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
import com.innovargia.salesmanager.dtos.SistemaDTO;

/**
 * @author aruaro
 *
 */
public class ParametroConfiguracionDTOJSON {
	private static final Logger logger = LoggerFactory
			.getLogger(ParametroConfiguracionDTOJSON.class);

	private List<SistemaDTO> proxiArray;
	private SistemaDTO registro;

	/**
	 * @return the data
	 */
	public List<SistemaDTO> getData() {
		if (this.proxiArray==null){
			proxiArray = new ArrayList<SistemaDTO>();
		}
		return proxiArray;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<SistemaDTO> data) {
		
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
	public ParametroConfiguracionDTOJSON() {
		// TODO Auto-generated constructor stub
	}
	
	/***
	 * obtiene el JSON que contiene en el InputStream y lo 
	 * deserealiza en un objero de CodigoPostalDTOJSON para poder
	 * actualizar los datos dle objeto
	 * @param is
	 */
	public void runJSONParser(InputStream is) {
		try {
			if (is==null) return;
			
			Gson gson = new Gson();
			Reader r = new InputStreamReader(is);
			ParametroConfiguracionDTOJSON objs = gson.fromJson(r, ParametroConfiguracionDTOJSON.class);
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
	public SistemaDTO getRegistro() {
		return registro;
	}

	/**
	 * @param registro the registro to set
	 */
	public void setRegistro(SistemaDTO registro) {
		this.registro = registro;
	}
	

}
