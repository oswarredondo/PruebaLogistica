/**
 * ObtenerLiquidacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerLiquidacion  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.lang.Integer idLiquidacion;

    private java.lang.String referenciaLiquidacion;

    public ObtenerLiquidacion() {
    }

    public ObtenerLiquidacion(
           java.lang.String apiKey,
           java.lang.Integer idLiquidacion,
           java.lang.String referenciaLiquidacion) {
           this.apiKey = apiKey;
           this.idLiquidacion = idLiquidacion;
           this.referenciaLiquidacion = referenciaLiquidacion;
    }


    /**
     * Gets the apiKey value for this ObtenerLiquidacion.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ObtenerLiquidacion.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the idLiquidacion value for this ObtenerLiquidacion.
     * 
     * @return idLiquidacion
     */
    public java.lang.Integer getIdLiquidacion() {
        return idLiquidacion;
    }


    /**
     * Sets the idLiquidacion value for this ObtenerLiquidacion.
     * 
     * @param idLiquidacion
     */
    public void setIdLiquidacion(java.lang.Integer idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }


    /**
     * Gets the referenciaLiquidacion value for this ObtenerLiquidacion.
     * 
     * @return referenciaLiquidacion
     */
    public java.lang.String getReferenciaLiquidacion() {
        return referenciaLiquidacion;
    }


    /**
     * Sets the referenciaLiquidacion value for this ObtenerLiquidacion.
     * 
     * @param referenciaLiquidacion
     */
    public void setReferenciaLiquidacion(java.lang.String referenciaLiquidacion) {
        this.referenciaLiquidacion = referenciaLiquidacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerLiquidacion)) return false;
        ObtenerLiquidacion other = (ObtenerLiquidacion) obj;
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
            ((this.idLiquidacion==null && other.getIdLiquidacion()==null) || 
             (this.idLiquidacion!=null &&
              this.idLiquidacion.equals(other.getIdLiquidacion()))) &&
            ((this.referenciaLiquidacion==null && other.getReferenciaLiquidacion()==null) || 
             (this.referenciaLiquidacion!=null &&
              this.referenciaLiquidacion.equals(other.getReferenciaLiquidacion())));
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
        if (getIdLiquidacion() != null) {
            _hashCode += getIdLiquidacion().hashCode();
        }
        if (getReferenciaLiquidacion() != null) {
            _hashCode += getReferenciaLiquidacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerLiquidacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerLiquidacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idLiquidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdLiquidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaLiquidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaLiquidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
