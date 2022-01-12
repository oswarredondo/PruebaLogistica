/**
 * ObtenerRutasResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerRutasResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PRuta[] obtenerRutasResult;

    public ObtenerRutasResponse() {
    }

    public ObtenerRutasResponse(
           ar.com.unisolutions.PRuta[] obtenerRutasResult) {
           this.obtenerRutasResult = obtenerRutasResult;
    }


    /**
     * Gets the obtenerRutasResult value for this ObtenerRutasResponse.
     * 
     * @return obtenerRutasResult
     */
    public ar.com.unisolutions.PRuta[] getObtenerRutasResult() {
        return obtenerRutasResult;
    }


    /**
     * Sets the obtenerRutasResult value for this ObtenerRutasResponse.
     * 
     * @param obtenerRutasResult
     */
    public void setObtenerRutasResult(ar.com.unisolutions.PRuta[] obtenerRutasResult) {
        this.obtenerRutasResult = obtenerRutasResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerRutasResponse)) return false;
        ObtenerRutasResponse other = (ObtenerRutasResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerRutasResult==null && other.getObtenerRutasResult()==null) || 
             (this.obtenerRutasResult!=null &&
              java.util.Arrays.equals(this.obtenerRutasResult, other.getObtenerRutasResult())));
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
        if (getObtenerRutasResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerRutasResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerRutasResult(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerRutasResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutasResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerRutasResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutasResult"));
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
