package com.tracusa.logistica.interfaces.bo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.tracusa.logistica.model.CartaPorteResumen;
import com.tracusa.logistica.model.DetalleFactura;
import com.tracusa.logistica.model.SapResult;
import com.tracusa.logistica.model.ViajeFinCarga;
import com.tracusa.logistica.unigis.ccp.UnigisCCP;

import ar.com.unisolutions.ConsultarViajeResultado;
import me.saro.sap.jco.SapFunctionResult;

public interface ICartaPorteBO {

    public ConsultarViajeResultado getViaje(ViajeFinCarga viaje) throws Exception;

    public ConsultarViajeResultado getViajeToSap(ViajeFinCarga viaje) throws Exception;

    public int createMarcaFactura(CartaPorteResumen cartaPorteResumen) throws Exception;

    public void marcarGuias(int idControl, String factura, String lstDocumentos);

    public List<SapResult> getFacturaSap(UnigisCCP unigisccp) throws Exception;

    public UnigisCCP getRestViaje(ViajeFinCarga viaje) throws UnsupportedEncodingException, IOException;

    int crearDocumentos(DetalleFactura detalleFactura);

    int modificarViajeConParadas(DetalleFactura detalleFactura);

    int updateStatus(DetalleFactura detalleFactura) throws Exception;

    void timbrarMarcaFactura(DetalleFactura detalleFactura);
}
