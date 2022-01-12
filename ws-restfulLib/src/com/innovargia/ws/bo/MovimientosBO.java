/**
 * 
 */
package com.innovargia.ws.bo;

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
import org.springframework.stereotype.Service;

import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.dto.Movimiento;
import com.innovargia.ws.repo.interfase.bo.IMovimientoBO;
import com.innovargia.ws.repo.interfase.dao.IMovimientoDao;

/**
 * @author aruaro
 *
 */
@Service
public class MovimientosBO  implements IMovimientoBO{
    
    private static final Logger logger = LoggerFactory
		.getLogger(MovimientosBO.class);
    
    @Autowired
     IMovimientoDao iMovimientoDao;
       /**
     * 
     */
    public MovimientosBO(){
	
    }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IMovimientoDao#insert(com.innovargia.ws.dto.Movimiento)
     */
    @Override
    public int insert(Movimiento obj) throws Exception{
	 obj.setIdguia(obj.getIdguia().toUpperCase().trim()) ;
	 String[] arr_guias = obj.getIdguia().split("\n");
	 //com.servicio.dtos.Entrega entregaDTO =null;
	
	 
	 //Separa y agrega las guias
	 for (String idguia : arr_guias) {
	     if ((idguia!=null) && (idguia.trim().length()>0)){
		 if (idguia.trim().length()<=30){
		     obj.setIdguia(idguia);
			 try{
			     obj.setCveLog(obj.getCveLog()==null?"":obj.getCveLog());
			     obj.setPlaza(obj.getPlaza()==null?"":obj.getPlaza());
			     
			     iMovimientoDao.insert(obj);
			    
			 }catch(Exception e){
			     logger.debug("Error al agregar el casamiento:" + e.getMessage() );
			 }
		 }else{
		     logger.debug("Guia :" + idguia.trim() + " tiene mas de 30 caracteres" );
		 }
		
		

	     }
	     
	     //Agrega el atachment
	}
	return 0;
    }
    
    
    @Override
    public int insertCasamiento(Movimiento obj) throws Exception{
	 obj.setIdguia(obj.getIdguia().toUpperCase().trim()) ;
	 String[] arr_guias = obj.getIdguia().split("\n");
	 com.servicio.dtos.Entrega entregaDTO =null;
	 String idcasamiento = obj.getGuiaCasamiento();
	 
	 
	 //Separa y agrega las guias
	 for (String idguia : arr_guias) {
	     if ((idguia!=null) && (idguia.trim().length()>0)){
		 if (idguia.trim().length()<=30){
		    
		     obj.setIdguia(idcasamiento);
		     obj.setGuiaCasamiento(idguia);
			 try{
			     iMovimientoDao.insertCasamiento(obj);
			    
			 }catch(Exception e){
			     logger.debug("Error al agregar el casamiento:" + e.getMessage() );
			 }
		 }else{
		     logger.debug("Guia :" + idguia.trim() + " tiene mas de 30 caracteres" );
		 }
		
		

	     }
	     
	     //Agrega el atachment
	}
	return 0;
    }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IMovimientoDao#update(com.innovargia.ws.dto.Movimiento)
     */
    @Override
    public int update(Movimiento obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IMovimientoDao#delete(com.innovargia.ws.dto.Movimiento)
     */
    @Override
    public int delete(Movimiento obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IMovimientoDao#select(com.innovargia.ws.dto.Movimiento)
     */
    @Override
    public List<Movimiento> select(Movimiento obj) throws Exception{
	
   	return new ArrayList<Movimiento>();
       }

}
