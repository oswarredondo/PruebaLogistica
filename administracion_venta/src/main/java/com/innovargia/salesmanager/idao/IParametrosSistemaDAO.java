/**
 * 
 */
package com.innovargia.salesmanager.idao;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.mail.EmailProperties;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;

/**
 * @author aruaro
 *
 */
public interface IParametrosSistemaDAO {

	
	/**
	 * Obtiene los datos de la propiedad solicitada, Entre las pripiedades
	 * existentes estan: <b>PathLogosEtiqueta</b>= Contiene el path físico donde
	 * se encuentran almacenadas las imagenes que son configuradas en la
	 * rotulación o importación de una etiqueta <b>Debug</b>= indica si se deben
	 * desplegar los datos de debug en pantalla <b>DirPDFTXTFile</b>= indica
	 * donde se van a almacenar todos los archivos de texto o pdf que genere el
	 * sistema <b>DirPDFTXTFile</b>
	 * 
	 * En caso de no encontrar el valor devuelve null.
	 * @param idSistema
	 * @param propiedad
	 * @return
	 */
	public String getValorPropiedad(String idparametro,String idsistema) throws Exception;
	public int  getValorPropiedadInt(String idparametro, String idsistema)throws Exception;
	public String getValorPropiedad(String idparametro,List<SistemaDTO> lista)
		throws Exception;
	public int getValorPropiedadInt(String idparametro,List<SistemaDTO> lista)
		throws Exception;
	
	/**
	 * Obtiene los paths asociados al sistema donde se pueden gardar en disco
	 * los documentos, imagenesm que serán asociados a un cliente y usuario,
	 * para cada imagen se guarda con el identificador de cliente, si se tiene
	 * una imagen llamada logo.gif para "X" empresa y un logo.gif para "Y" empresa,
	 * se le antepone el identificador del cliente de tal forma que se debe
	 * guardar X_logo.gif y Y_logo.gif y de esta manera en cuanquier proceso
	 * debe buscarse de esta forma
	 * 
	 * @param idSistema
	 *            identificador del sistema
	 * @param numCliente
	 *            identificador del cliente al cual pertenece la configuracion
	 * @param login
	 *            login del usuario que se esta firmando al sistema principal
	 * @return instancia de un objeto tipo Sistema, en caso de no encontrar
	 *         ningun dato retorna null
	 **/
	public SistemaDTO getPathsSistema(String idSistema, String numCliente)
			throws Exception;
	
	/***
	 * Obtiene los datos generales de un documento
	 * @param identidad
	 * @param organizacion
	 * @param onlyVisible
	 * @return
	 * @throws Exception
	 */
	public  MetaDatoCatalogoDTO getDatosTipoDoc(String id, int identidad, int organizacion)
			throws Exception;
	
	/**
	 * Obtiene las propiedades para el envio de correos todos estos deben 
	 * tener como identificador de sistema EMAILPROP, Si se manda un objeto de 
	 * propiedades solamente complementa los datos de conexion encontrados 
	 * despues de realizar la consulta, en caso de que senvie nulo crea un objeto de 
	 * EmailProperties
	 * @return
	 * @throws SQLException
	 */
	public EmailProperties getPropiedadesEmail(EmailProperties propiedades,String sistema) throws SQLException;
	
	
	/***
	 * Inserta un registro en un catalogo donde solamente existen los atributos
	 * de Id, Nombre, Descripcion y Estatus
	 * @param catalogo
	 * @throws Exception
	 */
	public void insert(SistemaDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza un registro en un catalogo donde solamente existen los atributos
	 * de Nombre, Descripcion y Estatus dado su ID
	 * @param catalogo
	 * @throws Exception
	 */
	public void update(SistemaDTO catalogo) throws Exception;
	
	/***
	 * Borra un registro en un catalogo dado su id
	 * @param catalogo
	 * @throws Exception
	 */
	public void delete(SistemaDTO catalogo) throws Exception;
	

	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public List<SistemaDTO> getRegistros(String idsistema) throws Exception;

}
