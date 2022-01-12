/**
 * ObtenerEstadiasResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerEstadiasResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PEstadiaParada[] obtenerEstadiasResult;

    public ObtenerEstadiasResponse() {
    }

    public ObtenerEstadiasResponse(
           ar.com.unisolutions.PEstadiaParada[] obtenerEstadiasResult) {
           this.obtenerEstadiasResult = obtenerEstadiasResult;
    }


    /**
     * Gets the obtenerEstadiasResult value for this ObtenerEstadiasResponse.
     * 
     * @return obtenerEstadiasResult
     */
    public ar.com.unisolutions.PEstadiaParada[] getObtenerEstadiasResult() {
        return obtenerEstadiasResult;
    }


    /**
     * Sets the obtenerEstadiasResult value for this ObtenerEstadiasResponse.
     * 
     * @param obtenerEstadiasResult
     */
    public void setObtenerEstadiasResult(ar.com.unisolutions.PEstadiaParada[] obtenerEstadiasResult) {
        this.obtenerEstadiasResult = obtenerEstadiasResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerEstadiasResponse)) return false;
        ObtenerEstadiasResponse other = (ObtenerEstadiasResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerEstadiasResult==null && other.getObtenerEstadiasResult()==null) || 
             (this.obtenerEstadiasResult!=null &&
              java.util.Arrays.equals(this.obtenerEstadiasResult, other.getObtenerEstadiasResult())));
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
        if (getObtenerEstadiasResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerEstadiasResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerEstadiasResult(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerEstadiasResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerEstadiasResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerEstadiasResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerEstadiasResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParada"));
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
