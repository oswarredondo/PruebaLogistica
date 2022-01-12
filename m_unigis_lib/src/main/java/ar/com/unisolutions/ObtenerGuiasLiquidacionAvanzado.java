/**
 * ObtenerGuiasLiquidacionAvanzado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ObtenerGuiasLiquidacionAvanzado  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.util.Calendar fechaDesde;

    private java.util.Calendar fechaHasta;

    private java.lang.String codigoSucursal;

    private ar.com.unisolutions.PVehiculo vehiculo;

    private ar.com.unisolutions.PTransporte transporte;

    private ar.com.unisolutions.PConductor conductor;

    private java.lang.String tipoGuia;

    private java.lang.String viaje_ReferenciaExterna;

    private java.lang.Integer idViaje;

    public ObtenerGuiasLiquidacionAvanzado() {
    }

    public ObtenerGuiasLiquidacionAvanzado(
           java.lang.String apiKey,
           java.util.Calendar fechaDesde,
           java.util.Calendar fechaHasta,
           java.lang.String codigoSucursal,
           ar.com.unisolutions.PVehiculo vehiculo,
           ar.com.unisolutions.PTransporte transporte,
           ar.com.unisolutions.PConductor conductor,
           java.lang.String tipoGuia,
           java.lang.String viaje_ReferenciaExterna,
           java.lang.Integer idViaje) {
           this.apiKey = apiKey;
           this.fechaDesde = fechaDesde;
           this.fechaHasta = fechaHasta;
           this.codigoSucursal = codigoSucursal;
           this.vehiculo = vehiculo;
           this.transporte = transporte;
           this.conductor = conductor;
           this.tipoGuia = tipoGuia;
           this.viaje_ReferenciaExterna = viaje_ReferenciaExterna;
           this.idViaje = idViaje;
    }


    /**
     * Gets the apiKey value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the fechaDesde value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return fechaDesde
     */
    public java.util.Calendar getFechaDesde() {
        return fechaDesde;
    }


    /**
     * Sets the fechaDesde value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param fechaDesde
     */
    public void setFechaDesde(java.util.Calendar fechaDesde) {
        this.fechaDesde = fechaDesde;
    }


    /**
     * Gets the fechaHasta value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return fechaHasta
     */
    public java.util.Calendar getFechaHasta() {
        return fechaHasta;
    }


    /**
     * Sets the fechaHasta value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param fechaHasta
     */
    public void setFechaHasta(java.util.Calendar fechaHasta) {
        this.fechaHasta = fechaHasta;
    }


    /**
     * Gets the codigoSucursal value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return codigoSucursal
     */
    public java.lang.String getCodigoSucursal() {
        return codigoSucursal;
    }


    /**
     * Sets the codigoSucursal value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param codigoSucursal
     */
    public void setCodigoSucursal(java.lang.String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }


    /**
     * Gets the vehiculo value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return vehiculo
     */
    public ar.com.unisolutions.PVehiculo getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param vehiculo
     */
    public void setVehiculo(ar.com.unisolutions.PVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the transporte value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return transporte
     */
    public ar.com.unisolutions.PTransporte getTransporte() {
        return transporte;
    }


    /**
     * Sets the transporte value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param transporte
     */
    public void setTransporte(ar.com.unisolutions.PTransporte transporte) {
        this.transporte = transporte;
    }


    /**
     * Gets the conductor value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return conductor
     */
    public ar.com.unisolutions.PConductor getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param conductor
     */
    public void setConductor(ar.com.unisolutions.PConductor conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the tipoGuia value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return tipoGuia
     */
    public java.lang.String getTipoGuia() {
        return tipoGuia;
    }


    /**
     * Sets the tipoGuia value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param tipoGuia
     */
    public void setTipoGuia(java.lang.String tipoGuia) {
        this.tipoGuia = tipoGuia;
    }


    /**
     * Gets the viaje_ReferenciaExterna value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return viaje_ReferenciaExterna
     */
    public java.lang.String getViaje_ReferenciaExterna() {
        return viaje_ReferenciaExterna;
    }


    /**
     * Sets the viaje_ReferenciaExterna value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param viaje_ReferenciaExterna
     */
    public void setViaje_ReferenciaExterna(java.lang.String viaje_ReferenciaExterna) {
        this.viaje_ReferenciaExterna = viaje_ReferenciaExterna;
    }


    /**
     * Gets the idViaje value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @return idViaje
     */
    public java.lang.Integer getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this ObtenerGuiasLiquidacionAvanzado.
     * 
     * @param idViaje
     */
    public void setIdViaje(java.lang.Integer idViaje) {
        this.idViaje = idViaje;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerGuiasLiquidacionAvanzado)) return false;
        ObtenerGuiasLiquidacionAvanzado other = (ObtenerGuiasLiquidacionAvanzado) obj;
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
            ((this.tipoGuia==null && other.getTipoGuia()==null) || 
             (this.tipoGuia!=null &&
              this.tipoGuia.equals(other.getTipoGuia()))) &&
            ((this.viaje_ReferenciaExterna==null && other.getViaje_ReferenciaExterna()==null) || 
             (this.viaje_ReferenciaExterna!=null &&
              this.viaje_ReferenciaExterna.equals(other.getViaje_ReferenciaExterna()))) &&
            ((this.idViaje==null && other.getIdViaje()==null) || 
             (this.idViaje!=null &&
              this.idViaje.equals(other.getIdViaje())));
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
        if (getTipoGuia() != null) {
            _hashCode += getTipoGuia().hashCode();
        }
        if (getViaje_ReferenciaExterna() != null) {
            _hashCode += getViaje_ReferenciaExterna().hashCode();
        }
        if (getIdViaje() != null) {
            _hashCode += getIdViaje().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerGuiasLiquidacionAvanzado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ObtenerGuiasLiquidacionAvanzado"));
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
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
        elemField.setFieldName("tipoGuia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoGuia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viaje_ReferenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Viaje_ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
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
