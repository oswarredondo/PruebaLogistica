/**
 * CrearRecursosResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearRecursosResponse  implements java.io.Serializable {
    private int crearRecursosResult;

    public CrearRecursosResponse() {
    }

    public CrearRecursosResponse(
           int crearRecursosResult) {
           this.crearRecursosResult = crearRecursosResult;
    }


    /**
     * Gets the crearRecursosResult value for this CrearRecursosResponse.
     * 
     * @return crearRecursosResult
     */
    public int getCrearRecursosResult() {
        return crearRecursosResult;
    }


    /**
     * Sets the crearRecursosResult value for this CrearRecursosResponse.
     * 
     * @param crearRecursosResult
     */
    public void setCrearRecursosResult(int crearRecursosResult) {
        this.crearRecursosResult = crearRecursosResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearRecursosResponse)) return false;
        CrearRecursosResponse other = (CrearRecursosResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.crearRecursosResult == other.getCrearRecursosResult();
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
        _hashCode += getCrearRecursosResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearRecursosResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearRecursosResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearRecursosResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearRecursosResult"));
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
