package mc_style.functions.soap.sap.document.sap_com;

public class ZVTASLOGISTICAProxy implements mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA {
  private String _endpoint = null;
  private mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA zVTASLOGISTICA = null;
  
  public ZVTASLOGISTICAProxy() {
    _initZVTASLOGISTICAProxy();
  }
  
  public ZVTASLOGISTICAProxy(String endpoint) {
    _endpoint = endpoint;
    _initZVTASLOGISTICAProxy();
  }
  
  private void _initZVTASLOGISTICAProxy() {
    try {
      zVTASLOGISTICA = (new mc_style.functions.soap.sap.document.sap_com.ZwsvtaslogisticaLocator()).getzwsvtaslogistica();
      if (zVTASLOGISTICA != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)zVTASLOGISTICA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)zVTASLOGISTICA)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (zVTASLOGISTICA != null)
      ((javax.xml.rpc.Stub)zVTASLOGISTICA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA getZVTASLOGISTICA() {
    if (zVTASLOGISTICA == null)
      _initZVTASLOGISTICAProxy();
    return zVTASLOGISTICA;
  }
  
  public void zsdVentasLogistica(java.lang.String PBstkd, java.lang.String PCorreo, java.lang.String PDocumento, java.lang.String PKunnr, java.lang.String PNumdocLog, java.lang.String PProceso, java.lang.String PSpart, java.lang.String PTipo, java.lang.String PZterm, mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdVovPedidoHolder TMov, mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder TTxtHead, mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder TTxtOper, javax.xml.rpc.holders.StringHolder PDocfi, javax.xml.rpc.holders.StringHolder PFactura, javax.xml.rpc.holders.StringHolder PMensaje, javax.xml.rpc.holders.StringHolder PPedido, javax.xml.rpc.holders.StringHolder PResultado) throws java.rmi.RemoteException{
    if (zVTASLOGISTICA == null)
      _initZVTASLOGISTICAProxy();
    zVTASLOGISTICA.zsdVentasLogistica(PBstkd, PCorreo, PDocumento, PKunnr, PNumdocLog, PProceso, PSpart, PTipo, PZterm, TMov, TTxtHead, TTxtOper, PDocfi, PFactura, PMensaje, PPedido, PResultado);
  }
  
  
}