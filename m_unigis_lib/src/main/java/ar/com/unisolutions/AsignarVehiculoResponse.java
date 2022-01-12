/**
 * AsignarVehiculoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class AsignarVehiculoResponse  implements java.io.Serializable {
    private int asignarVehiculoResult;

    public AsignarVehiculoResponse() {
    }

    public AsignarVehiculoResponse(
           int asignarVehiculoResult) {
           this.asignarVehiculoResult = asignarVehiculoResult;
    }


    /**
     * Gets the asignarVehiculoResult value for this AsignarVehiculoResponse.
     * 
     * @return asignarVehiculoResult
     */
    public int getAsignarVehiculoResult() {
        return asignarVehiculoResult;
    }


    /**
     * Sets the asignarVehiculoResult value for this AsignarVehiculoResponse.
     * 
     * @param asignarVehiculoResult
     */
    public void setAsignarVehiculoResult(int asignarVehiculoResult) {
        this.asignarVehiculoResult = asignarVehiculoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AsignarVehiculoResponse)) return false;
        AsignarVehiculoResponse other = (AsignarVehiculoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.asignarVehiculoResult == other.getAsignarVehiculoResult();
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
        _hashCode += getAsignarVehiculoResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AsignarVehiculoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AsignarVehiculoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asignarVehiculoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AsignarVehiculoResult"));
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
