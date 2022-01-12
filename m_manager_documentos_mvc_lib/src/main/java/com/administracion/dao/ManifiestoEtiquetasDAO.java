/**
 * 
 */
package com.administracion.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.administracion.idao.IManifiestoEtiquetasDAO;
import com.administracion.rowmapper.ManifiestoDTORowMapper;
import com.administracion.rowmapper.ManifiestoDocumentoConsultaDTORowMapper;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.ManifiestoDTO;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Repository
public class ManifiestoEtiquetasDAO extends JdbcDaoSupport implements IManifiestoEtiquetasDAO {

	private static final Logger logger = LoggerFactory.getLogger(ManifiestoEtiquetasDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ManifiestoEtiquetasDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 
	 */
	public ManifiestoEtiquetasDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ManifiestoDTO> getConcentradoCargaAsignada(ManifiestoDTO manifiesto, UsuarioDTO usuario)
			throws SQLException {
		String condicion = "";
		List<ManifiestoDTO> lista = new ArrayList<ManifiestoDTO>();
		String fechaini = manifiesto.getFechaini();
		String fechafin = manifiesto.getFechafin();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		params.put("numcliente", usuario.getNumCliente());
		params.put("ruta", manifiesto.getRuta());
		params.put("preasignacion", manifiesto.getPreAsigandoPendiente());
		params.put("fechaAsignacionIni", fechaini);
		params.put("fechaAsignacionFin", fechafin);
		params.put("idtipodocumento", manifiesto.getTipoDocumento());

		
		if (CondicionNivelPerfilDAO.condicionNivelUsuario(usuario,params) != null) {
			condicion = " AND " + CondicionNivelPerfilDAO.condicionNivelUsuario(usuario,params);
		} else {
			return lista;
		}

		/** Obtiene los concentrados de carga asignana y sin asignar */
		
		String sql = "SELECT C.ruta_dis as ruta,pesofisico_pend,pesovolumetrico_pend,cantidad_pend,volumen_pend,pesofisico_asig,"
				+ "pesovolumetrico_asig,cantidad_asig,volumen_asig FROM (" + "	SELECT * FROM ("
				+ "	SELECT DISTINCT ruta as ruta_dis from cadocumentos where  idtipodocumento=:idtipodocumento  AND "
				+ "		 manifiesto IS NULL AND (preasignacion='P'  OR preasignacion='A' )" + "	) A LEFT OUTER JOIN  ("
				+ "		SELECT ruta, sum(pesofisico) AS pesofisico_asig,sum(pesovolumetrico) AS pesovolumetrico_asig,"
				+ "		sum(numpiezas) AS cantidad_asig, sum(volumen) AS volumen_asig   FROM cadocumentos  "
				+ "		WHERE  preasignacion='A'  AND  fechaasignacion>=:fechaAsignacionIni AND  fechaasignacion<=:fechaAsignacionFin"
				+ "  AND idtipodocumento=:idtipodocumento AND manifiesto IS NULL AND "
				+ "fechamanifiesto IS NULL " + condicion + "			 GROUP BY  ruta"
				+ "	) B ON A.ruta_dis= B.ruta " + ") C  LEFT OUTER JOIN  ("
				+ "	SELECT ruta, sum(pesofisico) AS pesofisico_pend,sum(pesovolumetrico) AS pesovolumetrico_pend, "
				+ "	sum(numpiezas) AS cantidad_pend , sum(volumen) AS volumen_pend  FROM cadocumentos  WHERE preasignacion='P' AND "
				+ "	idtipodocumento=:idtipodocumento AND manifiesto IS NULL AND fechamanifiesto IS NULL " + condicion + "	GROUP BY  ruta "
				+ ") D  ON C.ruta_dis= D.ruta WHERE (cantidad_asig>0 OR cantidad_pend>0)";

		lista = this.namedParameterJdbcTemplate.query(sql,params, new ManifiestoDTORowMapper());
		return lista;
	}// fin de getConcentradoCargaAsignada

	@Override
	public List<DocumentoConsultaDTO> getDetalleManifiestoEtiquetas(ManifiestoDTO manifiesto, UsuarioDTO usuario)
			throws Exception {

		if (manifiesto.isPdv()) {
			return getDetalleManifiestoEtiquetasPDV(manifiesto, usuario);

		} else {
			return getDetalleManifiestoEtiquetasAutoDoc(manifiesto, usuario);
		}

	}

	private List<DocumentoConsultaDTO> getDetalleManifiestoEtiquetasPDV(ManifiestoDTO manifiesto, UsuarioDTO usuario)
			throws Exception {

		String fechaini = UtilsStringFechas.formatoStrFecha(manifiesto.getFechaini(), "dd/MM/yyyy", "yyyy-MM-dd")
				+ " 00:00:00";
		String fechafin = UtilsStringFechas.formatoStrFecha(manifiesto.getFechafin(), "dd/MM/yyyy", "yyyy-MM-dd")
				+ " 23:59:00";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		params.put("numcliente", usuario.getNumCliente());
		params.put("ruta", manifiesto.getRuta());
		params.put("preasignacion", manifiesto.getPreAsigandoPendiente());
		params.put("fechaini", fechaini);
		params.put("fechafin", fechafin);
		params.put("idtipodocumento", manifiesto.getTipoDocumento());
		params.put("idoficina",usuario.getIdoficina());
		
		
		String sql = "select pdv_manifiesto.iddocumento,COALESCE(pdv_manifiesto.manifiesto,'') as manifiesto ,"
				+ " COALESCE(pdv_manifiesto.ruta,'') as ruta,"
				+ " viewinfodocumento.idoficina, viewinfodocumento.idservicio,"
				+ "       viewinfodocumento.idterminalori, viewinfodocumento.idterminaldes,"
				+ "	viewinfodocumento.pesofisico, viewinfodocumento.pesovolumetrico,"
				+ "      viewinfodocumento.login,viewinfodocumento.numcliente, viewinfodocumento.numpiezas,"
				+ "       viewinfodocumento.zonaori,viewinfodocumento.zonades, viewinfodocumento.manifiesto, "
				+ "	viewinfodocumento.ruta, viewinfodocumento.estadoorigen, cporigen, telefonoorigen, "
				+ "	rfcorigen, emailorigen, viewinfodocumento.coloniarec,"
				+ "        viewinfodocumento.razonsocialdes,  viewinfodocumento.atenciondes,  viewinfodocumento.direcciondes, "
				+ "        viewinfodocumento.razonsocialrec,  viewinfodocumento.atencionrec,  viewinfodocumento.direccionrec,  "
				+ "        tiporecepcion, razonsocialorigen "
				+ "        from pdv_manifiesto left outer join viewinfodocumento ON "
				+ " pdv_manifiesto.iddocumento= viewinfodocumento.iddocumento "
				+ " WHERE pdv_manifiesto.idtipodocumento =:idtipodocumento AND "
				+ "pdv_manifiesto.idoficina = :idoficina AND fechainsercion>=:fechaini AND"
				+ " fechainsercion<=:fechafin";

		if (manifiesto.isSoloSinManifestar()) {
			sql += " AND COALESCE(pdv_manifiesto.manifiesto,'') = '' ";
		}
		logger.debug("Sql:" + sql);

		return this.namedParameterJdbcTemplate.query(sql,params, new ManifiestoDocumentoConsultaDTORowMapper());
	}

	private List<DocumentoConsultaDTO> getDetalleManifiestoEtiquetasAutoDoc(ManifiestoDTO manifiesto,
			UsuarioDTO usuario) throws Exception {
		String fechaini = UtilsStringFechas.formatoStrFecha(manifiesto.getFechaini(), "dd/MM/yyyy", "yyyy-MM-dd")
				+ " 00:00:00";
		String fechafin = UtilsStringFechas.formatoStrFecha(manifiesto.getFechafin(), "dd/MM/yyyy", "yyyy-MM-dd")
				+ " 23:59:00";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		params.put("numcliente", usuario.getNumCliente());
		params.put("ruta", manifiesto.getRuta());
		params.put("preasignacion", manifiesto.getPreAsigandoPendiente());
		params.put("fechaini", fechaini);
		params.put("fechafin", fechafin);
		params.put("idtipodocumento", manifiesto.getTipoDocumento());
		params.put("idoficina",usuario.getIdoficina());
		params.put("login", manifiesto.getLogin());
		
		
		String sql = "SELECT *  FROM viewinfodocumento WHERE estatus='A'  AND "
				+ " idtipodocumento=:idtipodocumento AND fechacreacion>='"+fechaini+"' AND "
				+ "fechacreacion<='" + fechafin+"' AND iddocumento NOT IN( SELECT DISTINCT IdGuia FROM Confirma ) AND " 
				+ " numcliente=:numcliente AND "
				+ " iddocumento NOT IN( SELECT DISTINCT idguia FROM Movimientos ) AND " + " identidad=:identidad"
						+ " AND " + "idorganizacion=:idorganizacion AND idservicio!='80' ";

		if ((manifiesto.getLogin() != null) && (!manifiesto.getLogin().trim().equals("NONE"))) {
			sql += " AND Login=:login";
		}

		//String soloSinManifestar = "";
		if (manifiesto.isSoloSinManifestar()) {
			sql += " AND COALESCE(manifiesto,'') = ''";
		}
		logger.debug("Sql:" + sql);

		return this.namedParameterJdbcTemplate.query(sql, params, new ManifiestoDocumentoConsultaDTORowMapper());
	}

	@Override
	public List<DocumentoConsultaDTO> getDetalleRuta(ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception {
		String condicion = "";
		String sql = "";
		List<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		params.put("numcliente", usuario.getNumCliente());

		if (CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params) != null) {
			condicion = " AND " + CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params);
		} else {
			return lista;
		}

		String fechaini = manifiesto.getFechaini();
		String fechafin = manifiesto.getFechafin();

		params.put("ruta", manifiesto.getRuta());
		params.put("preasignacion", manifiesto.getPreAsigandoPendiente());
		params.put("fechaAsignacionIni", fechaini);
		params.put("fechaAsignacionFin", fechafin);
		params.put("idtipodocumento", manifiesto.getTipoDocumento());

		// Varifica tipo de datos solicitados
		if ("A".equals(manifiesto.getPreAsigandoPendiente())) {
			// Asignados
			sql = "SELECT * FROM ( "
					+ "	SELECT iddocumento,ruta,factura,numcliente,fechacita,horacita,numpiezas,pesofisico,pesovolumetrico, "
					+ "	fechaAsignacion,cita,tipodeembalaje,volumen,fechalimite,largo,ancho,alto,pesovolumetrico "
					+ " FROM cadocumentos WHERE ruta=:ruta AND preasignacion=:preasignacion AND  "
					+ "	fechaAsignacion>=:fechaAsignacionIni AND  fechaAsignacion<=:fechaAsignacionFin AND  "
					+ "	idtipodocumento=:idtipodocumento AND fechamanifiesto IS NULL AND manifiesto IS NULL "
					+ condicion + " ) A LEFT OUTER JOIN ( "
					+ "	SELECT iddocumento as iddocumento_dir,razonsocial,Municipio FROM cadireccionesdocumento  "
					+ "	WHERE idtipodocumento=:idtipodocumento AND idtipodireccion='D' "
					+ ") B ON A.iddocumento = B.iddocumento_dir ORDER BY ruta,municipio,numcliente,fechacita,horacita";

		} else {
			// Pendientes
			sql = "SELECT * FROM ( "
					+ "	SELECT iddocumento,ruta,factura,numcliente,fechacita,horacita,numpiezas,pesofisico,pesovolumetrico, "
					+ "	fechaAsignacion,cita,tipodeembalaje,volumen,fechalimite,largo,ancho,alto,pesovolumetrico "
					+ " FROM cadocumentos WHERE ruta=:ruta AND preasignacion=:preasignacion  AND "
					+ "  idtipodocumento=:idtipodocumento AND fechamanifiesto IS NULL AND manifiesto IS NULL "
					+ condicion + " ) A LEFT OUTER JOIN ( "
					+ "	SELECT iddocumento as iddocumento_dir,razonsocial,Municipio FROM cadireccionesdocumento  "
					+ "	WHERE idtipodocumento=:idtipodocumento AND idtipodireccion='D' "
					+ ") B ON A.iddocumento = B.iddocumento_dir ORDER BY ruta,municipio,numcliente,fechacita,horacita";
		}

		return jdbcTemplate.query(sql, new ManifiestoDocumentoConsultaDTORowMapper());

	}

	@Override
	public List<DocumentoConsultaDTO> getDetalleManifiestoentrega(ManifiestoDTO manifiesto, UsuarioDTO usuario)
			throws Exception {

		String condicion = "";
		String sql = "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		params.put("numcliente", usuario.getNumCliente());

		ArrayList<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();
		if (CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params) != null) {
			condicion = CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params);
		} else {
			return lista;
		}

		params.put("ruta", manifiesto.getRuta());
		params.put("preasignacion", manifiesto.getPreAsigandoPendiente());
		params.put("manifiesto", manifiesto.getManifiesto());
		params.put("idtipodocumento", manifiesto.getTipoDocumento());

		sql = "SELECT * FROM ( "
				+ "	SELECT iddocumento,ruta,factura,numcliente,fechacita,horacita,numpiezas,pesofisico,pesovolumetrico, "
				+ "	fechaAsignacion,cita,tipodeembalaje,volumen,transportista,fechacreacion,manifiesto,idtipodocumento, "
				+ " fechalimite,largo,ancho,alto FROM cadocumentos WHERE " + condicion + " AND ";

		// Manifiesto de distribucion una vez que se ha asignado la carga
		if ("1".equals(manifiesto.getTipomanifiesto())) {
			sql += " manifiesto='" + manifiesto.getManifiesto() + "'   AND  idtipodocumento=:idtipodocumento";

		} else {
			// Manifiestos de entregas cuando ya se esta distribuyendo en
			// destino
			sql += " iddocumento IN ( SELECT IdDocumento FROM camanifiestoentrega WHERE manifiesto=:manifiesto "
					+ CondicionNivelPerfilDAO.condicionNivelUsuarioSoloEntidayOrganizacion(usuario)
					+ ") AND  idtipodocumento=:idtipodocumento";

		}

		sql += ") A LEFT OUTER JOIN ( "
				+ "	SELECT iddocumento as iddocumento_dir,razonsocial,Municipio FROM cadireccionesdocumento  "
				+ "	WHERE idtipodireccion='D'  "
				+ ") B ON A.iddocumento = B.iddocumento_dir ORDER BY municipio,numcliente,fechacita,horacita,fechaAsignacion,transportista";

		return this.namedParameterJdbcTemplate.query(sql, params, new ManifiestoDocumentoConsultaDTORowMapper());
	}

	@Override
	public List<DocumentoConsultaDTO> getDetalleRutaManifiesto(ManifiestoDTO manifiesto, UsuarioDTO usuario)
			throws Exception {
		List<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		params.put("numcliente", usuario.getNumCliente());

		String condicion = "";
		if (CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params) != null) {
			condicion = " AND " + CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params);
		} else {
			return lista;
		}
		String soloSinManifestar = "";
		if (manifiesto.isSoloSinManifestar()) {
			soloSinManifestar = " AND manifiesto IS NULL ";
		}

		String fechaini = manifiesto.getFechaini();
		String fechafin = manifiesto.getFechafin();

		params.put("ruta", manifiesto.getRuta());
		params.put("preasignacion", manifiesto.getPreAsigandoPendiente());
		params.put("fechaAsignacionIni", fechaini);
		params.put("fechaAsignacionFin", fechafin);
		params.put("idtipodocumento", manifiesto.getTipoDocumento());

		String sql = "SELECT * FROM ( "
				+ "	SELECT iddocumento,ruta,factura,numcliente,fechacita,horacita,numpiezas,pesofisico,pesovolumetrico, "
				+ "	fechaAsignacion,cita,tipodeembalaje,volumen,transportista,fechacreacion,manifiesto, "
				+ " fechalimite,largo,ancho,alto,pos_manif,unidadreparto,soldtopartydesc,delivery,shipment FROM cadocumentos "
				+ " WHERE ruta=:ruta AND  "
				+ "	fechaAsignacion>=:fechaAsignacionIni AND  fechaAsignacion<=:fechaAsignacionFin  AND  "
				+ "	idtipodocumento=:idtipodocumento " + condicion + soloSinManifestar + " ) A LEFT OUTER JOIN ( "
				+ "	SELECT iddocumento as iddocumento_dir,razonsocial,Municipio FROM cadireccionesdocumento  "
				+ "	WHERE idtipodocumento=:idtipodocumento AND idtipodireccion='D' "
				+ ") B ON A.iddocumento = B.iddocumento_dir ORDER BY municipio,numcliente,fechacita,horacita,fechaAsignacion,transportista";

		return this.namedParameterJdbcTemplate.query(sql, params, new ManifiestoDocumentoConsultaDTORowMapper());

	}

	@Override
	public void insertManifiestoEntregaRegistros(ManifiestoDTO manifiesto, UsuarioDTO usuario, String manifiesto_cons)
			throws SQLException {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", manifiesto.getIdDocumento());
		params.put("idtipodocumento", manifiesto.getTipoDocumento());
		params.put("login", usuario.getLogin());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		params.put("manifiesto", manifiesto_cons);
		params.put("pos_manif", manifiesto.getPos_manif());
		params.put("transportistaruta", manifiesto.getUnidadreparto());

		String query = "INSERT INTO camanifiestoentrega("
				+ " iddocumento, idtipodocumento, login, identidad, idorganizacion, "
				+ " fechainsercion, manifiesto,pos_manif, transportistaruta) "
				+ " VALUES (:iddocumento, :idtipodocumento, :login, :identidad, :idorganizacion,"
				+ "currenttimestamp, :manifiesto,:pos_manif, :transportistaruta)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(manifiesto);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);

		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
		}

	}

	@Override
	public void updatePosicionUnidadRepartoRegistros(ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", manifiesto.getIdDocumento());
		params.put("idtipodocumento", manifiesto.getTipoDocumento());
		params.put("login", usuario.getLogin());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		params.put("manifiesto", manifiesto.getManifiesto());
		params.put("pos_manif", manifiesto.getPos_manif());
		params.put("transportistaruta", manifiesto.getUnidadreparto());

		String sql = "UPDATE cadocumentos SET pos_manif=:pos_manif,unidadreparto=:transportistaruta "
				+ "WHERE iddocumento=:iddocumento AND manifiesto=:manifiesto AND identidad =:identidad";

		this.namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public void updateManifiestoRegistros(java.sql.Timestamp fechamanifiesto, String manifiesto, String ruta,
			java.sql.Timestamp fechaIni, java.sql.Timestamp fechaFin, String transportista, UsuarioDTO usuario,
			String tipodocumento) throws SQLException {

		String condicion;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idtipodocumento", tipodocumento);
		params.put("login", usuario.getLogin());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		params.put("manifiesto", manifiesto);
		params.put("fechamanifiesto", fechamanifiesto);
		params.put("transportista", transportista);
		params.put("ruta", ruta);
		params.put("fechaFin", fechaFin);
		params.put("fechaIni", fechaIni);

		if (CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params) != null) {
			condicion = " AND " + CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params);
		} else {
			return;
		}
		String sql = "UPDATE cadocumentos SET manifiesto=:manifiesto, fechamanifiesto=:fechamanifiesto, "
				+ "transportista=:transportista, pos_manif=32000 WHERE ruta=:ruta AND "
				+ "	fechaAsignacion>=:fechaIni  AND fechaAsignacion<=:fechaFin AND idtipodocumento=:tipodocumento AND"
				+ " manifiesto IS NULL AND  fechamanifiesto IS NULL " + condicion;

		this.namedParameterJdbcTemplate.update(sql, params);
		// new Object[] { fechamanifiesto, fechaIni,fechaFin });
	}

	@Override
	public void updateManifiestoRegistrosEtiquetas(java.sql.Timestamp fechamanifiesto, String manifiesto, String login,
			java.sql.Timestamp fechaIni, java.sql.Timestamp fechaFin, String transportista, UsuarioDTO usuario,
			String tipodocumento) throws SQLException {

		String sql = "UPDATE cadocumentos SET manifiesto='" + manifiesto + "'," + " fechamanifiesto=?, transportista='"
				+ transportista + "', pos_manif=32000 WHERE  "
				+ "	 manifiesto IS NULL AND  fechamanifiesto IS NULL AND estatus='A'  " + " AND idtipodocumento='"
				+ tipodocumento + "' AND fechacreacion>=? AND fechacreacion<=? "
				+ " AND iddocumento NOT IN( SELECT DISTINCT IdGuia FROM Confirma ) AND numcliente='"
				+ usuario.getNumCliente() + "'  "
				+ " AND iddocumento NOT IN( SELECT DISTINCT idguia FROM Movimientos ) AND identidad="
				+ usuario.entidad.getIdentidad() + "' " + "AND idorganizacion="
				+ usuario.organizacion.getIdorganizacion();

		login = ((login.trim().length() <= 0) || (login == null)) ? null : login.trim().toUpperCase();
		if ((login != null) && (!login.trim().equals("NONE"))) {
			sql += " AND Login='" + fechamanifiesto + "' ";
		}

		this.jdbcTemplate.update(sql, new Object[] { fechamanifiesto, fechaIni, fechaFin });

	}

	@Override
	public void updateManifiestoRegistrosEtiquetas(java.sql.Timestamp fechamanifiesto, ManifiestoDTO manifiesto,
			UsuarioDTO usuario, String tipodocumento) throws SQLException {

		String sql = "UPDATE cadocumentos SET ruta='" + manifiesto.getRuta() + "', manifiesto='"
				+ manifiesto.getManifiesto() + "',fechamanifiesto=current_timestamp, " + " transportista='"
				+ manifiesto.getEnrutamientoTransportista() + "', pos_manif=32000 WHERE  "
				+ "	 manifiesto IS NULL AND  fechamanifiesto IS NULL AND estatus='A'  " + " AND idtipodocumento='"
				+ tipodocumento + "' AND iddocumento='" + manifiesto.getIdDocumento() + "'  "
				+ " AND iddocumento NOT IN( SELECT DISTINCT IdGuia FROM Confirma )  "
				+ " AND iddocumento NOT IN( SELECT DISTINCT idguia FROM Movimientos ) AND identidad="
				+ usuario.entidad.getIdentidad() + " AND idorganizacion=" + usuario.organizacion.getIdorganizacion();

		logger.debug("sql marcando registros para manifiesto:" + sql);

		int afectados = this.jdbcTemplate.update(sql);
		logger.debug("Registros afectados para el manifiesto:" + afectados);

	}

	@Override
	public void updateManifiestoRegistrosEtiquetas(Timestamp fechamanifiesto, String iddocumento, String manifiesto,
			String transportista, UsuarioDTO usuario, String tipodocumento) throws SQLException {
		// TODO Auto-generated method stub

	}

	private MapSqlParameterSource getMapSqlParameterSource(Map<String, Object> map){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValues(map);
		
		return params;
	}
}
