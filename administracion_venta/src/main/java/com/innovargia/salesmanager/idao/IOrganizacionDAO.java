package com.innovargia.salesmanager.idao;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.EntidadDTO;
import com.innovargia.salesmanager.dtos.OrganizacionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IOrganizacionDAO {

	/**
	 * Obtiene todas las cuentas de una organiacion de una entidad de un usuario
	 * @param user
	 * @return ArrayList<Organizacion> o un arreglo vacio
	 * @throws SQLException
	 */
	public abstract List<CuentasDTO> getListaCuentasOrganizacion(
			int idorganizacion, UsuarioDTO user) throws Exception;

	/**
	 * Obtiene las organizaciones de un usuario, si el usuario en su perfil
	 * tiene configurado nivel E= Entidad entonces regresa todas las
	 * organizaciones de la entidad O= Organizacion entonces regresa solo la
	 * organiacion del usuario
	 * 
	 * @param user
	 * @return ArrayList<Organizacion> o un arreglo vacio
	 * @throws SQLException
	 */
	public abstract List<OrganizacionDTO> getListaOrganizacionesUser(
			UsuarioDTO user) throws SQLException;

	public abstract List<OrganizacionDTO> getListaOrganizacionesUser(
			UsuarioDTO user, boolean activeOnly) throws SQLException;

	/**
	 * OoBTIENE LOS DATOS DE LA organizacion y la entidad de un usuario
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract void getEntidadOrganizacion(UsuarioDTO user)
			throws SQLException;// fin de getClientesRemDes

	/**
	 * Obtiene todas las entidades existentes
	 * @return
	 */
	public abstract List<EntidadDTO> getEntidades(boolean onlyActive);

	/**
	 * Obtiene todas las organizaciones existentes
	 * @return
	 */
	public abstract List<OrganizacionDTO> getOrganizacionEntidad(
			String identidad, boolean onlyActive);

	/**
	 * Obtiene las organizaciones existentes bajo un cierto criterio o todas
	 * 
	 * @param inicial
	 * @param ordernax
	 * @param campoBusqueda
	 * @param entre
	 * @return
	 * @throws SQLException
	 */
	public abstract List<OrganizacionDTO> getOrganizaciones(String inicial,
			int ordernax, String campoBusqueda, String entre, String estatus)
			throws SQLException;// fin de 

	/**
	 * Actualiza estado una entidad
	 * @param perfil
	 * @throws SQLException
	 */
	public abstract void updateEstadoEntidad(int entidad, String estatus) throws SQLException;

	/**
	 * Agrega organizacion
	 * @param perfil
	 * @throws SQLException
	 */
	public abstract void insertOrganizacionEntidad(int entidad, String estatus,String descripcion) throws SQLException;

	/**
	 * Inserta entidad
	 * @param perfil
	 * @throws SQLException
	 */
	public abstract void insertEntidad(String estatus, String descripcion)
			throws SQLException;

	/**
	 * Actualiza estado una entidad
	 * @param perfil
	 * @throws SQLException
	 */
	public abstract void updateEstadoOrganizacionEntidad(int entidad,
			int idorganizacion, String estatus)
			throws SQLException;

	
	public void updateDescrupcionEntidad(int entidad,String descripcion)	throws SQLException;
	public void updateDescripcionOrganizacionEntidad(int entidad,int idorganizacion, String descripcion)	throws SQLException;
}