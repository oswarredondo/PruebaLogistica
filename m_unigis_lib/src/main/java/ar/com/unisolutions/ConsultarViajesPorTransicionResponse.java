/**
 * ConsultarViajesPorTransicionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajesPorTransicionResponse  implements java.io.Serializable {
    private ar.com.unisolutions.ConsultarViajeResponse[] consultarViajesPorTransicionResult;

    public ConsultarViajesPorTransicionResponse() {
    }

    public ConsultarViajesPorTransicionResponse(
           ar.com.unisolutions.ConsultarViajeResponse[] consultarViajesPorTransicionResult) {
           this.consultarViajesPorTransicionResult = consultarViajesPorTransicionResult;
    }


    /**
     * Gets the consultarViajesPorTransicionResult value for this ConsultarViajesPorTransicionResponse.
     * 
     * @return consultarViajesPorTransicionResult
     */
    public ar.com.unisolutions.ConsultarViajeResponse[] getConsultarViajesPorTransicionResult() {
        return consultarViajesPorTransicionResult;
    }


    /**
     * Sets the consultarViajesPorTransicionResult value for this ConsultarViajesPorTransicionResponse.
     * 
     * @param consultarViajesPorTransicionResult
     */
    public void setConsultarViajesPorTransicionResult(ar.com.unisolutions.ConsultarViajeResponse[] consultarViajesPorTransicionResult) {
        this.consultarViajesPorTransicionResult = consultarViajesPorTransicionResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajesPorTransicionResponse)) return false;
        ConsultarViajesPorTransicionResponse other = (ConsultarViajesPorTransicionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarViajesPorTransicionResult==null && other.getConsultarViajesPorTransicionResult()==null) || 
             (this.consultarViajesPorTransicionResult!=null &&
              java.util.Arrays.equals(this.consultarViajesPorTransicionResult, other.getConsultarViajesPorTransicionResult())));
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
        if (getConsultarViajesPorTransicionResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConsultarViajesPorTransicionResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConsultarViajesPorTransicionResult(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarViajesPorTransicionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajesPorTransicionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarViajesPorTransicionResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajesPorTransicionResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResponse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResponse"));
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
