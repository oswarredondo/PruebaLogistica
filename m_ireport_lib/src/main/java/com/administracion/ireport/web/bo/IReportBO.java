/**
 * 
 */
package com.administracion.ireport.web.bo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.ireport.web.ibo.IIReportBO;
import com.administracion.ireport.web.idao.IIReportDao;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.ireport.web.dto.IReportDTO;

/**
 * @author Adrian Morales Ruaro
 *
 */
@Service
public class IReportBO implements IIReportBO {
	@Autowired
	IIReportDao iReportDao;
	/**
	 * 
	 */
	public IReportBO() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see com.administracion.ireport.web.bo.IIReportBO#getReportes(com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<IReportDTO> getReportes(UsuarioDTO usuario ) throws Exception {
		return iReportDao.getReportes(usuario);
	}
	
	/* (non-Javadoc)
	 * @see com.administracion.ireport.web.bo.IIReportBO#getReporte(com.innovargia.salesmanager.dtos.UsuarioDTO, int)
	 */
	@Override
	public IReportDTO getReporte(UsuarioDTO usuario,int idreporte ) throws Exception {
		return iReportDao.getReporte(usuario,idreporte); 
	}

	@Override
	public IReportDTO getReporte(int idregistro) throws SQLException {
		// TODO Auto-generated method stub
		return iReportDao.getReporte(idregistro);
	}

	@Override
	public List<IReportDTO> getReportesPDV() throws SQLException {
	    // TODO Auto-generated method stub
	    return iReportDao.getReportesPDV();
	}

	
	@Override
	public List<IReportDTO> getReportesAdminVenta() throws SQLException {
	    // TODO Auto-generated method stub
	    return iReportDao.getReportesAdminVenta();
	}

	@Override
	public List<IReportDTO> getReportesAutoDoc(UsuarioDTO usuario) throws SQLException {
	    // TODO Auto-generated method stub
	    return iReportDao.getReportesAutoDoc(usuario);
	}

	@Override
	public List<IReportDTO> getReportesRecolecciones() throws SQLException {
	    // TODO Auto-generated method stub
	    return iReportDao.getReportesRecolecciones();
	}

	@Override
	public List<IReportDTO> getReportesMonitorScanner(UsuarioDTO usuario) throws Exception {
	    // TODO Auto-generated method stub
	    return iReportDao.getReportesMonitorScanner(usuario);
	}

	@Override
	public List<IReportDTO> getReportesIntegra() throws SQLException {
		// TODO Auto-generated method stub
		  return iReportDao.getReportesIntegra();
	}
}
