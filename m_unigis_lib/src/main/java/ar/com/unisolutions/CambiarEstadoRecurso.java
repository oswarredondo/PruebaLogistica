/**
 * CambiarEstadoRecurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CambiarEstadoRecurso  implements java.io.Serializable {
    private java.lang.String apikey;

    private java.lang.String entidad;

    private java.lang.String referenciaExterna;

    private java.lang.Integer idEntidad;

    private java.lang.String estado;

    private java.lang.String login;

    private java.lang.String motivo;

    private boolean validarTransicion;

    private boolean mismoEstado;

    private java.lang.String observaciones;

    public CambiarEstadoRecurso() {
    }

    public CambiarEstadoRecurso(
           java.lang.String apikey,
           java.lang.String entidad,
           java.lang.String referenciaExterna,
           java.lang.Integer idEntidad,
           java.lang.String estado,
           java.lang.String login,
           java.lang.String motivo,
           boolean validarTransicion,
           boolean mismoEstado,
           java.lang.String observaciones) {
           this.apikey = apikey;
           this.entidad = entidad;
           this.referenciaExterna = referenciaExterna;
           this.idEntidad = idEntidad;
           this.estado = estado;
           this.login = login;
           this.motivo = motivo;
           this.validarTransicion = validarTransicion;
           this.mismoEstado = mismoEstado;
           this.observaciones = observaciones;
    }


    /**
     * Gets the apikey value for this CambiarEstadoRecurso.
     * 
     * @return apikey
     */
    public java.lang.String getApikey() {
        return apikey;
    }


    /**
     * Sets the apikey value for this CambiarEstadoRecurso.
     * 
     * @param apikey
     */
    public void setApikey(java.lang.String apikey) {
        this.apikey = apikey;
    }


    /**
     * Gets the entidad value for this CambiarEstadoRecurso.
     * 
     * @return entidad
     */
    public java.lang.String getEntidad() {
        return entidad;
    }


    /**
     * Sets the entidad value for this CambiarEstadoRecurso.
     * 
     * @param entidad
     */
    public void setEntidad(java.lang.String entidad) {
        this.entidad = entidad;
    }


    /**
     * Gets the referenciaExterna value for this CambiarEstadoRecurso.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this CambiarEstadoRecurso.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the idEntidad value for this CambiarEstadoRecurso.
     * 
     * @return idEntidad
     */
    public java.lang.Integer getIdEntidad() {
        return idEntidad;
    }


    /**
     * Sets the idEntidad value for this CambiarEstadoRecurso.
     * 
     * @param idEntidad
     */
    public void setIdEntidad(java.lang.Integer idEntidad) {
        this.idEntidad = idEntidad;
    }


    /**
     * Gets the estado value for this CambiarEstadoRecurso.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this CambiarEstadoRecurso.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the login value for this CambiarEstadoRecurso.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this CambiarEstadoRecurso.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the motivo value for this CambiarEstadoRecurso.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this CambiarEstadoRecurso.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the validarTransicion value for this CambiarEstadoRecurso.
     * 
     * @return validarTransicion
     */
    public boolean isValidarTransicion() {
        return validarTransicion;
    }


    /**
     * Sets the validarTransicion value for this CambiarEstadoRecurso.
     * 
     * @param validarTransicion
     */
    public void setValidarTransicion(boolean validarTransicion) {
        this.validarTransicion = validarTransicion;
    }


    /**
     * Gets the mismoEstado value for this CambiarEstadoRecurso.
     * 
     * @return mismoEstado
     */
    public boolean isMismoEstado() {
        return mismoEstado;
    }


    /**
     * Sets the mismoEstado value for this CambiarEstadoRecurso.
     * 
     * @param mismoEstado
     */
    public void setMismoEstado(boolean mismoEstado) {
        this.mismoEstado = mismoEstado;
    }


    /**
     * Gets the observaciones value for this CambiarEstadoRecurso.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this CambiarEstadoRecurso.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CambiarEstadoRecurso)) return false;
        CambiarEstadoRecurso other = (CambiarEstadoRecurso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apikey==null && other.getApikey()==null) || 
             (this.apikey!=null &&
              this.apikey.equals(other.getApikey()))) &&
            ((this.entidad==null && other.getEntidad()==null) || 
             (this.entidad!=null &&
              this.entidad.equals(other.getEntidad()))) &&
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.idEntidad==null && other.getIdEntidad()==null) || 
             (this.idEntidad!=null &&
              this.idEntidad.equals(other.getIdEntidad()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo()))) &&
            this.validarTransicion == other.isValidarTransicion() &&
            this.mismoEstado == other.isMismoEstado() &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones())));
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
        if (getApikey() != null) {
            _hashCode += getApikey().hashCode();
        }
        if (getEntidad() != null) {
            _hashCode += getEntidad().hashCode();
        }
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getIdEntidad() != null) {
            _hashCode += getIdEntidad().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        _hashCode += (isValidarTransicion() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isMismoEstado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CambiarEstadoRecurso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CambiarEstadoRecurso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apikey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apikey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "entidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "referenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEntidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "idEntidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "motivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validarTransicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "validarTransicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mismoEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "mismoEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "observaciones"));
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
