/**
 * ConsultarViajeResponseType2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajeResponseType2  implements java.io.Serializable {
    private ar.com.unisolutions.ConsultarViajeResultado consultarViajeResult;

    public ConsultarViajeResponseType2() {
    }

    public ConsultarViajeResponseType2(
           ar.com.unisolutions.ConsultarViajeResultado consultarViajeResult) {
           this.consultarViajeResult = consultarViajeResult;
    }


    /**
     * Gets the consultarViajeResult value for this ConsultarViajeResponseType2.
     * 
     * @return consultarViajeResult
     */
    public ar.com.unisolutions.ConsultarViajeResultado getConsultarViajeResult() {
        return consultarViajeResult;
    }


    /**
     * Sets the consultarViajeResult value for this ConsultarViajeResponseType2.
     * 
     * @param consultarViajeResult
     */
    public void setConsultarViajeResult(ar.com.unisolutions.ConsultarViajeResultado consultarViajeResult) {
        this.consultarViajeResult = consultarViajeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajeResponseType2)) return false;
        ConsultarViajeResponseType2 other = (ConsultarViajeResponseType2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarViajeResult==null && other.getConsultarViajeResult()==null) || 
             (this.consultarViajeResult!=null &&
              this.consultarViajeResult.equals(other.getConsultarViajeResult())));
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
        if (getConsultarViajeResult() != null) {
            _hashCode += getConsultarViajeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarViajeResponseType2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarViajeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado"));
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
