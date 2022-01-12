/**
 * ObtenerGuiasLiquidacion2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerGuiasLiquidacion2Response  implements java.io.Serializable {
    private ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacion2Result;

    public ObtenerGuiasLiquidacion2Response() {
    }

    public ObtenerGuiasLiquidacion2Response(
           ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacion2Result) {
           this.obtenerGuiasLiquidacion2Result = obtenerGuiasLiquidacion2Result;
    }


    /**
     * Gets the obtenerGuiasLiquidacion2Result value for this ObtenerGuiasLiquidacion2Response.
     * 
     * @return obtenerGuiasLiquidacion2Result
     */
    public ar.com.unisolutions.PGuiaLiquidacion[] getObtenerGuiasLiquidacion2Result() {
        return obtenerGuiasLiquidacion2Result;
    }


    /**
     * Sets the obtenerGuiasLiquidacion2Result value for this ObtenerGuiasLiquidacion2Response.
     * 
     * @param obtenerGuiasLiquidacion2Result
     */
    public void setObtenerGuiasLiquidacion2Result(ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacion2Result) {
        this.obtenerGuiasLiquidacion2Result = obtenerGuiasLiquidacion2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerGuiasLiquidacion2Response)) return false;
        ObtenerGuiasLiquidacion2Response other = (ObtenerGuiasLiquidacion2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerGuiasLiquidacion2Result==null && other.getObtenerGuiasLiquidacion2Result()==null) || 
             (this.obtenerGuiasLiquidacion2Result!=null &&
              java.util.Arrays.equals(this.obtenerGuiasLiquidacion2Result, other.getObtenerGuiasLiquidacion2Result())));
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
        if (getObtenerGuiasLiquidacion2Result() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObtenerGuiasLiquidacion2Result());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObtenerGuiasLiquidacion2Result(), i);
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
        new org.apache.axis.description.TypeDesc(ObtenerGuiasLiquidacion2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacion2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerGuiasLiquidacion2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ObtenerGuiasLiquidacion2Result"));
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
