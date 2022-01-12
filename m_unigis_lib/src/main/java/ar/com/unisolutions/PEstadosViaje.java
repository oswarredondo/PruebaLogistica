/**
 * PEstadosViaje.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadosViaje  implements java.io.Serializable {
    private java.lang.Integer idViaje;

    private java.lang.Integer idEstadoViaje;

    private java.lang.String descripcionEstadoViaje;

    private ar.com.unisolutions.PEstadosParadas[] estadosParadas;

    public PEstadosViaje() {
    }

    public PEstadosViaje(
           java.lang.Integer idViaje,
           java.lang.Integer idEstadoViaje,
           java.lang.String descripcionEstadoViaje,
           ar.com.unisolutions.PEstadosParadas[] estadosParadas) {
           this.idViaje = idViaje;
           this.idEstadoViaje = idEstadoViaje;
           this.descripcionEstadoViaje = descripcionEstadoViaje;
           this.estadosParadas = estadosParadas;
    }


    /**
     * Gets the idViaje value for this PEstadosViaje.
     * 
     * @return idViaje
     */
    public java.lang.Integer getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PEstadosViaje.
     * 
     * @param idViaje
     */
    public void setIdViaje(java.lang.Integer idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the idEstadoViaje value for this PEstadosViaje.
     * 
     * @return idEstadoViaje
     */
    public java.lang.Integer getIdEstadoViaje() {
        return idEstadoViaje;
    }


    /**
     * Sets the idEstadoViaje value for this PEstadosViaje.
     * 
     * @param idEstadoViaje
     */
    public void setIdEstadoViaje(java.lang.Integer idEstadoViaje) {
        this.idEstadoViaje = idEstadoViaje;
    }


    /**
     * Gets the descripcionEstadoViaje value for this PEstadosViaje.
     * 
     * @return descripcionEstadoViaje
     */
    public java.lang.String getDescripcionEstadoViaje() {
        return descripcionEstadoViaje;
    }


    /**
     * Sets the descripcionEstadoViaje value for this PEstadosViaje.
     * 
     * @param descripcionEstadoViaje
     */
    public void setDescripcionEstadoViaje(java.lang.String descripcionEstadoViaje) {
        this.descripcionEstadoViaje = descripcionEstadoViaje;
    }


    /**
     * Gets the estadosParadas value for this PEstadosViaje.
     * 
     * @return estadosParadas
     */
    public ar.com.unisolutions.PEstadosParadas[] getEstadosParadas() {
        return estadosParadas;
    }


    /**
     * Sets the estadosParadas value for this PEstadosViaje.
     * 
     * @param estadosParadas
     */
    public void setEstadosParadas(ar.com.unisolutions.PEstadosParadas[] estadosParadas) {
        this.estadosParadas = estadosParadas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadosViaje)) return false;
        PEstadosViaje other = (PEstadosViaje) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idViaje==null && other.getIdViaje()==null) || 
             (this.idViaje!=null &&
              this.idViaje.equals(other.getIdViaje()))) &&
            ((this.idEstadoViaje==null && other.getIdEstadoViaje()==null) || 
             (this.idEstadoViaje!=null &&
              this.idEstadoViaje.equals(other.getIdEstadoViaje()))) &&
            ((this.descripcionEstadoViaje==null && other.getDescripcionEstadoViaje()==null) || 
             (this.descripcionEstadoViaje!=null &&
              this.descripcionEstadoViaje.equals(other.getDescripcionEstadoViaje()))) &&
            ((this.estadosParadas==null && other.getEstadosParadas()==null) || 
             (this.estadosParadas!=null &&
              java.util.Arrays.equals(this.estadosParadas, other.getEstadosParadas())));
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
        if (getIdViaje() != null) {
            _hashCode += getIdViaje().hashCode();
        }
        if (getIdEstadoViaje() != null) {
            _hashCode += getIdEstadoViaje().hashCode();
        }
        if (getDescripcionEstadoViaje() != null) {
            _hashCode += getDescripcionEstadoViaje().hashCode();
        }
        if (getEstadosParadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEstadosParadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEstadosParadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadosViaje.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosViaje"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEstadoViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdEstadoViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionEstadoViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DescripcionEstadoViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadosParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadosParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosParadas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosParadas"));
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
