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

import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.idao.IServicioDAO;
import com.innovargia.salesmanager.mappers.ServicioRowMapper;

@Repository
public class ServicioDAO extends JdbcDaoSupport implements  IServicioDAO {

	final String  sql_ = "SELECT identificador,idservicio ,"
			+ "descripcion,estatus,codigoid,tipocobro,generaretorno, nombre  FROM catiposervicio";


	private static final Logger logger = LoggerFactory
			.getLogger(ServicioDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ServicioDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(ServicioDTO catalogo) throws Exception {
		String query = "INSERT INTO catiposervicio(idservicio ,"
			+ "descripcion,estatus,codigoid, nombre, identidad,idorganizacion) " +
			       "VALUES(:idservicio,:descripcion,1,:codigoid,:nombre, 0,0)";
	
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idservicio" });
			
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
	public void update(ServicioDTO catalogo) throws Exception {
		String query = "UPDATE catiposervicio SET idservicio=:idservicio,descripcion=:descripcion,"
				+ "nombre=:nombre,estatus=:estatus,codigoid = :codigoid WHERE " +
			       " identificador = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}
		
	}
	@Override
	public void updateTipoCobro(int identificador, int tipocobro) throws Exception {
		String query = "UPDATE catiposervicio SET tipocobro='" + tipocobro + "' WHERE " +
			       " identificador = " + identificador;

		try{
			this.jdbcTemplate.update(query);
		}catch(Exception dae){
			logger.error("Error en updateTipoCobro: " + dae.getMessage());
		}
		
	}

	@Override
	public void updateEstatus(ServicioDTO catalogo) throws Exception {
		String query = "UPDATE catiposervicio SET estatus= :estatus WHERE " +
			       " idservicio = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(ServicioDTO catalogo) throws Exception {
		String query = "DELETE FROM catiposervicio WHERE " +
			       " identificador = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<ServicioDTO> getRegistros(ServicioDTO catalogo)
			throws Exception {
		List<ServicioDTO> lista = new ArrayList<ServicioDTO>();
		String sql = "SELECT catiposervicio.*, "
			+ "catipocobrorecepcion.descripcion as descripcion_tipocobro "
			+ "FROM catiposervicio left outer join "
			+ "catipocobrorecepcion  on catiposervicio.tipocobro = catipocobrorecepcion.idtipocobro";
		//Signidica que debe traer todos los registros
		if (catalogo.getEstatus()>-1){
			sql+= " WHERE catiposervicio.estatus="+catalogo.getEstatus();
		}
		
		lista = jdbcTemplate.query(sql,new ServicioRowMapper());
		return lista;
	}

	@Override
	public ServicioDTO get(ServicioDTO catalogo) throws Exception {
		String sql = sql_ + " WHERE identificador="+ catalogo.getIdentificador();
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new ServicioRowMapper(), catalogo.getIdentificador());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}
	
	/***
	 * Obtiene los registros de Servicios disponibles que no esten dados de baja para
	 * que se puedan y que no esten ya agregados a la organizaciòn 
	 * para agregar a una entidad-organizacion
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ServicioDTO> getRegistrosEntidadOrganizacio(ServicioDTO catalogo)
			throws Exception{
		List<ServicioDTO> lista = new ArrayList<ServicioDTO>();
		//String sql = sql_ + " WHERE idservicio not in (SELECT idservicio FROM  catiposervicio WHERE identidad=" +
		String sql = sql_ + " WHERE identidad=" +
		catalogo.getIdentidad()+ " AND idorganizacion=" + catalogo.getIdorganizacion()+ "  AND "
				+ " estatus=1";
		
		lista = jdbcTemplate.query(sql,new ServicioRowMapper());
		return lista;
	}


}
