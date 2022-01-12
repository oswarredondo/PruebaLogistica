/**
 * CrearOrdenesPedidoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearOrdenesPedidoResponse  implements java.io.Serializable {
    private int crearOrdenesPedidoResult;

    public CrearOrdenesPedidoResponse() {
    }

    public CrearOrdenesPedidoResponse(
           int crearOrdenesPedidoResult) {
           this.crearOrdenesPedidoResult = crearOrdenesPedidoResult;
    }


    /**
     * Gets the crearOrdenesPedidoResult value for this CrearOrdenesPedidoResponse.
     * 
     * @return crearOrdenesPedidoResult
     */
    public int getCrearOrdenesPedidoResult() {
        return crearOrdenesPedidoResult;
    }


    /**
     * Sets the crearOrdenesPedidoResult value for this CrearOrdenesPedidoResponse.
     * 
     * @param crearOrdenesPedidoResult
     */
    public void setCrearOrdenesPedidoResult(int crearOrdenesPedidoResult) {
        this.crearOrdenesPedidoResult = crearOrdenesPedidoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearOrdenesPedidoResponse)) return false;
        CrearOrdenesPedidoResponse other = (CrearOrdenesPedidoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.crearOrdenesPedidoResult == other.getCrearOrdenesPedidoResult();
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
        _hashCode += getCrearOrdenesPedidoResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearOrdenesPedidoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearOrdenesPedidoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearOrdenesPedidoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearOrdenesPedidoResult"));
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
