/**
 * 
 */
package com.administracion.bo;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.ibo.ICODBO;
import com.administracion.ibo.IParamsSistemaBO;
import com.administracion.idao.ICODDao;
import com.innovargia.documentos.dtos.CODFXC;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author Adrian Morales Ruaro
 *
 */
@Service
public class CODBO implements ICODBO {
    private static final Logger logger = LoggerFactory
  		.getLogger(CODBO.class);
    
	private static final String idSistema = ConstantesGenerales.ID_SKY4SOL;
	@Autowired
	ICODDao icodDao;	
	
	@Autowired
	IParamsSistemaBO iParamsSistemaBO;
	    
	/**
	 * 
	 */
	public CODBO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateEntregaCobro(CODFXC cod) throws SQLException {
	    icodDao.updateEntregaCobro(cod);
	    
	}

	@Override
	public void updateDevolucion(CODFXC cod) throws SQLException {
	    icodDao.updateDevolucion(cod);
	    
	}

	@Override
	public void insert(CODFXC cod) throws SQLException {
	    icodDao.insert(cod);
	    
	}
	
	@Override
	public boolean esCOD(String servicio){
	    String templatepdv ="";
	    try {
		 templatepdv = iParamsSistemaBO.getValorPropiedad(
			ConstantesGenerales.SERVICIOS_CODPDV,
			ConstantesGenerales.ID_SKY4SOL);
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    if (templatepdv==null)
		templatepdv="";
	    
	    if (servicio==null)
		return false;
	    
	    //Verifica si el servicio esta en la cadena de servicios COD
	    templatepdv = templatepdv.toUpperCase();
	    if (templatepdv.contains(servicio.toUpperCase())){
		return true;
	    }
	    return false;
	}

	@Override
	public CODFXC getRegistrOcurres(String iddocumento) throws Exception {
	    // TODO Auto-generated method stub
	    return icodDao.getRegistrOcurres(iddocumento);
	}
	
	

}
