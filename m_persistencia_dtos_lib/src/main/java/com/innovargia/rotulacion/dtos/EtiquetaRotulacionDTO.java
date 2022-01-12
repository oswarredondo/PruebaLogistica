/**
 * 
 */
package com.innovargia.rotulacion.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;

/**
 * @author Adri�n
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtiquetaRotulacionDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int idregistrodatos;
	int idregistro;
	int idventa;

	int esvalido = 1;// 0=NO ES VALIDO; 1= ES VALIDO
	String esmadre;// N = NO ES GUIA MADRE; S = ES GUIA MADRE

	boolean esimportacion = false;
	
	float kms_origen_destino;
	int linea_consecutivo;
	String remite = "";
	String destino;
	int cantidad;
	String idproducto="";
	String mensajeError = "";
	String tiporotucacion;
	String idenvio;
	String uuid;
	String idoficina;
	String idservicio;
	String garantia;
	String idtipocobro;
	String idformapago;
	String idadicional;
	String idterminalori;
	String idterminaldes;
	String idtipodocumento;
	String fechacreacion;
	String referencia;
	String login;
	String factura;
	String pedimento;
	String serviciotarifa;
	String aduana;
	float valordeclarado;
	String tipodeembalaje;
	String contenido;
	String ruta;
	String enrutamiento;
	
	String iddocumento;
	 String idguiainternacional;
	
	float preciozona;
	float iva;
	int largo;
	int ancho;
	int alto;
	int pesobase;
	float pesofisico; 
	float pesovolumetrico;
	float volumenamparado=0;
	float pesoamparado=0; 
	
	float pesomayor;

	float precio_unitario;
	float descuento;
	float precio_seguro;
	
	int idconvenio;
	int idcotizacion;
	int idconveniodetalle;
	int idtarifa;
	int idrangotarifa;
	int idpesotarifa;
	int idzonatarifa;
	float cargo_adicional;
	float importe_servicio;
	
	String dimensionmedida;
	
	boolean iscotizacion=false;
	
	boolean es_fxc =false;
	
	/* DATOS SEGURO */
	String ciaseguro;
	float cantasegurada;
	
	/*FECHA ESTIMADA DE ENTREGA*/
	String fechaEstimada;
	
	/**
	 * @return the importe_servicio
	 */
	public float getImporte_servicio() {
	    return importe_servicio;
	}

	/**
	 * @param importe_servicio the importe_servicio to set
	 */
	public void setImporte_servicio(float importe_servicio) {
	    this.importe_servicio = importe_servicio;
	}

	/* CAMBIO UNIGIS IDREMDES */
	String idRmDes_rem;
	
	String descripcion_servicio;
	String descripciongarantia;
	String nombreservicio;
	String tarifa_servicio;
	String numcliente;
	int numpiezas;
	String observacion;
	String zonaori;
	String zonades;
	String transportista;
	int identidad;
	int idorganizacion;
	String razonsocial_rem;
	String contacto_rem;
	String calle_rem;
	String colonia_rem;
	String municipio_rem;
	String estado_rem;
	String ciudad_rem;
	String cp_rem;
	String telefono_rem;
	String celular_rem;
	String rfc_rem;
	String email_rem;
	String referencia_rem;

	private String latitud_rem = null;
	private String longitud_rem = null;
	
	/* CAMBIO UNIGIS IDREMDES */
	String idRmDes_des;
	String razonsocial_des;
	String contacto_des;
	String calle_des;
	String colonia_des;
	String municipio_des;
	String estado_des;
	String ciudad_des;
	String cp_des;
	String telefono_des;
	String telefono_des2;
	String celular_des;
	String pais_rem;
	String pais_des;
	String codigopais_rem;
	String codigopais_des;
	String idestado_rem;
	String idestado_des;
	String rfc_des;
	String email_des;
	String referencia_des;

	private String latitud_des = null;
	private String longitud_des = null;
	
	String tiene_seguro;
	float valor_asegurado;
	String factura_producto;
	String tiene_retorno;
	String es_cod;
	String es_ocurre;
	String es_ocurre_des;
	String es_multiple;
	String tiporotulo;
	String nacional;
	float valor_a_cobrar;
	String factura_producto_cod;
	int idregistro_set;

	String numinterior_rem;
	String numexterior_rem;

	String numinterior_des;
	String numexterior_des;
	
	
	String razonsocial_fac;
	String contacto_fac;
	String calle_fac;
	String colonia_fac;
	String municipio_fac;
	String estado_fac;
	String ciudad_fac;
	String cp_fac;
	String telefono_fac;
	String celular_fac;
	String rfc_fac;
	String email_fac;
	String numexterior_fac;
	String numinterior_fac;
	String pais_fac;

	String factura_producto_asegurado;
	float valor_a_cobrar_cod;

	String descripcion;
	String tipoempaque;
	String pesomedida;
	String pesomedidadescripcion;

	int cantidad_total;
	float pesofisico_total;
	float pesovolumetrico_total;
	float tipocambio; //Tipo de cambio que se aplica cuando es una venta internacional
	

	String json_data;

	String adicionales;
	String siglasorigen;
	String siglasdestino;
	String oficinacontrol;
	
	/* CAMBIO CITAS V2 */
	String tiene_cita;
	String fecha_cita;
	String hora_cita;
	
	/* CAMBIO UNIGIS */
	int sistema;
	
	public int getSistema() {
		return sistema;
	}

	public void setSistema(int sistema) {
		this.sistema = sistema;
	}

	public String getTiene_cita() {
		return tiene_cita;
	}

	public void setTiene_cita(String tiene_cita) {
		this.tiene_cita = tiene_cita;
	}

	public String getFecha_cita() {
		return fecha_cita;
	}

	public void setFecha_cita(String fecha_cita) {
		this.fecha_cita = fecha_cita;
	}

	public String getHora_cita() {
		return hora_cita;
	}

	public void setHora_cita(String hora_cita) {
		this.hora_cita = hora_cita;
	}
	/* FIN CAMBIO CITAS */
	
	List<CruceCoberturaDTO> arr_transbordos = new ArrayList<CruceCoberturaDTO>();

	/**
	 * @return the json_data
	 */
	public String getJson_data() {
		return json_data;
	}

	/**
	 * @param json_data
	 *            the json_data to set
	 */
	public void setJson_data(String json_data) {
		this.json_data = json_data;
	}

	/**
	 * 
	 */
	public EtiquetaRotulacionDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdregistrodatos() {
		return idregistrodatos;
	}

	public void setIdregistrodatos(int idregistrodatos) {
		this.idregistrodatos = idregistrodatos;
	}

	public void setIdregistrodatos(String idregistrodatos) {
		try {
			this.idregistrodatos = Integer.parseInt(idregistrodatos);
		} catch (Exception e) {
			this.idregistrodatos = 0;
		}

	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getIdoficina() {
		return idoficina;
	}

	public void setIdoficina(String idoficina) {
		this.idoficina = idoficina;
	}

	public String getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
	}

	public String getIdtipocobro() {
		return idtipocobro;
	}

	public void setIdtipocobro(String idtipocobro) {
		this.idtipocobro = idtipocobro;
	}

	public String getIdformapago() {
		return idformapago;
	}

	public void setIdformapago(String idformapago) {
		this.idformapago = idformapago;
	}

	public String getIdadicional() {
		return idadicional;
	}

	public void setIdadicional(String idadicional) {
		this.idadicional = idadicional;
	}

	public String getIdterminalori() {
		return idterminalori;
	}

	public void setIdterminalori(String idterminalori) {
		this.idterminalori = idterminalori;
	}

	public String getIdterminaldes() {
		return idterminaldes;
	}

	public void setIdterminaldes(String idterminaldes) {
		this.idterminaldes = idterminaldes;
	}

	public String getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(String idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getEs_ocurre() {
		if ( (es_ocurre==null) || (es_ocurre.trim().isEmpty()) ){
			return "NO";
		}
		return es_ocurre;
	}

	public void setEs_ocurre(String es_ocurre) {
		if (es_ocurre != null) {
			es_ocurre = es_ocurre.toLowerCase().trim();
			if ("true".equals(es_ocurre) || "yes".equals(es_ocurre)
					|| "si".equals(es_ocurre)) {
				es_ocurre = "SI";
			} else {
				es_ocurre = "NO";
			}
		}
		this.es_ocurre = es_ocurre;
		this.es_ocurre_des = es_ocurre;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getPedimento() {
		return pedimento;
	}

	public void setPedimento(String pedimento) {
		this.pedimento = pedimento;
	}

	public String getAduana() {
		return aduana;
	}

	public void setAduana(String aduana) {
		this.aduana = aduana;
	}

	public float getValordeclarado() {
		return valordeclarado;
	}

	public void setValordeclarado(float valordeclarado) {
		this.valordeclarado = valordeclarado;
	}

	public void setValordeclarado(String valordeclarado) {
		try {
			this.valordeclarado = Float.parseFloat(valordeclarado);
		} catch (Exception e) {
			this.valordeclarado = 0;
		}

	}

	public String getTipodeembalaje() {
		return tipodeembalaje;
	}

	public void setTipodeembalaje(String tipodeembalaje) {
		this.tipodeembalaje = tipodeembalaje;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getEnrutamiento() {
		return enrutamiento;
	}

	public void setEnrutamiento(String enrutamiento) {
		this.enrutamiento = enrutamiento;
	}

	public float getPreciozona() {
		return preciozona;
	}

	public void setPreciozona(float preciozona) {
		this.preciozona = preciozona;
	}

	public void setPreciozona(String preciozona) {
		try {
			this.preciozona = Float.parseFloat(preciozona);
		} catch (Exception e) {
			this.preciozona = 0;
		}

	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public void setIva(String iva) {
		try {
			this.iva = Float.parseFloat(iva);
		} catch (Exception e) {
			this.iva = 0;
		}

	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public void setLargo(String largo) {
		try {
			this.largo = Integer.parseInt(largo);
		} catch (Exception e) {
			this.largo = 0;
		}

	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAncho(String ancho) {
		try {
			this.ancho = Integer.parseInt(ancho);
		} catch (Exception e) {
			this.ancho = 0;
		}

	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public void setAlto(String alto) {
		try {
			this.alto = Integer.parseInt(alto);
		} catch (Exception e) {
			this.alto = 0;
		}

	}

	public float getPesofisico() {
		return pesofisico;
	}

	public void setPesofisico(float pesofisico) {
		this.pesofisico = pesofisico;
	}

	public void setPesofisico(String pesofisico) {
		try {
			this.pesofisico = Float.parseFloat(pesofisico);
		} catch (Exception e) {
			this.pesofisico = 0;
		}

	}

	public float getPesovolumetrico() {
		return pesovolumetrico;
	}

	public void setPesovolumetrico(float pesovolumetrico) {
		this.pesovolumetrico = pesovolumetrico;
	}

	public void setPesovolumetrico(String pesovolumetrico) {
		try {
			this.pesovolumetrico = Float.parseFloat(pesovolumetrico);
		} catch (Exception e) {
			this.pesovolumetrico = 0;
		}

	}

	public String getNumcliente() {
		return numcliente;
	}

	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}

	public int getNumpiezas() {
		return numpiezas;
	}

	public void setNumpiezas(int numpiezas) {
		this.numpiezas = numpiezas;
	}

	public void setNumpiezas(String numpiezas) {
		try {
			this.numpiezas = Integer.parseInt(numpiezas);
		} catch (Exception e) {
			this.numpiezas = 0;
		}

	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getZonaori() {
		return zonaori;
	}

	public void setZonaori(String zonaori) {
		this.zonaori = zonaori;
	}

	public String getZonades() {
		return zonades;
	}

	public void setZonades(String zonades) {
		this.zonades = zonades;
	}

	public String getTransportista() {
		return transportista;
	}

	public void setTransportista(String transportista) {
		this.transportista = transportista;
	}

	public int getIdentidad() {
		return identidad;
	}

	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}

	public void setIdentidad(String identidad) {
		try {
			this.identidad = Integer.parseInt(identidad);
		} catch (Exception e) {
			this.identidad = 0;
		}

	}

	public int getIdorganizacion() {
		return idorganizacion;
	}

	public void setIdorganizacion(String idorganizacion) {
		try {
			this.idorganizacion = Integer.parseInt(idorganizacion);
		} catch (Exception e) {
			this.idorganizacion = 0;
		}

	}

	public int getIdregistro() {
		return idregistro;
	}

	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}

	public void setIdregistro(String idregistro) {
		try {
			this.idregistro = Integer.parseInt(idregistro);
		} catch (Exception e) {
			this.idregistro = 0;
		}

	}

	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	public String getRazonsocial_rem() {
		return razonsocial_rem;
	}

	public void setRazonsocial_rem(String razonsocial_rem) {
		this.razonsocial_rem = razonsocial_rem;
	}

	public String getContacto_rem() {
		return contacto_rem;
	}

	public void setContacto_rem(String contacto_rem) {
		this.contacto_rem = contacto_rem;
	}

	public String getCalle_rem() {
		return calle_rem;
	}

	public void setCalle_rem(String calle_rem) {
		this.calle_rem = calle_rem;
	}

	public String getColonia_rem() {
		return colonia_rem;
	}

	public void setColonia_rem(String colonia_rem) {
		this.colonia_rem = colonia_rem;
	}

	public String getMunicipio_rem() {
		return municipio_rem;
	}

	public void setMunicipio_rem(String municipio_rem) {
		this.municipio_rem = municipio_rem;
	}

	public String getEstado_rem() {
		return estado_rem;
	}

	public void setEstado_rem(String estado_rem) {
		this.estado_rem = estado_rem;
	}

	public String getCiudad_rem() {
		return ciudad_rem;
	}

	public void setCiudad_rem(String ciudad_rem) {
		this.ciudad_rem = ciudad_rem;
	}

	public String getCp_rem() {
		return cp_rem;
	}

	public void setCp_rem(String cp_rem) {
		this.cp_rem = cp_rem;
	}

	public String getTelefono_rem() {
		return telefono_rem;
	}

	public void setTelefono_rem(String telefono_rem) {
		this.telefono_rem = telefono_rem;
	}

	public String getCelular_rem() {
		return celular_rem;
	}

	public void setCelular_rem(String celular_rem) {
		this.celular_rem = celular_rem;
	}

	public String getRfc_rem() {
		return rfc_rem;
	}

	public void setRfc_rem(String rfc_rem) {
		this.rfc_rem = rfc_rem;
	}

	public String getEmail_rem() {
		return email_rem;
	}

	public void setEmail_rem(String email_rem) {
		this.email_rem = email_rem;
	}
	
	public String getReferencia_rem() {
		return referencia_rem;
	}

	public void setReferencia_rem(String referencia_rem) {
		this.referencia_rem = referencia_rem;
	}

	public String getRazonsocial_des() {
		return razonsocial_des;
	}

	public void setRazonsocial_des(String razonsocial_des) {
		this.razonsocial_des = razonsocial_des;
	}

	public String getContacto_des() {
		return contacto_des;
	}

	public void setContacto_des(String contacto_des) {
		this.contacto_des = contacto_des;
	}

	public String getCalle_des() {
		return calle_des;
	}

	public void setCalle_des(String calle_des) {
		this.calle_des = calle_des;
	}

	public String getColonia_des() {
		return colonia_des;
	}

	public void setColonia_des(String colonia_des) {
		this.colonia_des = colonia_des;
	}

	public String getMunicipio_des() {
		return municipio_des;
	}

	public void setMunicipio_des(String municipio_des) {
		this.municipio_des = municipio_des;
	}

	public String getEstado_des() {
		return estado_des;
	}

	public void setEstado_des(String estado_des) {
		this.estado_des = estado_des;
	}

	public String getCiudad_des() {
		return ciudad_des;
	}

	public void setCiudad_des(String ciudad_des) {
		this.ciudad_des = ciudad_des;
	}

	public String getCp_des() {
		return cp_des;
	}

	public void setCp_des(String cp_des) {
		this.cp_des = cp_des;
	}

	public String getTelefono_des() {
		return telefono_des;
	}

	public void setTelefono_des(String telefono_des) {
		this.telefono_des = telefono_des;
	}
	
	public String getTelefono_des2() {
		return telefono_des2;
	}

	public void setTelefono_des2(String telefono_des2) {
		this.telefono_des2 = telefono_des2;
	}
	
	public String getCelular_des() {
		return celular_des;
	}

	public void setCelular_des(String celular_des) {
		this.celular_des = celular_des;
	}

	public String getRfc_des() {
		return rfc_des;
	}

	public void setRfc_des(String rfc_des) {
		this.rfc_des = rfc_des;
	}

	public String getEmail_des() {
		return email_des;
	}

	public void setEmail_des(String email_des) {
		this.email_des = email_des;
	}
	
	public String getReferencia_des() {
		return referencia_des;
	}

	public void setReferencia_des(String referencia_des) {
		this.referencia_des = referencia_des;
	}

	public String getTiene_seguro() {
		return tiene_seguro;
	}

	public void setTiene_seguro(String tiene_seguro) {
		this.tiene_seguro = tiene_seguro;
	}

	public float getValor_asegurado() {
		return valor_asegurado;
	}

	public void setValor_asegurado(float valor_asegurado) {
		this.valor_asegurado = valor_asegurado;
	}

	public void setValor_asegurado(String valor_asegurado) {
		try {
			this.valor_asegurado = Float.parseFloat(valor_asegurado);
		} catch (Exception e) {
			this.valor_asegurado = 0;
		}

	}

	public String getFactura_producto() {
		return factura_producto;
	}

	public void setFactura_producto(String factura_producto) {
		this.factura_producto = factura_producto;
	}

	public String getEs_cod() {
		return es_cod;
	}

	public void setEs_cod(String es_cod) {
		this.es_cod = es_cod;
	}

	public float getValor_a_cobrar() {
		return valor_a_cobrar;
	}

	public void getValor_a_cobrar(String valor_a_cobrar) {
		try {
			this.valor_a_cobrar = Float.parseFloat(valor_a_cobrar);
		} catch (Exception e) {
			this.valor_a_cobrar = 0;
		}

	}

	public String getFactura_producto_cod() {
		return factura_producto_cod;
	}

	public void setFactura_producto_cod(String factura_producto_cod) {
		this.factura_producto_cod = factura_producto_cod;
	}

	public int getIdregistro_set() {
		return idregistro_set;
	}

	public void setIdregistro_set(int idregistro_set) {
		this.idregistro_set = idregistro_set;
	}

	public void setIdregistro_set(String idregistro_set) {
		try {
			this.idregistro_set = Integer.parseInt(idregistro_set);
		} catch (Exception e) {
			this.idregistro_set = 0;
		}

	}

	public String getFactura_producto_asegurado() {
		return factura_producto_asegurado;
	}

	public void setFactura_producto_asegurado(String factura_producto_asegurado) {
		this.factura_producto_asegurado = factura_producto_asegurado;
	}

	public float getValor_a_cobrar_cod() {
		return valor_a_cobrar_cod;
	}

	public void setValor_a_cobrar_cod(float valor_a_cobrar_cod) {
		this.valor_a_cobrar_cod = valor_a_cobrar_cod;
	}

	public void setValor_a_cobrar_cod(String valor_a_cobrar_cod) {
		try {
			this.valor_a_cobrar_cod = Float.parseFloat(valor_a_cobrar_cod);
		} catch (Exception e) {
			this.valor_a_cobrar_cod = 0;
		}

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTiene_retorno() {
		return tiene_retorno;
	}

	public void setTiene_retorno(String tiene_retorno) {
		this.tiene_retorno = tiene_retorno;
	}

	public String getEs_multiple() {
		return es_multiple;
	}

	public void setEs_multiple(String es_multiple) {
		this.es_multiple = es_multiple;
	}

	public String getTiporotulo() {
		return tiporotulo;
	}

	public void setTiporotulo(String tiporotulo) {
		this.tiporotulo = tiporotulo;
	}

	public String getNacional() {
		return nacional;
	}

	public void setNacional(String nacional) {
		this.nacional = nacional;
	}

	public void setValor_a_cobrar(float valor_a_cobrar) {
		this.valor_a_cobrar = valor_a_cobrar;
	}

	public String getNuminterior_rem() {
		return numinterior_rem;
	}

	public void setNuminterior_rem(String numinterior_rem) {
		this.numinterior_rem = numinterior_rem;
	}

	public String getNumexterior_rem() {
		return numexterior_rem;
	}

	public void setNumexterior_rem(String numexterior_rem) {
		this.numexterior_rem = numexterior_rem;
	}

	public String getNuminterior_des() {
		return numinterior_des;
	}

	public void setNuminterior_des(String numinterior_des) {
		this.numinterior_des = numinterior_des;
	}

	public String getNumexterior_des() {
		return numexterior_des;
	}

	public void setNumexterior_des(String numexterior_des) {
		this.numexterior_des = numexterior_des;
	}

	public String getEs_ocurre_des() {
		return es_ocurre_des;
	}

	public void setEs_ocurre_des(String es_ocurre_des) {
		if (es_ocurre_des != null) {
			es_ocurre_des = es_ocurre_des.toLowerCase().trim();
			if ("true".equals(es_ocurre_des) || "yes".equals(es_ocurre_des)
					|| "si".equals(es_ocurre)) {
				es_ocurre_des = "SI";
			} else {
				es_ocurre_des = "NO";
			}
		}

		this.es_ocurre_des = es_ocurre_des;
		this.es_ocurre = es_ocurre_des;
	}

	public String getTipoempaque() {
		return tipoempaque;
	}

	public void setTipoempaque(String tipoempaque) {
		this.tipoempaque = tipoempaque;
	}

	public int getCantidad_total() {
		return cantidad_total;
	}

	public void setCantidad_total(int cantidad_total) {
		this.cantidad_total = cantidad_total;
	}

	public float getPesofisico_total() {
		return pesofisico_total;
	}

	public void setPesofisico_total(float pesofisico_total) {
		this.pesofisico_total = pesofisico_total;
	}

	public float getPesovolumetrico_total() {
		return pesovolumetrico_total;
	}

	public void setPesovolumetrico_total(float pesovolumetrico_total) {
		this.pesovolumetrico_total = pesovolumetrico_total;
	}

	/**
	 * @return the esvalido
	 */
	public int getEsvalido() {
		return esvalido;
	}

	/**
	 * @param esvalido
	 *            the esvalido to set
	 */
	public void setEsvalido(int esvalido) {
		this.esvalido = esvalido;
	}

	/**
	 * @return the mensajeError
	 */
	public String getMensajeError() {
		return mensajeError;
	}

	/**
	 * @param mensajeError
	 *            the mensajeError to set
	 */
	public void setMensajeError(String mensajeError) {
		if (this.mensajeError==null){
			this.mensajeError="";
		}
		if (mensajeError==null){
			mensajeError="";
		}
		this.mensajeError = this.mensajeError + "   " +mensajeError;
	}

	/**
	 * @return the esimportacion
	 */
	public boolean isEsimportacion() {
		return esimportacion;
	}

	/**
	 * @param esimportacion
	 *            the esimportacion to set
	 */
	public void setEsimportacion(boolean esimportacion) {
		this.esimportacion = esimportacion;
	}

	/**
	 * @return the idconvenio
	 */
	public int getIdconvenio() {
		return idconvenio;
	}

	/**
	 * @param idconvenio
	 *            the idconvenio to set
	 */
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}

	public void setIdconvenio(String idconvenio) {
		try {
			this.idconvenio = Integer.parseInt(idconvenio);
		} catch (Exception e) {
			this.idconvenio = 0;
		}

	}

	/**
	 * @return the idtarifa
	 */
	public int getIdtarifa() {
		return idtarifa;
	}

	public void setIdtarifa(String idtarifa) {
		try {
			this.idtarifa = Integer.parseInt(idtarifa);
		} catch (Exception e) {
			this.idtarifa = 0;
		}

	}

	/**
	 * @param idtarifa
	 *            the idtarifa to set
	 */
	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}

	/**
	 * @return the tiporotucacion
	 */
	public String getTiporotucacion() {
		return tiporotucacion;
	}

	/**
	 * @param tiporotucacion
	 *            the tiporotucacion to set
	 */
	public void setTiporotucacion(String tiporotucacion) {
		this.tiporotucacion = tiporotucacion;
	}

	/**
	 * @return the idconveniodetalle
	 */
	public int getIdconveniodetalle() {
		return idconveniodetalle;
	}

	/**
	 * @param idconveniodetalle
	 *            the idconveniodetalle to set
	 */
	public void setIdconveniodetalle(int idconveniodetalle) {
		this.idconveniodetalle = idconveniodetalle;
	}

	public void setIdconveniodetalle(String idconveniodetalle) {
		try {
			this.idconveniodetalle = Integer.parseInt(idconveniodetalle);
		} catch (Exception e) {
			this.idconveniodetalle = 0;
		}

	}

	/**
	 * @return the adicionales
	 */
	public String getAdicionales() {
		return adicionales;
	}

	/**
	 * @param adicionales
	 *            the adicionales to set
	 */
	public void setAdicionales(String adicionales) {
		this.adicionales = adicionales;
	}

	/**
	 * @return the arr_transbordos
	 */
	public List<CruceCoberturaDTO> getArr_transbordos() {
		return arr_transbordos;
	}

	/**
	 * @param arr_transbordos
	 *            the arr_transbordos to set
	 */
	public void setArr_transbordos(List<CruceCoberturaDTO> arr_transbordos) {
		this.arr_transbordos = arr_transbordos;
	}

	/**
	 * @return the kms_origen_destino
	 */
	public float getKms_origen_destino() {
		return kms_origen_destino;
	}

	/**
	 * @param kms_origen_destino
	 *            the kms_origen_destino to set
	 */
	public void setKms_origen_destino(float kms_origen_destino) {
		this.kms_origen_destino = kms_origen_destino;
	}

	/**
	 * @return the pesomayor
	 */
	public float getPesomayor() {
		return pesomayor;
	}

	/**
	 * @param pesomayor
	 *            the pesomayor to set
	 */
	public void setPesomayor(float pesomayor) {
		this.pesomayor = pesomayor;
	}

	/**
	 * @return the descripcion_servicio
	 */
	public String getDescripcion_servicio() {
		return descripcion_servicio;
	}

	/**
	 * @param descripcion_servicio
	 *            the descripcion_servicio to set
	 */
	public void setDescripcion_servicio(String descripcion_servicio) {
		this.descripcion_servicio = descripcion_servicio;
	}

	/**
	 * @return the pesobase
	 */
	public int getPesobase() {
		return pesobase;
	}

	/**
	 * @param pesobase
	 *            the pesobase to set
	 */
	public void setPesobase(int pesobase) {
		this.pesobase = pesobase;
	}

	/**
	 * @return the descripciongarantia
	 */
	public String getDescripciongarantia() {
		return descripciongarantia;
	}

	/**
	 * @param descripciongarantia
	 *            the descripciongarantia to set
	 */
	public void setDescripciongarantia(String descripciongarantia) {
		this.descripciongarantia = descripciongarantia;
	}

	/**
	 * @return the siglasorigen
	 */
	public String getSiglasorigen() {
		return siglasorigen;
	}

	/**
	 * @param siglasorigen
	 *            the siglasorigen to set
	 */
	public void setSiglasorigen(String siglasorigen) {
		this.siglasorigen = siglasorigen;
	}

	/**
	 * @return the siglasdestino
	 */
	public String getSiglasdestino() {
		return siglasdestino;
	}

	/**
	 * @param siglasdestino
	 *            the siglasdestino to set
	 */
	public void setSiglasdestino(String siglasdestino) {
		this.siglasdestino = siglasdestino;
	}

	/**
	 * @return the idenvio
	 */
	public String getIdenvio() {
		return idenvio;
	}

	/**
	 * @param idenvio the idenvio to set
	 */
	public void setIdenvio(String idenvio) {
		this.idenvio = idenvio;
	}

	/**
	 * @return the serviciotarifa
	 */
	public String getServiciotarifa() {
		return serviciotarifa;
	}

	/**
	 * @param serviciotarifa the serviciotarifa to set
	 */
	public void setServiciotarifa(String serviciotarifa) {
		this.serviciotarifa = serviciotarifa;
	}

	/**
	 * @return the remite
	 */
	public String getRemite() {
		return remite;
	}

	/**
	 * @param remite the remite to set
	 */
	public void setRemite(String remite) {
		this.remite = remite;
	}

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the oficinacontrol
	 */
	public String getOficinacontrol() {
		return oficinacontrol;
	}

	/**
	 * @param oficinacontrol the oficinacontrol to set
	 */
	public void setOficinacontrol(String oficinacontrol) {
		this.oficinacontrol = oficinacontrol;
	}

	/**
	 * @return the nombreservicio
	 */
	public String getNombreservicio() {
		return nombreservicio;
	}

	/**
	 * @param nombreservicio the nombreservicio to set
	 */
	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
	}

	/**
	 * @return the tarifa_servicio
	 */
	public String getTarifa_servicio() {
		return tarifa_servicio;
	}

	/**
	 * @param tarifa_servicio the tarifa_servicio to set
	 */
	public void setTarifa_servicio(String tarifa_servicio) {
		this.tarifa_servicio = tarifa_servicio;
	}

	/**
	 * @return the pais_rem
	 */
	public String getPais_rem() {
		return pais_rem;
	}

	/**
	 * @param pais_rem the pais_rem to set
	 */
	public void setPais_rem(String pais_rem) {
		this.pais_rem = pais_rem;
	}

	/**
	 * @return the pais_des
	 */
	public String getPais_des() {
		return pais_des;
	}

	/**
	 * @param pais_des the pais_des to set
	 */
	public void setPais_des(String pais_des) {
		this.pais_des = pais_des;
	}

	/**
	 * @return the razonsocial_fac
	 */
	public String getRazonsocial_fac() {
		return razonsocial_fac;
	}

	/**
	 * @param razonsocial_fac the razonsocial_fac to set
	 */
	public void setRazonsocial_fac(String razonsocial_fac) {
		this.razonsocial_fac = razonsocial_fac;
	}

	/**
	 * @return the contacto_fac
	 */
	public String getContacto_fac() {
		return contacto_fac;
	}

	/**
	 * @param contacto_fac the contacto_fac to set
	 */
	public void setContacto_fac(String contacto_fac) {
		this.contacto_fac = contacto_fac;
	}

	/**
	 * @return the calle_fac
	 */
	public String getCalle_fac() {
		return calle_fac;
	}

	/**
	 * @param calle_fac the calle_fac to set
	 */
	public void setCalle_fac(String calle_fac) {
		this.calle_fac = calle_fac;
	}

	/**
	 * @return the colonia_fac
	 */
	public String getColonia_fac() {
		return colonia_fac;
	}

	/**
	 * @param colonia_fac the colonia_fac to set
	 */
	public void setColonia_fac(String colonia_fac) {
		this.colonia_fac = colonia_fac;
	}

	/**
	 * @return the municipio_fac
	 */
	public String getMunicipio_fac() {
		return municipio_fac;
	}

	/**
	 * @param municipio_fac the municipio_fac to set
	 */
	public void setMunicipio_fac(String municipio_fac) {
		this.municipio_fac = municipio_fac;
	}

	/**
	 * @return the estado_fac
	 */
	public String getEstado_fac() {
		return estado_fac;
	}

	/**
	 * @param estado_fac the estado_fac to set
	 */
	public void setEstado_fac(String estado_fac) {
		this.estado_fac = estado_fac;
	}

	/**
	 * @return the ciudad_fac
	 */
	public String getCiudad_fac() {
		return ciudad_fac;
	}

	/**
	 * @param ciudad_fac the ciudad_fac to set
	 */
	public void setCiudad_fac(String ciudad_fac) {
		this.ciudad_fac = ciudad_fac;
	}

	/**
	 * @return the cp_fac
	 */
	public String getCp_fac() {
		return cp_fac;
	}

	/**
	 * @param cp_fac the cp_fac to set
	 */
	public void setCp_fac(String cp_fac) {
		this.cp_fac = cp_fac;
	}

	/**
	 * @return the telefono_fac
	 */
	public String getTelefono_fac() {
		return telefono_fac;
	}

	/**
	 * @param telefono_fac the telefono_fac to set
	 */
	public void setTelefono_fac(String telefono_fac) {
		this.telefono_fac = telefono_fac;
	}

	/**
	 * @return the celular_fac
	 */
	public String getCelular_fac() {
		return celular_fac;
	}

	/**
	 * @param celular_fac the celular_fac to set
	 */
	public void setCelular_fac(String celular_fac) {
		this.celular_fac = celular_fac;
	}

	/**
	 * @return the rfc_fac
	 */
	public String getRfc_fac() {
		return rfc_fac;
	}

	/**
	 * @param rfc_fac the rfc_fac to set
	 */
	public void setRfc_fac(String rfc_fac) {
		this.rfc_fac = rfc_fac;
	}

	/**
	 * @return the email_fac
	 */
	public String getEmail_fac() {
		return email_fac;
	}

	/**
	 * @param email_fac the email_fac to set
	 */
	public void setEmail_fac(String email_fac) {
		this.email_fac = email_fac;
	}

	/**
	 * @return the numexterior_fac
	 */
	public String getNumexterior_fac() {
		return numexterior_fac;
	}

	/**
	 * @param numexterior_fac the numexterior_fac to set
	 */
	public void setNumexterior_fac(String numexterior_fac) {
		this.numexterior_fac = numexterior_fac;
	}

	/**
	 * @return the numinterior_fac
	 */
	public String getNuminterior_fac() {
		return numinterior_fac;
	}

	/**
	 * @param numinterior_fac the numinterior_fac to set
	 */
	public void setNuminterior_fac(String numinterior_fac) {
		this.numinterior_fac = numinterior_fac;
	}

	/**
	 * @return the pais_fac
	 */
	public String getPais_fac() {
		return pais_fac;
	}

	/**
	 * @param pais_fac the pais_fac to set
	 */
	public void setPais_fac(String pais_fac) {
		this.pais_fac = pais_fac;
	}

	/**
	 * @return the linea_consecutivo
	 */
	public int getLinea_consecutivo() {
	    return linea_consecutivo;
	}

	/**
	 * @param linea_consecutivo the linea_consecutivo to set
	 */
	public void setLinea_consecutivo(int linea_consecutivo) {
	    this.linea_consecutivo = linea_consecutivo;
	}

	/**
	 * @return the idproducto
	 */
	public String getIdproducto() {
	    return idproducto;
	}

	/**
	 * @param idproducto the idproducto to set
	 */
	public void setIdproducto(String idproducto) {
	    this.idproducto = idproducto;
	}

	/**
	 * @return the idrangotarifa
	 */
	public int getIdrangotarifa() {
	    return idrangotarifa;
	}

	/**
	 * @param idrangotarifa the idrangotarifa to set
	 */
	public void setIdrangotarifa(int idrangotarifa) {
	    this.idrangotarifa = idrangotarifa;
	}

	/**
	 * @return the idpesotarifa
	 */
	public int getIdpesotarifa() {
	    return idpesotarifa;
	}

	/**
	 * @param idpesotarifa the idpesotarifa to set
	 */
	public void setIdpesotarifa(int idpesotarifa) {
	    this.idpesotarifa = idpesotarifa;
	}

	/**
	 * @return the idzonatarifa
	 */
	public int getIdzonatarifa() {
	    return idzonatarifa;
	}

	/**
	 * @param idzonatarifa the idzonatarifa to set
	 */
	public void setIdzonatarifa(int idzonatarifa) {
	    this.idzonatarifa = idzonatarifa;
	}

	/**
	 * @return the precio_unitario
	 */
	public float getPrecio_unitario() {
	    return precio_unitario;
	}

	/**
	 * @param precio_unitario the precio_unitario to set
	 */
	public void setPrecio_unitario(float precio_unitario) {
	    this.precio_unitario = precio_unitario;
	}

	/**
	 * @return the descuento
	 */
	public float getDescuento() {
	    return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(float descuento) {
	    this.descuento = descuento;
	}

	/**
	 * @return the cargo_adicional
	 */
	public float getCargo_adicional() {
	    return cargo_adicional;
	}

	/**
	 * @param cargo_adicional the cargo_adicional to set
	 */
	public void setCargo_adicional(float cargo_adicional) {
	    this.cargo_adicional = cargo_adicional;
	}

	/**
	 * @return the idventa
	 */
	public int getIdventa() {
	    return idventa;
	}

	/**
	 * @param idventa the idventa to set
	 */
	public void setIdventa(int idventa) {
	    this.idventa = idventa;
	}

	/**
	 * @return the latitud_rem
	 */
	public String getLatitud_rem() {
	    return latitud_rem;
	}

	/**
	 * @param latitud_rem the latitud_rem to set
	 */
	public void setLatitud_rem(String latitud_rem) {
	    this.latitud_rem = latitud_rem;
	}

	/**
	 * @return the longitud_rem
	 */
	public String getLongitud_rem() {
	    return longitud_rem;
	}

	/**
	 * @param longitud_rem the longitud_rem to set
	 */
	public void setLongitud_rem(String longitud_rem) {
	    this.longitud_rem = longitud_rem;
	}

	/**
	 * @return the latitud_des
	 */
	public String getLatitud_des() {
	    return latitud_des;
	}

	/**
	 * @param latitud_des the latitud_des to set
	 */
	public void setLatitud_des(String latitud_des) {
	    this.latitud_des = latitud_des;
	}

	/**
	 * @return the longitud_des
	 */
	public String getLongitud_des() {
	    return longitud_des;
	}

	/**
	 * @param longitud_des the longitud_des to set
	 */
	public void setLongitud_des(String longitud_des) {
	    this.longitud_des = longitud_des;
	}

	/**
	 * @return the pesomedida
	 */
	public String getPesomedida() {
	    return pesomedida;
	}

	/**
	 * @param pesomedida the pesomedida to set
	 */
	public void setPesomedida(String pesomedida) {
	    this.pesomedida = pesomedida;
	}

	/**
	 * @return the pesomedidadescripcion
	 */
	public String getPesomedidadescripcion() {
	    return pesomedidadescripcion;
	}

	/**
	 * @param pesomedidadescripcion the pesomedidadescripcion to set
	 */
	public void setPesomedidadescripcion(String pesomedidadescripcion) {
	    this.pesomedidadescripcion = pesomedidadescripcion;
	}

	
	

	/**
	 * @return the garantia
	 */
	public String getGarantia() {
	    return garantia;
	}

	/**
	 * @param garantia the garantia to set
	 */
	public void setGarantia(String garantia) {
	    this.garantia = garantia;
	}

	/**
	 * @return the tipocambio
	 */
	public float getTipocambio() {
	    return tipocambio;
	}

	/**
	 * @param tipocambio the tipocambio to set
	 */
	public void setTipocambio(float tipocambio) {
	    this.tipocambio = tipocambio;
	}

	/**
	 * @return the dimensionmedida
	 */
	public String getDimensionmedida() {
	    return dimensionmedida;
	}

	/**
	 * @param dimensionmedida the dimensionmedida to set
	 */
	public void setDimensionmedida(String dimensionmedida) {
	    this.dimensionmedida = dimensionmedida;
	}

	/**
	 * @return the iddocumento
	 */
	public String getIddocumento() {
	    return iddocumento;
	}

	/**
	 * @param iddocumento the iddocumento to set
	 */
	public void setIddocumento(String iddocumento) {
	    this.iddocumento = iddocumento;
	}

	/**
	 * @return the idguiainternacional
	 */
	public String getIdguiainternacional() {
	    return idguiainternacional;
	}

	/**
	 * @param idguiainternacional the idguiainternacional to set
	 */
	public void setIdguiainternacional(String idguiainternacional) {
	    this.idguiainternacional = idguiainternacional;
	}

	/**
	 * @return the ruta
	 */
	public String getRuta() {
	    return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
	    this.ruta = ruta;
	}

	/**
	 * @return the iscotizacion
	 */
	public boolean isIscotizacion() {
	    return iscotizacion;
	}

	/**
	 * @param iscotizacion the iscotizacion to set
	 */
	public void setIscotizacion(boolean iscotizacion) {
	    this.iscotizacion = iscotizacion;
	}

	/**
	 * @return the precio_seguro
	 */
	public float getPrecio_seguro() {
	    return precio_seguro;
	}

	/**
	 * @param precio_seguro the precio_seguro to set
	 */
	public void setPrecio_seguro(float precio_seguro) {
	    this.precio_seguro = precio_seguro;
	}
	
	public void cleanRemitente(){
	    	this.razonsocial_rem="";
		this.contacto_rem="";
		this.calle_rem="";
		this.colonia_rem="";
		this.municipio_rem="";
		this.estado_rem="";
		this.ciudad_rem="";
		this.cp_rem="";
		this.telefono_rem="";
		this.celular_rem="";
		this.pais_rem="";
		this.pais_rem="";
		this.rfc_rem="";
		this.email_rem="";
		this.latitud_rem="";
		this.longitud_rem="";
		this.numinterior_rem="";
		this.numexterior_rem="";
	}
	public void cleanDestino(){
		this.razonsocial_des="";
		this.contacto_des="";
		this.calle_des="";
		this.colonia_des="";
		this.municipio_des="";
		this.estado_des="";
		this.ciudad_des="";
		this.cp_des="";
		this.telefono_des="";
		this.celular_des="";
		this.pais_des="";
		this.pais_des="";
		this.rfc_des="";
		this.email_des="";
		this.latitud_des="";
		this.longitud_des="";
		this.numinterior_des="";
		this.numexterior_des="";
	}

	/**
	 * @return the idcotizacion
	 */
	public int getIdcotizacion() {
	    return idcotizacion;
	}

	/**
	 * @param idcotizacion the idcotizacion to set
	 */
	public void setIdcotizacion(int idcotizacion) {
	    this.idcotizacion = idcotizacion;
	}

	public boolean isEs_fxc() {
		return es_fxc;
	}

	public void setEs_fxc(boolean es_fxc) {
		this.es_fxc = es_fxc;
	}

	public float getVolumenamparado() {
		return volumenamparado;
	}

	public void setVolumenamparado(float volumenamparado) {
		this.volumenamparado = volumenamparado;
	}

	public float getPesoamparado() {
		return pesoamparado;
	}

	public void setPesoamparado(float pesoamparado) {
		this.pesoamparado = pesoamparado;
	}

	/**
	 * @return the codigopais_rem
	 */
	public String getCodigopais_rem() {
		return codigopais_rem;
	}

	/**
	 * @param codigopais_rem the codigopais_rem to set
	 */
	public void setCodigopais_rem(String codigopais_rem) {
		this.codigopais_rem = codigopais_rem;
	}

	/**
	 * @return the codigopais_des
	 */
	public String getCodigopais_des() {
		return codigopais_des;
	}

	/**
	 * @param codigopais_des the codigopais_des to set
	 */
	public void setCodigopais_des(String codigopais_des) {
		this.codigopais_des = codigopais_des;
	}

	/**
	 * @return the idestado_rem
	 */
	public String getIdestado_rem() {
		return idestado_rem;
	}

	/**
	 * @return the idestado_des
	 */
	public String getIdestado_des() {
		return idestado_des;
	}

	/**
	 * @param idestado_rem the idestado_rem to set
	 */
	public void setIdestado_rem(String idestado_rem) {
		this.idestado_rem = idestado_rem;
	}

	/**
	 * @param idestado_des the idestado_des to set
	 */
	public void setIdestado_des(String idestado_des) {
		this.idestado_des = idestado_des;
	}
	
	/* PARA LA GUIA MADRE */
	public String getEsmadre() {
		return esmadre;
	}

	public void setEsmadre(String esmadre) {
		this.esmadre = esmadre;
	}
	
	/* DATOS SEGURO */
	public String getCiaseguro() {
		return ciaseguro;
	}

	public void setCiaseguro(String ciaseguro) {
		this.ciaseguro = ciaseguro;
	}

	public float getCantasegurada() {
		return cantasegurada;
	}

	public void setCantasegurada(float cantasegurada) {
		this.cantasegurada = cantasegurada;
	}
	
	/*FECHA ESTIMADA DE ENTREGA*/
	public String getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(String fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public String getIdRmDes_rem() {
		return idRmDes_rem;
	}

	public void setIdRmDes_rem(String idRmDes_rem) {
		this.idRmDes_rem = idRmDes_rem;
	}

	public String getIdRmDes_des() {
		return idRmDes_des;
	}

	public void setIdRmDes_des(String idRmDes_des) {
		this.idRmDes_des = idRmDes_des;
	}
	
	
	/* CAMBIO CITA EVIDENCIA MANIOBRA 
	public float getPrecioManiobra() {
		return precioManiobra;
	}

	public void setPrecioManiobra(float precioManiobra) {
		this.precioManiobra = precioManiobra;
	}

	public float getPrecioCitas() {
		return precioCitas;
	}

	public void setPrecioCitas(float precioCitas) {
		this.precioCitas = precioCitas;
	}

	public float getPrecioEvidencia() {
		return precioEvidencia;
	}

	public void setPrecioEvidencia(float precioEvidencia) {
		this.precioEvidencia = precioEvidencia;
	}
    FIN CAMBIO */
}
