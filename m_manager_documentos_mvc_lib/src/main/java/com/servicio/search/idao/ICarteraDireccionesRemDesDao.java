package com.servicio.search.idao;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface ICarteraDireccionesRemDesDao {

	public abstract List<RemDes> getDirecconesRemDes(BusquedaDTO busqueda, UsuarioDTO usuario)
			throws SQLException;

	public abstract void insert(RemDes objeto, UsuarioDTO usuario) throws Exception ;
	public abstract void update(RemDes objeto) throws Exception;
	public abstract void delete(RemDes objeto) throws Exception;
	public abstract List<RemDes> busquedaRemDes(BusquedaDTO busqueda, UsuarioDTO usuario)throws SQLException;

}