/**
 * ConsultarViajeReferenciaExternaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajeReferenciaExternaResponse  implements java.io.Serializable {
    private ar.com.unisolutions.ConsultarViajeResultado[] consultarViajeReferenciaExternaResult;

    public ConsultarViajeReferenciaExternaResponse() {
    }

    public ConsultarViajeReferenciaExternaResponse(
           ar.com.unisolutions.ConsultarViajeResultado[] consultarViajeReferenciaExternaResult) {
           this.consultarViajeReferenciaExternaResult = consultarViajeReferenciaExternaResult;
    }


    /**
     * Gets the consultarViajeReferenciaExternaResult value for this ConsultarViajeReferenciaExternaResponse.
     * 
     * @return consultarViajeReferenciaExternaResult
     */
    public ar.com.unisolutions.ConsultarViajeResultado[] getConsultarViajeReferenciaExternaResult() {
        return consultarViajeReferenciaExternaResult;
    }


    /**
     * Sets the consultarViajeReferenciaExternaResult value for this ConsultarViajeReferenciaExternaResponse.
     * 
     * @param consultarViajeReferenciaExternaResult
     */
    public void setConsultarViajeReferenciaExternaResult(ar.com.unisolutions.ConsultarViajeResultado[] consultarViajeReferenciaExternaResult) {
        this.consultarViajeReferenciaExternaResult = consultarViajeReferenciaExternaResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajeReferenciaExternaResponse)) return false;
        ConsultarViajeReferenciaExternaResponse other = (ConsultarViajeReferenciaExternaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarViajeReferenciaExternaResult==null && other.getConsultarViajeReferenciaExternaResult()==null) || 
             (this.consultarViajeReferenciaExternaResult!=null &&
              java.util.Arrays.equals(this.consultarViajeReferenciaExternaResult, other.getConsultarViajeReferenciaExternaResult())));
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
        if (getConsultarViajeReferenciaExternaResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConsultarViajeReferenciaExternaResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConsultarViajeReferenciaExternaResult(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarViajeReferenciaExternaResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajeReferenciaExternaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarViajeReferenciaExternaResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeReferenciaExternaResult"));
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
