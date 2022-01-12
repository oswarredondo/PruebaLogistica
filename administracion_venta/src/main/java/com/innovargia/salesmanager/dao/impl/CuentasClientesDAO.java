/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.idao.ICuentasClientesDAO;
import com.innovargia.salesmanager.mappers.CuentasRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class CuentasClientesDAO extends JdbcDaoSupport implements ICuentasClientesDAO { 

	private static final Logger logger = LoggerFactory
			.getLogger(CuentasClientesDAO.class);
	
	final String  sql_ = "SELECT identidad, idorganizacion, numcliente, razonsocial, atencion, "
			+ " calle, colonia, municipio, ciudad, cp, telefono, fax, email, "
			+ " depto, persona, estatus, observacion, tipocliente, rfc, cveunica,"
			+ " cuentamaestra, vertodasdirecciones, oborganizacion, estado, contrato,identificador,tipofolio FROM cacuenta ";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CuentasClientesDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#insert(com.innovargia.salesmanager.dtos.CuentasDTO)
	 */
	@Override
	public void insert(CuentasDTO obj) throws Exception{
		String estatus = obj.isEstatus()?"A":"B";
		String query = "INSERT INTO cacuenta("
				+ "identidad, idorganizacion, numcliente, razonsocial, atencion, "
				+ "calle, colonia, municipio, ciudad, cp, telefono, fax, email,"
				+ " depto,  observacion, tipocliente, rfc, cveunica, "
				+ "cuentamaestra,   estado, contrato,vertodasdirecciones,estatus)"
				+ " VALUES (:identidad, :idorganizacion, :numCliente, :razonSocial, :atencion, "
				+ "  :calle, :colonia, :municipio, :ciudad, :cp, :telefono, :fax, :correoe,"
				+ " :depto,   :observacion, :tipoCliente, :rfc, :cveUnica, "
				+ " :cuentaMaestra,  :estado, :contrato,'S','" + estatus+"')";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "identificador" });
			//return keyHolder.getKey();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#update(com.innovargia.salesmanager.dtos.CuentasDTO)
	 */
	@Override
	public void update(CuentasDTO obj) throws Exception{
		
		String query = "UPDATE cacuenta SET calle = :calle,numcliente=:numCliente,cuentamaestra=:cuentaMaestra,"
				+ "ciudad= :ciudad, colonia= :colonia,municipio= :municipio,atencion=:atencion,"
			       + "estado = :estado,email= :correoe,telefono= :telefono,razonsocial= :razonSocial,"
			       + "observacion=:observacion, rfc=:rfc "
				+ " WHERE identificador = " + obj.getIdentificador();
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}
		
		
	}
	@Override
	public void updateEstatus(CuentasDTO obj) throws Exception {
		String estatus = obj.isEstatus()?"A":"B";
		String query = "UPDATE cacuenta SET estatus='" +estatus + "'"
				+ " WHERE identificador =" + obj.getIdentificador();
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}
	
	@Override
	public void updateTipoManejo(CuentasDTO obj) throws Exception {
		
		String query = "UPDATE cacuenta SET tipofolio=" +obj.getTipofolio() 
				+ " WHERE identificador =" + obj.getIdentificador();
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#delete(com.innovargia.salesmanager.dtos.CuentasDTO)
	 */
	@Override
	public void delete(CuentasDTO obj) throws Exception{
		String query = "DELETE FROM cacuenta WHERE identificador = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#getRegistros(com.innovargia.salesmanager.dtos.CuentasDTO)
	 */
	@Override
	public List<CuentasDTO> getRegistros(BusquedaDTO obj) throws Exception{
		List<CuentasDTO> lista = new ArrayList<CuentasDTO>();
		String sql = sql_  + " WHERE identidad="+ obj.getIdentidad() + 
				" AND idorganizacion=" + obj.getIdorganizacion();
		lista = jdbcTemplate.query(sql,new CuentasRowMapper());
		return lista;
	}
	@Override
	public List<CuentasDTO> getBusquedaRegistros(BusquedaDTO obj) throws Exception{
		List<CuentasDTO> lista = new ArrayList<CuentasDTO>();
		String sql = sql_;

		//Signidica que debe traer todos los registros
		String where ="";
		String where_entidad_organizacion ="identidad="+ obj.getIdentidad() + 
					" AND idorganizacion=" + obj.getIdorganizacion() ;
		if (obj.getTipo()==0){//VER TODOS
		}else if (obj.getTipo()==1){//R.F.C
			where += " rfc LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==2){//RAZON SOCIAL
			where += " razonsocial LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==3){//NUM CLIENTE
			where += " numcliente = '" + obj.getPatron_busqueda() + "'";
		}else if (obj.getTipo()==4){//COLONIA
			where += " colonia LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==5){//MUNICIPIO
			where += " municipio LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==6){//ESTADO
			where += " estado LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==7){//ATENCION
			where += " atencion LIKE '" + obj.getPatron_busqueda() + "%'";
		}else{
			return lista;
		}

		if (where.trim().length()>0){
			sql = sql + " WHERE " + where_entidad_organizacion+ " AND " + where;
		}else{
			sql = sql + " WHERE " +where_entidad_organizacion;
		}
	

		lista = jdbcTemplate.query(sql,new CuentasRowMapper());
		return lista;
	}
	


	@Override
	public CuentasDTO get(BusquedaDTO obj) throws Exception {
		return null;
	}
	



}
