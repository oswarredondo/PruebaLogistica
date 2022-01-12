package com.administracion.consecutivos.bo;



import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.ibo.IAdminConsecutivosBO;
import com.administracion.idao.IAdminConsecutivosDAO;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.servicio.search.dao.BusquedaCPDao;

@Service
public class AdminConsecutivosBO implements IAdminConsecutivosBO {
    
    private static final Logger logger = LoggerFactory
		.getLogger(BusquedaCPDao.class);
	@Autowired
	IAdminConsecutivosDAO adminConsecutivoDao;
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
       
    }//fin de debug
    
    
	/* (non-Javadoc)
	 * @see com.administracion.consecutivos.bo.IAdminConsecutivosBO#getConsecutivoDocumento(java.lang.String, int, int)
	 */
	@Override
	public String getConsecutivoDocumento(String idTipoDocumento,int identidad,int idorganizacion) throws Exception{
		
		//IAdminConsecutivosDAO adminConsecutivoDao = new AdminConsecutivosDAO();
		MetaDatoCatalogoDTO metaDocumento = adminConsecutivoDao.getDatosTipoDoc(idTipoDocumento,identidad,idorganizacion);
		logger.debug("getConsecutivoDocumento idTipoDocumento:" + idTipoDocumento);
		if ((metaDocumento == null) || (metaDocumento.getTabla()==null) || metaDocumento.getTabla().isEmpty()) {
		    	
			debug("Identificador de documento " + idTipoDocumento
					+ " invalido o no se ha dado de alta");
			return null;
		}
		return adminConsecutivoDao.getConsecutivo(metaDocumento);

	}
	
	/* (non-Javadoc)
	 * @see com.administracion.consecutivos.bo.IAdminConsecutivosBO#getMetaDatoCatalogoDTO(java.lang.String, int, int)
	 */
	@Override
	public MetaDatoCatalogoDTO getMetaDatoCatalogoDTO(String idTipoDocumento,int identidad,int idorganizacion ) throws Exception{
		
		//IAdminConsecutivosDAO adminConsecutivoDao = new AdminConsecutivosDAO();
		MetaDatoCatalogoDTO metaDocumento = adminConsecutivoDao.getDatosTipoDoc(idTipoDocumento,
				identidad,idorganizacion);

		
		if (metaDocumento == null) {
			debug("Identificador de documento " + idTipoDocumento
					+ " invalido o no se ha dado de alta");
			return null;
		}
		return metaDocumento;

	}
	
	
	/* (non-Javadoc)
	 * @see com.administracion.consecutivos.bo.IAdminConsecutivosBO#getDatosTipoDoc(int, int, boolean)
	 */
	@Override
	public ArrayList<MetaDatoCatalogoDTO>  getDatosTipoDoc(int identidad,int idorganizacion, boolean onlyVisible) throws Exception{
		
		//IAdminConsecutivosDAO adminConsecutivoDao = new AdminConsecutivosDAO();
		ArrayList<MetaDatoCatalogoDTO> metaDocumento = adminConsecutivoDao.getDatosTipoDoc( identidad, idorganizacion,onlyVisible);

		return metaDocumento;

	}


	@Override
	public boolean existeTablaConsecutivos(MetaDatoCatalogoDTO meta)
			throws Exception {
		// TODO Auto-generated method stub
		return adminConsecutivoDao.existeTablaConsecutivos(meta);
	}

}
