package com.administracion.ibo;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Entrega;
import com.servicio.dtos.Movimiento;
import com.tracusa.ccp.FacturaCCP;

public interface IDocumentoServicioBO {

    public abstract List<DocumentoConsultaDTO> consulta(DocumentoDTO datos, int tipobusqueda, String fechaini,
	    String fechafin, UsuarioDTO usuario) throws Exception;

    /* REENVIO UNIGIS */
    public abstract List<DocumentoConsultaDTO> consultaEtiquetasUnigis(DocumentoDTO datos, int tipobusqueda,
	    String fechaini, String fechafin, UsuarioDTO usuario) throws Exception;

    public DocumentoDTO getInfoDocumento(String iddocumento, UsuarioDTO usuario);

    public List<LogHistoriaDTO> getHistoriaDocumento(String iddocumento, UsuarioDTO usuario);

    public void cancelaDocumento(String iddocumento, UsuarioDTO usuario) throws Exception;

    public DocumentoDTO getInfoDocumentoJson(String iddocumento);

    public List<DocumentoDTO> getInfoDocumentoMadre(String iddocumento);

    public void insertHistoriaDocumento(Movimiento movimiento) throws SQLException;

    public void insertConfirmaEntregaEnvio(Entrega entrega) throws SQLException;

    public DocumentoConsultaDTO getInfoGuia(String iddocumento);

    public void cancelaDocumento(String iddocumento, UsuarioDTO usuario, String folio) throws Exception;

    public List<ServicioDTO> getTipoServicioXTipoCobro(String tipocobro) throws Exception;

    public DocumentoConsultaDTO getInfoDocumentoMensajeria(String iddocumento);

    public List<FacturaCCP> getFacturasCCP(String viaje);
}