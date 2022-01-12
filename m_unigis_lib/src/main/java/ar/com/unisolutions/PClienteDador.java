/**
 * PClienteDador.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PClienteDador  implements java.io.Serializable {
    private java.lang.String referenciaExterna;

    private java.lang.String razonSocial;

    private java.lang.String nombreFantasia;

    private java.lang.String cuit;

    private java.lang.String telefono1;

    private java.lang.String telefono2;

    private java.lang.String direccion;

    private java.lang.String localidad;

    private java.lang.String eMailGestorDeFlota;

    private java.lang.String centroDeCosto;

    private ar.com.unisolutions.POperacion[] operaciones;

    private java.lang.Integer idEstado;

    public PClienteDador() {
    }

    public PClienteDador(
           java.lang.String referenciaExterna,
           java.lang.String razonSocial,
           java.lang.String nombreFantasia,
           java.lang.String cuit,
           java.lang.String telefono1,
           java.lang.String telefono2,
           java.lang.String direccion,
           java.lang.String localidad,
           java.lang.String eMailGestorDeFlota,
           java.lang.String centroDeCosto,
           ar.com.unisolutions.POperacion[] operaciones,
           java.lang.Integer idEstado) {
           this.referenciaExterna = referenciaExterna;
           this.razonSocial = razonSocial;
           this.nombreFantasia = nombreFantasia;
           this.cuit = cuit;
           this.telefono1 = telefono1;
           this.telefono2 = telefono2;
           this.direccion = direccion;
           this.localidad = localidad;
           this.eMailGestorDeFlota = eMailGestorDeFlota;
           this.centroDeCosto = centroDeCosto;
           this.operaciones = operaciones;
           this.idEstado = idEstado;
    }


    /**
     * Gets the referenciaExterna value for this PClienteDador.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this PClienteDador.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the razonSocial value for this PClienteDador.
     * 
     * @return razonSocial
     */
    public java.lang.String getRazonSocial() {
        return razonSocial;
    }


    /**
     * Sets the razonSocial value for this PClienteDador.
     * 
     * @param razonSocial
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = razonSocial;
    }


    /**
     * Gets the nombreFantasia value for this PClienteDador.
     * 
     * @return nombreFantasia
     */
    public java.lang.String getNombreFantasia() {
        return nombreFantasia;
    }


    /**
     * Sets the nombreFantasia value for this PClienteDador.
     * 
     * @param nombreFantasia
     */
    public void setNombreFantasia(java.lang.String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }


    /**
     * Gets the cuit value for this PClienteDador.
     * 
     * @return cuit
     */
    public java.lang.String getCuit() {
        return cuit;
    }


    /**
     * Sets the cuit value for this PClienteDador.
     * 
     * @param cuit
     */
    public void setCuit(java.lang.String cuit) {
        this.cuit = cuit;
    }


    /**
     * Gets the telefono1 value for this PClienteDador.
     * 
     * @return telefono1
     */
    public java.lang.String getTelefono1() {
        return telefono1;
    }


    /**
     * Sets the telefono1 value for this PClienteDador.
     * 
     * @param telefono1
     */
    public void setTelefono1(java.lang.String telefono1) {
        this.telefono1 = telefono1;
    }


    /**
     * Gets the telefono2 value for this PClienteDador.
     * 
     * @return telefono2
     */
    public java.lang.String getTelefono2() {
        return telefono2;
    }


    /**
     * Sets the telefono2 value for this PClienteDador.
     * 
     * @param telefono2
     */
    public void setTelefono2(java.lang.String telefono2) {
        this.telefono2 = telefono2;
    }


    /**
     * Gets the direccion value for this PClienteDador.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this PClienteDador.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the localidad value for this PClienteDador.
     * 
     * @return localidad
     */
    public java.lang.String getLocalidad() {
        return localidad;
    }


    /**
     * Sets the localidad value for this PClienteDador.
     * 
     * @param localidad
     */
    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }


    /**
     * Gets the eMailGestorDeFlota value for this PClienteDador.
     * 
     * @return eMailGestorDeFlota
     */
    public java.lang.String getEMailGestorDeFlota() {
        return eMailGestorDeFlota;
    }


    /**
     * Sets the eMailGestorDeFlota value for this PClienteDador.
     * 
     * @param eMailGestorDeFlota
     */
    public void setEMailGestorDeFlota(java.lang.String eMailGestorDeFlota) {
        this.eMailGestorDeFlota = eMailGestorDeFlota;
    }


    /**
     * Gets the centroDeCosto value for this PClienteDador.
     * 
     * @return centroDeCosto
     */
    public java.lang.String getCentroDeCosto() {
        return centroDeCosto;
    }


    /**
     * Sets the centroDeCosto value for this PClienteDador.
     * 
     * @param centroDeCosto
     */
    public void setCentroDeCosto(java.lang.String centroDeCosto) {
        this.centroDeCosto = centroDeCosto;
    }


    /**
     * Gets the operaciones value for this PClienteDador.
     * 
     * @return operaciones
     */
    public ar.com.unisolutions.POperacion[] getOperaciones() {
        return operaciones;
    }


    /**
     * Sets the operaciones value for this PClienteDador.
     * 
     * @param operaciones
     */
    public void setOperaciones(ar.com.unisolutions.POperacion[] operaciones) {
        this.operaciones = operaciones;
    }


    /**
     * Gets the idEstado value for this PClienteDador.
     * 
     * @return idEstado
     */
    public java.lang.Integer getIdEstado() {
        return idEstado;
    }


    /**
     * Sets the idEstado value for this PClienteDador.
     * 
     * @param idEstado
     */
    public void setIdEstado(java.lang.Integer idEstado) {
        this.idEstado = idEstado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PClienteDador)) return false;
        PClienteDador other = (PClienteDador) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.razonSocial==null && other.getRazonSocial()==null) || 
             (this.razonSocial!=null &&
              this.razonSocial.equals(other.getRazonSocial()))) &&
            ((this.nombreFantasia==null && other.getNombreFantasia()==null) || 
             (this.nombreFantasia!=null &&
              this.nombreFantasia.equals(other.getNombreFantasia()))) &&
            ((this.cuit==null && other.getCuit()==null) || 
             (this.cuit!=null &&
              this.cuit.equals(other.getCuit()))) &&
            ((this.telefono1==null && other.getTelefono1()==null) || 
             (this.telefono1!=null &&
              this.telefono1.equals(other.getTelefono1()))) &&
            ((this.telefono2==null && other.getTelefono2()==null) || 
             (this.telefono2!=null &&
              this.telefono2.equals(other.getTelefono2()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.localidad==null && other.getLocalidad()==null) || 
             (this.localidad!=null &&
              this.localidad.equals(other.getLocalidad()))) &&
            ((this.eMailGestorDeFlota==null && other.getEMailGestorDeFlota()==null) || 
             (this.eMailGestorDeFlota!=null &&
              this.eMailGestorDeFlota.equals(other.getEMailGestorDeFlota()))) &&
            ((this.centroDeCosto==null && other.getCentroDeCosto()==null) || 
             (this.centroDeCosto!=null &&
              this.centroDeCosto.equals(other.getCentroDeCosto()))) &&
            ((this.operaciones==null && other.getOperaciones()==null) || 
             (this.operaciones!=null &&
              java.util.Arrays.equals(this.operaciones, other.getOperaciones()))) &&
            ((this.idEstado==null && other.getIdEstado()==null) || 
             (this.idEstado!=null &&
              this.idEstado.equals(other.getIdEstado())));
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
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getRazonSocial() != null) {
            _hashCode += getRazonSocial().hashCode();
        }
        if (getNombreFantasia() != null) {
            _hashCode += getNombreFantasia().hashCode();
        }
        if (getCuit() != null) {
            _hashCode += getCuit().hashCode();
        }
        if (getTelefono1() != null) {
            _hashCode += getTelefono1().hashCode();
        }
        if (getTelefono2() != null) {
            _hashCode += getTelefono2().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getLocalidad() != null) {
            _hashCode += getLocalidad().hashCode();
        }
        if (getEMailGestorDeFlota() != null) {
            _hashCode += getEMailGestorDeFlota().hashCode();
        }
        if (getCentroDeCosto() != null) {
            _hashCode += getCentroDeCosto().hashCode();
        }
        if (getOperaciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperaciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperaciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdEstado() != null) {
            _hashCode += getIdEstado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PClienteDador.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RazonSocial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreFantasia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "NombreFantasia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cuit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Telefono1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Telefono2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Direccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Localidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EMailGestorDeFlota");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "eMailGestorDeFlota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("centroDeCosto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CentroDeCosto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "operaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOperacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOperacion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
