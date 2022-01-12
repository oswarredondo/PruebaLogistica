/**
 * FinalizarViajeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class FinalizarViajeResponse  implements java.io.Serializable {
    private boolean finalizarViajeResult;

    public FinalizarViajeResponse() {
    }

    public FinalizarViajeResponse(
           boolean finalizarViajeResult) {
           this.finalizarViajeResult = finalizarViajeResult;
    }


    /**
     * Gets the finalizarViajeResult value for this FinalizarViajeResponse.
     * 
     * @return finalizarViajeResult
     */
    public boolean isFinalizarViajeResult() {
        return finalizarViajeResult;
    }


    /**
     * Sets the finalizarViajeResult value for this FinalizarViajeResponse.
     * 
     * @param finalizarViajeResult
     */
    public void setFinalizarViajeResult(boolean finalizarViajeResult) {
        this.finalizarViajeResult = finalizarViajeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FinalizarViajeResponse)) return false;
        FinalizarViajeResponse other = (FinalizarViajeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.finalizarViajeResult == other.isFinalizarViajeResult();
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
        _hashCode += (isFinalizarViajeResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FinalizarViajeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">FinalizarViajeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finalizarViajeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinalizarViajeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
