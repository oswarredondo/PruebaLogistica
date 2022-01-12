/**
 * PTipoUnidadContenedora.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PTipoUnidadContenedora  implements java.io.Serializable {
    private java.lang.String referenciaExterna;

    private java.lang.String descripcion;

    private java.lang.Double pesoMaximo;

    private java.lang.Double volumenMaximo;

    private java.lang.Double bultosMaximo;

    private java.lang.Double peso;

    private java.lang.Double alto;

    private java.lang.Double ancho;

    private java.lang.Double profundidad;

    public PTipoUnidadContenedora() {
    }

    public PTipoUnidadContenedora(
           java.lang.String referenciaExterna,
           java.lang.String descripcion,
           java.lang.Double pesoMaximo,
           java.lang.Double volumenMaximo,
           java.lang.Double bultosMaximo,
           java.lang.Double peso,
           java.lang.Double alto,
           java.lang.Double ancho,
           java.lang.Double profundidad) {
           this.referenciaExterna = referenciaExterna;
           this.descripcion = descripcion;
           this.pesoMaximo = pesoMaximo;
           this.volumenMaximo = volumenMaximo;
           this.bultosMaximo = bultosMaximo;
           this.peso = peso;
           this.alto = alto;
           this.ancho = ancho;
           this.profundidad = profundidad;
    }


    /**
     * Gets the referenciaExterna value for this PTipoUnidadContenedora.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this PTipoUnidadContenedora.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the descripcion value for this PTipoUnidadContenedora.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PTipoUnidadContenedora.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the pesoMaximo value for this PTipoUnidadContenedora.
     * 
     * @return pesoMaximo
     */
    public java.lang.Double getPesoMaximo() {
        return pesoMaximo;
    }


    /**
     * Sets the pesoMaximo value for this PTipoUnidadContenedora.
     * 
     * @param pesoMaximo
     */
    public void setPesoMaximo(java.lang.Double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }


    /**
     * Gets the volumenMaximo value for this PTipoUnidadContenedora.
     * 
     * @return volumenMaximo
     */
    public java.lang.Double getVolumenMaximo() {
        return volumenMaximo;
    }


    /**
     * Sets the volumenMaximo value for this PTipoUnidadContenedora.
     * 
     * @param volumenMaximo
     */
    public void setVolumenMaximo(java.lang.Double volumenMaximo) {
        this.volumenMaximo = volumenMaximo;
    }


    /**
     * Gets the bultosMaximo value for this PTipoUnidadContenedora.
     * 
     * @return bultosMaximo
     */
    public java.lang.Double getBultosMaximo() {
        return bultosMaximo;
    }


    /**
     * Sets the bultosMaximo value for this PTipoUnidadContenedora.
     * 
     * @param bultosMaximo
     */
    public void setBultosMaximo(java.lang.Double bultosMaximo) {
        this.bultosMaximo = bultosMaximo;
    }


    /**
     * Gets the peso value for this PTipoUnidadContenedora.
     * 
     * @return peso
     */
    public java.lang.Double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this PTipoUnidadContenedora.
     * 
     * @param peso
     */
    public void setPeso(java.lang.Double peso) {
        this.peso = peso;
    }


    /**
     * Gets the alto value for this PTipoUnidadContenedora.
     * 
     * @return alto
     */
    public java.lang.Double getAlto() {
        return alto;
    }


    /**
     * Sets the alto value for this PTipoUnidadContenedora.
     * 
     * @param alto
     */
    public void setAlto(java.lang.Double alto) {
        this.alto = alto;
    }


    /**
     * Gets the ancho value for this PTipoUnidadContenedora.
     * 
     * @return ancho
     */
    public java.lang.Double getAncho() {
        return ancho;
    }


    /**
     * Sets the ancho value for this PTipoUnidadContenedora.
     * 
     * @param ancho
     */
    public void setAncho(java.lang.Double ancho) {
        this.ancho = ancho;
    }


    /**
     * Gets the profundidad value for this PTipoUnidadContenedora.
     * 
     * @return profundidad
     */
    public java.lang.Double getProfundidad() {
        return profundidad;
    }


    /**
     * Sets the profundidad value for this PTipoUnidadContenedora.
     * 
     * @param profundidad
     */
    public void setProfundidad(java.lang.Double profundidad) {
        this.profundidad = profundidad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTipoUnidadContenedora)) return false;
        PTipoUnidadContenedora other = (PTipoUnidadContenedora) obj;
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
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.pesoMaximo==null && other.getPesoMaximo()==null) || 
             (this.pesoMaximo!=null &&
              this.pesoMaximo.equals(other.getPesoMaximo()))) &&
            ((this.volumenMaximo==null && other.getVolumenMaximo()==null) || 
             (this.volumenMaximo!=null &&
              this.volumenMaximo.equals(other.getVolumenMaximo()))) &&
            ((this.bultosMaximo==null && other.getBultosMaximo()==null) || 
             (this.bultosMaximo!=null &&
              this.bultosMaximo.equals(other.getBultosMaximo()))) &&
            ((this.peso==null && other.getPeso()==null) || 
             (this.peso!=null &&
              this.peso.equals(other.getPeso()))) &&
            ((this.alto==null && other.getAlto()==null) || 
             (this.alto!=null &&
              this.alto.equals(other.getAlto()))) &&
            ((this.ancho==null && other.getAncho()==null) || 
             (this.ancho!=null &&
              this.ancho.equals(other.getAncho()))) &&
            ((this.profundidad==null && other.getProfundidad()==null) || 
             (this.profundidad!=null &&
              this.profundidad.equals(other.getProfundidad())));
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getPesoMaximo() != null) {
            _hashCode += getPesoMaximo().hashCode();
        }
        if (getVolumenMaximo() != null) {
            _hashCode += getVolumenMaximo().hashCode();
        }
        if (getBultosMaximo() != null) {
            _hashCode += getBultosMaximo().hashCode();
        }
        if (getPeso() != null) {
            _hashCode += getPeso().hashCode();
        }
        if (getAlto() != null) {
            _hashCode += getAlto().hashCode();
        }
        if (getAncho() != null) {
            _hashCode += getAncho().hashCode();
        }
        if (getProfundidad() != null) {
            _hashCode += getProfundidad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTipoUnidadContenedora.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTipoUnidadContenedora"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoMaximo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PesoMaximo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volumenMaximo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VolumenMaximo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bultosMaximo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "BultosMaximo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Peso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Alto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ancho");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ancho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profundidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Profundidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
