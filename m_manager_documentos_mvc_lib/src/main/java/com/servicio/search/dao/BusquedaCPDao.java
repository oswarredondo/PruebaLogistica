package com.servicio.search.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.rowmapper.CPRowMapper;
import com.administracion.rowmapper.DireccionCodigoPostalRowMapper;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.utils.JsonPrint;
import com.servicio.search.idao.IBusquedaCPDao;

/**
 *<CODE>
 * Manejo de los datos de C�digos Postales
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@Repository
public class BusquedaCPDao  extends JdbcDaoSupport implements IBusquedaCPDao{
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaCPDao.class);
    

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BusquedaCPDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	private static String SELECT_CP = "SELECT DISTINCT d_codigo,d_asenta,d_mnpio,d_estado," +
			"d_ciudad,c_estado,c_mnpio FROM znsepomexinfo ";	
	
    private static String SELECT_MUNICIPIOS = "SELECT DISTINCT c_mnpio,municipio," +
    		"estado,c_estado FROM viewznmunicipios ";
    
   
    
    //Obtiene el log de la aplicacion
    //  private Logger logger = Bitacora.getBitacora();
    
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
    	logger.debug( mensaje);
    }//fin de debug
       
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getInfoCP(java.lang.String)
	 */
    @Override
	public CPs getInfoCP(String cp)throws SQLException {
        
    	 List<CPs> cps =  getCPs( cp);
    	
    	if (cps.size()>0){
    		return (CPs)cps.get(0);
    	}
    	return null;
    }//fin de getCPs
    ///////////////////////////////////////////////////////////////////
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getCPs(java.lang.String)
	 */
    @Override
	public  List<CPs> getCPs(String cp)throws SQLException {
    	
		String sql = SELECT_CP + " WHERE d_codigo = ? ";

		List<CPs> lista = jdbcTemplate.query(sql, new Object[] { cp },
				new CPRowMapper());

		return lista;
    }//fin de getCPs
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#isExistCP(java.lang.String)
	 */
    @Override
	public boolean isExistCP(String cp)throws SQLException {
        
        String sql = SELECT_CP + " WHERE d_codigo = ? ";

    	 List<CPs>  lista = getCPs(cp);
    	 if (lista.size()>0){
    		 return true; 
    	 }
    	  return false;
      
     
    }//fin de isExistCP
    
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getMunicpioEstadoDelCP(java.lang.String)
	 */
    @Override
	public CPs getMunicpioEstadoDelCP(String cp)throws SQLException {
        
       
        try {
        	 List<CPs>  lista = getCPs(cp);
        	
        	if (lista.size()>0){
        		return (CPs)lista.get(0);
        	}
        } catch (SQLException sq) {
            throw sq;
        } 
       return null;
    }//fin de isExistCP
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getInfoCP(java.lang.String, int)
	 */
    @Override
	public String getInfoCP(String cp, int etiqueta)throws SQLException {
        
       
        try {
        	
        	 List<CPs>  lista = getCPs(cp);
        	
        	if (lista.size()>0){
        		CPs cp_encontrado = (CPs)lista.get(0);
        		
        		if (cp_encontrado!=null){
        			switch (etiqueta) {
					case ESTADO:
						return cp_encontrado.getEstado();
					case MUNICIPIO:
						return cp_encontrado.getMunicipio();
					case REGIONAL:
						return cp_encontrado.getRegional()+"";
					case SIGLASEST:
						return cp_encontrado.getSiglasEst();
					default:
						break;
					}
        		}
        		
        	}
        } catch (SQLException sq) {
            throw sq;
        } 
       return null;
    }//fin de isExistCP
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getColonias(java.lang.String)
	 */
    @Override
	public  List<CPs>  getColonias(String colonia)throws SQLException {
        
        if (colonia!=null){
            colonia = colonia.toUpperCase();
        }
        
		String sql =  SELECT_CP + " WHERE d_asenta LIKE :colonia";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("colonia", colonia+"%");
        logger.debug("SQL:" + sql);
        JsonPrint.show(params);
		List<CPs> lista = this.namedParameterJdbcTemplate.query(sql,params,new CPRowMapper());

		return lista;
		
        
     
    }//fin de getColonias
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getMuniciposEstado(java.lang.String)
	 */
    @Override
	public List<CPs> getMuniciposEstado(String estado)throws SQLException {
        
        
        String sql = SELECT_MUNICIPIOS + " WHERE siglasest LIKE :estado";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("estado", estado+"%");

        logger.debug("SQL:" + sql);
        JsonPrint.show(params);
        
		List<CPs> lista = this.namedParameterJdbcTemplate.query(sql,params,new CPRowMapper());

		return lista;
		
    }//fin de getColonias
    
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getColoniasMunicipo(java.lang.String)
	 */
    @Override
	public List<CPs> getColoniasMunicipo(String municipio)throws SQLException {
        
        
        String sql = SELECT_CP + " WHERE d_mnpio LIKE :municipio";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("municipio", municipio+"%");
        
        logger.debug("SQL:" + sql);
        JsonPrint.show(params);
        
    	List<CPs> lista = this.namedParameterJdbcTemplate.query(sql,params,new CPRowMapper());

		return lista;
    }//fin de getColonias
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getEstado()
	 */
    @Override
	public  List<CPs> getEstado()throws SQLException {
        //DE UTILIZA   caEstado ya que la vista es demasiada pesada 
    	//y no se viualiza de forma rapida los estados
        String sql = "SELECT * FROM znEstado";
        
        logger.debug("SQL:" + sql);
       
        
        List<CPs> lista = jdbcTemplate.query(sql,new CPRowMapper());

		return lista;
		
       
    }//fin de getColonias
    
  
   
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getCiudad(com.innovargia.documentos.dtos.CPs)
	 */
    @Override
	public CPs getCiudad(CPs cp) throws SQLException {
        
        
        String sql = "SELECT * FROM znsepomexinfo WHERE d_codigo=?";
        logger.debug("SQL:" + sql);
       
        
        List<CPs> lista = jdbcTemplate.query(sql,new Object[]{cp.getCp()},new CPRowMapper());
        if (lista.size()>0){
        	return lista.get(0);
        }
        return null;
      
    }//fin de getCiudad
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICPDao#getCP(java.lang.String, java.lang.String)
	 */
    @Override
	public CPs getCP(String id,String colonia)throws SQLException {
        
        String sql = "SELECT * FROM znsepomexinfo WHERE d_codigo = ?  AND d_asenta=? ";
        logger.debug("SQL:" + sql);
      
        
        List<CPs> lista = jdbcTemplate.query(sql,new Object[]{id, colonia},new CPRowMapper());
        if (lista.size()>0){
        	return lista.get(0);
        }
        return null;
        
    
    }//fin de getCP
    
    @Override
	public List<DireccionDTO> getDatosDireccionCP(BusquedaDTO busqueda)
			throws Exception {
		List<DireccionDTO> lista = new ArrayList<DireccionDTO>();
		String sql =" SELECT DISTINCT d_codigo,d_asenta,d_mnpio,d_estado,d_ciudad,c_estado,c_mnpio FROM znsepomexinfo ";
		

			if (busqueda.getTipo_str().equals("cp")){
				sql = sql + " WHERE d_codigo=:patron";
			}else if (busqueda.getTipo_str().equals("colonia")){
				busqueda.setPatron_busqueda(busqueda.getPatron_busqueda()+ "%");
				sql = sql + " WHERE d_asenta LIKE :patron";
			}else if (busqueda.getTipo_str().equals("municipio")){
				busqueda.setPatron_busqueda(busqueda.getPatron_busqueda()+ "%");
				sql = sql + " WHERE d_mnpio LIKE :patron'";
			}else if (busqueda.getTipo_str().equals("estado")){
				busqueda.setPatron_busqueda(busqueda.getPatron_busqueda()+ "%");
				sql = sql + " WHERE d_estado LIKE ':patron";
			}
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("patron", busqueda.getPatron_busqueda());
		
		logger.debug("sql:" + sql);
		JsonPrint.show(params);
		lista = this.namedParameterJdbcTemplate.query(sql,params, new DireccionCodigoPostalRowMapper());
		return lista;
	}


}//fin de CPDao
