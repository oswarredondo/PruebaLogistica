/**
 * PPregunta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PPregunta  implements java.io.Serializable {
    private java.lang.String pregunta;

    private java.lang.String respuesta;

    private java.lang.String observaciones;

    private ar.com.unisolutions.PArchivo[] fotos;

    public PPregunta() {
    }

    public PPregunta(
           java.lang.String pregunta,
           java.lang.String respuesta,
           java.lang.String observaciones,
           ar.com.unisolutions.PArchivo[] fotos) {
           this.pregunta = pregunta;
           this.respuesta = respuesta;
           this.observaciones = observaciones;
           this.fotos = fotos;
    }


    /**
     * Gets the pregunta value for this PPregunta.
     * 
     * @return pregunta
     */
    public java.lang.String getPregunta() {
        return pregunta;
    }


    /**
     * Sets the pregunta value for this PPregunta.
     * 
     * @param pregunta
     */
    public void setPregunta(java.lang.String pregunta) {
        this.pregunta = pregunta;
    }


    /**
     * Gets the respuesta value for this PPregunta.
     * 
     * @return respuesta
     */
    public java.lang.String getRespuesta() {
        return respuesta;
    }


    /**
     * Sets the respuesta value for this PPregunta.
     * 
     * @param respuesta
     */
    public void setRespuesta(java.lang.String respuesta) {
        this.respuesta = respuesta;
    }


    /**
     * Gets the observaciones value for this PPregunta.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PPregunta.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the fotos value for this PPregunta.
     * 
     * @return fotos
     */
    public ar.com.unisolutions.PArchivo[] getFotos() {
        return fotos;
    }


    /**
     * Sets the fotos value for this PPregunta.
     * 
     * @param fotos
     */
    public void setFotos(ar.com.unisolutions.PArchivo[] fotos) {
        this.fotos = fotos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PPregunta)) return false;
        PPregunta other = (PPregunta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pregunta==null && other.getPregunta()==null) || 
             (this.pregunta!=null &&
              this.pregunta.equals(other.getPregunta()))) &&
            ((this.respuesta==null && other.getRespuesta()==null) || 
             (this.respuesta!=null &&
              this.respuesta.equals(other.getRespuesta()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            ((this.fotos==null && other.getFotos()==null) || 
             (this.fotos!=null &&
              java.util.Arrays.equals(this.fotos, other.getFotos())));
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
        if (getPregunta() != null) {
            _hashCode += getPregunta().hashCode();
        }
        if (getRespuesta() != null) {
            _hashCode += getRespuesta().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        if (getFotos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFotos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFotos(), i);
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
        new org.apache.axis.description.TypeDesc(PPregunta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPregunta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pregunta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pregunta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Respuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fotos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fotos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivo"));
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
