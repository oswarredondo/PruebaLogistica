/**
 * PFoto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PFoto  implements java.io.Serializable {
    private int idArchivo;

    private java.lang.String descripcion;

    private java.lang.String login;

    private java.util.Calendar fechaCreacion;

    private java.lang.String tipo;

    private byte[] contenido;

    private java.lang.String clasificacion;

    private boolean firma;

    private java.lang.String ruta;

    public PFoto() {
    }

    public PFoto(
           int idArchivo,
           java.lang.String descripcion,
           java.lang.String login,
           java.util.Calendar fechaCreacion,
           java.lang.String tipo,
           byte[] contenido,
           java.lang.String clasificacion,
           boolean firma,
           java.lang.String ruta) {
           this.idArchivo = idArchivo;
           this.descripcion = descripcion;
           this.login = login;
           this.fechaCreacion = fechaCreacion;
           this.tipo = tipo;
           this.contenido = contenido;
           this.clasificacion = clasificacion;
           this.firma = firma;
           this.ruta = ruta;
    }


    /**
     * Gets the idArchivo value for this PFoto.
     * 
     * @return idArchivo
     */
    public int getIdArchivo() {
        return idArchivo;
    }


    /**
     * Sets the idArchivo value for this PFoto.
     * 
     * @param idArchivo
     */
    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }


    /**
     * Gets the descripcion value for this PFoto.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PFoto.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the login value for this PFoto.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this PFoto.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the fechaCreacion value for this PFoto.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this PFoto.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the tipo value for this PFoto.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this PFoto.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the contenido value for this PFoto.
     * 
     * @return contenido
     */
    public byte[] getContenido() {
        return contenido;
    }


    /**
     * Sets the contenido value for this PFoto.
     * 
     * @param contenido
     */
    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }


    /**
     * Gets the clasificacion value for this PFoto.
     * 
     * @return clasificacion
     */
    public java.lang.String getClasificacion() {
        return clasificacion;
    }


    /**
     * Sets the clasificacion value for this PFoto.
     * 
     * @param clasificacion
     */
    public void setClasificacion(java.lang.String clasificacion) {
        this.clasificacion = clasificacion;
    }


    /**
     * Gets the firma value for this PFoto.
     * 
     * @return firma
     */
    public boolean isFirma() {
        return firma;
    }


    /**
     * Sets the firma value for this PFoto.
     * 
     * @param firma
     */
    public void setFirma(boolean firma) {
        this.firma = firma;
    }


    /**
     * Gets the ruta value for this PFoto.
     * 
     * @return ruta
     */
    public java.lang.String getRuta() {
        return ruta;
    }


    /**
     * Sets the ruta value for this PFoto.
     * 
     * @param ruta
     */
    public void setRuta(java.lang.String ruta) {
        this.ruta = ruta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PFoto)) return false;
        PFoto other = (PFoto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idArchivo == other.getIdArchivo() &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.fechaCreacion==null && other.getFechaCreacion()==null) || 
             (this.fechaCreacion!=null &&
              this.fechaCreacion.equals(other.getFechaCreacion()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.contenido==null && other.getContenido()==null) || 
             (this.contenido!=null &&
              java.util.Arrays.equals(this.contenido, other.getContenido()))) &&
            ((this.clasificacion==null && other.getClasificacion()==null) || 
             (this.clasificacion!=null &&
              this.clasificacion.equals(other.getClasificacion()))) &&
            this.firma == other.isFirma() &&
            ((this.ruta==null && other.getRuta()==null) || 
             (this.ruta!=null &&
              this.ruta.equals(other.getRuta())));
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
        _hashCode += getIdArchivo();
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getContenido() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContenido());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContenido(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getClasificacion() != null) {
            _hashCode += getClasificacion().hashCode();
        }
        _hashCode += (isFirma() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRuta() != null) {
            _hashCode += getRuta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PFoto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pFoto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idArchivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdArchivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Login"));
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
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Contenido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clasificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Clasificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Firma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ruta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ruta"));
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
