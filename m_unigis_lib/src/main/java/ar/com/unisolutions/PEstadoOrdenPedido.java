/**
 * PEstadoOrdenPedido.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadoOrdenPedido  implements java.io.Serializable {
    private java.lang.String refDocumento;

    private java.lang.String estado;

    private java.lang.String estadoPrioridad;

    private java.lang.String estadoOrdenEntrega;

    private java.lang.String motivo;

    private java.lang.String observaciones;

    private java.util.Calendar estadoFecha;

    private java.lang.Boolean validarTransicion;

    private java.lang.String login;

    private ar.com.unisolutions.POrdenPedidoItem[] items;

    private ar.com.unisolutions.PRecursos[] recursos;

    private ar.com.unisolutions.PArchivoDoc[] archivosAsociados;

    public PEstadoOrdenPedido() {
    }

    public PEstadoOrdenPedido(
           java.lang.String refDocumento,
           java.lang.String estado,
           java.lang.String estadoPrioridad,
           java.lang.String estadoOrdenEntrega,
           java.lang.String motivo,
           java.lang.String observaciones,
           java.util.Calendar estadoFecha,
           java.lang.Boolean validarTransicion,
           java.lang.String login,
           ar.com.unisolutions.POrdenPedidoItem[] items,
           ar.com.unisolutions.PRecursos[] recursos,
           ar.com.unisolutions.PArchivoDoc[] archivosAsociados) {
           this.refDocumento = refDocumento;
           this.estado = estado;
           this.estadoPrioridad = estadoPrioridad;
           this.estadoOrdenEntrega = estadoOrdenEntrega;
           this.motivo = motivo;
           this.observaciones = observaciones;
           this.estadoFecha = estadoFecha;
           this.validarTransicion = validarTransicion;
           this.login = login;
           this.items = items;
           this.recursos = recursos;
           this.archivosAsociados = archivosAsociados;
    }


    /**
     * Gets the refDocumento value for this PEstadoOrdenPedido.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this PEstadoOrdenPedido.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the estado value for this PEstadoOrdenPedido.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PEstadoOrdenPedido.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the estadoPrioridad value for this PEstadoOrdenPedido.
     * 
     * @return estadoPrioridad
     */
    public java.lang.String getEstadoPrioridad() {
        return estadoPrioridad;
    }


    /**
     * Sets the estadoPrioridad value for this PEstadoOrdenPedido.
     * 
     * @param estadoPrioridad
     */
    public void setEstadoPrioridad(java.lang.String estadoPrioridad) {
        this.estadoPrioridad = estadoPrioridad;
    }


    /**
     * Gets the estadoOrdenEntrega value for this PEstadoOrdenPedido.
     * 
     * @return estadoOrdenEntrega
     */
    public java.lang.String getEstadoOrdenEntrega() {
        return estadoOrdenEntrega;
    }


    /**
     * Sets the estadoOrdenEntrega value for this PEstadoOrdenPedido.
     * 
     * @param estadoOrdenEntrega
     */
    public void setEstadoOrdenEntrega(java.lang.String estadoOrdenEntrega) {
        this.estadoOrdenEntrega = estadoOrdenEntrega;
    }


    /**
     * Gets the motivo value for this PEstadoOrdenPedido.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this PEstadoOrdenPedido.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the observaciones value for this PEstadoOrdenPedido.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PEstadoOrdenPedido.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the estadoFecha value for this PEstadoOrdenPedido.
     * 
     * @return estadoFecha
     */
    public java.util.Calendar getEstadoFecha() {
        return estadoFecha;
    }


    /**
     * Sets the estadoFecha value for this PEstadoOrdenPedido.
     * 
     * @param estadoFecha
     */
    public void setEstadoFecha(java.util.Calendar estadoFecha) {
        this.estadoFecha = estadoFecha;
    }


    /**
     * Gets the validarTransicion value for this PEstadoOrdenPedido.
     * 
     * @return validarTransicion
     */
    public java.lang.Boolean getValidarTransicion() {
        return validarTransicion;
    }


    /**
     * Sets the validarTransicion value for this PEstadoOrdenPedido.
     * 
     * @param validarTransicion
     */
    public void setValidarTransicion(java.lang.Boolean validarTransicion) {
        this.validarTransicion = validarTransicion;
    }


    /**
     * Gets the login value for this PEstadoOrdenPedido.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this PEstadoOrdenPedido.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the items value for this PEstadoOrdenPedido.
     * 
     * @return items
     */
    public ar.com.unisolutions.POrdenPedidoItem[] getItems() {
        return items;
    }


    /**
     * Sets the items value for this PEstadoOrdenPedido.
     * 
     * @param items
     */
    public void setItems(ar.com.unisolutions.POrdenPedidoItem[] items) {
        this.items = items;
    }


    /**
     * Gets the recursos value for this PEstadoOrdenPedido.
     * 
     * @return recursos
     */
    public ar.com.unisolutions.PRecursos[] getRecursos() {
        return recursos;
    }


    /**
     * Sets the recursos value for this PEstadoOrdenPedido.
     * 
     * @param recursos
     */
    public void setRecursos(ar.com.unisolutions.PRecursos[] recursos) {
        this.recursos = recursos;
    }


    /**
     * Gets the archivosAsociados value for this PEstadoOrdenPedido.
     * 
     * @return archivosAsociados
     */
    public ar.com.unisolutions.PArchivoDoc[] getArchivosAsociados() {
        return archivosAsociados;
    }


    /**
     * Sets the archivosAsociados value for this PEstadoOrdenPedido.
     * 
     * @param archivosAsociados
     */
    public void setArchivosAsociados(ar.com.unisolutions.PArchivoDoc[] archivosAsociados) {
        this.archivosAsociados = archivosAsociados;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadoOrdenPedido)) return false;
        PEstadoOrdenPedido other = (PEstadoOrdenPedido) obj;
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
            ((this.estadoPrioridad==null && other.getEstadoPrioridad()==null) || 
             (this.estadoPrioridad!=null &&
              this.estadoPrioridad.equals(other.getEstadoPrioridad()))) &&
            ((this.estadoOrdenEntrega==null && other.getEstadoOrdenEntrega()==null) || 
             (this.estadoOrdenEntrega!=null &&
              this.estadoOrdenEntrega.equals(other.getEstadoOrdenEntrega()))) &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            ((this.estadoFecha==null && other.getEstadoFecha()==null) || 
             (this.estadoFecha!=null &&
              this.estadoFecha.equals(other.getEstadoFecha()))) &&
            ((this.validarTransicion==null && other.getValidarTransicion()==null) || 
             (this.validarTransicion!=null &&
              this.validarTransicion.equals(other.getValidarTransicion()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.items==null && other.getItems()==null) || 
             (this.items!=null &&
              java.util.Arrays.equals(this.items, other.getItems()))) &&
            ((this.recursos==null && other.getRecursos()==null) || 
             (this.recursos!=null &&
              java.util.Arrays.equals(this.recursos, other.getRecursos()))) &&
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
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getEstadoPrioridad() != null) {
            _hashCode += getEstadoPrioridad().hashCode();
        }
        if (getEstadoOrdenEntrega() != null) {
            _hashCode += getEstadoOrdenEntrega().hashCode();
        }
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        if (getEstadoFecha() != null) {
            _hashCode += getEstadoFecha().hashCode();
        }
        if (getValidarTransicion() != null) {
            _hashCode += getValidarTransicion().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
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
        if (getRecursos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRecursos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRecursos(), i);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadoOrdenPedido.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoOrdenPedido"));
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
        elemField.setFieldName("estadoPrioridad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoPrioridad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoOrdenEntrega");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoOrdenEntrega"));
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
        elemField.setFieldName("observaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"));
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
        elemField.setFieldName("validarTransicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValidarTransicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("items");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Items"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoItem"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recursos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Recursos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos"));
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
