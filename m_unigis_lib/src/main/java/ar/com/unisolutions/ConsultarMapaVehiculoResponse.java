/**
 * ConsultarMapaVehiculoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarMapaVehiculoResponse  implements java.io.Serializable {
    private ar.com.unisolutions.ConsultarMapaVehiculoResultado consultarMapaVehiculoResult;

    public ConsultarMapaVehiculoResponse() {
    }

    public ConsultarMapaVehiculoResponse(
           ar.com.unisolutions.ConsultarMapaVehiculoResultado consultarMapaVehiculoResult) {
           this.consultarMapaVehiculoResult = consultarMapaVehiculoResult;
    }


    /**
     * Gets the consultarMapaVehiculoResult value for this ConsultarMapaVehiculoResponse.
     * 
     * @return consultarMapaVehiculoResult
     */
    public ar.com.unisolutions.ConsultarMapaVehiculoResultado getConsultarMapaVehiculoResult() {
        return consultarMapaVehiculoResult;
    }


    /**
     * Sets the consultarMapaVehiculoResult value for this ConsultarMapaVehiculoResponse.
     * 
     * @param consultarMapaVehiculoResult
     */
    public void setConsultarMapaVehiculoResult(ar.com.unisolutions.ConsultarMapaVehiculoResultado consultarMapaVehiculoResult) {
        this.consultarMapaVehiculoResult = consultarMapaVehiculoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarMapaVehiculoResponse)) return false;
        ConsultarMapaVehiculoResponse other = (ConsultarMapaVehiculoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarMapaVehiculoResult==null && other.getConsultarMapaVehiculoResult()==null) || 
             (this.consultarMapaVehiculoResult!=null &&
              this.consultarMapaVehiculoResult.equals(other.getConsultarMapaVehiculoResult())));
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
        if (getConsultarMapaVehiculoResult() != null) {
            _hashCode += getConsultarMapaVehiculoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarMapaVehiculoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarMapaVehiculoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarMapaVehiculoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResultado"));
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
