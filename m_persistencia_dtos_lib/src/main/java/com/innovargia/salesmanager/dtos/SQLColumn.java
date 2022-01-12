/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class SQLColumn {
	String name;
	String type;
	String tableName;
	
    
    
	/**
	 * 
	 */
	public SQLColumn() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}



	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
