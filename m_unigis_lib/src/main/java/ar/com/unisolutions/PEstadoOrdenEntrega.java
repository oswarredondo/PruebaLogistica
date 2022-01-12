/**
 * PEstadoOrdenEntrega.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadoOrdenEntrega  implements java.io.Serializable {
    private java.lang.Long idOrden;

    private java.lang.String sucursal;

    private java.lang.String operacion;

    private java.lang.String tipoOperacion;

    private java.lang.String descripcion;

    private java.lang.String refDocumento;

    private java.lang.String estado;

    private java.lang.String motivo;

    private java.util.Calendar estadoFecha;

    private java.lang.String observaciones;

    private ar.com.unisolutions.POrdenEntregaItem[] items;

    private java.lang.Boolean validarTransicion;

    private java.lang.String login;

    public PEstadoOrdenEntrega() {
    }

    public PEstadoOrdenEntrega(
           java.lang.Long idOrden,
           java.lang.String sucursal,
           java.lang.String operacion,
           java.lang.String tipoOperacion,
           java.lang.String descripcion,
           java.lang.String refDocumento,
           java.lang.String estado,
           java.lang.String motivo,
           java.util.Calendar estadoFecha,
           java.lang.String observaciones,
           ar.com.unisolutions.POrdenEntregaItem[] items,
           java.lang.Boolean validarTransicion,
           java.lang.String login) {
           this.idOrden = idOrden;
           this.sucursal = sucursal;
           this.operacion = operacion;
           this.tipoOperacion = tipoOperacion;
           this.descripcion = descripcion;
           this.refDocumento = refDocumento;
           this.estado = estado;
           this.motivo = motivo;
           this.estadoFecha = estadoFecha;
           this.observaciones = observaciones;
           this.items = items;
           this.validarTransicion = validarTransicion;
           this.login = login;
    }


    /**
     * Gets the idOrden value for this PEstadoOrdenEntrega.
     * 
     * @return idOrden
     */
    public java.lang.Long getIdOrden() {
        return idOrden;
    }


    /**
     * Sets the idOrden value for this PEstadoOrdenEntrega.
     * 
     * @param idOrden
     */
    public void setIdOrden(java.lang.Long idOrden) {
        this.idOrden = idOrden;
    }


    /**
     * Gets the sucursal value for this PEstadoOrdenEntrega.
     * 
     * @return sucursal
     */
    public java.lang.String getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this PEstadoOrdenEntrega.
     * 
     * @param sucursal
     */
    public void setSucursal(java.lang.String sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the operacion value for this PEstadoOrdenEntrega.
     * 
     * @return operacion
     */
    public java.lang.String getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this PEstadoOrdenEntrega.
     * 
     * @param operacion
     */
    public void setOperacion(java.lang.String operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the tipoOperacion value for this PEstadoOrdenEntrega.
     * 
     * @return tipoOperacion
     */
    public java.lang.String getTipoOperacion() {
        return tipoOperacion;
    }


    /**
     * Sets the tipoOperacion value for this PEstadoOrdenEntrega.
     * 
     * @param tipoOperacion
     */
    public void setTipoOperacion(java.lang.String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }


    /**
     * Gets the descripcion value for this PEstadoOrdenEntrega.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PEstadoOrdenEntrega.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the refDocumento value for this PEstadoOrdenEntrega.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this PEstadoOrdenEntrega.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the estado value for this PEstadoOrdenEntrega.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PEstadoOrdenEntrega.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the motivo value for this PEstadoOrdenEntrega.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this PEstadoOrdenEntrega.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the estadoFecha value for this PEstadoOrdenEntrega.
     * 
     * @return estadoFecha
     */
    public java.util.Calendar getEstadoFecha() {
        return estadoFecha;
    }


    /**
     * Sets the estadoFecha value for this PEstadoOrdenEntrega.
     * 
     * @param estadoFecha
     */
    public void setEstadoFecha(java.util.Calendar estadoFecha) {
        this.estadoFecha = estadoFecha;
    }


    /**
     * Gets the observaciones value for this PEstadoOrdenEntrega.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PEstadoOrdenEntrega.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the items value for this PEstadoOrdenEntrega.
     * 
     * @return items
     */
    public ar.com.unisolutions.POrdenEntregaItem[] getItems() {
        return items;
    }


    /**
     * Sets the items value for this PEstadoOrdenEntrega.
     * 
     * @param items
     */
    public void setItems(ar.com.unisolutions.POrdenEntregaItem[] items) {
        this.items = items;
    }


    /**
     * Gets the validarTransicion value for this PEstadoOrdenEntrega.
     * 
     * @return validarTransicion
     */
    public java.lang.Boolean getValidarTransicion() {
        return validarTransicion;
    }


    /**
     * Sets the validarTransicion value for this PEstadoOrdenEntrega.
     * 
     * @param validarTransicion
     */
    public void setValidarTransicion(java.lang.Boolean validarTransicion) {
        this.validarTransicion = validarTransicion;
    }


    /**
     * Gets the login value for this PEstadoOrdenEntrega.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this PEstadoOrdenEntrega.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadoOrdenEntrega)) return false;
        PEstadoOrdenEntrega other = (PEstadoOrdenEntrega) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idOrden==null && other.getIdOrden()==null) || 
             (this.idOrden!=null &&
              this.idOrden.equals(other.getIdOrden()))) &&
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
            ((this.tipoOperacion==null && other.getTipoOperacion()==null) || 
             (this.tipoOperacion!=null &&
              this.tipoOperacion.equals(other.getTipoOperacion()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
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
            ((this.items==null && other.getItems()==null) || 
             (this.items!=null &&
              java.util.Arrays.equals(this.items, other.getItems()))) &&
            ((this.validarTransicion==null && other.getValidarTransicion()==null) || 
             (this.validarTransicion!=null &&
              this.validarTransicion.equals(other.getValidarTransicion()))) &&
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
        if (getIdOrden() != null) {
            _hashCode += getIdOrden().hashCode();
        }
        if (getSucursal() != null) {
            _hashCode += getSucursal().hashCode();
        }
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        if (getTipoOperacion() != null) {
            _hashCode += getTipoOperacion().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
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
        if (getValidarTransicion() != null) {
            _hashCode += getValidarTransicion().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadoOrdenEntrega.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoOrdenEntrega"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("items");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Items"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaItem"));
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
