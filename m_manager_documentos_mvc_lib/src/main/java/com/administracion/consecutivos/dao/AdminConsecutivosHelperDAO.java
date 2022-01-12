/**
 * 
 */
package com.administracion.consecutivos.dao;

import java.io.IOException;
import java.sql.SQLException;
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

import com.administracion.idao.IAdminConsecutivosDAO;
import com.administracion.idao.IAdminConsecutivosHelperDAO;
import com.administracion.rowmapper.MetaDatoCatalogoRowMapper;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.utils.UtilsStringFechas;

/**
 * Clase que obtiene y genera un Consecutivo de acuerdo al tipo de documento
 * indicado
 * 
 * @author Adrian Morales Ruaro
 * 
 */
@Repository
public class AdminConsecutivosHelperDAO extends JdbcDaoSupport implements IAdminConsecutivosHelperDAO  {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminConsecutivosHelperDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private JdbcTemplate jdbcTemplate;

	@Autowired
	public AdminConsecutivosHelperDAO(DataSource dataSourceConsecutivo) {
		setDataSource(dataSourceConsecutivo);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
			dataSourceConsecutivo);
		//this.jdbcTemplate = new JdbcTemplate(dataSourceConsecutivo);
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {

	}// fin de debug

	

	/* (non-Javadoc)
	 * @see com.administracion.consecutivos.dao.IAdminConsecutivosHelperDAO#getConsecutivo(com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO)
	 */
	@Override
	public String getConsecutivo(MetaDatoCatalogoDTO meta) throws SQLException {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String uuid="registro"+ UtilsStringFechas.obtenerFechaActual("yyyyMMddHHmmssS");
		try {
			uuid = UUIDUniqueCreator.generateUUID();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String query = "INSERT INTO " + meta.getTabla() + "(iddocumento) VALUES('" + uuid+"')"; 
		 logger.debug("getConsecutivo query:" + query);
		try {
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
					meta);
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "consecutivo" });
			
			//Completa el alrgo del consecurivos
			Number consecutivo=  keyHolder.getKey();
			String consecutivo_str =""+consecutivo.intValue();
			while (consecutivo_str.trim().length()<meta.getLargoConsecutivo()) {
				consecutivo_str="0"+consecutivo_str;
			}
			return consecutivo_str;
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
	 * @see com.administracion.consecutivos.dao.IAdminConsecutivosHelperDAO#existeTablaConsecutivos(com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO)
	 */
	@Override
	public boolean existeTablaConsecutivos(MetaDatoCatalogoDTO meta) throws Exception {
		
		if (meta==null){
			return false;
		}
		
		String sql = "UPDATE "+ meta.getTabla() + " "
				+ "SET iddocumento='SKY' WHERE iddocumento='SKY4SOL' " ;
		
		logger.error("sql :" + sql);
		try {
			MapSqlParameterSource params = new MapSqlParameterSource();
			
			this.namedParameterJdbcTemplate.update(sql, params);
			return true;

		} catch (Exception e) {
			logger.error("Error :" + e.getMessage());

		}
		
		return false;

	}

}
