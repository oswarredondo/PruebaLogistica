/**
 * 
 */
package ar.com.unisolutions.dao.implement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.DocumentoPesoKMMaximo;
import com.google.gson.Gson;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.JsonPrint;
import com.servicio.constantes.ConstantesAdminSale;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Entrega;
import com.servicio.dtos.Movimiento;

import ar.com.unisolutions.dao.IDocumentoUnigisDAO;
import ar.com.unisolutions.rowmapper.DocumentoConsultaDTORowMapper;

@Repository
public class DocumentoUnigisDao extends JdbcDaoSupport implements IDocumentoUnigisDAO {

	private static final Logger logger = LoggerFactory.getLogger(DocumentoUnigisDao.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public DocumentoUnigisDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	String formatofecha = "dd-MM-yyyy HH:mm:ss";

	private final String QUERY_DOC =

			"SELECT iddocumentomadre, iddocumento, fechacreacion, referencia, contenido, login, numcliente, descripcion AS descripcionError, (SELECT razonsocial FROM caclientesrfc WHERE numcliente = cadocumentos.numcliente) AS razonsocial FROM cadocumentos\r\n"
					+ "LEFT JOIN caunigiserror ON cadocumentos.unigis_status = caunigiserror.estado";

	private void debug(String mensaje) {
		logger.debug(mensaje);
	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXRazonSocial(String fechaini, String fechafin, String razonSocial,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario) {

		String sql = QUERY_DOC + " WHERE idtipodocumento=:idtipodocumento AND " + " razonsocialdes LIKE :idbusqueda ";

		if (usuario.entidad.getIdentidad() != ConstantesAdminSale.CONSULTA_INTERNET) {
			sql = QUERY_DOC + " WHERE idtipodocumento=:idtipodocumento AND razonsocialdes LIKE :idbusqueda "
					+ "AND identidad=:identidad ";
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", datos.getIdDocumento());
		params.put("idtipodocumento", datos.getIdTipoDocumento());
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		params.put("idtipodocumento", tipoDocumento);
		params.put("fechaini", fechaini);
		params.put("fechafin", fechafin);
		params.put("razonSocial", razonSocial);

		List<DocumentoConsultaDTO> arr = getArrConsulta(razonSocial, true, sql, fechaini, fechafin, tipoDocumento,
				datos, usuario, params);
		// busquedaDocumentos(sql, fechaini, fechafin, tipoDocumento, datos,
		// usuario,params);

		return arr;

	}

	@Override
	public List<DocumentoConsultaDTO> busquedaTelDestino(String fechaini, String fechafin, String telfonodes,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario) {
		String sql = QUERY_DOC + " WHERE idtipodocumento=:idtipodocumento AND telefonodes LIKE :idbusqueda";

		if (usuario.entidad.getIdentidad() != ConstantesAdminSale.CONSULTA_INTERNET) {
			sql = QUERY_DOC + " WHERE idtipodocumento=:idtipodocumento AND " + " telefonodes LIKE :idbusqueda	"
					+ " AND identidad=:identidad ";
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", datos.getIdDocumento());
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		params.put("idtipodocumento", tipoDocumento);
		params.put("fechaini", fechaini);
		params.put("fechafin", fechafin);
		params.put("telfonodes", telfonodes);

		return getArrConsulta(telfonodes, true, sql, fechaini, fechafin, tipoDocumento, datos, usuario, params);
		// busquedaDocumentos(sql, fechaini, fechafin, tipoDocumento, datos,
		// usuario,params);
	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXFactura(String fechaini, String fechafin, String factura,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario) {

		String sql = QUERY_DOC + " WHERE idtipodocumento=:idtipodocumento AND factura=:idbusqueda  ";

		if (usuario.entidad.getIdentidad() != ConstantesAdminSale.CONSULTA_INTERNET) {
			sql = QUERY_DOC + " WHERE idtipodocumento=:idtipodocumento AND factura=:idbusqueda  "
					+ "AND identidad=:identidad";
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", datos.getIdDocumento());
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		params.put("idtipodocumento", tipoDocumento);
		params.put("fechaini", fechaini);
		params.put("fechafin", fechafin);
		params.put("factura", factura);

		return getArrConsulta(factura, sql, fechaini, fechafin, tipoDocumento, datos, usuario, params);
		// busquedaDocumentos(sql, fechaini, fechafin, tipoDocumento, datos,
		// usuario,params);

	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXDelivery(String fechaini, String fechafin, String delivery,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario) {

		String sql = QUERY_DOC + " WHERE delivery=:idbusqueda";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", datos.getIdDocumento());
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		params.put("idtipodocumento", tipoDocumento);
		params.put("fechaini", fechaini);
		params.put("fechafin", fechafin);
		params.put("delivery", delivery);

		return getArrConsulta(delivery, sql, fechaini, fechafin, tipoDocumento, datos, usuario, params);
		// busquedaDocumentos(sql, fechaini, fechafin, tipoDocumento, datos,
		// usuario,params);

	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXShipment(String fechaini, String fechafin, String shipment,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", datos.getIdDocumento());
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		params.put("idtipodocumento", tipoDocumento);
		params.put("fechaini", fechaini);
		params.put("fechafin", fechafin);
		params.put("shipment", shipment);

		String sql = QUERY_DOC + " WHERE shipment=:idbusqueda ";
		return getArrConsulta(shipment, sql, fechaini, fechafin, tipoDocumento, datos, usuario, params);
		// busquedaDocumentos(sql, fechaini, fechafin, tipoDocumento, datos,
		// usuario,params);

	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXReferencia(String fechaini, String fechafin, String referencia,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", datos.getIdDocumento());
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		params.put("idtipodocumento", tipoDocumento);
		params.put("fechaini", fechaini);
		params.put("fechafin", fechafin);
		params.put("referencia", referencia);

		String sql = QUERY_DOC + " WHERE  idtipodocumento=:idtipodocumento AND referencia LIKE :idbusqueda "
				+ "AND identidad=identidad";

		if (usuario.entidad.getIdentidad() == ConstantesAdminSale.CONSULTA_INTERNET) {
			sql = QUERY_DOC + " WHERE  idtipodocumento=:idtipodocumento AND " + "referencia LIKE :idbusqueda "
					+ "AND numcliente=:numcliente";
		}

		return getArrConsulta(referencia, true, sql, fechaini, fechafin, tipoDocumento, datos, usuario, params);
		// busquedaDocumentos(sql, fechaini, fechafin, tipoDocumento, datos,
		// usuario,params);
	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXContenido(String fechaini, String fechafin, String contenido,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", datos.getIdDocumento());
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		params.put("idtipodocumento", tipoDocumento);
		params.put("fechaini", fechaini);
		params.put("fechafin", fechafin);
		params.put("contenido", contenido);

		String sql = QUERY_DOC + " WHERE  idtipodocumento=:idtipodocumento AND contenido LIKE :idbusqueda ";

		if (usuario.entidad.getIdentidad() != ConstantesAdminSale.CONSULTA_INTERNET) {
			sql = QUERY_DOC + " WHERE  idtipodocumento=:idtipodocumento AND contenido LIKE :idbusqueda AND"
					+ " identidad=identidad";
		}
		return getArrConsulta(contenido, true, sql, fechaini, fechafin, tipoDocumento, datos, usuario, params);
		// busquedaDocumentos(sql, fechaini, fechafin, tipoDocumento, datos,
		// usuario,params);
	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXGuiaInternacional(String iddocumento, String tipoDocumento,
			UsuarioDTO usuario) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", iddocumento);
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		String sql = QUERY_DOC + " WHERE guiainternacional IN (:idbusqueda)";
		List<DocumentoConsultaDTO> lista = getArrConsulta(iddocumento, sql, null, null, tipoDocumento, null, usuario,
				params);
		// busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario,params);

		return lista;
	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXGuiaCasamiento(String iddocumento, String tipoDocumento,
			UsuarioDTO usuario) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", iddocumento);
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		String sql = QUERY_DOC + " WHERE idcasamiento IN (:idbuqueda)";
		List<DocumentoConsultaDTO> lista = getArrConsulta(iddocumento, sql, null, null, tipoDocumento, null, usuario,
				params);
		// busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario,params);

		return lista;
	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXGuiaConsecutivo(String iddocumento, String tipoDocumento,
			UsuarioDTO usuario) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", iddocumento);
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		String sql = QUERY_DOC + " WHERE consecutivo IN (:idbusqueda)";
		if (usuario.entidad.getIdentidad() == ConstantesAdminSale.CONSULTA_INTERNET) {
			sql = QUERY_DOC + " WHERE consecutivo IN (idbuqueda) AND numcliente=:numcliente";
		}
		List<DocumentoConsultaDTO> lista = getArrConsulta(iddocumento, sql, null, null, tipoDocumento, null, usuario,
				params);
		// busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario,params);

		return lista;
	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXGuiaMadreMultiple(String iddocumento, String tipoDocumento,
			UsuarioDTO usuario) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", iddocumento);
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		String sql = QUERY_DOC + " WHERE idguiamadremultiple =:idbusqueda";
		if (usuario.entidad.getIdentidad() == ConstantesAdminSale.CONSULTA_INTERNET) {
			sql = QUERY_DOC + " WHERE idguiamadremultiple =:idbusqueda AND numcliente=:numcliente";
		}
		List<DocumentoConsultaDTO> lista = getArrConsulta(iddocumento, sql, null, null, tipoDocumento, null, usuario,
				params);

		// busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario,params);

		return lista;
	}

	@Override
	public List<DocumentoConsultaDTO> getConsultaInfoDocumento(String iddocumento, String tipoDocumento,
			UsuarioDTO usuario, int tipoBusqueda) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento1", iddocumento);
		params.put("idbusqueda", iddocumento);

		params.put("idtipodocumento", tipoDocumento);
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());
		params.put("login", usuario.getLogin());
		logger.info("Parametros:");
		JsonPrint.show(params);

		List<DocumentoConsultaDTO> arr_documentos = new ArrayList<DocumentoConsultaDTO>();
		String sql = QUERY_DOC;

		if (tipoBusqueda == 1) {

			if (usuario.entidad.getIdentidad() == ConstantesAdminSale.CONSULTA_INTERNET) {
				sql = sql + " WHERE iddocumento IN (:idbusqueda)  AND idtipodocumento=:idtipodocumento";
			} else {
				if (iddocumento.contains("%")) {
					sql = sql + " WHERE iddocumento LIKE ':id%' AND idtipodocumento=:idtipodocumento AND "
							+ "identidad=:identidad";
				} else {
					sql = sql + " WHERE iddocumento IN (:idbusqueda) AND idtipodocumento=:idtipodocumento"
							+ " AND identidad=:identidad";
				}
			}

		} else if (tipoBusqueda == 32) {

			if (usuario.entidad.getIdentidad() == ConstantesAdminSale.CONSULTA_INTERNET) {
				sql = sql + " WHERE iddocumentomadre IN (:idbusqueda)  AND idtipodocumento=:idtipodocumento";
			} else {
				if (iddocumento.contains("%")) {
					sql = sql + " WHERE iddocumentomadre LIKE ':id%' AND idtipodocumento=:idtipodocumento AND "
							+ "identidad=:identidad";
				} else {
					sql = sql + " WHERE iddocumentomadre IN (:idbusqueda) AND idtipodocumento=:idtipodocumento"
							+ " AND identidad=:identidad";
				}
			}

		}

		logger.info("SQL:" + sql);

		arr_documentos = getArrConsulta(iddocumento, sql, null, null, tipoDocumento, null, usuario, params);
		// busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario,params);

		return arr_documentos;

	}

	@Override
	public List<DocumentoConsultaDTO> getInfoDocumentoLike(String iddocumento, String tipoDocumento,
			UsuarioDTO usuario) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", iddocumento);
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.getNumCliente());

		String sql = QUERY_DOC + " WHERE iddocumento LIKE :idbusqueda";
		List<DocumentoConsultaDTO> arr_documentos = getArrConsulta(iddocumento, true, sql, null, null, tipoDocumento,
				null, usuario, params);

		return arr_documentos;

	}

	@Override
	public List<DocumentoConsultaDTO> busquedaXFechasCreacion(String fechaini, String fechafin, String tipoDocumento,
			DocumentoDTO datos, UsuarioDTO usuario) {
		String sql = QUERY_DOC + " WHERE idtipodocumento=:idtipodocumento";

		if (usuario.entidad.getIdentidad() != ConstantesAdminSale.CONSULTA_INTERNET) {
			sql = QUERY_DOC + " WHERE idtipodocumento=:idtipodocumento  AND identidad=:identidad";
		} else {
			// Verifica si se manda el rangode fechas
			if ((fechaini != null) && (fechafin != null) && (fechaini.trim().length() > 0)
					&& (fechafin.trim().length() > 0)) {
				sql += " AND fechacreacion>='" + fechaini + "' AND fechacreacion<='" + fechafin + "'";
			}

		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iddocumento", datos.getIdDocumento());
		params.put("idtipodocumento", tipoDocumento);
		params.put("login", usuario.getLogin());
		params.put("numcliente", usuario.getNumCliente());
		params.put("fechafin", fechafin);
		params.put("fechaini", fechaini);

		return busquedaDocumentos(sql, fechaini, fechafin, tipoDocumento, datos, usuario, params);

	}

	private MapSqlParameterSource getMapSqlParameterSource(Map<String, Object> map) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValues(map);

		return params;
	}

	/***
	 * Busca los daros de una cadena separada por comas, hace una consulta con el
	 * criterio del query Si la cadena tiene 1,2,3,4,5 realiza 5 queriesy los agrega
	 * a un solo arreglo de resultado.
	 * 
	 * Se eliminan los repetidos
	 * 
	 * @param cadena_busca
	 * @param sql
	 * @param fechaini
	 * @param fechafin
	 * @param tipoDocumento
	 * @param datos
	 * @param usuario
	 * @param params
	 * @return
	 */
	private List<DocumentoConsultaDTO> getArrConsulta(String cadena_busca, String sql, String fechaini, String fechafin,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario, Map<String, Object> params) {
		return getArrConsulta(cadena_busca, false, sql, fechaini, fechafin, tipoDocumento, datos, usuario, params);

	}

	private List<DocumentoConsultaDTO> getArrConsulta(String cadena_busca, boolean withLike, String sql,
			String fechaini, String fechafin, String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario,
			Map<String, Object> params) {

		String[] arr_cadena_busca = cadena_busca.replaceAll("'", "").split(",");
		List<DocumentoConsultaDTO> tmp_arr_cadena_busca;
		List<DocumentoConsultaDTO> arr_devuelve = new ArrayList<DocumentoConsultaDTO>();
		Map<String, String> _map_ = new HashMap<String, String>();
		Map<String, String> _map_guias = new HashMap<String, String>();

		for (String mycadena : arr_cadena_busca) {
			// Verifica que no se haya ya realizado la busqueda con el mismo patron
			if (!_map_.containsKey(mycadena)) {
				params.put("idbusqueda", withLike ? "%" + mycadena + "%" : mycadena);
				tmp_arr_cadena_busca = busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario, params);
				for (DocumentoConsultaDTO documentoConsultaDTO : tmp_arr_cadena_busca) {
					// Verifica que no se haya agregado ya la guia
					if (!_map_guias.containsKey(documentoConsultaDTO.getIdDocumento())) {
						arr_devuelve.add(documentoConsultaDTO);
						_map_guias.put(documentoConsultaDTO.getIdDocumento(), documentoConsultaDTO.getIdDocumento());
					}

				}
				_map_.put(mycadena, mycadena);
			}

		}

		return arr_devuelve;
	}



	private List<DocumentoConsultaDTO> busquedaDocumentos(String sql, String fechaini, String fechafin,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario, Map<String, Object> params) {

		List<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();
		if (params == null) {

			if (datos != null) {
				params = new HashMap<String, Object>();
				params.put("idorganizacion", datos.organizacion.getIdorganizacion());
				params.put("numcliente", datos.getNumCliente());
				params.put("iddocumento", datos.getIdDocumento());
			}
			if (usuario != null) {
				params.put("identidad", usuario.entidad.getIdentidad());
			}
			params.put("idtipodocumento", tipoDocumento);
			params.put("fechaini", fechaini);
			params.put("fechafin", fechafin);

		}

		params.put("identidad", usuario.entidad.getIdentidad());
		params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
		if (datos != null) {
			params.put("iddocumento", datos.getIdDocumento());
		}

		params.put("cita", "T");

		logger.debug("Parametros");
		JsonPrint.show(params);

		if (datos != null) {
			if (datos.isSoloConCita()) {
				sql += " AND  cita=:cita";
			}
		}

		sql = sql + " AND (cadocumentos.unigis_status IS NULL OR cadocumentos.unigis_status <> 1)";
		
		// Verifica si se manda el rangode fechas
		if ((fechaini != null) && (fechafin != null) && (fechaini.trim().length() > 0)
				&& (fechafin.trim().length() > 0)) {

			sql += " AND fechacreacion>='" + fechaini + "' AND fechacreacion<='" + fechafin + "'";

			lista = this.namedParameterJdbcTemplate.query(sql, params, new DocumentoConsultaDTORowMapper());

		} else {
			lista = namedParameterJdbcTemplate.query(sql, params, new DocumentoConsultaDTORowMapper());
		}

		// Complementa los datos
		logger.debug(sql);
		
		return lista;

	}

}
