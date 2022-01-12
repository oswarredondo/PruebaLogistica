/**
 * POrdenPedidoTipoVehiculo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class POrdenPedidoTipoVehiculo  implements java.io.Serializable {
    private java.lang.String tipoVehiculo;

    private boolean permitir;

    public POrdenPedidoTipoVehiculo() {
    }

    public POrdenPedidoTipoVehiculo(
           java.lang.String tipoVehiculo,
           boolean permitir) {
           this.tipoVehiculo = tipoVehiculo;
           this.permitir = permitir;
    }


    /**
     * Gets the tipoVehiculo value for this POrdenPedidoTipoVehiculo.
     * 
     * @return tipoVehiculo
     */
    public java.lang.String getTipoVehiculo() {
        return tipoVehiculo;
    }


    /**
     * Sets the tipoVehiculo value for this POrdenPedidoTipoVehiculo.
     * 
     * @param tipoVehiculo
     */
    public void setTipoVehiculo(java.lang.String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }


    /**
     * Gets the permitir value for this POrdenPedidoTipoVehiculo.
     * 
     * @return permitir
     */
    public boolean isPermitir() {
        return permitir;
    }


    /**
     * Sets the permitir value for this POrdenPedidoTipoVehiculo.
     * 
     * @param permitir
     */
    public void setPermitir(boolean permitir) {
        this.permitir = permitir;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POrdenPedidoTipoVehiculo)) return false;
        POrdenPedidoTipoVehiculo other = (POrdenPedidoTipoVehiculo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipoVehiculo==null && other.getTipoVehiculo()==null) || 
             (this.tipoVehiculo!=null &&
              this.tipoVehiculo.equals(other.getTipoVehiculo()))) &&
            this.permitir == other.isPermitir();
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
        if (getTipoVehiculo() != null) {
            _hashCode += getTipoVehiculo().hashCode();
        }
        _hashCode += (isPermitir() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POrdenPedidoTipoVehiculo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoTipoVehiculo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoVehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoVehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permitir");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Permitir"));
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
