/**
 * ConsultarViajesPorDomicilioOrden.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajesPorDomicilioOrden  implements java.io.Serializable {
    private java.lang.String apiKey;

    private ar.com.unisolutions.ConsultarViajeRequest consulta;

    public ConsultarViajesPorDomicilioOrden() {
    }

    public ConsultarViajesPorDomicilioOrden(
           java.lang.String apiKey,
           ar.com.unisolutions.ConsultarViajeRequest consulta) {
           this.apiKey = apiKey;
           this.consulta = consulta;
    }


    /**
     * Gets the apiKey value for this ConsultarViajesPorDomicilioOrden.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ConsultarViajesPorDomicilioOrden.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the consulta value for this ConsultarViajesPorDomicilioOrden.
     * 
     * @return consulta
     */
    public ar.com.unisolutions.ConsultarViajeRequest getConsulta() {
        return consulta;
    }


    /**
     * Sets the consulta value for this ConsultarViajesPorDomicilioOrden.
     * 
     * @param consulta
     */
    public void setConsulta(ar.com.unisolutions.ConsultarViajeRequest consulta) {
        this.consulta = consulta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajesPorDomicilioOrden)) return false;
        ConsultarViajesPorDomicilioOrden other = (ConsultarViajesPorDomicilioOrden) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apiKey==null && other.getApiKey()==null) || 
             (this.apiKey!=null &&
              this.apiKey.equals(other.getApiKey()))) &&
            ((this.consulta==null && other.getConsulta()==null) || 
             (this.consulta!=null &&
              this.consulta.equals(other.getConsulta())));
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
        if (getApiKey() != null) {
            _hashCode += getApiKey().hashCode();
        }
        if (getConsulta() != null) {
            _hashCode += getConsulta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarViajesPorDomicilioOrden.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajesPorDomicilioOrden"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consulta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "consulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeRequest"));
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
