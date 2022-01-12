/**
 * 
 */
package com.tracusa.logistica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.tracusa.logistica.model.Caexcepcion;
import com.tracusa.logistica.model.Movimiento;
import com.tracusa.logistica.interfase.dao.IMovimientoDao;
import com.tracusa.logistica.rowmap.GuiaRowMap;
import com.servicio.dtos.Guia;

/**
 * @author aruaro
 *
 */
@Repository
public class MovimientosDao extends JdbcDaoSupport implements IMovimientoDao {

	private static final Logger logger = LoggerFactory.getLogger(MovimientosDao.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	@Autowired
	public MovimientosDao(DataSource dataSource) {

		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	@Override
	  public int insertEstadisticasCarga(com.administracion.dto.RegistroInfo o)throws Exception{

		 o.set_idpropietario( o.get_idpropietario()!=null?o.get_idpropietario().trim().toUpperCase():"");
		 o.set_servidor( o.get_servidor()!=null?o.get_servidor().trim().toUpperCase():"");
		 o.set_idRegistro( o.get_idRegistro()!=null?o.get_idRegistro().trim().toUpperCase():"");
		 o.set_plaza( o.get_plaza()!=null?o.get_plaza().trim().toUpperCase():"");

		 
			String sql_insert =
					"INSERT INTO bitacora_resumen_agregadori( idpropietario, "
					+ "servidor, tiporegistro,  plaza, diacarga, cantidad)"
					+ "  VALUES("+
			"'" + o.get_idpropietario()+ "'," +
			"'" + o.get_servidor() + "'," +
			"'" + o.get_idRegistro()  + "'," +
			"'" + o.get_plaza() + "',current_date, 0) ON CONFLICT (plaza, diacarga, tiporegistro) DO NOTHING";
			
			String sql_update = "UPDATE  bitacora_resumen_agregadori  SET Cantidad=Cantidad+1  "
					+ " WHERE IdPropietario='" +o.get_idpropietario()+ "' AND " +
					" Servidor='" +  o.get_servidor()	+"' AND  TipoRegistro='"  + 
					o.get_idRegistro()+"' AND Plaza='" + o.get_plaza()+"' AND DiaCarga=current_date ";
		
			try {
				//logger.debug(sql_insert);
				jdbcTemplate.update(sql_insert);
				
			} catch (Exception sq) {
				//logger.debug("Error al insertar datos envio-->" + sq.getMessage());
				// throw sq;
				throw new Exception("Error al insertar datos envio-->" + sq.getMessage());
			}

			try {
				//logger.debug(sql_update);
				jdbcTemplate.update(sql_update);
			} catch (Exception sq) {
				logger.debug("Error al insertar datos envio-->" + sq.getMessage());
				throw new Exception("Error al insertar datos envio-->" + sq.getMessage());
				// throw sq;
			}
			return 0;
	    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IMovimientoDao#insert(com.innovargia.ws.
	 * dto.Movimiento)
	 */
	@Override
	public String insert(Movimiento obj) throws Exception {
		logger.info("MovimientosDao create insert.");
		try {
			String nextMovimiento = nextMovimiento(obj.getIdguia());
			String[] movimientos = nextMovimiento.split("\\|");
			for(int i=0; i < movimientos.length; i++){
				if(movimientos[i].equals(obj.getTipoMovimiento())){
					//Insertar movimiento
					String query = "INSERT INTO movimientos(idguia, tiregistro, exclave, plsiglasplaza, "
							+ "ceorigenregistro, ruta, fechaevento, fechainsercion, empleado,latitud,longitud) "
//							+ "VALUES (:idguia,:tipoMovimiento,:cveLog,:plaza,:oriReg,:ruta,'" + obj.getFecha() + "', "
							+ "VALUES (:idguia,:tipoMovimiento,:cveLog,:plaza,:oriReg,:ruta,current_timestamp, "
							+ "current_timestamp,:empleado,:latitud,:longitud)";
					SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
					this.namedParameterJdbcTemplate.update(query, parameterSource);
					
					//if(obj.getTipoGuia().equals("M")){
					query = "INSERT INTO movimientos(idguia, tiregistro, exclave, plsiglasplaza, " +
							"ceorigenregistro, ruta, fechaevento, fechainsercion, empleado,latitud,longitud) " +
							"(SELECT iddocumento AS idguia, :tipoMovimiento AS tiregistro, :cveLog AS exclave, :plaza AS plsiglasplaza, :oriReg AS ceorigenregistro, :ruta AS ruta, " + 
//							"'" + obj.getFecha() + "' AS fechaevento, current_timestamp AS fechainsercion, :empleado AS empleado, :latitud AS latitud, :longitud AS longitud " +   
							"current_timestamp AS fechaevento, current_timestamp AS fechainsercion, :empleado AS empleado, :latitud AS latitud, :longitud AS longitud " +   
							"FROM cadocumentos WHERE iddocumentomadre IN ('" + obj.getIdguia() + "'))";
					this.namedParameterJdbcTemplate.update(query, parameterSource);
					//}else{}
					return "200";
				}
			}
			//Movimiento fuera del ciclo logico
			//nextMovimiento = nextMovimiento.replace("|", "");
			return nextMovimiento;
		} catch (DataAccessException dae) {
			logger.debug("error insert:" + dae.getMessage());
			throw new Exception("error insert:" + dae.getMessage());
		}
	}
	
	private String nextMovimiento(String idguia) throws Exception{
		String sqlSelect = "";
		try{
			sqlSelect = "SELECT idguia, tiregistro, exclave, ruta, fechaevento, fechainsercion, empleado FROM movimientos " +  
						"WHERE idguia = '" + idguia + "' ORDER BY fechainsercion DESC LIMIT 1";
			SqlRowSet set = jdbcTemplate.queryForRowSet(sqlSelect);
			String tiregistro = "";
			int count = 0;
			while(set.next()){
				tiregistro = set.getString("tiregistro");
			}

			switch(tiregistro){
				case "":
					return "21"; //Recolección
				case "21":
					return "1"; //Entrada a C.O.
				case "1":
					return "24|03|2"; //Salida Reparto | Mov. Interno | Salida foranea
				case "24":
					sqlSelect = "SELECT COUNT(idguia) AS rowcount FROM confirma "
								+ "WHERE idguia = '" + idguia + "'";
					set = jdbcTemplate.queryForRowSet(sqlSelect);
					set.next();
					count = set.getInt("rowcount");
					if(count >= 1){
						return "5"; //Entregada (La guia ya tiene entrega)
					}else{
						return "4|5"; //No exitoso | Entrega
					}
				case "2":
					return "1"; // Entrada C.O.
				case "4":
					return "1"; //Entrada a C.O.
				case "03":
					sqlSelect = "SELECT COUNT(idguia) AS rowcount FROM movimientos "
								+ "WHERE idGuia = '" + idguia + "' AND (tiregistro = '1' OR tiregistro = '01')";
					set = jdbcTemplate.queryForRowSet(sqlSelect);
					set.next();
					count = set.getInt("rowcount");
					if(count > 1){
						//Si la guia tiene mas de una Entrada a C.O. su siguiente movimiento son los siguientes:
						return "24|03|9"; //Salida Reparto | Mov. Interno | Casamiento
					}else{
						return "24|03|2"; //Salida Reparto | Mov. Interno | Salida foranea
					}
				default:
					return "";
			}
			
		}catch (DataAccessException dae) {
			logger.debug("error select:" + dae.getMessage());
			throw new Exception("error select: " + dae.getMessage());
		}
	}
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IMovimientoDao#update(com.innovargia.ws.
	 * dto.Movimiento)
	 */
	@Override
	public int update(Movimiento obj) throws Exception {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IMovimientoDao#delete(com.innovargia.ws.
	 * dto.Movimiento)
	 */
	@Override
	public int delete(Movimiento obj) throws Exception {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IMovimientoDao#select(com.innovargia.ws.
	 * dto.Movimiento)
	 */
	@Override
	public List<Caexcepcion> select(String movType) throws Exception {

		List<Caexcepcion> lstExcepciones = new ArrayList<Caexcepcion>();
		
		Caexcepcion excepcion;
		
		SqlRowSet set = null;
		
		String sql = "SELECT idexcepcion, CONCAT(idexcepcion,'-',descripcion) as descripcion, imputable FROM caexcepcion";
		
		try {
			
			if(movType.equals("2")||movType.equals("24")){
				
				sql = sql + " WHERE idexcepcion = 'E15'";
				
			}
				   
			
			set = jdbcTemplate.queryForRowSet(sql);
			
			while (set.next()) {
				
				excepcion = new Caexcepcion();
				
				excepcion.setIdExcepcion(set.getString("idexcepcion"));
				
				excepcion.setDescripcion(set.getString("descripcion"));
				
				excepcion.setImputable(set.getString("imputable"));
				
				lstExcepciones.add(excepcion);
				
			}
			
			return lstExcepciones;
			
			
		} catch (DataAccessException dae) {
			
			logger.debug("error select:" + dae.getMessage());
			
			throw new Exception("error select: " + dae.getMessage());
		}

	}
	

	@Override
	public int insertCasamiento(Movimiento obj) throws Exception {
		// TODO Auto-generated method stub
		logger.info("MovimientosDao create insertCasamiento.");

		String entrada = "0";
		String query = "";
		try {
			// Validar si tiene un no exitoso y mas de una entrada a C.O.
			entrada = tieneEntrada(obj.getIdguia(), obj.getGuiaCasamiento());
			if(entrada.equals("9")){
				query = "INSERT INTO casamiento(" + " idguia, idcasamiento, idcarrier, ceorigenregistro, "
						+ " plsiglasplaza, fechaevento, ruta, empleado)"
						+ " VALUES (:idguia,:guiaCasamiento,'',:oriReg,:plaza,'" + obj.getFecha() + "', :ruta,:empleado);";
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
				this.namedParameterJdbcTemplate.update(query, parameterSource);
			}
		} catch (DataAccessException dae) {
			logger.debug("error insertCasamiento:" + dae.getMessage());
		}

		return Integer.parseInt(entrada);
	}
	
	private String tieneEntrada(String idguia, String idguiacasamiento) throws Exception{
		String query = "";
		SqlRowSet set = null;
		int count = 0;
		boolean tieneNoExitoso = false;
		String tiregistro = "";
		String idGuiaTemp = "";
		String idGuiaCasamientoTemp = "";
		
		try{
			query = "SELECT COUNT(idguia) AS rowcount FROM casamiento " +
						"WHERE idguia = '" + idguia + "' AND idcasamiento = '" + idguiacasamiento + "' " +
							"OR idguia = '" + idguiacasamiento + "' AND idcasamiento = '" + idguia+ "'";
			
			set = jdbcTemplate.queryForRowSet(query);
			set.next();
			count = set.getInt("rowcount");
			if(count >= 2){
				return "6"; //Ya se encuentra el casamiento entre guias
			}else if(count >= 1){
				query = "SELECT * FROM casamiento " +
						"WHERE idguia = '" + idguia + "' AND idcasamiento = '" + idguiacasamiento + "' " +
							"OR idguia = '" + idguiacasamiento + "' AND idcasamiento = '" + idguia+ "'";
				set = jdbcTemplate.queryForRowSet(query);
				while(set.next()){
					idGuiaTemp = set.getString("idguia");
					idGuiaCasamientoTemp = set.getString("idcasamiento");
				}
				if(idguia.equals(idGuiaTemp) && idguiacasamiento.equals(idGuiaCasamientoTemp)){
					return "5"; //Ya guia ya se encuentra casada con la guia
				}else if(idguia.equals(idGuiaCasamientoTemp) && idguiacasamiento.equals(idGuiaTemp)){
					return "9"; //Inserta casamiento
				}else{
					//Una de las guias ya esta casada con otra guia
					return "3"; //Tiene casamiento
				}
			}else{ //No tiene casamiento
				//Consultar ultimo movimiento
				//Validar que las guias no esten casadas con otras guias
				query = "SELECT COUNT(idguia) AS rowcount FROM casamiento " +
						"WHERE idguia IN ('" + idguia + "', '" + idguiacasamiento + "') "
						+ "OR idcasamiento IN ('" + idguia + "', '" + idguiacasamiento + "')";
				set = jdbcTemplate.queryForRowSet(query);
				set.next();
				count = set.getInt("rowcount");
				if(count >= 2){
					return "3"; // Las 2 guias tienen casamiento
				}else if (count == 1){
					query = "SELECT * FROM casamiento " +
							"WHERE idguia IN ('" + idguia + "', '" + idguiacasamiento + "') "
							+ "OR idcasamiento IN ('" + idguia + "', '" + idguiacasamiento + "')";
					set = jdbcTemplate.queryForRowSet(query);
					while(set.next()){
						idGuiaTemp = set.getString("idguia");
						idGuiaCasamientoTemp = set.getString("idcasamiento");
					}
					if(idguia.equals(idGuiaTemp) && idguiacasamiento.equals(idGuiaCasamientoTemp)){
						//Inserta guia
						return "9";
					}else{
						//Una de las guias ya esta casada con otra guia
						return "3";
					}
				}else{
					//Consultar que la guia este vacia 
					query = "SELECT COUNT(idguia) AS rowcount  FROM movimientos WHERE idGuia = '" + idguiacasamiento + "'";
					set = jdbcTemplate.queryForRowSet(query);
					set.next();
					count = set.getInt("rowcount");
					if(count >= 1){
						return "4"; //La guia de casamiento contiene movimientos
					}
					
					query = "SELECT idguia, tiregistro, exclave, ruta, fechaevento, fechainsercion, empleado FROM movimientos " +  
							"WHERE idguia = '" + idguia + "' ORDER BY fechainsercion DESC LIMIT 1";
					set = jdbcTemplate.queryForRowSet(query);
					while(set.next()){
						tiregistro = set.getString("tiregistro");
					}
					
					switch(tiregistro){
						case "03":
						case "3":
						case "01":
						case "1":
							return "9";
						default:
							return "2";
					}
				}
			}
		}catch(DataAccessException dae){
			logger.debug("error select:" + dae.getMessage());
			throw new Exception("error select: " + dae.getMessage());
		}finally{
			query = "";
			set = null;
			count = 0;
			tieneNoExitoso = false;
			tiregistro = "";
			idGuiaTemp = "";
			idGuiaCasamientoTemp = "";
		}
	}
	@Override
	public String movimientoActual(Movimiento obj) throws Exception {
		String sqlSelect = "";
		try{
			sqlSelect = "SELECT idguia, tiregistro, exclave, ruta, fechaevento, fechainsercion, empleado FROM movimientos " +  
						"WHERE idguia = '" + obj.getIdguia() + "' ORDER BY fechainsercion DESC LIMIT 1";
			SqlRowSet set = jdbcTemplate.queryForRowSet(sqlSelect);
			String tiregistro = "";
			int count = 0;
			while(set.next()){
				tiregistro = set.getString("tiregistro");
			}

			return tiregistro;
			
		}catch (DataAccessException dae) {
			logger.debug("error select:" + dae.getMessage());
			throw new Exception("error select: " + dae.getMessage());
		}
	}

}
