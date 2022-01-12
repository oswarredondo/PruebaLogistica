/**
 * PIncidencia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PIncidencia  implements java.io.Serializable {
    private int idIncidencia;

    private java.lang.String descripcionIncidencia;

    private java.lang.String observaciones;

    private int idViaje;

    private java.lang.String referenciaViaje;

    private java.lang.String referenciaParada;

    private java.lang.String referenciaMotivo;

    private double valor;

    private java.util.Calendar fechaCreacion;

    private java.lang.String login;

    private java.lang.String estadoIncidencia;

    public PIncidencia() {
    }

    public PIncidencia(
           int idIncidencia,
           java.lang.String descripcionIncidencia,
           java.lang.String observaciones,
           int idViaje,
           java.lang.String referenciaViaje,
           java.lang.String referenciaParada,
           java.lang.String referenciaMotivo,
           double valor,
           java.util.Calendar fechaCreacion,
           java.lang.String login,
           java.lang.String estadoIncidencia) {
           this.idIncidencia = idIncidencia;
           this.descripcionIncidencia = descripcionIncidencia;
           this.observaciones = observaciones;
           this.idViaje = idViaje;
           this.referenciaViaje = referenciaViaje;
           this.referenciaParada = referenciaParada;
           this.referenciaMotivo = referenciaMotivo;
           this.valor = valor;
           this.fechaCreacion = fechaCreacion;
           this.login = login;
           this.estadoIncidencia = estadoIncidencia;
    }


    /**
     * Gets the idIncidencia value for this PIncidencia.
     * 
     * @return idIncidencia
     */
    public int getIdIncidencia() {
        return idIncidencia;
    }


    /**
     * Sets the idIncidencia value for this PIncidencia.
     * 
     * @param idIncidencia
     */
    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }


    /**
     * Gets the descripcionIncidencia value for this PIncidencia.
     * 
     * @return descripcionIncidencia
     */
    public java.lang.String getDescripcionIncidencia() {
        return descripcionIncidencia;
    }


    /**
     * Sets the descripcionIncidencia value for this PIncidencia.
     * 
     * @param descripcionIncidencia
     */
    public void setDescripcionIncidencia(java.lang.String descripcionIncidencia) {
        this.descripcionIncidencia = descripcionIncidencia;
    }


    /**
     * Gets the observaciones value for this PIncidencia.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PIncidencia.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the idViaje value for this PIncidencia.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PIncidencia.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the referenciaViaje value for this PIncidencia.
     * 
     * @return referenciaViaje
     */
    public java.lang.String getReferenciaViaje() {
        return referenciaViaje;
    }


    /**
     * Sets the referenciaViaje value for this PIncidencia.
     * 
     * @param referenciaViaje
     */
    public void setReferenciaViaje(java.lang.String referenciaViaje) {
        this.referenciaViaje = referenciaViaje;
    }


    /**
     * Gets the referenciaParada value for this PIncidencia.
     * 
     * @return referenciaParada
     */
    public java.lang.String getReferenciaParada() {
        return referenciaParada;
    }


    /**
     * Sets the referenciaParada value for this PIncidencia.
     * 
     * @param referenciaParada
     */
    public void setReferenciaParada(java.lang.String referenciaParada) {
        this.referenciaParada = referenciaParada;
    }


    /**
     * Gets the referenciaMotivo value for this PIncidencia.
     * 
     * @return referenciaMotivo
     */
    public java.lang.String getReferenciaMotivo() {
        return referenciaMotivo;
    }


    /**
     * Sets the referenciaMotivo value for this PIncidencia.
     * 
     * @param referenciaMotivo
     */
    public void setReferenciaMotivo(java.lang.String referenciaMotivo) {
        this.referenciaMotivo = referenciaMotivo;
    }


    /**
     * Gets the valor value for this PIncidencia.
     * 
     * @return valor
     */
    public double getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this PIncidencia.
     * 
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }


    /**
     * Gets the fechaCreacion value for this PIncidencia.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this PIncidencia.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the login value for this PIncidencia.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this PIncidencia.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the estadoIncidencia value for this PIncidencia.
     * 
     * @return estadoIncidencia
     */
    public java.lang.String getEstadoIncidencia() {
        return estadoIncidencia;
    }


    /**
     * Sets the estadoIncidencia value for this PIncidencia.
     * 
     * @param estadoIncidencia
     */
    public void setEstadoIncidencia(java.lang.String estadoIncidencia) {
        this.estadoIncidencia = estadoIncidencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PIncidencia)) return false;
        PIncidencia other = (PIncidencia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idIncidencia == other.getIdIncidencia() &&
            ((this.descripcionIncidencia==null && other.getDescripcionIncidencia()==null) || 
             (this.descripcionIncidencia!=null &&
              this.descripcionIncidencia.equals(other.getDescripcionIncidencia()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            this.idViaje == other.getIdViaje() &&
            ((this.referenciaViaje==null && other.getReferenciaViaje()==null) || 
             (this.referenciaViaje!=null &&
              this.referenciaViaje.equals(other.getReferenciaViaje()))) &&
            ((this.referenciaParada==null && other.getReferenciaParada()==null) || 
             (this.referenciaParada!=null &&
              this.referenciaParada.equals(other.getReferenciaParada()))) &&
            ((this.referenciaMotivo==null && other.getReferenciaMotivo()==null) || 
             (this.referenciaMotivo!=null &&
              this.referenciaMotivo.equals(other.getReferenciaMotivo()))) &&
            this.valor == other.getValor() &&
            ((this.fechaCreacion==null && other.getFechaCreacion()==null) || 
             (this.fechaCreacion!=null &&
              this.fechaCreacion.equals(other.getFechaCreacion()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.estadoIncidencia==null && other.getEstadoIncidencia()==null) || 
             (this.estadoIncidencia!=null &&
              this.estadoIncidencia.equals(other.getEstadoIncidencia())));
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
        _hashCode += getIdIncidencia();
        if (getDescripcionIncidencia() != null) {
            _hashCode += getDescripcionIncidencia().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        _hashCode += getIdViaje();
        if (getReferenciaViaje() != null) {
            _hashCode += getReferenciaViaje().hashCode();
        }
        if (getReferenciaParada() != null) {
            _hashCode += getReferenciaParada().hashCode();
        }
        if (getReferenciaMotivo() != null) {
            _hashCode += getReferenciaMotivo().hashCode();
        }
        _hashCode += new Double(getValor()).hashCode();
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getEstadoIncidencia() != null) {
            _hashCode += getEstadoIncidencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PIncidencia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pIncidencia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIncidencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdIncidencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionIncidencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DescripcionIncidencia"));
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
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaMotivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaMotivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Valor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCreacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCreacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoIncidencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoIncidencia"));
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
