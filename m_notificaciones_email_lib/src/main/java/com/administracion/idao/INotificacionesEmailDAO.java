package com.administracion.idao;

import java.sql.SQLException;
import java.util.List;

import com.administracion.dto.DocumentoJson;
import com.administracion.notificacionemail.dto.NotificacionEmailDTO;

public interface INotificacionesEmailDAO {

	List<DocumentoJson> getEnviosANotificar() throws SQLException;

	void updateSeEnvioNotificacion(String iddocumento) throws SQLException;

	NotificacionEmailDTO getDatosEnvioNotificacionConfiguracion(String numliente) throws SQLException;

}