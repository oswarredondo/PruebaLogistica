/**
 * PEstados.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstados  implements java.io.Serializable {
    private java.util.Calendar fechaEstado;

    private java.util.Calendar fechaCreacion;

    private java.lang.String descripcion;

    private java.lang.Double latitud;

    private java.lang.Double longitud;

    private java.lang.String login;

    public PEstados() {
    }

    public PEstados(
           java.util.Calendar fechaEstado,
           java.util.Calendar fechaCreacion,
           java.lang.String descripcion,
           java.lang.Double latitud,
           java.lang.Double longitud,
           java.lang.String login) {
           this.fechaEstado = fechaEstado;
           this.fechaCreacion = fechaCreacion;
           this.descripcion = descripcion;
           this.latitud = latitud;
           this.longitud = longitud;
           this.login = login;
    }


    /**
     * Gets the fechaEstado value for this PEstados.
     * 
     * @return fechaEstado
     */
    public java.util.Calendar getFechaEstado() {
        return fechaEstado;
    }


    /**
     * Sets the fechaEstado value for this PEstados.
     * 
     * @param fechaEstado
     */
    public void setFechaEstado(java.util.Calendar fechaEstado) {
        this.fechaEstado = fechaEstado;
    }


    /**
     * Gets the fechaCreacion value for this PEstados.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this PEstados.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the descripcion value for this PEstados.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PEstados.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the latitud value for this PEstados.
     * 
     * @return latitud
     */
    public java.lang.Double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this PEstados.
     * 
     * @param latitud
     */
    public void setLatitud(java.lang.Double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this PEstados.
     * 
     * @return longitud
     */
    public java.lang.Double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this PEstados.
     * 
     * @param longitud
     */
    public void setLongitud(java.lang.Double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the login value for this PEstados.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this PEstados.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstados)) return false;
        PEstados other = (PEstados) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaEstado==null && other.getFechaEstado()==null) || 
             (this.fechaEstado!=null &&
              this.fechaEstado.equals(other.getFechaEstado()))) &&
            ((this.fechaCreacion==null && other.getFechaCreacion()==null) || 
             (this.fechaCreacion!=null &&
              this.fechaCreacion.equals(other.getFechaCreacion()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.latitud==null && other.getLatitud()==null) || 
             (this.latitud!=null &&
              this.latitud.equals(other.getLatitud()))) &&
            ((this.longitud==null && other.getLongitud()==null) || 
             (this.longitud!=null &&
              this.longitud.equals(other.getLongitud()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin())));
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
        if (getFechaEstado() != null) {
            _hashCode += getFechaEstado().hashCode();
        }
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getLatitud() != null) {
            _hashCode += getLatitud().hashCode();
        }
        if (getLongitud() != null) {
            _hashCode += getLongitud().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstados.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstados"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCreacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCreacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Latitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Longitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Login"));
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
