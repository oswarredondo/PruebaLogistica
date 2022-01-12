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
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DescuentoDTO;
import com.innovargia.salesmanager.idao.IDescuentoClienteDAO;
import com.innovargia.salesmanager.mappers.DescuentoRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class DescuentoClienteDAO extends JdbcDaoSupport implements IDescuentoClienteDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoClienteDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
	public DescuentoClienteDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(DescuentoDTO obj) throws Exception {
		String query = "INSERT INTO cadescuentocliente(iddescuento,idcliente) " +
			       "VALUES( :iddescuento,:idcliente)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
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

	@Override
	public void update(DescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DescuentoDTO obj) throws Exception {
		String query = "DELETE FROM cadescuentocliente  WHERE " +
			       " iddescuento = :iddescuento AND idcliente=:idcliente";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
	}

	/***
	 * Obtiene los registos que fueron asignados al descuento
	 */
	@Override
	public List<DescuentoDTO> getRegistros(BusquedaDTO obj) throws Exception {
		List<DescuentoDTO> lista = new ArrayList<DescuentoDTO>();
		String sql =  "SELECT cadescuentocliente.iddescuento,"
				+ "cadescuentocliente.idcliente as identificador,caclientefacturacion.descripcion "
				+ " FROM cadescuentocliente left outer join caclientefacturacion"
				+ " ON cadescuentocliente.idcliente = caclientefacturacion.idcliente "
				+ " WHERE  cadescuentocliente.iddescuento=:identificador AND caclientefacturacion.estatus=1";;
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new DescuentoRowMapper());

		return lista;
	}
	
	/**
	 * Obtiene todos los registros de clientes que pueden ser asignados al descuuento
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DescuentoDTO> getRegistrosDisponibles(BusquedaDTO obj) throws Exception {
		List<DescuentoDTO> lista = new ArrayList<DescuentoDTO>();
		//obtiene las cuentas de clientes que estan disponibles para agregar
		//De la tabla de clientes
		String sql ="select idcliente as identificador,descripcion  from caclientefacturacion "
				+ " WHERE estatus =1 AND "
				+ "idcliente NOT IN (select idcliente from cadescuentocliente where iddescuento=:identificador) ";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new DescuentoRowMapper());

		return lista;
	}

	@Override
	public DescuentoDTO get(DescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEstatus(DescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
