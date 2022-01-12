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

import com.innovargia.salesmanager.dtos.ContactoDTO;
import com.innovargia.salesmanager.idao.IContactoDAO;
import com.innovargia.salesmanager.mappers.ContactoRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class ContactoDAO extends JdbcDaoSupport implements IContactoDAO{

	private static final Logger logger = LoggerFactory
			.getLogger(ContactoDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	final String  sql_ = "SELECT * FROM cacontactoctefact ";

	@Autowired
	public ContactoDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(ContactoDTO obj) throws Exception {
		String query = "INSERT INTO cacontactoctefact(idcliente,nombre,apellido,email,telefono,"
				+ "telefono2,movil,utilizadircliente,puesto,comentario,clasificacion, extencion,logincreador ) " +
			       "VALUES(:idcliente,:nombre, :apellido, :email,:telefono,:telefono2,:movil,:utilizadircliente,"
			       + " :puesto, :comentario,:clasificacion,:extencion,:logincreador)";

		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idcontacto" });
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
	public void update(ContactoDTO obj) throws Exception {
		String query = "UPDATE cacontactoctefact SET nombre= :nombre,"
				+ " apellido= :apellido,email= :email,telefono= :telefono,telefono2= :telefono2,"
				+ "utilizadircliente= :utilizadircliente, movil=:movil,"
				+ "puesto=:puesto,comentario= :comentario, clasificacion=:clasificacion, extencion=:extencion " 
				+ " WHERE " +
			       " idcontacto = :idcontacto";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(ContactoDTO obj) throws Exception {
		String query = "DELETE FROM cacontactoctefact  WHERE  idcontacto = :idcontacto";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<ContactoDTO> getRegistros(ContactoDTO obj) throws Exception {
		
		List<ContactoDTO> lista = new ArrayList<ContactoDTO>();
		String sql = sql_ + "WHERE idcliente=:idcliente";
		
		if (obj.getVisibilidad()==0){
			sql = sql + " AND logincreador='" + obj.getLogincreador()+ "'";
		}
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new ContactoRowMapper());
		return lista;

	}

	@Override
	public void updateEstatus(ContactoDTO obj) throws Exception {
		String query = "UPDATE cacontactoctefact SET estatus= :estatus"
				+ " WHERE " +
			       " idcontacto = :idcontacto";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public ContactoDTO get(ContactoDTO obj) throws Exception {
		String sql = sql_ + " WHERE idcontacto = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new ContactoRowMapper(), obj.getIdcontacto());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}
	
	
	

}
