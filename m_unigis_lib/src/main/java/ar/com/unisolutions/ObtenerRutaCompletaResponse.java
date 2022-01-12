/**
 * ObtenerRutaCompletaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerRutaCompletaResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PRuta obtenerRutaCompletaResult;

    public ObtenerRutaCompletaResponse() {
    }

    public ObtenerRutaCompletaResponse(
           ar.com.unisolutions.PRuta obtenerRutaCompletaResult) {
           this.obtenerRutaCompletaResult = obtenerRutaCompletaResult;
    }


    /**
     * Gets the obtenerRutaCompletaResult value for this ObtenerRutaCompletaResponse.
     * 
     * @return obtenerRutaCompletaResult
     */
    public ar.com.unisolutions.PRuta getObtenerRutaCompletaResult() {
        return obtenerRutaCompletaResult;
    }


    /**
     * Sets the obtenerRutaCompletaResult value for this ObtenerRutaCompletaResponse.
     * 
     * @param obtenerRutaCompletaResult
     */
    public void setObtenerRutaCompletaResult(ar.com.unisolutions.PRuta obtenerRutaCompletaResult) {
        this.obtenerRutaCompletaResult = obtenerRutaCompletaResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerRutaCompletaResponse)) return false;
        ObtenerRutaCompletaResponse other = (ObtenerRutaCompletaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerRutaCompletaResult==null && other.getObtenerRutaCompletaResult()==null) || 
             (this.obtenerRutaCompletaResult!=null &&
              this.obtenerRutaCompletaResult.equals(other.getObtenerRutaCompletaResult())));
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
        if (getObtenerRutaCompletaResult() != null) {
            _hashCode += getObtenerRutaCompletaResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerRutaCompletaResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerRutaCompletaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerRutaCompletaResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerRutaCompletaResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
