/**
 * ModificarViaje.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ModificarViaje  implements java.io.Serializable {
    private java.lang.String apiKey;

    private ar.com.unisolutions.PViaje viaje;

    private java.lang.String cambioMismoEstado;

    private java.lang.String validarTransicion;

    private java.util.Calendar fechaCambioEstado;

    public ModificarViaje() {
    }

    public ModificarViaje(
           java.lang.String apiKey,
           ar.com.unisolutions.PViaje viaje,
           java.lang.String cambioMismoEstado,
           java.lang.String validarTransicion,
           java.util.Calendar fechaCambioEstado) {
           this.apiKey = apiKey;
           this.viaje = viaje;
           this.cambioMismoEstado = cambioMismoEstado;
           this.validarTransicion = validarTransicion;
           this.fechaCambioEstado = fechaCambioEstado;
    }


    /**
     * Gets the apiKey value for this ModificarViaje.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ModificarViaje.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the viaje value for this ModificarViaje.
     * 
     * @return viaje
     */
    public ar.com.unisolutions.PViaje getViaje() {
        return viaje;
    }


    /**
     * Sets the viaje value for this ModificarViaje.
     * 
     * @param viaje
     */
    public void setViaje(ar.com.unisolutions.PViaje viaje) {
        this.viaje = viaje;
    }


    /**
     * Gets the cambioMismoEstado value for this ModificarViaje.
     * 
     * @return cambioMismoEstado
     */
    public java.lang.String getCambioMismoEstado() {
        return cambioMismoEstado;
    }


    /**
     * Sets the cambioMismoEstado value for this ModificarViaje.
     * 
     * @param cambioMismoEstado
     */
    public void setCambioMismoEstado(java.lang.String cambioMismoEstado) {
        this.cambioMismoEstado = cambioMismoEstado;
    }


    /**
     * Gets the validarTransicion value for this ModificarViaje.
     * 
     * @return validarTransicion
     */
    public java.lang.String getValidarTransicion() {
        return validarTransicion;
    }


    /**
     * Sets the validarTransicion value for this ModificarViaje.
     * 
     * @param validarTransicion
     */
    public void setValidarTransicion(java.lang.String validarTransicion) {
        this.validarTransicion = validarTransicion;
    }


    /**
     * Gets the fechaCambioEstado value for this ModificarViaje.
     * 
     * @return fechaCambioEstado
     */
    public java.util.Calendar getFechaCambioEstado() {
        return fechaCambioEstado;
    }


    /**
     * Sets the fechaCambioEstado value for this ModificarViaje.
     * 
     * @param fechaCambioEstado
     */
    public void setFechaCambioEstado(java.util.Calendar fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModificarViaje)) return false;
        ModificarViaje other = (ModificarViaje) obj;
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
            ((this.viaje==null && other.getViaje()==null) || 
             (this.viaje!=null &&
              this.viaje.equals(other.getViaje()))) &&
            ((this.cambioMismoEstado==null && other.getCambioMismoEstado()==null) || 
             (this.cambioMismoEstado!=null &&
              this.cambioMismoEstado.equals(other.getCambioMismoEstado()))) &&
            ((this.validarTransicion==null && other.getValidarTransicion()==null) || 
             (this.validarTransicion!=null &&
              this.validarTransicion.equals(other.getValidarTransicion()))) &&
            ((this.fechaCambioEstado==null && other.getFechaCambioEstado()==null) || 
             (this.fechaCambioEstado!=null &&
              this.fechaCambioEstado.equals(other.getFechaCambioEstado())));
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
        if (getViaje() != null) {
            _hashCode += getViaje().hashCode();
        }
        if (getCambioMismoEstado() != null) {
            _hashCode += getCambioMismoEstado().hashCode();
        }
        if (getValidarTransicion() != null) {
            _hashCode += getValidarTransicion().hashCode();
        }
        if (getFechaCambioEstado() != null) {
            _hashCode += getFechaCambioEstado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModificarViaje.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarViaje"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "viaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cambioMismoEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cambioMismoEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validarTransicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "validarTransicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCambioEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
