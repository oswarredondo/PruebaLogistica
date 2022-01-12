/**
 * EliminarDomiciliosOrdenResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class EliminarDomiciliosOrdenResponse  implements java.io.Serializable {
    private int eliminarDomiciliosOrdenResult;

    public EliminarDomiciliosOrdenResponse() {
    }

    public EliminarDomiciliosOrdenResponse(
           int eliminarDomiciliosOrdenResult) {
           this.eliminarDomiciliosOrdenResult = eliminarDomiciliosOrdenResult;
    }


    /**
     * Gets the eliminarDomiciliosOrdenResult value for this EliminarDomiciliosOrdenResponse.
     * 
     * @return eliminarDomiciliosOrdenResult
     */
    public int getEliminarDomiciliosOrdenResult() {
        return eliminarDomiciliosOrdenResult;
    }


    /**
     * Sets the eliminarDomiciliosOrdenResult value for this EliminarDomiciliosOrdenResponse.
     * 
     * @param eliminarDomiciliosOrdenResult
     */
    public void setEliminarDomiciliosOrdenResult(int eliminarDomiciliosOrdenResult) {
        this.eliminarDomiciliosOrdenResult = eliminarDomiciliosOrdenResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EliminarDomiciliosOrdenResponse)) return false;
        EliminarDomiciliosOrdenResponse other = (EliminarDomiciliosOrdenResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.eliminarDomiciliosOrdenResult == other.getEliminarDomiciliosOrdenResult();
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
        _hashCode += getEliminarDomiciliosOrdenResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EliminarDomiciliosOrdenResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarDomiciliosOrdenResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eliminarDomiciliosOrdenResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EliminarDomiciliosOrdenResult"));
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
