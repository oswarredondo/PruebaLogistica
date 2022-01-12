/**
 * ObtenerRutaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerRutaResponse  implements java.io.Serializable {
    private ar.com.unisolutions.POrdenEntrega[] obtenerRutaResult;

    public ObtenerRutaResponse() {
    }

    public ObtenerRutaResponse(
           ar.com.unisolutions.POrdenEntrega[] obtenerRutaResult) {
           this.obtenerRutaResult = obtenerRutaResult;
    }


    /**
     * Gets the obtenerRutaResult value for this ObtenerRutaResponse.
     * 
     * @return obtenerRutaResult
     */
    public ar.com.unisolutions.POrdenEntrega[] getObtenerRutaResult() {
        return obtenerRutaResult;
    }


    /**
     * Sets the obtenerRutaResult value for this ObtenerRutaResponse.
     * 
     * @param obtenerRutaResult
     */
    public void setObtenerRutaResult(ar.com.unisolutions.POrdenEntrega[] obtenerRutaResult) {
        this.obtenerRutaResult = obtenerRutaResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerRutaResponse)) return false;
        ObtenerRutaResponse other = (ObtenerRutaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerRutaResult==null && other.getObtenerRutaResult()==null) || 
             (this.obtenerRutaResult!=null &&
              java.util.Arrays.equals(this.obtenerRutaResult, other.getObtenerRutaResult())));
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
        if (getObtenerRutaResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerRutaResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerRutaResult(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerRutaResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerRutaResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutaResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
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
