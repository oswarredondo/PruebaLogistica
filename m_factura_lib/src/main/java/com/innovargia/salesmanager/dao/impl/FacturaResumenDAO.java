/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.administracion.dto.Factura;
import com.administracion.dto.FacturaDetalle;
import com.administracion.dto.FacturaGuia;
import com.administracion.rowmapper.CuentasClienteRowMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.innovargia.administracion.dto.LineaFacturaSAP;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.idao.IFacturaResumenDAO;
import com.innovargia.salesmanager.mappers.FacturaGuiaRowMapper;
import com.innovargia.salesmanager.mappers.FacturaResumenDetalleRowMapper;
import com.innovargia.salesmanager.mappers.FacturaResumenRowMapper;
import com.innovargia.salesmanager.mappers.LineaFacturaSAPRowMapper;
import com.innovargia.utils.UtilsStrings;

/**
 * @author aruaro
 * 
 */
@Repository
public class FacturaResumenDAO extends JdbcDaoSupport implements IFacturaResumenDAO {

	private static final Logger logger = LoggerFactory.getLogger(FacturaResumenDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public FacturaResumenDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insert(Factura obj) throws Exception {
		String query = "INSERT INTO factura_resumen(dia, cliente, login, estatus, tipo) " 
				+ " VALUES ('" + obj.getDia() +"',:cliente,:login, 'A',:tipo)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		logger.debug("Query:" + query);
		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder, new String[] { "idcontrol" });
			Number id = keyHolder.getKey();

			query = "UPDATE factura_resumen SET mes=EXTRACT(MONTH FROM dia) "
					+ " ,anio=EXTRACT(YEAR FROM dia), idcontrolenvio=? WHERE idcontrol=?";
			this.jdbcTemplate.update(query, new Object[]{UtilsStrings.completa(id.intValue() + "", '0', 6, 1),
					id.intValue()});
			return id.intValue();
		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.salesmanager.dao.impl.IFacturaResumen#updateCancela(com.
	 * administracion.dto.Factura)
	 */
	@Override
	public void updateCancela(Factura obj) throws Exception {

		String sql = "UPDATE factura_resumen SET " + " estatus='C',t_txt_oper=:t_txt_oper,"
				+ " t_txt_head=:t_txt_head,fecha_cancela=current_date, login_cancela=:login"
				+ " WHERE idcontrol=:idcontrol";
				

		logger.debug("Query:" + sql);
		try {
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
			this.namedParameterJdbcTemplate.update(sql, parameterSource);

		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}

	}

	@Override
	public void updateNotaCredito(Factura obj) throws Exception {

		String query = "UPDATE factura_resumen SET fecha_notacredito=current_date,"
				+ " estatus='N',t_txt_oper=:t_txt_oper, t_txt_head=:t_txt_head,fac_nota=:fac_nota,"
				+ "login_notacredito=:login WHERE idcontrol=:idcontrol";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);

		logger.debug("Query:" + query);
		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);

		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.salesmanager.dao.impl.IFacturaResumen#updateFactura(com.
	 * administracion.dto.Factura)
	 */
	@Override
	public void updateFactura(Factura obj) throws Exception {

		String query = "UPDATE factura_resumen SET estatus='F',factura=? WHERE idcontrol=?";

		logger.debug("Query:" + query);
		try {
			this.jdbcTemplate.update(query,new Object[]{obj.getFactura(),obj.getIdcontrol()});

			query = "UPDATE cadocumentos SET ordernumbersap=? WHERE marcafactura=?";
			
			logger.debug("Query:" + query);
			
			this.jdbcTemplate.update(query,new Object[]{obj.getFactura(), obj.getIdcontrolenvio()});
			
		} catch (Exception dae) {
			logger.error("error updateFactura:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}

	}

	public void updateMarcaFacturaEnDocumento(Factura obj) throws Exception {
		// Marca los registros con el idcontrolenvio de la tabla
		// de recumen_factura
		// TODO:VERIFICAR CRITERIO DE MARCADO
		String dia = obj.getDia() + " 00:00:00";
		String view = "";
		
		switch(obj.getEstatus()){
			case "1":
				view = "viewguiaoperada";
				break;
			case "2":
				view = "viewguiaconfirmada";
				break;
			case "3":
				view = "viewguiaconfirmadaconevidencia";
				break;
			/*  PARA GUIAS ASEGURADAS */	
			case "4":
				view = "viewguiaoperadaasegurada";
				break;
			case "5":
				view = "viewguiaconfirmadaasegurada";
				break;
			case "6":
				view = "viewguiaconfirmadaconevidenciaasegurada";
				break;
			/*  					 */	
			default:
				view = "viewguiaoperada";
				break;
		}
		
		String query = "UPDATE cadocumentos SET tipo=?, marcafactura=? WHERE iddocumento IN ( "
				+ " select distinct iddocumento from viewdocumentopendientefacturar " + " where numcliente=?"
						+ " AND estatus!='C' AND " + "  fechacreacion < '"+dia+"' AND iddocumento IN ("
								+ "Select idguia from " + view + ")  ) ";

		logger.debug("Actulizando documento a facturar:" + query);

		try {
			this.jdbcTemplate.update(query, new Object[]{obj.getTipo(),obj.getIdcontrolenvio() ,obj.getCliente()});

		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}

	}
	
	public void updateMarcaFacturaEnDocumentoConsumo(Factura obj) throws Exception {
		// Marca los registros con el idcontrolenvio de la tabla
		// de recumen_factura
		// TODO:VERIFICAR CRITERIO DE MARCADO
		String dia = obj.getDia() + " 00:00:00"; 
		String view = "";
		
		switch(obj.getEstatus()){
			case "1":
				view = "viewguiaoperada";
				break;
			case "2":
				view = "viewguiaconfirmada";
				break;
			case "3":
				view = "viewguiaconfirmadaconevidencia";
				break;
			/*  PARA GUIAS ASEGURADAS */	
			case "4":
				view = "viewguiaoperadaasegurada";
				break;
			case "5":
				view = "viewguiaconfirmadaasegurada";
				break;
			case "6":
				view = "viewguiaconfirmadaconevidenciaasegurada";
				break;
			/*  					 */	
			default:
				view = "viewguiaoperada";
				break;
		}
		
		String query = "UPDATE cadocumentos SET  preciozona=precioconsumo(iddocumento,?) ,"
				+ "marcafactura=? WHERE iddocumento IN ("
				+ "	 SELECT distinct iddocumento FROM viewdocumentopendientefacturar WHERE numcliente=? "
				+ "			AND estatus!='C' AND " + "  fechacreacion < '"+dia+"' AND "
				+ "			idconvenio=? AND iddocumento IN (Select idguia from " + view + ")"
				+ "  ) ";

		logger.debug("Actulizando documento a facturar:" + query);

		try {
			this.jdbcTemplate.update(query, new Object[]{
					obj.getCantidad(),
					obj.getIdcontrolenvio(),
					obj.getCliente(),
					dia,obj.getIdconvenio() });

		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}

	}

	@Override
	public void updateDesmarcaFacturaEnDocumento(Factura obj) throws Exception {
		// Marca los registros con el idcontrolenvio de la tabla de
		// recumen_factura
		String query = "UPDATE cadocumentos SET marcafactura=null WHERE marcafactura=?";

		logger.debug("Query:" + query);
		try {
			this.jdbcTemplate.update(query, new Object[]{obj.getIdcontrolenvio()});

		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.salesmanager.dao.impl.IFacturaResumen#getRegistros(com.
	 * administracion.dto.Factura)
	 */
	@Override
	public List<Factura> getRegistros(Factura obj) throws Exception {
		List<Factura> lista = new ArrayList<Factura>();
		// String sql = "SELECT * FROM factura_resumen WHERE mes=" +
		// obj.getMes() +
		// " AND anio=" + obj.getAnio();

		String sql = "SELECT factura.*,cantidad.cantidad  FROM  (" + "	SELECT * FROM factura_resumen WHERE mes=? AND anio=?)"
				+ " factura LEFT OUTER JOIN ( "
				+ "	select  marcafactura, count( marcafactura) as cantidad  "
				+ "	from viewdocumentomarcafactura  group by  marcafactura "
				+ ") cantidad ON factura.idcontrolenvio  = cantidad.marcafactura ";

		String cliente = obj.getCliente() == null ? "" : obj.getCliente().trim();
		Object[] params = new Object[]{obj.getMes(), obj.getAnio()};
		if (cliente.trim().length() > 0) {
			sql += " WHERE factura.cliente=?";
			params = new Object[]{obj.getMes(), obj.getAnio(),cliente};
		}
		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql,params, new FacturaResumenRowMapper());
		return lista;

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.salesmanager.dao.impl.IFacturaResumen#getRegistros(com.
	 * administracion.dto.Factura)
	 */
	@Override
	public List<FacturaGuia> getRegistrosGuias(Factura obj) throws Exception {
		List<FacturaGuia> lista = new ArrayList<FacturaGuia>();
		// String sql = "SELECT * FROM factura_resumen WHERE mes=" +
		// obj.getMes() +
		// " AND anio=" + obj.getAnio();

		String sql = "SELECT f.razonsocial, a.iddocumento, c.min :: date as fecha, c.tipo, a.referencia, h.cofecha :: date as fechaentrega, " + 
						"a.factura, a.isfacturada, a.estatus, e.nombre as tiposervicio, a.marcafactura, a.zonaori, a.zonades, " +
						"idzonaventa as Zonaventa, a.largo, a.ancho, a.alto, a.pesofisico,a.pesovolumetrico,b.precio, g.dia as fechacorte " +
						"FROM public.viewdocumentomarcafactura a " +
						"left join documento_pesokm_max_amparados b ON a.iddocumento = b.iddocumento " +
						"left join caconveniodetalle i ON b.idconveniodetalle= i.idconveniodetalle " +
						"left join viewfechaprimermovimientohistoria3 c ON a.iddocumento = c.idguia " +
						"left join cazonaventa d ON a.zonaori || a.zonades = d.idzonaventaori || d.idzonaventades " +
						"left join catiposervicio e ON a.idservicio = e.idservicio " +
						"left join caclientesrfc f ON a.numcliente = f.numcliente " +
						"left join factura_resumen g ON a.marcafactura=g.idcontrolenvio " +
						"left join confirma h ON h.idguia = a.iddocumento " +
						"where g.idcontrolenvio =? ";

		Object[] params = null;
		params = new Object[]{obj.getIdcontrolenvio()};
		
		/*if(obj.getTipoB().equals("1")){ // Fecha de corte
			params = new Object[]{obj.getIdcontrolenvio()};
		}else{ //IDGuia
			sql += "AND a.iddocumento = ? ";
			params = new Object[]{obj.getIdcontrolenvio(), obj.getT_txt_oper()};
		}
		
		if(obj.getEstatus().equals("2")){
			sql += "AND h.cofecha IS NOT NULL";
		}else if (obj.getEstatus().equals("3")){
			sql += "AND a.iddocumento IN (SELECT ca1.identificador " +
					"FROM caattachdocumento AS ca1 " +
					"RIGHT OUTER JOIN " +
					"	(SELECT identificador, max(fecha) AS fecha FROM caattachdocumento " + 
					"	WHERE identificador IN (a.iddocumento) AND descripcion IN ('FIRMA ENTREGA', 'FIRMA DE RECIBIDO') " +
					"	GROUP BY identificador) AS ca2 " +
					"ON ca1.identificador = ca2.identificador AND ca1.fecha = ca2.fecha " +
					"ORDER BY ca2.fecha DESC) ";
		}*/
		
		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql,params, new FacturaGuiaRowMapper());
		return lista;

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.salesmanager.dao.impl.IFacturaResumen#getRegistros(com.
	 * administracion.dto.Factura)
	 */
	@Override
	public JsonObject generaExcel(Factura obj) throws Exception {
		List<FacturaGuia> lista = new ArrayList<FacturaGuia>();
		JsonObject jsonGuias = new JsonObject();
		String sql = "";
		JsonElement nodesElement = null;
		Object[] params = null;
		params = new Object[]{obj.getIdcontrolenvio()};
	
		//Guias Servicios
		sql = "SELECT f.razonsocial, a.iddocumento, c.min :: date as fecha, c.tipo, a.referencia, h.cofecha :: date as fechaentrega, " + 
						"a.factura, a.isfacturada, a.estatus, e.nombre as tiposervicio, a.marcafactura, a.zonaori, a.zonades, " +
						"idzonaventa as Zonaventa, a.largo, a.ancho, a.alto, a.pesofisico,a.pesovolumetrico,b.precio, g.dia as fechacorte " +
						"FROM public.viewdocumentomarcafactura a " +
						"left join documento_pesokm_max_amparados b ON a.iddocumento = b.iddocumento " +
						"left join caconveniodetalle i ON b.idconveniodetalle= i.idconveniodetalle " +
						"left join viewfechaprimermovimientohistoria3 c ON a.iddocumento = c.idguia " +
						"left join cazonaventa d ON a.zonaori || a.zonades = d.idzonaventaori || d.idzonaventades " +
						"left join catiposervicio e ON a.idservicio = e.idservicio " +
						"left join caclientesrfc f ON a.numcliente = f.numcliente " +
						"left join factura_resumen g ON a.marcafactura=g.idcontrolenvio " +
						"left join confirma h ON h.idguia = a.iddocumento " +
						"where g.idcontrolenvio = ? ";

		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql,params, new FacturaGuiaRowMapper());
		nodesElement = new Gson().toJsonTree(lista);
		jsonGuias.add("guias", nodesElement);
		
		/* GUIAS ASEGURADAS */
		
		sql ="SELECT f.razonsocial, a.iddocumento, c.min :: date as fecha, c.tipo, a.referencia, h.cofecha :: date as fechaentrega, " +
					    "e.nombre as tiposervicio, a.marcafactura, a.zonaori, a.zonades, idzonaventa as Zonaventa, a.largo, a.ancho, a.alto, " +
					    "a.pesofisico,a.pesovolumetrico,b.precio, g.dia as fechacorte, a.contenido, (SELECT DISTINCT precio_seguro FROM cadocumentos WHERE iddocumento = a.iddocumento) AS valorasegurado " +
					    "FROM public.viewdocumentomarcafactura a " +
						"left join documento_pesokm_max_amparados b ON a.iddocumento = b.iddocumento " +
						"left join caconvenio o ON b.idconvenio = o.idconvenio " +
						"left join caconveniodetalle i ON o.idconvenio = i.idconvenio " +
						"left join viewfechaprimermovimientohistoria3 c ON a.iddocumento = c.idguia " +
						"left join cazonaventa d ON a.zonaori || a.zonades = d.idzonaventaori || d.idzonaventades " +
						"left join catiposervicio e ON a.idservicio = e.idservicio " +
						"left join caclientesrfc f ON a.numcliente = f.numcliente " +
						"left join factura_resumen g ON a.marcafactura = g.idcontrolenvio " +
						"left join confirma h ON h.idguia = a.iddocumento " +
						"where g.idcontrolenvio = ? AND o.asegura = 1 AND a.ciaseguro !=''";
		
		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql,params, new FacturaGuiaRowMapper());
		nodesElement = new Gson().toJsonTree(lista);
		jsonGuias.add("aseguradas", nodesElement);
		
		/* FIN GUIAS ASEGURADAS */
		
		/*Guias adicionales antiguas
		sql = "SELECT cadocumentos.iddocumento, cadocumentos.numcliente, movimientos.exclave, movimientos.fechaevento, " +
						"caadicional.descripcion, caadicional.precio " +
						"FROM cadocumentos " +
						"INNER JOIN movimientos ON cadocumentos.iddocumento = movimientos.idguia " +
						"INNER JOIN caadicional ON caadicional.idadicional = movimientos.exclave " +
						"WHERE cadocumentos.marcafactura = ? " +
						"AND movimientos.exclave IN (SELECT DISTINCT sapmateriales.clave FROM sapmateriales)"; */
		
		/*CAMBIO MANIOBRAS CITAS EVIDENCIAS*/
		sql = "((SELECT cadocumentos.iddocumento, cadocumentos.numcliente, movimientos.exclave, movimientos.fechaevento, " +
				"caadicional.descripcion, caadicional.precio " +
				"FROM cadocumentos " +
				"INNER JOIN movimientos ON cadocumentos.iddocumento = movimientos.idguia " +
				"INNER JOIN caadicional ON caadicional.idadicional = movimientos.exclave " +
				"WHERE cadocumentos.marcafactura =  ? " +
				"AND movimientos.exclave IN (SELECT DISTINCT sapmateriales.clave FROM sapmateriales)) " +
				"UNION " +
				"(SELECT cadocumentos.iddocumento, cadocumentos.numcliente, cadocumentoadicionales.idclaveadicional AS exclave, cadocumentoadicionales.fechacreacion AS fechaevento, " +
				"cadocumentoadicionales.descripcion, cadocumentoadicionales.precio " +
				"FROM cadocumentos " +
				"INNER JOIN cadocumentoadicionales ON cadocumentos.iddocumento = cadocumentoadicionales.iddocumento " +
				"WHERE cadocumentos.marcafactura = '" + obj.getIdcontrolenvio() + "' "  +
				"AND cadocumentoadicionales.idclaveadicional IN (SELECT DISTINCT sapmateriales.clave FROM sapmateriales))) ORDER BY iddocumento DESC";
		/* FIN CAMBIO */
		
		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql,params, new FacturaGuiaRowMapper());
		nodesElement = new Gson().toJsonTree(lista);
		jsonGuias.add("adicionales", nodesElement);
		
		//Guias servicios especiales
		sql = "SELECT a.idcontrol, b.idmaterial, c.nombre, c.descripcion, b.observacion, b.cantidad, b.precio, " +
						"(b.cantidad * b.precio) as subtotal " +
						"FROM factura_resumen a " +
						"INNER JOIN factura_cobroespecial b ON a.idcontrol= b.idcontrol " +
						"INNER JOIN sapmaterial_especial c ON c.idmaterial = b.idmaterial " +
						"WHERE a.idcontrolenvio = ? ";

		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql,params, new FacturaGuiaRowMapper());
		nodesElement = new Gson().toJsonTree(lista);
		jsonGuias.add("servicios", nodesElement);
		
		//Guias sobrepesos
		sql = "SELECT a.iddocumento, peso_amparado, peso_max_cliente, peso_max_medido, peso_max_calculado, " +
						"precio_kg_sp, kg_sobprepeso as kg_sobrepeso, monto_sobrepeso " +
						"FROM public.viewdocumentomarcafactura a " +
						"INNER JOIN viewfechaprimermovimientohistoria3 c ON a.iddocumento = c.idguia " +
						"INNER JOIN view_sobrepeso b ON a.iddocumento = b.iddocumento " +
						"INNER JOIN factura_resumen g ON a.marcafactura=g.idcontrolenvio " + 
						"WHERE g.idcontrolenvio = ? ";

		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql,params, new FacturaGuiaRowMapper());
		nodesElement = new Gson().toJsonTree(lista);
		jsonGuias.add("sobrepesos", nodesElement);
		
		//Guias Re expedicion
		sql = "SELECT cadocumentos.iddocumento, cadocumentos.numcliente, cadocumentos.zonaori, cadocumentos.zonades, cadireccionesdocumento.cp as cp, " +
						"(SELECT descripcion FROM caadicional WHERE idadicional='B59'), " +
						"(SELECT precio FROM caadicional WHERE idadicional='B59') AS precio " +
//						"(SELECT precio FROM caadicional WHERE idadicional='B59') AS precio_reexpedcion " +
						"FROM cadocumentos " +
						"INNER JOIN cadireccionesdocumento ON cadocumentos.iddocumento = cadireccionesdocumento.iddocumento " +
						"AND cadireccionesdocumento.idtipodireccion='D' " +
						"WHERE cadocumentos.marcafactura = ? AND cp IN (SELECT d_codigo FROM view_cp_reexpedicion)"; 

		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql,params, new FacturaGuiaRowMapper());
		nodesElement = new Gson().toJsonTree(lista);
		jsonGuias.add("reexpedicion", nodesElement);
		
		sql = " SELECT DISTINCT m.iddocumentomadre as iddocumento, " +
			 "e.nombre as tiposervicio, " + 
			 "('VARIOS')referencia, " + 
			 "h.cofecha :: date as fechaentrega, " + 
			 "m.zonaori, " + 
			 "m.zonades, " + 
			 "idzonaventa as Zonaventa, " +
			 "(SELECT COUNT(CA.iddocumentomadre) FROM CADOCUMENTOS CA WHERE IDDOCUMENTOMADRE = m.iddocumentomadre):: NUMERIC AS precio " +
			 "FROM cadocumentos AS m " +
			 "LEFT JOIN cadireccionesdocumento ON m.iddocumento::text = cadireccionesdocumento.iddocumento::text AND cadireccionesdocumento.idtipodireccion::text = 'D'::text " +
			 "left join documento_pesokm_max_amparados b ON m.iddocumento = b.iddocumento " +
			 "left join cazonaventa d ON m.zonaori || m.zonades = d.idzonaventaori || d.idzonaventades " + 
			 "left join catiposervicio e ON m.idservicio = e.idservicio " + 
			 "left join factura_resumen g ON m.marcafactura=g.idcontrolenvio " + 
			 "left join confirma h ON h.idguia = m.iddocumento " + 
			 "WHERE m.marcafactura IS NOT NULL AND m.estatus::text = 'A'::text AND g.idcontrolenvio = ? AND coalesce(TRIM(m.iddocumentomadre), '') != '' " +
			 "ORDER BY m.iddocumentomadre DESC";
 
		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql,params, new FacturaGuiaRowMapper());
		nodesElement = new Gson().toJsonTree(lista);
		jsonGuias.add("madre", nodesElement);
		
		
		List<FacturaGuia> listaCuerpo = new ArrayList<FacturaGuia>();
		/*RECORREMOS LA ULTIMA LISTA QUE ENESTE CASO TIEN LOS DATOS DE GUIA MADRE
		 * PARA PODER SACAR LAS GUIAS QUE AMPARA CADA GUIA MADRE*/
		for(int i = 0; i < lista.size(); i++){
			
			/* Parametros Finales */
			params = new Object[]{lista.get(i).getIddocumento()}; 
			
			/* Guias Madre Cuerpo Final */
		   sql=  "SELECT m.iddocumento, " + 
				   "e.nombre as tiposervicio, " + 
				   "m.referencia, " + 
				   "h.cofecha :: date as fechaentrega, " + 
				   "m.zonaori, " + 
				   "m.zonades, " + 
				   "idzonaventa as Zonaventa, " +
				   "m.largo, " + 
				   "m.ancho, " + 
				   "m.alto, " + 
				   "m.pesofisico, " +  
				   "b.precio " +
				   "FROM cadocumentos AS m " +
				   "LEFT JOIN cadireccionesdocumento ON m.iddocumento::text = cadireccionesdocumento.iddocumento::text AND cadireccionesdocumento.idtipodireccion::text = 'D'::text " +
				   "left join documento_pesokm_max_amparados b ON m.iddocumento = b.iddocumento " +
				   "left join cazonaventa d ON m.zonaori || m.zonades = d.idzonaventaori || d.idzonaventades " + 
				   "left join catiposervicio e ON m.idservicio = e.idservicio " + 
				   "left join factura_resumen g ON m.marcafactura=g.idcontrolenvio " + 
				   "left join confirma h ON h.idguia = m.iddocumento " + 
				   "WHERE m.marcafactura IS NOT NULL AND m.estatus::text = 'A'::text AND m.iddocumentomadre = ? ";
			
			logger.debug("Query:" + sql);
			listaCuerpo = jdbcTemplate.query(sql,params, new FacturaGuiaRowMapper());
			nodesElement = new Gson().toJsonTree(listaCuerpo);
			jsonGuias.add("body"+(i+1), nodesElement);
		}
		
		return jsonGuias;

	}

	@Override
	public Factura getRegistroById(Factura obj) throws Exception {
		List<Factura> lista = new ArrayList<Factura>();

		String sql = "SELECT factura.*,cantidad.cantidad  FROM  (" + "	SELECT * FROM factura_resumen WHERE idcontrol= ?)"
				+ " factura LEFT OUTER JOIN ( "
				+ "	select  marcafactura, count( marcafactura) as cantidad  "
				+ "	from viewdocumentomarcafactura  group by  marcafactura "
				+ ") cantidad ON factura.idcontrolenvio  = cantidad.marcafactura ";

		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql, new Object[]{obj.getIdcontrol()}, new FacturaResumenRowMapper());
		if (lista.size() > 0) {
			return lista.get(0);
		}
		return null;

	}

	@Override
	public List<LineaFacturaSAP> getLineas(String marcafactura) throws Exception {
		List<LineaFacturaSAP> lista = new ArrayList<LineaFacturaSAP>();
		String sql = "SELECT row_number() OVER (ORDER BY  idservicio, materialsap,cebe) as row_number, * "
				+ "  FROM viewlineasfacturasap WHERE marcafactura=?";
		logger.debug("query:" + sql);
		lista = jdbcTemplate.query(sql,new Object[]{marcafactura}, new LineaFacturaSAPRowMapper());
		return lista;
	}

	/**
	 * Agrupación de lineas ya facturadas
	 * 
	 * @param marcafactura
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LineaFacturaSAP> getLineasFacturadas(String marcafactura) throws Exception {
		List<LineaFacturaSAP> lista = new ArrayList<LineaFacturaSAP>();
		String sql = "SELECT row_number() OVER (ORDER BY  idservicio, materialsap,cebe) as row_number, * "
				+ "  FROM viewlineasfacturasap WHERE marcafactura=?";
		logger.debug("query:" + sql);
		lista = jdbcTemplate.query(sql, new Object[]{marcafactura}, new LineaFacturaSAPRowMapper());
		return lista;
	}

	@Override
	public CuentasDTO getDatosCliente(String numcliente) throws Exception {
		List<CuentasDTO> lista = new ArrayList<CuentasDTO>();
		String sql = "SELECT * FROM caclientesrfc WHERE numcliente = ?";
		logger.debug("Query:" + sql);
		lista = jdbcTemplate.query(sql, new Object[]{numcliente}, new CuentasClienteRowMapper());
		if (lista.size() > 0) {
			return lista.get(0);
		}

		return null;
	}

	@Override
	public LineaFacturaSAP getParametroGeneraFactura(String p_proceso, String p_tipo) throws Exception {
		List<LineaFacturaSAP> lista = new ArrayList<LineaFacturaSAP>();
		String sql = "SELECT * FROM sapparametros WHERE p_proceso=? AND p_tipo=? ";

		lista = jdbcTemplate.query(sql, new Object[]{p_proceso,p_tipo},  new LineaFacturaSAPRowMapper());
		if (lista.size() > 0) {
			return lista.get(0);
		}
		return null;
	}

	@Override
	public int cantidadRegistrosAMarcar(Factura obj) throws Exception {
		//Registos de forma de pago diferente a consumo
		String dia =obj.getDia() + " 00:00:00";
		String view = "";
		
		switch(obj.getEstatus()){
			case "1":
				view = "viewguiaoperada";
				break;
			case "2":
				view = "viewguiaconfirmada";
				break;
			case "3":
				view = "viewguiaconfirmadaconevidencia";
				break;
			/*  PARA GUIAS ASEGURADAS */	
			case "4":
				view = "viewguiaoperadaasegurada";
				break;
			case "5":
				view = "viewguiaconfirmadaasegurada";
				break;
			case "6":
				view = "viewguiaconfirmadaconevidenciaasegurada";
				break;
			/*  					 */	
			default:
				view = "viewguiaoperada";
				break;
		}
		
		String query = " select count(iddocumento) as cantidad from viewdocumentopendientefacturar "
				+ " where numcliente=? AND estatus!='C' AND  fechacreacion < '" +dia+"' AND"
						+ "  iddocumento IN (SELECT idguia  FROM " + view + ") AND "
						+ " idconvenio IN (SELECT idconvenio FROM viewconvenios where idformapago!=4)";
		logger.debug("cantidadRegistrosAMarcar Query:" + query);
		List<Factura> lista = jdbcTemplate.query(query,new Object[]{obj.getCliente()},  new FacturaResumenRowMapper());
		return lista.get(0).getCantidad();
	}

	@Override
	public List<FacturaDetalle> cantidadRegistrosAMarcarConsumo(Factura obj)throws Exception{
		//Registos de forma de pago de consumo
		String dia =obj.getDia() + " 00:00:00";
		String view = "";
		
		switch(obj.getEstatus()){
			case "1":
				view = "viewguiaoperada";
				break;
			case "2":
				view = "viewguiaconfirmada";
				break;
			case "3":
				view = "viewguiaconfirmadaconevidencia";
				break;
			/*  PARA GUIAS ASEGURADAS */
			case "4":
				view = "viewguiaoperadaasegurada";
				break;
			case "5":
				view = "viewguiaconfirmadaasegurada";
				break;
			case "6":
				view = "viewguiaconfirmadaconevidenciaasegurada";
				break;
			/*  					 */	
			default:
				view = "viewguiaoperada";
				break;
		}
		
		String query = "SELECT distinct cadocumentos.idconvenio, cadocumentos.numcliente,count(caconvenio.idconvenio) as cantidad   "+
		" FROM cadocumentos JOIN  "+
		"  caconvenio ON cadocumentos.idconvenio=caconvenio.idconvenio AND "+
		"  caconvenio.numcliente = cadocumentos.numcliente "+
		"  WHERE cadocumentos.estatus!='C' AND   "+
		"  cadocumentos.marcafactura IS NULL AND cadocumentos.ordernumbersap IS NULL AND  "
		+ "cadocumentos.idconvenio IN (SELECT idconvenio FROM viewconvenios where idformapago=4) AND "
		+ "  fechacreacion < '" +dia+"' AND "
 		+ "cadocumentos.numcliente = ? AND caconvenio.numcliente = ? AND"
 				+ "  iddocumento IN (Select idguia from " + view + ") "+
	 		"group by cadocumentos.idconvenio, cadocumentos.numcliente";
	
		logger.debug("cantidadRegistrosAMarcarConsumo Query:" + query);
		//"  and cadocumentos.iddocumento NOT IN (SELECT idguia  FROM viewguiaoperada)"+
		List<FacturaDetalle> lista = jdbcTemplate.query(query,new Object[]{obj.getCliente(),obj.getCliente()},new FacturaResumenDetalleRowMapper());
		return lista;
	}

	@Override
	public int cantidadRegistrosMarcados(Factura obj) throws Exception {
		String query = " select count(iddocumento) as cantidad " + " FROM viewdocumentomarcafactura WHERE "
				+ "marcafactura=?";

		List<Factura> lista = jdbcTemplate.query(query,new Object[]{obj.getIdcontrolenvio()}, new FacturaResumenRowMapper());
		return lista.get(0).getCantidad();
	}

	@Override
	public void insert(FacturaDetalle obj) throws Exception {
		String query = "INSERT INTO factura_resumen_detalle(idfactura, idconvenio, cantidad, precio,fecha) "
				+ " VALUES (:idfactura, :idconvenio, :cantidad, :precio,current_timestamp)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		logger.debug("Query:" + query);
		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}

	}
	
}
