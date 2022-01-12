/**
 * PEstadoLiquidacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadoLiquidacion  implements java.io.Serializable {
    private java.lang.Integer idLiquidacion;

    private java.lang.String referenciaLiquidacion;

    private java.lang.String estado;

    private java.lang.String observaciones;

    private java.lang.Boolean actualizarReferencia;

    public PEstadoLiquidacion() {
    }

    public PEstadoLiquidacion(
           java.lang.Integer idLiquidacion,
           java.lang.String referenciaLiquidacion,
           java.lang.String estado,
           java.lang.String observaciones,
           java.lang.Boolean actualizarReferencia) {
           this.idLiquidacion = idLiquidacion;
           this.referenciaLiquidacion = referenciaLiquidacion;
           this.estado = estado;
           this.observaciones = observaciones;
           this.actualizarReferencia = actualizarReferencia;
    }


    /**
     * Gets the idLiquidacion value for this PEstadoLiquidacion.
     * 
     * @return idLiquidacion
     */
    public java.lang.Integer getIdLiquidacion() {
        return idLiquidacion;
    }


    /**
     * Sets the idLiquidacion value for this PEstadoLiquidacion.
     * 
     * @param idLiquidacion
     */
    public void setIdLiquidacion(java.lang.Integer idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }


    /**
     * Gets the referenciaLiquidacion value for this PEstadoLiquidacion.
     * 
     * @return referenciaLiquidacion
     */
    public java.lang.String getReferenciaLiquidacion() {
        return referenciaLiquidacion;
    }


    /**
     * Sets the referenciaLiquidacion value for this PEstadoLiquidacion.
     * 
     * @param referenciaLiquidacion
     */
    public void setReferenciaLiquidacion(java.lang.String referenciaLiquidacion) {
        this.referenciaLiquidacion = referenciaLiquidacion;
    }


    /**
     * Gets the estado value for this PEstadoLiquidacion.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PEstadoLiquidacion.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the observaciones value for this PEstadoLiquidacion.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PEstadoLiquidacion.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the actualizarReferencia value for this PEstadoLiquidacion.
     * 
     * @return actualizarReferencia
     */
    public java.lang.Boolean getActualizarReferencia() {
        return actualizarReferencia;
    }


    /**
     * Sets the actualizarReferencia value for this PEstadoLiquidacion.
     * 
     * @param actualizarReferencia
     */
    public void setActualizarReferencia(java.lang.Boolean actualizarReferencia) {
        this.actualizarReferencia = actualizarReferencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadoLiquidacion)) return false;
        PEstadoLiquidacion other = (PEstadoLiquidacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idLiquidacion==null && other.getIdLiquidacion()==null) || 
             (this.idLiquidacion!=null &&
              this.idLiquidacion.equals(other.getIdLiquidacion()))) &&
            ((this.referenciaLiquidacion==null && other.getReferenciaLiquidacion()==null) || 
             (this.referenciaLiquidacion!=null &&
              this.referenciaLiquidacion.equals(other.getReferenciaLiquidacion()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            ((this.actualizarReferencia==null && other.getActualizarReferencia()==null) || 
             (this.actualizarReferencia!=null &&
              this.actualizarReferencia.equals(other.getActualizarReferencia())));
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
        if (getIdLiquidacion() != null) {
            _hashCode += getIdLiquidacion().hashCode();
        }
        if (getReferenciaLiquidacion() != null) {
            _hashCode += getReferenciaLiquidacion().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        if (getActualizarReferencia() != null) {
            _hashCode += getActualizarReferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadoLiquidacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoLiquidacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idLiquidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdLiquidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaLiquidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaLiquidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualizarReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ActualizarReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
