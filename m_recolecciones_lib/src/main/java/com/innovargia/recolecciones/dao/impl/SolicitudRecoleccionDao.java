/**
 * 
 */
package com.innovargia.recolecciones.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.administracion.dto.DiasSemanaMes;
import com.administracion.dto.SolicitudRecoleccion;
import com.administracion.rowmapper.RutaPlazaTotalDTOMapper;
import com.innovargia.recolecciones.idao.ISolicitudRecoleccionDAO;
import com.innovargia.recolecciones.mappers.DiasMesRowMapper;
import com.innovargia.recolecciones.mappers.DiasSemanaRowMapper;
import com.innovargia.recolecciones.mappers.Estatus;
import com.innovargia.recolecciones.mappers.HistorialRecoleccionRowMapper;
import com.innovargia.recolecciones.mappers.RutaRowMapper;
import com.innovargia.recolecciones.mappers.SolicitudRecoleccionRowMapper;
import com.innovargia.salesmanager.dtos.PlazaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;
import com.servicio.dtos.Movimiento;
import com.servicio.dtos.Ruta;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Repository
public class SolicitudRecoleccionDao  extends JdbcDaoSupport implements ISolicitudRecoleccionDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(SolicitudRecoleccionDao.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 */
	@Autowired
	public SolicitudRecoleccionDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}



	

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#obtieneOrdenesRecoleccionARealizar()
	 */
	@Override
	public List<SolicitudRecoleccion>  obtieneOrdenesRecoleccionARealizar() throws SQLException {
		return null;	
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#agregaRecoleccionAManifesto(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public void  agregaRecoleccionAManifesto(SolicitudRecoleccion solicitud) throws SQLException {
			String sql = "INSERT INTO remanifiesto("
				+ " idrecoleccion, manifiesto, usuariogenero,fecha) "
 				+ " VALUES (:idrecoleccion, :manifiesto,:idusuariocreador, current_date)";

			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(solicitud);

			try {
				this.namedParameterJdbcTemplate.update(sql, parameterSource);
				
				parameterSource = new BeanPropertySqlParameterSource(solicitud);
				sql = "UPDATE rerecolecciones SET manifiesto=:manifiesto WHERE idregistro=:idregistro";
				this.namedParameterJdbcTemplate.update(sql, parameterSource);
				
			} catch (DataAccessException dae) {
				logger.error("error insert:" + dae.getMessage());
				if (dae.contains(DuplicateKeyException.class)) {
					throw new DuplicateKeyException("Registro Duplicado");
				} else {
					throw new DuplicateKeyException(dae.getMessage());
				}

			}
			

	}
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#getRutasOrdenesRecoleccion(com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<SolicitudRecoleccion> getRutasOrdenesRecoleccion(UsuarioDTO usuario)  throws SQLException {
		String sql = " SELECT DISTINCT rutaasignada FROM rerecolecciones WHERE Plaza IN (SELECT DISTINCT plaza FROM " +
				"	caplazaorganizacion WHERE identidad=" + 
				usuario.entidad.getIdentidad()+" AND idorganizacion=" +
				usuario.organizacion.getIdorganizacion()+ ") AND  Fecha =current_date ";

		List<SolicitudRecoleccion> lista = new ArrayList<SolicitudRecoleccion>();
		lista = jdbcTemplate.query(sql,new SolicitudRecoleccionRowMapper());
		return lista;
		
	
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#getRutasConOrdenesRecoleccion(com.innovargia.salesmanager.dtos.UsuarioDTO, boolean)
	 */
	@Override
	public List<Ruta>  getRutasConOrdenesRecoleccion( UsuarioDTO usuario, boolean isShowAll) throws SQLException {

		List<Ruta> lista = new ArrayList<Ruta>();
		
		String sql = "SELECT distinct rutaasignada FROM rerecolecciones WHERE Fecha=current_date AND "
					+ " Plaza IN (SELECT DISTINCT idagrupador FROM caplazaorganizacion "
					+ "WHERE identidad=" +usuario.entidad.getIdentidad()+ " AND "
							+ "idorganizacion=" + usuario.organizacion.getIdorganizacion()+") ";
		if (!isShowAll){
			 sql += " AND idrecoleccion NOT IN (SELECT idrecoleccion FROM remanifiesto )";
		}
		

		lista = jdbcTemplate.query(sql,new RutaRowMapper());
		return lista;
		
		

	}
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#getPlazasOrganizacion(com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<String> getPlazasOrganizacion(UsuarioDTO usuario)  throws SQLException {
		
		List<String> plazas = new ArrayList<String>();
		
		String sql =  "SELECT DISTINCT plaza FROM caplazaorganizacion WHERE identidad=" +
				usuario.entidad.getIdentidad()+ " AND idorganizacion=" + usuario.organizacion.getIdorganizacion();
		

		plazas= jdbcTemplate.query(sql, new RowMapper<String> () {
		      public String mapRow(ResultSet resultSet, int i) throws SQLException {
		        return resultSet.getString(1);
		      }
		});
		 
		return plazas;
	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#getOrdenesRecoleccionRuta(java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<SolicitudRecoleccion>  getOrdenesRecoleccionRuta(String ruta,UsuarioDTO usuario) throws SQLException {

		List<SolicitudRecoleccion> lista = new ArrayList<SolicitudRecoleccion>();
		String sql = "";
	
		if ((ruta != null) && (ruta.trim().length() > 0)) {
			sql = "SELECT * FROM rerecolecciones WHERE rutaasignada = '" +ruta+ "' AND Fecha=current_date  AND "
							+ " rutaasignada IN (SELECT ruta FROM viewrutasplaza "
							+ " WHERE idagrupador='" +usuario.getSiglasPlaza() +"' AND " +
							"  idrecoleccion NOT IN (SELECT idrecoleccion FROM remanifiesto )"
							+ ") ";
		
		} else {
	
			sql = "SELECT * FROM rerecolecciones WHERE Fecha =current_date AND rutaasignada IN" +
					" (SELECT ruta FROM viewrutasplaza where  idagrupador='" +usuario.getSiglasPlaza() +"'"+
					" AND idrecoleccion NOT IN (SELECT idrecoleccion FROM remanifiesto )"
					+ ") ";
	
		}

		lista = jdbcTemplate.query(sql,new SolicitudRecoleccionRowMapper());
		return lista;
	
	}
	
	public List<SolicitudRecoleccion>  getOrdenesRecoleccionRuta(String ruta,String plaza, String fecha) throws SQLException {
	    String 	sql = "SELECT * FROM rerecolecciones WHERE rutaasignada = '" +ruta+ "' AND ";
	    List<SolicitudRecoleccion> lista = new ArrayList<SolicitudRecoleccion>();
	    
	    if ((fecha==null) || (fecha.trim().length()<=0)){
		sql = sql + " fecha=current_date   ";
	    }else {
		sql = sql + " fecha='"+ fecha +"'   ";
	    }
		
	    sql = sql + " AND plaza='" +plaza+"' AND " 
			 +"  idrecoleccion NOT IN (SELECT idrecoleccion FROM remanifiesto )";

		lista = jdbcTemplate.query(sql,new SolicitudRecoleccionRowMapper());
		return lista;
	
	}
	@Override
	public SolicitudRecoleccion  getSolicitudRecoleccionById(int idregistro,
		boolean isSolicitudRecoleccion) throws SQLException {
	    
        	List<SolicitudRecoleccion> lista = new ArrayList<SolicitudRecoleccion>();
        	String sql = "SELECT * FROM ";
        	if (isSolicitudRecoleccion) {
        	    sql = sql + " resolicitudrecoleccion";
        	} else {
        	    sql = sql + " rerecolecciones";
        	}
        	
        	sql = sql + " WHERE idregistro="+idregistro;
        	logger.debug("Buscarndo registro [" +sql +"]"); 
        	
        	lista = jdbcTemplate.query(sql, new SolicitudRecoleccionRowMapper());
        	
        	if (lista.size()>0){
        	    return lista.get(0);
        	}
		
        	return null;
		
	}
	
	/**
	 * Obtiene los registros de Solicitudes de Recoleccion o 
	 * Recoleccion dependiendeo de la solicitud del usuario
	 * @param solicitud
	 * @param isSolicitudRecoleccion
	 * @return
	 * @throws SQLException
	 */
	private List<SolicitudRecoleccion>  getSolicitudRecoleccion(SolicitudRecoleccion solicitud,
			boolean isSolicitudRecoleccion) throws SQLException {

		List<SolicitudRecoleccion> lista = new ArrayList<SolicitudRecoleccion>();
		
		logger.debug("getSolicitudRecoleccion->getTipoConsulta:"
				+ solicitud.getTipoConsulta());
		logger.debug("getSolicitudRecoleccion->esSolicitudRecoleccion:"
				+ solicitud.getTipoConsulta());

		String table = "rerecolecciones";
		if (isSolicitudRecoleccion) {
			table = "resolicitudrecoleccion";
		}
		String sql = "";

		try {
		
			String valor = "";
			String ini =solicitud.getFechainicio();
			String fin = solicitud.getFechafin();
			
			if (ini!=null){
			    ini= UtilsStringFechas.formatoStrFecha(solicitud.getFechainicio(), "dd/MM/yyyy", "yyyy-MM-dd") ; 
			}
			if (fin!=null){
			   fin= UtilsStringFechas.formatoStrFecha(fin, "dd/MM/yyyy", "yyyy-MM-dd") ;
			}
			
			
			
			if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_IDSOLICITUD) {
				sql = "SELECT * FROM " + table;
				valor = solicitud.getIdsolicitud();
				if (isSolicitudRecoleccion) {
					sql += " WHERE idsolicitud='" + valor+ "' ";
				}else{
					sql += " WHERE idrecoleccion='" + valor+ "' ";;
				}
				
				
			} else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_NOMBRE_SOLICITANTE) {
				valor = solicitud.getQuiensolicita();
				sql = "SELECT * FROM " + table + " WHERE quiensolicita LIKE '" +valor+ "%'";
				
			} else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_RANGOFECHAS) {


				  
				  if (isSolicitudRecoleccion) {
				    	    sql = "SELECT * FROM " + table+" WHERE fechainicio BETWEEN " +
				    		" '"+ ini +"' AND '" + fin+"' OR fechafin BETWEEN '" +ini+ "' AND '" + fin+"'";
					}else{
						sql = "SELECT * FROM " + table
							+ " WHERE fecha BETWEEN '" + ini+"' AND  '" + fin+"' ";
					}
				 
				  
			} else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_NUMEROCLIENTE) {
				valor = solicitud.getNumcliente();
				sql = "SELECT * FROM " + table + " WHERE numcliente='" + valor+"' ";
				
			} else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_CONTRATO) {
				valor = solicitud.getContrato();
				sql = "SELECT * FROM " + table + " WHERE contrato='" + valor+"' ";
				
			} else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_RAZONSOCIALRECO) {
				valor = solicitud.getRazonsocial();
				sql = "SELECT * FROM " + table + " WHERE razonsocial LIKE '" +valor+ "%'";
				
			} else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_ATENCIONRECO) {
				valor = solicitud.getPreguntarpor();
				sql = "SELECT * FROM " + table + " WHERE preguntarpor LIKE '" +valor+ "%'";
				
			} else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_IDRECOLECCION) {
				
				sql = "SELECT * FROM " + table + " WHERE ";
				if (isSolicitudRecoleccion) {
				    valor = solicitud.getIdsolicitud();
				    sql += "idsolicitud='" + valor+"' ";   
				}else{
				    valor = solicitud.getIdrecoleccion();
				    sql += "idrecoleccion='" + valor+"' "; 
				}
				
				
			}else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_MANIFIESTO) {
			    	valor = solicitud.getIdrecoleccion();
			    	if (isSolicitudRecoleccion) {
				   
				    sql = "SELECT * FROM resolicitudrecoleccion WHERE idsolicitud='" + valor+"' ";
				}else{
				  
				    sql = "SELECT * FROM rerecolecciones WHERE idrecoleccion='" + valor+"' ";
				}
				
			}else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_FECHA_INICIO_FIN) {
				
			    	if (isSolicitudRecoleccion) {
			    	    sql = "SELECT * FROM resolicitudrecoleccion WHERE fechainicio BETWEEN " +
			    		" '"+ ini +"' AND '" + fin+"' OR fechafin BETWEEN '" +ini+ "' AND '" + fin+"'";
				}else{
				    sql = "SELECT * FROM rerecolecciones WHERE fecha BETWEEN " +
				    		" '"+ ini +"' AND '" + fin+"'";
				}
			    
			}else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_DIARIA_MANIFIESTO) {
			    sql = "SELECT * FROM rerecolecciones WHERE ";
			    if ((ini==null) || (ini.trim().length()<=0)){
				 sql = sql + " fecha=current_date ";
			    }else{
				 sql = sql + "  fecha ='" +ini  +"'";
			    }
			   
			   
			    
			    sql = sql    +" and rutaasignada='"+ solicitud.getRutaasignada()+ "' AND "+
				    " plaza='" + solicitud.getPlaza() +
				    "' AND estatus NOT IN ('C', 'L') ";			
			}else if (solicitud.getTipoConsulta() == Estatus.TIPO_CONSULTA_RECOL_DIARIA_RUTA_PLAZA) {
			    sql = "SELECT * FROM rerecolecciones WHERE ";
			    sql = sql + " fecha=current_date ";
			    sql = sql    +" and rutaasignada='"+ solicitud.getRutaasignada()+ "' AND "+
				    " plaza='" + solicitud.getPlaza() + "' "; //AND estatus NOT IN ('C', 'L') ";		
			} else {
				return lista;
			}   

			lista = jdbcTemplate.query(sql,new SolicitudRecoleccionRowMapper());

			// Agrega al final un nuevo
		} catch (Exception e) {
			logger.debug("getSolicitudRecoleccion->" + e.getMessage());
		}
		return lista;
	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#getSolicitudesRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public List<SolicitudRecoleccion> getSolicitudesRecoleccion(
			SolicitudRecoleccion solicitud) throws SQLException {
		return getSolicitudRecoleccion(solicitud, true);
	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#getRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public List<SolicitudRecoleccion> getRecoleccion(
			SolicitudRecoleccion solicitud) throws SQLException {

		return getSolicitudRecoleccion(solicitud, false);
	}


	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#agregarSolicitudRecoleccion(com.administracion.dto.SolicitudRecoleccion, java.util.ArrayList)
	 */
	@Override
	public void agregarSolicitudRecoleccion(SolicitudRecoleccion solicitud,
			List<DiasSemanaMes> dias)  throws SQLException {
			
		int consecutivo = agregarSolicitudRecoleccion(solicitud);
		/*if (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA) {
			agregarDiasSemanaSolicitudRecoleccion(solicitud.getIdsolicitud(),
					dias);
		} else if (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MES) {
			agregarDiasMesSolicitudRecoleccion(solicitud.getIdsolicitud(), dias);
		}*/
	
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#updateSolicitudRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public void updateSolicitudRecoleccion(SolicitudRecoleccion solicitud)  throws SQLException {
		
	 	
    	String query ="UPDATE resolicitudrecoleccion SET " +
				"  numempleado=:numempleado, quiensolicita=:quiensolicita, correosolicita=:correosolicita, "
				+ "telefonosolicita=:telefonosolicita,  razonsocialcliente=:razonsocialcliente, " +
				" celularsolicita=:celularsolicita, numoficina=:numoficina, numcliente=:numcliente," +
				" contrato=:contrato, idtiporecol=:idtiporecol, "
				+ "idempaque=:idempaque, fechainicio='" +solicitud.getFechafin()+ "',"
				+ " fechafin='" +solicitud.getFechafin()+ "', razonsocial=:razonsocial, " +
				" preguntarpor=:preguntarpor, departamento=:departamento, calle=:calle, cp=:cp, "
				+ "colonia=:colonia, municipio=:municipio, estado=:estado, " +
				" telefono=:telefono, celular=:celular, email=:email, cantidadpzas=:cantidadpzas,"
				+ " pesokg=:pesokg, pesototal=:pesototal, alto=:alto, " +
				" ancho=:ancho, largo=:largo, volumen=:volumen, contenido=:contenido, observacion=:observacion, "
				+ "plaza=:plaza, rutaasignada=:rutaasignada, " 
				+ "latitud =:latitud,longitud= :longitud "+
				" WHERE idregistro=:idregistro";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(solicitud);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
		    
			logger.error("Error en updateEstatus: " + dae.getMessage());
			throw new SQLException(dae.getMessage());
		}
		
		
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#agregarSolicitudRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public int agregarSolicitudRecoleccion(SolicitudRecoleccion solicitud) throws SQLException {
        	if ((solicitud.getEstatus() != null)
        		&& (solicitud.getEstatus().length() > 0)) {
        	    solicitud.setEstatus(UtilsStrings.nullChangeToUpperCase(solicitud
        		    .getEstatus()));
        	} else {
        	    solicitud.setEstatus(Estatus.ESTATUS_ACTIVA);
        	}
		String sql ="INSERT INTO resolicitudrecoleccion(" +
				" idsolicitud, numempleado, quiensolicita, correosolicita, telefonosolicita, " +
				" celularsolicita, numoficina, numcliente, razonsocialcliente, " +
				" contrato, idtiporecol, idempaque, fechainicio, fechafin, razonsocial, " +
				" preguntarpor, departamento, calle, cp, colonia, municipio, estado, " +
				" telefono, celular, email, cantidadpzas, pesokg, pesototal, alto, " +
				" ancho, largo, volumen, contenido, observacion, plaza, rutaasignada, " +
				" estatus, idusuartiocreador, identidad, idorganizacion, fechacreacion, latitud, longitud)" +
				" VALUES ( :idsolicitud, :numempleado, :quiensolicita, :correosolicita, :telefonosolicita, " +
				" :celularsolicita, :numoficina, :numcliente, :razonsocialcliente, " +
				" :contrato, :idtiporecol, :idempaque, '" +solicitud.getFechainicio()+
				"', '" +solicitud.getFechafin()+ "', :razonsocial, " +
				" :preguntarpor, :departamento, :calle, :cp, :colonia, :municipio, :estado, " +
				" :telefono, :celular, :email, :cantidadpzas, :pesokg, :pesototal, :alto, " +
				" :ancho, :largo, :volumen, :contenido, :observacion, :plaza, :rutaasignada, " +
				" :estatus, :idusuariocreador, :identidad, :idorganizacion, current_timestamp,"
				+ " :latitud, :longitud)" ;
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(solicitud);
	
		try{
		
			this.namedParameterJdbcTemplate.update(sql, parameterSource,
					keyHolder, new String[] { "idregistro" });
			Number num = keyHolder.getKey();
			
			return num.intValue();
			
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
			throw new SQLException(dae.getMessage());
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#updateRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public void updateRecoleccion(SolicitudRecoleccion solicitud) throws SQLException {
		String sql = "UPDATE rerecolecciones SET "
				+ " idempaque=:idempaque, numcliente=:numcliente, quiensolicita=:quiensolicita, colonia=:colonia,"
				+ " calle=:calle, cp=:cp, municipio=:municipio, estado=:estado, telefono=:telefono, "
				+ " celular=:celular, estatus=:estatus, contrato=:contrato, "    
				+ " idtiporecol=:idtiporecol, pesokg=:pesokg,  alto=:alto,"   
				+ " ancho=:ancho,largo=:largo, volumen=:volumen, fecha='" +solicitud.getFecharecol()+ "'"
				+",  departamento=:departamento, "
				+ " preguntarpor=:preguntarpor, cantidadpzas=:cantidadpzas, idsolicitud=:idsolicitud,"
				+ " rutaasignada=:rutaasignada, email=:email, "
				+ " razonsocial=:razonsocial, observacion=:observacion, emailrecol=:correosolicita, "
				+ " contenido=:contenido,plaza=:plaza,pesototal=:pesototal,telefonosolicita=:telefonosolicita, "
				+ " celularsolicita=:celularsolicita,numoficina=:numoficina,numempleado=:numempleado,"
				+ " razonsocialcliente=:razonsocialcliente,correosolicita=:correosolicita,"
				+ " latitud =:latitud,longitud= :longitud "
				+ " WHERE idregistro=:idregistro";
		

		if ((solicitud.getEstatus()!=null) && (solicitud.getEstatus().length()>0)){
			solicitud.setEstatus( UtilsStrings.nullChangeToUpperCase(solicitud.getEstatus()));
		}else{
			solicitud.setEstatus( Estatus.ESTATUS_ACTIVA);
		}
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(solicitud);
	
		try{
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
			throw new SQLException(dae.getMessage());
		}
		

	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#agregarRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public int agregarRecoleccion(SolicitudRecoleccion solicitud)throws SQLException {
		
		String sql = "INSERT INTO rerecolecciones("
				+ "  idrecoleccion, idempaque, numcliente, quiensolicita, colonia,"
				+ " calle, cp, municipio, estado, telefono, celular, estatus, contrato, "
				+ " idtiporecol, pesokg,  alto,ancho,largo, volumen, fecha,  departamento, "
				+ " preguntarpor, cantidadpzas, idsolicitud, rutaasignada, email, "
				+ " razonsocial, observacion, emailrecol, contenido, identidad, idorganizacion,"
				+ " idusuariocreador, fechacreacion,plaza,pesototal,correosolicita," +
				"telefonosolicita,celularsolicita,numoficina,numempleado,razonsocialcliente,"
				+ " latitud, longitud)"
				+ " VALUES (:idrecoleccion, :idempaque, :numcliente, :quiensolicita, :colonia,"
				+ " :calle, :cp, :municipio, :estado, :telefono, :celular, :estatus, :contrato, "
				+ " :idtiporecol, :pesokg,  :alto,:ancho,:largo, :volumen, '" +solicitud.getFecharecol()+ "'"
				+ ",  :departamento, "
				+ " :preguntarpor, :cantidadpzas, :idsolicitud, :rutaasignada, :correosolicita, "
				+ " :razonsocial, :observacion, :email, :contenido, :identidad, :idorganizacion,"
				+ " :idusuariocreador, current_timestamp,:plaza,:pesototal,:correosolicita," +
				":telefonosolicita,:celularsolicita,:numoficina,:numempleado,:razonsocialcliente,"
				+ ":latitud, :longitud)";
		
		if ((solicitud.getEstatus()!=null) && (solicitud.getEstatus().length()>0)){
			solicitud.setEstatus( UtilsStrings.nullChangeToUpperCase(solicitud.getEstatus()));
		}else{
			solicitud.setEstatus( Estatus.ESTATUS_ACTIVA);
		}
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(solicitud);
	
		try{
			
			this.namedParameterJdbcTemplate.update(sql, parameterSource,
					keyHolder, new String[] { "idregistro" });
			Number num = keyHolder.getKey();
			return num.intValue();
			
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
			throw new SQLException(dae.getMessage());
		}
		
		
	
	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#cambiarEstatusRecoleccion(com.administracion.dto.SolicitudRecoleccion, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	//public void cambiarEstatusRecoleccion(SolicitudRecoleccion solicitud) {
	@Override
	public void cambiarEstatusRecoleccion(SolicitudRecoleccion solicitud,UsuarioDTO usuario) {
		// Crea un arreglo con los datos de los clientes
		String sql = "UPDATE rerecolecciones SET estatus='" +
			solicitud.getEstatus()
			+ "' WHERE idregistro= :idregistro ";
		//Solo cuando el usuario es de nivel Admin permite quitar esa condicion de bloqueo
		if (!usuario.perfil_Dto.getNivel().equals("A")){
			sql = sql + " AND estatus !='L'";
		}
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(solicitud);
	
		try{
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		

	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#agregarDiasSemanaSolicitudRecoleccion(java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void agregarDiasSemanaSolicitudRecoleccion(String idSolicitud,
			List<DiasSemanaMes> dias) {
		modificarDiasSemanaSolicitudRecoleccion(idSolicitud, dias);
	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#agregarDiasMesSolicitudRecoleccion(java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void agregarDiasMesSolicitudRecoleccion(String idSolicitud,
			List<DiasSemanaMes> dias) {
		modificarDiasMesSolicitudRecoleccion(idSolicitud, dias);
	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#modificarDiasSemanaSolicitudRecoleccion(java.lang.String, java.util.List)
	 */
	@Override
	public void modificarDiasSemanaSolicitudRecoleccion(String idSolicitud,
			List<DiasSemanaMes> dias) {

		try {
			String sql = "DELETE FROM rediassemanarecoleccion WHERE idsolicitud= '" + idSolicitud + "'";
			this.jdbcTemplate.update(sql);
			
			//Agrega todos los dias de la semana seleccionados
			for (DiasSemanaMes diasSemanaMes : dias) {
				sql = "INSERT INTO rediassemanarecoleccion (idsolicitud,diasemana,observacion) "
						+ " VALUES ('" + idSolicitud +"'," +diasSemanaMes.getDiasemanames() +",'" +
						diasSemanaMes.getObservacion()+ "')";
				this.jdbcTemplate.update(sql);
			}
	

		} catch (Exception e) {
			logger.error("Error en modificarDiasSemanaSolicitudRecoleccion: " + e.getMessage());
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#modificarDiasMesSolicitudRecoleccion(java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void modificarDiasMesSolicitudRecoleccion(String idSolicitud,
			List<DiasSemanaMes> dias) {
		
		try {
			String sql = "DELETE FROM rediasmesrecoleccion WHERE idsolicitud= '" + idSolicitud + "'";
			this.jdbcTemplate.update(sql);
			
			//Agrega todos los dias de la semana seleccionados
			for (DiasSemanaMes diasSemanaMes : dias) {
				sql = "INSERT INTO rediasmesrecoleccion (idsolicitud,diasemana,observacion) "
						+ " VALUES ('" + idSolicitud +"'," +diasSemanaMes.getDiasemanames() +",'" +
						diasSemanaMes.getObservacion()+ "')";
				this.jdbcTemplate.update(sql);
			}
	

		} catch (Exception e) {
			logger.error("Error en modificarDiasMesSolicitudRecoleccion: " + e.getMessage());
		}
		

	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#modificarRutaRecoleccion(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public void modificarRutaRecoleccion(String idrecoleccion, String ruta,UsuarioDTO usuario) {
		
		try {
			String sql = "UPDATE rerecolecciones SET rutaasignada='" + ruta+"' WHERE idregistro= " + idrecoleccion;
			//Solo cuando el usuario es de nivel Admin permite quitar esa condicion de bloqueo
			if (!usuario.perfil_Dto.getNivel().equals("A")){
				sql = sql + " AND estatus !='L'";
			}
			
			this.jdbcTemplate.update(sql);
			
			
		} catch (Exception e) {
			logger.error("Error en modificarRutaRecoleccion: " + e.getMessage());
		}
		
		

	}
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#modificarFechaRecoleccion(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public void modificarFechaRecoleccion(String idrecoleccion, String fecha,UsuarioDTO usuario) {

		try {
			String sql = "UPDATE rerecolecciones SET fecha='" + fecha+"' WHERE idregistro= " + idrecoleccion;
			//Solo cuando el usuario es de nivel Admin permite quitar esa condicion de bloqueo
			if (!usuario.perfil_Dto.getNivel().equals("A")){
				sql = sql + " AND estatus !='L'";
			}
			
			this.jdbcTemplate.update(sql);
			
			
		} catch (Exception e) {
			logger.error("Error en modificarFechaRecoleccion: " + e.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#modificarRutaSolicitudRecoleccion(java.lang.String, java.lang.String)
	 */
	@Override
	public void modificarRutaSolicitudRecoleccion(String idSolicitud,String ruta) {
		
		try {
			String sql = "UPDATE resolicitudrecoleccion SET rutaasignada='" + ruta+"' WHERE idregistro="+ idSolicitud;
			
			this.jdbcTemplate.update(sql);
			
			
		} catch (Exception e) {
			logger.error("Error en modificarRutaSolicitudRecoleccion: " + e.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#cambiarEstatusSolicitudRecoleccion(java.lang.String, java.lang.String)
	 */
	@Override
	public void cambiarEstatusSolicitudRecoleccion(String idSolicitud, String status) {
		try {
			String sql = "UPDATE resolicitudrecoleccion SET estatus='" + status+"' WHERE idregistro="+ idSolicitud;
			this.jdbcTemplate.update(sql);
			
			
		} catch (Exception e) {
			logger.error("Error en cambiarEstatusSolicitudRecoleccion: " + e.getMessage());
		}
	}
	

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#agregarCancelacionSolicitudRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public void agregarCancelacionSolicitudRecoleccion(SolicitudRecoleccion solicitud) {
		try {
			String sql =  "INSERT INTO recancelacion(idsolicitud, fechacancela, quiencancela, motivo)" +
					" VALUES (:idsolicitud, '"+ 
					UtilsStringFechas.formatoStrFecha(solicitud.getFechacancelacion(), "dd/MM/yyyy", "yyyy/MM/dd")
					+"', :quiencancela, :motivo)";
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(solicitud);
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
			
		} catch (Exception e) {
			logger.error("Error en agregarCancelacionSolicitudRecoleccion: " + e.getMessage());
		}
		

	}

	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#agregarMovimientoSolicitudRecoleccion(com.servicio.dtos.Movimiento)
	 */
	@Override
	public void agregarMovimientoSolicitudRecoleccion(Movimiento movimiento) {
		
		try {

			String sql =  "INSERT INTO removimientosrecol(" +
					"  idsolicitud, tipomovimiento, fecha, claveexc, ruta, empleado, " +
					" quienrechaza, motivo)" +
					" VALUES (:idsolicitud, :tipoRegistro, "
					+ "current_timestamp, :claveLogistica, :ruta, :empleado, " +
					" :quienrechaza, :motivo);";
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(movimiento);
			this.namedParameterJdbcTemplate.update(sql, parameterSource);
			
		} catch (Exception e) {
			logger.error("Error en agregarMovimientoSolicitudRecoleccion: " + e.getMessage());
		}

	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#generaOrdenesDeRecoleccionDiaria()
	 */
	@Override
	public List<SolicitudRecoleccion> generaOrdenesDeRecoleccionDiaria(){
		
		
		List<SolicitudRecoleccion> lista = new ArrayList<SolicitudRecoleccion>();
	   String sql =  "SELECT * from viewProgramacionRecolDia " +
				" WHERE fecha_recol= current_date AND idsolicitud NOT IN ( " +
				"	SELECT idsolicitud FROM rerecolecciones  WHERE fecha = current_date)";
		lista = jdbcTemplate.query(sql,new SolicitudRecoleccionRowMapper());
		return lista;
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#getProgramacionSemanal(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public List<DiasSemanaMes> getProgramacionSemanal(SolicitudRecoleccion solicitud){
		
		List<DiasSemanaMes> lista = new ArrayList<DiasSemanaMes>();
		String sql = "SELECT *  FROM "
				+ " 	rediassemanarecoleccion WHERE idsolicitud='"
				+ solicitud.getIdsolicitud() + "'";
		lista = jdbcTemplate.query(sql, new DiasSemanaRowMapper());
		return lista;

	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#getProgramacionMensual(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public List<DiasSemanaMes> getProgramacionMensual(SolicitudRecoleccion solicitud){
		
		List<DiasSemanaMes> lista = new ArrayList<DiasSemanaMes>();
		String sql = "SELECT *  FROM "
				+ " 	rediasmesrecoleccion WHERE idsolicitud='"
				+ solicitud.getIdsolicitud() + "'";
		lista = jdbcTemplate.query(sql, new DiasMesRowMapper());
		return lista;
		
		
	}
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.ISolicitudRecoleccionDAO#getHistoriaRecoelccion(java.lang.String)
	 */
	@Override
	public  List<Movimiento>  getHistoriaRecoelccion(String idrecoleccion){
		

		List<Movimiento> lista = new ArrayList<Movimiento>();
		String sql = "SELECT idsolicitud, tipomovimiento, fecha," +
	        		" claveexc, ruta, empleado, quienrechaza, motivo," +
	        		" inforegistros_maestro.descripcion FROM removimientosrecol  " +
	        		" LEFT OUTER JOIN inforegistros_maestro ON tipomovimiento=idregistro " +
	        		" WHERE idsolicitud='"+ idrecoleccion + "' ORDER BY fecha DESC ";
				
		lista = jdbcTemplate.query(sql, new HistorialRecoleccionRowMapper());
		return lista;
	
		
	}

    @Override
    public void insertDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {

	try {
	    String sql = "INSERT INTO rediassemanarecoleccion (idsolicitud,diasemana,observacion) "
		    + " VALUES ('"
		    + diasSemanaMes.getIdsolicitud()
		    + "',"
		    + diasSemanaMes.getDiasemanames()
		    + ",'"
		    + diasSemanaMes.getObservacion() + "')";
	    this.jdbcTemplate.update(sql);

	} catch (Exception e) {
	    logger.error("Error en modificarDiasSemanaSolicitudRecoleccion: "
		    + e.getMessage());
	}
    }

    @Override
    public void insertDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {

	try {
	    String sql = "INSERT INTO rediasmesrecoleccion (idsolicitud,dia,observacion) "
		    + " VALUES ('"
		    + diasSemanaMes.getIdsolicitud()
		    + "',"
		    + diasSemanaMes.getDiasemanames()
		    + ",'"
		    + diasSemanaMes.getObservacion() + "')";   
	    this.jdbcTemplate.update(sql);

	} catch (Exception e) {
	    logger.error("Error en modificarDiasSemanaSolicitudRecoleccion: "
		    + e.getMessage());
	}
    }

    @Override
    public void updateDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
	try {
	    String sql = "UPDATE  FROM rediasmesrecoleccion SET observacion=:observacion"
		    + " WHERE idregistro=:idregistro)";
	    SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		    diasSemanaMes);
	    this.namedParameterJdbcTemplate.update(sql, parameterSource);

	} catch (Exception e) {
	    logger.error("Error en agregarCancelacionSolicitudRecoleccion: "
		    + e.getMessage());
	}

    }

    @Override
    public void updateDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
	try {
	    String sql = "UPDATE  FROM rediassemanarecoleccion SET observacion=:observacion"
		    + " WHERE idregistro=:idregistro)";
	    SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		    diasSemanaMes);
	    this.namedParameterJdbcTemplate.update(sql, parameterSource);

	} catch (Exception e) {
	    logger.error("Error en agregarCancelacionSolicitudRecoleccion: "
		    + e.getMessage());
	}

    }

    @Override
    public void deleteDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
	try {
	    String sql = "DELETE FROM rediasmesrecoleccion WHERE idregistro=:idregistro";
	    SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		    diasSemanaMes);
	    this.namedParameterJdbcTemplate.update(sql, parameterSource);

	} catch (Exception e) {
	    logger.error("Error en agregarCancelacionSolicitudRecoleccion: "
		    + e.getMessage());
	}

    }

    @Override
    public void deleteDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
	try {
	    String sql = "DELETE FROM rediassemanarecoleccion WHERE idregistro=:idregistro";
	    SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		    diasSemanaMes);
	    this.namedParameterJdbcTemplate.update(sql, parameterSource);

	} catch (Exception e) {
	    logger.error("Error en agregarCancelacionSolicitudRecoleccion: "
		    + e.getMessage());
	}

    }

	    
    @Override
    public List<Ruta> obtienePlazaRutasTotal(String plaza, String fecha)
	    throws SQLException {
	String sql = " select rutaasignada as idruta, plaza,count(rutaasignada) as total from rerecolecciones "
		+ " group by  plaza,fecha ,rutaasignada having ";
	if ((fecha == null) || (fecha.trim().length() <= 0)) {
	    sql = sql + " fecha=current_date ";
	} else {
	    sql = sql + " fecha='" + fecha + "'";
	}
	if ((plaza == null) || (plaza.trim().length() <= 0)) {
	    sql = sql
		    + " AND  plaza IN (select distinct siglasplaza from caplaza )";
	} else {
	    sql = sql + " AND  plaza='" + plaza + "'";
	}

	List<Ruta> lista = jdbcTemplate.query(sql,
		new RutaPlazaTotalDTOMapper());
	return lista;
    }
	
    @Override
    public List<Ruta> obtienePlazaTotal(String plaza, String fecha)
	    throws SQLException {
	
	String sql = " select plaza, count(plaza) as total ,fecha  "
		+ "from rerecolecciones group by  plaza,fecha  having  ";
	
	if ((fecha == null) || (fecha.trim().length() <= 0)) {
	    sql = sql + " fecha=current_date ";
	} else {
	    sql = sql + " fecha='" + fecha + "'";
	}
	if ((plaza == null) || (plaza.trim().length() <= 0)) {
	    sql = sql
		    + " AND  plaza IN (select distinct siglasplaza from caplaza )";
	} else {
	    sql = sql + " AND  plaza='" + plaza + "'";
	}


	List<Ruta> lista = jdbcTemplate.query(sql,
		new RutaPlazaTotalDTOMapper());
	return lista;
    }
 
}
