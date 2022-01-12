package com.innovargia.salesmanager.ups.ibo;

import java.util.List;

import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;

public interface ITrackingBO {

    public List<LogHistoriaDTO> tracking(EtiquetaRotulacionDTO etiqueta, int accion) throws Exception;
    public List<LogHistoriaDTO> trackingS(CuentasConexionMensajeriaDTO cuentaconexion, EtiquetaRotulacionDTO etiqueta) throws Exception ;

}