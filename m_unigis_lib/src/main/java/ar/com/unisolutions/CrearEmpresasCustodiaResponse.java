/**
 * CrearEmpresasCustodiaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearEmpresasCustodiaResponse  implements java.io.Serializable {
    private int crearEmpresasCustodiaResult;

    public CrearEmpresasCustodiaResponse() {
    }

    public CrearEmpresasCustodiaResponse(
           int crearEmpresasCustodiaResult) {
           this.crearEmpresasCustodiaResult = crearEmpresasCustodiaResult;
    }


    /**
     * Gets the crearEmpresasCustodiaResult value for this CrearEmpresasCustodiaResponse.
     * 
     * @return crearEmpresasCustodiaResult
     */
    public int getCrearEmpresasCustodiaResult() {
        return crearEmpresasCustodiaResult;
    }


    /**
     * Sets the crearEmpresasCustodiaResult value for this CrearEmpresasCustodiaResponse.
     * 
     * @param crearEmpresasCustodiaResult
     */
    public void setCrearEmpresasCustodiaResult(int crearEmpresasCustodiaResult) {
        this.crearEmpresasCustodiaResult = crearEmpresasCustodiaResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearEmpresasCustodiaResponse)) return false;
        CrearEmpresasCustodiaResponse other = (CrearEmpresasCustodiaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.crearEmpresasCustodiaResult == other.getCrearEmpresasCustodiaResult();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCrearEmpresasCustodiaResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearEmpresasCustodiaResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearEmpresasCustodiaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearEmpresasCustodiaResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearEmpresasCustodiaResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
