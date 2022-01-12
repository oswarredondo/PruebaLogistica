/**
 * 
 */
package com.innovargia.ws.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.ws.dto.RutaUbicacion;
import com.innovargia.ws.repo.interfase.bo.IRutaUbicacionBO;
import com.innovargia.ws.repo.interfase.dao.IRutaUbicacionDao;

/**
 * @author aruaro
 *
 */
@Service
public class RutaUbicacionBO  implements IRutaUbicacionBO {
    
    private static final Logger logger = LoggerFactory
		.getLogger(RutaUbicacionBO.class);

    @Autowired
    IRutaUbicacionDao iRutaUbicacionDao;
   
 
	
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int insert(RutaUbicacion obj) throws Exception{
	iRutaUbicacionDao.insert(obj);

	return 0;
    }




    @Override
    public int update(RutaUbicacion obj) throws Exception {
	// TODO Auto-generated method stub
	return 0;
    }




    @Override
    public int delete(RutaUbicacion obj) throws Exception {
	// TODO Auto-generated method stub
	return 0;
    }




    @Override
    public List<RutaUbicacion> select(RutaUbicacion obj) throws Exception {
	// TODO Auto-generated method stub
	return null;
    }
    
   

}
