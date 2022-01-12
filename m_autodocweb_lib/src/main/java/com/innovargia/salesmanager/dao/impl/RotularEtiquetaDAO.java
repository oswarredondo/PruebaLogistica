package com.innovargia.salesmanager.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.administracion.dto.DetalleVenta;
import com.administracion.dto.VentaDTO;
import com.administracion.rowmapper.CuentasClienteRowMapper;
import com.administracion.rowmapper.EtiquetaRotularDTORowMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.idao.IRotulacionEtiquetasDatosDAO;
import com.innovargia.salesmanager.mappers.ConvenioDetalleRowMapper;
import com.innovargia.salesmanager.mappers.TarifaRowMapper;
import com.innovargia.utils.UUIDUniqueCreator;
import com.servicio.constantes.ConstantesGenerales;

@Repository
public class RotularEtiquetaDAO extends JdbcDaoSupport implements IRotulacionEtiquetasDatosDAO {

	final String sql_ = "SELECT identificador,idadicional AS clave,"
			+ " descripcion,estatus,precio, tipo,tipoincremento FROM caadicional";

	private static final Logger logger = LoggerFactory.getLogger(RotularEtiquetaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public RotularEtiquetaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CuentasDTO> getDatosClienteEntidad(BusquedaDTO obj) throws Exception {
		List<CuentasDTO> lista = new ArrayList<CuentasDTO>();
		String sql = "";
		// Si el tipo tipo de busqueda es de consumo
		if (obj.getTipo() == ConstantesGenerales.TIPO_BUSQUEDA_CLIENTE_ALL) {
			sql = "SELECT * FROM caclientesrfc ";
		} else if (obj.getTipo() == ConstantesGenerales.TIPO_BUSQUEDA_CLIENTE_CONSUMO) {
			sql = "SELECT DISTINCT identificador, caconvenio.numcliente,caconvenio.rfc,razonsocial FROM caclientesrfc join caconvenio 	"
					+ "ON caclientesrfc.numcliente = caconvenio.numcliente "
					+ "WHERE caconvenio.idformapago=4 order by rfc";
		} else if (obj.getTipo() == ConstantesGenerales.TIPO_BUSQUEDA_CLIENTE_DISTINTO_A_CONSUMO) {
			sql = "SELECT DISTINCT identificador, caconvenio.numcliente,caconvenio.rfc,razonsocial FROM caclientesrfc join caconvenio 	"
					+ "ON caclientesrfc.numcliente = caconvenio.numcliente "
					+ "WHERE caconvenio.idformapago!=4 order by rfc";
		}

		lista = namedParameterJdbcTemplate.query(sql, new CuentasClienteRowMapper());

		return lista;
	}

	@Override
	public int insert(EtiquetaRotulacionDTO etiqueta) throws Exception {

		String query = "INSERT INTO rotulacion_etiqueta_datos(uuid, idtipodocumento, fechacreacion, "
				+ "numcliente,identidad,idorganizacion, login,json_data,idtarifa,idconvenio,"
				+ "tiporotucacion,idconveniodetalle,kms_origen_destino,cp_rem,cp_des,tiene_retorno) "
				+ "VALUES(:uuid,:idtipodocumento,current_timestamp, :numcliente,"
				+ ":identidad,:idorganizacion, :login,:json_data,:idtarifa,:idconvenio,"
				+ ":tiporotucacion,:idconveniodetalle,:kms_origen_destino,:cp_rem,:cp_des" + ",:tiene_retorno)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder,
					new String[] { "idregistrodatos" });
			Number id = keyHolder.getKey();
			return id.intValue();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}

	}

	@Override
	public int insertRegistroImportado(EtiquetaRotulacionDTO etiqueta) throws Exception {
		int tipo = 0;
		String query = "INSERT INTO rotulacion_etiqueta_datos(uuid, idtipodocumento, fechacreacion, "
				+ "numcliente,identidad,idorganizacion, login) "
				+ "VALUES(:uuid,:idtipodocumento,current_timestamp, :numcliente,:identidad,:idorganizacion, :login)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder,
					new String[] { "idregistrodatos" });
			Number id = keyHolder.getKey();
			return id.intValue();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}

	}

	@Override
	public int insertRotulacionSet(EtiquetaRotulacionDTO etiqueta) throws Exception {
		int tipo = 0;
		String query = "INSERT INTO rotulacion_etiqueta_sets( " + " login, uuid, fecharegistro, descripcion)"
				+ " VALUES (:login, :uuid, current_timestamp, :descripcion)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder, new String[] { "idregistro" });
			Number id = keyHolder.getKey();
			return id.intValue();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}

	}

	@Override
	public int insertRotulacionEtiquetasGeneradas(EtiquetaRotulacionDTO etiqueta) throws Exception {
		int tipo = 0;
		String query = "INSERT INTO rotulacion_etiqueta_generadas_json("
				+ " fechacreacion, login, json_data,remite,destinatario,cantidad,uuid,nacional)"
				+ " VALUES (current_timestamp , :login, :json_data,:remite,:destino,:cantidad,:uuid,:nacional)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder, new String[] { "idregistro" });
			Number id = keyHolder.getKey();
			return id.intValue();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}

	}

	@Override
	public int insertLineaVolumenCOD(EtiquetaRotulacionDTO etiqueta) throws Exception {
		String query = "INSERT INTO rotulacion_etiqueta_volumen("
				+ "idregistrodatos , uuid, largo, ancho, alto, pesofisico, pesovolumetrico, "
				+ " valor_asegurado, factura_producto_asegurado, valor_a_cobrar_cod, "
				+ " factura_producto_cod,contenido,observacion,referencia,valordeclarado,fechacreacion,tipoempaque)"
				+ " VALUES (:idregistrodatos , :uuid, :largo, :ancho, :alto, :pesofisico, :pesovolumetrico, "
				+ " :valor_asegurado, :factura_producto_asegurado, :valor_a_cobrar_cod, "
				+ " :factura_producto_cod,:contenido,:observacion,:referencia,:valordeclarado, current_timestamp,:tipoempaque)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder,
					new String[] { "idregistrodatos" });
			Number id = keyHolder.getKey();
			return id.intValue();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}
	}

	@Override
	public int insertLineaAdicional(EtiquetaRotulacionDTO etiqueta) throws Exception {
		String query = "INSERT INTO rotulacion_etiqueta_adicionales("
				+ "    iddregistrodatos, idregistroadicional, uuid, idadicional, "
				+ "  valor_a_cobrar, decripcion,fechacreacion) "
				+ " VALUES (:iddregistrodatos, :idregistroadicional, :uuid, :idadicional, "
				+ "  :valor_a_cobrar, :decripcion, current_timestamp)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder,
					new String[] { "idregistrodatos" });
			Number id = keyHolder.getKey();
			return id.intValue();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}
	}

	@Override
	public void update(EtiquetaRotulacionDTO etiqueta) throws Exception {

		String query = "UPDATE rotulacion_etiqueta_datos"
				+ "   SET   idoficina=:idoficina, idservicio=:idservicio, idtipocobro=:idtipocobro, "
				+ "       idformapago=:idformapago, idadicional=:idadicional, idterminalori=:idterminalori, "
				+ " idterminaldes=:idterminaldes,   factura=:factura, "
				+ "       pedimento=:pedimento, aduana=:aduana, "
				+ " tipodeembalaje=:tipodeembalaje, enrutamiento=:enrutamiento, preciozona=:preciozona, iva=:iva, "
				+ "   numpiezas=:numpiezas,  zonaori=:zonaori, zonades=:zonades, transportista=:transportista, "
				+ "       razonsocial_rem=:razonsocial_rem, contacto_rem=:contacto_rem, calle_rem=:calle_rem, colonia_rem=:colonia_rem, "
				+ "       municipio_rem=:municipio_rem, estado_rem=:estado_rem, ciudad_rem=:ciudad_rem, cp_rem=:cp_rem, telefono_rem=:telefono_rem, "
				+ "       celular_rem=:celular_rem, rfc_rem=:rfc_rem, email_rem=:email_rem, razonsocial_des=:razonsocial_des, contacto_des=:contacto_des, "
				+ "       calle_des=:calle_des, colonia_des=:colonia_des, municipio_des=:municipio_des, estado_des=:estado_des, ciudad_des=:ciudad_des, "
				+ "       cp_des=:cp_des, telefono_des=:telefono_des, celular_des=:celular_des, rfc_des=:rfc_des, email_des=:email_des, "
				+ "       tiene_seguro=:tiene_seguro, es_cod=:es_cod, pais_rem =:pais_rem, pais_des=:pais_des,tiene_cita=:tiene_cita, ";

		if (etiqueta.getTiene_cita().equals("SI")) {

			query += "fecha_cita=:fecha_cita::timestamp,hora_cita=:hora_cita, ";
		}

		query += "       "
				+ "    es_ocurre=:es_ocurre,es_multiple=:es_multiple,numinterior_des=:numinterior_des, numexterior_des=:numexterior_des, "
				+ " numinterior_rem=:numinterior_rem, numexterior_rem=:numexterior_rem,"
				+ "   tiporotulo=:tiporotulo, nacional=:nacional" + " WHERE idregistrodatos= :idregistrodatos";

		// referencia=:referencia,valordeclarado=:valordeclarado,
		// valor_asegurado=:valor_asegurado, factura_producto=:factura_producto,
		// ,
		// valor_a_cobrar=:valor_a_cobrar,
		// factura_producto_cod=:factura_producto_cod,
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	@Override
	public void updateVolumen(EtiquetaRotulacionDTO etiqueta) throws Exception {

		String query = "UPDATE rotulacion_etiqueta_volumen" + "  SET  largo=:largo, ancho=:ancho, alto=:alto, "
				+ "  pesofisico=:pesofisico, pesovolumetrico=getpesovolumetrico(:alto,:ancho,:largo),"
				+ " tipoempaque=:tipoempaque, contenido=:contenido, observacion=:observacion,"
				+ " factura_producto_asegurado=:factura_producto_asegurado,referencia=:referencia,"
				+ " valordeclarado=:valordeclarado, valor_asegurado=:valor_asegurado "
				+ " WHERE idregistro=:idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	@Override
	public void updateRotulacionSet(EtiquetaRotulacionDTO etiqueta) throws Exception {

		String query = "UPDATE rotulacion_etiqueta_sets "
				+ "  SET descripcion=:descripcion  WHERE idregistro=:idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	@Override
	public void updateRotulacionIdRegistroSet(EtiquetaRotulacionDTO etiqueta) throws Exception {

		String query = "UPDATE rotulacion_etiqueta_datos " + "  SET idregistro_set=:idregistro_set  WHERE uuid=:uuid";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	@Override
	public void updateSeguro(EtiquetaRotulacionDTO etiqueta) throws Exception {

		String query = "UPDATE rotulacion_etiqueta_volumen"
				+ "  SET valor_a_cobrar_cod=:valor_a_cobrar_cod, factura_producto_cod=factura_producto_cod WHERE idregistro=:idregistrodatos";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	@Override
	public void updateCOD(EtiquetaRotulacionDTO etiqueta) throws Exception {

		String query = "UPDATE  rotulacion_etiqueta_volumen "
				+ "SET valor_a_cobrar_cod=:valor_a_cobrar_cod, factura_producto_cod=factura_producto_cod WHERE idregistro=:idregistrodatos";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	@Override
	public void updateRegistroDatos(EtiquetaRotulacionDTO etiqueta) throws Exception {
		String query = "UPDATE rotulacion_etiqueta_datos" + "   SET  idregistro_set=:idregistro_set"
				+ " WHERE idregistrodatos=:idregistrodatos ";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.debug("Error en updateEstatus: " + dae.getMessage());
		}

	}

	@Override
	public void delete(EtiquetaRotulacionDTO etiqueta) throws Exception {
		String query = "DELETE FROM rotulacion_etiqueta_datos  " + " WHERE idregistrodatos=:idregistrodatos ";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.debug("Error en delete: " + dae.getMessage());
		}

	}

	@Override
	public void deleteRegistrosUUID(EtiquetaRotulacionDTO etiqueta) throws Exception {
		String query = "DELETE FROM rotulacion_etiqueta_datos  " + " WHERE uuid=:uuid ";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.debug("Error en delete: " + dae.getMessage());
		}

	}

	@Override
	public void deleteJSonEtiquetasGeneradas() throws Exception {
		String query = "DELETE FROM rotulacion_etiqueta_generadas_json "
				+ " WHERE fechacreacion< (current_timestamp - interval '120 hour')";

		try {
			this.jdbcTemplate.update(query);
		} catch (Exception dae) {
			logger.debug("Error en delete: " + dae.getMessage());
		}

	}

	@Override
	public void depuraUUID(EtiquetaRotulacionDTO etiqueta) throws Exception {
		String query2 = "DELETE FROM rotulacion_etiqueta_datos WHERE uuid=:uuid AND "
				+ "uuid NOT IN (SELECT uuid FROM rotulacion_etiqueta_sets ) ";

		String query3 = "DELETE FROM rotulacion_etiqueta_volumen WHERE uuid=:uuid AND "
				+ "uuid NOT IN (SELECT uuid FROM rotulacion_etiqueta_sets )";

		String query4 = "DELETE FROM rotulacion_etiqueta_adicionales WHERE uuid=:uuid AND "
				+ "uuid NOT IN (SELECT uuid FROM rotulacion_etiqueta_sets )";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);
		try {

			this.namedParameterJdbcTemplate.update(query2, parameterSource);
			this.namedParameterJdbcTemplate.update(query3, parameterSource);
			this.namedParameterJdbcTemplate.update(query4, parameterSource);

		} catch (Exception dae) {
			logger.debug("Error en deleteLinea: " + dae.getMessage());
		}

	}

	@Override
	public void depuraRotulacionesTemporales() throws Exception {
		String query_datos = "	delete from rotulacion_etiqueta_datos where "
				+ " fechacreacion <=(current_timestamp - interval '24 hour') and  "
				+ "uuid NOT IN (SELECT uuid FROM rotulacion_etiqueta_sets )";

		String query_volumen = "	delete from rotulacion_etiqueta_volumen where "
				+ " fechacreacion <=(current_timestamp - interval '24 hour') and  "
				+ "uuid NOT IN (SELECT uuid FROM rotulacion_etiqueta_sets )";

		String query_adicionales = "	delete from rotulacion_etiqueta_adicionales where "
				+ " fechacreacion <=(current_timestamp - interval '24 hour') and  "
				+ "uuid NOT IN (SELECT uuid FROM rotulacion_etiqueta_sets )";

		String query_set = "delete from rotulacion_etiqueta_sets where uuid "
				+ " NOT IN (SELECT distinct uuid FROM rotulacion_etiqueta_datos  ) ";

		try {
			this.jdbcTemplate.update(query_adicionales);

			this.jdbcTemplate.update(query_volumen);
			this.jdbcTemplate.update(query_datos);

			this.jdbcTemplate.update(query_set);
		} catch (Exception dae) {
			logger.debug("Error en deleteLinea: " + dae.getMessage());
		}

	}

	@Override
	public void deleteRotulacionSet(EtiquetaRotulacionDTO etiqueta) throws Exception {
		String query1 = "DELETE FROM rotulacion_etiqueta_sets  WHERE uuid=:uuid ";
		String query2 = "DELETE FROM rotulacion_etiqueta_datos WHERE uuid=:uuid ";

		String query3 = "DELETE FROM rotulacion_etiqueta_volumen WHERE uuid=:uuid";

		String query4 = "DELETE FROM rotulacion_etiqueta_adicionales WHERE uuid=:uuid";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);
		try {

			this.namedParameterJdbcTemplate.update(query1, parameterSource);
			this.namedParameterJdbcTemplate.update(query2, parameterSource);
			this.namedParameterJdbcTemplate.update(query3, parameterSource);
			this.namedParameterJdbcTemplate.update(query4, parameterSource);

		} catch (Exception dae) {
			logger.debug("Error en deleteLinea: " + dae.getMessage());
		}

	}

	@Override
	public void deleteLinea(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// Borra la Linea
		String query = "DELETE FROM rotulacion_etiqueta_datos  " + " WHERE idregistrodatos=:idregistrodatos ";

		String query1 = "DELETE FROM rotulacion_etiqueta_volumen  "
				+ " WHERE idregistrodatos=:idregistrodatos and uuid=:uuid";

		String query2 = "DELETE FROM rotulacion_etiqueta_adicionales  "
				+ " WHERE iddregistrodatos=:idregistrodatos and uuid=:uuid";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query2, parameterSource);
			this.namedParameterJdbcTemplate.update(query1, parameterSource);
			this.namedParameterJdbcTemplate.update(query, parameterSource);

		} catch (Exception dae) {
			logger.debug("Error en deleteLinea: " + dae.getMessage());
		}

	}

	@Override
	public void deleteLineaVolumenSeguroCOD(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// Borra la Linea
		String query1 = "DELETE FROM rotulacion_etiqueta_volumen  " + " WHERE idregistro=:idregistro ";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query1, parameterSource);
		} catch (Exception dae) {
			logger.debug("Error en deleteLineaVolumenSeguroCOD: " + dae.getMessage());
		}

	}

	@Override
	public void deleteLineaAdicional(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// Borra la Linea
		String query2 = "DELETE FROM rotulacion_etiqueta_adicionales  " + " WHERE idregistro=:idregistro ";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query2, parameterSource);

		} catch (Exception dae) {
			logger.debug("Error en deleteLineaAdicional: " + dae.getMessage());
		}

	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatos(EtiquetaRotulacionDTO etiqueta) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();

		String sql = "SELECT distinct datostarifa.*, tarifa_servicio || '[Peso:' || COALESCE(peso,0) || ',Cob. Km:' ||"
				+ " COALESCE(coberturakm,0) || ',Precio:$'||COALESCE(precio,0) || ']' as  descripcion_servicio FROM ("
				+ "		SELECT datos.*,catarifas.nombre || '-' || nombreservicio as tarifa_servicio  FROM ("
				+ "			SELECT rotula.*, catiposervicio.nombre as nombreservicio FROM ( "
				+ "				select row_number() OVER () as linea, rotulacion_etiqueta_datos.*,  cantidad_total,"
				+ " 			pesofisico_total,pesovolumetrico_total, "
				+ "				extraeadicionalrotulacion(rotulacion_etiqueta_datos.uuid, "
				+ "				rotulacion_etiqueta_datos.idregistrodatos) as adicionales"
				+ "		 		from rotulacion_etiqueta_datos  left outer join viewrotulacion_etiquetas_totales ON  "
				+ "		 		rotulacion_etiqueta_datos.uuid = viewrotulacion_etiquetas_totales.uuid AND "
				+ "	 			rotulacion_etiqueta_datos.idregistrodatos =viewrotulacion_etiquetas_totales.idregistrodatos  "
				+ " 		) rotula LEFT OUTER JOIN catiposervicio	ON rotula.idservicio = catiposervicio.idservicio"
				+ "		)datos left outer join catarifas ON datos.idtarifa = catarifas.idtarifa" + ") datostarifa "
				+ "	LEFT OUTER JOIN caconveniodetalle ON  "
				+ "	datostarifa.idconveniodetalle = caconveniodetalle.idconveniodetalle "
				+ "	where datostarifa.uuid  =:uuid ";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<ConvenioContratoDetalleDTO> getDetalleConvenioRotulacion(int idconveniodetalle) throws Exception {
		List<ConvenioContratoDetalleDTO> lista = new ArrayList<ConvenioContratoDetalleDTO>();
		String sql = "select * from caconveniodetalle  where idconveniodetalle=?";
		lista = jdbcTemplate.query(sql, new Object[] { idconveniodetalle }, new ConvenioDetalleRowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosSets(EtiquetaRotulacionDTO etiqueta) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_sets WHERE uuid=:uuid";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosSetsUsuario(EtiquetaRotulacionDTO etiqueta) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_sets WHERE login=:login AND uuid IN (SELECT distinct uuid FROM rotulacion_etiqueta_datos  )";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosVolumen(EtiquetaRotulacionDTO etiqueta) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_volumen WHERE uuid=:uuid AND idregistrodatos=:idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosSeguro(EtiquetaRotulacionDTO etiqueta) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_volumen WHERE uuid=:uuid AND idregistrodatos=:idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosCOD(EtiquetaRotulacionDTO etiqueta) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_volumen WHERE uuid=:uuid AND idregistrodatos=:idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosContenidoObserva(EtiquetaRotulacionDTO etiqueta)
			throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_volumen WHERE uuid=:uuid AND idregistrodatos=:idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosEtiquetas(EtiquetaRotulacionDTO etiqueta) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		// String sql = "SELECT ROW_NUMBER() over (order by siglasdestino) as
		// linea_consecutivo,*, get_str_transbordos(siglasorigen,siglasdestino)
		// as enrutamientos,"
		// + "getidoficinacontrolconvenio(idconvenio) as oficinacontrol "
		// + " FROM viewrotulacion_etiquetas WHERE
		// idregistrodatos=:idregistrodatos";

		String sql = "SELECT ROW_NUMBER() over (order by siglasdestino) as linea_consecutivo,viewrotulacion_etiquetas.*, "
				+ "get_str_transbordos(siglasorigen,siglasdestino) as enrutamientos,getidoficinacontrolconvenio(idconvenio) as oficinacontrol ,"
				+ "frecuencia.ruta,getdescripcionservicio(idservicio) as descripcion_servicio ,"
				+ "getdescripciongarantia(substring(idservicio,1,1)) as descripciongarantia   "
				+ "FROM viewrotulacion_etiquetas left outer join "
				+ " (SELECT distinct d_codigo, ruta from frecuenciasentrega) frecuencia  ON "
				+ "viewrotulacion_etiquetas.cp_des = frecuencia.d_codigo WHERE idregistrodatos=:idregistrodatos";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosEtiquetasJsonGeneradas(UsuarioDTO usuario, String uuid)
			throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_generadas_json WHERE login=:login "
				+ " and fechacreacion>=(current_timestamp - interval '1 hour')  AND uuid='" + uuid
				+ "' order by fechacreacion desc";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getReimpresionRegistrosDatosEtiquetasJsonGeneradas(UsuarioDTO usuario,
			String fechaini, String fechafin) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_generadas_json WHERE login=:login "
				+ " and fechacreacion>=:fechaini::TIMESTAMP AND fechacreacion<=:fechafin::TIMESTAMP order by fechacreacion desc";

		// SqlParameterSource parameterSource = new
		// BeanPropertySqlParameterSource(
		// usuario);

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("fechaini", fechaini);
		params.addValue("fechafin", fechafin);
		params.addValue("login", usuario.getLogin());

		lista = this.namedParameterJdbcTemplate.query(sql, params, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosAdicionales(EtiquetaRotulacionDTO etiqueta) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_volumen WHERE uuid=:uuid AND idregistrodatos=:idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getReimpresionRegistrosDatosEtiquetasJsonGeneradas(String[] idregistro)
			throws Exception {

		StringBuffer sb = new StringBuffer();

		String sql = "SELECT * FROM rotulacion_etiqueta_generadas_json WHERE idregistro IN(:listOfValues) order by fechacreacion desc";

		List<Integer> nameRecordIDs = new ArrayList<Integer>();

		for (int i = 0; i < idregistro.length; i++) {

			nameRecordIDs.add(Integer.parseInt(idregistro[i]));

		}

		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();

		Map namedParameters = Collections.singletonMap("listOfValues", nameRecordIDs);

		lista = this.namedParameterJdbcTemplate.query(sql, namedParameters, new EtiquetaRotularDTORowMapper());

		return lista;
	}

	@Override
	public List<EtiquetaRotulacionDTO> getReimpresionRegistrosDatosEtiquetasJsonGeneradas(String uuid)
			throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
		String sql = "SELECT * FROM rotulacion_etiqueta_generadas_json WHERE uuid= ? order by fechacreacion desc";

		lista = this.jdbcTemplate.query(sql, new Object[] { uuid }, new EtiquetaRotularDTORowMapper());
		return lista;
	}

	@Override
	public int insertDetalle(DetalleVenta detalleventa) throws Exception {

		String query = "INSERT INTO pdv_venta_detalle(" + " idventa, idproducto," + " cantidad, precio_unitario, "
				+ "descuento, descripcion, idtarifa, " + "idrangotarifa, idpesotarifa,"
				+ " idzonatarifa, origen, destino, pesokg,"
				+ " pesovol, km, idadicional,iddocumento,idguiainternacional,"
				+ " tipocambio, tipoventa,idservicio,idconveniodetalle,idconvenio,valordeclarado,precio_seguro) "
				+ " VALUES (:idventa, :idproducto," + " :cantidad, :precio_unitario, "
				+ " :descuento, :descripcion, :idtarifa, " + " :idrangotarifa, :idpesotarifa,"
				+ " :idzonatarifa, :origen, :destino, :pesokg,"
				+ " :pesovol, :km, :idadicional, :iddocumento, :idguiainternacional,"
				+ ":tipocambio,:tipoventa,:idservicio,:idconveniodetalle,:idconvenio,:valor_declarado,:precio_seguro)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(detalleventa);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder,
					new String[] { "iddetalleventa" });
			Number id = keyHolder.getKey();
			return id.intValue();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}

	}

	@Override
	public int insertVentaAutoDoc(VentaDTO venta) throws Exception {

		String query = "INSERT INTO pdv_venta(" + " fecha, subtotal, iva, descuento,"
				+ " total, login, estatus, solicita_factura, " + "idformapago, banco_tarjeta, numero_tarjeta, "
				+ "fecha_venc_tarjeta, idoficina, observacion,idclientefactura,"
				+ "fechainsercion, nacional, tipoventa, idtipoventa,idfoliooficina)"
				+ " VALUES ( current_timestamp,:subtotal,:iva,:descuento,"
				+ ":total, :login, :estatus, :solicita_factura," + ":idformapago, :banco_tarjeta, :numero_tarjeta, "
				+ " :fecha_venc_tarjeta, :idoficina, " + ":observacion,:idclientefactura,current_timestamp,"
				+ " :nacional, :tipoventa,:idtipoventa,idfoliooficina)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(venta);

		try {
			// this.namedParameterJdbcTemplate.update(query, parameterSource);
			// return venta.getIdventa();

			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder, new String[] { "idventa" });
			Number id = keyHolder.getKey();
			return id.intValue();

		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}

	}

	@Override
	public void updateIdVentaJsonGeneradas(int idregistro, int idventa) throws Exception {

		String query = "update rotulacion_etiqueta_generadas_json set nacional='NACIONAL', idventa=? where idregistro=?";

		try {
			this.jdbcTemplate.update(query, new Object[] { idventa, idregistro });
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
		}

	}

	@Override
	public void insertVentaAutoDocDetalleRecepcionManifiesto(VentaDTO venta, UsuarioDTO usuario, String manifiesto)
			throws Exception {

		String query = " INSERT INTO pdv_recepcion_envios_detalle( "
				+ " uuid, iddocumento, idtarifa, rfc_rem, razonsocial_rem, contacto_rem,  "
				+ " numexterior_rem, numinterior_rem, calle_rem, colonia_rem, municipio_rem,  "
				+ " estado_rem, ciudad_rem, cp_rem, telefono_rem, celular_rem, email_rem,  "
				+ " pais_rem, rfc_des, razonsocial_des, contacto_des, calle_des,  "
				+ " 	numexterior_des, numinterior_des, colonia_des, municipio_des,  "
				+ " 	estado_des, ciudad_des, cp_des, telefono_des, celular_des, email_des,  "
				+ " 	pais_des, tiporotulo, idservicio, cobro_sobrepeso, cobro_reexpedicion,  "
				+ " 	tipo, alto, ancho, largo, peso, peso_vol, siglasplaza, idoficina,  "
				+ " 	login, manifiesto, fechacreacion, siglasorigen, siglasdestino,  "
				+ " 	enrutamiento, precio_unitario, idventa)  " + " 	 "
				+ " 		SELECT :uuid as uuid , detalleventa.iddocumento, idtarifa,rfcorigen as rfc_rem , razonsocialorigen as razonsocial_rem, atencionorigen as contacto_rem,  "
				+ " 	             '' as numexterior_rem,'' as numinterior_rem, direccionorigen as calle_rem, coloniaorigen as colonia_rem,municipioorigen as municipio_rem,  "
				+ " 	             estadoorigen as estado_rem, ciudadorigen as ciudad_rem, cporigen as cp_rem, telefonoorigen as telefono_rem, '' as celular_rem, emailorigen as email_rem,  "
				+ " 	                'MEXICO' as pais_rem, rfcdes as rfc_des, razonsocialdes as razonsocial_des, atenciondes as contacto_des, direcciondes as calle_des,  "
				+ " 	                '' as numexterior_des, '' as numinterior_des, coloniades as colonia_des, municipiodes as municipio_des,  "
				+ " 	                estadodes as estado_des, ciudaddes as ciudad_des, cpdes as cp_des, telefonodes as telefono_des, '' as celular_des, emaildes as email_des,  "
				+ " 	                'MEXICO' as pais_des, 'AMBAS', viewinfodocumento.idservicio, 0 as cobro_sobrepeso, 0 as cobro_reexpedicion, :tipo_rotula, "
				+ ",alto, ancho, largo, pesofisico,pesovolumetrico, :plaza,:oficina ,   :login_autodoc, :manifiesto, current_timestamp, zonaori as siglasorigen, "
				+ "zonades as siglasdestino, get_str_transbordos(zonaori,zonades) as enrutamiento, precio_unitario,  detalleventa.idventa   "
				+ " 		 FROM ( "
				+ " 			SELECT * FROM pdv_venta_detalle where idventa =:idventa and iddocumento is not null "
				+ " 		) detalleventa LEFT OUTER JOIN viewinfodocumento ON detalleventa.iddocumento = viewinfodocumento.iddocumento ";

		try {
			// SqlParameterSource parameterSource = new
			// BeanPropertySqlParameterSource(venta);
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("uuid", venta.getUuid());
			params.addValue("tipo_rotula", ConstantesGenerales.TIPO_ROTULACION_AUTODOC);
			params.addValue("plaza", usuario.getSiglasPlaza());
			params.addValue("oficina", usuario.getIdoficina());
			params.addValue("login_autodoc", usuario.getLogin_autodoc());
			params.addValue("manifiesto", manifiesto);

			this.namedParameterJdbcTemplate.update(query, params);

		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}
	}

	@Override
	public int insertRotulacionEtiquetasRecepcion(EtiquetaRotulacionDTO etiqueta, String nacional, String manifiesto)
			throws Exception {
		if (nacional == null) {
			nacional = "NACIONAL";
		}

		String query = "INSERT INTO pdv_recepcion_envios_json(" + "  fechacreacion, login, json_data, "
				+ " siglasplaza, idoficina,cantidad, uuid, " + " tipo, idventa, nacional,manifiesto)"
				+ " VALUES (current_timestamp , :login, :json_data,"
				+ " :siglasorigen, :idoficina, :cantidad,:uuid,:tiporotucacion,:idventa" + ",'" + nacional + "','"
				+ manifiesto + "' )";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder, new String[] { "idregistro" });
			Number id = keyHolder.getKey();
			query = "UPDATE pdv_recepcion_envios_json SET nacional=? , manifiesto=? WHERE idregistro= ?";
			this.jdbcTemplate.update(query, new Object[] { nacional, manifiesto, id.intValue() });

			return id.intValue();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		} catch (Exception e) {
			logger.error("error insert:" + e.getMessage());
		}

		return 0;
	}

	@Override
	public EtiquetaRotulacionDTO getRegistrosTarifaserviciozona(int idconvenio, int identidad, int idorganizacion,
			String numCliente, String login, float kms) throws Exception {

		EtiquetaRotulacionDTO etiquetaTXZ = new EtiquetaRotulacionDTO();

		String sql = "SELECT CD.idconvenio || '-' || CD.idtarifa || '-' || CD.idconveniodetalle || '-' || (Select idservicio FROM catarifas WHERE idtarifa = CD.idtarifa) as idservicio FROM caconveniodetalle AS CD WHERE CD.idconvenio=:convenio1 AND idserviciotarifazona = "
				+ "(SELECT idserviciotarifazona FROM catarifaserviciozona WHERE idserviciotarifazona IN "
				+ "(SELECT idserviciotarifazona FROM caconvenio AS c INNER JOIN caconveniodetalle AS cd ON c.idconvenio = cd.idconvenio  WHERE c.idconvenio =:convenio2 AND current_date>=c.fechainicio   and current_date<=c.fechatermino  AND c.estatus "
				+ "IN (40) AND c.idconvenio IN ( "
				+ "SELECT opusuarios_convenios.idconvenio from opusuarios_convenios WHERE identidad=:identidad AND idorganizacion=:idorganizacion AND numcliente=:numcliente AND login=:login "
				+ ")) AND :kmi >= kminicial AND :kmf <= kmfinal)";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("convenio1", idconvenio);
		params.addValue("convenio2", idconvenio);
		params.addValue("identidad", identidad);
		params.addValue("idorganizacion", idorganizacion);
		params.addValue("numcliente", numCliente);
		params.addValue("login", login);
		params.addValue("kmi", kms);
		params.addValue("kmf", kms);

		logger.debug("SQL:" + sql);

		etiquetaTXZ = this.namedParameterJdbcTemplate.queryForObject(sql, params, new EtiquetaRotularDTORowMapper());

		return etiquetaTXZ;

	}

	@Override
	public void UpdateDocumentoUnigis(String iddocumento, int unigis_status) {

		String query = "UPDATE cadocumentos SET unigis_status = :unigis_status WHERE iddocumento = :iddocumento";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("unigis_status", unigis_status);
		parameterSource.addValue("iddocumento", iddocumento);

		try {

			this.namedParameterJdbcTemplate.update(query, parameterSource);

		} catch (Exception dae) {

			logger.error("Error en update: " + dae.getMessage());

		}

	}

	@Override
	public void insertLog(String numCliente,String login, String iddocumento,int evento,String data,int tipodoc) {

		
		String query = "INSERT INTO calog (numcliente,login,fecha,data,estatus,code,iddocumento,tipo_documento,evento) VALUES " +
					   "(:numCliente,:login,current_timestamp,:data,1,200,:iddocumento,:tipodoc,:evento)";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		parameterSource.addValue("numCliente", numCliente);
		parameterSource.addValue("login", login);
		parameterSource.addValue("data", data);
		parameterSource.addValue("iddocumento", iddocumento);
		parameterSource.addValue("tipodoc", tipodoc);
		parameterSource.addValue("evento", evento);

		try {

			this.namedParameterJdbcTemplate.update(query, parameterSource);

		} catch (Exception dae) {
			
			logger.error("Error en insert caLog: " + dae.getMessage());
			
		}

	}

	@Override
	public String getDeposito(String codigo) {
		
		String deposito = "";

		String query = "SELECT idagrupador FROM frecuenciasentrega WHERE d_codigo = '" + codigo
				+ "' AND garantiamax = '2'";

		try {

			deposito = jdbcTemplate.queryForObject(query, String.class);

		} catch (Exception dae) {

			logger.error("Error en update: " + dae.getMessage());

		}

		return deposito;
	}
	
	public String getDirection(Envio etiquetaRotulacionDTO) {

		List<String> lstRemDes = new ArrayList<>();
		
		String idremdes = "";

		try {

			String query = "SELECT idremdes FROM CAREMDES WHERE numcliente = '" + etiquetaRotulacionDTO.getNumCliente()
					+ "' AND razonsocial = '" + etiquetaRotulacionDTO.getRazonSocialDe() + "' " + "AND colonia = '"
					+ etiquetaRotulacionDTO.getColoniaDe() + "' AND ciudad = '" + etiquetaRotulacionDTO.getMunicipioDe()
					+ "' AND estado = '" + etiquetaRotulacionDTO.getEstadoDe() + "' " + "AND cp = '"
					+ etiquetaRotulacionDTO.getCpDe()
					+ "' AND municipio = '" + etiquetaRotulacionDTO.getMunicipioDe() + "' " + "AND numinterior = '"
					+ etiquetaRotulacionDTO.destinatario.getNuminterior() + "' AND numexterior = '"
					+ etiquetaRotulacionDTO.destinatario.getNumexterior() + "' "
					+ "AND tipodireccion = 'DES' ORDER BY fechacreacion DESC LIMIT 1";

			lstRemDes = this.jdbcTemplate.query(query, new RowMapper() {
			      public Object mapRow(ResultSet resultSet, int i) throws SQLException {
			          return resultSet.getString(1);
			        }
			      });

			if (lstRemDes.size() == 0) {

				 idremdes = UUIDUniqueCreator.generateUUID();

				query = "INSERT INTO caremdes( numcliente, idremdes," + " razonsocial, direccion, colonia, "
						+ "  ciudad, estado, cp, telefono, municipio, rfc," + " identidad, idorganizacion, "
						+ " tipodireccion,numinterior,numexterior,"
						+ "celular,plazaoficina,login,fechacreacion,correoe)" + "    VALUES ('"
						+ etiquetaRotulacionDTO.getNumCliente() + "','" + idremdes + "' , '"
						+ etiquetaRotulacionDTO.getRazonSocialDe() + "', '"
						+ etiquetaRotulacionDTO.destinatario.getCalle() + "', '" + etiquetaRotulacionDTO.getColoniaDe()
						+ "', " + "'" + etiquetaRotulacionDTO.getMunicipioDe() + "', '"
						+ etiquetaRotulacionDTO.getEstadoDe() + "', '" + etiquetaRotulacionDTO.getCpDe() + "', '"
						+ etiquetaRotulacionDTO.getTelefonoDe() + "', '" + etiquetaRotulacionDTO.getMunicipioDe()
						+ "', '" + etiquetaRotulacionDTO.getRFCDe() + "', '"
						+ etiquetaRotulacionDTO.destinatario.getIdentidad() + "', '"
						+ etiquetaRotulacionDTO.destinatario.getIdorganizacion() + "',  " + "'DES','"
						+ etiquetaRotulacionDTO.destinatario.getNuminterior() + "','"
						+ etiquetaRotulacionDTO.destinatario.getNumexterior() + "','"
						+ etiquetaRotulacionDTO.destinatario.getTelefono2()
						+ "',(SELECT siglasplaza FROM caUsuarios WHERE login ='" + etiquetaRotulacionDTO.getNumCliente()
						+ "'),'" + etiquetaRotulacionDTO.getNumCliente() + "', current_timestamp,'"
						+ etiquetaRotulacionDTO.destinatario.getCorreoe() + "')";

				jdbcTemplate.execute(query);

			}else{
				
				idremdes = lstRemDes.get(0);
				
			}
			
			

		} catch (Exception dae) {

			logger.error("Error en update: " + dae.getMessage());

		}

		return idremdes;
	}

	@Override
	public void updateLogReenvio(String iddocumento) {
		
		String query = "UPDATE calog SET fechareenvio = NOW() WHERE iddocumento = :iddocumento AND tipo_documento = 2";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("iddocumento", iddocumento);

		try {

			this.namedParameterJdbcTemplate.update(query, parameterSource);

		} catch (Exception dae) {

			logger.error("Error en update: " + dae.getMessage());

		}
		
	}
}
