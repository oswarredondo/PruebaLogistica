package com.administracion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
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

import com.administracion.dto.CotizacionLineaVolumen;
import com.administracion.dto.CotizacionTarifa;
import com.administracion.idao.ICotizadorDAO;
import com.administracion.rowmapper.RemDesRowMapper;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.mappers.CotizaTarifaRowMapper;
import com.innovargia.salesmanager.mappers.TarifaCotizadaRowMapper;
import com.servicio.constantes.ConstantesGenerales;

@Repository
public class CotizadorDAO extends JdbcDaoSupport implements ICotizadorDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(CotizadorDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CotizadorDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CotizacionTarifa> getCotizacionesTarifa(CotizacionTarifa tarifa) throws DataAccessException {
		
		String sql ="SELECT * FROM ("+
			" SELECT * , :cporigen as cporigen, :cpdestino as cpdestino,:cantidadenvios as cantidadenvios,"
			+ " :pesoamparado as pesoamparado"
				+ ",(select sum(precio) from caadicional where tipo=1) as precioadicional,"
			+ "precio1*:cantidadenvios as totalprecioenvios,"
			+ " ( case  when (:pesoamparado-pesofinal1)>0  then (:pesoamparado-pesofinal1) else 0 end) as  sobrepeso,"
			+ " ( case  when (:pesoamparado-pesofinal1)>0  then ((:pesoamparado-pesofinal1)*preciokgsp1) else 0 end) as totalsobrepeso"
			+ "   FROM cotizadorservicios(:cporigen , :cpdestino, :cantidadenvios,:pesoamparado)"
			+ ") a where (a.kilometros1-a.kminicial1)>=0 AND (a.kmfinal1-a.kilometros1)>=0 ";
		  
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(tarifa);
		
		logger.debug("En getTarifas:" + sql);
		
		List<CotizacionTarifa> lista = this.namedParameterJdbcTemplate.query(sql,parameterSource, new CotizaTarifaRowMapper());
		return lista;
	}
	
	@Override
	public List<CotizacionTarifa> getLineaCotizacionesTarifa(CotizacionTarifa tarifa,
		CotizacionLineaVolumen linea) throws Exception {
		
		String sql ="SELECT tarifarangopeso.idtarifa as idtarifa1,idrangoenvios as idrangoenvios1,"
			+ " idtarifapeso as idtarifapeso1, "
			+ " tarifaserviciozona.idserviciotarifazona as idserviciotarifazona1,nombre as nombre1,"
			+ " descripcion as descripciontarifa1, garantia,idrangoinicial as idrangoinicial1, "
			+ " idrangofinal as idrangofinal1,pesoinicial as pesoinicial1, "
			+ " pesofinal as pesofinal1,kilometros as kilometros1,"
			+ " tarifaserviciozona.zona as zona1,kminicial as kminicial1, kmfinal as kmfinal1 , "
			+ " tarifaserviciozona.precio as precio1, tarifaserviciozona.preciokgsp as preciokgsp1,"
			+ " (kilometros/precio) as preciounitarioporkm1,getdescripciongarantia(garantia) as descripciongarantiamaxima  "
			+ "	FROM ("
			+ "		SELECT tarifarango.*,tarifapesorango.idtarifapeso,"
			+ "		tarifapesorango.pesoinicial, tarifapesorango.pesofinal,:kilometros()  as kilometros  FROM ("
				+ "			select tarifa.*,substring(tarifa.idservicio from 1 for 1) as garantia,"
				+ "			rango.idrangoenvios, rango.idrangoinicial,rango.idrangofinal  "
				+ "			from catarifas tarifa  LEFT OUTER JOIN ("
				+ "				SELECT * FROM ("
				+ "				SELECT idtarifa, idrangoenvios,idrangoinicial ,idrangofinal FROM"
				+ "					catarifarangosenvios WHERE idtarifa = :idtarifa)query "
							+ "	) rango ON tarifa.idtarifa = rango.idtarifa  WHERE tarifa.idtarifa=:idtarifa"
								+ "	)tarifarango LEFT OUTER JOIN ("
								+ "	SELECT idrangoenvios,idtarifapeso, pesoinicial, pesofinal FROM"
								+ "	catarifapeso WHERE idrangoenvios = :idrangoenvios " 
								+")tarifapesorango ON tarifarango.idrangoenvios=tarifapesorango.idrangoenvios"
								+ ") tarifarangopeso LEFT OUTER JOIN("
								+ "	SELECT idserviciotarifa,idserviciotarifazona, zona, kminicial,  "
								+ "	kmfinal, precio, preciokgsp FROM"
								+ "	catarifaserviciozona WHERE idserviciotarifa  IN ("
								+ "	SELECT idtarifapeso FROM catarifapeso  where estatus=1) "
								+ ")tarifaserviciozona ON tarifarangopeso.idtarifapeso = tarifaserviciozona.idserviciotarifa "
								+ "	WHERE COALESCE(idrangoenvios,-1)>-1 and estatus=1 AND fechafinal>=current_date "
								+ " and tarifaserviciozona.kmfinal>= :kilometros "
								+" AND idserviciotarifazona=:idserviciotarifazona";
		  
		logger.debug("En getTarifas:" + sql);
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(tarifa);
		List<CotizacionTarifa> lista = this.namedParameterJdbcTemplate.query(sql, parameterSource, new CotizaTarifaRowMapper());
		return lista;
	}
	
	@Override
	public List<CotizacionTarifa> getTarifasContado(CotizacionTarifa tarifa) throws DataAccessException {
		
		String sql ="select idtarifa as idtarifa1, "
			+ " caservicio.descripcion as nombre1,  "
			+ "'[' || caservicio.idservicio || '-' || "
			+ " caservicio.descripcion || ']' || ' ' || "
			+ " catarifas.nombre as descripciontarifa1, "
			+ " catarifas.idservicio as idserviciotarifa1  "
			+ " from catarifas LEFT OUTER JOIn catiposervicio as caservicio ON"
			+ " catarifas.idservicio=caservicio.idservicio where es_visible_pdv=1 AND "
			+ " current_date>=fechainicial ANd current_date<=fechafinal AND "
			+ " catarifas.estatus=1 AND idformapago IN (?)";
		  
		logger.debug("En getTarifasContado:" + sql);
		
		List<CotizacionTarifa> lista = jdbcTemplate.query(sql, 
				new Object[]{ConstantesGenerales.TIPO_ROTULACION_CONTADO}, 
				new CotizaTarifaRowMapper());
		return lista;
	}
	
	@Override
	public List<CotizacionTarifa> getTarifasFXC(CotizacionTarifa tarifa) 
			throws DataAccessException {
		
		String sql ="select idtarifa as idtarifa1, "
			+ " caservicio.descripcion as nombre1,  "
			+ "'[' || caservicio.idservicio || '-' || "
			+ " caservicio.descripcion || ']' || ' ' || "
			+ " catarifas.nombre as descripciontarifa1, "
			+ " catarifas.idservicio as idserviciotarifa1  "
			+ " from catarifas LEFT OUTER JOIn catiposervicio as caservicio ON"
			+ " catarifas.idservicio=caservicio.idservicio where es_visible_pdv=1 AND "
			+ " current_date>=fechainicial ANd current_date<=fechafinal AND "
			+ " catarifas.estatus=1 AND idformapago IN (?)";
		  
		logger.debug("En getTarifasContado:" + sql);
		
		List<CotizacionTarifa> lista = jdbcTemplate.query(sql, 
				new Object[]{ConstantesGenerales.TIPO_ROTULACION_FXC},
				new CotizaTarifaRowMapper());
		return lista;
	}
	
	@Override
	public List<CotizacionTarifa> getTarifasPrepagado(CotizacionTarifa tarifa) throws DataAccessException {

		String sql ="select idtarifa as idtarifa1, "
			+ " caservicio.descripcion as nombre1,  "
			+ "'[' || caservicio.idservicio || '-' || "
			+ " caservicio.descripcion || ']' || ' ' || "
			+ " catarifas.nombre as descripciontarifa1, "
			+ " catarifas.idservicio as idserviciotarifa1,  catarifas.idservicio "
			+ " from catarifas LEFT OUTER JOIn catiposervicio as caservicio ON"
			+ " catarifas.idservicio=caservicio.idservicio where es_visible_pdv=1 AND "
			+ " current_date>=fechainicial ANd current_date<=fechafinal AND "
			+ " catarifas.estatus=1 AND idformapago IN (?)";
		  
		logger.debug("En getTarifasPrepagado:" + sql);
		
		List<CotizacionTarifa> lista = jdbcTemplate.query(sql, 
				new Object[]{ConstantesGenerales.TIPO_ROTULACION_PREPAGADO},
				new CotizaTarifaRowMapper());
		return lista;
	}
	
	@Override
	public List<CotizacionTarifa> getFiltraTarifas(CotizacionTarifa tarifa) throws Exception {

		String sql ="select idtarifa as idtarifa1, "
			+ " caservicio.descripcion as nombre1,  "
			+ "'[' || caservicio.idservicio || '-' || "
			+ " caservicio.descripcion || ']' || ' ' || "
			+ " catarifas.nombre as descripciontarifa1, "
			+ " catarifas.idservicio as idserviciotarifa1  "
			+ " from catarifas LEFT OUTER JOIn catiposervicio as caservicio ON"
			+ " catarifas.idservicio=caservicio.idservicio where es_visible_pdv=1 AND "
			+ " current_date>=fechainicial ANd current_date<=fechafinal AND "
			+ " catarifas.estatus=1 AND idformapago IN (? ) AND "
					+ "catarifas.idservicio IN (?)";
		  
		logger.debug("En getFiltraTarifas:" + sql);
		
		List<CotizacionTarifa> lista = jdbcTemplate.query(sql,  
				new Object[]{tarifa.getIdtipoventa(), tarifa.getIdservicio()},
				new CotizaTarifaRowMapper());
		return lista;
	}
	
	@Override
	public List<CotizacionTarifa> getFiltraConveniosContado(CotizacionTarifa tarifa) throws Exception {
		  
		
		String sql = "SELECT 'CONVENIO' AS tipoRotulacion,idconveniodetalle,convenios.numcliente,convenios.idconvenio || '-' || convenios.idtarifa ||'-' "
		+ "	|| idconveniodetalle || '-'||  catarifas.idservicio  as idservicio, convenios.idtarifa as idtarifa1, "
		+ " 	catarifas.nombre || '-' || catarifas.idservicio || '[Peso:' || peso || ',Cob. Km:' || coberturakm || ',"
		+ "  Precio:$'||precio || ']' as descripciontarifa1, idconvenio   FROM (" 
		+ " 			select idconveniodetalle, caconvenio.numcliente,caconvenio.idtarifa,caconveniodetalle.idconvenio, "
		+ "  			caconveniodetalle.peso, caconveniodetalle.precio,caconveniodetalle.sobrepeso, "
		+ "  			caconveniodetalle.coberturakm from  caconveniodetalle left outer join caconvenio "
		+ "  			ON caconveniodetalle.idconvenio = caconvenio.idconvenio where "
		+ "  			  current_date>=caconvenio.fechainicio   and current_date<=caconvenio.fechatermino  "
		+ "  			AND caconvenio.estatus IN ( 40	 ) AND caconvenio.idconvenio IN ( "
		+ "  					select caconvenio.idconvenio "
		+ "					from caconvenio join caclientefacturacion on caconvenio.idcliente = caclientefacturacion.idcliente "
		+ "					where caconvenio.idcliente != -1 and caclientefacturacion.rfc=?"
		+ "  					) "
		+ "  			) convenios left outer join catarifas on convenios.idtarifa = catarifas.idtarifa where idformapago=?"
		+ " AND  catarifas.idservicio=?";
		  
		logger.debug("En getFiltraTarifas:" + sql);
		
		List<CotizacionTarifa> lista = jdbcTemplate.query(sql,
				new Object[]{tarifa.getContrato(),tarifa.getFormapago(),tarifa.getIdservicio()},
				new CotizaTarifaRowMapper());
		return lista;
		
	}
	
	@Override
	public List<CotizacionTarifa> getRangosKMTarifa(CotizacionTarifa tarifa)
			throws SQLException {

		String sql =
				"SELECT catarifaserviciozona.* FROM catarifaserviciozona join ( "+
				"		SELECT b.* FROM  ( "+
				"			select * from   catarifarangosenvios where idrangoenvios = ? "+
				"		) a LEFT OUTER JOIN ( "+
				"			SELECT * FROM catarifapeso where idrangoenvios =?"+ 
				"				and pesoinicial<= ?" + 
				"     			and pesofinal>=?"+ " order by pesoinicial limit 1 "+
				"		) b ON a.idrangoenvios = b.idrangoenvios "+
				"	) c  ON catarifaserviciozona.idserviciotarifa = c.idtarifapeso order by kminicial";
				
				
		  
		logger.debug("En getRangosKMTarifa:" + sql);
		
		List<CotizacionTarifa> lista = jdbcTemplate.query(sql,
				new Object[]{tarifa.getIdtarifa(),tarifa.getIdtarifa(),tarifa.getPesofinal(),tarifa.getPesofinal()},
				new CotizaTarifaRowMapper());
		return lista;
	}
	@Override
	public List<CotizacionTarifa> getRangosEnviosTarifa(CotizacionTarifa tarifa)
			throws SQLException {

		String sql =
				"select idtarifa as idtarifa1,"
				+ "idrangoenvios as idrangoenvios1,nombre as nombre1,"
				+ "idrangoinicial as idrangoinicial1,"
				+ "idrangofinal as idrangofinal1 "
				+ " from catarifarangosenvios where idtarifa =?" ;
		logger.debug("En getRangosKMTarifa:" + sql);
		
		List<CotizacionTarifa> lista = jdbcTemplate.query(sql,new Object[]{tarifa.getIdtarifa()}, new CotizaTarifaRowMapper());
		return lista;
	}
	@Override
	public List<CotizacionTarifa> getRangosEnviosConvenio(CotizacionTarifa tarifa)
			throws SQLException {

		String sql =
				"select idtarifa as idtarifa1,"
				+ "idrangoenvios as idrangoenvios1,nombre as nombre1,"
				+ "idrangoinicial as idrangoinicial1,"
				+ "idrangofinal as idrangofinal1  from catarifarangosenvios  "
				+ " where idrangoenvios IN (select distinct idrangoenvios "
				+ "	from caconveniodetalle  where idconvenio =?)";
		logger.debug("En getRangosKMTarifa:" + sql);
		
		List<CotizacionTarifa> lista = jdbcTemplate.query(sql,new Object[]{tarifa.getIdconvenio()}, new CotizaTarifaRowMapper());
		return lista;
	}
	
	
	@Override
	public List<RemDes> getClientesConvenios(BusquedaDTO busqueda)
			throws SQLException {
		String sql ="select distinct caconvenio.idconvenio as contrato,caconvenio.idcliente,"
				+ "caclientefacturacion.numcliente, "
				+ "caclientefacturacion.descripcion as razonsocial,"
				+ "caclientefacturacion.rfc "
				+ "  from caconvenio join caclientefacturacion "
				+ " on caconvenio.idcliente = caclientefacturacion.idcliente "
				+ "  where caconvenio.idcliente != -1 and ";
		if ("rfc".equals(busqueda.getTipo_str())){
			sql += " caclientefacturacion.rfc LIKE ?";
		}else if ("nombre".equals(busqueda.getTipo_str())){
			sql += " caclientefacturacion.descripcion LIKE ?";
		}else if ("contrato".equals(busqueda.getTipo_str())){
			sql += " caconvenio.idconvenio = ?";
		}else{
			return new ArrayList<RemDes>();
		}
		
		
		logger.debug("En getClientesConvenios:" + sql);
		
		List<RemDes> lista = jdbcTemplate.query(sql,new Object[]{busqueda.getPatron_busqueda()+"%"}, new RemDesRowMapper());
		return lista;
	}
	@Override
	public CotizacionTarifa getTarifa(CotizacionTarifa tarifa) throws DataAccessException {

		String sql ="select * from catarifas where idtarifa=?" ;
		  
		logger.debug("En getTarifas:" + sql);
		
		List<CotizacionTarifa> lista = jdbcTemplate.query(sql,new Object[]{tarifa.getIdtarifa()}, new TarifaCotizadaRowMapper());
		if (lista.size()>0){
		    return lista.get(0);
		}
		
		return null;
	}
}
