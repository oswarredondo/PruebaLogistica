/**
 * 
 */
package com.innovargia.salesmanager.idao;

import java.sql.Connection;

/**
 * @author aruaro
 * 
 */
public interface IReportesDAOJDBC {

	public abstract Connection getConexion();

	public abstract void closeConecction(Connection con) ;

}
