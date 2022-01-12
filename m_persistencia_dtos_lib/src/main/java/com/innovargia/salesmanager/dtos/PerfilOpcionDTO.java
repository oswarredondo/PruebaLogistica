/**
 * 
 */
package com.innovargia.salesmanager.dtos;


import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Adrian Morales Ruaro
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PerfilOpcionDTO implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idsistema; 
	private String idmodulo; 
	private String idperfil;
	private String descripcion_perfil;
	private String idopcion;
	private String nivel;
	private String descripcion_opcion;
	private String descripcion_modulo;
	private int identidad;
	private int idorganizacion;
	private String estatus;
	private String text;
	private String iconCls;
	private String windowId;
	private int quickstart=0;
	private int shortcut=0;
	
	private int consecutivo;
	private String tooltip;
	private String menupadre;


	
	public HashMap<String,String> map_perfil = new HashMap<String,String>();
	public ArrayList<String> arr_modulos = new ArrayList<String>();
	public ArrayList<PerfilOpcionDTO> arr_perfiles = new ArrayList<PerfilOpcionDTO>();
	
	
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

	public String getDescripcion_perfil() {
		if (this.descripcion_perfil!=null){
			this.descripcion_perfil=this.descripcion_perfil.toUpperCase();	
		}
		return descripcion_perfil;
	}

	public void setDescripcion_perfil(String descripcion_perefil) {
		this.descripcion_perfil = descripcion_perefil;
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
	 * @param identidad the idorganizacion to set
	 */
	public void setIdentidad(String identidad) {
		try{
			this.identidad = Integer.parseInt(identidad);
		}catch(Exception e){
			this.identidad =-1;
		}
		
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
	 * @param idorganizacion the idorganizacion to set
	 */
	public void setIdorganizacion(String idorganizacion) {
		try{
			this.idorganizacion = Integer.parseInt(idorganizacion);
		}catch(Exception e){
			this.idorganizacion =-1;
		}
		
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getWindowId() {
		return windowId;
	}

	public void setWindowId(String windowId) {
		this.windowId = windowId;
	}

	public int getQuickstart() {
		return quickstart;
	}

	public void setQuickstart(int quickstart) {
		this.quickstart = quickstart;
	}

	public int getShortcut() {
		return shortcut;
	}

	public void setShortcut(int shortcut) {
		this.shortcut = shortcut;
	}

	/**
	 * @return the consecutivo
	 */
	public int getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	
	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(String consecutivo) {
		try{
			this.consecutivo = Integer.parseInt(consecutivo);
		}catch(Exception e){
			this.consecutivo = -1;
		}
		
	}

	/**
	 * @return the tooltip
	 */
	public String getTooltip() {
	    return tooltip;
	}

	/**
	 * @param tooltip the tooltip to set
	 */
	public void setTooltip(String tooltip) {
	    this.tooltip = tooltip;
	}

	/**
	 * @return the menupadre
	 */
	public String getMenupadre() {
	    return menupadre;
	}

	/**
	 * @param menupadre the menupadre to set
	 */
	public void setMenupadre(String menupadre) {
	    this.menupadre = menupadre;
	}

}
