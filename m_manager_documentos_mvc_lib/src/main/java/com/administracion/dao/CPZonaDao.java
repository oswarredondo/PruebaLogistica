/* $Id:  $
 *
 * Nombre del Proyecto:
 * Nombre del Programa: CPDao.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion:  Acceso a los datos de codigos postales
 * garantias
 *
 * $Log:$
 */
package com.administracion.dao;


import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.idao.ICPZonaDao;
import com.administracion.rowmapper.ZonaRowMapper;
import com.administracion.rowmapper.ZonaVentaRowMapper;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.Zona;

/**
 *<CODE>
 * Manejo de los datos de C�digos Postales
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@Repository
public class CPZonaDao extends JdbcDaoSupport implements ICPZonaDao{

    
	private static final Logger logger = LoggerFactory
			.getLogger(CPZonaDao.class);
    

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CPZonaDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		//this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

    
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
    	logger.debug( mensaje);
    }//fin de debug
       
   
    /* (non-Javadoc)
	 * @see com.administracion.dao.ICPZonaDao#getCruceZona(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
    @Override
	public Zona getCruceZona(String zonaOri, String zonaDes,UsuarioDTO usuario,String idgarantia)throws SQLException {
        debug("zonaOri:" + zonaOri + "  zonaDes:"+zonaDes+",identidad:"+ 
        		usuario.entidad.getIdentidad() + ",organizacion:" + usuario.organizacion.getIdorganizacion() + ",Garantia:" + idgarantia);
       
        String sql = "SELECT * FROM znzonacruce WHERE zonaorigen=:zonaorigen"
        		+ " AND zonadestino=:zonadestino AND garantiamax=:idgarantia " +
        		" AND identidad=:identidad AND idorganizacion=:idorgnizacion" ;

        try{
        	MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("identidad", usuario.entidad.getIdentidad());
			params.addValue("organizacion", usuario.organizacion.getIdorganizacion());
			params.addValue("zonaorigen", zonaOri);
			params.addValue("zonadestino", zonaDes);
			params.addValue("idgarantia", idgarantia);
			
			
        	 List<Zona>  lista = this.namedParameterJdbcTemplate.query(sql,params,
        			 new ZonaRowMapper());
      		if ( lista.size()>0){
      			return lista.get(0);
      		}
		} catch (Exception sq) {
			debug(sq.getMessage());
	    } 

        return null;
    }//fin de getCPs
    
    /* (non-Javadoc)
	 * @see com.administracion.dao.ICPZonaDao#getZonaVenta(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
    @Override
	public Zona getZonaVenta(String zonaVentaOri, String zonaVentaDes,UsuarioDTO usuario,String idgarantia)throws SQLException {
        debug("zonaVentaOri:" + zonaVentaOri + "  zonaVentaDes:"+zonaVentaDes+",identidad:"+ 
    usuario.entidad.getIdentidad() + ",organizacion:" + usuario.organizacion.getIdorganizacion() + ",Garantia:" +idgarantia);
       
        String sql = "SELECT * FROM znzonaventa WHERE idzonaventaori=:idzonaventaori"
        		+ " AND idzonaventades=:idzonaventades AND "
        		+ "identidad=:identidad AND idorganizacion=:idorganizacion";
        
        try{
        	MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("identidad", usuario.entidad.getIdentidad());
			params.addValue("organizacion", usuario.organizacion.getIdorganizacion());
			params.addValue("idzonaventaori", zonaVentaOri);
			params.addValue("idzonaventades", zonaVentaDes);
			params.addValue("idgarantia", idgarantia);
        	
        	 List<Zona>  lista = this.namedParameterJdbcTemplate.query(sql,params,
        			 new ZonaVentaRowMapper());
      		if ( lista.size()>0){
      			return lista.get(0);
      		}
		} catch (Exception sq) {
			debug(sq.getMessage());
	    } 

        return null;
    }//fin de getCPs
    


}//fin de CPDao
