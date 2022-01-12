package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.ibo.ITarifaPesoBO;
import com.innovargia.salesmanager.ibo.ITarifaRangoEnviosBO;
import com.innovargia.salesmanager.ibo.ITarifaServicioZonaBO;
import com.innovargia.salesmanager.ibo.ITarifasBO;
import com.innovargia.salesmanager.idao.ITarifasDAO;

@Service
public class TarifasBO implements ITarifasBO {
	
	private static final Logger logger = LoggerFactory.getLogger(TarifasBO.class);
	@Autowired
	private ITarifasDAO tarifasDAO;
	
	@Autowired
	ITarifaRangoEnviosBO iTarifaRangoEnviosBO;
	
	@Autowired
	ITarifaPesoBO iTarifaPesoBO;
	
	@Autowired
	ITarifaServicioZonaBO iTarifaServicioZonaBO;
	
	public TarifasBO() {
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITarifasDAO#getTarifas()
	 */
	@Override
	public List<TarifaDTO> getTarifas(TarifaDTO tarifa) throws Exception {
		return null;
	}



	@Override
	@Transactional 
	public void insert(TarifaDTO tarifa) throws Exception {
		
		Number consecutivo = tarifasDAO.insert(tarifa);
		tarifa.setIdtarifa(consecutivo.intValue());

		
	}

	@Override
	public void update(TarifaDTO tarifa) throws Exception {
		tarifasDAO.update(tarifa);
		
	}

	@Override
	public void updateEstatus(TarifaDTO tarifa) throws Exception {
		tarifasDAO.updateEstatus(tarifa);
		
	}

	@Override
	@Transactional
	public void delete(TarifaDTO tarifa) throws Exception {
		//tarifasDAO.delete(tarifa);
	    deleteTarifa(tarifa);
		
	}

	@Override
	public  List<TarifaDTO> getRegistros(BusquedaDTO tarifa) throws Exception {
		return tarifasDAO.getRegistros(tarifa);
		
	}
	
	@Override
	public TarifaDTO get(TarifaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return tarifasDAO.get(obj);
	}

	/***
	 * Tarifa->Rango Guias->Rango Peso->Zona
	 */
	@Override
	@Transactional 
	public void clonarTarifa(TarifaDTO tarifa, String fechainicial,
		String fechafinal, int porcentaje_incremento_precio,
		int porcentaje_incremento_kgsobrepeso) throws Exception {
	    	// TODO Auto-generated method stub
	    
	    TarifaDTO tarifa_padre =  get(tarifa);
	    if (tarifa_padre.getEstatus()==0){
		throw new Exception("Tarifa seleccionada esta dada de baja o no existe, proceso de clonación inválido.");
	    }
	    
	    //Inserta la nueva tarifa con las nuevas fechas
	    tarifa_padre.setFechainicial(fechainicial);
	    tarifa_padre.setFechafinal(fechafinal);
	    tarifa_padre.setIdtarifa_padre(tarifa.getIdtarifa());
	    insert(tarifa_padre);
	    
	    //Obtiene los datos de Peso(catarifarangosenvios)
	    BusquedaDTO buscar_rangos_tarifa= new BusquedaDTO();
	    BusquedaDTO buscar_rango_peso_tarifa= new BusquedaDTO();
	    BusquedaDTO buscar_rango_peso_zona_tarifa= new BusquedaDTO();
	    
	  
	    List<TarifaDTO> lista_tarifa_rangos_guias_peso  = null;
	    List<TarifaDTO> lista_tarifa_rangos_guias_peso_zona  = null;
	    
	    float pocentaje_incremento_precio_f = 0;
	    if (porcentaje_incremento_precio>0){
		  pocentaje_incremento_precio_f = (porcentaje_incremento_precio/100);
	    }
	    float pocentaje_incremento_precio_sp_f = 0;
	    
	    if (pocentaje_incremento_precio_sp_f>0){
		pocentaje_incremento_precio_sp_f = (porcentaje_incremento_kgsobrepeso/100);
	    }
	    
	    float precio_kgsp = 0;
	    float precio_servicio = 0;
	    int idTarifaRangoGuiasPeso =0;
	    int idrangoenvios=0;
	    //Busca los rasngos de guias asociados al rango original
	    buscar_rangos_tarifa.setIdentificador(tarifa.getIdtarifa());
	    List<TarifaDTO> lista_tarifa_rangos_guias  =  iTarifaRangoEnviosBO.getRegistros(buscar_rangos_tarifa);
	    for (TarifaDTO rangoTarifaDTO : lista_tarifa_rangos_guias) {
		
		//Busca todos los rangos de peso asociados al rango de guias original
		buscar_rango_peso_tarifa.setIdentificador(rangoTarifaDTO.getIdrangoenvios());
		lista_tarifa_rangos_guias_peso = iTarifaPesoBO.getRegistros(buscar_rango_peso_tarifa);
		
		//Inserta el nuevo de rango de guias con el identificador nuevo de tarifa
		rangoTarifaDTO.setIdtarifa(tarifa_padre.getIdtarifa());
		idrangoenvios = iTarifaRangoEnviosBO.insert(rangoTarifaDTO);
		
		//Barre cada registro de peso para agregardo con el nuevo 
		//identificador de rango de guias
		for (TarifaDTO tarifaRangoGuiasPesoDTO : lista_tarifa_rangos_guias_peso) {
		    //Ajusta el nuevo Id de rangos
		    tarifaRangoGuiasPesoDTO.setIdrangoenvios(idrangoenvios);
		    
		    //Obtiene los registros de zonas del registro de peso original
		    buscar_rango_peso_zona_tarifa.setIdentificador(tarifaRangoGuiasPesoDTO.getIdtarifapeso());
		    lista_tarifa_rangos_guias_peso_zona =
			    iTarifaServicioZonaBO.getRegistros(buscar_rango_peso_zona_tarifa);
		    
		    //Agrega el nuevo de rango de peso
		    idTarifaRangoGuiasPeso = iTarifaPesoBO.insert(tarifaRangoGuiasPesoDTO);
		    tarifaRangoGuiasPesoDTO.setIdtarifapeso(idTarifaRangoGuiasPeso);
		    
		    //Barre todas las zonas asociadas a los rangos de peso y les 
		    //los da de alta con el nuevo identificador de peso
		    for (TarifaDTO tarifaRangoPesoZonaDTO : lista_tarifa_rangos_guias_peso_zona) {
			//Actualiza el nuevo identificador de peso para el registro de zona
			tarifaRangoPesoZonaDTO.setIdtarifapeso(idTarifaRangoGuiasPeso);
			tarifaRangoPesoZonaDTO.setIdserviciotarifa(idTarifaRangoGuiasPeso);
			//Calcula el nuevo precio de acuerdo al incremento
			    precio_servicio= 
				(pocentaje_incremento_precio_f*tarifaRangoPesoZonaDTO.getPrecio())+
				tarifaRangoPesoZonaDTO.getPrecio();
			    precio_kgsp= 
				(pocentaje_incremento_precio_sp_f*tarifaRangoPesoZonaDTO.getPreciokgsp())+
				tarifaRangoPesoZonaDTO.getPreciokgsp();
			
			tarifaRangoPesoZonaDTO.setPrecio(precio_servicio);
			tarifaRangoPesoZonaDTO.setPreciokgsp(precio_kgsp);
			
			//Se crea el nuevo registro de zona
			iTarifaServicioZonaBO.insert(tarifaRangoPesoZonaDTO);
		    }
		}
	    }
	}
	
	@Override
	@Transactional 
	public void deleteTarifa(TarifaDTO tarifa) throws Exception {
	    TarifaDTO tarifa_padre =  get(tarifa);
	    if (tarifa_padre.getEstatus()==0){
		throw new Exception("Tarifa seleccionada esta dada de baja o no existe, proceso de borrado inválido.");
	    }
	    //Obtiene los datos de Peso(catarifarangosenvios)
	    BusquedaDTO buscar_rangos_tarifa= new BusquedaDTO();
	    BusquedaDTO buscar_rango_peso_tarifa= new BusquedaDTO();
	    BusquedaDTO buscar_rango_peso_zona_tarifa= new BusquedaDTO();
	    
	    //Busca los rasngos de guias asociados al rango original
	    buscar_rangos_tarifa.setIdentificador(tarifa.getIdtarifa());
	 
	    
	    List<TarifaDTO> lista_tarifa_rangos_guias_peso  = null;
	    List<TarifaDTO> lista_tarifa_rangos_guias_peso_zona  = null;
	    
	    //Rangos de Guias
	    List<TarifaDTO> lista_tarifa_rangos_guias  =  iTarifaRangoEnviosBO.getRegistros(buscar_rangos_tarifa);
	    for (TarifaDTO rangoTarifaDTO : lista_tarifa_rangos_guias) {
		buscar_rango_peso_tarifa.setIdentificador(rangoTarifaDTO.getIdrangoenvios());
		 //Pesos
		lista_tarifa_rangos_guias_peso = iTarifaPesoBO.getRegistros(buscar_rango_peso_tarifa);
		
		for (TarifaDTO tarifaRangoGuiasPesoDTO : lista_tarifa_rangos_guias_peso) {
		    //Zonas
		    buscar_rango_peso_zona_tarifa.setIdentificador(tarifaRangoGuiasPesoDTO.getIdtarifapeso());
		    lista_tarifa_rangos_guias_peso_zona =
			    iTarifaServicioZonaBO.getRegistros(buscar_rango_peso_zona_tarifa);
		    
		    for (TarifaDTO tarifaRangoPesoZonaDTO : lista_tarifa_rangos_guias_peso_zona) {
			//Borra zona
			iTarifaServicioZonaBO.delete(tarifaRangoPesoZonaDTO);
		    }
		    //Borra Peso
		    iTarifaPesoBO.delete(tarifaRangoGuiasPesoDTO);
		}
		//Borra rango guias
		iTarifaRangoEnviosBO.delete(rangoTarifaDTO);
	    }
	    //Borra la Tarifa
	    tarifasDAO.delete(tarifa);
	}
	
}
