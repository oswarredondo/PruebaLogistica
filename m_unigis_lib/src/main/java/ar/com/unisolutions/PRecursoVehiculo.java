/**
 * PRecursoVehiculo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PRecursoVehiculo  extends ar.com.unisolutions.PRecurso  implements java.io.Serializable {
    private java.lang.String estado;

    private java.lang.String estadoRecurso;

    private ar.com.unisolutions.PVehiculoExtended vehiculo;

    public PRecursoVehiculo() {
    }

    public PRecursoVehiculo(
           java.lang.String referenciaExterna,
           java.lang.String tipo,
           java.lang.String descripcion,
           java.lang.Double calificacion,
           java.lang.Integer prioridad,
           java.lang.String estado,
           java.lang.String estadoRecurso,
           ar.com.unisolutions.PVehiculoExtended vehiculo) {
        super(
            referenciaExterna,
            tipo,
            descripcion,
            calificacion,
            prioridad);
        this.estado = estado;
        this.estadoRecurso = estadoRecurso;
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the estado value for this PRecursoVehiculo.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PRecursoVehiculo.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the estadoRecurso value for this PRecursoVehiculo.
     * 
     * @return estadoRecurso
     */
    public java.lang.String getEstadoRecurso() {
        return estadoRecurso;
    }


    /**
     * Sets the estadoRecurso value for this PRecursoVehiculo.
     * 
     * @param estadoRecurso
     */
    public void setEstadoRecurso(java.lang.String estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }


    /**
     * Gets the vehiculo value for this PRecursoVehiculo.
     * 
     * @return vehiculo
     */
    public ar.com.unisolutions.PVehiculoExtended getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this PRecursoVehiculo.
     * 
     * @param vehiculo
     */
    public void setVehiculo(ar.com.unisolutions.PVehiculoExtended vehiculo) {
        this.vehiculo = vehiculo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PRecursoVehiculo)) return false;
        PRecursoVehiculo other = (PRecursoVehiculo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.estadoRecurso==null && other.getEstadoRecurso()==null) || 
             (this.estadoRecurso!=null &&
              this.estadoRecurso.equals(other.getEstadoRecurso()))) &&
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo())));
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
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getEstadoRecurso() != null) {
            _hashCode += getEstadoRecurso().hashCode();
        }
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PRecursoVehiculo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursoVehiculo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Vehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculoExtended"));
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
