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
import org.springframework.transaction.annotation.Transactional;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.idao.ITarifaServicionZonaDAO;
import com.innovargia.salesmanager.mappers.TarifaRowMapper;

@Repository
public class TarifaServicioZonaDAO extends JdbcDaoSupport implements
		ITarifaServicionZonaDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(TarifaServicioZonaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	String _sql = "SELECT * FROM catarifaserviciozona ";

	/**
	 * Inseyecta el dataspource
	 * 
	 * @param dataSource
	 */
	@Autowired
	public TarifaServicioZonaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	@Transactional 
	public Number insert(TarifaDTO obj) throws Exception {
		String query = "INSERT INTO catarifaserviciozona( "
				+ "idserviciotarifa,zona,kminicial,kmfinal,estatus, precio,preciokgsp ) "
				+ " VALUES (:idserviciotarifa,:zona,:kminicial,:kmfinal,:estatus, :precio,:preciokgsp )";
				/* CAMBIO CITA EVIDENCIA MANIOBRAS 
				// Se agregan los campos para evidencia y citas
				+ " VALUES (:idserviciotarifa,:zona,:kminicial,:kmfinal,:estatus, :precio,:preciokgsp )";
				 FIN CAMBIO */

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idserviciotarifazona" });
			 return keyHolder.getKey();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new RuntimeException("Registro Duplicado");
			} else {
				throw new RuntimeException(dae.getMessage());
			}

		}

	}

	@Override
	public void update(TarifaDTO obj) throws Exception {
		String query = "UPDATE catarifaserviciozona SET "
				+ "zona=:zona,kminicial=:kminicial,kmfinal=:kmfinal, "
				+ "precio=:precio, preciokgsp=:preciokgsp "
				
				/* CAMBIO CITA EVIDENCIA MANIOBRA 
				
				//Se agregan los campos de cita y evidencia para insertar
				+ "preciocitas=:preciocitas, precioevidencia=:precioevidencia "
				
				 FIN CAMBIO */
				
				+ " WHERE " + " idserviciotarifazona = :idserviciotarifazona";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}

	}

	@Override
	public void updateEstatus(TarifaDTO obj) throws Exception {
		String query = "UPDATE catarifaserviciozona SET estatus= :estatus "
				+ " WHERE idserviciotarifazona = :idserviciotarifazona";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}

	}

	@Override
	@Transactional
	public void delete(TarifaDTO obj) throws Exception {
		String query = "DELETE FROM catarifaserviciozona  WHERE idserviciotarifazona = :idserviciotarifazona";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en delete: " + dae.getMessage());
		}

	}

	@Override
	public List<TarifaDTO> getRegistros(BusquedaDTO busqueda) throws Exception {

		List<TarifaDTO> lista = new ArrayList<TarifaDTO>();
		String sql = _sql + " WHERE idserviciotarifa=:identificador";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				busqueda);
		
		logger.debug("SQL:" + sql);		
		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
				new TarifaRowMapper());

		return lista;

	}

	@Override
	public TarifaDTO get(TarifaDTO tarifa) throws Exception {
		String sql = _sql + " WHERE idserviciotarifazona = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql, new TarifaRowMapper(),
					tarifa.getIdserviciotarifazona());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}

	@Override
	public List<TarifaDTO> getListaPrecioPosibles(TarifaDTO tarifa)
			throws Exception {
		// TODO Auto-generated method stub

		List<TarifaDTO> lista = new ArrayList<TarifaDTO>();
		String sql = "select * from catarifaserviciozona where idserviciotarifa ="
				+ tarifa.getIdtarifapeso()
				+ " AND kminicial<="
				+ tarifa.getKminicial()
				+ " UNION "
				+ " select * from catarifaserviciozona where idserviciotarifa ="
				+ tarifa.getIdtarifapeso()
				+ " AND kmfinal<="
				+ tarifa.getKminicial() + "  order by kmfinal desc ";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				tarifa);
		logger.debug("SQL:" + sql);		
		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
				new TarifaRowMapper());

		return lista;
	}

	@Override
	public TarifaDTO  getPrecio(TarifaDTO tarifa) throws Exception {
		// TODO Auto-generated method stub

		List<TarifaDTO> lista =  getListaPrecioPosibles( tarifa);

		if ((lista!=null)  && (lista.size()>0)){
				return lista.get(0);	
		}
		
		return null;
	}
}
