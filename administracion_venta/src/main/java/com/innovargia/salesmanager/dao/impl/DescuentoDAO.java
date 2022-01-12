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
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DescuentoDTO;
import com.innovargia.salesmanager.idao.IDescuentoDAO;
import com.innovargia.salesmanager.mappers.DescuentoRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class DescuentoDAO extends JdbcDaoSupport implements IDescuentoDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	final String  sql_ = "SELECT * FROM cadescuento ";

	@Autowired
	public DescuentoDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(DescuentoDTO obj) throws Exception {
		String query = "INSERT INTO cadescuento(nombre,descripcion,descuentofijo,porcentaje,tipo,estatus,"
				+ "fechaactivacion,fechatermino,fechaalta,nivel,idagrupamiento) " +
			       "VALUES( :nombre,:descripcion,:descuentofijo,:porcentaje, :tipo,1,"+
			        "'" + obj.getFechaactivacion()+"','" +obj.getFechatermino() +"','" + obj.getFechaalta()+
			        "',:nivel,:idagrupamiento)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "iddescuento" });
			//return keyHolder.getKey();
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
	public void update(DescuentoDTO obj) throws Exception {
		String query = "UPDATE cadescuento SET nombre= :nombre,descripcion= :descripcion,descuentofijo= :descuentofijo,"
			       + "porcentaje= :porcentaje,tipo= :tipo,nivel=:nivel,idagrupamiento=:idagrupamiento,"
			       + "fechaactivacion= '" +obj.getFechaactivacion() + "',fechatermino='" +obj.getFechatermino() +"'"
				+ " WHERE iddescuento = :iddescuento";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(DescuentoDTO obj) throws Exception {
		String query = "DELETE FROM cadescuento  WHERE " +
			       " iddescuento = :iddescuento";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	
	@Override
	public List<DescuentoDTO> getRegistros(BusquedaDTO busqueda) throws Exception {
		List<DescuentoDTO> lista = new ArrayList<DescuentoDTO>();
		String sql = sql_;
		String where="";
		switch (busqueda.getTipo()) {
		case 1: //Por nombre 
			where = " nombre LIKE '"  + busqueda.getPatron_busqueda() +"%'";
			break;
		case 2: //Por Descripcion 
			where = " descripcion LIKE '"  + busqueda.getPatron_busqueda()+"%'";
			break;
		case 3: //Por Fecha Activación
			where = " fechaactivacion = '"  + busqueda.getFechainicial()+"'";
			break;	
		case 4: //Por Forma pago 
			where = " fechatermino = '"  + busqueda.getFechafinal() +"'";
			break;	
		case 5: //Por Fechas de activación y caducidad
			where = " fechaactivacion>='"  + busqueda.getFechainicial()+"' AND fechatermino<='" + busqueda.getFechafinal()+"'";
			break;	
		case 10: 
			//Obtiene todos los descuentos posibles solo para el nivel de usuario y 
			//Para descuentos activos
			sql = "SELECT * FROM ("+
				//Por Tarifa
				"		SELECT  distinct cadescuento.* FROM cadescuento join ("+
				"			select cadescuentotarifa.* from catarifas left outer join "+
				"				cadescuentotarifa ON catarifas.idtarifa = cadescuentotarifa.idtarifa WHERE catarifas.estatus=1  "
				+ "					AND catarifas.idtarifa="+busqueda.getIdtarifa() + 
				"		) a ON cadescuento.iddescuento = a.iddescuento WHERE  cadescuento.estatus = 1 AND cadescuento.Tipo=2 AND cadescuento.nivel>="+  busqueda.getUsuario().getNivelPuesto()+
				"		UNION "+
				//Cliente
				"		SELECT distinct  cadescuento.* FROM cadescuento join ("+
				"			select cadescuentocliente.* from caclientefacturacion join "+
				"			cadescuentocliente ON caclientefacturacion.idcliente = cadescuentocliente.idcliente WHERE "
				+ "			caclientefacturacion.estatus=1 AND cadescuentocliente.idcliente="+busqueda.getIdcliente() +
				"		) a ON cadescuento.iddescuento = a.iddescuento WHERE cadescuento.estatus = 1 AND cadescuento.Tipo=1 AND cadescuento.nivel>="+  busqueda.getUsuario().getNivelPuesto()+
				"		UNION "+
				//Zona
				"		SELECT distinct  cadescuento.* FROM cadescuento join ("+
				"			select distinct * from cadescuentozona left outer join caagrupadorjerarquias on "
				+ "			cadescuentozona.idzona = (caagrupadorjerarquias.idagrupamiento||'')	"+
				"		) a ON cadescuento.iddescuento = a.iddescuento WHERE cadescuento.estatus = 1 AND cadescuento.Tipo=3 AND cadescuento.nivel>="+  busqueda.getUsuario().getNivelPuesto()+
				"		UNION "+
				//Global
				"		SELECT distinct  cadescuento.* FROM cadescuento where cadescuento.estatus = 1 AND cadescuento.Tipo=4 AND cadescuento.nivel>="+  busqueda.getUsuario().getNivelPuesto()+
				"	) a WHERE fechatermino>=current_date ";
				//Se agrega la condicion para que solo devuelva los desceuntos que pertenecen al agrupamiento del usuario o 
				//Sean generales
				//+ "AND idagrupamiento IN (SELECT idagrupamiento FROM caagrupadorjerarquias WHERE idagrupamiento IN ("
				//+ " SELECT distinct idagrupamiento FROM viewagrupacionusuarios WHERE login='" + busqueda.getUsuario().getLogin() +"') "
				//		+ "OR visualizatodo=1 )  ";

		default:
			break;
		}
		if (where.trim().length()>0){
			where = " WHERE " +  where ;
		}
		// Signidica que debe traer todos los registros
		if (busqueda.getEstatus() > -1) {
			where = where + " AND estatus=" + busqueda.getEstatus();
		}
		
		sql += where;
		logger.info("sql busqueda descuentos: " + sql);
		lista = jdbcTemplate.query(sql,new DescuentoRowMapper());
		return lista;
	}

	@Override
	public DescuentoDTO get(DescuentoDTO obj) throws Exception {
		String sql = sql_ + " WHERE iddescuento = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new DescuentoRowMapper(), obj.getIddescuento());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}

	@Override
	public void updateEstatus(DescuentoDTO obj) throws Exception {
		String query = "UPDATE cadescuento SET estatus= :estatus"
				+ " WHERE " +
			       " iddescuento = :iddescuento";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}
	
	

}
