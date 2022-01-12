/**
 * 
 */
package com.innovargia.ws.bo;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.ibo.IParamsSistemaBO;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.ws.dto.DatosEtiqueta;
import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.repo.interfase.bo.IDatosEtiquetaBO;
import com.innovargia.ws.repo.interfase.bo.IEntregaBO;
import com.innovargia.ws.repo.interfase.bo.IFirmaFotoBO;
import com.innovargia.ws.repo.interfase.dao.IDatosEtiquetaDao;
import com.innovargia.ws.repo.interfase.dao.IEntregaDao;
import com.innovargia.ws.repo.interfase.dao.IFirmaFotoDao;
import com.servicio.constantes.ConstantesGenerales;

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
