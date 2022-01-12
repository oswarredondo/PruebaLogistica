/**
 * 
 */
package com.innovargia.salesmanager.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.PerfilOpcionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IPerfilOpcionUsuarioBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;

/**
 * @author aruaro
 *
 */
@RequestMapping("/perfilopcion")
@Controller
public class PerfileOpcionController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PerfileOpcionController.class);

	@Autowired
	IPerfilOpcionUsuarioBO iPerfilOpcionUsuarioBO;
	/**
	 * 
	 */
	public PerfileOpcionController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * Obtiene las  opciones de un perfil de una entidad, isSeleccionados=true indica si 
	 * devuelve las opciones agregadas a un perfil , isSeleccionados=false devuelve 
	 * las opciones que no han sido agregadas a un perfil
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPerfilesEntidadOrganizacion")
	public @ResponseBody
	Map<String, ? extends Object> getPerfilesEntidadOrganizacion(HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<PerfilOpcionDTO> lista =null;
		boolean onlyActive= false;
		
		
		try{
			onlyActive= Boolean.parseBoolean(request.getParameter("onlyActive"));
		}catch(Exception e){
			
		}
		
		try {
			UsuarioDTO usuariosesion = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuariosesion == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.entidad.setIdentidad(request.getParameter("identidad") );
			usuario.organizacion.setIdorganizacion(request.getParameter("idorganizacion")  );
			
			lista  = iPerfilOpcionUsuarioBO.getPerfiles(usuario, onlyActive);
			modelMap.put("success", true);
			modelMap.put("message", "Se obtivieron los datos solicitados");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	
	/**
	 * Obtiene las  opciones de un perfil de una entidad, isSeleccionados=true indica si 
	 * devuelve las opciones agregadas a un perfil , isSeleccionados=false devuelve 
	 * las opciones que no han sido agregadas a un perfil
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/buscaPerfilOpciones")
	public @ResponseBody
	Map<String, ? extends Object> buscaPerfilOpciones(HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<PerfilOpcionDTO> lista =null;
		boolean isSeleccionados= true;

		try{
			isSeleccionados= Boolean.parseBoolean(request.getParameter("isSeleccionados"));
		}catch(Exception e){
			
		}
		

		try {
			UsuarioDTO usuariosesion = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuariosesion == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.entidad.setIdentidad(request.getParameter("identidad") );
			usuario.organizacion.setIdorganizacion(request.getParameter("idorganizacion")  );
			usuario.perfil_Dto.setIdperfil(request.getParameter("idperfil") );
			
			
			lista  = iPerfilOpcionUsuarioBO.getOpcionesPerfil(
					request.getParameter("idperfil"), 
					usuario, isSeleccionados, 
					ConstantesAdminSale.ID_SKY4SOL);
			
			modelMap.put("success", true);
			modelMap.put("message", "Se obtivieron los datos solicitados");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	/**
	 * Obtiene los datos de un catalogo, solo los registros que estan activos
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getInsertDeleteDetallePerfil")
	public @ResponseBody
	Map<String, ? extends Object> getDatosDetalleTipo(HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		String tipo = request.getParameter("tipo") ==null?"":request.getParameter("tipo");
		String identidad = request.getParameter("identidad") ==null?"":request.getParameter("identidad");
		String idorganizacion = request.getParameter("idorganizacion") ==null?"":request.getParameter("idorganizacion");
		String idperfil = request.getParameter("idperfil") ==null?"":request.getParameter("idperfil");
		String idmodulo = request.getParameter("idmodulo") ==null?"":request.getParameter("idmodulo");
		String idopcion = request.getParameter("idopcion") ==null?"":request.getParameter("idopcion");

		PerfilOpcionDTO perfilOpcionDTO = new PerfilOpcionDTO();
		try {
			perfilOpcionDTO.setIdentidad(identidad);
			perfilOpcionDTO.setIdorganizacion(idorganizacion);
			perfilOpcionDTO.setIdperfil(idperfil);
			perfilOpcionDTO.setIdsistema(ConstantesAdminSale.ID_SKY4SOL);
			perfilOpcionDTO.setIdmodulo(idmodulo);
			perfilOpcionDTO.setIdopcion(idopcion);

			if ((tipo.trim().length()>0) && 
				(identidad.trim().length()>0) && 
				(idorganizacion.trim().length()>0) && 
				(idperfil.trim().length()>0)
				){
				
				if (tipo.equals("delete")){
					iPerfilOpcionUsuarioBO.deleteOpcionPerfil(perfilOpcionDTO);
				}else if (tipo.equals("insert")){
					iPerfilOpcionUsuarioBO.addOpcionPerfil(perfilOpcionDTO);
				}
				success = true;
			}
			
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (Exception dae) {
		
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
				modelMap.put("error", dae.getMessage());

		}
		return modelMap;
		
	}
	
	/***
	 * Agrega un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertPerfil")
	public @ResponseBody
	Map<String, ? extends Object> insertPerfil(

			@RequestParam(value = "identidad", required = true) int identidad,
			@RequestParam(value = "idorganizacion", required = true) int idorganizacion,
			@RequestParam(value = "idperfil", required = false) String idperfil,
			@RequestParam(value = "nivel", required = false) String nivel,
			@RequestParam(value = "descripcion_perfil", required = true) String descripcion_perefil,
			HttpServletRequest request) throws Exception {


		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		
		UtilsRequest.displayParametros(request);
		PerfilOpcionDTO perfil = new PerfilOpcionDTO();
		perfil.setDescripcion_perfil(descripcion_perefil);	
		perfil.setIdentidad(identidad);
		perfil.setIdorganizacion(idorganizacion);
		perfil.setIdperfil(idperfil);
		perfil.setNivel(nivel);
		perfil.setIdsistema(ConstantesAdminSale.ID_SKY4SOL);
		try {
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			iPerfilOpcionUsuarioBO.add(perfil);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {

				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}

	
	/*** 
	 * Agrega un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatePerfil")
	public @ResponseBody
	Map<String, ? extends Object> updatePerfil(
			@RequestParam(value = "consecutivo", required = true) int consecutivo,
			@RequestParam(value = "identidad", required = true) int identidad,
			@RequestParam(value = "idorganizacion", required = true) int idorganizacion,
			@RequestParam(value = "idperfil", required = false) String idperfil,
			@RequestParam(value = "descripcion_perfil", required = true) String descripcion_perefil,
			@RequestParam(value = "nivel", required = true) String nivel,
			HttpServletRequest request) throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		
		UtilsRequest.displayParametros(request);
		PerfilOpcionDTO perfil = new PerfilOpcionDTO();
		perfil.setDescripcion_perfil(descripcion_perefil);	
		perfil.setIdentidad(identidad);
		perfil.setIdorganizacion(idorganizacion);
		perfil.setIdperfil(idperfil);
		perfil.setNivel(nivel);
		perfil.setConsecutivo(consecutivo);
		perfil.setEstatus("A");
		try {
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			iPerfilOpcionUsuarioBO.updatePerfil(perfil);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
	}
	
	/**
	 * Desactivan o Activa un registro 
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cambiarestatus")
	public @ResponseBody
	Map<String, ? extends Object> cambiarestatus(
			@RequestParam(value = "ids", required = true) String ids,
			@RequestParam(value = "estatus", required = true) String estatus,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		PerfilOpcionDTO documento = null;
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			if (ids != null) {
				String[] arr_idstarifas = ids.trim().split("\\|");
				for (String id : arr_idstarifas) {

					documento = new PerfilOpcionDTO();
					try {
						documento.setConsecutivo(id);
						documento.setEstatus(estatus);
						iPerfilOpcionUsuarioBO.updateEstado(documento);

					} catch (Exception e) {
						logger.error("Error:" + e.getMessage());
					}

				}
			}
			modelMap.put("success", true);
			modelMap.put("message",
					"Se cambio el estatus de los registros seleccionados.");

		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		
			
		
		return modelMap;
	}
}
