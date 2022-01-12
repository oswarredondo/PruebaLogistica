/**
 * ConsultarTransicionesEstadoViaje.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarTransicionesEstadoViaje  implements java.io.Serializable {
    private java.util.Calendar fecha;

    private java.lang.String apiKey;

    private int idViaje;

    private java.lang.String referenciaExterna;

    private java.lang.String operacion;

    private java.lang.String estadoViaje;

    private java.lang.String tipoFecha;

    public ConsultarTransicionesEstadoViaje() {
    }

    public ConsultarTransicionesEstadoViaje(
           java.util.Calendar fecha,
           java.lang.String apiKey,
           int idViaje,
           java.lang.String referenciaExterna,
           java.lang.String operacion,
           java.lang.String estadoViaje,
           java.lang.String tipoFecha) {
           this.fecha = fecha;
           this.apiKey = apiKey;
           this.idViaje = idViaje;
           this.referenciaExterna = referenciaExterna;
           this.operacion = operacion;
           this.estadoViaje = estadoViaje;
           this.tipoFecha = tipoFecha;
    }


    /**
     * Gets the fecha value for this ConsultarTransicionesEstadoViaje.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ConsultarTransicionesEstadoViaje.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the apiKey value for this ConsultarTransicionesEstadoViaje.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ConsultarTransicionesEstadoViaje.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the idViaje value for this ConsultarTransicionesEstadoViaje.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this ConsultarTransicionesEstadoViaje.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the referenciaExterna value for this ConsultarTransicionesEstadoViaje.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this ConsultarTransicionesEstadoViaje.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the operacion value for this ConsultarTransicionesEstadoViaje.
     * 
     * @return operacion
     */
    public java.lang.String getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this ConsultarTransicionesEstadoViaje.
     * 
     * @param operacion
     */
    public void setOperacion(java.lang.String operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the estadoViaje value for this ConsultarTransicionesEstadoViaje.
     * 
     * @return estadoViaje
     */
    public java.lang.String getEstadoViaje() {
        return estadoViaje;
    }


    /**
     * Sets the estadoViaje value for this ConsultarTransicionesEstadoViaje.
     * 
     * @param estadoViaje
     */
    public void setEstadoViaje(java.lang.String estadoViaje) {
        this.estadoViaje = estadoViaje;
    }


    /**
     * Gets the tipoFecha value for this ConsultarTransicionesEstadoViaje.
     * 
     * @return tipoFecha
     */
    public java.lang.String getTipoFecha() {
        return tipoFecha;
    }


    /**
     * Sets the tipoFecha value for this ConsultarTransicionesEstadoViaje.
     * 
     * @param tipoFecha
     */
    public void setTipoFecha(java.lang.String tipoFecha) {
        this.tipoFecha = tipoFecha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarTransicionesEstadoViaje)) return false;
        ConsultarTransicionesEstadoViaje other = (ConsultarTransicionesEstadoViaje) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.apiKey==null && other.getApiKey()==null) || 
             (this.apiKey!=null &&
              this.apiKey.equals(other.getApiKey()))) &&
            this.idViaje == other.getIdViaje() &&
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
            ((this.estadoViaje==null && other.getEstadoViaje()==null) || 
             (this.estadoViaje!=null &&
              this.estadoViaje.equals(other.getEstadoViaje()))) &&
            ((this.tipoFecha==null && other.getTipoFecha()==null) || 
             (this.tipoFecha!=null &&
              this.tipoFecha.equals(other.getTipoFecha())));
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
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getApiKey() != null) {
            _hashCode += getApiKey().hashCode();
        }
        _hashCode += getIdViaje();
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        if (getEstadoViaje() != null) {
            _hashCode += getEstadoViaje().hashCode();
        }
        if (getTipoFecha() != null) {
            _hashCode += getTipoFecha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarTransicionesEstadoViaje.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarTransicionesEstadoViaje"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("tipoFecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoFecha"));
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
