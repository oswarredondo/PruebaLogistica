/**
 * ConsultarRecursosRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarRecursosRequest  implements java.io.Serializable {
    private java.lang.String tipoRecurso;

    private java.lang.String referenciaRecurso;

    private java.lang.String estadoRecurso;

    private java.lang.String tipoUbicacion;

    private java.lang.String referenciaUbicacion;

    private java.util.Calendar fechaDesde;

    private java.util.Calendar fechaHasta;

    public ConsultarRecursosRequest() {
    }

    public ConsultarRecursosRequest(
           java.lang.String tipoRecurso,
           java.lang.String referenciaRecurso,
           java.lang.String estadoRecurso,
           java.lang.String tipoUbicacion,
           java.lang.String referenciaUbicacion,
           java.util.Calendar fechaDesde,
           java.util.Calendar fechaHasta) {
           this.tipoRecurso = tipoRecurso;
           this.referenciaRecurso = referenciaRecurso;
           this.estadoRecurso = estadoRecurso;
           this.tipoUbicacion = tipoUbicacion;
           this.referenciaUbicacion = referenciaUbicacion;
           this.fechaDesde = fechaDesde;
           this.fechaHasta = fechaHasta;
    }


    /**
     * Gets the tipoRecurso value for this ConsultarRecursosRequest.
     * 
     * @return tipoRecurso
     */
    public java.lang.String getTipoRecurso() {
        return tipoRecurso;
    }


    /**
     * Sets the tipoRecurso value for this ConsultarRecursosRequest.
     * 
     * @param tipoRecurso
     */
    public void setTipoRecurso(java.lang.String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }


    /**
     * Gets the referenciaRecurso value for this ConsultarRecursosRequest.
     * 
     * @return referenciaRecurso
     */
    public java.lang.String getReferenciaRecurso() {
        return referenciaRecurso;
    }


    /**
     * Sets the referenciaRecurso value for this ConsultarRecursosRequest.
     * 
     * @param referenciaRecurso
     */
    public void setReferenciaRecurso(java.lang.String referenciaRecurso) {
        this.referenciaRecurso = referenciaRecurso;
    }


    /**
     * Gets the estadoRecurso value for this ConsultarRecursosRequest.
     * 
     * @return estadoRecurso
     */
    public java.lang.String getEstadoRecurso() {
        return estadoRecurso;
    }


    /**
     * Sets the estadoRecurso value for this ConsultarRecursosRequest.
     * 
     * @param estadoRecurso
     */
    public void setEstadoRecurso(java.lang.String estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }


    /**
     * Gets the tipoUbicacion value for this ConsultarRecursosRequest.
     * 
     * @return tipoUbicacion
     */
    public java.lang.String getTipoUbicacion() {
        return tipoUbicacion;
    }


    /**
     * Sets the tipoUbicacion value for this ConsultarRecursosRequest.
     * 
     * @param tipoUbicacion
     */
    public void setTipoUbicacion(java.lang.String tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }


    /**
     * Gets the referenciaUbicacion value for this ConsultarRecursosRequest.
     * 
     * @return referenciaUbicacion
     */
    public java.lang.String getReferenciaUbicacion() {
        return referenciaUbicacion;
    }


    /**
     * Sets the referenciaUbicacion value for this ConsultarRecursosRequest.
     * 
     * @param referenciaUbicacion
     */
    public void setReferenciaUbicacion(java.lang.String referenciaUbicacion) {
        this.referenciaUbicacion = referenciaUbicacion;
    }


    /**
     * Gets the fechaDesde value for this ConsultarRecursosRequest.
     * 
     * @return fechaDesde
     */
    public java.util.Calendar getFechaDesde() {
        return fechaDesde;
    }


    /**
     * Sets the fechaDesde value for this ConsultarRecursosRequest.
     * 
     * @param fechaDesde
     */
    public void setFechaDesde(java.util.Calendar fechaDesde) {
        this.fechaDesde = fechaDesde;
    }


    /**
     * Gets the fechaHasta value for this ConsultarRecursosRequest.
     * 
     * @return fechaHasta
     */
    public java.util.Calendar getFechaHasta() {
        return fechaHasta;
    }


    /**
     * Sets the fechaHasta value for this ConsultarRecursosRequest.
     * 
     * @param fechaHasta
     */
    public void setFechaHasta(java.util.Calendar fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarRecursosRequest)) return false;
        ConsultarRecursosRequest other = (ConsultarRecursosRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipoRecurso==null && other.getTipoRecurso()==null) || 
             (this.tipoRecurso!=null &&
              this.tipoRecurso.equals(other.getTipoRecurso()))) &&
            ((this.referenciaRecurso==null && other.getReferenciaRecurso()==null) || 
             (this.referenciaRecurso!=null &&
              this.referenciaRecurso.equals(other.getReferenciaRecurso()))) &&
            ((this.estadoRecurso==null && other.getEstadoRecurso()==null) || 
             (this.estadoRecurso!=null &&
              this.estadoRecurso.equals(other.getEstadoRecurso()))) &&
            ((this.tipoUbicacion==null && other.getTipoUbicacion()==null) || 
             (this.tipoUbicacion!=null &&
              this.tipoUbicacion.equals(other.getTipoUbicacion()))) &&
            ((this.referenciaUbicacion==null && other.getReferenciaUbicacion()==null) || 
             (this.referenciaUbicacion!=null &&
              this.referenciaUbicacion.equals(other.getReferenciaUbicacion()))) &&
            ((this.fechaDesde==null && other.getFechaDesde()==null) || 
             (this.fechaDesde!=null &&
              this.fechaDesde.equals(other.getFechaDesde()))) &&
            ((this.fechaHasta==null && other.getFechaHasta()==null) || 
             (this.fechaHasta!=null &&
              this.fechaHasta.equals(other.getFechaHasta())));
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
        if (getTipoRecurso() != null) {
            _hashCode += getTipoRecurso().hashCode();
        }
        if (getReferenciaRecurso() != null) {
            _hashCode += getReferenciaRecurso().hashCode();
        }
        if (getEstadoRecurso() != null) {
            _hashCode += getEstadoRecurso().hashCode();
        }
        if (getTipoUbicacion() != null) {
            _hashCode += getTipoUbicacion().hashCode();
        }
        if (getReferenciaUbicacion() != null) {
            _hashCode += getReferenciaUbicacion().hashCode();
        }
        if (getFechaDesde() != null) {
            _hashCode += getFechaDesde().hashCode();
        }
        if (getFechaHasta() != null) {
            _hashCode += getFechaHasta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarRecursosRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarRecursosRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoUbicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoUbicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaUbicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaUbicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
