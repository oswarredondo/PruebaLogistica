/**
 * 
 */
package com.administracion.dto;

import java.util.ArrayList;

import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class Cuentas extends RemDes{

	//private int idorganizacion;
	//private int identidad;
	//Bandera que indica si la cuenta puede ver todas las direcciones 
	//de la organiuzacion y entidad o solo las propias
	private String vertodasdirecciones;
	private String tipoCuentaCliente;
	
	public ArrayList<UsuarioDTO> arr_usuario= new ArrayList<UsuarioDTO>(); 
	/**
	 * 
	 */
	public Cuentas() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the vertodasdirecciones
	 */
	public String getVertodasdirecciones() {
		return vertodasdirecciones;
	}
	/**
	 * @param vertodasdirecciones the vertodasdirecciones to set
	 */
	public void setVertodasdirecciones(String vertodasdirecciones) {
		this.vertodasdirecciones = vertodasdirecciones;
	}
	/**
	 * @return the tipoCuentaCliente
	 */
	public String getTipoCuentaCliente() {
		return tipoCuentaCliente;
	}
	/**
	 * @param tipoCuentaCliente the tipoCuentaCliente to set
	 */
	public void setTipoCuentaCliente(String tipoCuentaCliente) {
		this.tipoCuentaCliente = tipoCuentaCliente;
	}

}
