/**
 * 
 */
package com.innovargia.salesmanager.json;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;

/**
 * @author aruaro
 *
 */
public class EtiquetaRotulacionDTOJSON {
	private static final Logger logger = LoggerFactory
			.getLogger(EtiquetaRotulacionDTOJSON.class);

	private List<EtiquetaRotulacionDTO> proxiArray;
	private EtiquetaRotulacionDTO registro;

	/**
	 * @return the data
	 */
	public List<EtiquetaRotulacionDTO> getData() {
		if (this.proxiArray==null){
			proxiArray = new ArrayList<EtiquetaRotulacionDTO>();
		}
		return proxiArray;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<EtiquetaRotulacionDTO> data) {
		
		this.proxiArray = data;
	}
	
	public void clearData() {
		if (this.proxiArray!=null){
			this.proxiArray.clear();
		}
		
	}

	/**
	 * 
	 */
	public EtiquetaRotulacionDTOJSON() {
		// TODO Auto-generated constructor stub
	}
	
	/***
	 * obtiene el JSON que contiene en el InputStream y lo 
	 * deserealiza en un objero  para poder
	 * actualizar los datos dle objeto
	 * @param is
	 */
	public void runJSONParser(InputStream is) {
		try {
			if (is==null) return;
			
			Gson gson = new Gson();
			Reader r = new InputStreamReader(is);
			EtiquetaRotulacionDTOJSON objs = gson.fromJson(r, EtiquetaRotulacionDTOJSON.class);
			this.proxiArray= objs.getData();
			this.registro= objs.getRegistro();
			if ((this.proxiArray.size()==0) && (this.registro!=null)){
				this.proxiArray.add(this.registro);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
	
	public void runJSONParser(String  str) {
		InputStream is=null;
		try {
		
			if (str == null)
				return;
			is = new ByteArrayInputStream(str.getBytes());
			runJSONParser( is);
			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		} finally {

			try {
				is.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}

		}

	}

	/**
	 * @return the registro
	 */
	public EtiquetaRotulacionDTO getRegistro() { 
		return registro;
	}

	/**
	 * @param registro the registro to set
	 */
	public void setRegistro(EtiquetaRotulacionDTO registro) {
		this.registro = registro;
	}
	

	public EtiquetaRotulacionDTO deserializaJSONtoObject(String json_string){
		 Gson gson = new Gson();
		 EtiquetaRotulacionDTO objeto = gson.fromJson(json_string, EtiquetaRotulacionDTO.class);
	    return objeto;
	}
	
}
