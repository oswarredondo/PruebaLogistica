/**
 * ModificarParadas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ModificarParadas  implements java.io.Serializable {
    private java.lang.String apikey;

    private ar.com.unisolutions.PParada[] paradas;

    public ModificarParadas() {
    }

    public ModificarParadas(
           java.lang.String apikey,
           ar.com.unisolutions.PParada[] paradas) {
           this.apikey = apikey;
           this.paradas = paradas;
    }


    /**
     * Gets the apikey value for this ModificarParadas.
     * 
     * @return apikey
     */
    public java.lang.String getApikey() {
        return apikey;
    }


    /**
     * Sets the apikey value for this ModificarParadas.
     * 
     * @param apikey
     */
    public void setApikey(java.lang.String apikey) {
        this.apikey = apikey;
    }


    /**
     * Gets the paradas value for this ModificarParadas.
     * 
     * @return paradas
     */
    public ar.com.unisolutions.PParada[] getParadas() {
        return paradas;
    }


    /**
     * Sets the paradas value for this ModificarParadas.
     * 
     * @param paradas
     */
    public void setParadas(ar.com.unisolutions.PParada[] paradas) {
        this.paradas = paradas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModificarParadas)) return false;
        ModificarParadas other = (ModificarParadas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apikey==null && other.getApikey()==null) || 
             (this.apikey!=null &&
              this.apikey.equals(other.getApikey()))) &&
            ((this.paradas==null && other.getParadas()==null) || 
             (this.paradas!=null &&
              java.util.Arrays.equals(this.paradas, other.getParadas())));
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
        if (getApikey() != null) {
            _hashCode += getApikey().hashCode();
        }
        if (getParadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParadas(), i);
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
        new org.apache.axis.description.TypeDesc(ModificarParadas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarParadas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apikey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apikey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
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
