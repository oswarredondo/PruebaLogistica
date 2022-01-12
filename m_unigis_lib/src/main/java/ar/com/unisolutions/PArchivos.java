/**
 * PArchivos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PArchivos  implements java.io.Serializable {
    private java.lang.String tipoArchivo;

    private java.lang.String contenidoArchivo;

    public PArchivos() {
    }

    public PArchivos(
           java.lang.String tipoArchivo,
           java.lang.String contenidoArchivo) {
           this.tipoArchivo = tipoArchivo;
           this.contenidoArchivo = contenidoArchivo;
    }


    /**
     * Gets the tipoArchivo value for this PArchivos.
     * 
     * @return tipoArchivo
     */
    public java.lang.String getTipoArchivo() {
        return tipoArchivo;
    }


    /**
     * Sets the tipoArchivo value for this PArchivos.
     * 
     * @param tipoArchivo
     */
    public void setTipoArchivo(java.lang.String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }


    /**
     * Gets the contenidoArchivo value for this PArchivos.
     * 
     * @return contenidoArchivo
     */
    public java.lang.String getContenidoArchivo() {
        return contenidoArchivo;
    }


    /**
     * Sets the contenidoArchivo value for this PArchivos.
     * 
     * @param contenidoArchivo
     */
    public void setContenidoArchivo(java.lang.String contenidoArchivo) {
        this.contenidoArchivo = contenidoArchivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PArchivos)) return false;
        PArchivos other = (PArchivos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipoArchivo==null && other.getTipoArchivo()==null) || 
             (this.tipoArchivo!=null &&
              this.tipoArchivo.equals(other.getTipoArchivo()))) &&
            ((this.contenidoArchivo==null && other.getContenidoArchivo()==null) || 
             (this.contenidoArchivo!=null &&
              this.contenidoArchivo.equals(other.getContenidoArchivo())));
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
        if (getTipoArchivo() != null) {
            _hashCode += getTipoArchivo().hashCode();
        }
        if (getContenidoArchivo() != null) {
            _hashCode += getContenidoArchivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PArchivos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoArchivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoArchivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenidoArchivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ContenidoArchivo"));
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
