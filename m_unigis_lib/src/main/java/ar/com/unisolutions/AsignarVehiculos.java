/**
 * AsignarVehiculos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class AsignarVehiculos  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.lang.String[] vehiculos;

    private java.lang.String codigoSucursal;

    private java.lang.String codigoOperacion;

    private boolean borrarAsignaciones;

    public AsignarVehiculos() {
    }

    public AsignarVehiculos(
           java.lang.String apiKey,
           java.lang.String[] vehiculos,
           java.lang.String codigoSucursal,
           java.lang.String codigoOperacion,
           boolean borrarAsignaciones) {
           this.apiKey = apiKey;
           this.vehiculos = vehiculos;
           this.codigoSucursal = codigoSucursal;
           this.codigoOperacion = codigoOperacion;
           this.borrarAsignaciones = borrarAsignaciones;
    }


    /**
     * Gets the apiKey value for this AsignarVehiculos.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this AsignarVehiculos.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the vehiculos value for this AsignarVehiculos.
     * 
     * @return vehiculos
     */
    public java.lang.String[] getVehiculos() {
        return vehiculos;
    }


    /**
     * Sets the vehiculos value for this AsignarVehiculos.
     * 
     * @param vehiculos
     */
    public void setVehiculos(java.lang.String[] vehiculos) {
        this.vehiculos = vehiculos;
    }


    /**
     * Gets the codigoSucursal value for this AsignarVehiculos.
     * 
     * @return codigoSucursal
     */
    public java.lang.String getCodigoSucursal() {
        return codigoSucursal;
    }


    /**
     * Sets the codigoSucursal value for this AsignarVehiculos.
     * 
     * @param codigoSucursal
     */
    public void setCodigoSucursal(java.lang.String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }


    /**
     * Gets the codigoOperacion value for this AsignarVehiculos.
     * 
     * @return codigoOperacion
     */
    public java.lang.String getCodigoOperacion() {
        return codigoOperacion;
    }


    /**
     * Sets the codigoOperacion value for this AsignarVehiculos.
     * 
     * @param codigoOperacion
     */
    public void setCodigoOperacion(java.lang.String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }


    /**
     * Gets the borrarAsignaciones value for this AsignarVehiculos.
     * 
     * @return borrarAsignaciones
     */
    public boolean isBorrarAsignaciones() {
        return borrarAsignaciones;
    }


    /**
     * Sets the borrarAsignaciones value for this AsignarVehiculos.
     * 
     * @param borrarAsignaciones
     */
    public void setBorrarAsignaciones(boolean borrarAsignaciones) {
        this.borrarAsignaciones = borrarAsignaciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AsignarVehiculos)) return false;
        AsignarVehiculos other = (AsignarVehiculos) obj;
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
            ((this.vehiculos==null && other.getVehiculos()==null) || 
             (this.vehiculos!=null &&
              java.util.Arrays.equals(this.vehiculos, other.getVehiculos()))) &&
            ((this.codigoSucursal==null && other.getCodigoSucursal()==null) || 
             (this.codigoSucursal!=null &&
              this.codigoSucursal.equals(other.getCodigoSucursal()))) &&
            ((this.codigoOperacion==null && other.getCodigoOperacion()==null) || 
             (this.codigoOperacion!=null &&
              this.codigoOperacion.equals(other.getCodigoOperacion()))) &&
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
        if (getVehiculos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVehiculos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVehiculos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodigoSucursal() != null) {
            _hashCode += getCodigoSucursal().hashCode();
        }
        if (getCodigoOperacion() != null) {
            _hashCode += getCodigoOperacion().hashCode();
        }
        _hashCode += (isBorrarAsignaciones() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AsignarVehiculos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AsignarVehiculos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "vehiculos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoSucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "codigoSucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
