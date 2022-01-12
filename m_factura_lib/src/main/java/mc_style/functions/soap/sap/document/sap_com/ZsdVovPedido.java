/**
 * ZsdVovPedido.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mc_style.functions.soap.sap.document.sap_com;

public class ZsdVovPedido  implements java.io.Serializable {
    private java.lang.String posnr;

    private java.lang.String matnr;

    private java.lang.String zmeng;

    private java.lang.String zieme;

    private java.lang.String prctr;

    private java.lang.String netpr;

    public ZsdVovPedido() {
    }

    public ZsdVovPedido(
           java.lang.String posnr,
           java.lang.String matnr,
           java.lang.String zmeng,
           java.lang.String zieme,
           java.lang.String prctr,
           java.lang.String netpr) {
           this.posnr = posnr;
           this.matnr = matnr;
           this.zmeng = zmeng;
           this.zieme = zieme;
           this.prctr = prctr;
           this.netpr = netpr;
    }


    /**
     * Gets the posnr value for this ZsdVovPedido.
     * 
     * @return posnr
     */
    public java.lang.String getPosnr() {
        return posnr;
    }


    /**
     * Sets the posnr value for this ZsdVovPedido.
     * 
     * @param posnr
     */
    public void setPosnr(java.lang.String posnr) {
        this.posnr = posnr;
    }


    /**
     * Gets the matnr value for this ZsdVovPedido.
     * 
     * @return matnr
     */
    public java.lang.String getMatnr() {
        return matnr;
    }


    /**
     * Sets the matnr value for this ZsdVovPedido.
     * 
     * @param matnr
     */
    public void setMatnr(java.lang.String matnr) {
        this.matnr = matnr;
    }


    /**
     * Gets the zmeng value for this ZsdVovPedido.
     * 
     * @return zmeng
     */
    public java.lang.String getZmeng() {
        return zmeng;
    }


    /**
     * Sets the zmeng value for this ZsdVovPedido.
     * 
     * @param zmeng
     */
    public void setZmeng(java.lang.String zmeng) {
        this.zmeng = zmeng;
    }


    /**
     * Gets the zieme value for this ZsdVovPedido.
     * 
     * @return zieme
     */
    public java.lang.String getZieme() {
        return zieme;
    }


    /**
     * Sets the zieme value for this ZsdVovPedido.
     * 
     * @param zieme
     */
    public void setZieme(java.lang.String zieme) {
        this.zieme = zieme;
    }


    /**
     * Gets the prctr value for this ZsdVovPedido.
     * 
     * @return prctr
     */
    public java.lang.String getPrctr() {
        return prctr;
    }


    /**
     * Sets the prctr value for this ZsdVovPedido.
     * 
     * @param prctr
     */
    public void setPrctr(java.lang.String prctr) {
        this.prctr = prctr;
    }


    /**
     * Gets the netpr value for this ZsdVovPedido.
     * 
     * @return netpr
     */
    public java.lang.String getNetpr() {
        return netpr;
    }


    /**
     * Sets the netpr value for this ZsdVovPedido.
     * 
     * @param netpr
     */
    public void setNetpr(java.lang.String netpr) {
        this.netpr = netpr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZsdVovPedido)) return false;
        ZsdVovPedido other = (ZsdVovPedido) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.posnr==null && other.getPosnr()==null) || 
             (this.posnr!=null &&
              this.posnr.equals(other.getPosnr()))) &&
            ((this.matnr==null && other.getMatnr()==null) || 
             (this.matnr!=null &&
              this.matnr.equals(other.getMatnr()))) &&
            ((this.zmeng==null && other.getZmeng()==null) || 
             (this.zmeng!=null &&
              this.zmeng.equals(other.getZmeng()))) &&
            ((this.zieme==null && other.getZieme()==null) || 
             (this.zieme!=null &&
              this.zieme.equals(other.getZieme()))) &&
            ((this.prctr==null && other.getPrctr()==null) || 
             (this.prctr!=null &&
              this.prctr.equals(other.getPrctr()))) &&
            ((this.netpr==null && other.getNetpr()==null) || 
             (this.netpr!=null &&
              this.netpr.equals(other.getNetpr())));
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
        if (getPosnr() != null) {
            _hashCode += getPosnr().hashCode();
        }
        if (getMatnr() != null) {
            _hashCode += getMatnr().hashCode();
        }
        if (getZmeng() != null) {
            _hashCode += getZmeng().hashCode();
        }
        if (getZieme() != null) {
            _hashCode += getZieme().hashCode();
        }
        if (getPrctr() != null) {
            _hashCode += getPrctr().hashCode();
        }
        if (getNetpr() != null) {
            _hashCode += getNetpr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZsdVovPedido.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZsdVovPedido"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Posnr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Matnr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zmeng");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Zmeng"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zieme");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Zieme"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prctr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Prctr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netpr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Netpr"));
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
