/**
 * 
 */
package com.administracion.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.DocumentoJson;
import com.administracion.dto.DocumentoPesoKMMaximo;
import com.administracion.idao.IDireccionIndicadoresCitasDAO;
import com.administracion.idao.IDocumentoServicioDao;
import com.administracion.idao.IHistoriaDAO;
import com.administracion.rowmapper.AdicionalDTOMapper;
import com.administracion.rowmapper.CartaPorteDTORowMapper;
import com.administracion.rowmapper.DocumentoConsultaDTORowMapper;
import com.administracion.rowmapper.DocumentoConsultaDatoMensajeriaDTORowMapper;
import com.administracion.rowmapper.DocumentoDTOMapper;
import com.administracion.rowmapper.DocumentoJsonDTOMapper;
import com.administracion.rowmapper.FacturaCCPRowMapper;
import com.administracion.rowmapper.HistorialRowMapper;
import com.administracion.rowmapper.ObjetoRowMapper;
import com.administracion.rowmapper.RemDesRowMapper;
import com.administracion.rowmapper.TipoServicioRowMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.documentos.dtos.Objeto;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.JsonPrint;
import com.innovargia.utils.UtilsStringFechas;
import com.servicio.constantes.ConstantesAdminSale;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Entrega;
import com.servicio.dtos.Movimiento;
import com.tracusa.ccp.FacturaCCP;

import net.sf.jasperreports.engine.util.JsonUtil;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Repository
public class DocumentoServicioDao extends JdbcDaoSupport implements IDocumentoServicioDao {

    private static final Logger logger = LoggerFactory.getLogger(DocumentoServicioDao.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//	private JdbcTemplate jdbcTemplate;

    @Autowired
    public DocumentoServicioDao(DataSource dataSource) {
	setDataSource(dataSource);
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	// this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String SIN_DEF = "SIN-DEF";

    String formatofecha = "dd-MM-yyyy HH:mm:ss";
    @Autowired
    IHistoriaDAO historiaDao;

    @Autowired
    IDireccionIndicadoresCitasDAO dirIndicadorDAO;

    private final String QUERY_DOC =

	    "SELECT *,tieneattachdocumento(iddocumento) as isnota "
		    + " ,getdescripcionservicio(idservicio) as descripcionservicio,getfecharecoleccion(iddocumento) as fecharecoleccionmov "
		    + " FROM ("
		    + "SELECT datosguia1.*, razonsocial as razonsocialdes,contacto as contactodes,calle as calledes,colonia as coloniades, "
		    + "	municipio as municipiodes,estado as estadodes, ciudad as ciudaddes, cp as cpdes,telefono as telefonodes,"
		    + "	email as emaildes, rfc as rfcdes, encargado as encargadodes, pais as paisdes FROM ("
		    + "	"
		    + "		SELECT datosguia.*,razonsocial as razonsocialrem,contacto as contactorem,calle as callerem,colonia as coloniarem, "
		    + "			municipio as municipiorem,estado as estadorem, ciudad as ciudadrem, cp as cprem,telefono as telefonorem,"
		    + "			email as emailrem, rfc as rfcrem, encargado as encargadorem, pais as paisrem FROM ("
		    + "			SELECT D.*,Devolucion.iddevolucion as iddevolucion FROM (	" +
		    // " SELECT C.*,Casamiento.idcasamiento AS idcasamiento FROM
		    // ("+
		    "					SELECT *, determinaestatusdocumento(iddocumento) as est,extraeguiascasamiento(iddocumento) AS idcasamiento FROM cadocumentos "
		    + "					LEFT OUTER JOIN Confirma ON caDocumentos.IdDocumento = Confirma.idguia		"
		    +
		    // + " ) C LEFT OUTER JOIN Casamiento ON C.IdDocumento =
		    // Casamiento.IdGuia "+
		    "			) D LEFT OUTER JOIN Devolucion ON D.IdDocumento = Devolucion.IdGuia "
		    + "		)datosguia LEFT OUTER JOIN ("
		    + "			select * from cadireccionesdocumento where idtipodireccion ='O'"
		    + "		) remitente ON 	datosguia.iddocumento = remitente.iddocumento" + "	"
		    + ")datosguia1 left outer join ("
		    + "	select * from cadireccionesdocumento where idtipodireccion ='D'"
		    + ") destinatario ON datosguia1.iddocumento = destinatario.iddocumento" + ") a ";

    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje) {
	logger.debug(mensaje);
    }// fin de debug

    @Override
    public int cancelaDocumento(String iddocumento, UsuarioDTO usuario) throws SQLException {

	String query = "UPDATE cadocumentos SET estatus='C' WHERE iddocumento=:iddocumento AND "
		+ "identidad=:identidad AND idorganizacion=:idorganizacion AND "
		+ "quiensolicita IS NULL AND iddocumento NOT IN (SELECT idguia FROM Movimientos)";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("identidad", usuario.entidad.getIdentidad());
	params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
	params.put("iddocumento", iddocumento);

	return this.namedParameterJdbcTemplate.update(query, params);

    }

    @Override
    public int cancelaDocumento(String iddocumento) throws SQLException {

	String query = "UPDATE cadocumentos SET estatus='C' WHERE iddocumento=:iddocumento"
		+ " AND quiensolicita IS NULL " + "AND iddocumento NOT IN (SELECT idguia FROM Movimientos)";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", iddocumento);

	return this.namedParameterJdbcTemplate.update(query, params);

    }

    @Override
    public void updateCitaDocumento(String iddocumento, String fecha, String hora, String folio, UsuarioDTO usuario)
	    throws SQLException {

	String query = "UPDATE cadocumentos SET fechacita=:fechacita, "
		+ "horacita=:horacita ,foliocita=:foliocita WHERE iddocumento=:iddocumento "
		+ " AND identidad=:identidad AND idorganizacion=idorganizacion";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("identidad", usuario.entidad.getIdentidad());
	params.put("idorganizacion", usuario.organizacion.getIdorganizacion());
	params.put("iddocumento", iddocumento);
	params.put("foliocita", folio);
	params.put("horacita", FechasTimeStamp.formatoTime(hora));
	params.put("fechacita", FechasTimeStamp.formatoDateDDMMAAAA(fecha));

	this.namedParameterJdbcTemplate.update(query, params);

    }

    @Override
    public void insertPrecioServicio(DocumentoDTO carta, Connection cnx, UsuarioDTO UsuarioDTO) throws SQLException {
	String query = "INSERT INTO cacostoservicio(iddocumento, idtipodocumento, "
		+ "login, identidad, idorganizacion, costoservicio, porcentajedescuento,"
		+ " descuentoneto, porcentajeiva,ivaneto, importe, importeneto, costoadicionales, "
		+ "costoseguro,  costosobrepeso, costoflete, costoentregadom, costorecoleccion, "
		+ "costoacuse, costofleje, porcentajeretencion, subtotal,costootros,retencionneto,fecha)"
		+ "    VALUES (:idDocumento, :idTipoDocumento, :login,:identidad , :idorganizacion ,:costoservicio,"
		+ " :porcentajedescuento,:descuentoneto, :porcentajeiva,:ivaneto, :importe, :importeneto, :costoadicionales, "
		+ " :costoseguro,  :costosobrepeso, :costoflete, :costoentregadom, :costorecoleccion, "
		+ " :costoacuse, :costofleje, :porcentajeretencion, :subtotal,:costootros,:retencionneto,CURRENT_TIMESTAMP)";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", carta.getIdDocumento());
	params.put("idtipodocumento", carta.getIdTipoDocumento());
	params.put("login", UsuarioDTO.getLogin());
	params.put("identidad", carta.entidad.getIdentidad());
	params.put("idorganizacion", carta.organizacion.getIdorganizacion());
	params.put("costoservicio", carta.getPrecioServicio().getPrecioServicio());
	params.put("porcentajedescuento", carta.getPrecioServicio().getPorcentajedescuento());
	params.put("descuentoneto", carta.getPrecioServicio().getDescuentoneto());
	params.put("porcentajeiva", carta.getPrecioServicio().getPorcentajeIvaNeto());
	params.put("ivaneto", carta.getPrecioServicio().getIvaneto());
	params.put("importe", carta.getPrecioServicio().getImporte());
	params.put("importeneto", carta.getPrecioServicio().getImporteNeto());
	params.put("costoadicionales", carta.getPrecioServicio().getCostoadicionales());
	params.put("costoseguro", carta.getIdDocumento());
	params.put("costosobrepeso", carta.getPrecioServicio().getCostosobrepeso());
	params.put("costoflete", carta.getPrecioServicio().getCostoflete());
	params.put("costoentregadom", carta.getPrecioServicio().getCostoentregadom());
	params.put("costorecoleccion", carta.getPrecioServicio().getCostoacuse());
	params.put("costoacuse", carta.getPrecioServicio().getCostoacuse());
	params.put("costofleje", carta.getPrecioServicio().getCostorecoleccion());
	params.put("porcentajeretencion", carta.getPrecioServicio().getPorcentajeRetencionNeto());
	params.put("retencionneto", carta.getPrecioServicio().getTotalRetencionNeto());
	params.put("costootros", carta.getPrecioServicio().getCostoOtros());
	params.put("subtotal", carta.getPrecioServicio().getSubtotalNeto());

	/*
	 * carta.getPrecioServicio().getPrecioServicio() + " ," +
	 * carta.getPrecioServicio().getPorcentajedescuento() + " ," +
	 * carta.getPrecioServicio().getDescuentoneto() + " ," +
	 * carta.getPrecioServicio().getPorcentajeIvaNeto() + " ," +
	 * carta.getPrecioServicio().getIvaneto() + " ," +
	 * carta.getPrecioServicio().getImporte() + " ," +
	 * carta.getPrecioServicio().getImporteNeto() + " ," +
	 * carta.getPrecioServicio().getCostoadicionales() + " ," +
	 * carta.getPrecioServicio().getSeguro() + " ," +
	 * carta.getPrecioServicio().getCostosobrepeso() + " ," +
	 * carta.getPrecioServicio().getCostoflete() + " ," +
	 * carta.getPrecioServicio().getCostoentregadom() + " ," +
	 * carta.getPrecioServicio().getCostorecoleccion() + " ," +
	 * carta.getPrecioServicio().getCostoacuse() + " ," +
	 * carta.getPrecioServicio().getCostofleje() + " ," +
	 * carta.getPrecioServicio().getPorcentajeRetencionNeto() + " ," +
	 * carta.getPrecioServicio().getSubtotalNeto() + " ," +
	 * carta.getPrecioServicio().getCostoOtros() + " ," +
	 * carta.getPrecioServicio().getTotalRetencionNeto() + ",CURRENT_TIMESTAMP);";
	 */

	KeyHolder keyHolder = new GeneratedKeyHolder();
	// SqlParameterSource parameterSource = new
	// BeanPropertySqlParameterSource(carta);

	try {
	    this.namedParameterJdbcTemplate.update(query, getMapSqlParameterSource(params), keyHolder,
		    new String[] { "idadicional" });

	    // return keyHolder.getKey();
	} catch (DataAccessException dae) {
	    logger.error("error insert:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

    @Override
    public void insertDetalleDocumento(DocumentoDTO carta, Connection cnx) throws SQLException {

	String query = "INSERT INTO cadetalledocumentoserv( iddocumento, idtipodocumento, login, numcliente, "
		+ "factura,  sobrepeso, cantidad, contenido, peso, alto, ancho, largo, pesovol,"
		+ "  )  VALUES (:iddocumento, :idtipodocumento, :login, :numcliente, :factura,"
		+ ":sobrepeso,:sobrepeso, :cantidad, :contenido, :peso, :alto, :ancho, :largo, :pesovol,:flejado)";

	// SqlParameterSource parameterSource = new
	// BeanPropertySqlParameterSource(carta);

	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("iddocumento", carta.getIdDocumento());
	    params.put("idtipodocumento", carta.getIdTipoDocumento());
	    params.put("login", carta.getLogin());
	    params.put("numcliente", carta.getNumCliente());
	    params.put("factura", carta.getFactura());
	    params.put("sobrepeso", carta.getSobrePeso());
	    params.put("cantidad", carta.datosCarta.getBultos());
	    params.put("contenido", carta.datosCarta.getContenido());
	    params.put("peso", carta.datosCarta.getPesoBas());
	    params.put("alto", carta.datosCarta.getAlto());
	    params.put("ancho", carta.datosCarta.getAncho());
	    params.put("largo", carta.datosCarta.getLargo());
	    params.put("pesovol", carta.datosCarta.getPeso_volumetrico());
	    params.put("flejado", carta.datosCarta.geFlejado());
	    this.namedParameterJdbcTemplate.update(query, params);

	    // return keyHolder.getKey();
	} catch (DataAccessException dae) {
	    logger.error("error insertDetalleDocumento:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

    public void updateDoccumentoEtiqueta(EtiquetaRotulacionDTO etiqueta, String idguia) throws SQLException {

	String tmp_iddocumento = etiqueta.getIddocumento();
	etiqueta.setIddocumento(idguia);
	String sql = "UPDATE cadocumentos SET factura_producto_cod=:factura_producto_cod, "
		+ " factura_producto_asegurado=:factura_producto_asegurado, "
		+ " valor_a_cobrar_cod=:valor_a_cobrar_cod,tipoempaque=:tipoempaque,"
		+ " alto=alto, ancho=:ancho, largo=:largo, zonaori=:siglasorigen,"
		+ "es_ocurre=:es_ocurre, es_nacional=:nacional,"
		+ " zonades=:siglasdestino, idoficina=:idoficina,ruta=:ruta, "
		+ "guiainternacional=:idguiainternacional, valordeclarado=:valordeclarado where iddocumento=:iddocumento";

	// Datos administracion de documentos
	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiqueta);

	try {
	    this.namedParameterJdbcTemplate.update(sql, parameterSource);
	    etiqueta.setIddocumento(tmp_iddocumento);
	} catch (Exception dae) {
	    logger.debug("error updateDoccumentoEtiqueta:" + dae.getMessage());
	    dae.printStackTrace();
	    etiqueta.setIddocumento(tmp_iddocumento);
	    throw new DuplicateKeyException("Registro Duplicado");
	}

    }

    public void updateDoccumentoEtiquetaMultiple(String iddocumento, String idguiamadremultiple, String es_multiple,
	    int consecutivo, int cantidad_multiples) throws SQLException {

	String sql = "UPDATE cadocumentos SET idguiamadremultiple=:idguiamadremultiple,es_multiple=:es_multiple, "
		+ "consecutivo_multiple=:consecutivo ,cantidad_multiples= :cantidad_multiples"
		+ " where iddocumento=:iddocumento";
	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("idguiamadremultiple", idguiamadremultiple);
	    params.put("es_multiple", es_multiple);
	    params.put("consecutivo", consecutivo);
	    params.put("cantidad_multiples", cantidad_multiples);
	    params.put("iddocumento", iddocumento);

	    this.namedParameterJdbcTemplate.update(sql, params);
	} catch (Exception dae) {
	    logger.debug("error updateDoccumentoEtiquetaMultiple:" + dae.getMessage());
	    dae.printStackTrace();
	}

    }

    @Override
    public void insertAdicionalesDocumento(EtiquetaRotulacionDTO etiqueta) throws SQLException {
	String sql = "";
	List<CruceCoberturaDTO> arr_transbordos = etiqueta.getArr_transbordos();
	SqlParameterSource parameterSource = null;

	try {
	    sql = "insert into cadocumentoadicionales " + " (select :idenvio,idregistroadicional,"
		    + "idadicional,precio,descripcion, " + "current_timestamp,tipo from "
		    + "rotulacion_etiqueta_adicionales " + "where iddregistrodatos=:idregistrodatos )";

	    parameterSource = new BeanPropertySqlParameterSource(etiqueta);
	    this.namedParameterJdbcTemplate.update(sql, parameterSource);

	} catch (Exception dae) {
	    logger.debug("Error al agregar insertAdicionalesDocumento:" + dae.getMessage());
	    dae.printStackTrace();
	}

    }

    @Override
    public List<AdicionalDTO> getAdicionalesDocumento(String iddocumento) throws SQLException {
	String sql = "";
	List<AdicionalDTO> arr_transbordos = new ArrayList<AdicionalDTO>();

	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("iddocumento", iddocumento);

//			sql = "select * from cadocumentoadicionales where iddocumento= :iddocumento";

	    /* CAMBIO CITA EVIDENCIA MANIOBRA */
	    sql = "select * from cadocumentoadicionales where iddocumento = " + iddocumento;
	    /* FIN CAMBIO */

//			arr_transbordos = jdbcTemplate.query(sql,new AdicionalDTOMapper());

//			arr_transbordos = this.namedParameterJdbcTemplate.query(sql,params, new AdicionalDTOMapper());

	    /* CAMBIO CITA EVIDENCIA MANIOBRA */
	    arr_transbordos = this.namedParameterJdbcTemplate.query(sql, new AdicionalDTOMapper());
	    /* FIN CAMBIO */

	} catch (Exception dae) {
	    logger.debug("Error  getAdicionalesDocumento:" + dae.getMessage());
	    dae.printStackTrace();
	}

	return arr_transbordos;
    }

    public void insertDoccumentoTransbordos(EtiquetaRotulacionDTO etiqueta) throws SQLException {
	String sql = "";
	List<CruceCoberturaDTO> arr_transbordos = etiqueta.getArr_transbordos();
	SqlParameterSource parameterSource = null;

	try {
	    float precio_a_cobrar = 0;
	    for (CruceCoberturaDTO cruceCoberturaDTO : arr_transbordos) {
		etiqueta.setPrecio_unitario(cruceCoberturaDTO.getPrecio_unitario());
		// Datos administracion de documentos
		precio_a_cobrar = cruceCoberturaDTO.getPrecio_unitario() * cruceCoberturaDTO.getKms();
		sql = "INSERT INTO cadocumentotransbordo (iddocumento,terminal_ori,terminal_des,"
			+ "transbordo, tipo_transporte, precio,precio_unitario,"
			+ "km_origen_destino, total, fechainsercion) " + "VALUES ( '" + etiqueta.getIdenvio()
			+ "',:idcoorigen, " + ":idcodestino ,:transbordo,:tipo_transporte,:precio,"
			+ ":precio_unitario,:kms," + precio_a_cobrar + " ,current_timestamp)";

		parameterSource = new BeanPropertySqlParameterSource(cruceCoberturaDTO);
		this.namedParameterJdbcTemplate.update(sql, parameterSource);
	    }

	} catch (Exception dae) {
	    logger.debug("Error al agregar transbordos:" + dae.getMessage());
	    dae.printStackTrace();
	}

    }

    public void insertDatosDocumentoEtiqueta(DocumentoDTO carta) throws SQLException {
	logger.debug("Incia insertDatosDocumentoEtiqueta:" + carta.getIdDocumento());

	String sql = "";

	String esMadre = carta.getEsMadre();

	if (esMadre == null) {

	    esMadre = "n";

	}

	if (!esMadre.equals("n")) {

	    sql = "INSERT INTO cadocumentos("
		    + "iddocumento,idtipodocumento,numcliente,iddocumentopadre,identidad,idorganizacion,login,"
		    + "idoficina,idservicio,idtipocobro,idadicional,idterminalori,idterminaldes,fechacreacion,"
		    + "comentario,estatus,referencia,pesofisico,pesovolumetrico,factura,valordeclarado,contenido,"
		    + "enrutamiento,marcaretornodocumento,largo,ancho,alto,numpiezas,observacion,consecutivo,"
		    + "uuid,pesoamparado,idconvenio,idtarifa,oficinacontrol,cantasegurada,iddocumentomadre,ciaseguro,precio_seguro,cita,sistema) "

		    + " VALUES(:idDocumento,:idTipoDocumento,:numCliente,:idDocumentoPadre,1,1,:login,"
		    + ":idOficina,'--',"
		    + ":idTipoCobro,:idAdicional,:idTerminalOrigen, :idTerminalDestino,  CURRENT_TIMESTAMP,"
		    + ":comentario,'A',:referencia, :pesoBruto, getpesovolumetrico(:alto,:ancho,:largo),:factura,:valorDeclarado,"
		    + ":contenidoDeclarado,:enrutamiento,:marcaRetornoDocumento,:largo, :ancho, :alto, "
		    + ":numPiezas, :observaciones,:consecutivo ,:uuid, :pesoAmparadoFolios,:idconvenio,:idtarifa,"
		    + ":oficinacontrol,:valor_asegurado,:esMadre,:ciaseguro,:precio_seguro,:cita,:sistema)";

	} else {

	    sql = "INSERT INTO cadocumentos("
		    + "iddocumento,idtipodocumento,numcliente,iddocumentopadre,identidad,idorganizacion,login,"
		    + "idoficina,idservicio,idtipocobro,idadicional,idterminalori,idterminaldes,fechacreacion,"
		    + "comentario,estatus,referencia,pesofisico,pesovolumetrico,factura,valordeclarado,contenido,"
		    + "enrutamiento,marcaretornodocumento,largo,ancho,alto,numpiezas,observacion,consecutivo,"
		    + "uuid,pesoamparado,idconvenio,idtarifa,oficinacontrol,cantasegurada,ciaseguro,precio_seguro,maxedd,cita,sistema) "

		    + " VALUES(:idDocumento,:idTipoDocumento,:numCliente,:idDocumentoPadre,1,1,:login,"
		    + ":idOficina,'--',"
		    + ":idTipoCobro,:idAdicional,:idTerminalOrigen, :idTerminalDestino,  CURRENT_TIMESTAMP,"
		    + ":comentario,'A',:referencia, :pesoBruto, getpesovolumetrico(:alto,:ancho,:largo),:factura,:valorDeclarado,"
		    + ":contenidoDeclarado,:enrutamiento,:marcaRetornoDocumento,:largo, :ancho, :alto, "
		    + ":numPiezas, :observaciones,:consecutivo ,:uuid, :pesoAmparadoFolios,:idconvenio,:idtarifa,"
		    + ":oficinacontrol,:valor_asegurado,:ciaseguro,:precio_seguro,:maxEDD,:cita,:sistema)";

	}

	// Datos administracion de documentos
	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(carta);

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", carta.getIdDocumento());
	params.put("idtipodocumento", carta.getIdTipoDocumento());
	params.put("login", carta.getLogin());
	params.put("numcliente", carta.getNumCliente());
	params.put("identidad", carta.entidad.getIdentidad());
	params.put("idorganizacion", carta.organizacion.getIdorganizacion());
	params.put("idservicio", carta.datosCarta.getServicio());

	try {
	    this.namedParameterJdbcTemplate.update(sql, parameterSource);

	    sql = "UPDATE cadocumentos SET idservicio=:idservicio, identidad=:identidad, idorganizacion=:idorganizacion ";

	    if (carta.getCita().equals("S")) {

		params.put("cita", carta.getCita());
		params.put("fechacita", carta.getFechaCita());
		params.put("horacita", carta.getHoraCita());

		sql += ",cita=:cita, fechacita=:fechacita::date, horacita=:horacita::time ";

	    }

	    sql += "WHERE  Iddocumento = :iddocumento";

	    this.namedParameterJdbcTemplate.update(sql, params);

	} catch (DataAccessException dae) {
	    logger.debug("error insertDatosDocumentoEtiqueta:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

	try {

	    Gson gson = new Gson();
	    String json = gson.toJson(carta.datosCarta);

	    params.put("json", json);

	    this.namedParameterJdbcTemplate
		    .update("INSERT INTO cadocumentosjson (iddocumento, fechaevento,jsondata,login) "
			    + " VALUES (:iddocumento, current_timestamp,:json,:login)", params);

	    // return keyHolder.getKey();
	} catch (Exception dae) {
	    logger.debug("error insertDatosDocumentoEtiqueta:" + dae.getMessage());
	    dae.printStackTrace();
	}
    }

    @Override
    public void insertDatosDocumento(DocumentoDTO carta, Connection cnx) throws SQLException {
	String fechacita = UtilsStringFechas.formatoStrFecha(carta.getFechaCita(), "dd-MM-yyyy", "yyyy-MM-dd");
	String horacita = carta.getHoraCita() == null ? null : carta.getHoraCita();
	String ruta = (carta.getRuta() == null) || (carta.getRuta().trim().length() <= 0) ? "SIN_DEF"
		: carta.getRuta().trim();
	String fecharecoleccion = (carta.getFecharecoleccion() == null ? null
		: "'" + UtilsStringFechas.formatoStrFecha(carta.getFecharecoleccion(), "dd-MM-yyyy", "yyyy-MM-dd"))
		+ "'";

	String fechaLimite = (carta.getFechaLimite() == null ? null
		: "'" + UtilsStringFechas.formatoStrFecha(carta.getFechaLimite(), "dd-MM-yyyy", "yyyy-MM-dd")) + "'";

	String isdevolucion = UtilsStringFechas.formatoStrFecha(carta.getIsdevolucion(), "dd-MM-yyyy", "yyyy-MM-dd");
	isdevolucion = isdevolucion == null ? null : "'" + isdevolucion + "'";
	String isrevisado = UtilsStringFechas.formatoStrFecha(carta.getIsrevisado(), "dd-MM-yyyy", "yyyy-MM-dd");
	isrevisado = isrevisado == null ? null : "'" + isrevisado + "'";
	String isenviadoct = UtilsStringFechas.formatoStrFecha(carta.getIsenviadocte(), "dd-MM-yyyy", "yyyy-MM-dd");
	isenviadoct = isenviadoct == null ? null : "'" + isenviadoct + "'";
	String isrechazado = UtilsStringFechas.formatoStrFecha(carta.getIsrechazado(), "dd-MM-yyyy", "yyyy-MM-dd");
	isrechazado = isrechazado == null ? null : "'" + isrechazado + "'";
	String isliberado = UtilsStringFechas.formatoStrFecha(carta.getIsliberado(), "dd-MM-yyyy", "yyyy-MM-dd");
	isliberado = isliberado == null ? null : "'" + isliberado + "'";

	String query = "INSERT INTO cadocumentos(iddocumento, idoficina, idservicio, idtipocobro, idadicional, "
		+ "idterminalori, idterminaldes, idtipodocumento, fechacreacion, "
		+ "comentario, estatus, referencia, pesofisico, pesovolumetrico, "
		+ "login, factura, pedimento, aduana, valordeclarado, tipodeembalaje, "
		+ "contenido, enrutamiento, preciozona, iva, marcafactura, marcaretornodocumento, "
		+ "largo, ancho, alto, numcliente, numpiezas, observacion, zonaori, "
		+ "zonades, ruta, fechamanifiesto, cita, consecutivo, "
		+ "isfacturada, idformapago,quiensolicita,telQuienSolicita,emailQuienSolicita,"
		+ "ciaseguro,numpoliza,inciso,iddocumentopadre,porcentajeiva,porcentajeretencion, "
		+ "volumen,preasignacion,fechacita,horacita,delivery,shipment,fecharecoleccion,identidad,idorganizacion,"
		+ "isdevolucion,isrevisado,isenviadocte,isrechazado,isliberado,rastreo,fechalimite,"
		+ " origenembarque,cossdock,ordernumbersap,ordercreationdate,purcharseorder,shmtdocd,soldparty,soldtopartydesc,"
		+ "shipmentcreationdate,routenumber,deliverycreationdate,tppt,shippingpointcp,carriernumber,carrierdescription,"
		+ "fechasalidamx33,fechallegadal1,foliocita,tiporechazo,cantasegurada,zonaventa,pesoamparado)"
		+ "	VALUES (" + ":idDocumento, :idOficina,'--' , "
		+ ":idTipoCobro, :idAdicional,:idTerminalOrigen, :idTerminalDestino, :idTipoDocumento, CURRENT_TIMESTAMP, :comentario, "
		+ "'A', :referencia, :pesoBruto, :pesoVolumetrico,:login, :factura, :pedimento, :aduana, :valorDeclarado, :tipoEmbalaje, "
		+ ":contenidoDeclarado, :enrutamiento, :precioZona, :iva, :marcaFactura, :marcaRetornoDocumento,"
		+ ":largo, :ancho, :alto, :numCliente, :numPiezas, :observaciones, :idTerminalOrigen, :idTerminalDestino,"
		+ "'--', null, :cita, :consecutivo, :idTipoCobro, :quienSolcita,:telefonoQuienSolicita,"
		+ ":emailQuienSolicita,:ciaSeguro,:numPoliza,:inciso,:idDocumentoPadre,:porcentajeIva,:porcentajeRetencion,"
		+ ":volumen,'P',null,null,:delivery,:embarque,null,1,1,null,null,null,null,null,:consecutivo,null,:"
		+ "origenEmbarque,:cossDock,:orderNumberSAP,:orderCreationDate,:purcharseOrder,"
		+ ":smtDocD,:soldParty,:soldtoPartyDesc,:shipmentCreationDate,:routeNumber,:deliveryCreationDate,"
		+ ":tPPt,:shippingPointCP,:carrierNumber,:carrierDescription,:fechaSalidaMX33,:fechaLlegadaL1,:folioCita,:tiporechazo,"
		+ "0,:zonaVenta,:pesoAmparadoFolios)";

	// Datos administracion de documentos
	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(carta);

	try {

	    this.namedParameterJdbcTemplate.update(query, parameterSource);

	    query = "UPDATE cadocumentos SET idservicio=:idservicio, ruta=:ruta, fechacita=:fechacita,horacita=:horacita,"
		    + "fecharecoleccion=:fecharecoleccion,identidad=:identidad, idorganizacion=:idorganizacion, "
		    + "isdevolucion=:isdevolucion,isrevisado=:isrevisado=:isrevisado,isenviadocte=:isenviadocte,"
		    + "isrechazado=:isrechazado,isliberado=:isliberado,fechaLimite=:fechaLimite,cantasegurada=:cantasegurada "
		    + "WHERE iddocumento=:iddocumento";

	    // Actualiza datos restantes
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("iddocumento", carta.getIdDocumento());
	    params.put("idservicio", carta.datosCarta.getServicio());
	    params.put("ruta", ruta);
	    params.put("fechacita", fechacita);
	    params.put("horacita", horacita);
	    params.put("fecharecoleccion", fecharecoleccion);
	    params.put("identidad", fechacita);
	    params.put("idorganizacion", fechacita);
	    params.put("isdevolucion", isdevolucion);
	    params.put("isrevisado", isrevisado);
	    params.put("isenviadoct", isenviadoct);
	    params.put("isrechazado", isrechazado);
	    params.put("fechaLimite", fechaLimite);
	    params.put("cantidaasegurada", carta.datosCarta.getCantAsegurada());

	    this.namedParameterJdbcTemplate.update(query, params);

	    // return keyHolder.getKey();
	} catch (DataAccessException dae) {
	    logger.error("error insert:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

    @Override
    public void insertDireccionDocumento(RemDes direccion, String iddocumento, String numcliente, String login,
	    Connection cnx) throws SQLException {
	String query = "INSERT INTO cadireccionesdocumento("
		+ "iddocumento, numcliente, login, razonsocial, contacto, calle, "
		+ "colonia, municipio, estado, ciudad, cp, telefono, encargado, "
		+ "estatus, rfc, email, idtipodireccion, iddocumentopadre,idtipodocumento, "
		+ "pais,codigopais,numinterior,numexterior,referencia,telefono2)"
		+ "VALUES (:iddocumento ,:numcliente,:login, "
		+ ":razonSocial, :atencion, :direccion,:colonia, :municipio,"
		+ " :estado, :ciudad, :cp, :telefono, :encargado, null, :rfc, "
		+ ":correoe, :tipoDireccion, :idDocumentoPadre,:idTipoDocumento, :pais,:codigopais,"
		+ ":numinterior,:numexterior,:referencia,:telefono2)";

	// Datos administracion de documentos
	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(direccion);

	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("iddocumento", iddocumento);
	    params.put("login", login);
	    params.put("numcliente", numcliente);
	    params.put("razonSocial", direccion.getRazonSocial());
	    params.put("atencion", direccion.getAtencion());
	    params.put("direccion", direccion.getCalle());
	    params.put("colonia", direccion.getColonia());
	    params.put("municipio", direccion.getMunicipio());
	    params.put("estado", direccion.getEstado());
	    params.put("ciudad", direccion.getCiudad());
//			params.put("ciudad", direccion.getMunicipio());
	    params.put("cp", direccion.getCp());
	    params.put("telefono", direccion.getTelefono());
	    params.put("telefono2", direccion.getTelefono2());
	    params.put("encargado", direccion.getEncargado());
	    params.put("rfc", direccion.getRfc());
	    params.put("correoe", direccion.getCorreoe());
	    params.put("tipoDireccion", direccion.getTipoDireccion());
	    params.put("idDocumentoPadre", direccion.getIdDocumentoPadre());
	    params.put("idTipoDocumento", direccion.getIdTipoDocumento());
	    params.put("pais", direccion.getPais());
	    params.put("codigopais", direccion.getCodigopais());
	    params.put("numinterior", direccion.getNuminterior());
	    params.put("numexterior", direccion.getNumexterior());
	    params.put("referencia", direccion.getReferencia());

	    this.namedParameterJdbcTemplate.update(query, params);

	    // return keyHolder.getKey();
	} catch (DataAccessException dae) {
	    logger.error("error insertDireccionDocumento:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

    @Override
    public void insertPesoKmAmpara(DocumentoPesoKMMaximo datos) throws SQLException {

	String query = "";

	if (datos.getTipo() == ConstantesGenerales.TIPO_ROTULACION_AUTODOC) {
	    query = "INSERT INTO documento_pesokm_max_amparados("
		    + " iddocumento, idconvenio, idtarifa, idconveniodetalle, idrangotarifa, "
		    + " idpesotarifa, idzonatarifa, max_amparado_km, max_amparado_peso,"
		    + " precio, precio_kg_sp,tipo, siglasplaza, idoficina, login, idservicio,"
		    + "  fechacreacion, max_amparado_volumen) "
		    + " VALUES ( :iddocumento, :idconvenio, :idtarifa, :idconveniodetalle, :idrangotarifa, "
		    + " :idpesotarifa, :idzonatarifa,  " + " getmaximopesokmdetalleconvenio(:idconveniodetalle, 2),  "
		    + " getmaximopesokmdetalleconvenio(:idconveniodetalle, 1), "
		    + " getmaximopesokmdetalleconvenio(:idconveniodetalle, 3), "
		    + " getmaximopesokmdetalleconvenio(:idconveniodetalle, 4) , "
		    + ":tipo, getplazaconvenio(:idconvenio) , :idoficina, :login, :idservicio, "
		    + " current_timestamp, :max_amparado_volumen)";
	} else {
	    if (datos.getTipo() == ConstantesGenerales.TIPO_ROTULACION_INTERNACIONAL) {
		query = "INSERT INTO documento_pesokm_max_amparados("
			+ " iddocumento, idconvenio, idtarifa, idconveniodetalle, idrangotarifa, "
			+ " idpesotarifa, idzonatarifa, max_amparado_km, max_amparado_peso,"
			+ " precio, precio_kg_sp,tipo, siglasplaza, idoficina, login, idservicio,"
			+ "  fechacreacion, max_amparado_volumen) "
			+ " VALUES ( :iddocumento, :idconvenio, :idtarifa, :idconveniodetalle, :idrangotarifa, "
			+ " :idpesotarifa, :idzonatarifa, 0, 0, :precio,0, "
			+ ":tipo, :siglasplaza, :idoficina, :login, :idservicio,"
			+ " current_timestamp,:max_amparado_volumen)";
	    } else {
		query = "INSERT INTO documento_pesokm_max_amparados("
			+ " iddocumento, idconvenio, idtarifa, idconveniodetalle, idrangotarifa, "
			+ " idpesotarifa, idzonatarifa, max_amparado_km, max_amparado_peso,"
			+ " precio, precio_kg_sp,tipo, siglasplaza, idoficina, login, idservicio, "
			+ " fechacreacion, max_amparado_volumen) "
			+ " VALUES ( :iddocumento, :idconvenio, :idtarifa, :idconveniodetalle, :idrangotarifa, "
			+ " :idpesotarifa, :idzonatarifa,  getmaximopesokm(:idzonatarifa, 2),  "
			+ " getmaximopesokm(:idpesotarifa, 1), "
			+ " getmaximopesokm(:idzonatarifa, 3), getmaximopesokm(:idzonatarifa, 4) , "
			+ ":tipo, :siglasplaza, :idoficina, :login,"
			+ " :idservicio, current_timestamp, :max_amparado_volumen)";
	    }

	}
	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(datos);

	try {
	    this.namedParameterJdbcTemplate.update(query, parameterSource);

	    // return keyHolder.getKey();
	} catch (Exception dae) {
	    logger.error("error insertPesoKmAmpara:" + dae.getMessage());
	    dae.printStackTrace();

	}

    }

    @Override
    public void insertGuiasRetorno(String iddocumento, String iddocumentoretorno, Connection cnx) throws SQLException {
	String query = "INSERT INTO caguiasretorno(iddocumento, iddocumentoretorno, fechacreacion) "
		+ "VALUES (:iddocumento,:iddocumentoretorno, CURRENT_TIMESTAMP)";

	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("iddocumento", iddocumento);
	    params.put("iddocumentoretorno", iddocumentoretorno);

	    this.namedParameterJdbcTemplate.update(query, params);

	    // return keyHolder.getKey();
	} catch (DataAccessException dae) {
	    logger.error("error insert:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

    @Override
    public void insertGuiasACU(String iddocumento, int idventa, String iduui) throws SQLException {
	String query = "INSERT INTO cadocumento_acu(iddocumento, idventa, iduui,fechainsercion) "
		+ "VALUES (:iddocumento, :idventa,iduui,CURRENT_TIMESTAMP)";
	// + iddocumento + "' ," + idventa + ",'" + iduui + "', CURRENT_TIMESTAMP)";

	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("iddocumento", iddocumento);
	    params.put("idventa", idventa);
	    params.put("iduui", iduui);

	    this.namedParameterJdbcTemplate.update(query, params);

	    // return keyHolder.getKey();
	} catch (Exception dae) {
	    logger.error("error insert:" + dae.getMessage());

	}

    }

    @Override
    public void insertParametrosDocumento(Objeto objeto, DocumentoDTO documento, Connection cnx) throws SQLException {

	String query = "INSERT INTO cadocumentoatributo(iddocumento, idtipodocumento, login, numcliente, parametro, valor ) "
		+ "VALUES (:iddocumento, :idtipodocumento, :login, :numcliente,:parametro,:valor)";
	// + objeto.getStr_Id() + "','" + objeto.getDescripcion() + "')";

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(documento);

	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("iddocumento", documento.getIdDocumento());
	    params.put("idtipodocumento", documento.getIdTipoDocumento());
	    params.put("login", documento.getLogin());
	    params.put("numcliente", documento.getNumCliente());
	    params.put("parametro", objeto.getStr_Id());
	    params.put("valor", objeto.getDescripcion());

	    this.namedParameterJdbcTemplate.update(query, params);
	} catch (DataAccessException dae) {
	    logger.error("error insert:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

    @Override
    public void insertConfirmaEntregaEnvio(Entrega entrega) throws SQLException {

	String query = "INSERT INTO confirma (idguia,conombre,cofecha,fechainsercion,latitud,longitud) "
		+ "VALUES (:guia,:recibe,:fecha,current_timestamp,:latitud,:longitud) ";

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(entrega);

	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("iddocumento", entrega.getGuia());
	    params.put("recibe", entrega.getRecibe());
	    params.put("fecha", entrega.getFecha());
	    params.put("latitud", entrega.getLatitud());
	    params.put("longitud", entrega.getLongitud());

	    this.namedParameterJdbcTemplate.update(query, params);
	} catch (DataAccessException dae) {
	    logger.debug("error insert:" + dae.getMessage());
	}

    }

    @Override
    public void desmarcaPrevioFacturaDocumento(String marcafactura, UsuarioDTO usuario) throws SQLException {

	String query = "UPDATE cadocumentos SET marcafactura=NULL WHERE marcafactura=:marcafactura AND identidad=:identidad";

	try {

	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("marcafactura", marcafactura);
	    params.put("identidad", usuario.entidad.getIdentidad());

	    this.namedParameterJdbcTemplate.update(query, params);

	} catch (DataAccessException dae) {
	    logger.error("error insert:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

    @Override
    public void marcaPreFacturaDocumento(String[] cuentas_arr, String fechacorte, String tipoDocumento,
	    UsuarioDTO usuario, int idorganizacion, String marcafactura) throws SQLException {

	String cuentas = "";

	for (int i = 0; i < cuentas_arr.length; i++) {
	    cuentas += "'" + cuentas_arr[i].trim() + "'";
	    if ((i + 1) < cuentas_arr.length) {
		cuentas += ",";
	    }
	}
	java.sql.Timestamp ts_fecha = FechasTimeStamp.convertFechaToTimeStamp(fechacorte, null,
		FechasTimeStamp.FORMATO_FECHA_DD_MM_AAAA_HH_MM_SS);

	String sql = "UPDATE cadocumentos SET marcafactura=:marcafactura WHERE iddocumento IN ("
		+ " SELECT iddocumento FROM cadocumentos WHERE NumCliente =:cuenta"
		+ " AND fechacreacion<:ts_fecha AND isFacturada IS NULL AND marcafactura IS NULL ) AND"
		+ " identidad=:identidad AND idorganizacion=:idorganizacion ";

	if (!"*".equals(tipoDocumento)) {
	    sql += "  AND idtipodocumento=:idtipodocumento";
	}

	try {

	    Map<String, Object> params = new HashMap<String, Object>();

	    params.put("ts_fecha", ts_fecha);
	    params.put("idtipodocumento", tipoDocumento);
	    params.put("marcafactura", marcafactura);
	    params.put("fechacorte", fechacorte);
	    params.put("numcliente", usuario.getNumCliente());
	    params.put("identidad", usuario.entidad.getIdentidad());
	    params.put("idorganizacion", idorganizacion);

	    for (String cuenta : cuentas_arr) {
		params.put("cuenta", cuenta);
		this.namedParameterJdbcTemplate.update(sql, params);
	    }

	    /*
	     * if (!"*".equals(tipoDocumento)) {
	     * 
	     * this.namedParameterJdbcTemplate.update(sql, params); //new Object[] {
	     * marcafactura, ts_fecha, usuario.entidad.getIdentidad(), //idorganizacion,
	     * tipoDocumento }); } else { this.namedParameterJdbcTemplate.update(sql,
	     * params); //new Object[] { marcafactura, ts_fecha,
	     * usuario.entidad.getIdentidad(), idorganizacion }); }
	     */

	    // return keyHolder.getKey();
	} catch (DataAccessException dae) {
	    logger.error("error insert:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

    @Override
    public List<Objeto> listaMarcaFacturaPendientes(UsuarioDTO usuario, int organizacion) throws SQLException {

	String sql = "SELECT DISTINCT marcafactura as descripcion from cadocumentos where marcafactura is NOT NULL AND "
		+ "  isfacturada IS NULL AND identidad=? AND idorganizacion=?";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("login", usuario.getLogin());
	params.put("numcliente", usuario.getNumCliente());

	params.put("identidad", usuario.entidad.getIdentidad());
	params.put("idorganizacion", organizacion);

	return this.namedParameterJdbcTemplate.query(sql, params, new ObjetoRowMapper());
	// new Object[] { usuario.entidad.getIdentidad(), organizacion },new
	// ObjetoRowMapper());

    }

    @Override
    public String isExisteNOta(String iddocumento) throws SQLException {
	String sql = "SELECT distinct iddocumento as descripcion FROM canotadocumento WHERE iddocumento=:iddocumento";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", iddocumento);

	List<Objeto> lista = new ArrayList<Objeto>();
	lista = this.namedParameterJdbcTemplate.query(sql, params, new ObjetoRowMapper()); // new Object[] { iddocumento
											   // }, new ObjetoRowMapper());

	if (lista.size() > 0) {
	    return lista.get(0).getDescripcion();
	}

	return null;

    }

    @Override
    public void marcaFacturaDocumento(String factura, String prefactura, UsuarioDTO usuario) throws SQLException {

	String query = "UPDATE cadocumentos SET isFacturada=:factura WHERE isFacturada IS NULL AND marcafactura =:prefactura "
		+ " AND identidad=:identidad ";

	try {

	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("factura", factura);
	    params.put("prefactura", prefactura);
	    params.put("login", usuario.getLogin());
	    params.put("numcliente", usuario.getNumCliente());
	    params.put("identidad", usuario.entidad.getIdentidad());

	    this.namedParameterJdbcTemplate.update(query, params);
	    // new Object[] { factura, prefactura, usuario.entidad.getIdentidad() });

	} catch (DataAccessException dae) {
	    logger.error("error insert:" + dae.getMessage());
	    dae.printStackTrace();
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

    @Override
    public RemDes getInfoDireccion(String iddocumento, String tipoDireccion, String idtipodocumento) {
	String sql = "SELECT iddocumento, numcliente, login, razonsocial, contacto, calle,"
		+ " colonia, municipio, estado, ciudad, cp, telefono, encargado,"
		+ " estatus, rfc, email, idtipodireccion, iddocumentopadre, idtipodocumento"
		+ " FROM cadireccionesdocumento WHERE idtipodireccion =:idtipodireccion and "
		+ "iddocumento= :iddocumento AND idtipodocumento=:idtipodocumento";

	List<RemDes> lista = new ArrayList<RemDes>();

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", iddocumento);
	params.put("idtipodireccion", tipoDireccion);
	params.put("idtipodocumento", idtipodocumento);

	lista = this.namedParameterJdbcTemplate.query(sql, params, new RemDesRowMapper());
	// new Object[] { tipoDireccion, iddocumento, idtipodocumento },
	// new RemDesRowMapper());
	if (lista.size() > 0) {
	    return lista.get(0);
	}
	return null;

    }

    /**
     * Ajusta los datos de los documentos encontrados en al realizar la busqueda
     * 
     * @param rs
     * @return
     */
    private void setDatosDocumento(List<DocumentoDTO> arr) {

	// Obtiene las direcciones cartaPorDto.setRemitente(getInfoDireccion(
	for (DocumentoDTO cartaPorDto : arr) {

	    // Se elimino esta consulta ya que ya en el query existe ya la
	    // columna
	    // de isnota que indica si el documento tiene notas asociadas
	    try {
		cartaPorDto.setIsexistenota(isExisteNOta(cartaPorDto.getIdDocumento()));
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	    cartaPorDto.setRemitente(getInfoDireccion(cartaPorDto.getIdDocumentoPadre(),
		    RemDes.TIPO_DIRECCION_ORIGEN_REM, cartaPorDto.getIdTipoDocumento()));

	    cartaPorDto.setDestinatario(getInfoDireccion(cartaPorDto.getIdDocumentoPadre(),
		    RemDes.TIPO_DIRECCION_DESTINATARIO, cartaPorDto.getIdTipoDocumento()));

	    cartaPorDto.setRecoleccion(getInfoDireccion(cartaPorDto.getIdDocumentoPadre(),
		    RemDes.TIPO_DIRECCION_RECOLECCION, cartaPorDto.getIdTipoDocumento()));

	    cartaPorDto.setDomicionfiscal(getInfoDireccion(cartaPorDto.getIdDocumentoPadre(),
		    RemDes.TIPO_DIRECCION_FACTURACION, cartaPorDto.getIdTipoDocumento()));

	    cartaPorDto.setRazonSocialDestino(cartaPorDto.getDestinatario().getRazonSocial());

	    // Agusta los valores para ser desplegados en la tabla
	    cartaPorDto.setRazonSocialDestino(cartaPorDto.getDestinatario().getRazonSocial());

	}

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

	// verifica si la consulta es por Internet fuera del modulo de autodoc
	if (usuario.entidad.getIdentidad() == ConstantesAdminSale.CONSULTA_INTERNET) {
	    lista = this.namedParameterJdbcTemplate.query(sql, params, new DocumentoConsultaDTORowMapper());
	} else {
	    if (datos != null) {
		if (datos.isSoloConCita()) {
		    sql += " AND  cita=:cita";
		}
	    }

	    if (CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params) != null) {
		sql = sql + " AND " + CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params);
	    } else {
		return lista;
	    }

	    // Verifica si se manda el rangode fechas
	    if ((fechaini != null) && (fechafin != null) && (fechaini.trim().length() > 0)
		    && (fechafin.trim().length() > 0)) {

		sql += " AND fechacreacion>='" + fechaini + "' AND fechacreacion<='" + fechafin + "'";

		lista = this.namedParameterJdbcTemplate.query(sql, params, new DocumentoConsultaDTORowMapper());

	    } else {
		lista = namedParameterJdbcTemplate.query(sql, params, new DocumentoConsultaDTORowMapper());
	    }
	}

	// Complementa los datos
	logger.debug(sql);
	return lista;

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
    public List<DocumentoConsultaDTO> busquedaXShipment(UsuarioDTO user, String shipment, Hashtable condiciones,
	    String tipoDocumento, UsuarioDTO usuario) {

	List<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("shipment", shipment);
	params.put("idtipodocumento", tipoDocumento);
	params.put("login", usuario.getLogin());
	params.put("numcliente", usuario.getNumCliente());
	params.put("identidad", usuario.entidad.getIdentidad());
	params.put("idorganizacion", usuario.getNumCliente());

	// Obtiene los datos de la orden de Servicio
	String sql = QUERY_DOC + " WHERE shipment=:shipment ";
	if (tipoDocumento != null) {
	    sql += " AND idtipodocumento=:idtipodocumento";
	}

	if (CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params) != null) {
	    sql = sql + " AND " + CondicionNivelPerfilDAO.condicionNivelUsuario(usuario, params);
	} else {
	    return lista;
	}

	// Crea los diferentes tipos de combinaciones del hash
	// Obtiene las llaves de del has
	Enumeration llaves = condiciones.keys();
	String str_condiciones = "";
	boolean inicia = true;
	String key = "";
	while (llaves.hasMoreElements()) {

	    if (!inicia) {
		str_condiciones += " OR ";
	    }
	    key = (String) llaves.nextElement();
	    inicia = false;
	    str_condiciones += key + "=" + (String) condiciones.get(key);
	}
	if (!"".equals(str_condiciones)) {
	    sql += " AND (" + str_condiciones + ")";
	}

	lista = namedParameterJdbcTemplate.query(sql, params, new DocumentoConsultaDTORowMapper());

	// setDatosDocumento(lista);

	return lista;

    }

    @Override
    public List<DocumentoConsultaDTO> busquedaDocumentosEstatus(DocumentoDTO datoscarta, UsuarioDTO user) {
	String sql = QUERY_DOC + " WHERE shipment=:idbusqueda";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("shipment", datoscarta.getEmbarque());
	params.put("login", user.getLogin());
	params.put("numcliente", user.getNumCliente());
	params.put("identidad", user.entidad.getIdentidad());
	params.put("idorganizacion", user.getNumCliente());

	return getArrConsulta(datoscarta.getEmbarque(), sql, null, null, null, datoscarta, user, params);
	// busquedaDocumentos(sql, null, null, null, datoscarta, user,params);

    }

    @Override
    public ServicioDTO getTipoCobroServicio(String idservicio) throws Exception {
	String sql = "select * from catiposervicio where idservicio=:idservicio";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idservicio", idservicio);

	List<ServicioDTO> lista = namedParameterJdbcTemplate.query(sql, params, new TipoServicioRowMapper());

	if (lista.size() > 0) {
	    return lista.get(0);
	}
	return new ServicioDTO();

    }

    @Override
    public List<ServicioDTO> getTipoServicioXTipoCobro(String tipocobro) throws Exception {
	tipocobro = tipocobro == null ? "" : tipocobro.trim();
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("tipocobro", tipocobro);

	String sql = "select * from catiposervicio " + (tipocobro.isEmpty() ? "" : " where tipocobro=:tipocobro");

	List<ServicioDTO> lista = this.namedParameterJdbcTemplate.query(sql, params, new TipoServicioRowMapper());
	return lista;

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
    public List<DocumentoConsultaDTO> getEmbarquesDocumentoCliente(UsuarioDTO user) {
	List<DocumentoConsultaDTO> arr_documentos = new ArrayList<DocumentoConsultaDTO>();

	String sql = "Select distinct shipment FROM viewEmbarquesCuentaCliente" + "  WHERE identidad=identidad AND "
		+ "idorganizacion=:idorganizacion AND  numcliente=:numcliente";
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("login", user.getLogin());
	params.put("numcliente", user.getNumCliente());
	params.put("identidad", user.entidad.getIdentidad());
	params.put("idorganizacion", user.getNumCliente());

	return namedParameterJdbcTemplate.query(sql, params, new DocumentoConsultaDTORowMapper());

    }

    @Override
    public DocumentoDTO getInfoDocumento(String iddocumento, UsuarioDTO usuario) {

	List<DocumentoDTO> documentos = getInfoDocumento(iddocumento, null, usuario);
	if (documentos.size() > 0) {
	    return documentos.get(0);
	}
	return null;
    }

    @Override
    public DocumentoDTO getInfoDocumentoJson(String iddocumento) {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", iddocumento);

	String sql = "select * FROM cadocumentosjson WHERE iddocumento=:iddocumento";
	List<DocumentoJson> lista = this.namedParameterJdbcTemplate.query(sql, params, new DocumentoJsonDTOMapper());
	DocumentoJson obj_json = new DocumentoJson();
	if (lista.size() > 0) {
	    obj_json = lista.get(0);
	}
	DocumentoConsultaDTO docto = new DocumentoConsultaDTO();
	try {
	    sql = "select * FROM cadocumentos where iddocumento=:iddocumento";

	    List<DocumentoConsultaDTO> arr_envio = this.namedParameterJdbcTemplate.query(sql, params,
		    new DocumentoConsultaDTORowMapper());
	    if (arr_envio.size() > 0) {
		docto = arr_envio.get(0);
	    }
	} catch (Exception e) {
	    logger.info("No se logo encontrar la guia en documentos:" + e.getMessage());
	}
	Gson gson = new Gson();
	JsonParser parser = new JsonParser();
	JsonArray jArray = parser.parse("[" + obj_json.getJsondata() + "]").getAsJsonArray();

	// List<Envio> lcs = new ArrayList<Envio>();

	DocumentoDTO documento = new DocumentoDTO();
	for (JsonElement obj : jArray) {
	    Envio cse = gson.fromJson(obj, Envio.class);
	    cse.setSiglasOrigen(docto.getZonaOri());
	    cse.setSiglasDestino(docto.getZonaDes());
	    documento.datosCarta = cse;
	    return documento;
	}

	documento.datosCarta = null;

	return documento;
    }

    @Override
    public DocumentoConsultaDTO getInfoGuia(String iddocumento) {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", iddocumento);

	String sql = QUERY_DOC + " WHERE iddocumento=:iddocumento";
	List<DocumentoConsultaDTO> lista = this.namedParameterJdbcTemplate.query(sql, params,
		new DocumentoConsultaDTORowMapper());
	logger.debug("sql:" + sql);
	if (lista.size() > 0) {
	    return lista.get(0);
	}

	return null;
    }

    @Override
    public List<DocumentoDTO> getInfoDocumento(String iddocumento, String tipoDocumento, UsuarioDTO usuario) {
	List<DocumentoDTO> lista = new ArrayList<DocumentoDTO>();

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", iddocumento);
	params.put("idtipodocumento", tipoDocumento);

	params.put("numcliente", usuario.getNumCliente());
	params.put("identidad", usuario.entidad.getIdentidad());
	params.put("idorganizacion", usuario.getNumCliente());
	params.put("login", usuario.getLogin());

	String sql = QUERY_DOC + " WHERE iddocumento=:iddocumento AND identidad=:identidad";

	lista = this.namedParameterJdbcTemplate.query(sql, params, new CartaPorteDTORowMapper());

	return lista;

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
    public DocumentoConsultaDTO getInfoDocumentoMensajeria(String iddocumento) {
	String sql = "select idDocumento, es_nacional,guiainternacional, carriernumber "
		+ "from cadocumentos where iddocumento=:iddocumento";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", iddocumento);

	List<DocumentoConsultaDTO> lista = this.namedParameterJdbcTemplate.query(sql, params,
		new DocumentoConsultaDatoMensajeriaDTORowMapper());

	if (lista.size() > 0) {
	    return lista.get(0);
	}
	return null;
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

//		if (usuario.entidad.getIdentidad() == ConstantesAdminSale.CONSULTA_INTERNET) {
//			sql = sql + " WHERE iddocumento IN (:idbusqueda)  AND idtipodocumento=:idtipodocumento";
//		} else {
//			if (iddocumento.contains("%")) {
//				sql = sql + " WHERE iddocumento LIKE ':id%' AND idtipodocumento=:idtipodocumento AND "
//						+ "identidad=:identidad";
//			} else {
//				sql = sql + " WHERE iddocumento IN (:idbusqueda) AND idtipodocumento=:idtipodocumento"
//						+ " AND identidad=:identidad";
//			}
//		}
	logger.info("SQL:" + sql);

	/*
	 * String[] arr_iddocumento = iddocumento.replaceAll("'", "").split(",");
	 * List<DocumentoConsultaDTO> tmp_arr_documentos; arr_documentos = new
	 * ArrayList<DocumentoConsultaDTO>(); Map<String,String> _map_ = new
	 * HashMap<String,String>();
	 * 
	 * for (String myguia : arr_iddocumento) { if (!_map_.containsKey(myguia)){
	 * params.put("iddocumento",myguia); tmp_arr_documentos =
	 * busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario,params); for
	 * (DocumentoConsultaDTO documentoConsultaDTO : tmp_arr_documentos) {
	 * arr_documentos.add(documentoConsultaDTO); } _map_.put(myguia, myguia); }
	 * 
	 * 
	 * }
	 */

	arr_documentos = getArrConsulta(iddocumento, sql, null, null, tipoDocumento, null, usuario, params);
	// busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario,params);

	// Verifica si no existe informacion entonces lo checa en historia
	if (arr_documentos.size() <= 0) {
	    DocumentoConsultaDTO carta = new DocumentoConsultaDTO();
	    List<Movimiento> arrHistoria;
	    try {
		logger.info("Historia Documento:" + iddocumento);
		arrHistoria = historiaDao.getHistoria(iddocumento, false);
		if (arrHistoria.size() > 0) {
		    // Crea el registro con el estatus solo historia
		    carta.setIdDocumento(iddocumento);
		    carta.setEstatus("H");
		    arr_documentos.add(carta);
		}
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	}

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

	// busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario,params);

	// Ahora obtiene los datos de las guias que tengan historia o
	// confirmacion
	// pero que no esten en documentos y los agrega a a la lista
	sql = "SELECT distinct D.*,Devolucion.iddevolucion as iddevolucion FROM ( "
		+ " SELECT C.*,Casamiento.idcasamiento AS idcasamiento  FROM ( "
		+ "		SELECT A.*, B.* FROM ( 	SELECT DISTINCT movimientos.idguia as IdDocumento,"
		+ "		confirma.conombre,confirma.cofecha,confirma.fechaentregapod  FROM "
		+ "			movimientos LEFT OUTER JOIN confirma  ON movimientos.idguia = confirma.idguia"
		+ "				 WHERE movimientos.idguia NOT IN ( SELECT iddocumento FROM caDocumentos) AND"
		+ "						  movimientos.idguia LIKE ':iddocumento%'"
		+ "					) A LEFT OUTER JOIN  "
		+ "		( SELECT distinct iddocumento as isnota  FROM viewEnviosConNotas ) B ON A.IdDocumento = B.isnota "
		+ "	) C LEFT OUTER JOIN Casamiento ON C.IdDocumento = Casamiento.IdGuia ) D "
		+ "	LEFT OUTER JOIN Devolucion ON D.IdDocumento = Devolucion.IdGuia";

	List<DocumentoConsultaDTO> arr_documentos_historia = this.namedParameterJdbcTemplate.query(sql, params,
		new DocumentoConsultaDTORowMapper());
	for (DocumentoConsultaDTO cartaPorteDTO : arr_documentos_historia) {
	    arr_documentos.add(cartaPorteDTO);
	}

	return arr_documentos;

    }

    @Override
    public List<DocumentoConsultaDTO> getInfoDocumentoXRastreo(DocumentoDTO datosdocto, String tipoDocumento,
	    UsuarioDTO usuario) {

	String sql = QUERY_DOC + " WHERE  idtipodocumento=:idtipodocumento  AND rastreo= :consecutivo"
		+ " AND identidad=:identidad";
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("consecutivo", datosdocto.getConsecutivo());
	params.put("idtipodocumento", tipoDocumento);
	params.put("login", usuario.getLogin());
	params.put("numcliente", usuario.getNumCliente());
	params.put("identidad", usuario.entidad.getIdentidad());
	params.put("idorganizacion", usuario.getNumCliente());

	return busquedaDocumentos(sql, null, null, tipoDocumento, null, usuario, params);

    }

    @Override
    public List<DocumentoConsultaDTO> getInfoDocumentoXTransporte(DocumentoDTO datosdocto, String fechaini,
	    String fechafin, int tipobusqueda, UsuarioDTO usuario) {

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", datosdocto.getIdDocumento());
	params.put("idtipodocumento", datosdocto.getIdTipoDocumento());
	params.put("login", usuario.getLogin());
	params.put("numcliente", usuario.getNumCliente());
	params.put("fechafin", usuario.getNumCliente());

	List<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();
	String sql = QUERY_DOC + " WHERE  ";

	String valor = datosdocto.getEmbarque(); // Embarque tiene el valor
	params.put("valor", valor);
	// a buscar actualizado
	// en el ACTION
	if (tipobusqueda == 9) { // soldparty
	    sql += " soldparty=:valor";
	} else if (tipobusqueda == 10) { // OrderNumberSAP
	    sql += " ordernumbersap=:valor";
	} else if (tipobusqueda == 11) { // Coss Dock
	    sql += " cossdock=:valor";
	} else if (tipobusqueda == 12) { // Route Number
	    sql += " routenumber=:valor";
	} else if (tipobusqueda == 13) { // Purcharse Order
	    sql += " purcharseorder=:valor";
	} else {
	    // Regresa la lista vacia
	    logger.debug("No se definio tipo busqueda getInfoDocumentoXTransporte");
	    return lista;
	}

	return busquedaDocumentos(sql, fechaini, fechafin, null, null, usuario, params);

    }

    @Override
    public List<DocumentoConsultaDTO> busquedaXFechasCreacion(String fechaini, String fechafin, String tipoDocumento,
	    DocumentoDTO datos, UsuarioDTO usuario) {
	String sql = QUERY_DOC + " WHERE idtipodocumento=:idtipodocumento ";

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

    @Override
    public void updateAsignacionRuta(String iddocumento, String ruta, Timestamp fechaasignacion, String tipodocumento)
	    throws Exception {

	if ((ruta == null) || (ruta.trim().length() <= 0)) {
	    ruta = SIN_DEF;
	}
	debug("iddocumento:" + iddocumento + ", ruta" + ruta + " ,fechaasignacion:" + fechaasignacion
		+ "  ,tipodocumento:" + tipodocumento);
	// String preasignacion = "";
	String sql = "";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", iddocumento);
	params.put("ruta", ruta);
	params.put("idtipodocumento", tipodocumento);
	params.put("fechaasignacion", fechaasignacion);

	if (fechaasignacion != null) {
	    sql = "UPDATE cadocumentos SET fechaAsignacion=:fechaasignacion,preasignacion=:preasignacion,"
		    + " ruta=:ruta  WHERE iddocumento=:iddocumento AND idtipodocumento=:tipodocumento ";
	    params.put("preasignacion", "A");
	    this.namedParameterJdbcTemplate.update(sql, params);

	} else {
	    params.put("preasignacion", "P");
	    sql = "UPDATE cadocumentos SET fechaAsignacion=null,preasignacion=:preasignacion , ruta=:ruta"
		    + " WHERE iddocumento=:iddocumento AND idtipodocumento=:tipodocumento";

	    this.namedParameterJdbcTemplate.update(sql, params);
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.administracion.dao.IDocumentoServicioDao#updateEstatusDocumentos(
     * com.servicio.dtos.CartaPorteDTO, com.innovargia.salesmanager.dtos.UsuarioDTO)
     */
    @Override
    public void updateEstatusDocumentos(DocumentoDTO datos, UsuarioDTO user) throws Exception {

	String sql = "UPDATE cadocumentos SET isdevolucion=:isdevolucion,isrevisado=:isrevisado,"
		+ " isenviadocte=:isenviadocte,isrechazado=:isrechazado,isliberado=:isliberado"
		+ " WHERE iddocumento=:iddocumento AND identidad=:identidad  AND idorganizacion=:idorganizacion";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", datos.getIdDocumento());
	params.put("identidad", datos.entidad.getIdentidad());
	params.put("idorganizacion", datos.organizacion.getIdorganizacion());
	params.put("idtipodocumento", datos.getIdTipoDocumento());
	params.put("login", datos.getLogin());
	params.put("numcliente", datos.getNumCliente());
	params.put("isdevolucion", FechasTimeStamp.formatoDateDDMMAAAA(datos.getIsdevolucion()));
	params.put("isrevisado", FechasTimeStamp.formatoDateDDMMAAAA(datos.getIsrevisado()));
	params.put("isenviadocte", FechasTimeStamp.formatoDateDDMMAAAA(datos.getIsenviadocte()));
	params.put("isrechazado", FechasTimeStamp.formatoDateDDMMAAAA(datos.getIsrechazado()));
	params.put("isliberado", FechasTimeStamp.formatoDateDDMMAAAA(datos.getIsliberado()));

	this.namedParameterJdbcTemplate.update(sql, params);
	/*
	 * new Object[] { FechasTimeStamp.formatoDateDDMMAAAA(datos.getIsdevolucion()),
	 * FechasTimeStamp.formatoDateDDMMAAAA(datos.getIsrevisado()),
	 * FechasTimeStamp.formatoDateDDMMAAAA(datos.getIsrechazado()),
	 * FechasTimeStamp.formatoDateDDMMAAAA(datos.getIsliberado()),
	 * datos.getIdDocumento(), user.entidad.getIdentidad(),
	 * user.organizacion.getIdorganizacion()
	 * 
	 * });
	 */

    }

    @Override
    public void updateRechazoDocumentos(DocumentoDTO datos, UsuarioDTO user) throws Exception {

	String sql = "UPDATE cadocumentos SET fecharechazo=:fecharechazo,claverechazo=:claverechazo,"
		+ " foliorechazo=:foliorechazo,cantidadrechazo=.cantidadrechazo, tiporechazo=:tiporechazo"
		+ "  WHERE identidad=:identidad  AND idorganizacion=:idorganizacion and factura=:factura	";

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", datos.getIdDocumento());
	params.put("idtipodocumento", datos.getIdTipoDocumento());
	params.put("login", FechasTimeStamp.formatoDateDDMMAAAA(datos.getFecharechazo()));
	params.put("numcliente", datos.getNumCliente());
	params.put("fecharechazo", datos.getClaverechazo());
	params.put("foliorechazo", datos.getFoliorechazo());
	params.put("cantidadrechazo", datos.getCantidadrechazo());
	params.put("tiporechazo", datos.getTiporechazo());
	params.put("tiporechazo", datos.getTiporechazo());
	params.put("factura", datos.getFactura());

	this.namedParameterJdbcTemplate.update(sql, params);

	/*
	 * new Object[] { FechasTimeStamp.formatoDateDDMMAAAA(datos.getFecharechazo()),
	 * datos.getClaverechazo(), datos.getFoliorechazo(), datos.getCantidadrechazo(),
	 * datos.getTiporechazo(), user.entidad.getIdentidad(),
	 * user.organizacion.getIdorganizacion(), datos.getFactura()
	 * 
	 * });
	 */

    }

    @Override
    public List<LogHistoriaDTO> getHistoriaDocumento(String iddocumento, UsuarioDTO usuario) {

	String sql =

		"SELECT *, tiregistro as tipomovimiento FROM ("
			+ "SELECT mov2.*,estatus_documento.descripcion as descripcion_estatus, estatus_documento.imagen as imagen_css FROM ("
			+ "	SELECT * FROM ("
			+ "		SELECT  datos.*,caexcepcion.descripcion as descricpionexcepcion FROM ( "
			+ "						select movimientos.*, movimientos.tiregistro as idregistro,"
			+ "						fechaevento as fecha,ceorigenregistro as plazaorigina,nombre as descripcion,"
			+ "						latitud ,longitud "
			+ "						from movimientos left outer join "
			+ "						inforegistros_maestro on movimientos.tiregistro= inforegistros_maestro.idregistro "
			+ "					) datos left outer join caexcepcion ON datos.exclave = idexcepcion where idguia=:iddocumento"
			+ "	) mov1 LEFT OUTER JOIN movimiento_estatus ON mov1.tiregistro = movimiento_estatus.idregistro AND "
			+ "		COALESCE (mov1.exclave,'')  = COALESCE (movimiento_estatus.idexcepcion,'')  "
			+ ")mov2 LEFT OUTER JOIN 	estatus_documento ON mov2.idestatus = estatus_documento.idestatus"
			+ " UNION "

			+ " select idguia, "
			+ " '900' as tiporegistro ,idcasamiento as exclave,plsiglasplaza,ceorigenregistro,ruta,fechaevento, "
			+ "current_timestamp as fechainsercion,empleado,'' as latitud,'' as longitud,'' as viaje,"
			+ " '' as numeconomico, '' as operador, '' as cincho, '' as deptodestino, '' as ubicacion,'900' as idregistro,fechaevento as fecha,'' as plazaorigina,"
			+ " 'CASAMIENTO' as descripcion,'' as lat,'' as longi,'' as descripcionexcepcion,'900' as idregistro,"
			+ " 'CASAMIENTO' as idexcepcion,0 as idestatus, '' as descripcion_estatus, '' as imagen_css "
			+ " from casamiento where idguia=:iddocumento"

			+ " ) a order by fecha desc ";

	logger.debug("sql:" + sql);

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("iddocumento", iddocumento);
	return this.namedParameterJdbcTemplate.query(sql, params, new HistorialRowMapper());

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

    @Override
    public List<DocumentoDTO> getInfoDocumentoMadre(String iddocumentomadre) {

	List<DocumentoDTO> lista = null;

	try {

	    Map<String, Object> params = new HashMap<String, Object>();

	    params.put("iddocumentomadre", iddocumentomadre);

	    String sql = "SELECT * FROM cadocumentos WHERE iddocumentomadre =:iddocumentomadre";

	    lista = this.namedParameterJdbcTemplate.query(sql, params, new DocumentoDTOMapper());

	} catch (Exception e) {

	    logger.info("No se logo encontrar la guia en documentos:" + e.getMessage());

	}
	return lista;

    }

    @Override
    public List<FacturaCCP> getFacturasCCP(String viaje) {

	List<FacturaCCP> lista = null;

	try {

	    String sql = "";

	    if (viaje != null) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("idviaje", Integer.parseInt(viaje));

		sql = "SELECT * FROM ccp_factura WHERE idviaje =:idviaje ORDER BY idcontrol DESC";

		lista = this.namedParameterJdbcTemplate.query(sql, params, new FacturaCCPRowMapper());

	    } else {

		sql = "SELECT * FROM ccp_factura ORDER BY idcontrol DESC";

		lista = this.namedParameterJdbcTemplate.query(sql, new FacturaCCPRowMapper());

	    }

	} catch (Exception e) {

	    logger.info("No se logo encontrar la guia en documentos:" + e.getMessage());

	}
	return lista;
    }

}
