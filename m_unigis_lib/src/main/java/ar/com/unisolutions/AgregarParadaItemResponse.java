/**
 * AgregarParadaItemResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class AgregarParadaItemResponse  implements java.io.Serializable {
    private int agregarParadaItemResult;

    public AgregarParadaItemResponse() {
    }

    public AgregarParadaItemResponse(
           int agregarParadaItemResult) {
           this.agregarParadaItemResult = agregarParadaItemResult;
    }


    /**
     * Gets the agregarParadaItemResult value for this AgregarParadaItemResponse.
     * 
     * @return agregarParadaItemResult
     */
    public int getAgregarParadaItemResult() {
        return agregarParadaItemResult;
    }


    /**
     * Sets the agregarParadaItemResult value for this AgregarParadaItemResponse.
     * 
     * @param agregarParadaItemResult
     */
    public void setAgregarParadaItemResult(int agregarParadaItemResult) {
        this.agregarParadaItemResult = agregarParadaItemResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgregarParadaItemResponse)) return false;
        AgregarParadaItemResponse other = (AgregarParadaItemResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.agregarParadaItemResult == other.getAgregarParadaItemResult();
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
        _hashCode += getAgregarParadaItemResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgregarParadaItemResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AgregarParadaItemResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agregarParadaItemResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaItemResult"));
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
