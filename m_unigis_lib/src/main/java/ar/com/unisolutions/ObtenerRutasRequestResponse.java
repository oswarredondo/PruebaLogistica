/**
 * ObtenerRutasRequestResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerRutasRequestResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PRuta[] obtenerRutasRequestResult;

    public ObtenerRutasRequestResponse() {
    }

    public ObtenerRutasRequestResponse(
           ar.com.unisolutions.PRuta[] obtenerRutasRequestResult) {
           this.obtenerRutasRequestResult = obtenerRutasRequestResult;
    }


    /**
     * Gets the obtenerRutasRequestResult value for this ObtenerRutasRequestResponse.
     * 
     * @return obtenerRutasRequestResult
     */
    public ar.com.unisolutions.PRuta[] getObtenerRutasRequestResult() {
        return obtenerRutasRequestResult;
    }


    /**
     * Sets the obtenerRutasRequestResult value for this ObtenerRutasRequestResponse.
     * 
     * @param obtenerRutasRequestResult
     */
    public void setObtenerRutasRequestResult(ar.com.unisolutions.PRuta[] obtenerRutasRequestResult) {
        this.obtenerRutasRequestResult = obtenerRutasRequestResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerRutasRequestResponse)) return false;
        ObtenerRutasRequestResponse other = (ObtenerRutasRequestResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerRutasRequestResult==null && other.getObtenerRutasRequestResult()==null) || 
             (this.obtenerRutasRequestResult!=null &&
              java.util.Arrays.equals(this.obtenerRutasRequestResult, other.getObtenerRutasRequestResult())));
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
        if (getObtenerRutasRequestResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerRutasRequestResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerRutasRequestResult(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerRutasRequestResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutasRequestResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerRutasRequestResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutasRequestResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"));
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
