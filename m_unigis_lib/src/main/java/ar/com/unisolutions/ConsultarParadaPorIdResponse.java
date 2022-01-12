/**
 * ConsultarParadaPorIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarParadaPorIdResponse  implements java.io.Serializable {
    private ar.com.unisolutions.ConsultarParadaResultado consultarParadaPorIdResult;

    public ConsultarParadaPorIdResponse() {
    }

    public ConsultarParadaPorIdResponse(
           ar.com.unisolutions.ConsultarParadaResultado consultarParadaPorIdResult) {
           this.consultarParadaPorIdResult = consultarParadaPorIdResult;
    }


    /**
     * Gets the consultarParadaPorIdResult value for this ConsultarParadaPorIdResponse.
     * 
     * @return consultarParadaPorIdResult
     */
    public ar.com.unisolutions.ConsultarParadaResultado getConsultarParadaPorIdResult() {
        return consultarParadaPorIdResult;
    }


    /**
     * Sets the consultarParadaPorIdResult value for this ConsultarParadaPorIdResponse.
     * 
     * @param consultarParadaPorIdResult
     */
    public void setConsultarParadaPorIdResult(ar.com.unisolutions.ConsultarParadaResultado consultarParadaPorIdResult) {
        this.consultarParadaPorIdResult = consultarParadaPorIdResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarParadaPorIdResponse)) return false;
        ConsultarParadaPorIdResponse other = (ConsultarParadaPorIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarParadaPorIdResult==null && other.getConsultarParadaPorIdResult()==null) || 
             (this.consultarParadaPorIdResult!=null &&
              this.consultarParadaPorIdResult.equals(other.getConsultarParadaPorIdResult())));
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
        if (getConsultarParadaPorIdResult() != null) {
            _hashCode += getConsultarParadaPorIdResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarParadaPorIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarParadaPorIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarParadaPorIdResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaPorIdResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultado"));
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
