/**
 * CrearViajeCompleto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearViajeCompleto  implements java.io.Serializable {
    private ar.com.unisolutions.CrearViajeSolicitud crearviaje;

    public CrearViajeCompleto() {
    }

    public CrearViajeCompleto(
           ar.com.unisolutions.CrearViajeSolicitud crearviaje) {
           this.crearviaje = crearviaje;
    }


    /**
     * Gets the crearviaje value for this CrearViajeCompleto.
     * 
     * @return crearviaje
     */
    public ar.com.unisolutions.CrearViajeSolicitud getCrearviaje() {
        return crearviaje;
    }


    /**
     * Sets the crearviaje value for this CrearViajeCompleto.
     * 
     * @param crearviaje
     */
    public void setCrearviaje(ar.com.unisolutions.CrearViajeSolicitud crearviaje) {
        this.crearviaje = crearviaje;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearViajeCompleto)) return false;
        CrearViajeCompleto other = (CrearViajeCompleto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.crearviaje==null && other.getCrearviaje()==null) || 
             (this.crearviaje!=null &&
              this.crearviaje.equals(other.getCrearviaje())));
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
        if (getCrearviaje() != null) {
            _hashCode += getCrearviaje().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearViajeCompleto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViajeCompleto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearviaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "crearviaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeSolicitud"));
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
