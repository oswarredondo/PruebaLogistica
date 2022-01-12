/**
 * PObtenerRutasRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PObtenerRutasRequest  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.util.Calendar fecha;

    private java.lang.String codigoSucursal;

    private java.lang.String codigoOperacion;

    public PObtenerRutasRequest() {
    }

    public PObtenerRutasRequest(
           java.lang.String apiKey,
           java.util.Calendar fecha,
           java.lang.String codigoSucursal,
           java.lang.String codigoOperacion) {
           this.apiKey = apiKey;
           this.fecha = fecha;
           this.codigoSucursal = codigoSucursal;
           this.codigoOperacion = codigoOperacion;
    }


    /**
     * Gets the apiKey value for this PObtenerRutasRequest.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this PObtenerRutasRequest.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the fecha value for this PObtenerRutasRequest.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this PObtenerRutasRequest.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the codigoSucursal value for this PObtenerRutasRequest.
     * 
     * @return codigoSucursal
     */
    public java.lang.String getCodigoSucursal() {
        return codigoSucursal;
    }


    /**
     * Sets the codigoSucursal value for this PObtenerRutasRequest.
     * 
     * @param codigoSucursal
     */
    public void setCodigoSucursal(java.lang.String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }


    /**
     * Gets the codigoOperacion value for this PObtenerRutasRequest.
     * 
     * @return codigoOperacion
     */
    public java.lang.String getCodigoOperacion() {
        return codigoOperacion;
    }


    /**
     * Sets the codigoOperacion value for this PObtenerRutasRequest.
     * 
     * @param codigoOperacion
     */
    public void setCodigoOperacion(java.lang.String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PObtenerRutasRequest)) return false;
        PObtenerRutasRequest other = (PObtenerRutasRequest) obj;
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
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.codigoSucursal==null && other.getCodigoSucursal()==null) || 
             (this.codigoSucursal!=null &&
              this.codigoSucursal.equals(other.getCodigoSucursal()))) &&
            ((this.codigoOperacion==null && other.getCodigoOperacion()==null) || 
             (this.codigoOperacion!=null &&
              this.codigoOperacion.equals(other.getCodigoOperacion())));
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
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getCodigoSucursal() != null) {
            _hashCode += getCodigoSucursal().hashCode();
        }
        if (getCodigoOperacion() != null) {
            _hashCode += getCodigoOperacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PObtenerRutasRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pObtenerRutasRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoSucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
