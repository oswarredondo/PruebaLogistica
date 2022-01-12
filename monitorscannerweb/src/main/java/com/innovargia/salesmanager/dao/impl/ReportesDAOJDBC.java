/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.idao.IReportesDAOJDBC;

/**
 * @author aruaro
 * 
 */
@Repository
public class ReportesDAOJDBC  extends JdbcDaoSupport implements IReportesDAOJDBC{
	private static final Logger logger = LoggerFactory
			.getLogger(ReportesDAOJDBC.class);

	DataSource _dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ReportesDAOJDBC(DataSource dataSource) {
		this._dataSource = dataSource;
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Connection getConexion() {
		Connection con;
		try {
			con = this._dataSource.getConnection();
		} catch (Exception e) {
			logger.error("Abrir al cerrar la conexion");
			e.printStackTrace();
			return null;
		}
		return con;
	}

	@Override
	public void closeConecction(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			logger.error("Error al cerrar la conexion");
			e.printStackTrace();
		}
	}

}
