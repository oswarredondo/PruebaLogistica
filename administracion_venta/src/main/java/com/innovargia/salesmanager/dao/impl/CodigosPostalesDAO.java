package com.innovargia.salesmanager.dao.impl;

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

import com.administracion.rowmapper.CPRowMapper;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.salesmanager.idao.ICodigosPostalesDAO;
import com.innovargia.salesmanager.mappers.CodigoPostalRowMapper;

@Repository
public class CodigosPostalesDAO extends JdbcDaoSupport implements  ICodigosPostalesDAO { 

	
	private static final Logger logger = LoggerFactory
			.getLogger(CodigosPostalesDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	private static String SELECT_CP = "SELECT DISTINCT d_codigo,d_asenta,d_mnpio,d_estado," +
		"d_ciudad,c_estado,c_mnpio FROM znsepomexinfo ";	

private static String SELECT_MUNICIPIOS = "SELECT DISTINCT c_mnpio,municipio," +
		"estado,c_estado FROM viewznmunicipios ";


	@Autowired
	public CodigosPostalesDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(DireccionDTO catalogo) throws Exception {
		
		
	}

	@Override
	public void update(DireccionDTO catalogo) throws Exception {
	
		
	}

	@Override
	public void updateEstatus(DireccionDTO catalogo) throws Exception {
	
		
	}

	@Override
	public void delete(DireccionDTO catalogo) throws Exception {
	
	}

	@Override
	public List<DireccionDTO> getRegistros(BusquedaDTO busqueda)
			throws Exception {
		List<DireccionDTO> lista = new ArrayList<DireccionDTO>();
		String sql =" SELECT DISTINCT d_codigo,d_asenta,d_mnpio,d_estado,d_ciudad,c_estado,c_mnpio FROM znsepomexinfo ";
		

			if (busqueda.getTipo_str().equals("cp")){
				sql = sql + " WHERE d_codigo='" + busqueda.getPatron_busqueda() +"'";
			}else if (busqueda.getTipo_str().equals("colonia")){
				sql = sql + " WHERE d_asenta LIKE '" + busqueda.getPatron_busqueda() +"%'";
			}else if (busqueda.getTipo_str().equals("municipio")){
				sql = sql + " WHERE d_mnpio LIKE '" + busqueda.getPatron_busqueda() +"%'";
			}else if (busqueda.getTipo_str().equals("estado")){
				sql = sql + " WHERE d_estado LIKE '" + busqueda.getPatron_busqueda() +"%'";
			}
		
		
		lista = jdbcTemplate.query(sql,new CodigoPostalRowMapper());
		return lista;
	}

	@Override
	public DireccionDTO get(DireccionDTO catalogo) throws Exception {
		return null;
	}
	
	
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
	        
			String sql =  SELECT_CP + " WHERE d_asenta LIKE '" + colonia + "%'";

			List<CPs> lista = jdbcTemplate.query(sql,new CPRowMapper());

			return lista;
			
	        
	     
	    }//fin de getColonias
	    
	    /* (non-Javadoc)
		 * @see com.servicio.search.dao.ICPDao#getMuniciposEstado(java.lang.String)
		 */
	    @Override
		public List<CPs> getMuniciposEstado(String estado)throws SQLException {
	        
	        
	        String sql = SELECT_MUNICIPIOS + " WHERE siglasest LIKE '" + estado + "%'";
	        

			List<CPs> lista = jdbcTemplate.query(sql,new CPRowMapper());

			return lista;
			
	    }//fin de getColonias
	    
	    
	    /* (non-Javadoc)
		 * @see com.servicio.search.dao.ICPDao#getColoniasMunicipo(java.lang.String)
		 */
	    @Override
		public List<CPs> getColoniasMunicipo(String municipio)throws SQLException {
	        
	        
	        String sql = SELECT_CP + " WHERE d_mnpio LIKE '" + municipio + "%'";
	    	List<CPs> lista = jdbcTemplate.query(sql,new CPRowMapper());

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
	        
	        List<CPs> lista = jdbcTemplate.query(sql,new CPRowMapper());

			return lista;
			
	       
	    }//fin de getColonias
	    
	  
	   
	    
	    /* (non-Javadoc)
		 * @see com.servicio.search.dao.ICPDao#getCiudad(com.innovargia.documentos.dtos.CPs)
		 */
	    @Override
		public CPs getCiudad(CPs cp) throws SQLException {
	        
	        
	        String sql = "SELECT * FROM znsepomexinfo WHERE d_codigo=?";
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
	        List<CPs> lista = jdbcTemplate.query(sql,new Object[]{id, colonia},new CPRowMapper());
	        if (lista.size()>0){
	        	return lista.get(0);
	        }
	        return null;
	        
	    
	    }//fin de getCP


}
