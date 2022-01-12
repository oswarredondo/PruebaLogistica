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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.TareaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.idao.ITareasDAO;
import com.innovargia.salesmanager.mappers.TareaRowMapper;

/**
 * @author aruaro
 *
 */
@Repository
public class TareasDAO extends JdbcDaoSupport implements ITareasDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(TareasDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TareasDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public void insertResponsable(TareaDTO catalogo) throws Exception {

		try {
		    	
			if ("ABIERTA, REASIGNADA".contains(catalogo.getEstatus())){
			    SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
					catalogo);
			    String query = "INSERT INTO catareapendusuarioresp ( idusuarioresponsable ,idtarea) "
			    	+ "VALUES (:idusuarioresponsable,:idtarea)";
			    this.namedParameterJdbcTemplate.update(query, parameterSource);
			}
			

		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			
		}
	}

	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ITareasDAO#insert(com.innovargia.salesmanager.dtos.TareaDTO)
	 */
	@Override
	public Number insert(TareaDTO catalogo) throws Exception {
		String query = "INSERT INTO catareapendienteusuario("
				+ " idtareaorigina, idusuariogenero, idusuarioresponsable, "
				+ " fechasolicitud, solicitud, estatus, tipo, importancia,ambito,"
				+ "fechaexpira,idambitotarea,titulo,solucion) "
				+ " VALUES (:idtareaorigina, :idusuariogenero, :idusuarioresponsable,"
				+ "current_timestamp,:solicitud, :estatus, :tipo, :importancia,:ambito,"
				+"'"+ catalogo.getFechaexpira() + "'"+",:idambitotarea,:titulo, :solucion);";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idtarea" });
			 Number consecutivo = keyHolder.getKey();
			
			
			
			return consecutivo;
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
	 * @see com.innovargia.salesmanager.idao.ITareasDAO#update(com.innovargia.salesmanager.dtos.TareaDTO)
	 */
	@Override
	public void update(TareaDTO catalogo) throws Exception {
		String query = "UPDATE catareapendienteusuario SET idtareaorigina= :idtareaorigina,"+
				"idusuarioresponsable=:idusuarioresponsable,solicitud=:solicitud,estatus=:estatus,"+
				"tipo=:tipo,importancia=:importancia,ambito=:ambito,fechaexpira='"+ catalogo.getFechaexpira() + "',"+
				"idambitotarea=:idambitotarea, fechaultimocambio=current_timestamp,titulo=:titulo,solucion=:solucion "+
				 " WHERE idtarea = :idtarea";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
			
			
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ITareasDAO#updateEstatus(com.innovargia.salesmanager.dtos.TareaDTO)
	 */
	@Override
	public void updateEstatus(TareaDTO catalogo) throws Exception {
		String query = "UPDATE catareapendienteusuario SET fechaultimocambio= current_timestamp, "
				+ " solucion= :solucion,estatus= :estatus, 	idusuariomodifica=:idusuariomodifica"
				+ "  WHERE " +
			       " idtarea = :idtarea";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ITareasDAO#delete(com.innovargia.salesmanager.dtos.TareaDTO)
	 */
	@Override
	public void delete(TareaDTO catalogo) throws Exception {
		String query = "DELETE FROM catareapendienteusuario WHERE idtarea = :idtarea";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	@Override
	public List<TareaDTO> getExistentes()throws Exception{
		List<TareaDTO> lista = new ArrayList<TareaDTO>();
		String sql = "SELECT * FROM catareapendienteusuario  ORDER BY fechaexpira,importancia  desc ";
		
		lista = jdbcTemplate.query(sql,new TareaRowMapper());
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ITareasDAO#getRegistros(com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<TareaDTO> getAsignadasAlUsuario(UsuarioDTO usuario) throws Exception {
		List<TareaDTO> lista = new ArrayList<TareaDTO>();
		String sql =
				"SELECT * FROM ("+
				"	SELECT * FROM catareapendienteusuario WHERE ambito='TODOS' AND fechaexpira>=current_timestamp"+
				"	UNION "+
				"	SELECT * FROM catareapendienteusuario WHERE ambito='USUARIO' AND idusuarioresponsable=:login AND " +
				"   ESTATUS IN ('ABIERTA','ACEPTADA') AND fechaexpira>=current_timestamp "+
				"	UNION "+
				"	SELECT * FROM catareapendienteusuario WHERE ambito='NIVEL' AND idambitotarea IN (SELECT nivelpuesto||''  AS nivelpuesto " +
				"		FROM causuarios where login = :login) AND fechaexpira>=current_timestamp "+
				"	UNION "+
				"	SELECT * FROM  catareapendienteusuario WHERE ambito='GRUPO' AND idambitotarea IN (SELECT idagrupamiento||''  AS idagrupamiento "+
				"       FROM causuarios where login = :login) AND fechaexpira>=current_timestamp"+
				") a ORDER BY fechasolicitud,importancia desc";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new TareaRowMapper());
		return lista;
	}
	
	@Override
	public List<TareaDTO> getCreadasPorElUsuario(UsuarioDTO usuario) throws Exception {
		List<TareaDTO> lista = new ArrayList<TareaDTO>();
		String sql = "SELECT * FROM catareapendienteusuario WHERE idusuariogenero=:login  ORDER BY fechaexpira,importancia  desc";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new TareaRowMapper());
		return lista;
	}

	@Override
	public List<TareaDTO> getCreadasPorElUsuarioDeUnTipo(UsuarioDTO usuario,String tipo) throws Exception {
		List<TareaDTO> lista = new ArrayList<TareaDTO>();
		String sql = "SELECT * FROM catareapendienteusuario WHERE idusuariogenero=:login  "
				+ " AND tipo = '" + tipo +"' ORDER BY fechaexpira,importancia  desc";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new TareaRowMapper());
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ITareasDAO#getTareasAsociadas(com.innovargia.salesmanager.dtos.TareaDTO)
	 */
	@Override
	public List<TareaDTO> getTareasAsociadas(TareaDTO tarea) throws Exception {
		List<TareaDTO> lista = new ArrayList<TareaDTO>();
		String sql = "SELECT * FROM catareapendienteusuario WHERE idtareaorigina=:idtareaorigina  ORDER BY fechaexpira,importancia  desc" ;
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(tarea);
		
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new TareaRowMapper());
		return lista;
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ITareasDAO#get(com.innovargia.salesmanager.dtos.TareaDTO)
	 */
	@Override
	public TareaDTO get(TareaDTO catalogo) throws Exception {
		try {
			String sql = "SELECT * FROM catareapendienteusuario WHERE idtarea=:idtarea";
			return this.jdbcTemplate.queryForObject(sql,
					new TareaRowMapper(), catalogo.getIdtarea());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}



}
