/**
 * PEstadoViaje.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadoViaje  implements java.io.Serializable {
    private int idViaje;

    private java.lang.String estado;

    private java.lang.String motivo;

    private java.util.Calendar fechaCambioEstado;

    private java.lang.String login;

    private boolean validarTransicion;

    private boolean mismoEstado;

    private ar.com.unisolutions.PArchivoDoc[] archivosAsociados;

    public PEstadoViaje() {
    }

    public PEstadoViaje(
           int idViaje,
           java.lang.String estado,
           java.lang.String motivo,
           java.util.Calendar fechaCambioEstado,
           java.lang.String login,
           boolean validarTransicion,
           boolean mismoEstado,
           ar.com.unisolutions.PArchivoDoc[] archivosAsociados) {
           this.idViaje = idViaje;
           this.estado = estado;
           this.motivo = motivo;
           this.fechaCambioEstado = fechaCambioEstado;
           this.login = login;
           this.validarTransicion = validarTransicion;
           this.mismoEstado = mismoEstado;
           this.archivosAsociados = archivosAsociados;
    }


    /**
     * Gets the idViaje value for this PEstadoViaje.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PEstadoViaje.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the estado value for this PEstadoViaje.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PEstadoViaje.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the motivo value for this PEstadoViaje.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this PEstadoViaje.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the fechaCambioEstado value for this PEstadoViaje.
     * 
     * @return fechaCambioEstado
     */
    public java.util.Calendar getFechaCambioEstado() {
        return fechaCambioEstado;
    }


    /**
     * Sets the fechaCambioEstado value for this PEstadoViaje.
     * 
     * @param fechaCambioEstado
     */
    public void setFechaCambioEstado(java.util.Calendar fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }


    /**
     * Gets the login value for this PEstadoViaje.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this PEstadoViaje.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the validarTransicion value for this PEstadoViaje.
     * 
     * @return validarTransicion
     */
    public boolean isValidarTransicion() {
        return validarTransicion;
    }


    /**
     * Sets the validarTransicion value for this PEstadoViaje.
     * 
     * @param validarTransicion
     */
    public void setValidarTransicion(boolean validarTransicion) {
        this.validarTransicion = validarTransicion;
    }


    /**
     * Gets the mismoEstado value for this PEstadoViaje.
     * 
     * @return mismoEstado
     */
    public boolean isMismoEstado() {
        return mismoEstado;
    }


    /**
     * Sets the mismoEstado value for this PEstadoViaje.
     * 
     * @param mismoEstado
     */
    public void setMismoEstado(boolean mismoEstado) {
        this.mismoEstado = mismoEstado;
    }


    /**
     * Gets the archivosAsociados value for this PEstadoViaje.
     * 
     * @return archivosAsociados
     */
    public ar.com.unisolutions.PArchivoDoc[] getArchivosAsociados() {
        return archivosAsociados;
    }


    /**
     * Sets the archivosAsociados value for this PEstadoViaje.
     * 
     * @param archivosAsociados
     */
    public void setArchivosAsociados(ar.com.unisolutions.PArchivoDoc[] archivosAsociados) {
        this.archivosAsociados = archivosAsociados;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadoViaje)) return false;
        PEstadoViaje other = (PEstadoViaje) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idViaje == other.getIdViaje() &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo()))) &&
            ((this.fechaCambioEstado==null && other.getFechaCambioEstado()==null) || 
             (this.fechaCambioEstado!=null &&
              this.fechaCambioEstado.equals(other.getFechaCambioEstado()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            this.validarTransicion == other.isValidarTransicion() &&
            this.mismoEstado == other.isMismoEstado() &&
            ((this.archivosAsociados==null && other.getArchivosAsociados()==null) || 
             (this.archivosAsociados!=null &&
              java.util.Arrays.equals(this.archivosAsociados, other.getArchivosAsociados())));
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
        _hashCode += getIdViaje();
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        if (getFechaCambioEstado() != null) {
            _hashCode += getFechaCambioEstado().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        _hashCode += (isValidarTransicion() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isMismoEstado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadoViaje.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoViaje"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("motivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Motivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCambioEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCambioEstado"));
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
        elemField.setFieldName("validarTransicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValidarTransicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mismoEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "MismoEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
