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
import com.innovargia.salesmanager.idao.ITarifasDAO;
import com.innovargia.salesmanager.mappers.TarifaRowMapper;

@Repository
public class TarifasDAO extends JdbcDaoSupport implements ITarifasDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(TarifasDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	String _sql ="SELECT distinct a.*,caformapago.descripcion as descripcionformapago FROM ("
			+ "	 select catarifas.*,catiposervicio.descripcion as descripcionservicio from "
			+ "  catarifas left outer join catiposervicio on catarifas.idservicio = catiposervicio.idservicio"
			+ ") a left outer join caformapago ON a.idformapago=caformapago.idformapago";

	/**
	 * Inseyecta el dataspource
	 * 
	 * @param dataSource
	 */
	@Autowired
	public TarifasDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.salesmanager.dao.impl.ITarifasDAO#getTarifas()
	 */
	@Override
	public List<TarifaDTO> getTarifas(TarifaDTO tarifa) throws DataAccessException {
		logger.debug("En getTarifas");
		String sql = _sql;
		return jdbcTemplate.query(sql,new TarifaRowMapper());
	}

	@Override
	@Transactional 
	public Number insert(TarifaDTO obj) throws Exception {
		String query = "INSERT INTO catarifas(nombre,descripcion,estatus,"
			+ "	fechainicial,fechafinal,idservicio,idformapago,"
			+ "es_visible_pdv, es_default) "
				+ "VALUES(:nombre, :descripcion, 1, '" + 
				obj.getFechainicial() + "', '"+
				obj.getFechafinal() + "'"+
				",:idservicio,:idformapago,:es_visible_pdv,:es_default)";
		
		

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idtarifa" });
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
		String query = "UPDATE catarifas SET nombre= :nombre, descripcion =:descripcion,"
				+ "fechainicial='" + obj.getFechainicial()
				
				+"',fechafinal='"+ obj.getFechafinal() +"',"
				+ "idservicio= :idservicio,idformapago= :idformapago,"
				+ "es_visible_pdv=:es_visible_pdv, es_default=:es_default "
				+ " WHERE " + " idtarifa = :idtarifa";

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
		String query = "UPDATE catarifas SET estatus= :estatus "
				+ " WHERE idtarifa = :idtarifa";

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
		String query = "DELETE FROM catarifas  WHERE  idtarifa = :idtarifa";

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
		String sql = _sql;
		String where="";
		switch (busqueda.getTipo()) {
		case 1: //Por nombre 
			where = " a.nombre LIKE '"  + busqueda.getPatron_busqueda() +"%'";
			break;
		case 2: //Por Descripcion 
			where = " a.descripcion LIKE '"  + busqueda.getPatron_busqueda()+"%'";
			break;
		case 3: //Por Servicio 
			where = " a.descripcionservicio LIKE '"  + busqueda.getPatron_busqueda()+"%'";
			break;	
		case 4: //Por Forma pago 
			where = " caformapago.descripcion LIKE '"  + busqueda.getPatron_busqueda()+"%'";
			break;	
		case 5: //Por Fechas
			where = " a.fechainicial>='"  + busqueda.getFechainicial()+"' AND a.fechafinal<='" + busqueda.getFechafinal()+"'";
			break;			
		default:
			break;
		}
		if (where.trim().length()>0){
			where = " WHERE " +  where ;
		}
		// Signidica que debe traer todos los registros
		if (busqueda.getEstatus() > -1) {
			where = where + " AND a.estatus=" + busqueda.getEstatus();
		}
		
		sql += where;
		
		lista = jdbcTemplate.query(sql, new TarifaRowMapper());
		return lista;

	}
	
	@Override
	public TarifaDTO get(TarifaDTO tarifa) throws Exception {
		String sql = _sql + " WHERE idtarifa = "+ tarifa.getIdtarifa();
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new TarifaRowMapper());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}




}
