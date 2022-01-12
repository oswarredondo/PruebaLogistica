/**
 * 
 */
package com.tracusa.logistica.dao;

import java.util.ArrayList;
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
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.tracusa.logistica.model.Entrega;
import com.tracusa.logistica.model.RutaRequest;
import com.tracusa.logistica.model.RutaResponse;
import com.tracusa.logistica.interfase.dao.IEntregaDao;
import com.tracusa.logistica.rowmap.GuiaRowMap;
import com.tracusa.logistica.rowmap.RutaRowMap;
import com.servicio.dtos.Guia;

/**
 * @author aruaro
 *
 */
@Repository
public class EntregaDao extends JdbcDaoSupport implements IEntregaDao {

	private static final Logger logger = LoggerFactory.getLogger(EntregaDao.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	@Autowired
	public EntregaDao(DataSource dataSource) {

		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto
	 * .Entrega)
	 */
	@Override
	public int insert(Entrega obj) throws Exception {
		// logger.info("EntregaDao create insert.");
		String query = "";
		String salida = "0";
		try {
			// Validar si existe una salida reparto
			salida = tieneSalida(obj.getIdguia());
			// String[] movimientos = salida.split("\\|");
			if (salida.equals("5")) {
				query = "INSERT INTO confirma (idguia,conombre,cofecha," + "fechainsercion,latitud,longitud, "
				// + "ruta,plsiglasplaza,ceorigenregistro) " + "VALUES
				// (:idguia,:nomRecibe,'" + obj.getFecha() + "',"
						+ "ruta,plsiglasplaza,ceorigenregistro) " + "VALUES (:idguia,:nomRecibe,current_timestamp,"
						+ "current_timestamp,:latitud,:longitud," + ":ruta,:plaza,:oriReg)";
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
				this.namedParameterJdbcTemplate.update(query, parameterSource);

				query = "INSERT INTO confirma (idguia, conombre, cofecha, fechainsercion, latitud, longitud, ruta, plsiglasplaza, ceorigenregistro) "
						+
						// "(SELECT iddocumento AS idguia, :nomRecibe AS
						// conombre, '" + obj.getFecha() + "' AS cofecha,
						// current_timestamp AS fechainsercion, :latitud AS
						// latitud, :longitud AS longitud, " +
						"(SELECT iddocumento AS idguia, :nomRecibe AS conombre, current_timestamp AS cofecha, current_timestamp AS fechainsercion, :latitud AS latitud, :longitud AS longitud, "
						+ ":ruta AS ruta, :plaza AS plsiglasplaza, :oriReg AS ceorigenregistro FROM cadocumentos WHERE iddocumentomadre IN ('"
						+ obj.getIdguia() + "') AND iddocumento NOT IN ( "
						+ "SELECT idguia FROM confirma WHERE idguia IN (SELECT iddocumento FROM cadocumentos WHERE iddocumentomadre IN ('"
						+ obj.getIdguia() + "'))))";
				this.namedParameterJdbcTemplate.update(query, parameterSource);
			}
			/*
			 * 1 = Tiene entrega 5 = Procede a entrega 2 = No Tiene salida (no
			 * se permite entrega) 0 = Error
			 */
		} catch (DataAccessException dae) {
			logger.debug("error insert:" + dae.getMessage());
		}
		return Integer.parseInt(salida);
	}

	private String tieneSalida(String idguia) throws Exception {
		String query = "";
		try {
			query = "SELECT idguia, tiregistro, exclave, ruta, fechaevento, fechainsercion, empleado FROM movimientos "
					+ "WHERE idguia = '" + idguia + "' ORDER BY fechainsercion DESC LIMIT 1";
			SqlRowSet set = jdbcTemplate.queryForRowSet(query);
			String tiregistro = "";
			int count = 0;
			while (set.next()) {
				tiregistro = set.getString("tiregistro");
			}

			switch (tiregistro) {
			case "24":
				query = "SELECT COUNT(idguia) AS rowcount FROM confirma WHERE idguia = '" + idguia + "'";
				set = jdbcTemplate.queryForRowSet(query);
				set.next();
				count = set.getInt("rowcount");
				if (count >= 1) {
					return "1"; // Si la guia tiene entrega no hacer nada
				} else {
					return "5"; // Si la guia no tiene entrega proceder al
								// registro
				}
			default:
				return "2";
			}
		} catch (DataAccessException dae) {
			logger.debug("error select:" + dae.getMessage());
			throw new Exception("error select: " + dae.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IEntregaDao#update(com.innovargia.ws.dto
	 * .Entrega)
	 */
	@Override
	public int update(Entrega obj) throws Exception {
		// logger.info("EntregaDao create update.");
		String query = "UPDATE confirma SET latitud=:latitud,longitud=:longitud WHERE idguia=:idguia ";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (DataAccessException dae) {
			logger.debug("error insert:" + dae.getMessage());
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IEntregaDao#delete(com.innovargia.ws.dto
	 * .Entrega)
	 */
	@Override
	public int delete(Entrega obj) throws Exception {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IEntregaDao#select(com.innovargia.ws.dto
	 * .Entrega)
	 */
	@Override
	public List<Entrega> select(Entrega obj) throws Exception {

		return new ArrayList<Entrega>();
	}

	@Override
	public List<Guia> select(String manifiesto) throws Exception {
		String sql = "SELECT idguia FROM movimientosmanifiesto where manifiesto= :manifiesto";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("manifiesto", manifiesto);

		return this.namedParameterJdbcTemplate.query(sql, params, new GuiaRowMap());
	}

	@Override
	public List<RutaResponse> getRutas(RutaRequest ruta) throws Exception {

		List<RutaResponse> lstRutas = new ArrayList<>();

		/*
		String sql = "SELECT STRING_AGG(dd.iddocumento,', ') AS iddocumento, CONCAT(dd.CALLE, dd.NUMEXTERIOR,'\n', dd.COLONIA,' ', dd.MUNICIPIO,'\n', dd.ESTADO,' ', dd.CIUDAD) as destino, dd.contacto, dd.telefono FROM CADIRECCIONESDOCUMENTO AS dd "
				+ "INNER JOIN MOVIMIENTOSMANIFIESTO AS mm ON dd.iddocumento = mm.idguia "
				+ "INNER JOIN MOVIMIENTOSMANIFIESTO_DATOS AS md ON mm.manifiesto = md.manifiesto "
				+ "WHERE MD.manifiesto = "
				+ "(SELECT manifiesto FROM MOVIMIENTOSMANIFIESTO_DATOS AS mmd WHERE mmd.viaje = :ruta AND mmd.operador1 = :operador AND mmd.fechacreacion::DATE  = '2017-05-09 09:51:26.069829'::DATE AND mmd.manifiesto LIKE 'SA%' ORDER BY FECHACREACION DESC LIMIT 1) "
				+ "AND idtipodireccion = 'D' GROUP BY destino , dd.contacto, dd.telefono";
		 */
		
		String sql = "SELECT STRING_AGG(dd.iddocumento,',') AS iddocumento, CONCAT(dd.CALLE, dd.NUMEXTERIOR,'\n', dd.COLONIA,' ', dd.MUNICIPIO,'\n', dd.ESTADO,' ', dd.CIUDAD) as destino, dd.contacto, dd.telefono,COUNT(iddocumento) AS totales, COUNT((SELECT idguia FROM confirma WHERE idguia IN(dd.iddocumento))) AS entregadas "
				+ "FROM CADIRECCIONESDOCUMENTO AS dd INNER JOIN MOVIMIENTOSMANIFIESTO AS mm ON dd.iddocumento = mm.idguia "
				+ "INNER JOIN MOVIMIENTOSMANIFIESTO_DATOS AS md ON mm.manifiesto = md.manifiesto WHERE MD.manifiesto = (SELECT manifiesto FROM MOVIMIENTOSMANIFIESTO_DATOS AS mmd WHERE mmd.viaje = :ruta AND mmd.operador1 = :operador AND mmd.fechacreacion::DATE  = 'now'::TEXT::DATE AND mmd.manifiesto LIKE 'SA%' ORDER BY FECHACREACION DESC LIMIT 1) "
				+ "AND idtipodireccion = 'D' GROUP BY destino , dd.contacto, dd.telefono";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ruta", ruta.getViaje());
		params.addValue("operador", ruta.getOperador());

		lstRutas = namedParameterJdbcTemplate.query(sql, params, new RutaRowMap());

		return lstRutas;

	}

}
