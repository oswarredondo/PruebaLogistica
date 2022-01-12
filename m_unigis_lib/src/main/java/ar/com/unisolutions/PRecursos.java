/**
 * PRecursos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PRecursos  implements java.io.Serializable {
    private java.lang.String referenciaExterna;

    private java.lang.String descripcion;

    private java.lang.String descripcionTipoRecurso;

    private java.lang.String referenciaExternaEstadoRecurso;

    private java.lang.Integer cantidadAltaRecurso;

    private java.lang.Integer cantidad;

    public PRecursos() {
    }

    public PRecursos(
           java.lang.String referenciaExterna,
           java.lang.String descripcion,
           java.lang.String descripcionTipoRecurso,
           java.lang.String referenciaExternaEstadoRecurso,
           java.lang.Integer cantidadAltaRecurso,
           java.lang.Integer cantidad) {
           this.referenciaExterna = referenciaExterna;
           this.descripcion = descripcion;
           this.descripcionTipoRecurso = descripcionTipoRecurso;
           this.referenciaExternaEstadoRecurso = referenciaExternaEstadoRecurso;
           this.cantidadAltaRecurso = cantidadAltaRecurso;
           this.cantidad = cantidad;
    }


    /**
     * Gets the referenciaExterna value for this PRecursos.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this PRecursos.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the descripcion value for this PRecursos.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PRecursos.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the descripcionTipoRecurso value for this PRecursos.
     * 
     * @return descripcionTipoRecurso
     */
    public java.lang.String getDescripcionTipoRecurso() {
        return descripcionTipoRecurso;
    }


    /**
     * Sets the descripcionTipoRecurso value for this PRecursos.
     * 
     * @param descripcionTipoRecurso
     */
    public void setDescripcionTipoRecurso(java.lang.String descripcionTipoRecurso) {
        this.descripcionTipoRecurso = descripcionTipoRecurso;
    }


    /**
     * Gets the referenciaExternaEstadoRecurso value for this PRecursos.
     * 
     * @return referenciaExternaEstadoRecurso
     */
    public java.lang.String getReferenciaExternaEstadoRecurso() {
        return referenciaExternaEstadoRecurso;
    }


    /**
     * Sets the referenciaExternaEstadoRecurso value for this PRecursos.
     * 
     * @param referenciaExternaEstadoRecurso
     */
    public void setReferenciaExternaEstadoRecurso(java.lang.String referenciaExternaEstadoRecurso) {
        this.referenciaExternaEstadoRecurso = referenciaExternaEstadoRecurso;
    }


    /**
     * Gets the cantidadAltaRecurso value for this PRecursos.
     * 
     * @return cantidadAltaRecurso
     */
    public java.lang.Integer getCantidadAltaRecurso() {
        return cantidadAltaRecurso;
    }


    /**
     * Sets the cantidadAltaRecurso value for this PRecursos.
     * 
     * @param cantidadAltaRecurso
     */
    public void setCantidadAltaRecurso(java.lang.Integer cantidadAltaRecurso) {
        this.cantidadAltaRecurso = cantidadAltaRecurso;
    }


    /**
     * Gets the cantidad value for this PRecursos.
     * 
     * @return cantidad
     */
    public java.lang.Integer getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this PRecursos.
     * 
     * @param cantidad
     */
    public void setCantidad(java.lang.Integer cantidad) {
        this.cantidad = cantidad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PRecursos)) return false;
        PRecursos other = (PRecursos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.descripcionTipoRecurso==null && other.getDescripcionTipoRecurso()==null) || 
             (this.descripcionTipoRecurso!=null &&
              this.descripcionTipoRecurso.equals(other.getDescripcionTipoRecurso()))) &&
            ((this.referenciaExternaEstadoRecurso==null && other.getReferenciaExternaEstadoRecurso()==null) || 
             (this.referenciaExternaEstadoRecurso!=null &&
              this.referenciaExternaEstadoRecurso.equals(other.getReferenciaExternaEstadoRecurso()))) &&
            ((this.cantidadAltaRecurso==null && other.getCantidadAltaRecurso()==null) || 
             (this.cantidadAltaRecurso!=null &&
              this.cantidadAltaRecurso.equals(other.getCantidadAltaRecurso()))) &&
            ((this.cantidad==null && other.getCantidad()==null) || 
             (this.cantidad!=null &&
              this.cantidad.equals(other.getCantidad())));
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
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDescripcionTipoRecurso() != null) {
            _hashCode += getDescripcionTipoRecurso().hashCode();
        }
        if (getReferenciaExternaEstadoRecurso() != null) {
            _hashCode += getReferenciaExternaEstadoRecurso().hashCode();
        }
        if (getCantidadAltaRecurso() != null) {
            _hashCode += getCantidadAltaRecurso().hashCode();
        }
        if (getCantidad() != null) {
            _hashCode += getCantidad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PRecursos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionTipoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DescripcionTipoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExternaEstadoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaEstadoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadAltaRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CantidadAltaRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
