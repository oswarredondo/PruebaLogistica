/**
 * ConsultarMapaVehiculoBatchResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarMapaVehiculoBatchResponse  implements java.io.Serializable {
    private ar.com.unisolutions.ConsultarMapaVehiculoResultado[] consultarMapaVehiculoBatchResult;

    public ConsultarMapaVehiculoBatchResponse() {
    }

    public ConsultarMapaVehiculoBatchResponse(
           ar.com.unisolutions.ConsultarMapaVehiculoResultado[] consultarMapaVehiculoBatchResult) {
           this.consultarMapaVehiculoBatchResult = consultarMapaVehiculoBatchResult;
    }


    /**
     * Gets the consultarMapaVehiculoBatchResult value for this ConsultarMapaVehiculoBatchResponse.
     * 
     * @return consultarMapaVehiculoBatchResult
     */
    public ar.com.unisolutions.ConsultarMapaVehiculoResultado[] getConsultarMapaVehiculoBatchResult() {
        return consultarMapaVehiculoBatchResult;
    }


    /**
     * Sets the consultarMapaVehiculoBatchResult value for this ConsultarMapaVehiculoBatchResponse.
     * 
     * @param consultarMapaVehiculoBatchResult
     */
    public void setConsultarMapaVehiculoBatchResult(ar.com.unisolutions.ConsultarMapaVehiculoResultado[] consultarMapaVehiculoBatchResult) {
        this.consultarMapaVehiculoBatchResult = consultarMapaVehiculoBatchResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarMapaVehiculoBatchResponse)) return false;
        ConsultarMapaVehiculoBatchResponse other = (ConsultarMapaVehiculoBatchResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarMapaVehiculoBatchResult==null && other.getConsultarMapaVehiculoBatchResult()==null) || 
             (this.consultarMapaVehiculoBatchResult!=null &&
              java.util.Arrays.equals(this.consultarMapaVehiculoBatchResult, other.getConsultarMapaVehiculoBatchResult())));
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
        if (getConsultarMapaVehiculoBatchResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConsultarMapaVehiculoBatchResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConsultarMapaVehiculoBatchResult(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarMapaVehiculoBatchResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarMapaVehiculoBatchResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarMapaVehiculoBatchResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoBatchResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResultado"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResultado"));
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
