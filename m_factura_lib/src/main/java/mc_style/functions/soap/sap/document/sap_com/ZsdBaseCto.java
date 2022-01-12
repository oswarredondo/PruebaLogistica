/**
 * ZsdBaseCto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mc_style.functions.soap.sap.document.sap_com;

public class ZsdBaseCto  implements java.io.Serializable {
    private java.lang.String vkorg;

    private java.lang.String vtweg;

    private java.lang.String vtext;

    public ZsdBaseCto() {
    }

    public ZsdBaseCto(
           java.lang.String vkorg,
           java.lang.String vtweg,
           java.lang.String vtext) {
           this.vkorg = vkorg;
           this.vtweg = vtweg;
           this.vtext = vtext;
    }


    /**
     * Gets the vkorg value for this ZsdBaseCto.
     * 
     * @return vkorg
     */
    public java.lang.String getVkorg() {
        return vkorg;
    }


    /**
     * Sets the vkorg value for this ZsdBaseCto.
     * 
     * @param vkorg
     */
    public void setVkorg(java.lang.String vkorg) {
        this.vkorg = vkorg;
    }


    /**
     * Gets the vtweg value for this ZsdBaseCto.
     * 
     * @return vtweg
     */
    public java.lang.String getVtweg() {
        return vtweg;
    }


    /**
     * Sets the vtweg value for this ZsdBaseCto.
     * 
     * @param vtweg
     */
    public void setVtweg(java.lang.String vtweg) {
        this.vtweg = vtweg;
    }


    /**
     * Gets the vtext value for this ZsdBaseCto.
     * 
     * @return vtext
     */
    public java.lang.String getVtext() {
        return vtext;
    }


    /**
     * Sets the vtext value for this ZsdBaseCto.
     * 
     * @param vtext
     */
    public void setVtext(java.lang.String vtext) {
        this.vtext = vtext;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZsdBaseCto)) return false;
        ZsdBaseCto other = (ZsdBaseCto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vkorg==null && other.getVkorg()==null) || 
             (this.vkorg!=null &&
              this.vkorg.equals(other.getVkorg()))) &&
            ((this.vtweg==null && other.getVtweg()==null) || 
             (this.vtweg!=null &&
              this.vtweg.equals(other.getVtweg()))) &&
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
        if (getVkorg() != null) {
            _hashCode += getVkorg().hashCode();
        }
        if (getVtweg() != null) {
            _hashCode += getVtweg().hashCode();
        }
        if (getVtext() != null) {
            _hashCode += getVtext().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZsdBaseCto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZsdBaseCto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vkorg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Vkorg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vtweg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Vtweg"));
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
