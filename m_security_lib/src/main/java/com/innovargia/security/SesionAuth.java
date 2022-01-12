/**
 * 
 */
package com.innovargia.security;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author aruaro
 *
 */
public class SesionAuth {

	
	public static UsuarioDTO getSession(HttpSession sesion){
		//Obtenemos la autenticacion actual
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		//Evaluamos que el usuario se haya autenticado
		if(authentication instanceof AnonymousAuthenticationToken)
			return null;
		else
			return (UsuarioDTO)authentication.getPrincipal();
	}
	
}
