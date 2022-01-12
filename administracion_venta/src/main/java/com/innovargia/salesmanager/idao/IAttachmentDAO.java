package com.innovargia.salesmanager.idao;

import java.util.ArrayList;
import java.util.List;

import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;

public interface IAttachmentDAO {

	/***
	 * Inserta un registro en un catalogo donde solamente existen los atributos
	 * de Id, Nombre, Descripcion y Estatus
	 * @param catalogo
	 * @throws Exception
	 */
	public void insert(AttachmentDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza un registro en un catalogo donde solamente existen los atributos
	 * de Nombre, Descripcion y Estatus dado su ID
	 * @param catalogo
	 * @throws Exception
	 */
	public void update(AttachmentDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza estatus de un registro
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateEstatus(AttachmentDTO catalogo) throws Exception;
	
	/***
	 * Borra un registro en un catalogo dado su id
	 * @param catalogo
	 * @throws Exception
	 */
	public void delete(AttachmentDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public List<AttachmentDTO> getRegistros(BusquedaDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los regisgtros de attachment cuando se dan diferentes ids y diferentes tipos
	 * de documentos
	 * @param arr_identificador
	 * @param arr_idtipodocumento
	 * @return
	 * @throws Exception
	 */
	public List<AttachmentDTO> getRegistros(ArrayList<String> arr_identificador, ArrayList<String> arr_idtipodocumento)
			throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public AttachmentDTO get(AttachmentDTO catalogo) throws Exception;
}