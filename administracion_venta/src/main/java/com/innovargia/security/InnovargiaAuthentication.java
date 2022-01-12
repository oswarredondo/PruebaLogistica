package com.innovargia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.innovargia.salesmanager.bo.impl.UsuariosBO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;


public class InnovargiaAuthentication implements AuthenticationProvider {
	UsuarioDTO usuario = null;
	@Autowired
	UsuariosBO usuarioBO;
	
	// TODO los BOS de autowired que se vayan a utilizar
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		// Validacion con el usuario para verificar que exista

		try {

			String login = authentication.getName();;
			String password = authentication.getCredentials().toString().trim();
			usuario.setLogin(login);
			usuario.setPassword(password); 
			
			usuario = usuarioBO.getUsuarioLogin(usuario);
			
			if ((usuario!=null) && (usuario.isActivo())) {
				Authentication aut = new UsernamePasswordAuthenticationToken(
						usuario, password,null);
				return aut;
			} else {
				throw new UsernameNotFoundException("Usuario invalido");
			}
		} catch (Exception e) {
			throw new BadCredentialsException(
					"Usuario o Contraseña Incorrectos");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
}
