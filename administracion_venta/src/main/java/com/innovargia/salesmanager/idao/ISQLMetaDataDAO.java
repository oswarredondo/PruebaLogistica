/**
 * Proyecto : AFE v.1.0
 * ICarrierCPsDAO.java 
 * Fecha Creacion : 
 * Todos los derechos reservados Estafeta Mexicana S.A. de C.V 
 */
package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.SQLColumn;


/**
 * Inteface que contiene todos los metodos relacionados al Catalogo CarrierCPs
 * @author Hector Silvar Villaseñor SWITZ Software Artists S. DE. R.L. de C.V.
 */
public interface ISQLMetaDataDAO {
	
	/***
	 * Devuelve los campos de una tabla, se debe mandar el nombre de 
	 * la tabla existente en la base de datos e internamente se 
	 * obtienen los datos
	 * @param table
	 * @return
	 */
	public List<SQLColumn> getMetaDataTable(String table);

}