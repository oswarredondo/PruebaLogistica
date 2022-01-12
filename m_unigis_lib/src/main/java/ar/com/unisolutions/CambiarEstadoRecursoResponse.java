/**
 * CambiarEstadoRecursoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CambiarEstadoRecursoResponse  implements java.io.Serializable {
    private ar.com.unisolutions.BooleanResponse cambiarEstadoRecursoResult;

    public CambiarEstadoRecursoResponse() {
    }

    public CambiarEstadoRecursoResponse(
           ar.com.unisolutions.BooleanResponse cambiarEstadoRecursoResult) {
           this.cambiarEstadoRecursoResult = cambiarEstadoRecursoResult;
    }


    /**
     * Gets the cambiarEstadoRecursoResult value for this CambiarEstadoRecursoResponse.
     * 
     * @return cambiarEstadoRecursoResult
     */
    public ar.com.unisolutions.BooleanResponse getCambiarEstadoRecursoResult() {
        return cambiarEstadoRecursoResult;
    }


    /**
     * Sets the cambiarEstadoRecursoResult value for this CambiarEstadoRecursoResponse.
     * 
     * @param cambiarEstadoRecursoResult
     */
    public void setCambiarEstadoRecursoResult(ar.com.unisolutions.BooleanResponse cambiarEstadoRecursoResult) {
        this.cambiarEstadoRecursoResult = cambiarEstadoRecursoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CambiarEstadoRecursoResponse)) return false;
        CambiarEstadoRecursoResponse other = (CambiarEstadoRecursoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cambiarEstadoRecursoResult==null && other.getCambiarEstadoRecursoResult()==null) || 
             (this.cambiarEstadoRecursoResult!=null &&
              this.cambiarEstadoRecursoResult.equals(other.getCambiarEstadoRecursoResult())));
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
        if (getCambiarEstadoRecursoResult() != null) {
            _hashCode += getCambiarEstadoRecursoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CambiarEstadoRecursoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CambiarEstadoRecursoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cambiarEstadoRecursoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CambiarEstadoRecursoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "BooleanResponse"));
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
