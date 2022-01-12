/**
 * PEncuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEncuesta  implements java.io.Serializable {
    private int idViaje;

    private int idParada;

    private java.lang.String encuesta;

    private java.util.Calendar fecha;

    private ar.com.unisolutions.PPregunta[] preguntas;

    public PEncuesta() {
    }

    public PEncuesta(
           int idViaje,
           int idParada,
           java.lang.String encuesta,
           java.util.Calendar fecha,
           ar.com.unisolutions.PPregunta[] preguntas) {
           this.idViaje = idViaje;
           this.idParada = idParada;
           this.encuesta = encuesta;
           this.fecha = fecha;
           this.preguntas = preguntas;
    }


    /**
     * Gets the idViaje value for this PEncuesta.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PEncuesta.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the idParada value for this PEncuesta.
     * 
     * @return idParada
     */
    public int getIdParada() {
        return idParada;
    }


    /**
     * Sets the idParada value for this PEncuesta.
     * 
     * @param idParada
     */
    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }


    /**
     * Gets the encuesta value for this PEncuesta.
     * 
     * @return encuesta
     */
    public java.lang.String getEncuesta() {
        return encuesta;
    }


    /**
     * Sets the encuesta value for this PEncuesta.
     * 
     * @param encuesta
     */
    public void setEncuesta(java.lang.String encuesta) {
        this.encuesta = encuesta;
    }


    /**
     * Gets the fecha value for this PEncuesta.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this PEncuesta.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the preguntas value for this PEncuesta.
     * 
     * @return preguntas
     */
    public ar.com.unisolutions.PPregunta[] getPreguntas() {
        return preguntas;
    }


    /**
     * Sets the preguntas value for this PEncuesta.
     * 
     * @param preguntas
     */
    public void setPreguntas(ar.com.unisolutions.PPregunta[] preguntas) {
        this.preguntas = preguntas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEncuesta)) return false;
        PEncuesta other = (PEncuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idViaje == other.getIdViaje() &&
            this.idParada == other.getIdParada() &&
            ((this.encuesta==null && other.getEncuesta()==null) || 
             (this.encuesta!=null &&
              this.encuesta.equals(other.getEncuesta()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.preguntas==null && other.getPreguntas()==null) || 
             (this.preguntas!=null &&
              java.util.Arrays.equals(this.preguntas, other.getPreguntas())));
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
        _hashCode += getIdViaje();
        _hashCode += getIdParada();
        if (getEncuesta() != null) {
            _hashCode += getEncuesta().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getPreguntas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPreguntas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPreguntas(), i);
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
        new org.apache.axis.description.TypeDesc(PEncuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEncuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Encuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preguntas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Preguntas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPregunta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPregunta"));
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
