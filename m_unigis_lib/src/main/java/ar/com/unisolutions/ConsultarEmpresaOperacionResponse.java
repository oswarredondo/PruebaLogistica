/**
 * ConsultarEmpresaOperacionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarEmpresaOperacionResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PEmpresa consultarEmpresaOperacionResult;

    public ConsultarEmpresaOperacionResponse() {
    }

    public ConsultarEmpresaOperacionResponse(
           ar.com.unisolutions.PEmpresa consultarEmpresaOperacionResult) {
           this.consultarEmpresaOperacionResult = consultarEmpresaOperacionResult;
    }


    /**
     * Gets the consultarEmpresaOperacionResult value for this ConsultarEmpresaOperacionResponse.
     * 
     * @return consultarEmpresaOperacionResult
     */
    public ar.com.unisolutions.PEmpresa getConsultarEmpresaOperacionResult() {
        return consultarEmpresaOperacionResult;
    }


    /**
     * Sets the consultarEmpresaOperacionResult value for this ConsultarEmpresaOperacionResponse.
     * 
     * @param consultarEmpresaOperacionResult
     */
    public void setConsultarEmpresaOperacionResult(ar.com.unisolutions.PEmpresa consultarEmpresaOperacionResult) {
        this.consultarEmpresaOperacionResult = consultarEmpresaOperacionResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarEmpresaOperacionResponse)) return false;
        ConsultarEmpresaOperacionResponse other = (ConsultarEmpresaOperacionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarEmpresaOperacionResult==null && other.getConsultarEmpresaOperacionResult()==null) || 
             (this.consultarEmpresaOperacionResult!=null &&
              this.consultarEmpresaOperacionResult.equals(other.getConsultarEmpresaOperacionResult())));
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
        if (getConsultarEmpresaOperacionResult() != null) {
            _hashCode += getConsultarEmpresaOperacionResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarEmpresaOperacionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarEmpresaOperacionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarEmpresaOperacionResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEmpresaOperacionResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresa"));
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
