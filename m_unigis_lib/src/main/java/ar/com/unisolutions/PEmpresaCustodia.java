/**
 * PEmpresaCustodia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEmpresaCustodia  implements java.io.Serializable {
    private java.lang.String referenciaExterna;

    private java.lang.String razonSocial;

    private java.lang.String domicilio;

    private java.lang.String EMail;

    private java.lang.String telefono1;

    private java.lang.String telefono2;

    public PEmpresaCustodia() {
    }

    public PEmpresaCustodia(
           java.lang.String referenciaExterna,
           java.lang.String razonSocial,
           java.lang.String domicilio,
           java.lang.String EMail,
           java.lang.String telefono1,
           java.lang.String telefono2) {
           this.referenciaExterna = referenciaExterna;
           this.razonSocial = razonSocial;
           this.domicilio = domicilio;
           this.EMail = EMail;
           this.telefono1 = telefono1;
           this.telefono2 = telefono2;
    }


    /**
     * Gets the referenciaExterna value for this PEmpresaCustodia.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this PEmpresaCustodia.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the razonSocial value for this PEmpresaCustodia.
     * 
     * @return razonSocial
     */
    public java.lang.String getRazonSocial() {
        return razonSocial;
    }


    /**
     * Sets the razonSocial value for this PEmpresaCustodia.
     * 
     * @param razonSocial
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = razonSocial;
    }


    /**
     * Gets the domicilio value for this PEmpresaCustodia.
     * 
     * @return domicilio
     */
    public java.lang.String getDomicilio() {
        return domicilio;
    }


    /**
     * Sets the domicilio value for this PEmpresaCustodia.
     * 
     * @param domicilio
     */
    public void setDomicilio(java.lang.String domicilio) {
        this.domicilio = domicilio;
    }


    /**
     * Gets the EMail value for this PEmpresaCustodia.
     * 
     * @return EMail
     */
    public java.lang.String getEMail() {
        return EMail;
    }


    /**
     * Sets the EMail value for this PEmpresaCustodia.
     * 
     * @param EMail
     */
    public void setEMail(java.lang.String EMail) {
        this.EMail = EMail;
    }


    /**
     * Gets the telefono1 value for this PEmpresaCustodia.
     * 
     * @return telefono1
     */
    public java.lang.String getTelefono1() {
        return telefono1;
    }


    /**
     * Sets the telefono1 value for this PEmpresaCustodia.
     * 
     * @param telefono1
     */
    public void setTelefono1(java.lang.String telefono1) {
        this.telefono1 = telefono1;
    }


    /**
     * Gets the telefono2 value for this PEmpresaCustodia.
     * 
     * @return telefono2
     */
    public java.lang.String getTelefono2() {
        return telefono2;
    }


    /**
     * Sets the telefono2 value for this PEmpresaCustodia.
     * 
     * @param telefono2
     */
    public void setTelefono2(java.lang.String telefono2) {
        this.telefono2 = telefono2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEmpresaCustodia)) return false;
        PEmpresaCustodia other = (PEmpresaCustodia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.razonSocial==null && other.getRazonSocial()==null) || 
             (this.razonSocial!=null &&
              this.razonSocial.equals(other.getRazonSocial()))) &&
            ((this.domicilio==null && other.getDomicilio()==null) || 
             (this.domicilio!=null &&
              this.domicilio.equals(other.getDomicilio()))) &&
            ((this.EMail==null && other.getEMail()==null) || 
             (this.EMail!=null &&
              this.EMail.equals(other.getEMail()))) &&
            ((this.telefono1==null && other.getTelefono1()==null) || 
             (this.telefono1!=null &&
              this.telefono1.equals(other.getTelefono1()))) &&
            ((this.telefono2==null && other.getTelefono2()==null) || 
             (this.telefono2!=null &&
              this.telefono2.equals(other.getTelefono2())));
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
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getRazonSocial() != null) {
            _hashCode += getRazonSocial().hashCode();
        }
        if (getDomicilio() != null) {
            _hashCode += getDomicilio().hashCode();
        }
        if (getEMail() != null) {
            _hashCode += getEMail().hashCode();
        }
        if (getTelefono1() != null) {
            _hashCode += getTelefono1().hashCode();
        }
        if (getTelefono2() != null) {
            _hashCode += getTelefono2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEmpresaCustodia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresaCustodia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RazonSocial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Domicilio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EMail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Telefono1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Telefono2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
