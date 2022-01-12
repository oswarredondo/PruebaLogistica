package com.administracion.idao;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.ManifiestoDTO;

public interface IManifiestoEtiquetasDAO {

	public abstract List<ManifiestoDTO> getConcentradoCargaAsignada(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws SQLException;//fin de getConcentradoCargaAsignada

	public abstract List<DocumentoConsultaDTO> getDetalleManifiestoEtiquetas(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	public abstract List<DocumentoConsultaDTO> getDetalleRuta(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	public abstract List<DocumentoConsultaDTO> getDetalleManifiestoentrega(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	public abstract List<DocumentoConsultaDTO> getDetalleRutaManifiesto(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	public abstract void insertManifiestoEntregaRegistros(
			ManifiestoDTO manifiesto, UsuarioDTO usuario, String manifiesto_cons)
			throws SQLException;

	public abstract void updatePosicionUnidadRepartoRegistros(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	public abstract void updateManifiestoRegistros(
			java.sql.Timestamp fechamanifiesto, String manifiesto, String ruta,
			java.sql.Timestamp fechaIni, java.sql.Timestamp fechaFin,
			String transportista, UsuarioDTO usuario, String tipodocumento)
			throws SQLException;

	public void updateManifiestoRegistrosEtiquetas(java.sql.Timestamp fechamanifiesto,
			ManifiestoDTO manifiesto,UsuarioDTO usuario,String tipodocumento) throws SQLException;

	public abstract void updateManifiestoRegistrosEtiquetas(
			java.sql.Timestamp fechamanifiesto, String iddocumento,
			String manifiesto, String transportista, UsuarioDTO usuario,
			String tipodocumento) throws SQLException;
	
	public void updateManifiestoRegistrosEtiquetas(java.sql.Timestamp fechamanifiesto, 
   		 String manifiesto,  String login,java.sql.Timestamp fechaIni, 
   		 java.sql.Timestamp fechaFin, String transportista,UsuarioDTO usuario,String tipodocumento) throws SQLException;
	


}