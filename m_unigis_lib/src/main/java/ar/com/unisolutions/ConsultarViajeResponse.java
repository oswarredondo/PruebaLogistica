/**
 * ConsultarViajeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajeResponse  implements java.io.Serializable {
    private java.lang.String resultado;

    private boolean viajeFinalizado;

    private java.lang.String estadoViaje;

    private java.lang.String descripcionViaje;

    private java.lang.String referenciaViaje;

    private int cantidadParadas;

    private ar.com.unisolutions.POperacion operacion;

    private ar.com.unisolutions.PDeposito depositoSalida;

    private ar.com.unisolutions.PDeposito depositoLlegada;

    private ar.com.unisolutions.PConductor conductor;

    private ar.com.unisolutions.PVehiculo vehiculo;

    private ar.com.unisolutions.PVehiculo vehiculoSecundario;

    private ar.com.unisolutions.PVehiculo vehiculoTerciario;

    private ar.com.unisolutions.PTransporte transporte;

    private ar.com.unisolutions.PViajeTraceEstado[] traceEstados;

    public ConsultarViajeResponse() {
    }

    public ConsultarViajeResponse(
           java.lang.String resultado,
           boolean viajeFinalizado,
           java.lang.String estadoViaje,
           java.lang.String descripcionViaje,
           java.lang.String referenciaViaje,
           int cantidadParadas,
           ar.com.unisolutions.POperacion operacion,
           ar.com.unisolutions.PDeposito depositoSalida,
           ar.com.unisolutions.PDeposito depositoLlegada,
           ar.com.unisolutions.PConductor conductor,
           ar.com.unisolutions.PVehiculo vehiculo,
           ar.com.unisolutions.PVehiculo vehiculoSecundario,
           ar.com.unisolutions.PVehiculo vehiculoTerciario,
           ar.com.unisolutions.PTransporte transporte,
           ar.com.unisolutions.PViajeTraceEstado[] traceEstados) {
           this.resultado = resultado;
           this.viajeFinalizado = viajeFinalizado;
           this.estadoViaje = estadoViaje;
           this.descripcionViaje = descripcionViaje;
           this.referenciaViaje = referenciaViaje;
           this.cantidadParadas = cantidadParadas;
           this.operacion = operacion;
           this.depositoSalida = depositoSalida;
           this.depositoLlegada = depositoLlegada;
           this.conductor = conductor;
           this.vehiculo = vehiculo;
           this.vehiculoSecundario = vehiculoSecundario;
           this.vehiculoTerciario = vehiculoTerciario;
           this.transporte = transporte;
           this.traceEstados = traceEstados;
    }


    /**
     * Gets the resultado value for this ConsultarViajeResponse.
     * 
     * @return resultado
     */
    public java.lang.String getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this ConsultarViajeResponse.
     * 
     * @param resultado
     */
    public void setResultado(java.lang.String resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the viajeFinalizado value for this ConsultarViajeResponse.
     * 
     * @return viajeFinalizado
     */
    public boolean isViajeFinalizado() {
        return viajeFinalizado;
    }


    /**
     * Sets the viajeFinalizado value for this ConsultarViajeResponse.
     * 
     * @param viajeFinalizado
     */
    public void setViajeFinalizado(boolean viajeFinalizado) {
        this.viajeFinalizado = viajeFinalizado;
    }


    /**
     * Gets the estadoViaje value for this ConsultarViajeResponse.
     * 
     * @return estadoViaje
     */
    public java.lang.String getEstadoViaje() {
        return estadoViaje;
    }


    /**
     * Sets the estadoViaje value for this ConsultarViajeResponse.
     * 
     * @param estadoViaje
     */
    public void setEstadoViaje(java.lang.String estadoViaje) {
        this.estadoViaje = estadoViaje;
    }


    /**
     * Gets the descripcionViaje value for this ConsultarViajeResponse.
     * 
     * @return descripcionViaje
     */
    public java.lang.String getDescripcionViaje() {
        return descripcionViaje;
    }


    /**
     * Sets the descripcionViaje value for this ConsultarViajeResponse.
     * 
     * @param descripcionViaje
     */
    public void setDescripcionViaje(java.lang.String descripcionViaje) {
        this.descripcionViaje = descripcionViaje;
    }


    /**
     * Gets the referenciaViaje value for this ConsultarViajeResponse.
     * 
     * @return referenciaViaje
     */
    public java.lang.String getReferenciaViaje() {
        return referenciaViaje;
    }


    /**
     * Sets the referenciaViaje value for this ConsultarViajeResponse.
     * 
     * @param referenciaViaje
     */
    public void setReferenciaViaje(java.lang.String referenciaViaje) {
        this.referenciaViaje = referenciaViaje;
    }


    /**
     * Gets the cantidadParadas value for this ConsultarViajeResponse.
     * 
     * @return cantidadParadas
     */
    public int getCantidadParadas() {
        return cantidadParadas;
    }


    /**
     * Sets the cantidadParadas value for this ConsultarViajeResponse.
     * 
     * @param cantidadParadas
     */
    public void setCantidadParadas(int cantidadParadas) {
        this.cantidadParadas = cantidadParadas;
    }


    /**
     * Gets the operacion value for this ConsultarViajeResponse.
     * 
     * @return operacion
     */
    public ar.com.unisolutions.POperacion getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this ConsultarViajeResponse.
     * 
     * @param operacion
     */
    public void setOperacion(ar.com.unisolutions.POperacion operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the depositoSalida value for this ConsultarViajeResponse.
     * 
     * @return depositoSalida
     */
    public ar.com.unisolutions.PDeposito getDepositoSalida() {
        return depositoSalida;
    }


    /**
     * Sets the depositoSalida value for this ConsultarViajeResponse.
     * 
     * @param depositoSalida
     */
    public void setDepositoSalida(ar.com.unisolutions.PDeposito depositoSalida) {
        this.depositoSalida = depositoSalida;
    }


    /**
     * Gets the depositoLlegada value for this ConsultarViajeResponse.
     * 
     * @return depositoLlegada
     */
    public ar.com.unisolutions.PDeposito getDepositoLlegada() {
        return depositoLlegada;
    }


    /**
     * Sets the depositoLlegada value for this ConsultarViajeResponse.
     * 
     * @param depositoLlegada
     */
    public void setDepositoLlegada(ar.com.unisolutions.PDeposito depositoLlegada) {
        this.depositoLlegada = depositoLlegada;
    }


    /**
     * Gets the conductor value for this ConsultarViajeResponse.
     * 
     * @return conductor
     */
    public ar.com.unisolutions.PConductor getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this ConsultarViajeResponse.
     * 
     * @param conductor
     */
    public void setConductor(ar.com.unisolutions.PConductor conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the vehiculo value for this ConsultarViajeResponse.
     * 
     * @return vehiculo
     */
    public ar.com.unisolutions.PVehiculo getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this ConsultarViajeResponse.
     * 
     * @param vehiculo
     */
    public void setVehiculo(ar.com.unisolutions.PVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the vehiculoSecundario value for this ConsultarViajeResponse.
     * 
     * @return vehiculoSecundario
     */
    public ar.com.unisolutions.PVehiculo getVehiculoSecundario() {
        return vehiculoSecundario;
    }


    /**
     * Sets the vehiculoSecundario value for this ConsultarViajeResponse.
     * 
     * @param vehiculoSecundario
     */
    public void setVehiculoSecundario(ar.com.unisolutions.PVehiculo vehiculoSecundario) {
        this.vehiculoSecundario = vehiculoSecundario;
    }


    /**
     * Gets the vehiculoTerciario value for this ConsultarViajeResponse.
     * 
     * @return vehiculoTerciario
     */
    public ar.com.unisolutions.PVehiculo getVehiculoTerciario() {
        return vehiculoTerciario;
    }


    /**
     * Sets the vehiculoTerciario value for this ConsultarViajeResponse.
     * 
     * @param vehiculoTerciario
     */
    public void setVehiculoTerciario(ar.com.unisolutions.PVehiculo vehiculoTerciario) {
        this.vehiculoTerciario = vehiculoTerciario;
    }


    /**
     * Gets the transporte value for this ConsultarViajeResponse.
     * 
     * @return transporte
     */
    public ar.com.unisolutions.PTransporte getTransporte() {
        return transporte;
    }


    /**
     * Sets the transporte value for this ConsultarViajeResponse.
     * 
     * @param transporte
     */
    public void setTransporte(ar.com.unisolutions.PTransporte transporte) {
        this.transporte = transporte;
    }


    /**
     * Gets the traceEstados value for this ConsultarViajeResponse.
     * 
     * @return traceEstados
     */
    public ar.com.unisolutions.PViajeTraceEstado[] getTraceEstados() {
        return traceEstados;
    }


    /**
     * Sets the traceEstados value for this ConsultarViajeResponse.
     * 
     * @param traceEstados
     */
    public void setTraceEstados(ar.com.unisolutions.PViajeTraceEstado[] traceEstados) {
        this.traceEstados = traceEstados;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajeResponse)) return false;
        ConsultarViajeResponse other = (ConsultarViajeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            this.viajeFinalizado == other.isViajeFinalizado() &&
            ((this.estadoViaje==null && other.getEstadoViaje()==null) || 
             (this.estadoViaje!=null &&
              this.estadoViaje.equals(other.getEstadoViaje()))) &&
            ((this.descripcionViaje==null && other.getDescripcionViaje()==null) || 
             (this.descripcionViaje!=null &&
              this.descripcionViaje.equals(other.getDescripcionViaje()))) &&
            ((this.referenciaViaje==null && other.getReferenciaViaje()==null) || 
             (this.referenciaViaje!=null &&
              this.referenciaViaje.equals(other.getReferenciaViaje()))) &&
            this.cantidadParadas == other.getCantidadParadas() &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
            ((this.depositoSalida==null && other.getDepositoSalida()==null) || 
             (this.depositoSalida!=null &&
              this.depositoSalida.equals(other.getDepositoSalida()))) &&
            ((this.depositoLlegada==null && other.getDepositoLlegada()==null) || 
             (this.depositoLlegada!=null &&
              this.depositoLlegada.equals(other.getDepositoLlegada()))) &&
            ((this.conductor==null && other.getConductor()==null) || 
             (this.conductor!=null &&
              this.conductor.equals(other.getConductor()))) &&
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo()))) &&
            ((this.vehiculoSecundario==null && other.getVehiculoSecundario()==null) || 
             (this.vehiculoSecundario!=null &&
              this.vehiculoSecundario.equals(other.getVehiculoSecundario()))) &&
            ((this.vehiculoTerciario==null && other.getVehiculoTerciario()==null) || 
             (this.vehiculoTerciario!=null &&
              this.vehiculoTerciario.equals(other.getVehiculoTerciario()))) &&
            ((this.transporte==null && other.getTransporte()==null) || 
             (this.transporte!=null &&
              this.transporte.equals(other.getTransporte()))) &&
            ((this.traceEstados==null && other.getTraceEstados()==null) || 
             (this.traceEstados!=null &&
              java.util.Arrays.equals(this.traceEstados, other.getTraceEstados())));
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
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        _hashCode += (isViajeFinalizado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEstadoViaje() != null) {
            _hashCode += getEstadoViaje().hashCode();
        }
        if (getDescripcionViaje() != null) {
            _hashCode += getDescripcionViaje().hashCode();
        }
        if (getReferenciaViaje() != null) {
            _hashCode += getReferenciaViaje().hashCode();
        }
        _hashCode += getCantidadParadas();
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        if (getDepositoSalida() != null) {
            _hashCode += getDepositoSalida().hashCode();
        }
        if (getDepositoLlegada() != null) {
            _hashCode += getDepositoLlegada().hashCode();
        }
        if (getConductor() != null) {
            _hashCode += getConductor().hashCode();
        }
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        if (getVehiculoSecundario() != null) {
            _hashCode += getVehiculoSecundario().hashCode();
        }
        if (getVehiculoTerciario() != null) {
            _hashCode += getVehiculoTerciario().hashCode();
        }
        if (getTransporte() != null) {
            _hashCode += getTransporte().hashCode();
        }
        if (getTraceEstados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTraceEstados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTraceEstados(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarViajeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viajeFinalizado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ViajeFinalizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DescripcionViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CantidadParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOperacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositoSalida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DepositoSalida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositoLlegada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DepositoLlegada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"));
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
        elemField.setFieldName("vehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Vehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoSecundario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculoSecundario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoTerciario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculoTerciario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("traceEstados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TraceEstados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViajeTraceEstado"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViajeTraceEstado"));
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
