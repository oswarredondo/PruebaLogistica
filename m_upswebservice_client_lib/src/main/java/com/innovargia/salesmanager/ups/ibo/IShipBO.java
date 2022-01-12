package com.innovargia.salesmanager.ups.ibo;

import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;

public interface IShipBO {

    public String ship(EtiquetaRotulacionDTO etiqueta, int accion) throws Exception;
    public CuentasConexionMensajeriaDTO ship(CuentasConexionMensajeriaDTO cuentaconexion, EtiquetaRotulacionDTO etiqueta) throws Exception; 

}