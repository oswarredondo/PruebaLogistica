/**
 * ObtenerParadasResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerParadasResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PParada[] obtenerParadasResult;

    public ObtenerParadasResponse() {
    }

    public ObtenerParadasResponse(
           ar.com.unisolutions.PParada[] obtenerParadasResult) {
           this.obtenerParadasResult = obtenerParadasResult;
    }


    /**
     * Gets the obtenerParadasResult value for this ObtenerParadasResponse.
     * 
     * @return obtenerParadasResult
     */
    public ar.com.unisolutions.PParada[] getObtenerParadasResult() {
        return obtenerParadasResult;
    }


    /**
     * Sets the obtenerParadasResult value for this ObtenerParadasResponse.
     * 
     * @param obtenerParadasResult
     */
    public void setObtenerParadasResult(ar.com.unisolutions.PParada[] obtenerParadasResult) {
        this.obtenerParadasResult = obtenerParadasResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerParadasResponse)) return false;
        ObtenerParadasResponse other = (ObtenerParadasResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerParadasResult==null && other.getObtenerParadasResult()==null) || 
             (this.obtenerParadasResult!=null &&
              java.util.Arrays.equals(this.obtenerParadasResult, other.getObtenerParadasResult())));
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
        if (getObtenerParadasResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerParadasResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerParadasResult(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerParadasResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerParadasResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerParadasResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerParadasResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
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
