/**
 * 
 */
package com.innovargia.ws.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.repo.interfase.dao.IEntregaDao;
import com.innovargia.ws.repo.interfase.dao.IMQMensajesPendientesDAO;

/**
 * @author aruaro
 *
 */
@Repository
public class MQMensajesPendientesDAO extends JdbcDaoSupport implements IMQMensajesPendientesDAO {

	private static final Logger logger = LoggerFactory.getLogger(MQMensajesPendientesDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	@Autowired
	public MQMensajesPendientesDAO(DataSource dataSource) {

		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	/* (non-Javadoc)
	 * @see com.innovargia.ws.dao.IMQMensajesPendientesDAO#insert(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public int insert(String iddocumento, String jsondata, String login, int enviado) throws Exception {
		logger.info("EntregaDao create insert.");

		String query = "INSERT INTO mq_mensajes_pendientes(" + 
		"  iddocumento, fechaevento, jsondata, login, enviado)"
				+ " VALUES ( '" + iddocumento + "',current_timestamp,'" + jsondata + "','" + login + "',0)";

		try {
			this.jdbcTemplate.update(query);
		} catch (DataAccessException dae) {
			logger.debug("error insert:" + dae.getMessage());
		}

		return 0;
	}

	/* (non-Javadoc)
	 * @see com.innovargia.ws.dao.IMQMensajesPendientesDAO#updatePendientes(java.lang.String)
	 */
	@Override
	public void updatePendientes(String uuid) throws Exception {
		logger.info("EntregaDao create update.");
		String query = "UPDATE mq_mensajes_pendientes SET uuid='" + uuid + "' WHERE enviado=0 ";

		try {
			this.jdbcTemplate.update(query);
		} catch (DataAccessException dae) {
			logger.debug("error updatePendientes:" + dae.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.ws.dao.IMQMensajesPendientesDAO#updateEnviado(int, java.lang.String)
	 */
	@Override
	public void updateEnviado(int enviado, String uuid) throws Exception {
		logger.info("EntregaDao create update.");
		String query = "UPDATE mq_mensajes_pendientes SET enviado=" + enviado + " WHERE uuid='" + uuid + "' ";

		try {
			this.jdbcTemplate.update(query);
		} catch (DataAccessException dae) {
			logger.debug("error updateEnviado:" + dae.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.ws.dao.IMQMensajesPendientesDAO#deleteEnviadosEnviado()
	 */
	@Override
	public void deleteEnviadosEnviado() throws Exception {
		logger.info("EntregaDao create update.");
		String query = "DELETE FROM mq_mensajes_pendientes  WHERE enviado=1 ";

		try {
			this.jdbcTemplate.update(query);
		} catch (DataAccessException dae) {
			logger.debug("error deleteEnviadosEnviado:" + dae.getMessage());
		}

	}
}
