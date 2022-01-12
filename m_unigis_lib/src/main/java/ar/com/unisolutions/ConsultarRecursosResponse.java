/**
 * ConsultarRecursosResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarRecursosResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PRecursoExtended[] consultarRecursosResult;

    public ConsultarRecursosResponse() {
    }

    public ConsultarRecursosResponse(
           ar.com.unisolutions.PRecursoExtended[] consultarRecursosResult) {
           this.consultarRecursosResult = consultarRecursosResult;
    }


    /**
     * Gets the consultarRecursosResult value for this ConsultarRecursosResponse.
     * 
     * @return consultarRecursosResult
     */
    public ar.com.unisolutions.PRecursoExtended[] getConsultarRecursosResult() {
        return consultarRecursosResult;
    }


    /**
     * Sets the consultarRecursosResult value for this ConsultarRecursosResponse.
     * 
     * @param consultarRecursosResult
     */
    public void setConsultarRecursosResult(ar.com.unisolutions.PRecursoExtended[] consultarRecursosResult) {
        this.consultarRecursosResult = consultarRecursosResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarRecursosResponse)) return false;
        ConsultarRecursosResponse other = (ConsultarRecursosResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarRecursosResult==null && other.getConsultarRecursosResult()==null) || 
             (this.consultarRecursosResult!=null &&
              java.util.Arrays.equals(this.consultarRecursosResult, other.getConsultarRecursosResult())));
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
        if (getConsultarRecursosResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConsultarRecursosResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConsultarRecursosResult(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarRecursosResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarRecursosResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarRecursosResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarRecursosResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoExtended"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoExtended"));
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
