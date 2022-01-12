package com.innovargia.ws.repo.interfase.bo;

import com.innovargia.ws.dto.Usuario;

public interface IUsuarioBO {
	
	public abstract int insert(Usuario usuario) throws Exception;
	
	public abstract void changePassword(Usuario usuario) throws Exception;
	
	public abstract int login(Usuario usuario) throws Exception;

}
