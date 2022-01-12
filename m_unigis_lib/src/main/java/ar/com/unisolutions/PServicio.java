/**
 * PServicio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PServicio  implements java.io.Serializable {
    private java.lang.Double importe;

    private java.lang.String jurisdiccion;

    private java.lang.String tipo;

    private java.lang.String referenciaRecurso;

    private java.lang.String fecha;

    public PServicio() {
    }

    public PServicio(
           java.lang.Double importe,
           java.lang.String jurisdiccion,
           java.lang.String tipo,
           java.lang.String referenciaRecurso,
           java.lang.String fecha) {
           this.importe = importe;
           this.jurisdiccion = jurisdiccion;
           this.tipo = tipo;
           this.referenciaRecurso = referenciaRecurso;
           this.fecha = fecha;
    }


    /**
     * Gets the importe value for this PServicio.
     * 
     * @return importe
     */
    public java.lang.Double getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this PServicio.
     * 
     * @param importe
     */
    public void setImporte(java.lang.Double importe) {
        this.importe = importe;
    }


    /**
     * Gets the jurisdiccion value for this PServicio.
     * 
     * @return jurisdiccion
     */
    public java.lang.String getJurisdiccion() {
        return jurisdiccion;
    }


    /**
     * Sets the jurisdiccion value for this PServicio.
     * 
     * @param jurisdiccion
     */
    public void setJurisdiccion(java.lang.String jurisdiccion) {
        this.jurisdiccion = jurisdiccion;
    }


    /**
     * Gets the tipo value for this PServicio.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this PServicio.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the referenciaRecurso value for this PServicio.
     * 
     * @return referenciaRecurso
     */
    public java.lang.String getReferenciaRecurso() {
        return referenciaRecurso;
    }


    /**
     * Sets the referenciaRecurso value for this PServicio.
     * 
     * @param referenciaRecurso
     */
    public void setReferenciaRecurso(java.lang.String referenciaRecurso) {
        this.referenciaRecurso = referenciaRecurso;
    }


    /**
     * Gets the fecha value for this PServicio.
     * 
     * @return fecha
     */
    public java.lang.String getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this PServicio.
     * 
     * @param fecha
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PServicio)) return false;
        PServicio other = (PServicio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.jurisdiccion==null && other.getJurisdiccion()==null) || 
             (this.jurisdiccion!=null &&
              this.jurisdiccion.equals(other.getJurisdiccion()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.referenciaRecurso==null && other.getReferenciaRecurso()==null) || 
             (this.referenciaRecurso!=null &&
              this.referenciaRecurso.equals(other.getReferenciaRecurso()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha())));
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
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getJurisdiccion() != null) {
            _hashCode += getJurisdiccion().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getReferenciaRecurso() != null) {
            _hashCode += getReferenciaRecurso().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PServicio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jurisdiccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Jurisdiccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Tipo"));
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
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"));
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
