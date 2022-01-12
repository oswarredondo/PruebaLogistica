/**
 * ZVTASLOGISTICA_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mc_style.functions.soap.sap.document.sap_com;

public interface ZVTASLOGISTICA_PortType extends java.rmi.Remote {
    public void zsdVentasLogistica(java.lang.String PAuart, java.lang.String PBstkd, java.lang.String PCorreo, java.lang.String PDocumento, java.lang.String PKunnr, java.lang.String PNumdocLog, java.lang.String PProceso, java.lang.String PSpart, java.lang.String PTipo, java.lang.String PVkorg, java.lang.String PVstel, java.lang.String PVtweg, java.lang.String PWerks, java.lang.String PZterm, mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdVovPedidoHolder TMov, mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder TTxtHead, mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder TTxtOper, javax.xml.rpc.holders.StringHolder PDocfi, javax.xml.rpc.holders.StringHolder PFactura, javax.xml.rpc.holders.StringHolder PMensaje, javax.xml.rpc.holders.StringHolder PPedido, javax.xml.rpc.holders.StringHolder PResultado) throws java.rmi.RemoteException;
}
