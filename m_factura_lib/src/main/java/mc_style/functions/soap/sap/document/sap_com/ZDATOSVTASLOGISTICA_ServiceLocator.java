/**
 * ZDATOSVTASLOGISTICA_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mc_style.functions.soap.sap.document.sap_com;

public class ZDATOSVTASLOGISTICA_ServiceLocator extends org.apache.axis.client.Service implements mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_Service {

    public ZDATOSVTASLOGISTICA_ServiceLocator() {
    }


    public ZDATOSVTASLOGISTICA_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ZDATOSVTASLOGISTICA_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ZDATOSVTASLOGISTICA
    private java.lang.String ZDATOSVTASLOGISTICA_address = "http://SAPQAS.tracusa.com.mx:8010/sap/bc/srt/rfc/sap/zdatosvtaslogistica/300/zdatosvtaslogistica/zdatosvtaslogistica";

    public java.lang.String getZDATOSVTASLOGISTICAAddress() {
        return ZDATOSVTASLOGISTICA_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ZDATOSVTASLOGISTICAWSDDServiceName = "ZDATOSVTASLOGISTICA";

    public java.lang.String getZDATOSVTASLOGISTICAWSDDServiceName() {
        return ZDATOSVTASLOGISTICAWSDDServiceName;
    }

    public void setZDATOSVTASLOGISTICAWSDDServiceName(java.lang.String name) {
        ZDATOSVTASLOGISTICAWSDDServiceName = name;
    }

    public mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_PortType getZDATOSVTASLOGISTICA() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ZDATOSVTASLOGISTICA_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getZDATOSVTASLOGISTICA(endpoint);
    }

    public mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_PortType getZDATOSVTASLOGISTICA(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_BindingStub _stub = new mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_BindingStub(portAddress, this);
            _stub.setPortName(getZDATOSVTASLOGISTICAWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setZDATOSVTASLOGISTICAEndpointAddress(java.lang.String address) {
        ZDATOSVTASLOGISTICA_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_BindingStub _stub = new mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_BindingStub(new java.net.URL(ZDATOSVTASLOGISTICA_address), this);
                _stub.setPortName(getZDATOSVTASLOGISTICAWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ZDATOSVTASLOGISTICA".equals(inputPortName)) {
            return getZDATOSVTASLOGISTICA();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZDATOSVTASLOGISTICA");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZDATOSVTASLOGISTICA"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ZDATOSVTASLOGISTICA".equals(portName)) {
            setZDATOSVTASLOGISTICAEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
