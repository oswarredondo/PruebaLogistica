/**
 * 
 */
package com.administracion.dto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class PerfilOpcionDTO implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idsistema; 
	private String idmodulo; 
	private String idperfil;
	private String descripcion_perefil;
	private String idopcion;
	private String nivel;
	private String descripcion_opcion;
	private String descripcion_modulo;
	private int identidad;
	private int idorganizacion;
	private String estatus;

	
	public HashMap<String,String> map_perfil = new HashMap<String,String>();
	public ArrayList<String> arr_modulos = new ArrayList<String>();
	public ArrayList<PerfilOpcionDTO> arr_perfiles = new ArrayList<PerfilOpcionDTO>();
	
	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		
	}
	
	/**
	 * 
	 */
	public PerfilOpcionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Verifica si un usuario tiene acceso a una opocion determinada
	 * 1.- Primero se verifica si el usuario tiene acceso general (*)
	 * 2.- Segundo se verifica si el usuario tiene acceso general al modulo o a la opcion 
	 * (modulo.*) o si tiene acceso a la opcion = idopcion
	 * 3.- En cualquier otro caso no tiene acceso el usuario
	 * @param idopcion
	 * @return
	 */
	public boolean isAccesible(String idopcion){
		//debug("opcion:" + idopcion);
		boolean accesible = false;
		//Toma solo la raiz del id de la opcion que es el que indica 
		//el modulo al que se esta accesando
		String arr_opciones = idopcion.substring(0, 1);
		String str_general_module =arr_opciones; 
		//debug("str_general_module:" + idopcion);
		//Verifica si el usuario tiene acceso general cuando existe la llave = *
		if (map_perfil.containsKey("*") ){
			accesible= true;
		}
		
		//Verifica si el usuario tiened acceso a la opcion o general a la carpeta
		if (map_perfil.containsKey(str_general_module+".*") ||
			map_perfil.containsKey(idopcion)){
			accesible= true;
		}	
		//En cualquier otro caso el usuario no tiene acceso a la opcion seleccionada
		//debug("es accesible:" + accesible);
		return accesible;
	}
	
	/**
	 * Obtiene el titulo de la opcion
	 * @param idopcion
	 * @return
	 */
	public String getTituloOpcion(String idopcion){
		
		PerfilOpcionDTO obj=null;
		for (int i = 0; i < arr_perfiles.size(); i++) {
			obj = arr_perfiles.get(i);
			if (idopcion.equals(obj.getIdopcion())){
				return obj.getDescripcion_opcion();
			}
		}
		
		return null;
	}

	/**
	 * Agrega la opcion al map, ademas de agregar la opcion del modulo principal
	 * @param idopcion
	 */
	public void setIdOpcion(String idopcion){
		//Toma solo la raiz del id de la opcion que es el que indica 
		//el modulo al que se esta accesando
		String str_general_module = idopcion;
		if (!idopcion.equals("*")){
			str_general_module =idopcion.split("\\.")[0] + ".0";
			
		}
		//Agrega las dos opciones al MAP
		map_perfil.put(str_general_module, str_general_module);
		map_perfil.put(idopcion, idopcion);
		
	}
	
	public String getIdsistema() {
		return idsistema;
	}

	public void setIdsistema(String idsistema) {
		this.idsistema = idsistema;
	}

	public String getIdmodulo() {
		return idmodulo;
	}

	public void setIdmodulo(String idmodulo) {
		this.idmodulo = idmodulo;
	
		
		
	}

	public String getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(String idperfil) {
		this.idperfil = idperfil;
	}

	public String getIdopcion() {
		return idopcion;
	}

	public void setIdopcion(String idopcion) {
		this.idopcion = idopcion;
	}

	public String getDescripcion_perefil() {
		if (this.descripcion_perefil!=null){
			this.descripcion_perefil=this.descripcion_perefil.toUpperCase();	
		}
		return descripcion_perefil;
	}

	public void setDescripcion_perefil(String descripcion_perefil) {
		this.descripcion_perefil = descripcion_perefil;
	}

	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}
	
	/***
	 * Obtiene los niveles para 
	 * if ("A".equals(getNivel())){
	 * 		nivelJerarquias= "'A','E','O','C','U'"; //Todos los niveles
	 * }else if ("E".equals(getNivel())){
	 * 		nivelJerarquias= "'E','O','C','U'"; //Entidad crea solo a partir de organizacion
	 * }else if ("O".equals(getNivel())){
	 * 		nivelJerarquias= "'O','C','U'"; //Organizacion crea solo a partir de cuentas
	 * }else if ("C".equals(getNivel())){
	 * 		nivelJerarquias= "'C','U'"; //Cuenta crea solo a partir de usuarios
	 * }
	 * @return nivelJerarquias
	 */
	public String getNivelesJerarquiaPerfil() {
		String nivelJerarquias ="";
		if ("A".equals(getNivel())){
			nivelJerarquias= "'A','E','O','C','U'"; //Todos los niveles
		}else if ("E".equals(getNivel())){
			nivelJerarquias= "'E','O','C','U'"; //Entidad crea solo a partir de organizacion
		}else if ("O".equals(getNivel())){
			nivelJerarquias= "'O','C','U'"; //Organizacion crea solo a partir de cuentas
		}else if ("C".equals(getNivel())){
			nivelJerarquias= "'C','U'"; //Cuenta crea solo a partir de usuarios
		}
		return nivelJerarquias;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the descripcion_opcion
	 */
	public String getDescripcion_opcion() {
		return descripcion_opcion;
	}

	/**
	 * @param descripcion_opcion the descripcion_opcion to set
	 */
	public void setDescripcion_opcion(String descripcion_opcion) {
		this.descripcion_opcion = descripcion_opcion;
	}

	/**
	 * @return the descripcion_modulo
	 */
	public String getDescripcion_modulo() {
		return descripcion_modulo;
	}

	/**
	 * @param descripcion_modulo the descripcion_modulo to set
	 */
	public void setDescripcion_modulo(String descripcion_modulo) {
		this.descripcion_modulo = descripcion_modulo;
	}

	/**
	 * @return the identidad
	 */
	public int getIdentidad() {
		return identidad;
	}

	/**
	 * @param identidad the identidad to set
	 */
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}

	/**
	 * @return the idorganizacion
	 */
	public int getIdorganizacion() {
		return idorganizacion;
	}

	/**
	 * @param idorganizacion the idorganizacion to set
	 */
	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
