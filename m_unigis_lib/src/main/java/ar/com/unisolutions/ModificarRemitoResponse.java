/**
 * ModificarRemitoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ModificarRemitoResponse  implements java.io.Serializable {
    private int modificarRemitoResult;

    public ModificarRemitoResponse() {
    }

    public ModificarRemitoResponse(
           int modificarRemitoResult) {
           this.modificarRemitoResult = modificarRemitoResult;
    }


    /**
     * Gets the modificarRemitoResult value for this ModificarRemitoResponse.
     * 
     * @return modificarRemitoResult
     */
    public int getModificarRemitoResult() {
        return modificarRemitoResult;
    }


    /**
     * Sets the modificarRemitoResult value for this ModificarRemitoResponse.
     * 
     * @param modificarRemitoResult
     */
    public void setModificarRemitoResult(int modificarRemitoResult) {
        this.modificarRemitoResult = modificarRemitoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModificarRemitoResponse)) return false;
        ModificarRemitoResponse other = (ModificarRemitoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.modificarRemitoResult == other.getModificarRemitoResult();
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
        _hashCode += getModificarRemitoResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModificarRemitoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarRemitoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modificarRemitoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ModificarRemitoResult"));
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
