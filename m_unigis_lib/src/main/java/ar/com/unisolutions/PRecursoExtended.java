/**
 * PRecursoExtended.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PRecursoExtended  extends ar.com.unisolutions.PRecurso  implements java.io.Serializable {
    private java.lang.String estadoRecurso;

    private ar.com.unisolutions.Persona datosPersona;

    private ar.com.unisolutions.PVehiculoExtended datosVehiculo;

    private ar.com.unisolutions.UbicacionResponse ultimaUbicacion;

    private ar.com.unisolutions.UbicacionRecursoMovimientoDetalle[] movimientosUbicacion;

    public PRecursoExtended() {
    }

    public PRecursoExtended(
           java.lang.String referenciaExterna,
           java.lang.String tipo,
           java.lang.String descripcion,
           java.lang.Double calificacion,
           java.lang.Integer prioridad,
           java.lang.String estadoRecurso,
           ar.com.unisolutions.Persona datosPersona,
           ar.com.unisolutions.PVehiculoExtended datosVehiculo,
           ar.com.unisolutions.UbicacionResponse ultimaUbicacion,
           ar.com.unisolutions.UbicacionRecursoMovimientoDetalle[] movimientosUbicacion) {
        super(
            referenciaExterna,
            tipo,
            descripcion,
            calificacion,
            prioridad);
        this.estadoRecurso = estadoRecurso;
        this.datosPersona = datosPersona;
        this.datosVehiculo = datosVehiculo;
        this.ultimaUbicacion = ultimaUbicacion;
        this.movimientosUbicacion = movimientosUbicacion;
    }


    /**
     * Gets the estadoRecurso value for this PRecursoExtended.
     * 
     * @return estadoRecurso
     */
    public java.lang.String getEstadoRecurso() {
        return estadoRecurso;
    }


    /**
     * Sets the estadoRecurso value for this PRecursoExtended.
     * 
     * @param estadoRecurso
     */
    public void setEstadoRecurso(java.lang.String estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }


    /**
     * Gets the datosPersona value for this PRecursoExtended.
     * 
     * @return datosPersona
     */
    public ar.com.unisolutions.Persona getDatosPersona() {
        return datosPersona;
    }


    /**
     * Sets the datosPersona value for this PRecursoExtended.
     * 
     * @param datosPersona
     */
    public void setDatosPersona(ar.com.unisolutions.Persona datosPersona) {
        this.datosPersona = datosPersona;
    }


    /**
     * Gets the datosVehiculo value for this PRecursoExtended.
     * 
     * @return datosVehiculo
     */
    public ar.com.unisolutions.PVehiculoExtended getDatosVehiculo() {
        return datosVehiculo;
    }


    /**
     * Sets the datosVehiculo value for this PRecursoExtended.
     * 
     * @param datosVehiculo
     */
    public void setDatosVehiculo(ar.com.unisolutions.PVehiculoExtended datosVehiculo) {
        this.datosVehiculo = datosVehiculo;
    }


    /**
     * Gets the ultimaUbicacion value for this PRecursoExtended.
     * 
     * @return ultimaUbicacion
     */
    public ar.com.unisolutions.UbicacionResponse getUltimaUbicacion() {
        return ultimaUbicacion;
    }


    /**
     * Sets the ultimaUbicacion value for this PRecursoExtended.
     * 
     * @param ultimaUbicacion
     */
    public void setUltimaUbicacion(ar.com.unisolutions.UbicacionResponse ultimaUbicacion) {
        this.ultimaUbicacion = ultimaUbicacion;
    }


    /**
     * Gets the movimientosUbicacion value for this PRecursoExtended.
     * 
     * @return movimientosUbicacion
     */
    public ar.com.unisolutions.UbicacionRecursoMovimientoDetalle[] getMovimientosUbicacion() {
        return movimientosUbicacion;
    }


    /**
     * Sets the movimientosUbicacion value for this PRecursoExtended.
     * 
     * @param movimientosUbicacion
     */
    public void setMovimientosUbicacion(ar.com.unisolutions.UbicacionRecursoMovimientoDetalle[] movimientosUbicacion) {
        this.movimientosUbicacion = movimientosUbicacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PRecursoExtended)) return false;
        PRecursoExtended other = (PRecursoExtended) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.estadoRecurso==null && other.getEstadoRecurso()==null) || 
             (this.estadoRecurso!=null &&
              this.estadoRecurso.equals(other.getEstadoRecurso()))) &&
            ((this.datosPersona==null && other.getDatosPersona()==null) || 
             (this.datosPersona!=null &&
              this.datosPersona.equals(other.getDatosPersona()))) &&
            ((this.datosVehiculo==null && other.getDatosVehiculo()==null) || 
             (this.datosVehiculo!=null &&
              this.datosVehiculo.equals(other.getDatosVehiculo()))) &&
            ((this.ultimaUbicacion==null && other.getUltimaUbicacion()==null) || 
             (this.ultimaUbicacion!=null &&
              this.ultimaUbicacion.equals(other.getUltimaUbicacion()))) &&
            ((this.movimientosUbicacion==null && other.getMovimientosUbicacion()==null) || 
             (this.movimientosUbicacion!=null &&
              java.util.Arrays.equals(this.movimientosUbicacion, other.getMovimientosUbicacion())));
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
        if (getEstadoRecurso() != null) {
            _hashCode += getEstadoRecurso().hashCode();
        }
        if (getDatosPersona() != null) {
            _hashCode += getDatosPersona().hashCode();
        }
        if (getDatosVehiculo() != null) {
            _hashCode += getDatosVehiculo().hashCode();
        }
        if (getUltimaUbicacion() != null) {
            _hashCode += getUltimaUbicacion().hashCode();
        }
        if (getMovimientosUbicacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMovimientosUbicacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMovimientosUbicacion(), i);
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
        new org.apache.axis.description.TypeDesc(PRecursoExtended.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoExtended"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosPersona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DatosPersona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Persona"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosVehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DatosVehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculoExtended"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimaUbicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UltimaUbicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UbicacionResponse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("movimientosUbicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "MovimientosUbicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UbicacionRecursoMovimientoDetalle"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UbicacionRecursoMovimientoDetalle"));
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
