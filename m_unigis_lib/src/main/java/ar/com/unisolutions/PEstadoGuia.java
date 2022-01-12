/**
 * PEstadoGuia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadoGuia  implements java.io.Serializable {
    private java.lang.Integer idGuia;

    private java.lang.String referenciaGuia;

    private java.lang.String estado;

    private java.lang.String observaciones;

    public PEstadoGuia() {
    }

    public PEstadoGuia(
           java.lang.Integer idGuia,
           java.lang.String referenciaGuia,
           java.lang.String estado,
           java.lang.String observaciones) {
           this.idGuia = idGuia;
           this.referenciaGuia = referenciaGuia;
           this.estado = estado;
           this.observaciones = observaciones;
    }


    /**
     * Gets the idGuia value for this PEstadoGuia.
     * 
     * @return idGuia
     */
    public java.lang.Integer getIdGuia() {
        return idGuia;
    }


    /**
     * Sets the idGuia value for this PEstadoGuia.
     * 
     * @param idGuia
     */
    public void setIdGuia(java.lang.Integer idGuia) {
        this.idGuia = idGuia;
    }


    /**
     * Gets the referenciaGuia value for this PEstadoGuia.
     * 
     * @return referenciaGuia
     */
    public java.lang.String getReferenciaGuia() {
        return referenciaGuia;
    }


    /**
     * Sets the referenciaGuia value for this PEstadoGuia.
     * 
     * @param referenciaGuia
     */
    public void setReferenciaGuia(java.lang.String referenciaGuia) {
        this.referenciaGuia = referenciaGuia;
    }


    /**
     * Gets the estado value for this PEstadoGuia.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PEstadoGuia.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the observaciones value for this PEstadoGuia.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PEstadoGuia.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadoGuia)) return false;
        PEstadoGuia other = (PEstadoGuia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idGuia==null && other.getIdGuia()==null) || 
             (this.idGuia!=null &&
              this.idGuia.equals(other.getIdGuia()))) &&
            ((this.referenciaGuia==null && other.getReferenciaGuia()==null) || 
             (this.referenciaGuia!=null &&
              this.referenciaGuia.equals(other.getReferenciaGuia()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones())));
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
        if (getIdGuia() != null) {
            _hashCode += getIdGuia().hashCode();
        }
        if (getReferenciaGuia() != null) {
            _hashCode += getReferenciaGuia().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadoGuia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoGuia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGuia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdGuia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaGuia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaGuia"));
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
