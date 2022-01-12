/**
 * PArchivo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PArchivo  implements java.io.Serializable {
    private java.lang.String tipo;

    private java.lang.String foto;

    private java.lang.String clasificacion;

    public PArchivo() {
    }

    public PArchivo(
           java.lang.String tipo,
           java.lang.String foto,
           java.lang.String clasificacion) {
           this.tipo = tipo;
           this.foto = foto;
           this.clasificacion = clasificacion;
    }


    /**
     * Gets the tipo value for this PArchivo.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this PArchivo.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the foto value for this PArchivo.
     * 
     * @return foto
     */
    public java.lang.String getFoto() {
        return foto;
    }


    /**
     * Sets the foto value for this PArchivo.
     * 
     * @param foto
     */
    public void setFoto(java.lang.String foto) {
        this.foto = foto;
    }


    /**
     * Gets the clasificacion value for this PArchivo.
     * 
     * @return clasificacion
     */
    public java.lang.String getClasificacion() {
        return clasificacion;
    }


    /**
     * Sets the clasificacion value for this PArchivo.
     * 
     * @param clasificacion
     */
    public void setClasificacion(java.lang.String clasificacion) {
        this.clasificacion = clasificacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PArchivo)) return false;
        PArchivo other = (PArchivo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.foto==null && other.getFoto()==null) || 
             (this.foto!=null &&
              this.foto.equals(other.getFoto()))) &&
            ((this.clasificacion==null && other.getClasificacion()==null) || 
             (this.clasificacion!=null &&
              this.clasificacion.equals(other.getClasificacion())));
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
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getFoto() != null) {
            _hashCode += getFoto().hashCode();
        }
        if (getClasificacion() != null) {
            _hashCode += getClasificacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PArchivo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Foto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clasificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Clasificacion"));
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
