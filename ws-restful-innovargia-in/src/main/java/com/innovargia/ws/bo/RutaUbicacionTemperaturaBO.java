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
import com.innovargia.ws.repo.interfase.bo.IRutaUbicacionTemperaturaBO;
import com.innovargia.ws.repo.interfase.dao.IRutaUbicacionDao;
import com.innovargia.ws.repo.interfase.dao.IRutaUbicacionTemperaturaDao;

/**
 * @author aruaro
 *
 */
@Service
public class RutaUbicacionTemperaturaBO  implements IRutaUbicacionTemperaturaBO{
    
    private static final Logger logger = LoggerFactory
		.getLogger(RutaUbicacionTemperaturaBO.class);

    @Autowired
    IRutaUbicacionTemperaturaDao iRutaUbicacionTemperaturaDao;
   
 
	
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int insert(RutaUbicacion obj) throws Exception{
	iRutaUbicacionTemperaturaDao.insert(obj);

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
