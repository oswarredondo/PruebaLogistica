package com.innovargia.salesmanager.dao.impl;

import java.util.ArrayList;
import java.util.Date;
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

import com.google.gson.Gson;
import com.innovargia.autodoc.dto.DesgloceCumplimientoDias;
import com.innovargia.autodoc.dto.DesgloceCumplimientoDiasTotal;
import com.innovargia.autodoc.dto.FiltrosReportesIndicadores;
import com.innovargia.autodoc.dto.MedicionCrossDock;
import com.innovargia.autodoc.dto.MedicionCumplimientoGarantias;
import com.innovargia.autodoc.dto.MedicionDias;
import com.innovargia.autodoc.dto.MedicionGarantiasPorCliente;
import com.innovargia.autodoc.dto.MedicionIntentosEntrega;
import com.innovargia.autodoc.dto.MedicionPendientesCO;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.idao.IndicadoresDAO;
import com.innovargia.salesmanager.mappers.MedicionCrossDockRowMapper;
import com.innovargia.salesmanager.mappers.MedicionCumplimientoGarantiasRowMapper;
import com.innovargia.salesmanager.mappers.MedicionDiasRowMapper;
import com.innovargia.salesmanager.mappers.MedicionDiasTotalRowMapper;
import com.innovargia.salesmanager.mappers.MedicionGarantiasPorClienteRowMapper;
import com.innovargia.salesmanager.mappers.MedicionIntentosEntregaRowMapper;
import com.innovargia.salesmanager.mappers.MedicionPendientesCORowMapper;

@Repository
public class IndicadoresIDAO extends JdbcDaoSupport implements IndicadoresDAO {

	final String where_ = "AND cadocumentos.fechacreacion::date BETWEEN(:fecha_inicio::date) AND (:fecha_fin::date)";

	private static final Logger logger = LoggerFactory.getLogger(IndicadoresIDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public IndicadoresIDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<MedicionGarantiasPorCliente> getMedicionGarantiaXCliente(FiltrosReportesIndicadores filtros)
			throws Exception {

		List<MedicionGarantiasPorCliente> lstResult = null;

		String sql = "";

		if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
				|| !filtros.getMes_recoleccion().equals("12")) {

			filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

		}

		try {

			sql = "SELECT " + "caclientesrfc.razonsocial AS nombre_cliente, "
					+ "ROUND(AVG(contardiashabiles2(view_primer_recoleccion.fechaevento::date,(confirma.cofecha::date))),1) AS TIEMPO_ENTREGA, "
					+ "ROUND(AVG(contardiashabiles2(view_primer_recoleccion.fechaevento::date, now()::date)),1) AS TRANSITO, "
					+ "(ROUND(AVG(contardiashabiles2(view_primer_recoleccion.fechaevento::date, now()::date)),1) - ROUND(AVG(contardiashabiles2(view_primer_recoleccion.fechaevento::date,(confirma.cofecha::date))),1)) AS DIF_CONFIRMACION "
					+ "FROM " + "cadocumentos " + "INNER JOIN confirma ON confirma.idguia = cadocumentos.iddocumento "
					+ "INNER JOIN view_primer_recoleccion ON (view_primer_recoleccion.idguia = cadocumentos.iddocumento) "
					+ "INNER JOIN caclientesrfc ON cadocumentos.numcliente = caclientesrfc.numcliente "
					+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = cadocumentos.iddocumento AND idtipodireccion = 'D' "
					+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo " + "WHERE "
					// +"frecuenciasentrega.idagrupador = 'LEN' "
					+ "confirma.cofecha IS NOT NULL "
					+ "AND SUBSTRING (view_primer_recoleccion.fechaevento::text FROM 6 FOR 2) = :mes_recoleccion ";

			if (!filtros.getCentro_operativo().equals("ALL")) {

				sql = sql + " AND frecuenciasentrega.idagrupador = :centro_operativo ";

			}

			if (filtros.getTipo_entrega().equals("1")) {

				sql = sql + "AND frecuenciasentrega.idterminal = frecuenciasentrega.idagrupador ";

			} else if (filtros.getTipo_entrega().equals("2")) {

				sql = sql + "AND frecuenciasentrega.idterminal != frecuenciasentrega.idagrupador ";

			}

			sql = sql + where_;

			sql = sql + " GROUP BY nombre_cliente ORDER BY nombre_cliente DESC";

			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

			lstResult = namedParameterJdbcTemplate.query(sql, parameterSource,
					new MedicionGarantiasPorClienteRowMapper());

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}

	}

	@Override
	public List<MedicionCumplimientoGarantias> getMedicionCumplimientoGarantias(FiltrosReportesIndicadores filtros)
			throws Exception {

		List<MedicionCumplimientoGarantias> lstResult = null;

		String sql = "";

		if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
				|| !filtros.getMes_recoleccion().equals("12")) {

			filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

		}

		try {

			sql = "SELECT " + "caclientesrfc.razonsocial AS nombre_cliente, " + "ROUND((( " + "SUM( " + "CASE "
					+ "WHEN (contardiashabiles2(view_primer_recoleccion.fechaevento::date,confirma.cofecha::date)) <= (SELECT tiempo FROM SCBASECRUCESCP WHERE ori = cadocumentos.zonaori AND dest = cadocumentos.zonades ) "
					+ "THEN 1::int ELSE 0::int END "
					+ ") * 100::NUMERIC) / COUNT(cadocumentos.iddocumento)),1) AS SI_CUMPLIO, " + "ROUND((( " + "SUM( "
					+ "CASE "
					+ "WHEN (contardiashabiles2(view_primer_recoleccion.fechaevento::date,confirma.cofecha::date)) > (SELECT tiempo FROM SCBASECRUCESCP WHERE ori = cadocumentos.zonaori AND dest = cadocumentos.zonades ) "
					+ "THEN 1::int ELSE 0::int END "
					+ ") * 100::NUMERIC) / COUNT(cadocumentos.iddocumento)),1) AS NO_CUMPLIO " + "FROM "
					+ "cadocumentos " + "INNER JOIN confirma ON confirma.idguia = cadocumentos.iddocumento "
					+ "INNER JOIN view_primer_recoleccion ON (view_primer_recoleccion.idguia = cadocumentos.iddocumento) "
					+ "INNER JOIN caclientesrfc ON cadocumentos.numcliente = caclientesrfc.numcliente "
					+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = cadocumentos.iddocumento AND idtipodireccion = 'D' "
					+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo " + "WHERE "
					// +"frecuenciasentrega.idagrupador = 'LEN' "
					+ "confirma.cofecha IS NOT NULL "
					+ "AND SUBSTRING (view_primer_recoleccion.fechaevento::text FROM 6 FOR 2) = :mes_recoleccion ";

			if (!filtros.getCentro_operativo().equals("ALL")) {

				sql = sql + " AND frecuenciasentrega.idagrupador = :centro_operativo ";

			}

			if (filtros.getTipo_entrega().equals("1")) {

				sql = sql + "AND frecuenciasentrega.idterminal = frecuenciasentrega.idagrupador ";

			} else if (filtros.getTipo_entrega().equals("2")) {

				sql = sql + "AND frecuenciasentrega.idterminal != frecuenciasentrega.idagrupador ";

			}

			sql = sql + where_;

			sql = sql + " GROUP BY nombre_cliente ORDER BY nombre_cliente DESC";

			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

			lstResult = namedParameterJdbcTemplate.query(sql, parameterSource,
					new MedicionCumplimientoGarantiasRowMapper());

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}

	}

	@Override
	public List<MedicionCumplimientoGarantias> getMedicionCumplimientoGarantiasXCO(FiltrosReportesIndicadores filtros)
			throws Exception {

		List<MedicionCumplimientoGarantias> lstResult = null;

		String sql = "";

		if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
				|| !filtros.getMes_recoleccion().equals("12")) {

			filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

		}

		try {

			sql = "SELECT " + "frecuenciasentrega.idagrupador AS nombre_cliente, " + "ROUND((( " + "SUM( " + "CASE "
					+ "WHEN (contardiashabiles2(view_primer_recoleccion.fechaevento::date,confirma.cofecha::date)) <= (SELECT tiempo FROM SCBASECRUCESCP WHERE ori = cadocumentos.zonaori AND dest = cadocumentos.zonades ) "
					+ "THEN 1::int ELSE 0::int END "
					+ ") * 100::NUMERIC) / COUNT(cadocumentos.iddocumento)),1) AS SI_CUMPLIO, " + "ROUND((( " + "SUM( "
					+ "CASE "
					+ "WHEN (contardiashabiles2(view_primer_recoleccion.fechaevento::date,confirma.cofecha::date)) > (SELECT tiempo FROM SCBASECRUCESCP WHERE ori = cadocumentos.zonaori AND dest = cadocumentos.zonades ) "
					+ "THEN 1::int ELSE 0::int END "
					+ ") * 100::NUMERIC) / COUNT(cadocumentos.iddocumento)),1) AS NO_CUMPLIO " + "FROM "
					+ "cadocumentos " + "INNER JOIN confirma ON confirma.idguia = cadocumentos.iddocumento "
					+ "INNER JOIN view_primer_recoleccion ON (view_primer_recoleccion.idguia = cadocumentos.iddocumento) "
					+ "INNER JOIN caclientesrfc ON cadocumentos.numcliente = caclientesrfc.numcliente "
					+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = cadocumentos.iddocumento AND idtipodireccion = 'D' "
					+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo " + "WHERE "
					// + "frecuenciasentrega.idagrupador = :centro_operativo "
					+ "confirma.cofecha IS NOT NULL "
					+ "AND SUBSTRING (view_primer_recoleccion.fechaevento::text FROM 6 FOR 2) = :mes_recoleccion ";

			if (!filtros.getCentro_operativo().equals("ALL")) {

				sql = sql + " AND frecuenciasentrega.idagrupador = :centro_operativo ";

			}

			sql = sql + where_;

			sql = sql + " GROUP BY nombre_cliente ORDER BY nombre_cliente DESC";

			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

			lstResult = namedParameterJdbcTemplate.query(sql, parameterSource,
					new MedicionCumplimientoGarantiasRowMapper());

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}

	}

	@Override
	public List<MedicionGarantiasPorCliente> getTiempoEntregaPorCO(FiltrosReportesIndicadores filtros)
			throws Exception {

		List<MedicionGarantiasPorCliente> lstResult = null;

		String sql = "";

		try {

			sql = "SELECT " + "frecuenciasentrega.idagrupador AS nombre_cliente, "
					+ "ROUND(AVG(contardiashabiles2(view_primer_recoleccion.fechaevento::date,(confirma.cofecha::date))),1) AS TIEMPO_ENTREGA, "
					+ "ROUND(AVG(contardiashabiles2(view_primer_recoleccion.fechaevento::date, now()::date)),1) AS TRANSITO, "
					+ "(ROUND(AVG(contardiashabiles2(view_primer_recoleccion.fechaevento::date, now()::date)),1) - ROUND(AVG(contardiashabiles2(view_primer_recoleccion.fechaevento::date,(confirma.cofecha::date))),1)) AS DIF_CONFIRMACION "
					+ "FROM " + "cadocumentos " + "INNER JOIN confirma ON confirma.idguia = cadocumentos.iddocumento "
					+ "INNER JOIN view_primer_recoleccion ON (view_primer_recoleccion.idguia = cadocumentos.iddocumento) "
					+ "INNER JOIN caclientesrfc ON cadocumentos.numcliente = caclientesrfc.numcliente "
					+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = cadocumentos.iddocumento AND idtipodireccion = 'D' "
					+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo " + "WHERE "
					// +"frecuenciasentrega.idagrupador = 'LEN' "
					+ "confirma.cofecha IS NOT NULL ";

			if (!filtros.getCentro_operativo().equals("ALL")) {

				sql = sql + " AND frecuenciasentrega.idagrupador = :centro_operativo ";

			}

			sql = sql + where_;

			sql = sql + " GROUP BY nombre_cliente ORDER BY nombre_cliente DESC";

			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

			lstResult = namedParameterJdbcTemplate.query(sql, parameterSource,
					new MedicionGarantiasPorClienteRowMapper());

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}

	}

	@Override
	public List<MedicionCrossDock> getMedicionCrossDock(FiltrosReportesIndicadores filtros) throws Exception {

		List<MedicionCrossDock> lstResult = null;

		String sql = "";

		try {

			if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
					|| !filtros.getMes_recoleccion().equals("12")) {

				filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

			}

			sql = "SELECT " + "frecuenciasentrega.idagrupador AS CENTRO_OPERATIVO, "
					+ "ROUND(AVG(contardiashabiles2(view_primer_recoleccion.fechaevento::date,(SELECT getfechasalidacoporigen(cadocumentos.iddocumento))::date))::NUMERIC,1) AS CROSSDOCK "
					+ "FROM " + "cadocumentos " + "INNER JOIN confirma ON confirma.idguia = cadocumentos.iddocumento "
					+ "INNER JOIN view_primer_recoleccion ON (view_primer_recoleccion.idguia = cadocumentos.iddocumento) "
					+ "INNER JOIN caclientesrfc ON cadocumentos.numcliente = caclientesrfc.numcliente "
					+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = cadocumentos.iddocumento AND idtipodireccion = 'D' "
					+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo " + "WHERE "
					// +"frecuenciasentrega.idagrupador = 'LEN' "
					+ "confirma.cofecha IS NOT NULL "
					+ "AND SUBSTRING (view_primer_recoleccion.fechaevento::text FROM 6 FOR 2) = :mes_recoleccion ";

			if (!filtros.getCentro_operativo().equals("ALL")) {

				sql = sql + " AND frecuenciasentrega.idagrupador = :centro_operativo ";

			}

			sql = sql + where_;

			sql = sql + " GROUP BY CENTRO_OPERATIVO ORDER BY CENTRO_OPERATIVO DESC";

			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

			lstResult = namedParameterJdbcTemplate.query(sql, parameterSource, new MedicionCrossDockRowMapper());

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}

	}

	@Override
	public List<MedicionCrossDock> getDemoraIngresoCOFinal(FiltrosReportesIndicadores filtros) throws Exception {

		List<MedicionCrossDock> lstResult = null;

		String sql = "";

		if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
				|| !filtros.getMes_recoleccion().equals("12")) {

			filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

		}

		try {

			sql = "SELECT " + "frecuenciasentrega.idagrupador AS CENTRO_OPERATIVO, "
					+ "ROUND(AVG(contardiashabiles2((SELECT getfechasalidacoporigen(cadocumentos.iddocumento))::date,(SELECT getfechaentradacopfinal(cadocumentos.iddocumento))::date)),1) AS CROSSDOCK "
					+ "FROM " + "cadocumentos " + "INNER JOIN confirma ON confirma.idguia = cadocumentos.iddocumento "
					+ "INNER JOIN view_primer_recoleccion ON (view_primer_recoleccion.idguia = cadocumentos.iddocumento) "
					+ "INNER JOIN caclientesrfc ON cadocumentos.numcliente = caclientesrfc.numcliente "
					+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = cadocumentos.iddocumento AND idtipodireccion = 'D' "
					+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo " + "WHERE "
					+ "confirma.cofecha IS NOT NULL "
					+ "AND SUBSTRING (view_primer_recoleccion.fechaevento::text FROM 6 FOR 2) = :mes_recoleccion ";

			if (!filtros.getCentro_operativo().equals("ALL")) {

				sql = sql + " AND frecuenciasentrega.idagrupador = :centro_operativo ";

			}

			sql = sql + where_;

			sql = sql + " GROUP BY CENTRO_OPERATIVO ORDER BY CENTRO_OPERATIVO DESC";

			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

			lstResult = namedParameterJdbcTemplate.query(sql, parameterSource, new MedicionCrossDockRowMapper());

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}

	}

	@Override
	public List<DesgloceCumplimientoDias> getDesgloceCumplimientoDias(FiltrosReportesIndicadores filtros) throws Exception {

		List<MedicionDias> lstResult = null;

		List<DesgloceCumplimientoDias>  lstCumplimientoDias = new ArrayList<DesgloceCumplimientoDias>();
		
		DesgloceCumplimientoDias cumplimientoDias = new DesgloceCumplimientoDias();
		
		String sql = "", cop = "";
		
		Date date = new Date();  
		
		String fecha = "";

		if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
				|| !filtros.getMes_recoleccion().equals("12")) {

			filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

		}

		fecha = (date.getYear()+1900) + "-" + filtros.getMes_recoleccion() + "-01";
				
		try {

			for (int index = 0; index < 4; index++) {

				switch (index) {
				case 0:
					cop = "MEX";
					break;
				case 1:
					cop = "GDL";
					break;
				case 2:
					cop = "LEN";
					break;
				case 3:
					cop = "MTY";
					break;
				}
				
				sql = "SELECT "
						+ "'"+cop+"'::TEXT AS COP, "
						+ "	DIA::date, "
						+ "	COUNT(view_primer_recoleccion.idguia) AS NUMGUIAS "
						+ "FROM movimientos AS view_primer_recoleccion "
						+ "INNER JOIN generate_series('"+fecha+"', (select last_day('"+fecha+"')), '1 day'::interval) DIA ON DIA::date = view_primer_recoleccion.fechaevento::date AND view_primer_recoleccion.tiregistro = '21' "
						+ "INNER JOIN confirma ON confirma.idguia = view_primer_recoleccion.idguia "
						+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = view_primer_recoleccion.idguia AND idtipodireccion = 'D' "
						+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo "
						+ "WHERE frecuenciasentrega.idagrupador = '"+cop+"' "
						+ "AND SUBSTRING (view_primer_recoleccion.fechaevento::text FROM 6 FOR 2) = '"+filtros.getMes_recoleccion()+"' "
						+ "GROUP BY DIA "
						+ "ORDER BY DIA ASC";
			
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

				lstResult = namedParameterJdbcTemplate.query(sql, parameterSource, new MedicionDiasRowMapper());
				
				String json = "{ descripcion: '"+cop+"'";
				
				for(int j = 0; j < lstResult.size(); j++ ) {
						
					json += ", dia"+ lstResult.get(j).getDia().substring(8, 10) +":"+ lstResult.get(j).getNumGuias() +"";
						
				}
				
				json += "}";
				
				cumplimientoDias = new Gson().fromJson(json, DesgloceCumplimientoDias.class);
				
				lstCumplimientoDias.add(cumplimientoDias);
				
			}

			return lstCumplimientoDias;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}

	}

	@Override
	public List<DesgloceCumplimientoDias> getDesgloceCumplimientoDiasPrcentaje(FiltrosReportesIndicadores filtros)
			throws Exception {
		
		List<MedicionDias> lstResult = null;

		List<DesgloceCumplimientoDias>  lstCumplimientoDias = new ArrayList<DesgloceCumplimientoDias>();
		
		DesgloceCumplimientoDias cumplimientoDias = new DesgloceCumplimientoDias();
		
		String sql = "", cop = "";
		
		Date date = new Date();  
		
		String fecha = "";

		if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
				|| !filtros.getMes_recoleccion().equals("12")) {

			filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

		}

		fecha = (date.getYear()+1900) + "-" + filtros.getMes_recoleccion() + "-01";
				
		try {

			for (int index = 0; index < 4; index++) {

				switch (index) {
				case 0:
					cop = "MEX";
					break;
				case 1:
					cop = "GDL";
					break;
				case 2:
					cop = "LEN";
					break;
				case 3:
					cop = "MTY";
					break;
				}
				
				sql = "SELECT\r\n"
						+ "	'"+cop+"'::TEXT AS COP,\r\n"
						+ "	DIA::date,\r\n"
						+ "	ROUND((SELECT(((count(view_primer_recoleccion .idguia)) * 100::NUMERIC ) / (SELECT COUNT(idguia) FROM movimientos \r\n"
						+ "	INNER JOIN cadireccionesdocumento ON cadireccionesdocumento.iddocumento = movimientos.idguia AND idtipodireccion = 'D'\r\n"
						+ "	INNER JOIN frecuenciasentrega ON cadireccionesdocumento.cp = frecuenciasentrega.d_codigo\r\n"
						+ "	WHERE frecuenciasentrega.idagrupador = '"+cop+"'\r\n"
						+ "	AND tiregistro = '21' AND fechaevento BETWEEN '"+fecha+"'::date AND (select last_day('"+fecha+"'))))),2) AS PORCENTAJE\r\n"
						+ "FROM movimientos AS view_primer_recoleccion \r\n"
						+ "INNER JOIN generate_series('"+fecha+"', (select last_day('"+fecha+"')), '1 day'::interval) DIA ON DIA::date = view_primer_recoleccion.fechaevento::date AND view_primer_recoleccion.tiregistro = '21'\r\n"
						+ "INNER JOIN confirma ON confirma.idguia = view_primer_recoleccion.idguia\r\n"
						+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = view_primer_recoleccion.idguia AND idtipodireccion = 'D'\r\n"
						+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo\r\n"
						+ "WHERE frecuenciasentrega.idagrupador = '"+cop+"'\r\n"
						+ "AND SUBSTRING (view_primer_recoleccion.fechaevento::text FROM 6 FOR 2) = '"+filtros.getMes_recoleccion()+"'\r\n"
						+ "GROUP BY DIA\r\n"
						+ "ORDER BY DIA ASC";
			
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

				lstResult = namedParameterJdbcTemplate.query(sql, parameterSource, new MedicionDiasRowMapper());
				
				//String json = "{ descripcion: '"+cop+"'";
				
				StringBuilder jsonBuilder = new StringBuilder();
				
				jsonBuilder.append("{ descripcion: '"+cop+"'");
				
				for(int j = 0; j < lstResult.size(); j++ ) {
						
					//json += ", dia"+ lstResult.get(j).getDia().substring(8, 10) +":"+ lstResult.get(j).getNumGuias() +"";
					
					jsonBuilder.append(", dia"+ lstResult.get(j).getDia().substring(8, 10) +":"+ lstResult.get(j).getPorcentaje() +"");
						
				}
				
				jsonBuilder.append("}");
				
				String json = jsonBuilder.toString();
				
				cumplimientoDias = new Gson().fromJson(json, DesgloceCumplimientoDias.class);
				
				lstCumplimientoDias.add(cumplimientoDias);
				
			}

			return lstCumplimientoDias;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}
		
	}

	@Override
	public List<DesgloceCumplimientoDiasTotal> getDesgloceCumplimientoDiasTotal(FiltrosReportesIndicadores filtros)
			throws Exception {
		
		List<DesgloceCumplimientoDiasTotal> lstResult = null;

		String sql = "", cop = "";
		
		Date date = new Date();  
		
		String fecha = "";

		if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
				|| !filtros.getMes_recoleccion().equals("12")) {

			filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

		}

		fecha = (date.getYear()+1900) + "-" + filtros.getMes_recoleccion() + "-01";
				
		try {

				sql = "SELECT\r\n"
						+ "	frecuenciasentrega.idagrupador AS cop,\r\n"
						+ "	ROUND((SELECT(((count(view_primer_recoleccion .idguia)) * 100::NUMERIC ) / (SELECT COUNT(idguia) FROM movimientos \r\n"
						+ "	INNER JOIN cadireccionesdocumento ON cadireccionesdocumento.iddocumento = movimientos.idguia AND idtipodireccion = 'D'\r\n"
						+ "	INNER JOIN frecuenciasentrega ON cadireccionesdocumento.cp = frecuenciasentrega.d_codigo\r\n"
						+ "	WHERE tiregistro = '21' AND fechaevento BETWEEN '"+ fecha +"'::date AND (select last_day('"+ fecha +"'))))),2) AS PORCENTAJE\r\n"
						+ "FROM movimientos AS view_primer_recoleccion \r\n"
						+ "INNER JOIN confirma ON confirma.idguia = view_primer_recoleccion.idguia\r\n"
						+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = view_primer_recoleccion.idguia AND idtipodireccion = 'D'\r\n"
						+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo\r\n"
						+ "WHERE tiregistro = '21' AND fechaevento BETWEEN '"+ fecha +"'::date AND (select last_day('"+ fecha +"'))\r\n"
						+ "AND SUBSTRING (view_primer_recoleccion.fechaevento::text FROM 6 FOR 2) = '"+filtros.getMes_recoleccion()+"'\r\n"
						+ "GROUP BY cop";
				
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

				lstResult = namedParameterJdbcTemplate.query(sql, parameterSource, new MedicionDiasTotalRowMapper());
				

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}
		
	}

	@Override
	public List<DesgloceCumplimientoDiasTotal> getDesgloceCumplimientoDiasTotalNum(FiltrosReportesIndicadores filtros)
			throws Exception {
		
		List<DesgloceCumplimientoDiasTotal> lstResult = null;

		String sql = "", cop = "";
		
		Date date = new Date();  
		
		String fecha = "";

		if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
				|| !filtros.getMes_recoleccion().equals("12")) {

			filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

		}

		fecha = (date.getYear()+1900) + "-" + filtros.getMes_recoleccion() + "-01";
				
		try {

				sql = "SELECT\r\n"
						+ "	frecuenciasentrega.idagrupador AS cop,\r\n"
						+ "	(SELECT(count(view_primer_recoleccion .idguia))) AS PORCENTAJE\r\n"
						+ "FROM movimientos AS view_primer_recoleccion \r\n"
						+ "INNER JOIN confirma ON confirma.idguia = view_primer_recoleccion.idguia\r\n"
						+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = view_primer_recoleccion.idguia AND idtipodireccion = 'D'\r\n"
						+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo\r\n"
						+ "WHERE tiregistro = '21' AND fechaevento BETWEEN '"+ fecha +"'::date AND (select last_day('"+ fecha +"'))\r\n"
						+ "AND SUBSTRING (view_primer_recoleccion.fechaevento::text FROM 6 FOR 2) = '"+filtros.getMes_recoleccion()+"'\r\n"
						+ "GROUP BY cop";
				
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

				lstResult = namedParameterJdbcTemplate.query(sql, parameterSource, new MedicionDiasTotalRowMapper());
				

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}
		
	}

	@Override
	public List<MedicionPendientesCO> getMedicionPendientesCO(FiltrosReportesIndicadores filtros) throws Exception {
		
		List<MedicionPendientesCO> lstResult = null;

		String sql = "";
				
		try {

				sql = "SELECT \r\n"
						+ "	tabla.estatus, \r\n"
						+ "	SUM(tabla.almacen) AS almacen, \r\n"
						+ "	SUM(tabla.ruta) AS ruta, \r\n"
						+ "	SUM(tabla.ruta_foranea) AS rutaForanea, \r\n"
						+ "	SUM(tabla.confirmaoactualizar) AS confirmaActualiza, \r\n"
						+ "	SUM(tabla.investigacion) AS investigacion, \r\n"
						+ "	SUM(tabla.entrega) AS entrega, \r\n"
						+ "	SUM(tabla.sinmovimientos) AS sinMovimientos\r\n"
						+ "FROM (\r\n"
						+ "SELECT\r\n"
						+ "  CASE\r\n"
						+ "  WHEN (SELECT exclave FROM movimientos WHERE idguia = documento.idguia AND tiregistro NOT IN ('4','04','3','03') ORDER BY fechaevento DESC LIMIT 1) !=''  THEN 'EXCEPCION'::text\r\n"
						+ "  WHEN confirma.cofecha IS NOT NULL THEN 'ENTREGADO'::text\r\n"
						+ "  WHEN (SELECT tiregistro FROM movimientos WHERE idguia = documento.idguia ORDER BY fechaevento DESC LIMIT 1) = '24' THEN 'TRANSITO'::text\r\n"
						+ "  WHEN (documento.idguia::text IN ( SELECT movimientos.idguia\r\n"
						+ "	FROM movimientos\r\n"
						+ "	WHERE documento.idguia::text = movimientos.idguia::text\r\n"
						+ "	ORDER BY movimientos.fechaevento DESC\r\n"
						+ "	LIMIT 1)) THEN 'ACTIVO CON MOVIMIENTOS'::text ELSE 'ACTIVA SIN HISTORIAL'\r\n"
						+ "  END AS estatus,\r\n"
						+ "  CASE WHEN (SELECT getestatusgarantia(documento.idguia)) = 'En Almacén' THEN 1::INT ELSE 0::INT END AS ALMACEN,\r\n"
						+ "  CASE WHEN (SELECT getestatusgarantia(documento.idguia)) = 'En Ruta' THEN 1::INT ELSE 0::INT END AS RUTA,\r\n"
						+ "  CASE WHEN (SELECT getestatusgarantia(documento.idguia)) = 'En Ruta Foranea' THEN 1::INT ELSE 0::INT END AS RUTA_FORANEA,\r\n"
						+ "  CASE WHEN (SELECT getestatusgarantia(documento.idguia)) = 'Por Confirmar o Actualizar' THEN 1::INT ELSE 0::INT END AS CONFIRMAOACTUALIZAR,\r\n"
						+ "  CASE WHEN (SELECT getestatusgarantia(documento.idguia)) = 'En Investigacón' THEN 1::INT ELSE 0::INT END AS INVESTIGACION,\r\n"
						+ "  CASE WHEN (SELECT getestatusgarantia(documento.idguia)) = 'Entregada' THEN 1::INT ELSE 0::INT END AS ENTREGA,\r\n"
						+ "  CASE WHEN (SELECT getestatusgarantia(documento.idguia)) = 'Sin Movimientos' THEN 1::INT ELSE 0::INT END AS SINMOVIMIENTOS\r\n"
						+ "FROM movimientos AS documento\r\n"
						+ "LEFT JOIN confirma ON documento.idguia = confirma.idguia\r\n"
						+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = documento.idguia AND idtipodireccion = 'D'\r\n"
						+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo\r\n"
						+ "WHERE frecuenciasentrega.idagrupador = '"+filtros.getCentro_operativo()+"'\r\n"
						+ "AND documento.fechaevento::date BETWEEN('"+filtros.getFecha_inicio()+"'::date) AND ('"+filtros.getFecha_fin()+"'::date)\r\n"
						+ "GROUP BY estatus,documento.idguia,confirma.cofecha\r\n"
						+ "ORDER BY investigacion DESC, estatus ASC ) AS tabla\r\n"
						+ "GROUP BY estatus;";
				
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

				lstResult = namedParameterJdbcTemplate.query(sql, parameterSource, new MedicionPendientesCORowMapper());
				

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}
		
	}

	@Override
	public List<MedicionIntentosEntrega> getMedicionIntentosEntrega(FiltrosReportesIndicadores filtros)
			throws Exception {

		List<MedicionIntentosEntrega> lstResult = null;

		String sql = "";
		
		Date date = new Date();  
		
		String fecha = "";

		if (!filtros.getMes_recoleccion().equals("10") || !filtros.getMes_recoleccion().equals("11")
				|| !filtros.getMes_recoleccion().equals("12")) {

			filtros.setMes_recoleccion("0" + filtros.getMes_recoleccion());

		}
		
		fecha = (date.getYear()+1900) + "-" + filtros.getMes_recoleccion() + "-01";
		
		try {

				sql = "SELECT \r\n"
						+ "tabla.semana, \r\n"
						+ "((SUM(tabla.Intento_1) * 100::numeric / (SUM(tabla.Intento_1) + SUM(tabla.Intento_2) + SUM(tabla.mas_de_3))) ) AS intento_1, \r\n"
						+ "((SUM(tabla.Intento_2) * 100::numeric / (SUM(tabla.Intento_1) + SUM(tabla.Intento_2) + SUM(tabla.mas_de_3))) ) AS intento_2, \r\n"
						+ "((SUM(tabla.mas_de_3) * 100::numeric / (SUM(tabla.Intento_1) + SUM(tabla.Intento_2) + SUM(tabla.mas_de_3))) ) AS mas_de_3\r\n"
						+ "FROM (\r\n"
						+ "SELECT\r\n"
						+ "CONCAT(DIA::date,'/',( CASE WHEN (DIA::date + '6 day'::interval)::date > ('"+ fecha +"'::date + '1 month'::interval)::date THEN (select last_day('"+ fecha +"')) ELSE (DIA::date + '6 day'::interval)::date END) ) AS semana,\r\n"
						+ "(SELECT CASE WHEN (SELECT COUNT(fechaevento) FROM movimientos WHERE idguia = view_primer_recoleccion.idguia AND tiregistro IN ('4','04') AND exclave = 'D22') = 1 THEN 1::int ELSE 0::int END )AS Intento_1,\r\n"
						+ "(SELECT CASE WHEN (SELECT COUNT(fechaevento) FROM movimientos WHERE idguia = view_primer_recoleccion.idguia AND tiregistro IN ('4','04') AND exclave = 'D22') = 2 THEN 1::int ELSE 0::int END)AS Intento_2,\r\n"
						+ "(SELECT CASE WHEN (SELECT COUNT(fechaevento) FROM movimientos WHERE idguia = view_primer_recoleccion.idguia AND tiregistro IN ('4','04') AND exclave = 'D22') >= 3 THEN 1::int ELSE 0::int END )AS mas_de_3\r\n"
						+ "FROM movimientos AS view_primer_recoleccion\r\n"
						+ "INNER JOIN generate_series('"+ fecha +"', (select last_day('"+ fecha +"')), '1 week'::interval) DIA ON view_primer_recoleccion.fechaevento::date >= DIA::date \r\n"
						+ "AND view_primer_recoleccion.fechaevento::date <=  (CASE WHEN (DIA::date + '6 day'::interval)::date >= ('"+ fecha +"'::date + '1 month'::interval)::date THEN (select last_day('"+ fecha +"')) ELSE (DIA::date + '6 day'::interval)::date END)\r\n"
						+ "INNER JOIN cadireccionesdocumento AS destino ON destino.iddocumento = view_primer_recoleccion.idguia AND idtipodireccion = 'D'\r\n"
						+ "INNER JOIN frecuenciasentrega ON destino.cp = frecuenciasentrega.d_codigo\r\n"
						+ "WHERE frecuenciasentrega.idagrupador = '"+filtros.getCentro_operativo()+"'\r\n"
						+ "AND view_primer_recoleccion.tiregistro IN ('21') \r\n"
						+ "AND view_primer_recoleccion.idguia IN (SELECT DISTINCT idguia FROM movimientos WHERE tiregistro IN ('4','04') AND exclave = 'D22')\r\n"
						+ "GROUP BY semana, view_primer_recoleccion.idguia, dia\r\n"
						+ "ORDER BY semana ASC\r\n"
						+ ") AS tabla\r\n"
						+ "GROUP BY semana\r\n"
						+ "ORDER BY semana ASC;";
				
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(filtros);

				lstResult = namedParameterJdbcTemplate.query(sql, parameterSource, new MedicionIntentosEntregaRowMapper());
				

			return lstResult;

		} catch (DataAccessException dae) {

			logger.debug("Error en delete: " + dae.getMessage());

			throw new Exception(dae.getMessage());
		}

		
	}

}
