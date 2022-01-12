/**
 * ConsultarParadaEstadosResultado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarParadaEstadosResultado  implements java.io.Serializable {
    private java.lang.String resultado;

    private ar.com.unisolutions.PArchivosParada[] archivosParadas;

    public ConsultarParadaEstadosResultado() {
    }

    public ConsultarParadaEstadosResultado(
           java.lang.String resultado,
           ar.com.unisolutions.PArchivosParada[] archivosParadas) {
           this.resultado = resultado;
           this.archivosParadas = archivosParadas;
    }


    /**
     * Gets the resultado value for this ConsultarParadaEstadosResultado.
     * 
     * @return resultado
     */
    public java.lang.String getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this ConsultarParadaEstadosResultado.
     * 
     * @param resultado
     */
    public void setResultado(java.lang.String resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the archivosParadas value for this ConsultarParadaEstadosResultado.
     * 
     * @return archivosParadas
     */
    public ar.com.unisolutions.PArchivosParada[] getArchivosParadas() {
        return archivosParadas;
    }


    /**
     * Sets the archivosParadas value for this ConsultarParadaEstadosResultado.
     * 
     * @param archivosParadas
     */
    public void setArchivosParadas(ar.com.unisolutions.PArchivosParada[] archivosParadas) {
        this.archivosParadas = archivosParadas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarParadaEstadosResultado)) return false;
        ConsultarParadaEstadosResultado other = (ConsultarParadaEstadosResultado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            ((this.archivosParadas==null && other.getArchivosParadas()==null) || 
             (this.archivosParadas!=null &&
              java.util.Arrays.equals(this.archivosParadas, other.getArchivosParadas())));
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
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getArchivosParadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArchivosParadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArchivosParadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarParadaEstadosResultado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaEstadosResultado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archivosParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArchivosParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivosParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivosParada"));
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
