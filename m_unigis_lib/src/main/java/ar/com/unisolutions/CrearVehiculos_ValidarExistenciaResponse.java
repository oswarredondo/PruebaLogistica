/**
 * CrearVehiculos_ValidarExistenciaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearVehiculos_ValidarExistenciaResponse  implements java.io.Serializable {
    private int crearVehiculos_ValidarExistenciaResult;

    public CrearVehiculos_ValidarExistenciaResponse() {
    }

    public CrearVehiculos_ValidarExistenciaResponse(
           int crearVehiculos_ValidarExistenciaResult) {
           this.crearVehiculos_ValidarExistenciaResult = crearVehiculos_ValidarExistenciaResult;
    }


    /**
     * Gets the crearVehiculos_ValidarExistenciaResult value for this CrearVehiculos_ValidarExistenciaResponse.
     * 
     * @return crearVehiculos_ValidarExistenciaResult
     */
    public int getCrearVehiculos_ValidarExistenciaResult() {
        return crearVehiculos_ValidarExistenciaResult;
    }


    /**
     * Sets the crearVehiculos_ValidarExistenciaResult value for this CrearVehiculos_ValidarExistenciaResponse.
     * 
     * @param crearVehiculos_ValidarExistenciaResult
     */
    public void setCrearVehiculos_ValidarExistenciaResult(int crearVehiculos_ValidarExistenciaResult) {
        this.crearVehiculos_ValidarExistenciaResult = crearVehiculos_ValidarExistenciaResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearVehiculos_ValidarExistenciaResponse)) return false;
        CrearVehiculos_ValidarExistenciaResponse other = (CrearVehiculos_ValidarExistenciaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.crearVehiculos_ValidarExistenciaResult == other.getCrearVehiculos_ValidarExistenciaResult();
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
        _hashCode += getCrearVehiculos_ValidarExistenciaResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearVehiculos_ValidarExistenciaResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearVehiculos_ValidarExistenciaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearVehiculos_ValidarExistenciaResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearVehiculos_ValidarExistenciaResult"));
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
