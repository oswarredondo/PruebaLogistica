
package com.administracion.dao;

import java.sql.Connection;
import java.sql.SQLException;
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

import com.administracion.dto.Folios;
import com.administracion.idao.IFoliosDAO;
import com.administracion.rowmapper.FoliosRowMapper;
import com.innovargia.constantes.ConstantesUtils;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

@Repository
public class FoliosDAO extends JdbcDaoSupport implements IFoliosDAO {
    
    /**Query Generico para obtener los datos de folios*/
    public static String SELECT_FOLIOS =
    "SELECT NumCliente,IdServicio,CantidadAsiganda,CantidadUtilizada,Peso FROM Folios ";
    
    public static String SELECT_FOLIOS_PC ="SELECT NumCliente,FechaCreacion,Cantidad,"+
    "RangoEncriptado,ClaveUnica,IdServicio,Inicia,Termina FROM FoliosPC ";
    
	private static final Logger logger = LoggerFactory
			.getLogger(FoliosDAO.class);
    

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public FoliosDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
    //Obtiene el log de la aplicacion
    //private Logger logger = Bitacora.getBitacora();
    
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
        logger.debug(mensaje);
    }//fin de debug
    
    /* (non-Javadoc)
	 * @see com.administracion.dao.IFoliosDAO#getFolios(java.lang.String, int, int)
	 */
    @Override
	public  List<Folios> getFolios(String cliente, int identidad, int idorganizacion, String login) throws SQLException {

     	  String sql =
     			  " SELECT 'FOLIOS' AS tiporotulacion,catiposervicio.idservicio,catiposervicio.descripcion,catiposervicio.tipocobro,"+
     			  " catiposervicio.generaretorno,numcliente,cantidadasiganda, Folios.cantidadutilizada,Folios.peso"+ 
     			  " FROM catiposervicio , Folios where catiposervicio.idservicio = Folios.idservicio "+
     			  " AND catiposervicio.identidad= Folios.identidad AND catiposervicio.idorganizacion=Folios.idorganizacion"+
     			  " AND Folios.identidad=? AND Folios.idorganizacion=? AND numcliente=? AND "+
     			  " Folios.CantidadUtilizada<Folios.CantidadAsiganda AND Folios.idservicio IN ("+
     			  " 	SELECT idservicio from opusuarios_folios_servicio WHERE identidad=? AND"+
     			  " idorganizacion=? AND numcliente=? AND login=? " +
     			  " )  ORDER BY idservicio ";
     			  
     			  ;

    	List<Folios>  lista = this.jdbcTemplate.query(sql,new Object[]{
    			identidad, idorganizacion,cliente,	identidad, idorganizacion,cliente,login
    	},new FoliosRowMapper());
    	
    	for (Folios folio : lista) {
    		  folio.entidad.setIdentidad(identidad);
    	         folio.organizacion.setIdentidad(idorganizacion);
		}
    	
    	return lista;
    }
    @Override
   	public  List<Folios> getConvenios(String cliente, int identidad, int idorganizacion, String login, String tipo_formulario) throws SQLException {
       	
    	 //Solo folios que caigan dentro del rango de fechas y este autorizado(estatus=3)
  	  String sql =
  			 " 	SELECT 'CONVENIO' AS tipoRotulacion,idconveniodetalle,convenios.numcliente,convenios.idconvenio || '-' || convenios.idtarifa ||'-' "
  			 + "	|| idconveniodetalle || '-'||  catarifas.idservicio  as idservicio,"+
  			 " 	catarifas.nombre || '-' || catarifas.idservicio || '[Peso:' || peso || ',Cob. Km:' || coberturakm || ']' as descripcion  FROM ( "+		 
  			// " 	catarifas.nombre || '-' || catarifas.idservicio || '[Peso:' || peso || ',Cob. Km:' || coberturakm || ',Precio:$'||precio || ']' as descripcion  FROM ( "+
  			 " 			select idconveniodetalle, caconvenio.numcliente,caconvenio.idtarifa,caconveniodetalle.idconvenio, "+
  			 " 			caconveniodetalle.peso, caconveniodetalle.precio,caconveniodetalle.sobrepeso, "+
  			 " 			caconveniodetalle.coberturakm from  caconveniodetalle left outer join caconvenio "+
  			 " 			ON caconveniodetalle.idconvenio = caconvenio.idconvenio where "+
  			 " 			  current_date>=caconvenio.fechainicio   and current_date<=caconvenio.fechatermino  "+
  			 " 			AND caconvenio.estatus IN (?) AND caconvenio.idconvenio IN ( "+
  			 " 					SELECT opusuarios_convenios.idconvenio from opusuarios_convenios WHERE identidad=? AND idorganizacion=? AND numcliente=? AND login=? "+
  			 " 					) "+
  			 " 			) convenios left outer join catarifas on convenios.idtarifa = catarifas.idtarifa ";
 
    	/* CAMBIO COBRO POR ZONAS 
	  String sql =
		"SELECT 'CONVENIO' AS tipoRotulacion,idconvenio as idconveniodetalle,c.numcliente,c.idconvenio || '-' || c.idtarifa ||'-' || c.idrangoenvios || '-'||  t.idservicio as idservicio, '[' || s.nombre || '-' || t.nombre || '-' || t.descripcion || ']' as descripcion FROM " 
		+ "caconvenio AS c INNER JOIN catarifas AS t ON c.idtarifa = t.idtarifa INNER JOIN catiposervicio AS s ON t.idservicio = s.idservicio where current_date>=c.fechainicio   and current_date<=c.fechatermino  AND c.estatus "
		+ "IN (?) AND c.idconvenio IN ( "
		+ "SELECT opusuarios_convenios.idconvenio from opusuarios_convenios WHERE identidad=? AND idorganizacion=? AND numcliente=? AND login=? "
		+ ") ";
  	  if(tipo_formulario.equals("PAQUETE")){
  		  	  sql+= " AND t.idservicio IN ('10','20','40')";
    	  }else{
    		  sql+= " AND t.idservicio IN ('30')";
    	  }
    	 FIN CAMBIO COBRO POR ZONAS */
  	logger.debug("En getConvenios:" + sql);
       	List<Folios>  lista = jdbcTemplate.query(sql,new Object[]{
       			ConstantesUtils.ESTATUS_AUTORIZADO ,identidad, idorganizacion,cliente, login
       	},new FoliosRowMapper());
       	
       	for (Folios folio : lista) {
       		  folio.entidad.setIdentidad(identidad);
       	         folio.organizacion.setIdentidad(idorganizacion);
   		}
       	
       	return lista;
       }//fin
    
    @Override
	public  List<Folios> getConveniosAutoDocPDV(UsuarioDTO usuario) throws SQLException {
   	
	 //Solo folios que caigan dentro del rango de fechas y este autorizado(estatus=3)
	  String sql =
			 " 	SELECT 'CONVENIO' AS tipoRotulacion,idconveniodetalle,convenios.numcliente,convenios.idconvenio || '-' || convenios.idtarifa ||'-' "
			 + "	|| idconveniodetalle || '-'||  catarifas.idservicio  as idservicio,"+
			// " 	catarifas.nombre || '-' || catarifas.idservicio || '[Peso:' || peso || ',Cob. Km:' || coberturakm || ',Precio:$'||precio || ']' as descripcion,idconvenio   FROM ( "+
			 " 	catarifas.nombre || '-' || catarifas.idservicio || '[Peso:' || peso || ',Cob. Km:' || coberturakm  || ']' as descripcion,idconvenio   FROM ( "+
			 " 			select idconveniodetalle, caconvenio.numcliente,caconvenio.idtarifa,caconveniodetalle.idconvenio, "+
			 " 			caconveniodetalle.peso, caconveniodetalle.precio,caconveniodetalle.sobrepeso, "+
			 " 			caconveniodetalle.coberturakm, caconvenio.tipo_contrato,"
			 + "			 caconvenio.idoficinacontrol, getidoficinacontrolconvenio(caconveniodetalle.idconvenio)"
			 + "				 from  caconveniodetalle left outer join caconvenio "+
			 " 			ON caconveniodetalle.idconvenio = caconvenio.idconvenio where caconvenio.idconvenio="+ usuario.getIdconvenio() +
			 " 			AND  current_date>=caconvenio.fechainicio   and current_date<=caconvenio.fechatermino  "+
			 " 			AND caconvenio.estatus IN (?) AND caconvenio.idconvenio IN ( "+
			 " 					SELECT opusuarios_convenios.idconvenio from opusuarios_convenios "
			 + "		WHERE identidad=? AND idorganizacion=? AND numcliente=? AND login=? "+
			 " 					) "+
			 " 			) convenios left outer join catarifas on convenios.idtarifa = catarifas.idtarifa ";
	  
	logger.debug("En getConvenios:" + sql);
	
   	List<Folios>  lista = jdbcTemplate.query(sql,new Object[]{
   			ConstantesUtils.ESTATUS_AUTORIZADO,
   			usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion(),
   		usuario.getNumCliente(), usuario.getLogin()
   	},new FoliosRowMapper());
   	
   	for (Folios folio : lista) {
   	    folio.entidad.setIdentidad(usuario.entidad.getIdentidad());
   	    folio.organizacion.setIdentidad( usuario.organizacion.getIdorganizacion());
	}
   	
   	return lista;
   }//fin
    /* (non-Javadoc)
	 * @see com.administracion.dao.IFoliosDAO#getFoliosPCUltimo(java.lang.String)
	 */
    @Override
	public int getFoliosPCUltimo(String servicio) throws SQLException {
    	
    	return 1;
    }//fin de getFoliosPCUltimo
    
    /* (non-Javadoc)
	 * @see com.administracion.dao.IFoliosDAO#getFoliosAdmin(java.lang.String)
	 */
    @Override
	public  List<Folios> getFoliosAdmin(String cliente) throws SQLException {
		String sql = "SELECT Folios.*, caTipoServicio.descripcion as descripcionservicio FROM "
				+ "Folios left outer join caTipoServicio ON "
				+ "Folios.idservicio = caTipoServicio.idservicio WHERE numcliente=? ORDER BY IdServicio";

		List<Folios> lista = jdbcTemplate.query(sql, new Object[] { cliente },
				new FoliosRowMapper());
		return lista;
    	
    }//fin de getFoliosAdmin
    
    /* (non-Javadoc)
	 * @see com.administracion.dao.IFoliosDAO#getFoliosPC(java.lang.String)
	 */
    @Override
	public  List<Folios> getFoliosPC(String cliente) throws SQLException {

    	return null;
    }//fin de getFoliosAdmin
    /* (non-Javadoc)
	 * @see com.administracion.dao.IFoliosDAO#updateEnviosDisponibles(int, int, java.lang.String, java.lang.String, int, java.sql.Connection)
	 */
    @Override
	public void updateEnviosDisponibles(int entidad,int organizacion,String idServicio, 
			String cliente,int peso,Connection cnx ) throws SQLException {
        
    	
    	String query ="UPDATE Folios SET CantidadUtilizada=CantidadUtilizada+1 " +
    	        //" WHERE NumCliente=? AND IdServicio=? AND Peso=? AND identidad=? AND idorganizacion=?";
    	        " WHERE NumCliente=? AND IdServicio=? AND identidad=? AND idorganizacion=? "
    	        + " AND cantidadasiganda>CantidadUtilizada";
    	
    	logger.debug("cliente:" + cliente + ",idServicio:" + idServicio+ ",peso:" + peso+",entidad: " +entidad+",organizacion:" + organizacion);
    	logger.debug("query updateEnviosDisponiblesRetorno:" + query);
		int cantidad = this.jdbcTemplate.update(query, new Object[]{cliente,idServicio,entidad,organizacion});
		if (cantidad==0){
			throw new SQLException("Folios no disponibles para la impresion solicitada");
		}
		
        	
    }//fin de getListaUsuarios
    
    /* (non-Javadoc)
	 * @see com.administracion.dao.IFoliosDAO#updateEnviosDisponiblesRetorno(int, int, java.lang.String, java.lang.String, int, java.sql.Connection)
	 */
    @Override
	public void updateEnviosDisponiblesRetorno(int entidad,int organizacion,
			String idServicio, String cliente,int peso,Connection cnx ) throws SQLException {
        
    	String query ="UPDATE Folios SET CantidadUtilizada=CantidadUtilizada+1 " +
    	        " WHERE NumCliente=? AND IdServicio=?  AND identidad=? AND idorganizacion=?";

    	logger.debug("query updateEnviosDisponiblesRetorno:" + query);
		this.jdbcTemplate.update(query, new Object[]{cliente,idServicio,entidad,organizacion});
		
    
    }//fin de getListaUsuarios
    
    /* (non-Javadoc)
	 * @see com.administracion.dao.IFoliosDAO#isEnviosDisponibles(java.lang.String, java.lang.String, int)
	 */
    @Override
	public boolean isEnviosDisponibles(String idServicio, String cliente, int peso ) throws SQLException {
        
    	String sql =  SELECT_FOLIOS + " WHERE NumCliente=? AND IdServicio=? AND " +
    	        " CantidadUtilizada<CantidadAsiganda AND Peso=? " +
    	        " ORDER BY IdServicio";

		List<Folios> lista = jdbcTemplate.query(sql, new Object[] { cliente,idServicio, peso},
				new FoliosRowMapper());
		if (lista.size()>0){
			return true;
		}
		return false;
    
    }//fin de getListaUsuarios
    
    //////
    /* (non-Javadoc)
	 * @see com.administracion.dao.IFoliosDAO#isExisteRangoWeb(java.lang.String, java.lang.String, int)
	 */
    @Override
	public boolean isExisteRangoWeb(String idServicio, String cliente, int peso ) throws SQLException {
    	return isEnviosDisponibles(idServicio,cliente,peso);
    }//fin de getListaUsuarios
    
    
    /**
     * Aumenta el contador de los envios utilizados, utilizado en el modulo de administracion
     * @param idServicio identificador del servicio
     * @param cliente identificador del cliente (numero de cliente)
     * @throws SQLException
     * @return true si existen a�n envio, false en caso contrario
     */
    @Override
	public void updateEnviosDisponibles(Folios folios ) throws SQLException {
    	
    	String query = "UPDATE Folios SET CantidadAsiganda=CantidadAsiganda + ? " +
    	        " WHERE NumCliente=? AND IdServicio=? AND Peso=?";

		this.jdbcTemplate.update(query, new Object[]{folios.getCantidadAsignada(),folios.getNumCliente(),folios.getIdServicio(),folios.getPeso()});
        
   
    }//fin de updateEnviosDisponibles
    
    @Override
   	public Folios getFoliosDisponibles(String idservicio, String numcliente, 
   			int peso_amparado, int identidad, int idorganizacion) throws SQLException {
       	
       	String sql = "SELECT  * from Folios " +
       	        " WHERE NumCliente=? AND IdServicio=? AND identidad=? AND idorganizacion=?";
       

		List<Folios> lista = jdbcTemplate.query(sql,new Object[]{numcliente,idservicio,identidad,idorganizacion},
				new FoliosRowMapper());
           
			if (lista.size()>0){
				return lista.get(0);
			}
			
			return null;
      
       }//fin de updateEnviosDisponibles
    /**
     * Inicializa a cero el valor de los consecutrivos utilizados por el usuario
     * @param idServicio identificador del servicio
     * @param cliente identificador del cliente (numero de cliente)
     * @throws SQLException
     * @return true si existen a�n envio, false en caso contrario
     */
    @Override
	public void initUtilizadas(Folios folios ) throws SQLException {
    	
    	String query =  "UPDATE Folios SET CantidadUtilizada=0 " +
    	        " WHERE NumCliente=? AND IdServicio=? AND Peso=?";

		this.jdbcTemplate.update(query, new Object[]{folios.getNumCliente(),folios.getIdServicio(), folios.getPeso() });
		
        
   }//fin de updateEnviosDisponibles
    
    /**
     * Borra el registro de rangos de folios
     * @param idServicio identificador del servicio
     * @param cliente identificador del cliente (numero de cliente)
     * @throws SQLException
     * @return true si existen a�n envio, false en caso contrario
     */
    @Override
	public void deleteRangoFolios(Folios folios ) throws SQLException {
    	
    	String query =  "DELETE FROM Folios WHERE NumCliente=? AND IdServicio=? AND Peso=?";

		this.jdbcTemplate.update(query, new Object[]{folios.getNumCliente(),folios.getIdServicio(), folios.getPeso() });

    }//fin de updateEnviosDisponibles
    /**
     * Aumenta el contador de los envios utilizados
     * @param idServicio identificador del servicio
     * @param cliente identificador del cliente (numero de cliente)
     * @throws SQLException
     * @return true si existen a�n envio, false en caso contrario
     */
    @Override
	public void incrementaFoliosWeb(Folios folios) throws SQLException {
    	
    	String query = "UPDATE Folios SET CantidadUtilizada=CantidadUtilizada+? " +
    	        " WHERE NumCliente=? AND IdServicio=? AND Peso=?";

		this.jdbcTemplate.update(query, new Object[]{folios.getCantidadAsignada(),folios.getNumCliente(),
				folios.getIdServicio(), folios.getPeso() });

    }//fin de getListaUsuarios
    
    /**
     * Inserta un registro de Folios en el Web
     * @param folios datos de un folios de servicios asiganda al Web
     * @throws SQLException
     * @return true si existen a�n envio, false en caso contrario
     */
    @Override
	public void insertFoliosWeb(Folios folios ) throws SQLException {
        
     	String query = "INSERT INTO folios(numcliente, idservicio, cantidadasiganda, " +
           		"cantidadutilizada, peso, identidad, idorganizacion) " +
           		" VALUES (?, ?, ?, ?, ?, ?, ?)";
        

		this.jdbcTemplate.update(query, new Object[]{
				folios.getNumCliente(),
				folios.getIdServicio(),
				folios.getCantidadAsignada(),
				folios.getCantidadUtilizada(),
				folios.getPeso(),
				folios.entidad.getIdentidad(),
				folios.organizacion.getIdorganizacion() 
				
		});
		

    }//fin de getListaUsuarios
    
    /**
     * Inserta un registro de Folios en el Web
     * @param folios datos de un folios de servicios asiganda al Web
     * @throws SQLException
     * @return true si existen a�n envio, false en caso contrario
     */
    @Override
	public void insertLogFoliosWeb(Folios folios,String evento ) throws SQLException {
    	
    	String query = "INSERT INTO Log_Folios VALUES(?,?,?,?,0,getDate(),?,?)";
        

		this.jdbcTemplate.update(query, new Object[]{
				folios.getNumCliente(),
				folios.getIdServicio(),
				folios.getPeso(),
				folios.getCantidadAsignada(),
				evento,
				folios.getFactura()
				
		});
		
        
  
    }//fin de getListaUsuarios
    
    /**
     * Inserta un registro de Folios para la PC
     * @param folios datos de un folios de servicios asiganda al Web
     * @throws SQLException
     * @return true si existen a�n envio, false en caso contrario
     */
    @Override
	public void insertFoliosPC(Folios folios ) throws SQLException {  }
    
    /* (non-Javadoc)
	 * @see com.administracion.dao.IFoliosDAO#getConsecutivo()
	 */
    @Override
	public String getConsecutivo() throws SQLException {
    	
    	KeyHolder keyHolder = new GeneratedKeyHolder();
		 String query = "INSERT INTO Consecutivo (iddocumento) VALUES('registro')"; 
		try {
			MetaDatoCatalogoDTO meta = new MetaDatoCatalogoDTO();
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
					meta);
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "Consecutivo" });
			Number consecutivo=  keyHolder.getKey();
			return ""+consecutivo.intValue();
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
	 * @see com.administracion.dao.IFoliosDAO#getMaxFechaFolios(java.lang.String)
	 */
    @Override
	public String getMaxFechaFolios(String cliente) throws SQLException {
        
    	return null;
    }//fin de getFoliosAdmin
    
    
}//fin de UsuarioDao
