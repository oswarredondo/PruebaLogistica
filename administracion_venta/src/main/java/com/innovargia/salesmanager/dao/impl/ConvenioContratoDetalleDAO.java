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

import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.idao.IConvenioContratoDAO;
import com.innovargia.salesmanager.idao.IConvenioContratoDetalleDAO;
import com.innovargia.salesmanager.mappers.ConvenioContratoDetalleRowMapper;
import com.innovargia.salesmanager.mappers.ConvenioContratoRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class ConvenioContratoDetalleDAO extends JdbcDaoSupport implements IConvenioContratoDetalleDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ConvenioContratoDetalleDAO.class);

	final String  sql_ = "SELECT *, getPesoVolumetrico(alto, ancho, largo) as "
			+ " volumen FROM caconveniodetalle LEFT OUTER JOIN cadescuento ON "
			+ "caconveniodetalle.iddescuento = cadescuento.iddescuento ";
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ConvenioContratoDetalleDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(ConvenioContratoDetalleDTO obj) throws Exception {
		String query = "INSERT INTO caconveniodetalle( idconvenio, "
				+ "siglasori, siglasdes, peso, largo, alto, ancho, coberturakm, "
				+ " precio,cporigen,cpdestino, sobrepeso,"
				+ "comentario,preciosobrepeso,pesovolumetrico,"
				+ "idtarifa,idtarifapeso,idrangoenvios,idserviciotarifazona,precio_real)"
				+ "    VALUES (:idconvenio, :siglasori, :siglasdes, :peso, "
				+ " :largo, :alto, :ancho, :coberturakm, :precio,"
				+ " :cporigen,:cpdestino,:sobrepeso,:comentario,"
				+ ":preciosobrepeso,getPesoVolumetrico(:alto, :ancho, :largo),"
				+ ":idtarifa,:idtarifapeso,:idrangoenvios,:idserviciotarifazona,:precio_real)";
		  
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idconveniodetalle" });
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
	public void update(ConvenioContratoDetalleDTO obj) throws Exception {
		String query = "UPDATE caconveniodetalle"
				+ " SET siglasori=:siglasori, siglasdes=:siglasdes,peso=:peso, largo=:largo, "
				+ "alto=:alto, ancho=:ancho, coberturakm=:coberturakm, pesovolumetrico=:pesovolumetrico"
				+ "precio=:precio, cporigen=:cporigen,cpdestino=:cpdestino, sobrepeso=:sobrepeso,"
				+ "idtarifa=:idtarifa,idtarifapeso=:idtarifapeso,"
				+ "idrangoenvios=:idrangoenvios,"
				+ "iddserviciotarifazona=:iddserviciotarifazona"
				+ " WHERE idconveniodetalle=:idconveniodetalle";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void updatePrecio(ConvenioContratoDetalleDTO obj) throws Exception {
		String query = "UPDATE caconveniodetalle"
				+ " SET precio=:precio, preciosobrepeso=:preciosobrepeso "
				+ " WHERE idconveniodetalle=:idconveniodetalle";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}

		
	}

	
	@Override
	public void delete(ConvenioContratoDetalleDTO obj) throws Exception {
		String query = "DELETE FROM caconveniodetalle   WHERE idconveniodetalle=:idconveniodetalle";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<ConvenioContratoDetalleDTO> getRegistros(ConvenioContratoDetalleDTO obj)
			throws Exception {
		List<ConvenioContratoDetalleDTO> lista = new ArrayList<ConvenioContratoDetalleDTO>();
		
		String sql = "SELECT *, getPesoVolumetrico(alto, ancho, largo) as  volumen FROM caconveniodetalle LEFT OUTER JOIN ("+
				" 			select caconvenio.idconvenio,cadescuento.porcentaje as descuento  from caconvenio "+
				" 			LEFT OUTER JOIN cadescuento ON caconvenio.iddescuento = cadescuento.iddescuento WHERE caconvenio.idconvenio=" + obj.getIdconvenio() + 
				"	) convenio ON convenio.idconvenio = caconveniodetalle.idconvenio WHERE  convenio.idconvenio=" + obj.getIdconvenio() ;
				
		lista = jdbcTemplate.query(sql,new ConvenioContratoDetalleRowMapper());
		return lista;
	}

	@Override
	public ConvenioContratoDetalleDTO get(ConvenioContratoDetalleDTO obj) throws Exception {

		String sql = sql_ + " WHERE caconveniodetalle.idconveniodetalle="+obj.getIdconveniodetalle();
		List<ConvenioContratoDetalleDTO> lista = jdbcTemplate.query(sql,new ConvenioContratoDetalleRowMapper());
		if ((lista!=null) && (lista.size()>0)) {
			return lista.get(0);
		}
		return null;
	}
		

	@Override
	public void updateEstatus(ConvenioContratoDetalleDTO obj) throws Exception {
	
		
	}
	
	

}
