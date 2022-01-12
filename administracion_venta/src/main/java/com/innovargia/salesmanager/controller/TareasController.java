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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.TareaDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IAgrupamientoJerarquiaBO;
import com.innovargia.salesmanager.ibo.ITareasBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;

/**
 * @author Adrián
 *
 */
@RequestMapping("/tareas")
@Controller
public class TareasController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(TareasController.class);
	
	@Autowired
	ITareasBO bo;
	@Autowired
	IAgrupamientoJerarquiaBO iAgrupamientoJerarquiaBO;
	
	/**
	 * 
	 */
	public TareasController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Obtiene todas las tareas existentes
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getUsuariosDiusponiblesPorNivelUsuarioSesion")
	public @ResponseBody
	Map<String, ? extends Object> getUsuariosDiusponiblesPorNivelUsuarioSesion(HttpServletRequest request)throws Exception {
	

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<UsuarioCuentaDTO> lista =new ArrayList<UsuarioCuentaDTO>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			boolean mostrarSoloUsuarioConNivelSuperior = 
					(request.getParameter("mostrarSoloUsuarioConNivelSuperior")==null)||
					(!"true".equals(request.getParameter("mostrarSoloUsuarioConNivelSuperior")))?false:true;
			
			//Indica el paramegtro a 0 para devuelve todos los registros
			lista = iAgrupamientoJerarquiaBO.getNivelSuperiorDelUsuario(usuario,0,mostrarSoloUsuarioConNivelSuperior);

			if (lista==null){
				lista =new ArrayList<UsuarioCuentaDTO>();
			}
			modelMap.put("success", true);
			modelMap.put("message", "Se envian datos de usuario");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	/**
	 * Obtiene todas las tareas existentes
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTareasExistentes")
	public @ResponseBody
	Map<String, ? extends Object> getTareasExistentes(HttpServletRequest request)throws Exception {
	
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<TareaDTO> lista =null;
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			lista = bo.getExistentes();
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	/**
	 * Obtiene todas las tareas del usuario en sesion
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTareaUsuarioSesion")
	public @ResponseBody
	Map<String, ? extends Object> getTareaUsuarioSesion(HttpServletRequest request)throws Exception {
	
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<TareaDTO> lista =null;
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			lista = bo.getAsignadasAlUsuario(usuario);
			success = true;
			modelMap.put("success", success);
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
	 * Obtiene todas las tareas del usuario en sesion
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTareasAsociadas")
	public @ResponseBody
	Map<String, ? extends Object> getTareasAsociadas(HttpServletRequest request)throws Exception {
	
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<TareaDTO> lista =null;
		TareaDTO tarea = new TareaDTO();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			tarea.setIdtareaorigina(request.getParameter("idtareaorigina"));
			lista = bo.getTareasAsociadas(tarea);
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	/**
	 * Obtiene todas las tareas del usuario en sesion
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTareasCreadasXElUsuario")
	public @ResponseBody
	Map<String, ? extends Object> getTareasCreadasXElUsuario(HttpServletRequest request)throws Exception {
	
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<TareaDTO> lista =null;

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			UsuarioDTO usuario_busca = new UsuarioDTO();
			usuario_busca.setLogin(request.getParameter("login") );
			
			lista = bo.getCreadasPorElUsuario(usuario_busca);
			success = true;
			modelMap.put("success", success);
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
	 * Obtiene todas las tareas del usuario de tipo "SOLICITUD"
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCreadasPorElUsuarioDeUnTipo")
	public @ResponseBody
	Map<String, ? extends Object> getCreadasPorElUsuarioDeUnTipo(HttpServletRequest request)throws Exception {
	
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<TareaDTO> lista =null;

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			UsuarioDTO usuario_busca = new UsuarioDTO();
			usuario_busca.setLogin(request.getParameter("login") );
			//Si no se indico un usuario se toma por default el del usuario de sesion
			if (usuario_busca.getLogin()==null){
				usuario_busca.setLogin(usuario.getLogin());
			}
			//Por default devuelve las solicitudes
			if (request.getParameter("tipo") == null){
				lista = bo.getCreadasPorElUsuarioDeUnTipo(usuario_busca, ConstantesAdminSale.TIPO_NOTIFICACION_SOLICITUD);
			}else{
				//Busca el tipo indicado
				lista = bo.getCreadasPorElUsuarioDeUnTipo(usuario_busca, request.getParameter("tipo"));
			}
			
			success = true;
			modelMap.put("success", success);
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
	 * Obtiene los datos de un catalogo, solo los registros que estan activos
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insert")
	public @ResponseBody
	Map<String, ? extends Object> insert(HttpServletRequest request)throws Exception {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		TareaDTO tarea = new TareaDTO();
		
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		UtilsRequest.displayParametros(request);
		try {
			if (usuario==null){
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			if (request.getParameter("estatus")!=null ){
				tarea.setEstatus(request.getParameter("estatus"));
			}else{
				tarea.setEstatus("ABIERTA");
			}
			tarea.setTitulo(request.getParameter("titulo") );
			tarea.setIdtareaorigina(request.getParameter("idtareaorigina") );
			tarea.setIdusuariogenero(usuario.getLogin());
			tarea.setIdusuarioresponsable(request.getParameter("idusuarioresponsable")  );
			tarea.setImportancia(request.getParameter("importancia") );
			tarea.setSolicitud(request.getParameter("solicitud"));
			tarea.setSolucion(request.getParameter("solucion"));
			tarea.setTipo(request.getParameter("tipo"));
			tarea.setAmbito(request.getParameter("ambito") );
			
			
			
			
			String fechaexpira = 
					UtilsStringFechas.formatoStrFecha(request.getParameter("fechaexpira"), "dd-MM-yyyy", "yyyy-MM-dd");  
			if(fechaexpira!=null){
				tarea.setFechaexpira(fechaexpira +" 23:59:00" );
			}
			
			String idtareaambito = request.getParameter("idambitotarea")!=null?request.getParameter("idambitotarea").trim():"";
			String[] arr_idtareaambito = idtareaambito.split(",");
			tarea.setEnviarcorreo(request.getParameter("enviarcorreo"));
			for (String id : arr_idtareaambito) {
				tarea.setIdambitotarea(id);
				bo.insert(tarea);
			}

			
			modelMap.put("success", true);
			modelMap.put("message", "Se agrego correctamente la tarea.");
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
				
	}
	
	/**
	 * Actualiza datos de la tarea
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update")
	public @ResponseBody
	Map<String, ? extends Object> update(HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		TareaDTO tarea = new TareaDTO();
		UtilsRequest.displayParametros(request);
		     
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		
		try {
			if (usuario==null){
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			
			if (request.getParameter("estatus")!=null ){
				tarea.setEstatus(request.getParameter("estatus"));
			}else{
				tarea.setEstatus("ABIERTA");
			}
			tarea.setIdtarea(request.getParameter("idtarea") );
			tarea.setTitulo(request.getParameter("titulo") );
			tarea.setIdtareaorigina(request.getParameter("idtareaorigina") );
			tarea.setIdusuariogenero(usuario.getLogin());
			tarea.setIdusuarioresponsable(request.getParameter("idusuarioresponsable")  );
			tarea.setImportancia(request.getParameter("importancia") );
			tarea.setSolicitud(request.getParameter("solicitud"));
			tarea.setTipo(request.getParameter("tipo"));
			tarea.setAmbito(request.getParameter("ambito") );
			tarea.setSolucion(request.getParameter("solucion"));
			
			
			String fechaexpira = 
					UtilsStringFechas.formatoStrFecha(request.getParameter("fechaexpira"), "dd-MM-yyyy", "yyyy-MM-dd");  
			if(fechaexpira!=null){
				tarea.setFechaexpira(fechaexpira +" 23:59:00" );
			}
			
			String idtareaambito = request.getParameter("idambitotarea")!=null?request.getParameter("idambitotarea").trim():"";
			String[] arr_idtareaambito = idtareaambito.split(",");
			tarea.setEnviarcorreo(request.getParameter("enviarcorreo"));
			for (String id : arr_idtareaambito) {
			    	tarea.setIdusuarioresponsable(id);
				tarea.setIdambitotarea(id);
				bo.update(tarea);
			}
			
			modelMap.put("success", true);
			modelMap.put("message", "Se actualizo registro");
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	/**
	 * Actualiza datos de la tarea
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletRequest request)throws Exception {
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		TareaDTO tarea = new TareaDTO();
		
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		UtilsRequest.displayParametros(request);
		try {
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			if (ids!=null){
				String[] arr_idstarifas = ids.trim().split("\\|");
				for (String id : arr_idstarifas) {
					tarea.setIdtarea(id);
					
					try{
						bo.delete(tarea);
					}catch(Exception e){
						logger.error("Error:" + e.getMessage());
					}
					
				}
			}
			
			
			
			modelMap.put("success",true);
			modelMap.put("message",  "Se eliminio registro");
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
				
	}
	
	
	
	
	
}
