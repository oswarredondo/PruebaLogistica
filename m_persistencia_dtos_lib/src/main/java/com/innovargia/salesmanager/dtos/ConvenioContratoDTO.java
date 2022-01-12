/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class ConvenioContratoDTO {
	
	int idconvenio        ;
	int idcotizacionorigen; //Indica el tipo de cotizacion que origina el convenio
	int idtarifa	;
	int idoficinacontrol  ;
	int idtipoconvenio    ;
	int idformapago       ;
	int idmetodopago      ;
	int idcliente         ;
	int idpoblacionpago   ;
	int idcondicionpago   ;
	int idtarifarango     ;
	int idrangoenvios;
	int idunidadadm       ;
	int idagrupamiento       ;
	int credito       ;  //Dias de credito
	String fechainicio     ;      
	String fechaactivacion  ;    
	String fechatermino   ;       
	int iddescuento      ;   
	int estatus      ;  //0= Inactiva, 1 = Activa 2=Transformada a Convevio 3=Cerrada
	int tipo_precios  ;//1=Todo, 2=Detalle
	String  tipo_contrato;//Variable, Super Variable
    String clientelicitacion; 
	String nombre  ;
	String descripcion;
	String representantelegal;
	String idclientelicitacion;
	String observacion   ;  
	String descripcionOficinacontrol  ;
	String descripcionTipoconvenio    ;
	String descripcionFormapago       ;
	String descripcionMetodopago      ;
	String descripcionCliente         ;
	String descripcionPoblacionpago   ;
	String descripcionCondicionpago   ;
	String descripcionTarifarango     ;
	String descripcionUnidadadm       ;
	String descripcionDescuento;
	String descripcionTipoConvenio;
	
	String fechacreacionregis;
	String fechadocumento;
	String siglasplaza;
	String fecharevision;
	

	String numcliente       ;
	String razonsocial_cte;
	  
	String calle_cte       ;
	String contacto_cte      ;
	String numinterior_cte        ;
	String numexterior_cte        ;
	String cp_cte           ;
	String colonia_cte        ;
	String municipio_cte        ;
	String estado_cte         ;
	String telefono_cte         ;
	String movil_cte         ;
	String email_cte         ;
	
	String rfc	       ;
	String cuentabancaria       ;
	String nombrebanco	       ;
	String diasrevision        ; //LU, MA, MI, JU, VI
	String diaspago         ; //LU, MA, MI, JU, VI
	String calle_rev        ; 
	String numinterior_rev         ;
	String numexterior_rev        ;
	String cp_rev          ;
	String colonia_rev         ;
	String municipio_rev        ;
	String estado_rev           ;
	String responsable_rev	       ;
	String email_resp_rev       ;
	String telefono_rev ;
	String movil_rev;
	
	String responsable_pago	       ;
	String email_resp_pago	       ;
	String estadoactualdoc	       ; //Puede ser COTIZACION, CONVENIO, PRECONVENIO
	String login		       ;
	String rangoenvios;

	String clientefirma;
	String gerentecomercialfirma;
	String jefezonafirma;
	String coordinadorcreditocobfirma;
	String directoradmfinanzasfirma;
	String ejecutivoventasfirma;
	String tipocierre;
	String descripciontipocierre;
	
	/* PARA SEGUROS SE AGREGA */
	int asegura;
	String nombre_seguro;
	String porcentaje_seguro;
	
	/**
	 * 
	 */
	public ConvenioContratoDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getIdconvenio() {
		return idconvenio;
	}


	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}

	
	public void setIdconvenio(String idconvenio) {
		try{
			this.idconvenio = Integer.parseInt(idconvenio);
		}catch(Exception e){
			this.idconvenio=-1;
		}
		
	}


	public int getIdoficinacontrol() {
		return idoficinacontrol;
	}


	public void setIdoficinacontrol(int idoficinacontrol) {
		this.idoficinacontrol = idoficinacontrol;
	}

	public void setIdoficinacontrol(String idoficinacontrol) {
		try{
			this.idoficinacontrol = Integer.parseInt(idoficinacontrol);
		}catch(Exception e){
			
		}
		
	}
	
	public int getIdtipoconvenio() {
		return idtipoconvenio;
	}


	public void setIdtipoconvenio(int idtipoconvenio) {
		this.idtipoconvenio = idtipoconvenio;
	}


	public int getIdformapago() {
		return idformapago;
	}


	public void setIdformapago(int idformapago) {
		this.idformapago = idformapago;
	}

	public void setIdformapago(String idformapago) {
		try{
			this.idformapago = Integer.parseInt(idformapago);
		}catch(Exception e){
			
		}
		
	}

	public int getIdmetodopago() {
		return idmetodopago;
	}


	public void setIdmetodopago(int idmetodopago) {
		this.idmetodopago = idmetodopago;
	}

	public void setIdmetodopago(String idmetodopago) {
		try{
			this.idmetodopago = Integer.parseInt(idmetodopago);
		}catch(Exception e){
			
		}
		
	}
	
	public int getIdcliente() {
		return idcliente;
	}


	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public void setIdcliente(String idcliente) {
		try{
			this.idcliente = Integer.parseInt(idcliente);
		}catch(Exception e){
			this.idcliente = -1;
		}
		
	}


	public int getIdpoblacionpago() {
		return idpoblacionpago;
	}


	public void setIdpoblacionpago(int idpoblacionpago) {
		this.idpoblacionpago = idpoblacionpago;
	}

	public void setIdpoblacionpago(String idpoblacionpago) {
		try{
			this.idpoblacionpago = Integer.parseInt(idpoblacionpago);
		}catch(Exception e){
			
		}
		
	}

	
	public int getIdcondicionpago() {
		return idcondicionpago;
	}


	public void setIdcondicionpago(int idcondicionpago) {
		this.idcondicionpago = idcondicionpago;
	}

	public void setIdcondicionpago(String idcondicionpago) {
		try{
			this.idcondicionpago = Integer.parseInt(idcondicionpago);
		}catch(Exception e){
			
		}
		
	}

	
	public int getIdtarifarango() {
		return idtarifarango;
	}


	public void setIdtarifarango(int idtarifarango) {
		this.idtarifarango = idtarifarango;
	}


	public int getIdunidadadm() {
		return idunidadadm;
	}


	public void setIdunidadadm(int idunidadadm) {
		this.idunidadadm = idunidadadm;
	}

	public void setIdunidadadm(String idunidadadm) {
		try{
			this.idunidadadm = Integer.parseInt(idunidadadm);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @return the tipocierre
	 */
	public String getTipocierre() {
		return tipocierre;
	}


	/**
	 * @param tipocierre the tipocierre to set
	 */
	public void setTipocierre(String tipocierre) {
		this.tipocierre = tipocierre;
	}


	public String getFechainicio() {
		return fechainicio;
	}


	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}


	public String getFechaactivacion() {
		return fechaactivacion;
	}


	public void setFechaactivacion(String fechaactivacion) {
		this.fechaactivacion = fechaactivacion;
	}


	public String getFechatermino() {
		return fechatermino;
	}


	public void setFechatermino(String fechatermino) {
		this.fechatermino = fechatermino;
	}


	public int getIddescuento() {
		return iddescuento;
	}


	public void setIddescuento(int iddescuento) {
		this.iddescuento = iddescuento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getDescripcionOficinacontrol() {
		return descripcionOficinacontrol;
	}


	public void setDescripcionOficinacontrol(String descripcionOficinacontrol) {
		this.descripcionOficinacontrol = descripcionOficinacontrol;
	}


	public String getDescripcionTipoconvenio() {
		return descripcionTipoconvenio;
	}


	public void setDescripcionTipoconvenio(String descripcionTipoconvenio) {
		this.descripcionTipoconvenio = descripcionTipoconvenio;
	}


	public String getDescripcionFormapago() {
		return descripcionFormapago;
	}


	public void setDescripcionFormapago(String descripcionFormapago) {
		this.descripcionFormapago = descripcionFormapago;
	}


	public String getDescripcionMetodopago() {
		return descripcionMetodopago;
	}


	public void setDescripcionMetodopago(String descripcionMetodopago) {
		this.descripcionMetodopago = descripcionMetodopago;
	}


	public String getDescripcionCliente() {
		return descripcionCliente;
	}


	public void setDescripcionCliente(String descripcionCliente) {
		this.descripcionCliente = descripcionCliente;
	}


	

	public String getDescripcionCondicionpago() {
		return descripcionCondicionpago;
	}


	public void setDescripcionCondicionpago(String descripcionCondicionpago) {
		this.descripcionCondicionpago = descripcionCondicionpago;
	}


	public String getDescripcionTarifarango() {
		return descripcionTarifarango;
	}


	public void setDescripcionTarifarango(String descripcionTarifarango) {
		this.descripcionTarifarango = descripcionTarifarango;
	}


	public String getDescripcionUnidadadm() {
		return descripcionUnidadadm;
	}


	public void setDescripcionUnidadadm(String descripcionUnidadadm) {
		this.descripcionUnidadadm = descripcionUnidadadm;
	}


	public String getDescripcionPoblacionpago() {
		return descripcionPoblacionpago;
	}


	public void setDescripcionPoblacionpago(String descripcionPoblacionpago) {
		this.descripcionPoblacionpago = descripcionPoblacionpago;
	}


	public int getEstatus() {
		return estatus;
	}


	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getRepresentantelegal() {
		return representantelegal;
	}


	public void setRepresentantelegal(String representantelegal) {
		this.representantelegal = representantelegal;
	}


	public String getIdclientelicitacion() {
		return idclientelicitacion;
	}


	public void setIdclientelicitacion(String idclientelicitacion) {
		this.idclientelicitacion = idclientelicitacion;
	}


	public String getDescripcionDescuento() {
		return descripcionDescuento;
	}


	public void setDescripcionDescuento(String descripcionDescuento) {
		this.descripcionDescuento = descripcionDescuento;
	}


	public String getDescripcionTipoConvenio() {
		return descripcionTipoConvenio;
	}


	public void setDescripcionTipoConvenio(String descripcionTipoConvenio) {
		this.descripcionTipoConvenio = descripcionTipoConvenio;
	}


	/**
	 * @return the idtarifa
	 */
	public int getIdtarifa() {
		return idtarifa;
	}


	/**
	 * @param idtarifa the idtarifa to set
	 */
	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}


	/**
	 * @return the tipo_contrato
	 */
	public String getTipo_contrato() {
		return tipo_contrato;
	}


	/**
	 * @param tipo_contrato the tipo_contrato to set
	 */
	public void setTipo_contrato(String tipo_contrato) {
		this.tipo_contrato = tipo_contrato;
	}


	/**
	 * @return the fechacreacionregis
	 */
	public String getFechacreacionregis() {
		return fechacreacionregis;
	}


	/**
	 * @param fechacreacionregis the fechacreacionregis to set
	 */
	public void setFechacreacionregis(String fechacreacionregis) {
		this.fechacreacionregis = fechacreacionregis;
	}


	/**
	 * @return the fechadocumento
	 */
	public String getFechadocumento() {
		return fechadocumento;
	}


	/**
	 * @param fechadocumento the fechadocumento to set
	 */
	public void setFechadocumento(String fechadocumento) {
		this.fechadocumento = fechadocumento;
	}


	/**
	 * @return the numcliente
	 */
	public String getNumcliente() {
		return numcliente;
	}


	/**
	 * @param numcliente the numcliente to set
	 */
	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}


	/**
	 * @return the calle_cte
	 */
	public String getCalle_cte() {
		return calle_cte;
	}


	/**
	 * @param calle_cte the calle_cte to set
	 */
	public void setCalle_cte(String calle_cte) {
		this.calle_cte = calle_cte;
	}


	/**
	 * @return the numinterior_cte
	 */
	public String getNuminterior_cte() {
		return numinterior_cte;
	}


	/**
	 * @param numinterior_cte the numinterior_cte to set
	 */
	public void setNuminterior_cte(String numinterior_cte) {
		this.numinterior_cte = numinterior_cte;
	}


	/**
	 * @return the numexterior_cte
	 */
	public String getNumexterior_cte() {
		return numexterior_cte;
	}


	/**
	 * @param numexterior_cte the numexterior_cte to set
	 */
	public void setNumexterior_cte(String numexterior_cte) {
		this.numexterior_cte = numexterior_cte;
	}


	/**
	 * @return the cp_cte
	 */
	public String getCp_cte() {
		return cp_cte;
	}


	/**
	 * @param cp_cte the cp_cte to set
	 */
	public void setCp_cte(String cp_cte) {
		this.cp_cte = cp_cte;
	}


	/**
	 * @return the colonia_cte
	 */
	public String getColonia_cte() {
		return colonia_cte;
	}


	/**
	 * @param colonia_cte the colonia_cte to set
	 */
	public void setColonia_cte(String colonia_cte) {
		this.colonia_cte = colonia_cte;
	}


	/**
	 * @return the municipio_cte
	 */
	public String getMunicipio_cte() {
		return municipio_cte;
	}


	/**
	 * @param municipio_cte the municipio_cte to set
	 */
	public void setMunicipio_cte(String municipio_cte) {
		this.municipio_cte = municipio_cte;
	}


	/**
	 * @return the estado_cte
	 */
	public String getEstado_cte() {
		return estado_cte;
	}


	/**
	 * @param estado_cte the estado_cte to set
	 */
	public void setEstado_cte(String estado_cte) {
		this.estado_cte = estado_cte;
	}


	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}


	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	/**
	 * @return the cuentabancaria
	 */
	public String getCuentabancaria() {
		return cuentabancaria;
	}


	/**
	 * @param cuentabancaria the cuentabancaria to set
	 */
	public void setCuentabancaria(String cuentabancaria) {
		this.cuentabancaria = cuentabancaria;
	}


	/**
	 * @return the nombrebanco
	 */
	public String getNombrebanco() {
		return nombrebanco;
	}


	/**
	 * @param nombrebanco the nombrebanco to set
	 */
	public void setNombrebanco(String nombrebanco) {
		this.nombrebanco = nombrebanco;
	}


	/**
	 * @return the diasrevision
	 */
	public String getDiasrevision() {
		return diasrevision;
	}


	/**
	 * @param diasrevision the diasrevision to set
	 */
	public void setDiasrevision(String diasrevision) {
		this.diasrevision = diasrevision;
	}


	/**
	 * @return the diaspago
	 */
	public String getDiaspago() {
		return diaspago;
	}


	/**
	 * @param diaspago the diaspago to set
	 */
	public void setDiaspago(String diaspago) {
		this.diaspago = diaspago;
	}


	/**
	 * @return the calle_rev
	 */
	public String getCalle_rev() {
		return calle_rev;
	}


	/**
	 * @param calle_rev the calle_rev to set
	 */
	public void setCalle_rev(String calle_rev) {
		this.calle_rev = calle_rev;
	}


	/**
	 * @return the numinterior_rev
	 */
	public String getNuminterior_rev() {
		return numinterior_rev;
	}


	/**
	 * @param numinterior_rev the numinterior_rev to set
	 */
	public void setNuminterior_rev(String numinterior_rev) {
		this.numinterior_rev = numinterior_rev;
	}


	/**
	 * @return the numexterior_rev
	 */
	public String getNumexterior_rev() {
		return numexterior_rev;
	}


	/**
	 * @param numexterior_rev the numexterior_rev to set
	 */
	public void setNumexterior_rev(String numexterior_rev) {
		this.numexterior_rev = numexterior_rev;
	}


	/**
	 * @return the cp_rev
	 */
	public String getCp_rev() {
		return cp_rev;
	}


	/**
	 * @param cp_rev the cp_rev to set
	 */
	public void setCp_rev(String cp_rev) {
		this.cp_rev = cp_rev;
	}


	/**
	 * @return the colonia_rev
	 */
	public String getColonia_rev() {
		return colonia_rev;
	}


	/**
	 * @param colonia_rev the colonia_rev to set
	 */
	public void setColonia_rev(String colonia_rev) {
		this.colonia_rev = colonia_rev;
	}


	/**
	 * @return the municipio_rev
	 */
	public String getMunicipio_rev() {
		return municipio_rev;
	}


	/**
	 * @param municipio_rev the municipio_rev to set
	 */
	public void setMunicipio_rev(String municipio_rev) {
		this.municipio_rev = municipio_rev;
	}


	/**
	 * @return the estado_rev
	 */
	public String getEstado_rev() {
		return estado_rev;
	}


	/**
	 * @param estado_rev the estado_rev to set
	 */
	public void setEstado_rev(String estado_rev) {
		this.estado_rev = estado_rev;
	}


	/**
	 * @return the reponsable_rev
	 */
	public String getResponsable_rev() {
		return responsable_rev;
	}


	/**
	 * @param reponsable_rev the reponsable_rev to set
	 */
	public void setResponsable_rev(String responsable_rev) {
		this.responsable_rev = responsable_rev;
	}


	/**
	 * @return the email_resp_rev
	 */
	public String getEmail_resp_rev() {
		return email_resp_rev;
	}


	/**
	 * @param email_resp_rev the email_resp_rev to set
	 */
	public void setEmail_resp_rev(String email_resp_rev) {
		this.email_resp_rev = email_resp_rev;
	}


	/**
	 * @return the reponsable_pago
	 */
	public String getResponsable_pago() {
		return responsable_pago;
	}


	/**
	 * @param reponsable_pago the reponsable_pago to set
	 */
	public void setResponsable_pago(String responsable_pago) {
		this.responsable_pago = responsable_pago;
	}


	/**
	 * @return the email_resp_pago
	 */
	public String getEmail_resp_pago() {
		return email_resp_pago;
	}


	/**
	 * @param email_resp_pago the email_resp_pago to set
	 */
	public void setEmail_resp_pago(String email_resp_pago) {
		this.email_resp_pago = email_resp_pago;
	}


	/**
	 * @return the estadoactualdoc
	 */
	public String getEstadoactualdoc() {
		return estadoactualdoc;
	}


	/**
	 * @param estadoactualdoc the estadoactualdoc to set
	 */
	public void setEstadoactualdoc(String estadoactualdoc) {
		this.estadoactualdoc = estadoactualdoc;
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return the tipo_precios
	 */
	public int getTipo_precios() {
		return tipo_precios;
	}


	/**
	 * @param tipo_precios the tipo_precios to set
	 */
	public void setTipo_precios(int tipo_precios) {
		this.tipo_precios = tipo_precios;
	}
	
	/**
	 * @param tipo_precios the tipo_precios to set
	 */
	public void setTipo_precios(String tipo_precios) {
		int tipo =0;
		try{
			if (tipo_precios!=null){
				if (tipo_precios.trim().toLowerCase().equals("on") || 
					tipo_precios.trim().toLowerCase().equals("true")||
					tipo_precios.trim().toLowerCase().equals("si")||
					tipo_precios.trim().toLowerCase().equals("yes")||
					tipo_precios.trim().toLowerCase().equals("s")||
					tipo_precios.trim().toLowerCase().equals("y")){
					
					tipo=1;
				}
			}
		}catch(Exception e){
			
		}
		this.tipo_precios = tipo;
	}


	/**
	 * @return the contacto_cte
	 */
	public String getContacto_cte() {
		return contacto_cte;
	}


	/**
	 * @param contacto_cte the contacto_cte to set
	 */
	public void setContacto_cte(String contacto_cte) {
		this.contacto_cte = contacto_cte;
	}


	/**
	 * @return the razonsocial_cte
	 */
	public String getRazonsocial_cte() {
		return razonsocial_cte;
	}


	/**
	 * @param razonsocial_cte the razonsocial_cte to set
	 */
	public void setRazonsocial_cte(String razonsocial_cte) {
		this.razonsocial_cte = razonsocial_cte;
	}


	/**
	 * @return the rangoenvios
	 */
	public String getRangoenvios() {
		return rangoenvios;
	}


	/**
	 * @param rangoenvios the rangoenvios to set
	 */
	public void setRangoenvios(String rangoenvios) {
		this.rangoenvios = rangoenvios;
	}


	/**
	 * @return the idrangoenvios
	 */
	public int getIdrangoenvios() {
		return idrangoenvios;
	}


	/**
	 * @param idrangoenvios the idrangoenvios to set
	 */
	public void setIdrangoenvios(int idrangoenvios) {
		this.idrangoenvios = idrangoenvios;
	}
	
	/**
	 * @param idrangoenvios the idrangoenvios to set
	 */
	public void setIdrangoenvios(String idrangoenvios) {
		try{
			this.idrangoenvios = Integer.parseInt(idrangoenvios);
		}catch(Exception e){
			
		}
		
	}


	/**
	 * @return the idcotizacionorigen
	 */
	public int getIdcotizacionorigen() {
		return idcotizacionorigen;
	}


	/**
	 * @param idcotizacionorigen the idcotizacionorigen to set
	 */
	public void setIdcotizacionorigen(int idcotizacionorigen) {
		this.idcotizacionorigen = idcotizacionorigen;
	}
	
	/**
	 * @param idrangoenvios the idrangoenvios to set
	 */
	public void setIdcotizacionorigen(String idcotizacionorigen) {
		try{
			this.idcotizacionorigen = Integer.parseInt(idcotizacionorigen);
		}catch(Exception e){
			
		}
		
	}


	/**
	 * @return the credito
	 */
	public int getCredito() {
		return credito;
	}


	/**
	 * @param credito the credito to set
	 */
	public void setCredito(int credito) {
		this.credito = credito;
	}
	
	public void setCredito(String credito) {
		try{
			this.credito = Integer.parseInt(credito);
		}catch(Exception e){
			
		}
		
	}


	/**
	 * @return the telefono_cte
	 */
	public String getTelefono_cte() {
		return telefono_cte;
	}


	/**
	 * @param telefono_cte the telefono_cte to set
	 */
	public void setTelefono_cte(String telefono_cte) {
		this.telefono_cte = telefono_cte;
	}


	/**
	 * @return the movil_cte
	 */
	public String getMovil_cte() {
		return movil_cte;
	}


	/**
	 * @param movil_cte the movil_cte to set
	 */
	public void setMovil_cte(String movil_cte) {
		this.movil_cte = movil_cte;
	}


	/**
	 * @return the email_cte
	 */
	public String getEmail_cte() {
		return email_cte;
	}


	/**
	 * @param email_cte the email_cte to set
	 */
	public void setEmail_cte(String email_cte) {
		this.email_cte = email_cte;
	}


	/**
	 * @return the clientelicitacion
	 */
	public String getClientelicitacion() {
		return clientelicitacion;
	}


	/**
	 * @param clientelicitacion the clientelicitacion to set
	 */
	public void setClientelicitacion(String clientelicitacion) {
		this.clientelicitacion = clientelicitacion;
	}


	/**
	 * @return the fechapago
	 */
	public String getFecharevision() {
		return fecharevision;
	} 


	/**
	 * @param fechapago the fechapago to set
	 */
	public void setFecharevision(String fecharevision) {
		this.fecharevision = fecharevision;
	}


	/**
	 * @return the clientefirma
	 */
	public String getClientefirma() {
		return clientefirma;
	}


	/**
	 * @param clientefirma the clientefirma to set
	 */
	public void setClientefirma(String clientefirma) {
		this.clientefirma = clientefirma;
	}


	/**
	 * @return the gerentecomercialfirma
	 */
	public String getGerentecomercialfirma() {
		return gerentecomercialfirma;
	}


	/**
	 * @param gerentecomercialfirma the gerentecomercialfirma to set
	 */
	public void setGerentecomercialfirma(String gerentecomercialfirma) {
		this.gerentecomercialfirma = gerentecomercialfirma;
	}


	/**
	 * @return the jefezonafirma
	 */
	public String getJefezonafirma() {
		return jefezonafirma;
	}


	/**
	 * @param jefezonafirma the jefezonafirma to set
	 */
	public void setJefezonafirma(String jefezonafirma) {
		this.jefezonafirma = jefezonafirma;
	}


	/**
	 * @return the coordinadorcreditocobfirma
	 */
	public String getCoordinadorcreditocobfirma() {
		return coordinadorcreditocobfirma;
	}


	/**
	 * @param coordinadorcreditocobfirma the coordinadorcreditocobfirma to set
	 */
	public void setCoordinadorcreditocobfirma(String coordinadorcreditocobfirma) {
		this.coordinadorcreditocobfirma = coordinadorcreditocobfirma;
	}


	/**
	 * @return the directoradmfinanzasfirma
	 */
	public String getDirectoradmfinanzasfirma() {
		return directoradmfinanzasfirma;
	}


	/**
	 * @param directoradmfinanzasfirma the directoradmfinanzasfirma to set
	 */
	public void setDirectoradmfinanzasfirma(String directoradmfinanzasfirma) {
		this.directoradmfinanzasfirma = directoradmfinanzasfirma;
	}


	/**
	 * @return the idagrupamiento
	 */
	public int getIdagrupamiento() {
		return idagrupamiento;
	}


	/**
	 * @param idagrupamiento the idagrupamiento to set
	 */
	public void setIdagrupamiento(int idagrupamiento) {
		this.idagrupamiento = idagrupamiento;
	}


	/**
	 * @return the telefono_rev
	 */
	public String getTelefono_rev() {
		return telefono_rev;
	}


	/**
	 * @param telefono_rev the telefono_rev to set
	 */
	public void setTelefono_rev(String telefono_rev) {
		this.telefono_rev = telefono_rev;
	}


	/**
	 * @return the movil_rev
	 */
	public String getMovil_rev() {
		return movil_rev;
	}


	/**
	 * @param movil_rev the movil_rev to set
	 */
	public void setMovil_rev(String movil_rev) {
		this.movil_rev = movil_rev;
	}


	/**
	 * @return the descripciontipocierre
	 */
	public String getDescripciontipocierre() {
		return descripciontipocierre;
	}


	/**
	 * @param descripciontipocierre the descripciontipocierre to set
	 */
	public void setDescripciontipocierre(String descripciontipocierre) {
		this.descripciontipocierre = descripciontipocierre;
	}


	/**
	 * @return the ejecutivoventasfirma
	 */
	public String getEjecutivoventasfirma() {
		return ejecutivoventasfirma;
	}


	/**
	 * @param ejecutivoventasfirma the ejecutivoventasfirma to set
	 */
	public void setEjecutivoventasfirma(String ejecutivoventasfirma) {
		this.ejecutivoventasfirma = ejecutivoventasfirma;
	}


	/**
	 * @return the siglasplaza
	 */
	public String getSiglasplaza() {
	    return siglasplaza;
	}


	/**
	 * @param siglasplaza the siglasplaza to set
	 */
	public void setSiglasplaza(String siglasplaza) {
	    this.siglasplaza = siglasplaza;
	}
	
	/* GETTER AND SETTER PARA SEGUROS */
	
	public int getAsegura() {
		return asegura;
	}


	public void setAsegura(int asegura) {
		this.asegura = asegura;
	}
	
	public String getNombre_seguro() {
		return nombre_seguro;
	}


	public void setNombre_seguro(String nombre_seguro) {
		this.nombre_seguro = nombre_seguro;
	}


	public String getPorcentaje_seguro() {
		return porcentaje_seguro;
	}


	public void setPorcentaje_seguro(String porcentaje_seguro) {
		this.porcentaje_seguro = porcentaje_seguro;
	}
}
