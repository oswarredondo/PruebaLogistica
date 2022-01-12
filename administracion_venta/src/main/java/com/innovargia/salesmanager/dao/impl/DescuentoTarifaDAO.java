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
import com.innovargia.salesmanager.idao.IDescuentoTarifaDAO;
import com.innovargia.salesmanager.mappers.DescuentoRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class DescuentoTarifaDAO extends JdbcDaoSupport implements IDescuentoTarifaDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoTarifaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	final String  sql_ = "SELECT cadescuentotarifa.iddescuento,cadescuentotarifa.idtarifa as identificador,"
			+ "catarifas.nombre as descripcion"
			+ " FROM cadescuentotarifa left outer join catarifas "
			+ " ON cadescuentotarifa.idtarifa = catarifas.idtarifa";
	
	@Autowired
	public DescuentoTarifaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(DescuentoDTO obj) throws Exception {
		String query = "INSERT INTO cadescuentotarifa(iddescuento,idtarifa) " +
			       "VALUES( :iddescuento,:idtarifa)";

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
		String query = "DELETE FROM cadescuentotarifa  WHERE " +
			       " iddescuento = :iddescuento AND idtarifa=:idtarifa";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	/***
	 * Obtiene los datos de los rfegistros agregados al descruento y solo las tarifas que estan activas
	 * y cuya fecha de termino es igual o mayor a la fecha actual
	 */
	@Override
	public List<DescuentoDTO> getRegistros(BusquedaDTO obj) throws Exception {
		List<DescuentoDTO> lista = new ArrayList<DescuentoDTO>();
		String sql = sql_ + " WHERE  cadescuentotarifa.iddescuento=:identificador AND catarifas.estatus=1 AND"
				+ " catarifas.fechafinal>= current_date ";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new DescuentoRowMapper());
		return lista;
	}
	
	/**
	 * Obtiene todos los registros de clientes que pueden ser asignados al descuuento
	 * solo obtiene las tarifas que estan activas y cuya fecha final sea mayor o igual a la fecha
	 * actual
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DescuentoDTO> getRegistrosDisponibles(BusquedaDTO obj) throws Exception {
		List<DescuentoDTO> lista = new ArrayList<DescuentoDTO>();
		//obtiene las cuentas de clientes que estan disponibles para agregar
		//De la tabla de clientes
		//obtiene las tarifas que estan disponibles para agregar
		//De la tabla de tafias
		String sql ="select idtarifa as identificador, nombre as descripcion  from catarifas "
				+ " WHERE estatus =1 AND fechafinal>= current_date AND "
				+ "idtarifa NOT IN (select idtarifa from cadescuentotarifa where iddescuento=:identificador) ";
	
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
