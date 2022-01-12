/**
 * ConsultarOrdenEntregaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarOrdenEntregaResponse  implements java.io.Serializable {
    private ar.com.unisolutions.POrdenEntrega consultarOrdenEntregaResult;

    public ConsultarOrdenEntregaResponse() {
    }

    public ConsultarOrdenEntregaResponse(
           ar.com.unisolutions.POrdenEntrega consultarOrdenEntregaResult) {
           this.consultarOrdenEntregaResult = consultarOrdenEntregaResult;
    }


    /**
     * Gets the consultarOrdenEntregaResult value for this ConsultarOrdenEntregaResponse.
     * 
     * @return consultarOrdenEntregaResult
     */
    public ar.com.unisolutions.POrdenEntrega getConsultarOrdenEntregaResult() {
        return consultarOrdenEntregaResult;
    }


    /**
     * Sets the consultarOrdenEntregaResult value for this ConsultarOrdenEntregaResponse.
     * 
     * @param consultarOrdenEntregaResult
     */
    public void setConsultarOrdenEntregaResult(ar.com.unisolutions.POrdenEntrega consultarOrdenEntregaResult) {
        this.consultarOrdenEntregaResult = consultarOrdenEntregaResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarOrdenEntregaResponse)) return false;
        ConsultarOrdenEntregaResponse other = (ConsultarOrdenEntregaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarOrdenEntregaResult==null && other.getConsultarOrdenEntregaResult()==null) || 
             (this.consultarOrdenEntregaResult!=null &&
              this.consultarOrdenEntregaResult.equals(other.getConsultarOrdenEntregaResult())));
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
        if (getConsultarOrdenEntregaResult() != null) {
            _hashCode += getConsultarOrdenEntregaResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarOrdenEntregaResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarOrdenEntregaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarOrdenEntregaResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenEntregaResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
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
