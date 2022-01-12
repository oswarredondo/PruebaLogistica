/**
 * ConsultarViajePorFechasResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajePorFechasResponse  implements java.io.Serializable {
    private ar.com.unisolutions.ConsultarViajeResultado[] consultarViajePorFechasResult;

    public ConsultarViajePorFechasResponse() {
    }

    public ConsultarViajePorFechasResponse(
           ar.com.unisolutions.ConsultarViajeResultado[] consultarViajePorFechasResult) {
           this.consultarViajePorFechasResult = consultarViajePorFechasResult;
    }


    /**
     * Gets the consultarViajePorFechasResult value for this ConsultarViajePorFechasResponse.
     * 
     * @return consultarViajePorFechasResult
     */
    public ar.com.unisolutions.ConsultarViajeResultado[] getConsultarViajePorFechasResult() {
        return consultarViajePorFechasResult;
    }


    /**
     * Sets the consultarViajePorFechasResult value for this ConsultarViajePorFechasResponse.
     * 
     * @param consultarViajePorFechasResult
     */
    public void setConsultarViajePorFechasResult(ar.com.unisolutions.ConsultarViajeResultado[] consultarViajePorFechasResult) {
        this.consultarViajePorFechasResult = consultarViajePorFechasResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajePorFechasResponse)) return false;
        ConsultarViajePorFechasResponse other = (ConsultarViajePorFechasResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarViajePorFechasResult==null && other.getConsultarViajePorFechasResult()==null) || 
             (this.consultarViajePorFechasResult!=null &&
              java.util.Arrays.equals(this.consultarViajePorFechasResult, other.getConsultarViajePorFechasResult())));
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
        if (getConsultarViajePorFechasResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConsultarViajePorFechasResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConsultarViajePorFechasResult(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarViajePorFechasResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajePorFechasResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarViajePorFechasResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajePorFechasResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado"));
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
