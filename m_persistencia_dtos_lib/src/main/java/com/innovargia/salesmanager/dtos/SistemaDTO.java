/**
 * 
 */
package com.innovargia.salesmanager.dtos;

import java.util.ArrayList;

/**
 * @author aruaro
 *
 */
public class SistemaDTO {
	
	private String idpropertie;
	/**Contiene el identificador del sistema*/
	private String idSistema;
	/**Contiene la descripcion del sistema*/
	private String descripcion;
	/**Contiene el URL donde esta alojado el sistema*/	
	private String url;
	/**Contiene la version del sistema que se esta trabajando para un susuario*/
	private String version;
	
	/**Contiene el nombre del logo para reportes*/
	private String logoReportes;
	/**Contiene el nombre del logo  para manifiestos*/
	private String logoManifiestos;
	
	/**Contiene el nombre del logo  para generals*/
	private String logoGeneral;	
	
	
	/**Contiene el path del logo para reportes*/
	private String pathImagenReportes;
	/**Contiene el path del logo  para manifiestos*/
	private String pathImagenManifiestos;
	/**Contiene el path del logo  para generals*/
	private String pathImagenGeneral;	
	
	/**Path documentos */
	private String pathDocsPDFs;	
	
	
	/**Contiene el path del logo  para pie*/
	private String pie;	
	/**Contiene la descripcion del sistema a desplegar*/
	private String tituloADesplegar;
	/**Contiene el nombre del cliente a desplegar*/
	private String nombreEmpresa;
	
	/**Identifica el numero de cliente al cual esta atada la configuracion*/
	private String numCliente;
	
	/**Contiene el estado */
	private String estado;
	
	/**Contiene el estado */
	private String valor;
	
	/**Contiene todas las instancias de los modulos/opciones que estan dados de alta en un sistema*/
	public ArrayList arr_modulos= new ArrayList();
	
	/**
	 *  Devuelve el modulo de acuerdo al identificador indicado 
	 *  si no se encuetra en el arreglo de modulos devuelve un objeto 
	 *  en  null
	 *  
	 *  @param id identificador del modulo a buscar
	 *  @return instancia de un objeto tipo ModuloSistema
	 *  @see ModuloSistemaDTO
	 **/
	public ModuloSistemaDTO getModulo(String id){
		
		if (id == null) return null;
		ModuloSistemaDTO modulo = new ModuloSistemaDTO();
		for (int i=0;i<arr_modulos.size();i++){
			modulo = (ModuloSistemaDTO) arr_modulos.get(i);
			
			if (id.equals(modulo.getIdModulo())){
				return modulo;
			}
		}
		
		return null;
	}//fin getModulo

	public String getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(String idSistema) {
		this.idSistema = idSistema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ArrayList getArr_modulos() {
		return arr_modulos;
	}

	public void setArr_modulos(ArrayList arr_modulos) {
		this.arr_modulos = arr_modulos;
	}

	public String getLogoReportes() {
		if (logoReportes==null) return logoGeneral;
		return logoReportes;
	}

	public void setLogoReportes(String logoReportes) {
		this.logoReportes = logoReportes;
	}

	public String getLogoManifiestos() {
		if (logoManifiestos==null) return logoGeneral;
		return logoManifiestos;
	}

	public void setLogoManifiestos(String logoManifiestos) {
		this.logoManifiestos = logoManifiestos;
	}

	public String getLogoGeneral() {
		return logoGeneral;
	}

	public void setLogoGeneral(String logoGeneral) {
		this.logoGeneral = logoGeneral;
	}

	public String getPie() {
		return pie;
	}

	public void setPie(String pie) {
		this.pie = pie;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTituloADesplegar() {
		return tituloADesplegar;
	}

	public void setTituloADesplegar(String tituloADesplegar) {
		this.tituloADesplegar = tituloADesplegar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPathImagenReportes() {
		return pathImagenReportes;
	}

	public void setPathImagenReportes(String pathImagenReportes) {
		this.pathImagenReportes = pathImagenReportes;
	}

	public String getPathImagenManifiestos() {
		return pathImagenManifiestos;
	}

	public void setPathImagenManifiestos(String pathImagenManifiestos) {
		this.pathImagenManifiestos = pathImagenManifiestos;
	}

	public String getPathImagenGeneral() {
		return pathImagenGeneral;
	}

	public void setPathImagenGeneral(String pathImagenGeneral) {
		this.pathImagenGeneral = pathImagenGeneral;
	}

	public String getPathDocsPDFs() {
		return pathDocsPDFs;
	}

	public void setPathDocsPDFs(String pathDocsPDFs) {
		this.pathDocsPDFs = pathDocsPDFs;
	}

	public String getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the idpropertie
	 */
	public String getIdpropertie() {
		return idpropertie;
	}

	/**
	 * @param idpropertie the idpropertie to set
	 */
	public void setIdpropertie(String idpropertie) {
		this.idpropertie = idpropertie;
	}

}
