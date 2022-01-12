/**
 * CrearGuiasLiquidacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearGuiasLiquidacion  implements java.io.Serializable {
    private java.lang.String apiKey;

    private ar.com.unisolutions.PGuiaLiquidacion[] guias;

    public CrearGuiasLiquidacion() {
    }

    public CrearGuiasLiquidacion(
           java.lang.String apiKey,
           ar.com.unisolutions.PGuiaLiquidacion[] guias) {
           this.apiKey = apiKey;
           this.guias = guias;
    }


    /**
     * Gets the apiKey value for this CrearGuiasLiquidacion.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this CrearGuiasLiquidacion.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the guias value for this CrearGuiasLiquidacion.
     * 
     * @return guias
     */
    public ar.com.unisolutions.PGuiaLiquidacion[] getGuias() {
        return guias;
    }


    /**
     * Sets the guias value for this CrearGuiasLiquidacion.
     * 
     * @param guias
     */
    public void setGuias(ar.com.unisolutions.PGuiaLiquidacion[] guias) {
        this.guias = guias;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearGuiasLiquidacion)) return false;
        CrearGuiasLiquidacion other = (CrearGuiasLiquidacion) obj;
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
            ((this.guias==null && other.getGuias()==null) || 
             (this.guias!=null &&
              java.util.Arrays.equals(this.guias, other.getGuias())));
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
        if (getGuias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGuias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGuias(), i);
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
        new org.apache.axis.description.TypeDesc(CrearGuiasLiquidacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearGuiasLiquidacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Guias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
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
