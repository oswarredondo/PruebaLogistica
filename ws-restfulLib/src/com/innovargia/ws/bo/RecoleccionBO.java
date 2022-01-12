/**
 * 
 */
package com.innovargia.ws.bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.innovargia.ws.dto.OrdenRecoleccion;
import com.innovargia.ws.repo.interfase.bo.IRecoleccionBO;

/**
 * @author aruaro
 *
 */
@Service
public class RecoleccionBO implements IRecoleccionBO {

    private static final Logger logger = LoggerFactory
		.getLogger(RecoleccionBO.class);

    /**
     * 
     */
    public RecoleccionBO(){
	
    }
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IRecoleccionDao#insert(com.innovargia.ws.dto.OrdenRecoleccion)
     */
    @Override
    public int insert(OrdenRecoleccion obj) throws Exception{
	
	return 0;
    }
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IRecoleccionDao#update(com.innovargia.ws.dto.OrdenRecoleccion)
     */
    @Override
    public int update(OrdenRecoleccion obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IRecoleccionDao#delete(com.innovargia.ws.dto.OrdenRecoleccion)
     */
    @Override
    public int delete(OrdenRecoleccion obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IRecoleccionDao#select(com.innovargia.ws.dto.OrdenRecoleccion)
     */
    @Override
    public List<OrdenRecoleccion> select(OrdenRecoleccion obj) throws Exception{
	
   	return new ArrayList<OrdenRecoleccion>();
       }

}
