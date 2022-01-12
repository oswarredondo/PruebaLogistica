/**
 * 
 */
package com.administracion.recolecciones.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.DiasSemanaMes;
import com.administracion.dto.SolicitudRecoleccion;
import com.administracion.extjs.dto.TreeExtJS;
import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.recolecciones.ibo.ISolicitudRecoleccionBO;
import com.innovargia.recolecciones.mappers.Estatus;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IPlazaBO;
import com.innovargia.salesmanager.json.CatalogoDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.Ruta;
import com.servicio.search.ibo.IBusquedaAdicionalBO;

/**
 * @author Adrián
 * 
 */
@RequestMapping("/manifiestorutas")
@Controller
public class ManifiestoPlazasRegionalesRutasController {
    String formato_fecha ="yyyy/MM/dd";

    private static final Logger logger = LoggerFactory
	    .getLogger(ManifiestoPlazasRegionalesRutasController.class);

    @Autowired
    ISolicitudRecoleccionBO iSolicitudRecoleccionBO;

    @Autowired
    IPlazaBO iPlazaBO;

    /**
	 * 
	 */
    public ManifiestoPlazasRegionalesRutasController() {
	// TODO Auto-generated constructor stub
    }
    
    @RequestMapping("/getDatosTotalesPlaza")
    public @ResponseBody
    Map<String, ? extends Object> getDatosTotalesPlaza(
	    HttpServletRequest request) throws Exception {
	
	List<Ruta> lista_plazaruta = new ArrayList<Ruta>();
	String fecha = request.getParameter("fecha") == null ? UtilsStringFechas
		.obtenerFechaActual(formato_fecha) : request
		.getParameter("fecha");

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<TreeExtJS> lista = null;

	UtilsRequest.displayParametros(request);
	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	
	
	try {
	    if (usuario == null) {
		throw new Exception(
			mensaje = ConstantesAdminSale.MSG_SESSION_FINISH);
	    }
	    if (usuario.getVisibilidad() == 0) {
		lista_plazaruta = iSolicitudRecoleccionBO.obtienePlazaTotal(
			usuario.getSiglasPlaza(), fecha);
	    } else {
		// Todas las plazas
		lista_plazaruta = iSolicitudRecoleccionBO.obtienePlazaTotal(
			null, fecha);
	    }
	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	    modelMap.put("totalCount", lista_plazaruta.size());
	    modelMap.put("proxiArray", lista_plazaruta);

	} catch (Exception dae) {
	    modelMap.put("success", false);
	    modelMap.put("message", dae.getMessage());

	}
	return modelMap;
    }
    
    @RequestMapping("/getDatosTotalesRuta")
    public @ResponseBody
    Map<String, ? extends Object> getDatosTotalesRuta(
	    HttpServletRequest request) throws Exception {
	
	List<Ruta> lista_plazaruta = new ArrayList<Ruta>();
	String fecha = request.getParameter("fecha") == null ? UtilsStringFechas
		.obtenerFechaActual(formato_fecha) : request
		.getParameter("fecha");

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<TreeExtJS> lista = null;

	UtilsRequest.displayParametros(request);
	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	
	
	try {
	    if (usuario == null) {
		throw new Exception(
			mensaje = ConstantesAdminSale.MSG_SESSION_FINISH);
	    }
	    String siglas = request.getParameter("siglas");
	    if (siglas!=null){
		 lista_plazaruta = 
			    iSolicitudRecoleccionBO.obtienePlazaRutasTotal(siglas, fecha) ;
	    }
	   

	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	    modelMap.put("totalCount", lista_plazaruta.size());
	    modelMap.put("proxiArray", lista_plazaruta);

	} catch (Exception dae) {
	    modelMap.put("success", false);
	    modelMap.put("message", dae.getMessage());

	}
	return modelMap;
    }

    @RequestMapping("/getDatos")
    public @ResponseBody
    Map<String, ? extends Object> getDatos(
	    @ModelAttribute("id") SolicitudRecoleccion solicitud,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<TreeExtJS> lista = null;

	UtilsRequest.displayParametros(request);
	UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		.getSession(true));
	TreeExtJS plaza = null;
	try {
	    if (usuario == null) {
		throw new Exception(
			mensaje = ConstantesAdminSale.MSG_SESSION_FINISH);
	    }
	    String root = request.getParameter("node") == null ? "root"
		    : request.getParameter("node").trim();
	   logger.debug("root:" + root +"-");
	    // Obtiene la plaza del usuario
	    lista = new ArrayList<TreeExtJS>();
	    List<Ruta> lista_plazaruta = new ArrayList<Ruta>();
	    String fecha =request.getParameter("fecha")==null?
		    UtilsStringFechas.obtenerFechaActual("dd/MM/yyyy"):
		request.getParameter("fecha");

	    if ("root".equals(root)) {

		if (usuario.getVisibilidad() == 0) {
		    lista_plazaruta = 
			    iSolicitudRecoleccionBO.obtienePlazaTotal(usuario.getSiglasPlaza(), fecha) ;
		} else {
		    //Todas las plazas
		    lista_plazaruta = 
			    iSolicitudRecoleccionBO.obtienePlazaTotal(null, fecha) ;
		}
		
		for (Ruta ruta : lista_plazaruta) {  
		    plaza = new TreeExtJS();
		    plaza.setId("P-" + ruta.getSiglasplaza()+"-"+fecha );
		    plaza.setText(ruta.getSiglasplaza()+"(" + ruta.getTotal() +")");
		    plaza.setLeaf(false);
		    plaza.setIconCls("manager");
		    lista.add(plaza);
		}
	    } else {
		// Obtiene las rutas
		String[] datos_root =  root.split("-");
		String siglas = datos_root[1];
		lista_plazaruta = 
			    iSolicitudRecoleccionBO.obtienePlazaRutasTotal(siglas, fecha) ;
		
		for (Ruta ruta : lista_plazaruta) {  
		    plaza = new TreeExtJS();
		    plaza.setId("R-" + ruta.getSiglasplaza()+
			    "-"+ruta.getIdruta()+"-"+fecha );
		    plaza.setText(ruta.getIdruta()+"(" + ruta.getTotal() +")");
		    plaza.setLeaf(true);
		    plaza.setIconCls("ruta_blue");
		    lista.add(plaza);
		}
	    }

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

    @RequestMapping("/getRegionales")
    public @ResponseBody
    Map<String, ? extends Object> getRegionales(
	    @ModelAttribute("solicitud") SolicitudRecoleccion solicitud,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<TreeExtJS> lista = null;
	try {
	    lista = new ArrayList<TreeExtJS>();
	    TreeExtJS countryTree = new TreeExtJS();

	    countryTree.setId("R-CVA");
	    countryTree.setText("Cuernavaca");
	    countryTree.setLeaf(false);
	    countryTree.setIconCls("folder");
	    lista.add(countryTree);

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

    @RequestMapping("/getPlazas")
    public @ResponseBody
    Map<String, ? extends Object> getPlazas(
	    @ModelAttribute("solicitud") SolicitudRecoleccion solicitud,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<TreeExtJS> lista = null;
	try {
	    lista = new ArrayList<TreeExtJS>();
	    TreeExtJS countryTree = new TreeExtJS();

	    countryTree.setId("P-CVA1");
	    countryTree.setText("Cuernavaca");
	    countryTree.setLeaf(false);
	    countryTree.setIconCls("folder");
	    lista.add(countryTree);
	    countryTree = new TreeExtJS();
	    countryTree.setId("CVA2");
	    countryTree.setText("Cuernavaca2");
	    countryTree.setLeaf(false);
	    countryTree.setIconCls("folder");
	    lista.add(countryTree);

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

    @RequestMapping("/getRutas")
    public @ResponseBody
    Map<String, ? extends Object> getRutas(
	    @ModelAttribute("solicitud") SolicitudRecoleccion solicitud,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<TreeExtJS> lista = null;
	try {
	    lista = new ArrayList<TreeExtJS>();
	    TreeExtJS countryTree = new TreeExtJS();

	    countryTree.setId("RU-RUTA1");
	    countryTree.setText("Cuernavaca");
	    countryTree.setLeaf(false);
	    countryTree.setIconCls("folder");
	    lista.add(countryTree);
	    countryTree = new TreeExtJS();
	    countryTree.setId("RUTA2");
	    countryTree.setText("Cuernavaca2");
	    countryTree.setLeaf(false);
	    countryTree.setIconCls("folder");
	    lista.add(countryTree);

	    lista.add(countryTree);
	    countryTree = new TreeExtJS();
	    countryTree.setId("RUTA3");
	    countryTree.setText("Cuernavaca3");
	    countryTree.setLeaf(false);
	    countryTree.setIconCls("folder");
	    lista.add(countryTree);

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

    @RequestMapping("/getDatosProgramacion")
    public @ResponseBody
    Map<String, ? extends Object> getDatosProgramacion(
	    @ModelAttribute("solicitud") SolicitudRecoleccion solicitud,
	    @ModelAttribute("tiporecol") int tiporecol,
	    HttpServletRequest request) throws Exception {

	if (tiporecol == 1) {
	    return getDatosDiasSemana(solicitud, request);
	} else if (tiporecol == 2) {
	    return getDatosDiasMes(solicitud, request);
	}
	return null;

    }

    @RequestMapping("/getDatosDiasSemana")
    public @ResponseBody
    Map<String, ? extends Object> getDatosDiasSemana(
	    @ModelAttribute("solicitud") SolicitudRecoleccion solicitud,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<DiasSemanaMes> lista = null;
	try {
	    solicitud.setIdtiporecol(Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA);
	    lista = iSolicitudRecoleccionBO.getProgramacion(solicitud);

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

    @RequestMapping("/getDatosDiasMes")
    public @ResponseBody
    Map<String, ? extends Object> getDatosDiasMes(
	    @ModelAttribute("solicitud") SolicitudRecoleccion solicitud,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	List<DiasSemanaMes> lista = null;
	try {
	    solicitud.setIdtiporecol(Estatus.RECOL_PROGRAMADA_X_DIA_MES);
	    lista = iSolicitudRecoleccionBO.getProgramacion(solicitud);

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

    @RequestMapping("/insertDiaMes")
    public @ResponseBody
    Map<String, ? extends Object> insertDiaMes(
	    @ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    iSolicitudRecoleccionBO
		    .insertDiasMesSolicitudRecoleccion(diasSemanaMes);
	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	} catch (DataAccessException dae) {
	    modelMap.put("success", false);
	    mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
	    if (dae.getMessage().contains("duplicate key")) {
		mensaje += ". Los cambios serán deshechos, verifique.";
	    }

	}
	return modelMap;
    }

    @RequestMapping("/insertDiaSemana")
    public @ResponseBody
    Map<String, ? extends Object> insertDiaSemana(
	    @ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    iSolicitudRecoleccionBO
		    .insertDiasSemanaSolicitudRecoleccion(diasSemanaMes);
	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	} catch (DataAccessException dae) {
	    modelMap.put("success", false);
	    mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
	    if (dae.getMessage().contains("duplicate key")) {
		mensaje += ". Los cambios serán deshechos, verifique.";
	    }

	}
	return modelMap;
    }

    @RequestMapping("/updateDiaMes")
    public @ResponseBody
    Map<String, ? extends Object> updateDiaMes(
	    @ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    iSolicitudRecoleccionBO
		    .updateDiasMesSolicitudRecoleccion(diasSemanaMes);
	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	} catch (DataAccessException dae) {
	    modelMap.put("success", false);
	    mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
	    if (dae.getMessage().contains("duplicate key")) {
		mensaje += ". Los cambios serán deshechos, verifique.";
	    }

	}
	return modelMap;
    }

    @RequestMapping("/updateDiaSemana")
    public @ResponseBody
    Map<String, ? extends Object> updateDiaSemana(
	    @ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    iSolicitudRecoleccionBO
		    .updateDiasSemanaSolicitudRecoleccion(diasSemanaMes);
	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	} catch (DataAccessException dae) {
	    modelMap.put("success", false);
	    mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
	    if (dae.getMessage().contains("duplicate key")) {
		mensaje += ". Los cambios serán deshechos, verifique.";
	    }

	}
	return modelMap;
    }

    @RequestMapping("/deleteDiaMes")
    public @ResponseBody
    Map<String, ? extends Object> deleteDiaMes(
	    @ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {

	    UtilsRequest.displayParametros(request);
	    String[] ids = diasSemanaMes.getIdsolicitud().split(",");
	    int idregistro = -1;
	    for (String identificador : ids) {
		try {
		    idregistro = Integer.parseInt(identificador);
		    diasSemanaMes.setIdregistro(idregistro);
		    iSolicitudRecoleccionBO
			    .deleteDiasMesSolicitudRecoleccion(diasSemanaMes);
		} catch (Exception e) {
		    logger.debug("No se pudo convertir el identificador a integer:"
			    + identificador);
		}

	    }

	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	} catch (DataAccessException dae) {
	    modelMap.put("success", false);
	    mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
	    if (dae.getMessage().contains("duplicate key")) {
		mensaje += ". Los cambios serán deshechos, verifique.";
	    }

	}
	return modelMap;
    }

    @RequestMapping("/deleteDiaSemana")
    public @ResponseBody
    Map<String, ? extends Object> deleteDiaSemana(
	    @ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	try {
	    UtilsRequest.displayParametros(request);
	    String[] ids = diasSemanaMes.getIdsolicitud().split(",");
	    int idregistro = -1;
	    for (String identificador : ids) {
		try {
		    idregistro = Integer.parseInt(identificador);
		    diasSemanaMes.setIdregistro(idregistro);
		    iSolicitudRecoleccionBO
			    .deleteDiasSemanaSolicitudRecoleccion(diasSemanaMes);
		} catch (Exception e) {
		    logger.debug("No se pudo convertir el identificador a integer:"
			    + identificador);
		}

	    }
	    modelMap.put("success", true);
	    modelMap.put("message", mensaje);
	} catch (DataAccessException dae) {
	    modelMap.put("success", false);
	    mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
	    if (dae.getMessage().contains("duplicate key")) {
		mensaje += ". Los cambios serán deshechos, verifique.";
	    }

	}
	return modelMap;
    }

    @RequestMapping("/borrarProgramacion")
    public @ResponseBody
    Map<String, ? extends Object> borrarProgramacion(
	    @ModelAttribute("solicitud") DiasSemanaMes diasSemanaMes,
	    @ModelAttribute("tiporecol") int tiporecol,
	    HttpServletRequest request) throws Exception {

	if (tiporecol == 1) {
	    return deleteDiaSemana(diasSemanaMes, request);
	} else if (tiporecol == 2) {
	    return deleteDiaMes(diasSemanaMes, request);
	}
	return null;

    }

}
