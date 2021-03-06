package com.innovargia.security;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.innovargia.administracion.ibo.IAdminPasswordBO;
import com.innovargia.administracion.ibo.IPerfilOpcionUsuarioBO;
import com.innovargia.administracion.ibo.IUsuarioBO;
import com.innovargia.autodoc.dto.PermissionRoleDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesGenerales;

public class InnovargiaAuthentication implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(InnovargiaAuthentication.class);

	@Autowired
	IUsuarioBO iusuarioBO;
	@Autowired
	IPerfilOpcionUsuarioBO iPerfilOpcionUsuarioBO;
	@Autowired
	IAdminPasswordBO iAdminPasswordBO;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		
		String login = auth.getName();
		String password = auth.getCredentials().toString().trim();
		logger.debug("Autenticando usuario " + login);
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setLogin(UtilsStrings.nullChangeToUpperCase(login));
		usuario.setPassword(UtilsStrings.nullChangeToUpperCase(password));

		try {
			//Checa si es un usuario valido
			usuario = checkValidUser(login,password);
			// Obtiene los datos del perfil
			usuario.setInterfaz(ConstantesGenerales.MODULO_AUTODOCWEB);
			
		} catch (UsernameNotFoundException e) {
			logger.debug("UsernameNotFoundException:" + e.getMessage());
			e.printStackTrace();
			throw new UsernameNotFoundException(e.getMessage());
		} catch (Exception e) {
			logger.debug("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new BadCredentialsException("Usuario o Password Incorrectos");
		}

		// Devuelve la autenticacion
		Authentication aut = new UsernamePasswordAuthenticationToken(usuario, password, getAuthorities("USRAUTODOC"));
		logger.debug("Usuario autenticado" );
		return aut;
	}

	@Override
	public boolean supports(Class<?> type) {
		return type.equals(UsernamePasswordAuthenticationToken.class);
	}

	/**
	 * M??todo de puestra para obtener el perfil/rol de usuario
	 * 
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthorities(String role) {
		List<GrantedAuthority> permissions = new ArrayList<GrantedAuthority>();
		permissions.add(new PermissionRoleDTO(role));
		return permissions;
	}

	private UsuarioDTO checkValidUser(String login, String password) throws Exception {
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setLogin(UtilsStrings.nullChangeToUpperCase(login));
		// usuario.setPassword(UtilsStrings.nullChangeToUpperCase(password));
		usuario.setPassword(password);
		boolean existeUsuario = iAdminPasswordBO.existeLoginPass(usuario.getLogin(), usuario.getPassword());

		if (existeUsuario) {
			iAdminPasswordBO.insertBitacoraAcceso(usuario.getLogin(), ConstantesGenerales.MODULO_AUTODOCWEB, password);
			usuario = iusuarioBO.getUsuarioLogin(usuario);
			if ((usuario == null) || (usuario.getNombre() == null) || (usuario.getNombre().trim().length() <= 0)) {
				throw new UsernameNotFoundException(
						"Usuario no existe: Nombre, Login, o Password de usuario incorrecta verifique.");

			}
			if (!usuario.isActivo()) {
				throw new UsernameNotFoundException(
						"Usuario esta dado de baja, verifique con el administrador del sistema.");
			}
			iusuarioBO.getEntidadOrganizacion(usuario);

			if (!"A".equals(usuario.entidad.getEstatus())) {
				throw new UsernameNotFoundException("Entidad de negocio ha sido dada de baja verifique");
			}
			if (!"A".equals(usuario.organizacion.getEstatus())) {
				throw new UsernameNotFoundException("Organizacion de negocio ha sido dada de baja verifique");
			}
			if (!"A".equals(usuario.cuenta.getActivo())) {
				throw new UsernameNotFoundException("Cuenta de negocio ha sido dada de baja verifique");
			}

			usuario.setInterfaz(ConstantesGenerales.MODULO_AUTODOCWEB);

			String estado_password = iAdminPasswordBO.estadoLoginPass(login, password);
			if (estado_password == null) {
				estado_password = "T";
			}

			usuario.setEstado_p(estado_password);
		} else {
			// Checa si el usuario existe con la forma anterior
			usuario = new UsuarioDTO();
			usuario.setLogin(UtilsStrings.nullChangeToUpperCase(login));
			usuario.setPassword(UtilsStrings.nullChangeToUpperCase(password));
			usuario.setEstatus(90000);
			usuario = iusuarioBO.getUsuarioLogin(usuario);
			if (usuario == null) {
				iAdminPasswordBO.insertBitacoraAcceso(login, ConstantesGenerales.MODULO_AUTODOCWEB, password);
				throw new UsernameNotFoundException("Login o Password invalidos, verifique.");
				

			} else {
				iAdminPasswordBO.insertBitacoraAcceso(login, ConstantesGenerales.MODULO_AUTODOCWEB, password);
				iAdminPasswordBO.insertHistorial(login, password, ConstantesGenerales.ESTADO_CADUCO);

				// Actualiza el password anterior a ACTUALIZADO para saber que
				// ya pasa por el nuevo
				// proceso de passwords
				usuario.setPassword("ACTUALIZADO");
				iusuarioBO.updatePassword(usuario);
				usuario.setEstado_p("C");

			}
		}
		
		return usuario;

	}
}
