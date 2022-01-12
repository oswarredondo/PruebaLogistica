package com.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.administracion.idao.IAttachmentNotaDAO;
import com.administracion.rowmapper.AttachmentNotaRowMapper;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;

@Repository
public class AttachmentNotaDAO extends JdbcDaoSupport implements  IAttachmentNotaDAO {

	final String  sql_ = "SELECT idregistro,identificador,nombre_archivo,descripcion,fecha,login,idtipodocumento FROM caattachdocumento";

	private static final Logger logger = LoggerFactory
			.getLogger(AttachmentNotaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private JdbcTemplate jdbcTemplate;

	@Autowired
	public AttachmentNotaDAO(DataSource dataSource) {
		
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		//this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void insert(AttachmentDTO catalogo) throws Exception {
		String query = "INSERT INTO caattachdocumento(identificador,nombre_archivo,descripcion,fecha,login,idtipodocumento) " +
			       "VALUES(:identificador,:nombre_archivo,:descripcion,current_timestamp,:login,:idtipodocumento)";
		
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
	public void update(AttachmentDTO catalogo) throws Exception {
	}

	@Override
	public void updateEstatus(AttachmentDTO catalogo) throws Exception {
	}

	@Override
	public void delete(AttachmentDTO catalogo) throws Exception {
		String query = "DELETE FROM caattachdocumento WHERE " +
			       " nombre_archivo = :nombre_archivo";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<AttachmentDTO> getRegistros(BusquedaDTO catalogo)
			throws Exception {
		List<AttachmentDTO> lista = new ArrayList<AttachmentDTO>(); 
		String sql = sql_ + " WHERE identificador =:identificador_str AND idtipodocumento = :tipo_str  order by fecha desc";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new AttachmentNotaRowMapper());

		return lista;
	}
	@Override
	public AttachmentDTO getRegistro(int idregistro) throws Exception {
		List<AttachmentDTO> lista = new ArrayList<AttachmentDTO>(); 
		String sql = sql_ + " WHERE idregistro=:idregistro";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idregistro", idregistro);
		lista =  this.namedParameterJdbcTemplate.query(sql, params, new AttachmentNotaRowMapper());
		if (lista.size()>0){
			return lista.get(0);
		}

		return null;
	}
	
	@Override
	public AttachmentDTO getRegistroBase64(int idregistro) throws Exception {
		List<AttachmentDTO> lista = new ArrayList<AttachmentDTO>(); 
		String sql ="SELECT idregistro,identificador,"
				+ "nombre_archivo,descripcion,fecha,login,idtipodocumento,base64 "
				+ "FROM caattachdocumento WHERE idregistro=:idregistro";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idregistro", idregistro);
		lista =  this.namedParameterJdbcTemplate.query(sql, params, new AttachmentNotaRowMapper());
		if (lista.size()>0){
			return lista.get(0);
		}

		return null;
	}
	
	
	@Override
	public List<AttachmentDTO> getRegistros(ArrayList<String> arr_identificador, ArrayList<String> arr_idtipodocumento)
			throws Exception {
		
		List<AttachmentDTO> lista = new ArrayList<AttachmentDTO>(); 
		
		if (arr_identificador.size()<=0){
			return lista;
		}
		String id_str="";
		for (String id : arr_identificador) {
			id_str=id_str+ "'" + id +"' ";
		}
		id_str = id_str.trim().replace(" ", ",");
		
		String tipodocumento_str="";
		for (String tipo : arr_idtipodocumento) {
			tipodocumento_str=tipodocumento_str+ "'" + tipo +"' ";
		}
		tipodocumento_str = tipodocumento_str.trim().replace(" ", ",");
		
		String sql = sql_ + " WHERE identificador IN ("+id_str+")";
		if (tipodocumento_str.trim().length()>0){
			sql=sql+ " AND idtipodocumento IN (" + tipodocumento_str+ ")";
		}
		lista =  this.namedParameterJdbcTemplate.query(sql,  new AttachmentNotaRowMapper());

		return lista;
	}
	

	@Override
	public AttachmentDTO get(AttachmentDTO catalogo) throws Exception {
		return null;
	}


}
