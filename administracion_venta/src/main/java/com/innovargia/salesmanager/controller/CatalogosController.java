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
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.NivelUsuarioDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.dtos.WallPaperDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.IAgrupamientoJerarquiaBO;
import com.innovargia.salesmanager.ibo.IBancoBO;
import com.innovargia.salesmanager.ibo.IClavesExcepcionBO;
import com.innovargia.salesmanager.ibo.ICodigosPostalesBO;
import com.innovargia.salesmanager.ibo.ICondicionesPagoBO;
import com.innovargia.salesmanager.ibo.IFormaPagoBO;
import com.innovargia.salesmanager.ibo.IGrupoClienteBO;
import com.innovargia.salesmanager.ibo.IMetodoPagoBO;
import com.innovargia.salesmanager.ibo.INivelUsuarioBO;
import com.innovargia.salesmanager.ibo.IOficinaControlBO;
import com.innovargia.salesmanager.ibo.IParametrosSistemaBO;
import com.innovargia.salesmanager.ibo.IPlazaBO;
import com.innovargia.salesmanager.ibo.IPoblacionPagoBO;
import com.innovargia.salesmanager.ibo.IRegimenBO;
import com.innovargia.salesmanager.ibo.ITerminoPagoBO;
import com.innovargia.salesmanager.ibo.ITipoConvenioBO;
import com.innovargia.salesmanager.ibo.ITipoFormatoEmpaqueBO;
import com.innovargia.salesmanager.ibo.IUnidadAdministrativaBO;
import com.innovargia.salesmanager.ibo.IWallPaperBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;

/**
 * @author Adrián
 * 
 */
@RequestMapping("/catalogos/datos")
@Controller
public class CatalogosController {

	private static final Logger logger = LoggerFactory
			.getLogger(CatalogosController.class);

	@Autowired
	IAdicionalesBO iAdicionalesBO;
	@Autowired
	ICondicionesPagoBO icondicionesPagoBO;
	@Autowired
	IFormaPagoBO iformasPagoBO;
	@Autowired
	IGrupoClienteBO igrupoclienteBO;
	@Autowired
	IMetodoPagoBO imetodoPagoBO;
	@Autowired
	IOficinaControlBO ifocinaControlBO;
	@Autowired
	IPoblacionPagoBO ipoPoblacionPagoBO;
	@Autowired
	ITipoConvenioBO itipoConvenioBO;
	@Autowired
	IUnidadAdministrativaBO iUnidadAdministrativaBO;
	@Autowired
	ITerminoPagoBO iTerminoPago;
	@Autowired
	IPlazaBO iPlazaBO;
	@Autowired
	IRegimenBO iRegimenBO;
	@Autowired
	IWallPaperBO iWallPaperBO;
	@Autowired
	ICodigosPostalesBO iCodigosPostalesBO;
	@Autowired
	INivelUsuarioBO iNivelUsuarioBO;
	
	@Autowired
	IAgrupamientoJerarquiaBO iAgrupamientoJerarquiaBO;
	
	@Autowired
	IParametrosSistemaBO iParametrosSistemaBO;

	@Autowired
	IClavesExcepcionBO iClavesExcepcionBO;
	
	@Autowired
	ITipoFormatoEmpaqueBO iTipoFormatoEmpaqueBO;
	@Autowired
	IBancoBO iBancoBO;
	/**
	 * 
	 */
	public CatalogosController() {
		// TODO Auto-generated constructor stub
	}

	
	@RequestMapping("/getBancos")
	public @ResponseBody
	Map<String, ? extends Object> getBancos(HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		try {
			lista = iBancoBO.getRegistros();
			modelMap.put("message", "success");
		} catch (DataAccessException dae) {
			modelMap.put("message", dae.getMessage());

		}
		
		
		modelMap.put("proxiArray", lista);
		modelMap.put("totalCount", lista.size());
		modelMap.put("success", "true");
		
		return modelMap;

	}
	@RequestMapping("/getTiposEmpaques")
	public @ResponseBody
	Map<String, ? extends Object> getTiposEmpaques(HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		try {
			lista = iTipoFormatoEmpaqueBO.getRegistros(null);
			modelMap.put("message", "success");
		} catch (DataAccessException dae) {
			modelMap.put("message", dae.getMessage());

		}
		
		
		modelMap.put("proxiArray", lista);
		modelMap.put("totalCount", lista.size());
		modelMap.put("success", "true");
		
		return modelMap;

	}
	
	/**
	 * Obtiene los datos de un catalogo de agrupamientos disponibles
	 * 
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAgrupamientos")
	public @ResponseBody
	Map<String, ? extends Object> getAgrupamientos(HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<AgrupamientoDTO> lista = new ArrayList<AgrupamientoDTO>();
		try {
			lista = iAgrupamientoJerarquiaBO.getRegistros(null);
			modelMap.put("message", "success");
		} catch (DataAccessException dae) {
			modelMap.put("message", dae.getMessage());

		}
		
		
		modelMap.put("proxiArray", lista);
		modelMap.put("totalCount", lista.size());
		modelMap.put("success", "true");
		
		return modelMap;

	}
	
	/**
	 * Obtiene los datos de un catalogo, solo los registros que estan activos
	 * 
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getWallPapers")
	public @ResponseBody
	Map<String, ? extends Object> getWallPapers(
			@RequestParam(value = "idsistema", required = true) String idsistema,
			HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<WallPaperDTO> list_wallpaper = new ArrayList<WallPaperDTO>();
		try {
			WallPaperDTO wallpaper = new WallPaperDTO();
			wallpaper.setIdaplicacion(idsistema);
			list_wallpaper = iWallPaperBO.getRegistros(wallpaper);
			modelMap.put("message", "success");
		} catch (DataAccessException dae) {
			modelMap.put("message", dae.getMessage());

		}
		
		
		modelMap.put("proxiArray", list_wallpaper);
		modelMap.put("totalCount", list_wallpaper.size());
		modelMap.put("success", "true");
		
		return modelMap;

	}
	
	
	/**
	 * Obtiene los datos de un catalogo, solo los registros que estan activos
	 * 
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatosUsuario")
	public @ResponseBody
	Map<String, ? extends Object> getDatosUsuario(
					HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			lista.add(usuario);
			String wallpaper = iParametrosSistemaBO.getValorPropiedad(ConstantesAdminSale.WALLPAPER_PARAMETRO, ConstantesAdminSale.ID_APP);
			
			if (wallpaper==null){
				wallpaper =ConstantesAdminSale.WALLPAPER_DEFAULT;
			}

			modelMap.put("wallpaper_default_windows", wallpaper);
			modelMap.put("nombre_usuario_windows", usuario.getNombre());
			modelMap.put("perfil_usuario_windows", usuario.perfil_Dto.getDescripcion_perfil());
			modelMap.put("descripcionpuesto", usuario.getDescripcionpuesto());
			modelMap.put("login_usuario_windows", usuario.getLogin());
			modelMap.put("cliente_usuario_windows",usuario.getNumCliente());
			modelMap.put("plaza_usuario", usuario.getSiglasPlaza());
			modelMap.put("oficina_usuario", usuario.getIdoficina());
			modelMap.put("numempleado_usuario", usuario.getNumempleado());
			
			
			//Setea el wallpaper ya sea el default o el del usuario 
			if ((usuario.getWallpaper()==null) || (usuario.getWallpaper().trim().length()<=0)) {
				usuario.setWallpaper(wallpaper);
			}
			modelMap.put("usuario_wallpaper_windows",usuario.getWallpaper()!=null?usuario.getWallpaper():wallpaper);
			modelMap.put("usuario_up",usuario.getPassword());
			
			modelMap.put("jerarquia_usuario_windows", usuario.getDesperfil());
			modelMap.put("message", "success");
		} catch (DataAccessException dae) {
			modelMap.put("message", dae.getMessage());

		}
		modelMap.put("proxiArray", lista);
		modelMap.put("totalCount", lista.size());
		modelMap.put("success", "true");
		
		return modelMap;

	}
	

	/**
	 * Obtiene los datos de un catalogo, solo los registros que estan activos
	 * 
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatos")
	public @ResponseBody
	Map<String, ? extends Object> getDatos(
			@RequestParam(value = "idtabla", required = true) int idtabla,
			HttpServletRequest request)

	throws Exception {
		boolean success = false;
		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {
			switch (idtabla) {
			case 1: //
				
				break;

			default:
				break;
			}

			success = true;
			modelMap.put("success", success);
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
	 * Obtiene los datos que se buscan de codigos postales
	 * 
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatosCodigoPostal")
	public @ResponseBody
	Map<String, ? extends Object> getDatosCodigoPostal(	HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		String tipo_str = request.getParameter("tipobusqueda");
		String patron_busqueda = request.getParameter("patron");
		BusquedaDTO busquedaDTO = new BusquedaDTO();
		List<DireccionDTO>   lista = new ArrayList<DireccionDTO>(); 
		

		try {
			if ((tipo_str!=null) && (tipo_str.length()>0)){
				busquedaDTO.setTipo_str(tipo_str);
				busquedaDTO.setPatron_busqueda(patron_busqueda);
					lista = iCodigosPostalesBO.getRegistros(busquedaDTO);
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
	
	/**
	 * Obtiene los niveles de usuarios disponibles
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getNivelUsuario")
	public @ResponseBody
	Map<String, ? extends Object> getNivelUsuario(	
			@RequestParam(value = "vertodos", required = false) String vertodos,
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<NivelUsuarioDTO>   lista = new ArrayList<NivelUsuarioDTO>(); 
		//CatalogoDTO catalogo = new CatalogoDTO();

		try {
			/*if (vertodos!=null){
				//Obtiene todos los niveles disponibles
				catalogo.setEstatus(1);
			}else{
				//Obtiene solo los niveles visibles en toda la aplicacion
				//donde visiblesiempre=1
				catalogo.setEstatus(-1);
			}*/
		
			lista = iNivelUsuarioBO.getRegistros(null);
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
	
	

	/***
	 * Obtiene la cobertura de un registro
	 * @param idcoorigen
	 * @param idcodestino
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCoberturaCotizacion")
	public @ResponseBody
	Map<String, ? extends Object> getCoberturaCotizacion(
			@RequestParam(value = "idcoorigen", required = false) String idcoorigen,
			@RequestParam(value = "idcodestino", required = false) String idcodestino,
			HttpServletRequest request) throws Exception {
				 
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		LogHistoriaDTO historia = new LogHistoriaDTO();
		
		try {
			CruceCoberturaDTO cobertura = new CruceCoberturaDTO();
			cobertura.setIdcoorigen(idcoorigen);
			cobertura.setIdcodestino(idcodestino);
			
			cobertura = iPlazaBO.getCobertura(cobertura);

			if (cobertura!=null){
			
				modelMap.put("kms", cobertura.getKms());
			}
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
	}

}
