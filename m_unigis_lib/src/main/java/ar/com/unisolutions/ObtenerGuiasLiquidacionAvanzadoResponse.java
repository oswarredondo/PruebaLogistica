/**
 * ObtenerGuiasLiquidacionAvanzadoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerGuiasLiquidacionAvanzadoResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionAvanzadoResult;

    public ObtenerGuiasLiquidacionAvanzadoResponse() {
    }

    public ObtenerGuiasLiquidacionAvanzadoResponse(
           ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionAvanzadoResult) {
           this.obtenerGuiasLiquidacionAvanzadoResult = obtenerGuiasLiquidacionAvanzadoResult;
    }


    /**
     * Gets the obtenerGuiasLiquidacionAvanzadoResult value for this ObtenerGuiasLiquidacionAvanzadoResponse.
     * 
     * @return obtenerGuiasLiquidacionAvanzadoResult
     */
    public ar.com.unisolutions.PGuiaLiquidacion[] getObtenerGuiasLiquidacionAvanzadoResult() {
        return obtenerGuiasLiquidacionAvanzadoResult;
    }


    /**
     * Sets the obtenerGuiasLiquidacionAvanzadoResult value for this ObtenerGuiasLiquidacionAvanzadoResponse.
     * 
     * @param obtenerGuiasLiquidacionAvanzadoResult
     */
    public void setObtenerGuiasLiquidacionAvanzadoResult(ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionAvanzadoResult) {
        this.obtenerGuiasLiquidacionAvanzadoResult = obtenerGuiasLiquidacionAvanzadoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerGuiasLiquidacionAvanzadoResponse)) return false;
        ObtenerGuiasLiquidacionAvanzadoResponse other = (ObtenerGuiasLiquidacionAvanzadoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerGuiasLiquidacionAvanzadoResult==null && other.getObtenerGuiasLiquidacionAvanzadoResult()==null) || 
             (this.obtenerGuiasLiquidacionAvanzadoResult!=null &&
              java.util.Arrays.equals(this.obtenerGuiasLiquidacionAvanzadoResult, other.getObtenerGuiasLiquidacionAvanzadoResult())));
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
        if (getObtenerGuiasLiquidacionAvanzadoResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerGuiasLiquidacionAvanzadoResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerGuiasLiquidacionAvanzadoResult(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerGuiasLiquidacionAvanzadoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacionAvanzadoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerGuiasLiquidacionAvanzadoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacionAvanzadoResult"));
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
