package com.tracusa.logistica.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tracusa.logistica.model.DatosEtiqueta;
import com.tracusa.logistica.interfase.bo.IDatosEtiquetaBO;
import com.tracusa.logistica.interfase.dao.IDatosEtiquetaDao;


/**
 * @author aruaro
 *
 */
@Service
public class DatosEtiquetaBO implements IDatosEtiquetaBO   {
    
    private static final Logger logger = LoggerFactory
		.getLogger(DatosEtiquetaBO.class);

    @Autowired
    IDatosEtiquetaDao iDao;

    /* (non-Javadoc)
     * @see com.innovargia.ws.bo.IDatosEtiquetaBO#insert(com.innovargia.ws.dto.DatosEtiqueta)
     */
    @Override
    public int insert(DatosEtiqueta obj) throws Exception{
	iDao.insert(obj);		
	return 0;
    }
    
  
}
