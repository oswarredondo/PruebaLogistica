/**
 * CrearViajeResultado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearViajeResultado  implements java.io.Serializable {
    private int idViaje;

    private java.util.Calendar ultimoReporteUTC;

    private boolean vehiculoIntegrado;

    public CrearViajeResultado() {
    }

    public CrearViajeResultado(
           int idViaje,
           java.util.Calendar ultimoReporteUTC,
           boolean vehiculoIntegrado) {
           this.idViaje = idViaje;
           this.ultimoReporteUTC = ultimoReporteUTC;
           this.vehiculoIntegrado = vehiculoIntegrado;
    }


    /**
     * Gets the idViaje value for this CrearViajeResultado.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this CrearViajeResultado.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the ultimoReporteUTC value for this CrearViajeResultado.
     * 
     * @return ultimoReporteUTC
     */
    public java.util.Calendar getUltimoReporteUTC() {
        return ultimoReporteUTC;
    }


    /**
     * Sets the ultimoReporteUTC value for this CrearViajeResultado.
     * 
     * @param ultimoReporteUTC
     */
    public void setUltimoReporteUTC(java.util.Calendar ultimoReporteUTC) {
        this.ultimoReporteUTC = ultimoReporteUTC;
    }


    /**
     * Gets the vehiculoIntegrado value for this CrearViajeResultado.
     * 
     * @return vehiculoIntegrado
     */
    public boolean isVehiculoIntegrado() {
        return vehiculoIntegrado;
    }


    /**
     * Sets the vehiculoIntegrado value for this CrearViajeResultado.
     * 
     * @param vehiculoIntegrado
     */
    public void setVehiculoIntegrado(boolean vehiculoIntegrado) {
        this.vehiculoIntegrado = vehiculoIntegrado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearViajeResultado)) return false;
        CrearViajeResultado other = (CrearViajeResultado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idViaje == other.getIdViaje() &&
            ((this.ultimoReporteUTC==null && other.getUltimoReporteUTC()==null) || 
             (this.ultimoReporteUTC!=null &&
              this.ultimoReporteUTC.equals(other.getUltimoReporteUTC()))) &&
            this.vehiculoIntegrado == other.isVehiculoIntegrado();
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
        _hashCode += getIdViaje();
        if (getUltimoReporteUTC() != null) {
            _hashCode += getUltimoReporteUTC().hashCode();
        }
        _hashCode += (isVehiculoIntegrado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearViajeResultado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeResultado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimoReporteUTC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UltimoReporteUTC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoIntegrado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculoIntegrado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
