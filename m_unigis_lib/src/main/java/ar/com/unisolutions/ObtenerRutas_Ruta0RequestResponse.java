/**
 * ObtenerRutas_Ruta0RequestResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerRutas_Ruta0RequestResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PRuta[] obtenerRutas_Ruta0RequestResult;

    public ObtenerRutas_Ruta0RequestResponse() {
    }

    public ObtenerRutas_Ruta0RequestResponse(
           ar.com.unisolutions.PRuta[] obtenerRutas_Ruta0RequestResult) {
           this.obtenerRutas_Ruta0RequestResult = obtenerRutas_Ruta0RequestResult;
    }


    /**
     * Gets the obtenerRutas_Ruta0RequestResult value for this ObtenerRutas_Ruta0RequestResponse.
     * 
     * @return obtenerRutas_Ruta0RequestResult
     */
    public ar.com.unisolutions.PRuta[] getObtenerRutas_Ruta0RequestResult() {
        return obtenerRutas_Ruta0RequestResult;
    }


    /**
     * Sets the obtenerRutas_Ruta0RequestResult value for this ObtenerRutas_Ruta0RequestResponse.
     * 
     * @param obtenerRutas_Ruta0RequestResult
     */
    public void setObtenerRutas_Ruta0RequestResult(ar.com.unisolutions.PRuta[] obtenerRutas_Ruta0RequestResult) {
        this.obtenerRutas_Ruta0RequestResult = obtenerRutas_Ruta0RequestResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerRutas_Ruta0RequestResponse)) return false;
        ObtenerRutas_Ruta0RequestResponse other = (ObtenerRutas_Ruta0RequestResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerRutas_Ruta0RequestResult==null && other.getObtenerRutas_Ruta0RequestResult()==null) || 
             (this.obtenerRutas_Ruta0RequestResult!=null &&
              java.util.Arrays.equals(this.obtenerRutas_Ruta0RequestResult, other.getObtenerRutas_Ruta0RequestResult())));
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
        if (getObtenerRutas_Ruta0RequestResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerRutas_Ruta0RequestResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerRutas_Ruta0RequestResult(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerRutas_Ruta0RequestResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutas_Ruta0RequestResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerRutas_Ruta0RequestResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutas_Ruta0RequestResult"));
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
