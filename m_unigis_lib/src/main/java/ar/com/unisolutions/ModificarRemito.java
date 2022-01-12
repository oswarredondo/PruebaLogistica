/**
 * ModificarRemito.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ModificarRemito  implements java.io.Serializable {
    private java.lang.String apikey;

    private ar.com.unisolutions.PClienteDador clienteDador;

    private ar.com.unisolutions.PRemito remito;

    public ModificarRemito() {
    }

    public ModificarRemito(
           java.lang.String apikey,
           ar.com.unisolutions.PClienteDador clienteDador,
           ar.com.unisolutions.PRemito remito) {
           this.apikey = apikey;
           this.clienteDador = clienteDador;
           this.remito = remito;
    }


    /**
     * Gets the apikey value for this ModificarRemito.
     * 
     * @return apikey
     */
    public java.lang.String getApikey() {
        return apikey;
    }


    /**
     * Sets the apikey value for this ModificarRemito.
     * 
     * @param apikey
     */
    public void setApikey(java.lang.String apikey) {
        this.apikey = apikey;
    }


    /**
     * Gets the clienteDador value for this ModificarRemito.
     * 
     * @return clienteDador
     */
    public ar.com.unisolutions.PClienteDador getClienteDador() {
        return clienteDador;
    }


    /**
     * Sets the clienteDador value for this ModificarRemito.
     * 
     * @param clienteDador
     */
    public void setClienteDador(ar.com.unisolutions.PClienteDador clienteDador) {
        this.clienteDador = clienteDador;
    }


    /**
     * Gets the remito value for this ModificarRemito.
     * 
     * @return remito
     */
    public ar.com.unisolutions.PRemito getRemito() {
        return remito;
    }


    /**
     * Sets the remito value for this ModificarRemito.
     * 
     * @param remito
     */
    public void setRemito(ar.com.unisolutions.PRemito remito) {
        this.remito = remito;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModificarRemito)) return false;
        ModificarRemito other = (ModificarRemito) obj;
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
            ((this.clienteDador==null && other.getClienteDador()==null) || 
             (this.clienteDador!=null &&
              this.clienteDador.equals(other.getClienteDador()))) &&
            ((this.remito==null && other.getRemito()==null) || 
             (this.remito!=null &&
              this.remito.equals(other.getRemito())));
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
        if (getClienteDador() != null) {
            _hashCode += getClienteDador().hashCode();
        }
        if (getRemito() != null) {
            _hashCode += getRemito().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModificarRemito.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarRemito"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apikey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apikey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clienteDador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "clienteDador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "remito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRemito"));
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
