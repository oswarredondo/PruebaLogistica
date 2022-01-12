/**
 * ConsultarMapaVehiculoResultado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarMapaVehiculoResultado  implements java.io.Serializable {
    private java.lang.String dominio;

    private java.lang.String referenciaExterna;

    private java.lang.String etiqueta;

    private java.lang.String urlImagen;

    private java.lang.String ubicacion;

    private java.lang.String timeZone;

    private java.util.Calendar fechaHoraUltimoReporteUTC;

    private java.util.Calendar fechaHoraUltimoReporteLocal;

    private int minutosUltimoReporte;

    public ConsultarMapaVehiculoResultado() {
    }

    public ConsultarMapaVehiculoResultado(
           java.lang.String dominio,
           java.lang.String referenciaExterna,
           java.lang.String etiqueta,
           java.lang.String urlImagen,
           java.lang.String ubicacion,
           java.lang.String timeZone,
           java.util.Calendar fechaHoraUltimoReporteUTC,
           java.util.Calendar fechaHoraUltimoReporteLocal,
           int minutosUltimoReporte) {
           this.dominio = dominio;
           this.referenciaExterna = referenciaExterna;
           this.etiqueta = etiqueta;
           this.urlImagen = urlImagen;
           this.ubicacion = ubicacion;
           this.timeZone = timeZone;
           this.fechaHoraUltimoReporteUTC = fechaHoraUltimoReporteUTC;
           this.fechaHoraUltimoReporteLocal = fechaHoraUltimoReporteLocal;
           this.minutosUltimoReporte = minutosUltimoReporte;
    }


    /**
     * Gets the dominio value for this ConsultarMapaVehiculoResultado.
     * 
     * @return dominio
     */
    public java.lang.String getDominio() {
        return dominio;
    }


    /**
     * Sets the dominio value for this ConsultarMapaVehiculoResultado.
     * 
     * @param dominio
     */
    public void setDominio(java.lang.String dominio) {
        this.dominio = dominio;
    }


    /**
     * Gets the referenciaExterna value for this ConsultarMapaVehiculoResultado.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this ConsultarMapaVehiculoResultado.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the etiqueta value for this ConsultarMapaVehiculoResultado.
     * 
     * @return etiqueta
     */
    public java.lang.String getEtiqueta() {
        return etiqueta;
    }


    /**
     * Sets the etiqueta value for this ConsultarMapaVehiculoResultado.
     * 
     * @param etiqueta
     */
    public void setEtiqueta(java.lang.String etiqueta) {
        this.etiqueta = etiqueta;
    }


    /**
     * Gets the urlImagen value for this ConsultarMapaVehiculoResultado.
     * 
     * @return urlImagen
     */
    public java.lang.String getUrlImagen() {
        return urlImagen;
    }


    /**
     * Sets the urlImagen value for this ConsultarMapaVehiculoResultado.
     * 
     * @param urlImagen
     */
    public void setUrlImagen(java.lang.String urlImagen) {
        this.urlImagen = urlImagen;
    }


    /**
     * Gets the ubicacion value for this ConsultarMapaVehiculoResultado.
     * 
     * @return ubicacion
     */
    public java.lang.String getUbicacion() {
        return ubicacion;
    }


    /**
     * Sets the ubicacion value for this ConsultarMapaVehiculoResultado.
     * 
     * @param ubicacion
     */
    public void setUbicacion(java.lang.String ubicacion) {
        this.ubicacion = ubicacion;
    }


    /**
     * Gets the timeZone value for this ConsultarMapaVehiculoResultado.
     * 
     * @return timeZone
     */
    public java.lang.String getTimeZone() {
        return timeZone;
    }


    /**
     * Sets the timeZone value for this ConsultarMapaVehiculoResultado.
     * 
     * @param timeZone
     */
    public void setTimeZone(java.lang.String timeZone) {
        this.timeZone = timeZone;
    }


    /**
     * Gets the fechaHoraUltimoReporteUTC value for this ConsultarMapaVehiculoResultado.
     * 
     * @return fechaHoraUltimoReporteUTC
     */
    public java.util.Calendar getFechaHoraUltimoReporteUTC() {
        return fechaHoraUltimoReporteUTC;
    }


    /**
     * Sets the fechaHoraUltimoReporteUTC value for this ConsultarMapaVehiculoResultado.
     * 
     * @param fechaHoraUltimoReporteUTC
     */
    public void setFechaHoraUltimoReporteUTC(java.util.Calendar fechaHoraUltimoReporteUTC) {
        this.fechaHoraUltimoReporteUTC = fechaHoraUltimoReporteUTC;
    }


    /**
     * Gets the fechaHoraUltimoReporteLocal value for this ConsultarMapaVehiculoResultado.
     * 
     * @return fechaHoraUltimoReporteLocal
     */
    public java.util.Calendar getFechaHoraUltimoReporteLocal() {
        return fechaHoraUltimoReporteLocal;
    }


    /**
     * Sets the fechaHoraUltimoReporteLocal value for this ConsultarMapaVehiculoResultado.
     * 
     * @param fechaHoraUltimoReporteLocal
     */
    public void setFechaHoraUltimoReporteLocal(java.util.Calendar fechaHoraUltimoReporteLocal) {
        this.fechaHoraUltimoReporteLocal = fechaHoraUltimoReporteLocal;
    }


    /**
     * Gets the minutosUltimoReporte value for this ConsultarMapaVehiculoResultado.
     * 
     * @return minutosUltimoReporte
     */
    public int getMinutosUltimoReporte() {
        return minutosUltimoReporte;
    }


    /**
     * Sets the minutosUltimoReporte value for this ConsultarMapaVehiculoResultado.
     * 
     * @param minutosUltimoReporte
     */
    public void setMinutosUltimoReporte(int minutosUltimoReporte) {
        this.minutosUltimoReporte = minutosUltimoReporte;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarMapaVehiculoResultado)) return false;
        ConsultarMapaVehiculoResultado other = (ConsultarMapaVehiculoResultado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dominio==null && other.getDominio()==null) || 
             (this.dominio!=null &&
              this.dominio.equals(other.getDominio()))) &&
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.etiqueta==null && other.getEtiqueta()==null) || 
             (this.etiqueta!=null &&
              this.etiqueta.equals(other.getEtiqueta()))) &&
            ((this.urlImagen==null && other.getUrlImagen()==null) || 
             (this.urlImagen!=null &&
              this.urlImagen.equals(other.getUrlImagen()))) &&
            ((this.ubicacion==null && other.getUbicacion()==null) || 
             (this.ubicacion!=null &&
              this.ubicacion.equals(other.getUbicacion()))) &&
            ((this.timeZone==null && other.getTimeZone()==null) || 
             (this.timeZone!=null &&
              this.timeZone.equals(other.getTimeZone()))) &&
            ((this.fechaHoraUltimoReporteUTC==null && other.getFechaHoraUltimoReporteUTC()==null) || 
             (this.fechaHoraUltimoReporteUTC!=null &&
              this.fechaHoraUltimoReporteUTC.equals(other.getFechaHoraUltimoReporteUTC()))) &&
            ((this.fechaHoraUltimoReporteLocal==null && other.getFechaHoraUltimoReporteLocal()==null) || 
             (this.fechaHoraUltimoReporteLocal!=null &&
              this.fechaHoraUltimoReporteLocal.equals(other.getFechaHoraUltimoReporteLocal()))) &&
            this.minutosUltimoReporte == other.getMinutosUltimoReporte();
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
        if (getDominio() != null) {
            _hashCode += getDominio().hashCode();
        }
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getEtiqueta() != null) {
            _hashCode += getEtiqueta().hashCode();
        }
        if (getUrlImagen() != null) {
            _hashCode += getUrlImagen().hashCode();
        }
        if (getUbicacion() != null) {
            _hashCode += getUbicacion().hashCode();
        }
        if (getTimeZone() != null) {
            _hashCode += getTimeZone().hashCode();
        }
        if (getFechaHoraUltimoReporteUTC() != null) {
            _hashCode += getFechaHoraUltimoReporteUTC().hashCode();
        }
        if (getFechaHoraUltimoReporteLocal() != null) {
            _hashCode += getFechaHoraUltimoReporteLocal().hashCode();
        }
        _hashCode += getMinutosUltimoReporte();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarMapaVehiculoResultado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarMapaVehiculoResultado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dominio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiqueta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Etiqueta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlImagen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UrlImagen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ubicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ubicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeZone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TimeZone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraUltimoReporteUTC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHoraUltimoReporteUTC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraUltimoReporteLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHoraUltimoReporteLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minutosUltimoReporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "MinutosUltimoReporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
