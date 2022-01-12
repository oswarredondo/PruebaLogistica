/**
 * PVehiculoExtended.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PVehiculoExtended  extends ar.com.unisolutions.PVehiculo  implements java.io.Serializable {
    private java.lang.Double alto;

    private java.lang.Double ancho;

    private java.lang.Double profundidad;

    private java.util.Calendar fechaRegistracion;

    private java.lang.String tipoCaja;

    private java.lang.String refExternaTransporte;

    private java.lang.Integer idCliente;

    private java.lang.String referenciaContrato;

    private java.lang.String formaCarga;

    private java.lang.String login;

    private ar.com.unisolutions.LogEntidad[] cambiosVehiculo;

    public PVehiculoExtended() {
    }

    public PVehiculoExtended(
           java.lang.String dominio,
           java.lang.String dominioSemi,
           java.lang.String nroSerie,
           java.lang.String prestador,
           java.lang.String flota,
           java.lang.String chasis,
           java.lang.Double volumen,
           java.lang.Double peso,
           java.lang.String ciudad,
           java.lang.String marca,
           java.lang.String modelo,
           java.lang.String combustible,
           java.lang.String tipoVehiculo,
           java.lang.String tipoCarroceria,
           java.lang.String propietario,
           java.lang.String conductor,
           java.lang.String coConductor,
           java.lang.String aseguradora,
           java.lang.String transporte,
           java.lang.String categoria,
           java.lang.String[] grupos,
           java.lang.String referenciaExterna,
           java.lang.String color,
           java.lang.String contrato,
           java.lang.String tipoCarga,
           java.lang.String refTipoVehiculo,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           java.lang.String varchar4,
           java.util.Calendar fechaFabricacion,
           java.lang.Integer idEstado,
           java.lang.Integer int1,
           java.lang.Integer int2,
           java.lang.Double float1,
           java.lang.Double float2,
           java.lang.Double alto,
           java.lang.Double ancho,
           java.lang.Double profundidad,
           java.util.Calendar fechaRegistracion,
           java.lang.String tipoCaja,
           java.lang.String refExternaTransporte,
           java.lang.Integer idCliente,
           java.lang.String referenciaContrato,
           java.lang.String formaCarga,
           java.lang.String login,
           ar.com.unisolutions.LogEntidad[] cambiosVehiculo) {
        super(
            dominio,
            dominioSemi,
            nroSerie,
            prestador,
            flota,
            chasis,
            volumen,
            peso,
            ciudad,
            marca,
            modelo,
            combustible,
            tipoVehiculo,
            tipoCarroceria,
            propietario,
            conductor,
            coConductor,
            aseguradora,
            transporte,
            categoria,
            grupos,
            referenciaExterna,
            color,
            contrato,
            tipoCarga,
            refTipoVehiculo,
            varchar1,
            varchar2,
            varchar3,
            varchar4,
            fechaFabricacion,
            idEstado,
            int1,
            int2,
            float1,
            float2);
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.fechaRegistracion = fechaRegistracion;
        this.tipoCaja = tipoCaja;
        this.refExternaTransporte = refExternaTransporte;
        this.idCliente = idCliente;
        this.referenciaContrato = referenciaContrato;
        this.formaCarga = formaCarga;
        this.login = login;
        this.cambiosVehiculo = cambiosVehiculo;
    }


    /**
     * Gets the alto value for this PVehiculoExtended.
     * 
     * @return alto
     */
    public java.lang.Double getAlto() {
        return alto;
    }


    /**
     * Sets the alto value for this PVehiculoExtended.
     * 
     * @param alto
     */
    public void setAlto(java.lang.Double alto) {
        this.alto = alto;
    }


    /**
     * Gets the ancho value for this PVehiculoExtended.
     * 
     * @return ancho
     */
    public java.lang.Double getAncho() {
        return ancho;
    }


    /**
     * Sets the ancho value for this PVehiculoExtended.
     * 
     * @param ancho
     */
    public void setAncho(java.lang.Double ancho) {
        this.ancho = ancho;
    }


    /**
     * Gets the profundidad value for this PVehiculoExtended.
     * 
     * @return profundidad
     */
    public java.lang.Double getProfundidad() {
        return profundidad;
    }


    /**
     * Sets the profundidad value for this PVehiculoExtended.
     * 
     * @param profundidad
     */
    public void setProfundidad(java.lang.Double profundidad) {
        this.profundidad = profundidad;
    }


    /**
     * Gets the fechaRegistracion value for this PVehiculoExtended.
     * 
     * @return fechaRegistracion
     */
    public java.util.Calendar getFechaRegistracion() {
        return fechaRegistracion;
    }


    /**
     * Sets the fechaRegistracion value for this PVehiculoExtended.
     * 
     * @param fechaRegistracion
     */
    public void setFechaRegistracion(java.util.Calendar fechaRegistracion) {
        this.fechaRegistracion = fechaRegistracion;
    }


    /**
     * Gets the tipoCaja value for this PVehiculoExtended.
     * 
     * @return tipoCaja
     */
    public java.lang.String getTipoCaja() {
        return tipoCaja;
    }


    /**
     * Sets the tipoCaja value for this PVehiculoExtended.
     * 
     * @param tipoCaja
     */
    public void setTipoCaja(java.lang.String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }


    /**
     * Gets the refExternaTransporte value for this PVehiculoExtended.
     * 
     * @return refExternaTransporte
     */
    public java.lang.String getRefExternaTransporte() {
        return refExternaTransporte;
    }


    /**
     * Sets the refExternaTransporte value for this PVehiculoExtended.
     * 
     * @param refExternaTransporte
     */
    public void setRefExternaTransporte(java.lang.String refExternaTransporte) {
        this.refExternaTransporte = refExternaTransporte;
    }


    /**
     * Gets the idCliente value for this PVehiculoExtended.
     * 
     * @return idCliente
     */
    public java.lang.Integer getIdCliente() {
        return idCliente;
    }


    /**
     * Sets the idCliente value for this PVehiculoExtended.
     * 
     * @param idCliente
     */
    public void setIdCliente(java.lang.Integer idCliente) {
        this.idCliente = idCliente;
    }


    /**
     * Gets the referenciaContrato value for this PVehiculoExtended.
     * 
     * @return referenciaContrato
     */
    public java.lang.String getReferenciaContrato() {
        return referenciaContrato;
    }


    /**
     * Sets the referenciaContrato value for this PVehiculoExtended.
     * 
     * @param referenciaContrato
     */
    public void setReferenciaContrato(java.lang.String referenciaContrato) {
        this.referenciaContrato = referenciaContrato;
    }


    /**
     * Gets the formaCarga value for this PVehiculoExtended.
     * 
     * @return formaCarga
     */
    public java.lang.String getFormaCarga() {
        return formaCarga;
    }


    /**
     * Sets the formaCarga value for this PVehiculoExtended.
     * 
     * @param formaCarga
     */
    public void setFormaCarga(java.lang.String formaCarga) {
        this.formaCarga = formaCarga;
    }


    /**
     * Gets the login value for this PVehiculoExtended.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this PVehiculoExtended.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the cambiosVehiculo value for this PVehiculoExtended.
     * 
     * @return cambiosVehiculo
     */
    public ar.com.unisolutions.LogEntidad[] getCambiosVehiculo() {
        return cambiosVehiculo;
    }


    /**
     * Sets the cambiosVehiculo value for this PVehiculoExtended.
     * 
     * @param cambiosVehiculo
     */
    public void setCambiosVehiculo(ar.com.unisolutions.LogEntidad[] cambiosVehiculo) {
        this.cambiosVehiculo = cambiosVehiculo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PVehiculoExtended)) return false;
        PVehiculoExtended other = (PVehiculoExtended) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.alto==null && other.getAlto()==null) || 
             (this.alto!=null &&
              this.alto.equals(other.getAlto()))) &&
            ((this.ancho==null && other.getAncho()==null) || 
             (this.ancho!=null &&
              this.ancho.equals(other.getAncho()))) &&
            ((this.profundidad==null && other.getProfundidad()==null) || 
             (this.profundidad!=null &&
              this.profundidad.equals(other.getProfundidad()))) &&
            ((this.fechaRegistracion==null && other.getFechaRegistracion()==null) || 
             (this.fechaRegistracion!=null &&
              this.fechaRegistracion.equals(other.getFechaRegistracion()))) &&
            ((this.tipoCaja==null && other.getTipoCaja()==null) || 
             (this.tipoCaja!=null &&
              this.tipoCaja.equals(other.getTipoCaja()))) &&
            ((this.refExternaTransporte==null && other.getRefExternaTransporte()==null) || 
             (this.refExternaTransporte!=null &&
              this.refExternaTransporte.equals(other.getRefExternaTransporte()))) &&
            ((this.idCliente==null && other.getIdCliente()==null) || 
             (this.idCliente!=null &&
              this.idCliente.equals(other.getIdCliente()))) &&
            ((this.referenciaContrato==null && other.getReferenciaContrato()==null) || 
             (this.referenciaContrato!=null &&
              this.referenciaContrato.equals(other.getReferenciaContrato()))) &&
            ((this.formaCarga==null && other.getFormaCarga()==null) || 
             (this.formaCarga!=null &&
              this.formaCarga.equals(other.getFormaCarga()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.cambiosVehiculo==null && other.getCambiosVehiculo()==null) || 
             (this.cambiosVehiculo!=null &&
              java.util.Arrays.equals(this.cambiosVehiculo, other.getCambiosVehiculo())));
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
        if (getAlto() != null) {
            _hashCode += getAlto().hashCode();
        }
        if (getAncho() != null) {
            _hashCode += getAncho().hashCode();
        }
        if (getProfundidad() != null) {
            _hashCode += getProfundidad().hashCode();
        }
        if (getFechaRegistracion() != null) {
            _hashCode += getFechaRegistracion().hashCode();
        }
        if (getTipoCaja() != null) {
            _hashCode += getTipoCaja().hashCode();
        }
        if (getRefExternaTransporte() != null) {
            _hashCode += getRefExternaTransporte().hashCode();
        }
        if (getIdCliente() != null) {
            _hashCode += getIdCliente().hashCode();
        }
        if (getReferenciaContrato() != null) {
            _hashCode += getReferenciaContrato().hashCode();
        }
        if (getFormaCarga() != null) {
            _hashCode += getFormaCarga().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getCambiosVehiculo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCambiosVehiculo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCambiosVehiculo(), i);
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
        new org.apache.axis.description.TypeDesc(PVehiculoExtended.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculoExtended"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Alto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ancho");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ancho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profundidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Profundidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaRegistracion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaRegistracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCaja");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoCaja"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refExternaTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefExternaTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaContrato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaContrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formaCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FormaCarga"));
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
        elemField.setFieldName("cambiosVehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CambiosVehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LogEntidad"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LogEntidad"));
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
