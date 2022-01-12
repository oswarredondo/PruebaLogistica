/**
 * ConsultarEstadosParadasViajeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarEstadosParadasViajeResponse  implements java.io.Serializable {
    private ar.com.unisolutions.PEstadosViaje consultarEstadosParadasViajeResult;

    public ConsultarEstadosParadasViajeResponse() {
    }

    public ConsultarEstadosParadasViajeResponse(
           ar.com.unisolutions.PEstadosViaje consultarEstadosParadasViajeResult) {
           this.consultarEstadosParadasViajeResult = consultarEstadosParadasViajeResult;
    }


    /**
     * Gets the consultarEstadosParadasViajeResult value for this ConsultarEstadosParadasViajeResponse.
     * 
     * @return consultarEstadosParadasViajeResult
     */
    public ar.com.unisolutions.PEstadosViaje getConsultarEstadosParadasViajeResult() {
        return consultarEstadosParadasViajeResult;
    }


    /**
     * Sets the consultarEstadosParadasViajeResult value for this ConsultarEstadosParadasViajeResponse.
     * 
     * @param consultarEstadosParadasViajeResult
     */
    public void setConsultarEstadosParadasViajeResult(ar.com.unisolutions.PEstadosViaje consultarEstadosParadasViajeResult) {
        this.consultarEstadosParadasViajeResult = consultarEstadosParadasViajeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarEstadosParadasViajeResponse)) return false;
        ConsultarEstadosParadasViajeResponse other = (ConsultarEstadosParadasViajeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarEstadosParadasViajeResult==null && other.getConsultarEstadosParadasViajeResult()==null) || 
             (this.consultarEstadosParadasViajeResult!=null &&
              this.consultarEstadosParadasViajeResult.equals(other.getConsultarEstadosParadasViajeResult())));
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
        if (getConsultarEstadosParadasViajeResult() != null) {
            _hashCode += getConsultarEstadosParadasViajeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarEstadosParadasViajeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarEstadosParadasViajeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarEstadosParadasViajeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEstadosParadasViajeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosViaje"));
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
