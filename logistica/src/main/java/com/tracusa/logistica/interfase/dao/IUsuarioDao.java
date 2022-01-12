package com.tracusa.logistica.interfase.dao;

import java.util.List;

import com.tracusa.logistica.model.Usuario;

public interface IUsuarioDao {
	
	public abstract int insert(Usuario usuario) throws Exception;
	
	public abstract void changePassword(Usuario usuario) throws Exception;
	
	public abstract List<Usuario> login(Usuario usuario) throws Exception;

}
