package com.innovargia.ws.repo.interfase.dao;

public interface IMQMensajesPendientesDAO {

	int insert(String iddocumento, String jsondata, String login, int enviado) throws Exception;

	void updatePendientes(String uuid) throws Exception;

	void updateEnviado(int enviado, String uuid) throws Exception;

	void deleteEnviadosEnviado() throws Exception;

}