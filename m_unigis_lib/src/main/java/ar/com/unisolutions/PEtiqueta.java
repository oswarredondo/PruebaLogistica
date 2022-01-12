/**
 * PEtiqueta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEtiqueta  implements java.io.Serializable {
    private java.lang.String etiqueta;

    private int cantidad;

    public PEtiqueta() {
    }

    public PEtiqueta(
           java.lang.String etiqueta,
           int cantidad) {
           this.etiqueta = etiqueta;
           this.cantidad = cantidad;
    }


    /**
     * Gets the etiqueta value for this PEtiqueta.
     * 
     * @return etiqueta
     */
    public java.lang.String getEtiqueta() {
        return etiqueta;
    }


    /**
     * Sets the etiqueta value for this PEtiqueta.
     * 
     * @param etiqueta
     */
    public void setEtiqueta(java.lang.String etiqueta) {
        this.etiqueta = etiqueta;
    }


    /**
     * Gets the cantidad value for this PEtiqueta.
     * 
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this PEtiqueta.
     * 
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEtiqueta)) return false;
        PEtiqueta other = (PEtiqueta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.etiqueta==null && other.getEtiqueta()==null) || 
             (this.etiqueta!=null &&
              this.etiqueta.equals(other.getEtiqueta()))) &&
            this.cantidad == other.getCantidad();
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
        if (getEtiqueta() != null) {
            _hashCode += getEtiqueta().hashCode();
        }
        _hashCode += getCantidad();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEtiqueta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEtiqueta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiqueta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Etiqueta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
