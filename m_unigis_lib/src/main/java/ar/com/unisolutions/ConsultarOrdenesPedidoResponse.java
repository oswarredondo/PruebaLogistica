/**
 * ConsultarOrdenesPedidoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarOrdenesPedidoResponse  implements java.io.Serializable {
    private ar.com.unisolutions.POrdenPedido[] consultarOrdenesPedidoResult;

    public ConsultarOrdenesPedidoResponse() {
    }

    public ConsultarOrdenesPedidoResponse(
           ar.com.unisolutions.POrdenPedido[] consultarOrdenesPedidoResult) {
           this.consultarOrdenesPedidoResult = consultarOrdenesPedidoResult;
    }


    /**
     * Gets the consultarOrdenesPedidoResult value for this ConsultarOrdenesPedidoResponse.
     * 
     * @return consultarOrdenesPedidoResult
     */
    public ar.com.unisolutions.POrdenPedido[] getConsultarOrdenesPedidoResult() {
        return consultarOrdenesPedidoResult;
    }


    /**
     * Sets the consultarOrdenesPedidoResult value for this ConsultarOrdenesPedidoResponse.
     * 
     * @param consultarOrdenesPedidoResult
     */
    public void setConsultarOrdenesPedidoResult(ar.com.unisolutions.POrdenPedido[] consultarOrdenesPedidoResult) {
        this.consultarOrdenesPedidoResult = consultarOrdenesPedidoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarOrdenesPedidoResponse)) return false;
        ConsultarOrdenesPedidoResponse other = (ConsultarOrdenesPedidoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarOrdenesPedidoResult==null && other.getConsultarOrdenesPedidoResult()==null) || 
             (this.consultarOrdenesPedidoResult!=null &&
              java.util.Arrays.equals(this.consultarOrdenesPedidoResult, other.getConsultarOrdenesPedidoResult())));
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
        if (getConsultarOrdenesPedidoResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConsultarOrdenesPedidoResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConsultarOrdenesPedidoResult(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarOrdenesPedidoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenesPedidoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarOrdenesPedidoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenesPedidoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido"));
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
