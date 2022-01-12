/**
 * ObtenerParadas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerParadas  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.util.Calendar fecha;

    private long idViaje;

    private java.lang.String estadoViaje;

    private java.lang.String codigoSucursal;

    public ObtenerParadas() {
    }

    public ObtenerParadas(
           java.lang.String apiKey,
           java.util.Calendar fecha,
           long idViaje,
           java.lang.String estadoViaje,
           java.lang.String codigoSucursal) {
           this.apiKey = apiKey;
           this.fecha = fecha;
           this.idViaje = idViaje;
           this.estadoViaje = estadoViaje;
           this.codigoSucursal = codigoSucursal;
    }


    /**
     * Gets the apiKey value for this ObtenerParadas.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ObtenerParadas.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the fecha value for this ObtenerParadas.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ObtenerParadas.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the idViaje value for this ObtenerParadas.
     * 
     * @return idViaje
     */
    public long getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this ObtenerParadas.
     * 
     * @param idViaje
     */
    public void setIdViaje(long idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the estadoViaje value for this ObtenerParadas.
     * 
     * @return estadoViaje
     */
    public java.lang.String getEstadoViaje() {
        return estadoViaje;
    }


    /**
     * Sets the estadoViaje value for this ObtenerParadas.
     * 
     * @param estadoViaje
     */
    public void setEstadoViaje(java.lang.String estadoViaje) {
        this.estadoViaje = estadoViaje;
    }


    /**
     * Gets the codigoSucursal value for this ObtenerParadas.
     * 
     * @return codigoSucursal
     */
    public java.lang.String getCodigoSucursal() {
        return codigoSucursal;
    }


    /**
     * Sets the codigoSucursal value for this ObtenerParadas.
     * 
     * @param codigoSucursal
     */
    public void setCodigoSucursal(java.lang.String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerParadas)) return false;
        ObtenerParadas other = (ObtenerParadas) obj;
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
            this.idViaje == other.getIdViaje() &&
            ((this.estadoViaje==null && other.getEstadoViaje()==null) || 
             (this.estadoViaje!=null &&
              this.estadoViaje.equals(other.getEstadoViaje()))) &&
            ((this.codigoSucursal==null && other.getCodigoSucursal()==null) || 
             (this.codigoSucursal!=null &&
              this.codigoSucursal.equals(other.getCodigoSucursal())));
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
        _hashCode += new Long(getIdViaje()).hashCode();
        if (getEstadoViaje() != null) {
            _hashCode += getEstadoViaje().hashCode();
        }
        if (getCodigoSucursal() != null) {
            _hashCode += getCodigoSucursal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerParadas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerParadas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoSucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"));
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
