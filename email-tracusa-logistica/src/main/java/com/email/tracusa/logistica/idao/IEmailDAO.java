/**
 * 
 */
package com.email.tracusa.logistica.idao;

import java.util.List;

/**
 * @author Oswaldo Arredondo
 * 
 */
public interface IEmailDAO {

	public List<String> getUsuarios(String perfil) throws Exception;
	
	public List<String> getGuiasError() throws Exception;
}
