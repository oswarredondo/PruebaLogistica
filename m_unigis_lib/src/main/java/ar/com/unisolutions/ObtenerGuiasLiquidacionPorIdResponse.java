/**
 * ObtenerGuiasLiquidacionPorIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerGuiasLiquidacionPorIdResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionPorIdResult;

    public ObtenerGuiasLiquidacionPorIdResponse() {
    }

    public ObtenerGuiasLiquidacionPorIdResponse(
           ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionPorIdResult) {
           this.obtenerGuiasLiquidacionPorIdResult = obtenerGuiasLiquidacionPorIdResult;
    }


    /**
     * Gets the obtenerGuiasLiquidacionPorIdResult value for this ObtenerGuiasLiquidacionPorIdResponse.
     * 
     * @return obtenerGuiasLiquidacionPorIdResult
     */
    public ar.com.unisolutions.PGuiaLiquidacion[] getObtenerGuiasLiquidacionPorIdResult() {
        return obtenerGuiasLiquidacionPorIdResult;
    }


    /**
     * Sets the obtenerGuiasLiquidacionPorIdResult value for this ObtenerGuiasLiquidacionPorIdResponse.
     * 
     * @param obtenerGuiasLiquidacionPorIdResult
     */
    public void setObtenerGuiasLiquidacionPorIdResult(ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionPorIdResult) {
        this.obtenerGuiasLiquidacionPorIdResult = obtenerGuiasLiquidacionPorIdResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerGuiasLiquidacionPorIdResponse)) return false;
        ObtenerGuiasLiquidacionPorIdResponse other = (ObtenerGuiasLiquidacionPorIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerGuiasLiquidacionPorIdResult==null && other.getObtenerGuiasLiquidacionPorIdResult()==null) || 
             (this.obtenerGuiasLiquidacionPorIdResult!=null &&
              java.util.Arrays.equals(this.obtenerGuiasLiquidacionPorIdResult, other.getObtenerGuiasLiquidacionPorIdResult())));
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
        if (getObtenerGuiasLiquidacionPorIdResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerGuiasLiquidacionPorIdResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerGuiasLiquidacionPorIdResult(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerGuiasLiquidacionPorIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacionPorIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerGuiasLiquidacionPorIdResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacionPorIdResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
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
