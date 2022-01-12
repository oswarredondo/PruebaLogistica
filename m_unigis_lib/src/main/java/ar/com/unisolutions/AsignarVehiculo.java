/**
 * AsignarVehiculo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class AsignarVehiculo  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.lang.String vehiculo;

    private ar.com.unisolutions.CodigoSucursalOperacionRequest[] codigosSucursalOperacion;

    private boolean borrarAsignaciones;

    public AsignarVehiculo() {
    }

    public AsignarVehiculo(
           java.lang.String apiKey,
           java.lang.String vehiculo,
           ar.com.unisolutions.CodigoSucursalOperacionRequest[] codigosSucursalOperacion,
           boolean borrarAsignaciones) {
           this.apiKey = apiKey;
           this.vehiculo = vehiculo;
           this.codigosSucursalOperacion = codigosSucursalOperacion;
           this.borrarAsignaciones = borrarAsignaciones;
    }


    /**
     * Gets the apiKey value for this AsignarVehiculo.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this AsignarVehiculo.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the vehiculo value for this AsignarVehiculo.
     * 
     * @return vehiculo
     */
    public java.lang.String getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this AsignarVehiculo.
     * 
     * @param vehiculo
     */
    public void setVehiculo(java.lang.String vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the codigosSucursalOperacion value for this AsignarVehiculo.
     * 
     * @return codigosSucursalOperacion
     */
    public ar.com.unisolutions.CodigoSucursalOperacionRequest[] getCodigosSucursalOperacion() {
        return codigosSucursalOperacion;
    }


    /**
     * Sets the codigosSucursalOperacion value for this AsignarVehiculo.
     * 
     * @param codigosSucursalOperacion
     */
    public void setCodigosSucursalOperacion(ar.com.unisolutions.CodigoSucursalOperacionRequest[] codigosSucursalOperacion) {
        this.codigosSucursalOperacion = codigosSucursalOperacion;
    }


    /**
     * Gets the borrarAsignaciones value for this AsignarVehiculo.
     * 
     * @return borrarAsignaciones
     */
    public boolean isBorrarAsignaciones() {
        return borrarAsignaciones;
    }


    /**
     * Sets the borrarAsignaciones value for this AsignarVehiculo.
     * 
     * @param borrarAsignaciones
     */
    public void setBorrarAsignaciones(boolean borrarAsignaciones) {
        this.borrarAsignaciones = borrarAsignaciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AsignarVehiculo)) return false;
        AsignarVehiculo other = (AsignarVehiculo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apiKey==null && other.getApiKey()==null) || 
             (this.apiKey!=null &&
              this.apiKey.equals(other.getApiKey()))) &&
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo()))) &&
            ((this.codigosSucursalOperacion==null && other.getCodigosSucursalOperacion()==null) || 
             (this.codigosSucursalOperacion!=null &&
              java.util.Arrays.equals(this.codigosSucursalOperacion, other.getCodigosSucursalOperacion()))) &&
            this.borrarAsignaciones == other.isBorrarAsignaciones();
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
        if (getApiKey() != null) {
            _hashCode += getApiKey().hashCode();
        }
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        if (getCodigosSucursalOperacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCodigosSucursalOperacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCodigosSucursalOperacion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isBorrarAsignaciones() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AsignarVehiculo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AsignarVehiculo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "vehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigosSucursalOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigosSucursalOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigoSucursalOperacionRequest"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigoSucursalOperacionRequest"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("borrarAsignaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "borrarAsignaciones"));
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
