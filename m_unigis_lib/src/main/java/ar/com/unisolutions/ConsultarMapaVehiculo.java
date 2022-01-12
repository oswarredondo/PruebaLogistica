/**
 * ConsultarMapaVehiculo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarMapaVehiculo  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.lang.String dominio;

    private boolean devolverMapa;

    private boolean devolverGeoReversa;

    private boolean devolverTimeZone;

    public ConsultarMapaVehiculo() {
    }

    public ConsultarMapaVehiculo(
           java.lang.String apiKey,
           java.lang.String dominio,
           boolean devolverMapa,
           boolean devolverGeoReversa,
           boolean devolverTimeZone) {
           this.apiKey = apiKey;
           this.dominio = dominio;
           this.devolverMapa = devolverMapa;
           this.devolverGeoReversa = devolverGeoReversa;
           this.devolverTimeZone = devolverTimeZone;
    }


    /**
     * Gets the apiKey value for this ConsultarMapaVehiculo.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ConsultarMapaVehiculo.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the dominio value for this ConsultarMapaVehiculo.
     * 
     * @return dominio
     */
    public java.lang.String getDominio() {
        return dominio;
    }


    /**
     * Sets the dominio value for this ConsultarMapaVehiculo.
     * 
     * @param dominio
     */
    public void setDominio(java.lang.String dominio) {
        this.dominio = dominio;
    }


    /**
     * Gets the devolverMapa value for this ConsultarMapaVehiculo.
     * 
     * @return devolverMapa
     */
    public boolean isDevolverMapa() {
        return devolverMapa;
    }


    /**
     * Sets the devolverMapa value for this ConsultarMapaVehiculo.
     * 
     * @param devolverMapa
     */
    public void setDevolverMapa(boolean devolverMapa) {
        this.devolverMapa = devolverMapa;
    }


    /**
     * Gets the devolverGeoReversa value for this ConsultarMapaVehiculo.
     * 
     * @return devolverGeoReversa
     */
    public boolean isDevolverGeoReversa() {
        return devolverGeoReversa;
    }


    /**
     * Sets the devolverGeoReversa value for this ConsultarMapaVehiculo.
     * 
     * @param devolverGeoReversa
     */
    public void setDevolverGeoReversa(boolean devolverGeoReversa) {
        this.devolverGeoReversa = devolverGeoReversa;
    }


    /**
     * Gets the devolverTimeZone value for this ConsultarMapaVehiculo.
     * 
     * @return devolverTimeZone
     */
    public boolean isDevolverTimeZone() {
        return devolverTimeZone;
    }


    /**
     * Sets the devolverTimeZone value for this ConsultarMapaVehiculo.
     * 
     * @param devolverTimeZone
     */
    public void setDevolverTimeZone(boolean devolverTimeZone) {
        this.devolverTimeZone = devolverTimeZone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarMapaVehiculo)) return false;
        ConsultarMapaVehiculo other = (ConsultarMapaVehiculo) obj;
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
            ((this.dominio==null && other.getDominio()==null) || 
             (this.dominio!=null &&
              this.dominio.equals(other.getDominio()))) &&
            this.devolverMapa == other.isDevolverMapa() &&
            this.devolverGeoReversa == other.isDevolverGeoReversa() &&
            this.devolverTimeZone == other.isDevolverTimeZone();
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
        if (getDominio() != null) {
            _hashCode += getDominio().hashCode();
        }
        _hashCode += (isDevolverMapa() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDevolverGeoReversa() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDevolverTimeZone() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarMapaVehiculo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarMapaVehiculo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dominio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("devolverMapa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DevolverMapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("devolverGeoReversa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DevolverGeoReversa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("devolverTimeZone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DevolverTimeZone"));
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
