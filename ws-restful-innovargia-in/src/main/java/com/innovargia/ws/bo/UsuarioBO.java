package com.innovargia.ws.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.ws.dto.Usuario;
import com.innovargia.ws.repo.interfase.bo.IUsuarioBO;
import com.innovargia.ws.repo.interfase.dao.IUsuarioDao;

@Service
public class UsuarioBO implements IUsuarioBO {
	
	@Autowired
	private IUsuarioDao iUsuario;

	@Override
	public int insert(Usuario usuario) throws Exception {
	
		return iUsuario.insert(usuario);
	}

	@Override
	public void changePassword(Usuario usuario) throws Exception {
		
		iUsuario.changePassword(usuario);
	
	}

	@Override
	public int login(Usuario usuario) throws Exception {
		
		return iUsuario.login(usuario);
	} 

}
