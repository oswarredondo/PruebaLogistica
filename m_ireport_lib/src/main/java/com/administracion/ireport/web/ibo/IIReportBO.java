package com.administracion.ireport.web.ibo;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.ireport.web.dto.IReportDTO;

public interface IIReportBO {

	public abstract List<IReportDTO> getReportes(UsuarioDTO usuario)
			throws Exception;

	public abstract IReportDTO getReporte(UsuarioDTO usuario, int idreporte)
			throws Exception;
	
   	public IReportDTO getReporte( int idregistro) throws SQLException ;
   	
   	public List<IReportDTO> getReportesPDV() throws SQLException;
   	
   	public List<IReportDTO> getReportesAdminVenta() throws SQLException;
   	public List<IReportDTO> getReportesAutoDoc(UsuarioDTO usuario) throws SQLException;
   	public List<IReportDTO> getReportesRecolecciones() throws SQLException;
   	   	public List<IReportDTO> getReportesMonitorScanner(UsuarioDTO usuario) throws SQLException, Exception;
   	
   	 public List<IReportDTO> getReportesIntegra() throws SQLException;  	

}