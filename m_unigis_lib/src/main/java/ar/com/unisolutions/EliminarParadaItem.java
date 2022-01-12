/**
 * EliminarParadaItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class EliminarParadaItem  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.lang.String referenciaExternaParada;

    private java.lang.String referenciaExternaItem;

    private java.util.Calendar fecha;

    private java.lang.String sucursal;

    private java.lang.String operacion;

    public EliminarParadaItem() {
    }

    public EliminarParadaItem(
           java.lang.String apiKey,
           java.lang.String referenciaExternaParada,
           java.lang.String referenciaExternaItem,
           java.util.Calendar fecha,
           java.lang.String sucursal,
           java.lang.String operacion) {
           this.apiKey = apiKey;
           this.referenciaExternaParada = referenciaExternaParada;
           this.referenciaExternaItem = referenciaExternaItem;
           this.fecha = fecha;
           this.sucursal = sucursal;
           this.operacion = operacion;
    }


    /**
     * Gets the apiKey value for this EliminarParadaItem.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this EliminarParadaItem.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the referenciaExternaParada value for this EliminarParadaItem.
     * 
     * @return referenciaExternaParada
     */
    public java.lang.String getReferenciaExternaParada() {
        return referenciaExternaParada;
    }


    /**
     * Sets the referenciaExternaParada value for this EliminarParadaItem.
     * 
     * @param referenciaExternaParada
     */
    public void setReferenciaExternaParada(java.lang.String referenciaExternaParada) {
        this.referenciaExternaParada = referenciaExternaParada;
    }


    /**
     * Gets the referenciaExternaItem value for this EliminarParadaItem.
     * 
     * @return referenciaExternaItem
     */
    public java.lang.String getReferenciaExternaItem() {
        return referenciaExternaItem;
    }


    /**
     * Sets the referenciaExternaItem value for this EliminarParadaItem.
     * 
     * @param referenciaExternaItem
     */
    public void setReferenciaExternaItem(java.lang.String referenciaExternaItem) {
        this.referenciaExternaItem = referenciaExternaItem;
    }


    /**
     * Gets the fecha value for this EliminarParadaItem.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this EliminarParadaItem.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the sucursal value for this EliminarParadaItem.
     * 
     * @return sucursal
     */
    public java.lang.String getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this EliminarParadaItem.
     * 
     * @param sucursal
     */
    public void setSucursal(java.lang.String sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the operacion value for this EliminarParadaItem.
     * 
     * @return operacion
     */
    public java.lang.String getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this EliminarParadaItem.
     * 
     * @param operacion
     */
    public void setOperacion(java.lang.String operacion) {
        this.operacion = operacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EliminarParadaItem)) return false;
        EliminarParadaItem other = (EliminarParadaItem) obj;
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
            ((this.referenciaExternaParada==null && other.getReferenciaExternaParada()==null) || 
             (this.referenciaExternaParada!=null &&
              this.referenciaExternaParada.equals(other.getReferenciaExternaParada()))) &&
            ((this.referenciaExternaItem==null && other.getReferenciaExternaItem()==null) || 
             (this.referenciaExternaItem!=null &&
              this.referenciaExternaItem.equals(other.getReferenciaExternaItem()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion())));
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
        if (getReferenciaExternaParada() != null) {
            _hashCode += getReferenciaExternaParada().hashCode();
        }
        if (getReferenciaExternaItem() != null) {
            _hashCode += getReferenciaExternaItem().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getSucursal() != null) {
            _hashCode += getSucursal().hashCode();
        }
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EliminarParadaItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">EliminarParadaItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExternaParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExternaItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"));
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
