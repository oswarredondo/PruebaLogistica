package com.innovargia.administracion.ibo;

public interface IAdminPasswordBO {

	/***
	 * Inserta la bitacora de accesos de un usuario cuando ingresa a un modulo
	 * @param login
	 * @param modulo
	 * @param password
	 * @throws Exception
	 */
	void insertBitacoraAcceso(String login, String modulo, String password) throws Exception;

	/***
	 * Inserta el historial de login y password que el usuario ha dado de alta 
	 * @param login
	 * @param password
	 * @throws Exception
	 */
	void insertHistorial(String login, String password, String estado) throws Exception;

	/***
	 * Verifica si en el historial de Login y password ya ha sido dado de alta esta combinación 
	 * forzando al usuario no repetir una combinacion
	 * @param login
	 * @param password
	 * @return
	 * @throws Exception
	 */
	boolean existeLoginPass(String login, String password) throws Exception;

	/***
	 * Cambia todos los registrosd de usuario que su estado sea activo y que tengan mas de 60
	 * dias de haber sido dados de alta
	 * @throws Exception
	 */
	void cambiaEstatus() throws Exception;
	
	public String estadoLoginPass(String login, String password) throws Exception ;

}