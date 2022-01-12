/**
 * 
 */
package com.innovargia.administracion.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.administracion.dto.Folios;
import com.administracion.extjs.dto.MenuItemSys;
import com.administracion.ibo.IFoliosBO;
import com.administracion.ibo.IParamsSistemaBO;
import com.innovargia.administracion.dao.impl.PasswordValidator;
import com.innovargia.administracion.ibo.IAdminPasswordBO;
import com.innovargia.administracion.ibo.IPerfilOpcionUsuarioBO;
import com.innovargia.administracion.ibo.IUsuarioBO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.PerfilOpcionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.dtos.WallPaperDTO;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.OficinasDTO;
import com.servicio.search.ibo.IBusquedaCuentasClientesBO;
import com.servicio.search.ibo.IBusquedaOficinasBO;
import com.servicio.search.ibo.IBusquedaWallPaperBO;

/**
 * @author Adri�n /acceso
 *
 */
@RequestMapping("/acceso")
@Controller
public class LoginLogOut {
	private static final Logger logger = LoggerFactory.getLogger(LoginLogOut.class);

	@Autowired
	IUsuarioBO iusuarioBO;
	@Autowired
	IPerfilOpcionUsuarioBO iPerfilOpcionUsuarioBO;
	@Autowired
	IBusquedaWallPaperBO iBusquedaWallPaperBO;

	@Autowired
	IParamsSistemaBO iParametrosSistemaBO;

	@Autowired
	IAdminPasswordBO iAdminPasswordBO;

	@Autowired
	IFoliosBO iFoliosBO;

	@Autowired
	IBusquedaOficinasBO iBusquedaOficinasBO;

	@Autowired
	IBusquedaCuentasClientesBO iBusquedaCuentasClientesBO;

	public LoginLogOut() {
	}

	@RequestMapping(value = "/check_sesion")
	public @ResponseBody Map<String, ? extends Object> check_sesion(HttpServletRequest request) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		// UtilsRequest.displayParametros(request);
		try {
			// Verifica sesion del usuario
			if (usuario == null) {

				// Se reconecta el sistema
				UsuarioDTO usuario_tmp = new UsuarioDTO();
				usuario_tmp.setLogin(UtilsStrings.nullChangeToUpperCase(request.getParameter("lo")));
				usuario_tmp.setPassword(request.getParameter("pa"));
				usuario_tmp = iusuarioBO.checkSesoinUsuarioLogin(usuario_tmp);

				if (usuario_tmp == null) {
					logger.debug("check_sesion:" + "Usuario no existe o los datos estan incorrectos");
					modelMap.put("message", "Usuario no existe o los datos estan incorrectos");
					modelMap.put("invalido", true);
				} else {
					if (!usuario_tmp.isActivo()) {
						logger.debug("check_sesion:"
								+ "Usuario esta dado de baja, verifique con el administrador del sistema.");
						modelMap.put("message",
								"Usuario esta dado de baja, verifique con el administrador del sistema.");
						modelMap.put("invalido", true);
					} else {
						logger.debug("check_sesion:" + "Reiniciando sesion");
						creaSesionCte(usuario_tmp, request);
						modelMap.put("message", "success");
					}
				}
			}
			modelMap.put("success", true);
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;

	}

	private void creaSesionCte(UsuarioDTO usuario, HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		session = request.getSession(true);
		session.setAttribute(ConstantesGenerales.USER_SESSION, usuario);
		try {
			BusquedaDTO busqueda = new BusquedaDTO();
			busqueda.setTipo(3);// por tipo de cuenta
			busqueda.setNumcliente(usuario.getNumCliente());
			busqueda.setPatron_busqueda(usuario.getNumCliente());
			busqueda.setIdentidad(usuario.entidad.getIdentidad());
			busqueda.setIdorganizacion(usuario.organizacion.getIdorganizacion());
			List<CuentasDTO> cuentas = iBusquedaCuentasClientesBO.getBusquedaRegistros(busqueda);
			if (cuentas.size() > 0) {
				session.setAttribute(ConstantesGenerales.USER_CTE_SESSION, cuentas.get(0));
			}

		} catch (Exception e) {
			logger.debug("No se logro crear el bjeto de sesion de la cuenta de cliente:" + e.getMessage());
		}

	}

	/**
	 * Obtiene las opciones del menu a las que tiene acceso el usuario
	 */
	@RequestMapping(value = "/opcionesmenuadministracionventa")
	public @ResponseBody Map<String, ? extends Object> opcionesmenuadministracionventa(
			@RequestParam("permiteModulo") String permiteModulo, HttpServletRequest request) {
		logger.info("Obteniendo opciones de usuario");
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		ArrayList<PerfilOpcionDTO> arr_perfiles = new ArrayList<PerfilOpcionDTO>();
		List<MenuItemSys> opciones = new ArrayList<MenuItemSys>();
		try {
			PerfilOpcionDTO perfil = iPerfilOpcionUsuarioBO.getOpcionesPerfilAccesoWin(usuario,
					ConstantesAutoDoc.ID_MODULO);

			// Obtiene las opciones encontradas

			// if (usuario != null) {
			// arr_perfiles = perfil.arr_perfiles;
			// }
			// Obtiene las opciones encontradas
			
			if (perfil != null && perfil.arr_perfiles != null) {
				for (PerfilOpcionDTO po : perfil.arr_perfiles) {
					opciones.add(new MenuItemSys(po.getWindowId()));
				}
				//modelMap.put("proxiArray", opciones);
			}

			modelMap.put("message", "success");
		} catch (Exception dae) {
			modelMap.put("message", dae.getMessage());

		}

		modelMap.put("proxiArray", opciones);
		modelMap.put("totalCount", opciones.size());
		modelMap.put("success", "true");

		return modelMap;

	}

	@RequestMapping(value = "/getuseroptions", method = RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> getuseroptions(HttpServletRequest request) {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {

			// UsuarioDTO usuario =
			// UtilsRequest.getSession(request.getSession());
			UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

			com.administracion.extjs.dto.UsuarioDataDesktop user = new com.administracion.extjs.dto.UsuarioDataDesktop();
			user.setDescripcionpuesto(usuario.getDescripcionpuesto());
			user.setDesEmpresa(usuario.getDesEmpresa());
			user.setLogin(usuario.getNombre());
			user.setSiglasPlaza(usuario.getSiglasPlaza());
			user.setNombre(usuario.getNombre());
			user.setNombreCompleto(usuario.getNombreCompleto());

			modelMap.put("usuario", user);
			PerfilOpcionDTO perfil = iPerfilOpcionUsuarioBO.getOpcionesPerfilAccesoWin(usuario,
					ConstantesAutoDoc.ID_MODULO);

			// Obtiene las opciones encontradas
			List<String> opciones = new ArrayList<String>();
			if (perfil != null && perfil.arr_perfiles != null) {
				for (PerfilOpcionDTO po : perfil.arr_perfiles) {
					opciones.add(po.getWindowId());
				}
				modelMap.put("opciones", opciones);
			}

			creaSesionCte(usuario, request);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelMap;
	}

	/***
	 * Metodo de login para autenticar el usuario
	 * 
	 * @deprecated se cambia por la InnovargiaAuthentication para autenticar por
	 *             spring
	 * @param login
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login_old")
	public @ResponseBody Map<String, ? extends Object> login(@RequestParam("login") String login,
			@RequestParam("password") String password, HttpServletRequest request) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {

			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setLogin(UtilsStrings.nullChangeToUpperCase(login));
			// usuario.setPassword(UtilsStrings.nullChangeToUpperCase(password));
			usuario.setPassword(password);
			boolean existeUsuario = iAdminPasswordBO.existeLoginPass(usuario.getLogin(), usuario.getPassword());

			if (existeUsuario) {
				iAdminPasswordBO.insertBitacoraAcceso(usuario.getLogin(), ConstantesGenerales.MODULO_AUTODOCWEB,
						password);
				usuario = iusuarioBO.getUsuarioLogin(usuario);
				if ((usuario == null) || (usuario.getNombre() == null) || (usuario.getNombre().trim().length() <= 0)) {
					throw new Exception(
							"Usuario no existe: Nombre, Login, o Password de usuario incorrecta verifique.");

				}
				if (!usuario.isActivo()) {
					throw new Exception("Usuario esta dado de baja, verifique con el administrador del sistema.");
				}
				iusuarioBO.getEntidadOrganizacion(usuario);

				if (!"A".equals(usuario.entidad.getEstatus())) {
					throw new Exception("Entidad de negocio ha sido dada de baja verifique");
				}
				if (!"A".equals(usuario.organizacion.getEstatus())) {
					throw new Exception("Organizacion de negocio ha sido dada de baja verifique");
				}
				if (!"A".equals(usuario.cuenta.getActivo())) {
					throw new Exception("Cuenta de negocio ha sido dada de baja verifique");
				}

				usuario.setInterfaz(ConstantesGenerales.MODULO_AUTODOCWEB);
				// Agrega la sesion para el usuario
				/*
				 * HttpSession session = request.getSession(true); session =
				 * request.getSession(true);
				 * session.setAttribute(ConstantesGenerales.USER_SESSION,
				 * usuario);
				 */
				creaSesionCte(usuario, request);

				String estado_password = iAdminPasswordBO.estadoLoginPass(login, password);
				if (estado_password == null) {
					estado_password = "T";
				}
				modelMap.put("estado_pass", estado_password);
				modelMap.put("success", true);
				modelMap.put("error", false);
				modelMap.put("message", "Acceso correcto");
			} else {
				// Checa si el usuario existe con la forma anterior
				usuario = new UsuarioDTO();
				usuario.setLogin(UtilsStrings.nullChangeToUpperCase(login));
				usuario.setPassword(UtilsStrings.nullChangeToUpperCase(password));
				usuario.setEstatus(90000);
				usuario = iusuarioBO.getUsuarioLogin(usuario);
				if (usuario == null) {
					modelMap.put("success", true);
					modelMap.put("error", true);
					modelMap.put("message", "Usuario no existe o los datos estan incorrectos");
					iAdminPasswordBO.insertBitacoraAcceso(login, ConstantesGenerales.MODULO_AUTODOCWEB, password);

				} else {
					// Agrega la sesion para el usuario
					/*
					 * HttpSession session = request.getSession(true); session =
					 * request.getSession(true);
					 * session.setAttribute(ConstantesGenerales.USER_SESSION,
					 * usuario);
					 */
					creaSesionCte(usuario, request);

					iAdminPasswordBO.insertBitacoraAcceso(login, ConstantesGenerales.MODULO_AUTODOCWEB, password);
					iAdminPasswordBO.insertHistorial(login, password, ConstantesGenerales.ESTADO_CADUCO);

					// Actualiza el password anterior a ACTUALIZADO para saber
					// que ya pasa por el nuevo
					// proceso de passwords
					usuario.setPassword("ACTUALIZADO");
					iusuarioBO.updatePassword(usuario);
					modelMap.put("success", true);
					modelMap.put("message", "Password expiro para el usario " + login);
					modelMap.put("estado_pass", "C");

				}
			}

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("error", true);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;

	}

	@RequestMapping(value = "/login_pdv")
	public String login_pdv(@RequestParam("login") String login, @RequestParam("password") String password,
			Locale locale, Model model, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		String error = "";
		try {

			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setLogin(UtilsStrings.nullChangeToUpperCase(login));
			usuario.setPassword(UtilsStrings.nullChangeToUpperCase(password));

			usuario = iusuarioBO.getUsuarioLogin(usuario);

			if ((usuario == null) || (usuario.getNombre() == null) || (usuario.getNombre().trim().length() <= 0)) {
				throw new Exception("Usuario no existe: Nombre, Login, o password de usuario incorrecta verifique.");

			}
			if (!usuario.isActivo()) {
				throw new Exception("Usuario esta dado de baja, verifique con el administrador del sistema.");
			}
			iusuarioBO.getEntidadOrganizacion(usuario);

			if (!"A".equals(usuario.entidad.getEstatus())) {
				throw new Exception("Entidad de negocio ha sido dada de baja verifique");
			}
			if (!"A".equals(usuario.organizacion.getEstatus())) {
				throw new Exception("Organizacion de negocio ha sido dada de baja verifique");
			}
			if (!"A".equals(usuario.cuenta.getActivo())) {
				throw new Exception("Cuenta de negocio ha sido dada de baja verifique");
			}

			// Datos de la oficina que invoca
			usuario.setIdoficina(
					request.getParameter("idoficina") == null ? "" : (request.getParameter("idoficina").trim()));
			usuario.setLogin_autodoc(
					request.getParameter("login_pdv") == null ? "" : (request.getParameter("login_pdv").trim()));
			usuario.setAuto_pdv(request.getParameter("auto_pdv"));
			usuario.setIdconvenio(request.getParameter("idconvenio"));

			if (usuario.getIdoficina().isEmpty() || usuario.getLogin_autodoc().isEmpty() || !usuario.isAuto_pdv()) {
				throw new Exception("Solicitud de rotulacion de PDV invalida");
			}

			if (usuario.getIdconvenio() <= 0) {
				throw new Exception("Contrato Inv�lido");
			}

			List<Folios> lista_convenios = iFoliosBO.getConveniosAutoDocPDV(usuario);

			if (lista_convenios.size() <= 0) {
				throw new Exception("No existe convenio solicitado para autodocumentaci�n");
			}
			BusquedaDTO busqueda = new BusquedaDTO();
			busqueda.setIdentificador_str(usuario.getIdoficina());
			OficinasDTO oficina = iBusquedaOficinasBO.getOficinaReceptora(busqueda);
			if (oficina == null) {
				throw new Exception("Oficina receptora no existe o es inv�lida.");
			}

			usuario.setSiglasPlaza(oficina.getSiglasplaza());

			// Valida si el contrato es valido
			usuario.setInterfaz(ConstantesGenerales.MODULO_AUTODOCWEB);
			// Agrega la sesion para el usuario
			/*
			 * HttpSession session = request.getSession(true); session =
			 * request.getSession(true);
			 * session.setAttribute(ConstantesGenerales.USER_SESSION, usuario);
			 */
			creaSesionCte(usuario, request);
			return "menuwin";

		} catch (Exception dae) {
			error = dae.getMessage();
			logger.debug(dae.getMessage());
			redirectAttributes.addFlashAttribute("message", dae.getMessage());

		}
		response.setHeader("error", error);
		request.setAttribute("error", error);

		return "error";

	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/menu")
	public String menu(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Iniciando Menu", locale);
		return "menuwin";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/logout")
	public String logout(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Cerrando sesi�n de usuario", locale);

		// Remueve la session existente
		// Save our logged-in user in the session
		HttpSession sessionTerminada = request.getSession(true);

		if (sessionTerminada != null) {
			sessionTerminada.removeAttribute(ConstantesGenerales.USER_SESSION);
			sessionTerminada.removeAttribute(ConstantesGenerales.USER_CTE_SESSION);
			sessionTerminada.invalidate();
		}
		// Crea una nueva session para el usuario
		sessionTerminada = request.getSession(true);
		sessionTerminada.setAttribute(ConstantesGenerales.USER_SESSION, null);
		sessionTerminada.setAttribute(ConstantesGenerales.USER_CTE_SESSION, null);

		return "home";
	}

	/**
	 * Obtiene las opciones del menu a las que tiene acceso el usuario
	 */
	@RequestMapping(value = "/opcionesmenu")
	public @ResponseBody Map<String, ? extends Object> opcionesmenu(@RequestParam("permiteModulo") String permiteModulo,
			HttpServletRequest request) {
		logger.info("Obteniendo opciones de usuario");
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		ArrayList<PerfilOpcionDTO> arr_perfiles = new ArrayList<PerfilOpcionDTO>();
		List<MenuItemSys> opciones = new ArrayList<MenuItemSys>();
		try {
			PerfilOpcionDTO perfil = iPerfilOpcionUsuarioBO.getOpcionesPerfilAccesoWin(usuario, permiteModulo);

			// Obtiene las opciones encontradas

			if (usuario != null) {
				arr_perfiles = perfil.arr_perfiles;
			}

			for (PerfilOpcionDTO perfilOpcionDTO : arr_perfiles) {
				opciones.add(new MenuItemSys(perfilOpcionDTO.getWindowId()));
			}
			modelMap.put("message", "success");
		} catch (Exception dae) {
			modelMap.put("message", dae.getMessage());

		}

		modelMap.put("proxiArray", opciones);// arr_perfiles);
		modelMap.put("totalCount", opciones.size());// arr_perfiles.size());
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
	public @ResponseBody Map<String, ? extends Object> getDatosUsuario(HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();

		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		try {
			creaSesionCte(usuario, request);

			// lista.add(usuario);
			String wallpaper = iParametrosSistemaBO.getValorPropiedad(ConstantesGenerales.WALLPAPER_PARAMETRO,
					ConstantesGenerales.ID_APP);

			String tipo_menu = iParametrosSistemaBO.getValorPropiedad(ConstantesGenerales.TIPO_MENU,
					ConstantesGenerales.ID_SKY4SOL);

			if (tipo_menu == null) {
				tipo_menu = "top";
			}

			if (wallpaper == null) {
				wallpaper = ConstantesGenerales.WALLPAPER_DEFAULT;
			}

			modelMap.put("wallpaper_default_windows", wallpaper);
			modelMap.put("tipo_menu", tipo_menu);

			modelMap.put("nombre_usuario_windows", usuario.getNombre());
			modelMap.put("perfil_usuario_windows", usuario.perfil_Dto.getDescripcion_perfil());
			modelMap.put("descripcionpuesto", usuario.getDescripcionpuesto());
			// modelMap.put("login_usuario_windows", usuario.getLogin());
			// modelMap.put("cliente_usuario_windows",usuario.getNumCliente());
			modelMap.put("plaza_usuario", usuario.getSiglasPlaza());
			modelMap.put("oficina_usuario", usuario.getIdoficina());
			modelMap.put("numempleado_usuario", usuario.getNumempleado());
			modelMap.put("tipo_menu", tipo_menu);

			// Setea el wallpaper ya sea el default o el del usuario
			if ((usuario.getWallpaper() == null) || (usuario.getWallpaper().trim().length() <= 0)) {
				usuario.setWallpaper(wallpaper);
			}
			modelMap.put("usuario_wallpaper_windows",
					usuario.getWallpaper() != null ? usuario.getWallpaper() : wallpaper);
			// modelMap.put("usuario_up",usuario.getPassword());
			modelMap.put("estatus_pa", usuario.getEstado_p());

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
	@RequestMapping("/getWallPapers")
	public @ResponseBody Map<String, ? extends Object> getWallPapers(
			@RequestParam(value = "idsistema", required = true) String idsistema, HttpServletRequest request)
			throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<WallPaperDTO> list_wallpaper = new ArrayList<WallPaperDTO>();
		try {
			WallPaperDTO wallpaper = new WallPaperDTO();
			wallpaper.setIdaplicacion(idsistema);
			list_wallpaper = iBusquedaWallPaperBO.getRegistros(wallpaper);
			modelMap.put("message", "success");
		} catch (DataAccessException dae) {
			modelMap.put("message", dae.getMessage());

		}

		modelMap.put("proxiArray", list_wallpaper);
		modelMap.put("totalCount", list_wallpaper.size());
		modelMap.put("success", "true");

		return modelMap;

	}

	/***
	 * Actualiza el password del usuario
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatepassword")
	public @ResponseBody Map<String, ? extends Object> updatepassword(
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "passwordnuevo", required = false) String passwordnuevo, HttpServletRequest request)
			throws Exception {

		boolean success = false;
		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = new UsuarioDTO();

		UtilsRequest.displayParametros(request);

		UsuarioDTO usuario_session = ConstantesAutoDoc.getSession(request.getSession(true));
		try {
			/*
			 * if (usuario_session==null){ throw new
			 * Exception("Usuario no ha iniciado sesion vuelva a intentar."); }
			 */

			if (passwordnuevo.trim().length() <= 0) {
				throw new Exception("Password de usuario invalido.");
			}

			PasswordValidator validator = PasswordValidator.buildValidator(PasswordValidator.ForceSpecialChar,
					PasswordValidator.ForceCapitalLetter, PasswordValidator.ForceLowerLetter,
					PasswordValidator.ForceNumber, PasswordValidator.MinLength, PasswordValidator.MaxLength);

			if (validator.validatePassword(passwordnuevo)) {
				throw new Exception(PasswordValidator.MENSAJE_ERROR);
			}
			// Actualiza nuevo password
			usuario.setLogin(login);
			usuario.setPassword(passwordnuevo);
			// usuario.setNumCliente(usuario_session.getNumCliente());

			// bo.updatePassword(usuario);
			iAdminPasswordBO.insertHistorial(usuario.getLogin(), usuario.getPassword(),
					ConstantesGenerales.ESTADO_ACTIVO);

			HttpSession sessionTerminada = request.getSession(true);

			if (sessionTerminada != null) {
				sessionTerminada.removeAttribute(ConstantesGenerales.USER_SESSION);
				sessionTerminada.invalidate();
			}
			// Crea una nueva session para el usuario
			sessionTerminada = request.getSession(true);
			sessionTerminada.setAttribute(ConstantesGenerales.USER_SESSION, null);

			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (Exception dae) {
			modelMap.put("success", success);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
	}

}
