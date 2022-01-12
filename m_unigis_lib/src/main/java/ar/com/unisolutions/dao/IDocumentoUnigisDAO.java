package ar.com.unisolutions.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.List;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.DocumentoPesoKMMaximo;
import com.innovargia.documentos.dtos.Objeto;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Entrega;

public interface IDocumentoUnigisDAO {

	/**
	 * Obtiene la informacion de documento, comparamdo la razon social destino
	 * del tipo de documento indicado
	 * 
	 * @param fechaini
	 * @param fechafin
	 * @param razonSocial
	 * @param tipoDocumento
	 *            si tipo de documento es NULL busca todos los documentos sin
	 *            importar
	 * @return
	 */
	public abstract List<DocumentoConsultaDTO> busquedaXRazonSocial(
			String fechaini, String fechafin, String razonSocial,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

	public abstract List<DocumentoConsultaDTO> busquedaTelDestino(
			String fechaini, String fechafin, String telfonodes,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

	/**
	 * Obtiene la informacion de documento, comparamdo la factura
	 * 
	 * @param fechaini
	 * @param fechafin
	 * @param referencia
	 * @param tipoDocumento
	 *            si tipo de documento es NULL busca todos los documentos sin
	 *            importar
	 * @return
	 */
	public abstract List<DocumentoConsultaDTO> busquedaXFactura(String fechaini,
			String fechafin, String factura, String tipoDocumento,
			DocumentoDTO datos, UsuarioDTO usuario);

	/**
	 * Obtiene la informacion de documento, comparamdo la delivery
	 * 
	 * @param fechaini
	 * @param fechafin
	 * @param referencia
	 * @param tipoDocumento
	 *            si tipo de documento es NULL busca todos los documentos sin
	 *            importar
	 * @return
	 */
	public abstract List<DocumentoConsultaDTO> busquedaXDelivery(String fechaini,
			String fechafin, String delivery, String tipoDocumento,
			DocumentoDTO datos, UsuarioDTO usuario);

	/**
	 * Obtiene la informacion de documento, comparamdo la shipment
	 * 
	 * @param fechaini
	 * @param fechafin
	 * @param referencia
	 * @param tipoDocumento
	 *            si tipo de documento es NULL busca todos los documentos sin
	 *            importar
	 * @return
	 */
	public abstract List<DocumentoConsultaDTO> busquedaXShipment(String fechaini,
			String fechafin, String shipment, String tipoDocumento,
			DocumentoDTO datos, UsuarioDTO usuario);

	/**
	 * Obtiene la informacion de documento, comparamdo la referencia indicada
	 * 
	 * @param fechaini
	 * @param fechafin
	 * @param referencia
	 * @param tipoDocumento
	 *            si tipo de documento es NULL busca todos los documentos sin
	 *            importar el tipo
	 * @return
	 */
	public abstract List<DocumentoConsultaDTO> busquedaXReferencia(
			String fechaini, String fechafin, String referencia,
			String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

	public List<DocumentoConsultaDTO> getConsultaInfoDocumento(String iddocumento,
			String tipoDocumento, UsuarioDTO usuario, int tipobusqueda);
	
	
	public abstract List<DocumentoConsultaDTO> busquedaXGuiaInternacional(
		String iddocumento, String tipoDocumento, UsuarioDTO usuario);

	
	/**
	 * Obtiene la informacion de documento primero busca con la informacion 
	 * que existe en cadocumentos y despues contra los registros de historia y 
	 * confirmacion
	 * 
	 * @param iddocumento
	 *            identificador del documento que se desea buscar
	 * @return
	 */
	public abstract List<DocumentoConsultaDTO> getInfoDocumentoLike(
			String iddocumento, String tipoDocumento, UsuarioDTO usuario);

	/**
	 * Obtiene la informacion de documento, este metodo invoca los datos para
	 * obtener los datos de direcciones si tipoDocumento es NULL entonces busca
	 * todos los documentos sin importar su tipo
	 * 
	 * @param iddocumento
	 *            identificador del documento que se desea buscar
	 * @return
	 */
	public abstract List<DocumentoConsultaDTO> busquedaXFechasCreacion(
			String fechaini, String fechafin, String tipoDocumento,
			DocumentoDTO datos, UsuarioDTO usuario);
	
	public List<DocumentoConsultaDTO> busquedaXContenido(String fechaini,
			String fechafin, String contenido, String tipoDocumento,
			DocumentoDTO datos, UsuarioDTO usuario);
	
	public List<DocumentoConsultaDTO> busquedaXGuiaConsecutivo(
		String iddocumento, String tipoDocumento, UsuarioDTO usuario);
	
	
	public List<DocumentoConsultaDTO> busquedaXGuiaMadreMultiple(
		String iddocumento, String tipoDocumento, UsuarioDTO usuario);
	
	public List<DocumentoConsultaDTO> busquedaXGuiaCasamiento(
			String iddocumento, String tipoDocumento, UsuarioDTO usuario);
}
