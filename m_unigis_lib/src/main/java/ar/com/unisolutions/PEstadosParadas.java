/**
 * PEstadosParadas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadosParadas  implements java.io.Serializable {
    private java.lang.String refDocumento;

    private java.lang.String estado;

    private int idEstadoParada;

    private java.lang.String motivo;

    private java.util.Calendar estadoFecha;

    private java.lang.String observaciones;

    private double latitud;

    private double longitud;

    private java.lang.Integer idViaje;

    private java.lang.Integer idParadaTraceEstado;

    private java.lang.String referenciaViaje;

    private java.lang.String login;

    private java.util.Calendar inicioVisitaReal;

    private java.util.Calendar finVisitaReal;

    public PEstadosParadas() {
    }

    public PEstadosParadas(
           java.lang.String refDocumento,
           java.lang.String estado,
           int idEstadoParada,
           java.lang.String motivo,
           java.util.Calendar estadoFecha,
           java.lang.String observaciones,
           double latitud,
           double longitud,
           java.lang.Integer idViaje,
           java.lang.Integer idParadaTraceEstado,
           java.lang.String referenciaViaje,
           java.lang.String login,
           java.util.Calendar inicioVisitaReal,
           java.util.Calendar finVisitaReal) {
           this.refDocumento = refDocumento;
           this.estado = estado;
           this.idEstadoParada = idEstadoParada;
           this.motivo = motivo;
           this.estadoFecha = estadoFecha;
           this.observaciones = observaciones;
           this.latitud = latitud;
           this.longitud = longitud;
           this.idViaje = idViaje;
           this.idParadaTraceEstado = idParadaTraceEstado;
           this.referenciaViaje = referenciaViaje;
           this.login = login;
           this.inicioVisitaReal = inicioVisitaReal;
           this.finVisitaReal = finVisitaReal;
    }


    /**
     * Gets the refDocumento value for this PEstadosParadas.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this PEstadosParadas.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the estado value for this PEstadosParadas.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PEstadosParadas.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the idEstadoParada value for this PEstadosParadas.
     * 
     * @return idEstadoParada
     */
    public int getIdEstadoParada() {
        return idEstadoParada;
    }


    /**
     * Sets the idEstadoParada value for this PEstadosParadas.
     * 
     * @param idEstadoParada
     */
    public void setIdEstadoParada(int idEstadoParada) {
        this.idEstadoParada = idEstadoParada;
    }


    /**
     * Gets the motivo value for this PEstadosParadas.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this PEstadosParadas.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the estadoFecha value for this PEstadosParadas.
     * 
     * @return estadoFecha
     */
    public java.util.Calendar getEstadoFecha() {
        return estadoFecha;
    }


    /**
     * Sets the estadoFecha value for this PEstadosParadas.
     * 
     * @param estadoFecha
     */
    public void setEstadoFecha(java.util.Calendar estadoFecha) {
        this.estadoFecha = estadoFecha;
    }


    /**
     * Gets the observaciones value for this PEstadosParadas.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PEstadosParadas.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the latitud value for this PEstadosParadas.
     * 
     * @return latitud
     */
    public double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this PEstadosParadas.
     * 
     * @param latitud
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this PEstadosParadas.
     * 
     * @return longitud
     */
    public double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this PEstadosParadas.
     * 
     * @param longitud
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the idViaje value for this PEstadosParadas.
     * 
     * @return idViaje
     */
    public java.lang.Integer getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PEstadosParadas.
     * 
     * @param idViaje
     */
    public void setIdViaje(java.lang.Integer idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the idParadaTraceEstado value for this PEstadosParadas.
     * 
     * @return idParadaTraceEstado
     */
    public java.lang.Integer getIdParadaTraceEstado() {
        return idParadaTraceEstado;
    }


    /**
     * Sets the idParadaTraceEstado value for this PEstadosParadas.
     * 
     * @param idParadaTraceEstado
     */
    public void setIdParadaTraceEstado(java.lang.Integer idParadaTraceEstado) {
        this.idParadaTraceEstado = idParadaTraceEstado;
    }


    /**
     * Gets the referenciaViaje value for this PEstadosParadas.
     * 
     * @return referenciaViaje
     */
    public java.lang.String getReferenciaViaje() {
        return referenciaViaje;
    }


    /**
     * Sets the referenciaViaje value for this PEstadosParadas.
     * 
     * @param referenciaViaje
     */
    public void setReferenciaViaje(java.lang.String referenciaViaje) {
        this.referenciaViaje = referenciaViaje;
    }


    /**
     * Gets the login value for this PEstadosParadas.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this PEstadosParadas.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the inicioVisitaReal value for this PEstadosParadas.
     * 
     * @return inicioVisitaReal
     */
    public java.util.Calendar getInicioVisitaReal() {
        return inicioVisitaReal;
    }


    /**
     * Sets the inicioVisitaReal value for this PEstadosParadas.
     * 
     * @param inicioVisitaReal
     */
    public void setInicioVisitaReal(java.util.Calendar inicioVisitaReal) {
        this.inicioVisitaReal = inicioVisitaReal;
    }


    /**
     * Gets the finVisitaReal value for this PEstadosParadas.
     * 
     * @return finVisitaReal
     */
    public java.util.Calendar getFinVisitaReal() {
        return finVisitaReal;
    }


    /**
     * Sets the finVisitaReal value for this PEstadosParadas.
     * 
     * @param finVisitaReal
     */
    public void setFinVisitaReal(java.util.Calendar finVisitaReal) {
        this.finVisitaReal = finVisitaReal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadosParadas)) return false;
        PEstadosParadas other = (PEstadosParadas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            this.idEstadoParada == other.getIdEstadoParada() &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo()))) &&
            ((this.estadoFecha==null && other.getEstadoFecha()==null) || 
             (this.estadoFecha!=null &&
              this.estadoFecha.equals(other.getEstadoFecha()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            this.latitud == other.getLatitud() &&
            this.longitud == other.getLongitud() &&
            ((this.idViaje==null && other.getIdViaje()==null) || 
             (this.idViaje!=null &&
              this.idViaje.equals(other.getIdViaje()))) &&
            ((this.idParadaTraceEstado==null && other.getIdParadaTraceEstado()==null) || 
             (this.idParadaTraceEstado!=null &&
              this.idParadaTraceEstado.equals(other.getIdParadaTraceEstado()))) &&
            ((this.referenciaViaje==null && other.getReferenciaViaje()==null) || 
             (this.referenciaViaje!=null &&
              this.referenciaViaje.equals(other.getReferenciaViaje()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.inicioVisitaReal==null && other.getInicioVisitaReal()==null) || 
             (this.inicioVisitaReal!=null &&
              this.inicioVisitaReal.equals(other.getInicioVisitaReal()))) &&
            ((this.finVisitaReal==null && other.getFinVisitaReal()==null) || 
             (this.finVisitaReal!=null &&
              this.finVisitaReal.equals(other.getFinVisitaReal())));
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
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        _hashCode += getIdEstadoParada();
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        if (getEstadoFecha() != null) {
            _hashCode += getEstadoFecha().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        _hashCode += new Double(getLatitud()).hashCode();
        _hashCode += new Double(getLongitud()).hashCode();
        if (getIdViaje() != null) {
            _hashCode += getIdViaje().hashCode();
        }
        if (getIdParadaTraceEstado() != null) {
            _hashCode += getIdParadaTraceEstado().hashCode();
        }
        if (getReferenciaViaje() != null) {
            _hashCode += getReferenciaViaje().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getInicioVisitaReal() != null) {
            _hashCode += getInicioVisitaReal().hashCode();
        }
        if (getFinVisitaReal() != null) {
            _hashCode += getFinVisitaReal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadosParadas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadosParadas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumento"));
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
        elemField.setFieldName("idEstadoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdEstadoParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Motivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoFecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoFecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParadaTraceEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParadaTraceEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioVisitaReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioVisitaReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finVisitaReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinVisitaReal"));
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
