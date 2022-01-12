package com.innovargia.ws.repo.interfase.dao;

import com.innovargia.ws.dto.Usuario;

public interface IUsuarioDao {
	
	public abstract int insert(Usuario usuario) throws Exception;
	
	public abstract void changePassword(Usuario usuario) throws Exception;
	
	public abstract int login(Usuario usuario) throws Exception;

}
