package com.administracion.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.administracion.dto.CotizacionLineaDireccion;
import com.administracion.dto.CotizacionLineaVolumen;
import com.administracion.dto.CotizacionTarifa;
import com.administracion.ibo.ICotizadorBO;
import com.administracion.idao.ICotizadorDAO;
import com.administracion.idao.IReglaTarifaPesoDAO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.TarifaDTO;


@Repository
public class CotizadorBO implements ICotizadorBO{
	
	private static final Logger logger = LoggerFactory
			.getLogger(CotizadorBO.class);

	@Autowired 
	ICotizadorDAO iCotizadorDAO;
	
	@Autowired
	IReglaTarifaPesoDAO iReglaTarifaPeso;

	   
	@Override
	public List<CotizacionTarifa> getCotizacionesTarifa(
		CotizacionTarifa tarifa) throws Exception {
	    // TODO Auto-generated method stub
	    return iCotizadorDAO.getCotizacionesTarifa(tarifa);
	}
	@Override
	public List<CotizacionTarifa> getTarifasPrepagado(
		CotizacionTarifa tarifa) throws DataAccessException {
	    return iCotizadorDAO.getTarifasPrepagado(tarifa);
	}
	@Override
	public List<CotizacionTarifa> getTarifasContado(CotizacionTarifa tarifa)
		throws DataAccessException {
	    return iCotizadorDAO.getTarifasContado(tarifa);
	}
	
	@Override
	public List<CotizacionTarifa> getTarifasFXC(CotizacionTarifa tarifa)
		throws DataAccessException {
	    return iCotizadorDAO.getTarifasFXC(tarifa);
	}
	
	@Override
	public List<CotizacionTarifa> getLineaCotizacionesTarifa(
		CotizacionLineaVolumen linea, CotizacionLineaDireccion cotiza)
		throws Exception {
	    
		TarifaDTO tarifa = new TarifaDTO();
		tarifa.setIdtarifa(cotiza.getIdtarifa());
		tarifa.setPesoamparado(linea.getPeso());
		tarifa.setIdrangoinicial(linea.getCantidad());
		tarifa.setIdrangofinal(linea.getCantidad());
		tarifa.setIdrangoenvios(linea.getIdrangotarifa());
		
		//Si e idrango y el idtarifa ya estan definidos trae ese ranglon de 
		//rangos si no busca de acuerdo a todos los rango
		List<TarifaDTO> lista_tarifa_rango= tarifa.getIdrangoenvios()>0?
				iReglaTarifaPeso.getRangosDisponiblesId(tarifa):
				iReglaTarifaPeso.getRegistrosRangosDisponibles(tarifa);
		
		 if (lista_tarifa_rango.size()<=0){
			 throw new Exception("No existen rangos de Envios Disponibles para la cantidad selecconada.");
		 }
		ConvenioContratoDetalleDTO convenioContratoDetalleDTO = new ConvenioContratoDetalleDTO();
		convenioContratoDetalleDTO.setAlto(linea.getAlto());
		convenioContratoDetalleDTO.setAncho(linea.getAncho());
		convenioContratoDetalleDTO.setLargo(linea.getLargo());
		convenioContratoDetalleDTO.setIdrangoenvios(lista_tarifa_rango.get(0).getIdrangoenvios());
		tarifa.setIdrangoenvios(convenioContratoDetalleDTO.getIdrangoenvios());
		
		List<TarifaDTO> lista_tarifa_peso =
				iReglaTarifaPeso.getRegistrosPesoDisponibles(tarifa, convenioContratoDetalleDTO);
		
		if (lista_tarifa_peso.size()<=0){
			logger.debug("No existe tabla de pesos para los datos seleccionados");
			return new ArrayList<CotizacionTarifa>();
		}
		TarifaDTO tarifa_peso =lista_tarifa_peso.get(0);
		tarifa_peso.setKminicial(cotiza.getTramo());
		tarifa_peso.setKmfinal(cotiza.getTramo());
		float peso_final = tarifa_peso.getPesofinal();
		
		List<TarifaDTO> lista_tarifa_vol = 
				iReglaTarifaPeso.getRegistrosVolumenDisponibles(tarifa, convenioContratoDetalleDTO);
	
		if (lista_tarifa_vol.size()<=0){
			logger.debug("No existe tabla de volumen para los datos seleccionados");
			return new ArrayList<CotizacionTarifa>();
		}
		TarifaDTO tarifa_volumen = lista_tarifa_vol.get(0);
		tarifa_volumen.setKminicial(cotiza.getTramo());
		tarifa_volumen.setKmfinal(cotiza.getTramo());
		
		float volumen_final = tarifa_volumen.getVolumen();
		
		//Calcula precios
		List<TarifaDTO> arr_tarifa_peso_precio = iReglaTarifaPeso.getListaPrecioPosibles(tarifa_peso);
		if (arr_tarifa_peso_precio.size()<=0){
			logger.debug("No existe tabla de precios para peso seleccionados");
			return new ArrayList<CotizacionTarifa>();
		}
		tarifa_peso = arr_tarifa_peso_precio.get(0);

		List<TarifaDTO> arr_tarifa_volumen_precio = iReglaTarifaPeso.getListaPrecioPosibles(tarifa_volumen);
		if (arr_tarifa_volumen_precio.size()<=0){
			logger.debug("Lista de precios para peso es inválida su valor es $0.0");
			return new ArrayList<CotizacionTarifa>();
		}

		tarifa_volumen =arr_tarifa_volumen_precio.get(0);
		if (tarifa_peso.getPrecio()<=0 && tarifa_volumen.getPrecio()<=0 ){
		    throw new Exception("Lista de precios para volumen es inválida su valor es $0.0"); 
		}
		
		CotizacionTarifa cotizacionTarifa = new CotizacionTarifa();
		cotizacionTarifa.setIdtarifa(cotiza.getIdtarifa());
		cotizacionTarifa.setIdrangoenvios(convenioContratoDetalleDTO.getIdrangoenvios());	
		
		if (tarifa_peso.getPrecio()> tarifa_volumen.getPrecio()){
		    logger.debug("Precio mayor el de PESO " + tarifa.getPrecio());
		    cotizacionTarifa.setIdserviciotarifazona(tarifa_peso.getIdserviciotarifazona());
		}else{
		    logger.debug("Precio mayor el de VOLUMEN " + tarifa_volumen.getPrecio());
		    cotizacionTarifa.setIdserviciotarifazona(tarifa_volumen.getIdserviciotarifazona());
		}
		
		cotizacionTarifa.setPesoamparado(peso_final);
		cotizacionTarifa.setVolumenamparado(volumen_final);

		cotizacionTarifa.setCantidadenvios(linea.getCantidad());
		cotizacionTarifa.setKilometros(cotiza.getTramo());
	    
	    //CHEACE POR VOLUMEN LOS DATOS
		List<CotizacionTarifa> lista = iCotizadorDAO.getLineaCotizacionesTarifa(cotizacionTarifa,
				linea);
		if (lista.size()>0){
			CotizacionTarifa obj = lista.get(0);
			
			obj.setPesoamparado(peso_final);
			obj.setVolumenamparado(volumen_final);
			
			List<CotizacionTarifa> lista_final = new ArrayList<CotizacionTarifa>();
			lista_final.add(obj);
			return lista_final;
		}else{
			return lista;
		}
		

	}
	
	@Override
	public CotizacionTarifa getTarifa(CotizacionTarifa tarifa)
		throws DataAccessException {
	    return iCotizadorDAO.getTarifa(tarifa);
	}
	@Override
	public List<CotizacionTarifa> getRangosKMTarifa(CotizacionTarifa tarifa) 
			throws SQLException {
		// TODO Auto-generated method stub
		 return iCotizadorDAO.getRangosKMTarifa(tarifa);
	}
	@Override
	public List<CotizacionTarifa> getRangosEnviosTarifa(CotizacionTarifa tarifa) throws SQLException {
		// TODO Auto-generated method stub
		return iCotizadorDAO.getRangosEnviosTarifa(tarifa);
	}
	@Override
	public List<CotizacionTarifa> getFiltraTarifas(CotizacionTarifa tarifa) throws Exception {
		// TODO Auto-generated method stub
		return iCotizadorDAO.getFiltraTarifas(tarifa);
	}
	@Override
	public List<CotizacionTarifa> getFiltraConveniosContado(CotizacionTarifa tarifa) throws Exception {
		// TODO Auto-generated method stub
		return iCotizadorDAO.getFiltraConveniosContado(tarifa);
	}
	@Override
	public List<RemDes> getClientesConvenios(BusquedaDTO busqueda) throws SQLException {
		// TODO Auto-generated method stub
		return iCotizadorDAO.getClientesConvenios(busqueda);
	}
	@Override
	public List<CotizacionTarifa> getRangosEnviosConvenio(CotizacionTarifa tarifa) throws SQLException {
		// TODO Auto-generated method stub
		return iCotizadorDAO.getRangosEnviosConvenio(tarifa);
	}



}
