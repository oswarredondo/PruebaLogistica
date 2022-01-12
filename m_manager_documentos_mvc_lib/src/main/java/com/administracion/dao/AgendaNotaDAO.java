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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.administracion.idao.IAgendaNotaDAO;
import com.administracion.rowmapper.AttachmentNotaRowMapper;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;

@Repository
public class AgendaNotaDAO extends JdbcDaoSupport implements  IAgendaNotaDAO {

	final String  sql_ = "SELECT  *, nota as descripcion, fechaevento as fecha,"
		+ "tipoarchivo  as extension, archivoadjunto as nombre_archivo "
		+ " FROM agendaor_notas";

	private static final Logger logger = LoggerFactory
			.getLogger(AgendaNotaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private JdbcTemplate jdbcTemplate;

	@Autowired
	public AgendaNotaDAO(DataSource dataSource) {
		
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		//this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void insert(AttachmentDTO catalogo) throws Exception {
		String query = "INSERT INTO agendaor_notas(folio,"
			+ "archivoadjunto,nota,fechaevento,login,"
			+ "idtipodocumento,tipoarchivo,iddocumento, base64) " +
			       "VALUES(:folio,:nombre_archivo,:descripcion,"
			       + "current_timestamp,:login,:idtipodocumento,"
			       + ":extension, :iddocumento,:base64)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "identificador" });
			
			//return keyHolder.getKey();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new DuplicateKeyException(dae.getMessage());

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
		String query = "DELETE FROM agendaor_notas WHERE " +
			       " archivoadjunto  = :nombre_archivo";
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
		 String sql ="";
		 
		if (catalogo.getTipo() ==1){
		    sql = sql_ + " WHERE folio =" + catalogo.getIdentificador_str();
		}else if (catalogo.getTipo() ==2){
		    sql = sql_ + " WHERE iddocumento =:identificador_str";
		}else{
		   return lista; 
		}
		sql = sql + " order by fechaevento desc";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new AttachmentNotaRowMapper());

		return lista;
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
