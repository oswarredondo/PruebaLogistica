/**
 * 
 */
package com.administracion.consecutivos.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.idao.IAdminConsecutivosDAO;
import com.administracion.idao.IAdminConsecutivosHelperDAO;
import com.administracion.rowmapper.MetaDatoCatalogoRowMapper;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;

/**
 * Clase que obtiene y genera un Consecutivo de acuerdo al tipo de documento
 * indicado
 * 
 * @author Adrian Morales Ruaro
 * 
 */
@Repository
public class AdminConsecutivosDAO extends JdbcDaoSupport implements
		IAdminConsecutivosDAO {

   	@Autowired
	IAdminConsecutivosHelperDAO iAdminConsecutivosHelperDAO;
   	
	private static final Logger logger = LoggerFactory
			.getLogger(AdminConsecutivosDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private JdbcTemplate jdbcTemplate;

	@Autowired
	public AdminConsecutivosDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		//this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {

	}// fin de debug

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.consecutivos.dao.IAdminConsecutivosDAO#getDatosTipoDoc
	 * (int, int, boolean)
	 */
	@Override
	public ArrayList<MetaDatoCatalogoDTO> getDatosTipoDoc(int identidad,
			int organizacion, boolean onlyVisible) throws SQLException {

		String sql = "SELECT * FROM caTipoDocumento WHERE identidad=:identidad "
				+ " AND idorganizacion=:organizacion ";
		if (onlyVisible) {
			sql += " AND visible=" + onlyVisible;
		}

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("onlyVisible", onlyVisible);
		params.addValue("identidad", identidad);
		params.addValue("organizacion", organizacion);
		
		List<MetaDatoCatalogoDTO> lista = new ArrayList<MetaDatoCatalogoDTO>();
		try {
			lista = namedParameterJdbcTemplate.query(sql, params, new MetaDatoCatalogoRowMapper());

		} catch (Exception e) {
			logger.error("Error :" + e.getMessage());

		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.consecutivos.dao.IAdminConsecutivosDAO#getDatosTipoDoc
	 * (java.lang.String, int, int)
	 */
	@Override
	public MetaDatoCatalogoDTO getDatosTipoDoc(String id, int identidad,
			int organizacion) throws SQLException {

		String sql = "SELECT * FROM caTipoDocumento WHERE IdTipoDocumento = '"
				+ id + "' AND identidad=:identidad AND idorganizacion=:organizacion";
		logger.error("getDatosTipoDoc :" + sql);
		List<MetaDatoCatalogoDTO> lista = new ArrayList<MetaDatoCatalogoDTO>();
		try {
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("identidad", identidad);
			params.addValue("organizacion", organizacion);
			
			lista = this.namedParameterJdbcTemplate.query(sql, params,new MetaDatoCatalogoRowMapper());
			if (lista.size()>0){
				return lista.get(0);
			}

		} catch (Exception e) {
			logger.error("Error :" + e.getMessage());

		}
		return null;

		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.consecutivos.dao.IAdminConsecutivosDAO#getDatosTipoDoc
	 * (java.lang.String, int, int)
	 */
	@Override
	public MetaDatoCatalogoDTO getDatosTipoDocCuenta(String id, int identidad,
			int organizacion, String cuenta) throws SQLException {

		String iddocumento_str = id+cuenta;
		String sql = "SELECT * FROM caTipoDocumento WHERE idtipodocumento=:iddocumento_str "
				+ " AND identidad=:identidad AND idorganizacion=:organizacion" ;
		
		logger.error("sql :" + sql);
				
		List<MetaDatoCatalogoDTO> lista = new ArrayList<MetaDatoCatalogoDTO>();
		try {
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("identidad", identidad);
			params.addValue("organizacion", organizacion);
			params.addValue("iddocumento_str", iddocumento_str);
			
			lista = this.namedParameterJdbcTemplate.query(sql,params, 
					new MetaDatoCatalogoRowMapper());
			if (lista.size()>0){
				return lista.get(0);
			}

		} catch (Exception e) {
			logger.error("Error :" + e.getMessage());

		}
		return null;

		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.consecutivos.dao.IAdminConsecutivosDAO#getConsecutivo
	 * (com.administracion.dto.MetaDatoCatalogoDTO)
	 */
	@Override
	public String getConsecutivo(MetaDatoCatalogoDTO meta) throws SQLException {
	    return iAdminConsecutivosHelperDAO.getConsecutivo(meta);
		
		

		
	}
	
	@Override
	public boolean existeTablaConsecutivos(MetaDatoCatalogoDTO meta) throws Exception {
		return iAdminConsecutivosHelperDAO.existeTablaConsecutivos(meta);


	}

}
