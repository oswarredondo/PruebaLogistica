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

import com.innovargia.ws.repo.interfase.dao.IHistoriaDao;
import com.innovargia.ws.tracking.rest.dto.Movimiento;
import com.innovargia.ws.tracking.rest.rowmaps.HistorialRowMapper;

@Repository
public class HistoriaDao extends JdbcDaoSupport implements IHistoriaDao{
	private static Logger logger = Logger.getLogger(HistoriaDao.class);
    
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	    
	@Autowired	
    public HistoriaDao(DataSource dataSource) {
    	setDataSource(dataSource);
    	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
    	
    }
    
    /* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IHistoriaDao#getHistoria(java.lang.String)
	 */
    @Override
	public List<Movimiento> getHistoria(String idGuia) throws SQLException {
        
        String sql = "select movimientos.*,inforegistros.descripcion as tipo, tiRegistro, inforegistros.descripcion,  "
        		+ "caexcepcion.descripcion as descripcionExcepcipon"
        		+ " from movimientos "
        		+ " left outer join inforegistros ON movimientos.tiregistro= inforegistros.idregistro "
        		+ " LEFT OUTER JOIN caexcepcion ON  movimientos.exClave =caexcepcion.idexcepcion "
        		+ " WHERE IdGuia=:guia"
        		+ " ORDER BY fechaevento desc  ";
        
        Map<String,String> paramMap = Collections.singletonMap("guia", idGuia);
        
        List<Movimiento> lista = new ArrayList<Movimiento>();
        try {
        	
        	lista = this.namedParameterJdbcTemplate.query(sql, paramMap, new HistorialRowMapper());

        } catch (Exception sq) {
            logger.debug("Error getHistoria " + sq.getMessage());
        }
        return lista;
    }//fin de getHistoria
    
    /* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IHistoriaDao#getUltimoRegistroHistoria(java.lang.String)
	 */
    @Override
	public List<Movimiento> getUltimoRegistroHistoria(String idGuia) throws SQLException {

        
        List<Movimiento> lista =  getHistoria(idGuia);
        List<Movimiento> lista_ultimo = new ArrayList<Movimiento>();
        try {
        	if (lista.size()>0){
        		lista_ultimo.add(lista.get(0));
        	}

        } catch (Exception sq) {
        	logger.debug("Error getUltimoRegistroHistoria " + sq.getMessage());
        }
        return lista_ultimo;
    }//fin de getHistoria
 
    
  
  
}//fin de AccesoDao
