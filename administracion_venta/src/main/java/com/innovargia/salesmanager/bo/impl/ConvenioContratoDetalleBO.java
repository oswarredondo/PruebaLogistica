/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.ibo.IConvenioContratoDetalleBO;
import com.innovargia.salesmanager.ibo.ITarifaPesoBO;
import com.innovargia.salesmanager.idao.IConvenioContratoDetalleDAO;
import com.innovargia.salesmanager.idao.ICotizacionPreConvenioDAO;
import com.innovargia.salesmanager.idao.ITarifaServicionZonaDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class ConvenioContratoDetalleBO implements IConvenioContratoDetalleBO {

	private static final Logger logger = LoggerFactory
			.getLogger(ConvenioContratoDetalleBO.class);

	@Autowired
	IConvenioContratoDetalleDAO iConvenioContratoDetalleDAO;

	@Autowired
	ITarifaPesoBO iTarifaPesoBO;

	@Autowired
	ITarifaServicionZonaDAO iTarifaServicionZonaDAO;
	
	@Autowired
	ICotizacionPreConvenioDAO iCotizacionPreConvenioDAO;

	public ConvenioContratoDetalleBO() {

	}

	@Override
	public void insert(ConvenioContratoDetalleDTO obj) throws Exception {
			//Calcula los datos de Precio y precio
			calculaDatos(obj); 
		
			//Inserta el registro
			iConvenioContratoDetalleDAO.insert(obj);

		
	}
	
	@Override
	public void insertLineaCotizacionAConvenio(ConvenioContratoDetalleDTO obj) throws Exception {
	
			//Inserta el registro
			iConvenioContratoDetalleDAO.insert(obj);

		
	}
	private void calculaDatos(ConvenioContratoDetalleDTO obj)  throws Exception{
		ConvenioContratoDTO convenio = new ConvenioContratoDTO();
		convenio.setIdconvenio(obj.getIdconvenio());
		convenio = iCotizacionPreConvenioDAO.get(convenio); 
		
		if (convenio==null){
			throw new Exception("No existen datos de Convenio");
		}
		/*float peso_vol = 0;
		try{
			peso_vol = ( obj.getAlto()*obj.getAncho()*obj.getLargo()/5000);
		}catch(Exception e){
			peso_vol=0;
		}*/
				
				
		float peso_final = obj.getPeso();//>peso_vol?obj.getPeso():peso_vol;
		
		//Calcula sobre peso
		TarifaDTO tarifa = new TarifaDTO();
		tarifa.setIdrangoenvios(convenio.getIdrangoenvios());
		tarifa.setPesoamparado(peso_final);
		
		 List<TarifaDTO> lista_sobrepeso = iTarifaPesoBO.getRegistrosPesoDisponibles(tarifa,obj ); 
		 obj.setIdtarifa(convenio.getIdtarifa());
		 obj.setIdrangoenvios(convenio.getIdrangoenvios());
		
			
		if (lista_sobrepeso.size()<=0){
			throw new Exception("No existe tabla de pesos definida para la tarifa."); 
		}else{
			tarifa = lista_sobrepeso.get(0);
		}
		
		//Obtiene la lista de pesos por volumen y toma la primera linea
		TarifaDTO tarifa_volumen = new TarifaDTO();
		tarifa_volumen.setIdrangoenvios(convenio.getIdrangoenvios());
		tarifa_volumen.setPesoamparado(peso_final);
		List<TarifaDTO> lista_volumen = iTarifaPesoBO.getRegistrosVolumenDisponibles(tarifa_volumen, obj);
		
		if (lista_volumen.size()<=0){
			throw new Exception("No existe tabla de volumen definida para la tarifa."); 
		}else{
		    tarifa_volumen = lista_volumen.get(0);
		}
		
		//Calcula Precio para la tarifa por peso
		float sobrepeso = peso_final>tarifa.getPesoinicial()?peso_final-tarifa.getPesoinicial():0;
		tarifa.setSobrepeso(sobrepeso);
		obj.setSobrepeso(tarifa.getSobrepeso());	
		obj.setIdtarifapeso(tarifa.getIdtarifapeso());

		tarifa.setIdserviciotarifazona(tarifa.getIdtarifapeso()); 
		tarifa.setKmfinal(obj.getCoberturakm());
		tarifa.setKminicial(obj.getCoberturakm());
		tarifa = iTarifaServicionZonaDAO.getPrecio(tarifa);
	
		//Calcula Precio para la tarifa por volumen
		tarifa_volumen.setIdserviciotarifazona(tarifa_volumen.getIdtarifapeso()); 
		tarifa_volumen.setKmfinal(obj.getCoberturakm());
		tarifa_volumen.setKminicial(obj.getCoberturakm());
		tarifa_volumen = iTarifaServicionZonaDAO.getPrecio(tarifa_volumen);
		
		//Checa que exista los datos
		if ((tarifa==null) && (tarifa_volumen==null)){
		    throw new Exception("No existe lista de precios para la cobertura y peso seleccionados.");
		}
		tarifa = tarifa==null? new TarifaDTO():tarifa;
		tarifa_volumen = tarifa_volumen==null? new TarifaDTO():tarifa_volumen;
		if (tarifa.getPrecio()<=0 && tarifa_volumen.getPrecio()<=0 ){
		    throw new Exception("Lista de precios es invalida su valor es $0.0"); 
		}
		
		if (tarifa.getPrecio()> tarifa_volumen.getPrecio()){
		    logger.debug("Precio mayor el de PESO " + tarifa.getPrecio());
		    obj.setIdserviciotarifazona(tarifa.getIdserviciotarifazona());
			
		    obj.setPreciosobrepeso(tarifa.getPreciokgsp());
		    obj.setPrecio(tarifa.getPrecio());
		    obj.setPrecio_real(tarifa.getPrecio());
		}else{
		    logger.debug("Precio mayor el de VOLUMEN " + tarifa_volumen.getPrecio());
		    obj.setIdserviciotarifazona(tarifa_volumen.getIdserviciotarifazona());
		    obj.setPreciosobrepeso(tarifa_volumen.getPreciokgsp());
		    obj.setPrecio(tarifa_volumen.getPrecio());
		    obj.setPrecio_real(tarifa_volumen.getPrecio());
		}
		
	}

	@Override
	public void update(ConvenioContratoDetalleDTO obj) throws Exception {
		//Calcula los datos de Precio y precio
		calculaDatos(obj); 
		//Actualiza los datos
		iConvenioContratoDetalleDAO.update(obj);

	}
	@Override
	public void updatePrecio(ConvenioContratoDetalleDTO obj) throws Exception {
		//Actualiza los datos
		iConvenioContratoDetalleDAO.updatePrecio(obj);

	}
	@Override
	public void delete(ConvenioContratoDetalleDTO obj) throws Exception {
		iConvenioContratoDetalleDAO.delete(obj);

	}

	@Override
	public List<ConvenioContratoDetalleDTO> getRegistros(
			ConvenioContratoDetalleDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iConvenioContratoDetalleDAO.getRegistros(obj);
	}

	@Override
	public ConvenioContratoDetalleDTO get(ConvenioContratoDetalleDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return iConvenioContratoDetalleDAO.get(obj);
	}

	@Override
	public void updateEstatus(ConvenioContratoDetalleDTO obj) throws Exception {
		// TODO Auto-generated method stub
		iConvenioContratoDetalleDAO.updateEstatus(obj);
	}

}
