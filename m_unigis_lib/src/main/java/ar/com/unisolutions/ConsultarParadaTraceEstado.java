/**
 * ConsultarParadaTraceEstado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarParadaTraceEstado  implements java.io.Serializable {
    private java.lang.String apiKey;

    private int idParada;

    private java.lang.String refDocumento;

    private java.lang.String estadoParada;

    private java.lang.String tipoFecha;

    private java.util.Calendar fecha;

    private java.lang.String ignorarEstadoParada;

    public ConsultarParadaTraceEstado() {
    }

    public ConsultarParadaTraceEstado(
           java.lang.String apiKey,
           int idParada,
           java.lang.String refDocumento,
           java.lang.String estadoParada,
           java.lang.String tipoFecha,
           java.util.Calendar fecha,
           java.lang.String ignorarEstadoParada) {
           this.apiKey = apiKey;
           this.idParada = idParada;
           this.refDocumento = refDocumento;
           this.estadoParada = estadoParada;
           this.tipoFecha = tipoFecha;
           this.fecha = fecha;
           this.ignorarEstadoParada = ignorarEstadoParada;
    }


    /**
     * Gets the apiKey value for this ConsultarParadaTraceEstado.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ConsultarParadaTraceEstado.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the idParada value for this ConsultarParadaTraceEstado.
     * 
     * @return idParada
     */
    public int getIdParada() {
        return idParada;
    }


    /**
     * Sets the idParada value for this ConsultarParadaTraceEstado.
     * 
     * @param idParada
     */
    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }


    /**
     * Gets the refDocumento value for this ConsultarParadaTraceEstado.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this ConsultarParadaTraceEstado.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the estadoParada value for this ConsultarParadaTraceEstado.
     * 
     * @return estadoParada
     */
    public java.lang.String getEstadoParada() {
        return estadoParada;
    }


    /**
     * Sets the estadoParada value for this ConsultarParadaTraceEstado.
     * 
     * @param estadoParada
     */
    public void setEstadoParada(java.lang.String estadoParada) {
        this.estadoParada = estadoParada;
    }


    /**
     * Gets the tipoFecha value for this ConsultarParadaTraceEstado.
     * 
     * @return tipoFecha
     */
    public java.lang.String getTipoFecha() {
        return tipoFecha;
    }


    /**
     * Sets the tipoFecha value for this ConsultarParadaTraceEstado.
     * 
     * @param tipoFecha
     */
    public void setTipoFecha(java.lang.String tipoFecha) {
        this.tipoFecha = tipoFecha;
    }


    /**
     * Gets the fecha value for this ConsultarParadaTraceEstado.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ConsultarParadaTraceEstado.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the ignorarEstadoParada value for this ConsultarParadaTraceEstado.
     * 
     * @return ignorarEstadoParada
     */
    public java.lang.String getIgnorarEstadoParada() {
        return ignorarEstadoParada;
    }


    /**
     * Sets the ignorarEstadoParada value for this ConsultarParadaTraceEstado.
     * 
     * @param ignorarEstadoParada
     */
    public void setIgnorarEstadoParada(java.lang.String ignorarEstadoParada) {
        this.ignorarEstadoParada = ignorarEstadoParada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarParadaTraceEstado)) return false;
        ConsultarParadaTraceEstado other = (ConsultarParadaTraceEstado) obj;
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
            this.idParada == other.getIdParada() &&
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            ((this.estadoParada==null && other.getEstadoParada()==null) || 
             (this.estadoParada!=null &&
              this.estadoParada.equals(other.getEstadoParada()))) &&
            ((this.tipoFecha==null && other.getTipoFecha()==null) || 
             (this.tipoFecha!=null &&
              this.tipoFecha.equals(other.getTipoFecha()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.ignorarEstadoParada==null && other.getIgnorarEstadoParada()==null) || 
             (this.ignorarEstadoParada!=null &&
              this.ignorarEstadoParada.equals(other.getIgnorarEstadoParada())));
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
        _hashCode += getIdParada();
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getEstadoParada() != null) {
            _hashCode += getEstadoParada().hashCode();
        }
        if (getTipoFecha() != null) {
            _hashCode += getTipoFecha().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getIgnorarEstadoParada() != null) {
            _hashCode += getIgnorarEstadoParada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarParadaTraceEstado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarParadaTraceEstado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoParada"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ignorarEstadoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IgnorarEstadoParada"));
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
