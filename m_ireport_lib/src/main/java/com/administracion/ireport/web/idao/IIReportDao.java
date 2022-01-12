package com.administracion.ireport.web.idao;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.ireport.web.dto.IReportDTO;

public interface IIReportDao {

	/**
	 * Obtiene la lista de todos los reportes que el usuario puede consultar
	 *
	 * @return lista con instancias de Objeto conteniendo los datos, vacia en
	 *         caso de no encontrar algun dato
	 */
	public abstract List<IReportDTO> getReportes(UsuarioDTO usuario) throws SQLException;// fin
																							// de
																							// getListaUsuarios

	/**
	 * Obtiene los datos del reporte consulatdo, en caso de que no exista
	 * regresa null
	 *
	 * @return
	 */
	public abstract IReportDTO getReporte(UsuarioDTO usuario, int idReporte) throws SQLException;// fin
																									// de
																									// getReporte

	public IReportDTO getReporte(int idregistro) throws SQLException;

	public List<IReportDTO> getReportesPDV() throws SQLException;

	public List<IReportDTO> getReportesAdminVenta() throws SQLException;

	public List<IReportDTO> getReportesAutoDoc(UsuarioDTO usuario) throws SQLException;

	public List<IReportDTO> getReportesRecolecciones() throws SQLException;

	public List<IReportDTO> getReportesMonitorScanner(UsuarioDTO usuario) throws SQLException, Exception;

	public List<IReportDTO> getReportesIntegra() throws SQLException;

}