/**
 * Tvkot.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Tvkot  implements java.io.Serializable {
    private java.lang.String mandt;

    private java.lang.String spras;

    private java.lang.String vkorg;

    private java.lang.String vtext;

    public Tvkot() {
    }

    public Tvkot(
           java.lang.String mandt,
           java.lang.String spras,
           java.lang.String vkorg,
           java.lang.String vtext) {
           this.mandt = mandt;
           this.spras = spras;
           this.vkorg = vkorg;
           this.vtext = vtext;
    }


    /**
     * Gets the mandt value for this Tvkot.
     * 
     * @return mandt
     */
    public java.lang.String getMandt() {
        return mandt;
    }


    /**
     * Sets the mandt value for this Tvkot.
     * 
     * @param mandt
     */
    public void setMandt(java.lang.String mandt) {
        this.mandt = mandt;
    }


    /**
     * Gets the spras value for this Tvkot.
     * 
     * @return spras
     */
    public java.lang.String getSpras() {
        return spras;
    }


    /**
     * Sets the spras value for this Tvkot.
     * 
     * @param spras
     */
    public void setSpras(java.lang.String spras) {
        this.spras = spras;
    }


    /**
     * Gets the vkorg value for this Tvkot.
     * 
     * @return vkorg
     */
    public java.lang.String getVkorg() {
        return vkorg;
    }


    /**
     * Sets the vkorg value for this Tvkot.
     * 
     * @param vkorg
     */
    public void setVkorg(java.lang.String vkorg) {
        this.vkorg = vkorg;
    }


    /**
     * Gets the vtext value for this Tvkot.
     * 
     * @return vtext
     */
    public java.lang.String getVtext() {
        return vtext;
    }


    /**
     * Sets the vtext value for this Tvkot.
     * 
     * @param vtext
     */
    public void setVtext(java.lang.String vtext) {
        this.vtext = vtext;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Tvkot)) return false;
        Tvkot other = (Tvkot) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mandt==null && other.getMandt()==null) || 
             (this.mandt!=null &&
              this.mandt.equals(other.getMandt()))) &&
            ((this.spras==null && other.getSpras()==null) || 
             (this.spras!=null &&
              this.spras.equals(other.getSpras()))) &&
            ((this.vkorg==null && other.getVkorg()==null) || 
             (this.vkorg!=null &&
              this.vkorg.equals(other.getVkorg()))) &&
            ((this.vtext==null && other.getVtext()==null) || 
             (this.vtext!=null &&
              this.vtext.equals(other.getVtext())));
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
        if (getMandt() != null) {
            _hashCode += getMandt().hashCode();
        }
        if (getSpras() != null) {
            _hashCode += getSpras().hashCode();
        }
        if (getVkorg() != null) {
            _hashCode += getVkorg().hashCode();
        }
        if (getVtext() != null) {
            _hashCode += getVtext().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Tvkot.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Tvkot"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mandt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Mandt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Spras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vkorg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Vkorg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vtext");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Vtext"));
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
