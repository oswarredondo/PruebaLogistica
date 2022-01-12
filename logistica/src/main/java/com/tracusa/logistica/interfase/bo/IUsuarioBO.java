package com.tracusa.logistica.interfase.bo;

import java.util.List;

import com.tracusa.logistica.model.Usuario;

public interface IUsuarioBO {
	
	public abstract int insert(Usuario usuario) throws Exception;
	
	public abstract void changePassword(Usuario usuario) throws Exception;
	
	public abstract List<Usuario> login(Usuario usuario) throws Exception;

}
