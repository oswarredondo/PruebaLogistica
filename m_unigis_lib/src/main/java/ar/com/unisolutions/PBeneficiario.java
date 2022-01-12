/**
 * PBeneficiario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PBeneficiario  implements java.io.Serializable {
    private java.lang.String referenciaExternaTransporte;

    private java.lang.String nombreBeneficiario;

    private java.lang.String referenciaExternaBeneficiario;

    public PBeneficiario() {
    }

    public PBeneficiario(
           java.lang.String referenciaExternaTransporte,
           java.lang.String nombreBeneficiario,
           java.lang.String referenciaExternaBeneficiario) {
           this.referenciaExternaTransporte = referenciaExternaTransporte;
           this.nombreBeneficiario = nombreBeneficiario;
           this.referenciaExternaBeneficiario = referenciaExternaBeneficiario;
    }


    /**
     * Gets the referenciaExternaTransporte value for this PBeneficiario.
     * 
     * @return referenciaExternaTransporte
     */
    public java.lang.String getReferenciaExternaTransporte() {
        return referenciaExternaTransporte;
    }


    /**
     * Sets the referenciaExternaTransporte value for this PBeneficiario.
     * 
     * @param referenciaExternaTransporte
     */
    public void setReferenciaExternaTransporte(java.lang.String referenciaExternaTransporte) {
        this.referenciaExternaTransporte = referenciaExternaTransporte;
    }


    /**
     * Gets the nombreBeneficiario value for this PBeneficiario.
     * 
     * @return nombreBeneficiario
     */
    public java.lang.String getNombreBeneficiario() {
        return nombreBeneficiario;
    }


    /**
     * Sets the nombreBeneficiario value for this PBeneficiario.
     * 
     * @param nombreBeneficiario
     */
    public void setNombreBeneficiario(java.lang.String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }


    /**
     * Gets the referenciaExternaBeneficiario value for this PBeneficiario.
     * 
     * @return referenciaExternaBeneficiario
     */
    public java.lang.String getReferenciaExternaBeneficiario() {
        return referenciaExternaBeneficiario;
    }


    /**
     * Sets the referenciaExternaBeneficiario value for this PBeneficiario.
     * 
     * @param referenciaExternaBeneficiario
     */
    public void setReferenciaExternaBeneficiario(java.lang.String referenciaExternaBeneficiario) {
        this.referenciaExternaBeneficiario = referenciaExternaBeneficiario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PBeneficiario)) return false;
        PBeneficiario other = (PBeneficiario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.referenciaExternaTransporte==null && other.getReferenciaExternaTransporte()==null) || 
             (this.referenciaExternaTransporte!=null &&
              this.referenciaExternaTransporte.equals(other.getReferenciaExternaTransporte()))) &&
            ((this.nombreBeneficiario==null && other.getNombreBeneficiario()==null) || 
             (this.nombreBeneficiario!=null &&
              this.nombreBeneficiario.equals(other.getNombreBeneficiario()))) &&
            ((this.referenciaExternaBeneficiario==null && other.getReferenciaExternaBeneficiario()==null) || 
             (this.referenciaExternaBeneficiario!=null &&
              this.referenciaExternaBeneficiario.equals(other.getReferenciaExternaBeneficiario())));
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
        if (getReferenciaExternaTransporte() != null) {
            _hashCode += getReferenciaExternaTransporte().hashCode();
        }
        if (getNombreBeneficiario() != null) {
            _hashCode += getNombreBeneficiario().hashCode();
        }
        if (getReferenciaExternaBeneficiario() != null) {
            _hashCode += getReferenciaExternaBeneficiario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PBeneficiario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pBeneficiario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExternaTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "NombreBeneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExternaBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaBeneficiario"));
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
