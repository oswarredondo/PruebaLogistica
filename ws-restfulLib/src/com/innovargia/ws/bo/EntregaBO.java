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
import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.repo.interfase.bo.IEntregaBO;
import com.innovargia.ws.repo.interfase.dao.IEntregaDao;
import com.innovargia.ws.repo.interfase.dao.IFirmaFotoDao;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author aruaro
 *
 */
@Service
public class EntregaBO  implements IEntregaBO {
    
    private static final Logger logger = LoggerFactory
		.getLogger(EntregaBO.class);

    @Autowired
    IEntregaDao iEntregaDao;
    @Autowired
    IFirmaFotoDao iFirmaFotoDao;
    
    @Autowired
    IParamsSistemaBO iParamsSistemaBO;
 
	
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int insert(Entrega obj) throws Exception{
	 logger.info("EntregaBO create insert.");
	 obj.setIdguia(obj.getIdguia().toUpperCase().trim()) ;
	 String[] arr_guias = obj.getIdguia().split("\n");
	 com.servicio.dtos.Entrega entregaDTO =null;
	 
	 //Separa y agrega las guias
	 for (String idguia : arr_guias) {
	     if ((idguia!=null) && (idguia.trim().length()>0)){
		 if (idguia.trim().length()<=30){
		     obj.setIdguia(idguia);
			 try{
			     iEntregaDao.insert(obj);
			     iEntregaDao.update(obj);
			 }catch(Exception e){
			     logger.debug("Error al agregar la entrega:" + e.getMessage() );
			 }
		 }else{
		     logger.debug("Guia :" + idguia.trim() + " tiene mas de 30 caracteres" );
		 }
		
		

	     }
	     
	     //Agrega el atachment
	}
	 
	
	//Agrega la imagen de la firma para cada guia en las NOTAs pero solo 
	 //crea una imagen que sera compartida por todas las guias
	String nombre_archivo = UUIDUniqueCreator.generateUUID() +  ".png";
	//Guarda el archivo 
	SistemaDTO sistema  = iParamsSistemaBO.getPathsSistema(ConstantesGenerales.ID_APP,
					ConstantesGenerales.NUM_CTE_APP);
	
	if (sistema!=null){
	    String pathnamefile=sistema.getPathDocsPDFs() + nombre_archivo ;
	    
	    if ((obj.getImaBase64()!=null) && (obj.getImaBase64().trim().length()>0)){
		   //"path.documentos.attachment"
		Base64 b = new Base64();
		byte[] imageBytes = b.decode(obj.getImaBase64());
		FileOutputStream fos = new FileOutputStream(pathnamefile);
		fos.write(imageBytes);
		fos.close();
		
		 //Inserta la nota
		    AttachmentDTO attac_nota = new AttachmentDTO();
		    attac_nota.setDescripcion("FIRMA ENTREGA");
		    attac_nota.setFecha(obj.getFecha());
		    attac_nota.setNombre_archivo(nombre_archivo);
		    attac_nota.setLogin("RESTFUL");
		    attac_nota.setIdtipodocumento("ETIQU");
		    for (String idguia : arr_guias) {
			     if ((idguia!=null) && (idguia.trim().length()>0)){
				 attac_nota.setIdentificador(idguia);
				 iFirmaFotoDao.insert(attac_nota);
			     }
		    }
	    }   
	   
	   
	   
	    
	}else{
	    logger.debug("Path para imagenes no configurado PathDocsPDFs");
	}
			
	
	

	
	return 0;
    }
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#update(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int update(Entrega obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#delete(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int delete(Entrega obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#select(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public List<Entrega> select(Entrega obj) throws Exception{
	
   	return new ArrayList<Entrega>();
       }

}
