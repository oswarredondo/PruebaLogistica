package com.administracion.idao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.innovargia.documentos.dtos.Objeto;

public interface IServiciosDao {

	/**
	 * Verifica si existe el tipo de objeto servicio, empaques, garantias, etc
	 * 
	 * @throws SQLException
	 * @return una instancia de servicios con los datos requeridos o null en
	 *         caso de que no exista ningun dato
	 */
	public abstract Objeto getObjeto(String id, String query)
			throws SQLException;// fin de getObjeto

	/**
	 * Verifica si existe el tipo de objeto servicio, empaques, garantias, etc
	 * 
	 * @throws SQLException
	 * @return una instancia de servicios con los datos requeridos o null en
	 *         caso de que no exista ningun dato
	 */
	public abstract Objeto getObjeto(int id, String query) throws SQLException;// fin de getObjeto

	/**
	 * Verifica si existe el empaque/formatos buscado
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract Objeto getFormatos(String id) throws SQLException;// fin de getEmpaque

	/*
	 * Verifica si existe el empaque/formatos buscado
	 * 
	 * @throws SQLException
	 * 
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 * de que no exista ningun dato
	 */
	public abstract Objeto getFormaPago(String id) throws SQLException;// fin de getEmpaque

	/**
	 * Verifica si existe el empaque/formatos buscado
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract Objeto getAdicional(String id) throws SQLException;// fin de getEmpaque

	/**
	 * Verifica si existe el empaque/formatos buscado, regresa solamente la
	 * descripcion
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract String getDesFormatos(String id) throws SQLException;// fin de getEmpaque

	/**
	 * Verifica si existe el tipo de pago buscado, regresa solamente la
	 * descripcion
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract String getDesFormaPago(String id) throws SQLException;// fin de getEmpaque

	/**
	 * Obtiene la descripcion del tipo de envio
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract String getDesTipoEnvio(String id) throws SQLException;// fin de getTipoEnvio

	/**
	 * Obtiene la descripcion del tipo de servicio. Si el identificador del
	 * servicio es de dos caracteres siempre se toma el primero ya que indica el
	 * tipo de servicio adquirido y el segundo indica la forma de pago.
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract String getDesTipoServicio(String id) throws SQLException;// fin de getTipoEnvio

	/**
	 * Obtiene la descripcion del tipo de servicio
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract String getDesAdicional(String id) throws SQLException;// fin de getTipoEnvio

	/**
	 * Obtiene la descripcion del tipo de garantia
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract String getDesGarantia(String id) throws SQLException;// fin de getTipoEnvio

	/**
	 * Verifica si existe el formato/servicio buscado
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract Objeto getGarantia(String id) throws SQLException;// fin de getServicio

	/**
	 * Verifica si existe el formato/servicio buscado
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract Objeto getTipoEnvio(String id) throws SQLException;// fin de getGarantia

	/**
	 * Verifica si existe la garantia o tipos de servicios buscados
	 * 
	 * @throws SQLException
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract Objeto getTipoServicio(String id) throws SQLException;// fin de getGarantia

	/**
	 * Obtiene los datos solictados de servicios, formatos, garantias a traves
	 * de identificador,Utils.TIPO_ENVIO,Utils.TIPO_SERVICIO, Utils.FORMATOS,
	 * Utils.GARANTIA, Utils.TIPO_ADICIONAL, si el tipo indicado no se encuentra
	 * dentro de los validos devuelve Utils.FORMATOS por default.
	 * 
	 * @param id
	 * @throws SQLException
	 * @return una instancia de usuario con los datos requeridos o null en caso
	 *         de que no exista ningun dato
	 */
	public abstract ArrayList getListaObjetos(int _lista) throws SQLException;// fin de getListaObjetos

}