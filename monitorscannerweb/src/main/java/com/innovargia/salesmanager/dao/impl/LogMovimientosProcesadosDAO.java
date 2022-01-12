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

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO;
import com.innovargia.salesmanager.idao.ILogMovimientosProcesadosDAO;
import com.innovargia.salesmanager.mappers.LogHistorialRowMapper;
import com.innovargia.salesmanager.mappers.LogMovimientoProcesadoRowMapper;
import com.innovargia.salesmanager.mappers.ViajeCorridasRowMapper;
import com.servicio.dtos.ManifiestoDTO;

/**
 * @author aruaro
 * 
 */
@Repository
public class LogMovimientosProcesadosDAO extends JdbcDaoSupport implements ILogMovimientosProcesadosDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(LogMovimientosProcesadosDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	
	@Autowired
	public LogMovimientosProcesadosDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#insert(com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO)
	 */
	@Override
	public int insertManifiestoMovimiento(ManifiestoDTO  manifiesto) throws Exception {
	    String query = "INSERT INTO movimientosmanifiesto_datos("
	    	+ "  viaje, tramo_ruta, supervisor, operador1, operador2,"
	    	+ "  economico, cincho, manifiesto, login, fechacreacion, plaza,viaje_corrida)"
	    	+ "  VALUES ( :viaje, :tramo, :supervisor, :operador1, :operador2,"
	    	+ "  :economico, :cincho, :manifiesto, :login, current_timestamp, :siglasplaza, :corrida)";
	    
	    	KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
			manifiesto);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idmanifiesto" });
			
			return keyHolder.getKey().intValue();
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
	public int insertManifiestoMovimientoFXC(ManifiestoDTO  manifiesto_salida,
		ManifiestoDTO  manifiesto_salidafxc) throws Exception {
	    String query = "INSERT INTO movimientomanifiestomonto("
	    	+ "  idguia, monto, manifiesto,manifiestofxc,fechainsercion) "
	    	+ "SELECT idguia,monto,'" + manifiesto_salida.getManifiesto() 
	    	+"','"+ manifiesto_salidafxc.getManifiesto() +"', current_timestamp "
	    	+" FROM movimientosmonto where idguia IN ("
	    	+ "	SELECT idguia FROM movimientosmanifiesto "
	    	+ " WHERE manifiesto='" + manifiesto_salida.getManifiesto()+ "'"
	    	+ ")";


	        
        	try{
        		return this.jdbcTemplate.update(query);
        	}catch(Exception dae){
        		logger.error("Error en updateEstatus: " + dae.getMessage());
        	}
        	
        	return 0;
		
	}
	

		
	@Override
	public List<LogHistoriaDTO> getGuiasManifiestoFXC(String manifiesto) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		String sql = "select * FROM movimientomanifiestomonto "
			+ " where manifiestofxc='" +manifiesto +"'";
   
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}

	
	@Override
	public List<LogHistoriaDTO> getGuiasPosiblesManifiestoFXC(String manifiesto) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		
		String sql = " SELECT * FROM ( "
			+"SELECT movimientosmonto.* FROM ( "
			+"	select distinct idguia,tiregistro FROM movimientosmanifiesto   "
		+"	where manifiesto='" + manifiesto+ "' "
		+"	) a LEFT OUTER JOIN movimientosmonto ON a.idguia = movimientosmonto.idguia "
		+ " ) aa WHERE COALESCE(aa.idguia,'')!='' ";

		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#update(com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO, java.lang.String)
	 */
	@Override
	public void update(LogMovimientoProcesadoDTO obj, String exclude_guias) throws Exception {
		
		String query = "";
		
		if (!obj.getGuia().equals("NA")) {
			
	    	query = "UPDATE movimientosmanifiesto  SET loginmanifiesta=:login, manifiesto=:manifiesto ,"
		    		+ " fechamanifestado=current_timestamp "
		    		+ " WHERE ruta=:tramo AND viaje=:viaje and tiregistro=:tipomovimiento AND "
		    		/* Se agrega esta linea para hacer el update por guia y no general*/
		    		+ " idguia IN(select iddocumento from cadocumentos where iddocumentomadre ='"+ obj.getGuia() +"') AND "
		    		+ " manifiesto IS NULL AND fechamanifestado is null  " 
		    		+((obj.getPlazaenvia()!=null && !obj.getPlazaenvia().isEmpty())?" and plsiglasplaza IN (" + obj.getPlazaenvia() +") ":"");

		    	if (exclude_guias!=null && !exclude_guias.isEmpty()){
		    	    query += " AND idguia NOT IN (" + exclude_guias +")"; 
		    	}
			
		}else{
			
	    	query = "UPDATE movimientosmanifiesto  SET loginmanifiesta=:login, manifiesto=:manifiesto ,"
		    		+ " fechamanifestado=current_timestamp "
		    		+ " WHERE ruta=:tramo AND viaje=:viaje and tiregistro=:tipomovimiento AND "
		    		/* Se agrega esta linea para hacer el update por guia y no general*/
		    		+ " idguia IN("+exclude_guias+") AND "
		    		+ " manifiesto IS NULL AND fechamanifestado is null  " 
		    		+((obj.getPlazaenvia()!=null && !obj.getPlazaenvia().isEmpty())?" and plsiglasplaza IN (" + obj.getPlazaenvia() +") ":"");
			
		}
		
	    	logger.info("SQL:" + query);
	    	
        	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
        
        	try{
        		this.namedParameterJdbcTemplate.update(query, parameterSource);
        	}catch(Exception dae){
        		logger.error("Error en updateEstatus: " + dae.getMessage());
        	}
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#updateMovLocal(com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO, java.lang.String)
	 */
	@Override
	public void updateMovLocal(LogMovimientoProcesadoDTO obj, String exclude_guias) throws Exception {
	    	String deptodestino = obj.getTramo()==null?"":obj.getTramo();
	    	String query = "";
	    	if (!obj.getGuia().equals("NA")) {
	    		
		    	 query = "UPDATE movimientosmanifiesto  SET manifiesto=:manifiesto "
		 	    		+ " WHERE ruta=:viaje "
		 	    		/* Se agrega esta linea para hacer el update por guia y no general*/	
		 	    		+ "AND idguia IN(select iddocumento from cadocumentos where iddocumentomadre ='"+ obj.getGuia() +"') "	
		 	    		+ " AND  manifiesto IS NULL AND fechamanifestado is null AND  tiregistro=:tipomovimiento"
		 	    		//+ "AND deptodestino =:tramo AND "
		 	    		+((deptodestino!=null && !deptodestino.isEmpty())?" and deptodestino='" + deptodestino +"' " :"" );
		 	    			    		

		 	    	if (exclude_guias!=null && !exclude_guias.isEmpty()){
		 	    	    query += " AND idguia NOT IN (" + exclude_guias +")"; 
		 	    	}
	    		
	    	}else{
	    		
		    	 query = "UPDATE movimientosmanifiesto  SET manifiesto=:manifiesto "
		 	    		+ " WHERE ruta=:viaje "
		 	    		/* Se agrega esta linea para hacer el update por guia y no general*/	
		 	    		+ "AND idguia IN("+exclude_guias+") "	
		 	    		+ " AND  manifiesto IS NULL AND fechamanifestado is null AND  tiregistro=:tipomovimiento"
		 	    		//+ "AND deptodestino =:tramo AND "
		 	    		+((deptodestino!=null && !deptodestino.isEmpty())?" and deptodestino='" + deptodestino +"' " :"" );
	    		
	    	}

    	    	logger.info("SQL:" + query);
        	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
        
        	try{
        		this.namedParameterJdbcTemplate.update(query, parameterSource);
        	}catch(Exception dae){
        		logger.error("Error en updateEstatus: " + dae.getMessage());
        	}
		
	}
	
	@Override
	public void updateRecoleccion(LogMovimientoProcesadoDTO obj, String exclude_guias, String plazas) throws Exception {
	    	String deptodestino = obj.getTramo()==null?"":obj.getTramo();
	    	String query = "";
	    	if (!obj.getGuia().equals("NA")) {
	    		
		     query = "UPDATE movimientosmanifiesto  SET manifiesto=:manifiesto "
			    		+ " WHERE ruta=:viaje "
			    		/* Se agrega esta linea para hacer el update por guia y no general*/	
			    		+ "AND idguia IN(select iddocumento from cadocumentos where iddocumentomadre ='"+ obj.getGuia() +"') "	
			    		+ " AND  manifiesto IS NULL AND fechamanifestado is null AND  tiregistro=:tipomovimiento "
			    		 + ((plazas != null && !plazas.isEmpty()) ? " and plsiglasplaza IN (" + plazas +") ":"");

			    	if (exclude_guias!=null && !exclude_guias.isEmpty()){
			    	    query += " AND idguia NOT IN (" + exclude_guias +")"; 
			    	}
	    		
	    	}else{
	    		
		     query = "UPDATE movimientosmanifiesto  SET manifiesto=:manifiesto "
			    		+ " WHERE ruta=:viaje "
			    		+ "AND idguia IN("+exclude_guias+")"
			    		+ " AND  manifiesto IS NULL AND fechamanifestado is null AND  tiregistro=:tipomovimiento "
			    		 + ((plazas != null && !plazas.isEmpty()) ? " and plsiglasplaza IN (" + plazas +") ":"");
	    	}
//	    	String query = "UPDATE movimientosmanifiesto  SET manifiesto=:manifiesto "
//	    		+ " WHERE ruta=:viaje "
//	    		/* Se agrega esta linea para hacer el update por guia y no general*/	
//	    		+ "AND idguia IN(select iddocumento from cadocumentos where iddocumentomadre ='"+ obj.getGuia() +"') "	
//	    		+ " AND  manifiesto IS NULL AND fechamanifestado is null AND  tiregistro=:tipomovimiento "
//	    		 + ((plazas != null && !plazas.isEmpty()) ? " and plsiglasplaza IN (" + plazas +") ":"");
//
//	    	if (exclude_guias!=null && !exclude_guias.isEmpty()){
//	    	    query += " AND idguia NOT IN (" + exclude_guias +")"; 
//	    	}
	    	
    	    	logger.info("SQL:" + query);
        	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
        
        	try{
        		this.namedParameterJdbcTemplate.update(query, parameterSource);
        	}catch(Exception dae){
        		logger.error("Error en updateEstatus: " + dae.getMessage());
        	}
		
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#delete(com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO)
	 */
	@Override
	public void delete(LogMovimientoProcesadoDTO obj) throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getRegistros(com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO)
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getRegistrosProcesados(LogMovimientoProcesadoDTO obj) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "SELECT * FROM bitacora_registros_procesados "
			+ " WHERE date(fechaproceso)>= current_date "
			+((obj.isSoloregistrosconerror()) ? " AND tipoerror!='SUCCESS'": "")
			+ " ORDER BY fechaproceso desc  limit 200";
		//logger.info("SQL:" + sql);		
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getTotalesPlazaRegistro(java.lang.String)
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesPlazaRegistro(String plaza) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select plaza as plazaenvia, tiporegistro as tipomovimiento ,sum(cantidad) as cantidad "
			+ " from bitacora_resumen_agregadori where  diacarga= current_date" + 
			((plaza != null && !plaza.isEmpty()) ? " AND plaza='"+ plaza+"'" : "")
			+ " group by diacarga, plaza, tiporegistro order by plaza, tiporegistro desc ";
		
		//logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalPorTipoRegistro(String plaza) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		
		String sql =
			"SELECT distinct a.tipomovimiento ||'-'|| COALESCE(inforegistros_maestro.nombre,'') as tipomovimiento , "
			+ "cantidad FROM ("
			+ "	select tiporegistro as tipomovimiento, sum(cantidad) as cantidad "
			+ " 	from bitacora_resumen_agregadori  "
			+ " 	where  diacarga= current_date"
			+((plaza != null && !plaza.isEmpty()) ? " AND plaza='"+ plaza+"'" : "")
			+ " group by tiporegistro"
			+ ") a left outer join inforegistros_maestro ON"
			+ " a.tipomovimiento = inforegistros_maestro.idregistro order by tipomovimiento desc";

		//logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesPorPlaza(String plaza) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		
		String sql = "select plaza as tipomovimiento, sum(cantidad) as cantidad "
			+ " from bitacora_resumen_agregadori  "
			+ " where  diacarga= current_date"
			+((plaza != null && !plaza.isEmpty()) ? " AND plaza='"+ plaza+"'" : "")
			+ " group by plaza";

		//logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getTotalesTipoErroreProcesados(java.lang.String)
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesTipoErroreProcesados(String plaza) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		
		String sql = "select  distinct tipoerror as tipomovimiento, count(tipoerror) as cantidad "
			+ " from bitacora_registros_procesados "
			+ " WHERE date(fechaproceso)>= current_date  AND "
			+ " date(fechaproceso)<=current_date "
			+((plaza != null && !plaza.isEmpty()) ? " AND plazaenvia='"+ plaza+"' " : "")
			+ "group by   tipoerror";

		
		//logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	

	
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getTotalesViajeSalidas(java.lang.String, java.lang.String)
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getViajeSalidas(String plaza, String tipotranslado) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct viaje from viewscon "
			+ "where (manifiesto IS NULL or fechamanifestado is null) AND "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)  "
			//+ "  viaje is not null "
			+((tipotranslado!=null && !tipotranslado.isEmpty())?" and tipotranslado='" + tipotranslado +"' ":"")
			+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"")
			+ " and viaje is not null and viaje != '' group by viaje";
		logger.info("SQL:" + sql);

		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	@Override
	public List<LogMovimientoProcesadoDTO> getPlazaProcesaSalidas(String plaza, String tipotranslado) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		
		String sql = "select distinct plsiglasplaza as viaje from viewscon "
			+ " where (manifiesto IS NULL or fechamanifestado is null) AND  "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)  "
			+ " and plsiglasplaza is not null and plsiglasplaza != '' group by plsiglasplaza";
		logger.info("SQL:" + sql);

		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	@Override
	public List<LogMovimientoProcesadoDTO> getPlazaProcesaEntrada(String plaza, String tipotranslado) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct plsiglasplaza as viaje from viewecon "
			+ " where (manifiesto IS NULL or fechamanifestado is null) AND  "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)  "
			+ " and plsiglasplaza is not null and plsiglasplaza != '' group by plsiglasplaza";
		
		logger.info("SQL:" + sql);

		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	@Override
	public List<LogMovimientoProcesadoDTO> getPlazaProcesaMovimientoLocal(String plaza, String tipotranslado) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct plsiglasplaza as viaje from viewmloc "
			+ " where (manifiesto IS NULL or fechamanifestado is null) AND  "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)  "
			+ " and plsiglasplaza is not null and plsiglasplaza != '' group by plsiglasplaza";
		
		logger.info("SQL:" + sql);

		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	@Override
	public List<LogMovimientoProcesadoDTO> getPlazaProcesaRecoleciones(String plaza, String tipotranslado) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct plsiglasplaza as viaje from viewrecoleccion "
			+ " where (manifiesto IS NULL or fechamanifestado is null) AND  "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)  "
			+ " and plsiglasplaza is not null and plsiglasplaza != '' group by plsiglasplaza";
		
		logger.info("SQL:" + sql);

		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getTotalesViajeRutaSalidas(java.lang.String, java.lang.String)
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesViajeRutaSalidas(String viaje,String tipotranslado,String plaza) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct viaje, ruta, count(ruta) as cantidad from viewscon "
			+ "where (manifiesto IS NULL or fechamanifestado is null) AND "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)   AND "
			+ " viaje='" +viaje +"'"
			+((tipotranslado!=null && !tipotranslado.isEmpty())?" and tipotranslado='" + tipotranslado +"' ":"")
			+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"")
			+ " and viaje is not null group by viaje, ruta";
		

		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getTotalesViajeEntradas(java.lang.String)
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getViajesEntradas(String plaza,String tipotranslado) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct viaje from viewecon "
			+ "where (manifiesto IS NULL or fechamanifestado is null) AND "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND  "
			+ " date(fechaevento)<=date(current_date)   "
			+((tipotranslado!=null && !tipotranslado.isEmpty())?" and tipotranslado='" + tipotranslado +"' ":"")
			+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"")
			+ " and viaje is not null and viaje != '' group by viaje";
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getTotalesViajeRutaEntradas(java.lang.String, java.lang.String)
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesViajeRutaEntradas(String viaje,
		String tipotranslado,String plaza) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct viaje, ruta, count(ruta) as cantidad  from viewecon "
			+ "where (manifiesto IS NULL or fechamanifestado is null) AND "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)  AND "
			+ " viaje='" +viaje +"' "
			+((tipotranslado!=null && !tipotranslado.isEmpty())?" and tipotranslado='" + tipotranslado +"' ":"")
			+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"")
			+ "group by  viaje, ruta";
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	@Override
	public List<LogHistoriaDTO> getGuiasViajeRutaEntradas(String viaje,String ruta,
		String tipotranslado, boolean verSoloLasNoManifiestadas,String plaza) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		/* Se relaiza un union all con otra consultaque nos traera todas las guias madre 
		 * asi obtenemos tanto guias madre comoguias individuales */
		String sql = "select Distinct on (ca.iddocumentomadre) iddocumentomadre AS iddocumentomadre, 'NA' AS idguia, VL.tiregistro, VL.exclave, VL.plsiglasplaza, VL.ceorigenregistro, VL.ruta, VL.fechaevento, VL.fechainsercion, VL.empleado, VL.latitud, VL.longitud, VL.viaje, VL.numeconomico, VL.operador, VL.cincho, VL.manifiesto, VL.fechamanifestado, (SELECT COUNT(*) FROM CADOCUMENTOS WHERE IDDOCUMENTOMADRE = ca.iddocumentomadre) AS cantidad FROM viewecon AS VL "
			+"INNER JOIN cadocumentos AS CA ON VL.idguia = CA.iddocumento "	
			+"where VL.ruta='" +ruta +"' and VL.viaje='" + viaje +"' AND CA.iddocumentomadre is not null "
			+((tipotranslado!=null && !tipotranslado.isEmpty())?" and VL.tipotranslado='" + tipotranslado +"' ":"")
			+((plaza!=null && !plaza.isEmpty())?" and VL.plsiglasplaza IN (" + plaza +" ) ":"");
		
		if (!verSoloLasNoManifiestadas){
		    sql +=" and VL.fechamanifestado is null";
		}
		
		sql += " UNION ALL "
		
		+ "select 'NA' AS iddocumentomadre, VL.idguia, VL.tiregistro, VL.exclave, VL.plsiglasplaza, VL.ceorigenregistro, VL.ruta, VL.fechaevento, VL.fechainsercion, VL.empleado, VL.latitud, VL.longitud, VL.viaje, VL.numeconomico, VL.operador, VL.cincho, VL.manifiesto, VL.fechamanifestado, '1' AS cantidad FROM viewecon AS VL "
		+"INNER JOIN cadocumentos AS CA ON VL.idguia = CA.iddocumento "	
		+"where VL.ruta='" +ruta +"' and VL.viaje='" + viaje +"' AND CA.iddocumentomadre is null "
		+((tipotranslado!=null && !tipotranslado.isEmpty())?" and VL.tipotranslado='" + tipotranslado +"' ":"")
		+((plaza!=null && !plaza.isEmpty())?" and VL.plsiglasplaza IN (" + plaza +" ) ":"");
					
		if (!verSoloLasNoManifiestadas){
			sql +=" and VL.fechamanifestado is null";
		}
				
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}
	
	@Override
	public List<LogHistoriaDTO> getGuiasViajeRutaEntradasMadre(String viaje,String ruta,
		String tipotranslado, boolean verSoloLasNoManifiestadas,String plaza, String esMadre) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		String sql = "select VC.* FROM viewecon AS VC "
			+"INNER JOIN cadocumentos AS CA ON VC.idguia = CA.iddocumento "	
			+ " where VC.ruta='" +ruta +"' and VC.viaje='" + viaje +"' and CA.iddocumentomadre = '"+ esMadre +"' "
			+((tipotranslado!=null && !tipotranslado.isEmpty())?" and VC.tipotranslado='" + tipotranslado +"' ":"")
			+((plaza!=null && !plaza.isEmpty())?" and VC.plsiglasplaza IN (" + plaza +" ) ":"");
		
		if (!verSoloLasNoManifiestadas){
		    sql +=" and VC.fechamanifestado is null";
		}
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;

	}
	
	@Override
	public List<LogHistoriaDTO> getGuiasMovimientoLocal(String ruta,String depto,
		boolean verSoloLasNoManifiestadas,String plaza) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		/* Se relaiza un union all con otra consultaque nos traera todas las guias madre 
		 * asi obtenemos tanto guias madre comoguias individuales */
		String sql = "select Distinct on (ca.iddocumentomadre) iddocumentomadre AS iddocumentomadre, 'NA' AS idguia, VL.tiregistro, VL.exclave, VL.plsiglasplaza, VL.ceorigenregistro, VL.ruta, VL.fechaevento, VL.fechainsercion, VL.empleado, VL.latitud, VL.longitud, VL.viaje, VL.numeconomico, VL.operador, VL.cincho, VL.manifiesto, VL.fechamanifestado, VL.deptodestino, (SELECT COUNT(*) FROM CADOCUMENTOS WHERE IDDOCUMENTOMADRE = ca.iddocumentomadre) AS cantidad FROM viewmloc AS VL "
				+"INNER JOIN cadocumentos AS CA ON VL.idguia = CA.iddocumento "	
				+ "where VL.ruta='" +ruta + "' AND CA.iddocumentomadre is not null "
				+((depto!=null && !depto.isEmpty())?" and VL.deptodestino='" + depto +"' " :"" )
				+((plaza!=null && !plaza.isEmpty())?" and VL.plsiglasplaza IN (" + plaza +") ":"");
			
			if (!verSoloLasNoManifiestadas){
			    sql +=" and VL.fechamanifestado is null";
			}
		
		sql += " UNION ALL "	
			
		    + "select  'NA' AS iddocumentomadre, VL.idguia, VL.tiregistro, VL.exclave, VL.plsiglasplaza, VL.ceorigenregistro, VL.ruta, VL.fechaevento, VL.fechainsercion, VL.empleado, VL.latitud, VL.longitud, VL.viaje, VL.numeconomico, VL.operador, VL.cincho, VL.manifiesto, VL.fechamanifestado, VL.deptodestino, '1' AS cantidad FROM viewmloc AS VL "
		    + "INNER JOIN cadocumentos AS CA ON VL.idguia = CA.iddocumento "	
		    + "where VL.ruta='" +ruta + "' AND CA.iddocumentomadre is null "
			+((depto!=null && !depto.isEmpty())?" and VL.deptodestino='" + depto +"' " :"" )
			+((plaza!=null && !plaza.isEmpty())?" and VL.plsiglasplaza IN (" + plaza +") ":"");
		
		if (!verSoloLasNoManifiestadas){
		    sql +=" and VL.fechamanifestado is null";
		}
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}
	
	@Override
	public List<LogHistoriaDTO> getGuiasMovimientoLocalMadre(String ruta,String depto,
		boolean verSoloLasNoManifiestadas,String plaza, String esMadre) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		String sql = "select VL.* FROM viewmloc AS VL "
				+"INNER JOIN cadocumentos AS CA ON VL.idguia = CA.iddocumentomadre "	
				+ "where VL.ruta='" +ruta + "' and CA.iddocumentomadre = '" + esMadre + "' "
				+((depto!=null && !depto.isEmpty())?" and VL.deptodestino='" + depto +"' " :"" )
				+((plaza!=null && !plaza.isEmpty())?" and VL.plsiglasplaza IN (" + plaza +") ":"");
			
			if (!verSoloLasNoManifiestadas){
			    sql +=" and VL.fechamanifestado is null";
			}
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}
	@Override
	public List<LogHistoriaDTO> getGuiasRecolecciones(String ruta,String depto,
		boolean verSoloLasNoManifiestadas,String plaza) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		/* Se relaiza un union all con otra consultaque nos traera todas las guias madre 
		 * asi obtenemos tanto guias madre comoguias individuales */
		String sql = "select Distinct on (ca.iddocumentomadre) iddocumentomadre AS iddocumentomadre, 'NA' AS idguia, VR.tiregistro, VR.exclave, VR.plsiglasplaza, VR.ceorigenregistro, VR.ruta, VR.fechaevento, VR.fechainsercion, VR.empleado, VR.latitud, VR.longitud, VR.viaje, VR.numeconomico, VR.operador, VR.cincho, VR.manifiesto, VR.fechamanifestado, VR.loginmanifiesta, VR.deptodestino, VR.ubicacion, VR.ubicacion, VR.viaje_corrida, VR.idregistro, (SELECT COUNT(*) FROM CADOCUMENTOS WHERE IDDOCUMENTOMADRE = ca.iddocumentomadre) AS cantidad FROM viewrecoleccion AS VR "
				+"INNER JOIN CADOCUMENTOS AS CA ON VR.IDGUIA = CA.IDDOCUMENTO  where VR.ruta='" +ruta + "'AND CA.iddocumentomadre is not null AND "
				+"date(VR.fechaevento) >=date(current_date - interval '1 day') AND "
				+"date(VR.fechaevento)<=date(current_date) "
				+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"");
		if (!verSoloLasNoManifiestadas){
				sql +=" and VR.manifiesto IS NULL AND VR.fechamanifestado is null";
		}

				sql += " UNION ALL "
				+"select  'NA' AS iddocumentomadre, VR.idguia, VR.tiregistro, VR.exclave, VR.plsiglasplaza, VR.ceorigenregistro, VR.ruta, VR.fechaevento, VR.fechainsercion, VR.empleado, VR.latitud, VR.longitud, VR.viaje, VR.numeconomico, VR.operador, VR.cincho, VR.manifiesto, VR.fechamanifestado, VR.loginmanifiesta, VR.deptodestino, VR.ubicacion, VR.ubicacion, VR.viaje_corrida, VR.idregistro, '1' AS cantidad FROM viewrecoleccion AS VR "
				+"INNER JOIN CADOCUMENTOS AS CA ON VR.IDGUIA = CA.IDDOCUMENTO  where VR.ruta='" +ruta + "' AND CA.iddocumentomadre is null AND "
				+"date(VR.fechaevento) >=date(current_date - interval '1 day') AND "
				+"date(VR.fechaevento)<=date(current_date) "
				+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"");
		if (!verSoloLasNoManifiestadas){
				sql +=" and VR.manifiesto IS NULL AND VR.fechamanifestado is null";
		}	

		
		
		
//		if(madre.equals("n")){
//			
//			 sql = "select * FROM viewrecoleccion "
//					+ " where ruta='" +ruta + "' AND "
//					+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
//					+ " date(fechaevento)<=date(current_date)  "
//					+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"");
//			 
//				if (!verSoloLasNoManifiestadas){
//				    sql +=" and manifiesto IS NULL AND fechamanifestado is null ";
//				}
//			
//		}else if(madre.equals("s")){
//			
//			 sql = "select Distinct on (ca.iddocumentomadre) iddocumentomadre AS idguia, VR.tiregistro, " 
//					 + "VR.exclave, VR.plsiglasplaza, VR.ceorigenregistro, VR.ruta, VR.fechaevento, VR.fechainsercion, "
//					 + "VR.empleado, VR.latitud, VR.longitud, VR.viaje, VR.numeconomico, VR.operador, VR.cincho, VR.manifiesto, "
//					 +"VR.fechamanifestado, VR.loginmanifiesta, VR.deptodestino, VR.ubicacion, VR.ubicacion, VR.viaje_corrida, VR.idregistro, "
//					 +"(SELECT COUNT(*) FROM CADOCUMENTOS WHERE IDDOCUMENTOMADRE = ca.iddocumentomadre) AS CANTIDAD FROM viewrecoleccion AS VR "
//					 +"INNER JOIN CADOCUMENTOS AS CA ON VR.IDGUIA = CA.IDDOCUMENTO  where VR.ruta='" +ruta + "' AND  date(VR.fechaevento) >=date(current_date - interval '1 day') "
//					 +"AND  date(VR.fechaevento)<=date(current_date) "
//					 +((plaza!=null && !plaza.isEmpty())?" and VR.plsiglasplaza IN (" + plaza +") ":"");
//			 
//				if (!verSoloLasNoManifiestadas){
//				    sql +=" and VR.manifiesto IS NULL AND VR.fechamanifestado is null ";
//				}
//		}
//		
//		if (!verSoloLasNoManifiestadas){
//		    sql +=" and VR.manifiesto IS NULL AND VR.fechamanifestado is null ";
//		}
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}
	@Override
	public List<LogHistoriaDTO> getGuiasRecoleccionesMadre(String ruta,String depto,
		boolean verSoloLasNoManifiestadas,String plaza, String esMadre) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		String sql = "";
			
		sql = "select VR.* FROM viewrecoleccion AS VR "
				+"INNER JOIN CADOCUMENTOS AS CA ON VR.IDGUIA = CA.IDDOCUMENTO  where VR.ruta='" +ruta + "'AND CA.iddocumentomadre = '" + esMadre + "' AND "
				+"date(VR.fechaevento) >=date(current_date - interval '1 day') AND "
				+"date(VR.fechaevento)<=date(current_date) "
				+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"");
		if (!verSoloLasNoManifiestadas){
				sql +=" and VR.manifiesto IS NULL AND VR.fechamanifestado is null";
		}
			
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}
	@Override
	public List<LogHistoriaDTO> getGuiasViajeRutaSalidas(String viaje,String ruta,
		String tipotranslado, boolean verSoloLasNoManifiestadas, String plaza) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		/* Se relaiza un union all con otra consultaque nos traera todas las guias madre 
		 * asi obtenemos tanto guias madre comoguias individuales */
		String sql = "select Distinct on (ca.iddocumentomadre) iddocumentomadre AS iddocumentomadre, 'NA' AS idguia, VL.tiregistro, VL.exclave, VL.plsiglasplaza, VL.ceorigenregistro, VL.ruta, VL.fechaevento, VL.fechainsercion, VL.empleado, VL.latitud, VL.longitud, VL.viaje, VL.numeconomico, VL.operador, VL.cincho, VL.manifiesto, VL.fechamanifestado, (SELECT COUNT(*) FROM CADOCUMENTOS WHERE IDDOCUMENTOMADRE = ca.iddocumentomadre) AS cantidad FROM viewscon AS VL "
			+"INNER JOIN cadocumentos AS CA ON VL.idguia = CA.iddocumento "	
			+ "where VL.ruta='" +ruta +"' and VL.viaje='" + viaje +"' AND CA.iddocumentomadre is not null "
			+((tipotranslado!=null && !tipotranslado.isEmpty())?" and VL.tipotranslado='" + tipotranslado +"' ":"")
			+((plaza!=null && !plaza.isEmpty())?" and VL.plsiglasplaza IN ( " + plaza +") ":"");
		
		if (!verSoloLasNoManifiestadas){
		    sql +=" and VL.fechamanifestado is null";
		}
		
		sql += " UNION ALL "
		
		+"select 'NA' AS iddocumentomadre, VL.idguia, VL.tiregistro, VL.exclave, VL.plsiglasplaza, VL.ceorigenregistro, VL.ruta, VL.fechaevento, VL.fechainsercion, VL.empleado, VL.latitud, VL.longitud, VL.viaje, VL.numeconomico, VL.operador, VL.cincho, VL.manifiesto, VL.fechamanifestado, '1' AS cantidad FROM viewscon AS VL "
		+"INNER JOIN cadocumentos AS CA ON VL.idguia = CA.iddocumento "	
		+ "where VL.ruta='" +ruta +"' and VL.viaje='" + viaje +"' AND CA.iddocumentomadre is null "
		+((tipotranslado!=null && !tipotranslado.isEmpty())?" and VL.tipotranslado='" + tipotranslado +"' ":"")
		+((plaza!=null && !plaza.isEmpty())?" and VL.plsiglasplaza IN ( " + plaza +") ":"");
			
			if (!verSoloLasNoManifiestadas){
			    sql +=" and VL.fechamanifestado is null";
			}
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}
	
	@Override
	public List<LogHistoriaDTO> getGuiasViajeRutaSalidasMadre(String viaje,String ruta,
		String tipotranslado, boolean verSoloLasNoManifiestadas, String plaza, String esMadre) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		String sql = "select VC.* FROM viewscon AS VC "
				+"INNER JOIN cadocumentos AS CA ON VC.idguia = CA.iddocumento "	
				+ "where VC.ruta='" +ruta +"' and VC.viaje='" + viaje +"' and CA.iddocumentomadre = '"+ esMadre +"' "
				+((tipotranslado!=null && !tipotranslado.isEmpty())?" and VC.tipotranslado='" + tipotranslado +"' ":"")
				+((plaza!=null && !plaza.isEmpty())?" and VC.plsiglasplaza IN (" + plaza +" ) ":"");
			
			if (!verSoloLasNoManifiestadas){
			    sql +=" and VC.fechamanifestado is null";
			}
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}
	@Override
	public List<LogHistoriaDTO> getGuiasManifiesto(String manifiesto) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		String sql = "select * FROM movimientosmanifiesto "
			+ " where manifiesto='" +manifiesto +"'";

		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
		return lista;
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getTotalesViajeMovLocal()
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesViajeMovLocal() throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct ruta as viaje, count(ruta) as cantidad from viewmloc "
			+ "where (manifiesto IS NULL or fechamanifestado is null) AND "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)  ";
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getTotalesViajeRutaMovLocal()
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesRutaMovLocal(String plaza) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct ruta as viaje, count(ruta) as cantidad from viewmloc "
			+ "where (manifiesto IS NULL or fechamanifestado is null) AND "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)  "
			+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN  (" + plaza +") ":"")
				+ "group by   ruta";
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
		
	}
	 
	@Override
	public List<LogMovimientoProcesadoDTO> getViajeCorrida(String viajecorrida) throws Exception {

		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select id as tipomovimiento ,viaje, origen||'-'||destino as ruta ,"
			+ " fecha as fechaproceso"
			+ " from cacorridaviaje left outer join cacorridaviaje_data on viaje = idcorrida "
			+ " where fecha>=date(current_date - interval '5 day')  and "
			+ " fecha<=current_date AND viaje='" + viajecorrida +"' ORDER BY fecha  ";
		
		logger.info("SQL:" + sql); 
		lista = jdbcTemplate.query(sql,new ViajeCorridasRowMapper() );
		return lista;
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#getTotalesViajeRutaDeptoMovLocal(java.lang.String, java.lang.String)
	 */
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesRutaDeptoMovLocal(String plaza, String ruta) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct     "
			+ " deptodestino as ruta, count(COALESCE(deptodestino,'SN')) "
			+ " from viewmloc"
			+ " where (manifiesto IS NULL or fechamanifestado is null) AND "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)  AND "
			+ "  ruta='" + ruta + "'"
			+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"")
			+ " group by  viaje,ruta, deptodestino  ";
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesRutaRecolecciones(String plaza, String ruta) throws Exception {
		List<LogMovimientoProcesadoDTO> lista = new ArrayList<LogMovimientoProcesadoDTO>();
		String sql = "select distinct     "
			+ " ruta as viaje, count(COALESCE(ruta,'SN')) "
			+ " from viewrecoleccion"
			+ " where (manifiesto IS NULL or fechamanifestado is null) AND "
			+ " date(fechaevento) >=date(current_date - interval '1 day') AND "
			+ " date(fechaevento)<=date(current_date)   "
			//+ "  ruta='" + ruta + "'"
			+((plaza!=null && !plaza.isEmpty())?" and plsiglasplaza IN (" + plaza +") ":"")
			+ " group by  viaje,ruta, deptodestino  ";
		
		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogMovimientoProcesadoRowMapper() );
		return lista;
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#get(com.innovargia.salesmanager.dtos.LogHistoriaDTO)
	 */
	@Override
	public LogHistoriaDTO get(LogHistoriaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ILogMovimientosProcesadosDAO#updateEstatus(com.innovargia.salesmanager.dtos.LogHistoriaDTO)
	 */
	@Override
	public void updateEstatus(LogHistoriaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteManifiesto(LogMovimientoProcesadoDTO obj)
		throws Exception {
	    String query = "UPDATE movimientosmanifiesto  SET loginmanifiesta=null, manifiesto=null ,"
	    		+ " fechamanifestado=null "
	    		+ " WHERE manifiesto=:manifiesto  ";

	    	logger.info("SQL:" + query);
	    	
        	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
        
        	try{
        	    this.namedParameterJdbcTemplate.update(query, parameterSource);
        	    parameterSource = new BeanPropertySqlParameterSource(obj);
        	    logger.info("SQL:" + query);
        	    query = "DELETE FROM movimientosmanifiesto_datos WHERE manifiesto=:manifiesto  ";
        	    logger.info("SQL:" + query);
        	    this.namedParameterJdbcTemplate.update(query, parameterSource);
        	}catch(Exception dae){
        		logger.error("Error en deleteManifiesto: " + dae.getMessage());
        	}
	    
	}
	@Override
	public void deleteManifiestoFX(LogMovimientoProcesadoDTO obj )
		throws Exception {
	    String query = "DELETE FROM movimientomanifiestomonto WHERE manifiestofxc=:manifiesto";

	    	logger.info("SQL:" + query);
	    	
        	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
        
        	try{
        	    this.namedParameterJdbcTemplate.update(query, parameterSource);
        	    parameterSource = new BeanPropertySqlParameterSource(obj);
        	    logger.info("SQL:" + query);
        	    query = "DELETE FROM movimientosmanifiesto_datos WHERE manifiesto=:manifiesto  ";
        	    logger.info("SQL:" + query);
        	    this.namedParameterJdbcTemplate.update(query, parameterSource);
        	}catch(Exception dae){
        		logger.error("Error en deleteManifiestoFX: " + dae.getMessage());
        	}
	    
	}


	@Override
	public List<LogHistoriaDTO> getGuiasRutaManifiesto(String manifiesto) throws Exception {
		
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		
		String sql = "SELECT DISTINCT ON (DD.iddocumento) iddocumento AS idguia, MM.manifiesto, DD.estado, DD.ciudad, DD.calle, DD.colonia, DD.municipio, DD.numinterior, DD.numexterior, DD.cp FROM movimientosmanifiesto AS MM "
				+ "INNER JOIN cadireccionesdocumento AS DD ON MM.idguia = DD.iddocumento "
				+ "WHERE DD.idtipodireccion = 'D' AND MM.manifiesto ='" +manifiesto +"'";

		logger.info("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper() );
	
		return lista;
		
	}


	
	
	
	
}
