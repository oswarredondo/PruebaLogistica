/**
 * PEstadia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadia  implements java.io.Serializable {
    private java.lang.Double importe;

    private java.lang.String jurisdiccion;

    private java.lang.String tipoRecurso;

    private java.lang.String referenciaRecurso;

    private java.lang.String tipoUbicacion;

    private java.lang.String referenciaUbicacion;

    private java.lang.String duracion;

    public PEstadia() {
    }

    public PEstadia(
           java.lang.Double importe,
           java.lang.String jurisdiccion,
           java.lang.String tipoRecurso,
           java.lang.String referenciaRecurso,
           java.lang.String tipoUbicacion,
           java.lang.String referenciaUbicacion,
           java.lang.String duracion) {
           this.importe = importe;
           this.jurisdiccion = jurisdiccion;
           this.tipoRecurso = tipoRecurso;
           this.referenciaRecurso = referenciaRecurso;
           this.tipoUbicacion = tipoUbicacion;
           this.referenciaUbicacion = referenciaUbicacion;
           this.duracion = duracion;
    }


    /**
     * Gets the importe value for this PEstadia.
     * 
     * @return importe
     */
    public java.lang.Double getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this PEstadia.
     * 
     * @param importe
     */
    public void setImporte(java.lang.Double importe) {
        this.importe = importe;
    }


    /**
     * Gets the jurisdiccion value for this PEstadia.
     * 
     * @return jurisdiccion
     */
    public java.lang.String getJurisdiccion() {
        return jurisdiccion;
    }


    /**
     * Sets the jurisdiccion value for this PEstadia.
     * 
     * @param jurisdiccion
     */
    public void setJurisdiccion(java.lang.String jurisdiccion) {
        this.jurisdiccion = jurisdiccion;
    }


    /**
     * Gets the tipoRecurso value for this PEstadia.
     * 
     * @return tipoRecurso
     */
    public java.lang.String getTipoRecurso() {
        return tipoRecurso;
    }


    /**
     * Sets the tipoRecurso value for this PEstadia.
     * 
     * @param tipoRecurso
     */
    public void setTipoRecurso(java.lang.String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }


    /**
     * Gets the referenciaRecurso value for this PEstadia.
     * 
     * @return referenciaRecurso
     */
    public java.lang.String getReferenciaRecurso() {
        return referenciaRecurso;
    }


    /**
     * Sets the referenciaRecurso value for this PEstadia.
     * 
     * @param referenciaRecurso
     */
    public void setReferenciaRecurso(java.lang.String referenciaRecurso) {
        this.referenciaRecurso = referenciaRecurso;
    }


    /**
     * Gets the tipoUbicacion value for this PEstadia.
     * 
     * @return tipoUbicacion
     */
    public java.lang.String getTipoUbicacion() {
        return tipoUbicacion;
    }


    /**
     * Sets the tipoUbicacion value for this PEstadia.
     * 
     * @param tipoUbicacion
     */
    public void setTipoUbicacion(java.lang.String tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }


    /**
     * Gets the referenciaUbicacion value for this PEstadia.
     * 
     * @return referenciaUbicacion
     */
    public java.lang.String getReferenciaUbicacion() {
        return referenciaUbicacion;
    }


    /**
     * Sets the referenciaUbicacion value for this PEstadia.
     * 
     * @param referenciaUbicacion
     */
    public void setReferenciaUbicacion(java.lang.String referenciaUbicacion) {
        this.referenciaUbicacion = referenciaUbicacion;
    }


    /**
     * Gets the duracion value for this PEstadia.
     * 
     * @return duracion
     */
    public java.lang.String getDuracion() {
        return duracion;
    }


    /**
     * Sets the duracion value for this PEstadia.
     * 
     * @param duracion
     */
    public void setDuracion(java.lang.String duracion) {
        this.duracion = duracion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadia)) return false;
        PEstadia other = (PEstadia) obj;
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
            ((this.tipoRecurso==null && other.getTipoRecurso()==null) || 
             (this.tipoRecurso!=null &&
              this.tipoRecurso.equals(other.getTipoRecurso()))) &&
            ((this.referenciaRecurso==null && other.getReferenciaRecurso()==null) || 
             (this.referenciaRecurso!=null &&
              this.referenciaRecurso.equals(other.getReferenciaRecurso()))) &&
            ((this.tipoUbicacion==null && other.getTipoUbicacion()==null) || 
             (this.tipoUbicacion!=null &&
              this.tipoUbicacion.equals(other.getTipoUbicacion()))) &&
            ((this.referenciaUbicacion==null && other.getReferenciaUbicacion()==null) || 
             (this.referenciaUbicacion!=null &&
              this.referenciaUbicacion.equals(other.getReferenciaUbicacion()))) &&
            ((this.duracion==null && other.getDuracion()==null) || 
             (this.duracion!=null &&
              this.duracion.equals(other.getDuracion())));
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
        if (getTipoRecurso() != null) {
            _hashCode += getTipoRecurso().hashCode();
        }
        if (getReferenciaRecurso() != null) {
            _hashCode += getReferenciaRecurso().hashCode();
        }
        if (getTipoUbicacion() != null) {
            _hashCode += getTipoUbicacion().hashCode();
        }
        if (getReferenciaUbicacion() != null) {
            _hashCode += getReferenciaUbicacion().hashCode();
        }
        if (getDuracion() != null) {
            _hashCode += getDuracion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadia"));
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
        elemField.setFieldName("duracion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Duracion"));
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
