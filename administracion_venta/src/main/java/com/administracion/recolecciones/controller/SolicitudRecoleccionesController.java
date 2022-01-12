/**
 * 
 */
package com.administracion.recolecciones.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.administracion.bo.IGMaps;
import com.administracion.dto.DiasSemanaMes;
import com.administracion.dto.SolicitudRecoleccion;
import com.google.code.geocoder.model.LatLng;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.recolecciones.ibo.ISolicitudRecoleccionBO;
import com.innovargia.recolecciones.mappers.Estatus;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IFrecuenciasBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;
import com.servicio.dtos.Movimiento;
import com.servicio.dtos.Ruta;


/**
 * com.servicio.recoleccion.action.SolicitudRecoleccionesAction
 * 
 * @author Adrian Morales Ruaro
 *  /solicitudrecoleccion/puntosrecoleccion
 */
@RequestMapping("/solicitudrecoleccion")
@Controller
public class SolicitudRecoleccionesController {
    private static final Logger logger = LoggerFactory
	    .getLogger(SolicitudRecoleccionesController.class);

    @Autowired
    ISolicitudRecoleccionBO solicitudRecoleccionBO;
    @Autowired
    IFrecuenciasBO boBusqueda;
    @Autowired
    IGMaps gMaps;

    /**
	 * 
	 */
    public SolicitudRecoleccionesController() {
	// TODO Auto-generated constructor stub
    }

    /***
     * COnfigura los dias de recoleccion ya sea semanales o por mes
     * 
     * @param request
     * @param response
     * @return
     */
    private ArrayList<DiasSemanaMes> getDiasSolicitud(HttpServletRequest request) {
	String dias_programacion = request.getParameter("dias_programacion");
	ArrayList<DiasSemanaMes> dias = new ArrayList<DiasSemanaMes>();
	DiasSemanaMes diames = null;
	if (dias_programacion != null) {
	    String[] arr_dias_programacion = dias_programacion.trim().split(
		    "\\|");
	    String[] arr_dia_observa = null;
	    for (int i = 0; i < arr_dias_programacion.length; i++) {
		arr_dia_observa = arr_dias_programacion[i].split("_");

		try {
		    diames = new DiasSemanaMes();
		    diames.setDiasemanames(arr_dia_observa[0]);
		    if (arr_dia_observa.length >= 2) {
			diames.setObservacion(arr_dia_observa[1]);
		    }

		    dias.add(diames);
		} catch (Exception e) {
		}
	    }
	}
	return dias;
    }

    /***
     * COnfigura los datos de una solicitud enviados por el request
     * 
     * @param request
     * @param response
     * @return
     */
    private SolicitudRecoleccion getRequestSolicitud(HttpServletRequest request) {


	SolicitudRecoleccion solicitud = new SolicitudRecoleccion();
	
	solicitud.setIdregistro(request.getParameter("idregistro" ));
	// Datos
	solicitud.setTipoConsulta(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("tipoconsulta")));
	solicitud.setIdsolicitud(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("idsolicitud")));
	solicitud.setIdrecoleccion(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("idrecoleccion")));

	solicitud.setNumempleado(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("numempleado")));
	solicitud.setQuiensolicita(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("quiensolicita")));
	solicitud.setCorreosolicita(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("correosolicita")));
	solicitud
		.setTelefonosolicita(UtilsStrings.nullChangeToUpperCase(request
			.getParameter("telefonosolicita")));
	solicitud.setCelularsolicita(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("celularsolicita")));
	solicitud.setNumoficina(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("numoficina")));

	solicitud.setNumcliente(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("numcliente")));
	solicitud.setRazonsocialcliente(UtilsStrings
		.nullChangeToUpperCase(request
			.getParameter("razonsocialcliente")));
	solicitud.setContrato(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("contrato")));

	solicitud.setPreguntarpor(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("preguntarpor")));
	solicitud.setIdtiporecol(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("idtiporecol")));
	solicitud.setIdempaque(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("idempaque")));
	String fecha = request.getParameter("fechainicio");
	String[] arr_fecha = null;
	if (fecha != null) {
	    arr_fecha = fecha.trim().split("T");
	    if (arr_fecha.length >= 1) {
		solicitud.setFechainicio(arr_fecha[0]);
	    }
	}
	fecha = request.getParameter("fechafin");
	if (fecha != null) {
	    arr_fecha = fecha.trim().split("T");
	    if (arr_fecha.length >= 1) {
		solicitud.setFechafin(arr_fecha[0]);
	    }
	}
	fecha = request.getParameter("fecharecol");
	if (fecha != null) {
	    arr_fecha = fecha.trim().split("T");
	    if (arr_fecha.length >= 1) {
		solicitud.setFecharecol(arr_fecha[0]);
	    }
	}
	

	solicitud.setCorreosolicita(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("correosolicita")));
	solicitud.setRazonsocial(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("razonsocial")));
	solicitud.setDepartamento(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("departamento")));
	solicitud.setCalle(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("calle")));
	solicitud.setCp(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("cp")));
	solicitud.setColonia(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("colonia")));
	solicitud.setMunicipio(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("municipio")));
	solicitud.setEstado(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("estado")));
	solicitud.setTelefono(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("telefono")));
	solicitud.setCelular(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("celular")));
	solicitud.setEmail(request.getParameter("email"));

	solicitud.setPesokg(request.getParameter("pesokg"));
	solicitud.setCantidadpzas(request.getParameter("cantidadpzas"));
	solicitud.setPesototal(request.getParameter("pesototal"));
	solicitud.setAncho(request.getParameter("ancho"));
	solicitud.setAlto(request.getParameter("alto"));
	solicitud.setLargo(request.getParameter("largo"));
	solicitud.setVolumen(request.getParameter("volumen"));
	solicitud.setObservacion(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("observacion")));
	solicitud.setContenido(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("contenido")));
	solicitud.setRutaasignada(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("rutaasignada")));
	solicitud.setPlaza(UtilsStrings.nullChangeToUpperCase(request
		.getParameter("plaza")));
	
	return solicitud;
    }

    
    @RequestMapping(value = "/puntosrecoleccion")
	public String puntosrecoleccion(Locale locale, Model model,
		HttpServletRequest request,
		HttpServletResponse response,
		RedirectAttributes redirectAttributes
		) {
		logger.debug("Buscando puntos de recoleccion");
		
		 UtilsRequest.displayParametros(request);
		 SolicitudRecoleccion solicitud = getRequestSolicitud(request);
		 String markers ="";
		 String markers_titles ="";
		 String icono="";
		 String estatus="";
		 String estatus_objeto="";
		 String title="";
		 try {
		    List<SolicitudRecoleccion> lista = solicitudRecoleccionBO.getRecoleccion(solicitud);
		   
		    for (SolicitudRecoleccion solicitudRecoleccion : lista) {
			if ((solicitudRecoleccion.getLatitud()!=null) && 
				(solicitudRecoleccion.getLongitud()!=null)){
			    if ((!solicitudRecoleccion.getLatitud().trim().isEmpty()) 
				    && (!solicitudRecoleccion.getLongitud().trim().isEmpty())){
				
				estatus_objeto= solicitudRecoleccion.getEstatus();
				
				if (Estatus.ESTATUS_ACTIVA.equals(estatus_objeto)){
				    icono ="point_blue";
				    estatus ="ACTIVA";
				    title="blue";
				}else if (Estatus.ESTATUS_CANCELADA.equals(estatus_objeto)){
				    icono ="point_red";
				    estatus ="CANCELADA";
				    title="red";
				}else if (Estatus.ESTATUS_DEVUELTA.equals(estatus_objeto)){
				    icono ="point_red";
				    estatus ="DEVUELTA POR PROBLEMAS";
				    title="grey";
				}else if (Estatus.ESTATUS_PENDIENTE.equals(estatus_objeto)){
				    estatus ="PENDIENTE";
				    icono ="point_yellow";
				    title="yellow";
				}
				markers += "['" + solicitudRecoleccion.getRazonsocial()+ "'," + 
					solicitudRecoleccion.getLatitud()+ ","+
					solicitudRecoleccion.getLongitud()+",'"+ icono +"'], ";
				
				 
				   
				markers_titles +=  "[\"" + "<div id='iw-container'>" +
		                    "<div class='iw-title'>"+ solicitudRecoleccion.getRazonsocial() +"</div>" +
		                    "<div class='iw-content'>" +
		                      "<div class='iw-subTitle'>Dirección</div>" +
		                      //"<img src='images/vistalegre.jpg' alt='Porcelain Factory of Vista Alegre' height='115' width='83'>" +
		                      "<p>"+solicitudRecoleccion.getCalle()+ 
					", Col." + solicitudRecoleccion.getColonia() + ", CP " +
					solicitudRecoleccion.getCp() + ", Municipio " + 
					solicitudRecoleccion.getMunicipio()+"</p>" +
		                      "<div class='iw-subTitle'>Estatus:"+ estatus+"</div>" +
		                   //   "<p>"+ solicitudRecoleccion.getEstatus()+"<br>"+
		                    //  "<br>Phone. +351 234 320 600<br>e-mail: geral@vaa.pt<br>www: www.myvistaalegre.com</p>"+
		                    "</div>" +
		                    "<div class='iw-bottom-gradient'></div>" +
		                  "</div>" +  "\"] ";
				
			    }
			}
			
		    }
		    
		    markers = markers.trim().replace("] ", "],");
		    markers_titles = markers_titles.trim().replace("] [", "],[");
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		 model.addAttribute("markers", markers);
		 model.addAttribute("markers_titles", markers_titles);
		 redirectAttributes.addAttribute("markers", markers);
		 request.setAttribute("markers", markers);
		// return "redirect:/rutarecolecciones";   
		return "rutarecolecciones";
	}
    @RequestMapping("/busqueda")
    public @ResponseBody
    Map<String, ? extends Object> busqueda(
	    HttpServletRequest request) throws Exception {

	boolean success = false;
	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<SolicitudRecoleccion> lista = null;
	try {
	    UtilsRequest.displayParametros(request);
	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	    // List<SolicitudRecoleccion> arr_ordenrecolecion = new
	    // ArrayList<SolicitudRecoleccion>();
	    if ((solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA)
		    || (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MES)) {
		lista = solicitudRecoleccionBO
			.getSolicitudesRecoleccion(solicitud);
	    } else {
		// Esporadica
		lista = solicitudRecoleccionBO.getRecoleccion(solicitud);

	    }

	    success = true;
	    modelMap.put("success", success);
	    modelMap.put("message", mensaje);
	    modelMap.put("totalCount", lista.size());
	    modelMap.put("proxiArray", lista);

	} catch (DataAccessException dae) {
	    if (dae.contains(DuplicateKeyException.class)) {
		modelMap.put("success", success);
		modelMap.put("message", dae.getMessage());
	    }

	}
	return modelMap;

    }

    @RequestMapping("/getDatosRecoleccion")
    public @ResponseBody
    Map<String, ? extends Object> getDatosRecoleccion(HttpServletRequest request)
	    throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    UtilsRequest.displayParametros(request);
	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	    SolicitudRecoleccion solicitud_tmp = null;
	    if ((solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA)
		    || (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MES)) {

		solicitud_tmp = solicitudRecoleccionBO
			.getDocumentoSolicitudRecoleccion(solicitud_tmp);
	    } else {
		// Esporadica
		solicitud_tmp = solicitudRecoleccionBO
			.getDocumentoOrdenRecoleccion(solicitud_tmp);
	    }

	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	    modelMap.put("totalCount", solicitud_tmp);
	    modelMap.put("proxiArray", solicitud_tmp);

	} catch (Exception dae) {
	    modelMap.put("success", false);
	    modelMap.put("message", dae.getMessage());

	}
	return modelMap;

    }

    /**
     * Obtiene los datos de programacion de una solicitud de recoleccion, para
     * que el usuario pueda modificarlos, el sistema debe verificar si se trata
     * de una programacion por semana o por día del mes para poder desplegar la
     * info de forma correcta y el usuario pueda modificarla, esta información
     * se despliega en un grid y el usuario puede agregar o eliminar dias
     * 
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/getProgramacionRecoleccion")
    public @ResponseBody
    Map<String, ? extends Object> getProgramacionRecoleccion(
	    HttpServletRequest request) throws Exception {
	
	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<DiasSemanaMes> lista = null;
	try {
	    UtilsRequest.displayParametros(request);
	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	    lista = solicitudRecoleccionBO.getProgramacion(solicitud);

	   
	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	    modelMap.put("totalCount", lista.size());
	    modelMap.put("proxiArray", lista);

	} catch (Exception dae) {
	   
		modelMap.put("success", false);
		modelMap.put("message", dae.getMessage());


	}
	return modelMap;

    }

    /**
     * Realiza la busqueda de la ruta en especifico para el manifiesto o de
     * todos los manifiestos para impresión
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/generaManifiesto")
    public @ResponseBody
    Map<String, ? extends Object> generaManifiesto(HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<String> arr_rutas = new ArrayList<String>();
	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	try {
	    UtilsRequest.displayParametros(request);
	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	    
	   /* - fechainicio=
		    2014-11-01 13:29:01,524  INFO [http-bio-8089-exec-8] UtilsRequest - fechafin=
		    2014-11-01 13:29:01,524  INFO [http-bio-8089-exec-8] UtilsRequest - plaza=MEX
		    2014-11-01 13:29:01,524  INFO [http-bio-8089-exec-8] UtilsRequest - rutaasignada=RUTAZ06
		    2014-11-01 13:29:01,524  INFO [http-bio-8089-exec-8] UtilsRequest - manifiesto=
		    2014-11-01 13:29:01,524  INFO [http-bio-8089-exec-8] UtilsRequest - fecharecol=
*/
	    if ((solicitud.getRutaasignada() == null)
		    || (solicitud.getRutaasignada().trim().toUpperCase()
			    .equals("ALL"))) {
		// Obtiene toda la lista de rutas pertenecientes a la plaza del
		// usuario
		arr_rutas = solicitudRecoleccionBO
			.getRutasOrdenesRecoleccion(usuario);
	    } else {
		// Solo obtiene las recolecciones de la ruta seleccionada por el
		// usuario
		arr_rutas.add(solicitud.getRutaasignada());
	    }

	    // Obtiene todos los manifiestos generados
	    List<String> arr_manifiestos = solicitudRecoleccionBO
		    .agregaRecoleccionAManifesto(arr_rutas, usuario, solicitud.getPlaza(), solicitud.getFechainicio());
	    byte[] bytes =null;
	    if (arr_manifiestos.size()>0){
		bytes  = solicitudRecoleccionBO
			    .generarManifiestoPDF(
				    arr_manifiestos,
				    usuario,
				    "No existen registros de ordenes de recoleccion ACTIVOS pendientes de manifestar.");
	    }
	   
	  
	    flushManifiesto(bytes, response,"No existen registros de ordenes de recoleccion ACTIVOS pendientes de manifestar.");

	} catch (Exception dae) {
	    modelMap.put("success", false);
	    modelMap.put("message", dae.getMessage());
	}
	return modelMap;

    }

    @RequestMapping("/getRutasConOrdenesRecoleccion")
    public @ResponseBody
    Map<String, ? extends Object> getRutasConOrdenesRecoleccion(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	try {
	    UtilsRequest.displayParametros(request);
	   
	    List<Ruta> arr_rutas = solicitudRecoleccionBO
		    .getRutasConOrdenesRecoleccion(usuario, false);
	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	    modelMap.put("totalCount", arr_rutas.size());
	    modelMap.put("proxiArray", arr_rutas);

	} catch (Exception dae) {
	    modelMap.put("success", false);
	    modelMap.put("message", dae.getMessage());
	}
	return modelMap;

    }

    @RequestMapping("/reimprimirManifiesto")
    public @ResponseBody
    Map<String, ? extends Object> reimprimirManifiesto(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	try {
	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	    String manifiesto = request.getParameter("manifiesto");
	    solicitud.setManifiesto(manifiesto);
	    // Obtiene todos los manifiestos generados
	    ArrayList<String> arr_manifiestos = new ArrayList<String>();
	    arr_manifiestos.add(solicitud.getManifiesto());

	    byte[] bytes = solicitudRecoleccionBO.generarManifiestoPDF(
		    arr_manifiestos, usuario, "");
	    flushManifiesto(bytes, response,"No existen registros de ordenes de recoleccion ACTIVOS pendientes de manifestar.");

	} catch (Exception dae) {
	    modelMap.put("success", false);
	    modelMap.put("message", dae.getMessage());
	}
	return modelMap;

    }

    /**
     * Agrega una solicitud de recoleccion
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/agregarSolicitudRecoleccion")
    public @ResponseBody
    Map<String, ? extends Object> agregarSolicitudRecoleccion(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    if (usuario == null) {
		throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
	    }

	    String accion = request.getParameter("accion") == null ? ""
		    : request.getParameter("accion").trim().toUpperCase();
	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	    solicitud.setIdentidad(usuario.entidad.getIdentidad()); 
	    solicitud.setIdorganizacion(usuario.organizacion
		    .getIdorganizacion());
	    solicitud.setIdusuariocreador(usuario.getLogin());

	    LatLng location = gMaps.getLocation(solicitud.getCalle() + ", "
		    + solicitud.getColonia() + ", " + solicitud.getCp() + ", "
		    + solicitud.getEstado());
	    if (location != null) {
		solicitud.setLatitud(location.getLat() + "");
		solicitud.setLongitud(location.getLng() + "");
	    }

	    // Verifica las siglas plaza y la ruta predeterminada si
	    // son nulas obtiene las frecuencias del CP y toma esos datos
	    // de cualquier registro=
	    if ((solicitud.getRutaasignada() == null)
		    || (solicitud.getRutaasignada().trim().length() <= 0)
		    || (solicitud.getPlaza() == null)
		    || (solicitud.getPlaza().trim().length() <= 0)) {
		Frecuencias frecuencia = boBusqueda.getRutaAsignada(solicitud.getCp());
		
		if (frecuencia!=null){
		    solicitud.setRutaasignada(frecuencia.getRutaEnt());
			solicitud.setPlaza(frecuencia.getIdagrupador());
		}
	    }

	    // Obtiene los dias de la programacion
	    // ArrayList<DiasSemanaMes> dias = getDiasSolicitud(request);
	   // String fechasystema = Fechas.formatoFecha(Calendar.getInstance(),
	//	    "yyyy-MM-dd hh:mm:ss");

	    // Obtiene el movimiento de historia en caso de la actualizacion
	    /*Movimiento movimiento = new Movimiento();
	    movimiento.setTipoRegistro("MU");
	    movimiento.setFecha(fechasystema);
	    movimiento.setClaveLogistica("");
	    movimiento.setRuta("");
	    movimiento.setEmpleado(usuario.getLogin());
	    movimiento.setQuienrechaza("");
	    movimiento.setMotivo("ACTULIZA DATOS");*/

	 
	    if ((solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA)
		    || (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MES)) {
		String fechaini = UtilsStringFechas.formatoStrFecha(solicitud.getFechainicio(), "dd/MM/yyyy", "yyyy-MM-dd");
		String fechafin= UtilsStringFechas.formatoStrFecha(solicitud.getFechafin(), "dd/MM/yyyy", "yyyy-MM-dd");
		solicitud.setFechainicio(fechaini);
		solicitud.setFechafin(fechafin);
		
		if (accion.trim().equals("UPDATE")) {
		    solicitudRecoleccionBO.updateSolicitudRecoleccion(
			    solicitud, null);
		    
		    /*insertHistoriaRecoleccion(solicitud.getIdregistro(),
			    "MU", usuario.getLogin(), "", "ACTULIZA DATOS",true); */
			solicitudRecoleccionBO.insertHistoriaRecoleccion(solicitud.getIdregistro(),
				"MU", usuario.getLogin(), "", 
				"ACTULIZA DATOS",true);
		    
		    //movimiento.setIdsolicitud(solicitud.getIdsolicitud());
		    //solicitudRecoleccionBO.insertaMovimiento(movimiento);
		} else {
		    solicitudRecoleccionBO.agregarSolicitudRecoleccion(
			    solicitud, null);
		}
	    } else {
		String fecha = UtilsStringFechas.formatoStrFecha(solicitud.getFechainicio(), "dd/MM/yyyy", "yyyy-MM-dd");
		solicitud.setFechainicio(fecha);
		solicitud.setFechafin(fecha);
		solicitud.setFecharecol(fecha);
		// Esporadica
		if (accion.trim().equals("UPDATE")) {
		    solicitudRecoleccionBO.updateRecoleccion(solicitud, null);
		    //movimiento.setIdsolicitud(solicitud.getIdrecoleccion());
		    // Agrega la historia de la actualizacion de los datos
		    //solicitudRecoleccionBO.insertaMovimiento(movimiento);
		    /*insertHistoriaRecoleccion(solicitud.getIdregistro(),
			    "MU", usuario.getLogin(), "", "ACTULIZA DATOS", false);*/
		solicitudRecoleccionBO.insertHistoriaRecoleccion(solicitud.getIdregistro(),
				"MU", usuario.getLogin(), "", 
				"ACTULIZA DATOS",false);
		 			
		} else {
		    solicitudRecoleccionBO.agregarRecoleccion(solicitud);
		}
	    }
	    modelMap.put("success", true);
	    modelMap.put("Idsolicitud", solicitud.getIdsolicitud());
	    modelMap.put("message", "Correcto");
	} catch (Exception e) {
	    modelMap.put("success", false);
	    modelMap.put("message", e.getMessage());
	}

	return modelMap;
    }

    /**
     * Modifica la ruta de una Recoleccion
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/actualizaRutaRecoleccion")
    public @ResponseBody
    Map<String, ? extends Object> actualizaRutaRecoleccion(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    if (usuario == null) {
		throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
	    }

	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	    /*String fechasystema = Fechas.formatoFecha(Calendar.getInstance(),
		    "yyyy-MM-dd hh:mm:ss");
	    Movimiento movimiento = new Movimiento();
	    movimiento.setTipoRegistro("MR");
	    movimiento.setFecha(fechasystema);
	    movimiento.setClaveLogistica("");
	    movimiento.setRuta("");
	    movimiento.setEmpleado(usuario.getLogin());
	    movimiento.setQuienrechaza("");
	    movimiento.setMotivo("Reasignacion de Ruta");*/

	    String arr_idrecolecion = request.getParameter("idsrecoleccion");
	    if (arr_idrecolecion != null) {
		String[] arr_recolecciones = arr_idrecolecion.split(",");
		if (arr_recolecciones.length > 0) {
		    boolean isSolicitudRecoleccion=true;
		    for (int i = 0; i < arr_recolecciones.length; i++) {
			solicitud.setIdrecoleccion(arr_recolecciones[i]);
			 solicitud.setIdregistro(arr_recolecciones[i]);
			if ((solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA)
				|| (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MES)) {
			    solicitudRecoleccionBO
				    .modificarRutaSolicitudRecoleccion(
					    arr_recolecciones[i],
					    solicitud.getRutaasignada());
			    // Inserta registro de historia
			    /*movimiento.setIdsolicitud(arr_recolecciones[i]);
			    solicitudRecoleccionBO
				    .insertaMovimiento(movimiento);*/

			} else {
			    // Esporadica
			    isSolicitudRecoleccion=false;
			    solicitudRecoleccionBO.modificarRutaRecoleccion(
				    arr_recolecciones[i],
				    solicitud.getRutaasignada(), usuario);
			    // Inserta registro de historia
			   /* movimiento.setIdsolicitud(arr_recolecciones[i]);
			    solicitudRecoleccionBO
				    .insertaMovimiento(movimiento);*/
			}
			
			solicitudRecoleccionBO.insertHistoriaRecoleccion(solicitud.getIdregistro(),
				"MR", usuario.getLogin(), "", 
				"Reasignacion de Ruta",isSolicitudRecoleccion);
			
			// Inserta registro de historia
			/*insertHistoriaRecoleccion(solicitud.getIdregistro(),
				"MR", usuario.getLogin(), "", 
				"Reasignacion de Ruta",isSolicitudRecoleccion);*/

		    }

		}
	    }

	    modelMap.put("success", true);
	    modelMap.put("Idsolicitud", solicitud.getIdsolicitud());
	    modelMap.put("message", "Correcto");

	} catch (Exception e) {
	    modelMap.put("success", false);
	    modelMap.put("message", "Incorrecto");
	}

	return modelMap;
    }

    /**
     * Modifica el estatus de una solicitud de recoleccion
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/cambiaEstatusSolicitudRecoleccion")
    public @ResponseBody
    Map<String, ? extends Object> cambiaEstatusSolicitudRecoleccion(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	    String estatus = request.getParameter("estatus") == null ? ""
		    : request.getParameter("estatus").trim().toUpperCase();
	    String motivo = request.getParameter("motivocancelacion") == null ? 
		    "CAMBIO ESTATUS"
		    : request.getParameter("motivocancelacion").trim()
			    .toUpperCase();

	    solicitud.setMotivocancelacion(motivo);
	    Movimiento movimiento = new Movimiento();
	    if (estatus.equals(Estatus.ESTATUS_ACTIVA)) {
		
		estatus = Estatus.ESTATUS_CANCELADA;
		movimiento.setTipoRegistro("MC");
	    } else {
		estatus = Estatus.ESTATUS_ACTIVA;
		movimiento.setTipoRegistro("MA");
	    }

	    String arr_idrecolecion = request.getParameter("idsrecoleccion");
	   /* String fechasystema = Fechas.formatoFecha(Calendar.getInstance(),
		    "yyyy-MM-dd hh:mm:ss");
	    movimiento.setFecha(fechasystema);
	    movimiento.setClaveLogistica("");
	    movimiento.setRuta("");
	    movimiento.setEmpleado(usuario.getLogin());
	    movimiento.setQuienrechaza(usuario.getLogin());
	    movimiento.setMotivo(motivo);*/
	    

	    if (arr_idrecolecion != null) {
		String[] arr_recolecciones = arr_idrecolecion.split(",");
		if (arr_recolecciones.length > 0) {
		    boolean isSolicitudRecoleccion=true;
		    for (int i = 0; i < arr_recolecciones.length; i++) {
			
			solicitud.setIdrecoleccion(arr_recolecciones[i]);
			solicitud.setIdsolicitud(arr_recolecciones[i]);
			solicitud.setIdregistro(arr_recolecciones[i]);
			
			if ((solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA)
				|| (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MES)) {
			    solicitudRecoleccionBO
				    .cambiarEstatusSolicitudRecoleccion(
					    arr_recolecciones[i], estatus);
			    // Inserta registro de historia
			    //movimiento.setIdsolicitud(arr_recolecciones[i]);
			   // solicitudRecoleccionBO
				//    .insertaMovimiento(movimiento);

			} else {
			    // Esporadica
			    isSolicitudRecoleccion=false;
			    solicitud.setEstatus(estatus);
			    solicitud.setIdsolicitud(arr_recolecciones[i]);
			    solicitudRecoleccionBO.cambiarEstatusRecoleccion(
				    solicitud, usuario);
			    // Inserta registro de historia
			  //  movimiento.setIdsolicitud(arr_recolecciones[i]);
			   // solicitudRecoleccionBO
				//    .insertaMovimiento(movimiento);
			}
			
			// Inserta registro de historia
			solicitudRecoleccionBO.insertHistoriaRecoleccion(solicitud.getIdregistro(),
				movimiento.getTipoRegistro(), usuario.getLogin(), "", 
				motivo,isSolicitudRecoleccion);
			/*insertHistoriaRecoleccion(solicitud.getIdregistro(),
				movimiento.getTipoRegistro(), usuario.getLogin(), "",
				motivo,isSolicitudRecoleccion);*/
		    }

		}
	    }
	    modelMap.put("success", true);
	    modelMap.put("Idsolicitud", solicitud.getIdsolicitud());
	    modelMap.put("message", "Correcto");

	} catch (Exception e) {
	    modelMap.put("success", false);
	    modelMap.put("message", "InCorrecto");
	}
	return modelMap;

    }

    /**
     * Descloquea una orden de recoleccion cuando su estatus es de tipo L
     * (BLOQUEADO), esta operacion solo la puede realizar un usuario cuyo perfil
     * sea de tipo administrador
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/desbloqueaOrdenSolicitudRecoleccion")
    public @ResponseBody
    Map<String, ? extends Object> desbloqueaOrdenSolicitudRecoleccion(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    // Solo es permitida la operacion con usuario de perfil
	    // administrador
	    if (usuario.perfil_Dto.getNivel().equals("A")) {
		SolicitudRecoleccion solicitud = getRequestSolicitud(request);

		String arr_idrecolecion = request
			.getParameter("idsrecoleccion");

		 boolean isSolicitudRecoleccion=
			    solicitud.getIdtiporecol()==3?false:true;
		/*String fechasystema = Fechas.formatoFecha(
			Calendar.getInstance(), "yyyy-MM-dd hh:mm:ss");
		Movimiento movimiento = new Movimiento();
		movimiento.setFecha(fechasystema);
		movimiento.setTipoRegistro("MB");
		movimiento.setClaveLogistica("");
		movimiento.setRuta("");
		movimiento.setEmpleado(usuario.getLogin());
		movimiento.setQuienrechaza(usuario.getLogin());
		movimiento.setMotivo("REGISTRO DESBLOQUEADO");*/

		if (arr_idrecolecion != null) {
		    String[] arr_recolecciones = arr_idrecolecion.split(",");
		    if (arr_recolecciones.length > 0) {
			for (int i = 0; i < arr_recolecciones.length; i++) {
			    // REACTIVA LOS REGISTROS BLOQUEADOS
			    solicitud.setEstatus("A");
			    solicitud.setIdrecoleccion(arr_recolecciones[i]);
			    solicitud.setIdregistro(arr_recolecciones[i]);
			    solicitud.setIdsolicitud(arr_recolecciones[i]);
			    solicitudRecoleccionBO.cambiarEstatusRecoleccion(
				    solicitud, usuario);
			    
			    
			    // Inserta registro de historia
			    /*insertHistoriaRecoleccion(solicitud.getIdregistro(),
				    "MB", usuario.getLogin(), usuario.getLogin(),
				    "REGISTRO DESBLOQUEADO",isSolicitudRecoleccion);*/
			    
			     solicitudRecoleccionBO.insertHistoriaRecoleccion(solicitud.getIdregistro(),
					"MB", usuario.getLogin(), "", 
					"REGISTRO DESBLOQUEADO",isSolicitudRecoleccion);
			    
			    /*movimiento.setIdsolicitud(arr_recolecciones[i]);
			    solicitudRecoleccionBO
				    .insertaMovimiento(movimiento);*/

			}

		    }
		}
		modelMap.put("success", true);
		modelMap.put(
			"Idsolicitud",
			"Se modifico el estatus de la solicitud "
				+ solicitud.getIdsolicitud());
		modelMap.put("message", "Correcto");

	    } else {
		modelMap.put("success", true);
		modelMap.put(
			"message",
			"Esta operacion solo puede ser realizada por un usuario con nivel de ADMINISTRADOR.");

	    }

	} catch (Exception e) {
	    modelMap.put("success", false);
	    modelMap.put("message",
		    "Error al crear la recoleccioón " + e.getMessage());
	}

	return modelMap;

    }

    /**
     * Modifica la ruta de una Recoleccion
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/actualizaFechaRecoleccion")
    public @ResponseBody
    Map<String, ? extends Object> actualizaFechaRecoleccion(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {

	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	    boolean isSolicitudRecoleccion=solicitud.getIdtiporecol()==3?true:false;
	    String arr_idrecolecion = request.getParameter("idsrecoleccion");
	    String fecharecol = request.getParameter("fecharecol");
	    String[] partes_fecha = fecharecol.split("T");
	    solicitud.setFecharecol(partes_fecha[0]);
	   /* String fechasystema = Fechas.formatoFecha(Calendar.getInstance(),
		    "yyyy-MM-dd hh:mm:ss");
	    Movimiento movimiento = new Movimiento();
	    movimiento.setTipoRegistro("MF");
	    movimiento.setFecha(fechasystema);
	    movimiento.setClaveLogistica("");
	    movimiento.setRuta("");
	    movimiento.setEmpleado(usuario.getLogin());
	    movimiento.setQuienrechaza(usuario.getLogin());
	    movimiento.setMotivo("");*/

	    if (arr_idrecolecion != null) {
		String[] arr_recolecciones = arr_idrecolecion.split(",");
		fecharecol= UtilsStringFechas.formatoStrFecha(solicitud.getFecharecol(), "dd/MM/yyyy", "yyyy-MM-dd") ;
		solicitud.setFecharecol(fecharecol);
		
		if (arr_recolecciones.length > 0) {
		    for (int i = 0; i < arr_recolecciones.length; i++) {
			
			 
			  
			/*if ((solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA)
				|| (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MES)) {

			} else {*/
			    // Esporadica
			    solicitud.setIdrecoleccion(arr_recolecciones[i]);
			    solicitud.setIdsolicitud(arr_recolecciones[i]);
			    solicitud.setIdregistro(arr_recolecciones[i]);
			    solicitudRecoleccionBO.cambiarFechaRecoleccion(
				    solicitud, usuario);
			    // Inserta registro de historia
			    /*insertHistoriaRecoleccion(solicitud.getIdregistro(),
				    "MF", usuario.getLogin(),"",
				    "",isSolicitudRecoleccion);*/
			    
			    solicitudRecoleccionBO.insertHistoriaRecoleccion(solicitud.getIdregistro(),
					"MF", usuario.getLogin(), "", 
					"",isSolicitudRecoleccion);
			    
			   /* movimiento.setIdsolicitud(arr_recolecciones[i]);
			    solicitudRecoleccionBO
				    .insertaMovimiento(movimiento);*/
			//}
		    }
		}
	    }

	    modelMap.put("success", true);
	    modelMap.put("message", "Se modifico la ruta de la solicitud "
		    + solicitud.getIdsolicitud());

	} catch (Exception e) {
	    modelMap.put("success", false);
	    modelMap.put("message",
		    "Error al crear la recolección " + e.getMessage());
	}

	return modelMap;
    }

    /**
     * Modifica los dias de recoleccion
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/actualizaDiasRecoleccion")
    public @ResponseBody
    Map<String, ? extends Object> actualizaDiasRecoleccion(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {

	    SolicitudRecoleccion solicitud = getRequestSolicitud(request);

	    ArrayList<DiasSemanaMes> dias = getDiasSolicitud(request);
	    if (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA) {
		solicitudRecoleccionBO.modificarDiasSemanaSolicitudRecoleccion(
			solicitud.getIdsolicitud(), dias);
	    } else if (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MES) {
		// Esporadica
		solicitudRecoleccionBO.modificarDiasMesSolicitudRecoleccion(
			solicitud.getIdsolicitud(), dias);
	    }
	    modelMap.put("success", true);
	    modelMap.put("message", "Se modifico la ruta de la solicitud "
		    + solicitud.getIdsolicitud());

	} catch (Exception e) {
	    modelMap.put("success", false);
	    modelMap.put("message",
		    "Error al crear la recoleccioón " + e.getMessage());
	}
	return modelMap;
    }

    /**
     * Obtiene los datos de la hora del servidor para indicar al usuario que se
     * ha terminao el tiempo de captura de recoleccion
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/obtenerHoraServidor")
    public @ResponseBody
    Map<String, ? extends Object> obtenerHoraServidor(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	ControlHoraCorteRecoleccion controlHoraCorteRecoleccion = new ControlHoraCorteRecoleccion();

	if (controlHoraCorteRecoleccion.isHoraCorte() == 0) {
	    modelMap.put("success", true);
	    modelMap.put("isOK", true);
	    modelMap.put("horacorte", controlHoraCorteRecoleccion.getHoracorte());
	    modelMap.put("hora_str", controlHoraCorteRecoleccion.getHora_str());
	    
	    
	    
	} else if (controlHoraCorteRecoleccion.isHoraCorte() == 1) {
	    modelMap.put("success", false);  
	    modelMap.put("isOK", false);
	    modelMap.put("horacorte", controlHoraCorteRecoleccion.getHoracorte());
	    modelMap.put("hora_str", controlHoraCorteRecoleccion.getHora_str());
	    modelMap.put("message",
		    "Hora de recolección ha excedido las 14:00 hrs");
	} else if (controlHoraCorteRecoleccion.isHoraCorte() == 2) {
	    modelMap.put("success", false);
	    modelMap.put("isOK", false);
	    modelMap.put("horacorte", controlHoraCorteRecoleccion.getHoracorte());
	    modelMap.put("hora_str", controlHoraCorteRecoleccion.getHora_str());
	    modelMap.put(
		    "message",
		    "Hora de recolección ha terminado, su recolección será configurada para el día siguiente.");
	}
	return modelMap;
    }

    /**
     * Realiza la busqueda de las ordenes de recolecciòn de un usuario de todas
     * sus rutas o de solo la ruta indicada
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/ordenesRecoleccionRutaManifiesto")
    public @ResponseBody
    Map<String, ? extends Object> ordenesRecoleccionRutaManifiesto(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	try {
	    List<SolicitudRecoleccion> lista = solicitudRecoleccionBO
		    .getOrdenesRecoleccionRuta(solicitud.getRutaasignada(),
			    usuario);
	    modelMap.put("success", true);
	    modelMap.put("message", "Correcto");
	    modelMap.put("totalCount", lista.size());
	    modelMap.put("proxiArray", lista);

	} catch (Exception e) {
	    List<SolicitudRecoleccion> lista1 = new ArrayList<SolicitudRecoleccion>();
	    modelMap.put("success", true);
	    modelMap.put("message", e.getMessage());
	    modelMap.put("totalCount", lista1.size());
	    modelMap.put("proxiArray", lista1);
	}
	return modelMap;
    }

    /**
     * Obtiene las rutas que tienen recoleccion y que pertenecen a un usuario en
     * particular de determinadas plazas
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/rutasRecoleccionUsuario")
    public @ResponseBody
    Map<String, ? extends Object> rutasRecoleccionUsuario(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	try {
	    List<SolicitudRecoleccion> lista = solicitudRecoleccionBO
		    .getOrdenesRecoleccionRuta(solicitud.getRutaasignada(),
			    usuario);
	    modelMap.put("success", true);
	    modelMap.put("message", "Correcto");
	    modelMap.put("totalCount", lista.size());
	    modelMap.put("proxiArray", lista);

	} catch (Exception e) {
	    List<SolicitudRecoleccion> lista1 = new ArrayList<SolicitudRecoleccion>();
	    modelMap.put("success", true);
	    modelMap.put("message", e.getMessage());
	    modelMap.put("totalCount", lista1.size());
	    modelMap.put("proxiArray", lista1);
	}

	return modelMap;
    }

    /**
     * Genera las ordenes de recoleccion del dia actual
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/cronGeneraOrdenesRecolecionHoy")
    public @ResponseBody
    Map<String, ? extends Object> cronGeneraOrdenesRecolecionHoy(
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    if (usuario == null) {
			throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH );
		    }
	    solicitudRecoleccionBO.generarOrdenesRecoleccion();
	    modelMap.put("success", true);
	    modelMap.put("message", "Se generaron las recolecciones del día " + 
	    UtilsStringFechas.obtenerFechaActual("dd/MM/yyyy"));

	} catch (Exception e) {
	    modelMap.put("success", false);
	    modelMap.put("message", e.getMessage());
	}

	return modelMap;
    }

    /**
     * Obtiene la historia de una orden de recoleccion o solicitud y regresa un
     * objeto de Solicitud JSON con su historia
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/obtenerHistoria")
    public @ResponseBody
    Map<String, ? extends Object> obtenerHistoria(HttpServletRequest request,
	    HttpServletResponse response) throws Exception {

	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	UtilsRequest.displayParametros(request);
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	SolicitudRecoleccion solicitud = getRequestSolicitud(request);
	try {

	    List<Movimiento> lista = solicitudRecoleccionBO
		    .getHistoriaRecoelccion(solicitud.getIdrecoleccion());

	    modelMap.put("success", true);
	    modelMap.put("message", "Correcto");
	    modelMap.put("totalCount", lista.size());
	    modelMap.put("proxiArray", lista);

	} catch (Exception e) {
	    List<SolicitudRecoleccion> lista1 = new ArrayList<SolicitudRecoleccion>();
	    modelMap.put("success", true);
	    modelMap.put("message", e.getMessage());
	    modelMap.put("totalCount", lista1.size());
	    modelMap.put("proxiArray", lista1);
	}

	return modelMap;
    }

    private void flushManifiesto(byte[] bytes, HttpServletResponse response, String error)
	    throws IOException {
	
	if (error==null){
	    error ="NO SE HA LOGRADO GENERAR EL REPORTE,"
			+ " VERIFIQUE CON EL ADMINISTRADOR.";
	}
	 
	
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	ServletOutputStream out = response.getOutputStream();

	//Verifica el tipo de documento a desplegar
	if (bytes!=null){
		response.setContentType(MimeTypes.getMimeType("*.pdf"));
	}else{
		response.setContentType(MimeTypes.getMimeType("*.html"));
		bytes = error.getBytes();
	}
	
	bos.write(bytes);
	
	response.setContentLength(bos.size());
	out.write(bos.toByteArray());
	out.flush();
	bos.close();
	out.close();
	response.flushBuffer();
    }
    
   /* private void insertHistoriaRecoleccion(int idregistro, 
	    String tipoRegistro, String login, String quienrechaza,
	    String motivo, boolean isSolicitudRecoleccion){
	  // Obtiene los dias de la programacion
	    // ArrayList<DiasSemanaMes> dias = getDiasSolicitud(request);
	    String fechasystema = Fechas.formatoFecha(Calendar.getInstance(),
		    "yyyy-MM-dd hh:mm:ss");

	    // Obtiene el movimiento de historia en caso de la actualizacion
	    Movimiento movimiento = new Movimiento();
	    movimiento.setTipoRegistro(tipoRegistro);
	    movimiento.setFecha(fechasystema);
	    movimiento.setClaveLogistica("");
	    movimiento.setRuta("");
	    movimiento.setEmpleado(login);
	    movimiento.setQuienrechaza(quienrechaza);
	    movimiento.setMotivo(motivo);
	    
	    try {
		SolicitudRecoleccion solicitud = 
			solicitudRecoleccionBO.getSolicitudRecoleccionById(idregistro,
			isSolicitudRecoleccion);
		String idsolicitud="";
		if (solicitud!=null){
		    idsolicitud = isSolicitudRecoleccion?
			    solicitud.getIdsolicitud():solicitud.getIdrecoleccion();
			    
		    movimiento.setIdsolicitud(idsolicitud);
		    solicitudRecoleccionBO
			.insertaMovimiento(movimiento);
		   
		}
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    
    }*/

}
