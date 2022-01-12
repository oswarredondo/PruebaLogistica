/**
 * 
 */
package com.innovargia.salesmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.AgendaOR;
import com.administracion.ibo.IAttachmentNotaBO;
import com.administracion.ibo.IDocumentoServicioBO;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IAgendaBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.dtos.DocumentoConsultaDTO;

/**
 * @author Adrián
 * /agendarastreo/getDatos
 *
 */
@RequestMapping("/agendarastreo")
@Controller
public class AgendaRastreoController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AgendaRastreoController.class);
	
	@Autowired
	IAgendaBO bo;
	
	@Autowired
	IDocumentoServicioBO iDocumentoServicioBO;
	
	@Autowired
	IAttachmentNotaBO iAttachmentNotaBO;
	
	/**
	 * 
	 */
	public AgendaRastreoController() {
		// TODO Auto-generated constructor stub
	}	

    @RequestMapping("/getDatos")
    public @ResponseBody
    Map<String, ? extends Object> getDatos(HttpServletRequest request)
	    throws Exception {

	
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	AgendaOR objeto = new AgendaOR();

	List<AgendaOR> lista = null;
	try {
	    UsuarioDTO usuario = ConstantesAdminSale.getSession(request
		    .getSession(true));
	    if (usuario != null) {
		if (request.getParameter("tipobusqueda")!=null){
		    objeto.setTipo(request.getParameter("tipobusqueda"));
		    String patronbusqueda = request.getParameter("iddatoabuscar")==null?"": request.getParameter("iddatoabuscar"); 
		    objeto.setIddocumento(patronbusqueda); 
		    objeto.setFolio(patronbusqueda);
		    objeto.setQuiensolicita(patronbusqueda); 
		    objeto.setTelefonosolicita(patronbusqueda); 
		    lista = bo.getRegistros(objeto);
		}else{
		    lista = new ArrayList<AgendaOR>();
		}
		
	    } else {
		lista = new ArrayList<AgendaOR>();
		logger.debug(ConstantesAdminSale.MSG_SESSION_FINISH);
	    }

	    modelMap.put("success", true);
	    modelMap.put("message", "Consulta Realizada:" + lista.size());
	    modelMap.put("totalCount", lista.size());
	    modelMap.put("proxiArray", lista);

	} catch (DataAccessException dae) {
	    modelMap.put("success", false);
	    modelMap.put("message", dae.getMessage());

	}
	return modelMap;

    }
	
    @RequestMapping("/insert")
    public @ResponseBody
    Map<String, ? extends Object> insert(
	    @ModelAttribute("orden") AgendaOR orden,
	    HttpServletRequest request) throws Exception {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();


		try {
		    	String cb_entrega=request.getParameter("cb-entrega"), 
		    		cb_historia=request.getParameter("cb-historia"), 
		    		rb_plaza=request.getParameter("rb_plaza");
		    	
			
		    	 UsuarioDTO usuario = ConstantesAdminSale.getSession(request
				    .getSession(true));
		    	 
			//Agrega la entrega al comentario
		    	cb_entrega = cb_entrega==null?"false":"true";
		    	String nota  = request.getParameter("nota")==null?"":request.getParameter("nota").trim().toUpperCase();
		    	nota = UtilsStringFechas.convierteCadena(nota);
			if ("true".equals(cb_entrega)){
			    DocumentoConsultaDTO docto = iDocumentoServicioBO.getInfoGuia(orden.getIddocumento());
			    if (docto!=null){
				 if(docto.getQuienRecibe()!=null){
					nota += "\nConfirmación Engtrega:";
					nota += "\n" + "Quién Recibe:" + docto.getQuienRecibe() + ", Fecha Entrega:" + docto.getFechaConfirmacion();
				    }
			    }
			   
			    
			}
			//Agrega el ultimo registo de historia a la nota
			cb_historia = cb_historia==null?"false":"true";
			if ("true".equals(cb_historia)){
			    List<LogHistoriaDTO> historia = iDocumentoServicioBO.getHistoriaDocumento(orden.getIddocumento(), null);
			  
			    if(historia.size()>0){
				nota += "\nUltimo Registro Historia:";
				nota += "\n" + historia.get(0).getIdregistro() + " - " + historia.get(0).getDescripcion() + " - "  +
					 historia.get(0).getExclave() + " - "  +  historia.get(0).getFecha()+ " - "  +
					 historia.get(0).getPlazaorigina();
			    }
			    
			    
			}
			if (orden.getIddocumento().isEmpty()){
			    orden.setIddocumento("");
			}
			if (orden.getDatosorigen().isEmpty()){
			    orden.setDatosorigen("");
			}
			if (orden.getDatosdestino().isEmpty()){
			    orden.setDatosdestino("");
			}
			 //Folio
			orden.setEstatus("ABIERTA");
			orden.setQuiencaptura(usuario.getLogin());
		    	int folio = bo.insert(orden);
		    	
		    	//Agrega la nota del registro
		    	orden.setFolio(folio);
		    	AttachmentDTO catalogo = new AttachmentDTO();
		    	catalogo.setIddocumento(orden.getIddocumento());
		    	catalogo.setDescripcion(nota);
		    	catalogo.setFolio(folio);
		    	catalogo.setIdtipodocumento("AGENDAOR");
		    	catalogo.setIdentidad(usuario.entidad.getIdentidad());
		    	catalogo.setIdorganizacion(usuario.organizacion.getIdorganizacion());
		    	catalogo.setLogin(usuario.getLogin());
		    	iAttachmentNotaBO.insertNotaAgenda(catalogo, null);
		    	 
			modelMap.put("success", true);
			modelMap.put("message", "Se creo la orden:" + folio);
			modelMap.put("folio", folio);
		} catch (Exception dae) {
			modelMap.put("success", false);
			String mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (mensaje.contains("duplicate key") ||  
				mensaje.contains("llave duplicada") || 
				mensaje.contains("Registro Duplicado")){

			    mensaje= "Guía ya tiene asignada una orden de en la agenda." + mensaje;
			}
			modelMap.put("message", mensaje);

		}
		return modelMap;
	}

	@RequestMapping("/update")
	public @ResponseBody
	Map<String, ? extends Object> update(
		  @ModelAttribute("orden") AgendaOR orden,
		HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {
			bo.update(orden);
			modelMap.put("success", false);
			modelMap.put("message", "El folio " + orden.getFolio() + " fue actualizado.");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	@RequestMapping("/updateAtiende")
	public @ResponseBody
	Map<String, ? extends Object> updateAtiende(
		  @ModelAttribute("orden") AgendaOR orden,
		HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		 UsuarioDTO usuario = ConstantesAdminSale.getSession(request
			    .getSession(true));
		 
		try {
		    
			bo.updateAsignadoAtiende(orden);
			
			AttachmentDTO catalogo = new AttachmentDTO();
		    	catalogo.setIddocumento(orden.getFolio()+"");
		    	catalogo.setDescripcion("CASO ASIGNADO POR " + usuario.getLogin());
		    	catalogo.setFolio(orden.getFolio());
		    	catalogo.setIdtipodocumento("AGENDAOR");
		    	catalogo.setIdentidad(usuario.entidad.getIdentidad());
		    	catalogo.setIdorganizacion(usuario.organizacion.getIdorganizacion());
		    	catalogo.setLogin(usuario.getLogin());
		    	iAttachmentNotaBO.insertNotaAgenda(catalogo, null);
		    	
			modelMap.put("success", false);
			modelMap.put("message", "El folio " + orden.getFolio() + " fue actualizado.");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	@RequestMapping("/updateEstatus")
	public @ResponseBody
	Map<String, ? extends Object> updateEstatus(
		  @ModelAttribute("orden") AgendaOR orden,
		HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		 UsuarioDTO usuario = ConstantesAdminSale.getSession(request
			    .getSession(true));
		 
		try {
			bo.updateEstatus(orden);
			
			  
			    AttachmentDTO catalogo = new AttachmentDTO();
			    	catalogo.setIddocumento(orden.getFolio()+"");
			    	catalogo.setDescripcion("CASO FUE " + orden.getEstatus() + " por " + usuario.getLogin());
			    	catalogo.setFolio(orden.getFolio());
			    	catalogo.setIdtipodocumento("AGENDAOR");
			    	catalogo.setIdentidad(usuario.entidad.getIdentidad());
			    	catalogo.setIdorganizacion(usuario.organizacion.getIdorganizacion());
			    	catalogo.setLogin(usuario.getLogin());
			    	iAttachmentNotaBO.insertNotaAgenda(catalogo, null);
			    	
			modelMap.put("success", false);
			modelMap.put("message", "El folio " + orden.getFolio() + " fue actualizado.");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	@RequestMapping("/reabircaso")
	public @ResponseBody
	Map<String, ? extends Object> reabircaso(
		  @ModelAttribute("orden") AgendaOR orden,
		HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		 UsuarioDTO usuario = ConstantesAdminSale.getSession(request
			    .getSession(true));
		 
		try {
		    	orden.setEstatus("REABIERTO");
			bo.updateEstatus(orden);
			
			//Agrega la nota del registro
		    	orden.setFolio(orden.getFolio());
		    	AttachmentDTO catalogo = new AttachmentDTO();
		    	catalogo.setIddocumento(orden.getFolio()+"");
		    	catalogo.setDescripcion("USUARIO " +  usuario.getLogin() + " reabrio el caso de reastreo.");
		    	catalogo.setFolio(orden.getFolio());
		    	catalogo.setIdtipodocumento("AGENDAOR");
		    	catalogo.setIdentidad(usuario.entidad.getIdentidad());
		    	catalogo.setIdorganizacion(usuario.organizacion.getIdorganizacion());
		    	catalogo.setLogin(usuario.getLogin());
		    	iAttachmentNotaBO.insertNotaAgenda(catalogo, null);
		    	
			modelMap.put("success", false);
			modelMap.put("message", "El folio " + orden.getFolio() + " fue Reabierto.");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	
	@RequestMapping("/updateCierre")
	public @ResponseBody
	Map<String, ? extends Object> updateCierre(
		  @ModelAttribute("orden") AgendaOR orden,
		HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		 UsuarioDTO usuario = ConstantesAdminSale.getSession(request
			    .getSession(true));
		 
		try {
		    orden.setFechacierre(UtilsStringFechas.formatoStrFecha(
			    orden.getFechacierre(), "dd-MM-yyyy",
				"yyyy-MM-dd"));
		    
		    if (orden.getTiposolucion().isEmpty()){
			 orden.setEstatus("CANCELADO");
			 orden.setTiposolucion("CANCELADO");
		    }else{
			 orden.setEstatus("CERRADO");
		    }
		    bo.updateDatosCierre(orden);
		    
		    AttachmentDTO catalogo = new AttachmentDTO();
		    	catalogo.setIddocumento(orden.getFolio()+"");
		    	catalogo.setDescripcion("CASO FUE " + orden.getEstatus() + " por " + usuario.getLogin());
		    	catalogo.setFolio(orden.getFolio());
		    	catalogo.setIdtipodocumento("AGENDAOR");
		    	catalogo.setIdentidad(usuario.entidad.getIdentidad());
		    	catalogo.setIdorganizacion(usuario.organizacion.getIdorganizacion());
		    	catalogo.setLogin(usuario.getLogin());
		    	iAttachmentNotaBO.insertNotaAgenda(catalogo, null);
		    	
			
			
			modelMap.put("success", true);
			modelMap.put("message", "El folio " + orden.getFolio() + " fue actualizado.");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	@RequestMapping("/delete")
	public @ResponseBody
	Map<String, ? extends Object> delete(
		  @ModelAttribute("orden") AgendaOR orden,
		HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {
			bo.delete(orden);
			modelMap.put("success", false);
			modelMap.put("message", "El folio " + orden.getFolio() + " fue eliminado.");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	
	
	
}
