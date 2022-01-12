/* $Id: $
 * Nombre del Proyecto: IETWeb
 * Nombre del Programa: Envio.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion: Datos Pertenecientes a un envio
 *
 *$Log:$
 */
package com.innovargia.documentos.dtos;

import java.io.Serializable;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.servicio.dtos.DocumentoDTO;
 
/**
 * <CODE>
 * Datos de un cliente o un remitente
 *</CODE>
 * 
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT) 
public class Envio implements Serializable {

	/**
	 * Identificadores del tipo de rotulo existente
	 */
	public final static int ROT_REMITE = 1;
	public final static int ROT_DESTINO = 2;
	public final static int ROT_AMBOS = 3;
	public final static int ROT_BLANCO = 4;
	public final static int _LARGO_FACTURA = 5;
	public int indice =0;

	/** Posibles estatus del envio */
	public final static String ERROR = "E";
	public final static String SIN_GARANTIA = "S";
	public final static String CORRECTO = "C";

	/** Etiqueta sin garantia */
	public final static String ETI_SIN_GARANTIA = "**SIN GARANTIA**";
	private String tipoEntrega="NACIONAL";    //NACIONAL, INTERNACIONAL
	/**
	 * Tipo de informacion que puede guardar la clase:<br>
	 * E = ENVIO, cuando se trata de datos de una etiqueta<br>
	 * R = RECOLECCION cuando se trata de una orden de recolecci�n para un
	 * cliente en un destino<br>
	 * P = Cuando se trata de un pedido de embarque<br>
	 * 
	 * Estos identificadores son utilizados en el sistema de pedidos de
	 * embarques
	 * 
	 */
	public final static String TIPOINFO_ENVIO = "E";
	public final static String TIPOINFO_RECOLECCION = "R";
	public final static String TIPOINFO_PEDIDO_EMBARQUE = "P";
	
	private int bultos=0;
	private String embalaje="";
	private int largo=0;
	private int alto=0;
	private int ancho=0;
	private int pesovol=0;
	private int pesofis=0;
	private String flejado="false";
	
	private int consecutivo=0;
	private int cantidad_envios_remesa=1;

	public final static String _activo = "A";
	public final static String _cancelado = "C";
	public final static String _retenido = "R";
	public final static String _entregado = "E";
	public final static String _recolectado = "L";
	public final static String _preimpreso = "S";// Indica un estado de
	// preimpreso
	public final static String _impreso = "I"; // Indica que el envio esta
	// impreso
	public final static String _facturado = "F"; // Indica que esta facturado
	public final static String _con_historia = "H"; // Indica que el envio tiene
	// historia
	public final static String _masivo = "M"; // Indica que es un envio masivo
	public final static String _devolucion = "W"; // Indica que es un envio de
	// devolucion
	public final static String _programado = "P"; // Indica que fue realizada
	// una recoleccion
	// programada
	public final static String _carta_recoleccion = "CARTA RECOLECCION";

	/** Variable que almacena el mensaje de error */
	private String msgError = "";
	
	String reimpresion;
	String fuerzaventas;
	String ciclo;
	String oficinacontrol;
	String descripcionfolioconvenio;
	String idOficina;

	

	/** Indica si en la etiqueta se va a indicar la leyenda ocurre */

	public String getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}

	/** Datos de un pagare* */
	public Pagare pagare = new Pagare();

	/** Contiene los datos de la frecuencia y enrutamiento del destino */
	private boolean ocurre = false;

	/** Indica si la frecuencia es incorrecta */
	private boolean frecuenciaCorrecta = true;

	public CPs enrutamiento = new CPs();

	/**
	 * Identifica un registro de datos como incorrecto cuando se esta importando
	 * la informaci�n para impresi�n con destinos o remitentes o cuando se esta
	 * cargando una cartera de clientes Indica si un registro es correcto o
	 * incorrecto cuando se esta importando la infomacion
	 * 
	 * c= Correcto, S= SIN GARANTIA , E= Error
	 */
	private String estatus = "C";

	/**
	 * Indica el numero de cliente al que esta asociado este registro al ser
	 * importado
	 */
	private String numCliente;

	/** Indica si se va a crear un pagara **** */
	private boolean crea_Pagare = false;

	/** Indica si se va a crear un pagara **** */
	private boolean preimpresa = false;

	/**
	 * Indica si un envio es salvado como persistente para futura impresiones,
	 * el valor por omision es 0=false
	 */
	private int persistente = 0;

	/** Path del archivo que contiene la informacion */
	private String pathFile;

	/** Cantidad asegurada del envio */
	private float cantAsegurada = 0;
	/**
	 * Indica el tipo de rotulo seleccionado por el usaurio} Remitente, Destino,
	 * Ambos, blanco
	 */
	private int tipoRotulo;

	/** Clase */
	private String idClase;
	/** Grupo */
	private String idGrupo;
	/** Gestion */
	private String idGestion;
	/** Medida */
	private String idMedida;
	/** Serie */
	private String serie;
	
	private String idguiainternacional;
	
	/** Transbordos */
	List<CruceCoberturaDTO> arr_transbordos = new ArrayList<CruceCoberturaDTO>();
	

	/**
	 * Indica si la etiqueta es con acuse, de esta forma se imprimen dos
	 * eriquetas
	 */
	private boolean acuse = false;

	public boolean isAcuse() {
		return acuse;
	}

	public void setAcuse(boolean acuse) {
		this.acuse = acuse;
	}

	public void setAcuse(String acuse) {
		
		String s = acuse==null?"false":acuse.trim().toLowerCase();
		
		if ("yes".equals(s) || "si".equals(s) || "true".equals(s)  ||
				"s".equals(s) || "y".equals(s)  || "t".equals(s) ){
			this.acuse = true;
		}else{
			this.acuse = false;
		}
		
		
	}

	/**
	 * Tipo informacion, al inicio se puede tener E= Enbarque R= Recoleccion
	 */
	private String tipoInf = "E"; // Por default es un embarque

	/**
	 * Indica la posicion del envio dentro del arreglo para poder ser borrado o
	 * no se toma en cuenta en caso de que el usuario lo borre en la p�gina web.
	 * el formato es de 9999
	 */
	private String posicion;

	/** *Contiene los folios asociados a l envio */
	private ArrayList folios = new ArrayList();

	/** * *** */
	/**
	 * Arreglo que contiene la historia del envio
	 */
	ArrayList historia = new ArrayList();
	/**
	 * Indica la lista de proyectos, horas, etc del usuario
	 */
	public ArrayList objetos = new ArrayList();

	/**
	 * Contiene los identificadores de las ubicaciones, lugar fisico donde se
	 * puede encontrar el envio
	 */
	public String ubicacion;

	/** Identificador llave para cuando se esta importando la informacion */
	private String idLLaveImport;

	/** Indica el identificador de la mensajeria por la que fue enviado */
	private String enrutadoPor;

	public String getEnrutadoPor() {
		if (enrutadoPor == null)
			return "";
		return enrutadoPor;
	}

	public void setEnrutadoPor(String enrutadoPor) {
		this.enrutadoPor = enrutadoPor;
	}

	/**
	 * Indinca si se debe dar un salto de pagina en la impresion
	 */
	public String breakPage;

	/***************************************************************************
	 * Contiene los identificadores de los destinos en el siguiente formato
	 * Id_Usuario_Destino|Formato|Tipo|Servicio|Comentario
	 */
	private String destinos;
	/** Arreglo con todos los destinos a imprimir */
	public String[] ar_destinos;
	/** Contiene los datos del remitente */
	public RemDes remitente = new RemDes();
	/** Contiene los datos del destinatario */
	public RemDes destinatario = new RemDes();
	/** Contiene los datos de la confirmacion */
	public Confirmacion confirmacion = new Confirmacion();
	/** Contiene la informaci�n de casamiento de un envio */
	public CasamientoEnvio casamiento = new CasamientoEnvio();

	private String idBarras;
	
	private String razonSocialRemitente;
	private String razonSocialDestino;

	/**
	 * Contiene la fecha en formato dd/mm/aaaa de impresion
	 */
	private String fechaCorta;
	/**
	 * Contiene la hora en formato 00-12 de impresion
	 */
	private String horaCorta;
	/**
	 * Contiene los minutos en formato 00-59 de impresion
	 */
	private String minutosCorta;
	/**
	 * Identificador del envio
	 */
	private String idEnvio;
	/** Identificador tipo de servicio */
	private String servicio;
	/** Identificador de la forma de pago **/
	private String formapago;
	/** Identificador del empaque/formato */
	private String formato;
	/** Garantia */
	private String garantia;
	/** Adicional */
	private String adicional;
	/** Referencia */
	private String referencia;

	/** Descripcion de la garantia */
	private String des_servicio;
	/** Descripcion del empaque/formato */
	private String des_formato;
	/** Descripcion Garantia */
	private String des_garantia;
	/** Descripcion Adicional */
	private String des_adicional;
	/** Descripci�n de la forma de pago */
	private String des_formapago;
	/** Enrutamiento del envio */
	private String ruta;
	private String contenido = "";

	private int peso = 0;

	private int cantidad = 1;
	private String observa1 = "";
	private String observa2 = "";
	/**
	 * Indinca si es mas de una etiqueta si se deben imprimir los envios
	 * multiples, solo se imprimie multiples cuando esta variable tiene el valor
	 * de 'S'
	 */
	private String multiples = "N";
	
	private String idguiamadremultiple;

	/** Garantia */
	/**
	 * Ruta Retorno
	 */
	private String rutaRemitente;
	/**
	 * Fecha de creacion de la etiqueta o del registro de informaci�n en el
	 * agregado por Servidor Registros
	 */
	private String fechaCreacion;
	/** Identificador del usuario */
	private String idUsuario;
	/** Comentario */
	private String comentario;
	/** Estado de un envio */
	private String estado = "A";

	private String login;
	private String  usuarioimprime;
	//Indica si el envio es con guia de retorno
	private boolean conRetorno=false;

	/**
	 * Logo en la etiqueta
	 */
	private String logo;

	/** Siglas de la plaza origen */
	private String siglasOrigen;

	/** Siglas de la plaza destino */
	private String siglasDestino;

	/** Descripcion del centro de costo */
	private String descentrocosto;

	/** Numero de factura asignado* */
	private String factura;

	/** Datos del registro envio origen registro */
	private String origenRegistro;
	/** Siglas de la plaza donde se genera la informaci�n */
	private String siglasPlaza;

	/** Monto que ampara el paquete */
	private double monto;
	private double montoAsegurado;
	
	

	private String s_monto;

	/** Peso bascula que es actualizada por opereciones **/
	private double pesoBas;
	private int pesoAmparado;
	private int pesoAmparaServicio;
	private double peso_volumetrico = 0;

	/** Indica el tipo de envio que se esta procesando */
	public static final int TIPO_ENVIO_NOR = 0;
	public static final int TIPO_ENVIO_TC = 1;
	public static final int TIPO_ENVIO_EFE = 2;
	public static final int TIPO_ENVIO_COD = 3;

	private int tipo_Envio = TIPO_ENVIO_NOR;

	private String guiaMadre;
	
	private String esMadre;
	
	private String lineaenruta1;
	private String lineaenruta2;
	private String lineaenruta3;
	private String lineaenruta4;
	
	
	/* PARA SABER SI LA ETIQUETA ES ASEGURADA */
	private String tiene_seguro;
	
	/*FECHA ESTIMADA WALMART*/
	private String maxEDD;
	
	/* PARA SABER SI LA ETIQUETA ES ASEGURADA */
	private String tiene_cita;

	/* CAMBIO UNIGIS */
	private String tipo_empaque;
	
	private String idproducto;
	
	public String getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getTipo_empaque() {
		return tipo_empaque;
	}

	public void setTipo_empaque(String tipo_empaque) {
		this.tipo_empaque = tipo_empaque;
	}

	/**
	 * Hash que contiene los estados de un envio, que pueden ser:<br>
	 * 
	 * A-->ACTIVO<br>
	 * C-->CANCELADO<br>
	 * R-->RETENIDO<br>
	 * E-->ENTREGADO<br>
	 * L-->RECOLECTADO<br>
	 * I-->IMPRESO<br>
	 * F-->FACTURADO<br>
	 * H-->CON HISTORIA <br>
	 * M-->ENVIO MASIVO <br>
	 * 
	 */
	private static HashMap mapEstados = new HashMap();
	static {

		mapEstados.put(_activo, "ACTIVO");
		mapEstados.put(_cancelado, "CANCELADO");
		mapEstados.put(_retenido, "RETENIDO");
		mapEstados.put(_entregado, "ENTREGADO");
		mapEstados.put(_recolectado, "RECOLECTADO");
		mapEstados.put(_impreso, "IMPRESO");
		mapEstados.put(_facturado, "FACTURADO");
		mapEstados.put(_con_historia, "CON HISTORIA");
		mapEstados.put(_masivo, "ENVIO MASIVO");
		mapEstados.put(_devolucion, "DEVOLUCION A ORIGEN");
		mapEstados.put(_programado, "RECOLECCION PROGRAMADA");
		mapEstados.put(_preimpreso, "ETIQUETA PREIMPRESA");

	}

	public String getMiEstado() {
		if (this.fechaCreacion == null) {
			return _preimpreso;
		}
		if (this.estado == null) {
			return _impreso;
		}
		return this.estado;
	}

	public double getPesoBas() {
		return pesoBas;
	}

	public void setPesoBas(double pesoBas) {
		this.pesoBas = pesoBas;
	}

	/**
	 * @return the peso_volumetrico
	 */
	public double getPeso_volumetrico() {
		return peso_volumetrico;
	}

	/**
	 * @param peso_volumetrico
	 *            the peso_volumetrico to set
	 */
	public void setPeso_volumetrico(double peso_volumetrico) {
		this.peso_volumetrico = peso_volumetrico;
	}

	/**
	 * Devuelve el identificador del estado original al que se seteo la
	 * propiedad this.estado, sin realizar ningua comparacion
	 */
	public String getInicialEstado() {
		if (this.estado == null)
			return _impreso;
		return this.estado;
	}

	public String getTransportistaRe() {
		return this.ruta;
	}

	/**
	 * Devuelve el identificador del este3ado del envio, que puede ser A =
	 * ACTIVO, R= Retenido, C=Cancelado, si no cae dento de ninguno de estos
	 * devuelve A=Activo, E=Entregado
	 * 
	 * @return Value of property estado.
	 * 
	 */
	public java.lang.String getEstado() {

		if (this.fechaCreacion == null) {
			return (String) mapEstados.get(_preimpreso);
		}

		// Verifica si existe confirnmacion
		if (this.confirmacion != null) {
			if ((this.confirmacion.getQuienRecibe() != null)
					&& (this.confirmacion.getQuienRecibe().trim().length() > 0)) {
				return (String) mapEstados.get(_entregado);

			}
		}
		if (this.estado != null) {
			if (this.estado.trim().equals(_devolucion)) {
				return (String) mapEstados.get(_devolucion);
			}
		}
		if (this.estado != null) {
			if (this.estado.trim().equals(_masivo)) {
				return (String) mapEstados.get(_masivo);
			}
		}

		if (!mapEstados.containsKey(this.estado)) {
			return (String) mapEstados.get(_activo);
		}

		return (String) mapEstados.get(this.estado);
	}

	/**
	 * Devuelve Activo para los envios cuyo estado sea distinto a cancelado
	 * 
	 * @return Value of property estado.
	 * 
	 */
	public java.lang.String getEstadoGif() {

		if (this.fechaCreacion == null) {
			return "printer";
		}
		if (this.estado == null) {
			return "activo";
		}
		// Verifica si ya esta confirmado el envio
		if (this.confirmacion != null) {
			if ((this.confirmacion.getQuienRecibe() != null)
					&& (this.confirmacion.getQuienRecibe().trim().length() > 0)) {
				return "confirmado";
			}
		}
		if (this.estado.equals(_cancelado)) {
			return "inactivo";
		} else {
			if (this.estado.equals(_devolucion)) {
				return "devolucion";
			}
			return "activo";
		}
	}// fin getEstadoGif

	/**
	 * Setter for property estado.
	 * 
	 * @param estado
	 *            New value of property estado.
	 * 
	 */
	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	public Envio() {
	}

	public Envio(RemDes remitente, RemDes destinatario) {
		this.remitente = remitente;
		this.destinatario = destinatario;

	}

	public Envio(RemDes remitente, RemDes destinatario, String formato,
			String servicio, String idUsuario, String comentario) {
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.formato = formato;
		this.servicio = servicio;
		this.idUsuario = idUsuario;
		this.comentario = comentario;
	}

	public Envio(String idEnvio, String formato, String servicio,
			String idUsuario, String comentario) {
		this.formato = formato;
		this.servicio = servicio;
		this.idUsuario = idUsuario;
		this.comentario = comentario;
	}

	public Envio(String idEnvio, String formato, String servicio,
			String idUsuario, String comentario, String estado) {
		this.formato = formato;
		this.servicio = servicio;
		this.idUsuario = idUsuario;
		this.comentario = comentario;
		this.estado = estado;
	}

	/**
	 * Arma el identificador del envio bajo el siguiente criterio:<br>
	 * Partes de una Guia de izquierda a derecha<br>
	 * Primeros 4 numeros Numero Cliente ( completar con ceros a la izq.)<br>
	 * Siguiente 2 tipo servicio ( El primero indica el tipo de servicio y el
	 * segundo indica la forma de pago<br>
	 * Siguiente 2 Peso<br>
	 * Siguientes 7 Folio ( completar con ceros a la izq.)<br>
	 * Estructura:<br>
	 * <strong> cliente+this.servicio+str_peso+consecutivo</strong>
	 * 
	 * @param consecutivo
	 *            consecutivo de la guia
	 * @param cliente
	 *            numero de cliente que es igual al lgin del usuario de la
	 *            sesionj activa
	 * @param amparapeso
	 *            pero que ampara el rango seleccionado poe rl usuario
	 * @return
	 */
	public String armaIdEnvio(String consecutivo, String cliente, int amparapeso) {

		String str_peso = amparapeso + "";

		if (amparapeso > 99) {
			str_peso = "99";
		}
		str_peso = str_peso.trim();

		while (str_peso.trim().length() < 2) {
			str_peso = "0" + str_peso;
		}

		while (consecutivo.trim().length() < 7) {
			consecutivo = "0" + consecutivo;
		}
		while (cliente.trim().length() < 4) {
			cliente = "0" + cliente;
		}
		// devuelve el numero de guia creado
		return cliente + this.servicio + str_peso + consecutivo;

	}// fin de armaIdEnvio
	
	/**
	 * Arma el identificador de la carta tomandoen cuenta:
	 * Peso, consecutivo, numero de cliente,entidad y organizacion
	 *   
	 *   entidad+organizacion+cliente + this.servicio + str_peso + consecutivo
	 *   
	 * @param consecutivo
	 * @param carta
	 *  @param largo
	 * @return
	 */
	public String armaIdEnvio(String consecutivo,DocumentoDTO carta, int largo) {
	    
	    if (largo<=0){
		largo=8;
	    }
		String str_peso = carta.datosCarta.getPesoAmparado()  + "";
		String cliente=carta.getNumCliente();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 22);

		if (carta.datosCarta.getPesoAmparado() > 99) {
			str_peso = "99";
		}
		str_peso = str_peso.trim();

		while (str_peso.trim().length() < 2) {
			str_peso = "0" + str_peso;
		}

		while (consecutivo.trim().length() < 7) {
			consecutivo = "0" + consecutivo;
		}
		while (cliente.trim().length() < 4) {
			cliente = "0" + cliente;
		}
		String entidad=carta.entidad.getIdentidad()+"";
		String organizacion=carta.organizacion.getIdorganizacion()+"";
		while (entidad.trim().length() < 3) {
			entidad = "0" + entidad;
		}
		while (organizacion.trim().length() < 3) {
			organizacion = "0" + organizacion;
		}
		// devuelve el numero de guia creado
		return organizacion+cliente + this.servicio + str_peso + consecutivo;
		//"001 0000107 00 0000171"

	}// fin de armaIdEnvio

	/**
	 * Devuelve el estado en que se encuentra el envio, que puede ser Activo,
	 * Retenido o Cancelado, en caso de que el identificador no este dentro de
	 * (A,R,C) devuelve el estado ACTIVO (A)
	 */
	public String getDescripcionEstado() {
		if (this.fechaCreacion == null) {
			return (String) mapEstados.get(_preimpreso);
		}
		try {
			if ((this.confirmacion.getQuienRecibe() != null)
					|| (this.confirmacion.getQuienRecibe().trim().length() > 0)) {
				if ((this.estado != null) && (this.estado.trim().equals("M"))) {
					// Envio MASIVO ENTREGADO
					return ((String) mapEstados.get(_masivo) + (String) mapEstados
							.get(_entregado));
				} else {
					// ENVIO NORMAL
					return (String) mapEstados.get(_entregado);
				}
			}
		} catch (Exception e) {

		}
		if (!mapEstados.containsKey(this.estado)) {
			return "NO REGISTRADO";
		}
		return (String) mapEstados.get(this.estado);
	}// fin de getDescripcionEstado

	/*
	 * public Envio(String idEnvio,String des_tipo,String des_formato, String
	 * des_servicio,int idUsuario,String comentario){ this.des_tipo = des_tipo;
	 * this.des_formato = des_formato; this.des_servicio = des_servicio;
	 * this.idUsuario = idUsuario; this.comentario = comentario; }
	 */

	

	/**
	 * Obtiene el valor de la propiedad de idUsuario.
	 * 
	 * @return Value of property idUsuario.
	 */
	public String getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Ajusta el valor de la propiedad de idUsuario.
	 * 
	 * @param idUsuario
	 *            New value of property idUsuario.
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtiene el valor de la propiedad de comentario.
	 * 
	 * @return Value of property comentario.
	 */
	public java.lang.String getComentario() {
		if (comentario != null)
			return comentario.toUpperCase();

		return comentario;
	}

	/**
	 * Ajusta el valor de la propiedad de comentario.
	 * 
	 * @param comentario
	 *            New value of property comentario.
	 */
	public void setComentario(java.lang.String comentario) {
		this.comentario = comentario;
	}

	/**
	 * Obtiene el valor de la propiedad formato.
	 * 
	 * @return Value of property formato.
	 * 
	 */
	public String getFormato() {
		if (formato != null)
			return formato.toUpperCase();

		return formato;
	}

	/**
	 * Ajusta el valor de la propiedad formato.
	 * 
	 * @param formato
	 *            New value of property formato.
	 * 
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}

	/**
	 * Obtiene el valor de la propiedad servicio.
	 * 
	 * @return Value of property servicio.
	 * 
	 */
	public String getServicio() {
		if (servicio != null)
			return servicio.toUpperCase();

		return servicio;
	}

	/**
	 * Ajusta el valor de la propiedad servicio.
	 * 
	 * @param servicio
	 *            New value of property servicio.
	 * 
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	/**
	 * Getter for property idEnvio.
	 * 
	 * @return Value of property idEnvio.
	 * 
	 */
	public java.lang.String getIdEnvio() {
		if (idEnvio != null)
			return idEnvio.toUpperCase();

		return idEnvio;
	}

	/**
	 * Obtiene el peso amparado por la gu�a impresa convertido como entero
	 * 
	 * @return
	 */
	public int getPesoIdEnvio() {
		if (idEnvio != null) {
			if (idEnvio.trim().length()>8 ){
				
				try {
					return Integer.parseInt( idEnvio.substring(6, 8));
				}catch(Exception e){
					return 0;
				}
			}
		}
		return 0;
	}

	/**
	 * Setter for property idEnvio.
	 * 
	 * @param idEnvio
	 *            New value of property idEnvio.
	 * 
	 */
	public void setIdEnvio(java.lang.String idEnvio) {
		this.idEnvio = idEnvio;
	}

	/**
	 * Getter for property des_formato.
	 * 
	 * @return Value of property des_formato.
	 * 
	 */
	public java.lang.String getDes_formato() {
		if (des_formato != null)
			return des_formato.toUpperCase();

		return des_formato;
	}

	/**
	 * Setter for property des_formato.
	 * 
	 * @param des_formato
	 *            New value of property des_formato.
	 * 
	 */
	public void setDes_formato(java.lang.String des_formato) {
		this.des_formato = des_formato;
	}

	/**
	 * Getter for property des_servicio.
	 * 
	 * @return Value of property des_servicio.
	 * 
	 */
	public java.lang.String getDes_servicio() {
		if (des_servicio != null)
			return des_servicio.toUpperCase();

		return des_servicio;
	}

	/**
	 * Setter for property des_servicio.
	 * 
	 * @param des_servicio
	 *            New value of property des_servicio.
	 * 
	 */
	public void setDes_servicio(java.lang.String des_servicio) {
		this.des_servicio = des_servicio;
	}

	// DATOS REMITENTE

	/**
	 * Getter for property numCliente.
	 * 
	 * @return Value of property numCliente.
	 */
	public java.lang.String getNumClienteRem() {
		return this.remitente.getNumCliente();
	}

	/**
	 * Getter for property numCliente.
	 * 
	 * @return Value of property numCliente.
	 */
	public void setNumClienteRem(java.lang.String numCliente) {
		this.remitente.setNumCliente(numCliente);
	}

	/**
	 * Getter for property numCliente.
	 * 
	 * @return Value of property numCliente.
	 */
	public void setNumClienteDe(java.lang.String numCliente) {
		this.destinatario.setNumCliente(numCliente);
	}

	/**
	 * Getter for property idRmDes.
	 * 
	 * @return Value of property idRmDes.
	 */
	public String getIdRmDesRem() {
		return this.remitente.getIdRmDes();
	}
	
	public String getCorreoe() {
		return this.destinatario.getCorreoe();
	}
	
	public void setCorreoe(String correoe) {
		 this.destinatario.setCorreoe(correoe);
	}

	/**
	 * 
	 * /** Getter for property razonSocial.
	 * 
	 * @return Value of property razonSocial.
	 */
	public java.lang.String getRazonSocialRem() {
		return this.remitente.getRazonSocial();
	}

	/**
	 * Getter for property atencion.
	 * 
	 * @return Value of property atencion.
	 */
	public java.lang.String getAtencionRem() {
		return this.remitente.getAtencion();
	}

	/**
	 * Getter for property direccion.
	 * 
	 * @return Value of property direccion.
	 */
	public java.lang.String getDireccionRem() {
		return this.remitente.getDireccion();
	}

	/**
	 * Getter for property colonia.
	 * 
	 * @return Value of property colonia.
	 */
	public java.lang.String getColoniaRem() {
		return this.remitente.getColonia();
	}

	/**
	 * Getter for property ciudad.
	 * 
	 * @return Value of property ciudad.
	 */
	public java.lang.String getCiudadRem() {
		return this.remitente.getCiudad();
	}

	/**
	 * Getter for property municipio.
	 * 
	 * @return Value of property municipio.
	 */
	public java.lang.String getMunicipioRem() {
		return this.remitente.getMunicipio();
	}

	/**
	 * Getter for property estado.
	 * 
	 * @return Value of property estado.
	 */
	public java.lang.String getEstadoRem() {
		if (this.remitente != null) {
			return this.remitente.getEstado();
		}
		return "";
	}

	/**
	 * Getter for property cp.
	 * 
	 * @return Value of property cp.
	 */
	public java.lang.String getCpRem() {
		return this.remitente.getCp();
	}

	/**
	 * Getter for property telefono.
	 * 
	 * @return Value of property telefono.
	 */
	public java.lang.String getTelefonoRem() {
		return this.remitente.getTelefono();
	}

	/**
	 * Getter for property Ubicacion.
	 * 
	 * @return Value of property Ubicacion.
	 */
	public int getUbicacionRem() {
		return this.remitente.getUbicacion();
	}

	/**
	 * Getter for property oficina.
	 * 
	 * @return Value of property oficina.
	 */
	public java.lang.String getOficinaRem() {
		return this.remitente.getOficina();
	}

	/**
	 * Getter for property piso.
	 * 
	 * @return Value of property piso.
	 */
	public java.lang.String getPisoRem() {
		return this.remitente.getPiso();
	}

	// DATOS DESTINO
	/**
	 * Getter for property numCliente.
	 * 
	 * @return Value of property numCliente.
	 */
	public java.lang.String getNumClienteDe() {
		return this.destinatario.getNumCliente();
	}

	/**
	 * Getter for property idRmDes.
	 * 
	 * @return Value of property idRmDes.
	 */
	public String getIdRmDesDe() {
		return this.destinatario.getIdRmDes();
	}

	/**
	 * 
	 * /** Getter for property razonSocial.
	 * 
	 * @return Value of property razonSocial.
	 */
	public java.lang.String getRazonSocialDe() {
		return this.destinatario.getRazonSocial();
	}

	public void setRazonSocialRem(String s) {
		this.remitente.setRazonSocial(s);
	}

	/**
	 * 
	 * /** Getter for property razonSocial.
	 * 
	 * @return Value of property razonSocial.
	 */
	public void setRazonSocialDe(String s) {
		this.destinatario.setRazonSocial(s);
	}

	/**
	 * Getter for property atencion.
	 * 
	 * @return Value of property atencion.
	 */
	public java.lang.String getAtencionDe() {
		return this.destinatario.getAtencion();
	}

	/**
	 * Getter for property atencion.
	 * 
	 * @return Value of property atencion.
	 */
	public void setAtencionDe(String s) {
		this.destinatario.setAtencion(s);
	}

	public void setAtencionRem(String s) {
		this.remitente.setAtencion(s);
	}

	/**
	 * Getter for property direccion.
	 * 
	 * @return Value of property direccion.
	 */
	public java.lang.String getDireccionDe() {
		return this.destinatario.getDireccion();
	}

	/**
	 * Getter for property direccion.
	 * 
	 * @return Value of property direccion.
	 */
	public void setDireccionDe(String s) {
		this.destinatario.setDireccion(s);
	}

	public void setDireccionRem(String s) {
		this.remitente.setDireccion(s);
	}

	/**
	 * Getter for property colonia.
	 * 
	 * @return Value of property colonia.
	 */
	public java.lang.String getColoniaDe() {
		return this.destinatario.getColonia();
	}

	public void setColoniaDe(String s) {
		this.destinatario.setColonia(s);
	}

	public void setColoniaRem(String s) {
		this.remitente.setColonia(s);
	}

	/**
	 * Getter for property ciudad.
	 * 
	 * @return Value of property ciudad.
	 */
	public java.lang.String getCiudadDe() {
		return this.destinatario.getCiudad();
	}

	public void setCiudadDe(String s) {
		this.destinatario.setCiudad(s);
	}

	public void setCiudadRem(String s) {
		this.remitente.setCiudad(s);
	}

	/**
	 * Getter for property estado.
	 * 
	 * @return Value of property estado.
	 */
	public java.lang.String getEstadoDe() {
		if (this.destinatario != null) {
			return this.destinatario.getEstado();
		}
		return "";
	}

	public void setEstadoDe(String s) {
		this.destinatario.setEstado(s);
	}

	public void setEstadoRem(String s) {
		this.remitente.setEstado(s);
	}

	/**
	 * Getter for property municipio.
	 * 
	 * @return Value of property municipio.
	 */
	public String getMunicipioDe() {
		return this.destinatario.getMunicipio();
	}

	public void setMunicipioDe(String s) {
		this.destinatario.setMunicipio(s);
	}

	public void setMunicipioRem(String s) {
		this.remitente.setMunicipio(s);
	}

	/**
	 * Getter for property cp.
	 * 
	 * @return Value of property cp.
	 */
	public java.lang.String getCpDe() {
		return this.destinatario.getCp();
	}

	public void setCpDe(String s) {
		this.destinatario.setCp(s);
	}
	
	public void setRFCDe(String s) {
		this.destinatario.setRfc(s);
	}
	public String getRFCDe() {
		return this.destinatario.getRfc();
	}

	public void setCpRem(String s) {
		this.remitente.setCp(s);
	}
	
	public void setRFCRem(String s) {
		this.remitente.setRfc(s);
	}
	public String getRFCRem() {
		return this.remitente.getRfc();
	}
	/**
	 * Getter for property telefono.
	 * 
	 * @return Value of property telefono.
	 */
	public java.lang.String getTelefonoDe() {
		return this.destinatario.getTelefono();
	}

	public void setTelefonoDe(String s) {
		this.destinatario.setTelefono(s);
	}

	public void setTelefonoRem(String s) {
		this.remitente.setTelefono(s);
	}

	public void setDistribuidorRem(String s) {
		this.remitente.setDistribuidor(s);
	}

	public void setDistribuidorDe(String s) {
		this.destinatario.setDistribuidor(s);
	}

	public String getDistribuidorRem() {
		return this.remitente.getDistribuidor();
	}

	public String getDistribuidorDe() {
		return this.destinatario.getDistribuidor();
	}

	/**
	 * Getter for property Ubicacion.
	 * 
	 * @return Value of property Ubicacion.
	 */
	public int getUbicacionDe() {
		return this.destinatario.getUbicacion();
	}

	/**
	 * Getter for property oficina.
	 * 
	 * @return Value of property oficina.
	 */
	public java.lang.String getOficinaDe() {
		return this.destinatario.getOficina();
	}

	/**
	 * Getter for property piso.
	 * 
	 * @return Value of property piso.
	 */
	public java.lang.String getPisoDe() {
		return this.destinatario.getPiso();
	}

	/**
	 * Obtiene la fecha en que se esta generando la etiqueta
	 */
	public String getFecha() {
		Calendar fecha = Calendar.getInstance();
		// Da formato a la fecha
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(fecha.getTime());
		// return this.fecha;
	}

	/**
	 * Contiene la hora en que se esta generando la etiqueta
	 */
	public String getHora() {
		Calendar fecha = Calendar.getInstance();
		// Da formato a la fecha
		SimpleDateFormat formato = new SimpleDateFormat("hh:mm");
		return formato.format(fecha.getTime());
	}

	/**
	 * Getter for property ubicacion.
	 * 
	 * @return Value of property ubicacion.
	 * 
	 */
	public java.lang.String getUbicacion() {
		if (ubicacion != null)
			return ubicacion.toUpperCase();

		return ubicacion;
	}

	/**
	 * Setter for property ubicacion.
	 * 
	 * @param ubicacion
	 *            New value of property ubicacion.
	 * 
	 */
	public void setUbicacion(java.lang.String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * Getter for property destinos.
	 * 
	 * @return Value of property destinos.
	 * 
	 */
	public java.lang.String getDestinos() {
		return destinos;
	}

	/**
	 * Setter for property destinos.
	 * 
	 * @param destinos
	 *            New value of property destinos.
	 * 
	 */
	public void setDestinos(java.lang.String destinos) {
		this.destinos = destinos;
	}

	/**
	 * Getter for property ar_destinos.
	 * 
	 * @return Value of property ar_destinos.
	 * 
	 */
	public java.lang.String[] getAr_destinos() {
		return this.ar_destinos;
	}

	/**
	 * Setter for property ar_destinos.
	 * 
	 * @param ar_destinos
	 *            New value of property ar_destinos.
	 * 
	 */
	public void setAr_destinos(java.lang.String[] ar_destinos) {
		this.ar_destinos = ar_destinos;
	}

	/**
	 * Getter for property objetos.
	 * 
	 * @return Value of property objetos.
	 * 
	 */
	public java.util.ArrayList getObjetos() {
		return objetos;
	}

	/**
	 * Setter for property objetos.
	 * 
	 * @param objetos
	 *            New value of property objetos.
	 * 
	 */
	public void setObjetos(java.util.ArrayList objetos) {
		this.objetos = objetos;
	}

	/**
	 * Getter for property ruta.
	 * 
	 * @return Value of property ruta.
	 * 
	 */
	public java.lang.String getRuta() {
		if (ruta != null)
			return ruta.toUpperCase();

		return ruta;
	}

	public String getRutaEntrega() {
		return this.confirmacion.getRuta();
	}

	/**
	 * Setter for property ruta.
	 * 
	 * @param ruta
	 *            New value of property ruta.
	 * 
	 */
	public void setRuta(java.lang.String ruta) {
		this.ruta = ruta;
	}

	/**
	 * Setter for property fecha.
	 * 
	 * @param fecha
	 *            New value of property fecha.
	 * 
	 */
	// public void setFecha(java.lang.String fecha) {
	// this.fecha = fecha;
	// }
	/**
	 * Obtiene el valor de la propiedad de fechaConfirmacion.
	 * 
	 * @return Value of property fechaConfirmacion.
	 */
	public java.lang.String getFechaConfirmacion() {
		return this.confirmacion.getFechaConfirmacion();
	}

	/**
	 * Obtiene la hora de confirmacion
	 * 
	 * @return Value of property fechaConfirmacion.
	 */
	public java.lang.String getHoraConfirmacion() {
		return this.confirmacion.getHoraCorta();
	}

	/**
	 * Ontiene los minutos de confirmacion
	 * 
	 * @return Value of property fechaConfirmacion.
	 */
	public java.lang.String getMinutosConfirmacion() {
		return this.confirmacion.getMinutosCorta();
	}

	/**
	 * Obtiene la fecha corta de confirmaci�n
	 * 
	 * @return Value of property fechaConfirmacion.
	 */
	public java.lang.String getFechaCortaConfirmacion() {
		return this.confirmacion.getFechaCorta();
	}

	/**
	 * Obtiene el valor de la propiedad de quienRecibe.
	 * 
	 * @return Value of property quienRecibe.
	 */
	public java.lang.String getQuienRecibe() {
		return this.confirmacion.getQuienRecibe();
	}

	/**
	 * Getter for property fechaCreacion.
	 * 
	 * @return Value of property fechaCreacion.
	 * 
	 */
	public java.lang.String getFechaCreacion() {
		if (fechaCreacion == null)
			return ""; // return "P R E I M P R E S A";

		return fechaCreacion;
	}

	/**
	 * Setter for property fechaCreacion.
	 * 
	 * @param fechaCreacion
	 *            New value of property fechaCreacion.
	 * 
	 */
	public void setFechaCreacion(java.lang.String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Getter for property Ubicacion.
	 * 
	 * @return Value of property Ubicacion.
	 * 
	 */
	public int getRemUbicacion() {
		return this.remitente.getUbicacion();
	}

	/**
	 * Getter for property Ubicacion.
	 * 
	 * @return Value of property Ubicacion.
	 * 
	 */
	public int getDesUbicacion() {
		return this.destinatario.getUbicacion();
	}

	/**
	 * Getter for property descentrocosto.
	 * 
	 * @return Value of property descentrocosto.
	 */
	public java.lang.String getDescentrocosto() {
		if (descentrocosto != null)
			return descentrocosto.toUpperCase();

		return descentrocosto;
	}

	/**
	 * Setter for property descentrocosto.
	 * 
	 * @param descentrocosto
	 *            New value of property descentrocosto.
	 */
	public void setDescentrocosto(java.lang.String descentrocosto) {
		this.descentrocosto = descentrocosto;
	}

	public String getIdCodigoBarras() {
		return idBarras.toUpperCase();
	}// fin de getIdCodigoBarras

	/**
	 * Setter for property descentrocosto.
	 * 
	 * @param descentrocosto
	 *            New value of property descentrocosto.
	 */
	public String getIdBarras() {
		idBarras = null;
		if (idBarras != null) {
			return idBarras.toUpperCase();
		} else {
			setIdBarras();
		}
		return this.idBarras.toUpperCase();
	}

	/**
	 * Setter for property idBarras.
	 * 
	 * @param idBarras
	 *            New value of property idBarras.
	 */
	public void setIdBarras() {
		Calendar fecha = Calendar.getInstance();
		// Da formato a la fecha
		SimpleDateFormat formato = new SimpleDateFormat("hhmmssSS");
		this.idBarras = formato.format(fecha.getTime());
	}

	/**
	 * Getter for property rutaRemitente.
	 * 
	 * @return Value of property rutaRemitente.
	 */
	public java.lang.String getRutaRemitente() {
		if (rutaRemitente != null)
			return rutaRemitente.toUpperCase();

		return rutaRemitente;
	}

	/**
	 * Setter for property rutaRemitente.
	 * 
	 * @param rutaRemitente
	 *            New value of property rutaRemitente.
	 */
	public void setRutaRemitente(java.lang.String rutaRemitente) {
		this.rutaRemitente = rutaRemitente;
	}

	/**
	 * Getter for property fechaCorta.
	 * 
	 * @return Value of property fechaCorta.
	 */
	public java.lang.String getFechaCorta() {
		return fechaCorta;
	}

	/**
	 * Setter for property fechaCorta.
	 * 
	 * @param fechaCorta
	 *            New value of property fechaCorta.
	 */
	public void setFechaCorta(java.lang.String fechaCorta) {
		this.fechaCorta = fechaCorta;
	}

	/**
	 * Getter for property horaCorta.
	 * 
	 * @return Value of property horaCorta.
	 */
	public java.lang.String getHoraCorta() {
		if (horaCorta == null)
			horaCorta = "";

		while (horaCorta.length() < 2) {
			horaCorta = 0 + horaCorta;
		}

		return horaCorta;
	}

	/**
	 * Setter for property horaCorta.
	 * 
	 * @param horaCorta
	 *            New value of property horaCorta.
	 */
	public void setHoraCorta(java.lang.String horaCorta) {
		this.horaCorta = horaCorta;
	}

	/**
	 * Getter for property minutosCorta.
	 * 
	 * @return Value of property minutosCorta.
	 */
	public java.lang.String getMinutosCorta() {
		if (minutosCorta == null)
			minutosCorta = "";

		while (minutosCorta.length() < 2) {
			minutosCorta = 0 + minutosCorta;
		}
		return minutosCorta;
	}

	/**
	 * Setter for property minutosCorta.
	 * 
	 * @param minutosCorta
	 *            New value of property minutosCorta.
	 */
	public void setMinutosCorta(java.lang.String minutosCorta) {
		this.minutosCorta = minutosCorta;
	}

	/**
	 * Getter for property breakPage.
	 * 
	 * @return Value of property breakPage.
	 */
	public java.lang.String getBreakPage() {
		return breakPage;
	}

	/**
	 * Setter for property breakPage.
	 * 
	 * @param breakPage
	 *            New value of property breakPage.
	 */
	public void setBreakPage(java.lang.String breakPage) {
		this.breakPage = breakPage;
	}

	/**
	 * Getter for property garantia.
	 * 
	 * @return Value of property garantia.
	 */
	public java.lang.String getGarantia() {
		return garantia;
	}

	/**
	 * Setter for property garantia.
	 * 
	 * @param garantia
	 *            New value of property garantia.
	 */
	public void setGarantia(java.lang.String garantia) {
		this.garantia = garantia;
	}

	/**
	 * Getter for property adicional.
	 * 
	 * @return Value of property adicional.
	 */
	public java.lang.String getAdicional() {
		return adicional;
	}

	/**
	 * Setter for property adicional.
	 * 
	 * @param adicional
	 *            New value of property adicional.
	 */
	public void setAdicional(java.lang.String adicional) {
		this.adicional = adicional;
	}

	/**
	 * Getter for property referencia.
	 * 
	 * @return Value of property referencia.
	 */
	public java.lang.String getReferencia() {
		return referencia;
	}

	/**
	 * Setter for property referencia.
	 * 
	 * @param referencia
	 *            New value of property referencia.
	 */
	public void setReferencia(java.lang.String referencia) {
		this.referencia = referencia;
	}

	/**
	 * Getter for property multiples.
	 * 
	 * @return Value of property multiples.
	 */
	public java.lang.String getMultiples() {
		if (multiples == null)
			return "";

		return multiples.toUpperCase();
	}

	/**
	 * Setter for property multiples.
	 * 
	 * @param multiples
	 *            New value of property multiples.
	 */
	public void setMultiples(java.lang.String multiples) {
		
		this.multiples = multiples;
	}

	/**
	 * Getter for property contenido.
	 * 
	 * @return Value of property contenido.
	 */
	public java.lang.String getContenido() {
		return contenido;
	}

	/**
	 * Setter for property contenido.
	 * 
	 * @param contenido
	 *            New value of property contenido.
	 */
	public void setContenido(java.lang.String contenido) {
		this.contenido = contenido;
	}

	/**
	 * Getter for property peso.
	 * 
	 * @return Value of property peso.
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * Setter for property peso.
	 * 
	 * @param peso
	 *            New value of property peso.
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void setPeso(String peso) {
		try {
			this.peso = Integer.parseInt(peso);
		} catch (Exception e) {
			this.peso = 0;
		}
	}

	/**
	 * Getter for property cantidad.
	 * 
	 * @return Value of property cantidad.
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Setter for property cantidad.
	 * 
	 * @param cantidad
	 *            New value of property cantidad.
	 */
	public void setCantidad(int cantidad) {

		this.cantidad = cantidad;
	}

	public void setCantidad(String cantidad) {
		try {
			this.cantidad = Integer.parseInt(cantidad);
		} catch (Exception e) {
			this.cantidad = 0;
		}
	}

	/**
	 * Getter for property observa1.
	 * 
	 * @return Value of property observa1.
	 */
	public java.lang.String getObserva1() {
		return observa1;
	}

	/**
	 * Setter for property observa1.
	 * 
	 * @param observa1
	 *            New value of property observa1.
	 */
	public void setObserva1(java.lang.String observa1) {
		this.observa1 = observa1;
	}

	/**
	 * Getter for property observa2.
	 * 
	 * @return Value of property observa2.
	 */
	public java.lang.String getObserva2() {
		return observa2;
	}

	/**
	 * Setter for property observa2.
	 * 
	 * @param observa2
	 *            New value of property observa2.
	 */
	public void setObserva2(java.lang.String observa2) {
		this.observa2 = observa2;
	}

	/**
	 * Getter for property des_adicional.
	 * 
	 * @return Value of property des_adicional.
	 */
	public java.lang.String getDes_adicional() {
		return des_adicional;
	}

	/**
	 * Setter for property des_adicional.
	 * 
	 * @param des_adicional
	 *            New value of property des_adicional.
	 */
	public void setDes_adicional(java.lang.String des_adicional) {
		this.des_adicional = des_adicional;
	}

	/**
	 * Getter for property des_garantia.
	 * 
	 * @return Value of property des_garantia.
	 */
	public java.lang.String getDes_garantia() {
		return des_garantia;
	}

	/**
	 * Setter for property des_garantia.
	 * 
	 * @param des_garantia
	 *            New value of property des_garantia.
	 */
	public void setDes_garantia(java.lang.String des_garantia) {
		this.des_garantia = des_garantia;
	}

	/**
	 * Getter for property siglasOrigen.
	 * 
	 * @return Value of property siglasOrigen.
	 */
	public java.lang.String getSiglasOrigen() {
		if (this.siglasOrigen == null)
			return "";
		return this.siglasOrigen;
	}

	/**
	 * Setter for property siglasOrigen.
	 * 
	 * @param siglasOrigen
	 *            New value of property siglasOrigen.
	 */
	public void setSiglasOrigen(java.lang.String siglasOrigen) {
		this.siglasOrigen = siglasOrigen;
	}

	/**
	 * Getter for property siglasDestino.
	 * 
	 * @return Value of property siglasDestino.
	 */
	public java.lang.String getSiglasDestino() {
		if (this.siglasDestino == null)
			return "";
		return siglasDestino;
	}

	/**
	 * Setter for property siglasDestino.
	 * 
	 * @param siglasDestino
	 *            New value of property siglasDestino.
	 */
	public void setSiglasDestino(java.lang.String siglasDestino) {
		this.siglasDestino = siglasDestino;
	}

	/**
	 * Getter for property historia.
	 * 
	 * @return Value of property historia.
	 */
	public java.util.ArrayList getHistoria() {
		return historia;
	}

	/**
	 * Setter for property historia.
	 * 
	 * @param historia
	 *            New value of property historia.
	 */
	public void setHistoria(java.util.ArrayList historia) {
		this.historia = historia;
	}

	/**
	 * Getter for property tipoRotulo.
	 * 
	 * @return Value of property tipoRotulo.
	 */
	public int getTipoRotulo() {
		return tipoRotulo;
	}

	/**
	 * Setter for property tipoRotulo.
	 * 
	 * @param tipoRotulo
	 *            New value of property tipoRotulo.
	 */
	public void setTipoRotulo(int tipoRotulo) {
		this.tipoRotulo = tipoRotulo;
	}

	/**
	 * Getter for property factura.
	 * 
	 * @return Value of property factura.
	 */
	public java.lang.String getFactura() {
		return this.factura;
	}

	/**
	 * Setter for property factura., la factura tiene un largo de 5 caracteres
	 * bajo el formato de : 99999 ejemplo: 00001
	 * 
	 * @param logo
	 *            New value of property factura.
	 */
	public void setFactura(java.lang.String factura) {
		/*
		 * if (factura!=null){ factura=factura.trim();
		 * 
		 * while (factura.trim().length()<_LARGO_FACTURA){
		 * factura="0"+factura.trim(); } }
		 */
		this.factura = factura;
	}

	/**
	 * Getter for property logo.
	 * 
	 * @return Value of property logo.
	 */
	public java.lang.String getLogo() {

    	if ((logo == null) || (logo.trim().length()<=0)) {
			return "logoInferior.gif";
		}
        return logo.trim();
	}

	/**
	 * Setter for property logo.
	 * 
	 * @param logo
	 *            New value of property logo.
	 */
	public void setLogo(java.lang.String logo) {
		this.logo = logo;
	}

	/**
	 * Getter for property login.
	 * 
	 * @return Value of property login.
	 */
	public java.lang.String getLogin() {
		return login;
	}

	/**
	 * Setter for property login.
	 * 
	 * @param login
	 *            New value of property login.
	 */
	public void setLogin(java.lang.String login) {
		this.login = login;
	}

	/**
	 * Getter for property posicion.
	 * 
	 * @return Value of property posicion.
	 */
	public java.lang.String getPosicion() {
		if (posicion == null) {
			posicion = "";
		}

		// formate a el numero a 9999
		while (posicion.length() < 4) {
			posicion = "0" + posicion.trim();
		}
		return posicion;

	}

	/**
	 * Setter for property posicion.
	 * 
	 * @param posicion
	 *            New value of property posicion.
	 */
	public void setPosicion(java.lang.String posicion) {
		this.posicion = posicion;
	}

	/**
	 * Getter for property folios.
	 * 
	 * @return Value of property folios.
	 */
	public java.util.ArrayList getFolios() {
		return folios;
	}

	/**
	 * Setter for property folios.
	 * 
	 * @param folios
	 *            New value of property folios.
	 */
	public void setFolios(java.util.ArrayList folios) {
		this.folios = folios;
	}

	/**
	 * Getter for property origenRegistro.
	 * 
	 * @return Value of property origenRegistro.
	 */
	public java.lang.String getOrigenRegistro() {
		return origenRegistro;
	}

	/**
	 * Setter for property origenRegistro.
	 * 
	 * @param origenRegistro
	 *            New value of property origenRegistro.
	 */
	public void setOrigenRegistro(java.lang.String origenRegistro) {
		this.origenRegistro = origenRegistro;
	}

	/**
	 * Getter for property siglasPlaza.
	 * 
	 * @return Value of property siglasPlaza.
	 */
	public java.lang.String getSiglasPlaza() {
		return siglasPlaza;
	}

	/**
	 * Setter for property siglasPlaza.
	 * 
	 * @param siglasPlaza
	 *            New value of property siglasPlaza.
	 */
	public void setSiglasPlaza(java.lang.String siglasPlaza) {
		this.siglasPlaza = siglasPlaza;
	}

	/**
	 * Si el estado del ewnvio es W sustituye el caracter de tipo de actual por
	 * W <br>
	 * ejemplo: <br>
	 * 0101B2300001236 a 0101W2300001236
	 * 
	 */
	public String getGuiaDevolucion() {

		if (this.estado == null) {
			return "";
		}

		// Regresa la misma guia pero con el tipo de servicio de devolucion
		if (this.estado.equals(_devolucion)) {
			StringBuffer sb = new StringBuffer();
			sb.append(this.idEnvio);
			sb.setCharAt(4, 'W');
			return sb.toString();
		}
		return "";
	}

	/**
	 * Getter for property monto.
	 * 
	 * @return Value of property monto.
	 */
	public double getMonto() {
		return monto;
	}

	
	public double getMontoAsegurado() {
		return montoAsegurado;
	}

	public void setMontoAsegurado(double montoAsegurado) {
		this.montoAsegurado = montoAsegurado;
	}
	
	public void setMontoAsegurado(String monto) {
		try {
			this.montoAsegurado = Double.parseDouble(monto);
		} catch (Exception e) {
			this.montoAsegurado = 0.0;
		}
	}
	
	public String getRoundMontoAsegurado() {
		return round(this.montoAsegurado, 2) + "";
	}
	
	/**
	 * Redondea los datos de un float para que solo regrese una cantidad
	 * determinada de decimales
	 */
	public float round(double f, int i) {
		double d = Math.pow(10.0, (double) i);
		double aux = f * d;
		int auxi = (int) aux;
		float df = auxi / ((float) d);
		return df;
	}

	
	/**
	 * Regresa la informacion del monto redondeada a  decimales 
	 * 
	 **/
	public String getRound() {
		return round(this.monto, 2) + "";
	}

	/**
	 * Setter for property monto.
	 * 
	 * @param monto
	 *            New value of property monto.
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}

	public void setMonto(String monto) {
		try {
			this.monto = Double.parseDouble(monto);
		} catch (Exception e) {
			this.monto = 0.0;
		}
	}

	/**
	 * Getter for property tipo_Envio.
	 * 
	 * @return Value of property tipo_Envio.
	 */
	public int getTipo_Envio() {
		return tipo_Envio;
	}

	/**
	 * Setter for property tipo_Envio.
	 * 
	 * @param tipo_Envio
	 *            New value of property tipo_Envio.
	 */
	public void setTipo_Envio(int tipo_Envio) {
		this.tipo_Envio = tipo_Envio;
	}

	/**
	 * Getter for property s_monto.
	 * 
	 * @return Value of property s_monto.
	 */
	public java.lang.String getS_monto() {
		return s_monto;
	}

	/**
	 * Setter for property s_monto.
	 * 
	 * @param s_monto
	 *            New value of property s_monto.
	 */
	public void setS_monto(java.lang.String s_monto) {
		this.s_monto = s_monto;
	}

	/**
	 * Getter for property pathFile.
	 * 
	 * @return Value of property pathFile.
	 */
	public java.lang.String getPathFile() {
		return pathFile;
	}

	/**
	 * Setter for property pathFile.
	 * 
	 * @param pathFile
	 *            New value of property pathFile.
	 */
	public void setPathFile(java.lang.String pathFile) {
		this.pathFile = pathFile;
	}

	/**
	 * Getter for property empresa_recolecta.
	 * 
	 * @return Value of property empresa_recolecta.
	 */
	public java.lang.String getEmpresa_recolecta() {
		return this.remitente.getEmpresa_recolecta();
	}

	/**
	 * Getter for property vobo_carta.
	 * 
	 * @return Value of property vobo_carta.
	 */
	public java.lang.String getVobo_carta() {
		return this.remitente.getVobo_carta();
	}

	/**
	 * Getter for property representate_empresa_recolecta.
	 * 
	 * @return Value of property representate_empresa_recolecta.
	 */
	public java.lang.String getRepresentate_empresa_recolecta() {
		return this.remitente.getRepresentate_empresa_recolecta();
	}

	/**
	 * Getter for property empresa_remite_carta.
	 * 
	 * @return Value of property empresa_remite_carta.
	 */
	public java.lang.String getEmpresa_remite_carta() {

		return this.remitente.getEmpresa_remite_carta();
	}

	/**
	 * Getter for property folio.
	 * 
	 * @return Value of property folio.
	 */
	public java.lang.String getFolio() {
		return this.remitente.getFolio();
	}

	/**
	 * Getter for property guiaMadre.
	 * 
	 * @return Value of property guiaMadre.
	 */
//	public java.lang.String getGuiaMadre() {
//		return guiaMadre;
//	}

	/**
	 * Setter for property guiaMadre.
	 * 
	 * @param guiaMadre
	 *            New value of property guiaMadre.
	 */
	public void setEsMadre(java.lang.String esMadre) {
		this.esMadre = esMadre;
	}
	
	/**
	 * Getter for property guiaMadre.
	 * 
	 * @return Value of property guiaMadre.
	 */
	public java.lang.String getesMadre() {
		return esMadre;
	}

	/**
	 * Setter for property guiaMadre.
	 * 
	 * @param guiaMadre
	 *            New value of property guiaMadre.
	 */
//	public void setGuiaMadre(java.lang.String guiaMadre) {
//		this.guiaMadre = guiaMadre;
//	}
	
	/**
	 * Getter for property cantAsegurada.
	 * 
	 * @return Value of property cantAsegurada.
	 */
	public float getCantAsegurada() {
		return cantAsegurada;
	}

	/**
	 * Setter for property cantAsegurada.
	 * 
	 * @param cantAsegurada
	 *            New value of property cantAsegurada.
	 */
	public void setCantAsegurada(float cantAsegurada) {
		this.cantAsegurada = cantAsegurada;
	}

	public void setCantAsegurada(String cantAsegurada) {
		try {
			this.cantAsegurada = Float.parseFloat(cantAsegurada);
		} catch (Exception e) {
			this.cantAsegurada = 0;
		}

	}

	/**
	 * Toma la fecha de creacion y regresa una representacion en un objeto de
	 * tipo Date, en caso de que error regresa un objeto null. La fecha esta en
	 * formato dd/mm/aaaa
	 * 
	 * @return una intrsnacia del objeto de tipo java.sql.Date
	 */
	public java.sql.Date getFechaCreacionDate() {

		if ((fechaCreacion == null) || (fechaCreacion.trim().length() <= 0)) {
			return null;
		}

		try {
			if (fechaCreacion.split("/").length >= 3) {
				java.sql.Date sqlDate = new java.sql.Date(0000 - 00 - 00);
				return sqlDate.valueOf(this.fechaCreacion.split("/")[2] + "-"
						+ this.fechaCreacion.split("/")[1] + "-"
						+ this.fechaCreacion.split("/")[0]);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	/**
	 * Getter for property idClase.
	 * 
	 * @return Value of property idClase.
	 */
	public java.lang.String getIdClase() {
		return idClase;
	}

	/**
	 * Setter for property idClase.
	 * 
	 * @param idClase
	 *            New value of property idClase.
	 */
	public void setIdClase(java.lang.String idClase) {
		this.idClase = idClase;
	}

	/**
	 * Getter for property idGrupo.
	 * 
	 * @return Value of property idGrupo.
	 */
	public java.lang.String getIdGrupo() {
		return idGrupo;
	}

	/**
	 * Setter for property idGrupo.
	 * 
	 * @param idGrupo
	 *            New value of property idGrupo.
	 */
	public void setIdGrupo(java.lang.String idGrupo) {
		this.idGrupo = idGrupo;
	}

	/**
	 * Getter for property idGestion.
	 * 
	 * @return Value of property idGestion.
	 */
	public java.lang.String getIdGestion() {
		return idGestion;
	}

	/**
	 * Setter for property idGestion.
	 * 
	 * @param idGestion
	 *            New value of property idGestion.
	 */
	public void setIdGestion(java.lang.String idGestion) {
		this.idGestion = idGestion;
	}

	/**
	 * Getter for property idMedida.
	 * 
	 * @return Value of property idMedida.
	 */
	public java.lang.String getIdMedida() {
		return idMedida;
	}

	/**
	 * Setter for property idMedida.
	 * 
	 * @param idMedida
	 *            New value of property idMedida.
	 */
	public void setIdMedida(java.lang.String idMedida) {
		this.idMedida = idMedida;
	}

	/**
	 * Getter for property serie.
	 * 
	 * @return Value of property serie.
	 */
	public java.lang.String getSerie() {
		return serie;
	}

	/**
	 * Setter for property serie.
	 * 
	 * @param serie
	 *            New value of property serie.
	 */
	public void setSerie(java.lang.String serie) {
		this.serie = serie;
	}

	/** **************** Datos del pagare ************************ */
	/**
	 * Getter for property division.
	 * 
	 * @return Value of property division.
	 */
	public java.lang.String getDivision() {
		return pagare.getDivision();
	}

	/**
	 * Setter for property division.
	 * 
	 * @param division
	 *            New value of property division.
	 */
	public void setDivision(java.lang.String division) {
		pagare.setDivision(division);
	}

	/**
	 * Getter for property modelo.
	 * 
	 * @return Value of property modelo.
	 */
	public java.lang.String getModelo() {
		return pagare.getModelo();
	}

	/**
	 * Setter for property modelo.
	 * 
	 * @param modelo
	 *            New value of property modelo.
	 */
	public void setModelo(java.lang.String modelo) {
		pagare.setModelo(modelo);
	}

	/**
	 * Getter for property origen.
	 * 
	 * @return Value of property origen.
	 */
	public java.lang.String getOrigen() {
		return pagare.getOrigen();
	}

	/**
	 * Setter for property origen.
	 * 
	 * @param origen
	 *            New value of property origen.
	 */
	public void setOrigen(java.lang.String origen) {
		pagare.setOrigen(origen);
	}

	/**
	 * Getter for property area.
	 * 
	 * @return Value of property area.
	 */
	public java.lang.String getArea() {
		return pagare.getArea();
	}

	/**
	 * Setter for property area.
	 * 
	 * @param area
	 *            New value of property area.
	 */
	public void setArea(java.lang.String area) {
		pagare.setArea(area);
	}

	/**
	 * Getter for property sku.
	 * 
	 * @return Value of property sku.
	 */
	public java.lang.String getSku() {
		return pagare.getSku();
	}

	/**
	 * Setter for property sku.
	 * 
	 * @param sku
	 *            New value of property sku.
	 */
	public void setSku(java.lang.String sku) {
		pagare.setSku(sku);
	}

	/**
	 * Getter for property nPlan.
	 * 
	 * @return Value of property nPlan.
	 */
	public java.lang.String getNPlan() {
		return pagare.getNPlan();
	}

	/**
	 * Setter for property nPlan.
	 * 
	 * @param nPlan
	 *            New value of property nPlan.
	 */
	public void setNPlan(java.lang.String nPlan) {
		pagare.setNPlan(nPlan);
	}

	/**
	 * Getter for property montoMensualidad.
	 * 
	 * @return Value of property montoMensualidad.
	 */
	public java.lang.String getMontoMensualidad() {
		return pagare.getMontoMensualidad();
	}

	/**
	 * Getter for property montoString.
	 * 
	 * @return Value of property montoString.
	 */
	public java.lang.String getMontoString() {
		return pagare.getMontoString();
	}

	/**
	 * Setter for property montoMensualidad.
	 * 
	 * @param montoMensualidad
	 *            New value of property montoMensualidad.
	 */
	public void setMontoMensualidad(java.lang.String montoMensualidad) {
		pagare.setMontoMensualidad(montoMensualidad);
	}

	/**
	 * Getter for property numeroSerie.
	 * 
	 * @return Value of property numeroSerie.
	 */
	public java.lang.String getNumeroSerie() {
		return pagare.getNumeroSerie();
	}

	/**
	 * Setter for property numeroSerie.
	 * 
	 * @param numeroSerie
	 *            New value of property numeroSerie.
	 */
	public void setNumeroSerie(java.lang.String numeroSerie) {
		pagare.setNumeroSerie(numeroSerie);
	}

	/**
	 * Getter for property crea_Pagare.
	 * 
	 * @return Value of property crea_Pagare.
	 */
	public boolean isCrea_Pagare() {
		return crea_Pagare;
	}

	/**
	 * Setter for property crea_Pagare.
	 * 
	 * @param crea_Pagare
	 *            New value of property crea_Pagare.
	 */
	public void setCrea_Pagare(boolean crea_Pagare) {
		this.crea_Pagare = crea_Pagare;
	}

	/** Devuelve los datos del producto para el JSONObject */
	public JSONObject toJSONObject() throws Exception {

		JSONObject json = new JSONObject();
		json.put("idEnvio", this.idEnvio);
		json.put("embarque", this.idEnvio);
		json.put("idUsuario", this.idUsuario);
		json.put("numCliente", this.destinatario.getNumCliente());
		json.put("razonSocial", this.destinatario.getRazonSocial());
		json.put("atencion", this.destinatario.getAtencion());
		json.put("direccion", this.destinatario.getDireccion());
		json.put("colonia", this.destinatario.getColonia());
		json.put("municipio", this.destinatario.getMunicipio());
		json.put("estado", this.destinatario.getEstado());
		json.put("cp", this.destinatario.getCp());
		json.put("telefono", this.destinatario.getTelefono());
		json.put("fax", this.destinatario.getFax());
		json.put("activo", this.destinatario.getActivo());
		json.put("referencia", this.destinatario.getRefdomicilio());
		json.put("fechaCreacion", this.fechaCreacion);
		json.put("fechaentrega", this.confirmacion.getFechaConfirmacion());
		json.put("recibe", this.confirmacion.getQuienRecibe());

		return json;
	}

	/** Devuelve los datos del producto para el JSONObject */
	public JSONObject toJSONObjectEnvioImportado() throws Exception {

		JSONObject json = new JSONObject();

		// Remitente
		json.put("razonSocialRem", this.remitente.getRazonSocial());
		json.put("atencionRem", this.remitente.getAtencion());
		json.put("direccionRem", this.remitente.getDireccion());
		json.put("coloniaRem", this.remitente.getColonia());
		json.put("municipioRem", this.remitente.getMunicipio());
		json.put("estadoRem", this.remitente.getEstado());
		json.put("estadoRem", this.remitente.getCiudad());
		json.put("cpRem", this.remitente.getCp());
		json.put("telefonoRem", this.remitente.getTelefono());
		json.put("faxRem", this.remitente.getFax());

		// Destinatario
		json.put("razonSocialDe", this.destinatario.getRazonSocial());
		json.put("atencionDe", this.destinatario.getAtencion());
		json.put("direccionDe", this.destinatario.getDireccion());
		json.put("coloniaDe", this.destinatario.getColonia());
		json.put("municipioDe", this.destinatario.getMunicipio());
		json.put("estadoRem", this.destinatario.getCiudad());
		json.put("estadoDe", this.destinatario.getEstado());
		json.put("cpDe", this.destinatario.getCp());
		json.put("telefonoDe", this.destinatario.getTelefono());
		json.put("faxDe", this.destinatario.getFax());

		// Datos Envios
		json.put("cantidad", this.cantidad);
		json.put("referencia", this.referencia);
		json.put("comentario", this.comentario);
		json.put("multiples", this.multiples);
		json.put("peso", this.peso);
		json.put("peso_volumetrico", this.peso_volumetrico);
		json.put("pesoBas", this.pesoBas);
		json.put("cantAsegurada", this.cantAsegurada);

		return json;
	}

	public String getTipoInf() {
		if (tipoInf == null)
			return "?"; // Si no tiene ningun datos devuelve una interrogacion
		return tipoInf;
	}

	public void setTipoInf(String tipoInf) {
		this.tipoInf = tipoInf;
	}

	public boolean isPreimpresa() {
		return preimpresa;
	}

	public void setPreimpresa(boolean preimpresa) {
		this.preimpresa = preimpresa;
	}
	
	/**
	 * @param ocurre
	 *            the ocurre to set
	 */
	public void setPreimpresa(String preimpresa) {
		this.preimpresa = ((preimpresa != null) && (preimpresa.trim().toLowerCase()
				.equals("true"))) ? true : false;
	}

	public String getEstatus() {
		if (this.estatus == null)
			return "E";
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getPersistente() {
		return persistente;
	}

	public void setPersistente(boolean persistente) {
		if (persistente) {
			this.persistente = 1; // el registro es persistente
		} else {
			this.persistente = 0; // el registro no es persistente
		}
	}

	public String getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}

	public String getIdLLaveImport() {
		return idLLaveImport;
	}

	public void setIdLLaveImport(String idLLaveImport) {
		this.idLLaveImport = idLLaveImport;
	}

	// Arma los datos en una cadena
	public String getInfoEnvio(Envio envio) {
		String multiple = envio.getMultiples()==null?"":envio.getMultiples();
		if ("N".equals(envio.getMultiples())){
			envio.setMultiples("");
		}
		String str_envio = envio.getIdEnvio() + "|"
				+ checaNull(envio.getRuta()) + "|"
				+ checaNull(envio.getDes_servicio()) + "|"
				+ checaNull(envio.remitente.getRazonSocial()) + "|"
				+ checaNull(envio.remitente.getAtencion()) + "|"
				+ checaNull(envio.remitente.getDireccion()) + "|"
				+ checaNull(envio.remitente.getColonia()) + "|"
				+ checaNull(envio.remitente.getMunicipio()) + "|"
				+ checaNull(envio.remitente.getEstado()) + "|"
				+ checaNull(envio.remitente.getCp()) + "|"
				+ checaNull(envio.remitente.getTelefono()) + "|"
				+ checaNull(envio.destinatario.getRazonSocial()) + "|"
				+ checaNull(envio.destinatario.getAtencion()) + "|"
				+ checaNull(envio.destinatario.getDireccion()) + "|"
				+ checaNull(envio.destinatario.getColonia()) + "|"
				+ checaNull(envio.destinatario.getMunicipio()) + "|"
				+ checaNull(envio.destinatario.getEstado()) + "|"
				+ checaNull(envio.destinatario.getCp()) + "|"
				+ checaNull(envio.destinatario.getTelefono()) + "|"
				+ checaNull(envio.getContenido()) + "|" + envio.getPeso() + "|"
				+ checaNull(envio.getComentario()) + "|"
				+ checaNull(envio.getMultiples()) + "|" + envio.getCantidad()
				+ "|" + checaNull(envio.getReferencia()) + "|"
				+ envio.getMonto() + "|" + envio.getCantAsegurada() + "|"
				+ envio.getEnrutadoPor() + "|" + envio.isAcuse() + "|"
				+ envio.getSiglasOrigen() + "|" + envio.getSiglasDestino()
				+ "|" + envio.getLogo() + "|"
				+ checaNull(envio.getDes_garantia()) + "|"
				+ checaNull(getNumCliente()) + "|" + checaNull(getObserva1())
				+ "|" + isOcurre() + "|"  + alto+ "|" +ancho+ "|" + largo +  "\n";
		
		String[] arr =  str_envio.split("\\|");

		for (int i = 0; i < arr.length; i++) {
			//System.out.println("arr[" + i + "]="+ arr[i]);
		}
		return str_envio;
	}

	public String getInfoEnvio() {
		return getInfoEnvio(this);
	}

	private static String checaNull(String str) {
		// Verifica si es null
		if (str == null) {
			return "";
		}

		// reemplaza los caracters de enter por espacios
		return quitoSignos(str);
	}

	private static String quitoSignos(String cadena) {
		if (cadena==null) return cadena;
		   cadena = cadena.trim();
				 
			String output = 	Normalizer
				    .normalize(cadena, Normalizer.Form.NFD)
				    .replaceAll("[^\\p{ASCII}]", "");
					
			return output;

	}

	/**
	 * @return the msgError
	 */
	public String getMsgError() {
		return msgError;
	}

	/**
	 * @param msgError
	 *            the msgError to set
	 */
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

	/**
	 * @return the formapago
	 */
	public String getFormapago() {
		return formapago;
	}

	/**
	 * @param formapago
	 *            the formapago to set
	 */
	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}

	/**
	 * @return the des_formapago
	 */
	public String getDes_formapago() {
		return des_formapago;
	}

	/**
	 * @param des_formapago
	 *            the des_formapago to set
	 */
	public void setDes_formapago(String des_formapago) {
		this.des_formapago = des_formapago;
	}

	/**
	 * @return the ocurre
	 */
	public boolean isOcurre() {
		return ocurre;
	}

	/**
	 * @param ocurre
	 *            the ocurre to set
	 */
	public void setOcurre(boolean ocurre) {
		this.ocurre = ocurre;
	}

	/**
	 * @param ocurre
	 *            the ocurre to set
	 */
	public void setOcurre(String ocurre) {
		this.ocurre = ((ocurre != null) && (ocurre.trim().toLowerCase()
				.equals("true"))) ? true : false;
	}

	/**
	 * @return the frecuenciaCorrecta
	 */
	public boolean isFrecuenciaCorrecta() {
		return frecuenciaCorrecta;
	}

	/**
	 * @param frecuenciaCorrecta
	 *            the frecuenciaCorrecta to set
	 */
	public void setFrecuenciaCorrecta(boolean frecuenciaCorrecta) {
		this.frecuenciaCorrecta = frecuenciaCorrecta;
	}

	public boolean getFrecuenciaCorrecta() {
		return frecuenciaCorrecta;
	}

	/**
	 * Calcula el monto de sobre peso que se debe mostrar en el reporte
	 * 
	 * @return el sobre peso calculado
	 */
	public double getSobrePeso() {
		//System.out.println("Peso bascula:" +getPeso() );
		//System.out.println("Peso bascula:" +getPesoBas() );
		//System.out.println("Peso vol:" +getPeso_volumetrico() );
		
		double sobre_peso = 0;
		// En este caso solo se realiza una comparacion entre el peso que
		// declara el cliente y el peso que ampara la guia
		if ((getPesoBas() == 0) && (getPeso_volumetrico() == 0)) { 
			//System.out.println("Sin registro sobre peso:");
			sobre_peso =  getPeso() - getPesoIdEnvio(); 
			//System.out.println("Sobre peso: " + sobre_peso);
		} else {
			//System.out.println("Con registro sobre peso:");
			// En este caso se tiene que obtener el peso mayor entre el fisico y
			// el volumetrico, ya teniendo el mayor se tiene
			// que comparar con el declarado por el cliente y lo mismo obtener
			// el mayor.
			// Terminado esto se compara con el peso que ampara el envio para
			// sacar el sobrepeso
			double peso_mayor = getPesoBas() > getPeso_volumetrico() ? getPesoBas()
					: getPeso_volumetrico();
			
			//System.out.println("Peso mayor: " + peso_mayor);
			sobre_peso = peso_mayor - getPesoIdEnvio();
			
			//System.out.println("Sobre peso: " + sobre_peso);
		
		}
		
		//Indica el sobre peso
		sobre_peso = sobre_peso > 0 ? sobre_peso : 0;
		//System.out.println("Sobre peso final: " + sobre_peso);
		
		return sobre_peso;
	}

	/**
	 * @return the bultos
	 */
	public int getBultos() {
		return bultos;
	}

	/**
	 * @return the embalaje
	 */
	public String getEmbalaje() {
		return embalaje;
	}

	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * @return the pesovol
	 */
	public int getPesovol() {
		return pesovol;
	}

	/**
	 * @return the pesofis
	 */
	public int getPesofis() {
		return pesofis;
	}

	/**
	 * @return the flejado
	 */
	public String geFlejado() {
		return flejado;
	}

	/**
	 * @param bultos the bultos to set
	 */
	public void setBultos(int bultos) {
		this.bultos = bultos;
	}

	/**
	 * @param embalaje the embalaje to set
	 */
	public void setEmbalaje(String embalaje) {
		this.embalaje = embalaje;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * @param pesovol the pesovol to set
	 */
	public void setPesovol(int pesovol) {
		this.pesovol = pesovol;
	}

	/**
	 * @param pesofis the pesofis to set
	 */
	public void setPesofis(int pesofis) {
		this.pesofis = pesofis;
	}

	/**
	 * @param flejado the flejado to set
	 */
	public void setFlejado(String flejado) {
		this.flejado = flejado;
	}

	/**
	 * @return the largo
	 */
	public int getLargo() {
		return largo;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getPesoAmparado() {
		return pesoAmparado;
	}

	public void setPesoAmparado(int pesoAmparado) {
		this.pesoAmparado = pesoAmparado;
	}

	public int getPesoAmparaServicio() {
		return pesoAmparaServicio;
	}

	public void setPesoAmparaServicio(int pesoAmparaServicio) {
		this.pesoAmparaServicio = pesoAmparaServicio;
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
	public void setConsecutivo(String  consecutivo) {
		try{
			this.consecutivo = Integer.parseInt(consecutivo);
		}catch(Exception e){
			this.consecutivo = 0;
		}
	}

	/**
	 * @return the conRetorno
	 */
	public boolean isConRetorno() {
		return conRetorno;
	}

	/**
	 * @param conRetorno the conRetorno to set
	 */
	public void setConRetorno(boolean conRetorno) {
		this.conRetorno = conRetorno;
	}
	
	/**
	 * @param conRetorno the conRetorno to set
	 */
	public void setConRetorno(String conRetorno) {
		String s = conRetorno==null?"false":conRetorno.trim().toLowerCase();
		
		if ("yes".equals(s) || "si".equals(s) || "true".equals(s)  ||
				"s".equals(s) || "y".equals(s)  || "t".equals(s) ){
			this.conRetorno = true;
		}else{
			this.conRetorno = false;
		}
		
	}
	/**
	 * @return the tipoEntrega
	 */
	public String getTipoEntrega() {
		return tipoEntrega;
	}

	/**
	 * @param tipoEntrega the tipoEntrega to set
	 */
	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	/**
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}

	/**
	 * @return the arr_transbordos
	 */
	public List<CruceCoberturaDTO> getArr_transbordos() {
		return arr_transbordos;
	}

	/**
	 * @param arr_transbordos the arr_transbordos to set
	 */
	public void setArr_transbordos(List<CruceCoberturaDTO> arr_transbordos) {
		this.arr_transbordos = arr_transbordos;
	}

	/**
	 * @return the reimpresion
	 */
	public String getReimpresion() {
		return reimpresion;
	}

	/**
	 * @param reimpresion the reimpresion to set
	 */
	public void setReimpresion(String reimpresion) {
		this.reimpresion = reimpresion;
	}

	/**
	 * @return the fuerzaventas
	 */
	public String getFuerzaventas() {
		return fuerzaventas;
	}

	/**
	 * @param fuerzaventas the fuerzaventas to set
	 */
	public void setFuerzaventas(String fuerzaventas) {
		this.fuerzaventas = fuerzaventas;
	}

	/**
	 * @return the ciclo
	 */
	public String getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the lineaenruta1
	 */
	public String getLineaenruta1() {
		return lineaenruta1;
	}

	/**
	 * @param lineaenruta1 the lineaenruta1 to set
	 */
	public void setLineaenruta1(String lineaenruta1) {
		this.lineaenruta1 = lineaenruta1;
	}

	/**
	 * @return the lineaenruta2
	 */
	public String getLineaenruta2() {
		return lineaenruta2;
	}

	/**
	 * @param lineaenruta2 the lineaenruta2 to set
	 */
	public void setLineaenruta2(String lineaenruta2) {
		this.lineaenruta2 = lineaenruta2;
	}

	/**
	 * @return the lineaenruta3
	 */
	public String getLineaenruta3() {
		return lineaenruta3;
	}

	/**
	 * @param lineaenruta3 the lineaenruta3 to set
	 */
	public void setLineaenruta3(String lineaenruta3) {
		this.lineaenruta3 = lineaenruta3;
	}

	/**
	 * @return the lineaenruta4
	 */
	public String getLineaenruta4() {
		return lineaenruta4;
	}

	/**
	 * @param lineaenruta4 the lineaenruta4 to set
	 */
	public void setLineaenruta4(String lineaenruta4) {
		this.lineaenruta4 = lineaenruta4;
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
	 * @return the descripcionfolioconvenio
	 */
	public String getDescripcionfolioconvenio() {
		return descripcionfolioconvenio;
	}

	/**
	 * @param descripcionfolioconvenio the descripcionfolioconvenio to set
	 */
	public void setDescripcionfolioconvenio(String descripcionfolioconvenio) {
		this.descripcionfolioconvenio = descripcionfolioconvenio;
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
	 * @return the idguiamadremultiple
	 */
	public String getIdguiamadremultiple() {
	    return idguiamadremultiple;
	}

	/**
	 * @param idguiamadremultiple the idguiamadremultiple to set
	 */
	public void setIdguiamadremultiple(String idguiamadremultiple) {
	    this.idguiamadremultiple = idguiamadremultiple;
	}

	/**
	 * @return the cantidad_envios_remesa
	 */
	public int getCantidad_envios_remesa() {
	    return cantidad_envios_remesa;
	}

	/**
	 * @param cantidad_envios_remesa the cantidad_envios_remesa to set
	 */
	public void setCantidad_envios_remesa(int cantidad_envios_remesa) {
	    this.cantidad_envios_remesa = cantidad_envios_remesa;
	}

	public String getUsuarioimprime() {
		return usuarioimprime;
	}

	public void setUsuarioimprime(String usuarioimprime) {
		this.usuarioimprime = usuarioimprime;
	}
	
	/* PARA SABER SI LA ETIQUETA ES ASEGURADA */
	public String getTiene_seguro() {
		return tiene_seguro;
	}

	public void setTiene_seguro(String tiene_seguro) {
		this.tiene_seguro = tiene_seguro;
	}
	
	/*FECHA ESTIMADa WALMART*/
	public String getMaxEDD() {
		return maxEDD;
	}

	public void setMaxEDD(String maxEDD) {
		this.maxEDD = maxEDD;
	}
	
	/* PARA SABER SI LA ETIQUETA TIENE CITA */
	public String getTiene_cita() {
		return tiene_cita;
	}

	public void setTiene_cita(String tiene_cita) {
		this.tiene_cita = tiene_cita;
	}
} // fin Envio
