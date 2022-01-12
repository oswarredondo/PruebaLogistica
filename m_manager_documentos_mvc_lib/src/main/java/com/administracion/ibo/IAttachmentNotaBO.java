/**
 * 
 */
package com.administracion.ibo;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;

/**
 * @author aruaro
 *
 */
public interface IAttachmentNotaBO {
	/***
	 * Inserta un registro en un catalogo donde solamente existen los atributos
	 * de Id, Nombre, Descripcion y Estatus
	 * @param catalogo
	 * @throws Exception
	 */
	public void insert(AttachmentDTO catalogo,InputStream inputstream) throws Exception;
	
	
	
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
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public List<AttachmentDTO> getRegistros(BusquedaDTO catalogo) throws Exception;
	
	/***
	 * Borra un registro en un catalogo dado su id
	 * @param catalogo
	 * @throws Exception
	 */
	public void delete(AttachmentDTO catalogo) throws Exception;
	
	
	
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
	
	public AttachmentDTO getRegistro(int idregistro) throws Exception;
	/***
	 * Obtiene los datos del archivo que se desea
	 * @param fileName
	 * @return
	 */
	public File getFile(String fileName);
	
	/***
	 * Inserta un registro en un catalogo donde solamente existen los atributos
	 * de Id, Nombre, Descripcion y Estatus
	 * @param catalogo
	 * @throws Exception
	 */
	public void insertNotaAgenda(AttachmentDTO catalogo,InputStream inputstream) throws Exception;
	/***
	 * Actrualiza un registro en un catalogo donde solamente existen los atributos
	 * de Nombre, Descripcion y Estatus dado su ID
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateNotaAgenda(AttachmentDTO catalogo) throws Exception;
	/***
	 * Actrualiza estatus de un registro
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateEstatusAgenda(AttachmentDTO catalogo) throws Exception;
	
	/***
	 * Borra un registro en un catalogo dado su id
	 * @param catalogo
	 * @throws Exception
	 */
	public void deleteAgenda(AttachmentDTO catalogo) throws Exception;
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public List<AttachmentDTO> getRegistrosNotasAgenda(BusquedaDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los datos del archivo que se desea
	 * @param fileName
	 * @return
	 */
	public File getFileNotasAgenda(String fileName);
	
	/***
	 * Obtiene el registro y el base64 del archivo que ampara esto para poder 
	 * convertirlo a un archivo como primera opción
	 * @param idregistro
	 * @return
	 * @throws Exception
	 */
	public AttachmentDTO getRegistroBase64(int idregistro) throws Exception;
	

}
