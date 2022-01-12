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
import com.innovargia.salesmanager.dtos.DescuentoDTO;

/**
 * @author aruaro
 *
 */
public class DescuentoDTOJSON {

	private List<DescuentoDTO> proxiArray;
	private DescuentoDTO registro;

	/**
	 * @return the proxiArray
	 */
	public List<DescuentoDTO> getData() {
		if (this.proxiArray==null){
			proxiArray = new ArrayList<DescuentoDTO>();
		}
		return proxiArray;
	}

	/**
	 * @param proxiArray the proxiArray to set
	 */
	public void setData(List<DescuentoDTO> proxiArray) {
		
		this.proxiArray = proxiArray;
	}
	
	public void clearData() {
		if (this.proxiArray!=null){
			this.proxiArray.clear();
		}
		
	}

	/**
	 * 
	 */
	public DescuentoDTOJSON() {
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
			DescuentoDTOJSON objs = gson.fromJson(r, DescuentoDTOJSON.class);
			this.proxiArray= objs.getData();
			this.registro= objs.getRegistro();
			if ((this.proxiArray.size()==0) && (this.registro!=null)){
				this.proxiArray.add(this.registro);
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
	public DescuentoDTO getRegistro() {
		return registro;
	}

	/**
	 * @param registro the registro to set
	 */
	public void setRegistro(DescuentoDTO registro) {
		this.registro = registro;
	}
	

}
