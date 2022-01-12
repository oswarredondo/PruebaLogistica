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

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.idao.IAgrupamientoJerarquiaDAO;
import com.innovargia.salesmanager.mappers.AgrupamientoRowMapper;
import com.innovargia.salesmanager.mappers.UsuarioCuentaRowMapper;

@Repository
public class AgrupamientoDAO extends JdbcDaoSupport implements  IAgrupamientoJerarquiaDAO {

	final String  sql_ = "SELECT * FROM caagrupadorjerarquias";


	private static final Logger logger = LoggerFactory
			.getLogger(AgrupamientoDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AgrupamientoDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(AgrupamientoDTO catalogo) throws Exception {
		
		String query = "INSERT INTO caagrupadorjerarquias(idagrupamiento, descripcion, "
				+ "visualizatodo, jefezona, dirfinanzas,creditocobranza, gerentecomercial) "
				+ " VALUES (:idagrupamiento, :descripcion, :visualizatodo, :jefezona,"
				+ " :dirfinanzas,:creditocobranza, :gerentecomercial)";

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
	public void update(AgrupamientoDTO catalogo) throws Exception {
		String query = "UPDATE caagrupadorjerarquias SET descripcion=:descripcion, "
				+ " jefezona=:jefezona, dirfinanzas=:dirfinanzas,"
				+ "creditocobranza=:creditocobranza, gerentecomercial=:gerentecomercial"
				+ " WHERE identificador = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void updateEstatus(AgrupamientoDTO catalogo) throws Exception {
		String query = "UPDATE caagrupadorjerarquias SET estatus= :estatus WHERE " +
			       " idadicional = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(AgrupamientoDTO catalogo) throws Exception {
		String query = "DELETE FROM caagrupadorjerarquias WHERE " +
			       " identificador = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<AgrupamientoDTO> getRegistros(BusquedaDTO catalogo)
			throws Exception {
		List<AgrupamientoDTO> lista = new ArrayList<AgrupamientoDTO>();
		String sql = sql_;
		//Signidica que debe traer todos los registros
		lista = jdbcTemplate.query(sql,new AgrupamientoRowMapper());
		return lista;
	}
	
	@Override
	public List<AgrupamientoDTO> getRegistrosAgrupamientosUsuario(String login)
			throws Exception {
		List<AgrupamientoDTO> lista = new ArrayList<AgrupamientoDTO>();
		String sql = sql_ + " WHERE  idagrupamiento IN "+
				"(SELECT idagrupamiento FROM viewAgrupacionUsuarios WHERE login='" + login +"')" ;
		//Signidica que debe traer todos los registros

		lista = jdbcTemplate.query(sql,new AgrupamientoRowMapper());
		return lista;
	}
	
	
	@Override
	public List<AgrupamientoDTO> getRegistrosXTipo(CatalogoDTO catalogo)
			throws Exception {
		List<AgrupamientoDTO> lista = new ArrayList<AgrupamientoDTO>();
		String sql = sql_ + " WHERE tipo=" + catalogo.getTipo() ;

		//Signidica que debe traer todos los registros
		if (catalogo.getEstatus()>-1){
			sql+= " AND estatus='"+catalogo.getEstatus()+"'";
		}
		
		lista = jdbcTemplate.query(sql,new AgrupamientoRowMapper());
		return lista;
	}
	

	@Override
	public AgrupamientoDTO get(AgrupamientoDTO catalogo) throws Exception {
		String sql = sql_ + " WHERE identificador=?";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new AgrupamientoRowMapper(), catalogo.getIdentificador());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}
	
	@Override
	public List<UsuarioCuentaDTO> getNivelSuperiorDelUsuario(UsuarioDTO  usuario) throws Exception {

		String sql = "SELECT distinct viewAgrupacionUsuarios.idagrupamiento,viewAgrupacionUsuarios.login,viewAgrupacionUsuarios.email, "
				+ "	   nombre,nivelpuesto,(nivelpuesto-" + usuario.getNivelPuesto()+ ") as puestosup FROM viewAgrupacionUsuarios "
				+ "		WHERE idagrupamiento IN (SELECT idagrupamiento FROM viewAgrupacionUsuarios WHERE login=:login)  AND (nivelpuesto-" + usuario.getNivelPuesto()+ ")<0  AND nivelpuesto IN ("
				+ "			SELECT nivelpuesto FROM viewAgrupacionUsuarios "
				+ "			WHERE idagrupamiento IN(SELECT idagrupamiento FROM viewAgrupacionUsuarios WHERE login=:login) AND (nivelpuesto-" + usuario.getNivelPuesto()+ ")<0 "
						+ " )" 
				+ " ORDER BY (nivelpuesto-" + usuario.getNivelPuesto()+ ") desc limit 1";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		try {
			return namedParameterJdbcTemplate.query(sql,parameterSource,new UsuarioCuentaRowMapper());
		} catch (Exception dae) {
			logger.error("Error getNivelSuperiorDelUsuario:" + dae.getMessage());
			return null;
		}
	}
	@Override
	public List<UsuarioCuentaDTO> getNivelSuperiorIndicandoElNivel(UsuarioDTO  usuario,
			int nivelsuperior) throws Exception {

		String sql = "SELECT distinct viewAgrupacionUsuarios.idagrupamiento,viewAgrupacionUsuarios.login,viewAgrupacionUsuarios.email, "
				+ "	   nombre,nivelpuesto,(nivelpuesto-" + usuario.getNivelPuesto()+ ") as puestosup FROM viewAgrupacionUsuarios "
				+ "		WHERE idagrupamiento IN (SELECT idagrupamiento FROM viewAgrupacionUsuarios WHERE login=:login)  AND (nivelpuesto-" + usuario.getNivelPuesto()+ ")<0  AND nivelpuesto IN ("
				+ "			SELECT nivelpuesto FROM viewAgrupacionUsuarios "
				+ "			WHERE idagrupamiento IN(SELECT idagrupamiento FROM viewAgrupacionUsuarios WHERE login=:login) AND (nivelpuesto-" + usuario.getNivelPuesto()+ ")<0 "
						+ " ) and viewAgrupacionUsuarios.nivelpuesto= " +nivelsuperior
				+ " ORDER BY (nivelpuesto-" + usuario.getNivelPuesto()+ ") desc";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		try {
			return namedParameterJdbcTemplate.query(sql,parameterSource,new UsuarioCuentaRowMapper());
		} catch (Exception dae) {
			logger.error("Error getNivelSuperiorDelUsuario:" + dae.getMessage());
			return null;
		}
	}
	
	@Override
	public List<UsuarioCuentaDTO> getNivelSuperiorDelUsuarioTodos(UsuarioDTO  usuario) throws Exception {

		String sql = "SELECT distinct viewAgrupacionUsuarios.login,viewAgrupacionUsuarios.email, "
				+ "	   nombre,nivelpuesto,(nivelpuesto-" + usuario.getNivelPuesto()+ ") as puestosup FROM viewAgrupacionUsuarios "
				+ "		WHERE idagrupamiento IN (SELECT idagrupamiento FROM viewAgrupacionUsuarios WHERE login=:login)  AND (nivelpuesto-" + usuario.getNivelPuesto()+ ")<0  AND nivelpuesto IN ("
				+ "			SELECT nivelpuesto FROM viewAgrupacionUsuarios "
				+ "			WHERE idagrupamiento IN(SELECT idagrupamiento FROM viewAgrupacionUsuarios WHERE login=:login) AND (nivelpuesto-" + usuario.getNivelPuesto()+ ")<0 "
						+ " )" 
				+ " ORDER BY (nivelpuesto-" + usuario.getNivelPuesto()+ ") desc";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		try {
			return namedParameterJdbcTemplate.query(sql,parameterSource,new UsuarioCuentaRowMapper());
		} catch (Exception dae) {
			logger.error("Error getNivelSuperiorDelUsuario:" + dae.getMessage());
			return null;
		}
	}
	@Override
	public List<UsuarioCuentaDTO> getUsuariosDelMismoGrupo(UsuarioDTO  usuario) throws Exception {

		String sql = "SELECT * FROM viewAgrupacionUsuarios WHERE idagrupamiento IN (SELECT idagrupamiento FROM viewAgrupacionUsuarios WHERE login=:login)  ";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		try {
			return namedParameterJdbcTemplate.query(sql,parameterSource,new UsuarioCuentaRowMapper());
		} catch (Exception dae) {
			logger.error("Error getNivelSuperiorDelUsuario:" + dae.getMessage());
			return null;
		}
	}



}
