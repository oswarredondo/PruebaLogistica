/**
 * 
 */
package com.administracion.idao;

import java.sql.Connection;

/**
 * @author aruaro
 * 
 */
public interface IConexionDAOJDBC {

	public abstract Connection getConexion();

	public abstract void closeConecction(Connection con) ;

}
