/* $Id:$
 * Nombre del Proyecto:
 * Nombre del Programa: HistoriaDao.java
 * Responsable:
 * Descripcion: Muestra datos de Historia
 *
 * $Log:$
 */

package com.innovargia.servicio.tracking.rest.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.ws.repo.interfase.dao.IFirmaEvidenciaDao;
import com.innovargia.ws.tracking.rest.dto.FirmaFoto;
import com.innovargia.ws.tracking.rest.rowmaps.FirmaRowMapper;
import com.innovargia.ws.tracking.rest.rowmaps.FotoRowMapper;

@Repository
public class FirmaEvienciaDao extends JdbcDaoSupport implements IFirmaEvidenciaDao{
	private static Logger logger = Logger.getLogger(FirmaEvienciaDao.class);
    
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	    
	/** Creates nueva instancia de UsuarioDao */
	@Autowired	
    public FirmaEvienciaDao(DataSource dataSource) {
    	setDataSource(dataSource);
    	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
    	
    }
    

    
    /* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IFirmaEvidenciaDao#getFirmaEntrega(java.lang.String)
	 */
    @Override
	public FirmaFoto getFirmaEntrega(String idGuia) throws SQLException {
        
        String sql = "select * from caattachdocumento where identificador=:guia and descripcion IN ('FIRMA ENTREGA', 'FIRMA DE RECIBIDO') limit 1  ";
        
        Map<String,String> paramMap = Collections.singletonMap("guia", idGuia);
        
        List<FirmaFoto> lista = new ArrayList<FirmaFoto>();
        FirmaFoto obj = null;
        try {
        	lista = this.namedParameterJdbcTemplate.query(sql, paramMap, new FirmaRowMapper());
        	
        	if (lista.size()>0){
        		obj = lista.get(0);
        	}
        } catch (Exception sq) {
            logger.debug("Error getFirmaEntrega " + sq.getMessage());
        }
        return obj;
    }
    
    /* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IFirmaEvidenciaDao#getEvienciaEntrega(java.lang.String)
	 */
    @Override
	public FirmaFoto getEvienciaEntrega(String idGuia) throws SQLException {
        
        String sql = "select * from caattachdocumento where identificador=:guia and descripcion IN ('EVIDENCIA', 'FOTO') limit 1  ";
        
        Map<String,String> paramMap = Collections.singletonMap("guia", idGuia);
        
        List<FirmaFoto> lista = new ArrayList<FirmaFoto>();
        FirmaFoto obj = null;
        try {
        	lista = this.namedParameterJdbcTemplate.query(sql, paramMap, new FotoRowMapper());
        	
        	if (lista.size()>0){
        		obj = lista.get(0);
        	}
        } catch (Exception sq) {
            logger.debug("Error getEvienciaEntrega " + sq.getMessage());
        }
        return obj;
    }
 
    
  
  
}
