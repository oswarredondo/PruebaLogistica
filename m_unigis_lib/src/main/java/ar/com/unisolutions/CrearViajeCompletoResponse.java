/**
 * CrearViajeCompletoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearViajeCompletoResponse  implements java.io.Serializable {
    private ar.com.unisolutions.CrearViajeResultado crearViajeCompletoResult;

    public CrearViajeCompletoResponse() {
    }

    public CrearViajeCompletoResponse(
           ar.com.unisolutions.CrearViajeResultado crearViajeCompletoResult) {
           this.crearViajeCompletoResult = crearViajeCompletoResult;
    }


    /**
     * Gets the crearViajeCompletoResult value for this CrearViajeCompletoResponse.
     * 
     * @return crearViajeCompletoResult
     */
    public ar.com.unisolutions.CrearViajeResultado getCrearViajeCompletoResult() {
        return crearViajeCompletoResult;
    }


    /**
     * Sets the crearViajeCompletoResult value for this CrearViajeCompletoResponse.
     * 
     * @param crearViajeCompletoResult
     */
    public void setCrearViajeCompletoResult(ar.com.unisolutions.CrearViajeResultado crearViajeCompletoResult) {
        this.crearViajeCompletoResult = crearViajeCompletoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearViajeCompletoResponse)) return false;
        CrearViajeCompletoResponse other = (CrearViajeCompletoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.crearViajeCompletoResult==null && other.getCrearViajeCompletoResult()==null) || 
             (this.crearViajeCompletoResult!=null &&
              this.crearViajeCompletoResult.equals(other.getCrearViajeCompletoResult())));
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
        if (getCrearViajeCompletoResult() != null) {
            _hashCode += getCrearViajeCompletoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearViajeCompletoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViajeCompletoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearViajeCompletoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeCompletoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeResultado"));
        elemField.setMinOccurs(0);
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
