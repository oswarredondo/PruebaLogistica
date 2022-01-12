/* $Id:$
 * Nombre del Proyecto:
 * Nombre del Programa: HistoriaDao.java
 * Responsable:
 * Descripcion: Muestra datos de Historia
 *
 * $Log:$
 */

package com.administracion.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.idao.IHistoriaDAO;
import com.administracion.rowmapper.SeguimientoRowMapper;
import com.servicio.dtos.Movimiento;

@Repository
public class HistoriaDao extends JdbcDaoSupport implements IHistoriaDAO {

	private static final Logger logger = LoggerFactory.getLogger(HistoriaDao.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public HistoriaDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// Obtiene el log de la aplicacion
	// private Logger logger = Bitacora.getBitacora();

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		logger.debug(mensaje);
	}// fin de debug

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.dao.IHistoriaDAO#insertHistoriaDocumento(com.servicio.
	 * dtos.Movimiento)
	 */
	@Override
	public void insertHistoriaDocumento(Movimiento movimiento) throws SQLException {

		String sql = "INSERT INTO movimientos(idguia, tiregistro, exclave, "
				+ "plsiglasplaza, ceorigenregistro, ruta, fechaevento, " + "fechainsercion, empleado) VALUES "
				+ " (:guia,:tipoRegistro,:claveLogistica,:siglasPlaza,"
				+ ":origenRegistro, :ruta, current_timestamp,current_timestamp,:empleado )";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(movimiento);

		try {
			this.namedParameterJdbcTemplate.update(sql, parameterSource);

		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.administracion.dao.IHistoriaDAO#getHistoria(java.lang.String)
	 */
	@Override
	public List<Movimiento> getHistoria(String idGuia) throws SQLException {

		String sql = "SELECT mov.*,caexcepcion.descripcion as descripcionexcepcion  FROM ( "
				+ " SELECT  Movimientos.*,inforegistros_maestro.descripcion as registrodescripcion  FROM Movimientos  "
				+ " LEFT OUTER JOIN inforegistros_maestro ON Movimientos.tiRegistro = inforegistros_maestro.idregistro  "
				+ " )mov LEFT OUTER JOIN caexcepcion ON mov.exclave = caexcepcion.idexcepcion	 "
				+ " WHERE IdGuia=? ORDER BY FechaEvento DESC ";

		List<Movimiento> lista = jdbcTemplate.query(sql, new Object[] { idGuia }, new SeguimientoRowMapper());

		for (Movimiento movimiento : lista) {
			movimiento.setIdCasamiento(getCasamiento(idGuia, movimiento.getFecha()));
			if (movimiento.getIdCasamiento() != null) {
				movimiento
						.setTipoRegistro(movimiento.getTipoRegistro() + "  Referencia:" + movimiento.getIdCasamiento());
			}
		}

		return lista;

	}// fin de getHistoria

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.administracion.dao.IHistoriaDAO#getHistoria(java.lang.String,
	 * boolean)
	 */
	@Override
	public List<Movimiento> getHistoria(String idGuia, boolean confirmacion) throws SQLException {

		String sql = "SELECT mov.*,caexcepcion.descripcion as descripcionexcepcion  FROM ( "
				+ " SELECT  Movimientos.*,inforegistros_maestro.nombre as registrodescripcion  FROM Movimientos  "
				+ " LEFT OUTER JOIN inforegistros_maestro ON Movimientos.tiRegistro = inforegistros_maestro.idregistro  "
				+ " )mov LEFT OUTER JOIN caexcepcion ON mov.exclave = caexcepcion.idexcepcion	 "
				+ " WHERE IdGuia=? ORDER BY FechaEvento DESC ";
		
		 logger.info("Historia sql:" + sql);
		List<Movimiento> lista = jdbcTemplate.query(sql, new Object[] { idGuia }, new SeguimientoRowMapper());
		for (Movimiento movimiento : lista) {
			if (movimiento.getTipoRegistro().equals("9") || movimiento.getTipoRegistro().equals("09")) {
				movimiento.setIdCasamiento(getCasamiento(idGuia, movimiento.getFecha()));
				if (movimiento.getIdCasamiento() != null) {
					movimiento.setTipoRegistro(
							movimiento.getTipoRegistro() + "  Referencia:" + movimiento.getIdCasamiento());
				}
			}
		}

		return lista;

	}// fin de getHistoria

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.administracion.dao.IHistoriaDAO#getCasamiento(java.lang.String,
	 * java.sql.Timestamp)
	 */
	@Override
	public String getCasamiento(String idGuia, String fechaevento) throws SQLException {

		String sql = "SELECT  IdGuia,FechaEvento," + " IdCasamiento,IdCarrier, plSiglasPlaza,ceOrigenRegistro,Ruta "
				+ "  FROM Casamiento WHERE IdGuia=?  ";

		List<Movimiento> lista = jdbcTemplate.query(sql, new Object[] { idGuia }, new SeguimientoRowMapper());

		if (lista.size() > 0) {
			lista.get(0).getGuia();
		}

		return null;

	}// fin de getCasamiento

	@Override
	public int insertCasamiento(Movimiento obj) throws Exception {
		// TODO Auto-generated method stub
		logger.info("MovimientosDao create insertCasamiento.");
		String fecha =  obj.getFecha()==null?"current_timestamp": "'" + obj.getFecha() + "'";
		String query = "INSERT INTO casamiento(idguia, idcasamiento, idcarrier, ceorigenregistro, "
				+ " plsiglasplaza, fechaevento, ruta, empleado)"
				+ " VALUES (:idguia,:guiaCasamiento,:idCarrier,:oriReg,:plaza ,:fecha, :ruta,:empleado);";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);

		try {
			MapSqlParameterSource  params = new MapSqlParameterSource();
			params.addValue("idguia", obj.getGuia());
			params.addValue("guiaCasamiento",  obj.getIdCasamiento());
			params.addValue("idCarrier",  obj.getIdCarrier());
			params.addValue("oriReg",  obj.getOrigenRegistro());
			params.addValue("plaza",  obj.getSiglasPlaza());
			params.addValue("fecha",  fecha);
			params.addValue("ruta",  obj.getRuta());
			params.addValue("empleado",  obj.getEmpleado());
			
			
			
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (DataAccessException dae) {
			logger.debug("error insertCasamiento:" + dae.getMessage());
		}

		return 0;
	}

}// fin de AccesoDao
