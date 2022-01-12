package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.mail.EmailProperties;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;

public interface ICotizacionPreConvenioBO {

	/***
	 * Inserta un registro en un catalogo donde solamente existen los atributos
	 * de Id, Nombre, Descripcion y Estatus
	 * @param catalogo
	 * @throws Exception
	 */
	public int insert(ConvenioContratoDTO obj) throws Exception;
	
	/***
	 * Actrualiza un registro en un catalogo donde solamente existen los atributos
	 * de Nombre, Descripcion y Estatus dado su ID
	 * @param catalogo
	 * @throws Exception
	 */
	public void update(ConvenioContratoDTO obj) throws Exception;
	
	/***
	 * Actrualiza estatus de un registro
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateEstatus(ConvenioContratoDTO obj) throws Exception;
	
	/***
	 * Actrualiza el tipo de cierre
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateTipoCierre(ConvenioContratoDTO obj) throws Exception;
	
	/***
	 * Borra un registro en un catalogo dado su id
	 * @param catalogo
	 * @throws Exception
	 */
	public void delete(ConvenioContratoDTO obj) throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public List<ConvenioContratoDTO> getRegistros(BusquedaDTO obj) throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public ConvenioContratoDTO get(ConvenioContratoDTO obj) throws Exception;
	
	/***
	 * Crea el PDF devuelve el arreglo de bytes para poder ser mostrado en pantalla
	 * 
	 */
	public byte[] getPDFCotizacion(ConvenioContratoDTO obj)throws Exception;
	
	/***
	 * Envia un correo con el documento indicado
	 * @param documento
	 * @param send_email
	 * @throws Exception
	 */
	public void sendMail(ConvenioContratoDTO documento,	EmailProperties send_email )throws Exception;
	
	/***
	 * Actualiza el dato del creador del documneto
	 * @param obj
	 * @throws Exception
	 */
	public void updateUsuarioCreador(ConvenioContratoDTO obj) throws Exception;

}