package com.tracusa.logistica.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracusa.logistica.model.Usuario;
import com.tracusa.logistica.interfase.bo.IUsuarioBO;
import com.tracusa.logistica.interfase.dao.IUsuarioDao;

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
	public List<Usuario> login(Usuario usuario) throws Exception {
		
		return iUsuario.login(usuario);
	} 

}
