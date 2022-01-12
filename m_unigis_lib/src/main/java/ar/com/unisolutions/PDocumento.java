/**
 * PDocumento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PDocumento  implements java.io.Serializable {
    private java.lang.String tipoDocumento;

    private java.lang.String referencia;

    private java.util.Calendar fechaEmision;

    private java.util.Calendar fechaExpiracion;

    private java.lang.String categoria;

    private java.lang.String clase;

    private java.lang.String observaciones;

    private java.lang.String referenciaEstadoDocumento;

    private java.lang.String referenciaConductor;

    private java.lang.Boolean forzarActualizacion;

    private ar.com.unisolutions.PAsociarEntidad asociaciones;

    private ar.com.unisolutions.PArchivoDoc[] archivosAsociados;

    private java.lang.Boolean crearDocumentoRequeridoViaje;

    private java.lang.Integer idViaje;

    private java.lang.Integer idParada;

    private java.lang.Boolean esDocumentoRequerido;

    public PDocumento() {
    }

    public PDocumento(
           java.lang.String tipoDocumento,
           java.lang.String referencia,
           java.util.Calendar fechaEmision,
           java.util.Calendar fechaExpiracion,
           java.lang.String categoria,
           java.lang.String clase,
           java.lang.String observaciones,
           java.lang.String referenciaEstadoDocumento,
           java.lang.String referenciaConductor,
           java.lang.Boolean forzarActualizacion,
           ar.com.unisolutions.PAsociarEntidad asociaciones,
           ar.com.unisolutions.PArchivoDoc[] archivosAsociados,
           java.lang.Boolean crearDocumentoRequeridoViaje,
           java.lang.Integer idViaje,
           java.lang.Integer idParada,
           java.lang.Boolean esDocumentoRequerido) {
           this.tipoDocumento = tipoDocumento;
           this.referencia = referencia;
           this.fechaEmision = fechaEmision;
           this.fechaExpiracion = fechaExpiracion;
           this.categoria = categoria;
           this.clase = clase;
           this.observaciones = observaciones;
           this.referenciaEstadoDocumento = referenciaEstadoDocumento;
           this.referenciaConductor = referenciaConductor;
           this.forzarActualizacion = forzarActualizacion;
           this.asociaciones = asociaciones;
           this.archivosAsociados = archivosAsociados;
           this.crearDocumentoRequeridoViaje = crearDocumentoRequeridoViaje;
           this.idViaje = idViaje;
           this.idParada = idParada;
           this.esDocumentoRequerido = esDocumentoRequerido;
    }


    /**
     * Gets the tipoDocumento value for this PDocumento.
     * 
     * @return tipoDocumento
     */
    public java.lang.String getTipoDocumento() {
        return tipoDocumento;
    }


    /**
     * Sets the tipoDocumento value for this PDocumento.
     * 
     * @param tipoDocumento
     */
    public void setTipoDocumento(java.lang.String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    /**
     * Gets the referencia value for this PDocumento.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this PDocumento.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the fechaEmision value for this PDocumento.
     * 
     * @return fechaEmision
     */
    public java.util.Calendar getFechaEmision() {
        return fechaEmision;
    }


    /**
     * Sets the fechaEmision value for this PDocumento.
     * 
     * @param fechaEmision
     */
    public void setFechaEmision(java.util.Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }


    /**
     * Gets the fechaExpiracion value for this PDocumento.
     * 
     * @return fechaExpiracion
     */
    public java.util.Calendar getFechaExpiracion() {
        return fechaExpiracion;
    }


    /**
     * Sets the fechaExpiracion value for this PDocumento.
     * 
     * @param fechaExpiracion
     */
    public void setFechaExpiracion(java.util.Calendar fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }


    /**
     * Gets the categoria value for this PDocumento.
     * 
     * @return categoria
     */
    public java.lang.String getCategoria() {
        return categoria;
    }


    /**
     * Sets the categoria value for this PDocumento.
     * 
     * @param categoria
     */
    public void setCategoria(java.lang.String categoria) {
        this.categoria = categoria;
    }


    /**
     * Gets the clase value for this PDocumento.
     * 
     * @return clase
     */
    public java.lang.String getClase() {
        return clase;
    }


    /**
     * Sets the clase value for this PDocumento.
     * 
     * @param clase
     */
    public void setClase(java.lang.String clase) {
        this.clase = clase;
    }


    /**
     * Gets the observaciones value for this PDocumento.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PDocumento.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the referenciaEstadoDocumento value for this PDocumento.
     * 
     * @return referenciaEstadoDocumento
     */
    public java.lang.String getReferenciaEstadoDocumento() {
        return referenciaEstadoDocumento;
    }


    /**
     * Sets the referenciaEstadoDocumento value for this PDocumento.
     * 
     * @param referenciaEstadoDocumento
     */
    public void setReferenciaEstadoDocumento(java.lang.String referenciaEstadoDocumento) {
        this.referenciaEstadoDocumento = referenciaEstadoDocumento;
    }


    /**
     * Gets the referenciaConductor value for this PDocumento.
     * 
     * @return referenciaConductor
     */
    public java.lang.String getReferenciaConductor() {
        return referenciaConductor;
    }


    /**
     * Sets the referenciaConductor value for this PDocumento.
     * 
     * @param referenciaConductor
     */
    public void setReferenciaConductor(java.lang.String referenciaConductor) {
        this.referenciaConductor = referenciaConductor;
    }


    /**
     * Gets the forzarActualizacion value for this PDocumento.
     * 
     * @return forzarActualizacion
     */
    public java.lang.Boolean getForzarActualizacion() {
        return forzarActualizacion;
    }


    /**
     * Sets the forzarActualizacion value for this PDocumento.
     * 
     * @param forzarActualizacion
     */
    public void setForzarActualizacion(java.lang.Boolean forzarActualizacion) {
        this.forzarActualizacion = forzarActualizacion;
    }


    /**
     * Gets the asociaciones value for this PDocumento.
     * 
     * @return asociaciones
     */
    public ar.com.unisolutions.PAsociarEntidad getAsociaciones() {
        return asociaciones;
    }


    /**
     * Sets the asociaciones value for this PDocumento.
     * 
     * @param asociaciones
     */
    public void setAsociaciones(ar.com.unisolutions.PAsociarEntidad asociaciones) {
        this.asociaciones = asociaciones;
    }


    /**
     * Gets the archivosAsociados value for this PDocumento.
     * 
     * @return archivosAsociados
     */
    public ar.com.unisolutions.PArchivoDoc[] getArchivosAsociados() {
        return archivosAsociados;
    }


    /**
     * Sets the archivosAsociados value for this PDocumento.
     * 
     * @param archivosAsociados
     */
    public void setArchivosAsociados(ar.com.unisolutions.PArchivoDoc[] archivosAsociados) {
        this.archivosAsociados = archivosAsociados;
    }


    /**
     * Gets the crearDocumentoRequeridoViaje value for this PDocumento.
     * 
     * @return crearDocumentoRequeridoViaje
     */
    public java.lang.Boolean getCrearDocumentoRequeridoViaje() {
        return crearDocumentoRequeridoViaje;
    }


    /**
     * Sets the crearDocumentoRequeridoViaje value for this PDocumento.
     * 
     * @param crearDocumentoRequeridoViaje
     */
    public void setCrearDocumentoRequeridoViaje(java.lang.Boolean crearDocumentoRequeridoViaje) {
        this.crearDocumentoRequeridoViaje = crearDocumentoRequeridoViaje;
    }


    /**
     * Gets the idViaje value for this PDocumento.
     * 
     * @return idViaje
     */
    public java.lang.Integer getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PDocumento.
     * 
     * @param idViaje
     */
    public void setIdViaje(java.lang.Integer idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the idParada value for this PDocumento.
     * 
     * @return idParada
     */
    public java.lang.Integer getIdParada() {
        return idParada;
    }


    /**
     * Sets the idParada value for this PDocumento.
     * 
     * @param idParada
     */
    public void setIdParada(java.lang.Integer idParada) {
        this.idParada = idParada;
    }


    /**
     * Gets the esDocumentoRequerido value for this PDocumento.
     * 
     * @return esDocumentoRequerido
     */
    public java.lang.Boolean getEsDocumentoRequerido() {
        return esDocumentoRequerido;
    }


    /**
     * Sets the esDocumentoRequerido value for this PDocumento.
     * 
     * @param esDocumentoRequerido
     */
    public void setEsDocumentoRequerido(java.lang.Boolean esDocumentoRequerido) {
        this.esDocumentoRequerido = esDocumentoRequerido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PDocumento)) return false;
        PDocumento other = (PDocumento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipoDocumento==null && other.getTipoDocumento()==null) || 
             (this.tipoDocumento!=null &&
              this.tipoDocumento.equals(other.getTipoDocumento()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            ((this.fechaEmision==null && other.getFechaEmision()==null) || 
             (this.fechaEmision!=null &&
              this.fechaEmision.equals(other.getFechaEmision()))) &&
            ((this.fechaExpiracion==null && other.getFechaExpiracion()==null) || 
             (this.fechaExpiracion!=null &&
              this.fechaExpiracion.equals(other.getFechaExpiracion()))) &&
            ((this.categoria==null && other.getCategoria()==null) || 
             (this.categoria!=null &&
              this.categoria.equals(other.getCategoria()))) &&
            ((this.clase==null && other.getClase()==null) || 
             (this.clase!=null &&
              this.clase.equals(other.getClase()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            ((this.referenciaEstadoDocumento==null && other.getReferenciaEstadoDocumento()==null) || 
             (this.referenciaEstadoDocumento!=null &&
              this.referenciaEstadoDocumento.equals(other.getReferenciaEstadoDocumento()))) &&
            ((this.referenciaConductor==null && other.getReferenciaConductor()==null) || 
             (this.referenciaConductor!=null &&
              this.referenciaConductor.equals(other.getReferenciaConductor()))) &&
            ((this.forzarActualizacion==null && other.getForzarActualizacion()==null) || 
             (this.forzarActualizacion!=null &&
              this.forzarActualizacion.equals(other.getForzarActualizacion()))) &&
            ((this.asociaciones==null && other.getAsociaciones()==null) || 
             (this.asociaciones!=null &&
              this.asociaciones.equals(other.getAsociaciones()))) &&
            ((this.archivosAsociados==null && other.getArchivosAsociados()==null) || 
             (this.archivosAsociados!=null &&
              java.util.Arrays.equals(this.archivosAsociados, other.getArchivosAsociados()))) &&
            ((this.crearDocumentoRequeridoViaje==null && other.getCrearDocumentoRequeridoViaje()==null) || 
             (this.crearDocumentoRequeridoViaje!=null &&
              this.crearDocumentoRequeridoViaje.equals(other.getCrearDocumentoRequeridoViaje()))) &&
            ((this.idViaje==null && other.getIdViaje()==null) || 
             (this.idViaje!=null &&
              this.idViaje.equals(other.getIdViaje()))) &&
            ((this.idParada==null && other.getIdParada()==null) || 
             (this.idParada!=null &&
              this.idParada.equals(other.getIdParada()))) &&
            ((this.esDocumentoRequerido==null && other.getEsDocumentoRequerido()==null) || 
             (this.esDocumentoRequerido!=null &&
              this.esDocumentoRequerido.equals(other.getEsDocumentoRequerido())));
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
        if (getTipoDocumento() != null) {
            _hashCode += getTipoDocumento().hashCode();
        }
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        if (getFechaEmision() != null) {
            _hashCode += getFechaEmision().hashCode();
        }
        if (getFechaExpiracion() != null) {
            _hashCode += getFechaExpiracion().hashCode();
        }
        if (getCategoria() != null) {
            _hashCode += getCategoria().hashCode();
        }
        if (getClase() != null) {
            _hashCode += getClase().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        if (getReferenciaEstadoDocumento() != null) {
            _hashCode += getReferenciaEstadoDocumento().hashCode();
        }
        if (getReferenciaConductor() != null) {
            _hashCode += getReferenciaConductor().hashCode();
        }
        if (getForzarActualizacion() != null) {
            _hashCode += getForzarActualizacion().hashCode();
        }
        if (getAsociaciones() != null) {
            _hashCode += getAsociaciones().hashCode();
        }
        if (getArchivosAsociados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArchivosAsociados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArchivosAsociados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCrearDocumentoRequeridoViaje() != null) {
            _hashCode += getCrearDocumentoRequeridoViaje().hashCode();
        }
        if (getIdViaje() != null) {
            _hashCode += getIdViaje().hashCode();
        }
        if (getIdParada() != null) {
            _hashCode += getIdParada().hashCode();
        }
        if (getEsDocumentoRequerido() != null) {
            _hashCode += getEsDocumentoRequerido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PDocumento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDocumento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEmision");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaEmision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaExpiracion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaExpiracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Categoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Clase"));
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
        elemField.setFieldName("referenciaEstadoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaEstadoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaConductor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaConductor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forzarActualizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ForzarActualizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asociaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Asociaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pAsociarEntidad"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archivosAsociados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArchivosAsociados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivoDoc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivoDoc"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearDocumentoRequeridoViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearDocumentoRequeridoViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esDocumentoRequerido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EsDocumentoRequerido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
