/**
 * ZwsvtaslogisticaLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mc_style.functions.soap.sap.document.sap_com;

public class ZwsvtaslogisticaLocator extends org.apache.axis.client.Service implements mc_style.functions.soap.sap.document.sap_com.Zwsvtaslogistica {

    public ZwsvtaslogisticaLocator() {
    }


    public ZwsvtaslogisticaLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ZwsvtaslogisticaLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for zwsvtaslogistica
    private java.lang.String zwsvtaslogistica_address = "http://SAPQAS.tracusa.com.mx:8010/sap/bc/srt/rfc/sap/zvtaslogistica/300/zwsvtaslogistica/zwsvtaslogistica";

    public java.lang.String getzwsvtaslogisticaAddress() {
        return zwsvtaslogistica_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String zwsvtaslogisticaWSDDServiceName = "zwsvtaslogistica";

    public java.lang.String getzwsvtaslogisticaWSDDServiceName() {
        return zwsvtaslogisticaWSDDServiceName;
    }

    public void setzwsvtaslogisticaWSDDServiceName(java.lang.String name) {
        zwsvtaslogisticaWSDDServiceName = name;
    }

    public mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA getzwsvtaslogistica() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(zwsvtaslogistica_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getzwsvtaslogistica(endpoint);
    }

    public mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA getzwsvtaslogistica(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mc_style.functions.soap.sap.document.sap_com.ZwsvtaslogisticaStub _stub = new mc_style.functions.soap.sap.document.sap_com.ZwsvtaslogisticaStub(portAddress, this);
            _stub.setPortName(getzwsvtaslogisticaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setzwsvtaslogisticaEndpointAddress(java.lang.String address) {
        zwsvtaslogistica_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA.class.isAssignableFrom(serviceEndpointInterface)) {
                mc_style.functions.soap.sap.document.sap_com.ZwsvtaslogisticaStub _stub = new mc_style.functions.soap.sap.document.sap_com.ZwsvtaslogisticaStub(new java.net.URL(zwsvtaslogistica_address), this);
                _stub.setPortName(getzwsvtaslogisticaWSDDServiceName());
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
        if ("zwsvtaslogistica".equals(inputPortName)) {
            return getzwsvtaslogistica();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "zwsvtaslogistica");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "zwsvtaslogistica"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("zwsvtaslogistica".equals(portName)) {
            setzwsvtaslogisticaEndpointAddress(address);
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
