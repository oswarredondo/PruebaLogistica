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
import com.innovargia.salesmanager.dtos.CuentasDTO;

/**
 * @author aruaro
 *
 */
public class CuentasClientesDTOJSON {

	private List<CuentasDTO> data;
	private CuentasDTO registro;

	/**
	 * @return the data
	 */
	public List<CuentasDTO> getData() {
		if (this.data==null){
			data = new ArrayList<CuentasDTO>();
		}
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<CuentasDTO> data) {
		
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
	public CuentasClientesDTOJSON() {
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
			CuentasClientesDTOJSON objs = gson.fromJson(r, CuentasClientesDTOJSON.class);
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
	public CuentasDTO getRegistro() {
		return registro;
	}

	/**
	 * @param registro the registro to set
	 */
	public void setRegistro(CuentasDTO registro) {
		this.registro = registro;
	}
	

}
