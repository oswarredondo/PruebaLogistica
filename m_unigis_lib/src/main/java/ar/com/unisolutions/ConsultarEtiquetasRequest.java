/**
 * ConsultarEtiquetasRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarEtiquetasRequest  implements java.io.Serializable {
    private java.lang.Integer fromId;

    private java.util.Calendar fromDate;

    private java.util.Calendar toDate;

    public ConsultarEtiquetasRequest() {
    }

    public ConsultarEtiquetasRequest(
           java.lang.Integer fromId,
           java.util.Calendar fromDate,
           java.util.Calendar toDate) {
           this.fromId = fromId;
           this.fromDate = fromDate;
           this.toDate = toDate;
    }


    /**
     * Gets the fromId value for this ConsultarEtiquetasRequest.
     * 
     * @return fromId
     */
    public java.lang.Integer getFromId() {
        return fromId;
    }


    /**
     * Sets the fromId value for this ConsultarEtiquetasRequest.
     * 
     * @param fromId
     */
    public void setFromId(java.lang.Integer fromId) {
        this.fromId = fromId;
    }


    /**
     * Gets the fromDate value for this ConsultarEtiquetasRequest.
     * 
     * @return fromDate
     */
    public java.util.Calendar getFromDate() {
        return fromDate;
    }


    /**
     * Sets the fromDate value for this ConsultarEtiquetasRequest.
     * 
     * @param fromDate
     */
    public void setFromDate(java.util.Calendar fromDate) {
        this.fromDate = fromDate;
    }


    /**
     * Gets the toDate value for this ConsultarEtiquetasRequest.
     * 
     * @return toDate
     */
    public java.util.Calendar getToDate() {
        return toDate;
    }


    /**
     * Sets the toDate value for this ConsultarEtiquetasRequest.
     * 
     * @param toDate
     */
    public void setToDate(java.util.Calendar toDate) {
        this.toDate = toDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarEtiquetasRequest)) return false;
        ConsultarEtiquetasRequest other = (ConsultarEtiquetasRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fromId==null && other.getFromId()==null) || 
             (this.fromId!=null &&
              this.fromId.equals(other.getFromId()))) &&
            ((this.fromDate==null && other.getFromDate()==null) || 
             (this.fromDate!=null &&
              this.fromDate.equals(other.getFromDate()))) &&
            ((this.toDate==null && other.getToDate()==null) || 
             (this.toDate!=null &&
              this.toDate.equals(other.getToDate())));
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
        if (getFromId() != null) {
            _hashCode += getFromId().hashCode();
        }
        if (getFromDate() != null) {
            _hashCode += getFromDate().hashCode();
        }
        if (getToDate() != null) {
            _hashCode += getToDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarEtiquetasRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarEtiquetasRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fromId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FromId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fromDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FromDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ToDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
