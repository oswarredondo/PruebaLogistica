/**
 * PArchivoDoc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PArchivoDoc  implements java.io.Serializable {
    private java.lang.String descripcion;

    private java.lang.String tipoArchivo;

    private java.lang.String contenido;

    private java.lang.String clasificacionArchivo;

    public PArchivoDoc() {
    }

    public PArchivoDoc(
           java.lang.String descripcion,
           java.lang.String tipoArchivo,
           java.lang.String contenido,
           java.lang.String clasificacionArchivo) {
           this.descripcion = descripcion;
           this.tipoArchivo = tipoArchivo;
           this.contenido = contenido;
           this.clasificacionArchivo = clasificacionArchivo;
    }


    /**
     * Gets the descripcion value for this PArchivoDoc.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PArchivoDoc.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the tipoArchivo value for this PArchivoDoc.
     * 
     * @return tipoArchivo
     */
    public java.lang.String getTipoArchivo() {
        return tipoArchivo;
    }


    /**
     * Sets the tipoArchivo value for this PArchivoDoc.
     * 
     * @param tipoArchivo
     */
    public void setTipoArchivo(java.lang.String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }


    /**
     * Gets the contenido value for this PArchivoDoc.
     * 
     * @return contenido
     */
    public java.lang.String getContenido() {
        return contenido;
    }


    /**
     * Sets the contenido value for this PArchivoDoc.
     * 
     * @param contenido
     */
    public void setContenido(java.lang.String contenido) {
        this.contenido = contenido;
    }


    /**
     * Gets the clasificacionArchivo value for this PArchivoDoc.
     * 
     * @return clasificacionArchivo
     */
    public java.lang.String getClasificacionArchivo() {
        return clasificacionArchivo;
    }


    /**
     * Sets the clasificacionArchivo value for this PArchivoDoc.
     * 
     * @param clasificacionArchivo
     */
    public void setClasificacionArchivo(java.lang.String clasificacionArchivo) {
        this.clasificacionArchivo = clasificacionArchivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PArchivoDoc)) return false;
        PArchivoDoc other = (PArchivoDoc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.tipoArchivo==null && other.getTipoArchivo()==null) || 
             (this.tipoArchivo!=null &&
              this.tipoArchivo.equals(other.getTipoArchivo()))) &&
            ((this.contenido==null && other.getContenido()==null) || 
             (this.contenido!=null &&
              this.contenido.equals(other.getContenido()))) &&
            ((this.clasificacionArchivo==null && other.getClasificacionArchivo()==null) || 
             (this.clasificacionArchivo!=null &&
              this.clasificacionArchivo.equals(other.getClasificacionArchivo())));
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getTipoArchivo() != null) {
            _hashCode += getTipoArchivo().hashCode();
        }
        if (getContenido() != null) {
            _hashCode += getContenido().hashCode();
        }
        if (getClasificacionArchivo() != null) {
            _hashCode += getClasificacionArchivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PArchivoDoc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivoDoc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoArchivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoArchivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Contenido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clasificacionArchivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ClasificacionArchivo"));
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
