/**
 * CrearClientesDadores.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearClientesDadores  implements java.io.Serializable {
    private java.lang.String apiKey;

    private ar.com.unisolutions.PClienteDador[] clientes;

    public CrearClientesDadores() {
    }

    public CrearClientesDadores(
           java.lang.String apiKey,
           ar.com.unisolutions.PClienteDador[] clientes) {
           this.apiKey = apiKey;
           this.clientes = clientes;
    }


    /**
     * Gets the apiKey value for this CrearClientesDadores.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this CrearClientesDadores.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the clientes value for this CrearClientesDadores.
     * 
     * @return clientes
     */
    public ar.com.unisolutions.PClienteDador[] getClientes() {
        return clientes;
    }


    /**
     * Sets the clientes value for this CrearClientesDadores.
     * 
     * @param clientes
     */
    public void setClientes(ar.com.unisolutions.PClienteDador[] clientes) {
        this.clientes = clientes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearClientesDadores)) return false;
        CrearClientesDadores other = (CrearClientesDadores) obj;
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
            ((this.clientes==null && other.getClientes()==null) || 
             (this.clientes!=null &&
              java.util.Arrays.equals(this.clientes, other.getClientes())));
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
        if (getClientes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClientes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClientes(), i);
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
        new org.apache.axis.description.TypeDesc(CrearClientesDadores.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearClientesDadores"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "apiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "clientes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador"));
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
