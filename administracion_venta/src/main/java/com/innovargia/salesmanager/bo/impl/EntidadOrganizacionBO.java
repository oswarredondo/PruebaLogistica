package com.innovargia.salesmanager.bo.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.EntidadDTO;
import com.innovargia.salesmanager.dtos.OrganizacionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IOrganizacionBO;
import com.innovargia.salesmanager.idao.IOrganizacionDAO;

@Service
public class EntidadOrganizacionBO  implements IOrganizacionBO {

	private static final Logger logger = LoggerFactory
			.getLogger(EntidadOrganizacionBO.class);


	@Autowired
	IOrganizacionDAO iOrganizacionDAO;
	public EntidadOrganizacionBO(){
		
	}
	@Override
	public List<CuentasDTO> getListaCuentasOrganizacion(int idorganizacion,
			UsuarioDTO user) throws Exception {
		// TODO Auto-generated method stub
		return iOrganizacionDAO.getListaCuentasOrganizacion(idorganizacion, user);
	}
	@Override
	public List<OrganizacionDTO> getListaOrganizacionesUser(UsuarioDTO user)
			throws SQLException {
		// TODO Auto-generated method stub
		return iOrganizacionDAO.getListaOrganizacionesUser(user);
	}
	@Override
	public List<OrganizacionDTO> getListaOrganizacionesUser(UsuarioDTO user,
			boolean activeOnly) throws SQLException {
		// TODO Auto-generated method stub
		return iOrganizacionDAO.getListaOrganizacionesUser(user, activeOnly);
	}
	@Override
	public void getEntidadOrganizacion(UsuarioDTO user) throws SQLException {
		// TODO Auto-generated method stub
		iOrganizacionDAO.getEntidadOrganizacion(user);
	}
	@Override
	public List<EntidadDTO> getEntidades(boolean onlyActive) {
		// TODO Auto-generated method stub
		return iOrganizacionDAO.getEntidades(onlyActive);
	}
	@Override
	public List<OrganizacionDTO> getOrganizacionEntidad(String identidad,
			boolean onlyActive) {
		// TODO Auto-generated method stub
		return iOrganizacionDAO.getOrganizacionEntidad(identidad, onlyActive);
	}
	@Override
	public List<OrganizacionDTO> getOrganizaciones(String inicial,
			int ordernax, String campoBusqueda, String entre, String estatus)
			throws SQLException {
		// TODO Auto-generated method stub
		return iOrganizacionDAO.getOrganizaciones(inicial, ordernax, campoBusqueda, entre, estatus);
	}
	@Override
	public void updateEstadoEntidad(int entidad, String estatus) throws SQLException {
		// TODO Auto-generated method stub
		iOrganizacionDAO.updateEstadoEntidad(entidad,estatus);
	}
	@Override
	public void insertOrganizacionEntidad(int entidad, String estatus,
			String descripcion) throws SQLException {
		// TODO Auto-generated method stub
		iOrganizacionDAO.insertOrganizacionEntidad(entidad, estatus,descripcion);
	}
	@Override
	public void insertEntidad(String estatus, String descripcion)
			throws SQLException {
		// TODO Auto-generated method stub
		iOrganizacionDAO.insertEntidad(estatus, descripcion);
	}
	@Override
	public void updateEstadoOrganizacionEntidad(int entidad,
			int idorganizacion, String estatus)
			throws SQLException {
		iOrganizacionDAO.updateEstadoOrganizacionEntidad(entidad, idorganizacion,estatus);
	}
	@Override
	public void updateDescrupcionEntidad(int entidad, String descripcion)
			throws SQLException {
		iOrganizacionDAO.updateDescrupcionEntidad(entidad, descripcion);
		
	}
	@Override
	public void updateDescripcionOrganizacionEntidad(int entidad,
			int idorganizacion, String descripcion) throws SQLException {
		iOrganizacionDAO.updateDescripcionOrganizacionEntidad(entidad, idorganizacion, descripcion);
		
	}


	


}
