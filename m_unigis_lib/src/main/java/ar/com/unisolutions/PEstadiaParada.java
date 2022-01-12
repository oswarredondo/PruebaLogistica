/**
 * PEstadiaParada.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadiaParada  implements java.io.Serializable {
    private java.lang.String referenciaExterna;

    private java.lang.String tipo;

    private java.lang.Boolean validaGeocerca;

    private java.lang.Double latitudUltimoEstado;

    private java.lang.Double longitudUltimoEstado;

    private double latitud;

    private double longitud;

    private ar.com.unisolutions.PEstadiaParadaVisita[] detalle;

    public PEstadiaParada() {
    }

    public PEstadiaParada(
           java.lang.String referenciaExterna,
           java.lang.String tipo,
           java.lang.Boolean validaGeocerca,
           java.lang.Double latitudUltimoEstado,
           java.lang.Double longitudUltimoEstado,
           double latitud,
           double longitud,
           ar.com.unisolutions.PEstadiaParadaVisita[] detalle) {
           this.referenciaExterna = referenciaExterna;
           this.tipo = tipo;
           this.validaGeocerca = validaGeocerca;
           this.latitudUltimoEstado = latitudUltimoEstado;
           this.longitudUltimoEstado = longitudUltimoEstado;
           this.latitud = latitud;
           this.longitud = longitud;
           this.detalle = detalle;
    }


    /**
     * Gets the referenciaExterna value for this PEstadiaParada.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this PEstadiaParada.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the tipo value for this PEstadiaParada.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this PEstadiaParada.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the validaGeocerca value for this PEstadiaParada.
     * 
     * @return validaGeocerca
     */
    public java.lang.Boolean getValidaGeocerca() {
        return validaGeocerca;
    }


    /**
     * Sets the validaGeocerca value for this PEstadiaParada.
     * 
     * @param validaGeocerca
     */
    public void setValidaGeocerca(java.lang.Boolean validaGeocerca) {
        this.validaGeocerca = validaGeocerca;
    }


    /**
     * Gets the latitudUltimoEstado value for this PEstadiaParada.
     * 
     * @return latitudUltimoEstado
     */
    public java.lang.Double getLatitudUltimoEstado() {
        return latitudUltimoEstado;
    }


    /**
     * Sets the latitudUltimoEstado value for this PEstadiaParada.
     * 
     * @param latitudUltimoEstado
     */
    public void setLatitudUltimoEstado(java.lang.Double latitudUltimoEstado) {
        this.latitudUltimoEstado = latitudUltimoEstado;
    }


    /**
     * Gets the longitudUltimoEstado value for this PEstadiaParada.
     * 
     * @return longitudUltimoEstado
     */
    public java.lang.Double getLongitudUltimoEstado() {
        return longitudUltimoEstado;
    }


    /**
     * Sets the longitudUltimoEstado value for this PEstadiaParada.
     * 
     * @param longitudUltimoEstado
     */
    public void setLongitudUltimoEstado(java.lang.Double longitudUltimoEstado) {
        this.longitudUltimoEstado = longitudUltimoEstado;
    }


    /**
     * Gets the latitud value for this PEstadiaParada.
     * 
     * @return latitud
     */
    public double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this PEstadiaParada.
     * 
     * @param latitud
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this PEstadiaParada.
     * 
     * @return longitud
     */
    public double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this PEstadiaParada.
     * 
     * @param longitud
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the detalle value for this PEstadiaParada.
     * 
     * @return detalle
     */
    public ar.com.unisolutions.PEstadiaParadaVisita[] getDetalle() {
        return detalle;
    }


    /**
     * Sets the detalle value for this PEstadiaParada.
     * 
     * @param detalle
     */
    public void setDetalle(ar.com.unisolutions.PEstadiaParadaVisita[] detalle) {
        this.detalle = detalle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadiaParada)) return false;
        PEstadiaParada other = (PEstadiaParada) obj;
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
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.validaGeocerca==null && other.getValidaGeocerca()==null) || 
             (this.validaGeocerca!=null &&
              this.validaGeocerca.equals(other.getValidaGeocerca()))) &&
            ((this.latitudUltimoEstado==null && other.getLatitudUltimoEstado()==null) || 
             (this.latitudUltimoEstado!=null &&
              this.latitudUltimoEstado.equals(other.getLatitudUltimoEstado()))) &&
            ((this.longitudUltimoEstado==null && other.getLongitudUltimoEstado()==null) || 
             (this.longitudUltimoEstado!=null &&
              this.longitudUltimoEstado.equals(other.getLongitudUltimoEstado()))) &&
            this.latitud == other.getLatitud() &&
            this.longitud == other.getLongitud() &&
            ((this.detalle==null && other.getDetalle()==null) || 
             (this.detalle!=null &&
              java.util.Arrays.equals(this.detalle, other.getDetalle())));
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
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getValidaGeocerca() != null) {
            _hashCode += getValidaGeocerca().hashCode();
        }
        if (getLatitudUltimoEstado() != null) {
            _hashCode += getLatitudUltimoEstado().hashCode();
        }
        if (getLongitudUltimoEstado() != null) {
            _hashCode += getLongitudUltimoEstado().hashCode();
        }
        _hashCode += new Double(getLatitud()).hashCode();
        _hashCode += new Double(getLongitud()).hashCode();
        if (getDetalle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDetalle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDetalle(), i);
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
        new org.apache.axis.description.TypeDesc(PEstadiaParada.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParada"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validaGeocerca");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValidaGeocerca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitudUltimoEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LatitudUltimoEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitudUltimoEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LongitudUltimoEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Latitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Longitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detalle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Detalle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParadaVisita"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParadaVisita"));
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
