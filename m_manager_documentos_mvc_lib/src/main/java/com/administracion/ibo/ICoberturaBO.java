/**
 * 
 */
package com.administracion.ibo;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;

/**
 * @author aruaro
 *
 */
public interface ICoberturaBO {
	
	
	/**
	 * Obtiene los datos del cruce de los dos centros operaivos indicados
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public CruceCoberturaDTO getCobertura(CruceCoberturaDTO catalogo) throws Exception;
	

   	public List<CruceCoberturaDTO> getEnrutamientos(String siglasorigen, String siglasdestino, String garantiamax) throws Exception;
	
   	/* PARA OBTENER SEGURO */
   	public int getSeguro(CruceCoberturaDTO catalogo) throws Exception;
   	
   	public List<CruceCoberturaDTO> validarConvenioSeguro(String numCliente) throws SQLException;
}
