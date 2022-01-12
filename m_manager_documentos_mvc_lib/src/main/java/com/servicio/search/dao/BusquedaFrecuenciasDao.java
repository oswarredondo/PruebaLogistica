package com.servicio.search.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.rowmapper.FrecuenciaCoberturaEnrutaRowMapper;
import com.administracion.rowmapper.FrecuenciaRowMapper;
import com.administracion.rowmapper.RegionalRowMapper;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.documentos.dtos.Regional;
import com.innovargia.rotulacion.dtos.CoberturaEnrutamientoTranladoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.search.idao.IBusquedaFrecuenciasDao;

/**
 *<CODE>
 * Manejo de los datos de frecuencias
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
/**
 * @author amoralesr
 */
@Repository
public class BusquedaFrecuenciasDao  extends JdbcDaoSupport implements IBusquedaFrecuenciasDao {
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaFrecuenciasDao.class);
      

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BusquedaFrecuenciasDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	/**QUERY GENERICO PARA FRECUENCIAS*/
    private String SELECT_FRECUENCIAS = "SELECT * FROM frecuenciasentrega ";
    
    
    private String SELECT_GARANTIA_REGIONALES =
    	"SELECT idregionalori,idregionaldes,IdGarantia,Mensajeria FROM zngarantiaregionales ";
    
    
    /** Query para obtener la cantidad de dias que hay de una plaza a otra*/
    /** Creates nueva instancia de UsuarioDao */
    public BusquedaFrecuenciasDao() {}
    
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
       logger.debug( mensaje);
    }//fin de debug
    
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.IFrecuenciasDao#getFrecuenciaCP(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
    @Override
	public Frecuencias getFrecuenciaCP(String cp,String idgarantia,UsuarioDTO usuario){
    	    
    	try {
    		 List<Frecuencias> _array = getFrecuenciasCP(cp, idgarantia,usuario);
        	if (_array.size()>0){
        	 return (Frecuencias)_array.get(0);
        	}
		} catch (Exception e) {
			debug("getFrecuenciaCP->No se pudo realizar la conversi�n de frecuencias:" + e.getMessage());
		}
    	
    	return null;
   	
    }//fin de getFrecuenciaCP
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.IFrecuenciasDao#getFrecuenciasCPFoliosUsuario(java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
    @Override
	public List<Frecuencias> getFrecuenciasCPFoliosUsuario(String cp, UsuarioDTO usuario)throws SQLException {
    	
    	List<Frecuencias> lista = new ArrayList<Frecuencias>();
		//String sql = "SELECT * FROM rotulacion_etiqueta_datos WHERE uuid=:uuid";
    	String sql = "SELECT frecuenciasentrega.*,caTipoGarantia.descripcion FROM" +
    			" frecuenciasentrega,caTipoGarantia where d_codigo='" +cp+ "' AND " +
    			" garantiamax IN ( SELECT substring(idservicio,1,1) FROM Folios WHERE identidad=" + usuario.entidad.getIdentidad()+" AND " +
    			"	idorganizacion=" + usuario.organizacion.getIdorganizacion() +" AND numcliente='" +usuario.getNumCliente() +"' ) " +
    			" AND frecuenciasentrega.garantiamax=caTipoGarantia.idgarantia";
    	


		lista = this.jdbcTemplate.query(sql,new FrecuenciaRowMapper());
		return lista;

    }
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.IFrecuenciasDao#getFrecuenciasCP(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
    @Override
	public List<Frecuencias> getFrecuenciasCP(String cp, String idgarantia,UsuarioDTO usuario)throws SQLException {
        
        //Obtiene los datos por codigo postal
    	String sql = "SELECT * FROM frecuenciasentrega left outer join catipogarantia " +
    			" ON frecuenciasentrega.garantiamax= catipogarantia.idgarantia " +
    			//" WHERE viewfrecuenciasentrega.identidad=" +usuario.ent+ " AND viewfrecuenciasentrega.idorganizacion=? AND d_codigo=? ";
    			" WHERE  d_codigo='" + cp +"'";
    	idgarantia = idgarantia==null?"":idgarantia;
    	
    	//Si se indica una garantia en particular se verifica como garantia maxima 
    	if ((idgarantia!=null) && (idgarantia.trim().length()>0)){
    		idgarantia = idgarantia.length()>1?idgarantia.charAt(0)+"":idgarantia;
    		sql+= " AND frecuenciasentrega.garantiamax='" +  idgarantia + "'" ;
    	}
    	
    	sql+= " ORDER BY d_codigo ASC";
    	
    	debug("getCP->sql->" + sql);
    	
    	List<Frecuencias> lista = new ArrayList<Frecuencias>();
    	lista = this.jdbcTemplate.query(sql,new FrecuenciaRowMapper());
		return lista;

    }//fin de getFrecuenciasCP
    
    @Override
    public List<CoberturaEnrutamientoTranladoDTO> getFrecuenciasOriDesCobertura(String cporigen, String cpdestino,
	    String idgarantia,UsuarioDTO usuario)throws SQLException {
	 
	idgarantia = ((idgarantia!=null) && (idgarantia.trim().length())>1)? idgarantia.trim().substring(0, 1):idgarantia;
	String sql = 
		"SELECT * FROM ( " +
		"	SELECT idori as id,cpori,idterminalori,idagrupadorori,zonaventaori," +
		"	cpdes,idterminaldes,idagrupadordes,zonaventades,rutaentrega " +
		"	 FROM ( " +
		"		select distinct 1 as idori,d_codigo as cpori,idterminal as idterminalori, " +
		"		idagrupador as idagrupadorori, zonaventa as zonaventaori " +  
		"		from frecuenciasentrega where d_codigo ='"+ cporigen + "'" +
		(idgarantia!=null && !idgarantia.trim().isEmpty()?" and garantiamax='" +idgarantia.trim() + "'":"")
		+" limit 1  " +
		"	 ) a LEFT OUTER JOIN ( " +
		"		select distinct 1 as iddes,d_codigo as cpdes,idterminal as idterminaldes, " +
		"		idagrupador as idagrupadordes, zonaventa as zonaventades, ruta as rutaentrega  " +
		"		from frecuenciasentrega where d_codigo ='"+ cpdestino +"'";
	
		//Agrega la garantia
		if (idgarantia!=null){
		    if (!idgarantia.trim().isEmpty()){
			 sql+=   " and garantiamax='" +idgarantia.trim() + "' limit 1 " ;
		    }
		   
		}
		
		sql+="	) b ON a.idori=  b.iddes " +
		" ) c LEFT OUTER JOIN cacruceoperacion ON c.idterminalori= cacruceoperacion.idcoorigen AND " +
//		" c.idterminalori= cacruceoperacion.idcodestino" ;
	    " c.idterminaldes= cacruceoperacion.idcodestino" ;
		
		if (idgarantia!=null){
		    if (!idgarantia.trim().isEmpty()){
			 sql+=   " and garantiamax='" +idgarantia.trim() + "' " ;
		    }
		   
		}
		
		logger.debug("SQL:" + sql);
		
		List<CoberturaEnrutamientoTranladoDTO> lista = new ArrayList<CoberturaEnrutamientoTranladoDTO>();
	    	lista = this.jdbcTemplate.query(sql,new FrecuenciaCoberturaEnrutaRowMapper());
		return lista;
    }
    
    
    
    /* (non-Javadoc)
   	 * @see com.servicio.search.dao.IFrecuenciasDao#getFrecuenciasCP(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
   	 */
       @Override
   	public Frecuencias getFrecuenciasEntregaCP(String cp)throws SQLException {
           
           //Obtiene los datos por codigo postal
       	String sql = "SELECT * FROM frecuenciasentrega left outer join catipogarantia " +
       			" ON frecuenciasentrega.garantiamax= catipogarantia.idgarantia " +
       			" WHERE  d_codigo='" + cp+ "'";
   
       	sql+= " ORDER BY d_codigo ASC";
       	
       	debug("getCP->sql->" + sql);
       	
       	List<Frecuencias> lista = new ArrayList<Frecuencias>();
       	lista = this.jdbcTemplate.query(sql,new FrecuenciaRowMapper());
       	if (lista.size()>0){
       		return lista.get(0);
       	}
   		return null;

       }//fin de getFrecuenciasCP

    /* (non-Javadoc)
	 * @see com.servicio.search.dao.IFrecuenciasDao#getGarantiaRegional(int, int)
	 */
    @Override
	public Regional getGarantiaRegional(int regionalOri,int regionalDes){

    	List<Regional> lista = new ArrayList<Regional>();
		//String sql = "SELECT * FROM rotulacion_etiqueta_datos WHERE uuid=:uuid";
    	String sql = SELECT_GARANTIA_REGIONALES + 
    			" WHERE idregionalori=" + regionalOri+" AND idregionaldes="+regionalDes;   	


		lista = this.jdbcTemplate.query(sql,new RegionalRowMapper());
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
	
    }//fin de getGarantiaRegional
    
    @Override
    public Frecuencias getRutaAsignada(String cp)throws SQLException {
         
        //Obtiene los datos por codigo postal
    	String sql = "SELECT * FROM frecuenciasentrega  WHERE  d_codigo='" + cp +"'";
      	sql+= " ORDER BY d_codigo ASC";
    	debug("getCP->sql->" + sql);
    	
    	List<Frecuencias> lista = new ArrayList<Frecuencias>();
    	lista = this.jdbcTemplate.query(sql,new FrecuenciaRowMapper());
    	if (lista.size()>0){
    	    return lista.get(0);
    	}
	return null;

    }//fin de getFrecuenciasCP

    
}//fin de ServiciosDao
