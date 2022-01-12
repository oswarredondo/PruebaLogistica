/**
 * TestTimeZoneResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class TestTimeZoneResponse  implements java.io.Serializable {
    private java.util.Calendar testTimeZoneResult;

    public TestTimeZoneResponse() {
    }

    public TestTimeZoneResponse(
           java.util.Calendar testTimeZoneResult) {
           this.testTimeZoneResult = testTimeZoneResult;
    }


    /**
     * Gets the testTimeZoneResult value for this TestTimeZoneResponse.
     * 
     * @return testTimeZoneResult
     */
    public java.util.Calendar getTestTimeZoneResult() {
        return testTimeZoneResult;
    }


    /**
     * Sets the testTimeZoneResult value for this TestTimeZoneResponse.
     * 
     * @param testTimeZoneResult
     */
    public void setTestTimeZoneResult(java.util.Calendar testTimeZoneResult) {
        this.testTimeZoneResult = testTimeZoneResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TestTimeZoneResponse)) return false;
        TestTimeZoneResponse other = (TestTimeZoneResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.testTimeZoneResult==null && other.getTestTimeZoneResult()==null) || 
             (this.testTimeZoneResult!=null &&
              this.testTimeZoneResult.equals(other.getTestTimeZoneResult())));
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
        if (getTestTimeZoneResult() != null) {
            _hashCode += getTestTimeZoneResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TestTimeZoneResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">testTimeZoneResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testTimeZoneResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "testTimeZoneResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
