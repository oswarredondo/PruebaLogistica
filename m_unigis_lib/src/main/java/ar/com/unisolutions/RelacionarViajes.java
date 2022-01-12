/**
 * RelacionarViajes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class RelacionarViajes  implements java.io.Serializable {
    private java.lang.String apiKey;

    private int idViaje1;

    private int idViaje2;

    private java.lang.String tipoRelacion;

    private java.util.Calendar desde;

    private java.util.Calendar hasta;

    public RelacionarViajes() {
    }

    public RelacionarViajes(
           java.lang.String apiKey,
           int idViaje1,
           int idViaje2,
           java.lang.String tipoRelacion,
           java.util.Calendar desde,
           java.util.Calendar hasta) {
           this.apiKey = apiKey;
           this.idViaje1 = idViaje1;
           this.idViaje2 = idViaje2;
           this.tipoRelacion = tipoRelacion;
           this.desde = desde;
           this.hasta = hasta;
    }


    /**
     * Gets the apiKey value for this RelacionarViajes.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this RelacionarViajes.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the idViaje1 value for this RelacionarViajes.
     * 
     * @return idViaje1
     */
    public int getIdViaje1() {
        return idViaje1;
    }


    /**
     * Sets the idViaje1 value for this RelacionarViajes.
     * 
     * @param idViaje1
     */
    public void setIdViaje1(int idViaje1) {
        this.idViaje1 = idViaje1;
    }


    /**
     * Gets the idViaje2 value for this RelacionarViajes.
     * 
     * @return idViaje2
     */
    public int getIdViaje2() {
        return idViaje2;
    }


    /**
     * Sets the idViaje2 value for this RelacionarViajes.
     * 
     * @param idViaje2
     */
    public void setIdViaje2(int idViaje2) {
        this.idViaje2 = idViaje2;
    }


    /**
     * Gets the tipoRelacion value for this RelacionarViajes.
     * 
     * @return tipoRelacion
     */
    public java.lang.String getTipoRelacion() {
        return tipoRelacion;
    }


    /**
     * Sets the tipoRelacion value for this RelacionarViajes.
     * 
     * @param tipoRelacion
     */
    public void setTipoRelacion(java.lang.String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }


    /**
     * Gets the desde value for this RelacionarViajes.
     * 
     * @return desde
     */
    public java.util.Calendar getDesde() {
        return desde;
    }


    /**
     * Sets the desde value for this RelacionarViajes.
     * 
     * @param desde
     */
    public void setDesde(java.util.Calendar desde) {
        this.desde = desde;
    }


    /**
     * Gets the hasta value for this RelacionarViajes.
     * 
     * @return hasta
     */
    public java.util.Calendar getHasta() {
        return hasta;
    }


    /**
     * Sets the hasta value for this RelacionarViajes.
     * 
     * @param hasta
     */
    public void setHasta(java.util.Calendar hasta) {
        this.hasta = hasta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelacionarViajes)) return false;
        RelacionarViajes other = (RelacionarViajes) obj;
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
            this.idViaje1 == other.getIdViaje1() &&
            this.idViaje2 == other.getIdViaje2() &&
            ((this.tipoRelacion==null && other.getTipoRelacion()==null) || 
             (this.tipoRelacion!=null &&
              this.tipoRelacion.equals(other.getTipoRelacion()))) &&
            ((this.desde==null && other.getDesde()==null) || 
             (this.desde!=null &&
              this.desde.equals(other.getDesde()))) &&
            ((this.hasta==null && other.getHasta()==null) || 
             (this.hasta!=null &&
              this.hasta.equals(other.getHasta())));
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
        _hashCode += getIdViaje1();
        _hashCode += getIdViaje2();
        if (getTipoRelacion() != null) {
            _hashCode += getTipoRelacion().hashCode();
        }
        if (getDesde() != null) {
            _hashCode += getDesde().hashCode();
        }
        if (getHasta() != null) {
            _hashCode += getHasta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RelacionarViajes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">RelacionarViajes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoRelacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoRelacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "desde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "hasta"));
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
