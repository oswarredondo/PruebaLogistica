/**
 * ZsdAuart.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mc_style.functions.soap.sap.document.sap_com;

public class ZsdAuart  implements java.io.Serializable {
    private java.lang.String auart;

    private java.lang.String bezei;

    public ZsdAuart() {
    }

    public ZsdAuart(
           java.lang.String auart,
           java.lang.String bezei) {
           this.auart = auart;
           this.bezei = bezei;
    }


    /**
     * Gets the auart value for this ZsdAuart.
     * 
     * @return auart
     */
    public java.lang.String getAuart() {
        return auart;
    }


    /**
     * Sets the auart value for this ZsdAuart.
     * 
     * @param auart
     */
    public void setAuart(java.lang.String auart) {
        this.auart = auart;
    }


    /**
     * Gets the bezei value for this ZsdAuart.
     * 
     * @return bezei
     */
    public java.lang.String getBezei() {
        return bezei;
    }


    /**
     * Sets the bezei value for this ZsdAuart.
     * 
     * @param bezei
     */
    public void setBezei(java.lang.String bezei) {
        this.bezei = bezei;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZsdAuart)) return false;
        ZsdAuart other = (ZsdAuart) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.auart==null && other.getAuart()==null) || 
             (this.auart!=null &&
              this.auart.equals(other.getAuart()))) &&
            ((this.bezei==null && other.getBezei()==null) || 
             (this.bezei!=null &&
              this.bezei.equals(other.getBezei())));
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
        if (getAuart() != null) {
            _hashCode += getAuart().hashCode();
        }
        if (getBezei() != null) {
            _hashCode += getBezei().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZsdAuart.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZsdAuart"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Auart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bezei");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Bezei"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
