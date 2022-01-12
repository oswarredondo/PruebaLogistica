/**
 * ObtenerViajesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerViajesResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PViaje[] obtenerViajesResult;

    public ObtenerViajesResponse() {
    }

    public ObtenerViajesResponse(
           ar.com.unisolutions.PViaje[] obtenerViajesResult) {
           this.obtenerViajesResult = obtenerViajesResult;
    }


    /**
     * Gets the obtenerViajesResult value for this ObtenerViajesResponse.
     * 
     * @return obtenerViajesResult
     */
    public ar.com.unisolutions.PViaje[] getObtenerViajesResult() {
        return obtenerViajesResult;
    }


    /**
     * Sets the obtenerViajesResult value for this ObtenerViajesResponse.
     * 
     * @param obtenerViajesResult
     */
    public void setObtenerViajesResult(ar.com.unisolutions.PViaje[] obtenerViajesResult) {
        this.obtenerViajesResult = obtenerViajesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerViajesResponse)) return false;
        ObtenerViajesResponse other = (ObtenerViajesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerViajesResult==null && other.getObtenerViajesResult()==null) || 
             (this.obtenerViajesResult!=null &&
              java.util.Arrays.equals(this.obtenerViajesResult, other.getObtenerViajesResult())));
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
        if (getObtenerViajesResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerViajesResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerViajesResult(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerViajesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerViajesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerViajesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerViajesResult"));
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
