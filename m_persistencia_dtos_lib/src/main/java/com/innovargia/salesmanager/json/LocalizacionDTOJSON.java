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

import com.google.gson.Gson;
import com.innovargia.salesmanager.dtos.LocalizacionDTO;

/**
 * @author aruaro
 *
 */
public class LocalizacionDTOJSON {

	private List<LocalizacionDTO> data;
	private LocalizacionDTO registro;

	/**
	 * @return the data
	 */
	public List<LocalizacionDTO> getData() {
		if (this.data==null){
			data = new ArrayList<LocalizacionDTO>();
		}
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<LocalizacionDTO> data) {
		
		this.data = data;
	}
	
	public void clearData() {
		if (this.data!=null){
			this.data.clear();
		}
		
	}

	/**
	 * 
	 */
	public LocalizacionDTOJSON() {
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
			LocalizacionDTOJSON objs = gson.fromJson(r, LocalizacionDTOJSON.class);
			this.data= objs.getData();
			this.registro= objs.getRegistro();
			if ((this.data.size()==0) && (this.registro!=null)){
				this.data.add(this.registro);
			}
		} catch (Exception ex) {
			//ex.printStackTrace();
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
			//ex.printStackTrace();
		} finally {

			try {
				is.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}

		}

	}

	/**
	 * @return the registro
	 */
	public LocalizacionDTO getRegistro() {
		return registro;
	}

	/**
	 * @param registro the registro to set
	 */
	public void setRegistro(LocalizacionDTO registro) {
		this.registro = registro;
	}
	

}
