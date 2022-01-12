package org.rest_tracusa_logistica.struct;

public class UserKey {

	private int idUserKey;
	private String idClient;
	private String login;
	private String user;
	private String password;
	private String apiKey;
	private String estatus;
	private String prorroga;
	
	public int getIdUserKey() {
		return idUserKey;
	}
	public void setIdUserKey(int idUserKey) {
		this.idUserKey = idUserKey;
	}
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getProrroga() {
		return prorroga;
	}
	public void setProrroga(String prorroga) {
		this.prorroga = prorroga;
	}
}
