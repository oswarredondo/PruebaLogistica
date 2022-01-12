/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.EntidadDTO;
import com.innovargia.salesmanager.dtos.OrganizacionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.idao.IOrganizacionDAO;
import com.innovargia.salesmanager.mappers.CuentasRowMapper;
import com.innovargia.salesmanager.mappers.EntidadRowMapper;
import com.innovargia.salesmanager.mappers.OrganizacionRowMapper;
import com.innovargia.salesmanager.mappers.UsuarioRowMapper;

/**
 * @author aruaro
 *
 */
@Repository
public class OrganizacionDAO extends JdbcDaoSupport implements IOrganizacionDAO   {
	private static final Logger logger = LoggerFactory
			.getLogger(OrganizacionDAO.class);
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	private final String _qry = "SELECT * FROM Organizacion";
	private final String _qryEntidadOrganizacion = "SELECT * FROM caOrganizacion";

	@Autowired
	public OrganizacionDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#getListaCuentasOrganizacion(int, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<CuentasDTO> getListaCuentasOrganizacion(
			int idorganizacion, UsuarioDTO user) throws Exception {
		
		String sql = "SELECT * FROM cacuenta WHERE identidad=?  AND idorganizacion=?";
		
		return 	jdbcTemplate.query(sql,  new Object[]{user.entidad.getIdentidad(),
				idorganizacion},new CuentasRowMapper());


	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#getListaOrganizacionesUser(com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<OrganizacionDTO> getListaOrganizacionesUser(UsuarioDTO user)throws SQLException {
		return getListaOrganizacionesUser( user,false);
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#getListaOrganizacionesUser(com.innovargia.salesmanager.dtos.UsuarioDTO, boolean)
	 */
	@Override
	public List<OrganizacionDTO> getListaOrganizacionesUser(UsuarioDTO user, boolean activeOnly)
			throws SQLException {
		
		String sql = "";
		
		if ("E".equals(user.perfil_Dto.getNivel())) {
			sql = "SELECT * FROM caorganizacion WHERE identidad="+  user.entidad.getIdentidad();
			if (activeOnly){
				sql+= " AND estatus='A'";	
			}
		} else {
			sql = "SELECT * FROM caorganizacion WHERE identidad=" +  user.entidad.getIdentidad()+ 
					" AND idorganizacion="+user.organizacion.getIdorganizacion();
			if (activeOnly){
				sql+= " AND estatus='A'";	
			}
		}
		
		
		return 	jdbcTemplate.query(sql,new OrganizacionRowMapper());

		
	

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#getEntidadOrganizacion(com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public void getEntidadOrganizacion(UsuarioDTO user) throws SQLException {


		String sql = " SELECT caEntidad.identidad,caOrganizacion.idorganizacion,caEntidad.Descripcion AS DescEntidad,caEntidad.Estatus as EstatusEntidad, "
				+ " caOrganizacion.Descripcion as DescOrganiza,caOrganizacion.Estatus AS EstatusOrganiza, "
				+ " caOrganizacion.logo AS LogoOrganiza,caCuenta.razonsocial,caCuenta.Estatus AS EstatusCuenta,"
				+ " caCuenta.vertodasdirecciones, caCuenta.cp  FROM caEntidad, caOrganizacion,caCuenta "
				+ " WHERE caEntidad.identidad = caOrganizacion.identidad AND caEntidad.identidad = caCuenta.identidad AND "
				+ " caOrganizacion.identidad = caCuenta.identidad AND caOrganizacion.idorganizacion= caCuenta.idorganizacion AND "
				+ " caEntidad.identidad=" + 
				user.entidad.getIdentidad()+ " and caOrganizacion.idorganizacion=" +user.organizacion.getIdorganizacion()
				+ "  AND caCuenta.numcliente='" +user.getNumCliente() + "'";

		List<UsuarioDTO>  lista  = jdbcTemplate.query(sql,new UsuarioRowMapper());
		
		//Verifica si existe el registro 
		if (lista.size()>0){
			user.cuenta = lista.get(0).cuenta;
			user.cuenta.setNumCliente(user.getNumCliente());
			user.organizacion = lista.get(0).organizacion;
			user.entidad = lista.get(0).entidad;
		}
		
	
	}// fin de getClientesRemDes
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#getEntidades(boolean)
	 */
	@Override
	public List<EntidadDTO> getEntidades(boolean onlyActive){
		String sql = "SELECT * FROM caentidad";
		if (onlyActive){
			sql += " WHERE estatus='A'";
		}
		
		return jdbcTemplate.query(sql,new EntidadRowMapper());
		
	
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#getOrganizacionEntidad(java.lang.String, boolean)
	 */
	@Override
	public List<OrganizacionDTO> getOrganizacionEntidad(String identidad, boolean onlyActive){
		String sql = "SELECT * FROM caorganizacion where identidad="+identidad;
		
		if (onlyActive){
			sql += " AND estatus='A'";
		}
		return jdbcTemplate.query(sql,new OrganizacionRowMapper());
	
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#getOrganizaciones(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<OrganizacionDTO> getOrganizaciones(String inicial, int ordernax,
			String campoBusqueda, String entre, String estatus)
			throws SQLException {
		
		String sql = _qry;
		if (estatus != null) {
			sql += " WHERE estatus='" + estatus +"'";
		}

		return jdbcTemplate.query(sql,new OrganizacionRowMapper());
	}// fin de 
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#updateEstadoEntidad(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateEstadoEntidad(int entidad,String estatus)	throws SQLException {
		
		String sql = "UPDATE caentidad SET estatus=:estatus WHERE identidad=:identidad";
		EntidadDTO obj = new EntidadDTO();
		
		obj.setIdentidad(entidad);
		obj.setEstatus(estatus);
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}

	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#updateEstadoEntidad(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateDescrupcionEntidad(int entidad,String descripcion)	throws SQLException {
		
		String sql = "UPDATE caentidad SET descripcion=:descripcion WHERE identidad=:identidad";
		EntidadDTO obj = new EntidadDTO();
		
		obj.setIdentidad(entidad);
		obj.setDescripcion(descripcion);
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}

	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#insertOrganizacionEntidad(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertOrganizacionEntidad(int entidad, String estatus,String descripcion)	throws SQLException {
		
		String sql = "INSERT INTO caorganizacion(identidad, idorganizacion, descripcion, fechacreacion, logo,estatus)" +
				" VALUES (:identidad, consecutivo_organiza("+entidad+"), :descripcion, current_timestamp, null, :estatus)";
		
		OrganizacionDTO obj = new OrganizacionDTO();
		obj.setIdentidad(entidad);
		obj.setEstatus(estatus);
		obj.setDescripcion(descripcion);
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		
		try{
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#insertEntidad(java.lang.String, java.lang.String)
	 */
	@Override
	public void insertEntidad(String estatus, String descripcion)	throws SQLException {
		
		String sql = "INSERT INTO caentidad(identidad, descripcion, estatus)  VALUES (consecutivo_entidad(), :descripcion, :estatus)";
		EntidadDTO obj = new EntidadDTO();
		obj.setEstatus(estatus);
		obj.setDescripcion(descripcion);
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		
		try{
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
		
	
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#updateEstadoOrganizacionEntidad(int, int, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateEstadoOrganizacionEntidad(int entidad,int idorganizacion, String estatus)	throws SQLException {
		
		String sql = "UPDATE caorganizacion SET estatus=:estatus "
				+ " WHERE identidad=:identidad AND idorganizacion=:idorganizacion";
		
		OrganizacionDTO obj = new OrganizacionDTO();
		obj.setIdentidad(entidad);
		obj.setIdorganizacion(idorganizacion);
		obj.setEstatus(estatus);
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		
		try{
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}

	}
	/*
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#updateEstadoOrganizacionEntidad(int, int, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateDescripcionOrganizacionEntidad(int entidad,int idorganizacion, String descripcion)	throws SQLException {
		
		String sql = "UPDATE caorganizacion SET descripcion=:descripcion "
				+ " WHERE identidad=:identidad AND idorganizacion=:idorganizacion";
		
		OrganizacionDTO obj = new OrganizacionDTO();
		obj.setIdentidad(entidad);
		obj.setIdorganizacion(idorganizacion);
		obj.setDescripcion(descripcion);
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		
		try{
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}

	}
	

	

	
}
