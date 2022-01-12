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

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.NivelUsuarioDTO;
import com.innovargia.salesmanager.idao.INivelUsuarioDAO;
import com.innovargia.salesmanager.mappers.CatalogoRowMapper;
import com.innovargia.salesmanager.mappers.NivelUsuarioRowMapper;

@Repository
public class NivelUsuarioDAO extends JdbcDaoSupport implements  INivelUsuarioDAO {

	final String  sql_ = "SELECT idnivelusuario as identificador,"
			+ "descripcion,visiblesiempre as estatus FROM canivelusuario ";

	private static final Logger logger = LoggerFactory
			.getLogger(NivelUsuarioDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public NivelUsuarioDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(NivelUsuarioDTO catalogo) throws Exception {
		String query = "INSERT INTO canivelusuario(idnivelusuario, descripcion, "
				+ "visiblesiempre, maxdescadicional,maxdesctarifas)"
				+ " VALUES (:idnivelusuario, :descripcion,:visiblesiempre, "
				+ ":maxdescadicional,:maxdesctarifas )";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

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
	
	@Override
	public void insertPuestoAgrupamiento(NivelUsuarioDTO catalogo) throws Exception {
		String query = "INSERT INTO caagrupadorjeraquiapuestos(idagrupamiento, idpuesto)"
				+ "   VALUES (:idagrupamiento, :idpuesto)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);

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
	public void deletePuestoAgrupamiento(NivelUsuarioDTO catalogo) throws Exception {
		String query = "DELETE FROM caagrupadorjeraquiapuestos WHERE " +
			       "idagrupamiento=:idagrupamiento,idpuesto=:idpuesto";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
	}

	@Override
	public void update(NivelUsuarioDTO catalogo) throws Exception {
	
		String query = "UPDATE canivelusuario  SET idnivelusuario=:idnivelusuario, "
				+ "descripcion=:descripcion, visiblesiempre=:visiblesiempre, maxdescadicional=:maxdescadicional, "
				+ "maxdesctarifas=:maxdesctarifas WHERE " +
			       " identificador = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
		
		 
	}

	@Override
	public void updateEstatus(NivelUsuarioDTO catalogo) throws Exception {
	
	}

	@Override
	public void delete(NivelUsuarioDTO catalogo) throws Exception {
		String query = "DELETE FROM canivelusuario WHERE " +
			       " identificador = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
	}

	@Override
	public List<NivelUsuarioDTO> getRegistros(NivelUsuarioDTO catalogo)
			throws Exception {
		List<NivelUsuarioDTO> lista = new ArrayList<NivelUsuarioDTO>();
		String sql = "SELECT idnivelusuario as identificador,"
				+ "descripcion,visiblesiempre as estatus FROM canivelusuario " ;
		
			
		lista = jdbcTemplate.query(sql,new NivelUsuarioRowMapper());
		return lista;
	}
	@Override
	public List<NivelUsuarioDTO> getRegistrosNivelAgrupamiento(NivelUsuarioDTO catalogo)
			throws Exception {
		List<NivelUsuarioDTO> lista = new ArrayList<NivelUsuarioDTO>();
		String sql = "select caagrupadorjeraquiapuestos.*,canivelusuario.descripcion "
				+ " from caagrupadorjeraquiapuestos left outer join canivelusuario ON"
				+ " idnivelusuario=idpuesto where idagrupamiento=" + catalogo.getIdagrupamiento() ;
		
			
		lista = jdbcTemplate.query(sql,new NivelUsuarioRowMapper());
		return lista;
	}
	
	
	@Override
	public NivelUsuarioDTO get(int nivel) throws Exception {

		List<NivelUsuarioDTO> lista = new ArrayList<NivelUsuarioDTO>();
		String sql = "SELECT * FROM canivelusuario WHERE idnivelusuario=" +nivel;

		lista = jdbcTemplate.query(sql,new NivelUsuarioRowMapper());
		if (lista.size()>0){
			return lista.get(0);
		}
		return  new NivelUsuarioDTO();
	}


}
