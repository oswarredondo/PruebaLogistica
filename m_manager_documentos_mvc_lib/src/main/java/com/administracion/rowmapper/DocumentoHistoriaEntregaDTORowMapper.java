package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.FechasTimeStamp;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Zona;

public class DocumentoHistoriaEntregaDTORowMapper implements
		RowMapper<DocumentoDTO> {

	String formatofecha = "dd-MM-yyyy HH:mm:ss";

	public DocumentoHistoriaEntregaDTORowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DocumentoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		DocumentoDTO carta = new DocumentoDTO();

		// Crea el registro con el estatus solo historia
		carta.setIdDocumento(rs.getString("iddocumento"));
		carta.datosCarta.confirmacion.setQuienRecibe(rs.getString("conombre"));
		carta.datosCarta.confirmacion
				.setFechaConfirmacion(FechasTimeStamp.formatoTimeStamp(
						rs.getTimestamp("cofecha"), this.formatofecha));
		carta.datosCarta.confirmacion.setFechaentregapod(FechasTimeStamp
				.formatoTimeStamp(rs.getTimestamp("fechaentregapod"),
						this.formatofecha));

		// Ajusta guia de devolucion y casamiento
		carta.setIdGuiaDevolucion(rs.getString("iddevolucion"));
		carta.setIdGuiaCasamiento(rs.getString("idcasamiento"));

		if ((rs.getString("isnota") != null)
				&& (rs.getString("isnota").trim().length() > 0)) {
			carta.setIsexistenota(rs.getString("isnota"));
		}
		// Indica la historia como estatus
		carta.setEstatus("H");

		return carta;
	}

}
