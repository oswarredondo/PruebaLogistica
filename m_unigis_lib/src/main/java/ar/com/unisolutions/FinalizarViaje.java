/**
 * FinalizarViaje.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class FinalizarViaje  implements java.io.Serializable {
    private java.lang.String apiKey;

    private int idViaje;

    private java.util.Calendar fechaCambioEstado;

    public FinalizarViaje() {
    }

    public FinalizarViaje(
           java.lang.String apiKey,
           int idViaje,
           java.util.Calendar fechaCambioEstado) {
           this.apiKey = apiKey;
           this.idViaje = idViaje;
           this.fechaCambioEstado = fechaCambioEstado;
    }


    /**
     * Gets the apiKey value for this FinalizarViaje.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this FinalizarViaje.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the idViaje value for this FinalizarViaje.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this FinalizarViaje.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the fechaCambioEstado value for this FinalizarViaje.
     * 
     * @return fechaCambioEstado
     */
    public java.util.Calendar getFechaCambioEstado() {
        return fechaCambioEstado;
    }


    /**
     * Sets the fechaCambioEstado value for this FinalizarViaje.
     * 
     * @param fechaCambioEstado
     */
    public void setFechaCambioEstado(java.util.Calendar fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FinalizarViaje)) return false;
        FinalizarViaje other = (FinalizarViaje) obj;
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
            this.idViaje == other.getIdViaje() &&
            ((this.fechaCambioEstado==null && other.getFechaCambioEstado()==null) || 
             (this.fechaCambioEstado!=null &&
              this.fechaCambioEstado.equals(other.getFechaCambioEstado())));
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
        _hashCode += getIdViaje();
        if (getFechaCambioEstado() != null) {
            _hashCode += getFechaCambioEstado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FinalizarViaje.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">FinalizarViaje"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCambioEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
