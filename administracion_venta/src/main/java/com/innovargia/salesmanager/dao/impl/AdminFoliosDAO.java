package com.innovargia.salesmanager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.dto.Folios;
import com.administracion.rowmapper.FoliosRowMapper;
import com.innovargia.salesmanager.idao.IAdminFoliosDAO;

@Repository
public class AdminFoliosDAO extends JdbcDaoSupport implements IAdminFoliosDAO {

	private static final Logger logger = LoggerFactory.getLogger(AdminFoliosDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AdminFoliosDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IFoliosDAO#insert(com.administracion.dto.Folios)
	 */
	@Override
	public void insert(Folios obj) throws Exception {

		String query = "INSERT INTO folios(numcliente, idservicio, cantidadasiganda, "
				+ "  peso, fechaliberacion, identidad, idorganizacion,cantidadutilizada) "
				+ " VALUES (:numCliente, :idServicio, :cantidadAsignada, :peso," + " current_timestamp, "
				+ obj.entidad.getIdentidad() + ", " + obj.organizacion.getIdorganizacion() + ",0)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IFoliosDAO#increment(com.administracion.dto.Folios)
	 */
	@Override
	public void increment(Folios obj) throws Exception {

		String query = "UPDATE folios SET cantidadasiganda= cantidadasiganda + :cantidadAsignada"
				+ " WHERE  idregistro = :idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IFoliosDAO#delete(com.administracion.dto.Folios)
	 */
	@Override
	public void delete(Folios obj) throws Exception {

		String query = "DELETE FROM folios WHERE  idregistro = :idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IFoliosDAO#getRegistros(java.lang.String)
	 */
	@Override
	public List<Folios> getRegistros(Folios folio) throws Exception {
		List<Folios> lista = new ArrayList<Folios>();
		String sql = "SELECT distinct folios.*,catiposervicio.descripcion"
				+ "  FROM folios JOIN catiposervicio ON "
				+ " folios.idservicio = catiposervicio.idservicio "
				+ " WHERE folios.identidad=" + 
				  folio.entidad.getIdentidad()+ " AND "
				+ "folios.idorganizacion=" + folio.organizacion.getIdorganizacion()+"  AND "
				+ " numcliente='" + folio.getNumCliente() + "'";
				
		lista = jdbcTemplate.query(sql, new FoliosRowMapper());
		return lista;
	}

}
