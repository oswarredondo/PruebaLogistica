package com.innovargia.ws.repo.interfase.bo;

public interface IReplicaMsgBO {

	int insert(String iddocumento, String jsondata, String login, int enviado) throws Exception;

	void updatePendientes(String uuid) throws Exception;

	void updateEnviado(int enviado, String uuid) throws Exception;

	void deleteEnviadosEnviado() throws Exception;
	
	void replicaMsg() throws Exception;

}