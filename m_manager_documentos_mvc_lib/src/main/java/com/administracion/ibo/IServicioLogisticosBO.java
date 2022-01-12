package com.administracion.ibo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import com.innovargia.documentos.dtos.Objeto;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Zona;

public interface IServicioLogisticosBO {

	public static final String TIPO_DOC_MARCADOMAN = "MARCADOMAN";
	public static final String TIPO_DOC_FACTURADO = "FACTURADO";

	/**
	 * Marca los  documentos cuyo marcafactura y entidad sean las indicadas
	 *
	 * @param factura
	 * @param marcafactura
	 * @param UsuarioDTO
	 * @throws Exception
	 */
	public abstract void marcaDocumentoFactura(String factura,
			String marcafactura, UsuarioDTO UsuarioDTO) throws Exception;

	/**
	 * Obtiene una listra con todas las marcas de factura realizadas y que aun noi
	 * han sido facturadas de una organizacion y una entidad
	 *
	 * @param organizacion
	 * @param UsuarioDTO
	 * @throws Exception
	 */
	public abstract ArrayList<Objeto> listaMarcaFacturaPendientes(
			UsuarioDTO UsuarioDTO, int organizacion) throws Exception;

	/**
	 * Realiza el premarcado de los registros indicados por el UsuarioDTO de
	 * acuerdo a los parametros indicados
	 * 
	 * @param fechacorte
	 * @param cuentas_arr
	 * @param tipoDocumento
	 * @param UsuarioDTO
	 * @param idorganizacion
	 * @return el identificador de la prefactura
	 */
	public abstract String marcaPrefactura(String fechacorte,
			String[] cuentas_arr, String tipoDocumento, UsuarioDTO UsuarioDTO,
			int idorganizacion) throws Exception;

	/**
	 * Desmarca los registros de carta porte
	 * 
	 * @param carta
	 */
	public abstract void desmarcaPrevio(String marcafactura,
			UsuarioDTO UsuarioDTO) throws Exception;

	/**
	 * Solicita la cancelacion de un documento, solo se cancela si:
	 * 
	 * No esta confirmado No tiene historia Es de la Entidad y organizacion del
	 * UsuarioDTO
	 * 
	 * @param datos
	 * @param UsuarioDTO
	 */
	public abstract void cancelar(String iddocumento, UsuarioDTO UsuarioDTO)
			throws Exception;

	public abstract void updateCita(String iddocumento, String fecha,
			String hora, String folio, UsuarioDTO UsuarioDTO) throws Exception;

	/**
	 * Busca el cruce de zonas
	 * 
	 * @param cprecolecta
	 * @param cpDestino
	 * @return
	 */
	public abstract Zona buscaZonas(String cprecolecta, String cpDestino);

	public abstract double getCantidadIva(Zona cruceZonas);

	/**
	 * Agrega los parametros de la carta, este afecta la tabla de
	 * cadocumentoatributo
	 * 
	 * @param parametros
	 * @param idDocto
	 * @param numCliente
	 * @return
	 */
	public abstract int creaParametrosDocumento(ArrayList<Objeto> parametros,
			DocumentoDTO carta, Connection cnx);

	/**
	 * Crea el detalle de una carta, este afecta la tabla de
	 * cadetalledocumentoserv
	 * 
	 * @param detalle
	 * @param carta
	 * @param cnx
	 * @throws Exception
	 */
	public abstract void creaDetalleDocumento(ArrayList<DocumentoDTO> detalle,
			DocumentoDTO carta, Connection cnx) throws Exception;

	/**
	 * Crea el detalle del precio del servicio
	 * 
	 * @param detalle
	 * @param carta
	 * @param cnx
	 * @throws Exception
	 */
	public abstract void creaDetallePrecioServicio(DocumentoDTO carta,
			Connection cnx, UsuarioDTO UsuarioDTO) throws Exception;

	/**
	 * Actualiza los datos de rechazo
	 * @param datos
	 * @param user
	 * @throws Exception
	 */
	public abstract void updateRechazoDocumentos(DocumentoDTO datos,
			UsuarioDTO user) throws Exception;

	public abstract double getSubTotal(Zona cruceZonas);

	public abstract double getTotal(Zona cruceZonas);

	public abstract String getTotalLetraMoneda(double cantidad);

	/**
	 * Obtiene el OutputStream para un reporte dado
	 * @param cartaPorte
	 * @return
	 */
	public abstract byte[] creaByteArrayOutputStream(String idTipoDocumento,
			Map<String, String> parameters, UsuarioDTO UsuarioDTO);

	/**
	 * Regla de negocio para actualizar los datos del documento
	 * @param carta
	 * @param user
	 */
	public abstract void marcaEstatusDocumentos(DocumentoDTO carta,
			UsuarioDTO user) throws Exception;

}