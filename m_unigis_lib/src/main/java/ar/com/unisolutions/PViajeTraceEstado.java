/**
 * PViajeTraceEstado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PViajeTraceEstado  implements java.io.Serializable {
    private int secuencia;

    private java.lang.String estadoOrigen;

    private java.lang.String estadoDestino;

    private java.util.Calendar fecha;

    private java.lang.String usuario;

    public PViajeTraceEstado() {
    }

    public PViajeTraceEstado(
           int secuencia,
           java.lang.String estadoOrigen,
           java.lang.String estadoDestino,
           java.util.Calendar fecha,
           java.lang.String usuario) {
           this.secuencia = secuencia;
           this.estadoOrigen = estadoOrigen;
           this.estadoDestino = estadoDestino;
           this.fecha = fecha;
           this.usuario = usuario;
    }


    /**
     * Gets the secuencia value for this PViajeTraceEstado.
     * 
     * @return secuencia
     */
    public int getSecuencia() {
        return secuencia;
    }


    /**
     * Sets the secuencia value for this PViajeTraceEstado.
     * 
     * @param secuencia
     */
    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }


    /**
     * Gets the estadoOrigen value for this PViajeTraceEstado.
     * 
     * @return estadoOrigen
     */
    public java.lang.String getEstadoOrigen() {
        return estadoOrigen;
    }


    /**
     * Sets the estadoOrigen value for this PViajeTraceEstado.
     * 
     * @param estadoOrigen
     */
    public void setEstadoOrigen(java.lang.String estadoOrigen) {
        this.estadoOrigen = estadoOrigen;
    }


    /**
     * Gets the estadoDestino value for this PViajeTraceEstado.
     * 
     * @return estadoDestino
     */
    public java.lang.String getEstadoDestino() {
        return estadoDestino;
    }


    /**
     * Sets the estadoDestino value for this PViajeTraceEstado.
     * 
     * @param estadoDestino
     */
    public void setEstadoDestino(java.lang.String estadoDestino) {
        this.estadoDestino = estadoDestino;
    }


    /**
     * Gets the fecha value for this PViajeTraceEstado.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this PViajeTraceEstado.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the usuario value for this PViajeTraceEstado.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this PViajeTraceEstado.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PViajeTraceEstado)) return false;
        PViajeTraceEstado other = (PViajeTraceEstado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.secuencia == other.getSecuencia() &&
            ((this.estadoOrigen==null && other.getEstadoOrigen()==null) || 
             (this.estadoOrigen!=null &&
              this.estadoOrigen.equals(other.getEstadoOrigen()))) &&
            ((this.estadoDestino==null && other.getEstadoDestino()==null) || 
             (this.estadoDestino!=null &&
              this.estadoDestino.equals(other.getEstadoDestino()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario())));
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
        _hashCode += getSecuencia();
        if (getEstadoOrigen() != null) {
            _hashCode += getEstadoOrigen().hashCode();
        }
        if (getEstadoDestino() != null) {
            _hashCode += getEstadoDestino().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PViajeTraceEstado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViajeTraceEstado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secuencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Secuencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoOrigen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoOrigen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoDestino"));
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
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Usuario"));
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
