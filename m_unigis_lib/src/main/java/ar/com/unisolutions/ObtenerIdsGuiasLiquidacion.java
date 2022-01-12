/**
 * ObtenerIdsGuiasLiquidacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerIdsGuiasLiquidacion  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.util.Calendar fechaDesde;

    private java.util.Calendar fechaHasta;

    private java.lang.String codigoSucursal;

    private ar.com.unisolutions.PVehiculo vehiculo;

    private ar.com.unisolutions.PTransporte transporte;

    private ar.com.unisolutions.PConductor conductor;

    private java.lang.String estadoGuias;

    private java.lang.String tipoGuia;

    private java.lang.String codigoOperacion;

    public ObtenerIdsGuiasLiquidacion() {
    }

    public ObtenerIdsGuiasLiquidacion(
           java.lang.String apiKey,
           java.util.Calendar fechaDesde,
           java.util.Calendar fechaHasta,
           java.lang.String codigoSucursal,
           ar.com.unisolutions.PVehiculo vehiculo,
           ar.com.unisolutions.PTransporte transporte,
           ar.com.unisolutions.PConductor conductor,
           java.lang.String estadoGuias,
           java.lang.String tipoGuia,
           java.lang.String codigoOperacion) {
           this.apiKey = apiKey;
           this.fechaDesde = fechaDesde;
           this.fechaHasta = fechaHasta;
           this.codigoSucursal = codigoSucursal;
           this.vehiculo = vehiculo;
           this.transporte = transporte;
           this.conductor = conductor;
           this.estadoGuias = estadoGuias;
           this.tipoGuia = tipoGuia;
           this.codigoOperacion = codigoOperacion;
    }


    /**
     * Gets the apiKey value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the fechaDesde value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return fechaDesde
     */
    public java.util.Calendar getFechaDesde() {
        return fechaDesde;
    }


    /**
     * Sets the fechaDesde value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param fechaDesde
     */
    public void setFechaDesde(java.util.Calendar fechaDesde) {
        this.fechaDesde = fechaDesde;
    }


    /**
     * Gets the fechaHasta value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return fechaHasta
     */
    public java.util.Calendar getFechaHasta() {
        return fechaHasta;
    }


    /**
     * Sets the fechaHasta value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param fechaHasta
     */
    public void setFechaHasta(java.util.Calendar fechaHasta) {
        this.fechaHasta = fechaHasta;
    }


    /**
     * Gets the codigoSucursal value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return codigoSucursal
     */
    public java.lang.String getCodigoSucursal() {
        return codigoSucursal;
    }


    /**
     * Sets the codigoSucursal value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param codigoSucursal
     */
    public void setCodigoSucursal(java.lang.String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }


    /**
     * Gets the vehiculo value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return vehiculo
     */
    public ar.com.unisolutions.PVehiculo getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param vehiculo
     */
    public void setVehiculo(ar.com.unisolutions.PVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the transporte value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return transporte
     */
    public ar.com.unisolutions.PTransporte getTransporte() {
        return transporte;
    }


    /**
     * Sets the transporte value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param transporte
     */
    public void setTransporte(ar.com.unisolutions.PTransporte transporte) {
        this.transporte = transporte;
    }


    /**
     * Gets the conductor value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return conductor
     */
    public ar.com.unisolutions.PConductor getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param conductor
     */
    public void setConductor(ar.com.unisolutions.PConductor conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the estadoGuias value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return estadoGuias
     */
    public java.lang.String getEstadoGuias() {
        return estadoGuias;
    }


    /**
     * Sets the estadoGuias value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param estadoGuias
     */
    public void setEstadoGuias(java.lang.String estadoGuias) {
        this.estadoGuias = estadoGuias;
    }


    /**
     * Gets the tipoGuia value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return tipoGuia
     */
    public java.lang.String getTipoGuia() {
        return tipoGuia;
    }


    /**
     * Sets the tipoGuia value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param tipoGuia
     */
    public void setTipoGuia(java.lang.String tipoGuia) {
        this.tipoGuia = tipoGuia;
    }


    /**
     * Gets the codigoOperacion value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @return codigoOperacion
     */
    public java.lang.String getCodigoOperacion() {
        return codigoOperacion;
    }


    /**
     * Sets the codigoOperacion value for this ObtenerIdsGuiasLiquidacion.
     * 
     * @param codigoOperacion
     */
    public void setCodigoOperacion(java.lang.String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerIdsGuiasLiquidacion)) return false;
        ObtenerIdsGuiasLiquidacion other = (ObtenerIdsGuiasLiquidacion) obj;
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
            ((this.fechaDesde==null && other.getFechaDesde()==null) || 
             (this.fechaDesde!=null &&
              this.fechaDesde.equals(other.getFechaDesde()))) &&
            ((this.fechaHasta==null && other.getFechaHasta()==null) || 
             (this.fechaHasta!=null &&
              this.fechaHasta.equals(other.getFechaHasta()))) &&
            ((this.codigoSucursal==null && other.getCodigoSucursal()==null) || 
             (this.codigoSucursal!=null &&
              this.codigoSucursal.equals(other.getCodigoSucursal()))) &&
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo()))) &&
            ((this.transporte==null && other.getTransporte()==null) || 
             (this.transporte!=null &&
              this.transporte.equals(other.getTransporte()))) &&
            ((this.conductor==null && other.getConductor()==null) || 
             (this.conductor!=null &&
              this.conductor.equals(other.getConductor()))) &&
            ((this.estadoGuias==null && other.getEstadoGuias()==null) || 
             (this.estadoGuias!=null &&
              this.estadoGuias.equals(other.getEstadoGuias()))) &&
            ((this.tipoGuia==null && other.getTipoGuia()==null) || 
             (this.tipoGuia!=null &&
              this.tipoGuia.equals(other.getTipoGuia()))) &&
            ((this.codigoOperacion==null && other.getCodigoOperacion()==null) || 
             (this.codigoOperacion!=null &&
              this.codigoOperacion.equals(other.getCodigoOperacion())));
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
        if (getFechaDesde() != null) {
            _hashCode += getFechaDesde().hashCode();
        }
        if (getFechaHasta() != null) {
            _hashCode += getFechaHasta().hashCode();
        }
        if (getCodigoSucursal() != null) {
            _hashCode += getCodigoSucursal().hashCode();
        }
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        if (getTransporte() != null) {
            _hashCode += getTransporte().hashCode();
        }
        if (getConductor() != null) {
            _hashCode += getConductor().hashCode();
        }
        if (getEstadoGuias() != null) {
            _hashCode += getEstadoGuias().hashCode();
        }
        if (getTipoGuia() != null) {
            _hashCode += getTipoGuia().hashCode();
        }
        if (getCodigoOperacion() != null) {
            _hashCode += getCodigoOperacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerIdsGuiasLiquidacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerIdsGuiasLiquidacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoSucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Vehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conductor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoGuias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoGuias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoGuia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoGuia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoOperacion"));
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
