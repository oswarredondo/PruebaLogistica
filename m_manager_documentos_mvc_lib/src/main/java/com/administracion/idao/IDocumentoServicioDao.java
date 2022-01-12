package com.administracion.idao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.List;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.DocumentoPesoKMMaximo;
import com.innovargia.documentos.dtos.Objeto;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Entrega;
import com.tracusa.ccp.FacturaCCP;

public interface IDocumentoServicioDao {
    public void insertDatosDocumentoEtiqueta(DocumentoDTO carta) throws SQLException;

    /**
     * Solicita la cancelacion de un documento, solo se cancela si:
     * 
     * No esta confirmado No tiene historia Es de la Entidad y organizacion del
     * UsuarioDTO
     * 
     * @param iddocumento
     * @param UsuarioDTO
     * @throws SQLException
     */
    public abstract int cancelaDocumento(String iddocumento, UsuarioDTO usuario) throws SQLException;

    public int cancelaDocumento(String iddocumento) throws SQLException;

    /**
     * Actualiza los datos de la cita de un documento
     * 
     * @param iddocumento
     * @param UsuarioDTO
     * @throws SQLException
     */
    public abstract void updateCitaDocumento(String iddocumento, String fecha, String hora, String folio,
	    UsuarioDTO usuario) throws SQLException;

    /**
     * Inserta el detalle del precio del servicio
     * 
     * @param carta
     * @throws SQLException
     */
    public abstract void insertPrecioServicio(DocumentoDTO carta, Connection cnx, UsuarioDTO usuario)
	    throws SQLException;

    /**
     * Inserta el detalle del documento este afecta la tabla de
     * cadetalledocumentoserv
     * 
     * @param carta
     * @throws SQLException
     */
    public abstract void insertDetalleDocumento(DocumentoDTO carta, Connection cnx) throws SQLException;

    /**
     * Inserta los datos del documento
     * 
     * @param carta
     * @throws SQLException
     */
    public abstract void insertDatosDocumento(DocumentoDTO carta, Connection cnx) throws SQLException;

    /**
     * Inserta el registro de direccion de carta porte
     * 
     * @param direccion
     * @param id
     * @param numcliente
     * @param login
     * @throws SQLException
     */
    public abstract void insertDireccionDocumento(RemDes direccion, String iddocumento, String numcliente, String login,
	    Connection cnx) throws SQLException;

    /**
     * Inserta el registro de documento de retorno
     * 
     * @param direccion
     * @param id
     * @param numcliente
     * @param login
     * @throws SQLException
     */
    public abstract void insertGuiasRetorno(String iddocumento, String iddocumentoretorno, Connection cnx)

	    throws SQLException;

    /**
     * Inserta los atributos de un documento
     * 
     * @param idDocto
     * @param numcliente
     * @param objeto
     * @param login
     * @throws SQLException
     */
    public abstract void insertParametrosDocumento(Objeto objeto, DocumentoDTO documento, Connection cnx)
	    throws SQLException;

    /**
     * Ajusta el valor del campo marcafactura a NULL la marca de marcafactura
     * (previo) sea igual a la llave indicada
     * 
     * @param marcafactura
     * @param UsuarioDTO
     * @throws SQLException
     */
    public abstract void desmarcaPrevioFacturaDocumento(String marcafactura, UsuarioDTO usuario) throws SQLException;

    /**
     * Actualiza el campo de marcafactura de documento dentro de un rango y que
     * pertenezca a los clientes indicados, si tipoDocumento='*' actualiza todos los
     * registros sin importar eltipo de servicio en cualquier otro caso actualiza
     * solo registros donde el tipo de documento sea igual al valor de
     * tipoDocumento.
     * 
     * Este campo sirve como prefacturacion para posteriormente el UsuarioDTO pueda
     * facturar para que se actualice el campo de isfacturado con el numero de
     * prefacturacon
     * 
     * @param cuentas_arr
     * @param fechacorte
     * @param factura
     * @param tipoDocumento
     * @param UsuarioDTO
     * @param identidad
     * @param idorganizacion
     * @param marcafactura
     * @throws SQLException
     */
    public abstract void marcaPreFacturaDocumento(String[] cuentas_arr, String fechacorte, String tipoDocumento,
	    UsuarioDTO usuario, int idorganizacion, String marcafactura) throws SQLException;

    /**
     * Devuelve los identificadores de prefacturas que aun no han sido facturados de
     * una entidad y organizacion
     * 
     * @param UsuarioDTO
     * @param organizacion
     * @return
     * @throws SQLException
     */
    public abstract List<Objeto> listaMarcaFacturaPendientes(UsuarioDTO usuario, int organizacion) throws SQLException;

    /***
     * verifica si existen notas en un documento
     * 
     * @param iddocumento
     * @return
     * @throws SQLException
     */
    public abstract String isExisteNOta(String iddocumento) throws SQLException;

    /**
     * Marca los registros en el campo isfacturado indicando la prefactura
     * 
     * @param factura
     * @param prefactura
     * @param UsuarioDTO
     * @throws SQLException
     */
    public abstract void marcaFacturaDocumento(String factura, String prefactura, UsuarioDTO usuario)
	    throws SQLException;

    /**
     * Obtiene la informacon de una direccion de acuerdo a su documento padre y al
     * tipo de direccion
     * 
     * @param iddocumento
     * @param tipoDireccion
     * @return
     */
    public abstract RemDes getInfoDireccion(String iddocumento, String tipoDireccion, String idtipodocumento);

    /**
     * Obtiene la informacion de documento, comparamdo la razon social destino del
     * tipo de documento indicado
     * 
     * @param fechaini
     * @param fechafin
     * @param razonSocial
     * @param tipoDocumento si tipo de documento es NULL busca todos los documentos
     *                      sin importar
     * @return
     */
    public abstract List<DocumentoConsultaDTO> busquedaXRazonSocial(String fechaini, String fechafin,
	    String razonSocial, String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

    public abstract List<DocumentoConsultaDTO> busquedaTelDestino(String fechaini, String fechafin, String telfonodes,
	    String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

    /**
     * Obtiene la informacion de documento, comparamdo la factura
     * 
     * @param fechaini
     * @param fechafin
     * @param referencia
     * @param tipoDocumento si tipo de documento es NULL busca todos los documentos
     *                      sin importar
     * @return
     */
    public abstract List<DocumentoConsultaDTO> busquedaXFactura(String fechaini, String fechafin, String factura,
	    String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

    /**
     * Obtiene la informacion de documento, comparamdo la delivery
     * 
     * @param fechaini
     * @param fechafin
     * @param referencia
     * @param tipoDocumento si tipo de documento es NULL busca todos los documentos
     *                      sin importar
     * @return
     */
    public abstract List<DocumentoConsultaDTO> busquedaXDelivery(String fechaini, String fechafin, String delivery,
	    String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

    /**
     * Obtiene la informacion de documento, comparamdo la shipment
     * 
     * @param fechaini
     * @param fechafin
     * @param referencia
     * @param tipoDocumento si tipo de documento es NULL busca todos los documentos
     *                      sin importar
     * @return
     */
    public abstract List<DocumentoConsultaDTO> busquedaXShipment(UsuarioDTO user, String shipment,
	    Hashtable condiciones, String tipoDocumento, UsuarioDTO usuario);

    /**
     * Obtiene los documentos que tengan
     * identidad+idorganizacion+numcliente+shipment
     * 
     * @param datoscarta
     * @param user
     * @return
     */
    public abstract List<DocumentoConsultaDTO> busquedaDocumentosEstatus(DocumentoDTO datoscarta, UsuarioDTO user);

    /**
     * Obtiene la informacion de documento, comparamdo la shipment
     * 
     * @param fechaini
     * @param fechafin
     * @param referencia
     * @param tipoDocumento si tipo de documento es NULL busca todos los documentos
     *                      sin importar
     * @return
     */
    public abstract List<DocumentoConsultaDTO> busquedaXShipment(String fechaini, String fechafin, String shipment,
	    String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

    /**
     * Obtiene la informacion de documento, comparamdo la referencia indicada
     * 
     * @param fechaini
     * @param fechafin
     * @param referencia
     * @param tipoDocumento si tipo de documento es NULL busca todos los documentos
     *                      sin importar el tipo
     * @return
     */
    public abstract List<DocumentoConsultaDTO> busquedaXReferencia(String fechaini, String fechafin, String referencia,
	    String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

    /**
     * Obtiene los identificadors de embarques de una cuenta cliente
     * 
     * @param user
     * @return
     */
    public abstract List<DocumentoConsultaDTO> getEmbarquesDocumentoCliente(UsuarioDTO user);

    /**
     * Obtiene la informacion de documento, este metodo invoca los datos para
     * obtener los datos de direcciones si tipoDocumento es NULL entonces busca
     * todos los documentos sin importar su tipo
     * 
     * @param iddocumento identificador del documento que se desea buscar
     * @return
     */
    public abstract DocumentoDTO getInfoDocumento(String iddocumento, UsuarioDTO usuario);

    public List<DocumentoConsultaDTO> getConsultaInfoDocumento(String iddocumento, String tipoDocumento,
	    UsuarioDTO usuario, int tipobusqueda);

    /**
     * Obtiene la informacion de documento, este metodo invoca los datos para
     * obtener los datos de direcciones si tipoDocumento es NULL entonces busca
     * todos los documentos sin importar su tipo
     * 
     * @param iddocumento identificador del documento que se desea buscar
     * @return
     */
    public abstract List<DocumentoDTO> getInfoDocumento(String iddocumento, String tipoDocumento, UsuarioDTO usuario);

    public abstract List<DocumentoConsultaDTO> busquedaXGuiaInternacional(String iddocumento, String tipoDocumento,
	    UsuarioDTO usuario);

    /**
     * Obtiene la informacion de documento primero busca con la informacion que
     * existe en cadocumentos y despues contra los registros de historia y
     * confirmacion
     * 
     * @param iddocumento identificador del documento que se desea buscar
     * @return
     */
    public abstract List<DocumentoConsultaDTO> getInfoDocumentoLike(String iddocumento, String tipoDocumento,
	    UsuarioDTO usuario);

    /**
     * Busca el documento por su tipo, numero de rastreo, entidad y organizacion
     * 
     * @param iddocumento identificador del documento que se desea buscar
     * @return
     */
    public abstract List<DocumentoConsultaDTO> getInfoDocumentoXRastreo(DocumentoDTO datosdocto, String tipoDocumento,
	    UsuarioDTO usuario);

    /**
     * Busca el documento por su tipo, sold party y rango de fechas
     * 
     * @param iddocumento identificador del documento que se desea buscar
     * @return
     */
    public abstract List<DocumentoConsultaDTO> getInfoDocumentoXTransporte(DocumentoDTO datosdocto, String fechaini,
	    String fechafin, int tipobusqueda, UsuarioDTO usuario);

    /**
     * Obtiene la informacion de documento, este metodo invoca los datos para
     * obtener los datos de direcciones si tipoDocumento es NULL entonces busca
     * todos los documentos sin importar su tipo
     * 
     * @param iddocumento identificador del documento que se desea buscar
     * @return
     */
    public abstract List<DocumentoConsultaDTO> busquedaXFechasCreacion(String fechaini, String fechafin,
	    String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

    /**
     * Actualiza los datos de ruta y fecha de asignacion cuando se ha realizado la
     * asignacion de uina ruta
     * 
     * @param iddocumento
     * @param ruta
     * @param fechaasignacion
     * @param tipodocumento
     * @throws Exception
     */
    public abstract void updateAsignacionRuta(String iddocumento, String ruta, Timestamp fechaasignacion,
	    String tipodocumento) throws Exception;

    /**
     * Actualiza los estados de docuemntos
     * 
     * @param datos
     * @param user
     * @throws Exception
     */
    public abstract void updateEstatusDocumentos(DocumentoDTO datos, UsuarioDTO user) throws Exception;

    /**
     * Actualiza loca campos de Rechazo para todos los documjentos donde se
     * identidad+idorganizacion+factura sean iguala lo indicado
     * 
     * @param datos
     * @param user
     * @throws Exception
     */
    public abstract void updateRechazoDocumentos(DocumentoDTO datos, UsuarioDTO user) throws Exception;

    public List<LogHistoriaDTO> getHistoriaDocumento(String iddocumento, UsuarioDTO usuario);

    public List<DocumentoConsultaDTO> busquedaXContenido(String fechaini, String fechafin, String contenido,
	    String tipoDocumento, DocumentoDTO datos, UsuarioDTO usuario);

    public DocumentoDTO getInfoDocumentoJson(String iddocumento);

    public List<DocumentoDTO> getInfoDocumentoMadre(String iddocumento);

    public void updateDoccumentoEtiqueta(EtiquetaRotulacionDTO etiqueta, String idguia) throws SQLException;

    public void insertDoccumentoTransbordos(EtiquetaRotulacionDTO etiqueta) throws SQLException;

    public void insertAdicionalesDocumento(EtiquetaRotulacionDTO etiqueta) throws SQLException;

    public void insertConfirmaEntregaEnvio(Entrega entrega) throws SQLException;

    public List<DocumentoConsultaDTO> busquedaXGuiaCasamiento(String iddocumento, String tipoDocumento,
	    UsuarioDTO usuario);

    public List<DocumentoConsultaDTO> busquedaXGuiaConsecutivo(String iddocumento, String tipoDocumento,
	    UsuarioDTO usuario);

    public void updateDoccumentoEtiquetaMultiple(String iddocumento, String idguiamadremultiple, String es_multiple,
	    int consecutivo, int cantidad_multiples) throws SQLException;

    public List<DocumentoConsultaDTO> busquedaXGuiaMadreMultiple(String iddocumento, String tipoDocumento,
	    UsuarioDTO usuario);

    public DocumentoConsultaDTO getInfoGuia(String iddocumento);

    public void insertPesoKmAmpara(DocumentoPesoKMMaximo datos) throws SQLException;

    public ServicioDTO getTipoCobroServicio(String idservicio) throws Exception;

    public List<AdicionalDTO> getAdicionalesDocumento(String iddocumento) throws SQLException;

    public void insertGuiasACU(String iddocumento, int idventa, String iduui) throws SQLException;

    public List<ServicioDTO> getTipoServicioXTipoCobro(String tipocobro) throws Exception;

    public DocumentoConsultaDTO getInfoDocumentoMensajeria(String iddocumento);

    public List<FacturaCCP> getFacturasCCP(String viaje);
}