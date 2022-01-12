/**
 * ConsultarViajesPorDomicilioOrdenResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajesPorDomicilioOrdenResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PViaje[] consultarViajesPorDomicilioOrdenResult;

    public ConsultarViajesPorDomicilioOrdenResponse() {
    }

    public ConsultarViajesPorDomicilioOrdenResponse(
           ar.com.unisolutions.PViaje[] consultarViajesPorDomicilioOrdenResult) {
           this.consultarViajesPorDomicilioOrdenResult = consultarViajesPorDomicilioOrdenResult;
    }


    /**
     * Gets the consultarViajesPorDomicilioOrdenResult value for this ConsultarViajesPorDomicilioOrdenResponse.
     * 
     * @return consultarViajesPorDomicilioOrdenResult
     */
    public ar.com.unisolutions.PViaje[] getConsultarViajesPorDomicilioOrdenResult() {
        return consultarViajesPorDomicilioOrdenResult;
    }


    /**
     * Sets the consultarViajesPorDomicilioOrdenResult value for this ConsultarViajesPorDomicilioOrdenResponse.
     * 
     * @param consultarViajesPorDomicilioOrdenResult
     */
    public void setConsultarViajesPorDomicilioOrdenResult(ar.com.unisolutions.PViaje[] consultarViajesPorDomicilioOrdenResult) {
        this.consultarViajesPorDomicilioOrdenResult = consultarViajesPorDomicilioOrdenResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajesPorDomicilioOrdenResponse)) return false;
        ConsultarViajesPorDomicilioOrdenResponse other = (ConsultarViajesPorDomicilioOrdenResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarViajesPorDomicilioOrdenResult==null && other.getConsultarViajesPorDomicilioOrdenResult()==null) || 
             (this.consultarViajesPorDomicilioOrdenResult!=null &&
              java.util.Arrays.equals(this.consultarViajesPorDomicilioOrdenResult, other.getConsultarViajesPorDomicilioOrdenResult())));
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
        if (getConsultarViajesPorDomicilioOrdenResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConsultarViajesPorDomicilioOrdenResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConsultarViajesPorDomicilioOrdenResult(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarViajesPorDomicilioOrdenResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajesPorDomicilioOrdenResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarViajesPorDomicilioOrdenResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajesPorDomicilioOrdenResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"));
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
