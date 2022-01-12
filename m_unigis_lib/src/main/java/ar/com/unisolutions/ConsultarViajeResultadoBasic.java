/**
 * ConsultarViajeResultadoBasic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajeResultadoBasic  extends ar.com.unisolutions.ConsultarViajeResultado  implements java.io.Serializable {
    private java.util.Calendar fechaInicioCarga;

    private java.util.Calendar fechaCreacion;

    private ar.com.unisolutions.PViajeTraceEstado[] traceEstados;

    public ConsultarViajeResultadoBasic() {
    }

    public ConsultarViajeResultadoBasic(
           java.lang.String referenciaExterna,
           java.lang.String descripcion,
           java.lang.String resultado,
           boolean viajeFinalizado,
           java.lang.String estadoViaje,
           java.lang.String estadoSeguimiento,
           java.lang.String vehiculoEstadoSeguimiento,
           int cantidadParadas,
           int paradaVisitada,
           java.util.Calendar fechaParadaVisitada,
           java.lang.String refCliente,
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           java.lang.Double kmsPlan,
           java.lang.Double kmsRecorridos,
           java.util.Calendar fechaInicioReal,
           java.util.Calendar fechaFinReal,
           java.util.Calendar fechaInicioPlan,
           java.util.Calendar fechaFinPlan,
           ar.com.unisolutions.PDeposito depositoSalida,
           ar.com.unisolutions.PDeposito depositoLlegada,
           ar.com.unisolutions.PVehiculo vehiculo,
           ar.com.unisolutions.PVehiculo vehiculoSecundario,
           ar.com.unisolutions.PVehiculo vehiculoTerciario,
           java.lang.String categoriaViaje,
           java.lang.String tipoViaje,
           java.lang.String recorrido,
           ar.com.unisolutions.POperacion operacion,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           java.lang.String varchar4,
           java.lang.String varchar5,
           java.lang.String varchar6,
           java.lang.Double float1,
           java.lang.Double float2,
           java.lang.Double peso,
           java.lang.Double volumen,
           java.lang.Double bultos,
           java.lang.Double pallets,
           ar.com.unisolutions.PConductor conductor,
           ar.com.unisolutions.PTransporte transporte,
           ar.com.unisolutions.PRecurso[] recursosViaje,
           ar.com.unisolutions.PParada[] paradas,
           ar.com.unisolutions.PIncidencia[] incidencias,
           java.util.Calendar fechaInicioCarga,
           java.util.Calendar fechaCreacion,
           ar.com.unisolutions.PViajeTraceEstado[] traceEstados) {
        super(
            referenciaExterna,
            descripcion,
            resultado,
            viajeFinalizado,
            estadoViaje,
            estadoSeguimiento,
            vehiculoEstadoSeguimiento,
            cantidadParadas,
            paradaVisitada,
            fechaParadaVisitada,
            refCliente,
            refDocumento,
            refDocumentoAdicional,
            kmsPlan,
            kmsRecorridos,
            fechaInicioReal,
            fechaFinReal,
            fechaInicioPlan,
            fechaFinPlan,
            depositoSalida,
            depositoLlegada,
            vehiculo,
            vehiculoSecundario,
            vehiculoTerciario,
            categoriaViaje,
            tipoViaje,
            recorrido,
            operacion,
            varchar1,
            varchar2,
            varchar3,
            varchar4,
            varchar5,
            varchar6,
            float1,
            float2,
            peso,
            volumen,
            bultos,
            pallets,
            conductor,
            transporte,
            recursosViaje,
            paradas,
            incidencias);
        this.fechaInicioCarga = fechaInicioCarga;
        this.fechaCreacion = fechaCreacion;
        this.traceEstados = traceEstados;
    }


    /**
     * Gets the fechaInicioCarga value for this ConsultarViajeResultadoBasic.
     * 
     * @return fechaInicioCarga
     */
    public java.util.Calendar getFechaInicioCarga() {
        return fechaInicioCarga;
    }


    /**
     * Sets the fechaInicioCarga value for this ConsultarViajeResultadoBasic.
     * 
     * @param fechaInicioCarga
     */
    public void setFechaInicioCarga(java.util.Calendar fechaInicioCarga) {
        this.fechaInicioCarga = fechaInicioCarga;
    }


    /**
     * Gets the fechaCreacion value for this ConsultarViajeResultadoBasic.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this ConsultarViajeResultadoBasic.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the traceEstados value for this ConsultarViajeResultadoBasic.
     * 
     * @return traceEstados
     */
    public ar.com.unisolutions.PViajeTraceEstado[] getTraceEstados() {
        return traceEstados;
    }


    /**
     * Sets the traceEstados value for this ConsultarViajeResultadoBasic.
     * 
     * @param traceEstados
     */
    public void setTraceEstados(ar.com.unisolutions.PViajeTraceEstado[] traceEstados) {
        this.traceEstados = traceEstados;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajeResultadoBasic)) return false;
        ConsultarViajeResultadoBasic other = (ConsultarViajeResultadoBasic) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.fechaInicioCarga==null && other.getFechaInicioCarga()==null) || 
             (this.fechaInicioCarga!=null &&
              this.fechaInicioCarga.equals(other.getFechaInicioCarga()))) &&
            ((this.fechaCreacion==null && other.getFechaCreacion()==null) || 
             (this.fechaCreacion!=null &&
              this.fechaCreacion.equals(other.getFechaCreacion()))) &&
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
        int _hashCode = super.hashCode();
        if (getFechaInicioCarga() != null) {
            _hashCode += getFechaInicioCarga().hashCode();
        }
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
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
        new org.apache.axis.description.TypeDesc(ConsultarViajeResultadoBasic.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultadoBasic"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicioCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaInicioCarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCreacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCreacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
