/**
 * ConsultarEtiquetasResponseType1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarEtiquetasResponseType1  implements java.io.Serializable {
    private ar.com.unisolutions.ConsultarEtiquetasResponse consultarEtiquetasResult;

    public ConsultarEtiquetasResponseType1() {
    }

    public ConsultarEtiquetasResponseType1(
           ar.com.unisolutions.ConsultarEtiquetasResponse consultarEtiquetasResult) {
           this.consultarEtiquetasResult = consultarEtiquetasResult;
    }


    /**
     * Gets the consultarEtiquetasResult value for this ConsultarEtiquetasResponseType1.
     * 
     * @return consultarEtiquetasResult
     */
    public ar.com.unisolutions.ConsultarEtiquetasResponse getConsultarEtiquetasResult() {
        return consultarEtiquetasResult;
    }


    /**
     * Sets the consultarEtiquetasResult value for this ConsultarEtiquetasResponseType1.
     * 
     * @param consultarEtiquetasResult
     */
    public void setConsultarEtiquetasResult(ar.com.unisolutions.ConsultarEtiquetasResponse consultarEtiquetasResult) {
        this.consultarEtiquetasResult = consultarEtiquetasResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarEtiquetasResponseType1)) return false;
        ConsultarEtiquetasResponseType1 other = (ConsultarEtiquetasResponseType1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarEtiquetasResult==null && other.getConsultarEtiquetasResult()==null) || 
             (this.consultarEtiquetasResult!=null &&
              this.consultarEtiquetasResult.equals(other.getConsultarEtiquetasResult())));
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
        if (getConsultarEtiquetasResult() != null) {
            _hashCode += getConsultarEtiquetasResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarEtiquetasResponseType1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarEtiquetasResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarEtiquetasResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEtiquetasResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEtiquetasResponse"));
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
