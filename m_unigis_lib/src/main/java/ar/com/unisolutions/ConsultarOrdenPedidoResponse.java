/**
 * ConsultarOrdenPedidoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarOrdenPedidoResponse  implements java.io.Serializable {
    private ar.com.unisolutions.POrdenPedido consultarOrdenPedidoResult;

    public ConsultarOrdenPedidoResponse() {
    }

    public ConsultarOrdenPedidoResponse(
           ar.com.unisolutions.POrdenPedido consultarOrdenPedidoResult) {
           this.consultarOrdenPedidoResult = consultarOrdenPedidoResult;
    }


    /**
     * Gets the consultarOrdenPedidoResult value for this ConsultarOrdenPedidoResponse.
     * 
     * @return consultarOrdenPedidoResult
     */
    public ar.com.unisolutions.POrdenPedido getConsultarOrdenPedidoResult() {
        return consultarOrdenPedidoResult;
    }


    /**
     * Sets the consultarOrdenPedidoResult value for this ConsultarOrdenPedidoResponse.
     * 
     * @param consultarOrdenPedidoResult
     */
    public void setConsultarOrdenPedidoResult(ar.com.unisolutions.POrdenPedido consultarOrdenPedidoResult) {
        this.consultarOrdenPedidoResult = consultarOrdenPedidoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarOrdenPedidoResponse)) return false;
        ConsultarOrdenPedidoResponse other = (ConsultarOrdenPedidoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarOrdenPedidoResult==null && other.getConsultarOrdenPedidoResult()==null) || 
             (this.consultarOrdenPedidoResult!=null &&
              this.consultarOrdenPedidoResult.equals(other.getConsultarOrdenPedidoResult())));
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
        if (getConsultarOrdenPedidoResult() != null) {
            _hashCode += getConsultarOrdenPedidoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarOrdenPedidoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenPedidoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarOrdenPedidoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenPedidoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido"));
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
