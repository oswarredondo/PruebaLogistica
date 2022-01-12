/**
 * PEstadoParada.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadoParada  implements java.io.Serializable {
    private java.lang.String refDocumento;

    private java.lang.String estado;

    private java.lang.String motivo;

    private java.util.Calendar estadoFecha;

    private java.lang.String observaciones;

    private double latitud;

    private double longitud;

    private java.lang.Integer idViaje;

    private java.lang.Integer idParadaTraceEstado;

    private java.lang.String referenciaViaje;

    private java.lang.String login;

    private byte[] contenido;

    private ar.com.unisolutions.PParadaItem[] items;

    private ar.com.unisolutions.PArchivoDoc[] archivosAsociados;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private java.lang.Boolean mismoEstado;

    private java.lang.Boolean validarTransicion;

    public PEstadoParada() {
    }

    public PEstadoParada(
           java.lang.String refDocumento,
           java.lang.String estado,
           java.lang.String motivo,
           java.util.Calendar estadoFecha,
           java.lang.String observaciones,
           double latitud,
           double longitud,
           java.lang.Integer idViaje,
           java.lang.Integer idParadaTraceEstado,
           java.lang.String referenciaViaje,
           java.lang.String login,
           byte[] contenido,
           ar.com.unisolutions.PParadaItem[] items,
           ar.com.unisolutions.PArchivoDoc[] archivosAsociados,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           java.lang.Boolean mismoEstado,
           java.lang.Boolean validarTransicion) {
           this.refDocumento = refDocumento;
           this.estado = estado;
           this.motivo = motivo;
           this.estadoFecha = estadoFecha;
           this.observaciones = observaciones;
           this.latitud = latitud;
           this.longitud = longitud;
           this.idViaje = idViaje;
           this.idParadaTraceEstado = idParadaTraceEstado;
           this.referenciaViaje = referenciaViaje;
           this.login = login;
           this.contenido = contenido;
           this.items = items;
           this.archivosAsociados = archivosAsociados;
           this.campoDinamico = campoDinamico;
           this.mismoEstado = mismoEstado;
           this.validarTransicion = validarTransicion;
    }


    /**
     * Gets the refDocumento value for this PEstadoParada.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this PEstadoParada.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the estado value for this PEstadoParada.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PEstadoParada.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the motivo value for this PEstadoParada.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this PEstadoParada.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the estadoFecha value for this PEstadoParada.
     * 
     * @return estadoFecha
     */
    public java.util.Calendar getEstadoFecha() {
        return estadoFecha;
    }


    /**
     * Sets the estadoFecha value for this PEstadoParada.
     * 
     * @param estadoFecha
     */
    public void setEstadoFecha(java.util.Calendar estadoFecha) {
        this.estadoFecha = estadoFecha;
    }


    /**
     * Gets the observaciones value for this PEstadoParada.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PEstadoParada.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the latitud value for this PEstadoParada.
     * 
     * @return latitud
     */
    public double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this PEstadoParada.
     * 
     * @param latitud
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this PEstadoParada.
     * 
     * @return longitud
     */
    public double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this PEstadoParada.
     * 
     * @param longitud
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the idViaje value for this PEstadoParada.
     * 
     * @return idViaje
     */
    public java.lang.Integer getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PEstadoParada.
     * 
     * @param idViaje
     */
    public void setIdViaje(java.lang.Integer idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the idParadaTraceEstado value for this PEstadoParada.
     * 
     * @return idParadaTraceEstado
     */
    public java.lang.Integer getIdParadaTraceEstado() {
        return idParadaTraceEstado;
    }


    /**
     * Sets the idParadaTraceEstado value for this PEstadoParada.
     * 
     * @param idParadaTraceEstado
     */
    public void setIdParadaTraceEstado(java.lang.Integer idParadaTraceEstado) {
        this.idParadaTraceEstado = idParadaTraceEstado;
    }


    /**
     * Gets the referenciaViaje value for this PEstadoParada.
     * 
     * @return referenciaViaje
     */
    public java.lang.String getReferenciaViaje() {
        return referenciaViaje;
    }


    /**
     * Sets the referenciaViaje value for this PEstadoParada.
     * 
     * @param referenciaViaje
     */
    public void setReferenciaViaje(java.lang.String referenciaViaje) {
        this.referenciaViaje = referenciaViaje;
    }


    /**
     * Gets the login value for this PEstadoParada.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this PEstadoParada.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the contenido value for this PEstadoParada.
     * 
     * @return contenido
     */
    public byte[] getContenido() {
        return contenido;
    }


    /**
     * Sets the contenido value for this PEstadoParada.
     * 
     * @param contenido
     */
    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }


    /**
     * Gets the items value for this PEstadoParada.
     * 
     * @return items
     */
    public ar.com.unisolutions.PParadaItem[] getItems() {
        return items;
    }


    /**
     * Sets the items value for this PEstadoParada.
     * 
     * @param items
     */
    public void setItems(ar.com.unisolutions.PParadaItem[] items) {
        this.items = items;
    }


    /**
     * Gets the archivosAsociados value for this PEstadoParada.
     * 
     * @return archivosAsociados
     */
    public ar.com.unisolutions.PArchivoDoc[] getArchivosAsociados() {
        return archivosAsociados;
    }


    /**
     * Sets the archivosAsociados value for this PEstadoParada.
     * 
     * @param archivosAsociados
     */
    public void setArchivosAsociados(ar.com.unisolutions.PArchivoDoc[] archivosAsociados) {
        this.archivosAsociados = archivosAsociados;
    }


    /**
     * Gets the campoDinamico value for this PEstadoParada.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this PEstadoParada.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the mismoEstado value for this PEstadoParada.
     * 
     * @return mismoEstado
     */
    public java.lang.Boolean getMismoEstado() {
        return mismoEstado;
    }


    /**
     * Sets the mismoEstado value for this PEstadoParada.
     * 
     * @param mismoEstado
     */
    public void setMismoEstado(java.lang.Boolean mismoEstado) {
        this.mismoEstado = mismoEstado;
    }


    /**
     * Gets the validarTransicion value for this PEstadoParada.
     * 
     * @return validarTransicion
     */
    public java.lang.Boolean getValidarTransicion() {
        return validarTransicion;
    }


    /**
     * Sets the validarTransicion value for this PEstadoParada.
     * 
     * @param validarTransicion
     */
    public void setValidarTransicion(java.lang.Boolean validarTransicion) {
        this.validarTransicion = validarTransicion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadoParada)) return false;
        PEstadoParada other = (PEstadoParada) obj;
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
            ((this.contenido==null && other.getContenido()==null) || 
             (this.contenido!=null &&
              java.util.Arrays.equals(this.contenido, other.getContenido()))) &&
            ((this.items==null && other.getItems()==null) || 
             (this.items!=null &&
              java.util.Arrays.equals(this.items, other.getItems()))) &&
            ((this.archivosAsociados==null && other.getArchivosAsociados()==null) || 
             (this.archivosAsociados!=null &&
              java.util.Arrays.equals(this.archivosAsociados, other.getArchivosAsociados()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.mismoEstado==null && other.getMismoEstado()==null) || 
             (this.mismoEstado!=null &&
              this.mismoEstado.equals(other.getMismoEstado()))) &&
            ((this.validarTransicion==null && other.getValidarTransicion()==null) || 
             (this.validarTransicion!=null &&
              this.validarTransicion.equals(other.getValidarTransicion())));
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
        if (getItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getCampoDinamico() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCampoDinamico());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCampoDinamico(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMismoEstado() != null) {
            _hashCode += getMismoEstado().hashCode();
        }
        if (getValidarTransicion() != null) {
            _hashCode += getValidarTransicion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadoParada.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoParada"));
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
        elemField.setFieldName("contenido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Contenido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("items");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Items"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem"));
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
        elemField.setFieldName("campoDinamico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoDinamico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mismoEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "MismoEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validarTransicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValidarTransicion"));
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
