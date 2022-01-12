package com.servicio.search.idao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DireccionDTO;

public interface IBusquedaCPDao {

	public static final int MUNICIPIO = 1;
	public static final int ESTADO = 2;
	public static final int SIGLASEST = 3;
	public static final int REGIONAL = 4;

	/**
	 * Obtiene los datos del CP indicado
	 *
	 * @throws SQLException
	 *  @return un arreglo con todas las intancias de colonias asociadas a un CP
	 * las instancias son envueltas en un objeto de tipo CPs, en caso de no encontrar
	 * ningun registro devuelve un arreglo vacio
	 * @see CPs
	 */
	public abstract CPs getInfoCP(String cp) throws SQLException;//fin de getCPs

	///////////////////////////////////////////////////////////////////
	/**
	 * Obtiene las colonias asociadas a un CP
	 *
	 * @throws SQLException
	 *  @return un arreglo con todas las intancias de colonias asociadas a un CP
	 * las instancias son envueltas en un objeto de tipo CPs, en caso de no encontrar
	 * ningun registro devuelve un arreglo vacio
	 * @see CPs
	 */
	public abstract  List<CPs> getCPs(String cp) throws SQLException;//fin de getCPs

	/**
	 * Verifica si existe un CP en el catálogo de colonias
	 *
	 * @throws SQLException
	 *  @return true si existe false en cualquier otro caso
	 */
	public abstract boolean isExistCP(String cp) throws SQLException;//fin de isExistCP

	/**
	 * Obtiene los datos de municipio y estado de un CP determinado
	 *
	 * @throws SQLException
	 *  @return true si existe false en cualquier otro caso
	 */
	public abstract CPs getMunicpioEstadoDelCP(String cp) throws SQLException;//fin de isExistCP

	/**
	 * Obtiene un dato en particular de un código postal, de acuerdo a la etiqueta que indique el 
	 * usuario es la información que devolvera el metodo.
	 * 
	 * -MUNICIPIO
	 * -ESTADO
	 * -SIGLASEST
	 * -REGIONAL
	 * 
	 * En caso de no existir info devuelve null
	 *
	 * @throws SQLException
	 *  @return la info solicitada o null en caso de no encontrar información o la etiqueta no 
	 *  esta definida.
	 */
	public abstract String getInfoCP(String cp, int etiqueta)
			throws SQLException;//fin de isExistCP

	/**
	 * Obtiene todas las colonias correspoindientes al patron indicado por el usuario
	 * @throws SQLException
	 *  @return un arreglo con todas las intancias de colonias asociadas a un CP
	 * las instancias son envueltas en un objeto de tipo CPs, en caso de no encontrar
	 * ningun registro devuelve un arreglo vacio
	 * @see CPs
	 */
	public abstract  List<CPs> getColonias(String colonia) throws SQLException;//fin de getColonias

	/**
	 * Obtiene los municipios de un estado
	 * @throws SQLException
	 *  @return un arreglo con todas las intancias de colonias asociadas a un CP
	 * las instancias son envueltas en un objeto de tipo CPs, en caso de no encontrar
	 * ningun registro devuelve un arreglo vacio
	 * @see CPs
	 */
	public abstract  List<CPs> getMuniciposEstado(String estado)
			throws SQLException;//fin de getColonias

	/**
	 * Obtiene los datos de los CP asociados al municipio que corresponda al patron indicado 
	 * por el usuario
	 *
	 * @throws SQLException
	 *  @return un arreglo con todas las intancias de colonias asociadas a un CP
	 * las instancias son envueltas en un objeto de tipo CPs, en caso de no encontrar
	 * ningun registro devuelve un arreglo vacio
	 * @see CPs
	 */
	public abstract  List<CPs> getColoniasMunicipo(String municipio)
			throws SQLException;//fin de getColonias

	/**
	 * Obtiene la lista de los estados disponibles
	 *
	 * @throws SQLException
	 *  @return un arreglo con todas las intancias de colonias asociadas a un CP
	 * las instancias son envueltas en un objeto de tipo CPs, en caso de no encontrar
	 * ningun registro devuelve un arreglo vacio
	 * @see CPs
	 */
	public abstract  List<CPs> getEstado() throws SQLException;//fin de getColonias

	/** Obtiene la ciudad de un CP,  si no lo encuentra devuelve, inicializa la
	 * ciudad con el nombre del estado
	 *
	 * @throws SQLException
	 *  @return un arreglo con todas las intancias de colonias asociadas a un CP
	 * las instancias son envueltas en un objeto de tipo CPs, en caso de no encontrar
	 * ningun registro devuelve un arreglo vacio
	 * @see CPs
	 */
	public abstract CPs getCiudad(CPs cp) throws SQLException;//fin de getCiudad

	/**
	 * Obtiene los datos de un CP, cuando el usuario indica el correspondiente
	 * CP y Colonia
	 *
	 * @param id     identificador del CP
	 * @param colonia Colonia buscada
	 * @throws SQLException
	 * @return una instancia de CPs con los datos requeridos o null
	 * en caso de que no exista ningun dato
	 */
	public abstract CPs getCP(String id, String colonia) throws SQLException;//fin de getCP
	
	public List<DireccionDTO> getDatosDireccionCP(BusquedaDTO busqueda)
		throws Exception;

}