/**
 * 
 */
package com.innovargia.salesmanager.dtos;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;



import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Adrian Morales Ruaro
 *
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT) 
public class CuentasConexionMensajeriaDTO implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String quienSolicita; //Indica el sistema que solicita AUTODOC, PDV, CONEXIONMENSAJERIAS
	String numcliente ;
	String login ;
	String password ;
	String suscriberid ;
	String numclientearrier ;
	String manejoporfoliosconvenio;
	int  idregistro ;
	int  idconvenio ;
	String idservicio ;
	int peso_ampara_folio ;
	int identidad_default_folio ;
	int organizacion_default_folio ;
	String idserviciocarrier ;
	String loginconsultacarrier ;
	String passwordconsultacarrier ;
	String numclienteconsultacarrier ;
	String suscriberidconsultacarrier ;
	String endpoint_creacion ;
	String endpoint_consulta ;
	String oficina_organizacion ;
	String mensajeria ;
	String templateGuia ;
	int accion=1; //1:CREACION 2:VALIADACION
	String propiedades; //Campo de la base de datos
	
	//Datos para librerias cuando se deben devolver los datos
	int codigo=0; //codigo de error
	String descripcion;//Descripcion del posible error
	String guis_Generadas;//el separador entre guias debe ser _
	byte[] labelPDF;
	String nombre_archivo;
	String base64_archivo;
	
	
	private HashMap< String , String> _properties = new HashMap<String, String>();
	
	//Ajusta los valores de las propiedades de conexion
	/**
	 * Deben estar separadas por primeo por entrer y despues llave=valor 
	 * ejemplo:
	 * numcliente=111111\n
	 * login=22222
	 * @param properties
	 */
	public void setProperties(String properties){
		if (properties==null || properties.isEmpty()){
			return;
		}
		String[] arr_properties = properties.trim().split("\\n"); 
		String[] arr_valor_llave;
		for (String linea : arr_properties) {
			linea = linea==null?"":linea;
			 if(!linea.isEmpty()){
				 arr_valor_llave = linea.split(":=");
				 if (arr_valor_llave.length>1){
					 //Por ultimo verifica que no sea un comentario
					 if (!arr_valor_llave[0].startsWith("#")){
						 //indica llave y valor
						 _properties.put(arr_valor_llave[0], arr_valor_llave[1]==null?"":arr_valor_llave[1].trim()); 
					 }
					
				 }
			 }
			
		}
	}
	public String getPropertiesString(String llave){
		return _properties.get(llave);
	}
	public int getPropertiesInteger(String llave){
		String valor =  _properties.get(llave);
		try{
			return Integer.parseInt(valor);
		}catch(Exception e){
			return -1;
		}
		
	}
	public boolean getPropertiesBoolean(String llave){
		String valor =  _properties.get(llave);
		try{
			return Boolean.parseBoolean(valor);
		}catch(Exception e){
			return false;
		}
		
	}
	
	
	public String getNumcliente() {
		return numcliente;
	}
	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSuscriberid() {
		return suscriberid;
	}
	public void setSuscriberid(String suscriberid) {
		this.suscriberid = suscriberid;
	}
	public String getNumclientearrier() {
		return numclientearrier;
	}
	public void setNumclientearrier(String numclientearrier) {
		this.numclientearrier = numclientearrier;
	}
	public String getManejoporfoliosconvenio() {
		return manejoporfoliosconvenio;
	}
	public void setManejoporfoliosconvenio(String manejoporfoliosconvenio) {
		this.manejoporfoliosconvenio = manejoporfoliosconvenio;
	}
	public int getIdconvenio() {
		return idconvenio;
	}
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}
	public String getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
	}
	public int getPeso_ampara_folio() {
		return peso_ampara_folio;
	}
	public void setPeso_ampara_folio(int peso_ampara_folio) {
		this.peso_ampara_folio = peso_ampara_folio;
	}
	public int getIdentidad_default_folio() {
		return identidad_default_folio;
	}
	public void setIdentidad_default_folio(int identidad_default_folio) {
		this.identidad_default_folio = identidad_default_folio;
	}
	public int getOrganizacion_default_folio() {
		return organizacion_default_folio;
	}
	public void setOrganizacion_default_folio(int organizacion_default_folio) {
		this.organizacion_default_folio = organizacion_default_folio;
	}
	public String getIdserviciocarrier() {
		return idserviciocarrier;
	}
	public void setIdserviciocarrier(String idserviciocarrier) {
		this.idserviciocarrier = idserviciocarrier;
	}
	public String getLoginconsultacarrier() {
		return loginconsultacarrier;
	}
	public void setLoginconsultacarrier(String loginconsultacarrier) {
		this.loginconsultacarrier = loginconsultacarrier;
	}
	public String getPasswordconsultacarrier() {
		return passwordconsultacarrier;
	}
	public void setPasswordconsultacarrier(String passwordconsultacarrier) {
		this.passwordconsultacarrier = passwordconsultacarrier;
	}
	public String getNumclienteconsultacarrier() {
		return numclienteconsultacarrier;
	}
	public void setNumclienteconsultacarrier(String numclienteconsultacarrier) {
		this.numclienteconsultacarrier = numclienteconsultacarrier;
	}
	public String getSuscriberidconsultacarrier() {
		return suscriberidconsultacarrier;
	}
	public void setSuscriberidconsultacarrier(String suscriberidconsultacarrier) {
		this.suscriberidconsultacarrier = suscriberidconsultacarrier;
	}
	public String getEndpoint_creacion() {
		return endpoint_creacion;
	}
	public void setEndpoint_creacion(String endpoint_creacion) {
		this.endpoint_creacion = endpoint_creacion;
	}
	public String getEndpoint_consulta() {
		return endpoint_consulta;
	}
	public void setEndpoint_consulta(String endpoint_consulta) {
		this.endpoint_consulta = endpoint_consulta;
	}
	public String getOficina_organizacion() {
		return oficina_organizacion;
	}
	public void setOficina_organizacion(String oficina_organizacion) {
		this.oficina_organizacion = oficina_organizacion;
	}
	public String getMensajeria() {
		return mensajeria;
	}
	public void setMensajeria(String mensajeria) {
		this.mensajeria = mensajeria;
	}
	/**
	 * @return the templateGuia
	 */
	public String getTemplateGuia() {
		return templateGuia;
	}
	/**
	 * @param templateGuia the templateGuia to set
	 */
	public void setTemplateGuia(String templateGuia) {
		this.templateGuia = templateGuia;
	}
	/**
	 * @return the accion
	 */
	public int getAccion() {
		return accion;
	}
	/**
	 * @param accion the accion to set
	 */
	public void setAccion(int accion) {
		this.accion = accion;
	}
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the guis_Generadas
	 */
	public String getGuis_Generadas() {
		return guis_Generadas;
	}
	/**
	 * @param guis_Generadas the guis_Generadas to set
	 */
	public void setGuis_Generadas(String guis_Generadas) {
		this.guis_Generadas = guis_Generadas;
	}
	/**
	 * @return the labelPDF
	 */
	public byte[] getLabelPDF() {
		return labelPDF;
	}
	/**
	 * @param labelPDF the labelPDF to set
	 */
	public void setLabelPDF(byte[] labelPDF) {
		this.labelPDF = labelPDF;
	}
	/**
	 * @return the nombre_archivo
	 */
	public String getNombre_archivo() {
		return nombre_archivo;
	}
	/**
	 * @param nombre_archivo the nombre_archivo to set
	 */
	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}
	/**
	 * @return the base64_archivo
	 */
	public String getBase64_archivo() {
		return base64_archivo;
	}
	/**
	 * @param base64_archivo the base64_archivo to set
	 */
	public void setBase64_archivo(String base64_archivo) {
		this.base64_archivo = base64_archivo;
	}
	/**
	 * @return the propiedades
	 */
	public String getPropiedades() {
		return propiedades;
	}
	/**
	 * @param propiedades the propiedades to set
	 */
	public void setPropiedades(String propiedades) {
		this.propiedades = propiedades;
	}
	/**
	 * @return the idregistro
	 */
	public int getIdregistro() {
		return idregistro;
	}
	/**
	 * @param idregistro the idregistro to set
	 */
	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}
	/**
	 * @return the quienSolicita
	 */
	public String getQuienSolicita() {
		return quienSolicita;
	}
	/**
	 * @param quienSolicita the quienSolicita to set
	 */
	public void setQuienSolicita(String quienSolicita) {
		this.quienSolicita = quienSolicita;
	}
}
