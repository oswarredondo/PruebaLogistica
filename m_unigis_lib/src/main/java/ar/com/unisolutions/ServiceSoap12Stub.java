/**
 * ServiceSoap12Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ServiceSoap12Stub extends org.apache.axis.client.Stub implements ar.com.unisolutions.ServiceSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();
    private String xmlRequest;
    
    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[108];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
        _initOperationDesc7();
        _initOperationDesc8();
        _initOperationDesc9();
        _initOperationDesc10();
        _initOperationDesc11();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerIdsGuiasLiquidacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaDesde"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHasta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Vehiculo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"), ar.com.unisolutions.PVehiculo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte"), ar.com.unisolutions.PTransporte.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"), ar.com.unisolutions.PConductor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoGuias"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoGuia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoOperacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfInt"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerIdsGuiasLiquidacionResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerGuiasLiquidacionPorId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdsGuias"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfInt"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "int"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPGuiaLiquidacion"));
        oper.setReturnClass(ar.com.unisolutions.PGuiaLiquidacion[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacionPorIdResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerGuiasLiquidacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaDesde"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHasta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Vehiculo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"), ar.com.unisolutions.PVehiculo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte"), ar.com.unisolutions.PTransporte.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"), ar.com.unisolutions.PConductor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoGuias"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoGuia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoOperacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPGuiaLiquidacion"));
        oper.setReturnClass(ar.com.unisolutions.PGuiaLiquidacion[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacionResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerGuiasLiquidacion2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacionRequest"), ar.com.unisolutions.ObtenerGuiasLiquidacionRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPGuiaLiquidacion"));
        oper.setReturnClass(ar.com.unisolutions.PGuiaLiquidacion[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacion2Result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerGuiasLiquidacionAvanzado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaDesde"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHasta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Vehiculo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"), ar.com.unisolutions.PVehiculo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte"), ar.com.unisolutions.PTransporte.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"), ar.com.unisolutions.PConductor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoGuia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Viaje_ReferenciaExterna"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPGuiaLiquidacion"));
        oper.setReturnClass(ar.com.unisolutions.PGuiaLiquidacion[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacionAvanzadoResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarEstadoGuia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "estado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoGuia"), ar.com.unisolutions.PEstadoGuia.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoGuiaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarEstadoLiquidacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "estado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoLiquidacion"), ar.com.unisolutions.PEstadoLiquidacion.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoLiquidacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearGuiasLiquidacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Guias"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPGuiaLiquidacion"), ar.com.unisolutions.PGuiaLiquidacion[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearGuiasLiquidacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AgregarParadaViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "idViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada"), ar.com.unisolutions.PParada[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfAgregarParadaViajeResponse"));
        oper.setReturnClass(ar.com.unisolutions.AgregarParadaViajeResponse[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaViajeResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaViajeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearDocumentos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Documentos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPDocumento"), ar.com.unisolutions.PDocumento[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDocumento"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearDocumentosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EliminarDocumento");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarDocumentoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarTarifas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Tarifas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPTarifa"), ar.com.unisolutions.PTarifa[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTarifa"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarTarifasResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearRecursos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "recursos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRecurso"), ar.com.unisolutions.PRecurso[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecurso"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearRecursosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EliminaRecurso");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "referenciaRecurso"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminaRecursoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarRecursos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "consultarRecursos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarRecursosRequest"), ar.com.unisolutions.ConsultarRecursosRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRecursoExtended"));
        oper.setReturnClass(ar.com.unisolutions.PRecursoExtended[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarRecursosResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoExtended"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearEmpresasCustodia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "empresas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEmpresaCustodia"), ar.com.unisolutions.PEmpresaCustodia[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresaCustodia"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearEmpresasCustodiaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearCustodios");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "custodios"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPCustodio"), ar.com.unisolutions.PCustodio[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCustodio"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearCustodiosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearConductores");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "conductores"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPConductor"), ar.com.unisolutions.PConductor[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearConductoresResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearTransportes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "transportes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPTransporte"), ar.com.unisolutions.PTransporte[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearTransportesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearClientesDadores");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "clientes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPClienteDador"), ar.com.unisolutions.PClienteDador[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearClientesDadoresResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearPropietarios");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "propietarios"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPPropietario"), ar.com.unisolutions.PPropietario[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPropietario"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearPropietariosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CambiarEstado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "entidad"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "referenciaExterna"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "idEntidad"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "idEstado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "BooleanResponse"));
        oper.setReturnClass(ar.com.unisolutions.BooleanResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CambiarEstadoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearCodigosControl");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPCodigoControl"), ar.com.unisolutions.PCodigoControl[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCodigoControl"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearCodigosControlResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearRuta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ruta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"), ar.com.unisolutions.PRuta.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearRutaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateDeposits");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "deposits"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPDeposito"), ar.com.unisolutions.PDeposito[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CreateDepositsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarRuta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ruta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"), ar.com.unisolutions.PRuta.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarRutaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EliminarDomiciliosOrden");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "datos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPCliente"), ar.com.unisolutions.PCliente[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarDomiciliosOrdenResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarViajesPorDomicilioOrden");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "consulta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeRequest"), ar.com.unisolutions.ConsultarViajeRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPViaje"));
        oper.setReturnClass(ar.com.unisolutions.PViaje[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajesPorDomicilioOrdenResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarParadas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apikey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada"), ar.com.unisolutions.PParada[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarParadasResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarEtiquetas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apikey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEtiquetasRequest"), ar.com.unisolutions.ConsultarEtiquetasRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEtiquetasResponse"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarEtiquetasResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEtiquetasResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarEmpresaOperacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEmpresaOperacionRequest"), ar.com.unisolutions.ConsultarEmpresaOperacionRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresa"));
        oper.setReturnClass(ar.com.unisolutions.PEmpresa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEmpresaOperacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarRemito");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apikey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "clienteDador"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador"), ar.com.unisolutions.PClienteDador.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "remito"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRemito"), ar.com.unisolutions.PRemito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarRemitoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarEstadosParadasViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apikey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosViaje"));
        oper.setReturnClass(ar.com.unisolutions.PEstadosViaje.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEstadosParadasViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CambiarEstadoRecurso");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apikey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "entidad"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "referenciaExterna"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "idEntidad"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "estado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "motivo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "validarTransicion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "mismoEstado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "observaciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "BooleanResponse"));
        oper.setReturnClass(ar.com.unisolutions.BooleanResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CambiarEstadoRecursoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarEstadoViajeArchivos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cambio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoViaje"), ar.com.unisolutions.PEstadoViaje.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoViajeArchivosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarEstadoViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValidarTransicion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarEstadoRuta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdRuta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValidarTransicion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoRutaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerViajes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoOperacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPViaje"));
        oper.setReturnClass(ar.com.unisolutions.PViaje[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerViajesResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("testTimeZone");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "dt"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        oper.setReturnClass(java.util.Calendar.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "testTimeZoneResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerEstadias");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "desde"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "hasta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TimeZone"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEstadiaParada"));
        oper.setReturnClass(ar.com.unisolutions.PEstadiaParada[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerEstadiasResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParada"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AgregarEncuestas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Encuestas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEncuesta"), ar.com.unisolutions.PEncuesta[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEncuesta"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "BooleanResponse"));
        oper.setReturnClass(ar.com.unisolutions.BooleanResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarEncuestasResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearBeneficiariosTransporte");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "beneficiarios"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPBeneficiario"), ar.com.unisolutions.PBeneficiario[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pBeneficiario"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearBeneficiariosTransporteResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ApiKeyValida");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "s"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKeyValidaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DummyCrearViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DummyCrearViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "transporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"), ar.com.unisolutions.Transporte.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"), ar.com.unisolutions.PCliente.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoSalida"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoLlegada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "conductor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"), ar.com.unisolutions.PConductor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada"), ar.com.unisolutions.PParada[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearViaje2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "transporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"), ar.com.unisolutions.Transporte.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"), ar.com.unisolutions.PCliente.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoSalida"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoLlegada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "conductor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"), ar.com.unisolutions.PConductor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "prestador"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada"), ar.com.unisolutions.PParada[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearViaje3");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Empresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "transporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"), ar.com.unisolutions.Transporte.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"), ar.com.unisolutions.PCliente.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoSalida"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoLlegada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "conductor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"), ar.com.unisolutions.PConductor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "prestador"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada"), ar.com.unisolutions.PParada[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje3Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearViaje4");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Empresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "transporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"), ar.com.unisolutions.Transporte.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"), ar.com.unisolutions.PCliente.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoSalida"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoLlegada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "conductor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"), ar.com.unisolutions.PConductor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "prestador"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada"), ar.com.unisolutions.PParada[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeResultado"));
        oper.setReturnClass(ar.com.unisolutions.CrearViajeResultado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje4Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearViaje5");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Empresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoOperacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "transporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"), ar.com.unisolutions.Transporte.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"), ar.com.unisolutions.PCliente.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoSalida"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoLlegada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "conductor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"), ar.com.unisolutions.PConductor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada"), ar.com.unisolutions.PParada[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeResultado"));
        oper.setReturnClass(ar.com.unisolutions.CrearViajeResultado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje5Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearViaje6");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Empresa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Recorrido"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "transporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"), ar.com.unisolutions.Transporte.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"), ar.com.unisolutions.PCliente.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoSalida"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoLlegada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"), ar.com.unisolutions.PDeposito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "conductor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"), ar.com.unisolutions.PConductor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "prestador"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada"), ar.com.unisolutions.PParada[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeResultado"));
        oper.setReturnClass(ar.com.unisolutions.CrearViajeResultado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje6Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearViajeCompleto");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "crearviaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeSolicitud"), ar.com.unisolutions.CrearViajeSolicitud.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeResultado"));
        oper.setReturnClass(ar.com.unisolutions.CrearViajeResultado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeCompletoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ReordenarViajeTransito");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "OptSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AnularViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AnularViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FinalizarViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinalizarViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ActivarViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ActivarViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RelacionarViajes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoRelacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "desde"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "hasta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RelacionarViajesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarEstadoOrdenEntrega");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "estado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoOrdenEntrega"), ar.com.unisolutions.PEstadoOrdenEntrega.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoOrdenEntregaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarEstadoOrdenPedido");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "estado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoOrdenPedido"), ar.com.unisolutions.PEstadoOrdenPedido.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoOrdenPedidoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarOrdenPedido");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido"));
        oper.setReturnClass(ar.com.unisolutions.POrdenPedido.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenPedidoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarOrdenPedidoId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdPedido"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido"));
        oper.setReturnClass(ar.com.unisolutions.POrdenPedido.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenPedidoIdResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[59] = oper;

    }

    private static void _initOperationDesc7(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarOrdenesPedido");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenesPedidoRequest"), ar.com.unisolutions.ConsultarOrdenesPedidoRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenPedido"));
        oper.setReturnClass(ar.com.unisolutions.POrdenPedido[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenesPedidoResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarOrdenEntrega");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumento"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoOperacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
        oper.setReturnClass(ar.com.unisolutions.POrdenEntrega.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenEntregaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[61] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarEstadoParada");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "estado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoParada"), ar.com.unisolutions.PEstadoParada.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoParadaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[62] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarParadaItem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Item"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem"), ar.com.unisolutions.PParadaItem.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarParadaItemResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[63] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AgregarParadaItem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Items"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfParadaItem"), ar.com.unisolutions.ParadaItem[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ParadaItem"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaItemResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[64] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarParadaItemDesdeViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Item"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem"), ar.com.unisolutions.PParadaItem.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarParadaItemDesdeViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[65] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EliminarParadaItemDesdeViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaItem"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarParadaItemDesdeViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[66] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EliminarParadaItem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaItem"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarParadaItemResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[67] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarParadaPorId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultado"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarParadaResultado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaPorIdResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[68] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarParadaTraceEstado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumento"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoFecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IgnorarEstadoParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaEstadosResultado"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarParadaEstadosResultado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaTraceEstadoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[69] = oper;

    }

    private static void _initOperationDesc8(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarParada");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Secuencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumento"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumentoAdicional"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefCliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultado"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarParadaResultado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[70] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarTransicionesEstadoViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoFecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarViajeResultadoBasic"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarViajeResultadoBasic[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarTransicionesEstadoViajeResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultadoBasic"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[71] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarViajesPorTransicion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaDesde"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHasta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarViajeResponse"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarViajeResponse[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajesPorTransicionResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[72] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarViajeResultado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[73] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarViajePorFechas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaJornadaDesde"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaJornadaHasta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pagina"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarParadas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarItems"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarIncidencias"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarRecursos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarEstadoParada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarUltimaParadaVisitada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarTransporte"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarViajeResultado"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarViajeResultado[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajePorFechasResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[74] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarViajeReferenciaExterna");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarViajeResultado"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarViajeResultado[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeReferenciaExternaResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[75] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarViajeReferenciaExternaFechaJornada");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarViajeResultado"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarViajeResultado[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeReferenciaExternaFechaJornadaResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[76] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "viaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"), ar.com.unisolutions.PViaje.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cambioMismoEstado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "validarTransicion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[77] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModificarViajeConParadas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "viaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"), ar.com.unisolutions.PViaje.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarViajeConParadasResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[78] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CambiarVehiculoViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CambiarVehiculoViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[79] = oper;

    }

    private static void _initOperationDesc9(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarRecursoVehiculo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaRecurso"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoRecurso"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCreacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaEstadoRecurso"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaModificacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRecursoVehiculo"));
        oper.setReturnClass(ar.com.unisolutions.PRecursoVehiculo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarRecursoVehiculoResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoVehiculo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[80] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarVehiculo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarVehiculoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[81] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarMapaVehiculoBatch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DevolverMapa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DevolverGeoReversa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DevolverTimeZone"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarMapaVehiculoResultado"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarMapaVehiculoResultado[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoBatchResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResultado"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[82] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarMapaVehiculo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DevolverMapa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DevolverGeoReversa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DevolverTimeZone"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResultado"));
        oper.setReturnClass(ar.com.unisolutions.ConsultarMapaVehiculoResultado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[83] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CalcularViaje");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "MantenerSecuencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CalcularViajeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[84] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TestDBConnection");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TestDBConnectionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[85] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerRuta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdJornada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdRuta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenEntrega"));
        oper.setReturnClass(ar.com.unisolutions.POrdenEntrega[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutaResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[86] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearClientesOrden");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "clientes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPCliente"), ar.com.unisolutions.PCliente[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoOperacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearClientesOrdenResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[87] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearOrdenesPedido");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pedidos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenPedido"), ar.com.unisolutions.POrdenPedido[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearOrdenesPedidoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[88] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearProductos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "productos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPProducto"), ar.com.unisolutions.PProducto[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pProducto"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearProductosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[89] = oper;

    }

    private static void _initOperationDesc10(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EliminarOrdenesPedido");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pedidos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenPedido"), ar.com.unisolutions.POrdenPedido[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarOrdenesPedidoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[90] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearRemito");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Remito"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRemito"), ar.com.unisolutions.PRemito.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearRemitoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[91] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearOrdenesEntrega");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "entregas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenEntrega"), ar.com.unisolutions.POrdenEntrega[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearOrdenesEntregaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[92] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EliminarOrdenesEntrega");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "entregas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenEntrega"), ar.com.unisolutions.POrdenEntrega[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarOrdenesEntregaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[93] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearVehiculos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "vehiculos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPVehiculo"), ar.com.unisolutions.PVehiculo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearVehiculosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[94] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CrearVehiculos_ValidarExistencia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "vehiculos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPVehiculo"), ar.com.unisolutions.PVehiculo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearVehiculos_ValidarExistenciaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[95] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AsignarVehiculo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "vehiculo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigosSucursalOperacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfCodigoSucursalOperacionRequest"), ar.com.unisolutions.CodigoSucursalOperacionRequest[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigoSucursalOperacionRequest"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "borrarAsignaciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AsignarVehiculoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[96] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AsignarVehiculos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "vehiculos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "string"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoOperacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "borrarAsignaciones"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AsignarVehiculosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[97] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ActivarVehiculos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "vehiculos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPVehiculo"), ar.com.unisolutions.PVehiculo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ActivarVehiculosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[98] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerRutaCompleta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdJornada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdRuta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"));
        oper.setReturnClass(ar.com.unisolutions.PRuta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutaCompletaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[99] = oper;

    }

    private static void _initOperationDesc11(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerRutas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRuta"));
        oper.setReturnClass(ar.com.unisolutions.PRuta[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutasResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[100] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerRutasRequest");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pObtenerRutasRequest"), ar.com.unisolutions.PObtenerRutasRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRuta"));
        oper.setReturnClass(ar.com.unisolutions.PRuta[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutasRequestResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[101] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerRutas_Ruta0");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRuta"));
        oper.setReturnClass(ar.com.unisolutions.PRuta[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutas_Ruta0Result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[102] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerRutas_Ruta0Request");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pObtenerRutasRequest"), ar.com.unisolutions.PObtenerRutasRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRuta"));
        oper.setReturnClass(ar.com.unisolutions.PRuta[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutas_Ruta0RequestResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[103] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerParadas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoViaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada"));
        oper.setReturnClass(ar.com.unisolutions.PParada[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerParadasResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[104] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerIncidencia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdIncidencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pIncidencia"));
        oper.setReturnClass(ar.com.unisolutions.PIncidencia.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerIncidenciaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[105] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerLiquidacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdLiquidacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaLiquidacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pLiquidacion"));
        oper.setReturnClass(ar.com.unisolutions.PLiquidacion.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerLiquidacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[106] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerLiquidaciones");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPLiquidacion"));
        oper.setReturnClass(ar.com.unisolutions.PLiquidacion[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerLiquidacionesResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pLiquidacion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[107] = oper;

    }

    public ServiceSoap12Stub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ServiceSoap12Stub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ServiceSoap12Stub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
        addBindings2();
        addBindings3();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ActivarVehiculos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ActivarVehiculos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ActivarVehiculosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ActivarVehiculosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ActivarViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ActivarViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ActivarViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ActivarViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AgregarEncuestas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AgregarEncuestas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AgregarEncuestasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AgregarEncuestasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AgregarParadaItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AgregarParadaItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AgregarParadaItemResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AgregarParadaItemResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AgregarParadaViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AgregarParadaViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AgregarParadaViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AgregarParadaViajeResponseType0.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AnularViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AnularViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AnularViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AnularViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ApiKeyValida");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ApiKeyValida.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ApiKeyValidaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ApiKeyValidaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AsignarVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AsignarVehiculo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AsignarVehiculoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AsignarVehiculoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AsignarVehiculos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AsignarVehiculos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AsignarVehiculosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AsignarVehiculosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CalcularViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CalcularViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CalcularViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CalcularViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CambiarEstado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CambiarEstado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CambiarEstadoRecurso");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CambiarEstadoRecurso.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CambiarEstadoRecursoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CambiarEstadoRecursoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CambiarEstadoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CambiarEstadoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CambiarVehiculoViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CambiarVehiculoViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CambiarVehiculoViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CambiarVehiculoViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarEmpresaOperacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarEmpresaOperacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarEmpresaOperacionResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarEmpresaOperacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarEstadosParadasViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarEstadosParadasViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarEstadosParadasViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarEstadosParadasViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarEtiquetas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarEtiquetas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarEtiquetasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarEtiquetasResponseType1.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarMapaVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarMapaVehiculo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarMapaVehiculoBatch");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarMapaVehiculoBatch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarMapaVehiculoBatchResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarMapaVehiculoBatchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarMapaVehiculoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarMapaVehiculoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenEntrega");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarOrdenEntrega.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenEntregaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarOrdenEntregaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenesPedido");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarOrdenesPedido.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenesPedidoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarOrdenesPedidoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenPedido");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarOrdenPedido.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenPedidoId");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarOrdenPedidoId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenPedidoIdResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarOrdenPedidoIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenPedidoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarOrdenPedidoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParada.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarParadaPorId");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParadaPorId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarParadaPorIdResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParadaPorIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarParadaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParadaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarParadaTraceEstado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParadaTraceEstado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarParadaTraceEstadoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParadaTraceEstadoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarRecursos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarRecursos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarRecursosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarRecursosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarRecursoVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarRecursoVehiculo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarRecursoVehiculoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarRecursoVehiculoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarTransicionesEstadoViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarTransicionesEstadoViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarTransicionesEstadoViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarTransicionesEstadoViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarVehiculo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarVehiculoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarVehiculoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajePorFechas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajePorFechas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajePorFechasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajePorFechasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajeReferenciaExterna");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeReferenciaExterna.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajeReferenciaExternaFechaJornada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeReferenciaExternaFechaJornada.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajeReferenciaExternaFechaJornadaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeReferenciaExternaFechaJornadaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajeReferenciaExternaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeReferenciaExternaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeResponseType2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajesPorDomicilioOrden");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajesPorDomicilioOrden.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajesPorDomicilioOrdenResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajesPorDomicilioOrdenResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajesPorTransicion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajesPorTransicion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajesPorTransicionResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajesPorTransicionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearBeneficiariosTransporte");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearBeneficiariosTransporte.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearBeneficiariosTransporteResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearBeneficiariosTransporteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearClientesDadores");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearClientesDadores.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearClientesDadoresResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearClientesDadoresResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearClientesOrden");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearClientesOrden.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearClientesOrdenResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearClientesOrdenResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearCodigosControl");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearCodigosControl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearCodigosControlResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearCodigosControlResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearConductores");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearConductores.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearConductoresResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearConductoresResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearCustodios");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearCustodios.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearCustodiosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearCustodiosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearDocumentos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearDocumentos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearDocumentosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearDocumentosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearEmpresasCustodia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearEmpresasCustodia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearEmpresasCustodiaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearEmpresasCustodiaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearGuiasLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearGuiasLiquidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearGuiasLiquidacionResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearGuiasLiquidacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearOrdenesEntrega");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearOrdenesEntrega.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearOrdenesEntregaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearOrdenesEntregaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearOrdenesPedido");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearOrdenesPedido.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearOrdenesPedidoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearOrdenesPedidoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearProductos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearProductos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearProductosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearProductosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearPropietarios");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearPropietarios.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearPropietariosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearPropietariosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearRecursos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearRecursos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearRecursosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearRecursosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearRemito");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearRemito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearRemitoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearRemitoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearRuta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearRuta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearRutaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearRutaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearTransportes");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearTransportes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearTransportesResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearTransportesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearVehiculos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearVehiculos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearVehiculos_ValidarExistencia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearVehiculos_ValidarExistencia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearVehiculos_ValidarExistenciaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearVehiculos_ValidarExistenciaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearVehiculosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearVehiculosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje2");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje2Response");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje3");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje3.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje3Response");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje3Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje4");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje4.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje4Response");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje4Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje5");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje5.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje5Response");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje5Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje6");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje6.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje6Response");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViaje6Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViajeCompleto");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViajeCompleto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViajeCompletoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViajeCompletoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CreateDeposits");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CreateDeposits.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CreateDepositsResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CreateDepositsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">DummyCrearViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.DummyCrearViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">DummyCrearViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.DummyCrearViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarDocumento");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarDocumento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarDocumentoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarDocumentoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarDomiciliosOrden");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarDomiciliosOrden.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarDomiciliosOrdenResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarDomiciliosOrdenResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminaRecurso");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminaRecurso.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminaRecursoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminaRecursoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarOrdenesEntrega");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarOrdenesEntrega.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarOrdenesEntregaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarOrdenesEntregaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarOrdenesPedido");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarOrdenesPedido.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarOrdenesPedidoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarOrdenesPedidoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarParadaItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarParadaItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarParadaItemDesdeViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarParadaItemDesdeViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarParadaItemDesdeViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarParadaItemDesdeViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarParadaItemResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EliminarParadaItemResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">FinalizarViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.FinalizarViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">FinalizarViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.FinalizarViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoGuia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoGuia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoGuiaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoGuiaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoLiquidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoLiquidacionResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoLiquidacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoOrdenEntrega");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoOrdenEntrega.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoOrdenEntregaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoOrdenEntregaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoOrdenPedido");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoOrdenPedido.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoOrdenPedidoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoOrdenPedidoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoParada.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoParadaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoParadaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoRuta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoRuta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoRutaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoRutaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoViajeArchivos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoViajeArchivos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoViajeArchivosResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoViajeArchivosResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarEstadoViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarParadaItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarParadaItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarParadaItemDesdeViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarParadaItemDesdeViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarParadaItemDesdeViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarParadaItemDesdeViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarParadaItemResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarParadaItemResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarParadas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarParadas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarParadasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarParadasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarRemito");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarRemito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarRemitoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarRemitoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarRuta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarRuta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarRutaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarRutaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarTarifas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarTarifas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarTarifasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarTarifasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarViajeConParadas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarViajeConParadas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarViajeConParadasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarViajeConParadasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ModificarViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerEstadias");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerEstadias.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerEstadiasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerEstadiasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerGuiasLiquidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacion2");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerGuiasLiquidacion2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacion2Response");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerGuiasLiquidacion2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacionAvanzado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerGuiasLiquidacionAvanzado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacionAvanzadoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerGuiasLiquidacionAvanzadoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacionPorId");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerGuiasLiquidacionPorId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacionPorIdResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerGuiasLiquidacionPorIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacionResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerGuiasLiquidacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerIdsGuiasLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerIdsGuiasLiquidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerIdsGuiasLiquidacionResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerIdsGuiasLiquidacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerIncidencia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerIncidencia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerIncidenciaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerIncidenciaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerLiquidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerLiquidaciones");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerLiquidaciones.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerLiquidacionesResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerLiquidacionesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerLiquidacionResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerLiquidacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerParadas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerParadas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerParadasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerParadasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRuta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRuta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutaCompleta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutaCompleta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutaCompletaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutaCompletaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutaResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutas_Ruta0");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutas_Ruta0.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings2() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutas_Ruta0Request");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutas_Ruta0Request.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutas_Ruta0RequestResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutas_Ruta0RequestResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutas_Ruta0Response");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutas_Ruta0Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutasRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutasRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutasRequestResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutasRequestResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerRutasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerViajes");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerViajes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerViajesResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerViajesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">RelacionarViajes");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.RelacionarViajes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">RelacionarViajesResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.RelacionarViajesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ReordenarViajeTransito");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ReordenarViajeTransito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ReordenarViajeTransitoResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ReordenarViajeTransitoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">TestDBConnection");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.TestDBConnection.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">TestDBConnectionResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.TestDBConnectionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">testTimeZone");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.TestTimeZone.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">testTimeZoneResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.TestTimeZoneResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AbstractEntitie");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AbstractEntitie.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AbstractEntitieCacheable");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AbstractEntitieCacheable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AbstractEntitieDynamicFields");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AbstractEntitieDynamicFields.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AgregarParadaViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfAgregarParadaViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.AgregarParadaViajeResponse[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaViajeResponse");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaViajeResponse");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfCampoValor");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CampoValor[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfCodigoSucursalOperacionRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CodigoSucursalOperacionRequest[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigoSucursalOperacionRequest");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigoSucursalOperacionRequest");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarMapaVehiculoResultado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarMapaVehiculoResultado[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResultado");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResultado");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarParadaResultadoItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParadaResultadoItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultadoItem");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultadoItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeResponse[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResponse");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResponse");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarViajeResultado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeResultado[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfConsultarViajeResultadoBasic");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeResultadoBasic[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultadoBasic");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultadoBasic");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfDynamicField");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.DynamicField[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DynamicField");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DynamicField");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfEntityKeyMember");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EntityKeyMember[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityKeyMember");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityKeyMember");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfInt");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "int");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfLogEntidad");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.LogEntidad[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LogEntidad");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LogEntidad");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPAjuste");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PAjuste[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pAjuste");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pAjuste");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfParadaItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ParadaItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ParadaItem");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ParadaItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPArchivo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PArchivo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivo");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPArchivoDoc");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PArchivoDoc[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivoDoc");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivoDoc");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPArchivos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PArchivos[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivos");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivos");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPArchivosParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PArchivosParada[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivosParada");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivosParada");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPBeneficiario");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PBeneficiario[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pBeneficiario");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pBeneficiario");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPCliente");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PCliente[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPClienteDador");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PClienteDador[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPCodigoControl");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PCodigoControl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCodigoControl");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCodigoControl");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPConceptoDinamico");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PConceptoDinamico[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoDinamico");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoDinamico");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPConceptoExterno");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PConceptoExterno[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoExterno");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoExterno");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPConductor");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PConductor[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPConductorTransporte");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PConductorTransporte[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductorTransporte");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductorTransporte");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPCustodio");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PCustodio[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCustodio");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCustodio");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPDeposito");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PDeposito[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPDocumento");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PDocumento[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDocumento");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDocumento");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEmpresaCustodia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEmpresaCustodia[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresaCustodia");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresaCustodia");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEncuesta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEncuesta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEncuesta");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEncuesta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEstadia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadia[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadia");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadia");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEstadiaParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadiaParada[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParada");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParada");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEstadiaParadaVisita");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadiaParadaVisita[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParadaVisita");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParadaVisita");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEstadoParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadoParada[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoParada");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoParada");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEstados");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstados[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstados");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstados");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEstadosParadas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadosParadas[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosParadas");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosParadas");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPEtiqueta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEtiqueta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEtiqueta");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEtiqueta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPFoto");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PFoto[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pFoto");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pFoto");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPGuiaLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PGuiaLiquidacion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPImputacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PImputacion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pImputacion");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pImputacion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPIncidencia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PIncidencia[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pIncidencia");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pIncidencia");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PLiquidacion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pLiquidacion");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pLiquidacion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOperacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POperacion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOperacion");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOperacion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenEntrega");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenEntrega[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenEntregaItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenEntregaItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaItem");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenPedido");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenPedido[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenPedidoItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenPedidoItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoItem");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPOrdenPedidoTipoVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenPedidoTipoVehiculo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoTipoVehiculo");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoTipoVehiculo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PParada[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParadaEtiqueta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PParadaEtiqueta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaEtiqueta");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaEtiqueta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPParadaItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PParadaItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPPregunta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PPregunta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPregunta");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPregunta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPProducto");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PProducto[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pProducto");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pProducto");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPPropietario");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PPropietario[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPropietario");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPropietario");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRecurso");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRecurso[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecurso");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecurso");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRecursoExtended");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRecursoExtended[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoExtended");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoExtended");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRecursos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRecursos[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRecursoVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRecursoVehiculo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoVehiculo");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoVehiculo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPRuta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRuta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPServicio");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PServicio[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicio");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicio");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPServicioAdicional");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PServicioAdicional[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicioAdicional");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicioAdicional");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPTarifa");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PTarifa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTarifa");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTarifa");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPTransporte");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PTransporte[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PVehiculo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PViaje[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfPViajeTraceEstado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PViajeTraceEstado[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViajeTraceEstado");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViajeTraceEstado");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArrayOfUbicacionRecursoMovimientoDetalle");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.UbicacionRecursoMovimientoDetalle[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UbicacionRecursoMovimientoDetalle");
            qName2 = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UbicacionRecursoMovimientoDetalle");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "BooleanResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.BooleanResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CampoValor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigoSucursalOperacionRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CodigoSucursalOperacionRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEmpresaOperacionRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarEmpresaOperacionRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEtiquetasRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarEtiquetasRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEtiquetasResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarEtiquetasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResultado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarMapaVehiculoResultado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenesPedidoRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarOrdenesPedidoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaEstadosResultado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParadaEstadosResultado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParadaResultado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultadoItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarParadaResultadoItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings3() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarRecursosRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarRecursosRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeResultado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultadoBasic");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ConsultarViajeResultadoBasic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeResultado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViajeResultado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeSolicitud");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.CrearViajeSolicitud.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DynamicField");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.DynamicField.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityKey");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EntityKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityKeyMember");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EntityKeyMember.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityObject");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.EntityObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LogEntidad");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.LogEntidad.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Motivo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.Motivo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacionRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ObtenerGuiasLiquidacionRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pAjuste");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PAjuste.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ParadaItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.ParadaItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PArchivo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivoDoc");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PArchivoDoc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PArchivos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivosParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PArchivosParada.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pAsociarEntidad");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PAsociarEntidad.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pBeneficiario");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PBeneficiario.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PCliente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PClienteDador.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCodigoControl");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PCodigoControl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoDinamico");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PConceptoDinamico.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoExterno");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PConceptoExterno.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PConductor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductorTransporte");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PConductorTransporte.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCustodio");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PCustodio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PDeposito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDocumento");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PDocumento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDomicilio");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PDomicilio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresa");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEmpresa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresaCustodia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEmpresaCustodia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEncuesta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEncuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Persona");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.Persona.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadiaParada.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParadaVisita");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadiaParadaVisita.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoGuia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadoGuia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadoLiquidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoOrdenEntrega");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadoOrdenEntrega.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoOrdenPedido");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadoOrdenPedido.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadoParada.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstados");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstados.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosParadas");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadosParadas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadosViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEstadoViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEtiqueta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PEtiqueta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pFoto");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PFoto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PGuiaLiquidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pImputacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PImputacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pIncidencia");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PIncidencia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PLiquidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pObtenerRutasRequest");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PObtenerRutasRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOperacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POperacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrden");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrden.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenEntrega.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaConsultarViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenEntregaConsultarViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenEntregaItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenPedido.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenPedidoItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoTipoVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.POrdenPedidoTipoVehiculo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PParada.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaEtiqueta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PParadaEtiqueta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PParadaItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPedidoTurno");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PPedidoTurno.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPeriodoLiquidacion");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PPeriodoLiquidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPregunta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PPregunta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pProducto");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PProducto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPropietario");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PPropietario.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecurso");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRecurso.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoExtended");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRecursoExtended.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRecursos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRecursoVehiculo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRemito");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRemito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Producto");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.Producto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PRuta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicio");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PServicio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicioAdicional");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PServicioAdicional.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pSucursal");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PSucursal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTarifa");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PTarifa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTipoUnidadContenedora");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PTipoUnidadContenedora.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PTransporte.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pUnidadContenedora");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PUnidadContenedora.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PVehiculo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculoExtended");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PVehiculoExtended.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PViaje.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViajeTraceEstado");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.PViajeTraceEstado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "StructuralObject");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.StructuralObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.Transporte.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UbicacionRecursoMovimientoDetalle");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.UbicacionRecursoMovimientoDetalle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UbicacionResponse");
            cachedSerQNames.add(qName);
            cls = ar.com.unisolutions.UbicacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public int[] obtenerIdsGuiasLiquidacion(java.lang.String apiKey, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String codigoSucursal, ar.com.unisolutions.PVehiculo vehiculo, ar.com.unisolutions.PTransporte transporte, ar.com.unisolutions.PConductor conductor, java.lang.String estadoGuias, java.lang.String tipoGuia, java.lang.String codigoOperacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerIdsGuiasLiquidacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerIdsGuiasLiquidacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, fechaDesde, fechaHasta, codigoSucursal, vehiculo, transporte, conductor, estadoGuias, tipoGuia, codigoOperacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionPorId(java.lang.String apiKey, int[] idsGuias) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerGuiasLiquidacionPorId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacionPorId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, idsGuias});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PGuiaLiquidacion[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PGuiaLiquidacion[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PGuiaLiquidacion[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacion(java.lang.String apiKey, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String codigoSucursal, ar.com.unisolutions.PVehiculo vehiculo, ar.com.unisolutions.PTransporte transporte, ar.com.unisolutions.PConductor conductor, java.lang.String estadoGuias, java.lang.String tipoGuia, java.lang.String codigoOperacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerGuiasLiquidacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, fechaDesde, fechaHasta, codigoSucursal, vehiculo, transporte, conductor, estadoGuias, tipoGuia, codigoOperacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PGuiaLiquidacion[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PGuiaLiquidacion[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PGuiaLiquidacion[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacion2(ar.com.unisolutions.ObtenerGuiasLiquidacionRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerGuiasLiquidacion2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacion2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PGuiaLiquidacion[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PGuiaLiquidacion[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PGuiaLiquidacion[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionAvanzado(java.lang.String apiKey, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String codigoSucursal, ar.com.unisolutions.PVehiculo vehiculo, ar.com.unisolutions.PTransporte transporte, ar.com.unisolutions.PConductor conductor, java.lang.String tipoGuia, java.lang.String viaje_ReferenciaExterna, int idViaje) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerGuiasLiquidacionAvanzado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacionAvanzado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, fechaDesde, fechaHasta, codigoSucursal, vehiculo, transporte, conductor, tipoGuia, viaje_ReferenciaExterna, new java.lang.Integer(idViaje)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PGuiaLiquidacion[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PGuiaLiquidacion[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PGuiaLiquidacion[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarEstadoGuia(java.lang.String apiKey, ar.com.unisolutions.PEstadoGuia estado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarEstadoGuia");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoGuia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, estado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarEstadoLiquidacion(java.lang.String apiKey, ar.com.unisolutions.PEstadoLiquidacion estado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarEstadoLiquidacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoLiquidacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, estado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearGuiasLiquidacion(java.lang.String apiKey, ar.com.unisolutions.PGuiaLiquidacion[] guias) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearGuiasLiquidacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearGuiasLiquidacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, guias});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.AgregarParadaViajeResponse[] agregarParadaViaje(java.lang.String apiKey, int idViaje, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/AgregarParadaViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje), paradas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.AgregarParadaViajeResponse[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.AgregarParadaViajeResponse[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.AgregarParadaViajeResponse[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearDocumentos(java.lang.String apiKey, ar.com.unisolutions.PDocumento[] documentos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearDocumentos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearDocumentos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, documentos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int eliminarDocumento(java.lang.String apiKey, java.lang.String referencia) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/EliminarDocumento");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarDocumento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, referencia});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarTarifas(java.lang.String apiKey, ar.com.unisolutions.PTarifa[] tarifas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarTarifas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarTarifas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, tarifas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearRecursos(java.lang.String apiKey, ar.com.unisolutions.PRecurso[] recursos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearRecursos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearRecursos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, recursos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int eliminaRecurso(java.lang.String apiKey, java.lang.String referenciaRecurso) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/EliminaRecurso");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminaRecurso"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, referenciaRecurso});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PRecursoExtended[] consultarRecursos(java.lang.String apiKey, ar.com.unisolutions.ConsultarRecursosRequest consultarRecursos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarRecursos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarRecursos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, consultarRecursos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PRecursoExtended[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PRecursoExtended[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PRecursoExtended[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearEmpresasCustodia(java.lang.String apiKey, ar.com.unisolutions.PEmpresaCustodia[] empresas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearEmpresasCustodia");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearEmpresasCustodia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, empresas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearCustodios(java.lang.String apiKey, ar.com.unisolutions.PCustodio[] custodios) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearCustodios");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearCustodios"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, custodios});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearConductores(java.lang.String apiKey, ar.com.unisolutions.PConductor[] conductores) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearConductores");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearConductores"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, conductores});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearTransportes(java.lang.String apiKey, ar.com.unisolutions.PTransporte[] transportes) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearTransportes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearTransportes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, transportes});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearClientesDadores(java.lang.String apiKey, ar.com.unisolutions.PClienteDador[] clientes) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearClientesDadores");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearClientesDadores"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, clientes});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearPropietarios(java.lang.String apiKey, ar.com.unisolutions.PPropietario[] propietarios) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearPropietarios");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearPropietarios"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, propietarios});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.BooleanResponse cambiarEstado(java.lang.String entidad, java.lang.String referenciaExterna, int idEntidad, int idEstado, java.lang.String apiKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CambiarEstado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CambiarEstado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entidad, referenciaExterna, new java.lang.Integer(idEntidad), new java.lang.Integer(idEstado), apiKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.BooleanResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.BooleanResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.BooleanResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearCodigosControl(java.lang.String apiKey, ar.com.unisolutions.PCodigoControl[] codigos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearCodigosControl");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearCodigosControl"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, codigos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearRuta(java.lang.String apiKey, ar.com.unisolutions.PRuta ruta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearRuta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearRuta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, ruta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int createDeposits(java.lang.String apiKey, ar.com.unisolutions.PDeposito[] deposits) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CreateDeposits");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CreateDeposits"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, deposits});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarRuta(java.lang.String apiKey, ar.com.unisolutions.PRuta ruta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarRuta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarRuta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, ruta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int eliminarDomiciliosOrden(java.lang.String apiKey, ar.com.unisolutions.PCliente[] datos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/EliminarDomiciliosOrden");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarDomiciliosOrden"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, datos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PViaje[] consultarViajesPorDomicilioOrden(java.lang.String apiKey, ar.com.unisolutions.ConsultarViajeRequest consulta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarViajesPorDomicilioOrden");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajesPorDomicilioOrden"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, consulta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PViaje[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PViaje[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PViaje[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarParadas(java.lang.String apikey, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarParadas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarParadas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apikey, paradas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarEtiquetasResponse consultarEtiquetas(java.lang.String apikey, ar.com.unisolutions.ConsultarEtiquetasRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarEtiquetas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEtiquetas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apikey, request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarEtiquetasResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarEtiquetasResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarEtiquetasResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PEmpresa consultarEmpresaOperacion(ar.com.unisolutions.ConsultarEmpresaOperacionRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarEmpresaOperacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEmpresaOperacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PEmpresa) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PEmpresa) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PEmpresa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarRemito(java.lang.String apikey, ar.com.unisolutions.PClienteDador clienteDador, ar.com.unisolutions.PRemito remito) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarRemito");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarRemito"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apikey, clienteDador, remito});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PEstadosViaje consultarEstadosParadasViaje(java.lang.String apikey, int idViaje) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarEstadosParadasViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEstadosParadasViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apikey, new java.lang.Integer(idViaje)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PEstadosViaje) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PEstadosViaje) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PEstadosViaje.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.BooleanResponse cambiarEstadoRecurso(java.lang.String apikey, java.lang.String entidad, java.lang.String referenciaExterna, int idEntidad, java.lang.String estado, java.lang.String login, java.lang.String motivo, boolean validarTransicion, boolean mismoEstado, java.lang.String observaciones) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CambiarEstadoRecurso");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CambiarEstadoRecurso"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apikey, entidad, referenciaExterna, new java.lang.Integer(idEntidad), estado, login, motivo, new java.lang.Boolean(validarTransicion), new java.lang.Boolean(mismoEstado), observaciones});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.BooleanResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.BooleanResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.BooleanResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarEstadoViajeArchivos(java.lang.String apiKey, ar.com.unisolutions.PEstadoViaje cambio) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarEstadoViajeArchivos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoViajeArchivos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, cambio});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarEstadoViaje(java.lang.String apiKey, int idViaje, java.lang.String estado, java.lang.String login, boolean validarTransicion, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarEstadoViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje), estado, login, new java.lang.Boolean(validarTransicion), fechaCambioEstado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarEstadoRuta(java.lang.String apiKey, int idRuta, java.lang.String estado, java.lang.String login, boolean validarTransicion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarEstadoRuta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoRuta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idRuta), estado, login, new java.lang.Boolean(validarTransicion)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PViaje[] obtenerViajes(java.lang.String apiKey, java.util.Calendar fecha, java.lang.String codigoOperacion, java.lang.String codigoSucursal) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerViajes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerViajes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, fecha, codigoOperacion, codigoSucursal});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PViaje[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PViaje[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PViaje[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.util.Calendar testTimeZone(java.util.Calendar dt, java.lang.String apiKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/testTimeZone");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "testTimeZone"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dt, apiKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.util.Calendar) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.util.Calendar) org.apache.axis.utils.JavaUtils.convert(_resp, java.util.Calendar.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PEstadiaParada[] obtenerEstadias(java.lang.String apiKey, java.util.Calendar desde, java.util.Calendar hasta, java.lang.String timeZone) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerEstadias");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerEstadias"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, desde, hasta, timeZone});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PEstadiaParada[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PEstadiaParada[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PEstadiaParada[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.BooleanResponse agregarEncuestas(java.lang.String apiKey, java.lang.String login, ar.com.unisolutions.PEncuesta[] encuestas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/AgregarEncuestas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarEncuestas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, login, encuestas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.BooleanResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.BooleanResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.BooleanResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearBeneficiariosTransporte(java.lang.String apiKey, ar.com.unisolutions.PBeneficiario[] beneficiarios) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearBeneficiariosTransporte");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearBeneficiariosTransporte"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, beneficiarios});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean apiKeyValida(java.lang.String s) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ApiKeyValida");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKeyValida"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {s});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int dummyCrearViaje(java.lang.String apiKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/DummyCrearViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DummyCrearViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearViaje(java.lang.String apiKey, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, dominio, fechaViaje, referencia, observaciones, transporte, cliente, depositoSalida, depositoLlegada, conductor, login, paradas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearViaje2(java.lang.String apiKey, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, java.lang.String prestador, java.lang.String varchar1, java.lang.String varchar2, java.lang.String varchar3, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearViaje2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, dominio, fechaViaje, referencia, observaciones, transporte, cliente, depositoSalida, depositoLlegada, conductor, login, prestador, varchar1, varchar2, varchar3, paradas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearViaje3(java.lang.String apiKey, java.lang.String empresa, java.lang.String sucursal, java.lang.String operacion, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, java.lang.String prestador, java.lang.String varchar1, java.lang.String varchar2, java.lang.String varchar3, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearViaje3");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje3"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, empresa, sucursal, operacion, dominio, fechaViaje, referencia, observaciones, transporte, cliente, depositoSalida, depositoLlegada, conductor, login, prestador, varchar1, varchar2, varchar3, paradas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.CrearViajeResultado crearViaje4(java.lang.String apiKey, java.lang.String empresa, java.lang.String sucursal, java.lang.String operacion, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, java.lang.String prestador, java.lang.String varchar1, java.lang.String varchar2, java.lang.String varchar3, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearViaje4");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje4"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, empresa, sucursal, operacion, dominio, fechaViaje, referencia, observaciones, transporte, cliente, depositoSalida, depositoLlegada, conductor, login, prestador, varchar1, varchar2, varchar3, paradas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.CrearViajeResultado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.CrearViajeResultado) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.CrearViajeResultado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.CrearViajeResultado crearViaje5(java.lang.String apiKey, java.lang.String empresa, java.lang.String sucursal, java.lang.String tipoOperacion, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearViaje5");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje5"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, empresa, sucursal, tipoOperacion, dominio, fechaViaje, referencia, observaciones, transporte, cliente, depositoSalida, depositoLlegada, conductor, login, paradas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.CrearViajeResultado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.CrearViajeResultado) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.CrearViajeResultado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.CrearViajeResultado crearViaje6(java.lang.String apiKey, java.lang.String empresa, java.lang.String sucursal, java.lang.String operacion, java.lang.String recorrido, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, java.lang.String prestador, java.lang.String varchar1, java.lang.String varchar2, java.lang.String varchar3, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearViaje6");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje6"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, empresa, sucursal, operacion, recorrido, dominio, fechaViaje, referencia, observaciones, transporte, cliente, depositoSalida, depositoLlegada, conductor, login, prestador, varchar1, varchar2, varchar3, paradas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.CrearViajeResultado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.CrearViajeResultado) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.CrearViajeResultado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.CrearViajeResultado crearViajeCompleto(ar.com.unisolutions.CrearViajeSolicitud crearviaje) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearViajeCompleto");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeCompleto"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {crearviaje});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.CrearViajeResultado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.CrearViajeResultado) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.CrearViajeResultado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void reordenarViajeTransito(java.lang.String apiKey, int idViaje, int optSize) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ReordenarViajeTransito");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReordenarViajeTransito"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje), new java.lang.Integer(optSize)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean anularViaje(java.lang.String apiKey, int idViaje, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/AnularViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AnularViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje), fechaCambioEstado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean finalizarViaje(java.lang.String apiKey, int idViaje, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/FinalizarViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinalizarViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje), fechaCambioEstado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean activarViaje(java.lang.String apiKey, int idViaje, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ActivarViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ActivarViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje), fechaCambioEstado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean relacionarViajes(java.lang.String apiKey, int idViaje1, int idViaje2, java.lang.String tipoRelacion, java.util.Calendar desde, java.util.Calendar hasta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/RelacionarViajes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RelacionarViajes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje1), new java.lang.Integer(idViaje2), tipoRelacion, desde, hasta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarEstadoOrdenEntrega(java.lang.String apiKey, ar.com.unisolutions.PEstadoOrdenEntrega estado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarEstadoOrdenEntrega");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoOrdenEntrega"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, estado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarEstadoOrdenPedido(java.lang.String apiKey, ar.com.unisolutions.PEstadoOrdenPedido estado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarEstadoOrdenPedido");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoOrdenPedido"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, estado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.POrdenPedido consultarOrdenPedido(java.lang.String apiKey, java.lang.String referenciaExterna) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarOrdenPedido");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenPedido"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, referenciaExterna});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.POrdenPedido) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.POrdenPedido) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.POrdenPedido.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.POrdenPedido consultarOrdenPedidoId(java.lang.String apiKey, int idPedido) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarOrdenPedidoId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenPedidoId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idPedido)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.POrdenPedido) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.POrdenPedido) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.POrdenPedido.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.POrdenPedido[] consultarOrdenesPedido(ar.com.unisolutions.ConsultarOrdenesPedidoRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarOrdenesPedido");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenesPedido"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.POrdenPedido[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.POrdenPedido[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.POrdenPedido[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.POrdenEntrega consultarOrdenEntrega(java.lang.String apiKey, java.lang.String refDocumento, java.lang.String sucursal, java.lang.String operacion, java.lang.String tipoOperacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarOrdenEntrega");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenEntrega"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, refDocumento, sucursal, operacion, tipoOperacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.POrdenEntrega) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.POrdenEntrega) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.POrdenEntrega.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarEstadoParada(java.lang.String apiKey, ar.com.unisolutions.PEstadoParada estado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[62]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarEstadoParada");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarEstadoParada"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, estado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarParadaItem(java.lang.String apiKey, java.lang.String referenciaExternaParada, ar.com.unisolutions.PParadaItem item, java.util.Calendar fecha, java.lang.String sucursal, java.lang.String operacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[63]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarParadaItem");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarParadaItem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, referenciaExternaParada, item, fecha, sucursal, operacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int agregarParadaItem(java.lang.String apiKey, int idViaje, java.lang.String referenciaExternaParada, ar.com.unisolutions.ParadaItem[] items) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[64]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/AgregarParadaItem");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaItem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje), referenciaExternaParada, items});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarParadaItemDesdeViaje(java.lang.String apiKey, java.lang.String referenciaExternaParada, ar.com.unisolutions.PParadaItem item, java.util.Calendar fecha, java.lang.String sucursal, java.lang.String operacion, int idViaje) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[65]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarParadaItemDesdeViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarParadaItemDesdeViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, referenciaExternaParada, item, fecha, sucursal, operacion, new java.lang.Integer(idViaje)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int eliminarParadaItemDesdeViaje(java.lang.String apiKey, java.lang.String referenciaExternaParada, java.lang.String referenciaExternaItem, java.util.Calendar fecha, java.lang.String sucursal, java.lang.String operacion, int idViaje) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[66]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/EliminarParadaItemDesdeViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarParadaItemDesdeViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, referenciaExternaParada, referenciaExternaItem, fecha, sucursal, operacion, new java.lang.Integer(idViaje)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int eliminarParadaItem(java.lang.String apiKey, java.lang.String referenciaExternaParada, java.lang.String referenciaExternaItem, java.util.Calendar fecha, java.lang.String sucursal, java.lang.String operacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[67]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/EliminarParadaItem");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarParadaItem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, referenciaExternaParada, referenciaExternaItem, fecha, sucursal, operacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarParadaResultado consultarParadaPorId(java.lang.String apiKey, int idParada) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[68]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarParadaPorId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaPorId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idParada)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarParadaResultado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarParadaResultado) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarParadaResultado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarParadaEstadosResultado consultarParadaTraceEstado(java.lang.String apiKey, int idParada, java.lang.String refDocumento, java.lang.String estadoParada, java.lang.String tipoFecha, java.util.Calendar fecha, java.lang.String ignorarEstadoParada) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[69]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarParadaTraceEstado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaTraceEstado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idParada), refDocumento, estadoParada, tipoFecha, fecha, ignorarEstadoParada});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarParadaEstadosResultado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarParadaEstadosResultado) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarParadaEstadosResultado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarParadaResultado consultarParada(java.lang.String apiKey, int idViaje, int secuencia, java.lang.String refDocumento, java.lang.String refDocumentoAdicional, java.lang.String refCliente) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[70]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarParada");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParada"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje), new java.lang.Integer(secuencia), refDocumento, refDocumentoAdicional, refCliente});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarParadaResultado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarParadaResultado) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarParadaResultado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarViajeResultadoBasic[] consultarTransicionesEstadoViaje(java.util.Calendar fecha, java.lang.String apiKey, int idViaje, java.lang.String referenciaExterna, java.lang.String operacion, java.lang.String estadoViaje, java.lang.String tipoFecha) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[71]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarTransicionesEstadoViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarTransicionesEstadoViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {fecha, apiKey, new java.lang.Integer(idViaje), referenciaExterna, operacion, estadoViaje, tipoFecha});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarViajeResultadoBasic[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarViajeResultadoBasic[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarViajeResultadoBasic[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarViajeResponse[] consultarViajesPorTransicion(java.lang.String apiKey, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion, java.lang.String estadoViaje) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[72]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarViajesPorTransicion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajesPorTransicion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, fechaDesde, fechaHasta, operacion, estadoViaje});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarViajeResponse[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarViajeResponse[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarViajeResponse[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarViajeResultado consultarViaje(java.lang.String apiKey, int idViaje) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[73]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarViajeResultado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarViajeResultado) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarViajeResultado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarViajeResultado[] consultarViajePorFechas(java.lang.String apiKey, java.util.Calendar fechaJornadaDesde, java.util.Calendar fechaJornadaHasta, int pagina, boolean cargarParadas, boolean cargarItems, boolean cargarIncidencias, boolean cargarRecursos, boolean cargarEstadoParada, boolean cargarUltimaParadaVisitada, boolean cargarTransporte) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[74]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarViajePorFechas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajePorFechas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, fechaJornadaDesde, fechaJornadaHasta, new java.lang.Integer(pagina), new java.lang.Boolean(cargarParadas), new java.lang.Boolean(cargarItems), new java.lang.Boolean(cargarIncidencias), new java.lang.Boolean(cargarRecursos), new java.lang.Boolean(cargarEstadoParada), new java.lang.Boolean(cargarUltimaParadaVisitada), new java.lang.Boolean(cargarTransporte)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarViajeResultado[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarViajeResultado[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarViajeResultado[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarViajeResultado[] consultarViajeReferenciaExterna(java.lang.String apiKey, java.lang.String referenciaExterna) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[75]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarViajeReferenciaExterna");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeReferenciaExterna"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, referenciaExterna});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarViajeResultado[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarViajeResultado[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarViajeResultado[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarViajeResultado[] consultarViajeReferenciaExternaFechaJornada(java.lang.String apiKey, java.lang.String referenciaExterna, java.util.Calendar fechaViaje) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[76]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarViajeReferenciaExternaFechaJornada");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeReferenciaExternaFechaJornada"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, referenciaExterna, fechaViaje});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarViajeResultado[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarViajeResultado[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarViajeResultado[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarViaje(java.lang.String apiKey, ar.com.unisolutions.PViaje viaje, java.lang.String cambioMismoEstado, java.lang.String validarTransicion, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[77]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, viaje, cambioMismoEstado, validarTransicion, fechaCambioEstado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int modificarViajeConParadas(java.lang.String apiKey, ar.com.unisolutions.PViaje viaje, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[78]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ModificarViajeConParadas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarViajeConParadas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, viaje, fechaCambioEstado});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean cambiarVehiculoViaje(java.lang.String apiKey, int idViaje, java.lang.String referenciaExterna, java.lang.String dominio) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[79]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CambiarVehiculoViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CambiarVehiculoViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idViaje), referenciaExterna, dominio});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PRecursoVehiculo[] consultarRecursoVehiculo(java.lang.String apiKey, java.lang.String dominio, java.lang.String referenciaRecurso, java.lang.String estado, java.lang.String estadoRecurso, java.util.Calendar fechaCreacion, java.util.Calendar fechaEstadoRecurso, java.util.Calendar fechaModificacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[80]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarRecursoVehiculo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarRecursoVehiculo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, dominio, referenciaRecurso, estado, estadoRecurso, fechaCreacion, fechaEstadoRecurso, fechaModificacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PRecursoVehiculo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PRecursoVehiculo[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PRecursoVehiculo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int consultarVehiculo(java.lang.String apiKey, java.lang.String dominio) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[81]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarVehiculo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarVehiculo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, dominio});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarMapaVehiculoResultado[] consultarMapaVehiculoBatch(java.lang.String apiKey, boolean devolverMapa, boolean devolverGeoReversa, boolean devolverTimeZone) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[82]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarMapaVehiculoBatch");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoBatch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Boolean(devolverMapa), new java.lang.Boolean(devolverGeoReversa), new java.lang.Boolean(devolverTimeZone)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarMapaVehiculoResultado[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarMapaVehiculoResultado[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarMapaVehiculoResultado[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.ConsultarMapaVehiculoResultado consultarMapaVehiculo(java.lang.String apiKey, java.lang.String dominio, boolean devolverMapa, boolean devolverGeoReversa, boolean devolverTimeZone) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[83]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ConsultarMapaVehiculo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, dominio, new java.lang.Boolean(devolverMapa), new java.lang.Boolean(devolverGeoReversa), new java.lang.Boolean(devolverTimeZone)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.ConsultarMapaVehiculoResultado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.ConsultarMapaVehiculoResultado) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.ConsultarMapaVehiculoResultado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean calcularViaje(int idViaje, boolean mantenerSecuencia, java.lang.String apiKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[84]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CalcularViaje");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CalcularViaje"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(idViaje), new java.lang.Boolean(mantenerSecuencia), apiKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean testDBConnection(java.lang.String apiKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[85]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/TestDBConnection");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TestDBConnection"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.POrdenEntrega[] obtenerRuta(java.lang.String apiKey, int idJornada, int idRuta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[86]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerRuta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRuta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idJornada), new java.lang.Integer(idRuta)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.POrdenEntrega[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.POrdenEntrega[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.POrdenEntrega[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearClientesOrden(ar.com.unisolutions.PCliente[] clientes, java.lang.String codigoSucursal, java.lang.String codigoOperacion, java.lang.String apiKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[87]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearClientesOrden");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearClientesOrden"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientes, codigoSucursal, codigoOperacion, apiKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearOrdenesPedido(java.lang.String apiKey, ar.com.unisolutions.POrdenPedido[] pedidos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[88]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearOrdenesPedido");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearOrdenesPedido"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, pedidos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            xmlRequest = _call.getMessageContext().getRequestMessage().getSOAPPartAsString();
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearProductos(java.lang.String apiKey, ar.com.unisolutions.PProducto[] productos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[89]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearProductos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearProductos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, productos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int eliminarOrdenesPedido(java.lang.String apiKey, ar.com.unisolutions.POrdenPedido[] pedidos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[90]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/EliminarOrdenesPedido");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarOrdenesPedido"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, pedidos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearRemito(java.lang.String apiKey, ar.com.unisolutions.PRemito remito) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[91]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearRemito");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearRemito"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, remito});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearOrdenesEntrega(java.lang.String apiKey, ar.com.unisolutions.POrdenEntrega[] entregas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[92]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearOrdenesEntrega");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearOrdenesEntrega"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, entregas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int eliminarOrdenesEntrega(java.lang.String apiKey, ar.com.unisolutions.POrdenEntrega[] entregas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[93]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/EliminarOrdenesEntrega");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarOrdenesEntrega"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, entregas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearVehiculos(java.lang.String apiKey, ar.com.unisolutions.PVehiculo[] vehiculos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[94]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearVehiculos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearVehiculos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, vehiculos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int crearVehiculos_ValidarExistencia(java.lang.String apiKey, ar.com.unisolutions.PVehiculo[] vehiculos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[95]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/CrearVehiculos_ValidarExistencia");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearVehiculos_ValidarExistencia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, vehiculos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int asignarVehiculo(java.lang.String apiKey, java.lang.String vehiculo, ar.com.unisolutions.CodigoSucursalOperacionRequest[] codigosSucursalOperacion, boolean borrarAsignaciones) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[96]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/AsignarVehiculo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AsignarVehiculo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, vehiculo, codigosSucursalOperacion, new java.lang.Boolean(borrarAsignaciones)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int asignarVehiculos(java.lang.String apiKey, java.lang.String[] vehiculos, java.lang.String codigoSucursal, java.lang.String codigoOperacion, boolean borrarAsignaciones) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[97]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/AsignarVehiculos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AsignarVehiculos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, vehiculos, codigoSucursal, codigoOperacion, new java.lang.Boolean(borrarAsignaciones)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int activarVehiculos(java.lang.String apiKey, ar.com.unisolutions.PVehiculo[] vehiculos, java.lang.String codigoSucursal) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[98]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ActivarVehiculos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ActivarVehiculos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, vehiculos, codigoSucursal});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PRuta obtenerRutaCompleta(java.lang.String apiKey, int idJornada, int idRuta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[99]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerRutaCompleta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutaCompleta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idJornada), new java.lang.Integer(idRuta)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PRuta) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PRuta) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PRuta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PRuta[] obtenerRutas(java.lang.String apiKey, java.util.Calendar fecha, java.lang.String codigoSucursal) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[100]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerRutas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, fecha, codigoSucursal});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PRuta[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PRuta[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PRuta[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PRuta[] obtenerRutasRequest(ar.com.unisolutions.PObtenerRutasRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[101]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerRutasRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutasRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PRuta[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PRuta[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PRuta[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PRuta[] obtenerRutas_Ruta0(java.lang.String apiKey, java.util.Calendar fecha, java.lang.String codigoSucursal) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[102]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerRutas_Ruta0");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutas_Ruta0"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, fecha, codigoSucursal});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PRuta[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PRuta[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PRuta[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PRuta[] obtenerRutas_Ruta0Request(ar.com.unisolutions.PObtenerRutasRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[103]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerRutas_Ruta0Request");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutas_Ruta0Request"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PRuta[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PRuta[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PRuta[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PParada[] obtenerParadas(java.lang.String apiKey, java.util.Calendar fecha, long idViaje, java.lang.String estadoViaje, java.lang.String codigoSucursal) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[104]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerParadas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerParadas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, fecha, new java.lang.Long(idViaje), estadoViaje, codigoSucursal});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PParada[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PParada[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PParada[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PIncidencia obtenerIncidencia(java.lang.String apiKey, int idIncidencia) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[105]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerIncidencia");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerIncidencia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idIncidencia)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PIncidencia) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PIncidencia) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PIncidencia.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PLiquidacion obtenerLiquidacion(java.lang.String apiKey, int idLiquidacion, java.lang.String referenciaLiquidacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[106]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerLiquidacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerLiquidacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey, new java.lang.Integer(idLiquidacion), referenciaLiquidacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PLiquidacion) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PLiquidacion) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PLiquidacion.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.unisolutions.PLiquidacion[] obtenerLiquidaciones(java.lang.String apiKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[107]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://unisolutions.com.ar/ObtenerLiquidaciones");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerLiquidaciones"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apiKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.unisolutions.PLiquidacion[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.unisolutions.PLiquidacion[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.unisolutions.PLiquidacion[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    @Override
    public String getXmlRequest() {
	// TODO Auto-generated method stub
	return xmlRequest;
    }

}
