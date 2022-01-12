/**
 * AgregarParadaViajeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class AgregarParadaViajeResponse  implements java.io.Serializable {
    private java.lang.String refDocumento;

    private int idParada;

    private java.lang.String descripcion;

    public AgregarParadaViajeResponse() {
    }

    public AgregarParadaViajeResponse(
           java.lang.String refDocumento,
           int idParada,
           java.lang.String descripcion) {
           this.refDocumento = refDocumento;
           this.idParada = idParada;
           this.descripcion = descripcion;
    }


    /**
     * Gets the refDocumento value for this AgregarParadaViajeResponse.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this AgregarParadaViajeResponse.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the idParada value for this AgregarParadaViajeResponse.
     * 
     * @return idParada
     */
    public int getIdParada() {
        return idParada;
    }


    /**
     * Sets the idParada value for this AgregarParadaViajeResponse.
     * 
     * @param idParada
     */
    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }


    /**
     * Gets the descripcion value for this AgregarParadaViajeResponse.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this AgregarParadaViajeResponse.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgregarParadaViajeResponse)) return false;
        AgregarParadaViajeResponse other = (AgregarParadaViajeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            this.idParada == other.getIdParada() &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion())));
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
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        _hashCode += getIdParada();
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgregarParadaViajeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarParadaViajeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
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
