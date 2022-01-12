/**
 * ConsultarOrdenesPedido.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarOrdenesPedido  implements java.io.Serializable {
    private ar.com.unisolutions.ConsultarOrdenesPedidoRequest request;

    public ConsultarOrdenesPedido() {
    }

    public ConsultarOrdenesPedido(
           ar.com.unisolutions.ConsultarOrdenesPedidoRequest request) {
           this.request = request;
    }


    /**
     * Gets the request value for this ConsultarOrdenesPedido.
     * 
     * @return request
     */
    public ar.com.unisolutions.ConsultarOrdenesPedidoRequest getRequest() {
        return request;
    }


    /**
     * Sets the request value for this ConsultarOrdenesPedido.
     * 
     * @param request
     */
    public void setRequest(ar.com.unisolutions.ConsultarOrdenesPedidoRequest request) {
        this.request = request;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarOrdenesPedido)) return false;
        ConsultarOrdenesPedido other = (ConsultarOrdenesPedido) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.request==null && other.getRequest()==null) || 
             (this.request!=null &&
              this.request.equals(other.getRequest())));
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
        if (getRequest() != null) {
            _hashCode += getRequest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarOrdenesPedido.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenesPedido"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("request");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "request"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenesPedidoRequest"));
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
