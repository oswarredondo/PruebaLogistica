package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IAgrupamientoJerarquiaBO {

	public abstract void insert(AgrupamientoDTO catalogo) throws Exception;

	public abstract void update(AgrupamientoDTO catalogo) throws Exception;

	public abstract void updateEstatus(AgrupamientoDTO catalogo) throws Exception;

	public abstract void delete(AgrupamientoDTO catalogo) throws Exception;

	public abstract List<AgrupamientoDTO> getRegistros(BusquedaDTO catalogo)
			throws Exception;

	public abstract AgrupamientoDTO get(AgrupamientoDTO catalogo) throws Exception;
	
	
	public List<AgrupamientoDTO> getRegistrosAgrupamientosUsuario(String login)
			throws Exception ;

	/***
	 * Obtiene los adicionales existentes de acuerdo a su tipo
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public List<AgrupamientoDTO> getRegistrosXTipo(CatalogoDTO catalogo) throws Exception ;
	
	
	/***
	 * Obtiene los usuarios con mayor nivel(puesto) que el usuario indicado y que pertenecen al 
	 * mismo agrupamiento
	 * @param usuario
	 * @param limit indica el limite de registros a devolver, debe ser mayor de cero
	 * @param mostrarSoloUsuarioConNivelSuperior indica si solo se m uestran los usuarios con nivel superior
	 * al usuario de sesión, en este caso se obtiene primero el nivel superior al usuario y solo 
	 * se obtiene los datos de los usuarios con ese nivel superior inmediato
	 * @return una lista con los usuarios, esta lista contiene una lista con el mismo nivel que es uno mayor al 
	 * del usuario de acuerdo al grupo 
	 * @throws Exception
	 */
	public List<UsuarioCuentaDTO> getNivelSuperiorDelUsuario(UsuarioDTO  usuario, int limit,boolean mostrarSoloUsuarioConNivelSuperior) throws Exception;


}