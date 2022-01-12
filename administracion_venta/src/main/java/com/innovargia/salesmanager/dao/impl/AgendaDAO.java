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

import com.administracion.dto.AgendaOR;
import com.innovargia.salesmanager.idao.IAgendaDAO;
import com.innovargia.salesmanager.mappers.AgendaORRowMapper;
import com.innovargia.salesmanager.mappers.CatalogoRowMapper;

@Repository
public class AgendaDAO extends JdbcDaoSupport implements  IAgendaDAO {

	final String  sql_ = "SELECT * FROM agendaor";

	private static final Logger logger = LoggerFactory
			.getLogger(AgendaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AgendaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Number insert(AgendaOR catalogo) throws Exception {
		
		String query = "INSERT INTO agendaor("
			+ " quiencaptura, fechacaptura,"
			+ " quiensolicita, nombresolicita, "
			+ " telefonosolicita, iddocumento,"
			+ " datosorigen, datosdestino, tipoproblema, "
			+ " depto_que_atiende, nombre_quien_atiende,"
			+ " tiposolucion, fechacierre, estatus, comentariocierre,prioridad)"
			+ " VALUES ( :quiencaptura, current_timestamp, "
			+ " :quiensolicita, :nombresolicita,:telefonosolicita, "
			+ " :iddocumento, :datosorigen, :datosdestino, :tipoproblema, "
			+ " :depto_que_atiende, :nombre_quien_atiende, :tiposolucion, null, "
			+ " :estatus, :comentariocierre,:prioridad)";
	
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "folio" });
			
			return keyHolder.getKey();
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
	public void update(AgendaOR catalogo) throws Exception {

		String query = "UPDATE agendaor"
			+ "   SET quiencaptura=:quiencaptura,  "
			+ "  quiensolicita=:quiensolicita, "
			+ "  nombresolicita=:nombresolicita, "
			+ "  telefonosolicita=:telefonosolicita,"
			+ " datosorigen=:datosorigen, datosdestino=:datosdestino, "
			+ " tipoproblema=:tipoproblema,prioridad=:prioridad "
			+ " WHERE folio=:folio";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}
	@Override
	public void updateAsignadoAtiende(AgendaOR catalogo) throws Exception {

		String query = "UPDATE agendaor"
			+ "   SET fecha_asignado_atiende=:fecha_asignado_atiende,  "
			+ "  depto_que_atiende=:depto_que_atiende, "
			+ "  nombre_quien_atiende=:nombre_quien_atiende "
			
			+ " WHERE folio=:folio";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}
	
	@Override
	public void updateDatosCierre(AgendaOR catalogo) throws Exception {
		String query = " UPDATE agendaor"
			+ "   SET tiposolucion=:tiposolucion, "
			+ " fechacierre='"+ catalogo.getFechacierre() +"', estatus=:estatus,"
			+ " comentariocierre=:comentariocierre"
			+ " WHERE folio=:folio";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en updateEstatus: " + dae.getMessage());
		}
		
	}
	
	@Override
	public void updateEstatus(AgendaOR catalogo) throws Exception {
	    String query = " UPDATE agendaor SET estatus=:estatus WHERE folio=:folio";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(AgendaOR catalogo) throws Exception {
	    String query = " DELETE FROM agendaor WHERE folio=:folio";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<AgendaOR> getRegistros(AgendaOR catalogo)
			throws Exception {
		List<AgendaOR> lista = new ArrayList<AgendaOR>();
		String sql = sql_;

		
		if (catalogo.getTipo() ==10){
		    sql = sql_ + " WHERE folio =" + catalogo.getFolio() ;
		}else if (catalogo.getTipo() ==20){
		    sql = sql_ + " WHERE iddocumento ='" +  catalogo.getIddocumento()+ "'";
		}else if (catalogo.getTipo() ==40){
		    sql = sql_ + " WHERE nombresolicita LIKE '" +  catalogo.getQuiensolicita()+ "%'";  
		}else if (catalogo.getTipo() ==30){
		    sql = sql_ + " WHERE telefonosolicita LIKE '" +  catalogo.getTelefonosolicita()+ "%'";    
		}else{
		   return lista; 
		}
		
		lista = jdbcTemplate.query(sql,new AgendaORRowMapper());
		return lista;
	}
	
	

	@Override
	public AgendaOR get(AgendaOR catalogo) throws Exception {
		String sql = sql_ + " WHERE folio="+catalogo.getFolio();
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new AgendaORRowMapper());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}


}
