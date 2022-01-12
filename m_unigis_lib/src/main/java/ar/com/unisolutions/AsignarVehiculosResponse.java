/**
 * AsignarVehiculosResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class AsignarVehiculosResponse  implements java.io.Serializable {
    private int asignarVehiculosResult;

    public AsignarVehiculosResponse() {
    }

    public AsignarVehiculosResponse(
           int asignarVehiculosResult) {
           this.asignarVehiculosResult = asignarVehiculosResult;
    }


    /**
     * Gets the asignarVehiculosResult value for this AsignarVehiculosResponse.
     * 
     * @return asignarVehiculosResult
     */
    public int getAsignarVehiculosResult() {
        return asignarVehiculosResult;
    }


    /**
     * Sets the asignarVehiculosResult value for this AsignarVehiculosResponse.
     * 
     * @param asignarVehiculosResult
     */
    public void setAsignarVehiculosResult(int asignarVehiculosResult) {
        this.asignarVehiculosResult = asignarVehiculosResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AsignarVehiculosResponse)) return false;
        AsignarVehiculosResponse other = (AsignarVehiculosResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.asignarVehiculosResult == other.getAsignarVehiculosResult();
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
        _hashCode += getAsignarVehiculosResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AsignarVehiculosResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AsignarVehiculosResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asignarVehiculosResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AsignarVehiculosResult"));
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
