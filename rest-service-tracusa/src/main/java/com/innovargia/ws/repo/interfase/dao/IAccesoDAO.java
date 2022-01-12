package com.innovargia.ws.repo.interfase.dao;

import com.innovargia.ws.tracking.rest.dto.UsuarioDTO;

public interface IAccesoDAO {

	UsuarioDTO getUsuario(UsuarioDTO usuario) throws Exception;

}