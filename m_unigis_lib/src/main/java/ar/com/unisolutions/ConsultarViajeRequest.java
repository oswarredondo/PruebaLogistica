/**
 * ConsultarViajeRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajeRequest  implements java.io.Serializable {
    private java.lang.String empresa;

    private java.lang.String domicilioOrden;

    private java.lang.String[] listaDeEstadosViajeRequerdidos;

    private java.util.Calendar fecha;

    public ConsultarViajeRequest() {
    }

    public ConsultarViajeRequest(
           java.lang.String empresa,
           java.lang.String domicilioOrden,
           java.lang.String[] listaDeEstadosViajeRequerdidos,
           java.util.Calendar fecha) {
           this.empresa = empresa;
           this.domicilioOrden = domicilioOrden;
           this.listaDeEstadosViajeRequerdidos = listaDeEstadosViajeRequerdidos;
           this.fecha = fecha;
    }


    /**
     * Gets the empresa value for this ConsultarViajeRequest.
     * 
     * @return empresa
     */
    public java.lang.String getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this ConsultarViajeRequest.
     * 
     * @param empresa
     */
    public void setEmpresa(java.lang.String empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the domicilioOrden value for this ConsultarViajeRequest.
     * 
     * @return domicilioOrden
     */
    public java.lang.String getDomicilioOrden() {
        return domicilioOrden;
    }


    /**
     * Sets the domicilioOrden value for this ConsultarViajeRequest.
     * 
     * @param domicilioOrden
     */
    public void setDomicilioOrden(java.lang.String domicilioOrden) {
        this.domicilioOrden = domicilioOrden;
    }


    /**
     * Gets the listaDeEstadosViajeRequerdidos value for this ConsultarViajeRequest.
     * 
     * @return listaDeEstadosViajeRequerdidos
     */
    public java.lang.String[] getListaDeEstadosViajeRequerdidos() {
        return listaDeEstadosViajeRequerdidos;
    }


    /**
     * Sets the listaDeEstadosViajeRequerdidos value for this ConsultarViajeRequest.
     * 
     * @param listaDeEstadosViajeRequerdidos
     */
    public void setListaDeEstadosViajeRequerdidos(java.lang.String[] listaDeEstadosViajeRequerdidos) {
        this.listaDeEstadosViajeRequerdidos = listaDeEstadosViajeRequerdidos;
    }


    /**
     * Gets the fecha value for this ConsultarViajeRequest.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ConsultarViajeRequest.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajeRequest)) return false;
        ConsultarViajeRequest other = (ConsultarViajeRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa()))) &&
            ((this.domicilioOrden==null && other.getDomicilioOrden()==null) || 
             (this.domicilioOrden!=null &&
              this.domicilioOrden.equals(other.getDomicilioOrden()))) &&
            ((this.listaDeEstadosViajeRequerdidos==null && other.getListaDeEstadosViajeRequerdidos()==null) || 
             (this.listaDeEstadosViajeRequerdidos!=null &&
              java.util.Arrays.equals(this.listaDeEstadosViajeRequerdidos, other.getListaDeEstadosViajeRequerdidos()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha())));
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
        if (getEmpresa() != null) {
            _hashCode += getEmpresa().hashCode();
        }
        if (getDomicilioOrden() != null) {
            _hashCode += getDomicilioOrden().hashCode();
        }
        if (getListaDeEstadosViajeRequerdidos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaDeEstadosViajeRequerdidos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaDeEstadosViajeRequerdidos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarViajeRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "empresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "domicilioOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDeEstadosViajeRequerdidos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "listaDeEstadosViajeRequerdidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
