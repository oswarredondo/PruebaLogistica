/**
 * Transporte.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class Transporte  extends ar.com.unisolutions.EntityObject  implements java.io.Serializable {
    private java.lang.String razonSocial;

    private java.lang.String nombreFantasia;

    private java.lang.String CUIT;

    private java.lang.String direccion;

    private java.lang.String localidad;

    private java.lang.String telefono1;

    private java.lang.String telefono2;

    private java.lang.String EMail;

    private java.lang.Integer idEstadoTransporte;

    private java.lang.Integer idTipoTransporte;

    private java.lang.Double calificacion;

    private java.lang.String contacto1;

    private java.lang.String codigoPostal;

    private java.lang.String referenciaExterna;

    private int idTransporte;

    public Transporte() {
    }

    public Transporte(
           ar.com.unisolutions.EntityKey entityKey,
           java.lang.String razonSocial,
           java.lang.String nombreFantasia,
           java.lang.String CUIT,
           java.lang.String direccion,
           java.lang.String localidad,
           java.lang.String telefono1,
           java.lang.String telefono2,
           java.lang.String EMail,
           java.lang.Integer idEstadoTransporte,
           java.lang.Integer idTipoTransporte,
           java.lang.Double calificacion,
           java.lang.String contacto1,
           java.lang.String codigoPostal,
           java.lang.String referenciaExterna,
           int idTransporte) {
        super(
            entityKey);
        this.razonSocial = razonSocial;
        this.nombreFantasia = nombreFantasia;
        this.CUIT = CUIT;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.EMail = EMail;
        this.idEstadoTransporte = idEstadoTransporte;
        this.idTipoTransporte = idTipoTransporte;
        this.calificacion = calificacion;
        this.contacto1 = contacto1;
        this.codigoPostal = codigoPostal;
        this.referenciaExterna = referenciaExterna;
        this.idTransporte = idTransporte;
    }


    /**
     * Gets the razonSocial value for this Transporte.
     * 
     * @return razonSocial
     */
    public java.lang.String getRazonSocial() {
        return razonSocial;
    }


    /**
     * Sets the razonSocial value for this Transporte.
     * 
     * @param razonSocial
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = razonSocial;
    }


    /**
     * Gets the nombreFantasia value for this Transporte.
     * 
     * @return nombreFantasia
     */
    public java.lang.String getNombreFantasia() {
        return nombreFantasia;
    }


    /**
     * Sets the nombreFantasia value for this Transporte.
     * 
     * @param nombreFantasia
     */
    public void setNombreFantasia(java.lang.String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }


    /**
     * Gets the CUIT value for this Transporte.
     * 
     * @return CUIT
     */
    public java.lang.String getCUIT() {
        return CUIT;
    }


    /**
     * Sets the CUIT value for this Transporte.
     * 
     * @param CUIT
     */
    public void setCUIT(java.lang.String CUIT) {
        this.CUIT = CUIT;
    }


    /**
     * Gets the direccion value for this Transporte.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this Transporte.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the localidad value for this Transporte.
     * 
     * @return localidad
     */
    public java.lang.String getLocalidad() {
        return localidad;
    }


    /**
     * Sets the localidad value for this Transporte.
     * 
     * @param localidad
     */
    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }


    /**
     * Gets the telefono1 value for this Transporte.
     * 
     * @return telefono1
     */
    public java.lang.String getTelefono1() {
        return telefono1;
    }


    /**
     * Sets the telefono1 value for this Transporte.
     * 
     * @param telefono1
     */
    public void setTelefono1(java.lang.String telefono1) {
        this.telefono1 = telefono1;
    }


    /**
     * Gets the telefono2 value for this Transporte.
     * 
     * @return telefono2
     */
    public java.lang.String getTelefono2() {
        return telefono2;
    }


    /**
     * Sets the telefono2 value for this Transporte.
     * 
     * @param telefono2
     */
    public void setTelefono2(java.lang.String telefono2) {
        this.telefono2 = telefono2;
    }


    /**
     * Gets the EMail value for this Transporte.
     * 
     * @return EMail
     */
    public java.lang.String getEMail() {
        return EMail;
    }


    /**
     * Sets the EMail value for this Transporte.
     * 
     * @param EMail
     */
    public void setEMail(java.lang.String EMail) {
        this.EMail = EMail;
    }


    /**
     * Gets the idEstadoTransporte value for this Transporte.
     * 
     * @return idEstadoTransporte
     */
    public java.lang.Integer getIdEstadoTransporte() {
        return idEstadoTransporte;
    }


    /**
     * Sets the idEstadoTransporte value for this Transporte.
     * 
     * @param idEstadoTransporte
     */
    public void setIdEstadoTransporte(java.lang.Integer idEstadoTransporte) {
        this.idEstadoTransporte = idEstadoTransporte;
    }


    /**
     * Gets the idTipoTransporte value for this Transporte.
     * 
     * @return idTipoTransporte
     */
    public java.lang.Integer getIdTipoTransporte() {
        return idTipoTransporte;
    }


    /**
     * Sets the idTipoTransporte value for this Transporte.
     * 
     * @param idTipoTransporte
     */
    public void setIdTipoTransporte(java.lang.Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }


    /**
     * Gets the calificacion value for this Transporte.
     * 
     * @return calificacion
     */
    public java.lang.Double getCalificacion() {
        return calificacion;
    }


    /**
     * Sets the calificacion value for this Transporte.
     * 
     * @param calificacion
     */
    public void setCalificacion(java.lang.Double calificacion) {
        this.calificacion = calificacion;
    }


    /**
     * Gets the contacto1 value for this Transporte.
     * 
     * @return contacto1
     */
    public java.lang.String getContacto1() {
        return contacto1;
    }


    /**
     * Sets the contacto1 value for this Transporte.
     * 
     * @param contacto1
     */
    public void setContacto1(java.lang.String contacto1) {
        this.contacto1 = contacto1;
    }


    /**
     * Gets the codigoPostal value for this Transporte.
     * 
     * @return codigoPostal
     */
    public java.lang.String getCodigoPostal() {
        return codigoPostal;
    }


    /**
     * Sets the codigoPostal value for this Transporte.
     * 
     * @param codigoPostal
     */
    public void setCodigoPostal(java.lang.String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    /**
     * Gets the referenciaExterna value for this Transporte.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this Transporte.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the idTransporte value for this Transporte.
     * 
     * @return idTransporte
     */
    public int getIdTransporte() {
        return idTransporte;
    }


    /**
     * Sets the idTransporte value for this Transporte.
     * 
     * @param idTransporte
     */
    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Transporte)) return false;
        Transporte other = (Transporte) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.razonSocial==null && other.getRazonSocial()==null) || 
             (this.razonSocial!=null &&
              this.razonSocial.equals(other.getRazonSocial()))) &&
            ((this.nombreFantasia==null && other.getNombreFantasia()==null) || 
             (this.nombreFantasia!=null &&
              this.nombreFantasia.equals(other.getNombreFantasia()))) &&
            ((this.CUIT==null && other.getCUIT()==null) || 
             (this.CUIT!=null &&
              this.CUIT.equals(other.getCUIT()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.localidad==null && other.getLocalidad()==null) || 
             (this.localidad!=null &&
              this.localidad.equals(other.getLocalidad()))) &&
            ((this.telefono1==null && other.getTelefono1()==null) || 
             (this.telefono1!=null &&
              this.telefono1.equals(other.getTelefono1()))) &&
            ((this.telefono2==null && other.getTelefono2()==null) || 
             (this.telefono2!=null &&
              this.telefono2.equals(other.getTelefono2()))) &&
            ((this.EMail==null && other.getEMail()==null) || 
             (this.EMail!=null &&
              this.EMail.equals(other.getEMail()))) &&
            ((this.idEstadoTransporte==null && other.getIdEstadoTransporte()==null) || 
             (this.idEstadoTransporte!=null &&
              this.idEstadoTransporte.equals(other.getIdEstadoTransporte()))) &&
            ((this.idTipoTransporte==null && other.getIdTipoTransporte()==null) || 
             (this.idTipoTransporte!=null &&
              this.idTipoTransporte.equals(other.getIdTipoTransporte()))) &&
            ((this.calificacion==null && other.getCalificacion()==null) || 
             (this.calificacion!=null &&
              this.calificacion.equals(other.getCalificacion()))) &&
            ((this.contacto1==null && other.getContacto1()==null) || 
             (this.contacto1!=null &&
              this.contacto1.equals(other.getContacto1()))) &&
            ((this.codigoPostal==null && other.getCodigoPostal()==null) || 
             (this.codigoPostal!=null &&
              this.codigoPostal.equals(other.getCodigoPostal()))) &&
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            this.idTransporte == other.getIdTransporte();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getRazonSocial() != null) {
            _hashCode += getRazonSocial().hashCode();
        }
        if (getNombreFantasia() != null) {
            _hashCode += getNombreFantasia().hashCode();
        }
        if (getCUIT() != null) {
            _hashCode += getCUIT().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getLocalidad() != null) {
            _hashCode += getLocalidad().hashCode();
        }
        if (getTelefono1() != null) {
            _hashCode += getTelefono1().hashCode();
        }
        if (getTelefono2() != null) {
            _hashCode += getTelefono2().hashCode();
        }
        if (getEMail() != null) {
            _hashCode += getEMail().hashCode();
        }
        if (getIdEstadoTransporte() != null) {
            _hashCode += getIdEstadoTransporte().hashCode();
        }
        if (getIdTipoTransporte() != null) {
            _hashCode += getIdTipoTransporte().hashCode();
        }
        if (getCalificacion() != null) {
            _hashCode += getCalificacion().hashCode();
        }
        if (getContacto1() != null) {
            _hashCode += getContacto1().hashCode();
        }
        if (getCodigoPostal() != null) {
            _hashCode += getCodigoPostal().hashCode();
        }
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        _hashCode += getIdTransporte();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Transporte.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("CUIT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CUIT"));
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
        elemField.setFieldName("EMail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEstadoTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdEstadoTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTipoTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdTipoTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Calificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contacto1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Contacto1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoPostal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoPostal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
