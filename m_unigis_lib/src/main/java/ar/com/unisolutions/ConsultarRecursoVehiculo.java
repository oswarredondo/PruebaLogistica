/**
 * ConsultarRecursoVehiculo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarRecursoVehiculo  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.lang.String dominio;

    private java.lang.String referenciaRecurso;

    private java.lang.String estado;

    private java.lang.String estadoRecurso;

    private java.util.Calendar fechaCreacion;

    private java.util.Calendar fechaEstadoRecurso;

    private java.util.Calendar fechaModificacion;

    public ConsultarRecursoVehiculo() {
    }

    public ConsultarRecursoVehiculo(
           java.lang.String apiKey,
           java.lang.String dominio,
           java.lang.String referenciaRecurso,
           java.lang.String estado,
           java.lang.String estadoRecurso,
           java.util.Calendar fechaCreacion,
           java.util.Calendar fechaEstadoRecurso,
           java.util.Calendar fechaModificacion) {
           this.apiKey = apiKey;
           this.dominio = dominio;
           this.referenciaRecurso = referenciaRecurso;
           this.estado = estado;
           this.estadoRecurso = estadoRecurso;
           this.fechaCreacion = fechaCreacion;
           this.fechaEstadoRecurso = fechaEstadoRecurso;
           this.fechaModificacion = fechaModificacion;
    }


    /**
     * Gets the apiKey value for this ConsultarRecursoVehiculo.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ConsultarRecursoVehiculo.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the dominio value for this ConsultarRecursoVehiculo.
     * 
     * @return dominio
     */
    public java.lang.String getDominio() {
        return dominio;
    }


    /**
     * Sets the dominio value for this ConsultarRecursoVehiculo.
     * 
     * @param dominio
     */
    public void setDominio(java.lang.String dominio) {
        this.dominio = dominio;
    }


    /**
     * Gets the referenciaRecurso value for this ConsultarRecursoVehiculo.
     * 
     * @return referenciaRecurso
     */
    public java.lang.String getReferenciaRecurso() {
        return referenciaRecurso;
    }


    /**
     * Sets the referenciaRecurso value for this ConsultarRecursoVehiculo.
     * 
     * @param referenciaRecurso
     */
    public void setReferenciaRecurso(java.lang.String referenciaRecurso) {
        this.referenciaRecurso = referenciaRecurso;
    }


    /**
     * Gets the estado value for this ConsultarRecursoVehiculo.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this ConsultarRecursoVehiculo.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the estadoRecurso value for this ConsultarRecursoVehiculo.
     * 
     * @return estadoRecurso
     */
    public java.lang.String getEstadoRecurso() {
        return estadoRecurso;
    }


    /**
     * Sets the estadoRecurso value for this ConsultarRecursoVehiculo.
     * 
     * @param estadoRecurso
     */
    public void setEstadoRecurso(java.lang.String estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }


    /**
     * Gets the fechaCreacion value for this ConsultarRecursoVehiculo.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this ConsultarRecursoVehiculo.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the fechaEstadoRecurso value for this ConsultarRecursoVehiculo.
     * 
     * @return fechaEstadoRecurso
     */
    public java.util.Calendar getFechaEstadoRecurso() {
        return fechaEstadoRecurso;
    }


    /**
     * Sets the fechaEstadoRecurso value for this ConsultarRecursoVehiculo.
     * 
     * @param fechaEstadoRecurso
     */
    public void setFechaEstadoRecurso(java.util.Calendar fechaEstadoRecurso) {
        this.fechaEstadoRecurso = fechaEstadoRecurso;
    }


    /**
     * Gets the fechaModificacion value for this ConsultarRecursoVehiculo.
     * 
     * @return fechaModificacion
     */
    public java.util.Calendar getFechaModificacion() {
        return fechaModificacion;
    }


    /**
     * Sets the fechaModificacion value for this ConsultarRecursoVehiculo.
     * 
     * @param fechaModificacion
     */
    public void setFechaModificacion(java.util.Calendar fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarRecursoVehiculo)) return false;
        ConsultarRecursoVehiculo other = (ConsultarRecursoVehiculo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apiKey==null && other.getApiKey()==null) || 
             (this.apiKey!=null &&
              this.apiKey.equals(other.getApiKey()))) &&
            ((this.dominio==null && other.getDominio()==null) || 
             (this.dominio!=null &&
              this.dominio.equals(other.getDominio()))) &&
            ((this.referenciaRecurso==null && other.getReferenciaRecurso()==null) || 
             (this.referenciaRecurso!=null &&
              this.referenciaRecurso.equals(other.getReferenciaRecurso()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.estadoRecurso==null && other.getEstadoRecurso()==null) || 
             (this.estadoRecurso!=null &&
              this.estadoRecurso.equals(other.getEstadoRecurso()))) &&
            ((this.fechaCreacion==null && other.getFechaCreacion()==null) || 
             (this.fechaCreacion!=null &&
              this.fechaCreacion.equals(other.getFechaCreacion()))) &&
            ((this.fechaEstadoRecurso==null && other.getFechaEstadoRecurso()==null) || 
             (this.fechaEstadoRecurso!=null &&
              this.fechaEstadoRecurso.equals(other.getFechaEstadoRecurso()))) &&
            ((this.fechaModificacion==null && other.getFechaModificacion()==null) || 
             (this.fechaModificacion!=null &&
              this.fechaModificacion.equals(other.getFechaModificacion())));
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
        if (getApiKey() != null) {
            _hashCode += getApiKey().hashCode();
        }
        if (getDominio() != null) {
            _hashCode += getDominio().hashCode();
        }
        if (getReferenciaRecurso() != null) {
            _hashCode += getReferenciaRecurso().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getEstadoRecurso() != null) {
            _hashCode += getEstadoRecurso().hashCode();
        }
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
        }
        if (getFechaEstadoRecurso() != null) {
            _hashCode += getFechaEstadoRecurso().hashCode();
        }
        if (getFechaModificacion() != null) {
            _hashCode += getFechaModificacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarRecursoVehiculo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarRecursoVehiculo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dominio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCreacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCreacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEstadoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaEstadoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaModificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaModificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
