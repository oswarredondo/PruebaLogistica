/**
 * PCodigoControl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PCodigoControl  implements java.io.Serializable {
    private java.lang.String vehiculo;

    private java.lang.String tipoCodigoControl;

    private java.lang.String codigo;

    private java.lang.String agrupador;

    private java.lang.Integer numerador;

    private boolean habilitado;

    public PCodigoControl() {
    }

    public PCodigoControl(
           java.lang.String vehiculo,
           java.lang.String tipoCodigoControl,
           java.lang.String codigo,
           java.lang.String agrupador,
           java.lang.Integer numerador,
           boolean habilitado) {
           this.vehiculo = vehiculo;
           this.tipoCodigoControl = tipoCodigoControl;
           this.codigo = codigo;
           this.agrupador = agrupador;
           this.numerador = numerador;
           this.habilitado = habilitado;
    }


    /**
     * Gets the vehiculo value for this PCodigoControl.
     * 
     * @return vehiculo
     */
    public java.lang.String getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this PCodigoControl.
     * 
     * @param vehiculo
     */
    public void setVehiculo(java.lang.String vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the tipoCodigoControl value for this PCodigoControl.
     * 
     * @return tipoCodigoControl
     */
    public java.lang.String getTipoCodigoControl() {
        return tipoCodigoControl;
    }


    /**
     * Sets the tipoCodigoControl value for this PCodigoControl.
     * 
     * @param tipoCodigoControl
     */
    public void setTipoCodigoControl(java.lang.String tipoCodigoControl) {
        this.tipoCodigoControl = tipoCodigoControl;
    }


    /**
     * Gets the codigo value for this PCodigoControl.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this PCodigoControl.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the agrupador value for this PCodigoControl.
     * 
     * @return agrupador
     */
    public java.lang.String getAgrupador() {
        return agrupador;
    }


    /**
     * Sets the agrupador value for this PCodigoControl.
     * 
     * @param agrupador
     */
    public void setAgrupador(java.lang.String agrupador) {
        this.agrupador = agrupador;
    }


    /**
     * Gets the numerador value for this PCodigoControl.
     * 
     * @return numerador
     */
    public java.lang.Integer getNumerador() {
        return numerador;
    }


    /**
     * Sets the numerador value for this PCodigoControl.
     * 
     * @param numerador
     */
    public void setNumerador(java.lang.Integer numerador) {
        this.numerador = numerador;
    }


    /**
     * Gets the habilitado value for this PCodigoControl.
     * 
     * @return habilitado
     */
    public boolean isHabilitado() {
        return habilitado;
    }


    /**
     * Sets the habilitado value for this PCodigoControl.
     * 
     * @param habilitado
     */
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PCodigoControl)) return false;
        PCodigoControl other = (PCodigoControl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo()))) &&
            ((this.tipoCodigoControl==null && other.getTipoCodigoControl()==null) || 
             (this.tipoCodigoControl!=null &&
              this.tipoCodigoControl.equals(other.getTipoCodigoControl()))) &&
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.agrupador==null && other.getAgrupador()==null) || 
             (this.agrupador!=null &&
              this.agrupador.equals(other.getAgrupador()))) &&
            ((this.numerador==null && other.getNumerador()==null) || 
             (this.numerador!=null &&
              this.numerador.equals(other.getNumerador()))) &&
            this.habilitado == other.isHabilitado();
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
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        if (getTipoCodigoControl() != null) {
            _hashCode += getTipoCodigoControl().hashCode();
        }
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getAgrupador() != null) {
            _hashCode += getAgrupador().hashCode();
        }
        if (getNumerador() != null) {
            _hashCode += getNumerador().hashCode();
        }
        _hashCode += (isHabilitado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PCodigoControl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCodigoControl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "vehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCodigoControl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoCodigoControl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agrupador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Agrupador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numerador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Numerador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("habilitado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Habilitado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
