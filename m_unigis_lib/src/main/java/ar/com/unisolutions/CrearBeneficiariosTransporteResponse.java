/**
 * CrearBeneficiariosTransporteResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearBeneficiariosTransporteResponse  implements java.io.Serializable {
    private int crearBeneficiariosTransporteResult;

    public CrearBeneficiariosTransporteResponse() {
    }

    public CrearBeneficiariosTransporteResponse(
           int crearBeneficiariosTransporteResult) {
           this.crearBeneficiariosTransporteResult = crearBeneficiariosTransporteResult;
    }


    /**
     * Gets the crearBeneficiariosTransporteResult value for this CrearBeneficiariosTransporteResponse.
     * 
     * @return crearBeneficiariosTransporteResult
     */
    public int getCrearBeneficiariosTransporteResult() {
        return crearBeneficiariosTransporteResult;
    }


    /**
     * Sets the crearBeneficiariosTransporteResult value for this CrearBeneficiariosTransporteResponse.
     * 
     * @param crearBeneficiariosTransporteResult
     */
    public void setCrearBeneficiariosTransporteResult(int crearBeneficiariosTransporteResult) {
        this.crearBeneficiariosTransporteResult = crearBeneficiariosTransporteResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearBeneficiariosTransporteResponse)) return false;
        CrearBeneficiariosTransporteResponse other = (CrearBeneficiariosTransporteResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.crearBeneficiariosTransporteResult == other.getCrearBeneficiariosTransporteResult();
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
        _hashCode += getCrearBeneficiariosTransporteResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearBeneficiariosTransporteResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearBeneficiariosTransporteResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearBeneficiariosTransporteResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearBeneficiariosTransporteResult"));
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
