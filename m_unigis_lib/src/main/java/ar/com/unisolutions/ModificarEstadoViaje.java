/**
 * ModificarEstadoViaje.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ModificarEstadoViaje  implements java.io.Serializable {
    private java.lang.String apiKey;

    private int idViaje;

    private java.lang.String estado;

    private java.lang.String login;

    private boolean validarTransicion;

    private java.util.Calendar fechaCambioEstado;

    public ModificarEstadoViaje() {
    }

    public ModificarEstadoViaje(
           java.lang.String apiKey,
           int idViaje,
           java.lang.String estado,
           java.lang.String login,
           boolean validarTransicion,
           java.util.Calendar fechaCambioEstado) {
           this.apiKey = apiKey;
           this.idViaje = idViaje;
           this.estado = estado;
           this.login = login;
           this.validarTransicion = validarTransicion;
           this.fechaCambioEstado = fechaCambioEstado;
    }


    /**
     * Gets the apiKey value for this ModificarEstadoViaje.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ModificarEstadoViaje.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the idViaje value for this ModificarEstadoViaje.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this ModificarEstadoViaje.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the estado value for this ModificarEstadoViaje.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this ModificarEstadoViaje.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the login value for this ModificarEstadoViaje.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this ModificarEstadoViaje.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the validarTransicion value for this ModificarEstadoViaje.
     * 
     * @return validarTransicion
     */
    public boolean isValidarTransicion() {
        return validarTransicion;
    }


    /**
     * Sets the validarTransicion value for this ModificarEstadoViaje.
     * 
     * @param validarTransicion
     */
    public void setValidarTransicion(boolean validarTransicion) {
        this.validarTransicion = validarTransicion;
    }


    /**
     * Gets the fechaCambioEstado value for this ModificarEstadoViaje.
     * 
     * @return fechaCambioEstado
     */
    public java.util.Calendar getFechaCambioEstado() {
        return fechaCambioEstado;
    }


    /**
     * Sets the fechaCambioEstado value for this ModificarEstadoViaje.
     * 
     * @param fechaCambioEstado
     */
    public void setFechaCambioEstado(java.util.Calendar fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModificarEstadoViaje)) return false;
        ModificarEstadoViaje other = (ModificarEstadoViaje) obj;
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
            this.idViaje == other.getIdViaje() &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            this.validarTransicion == other.isValidarTransicion() &&
            ((this.fechaCambioEstado==null && other.getFechaCambioEstado()==null) || 
             (this.fechaCambioEstado!=null &&
              this.fechaCambioEstado.equals(other.getFechaCambioEstado())));
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
        _hashCode += getIdViaje();
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        _hashCode += (isValidarTransicion() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFechaCambioEstado() != null) {
            _hashCode += getFechaCambioEstado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModificarEstadoViaje.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ModificarEstadoViaje"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
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
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"));
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
        elemField.setFieldName("validarTransicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValidarTransicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCambioEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
