/**
 * AgregarEncuestasResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class AgregarEncuestasResponse  implements java.io.Serializable {
    private ar.com.unisolutions.BooleanResponse agregarEncuestasResult;

    public AgregarEncuestasResponse() {
    }

    public AgregarEncuestasResponse(
           ar.com.unisolutions.BooleanResponse agregarEncuestasResult) {
           this.agregarEncuestasResult = agregarEncuestasResult;
    }


    /**
     * Gets the agregarEncuestasResult value for this AgregarEncuestasResponse.
     * 
     * @return agregarEncuestasResult
     */
    public ar.com.unisolutions.BooleanResponse getAgregarEncuestasResult() {
        return agregarEncuestasResult;
    }


    /**
     * Sets the agregarEncuestasResult value for this AgregarEncuestasResponse.
     * 
     * @param agregarEncuestasResult
     */
    public void setAgregarEncuestasResult(ar.com.unisolutions.BooleanResponse agregarEncuestasResult) {
        this.agregarEncuestasResult = agregarEncuestasResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgregarEncuestasResponse)) return false;
        AgregarEncuestasResponse other = (AgregarEncuestasResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agregarEncuestasResult==null && other.getAgregarEncuestasResult()==null) || 
             (this.agregarEncuestasResult!=null &&
              this.agregarEncuestasResult.equals(other.getAgregarEncuestasResult())));
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
        if (getAgregarEncuestasResult() != null) {
            _hashCode += getAgregarEncuestasResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgregarEncuestasResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">AgregarEncuestasResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agregarEncuestasResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AgregarEncuestasResult"));
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
