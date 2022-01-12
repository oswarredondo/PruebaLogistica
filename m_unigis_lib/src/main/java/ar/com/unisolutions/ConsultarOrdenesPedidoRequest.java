/**
 * ConsultarOrdenesPedidoRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarOrdenesPedidoRequest  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.util.Calendar fechaDesde;

    private java.util.Calendar fechaHasta;

    private java.lang.String referenciaExterna;

    private java.lang.String clienteDador_ReferenciaExterna;

    private java.lang.String incluirEstadosPedido;

    public ConsultarOrdenesPedidoRequest() {
    }

    public ConsultarOrdenesPedidoRequest(
           java.lang.String apiKey,
           java.util.Calendar fechaDesde,
           java.util.Calendar fechaHasta,
           java.lang.String referenciaExterna,
           java.lang.String clienteDador_ReferenciaExterna,
           java.lang.String incluirEstadosPedido) {
           this.apiKey = apiKey;
           this.fechaDesde = fechaDesde;
           this.fechaHasta = fechaHasta;
           this.referenciaExterna = referenciaExterna;
           this.clienteDador_ReferenciaExterna = clienteDador_ReferenciaExterna;
           this.incluirEstadosPedido = incluirEstadosPedido;
    }


    /**
     * Gets the apiKey value for this ConsultarOrdenesPedidoRequest.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ConsultarOrdenesPedidoRequest.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the fechaDesde value for this ConsultarOrdenesPedidoRequest.
     * 
     * @return fechaDesde
     */
    public java.util.Calendar getFechaDesde() {
        return fechaDesde;
    }


    /**
     * Sets the fechaDesde value for this ConsultarOrdenesPedidoRequest.
     * 
     * @param fechaDesde
     */
    public void setFechaDesde(java.util.Calendar fechaDesde) {
        this.fechaDesde = fechaDesde;
    }


    /**
     * Gets the fechaHasta value for this ConsultarOrdenesPedidoRequest.
     * 
     * @return fechaHasta
     */
    public java.util.Calendar getFechaHasta() {
        return fechaHasta;
    }


    /**
     * Sets the fechaHasta value for this ConsultarOrdenesPedidoRequest.
     * 
     * @param fechaHasta
     */
    public void setFechaHasta(java.util.Calendar fechaHasta) {
        this.fechaHasta = fechaHasta;
    }


    /**
     * Gets the referenciaExterna value for this ConsultarOrdenesPedidoRequest.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this ConsultarOrdenesPedidoRequest.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the clienteDador_ReferenciaExterna value for this ConsultarOrdenesPedidoRequest.
     * 
     * @return clienteDador_ReferenciaExterna
     */
    public java.lang.String getClienteDador_ReferenciaExterna() {
        return clienteDador_ReferenciaExterna;
    }


    /**
     * Sets the clienteDador_ReferenciaExterna value for this ConsultarOrdenesPedidoRequest.
     * 
     * @param clienteDador_ReferenciaExterna
     */
    public void setClienteDador_ReferenciaExterna(java.lang.String clienteDador_ReferenciaExterna) {
        this.clienteDador_ReferenciaExterna = clienteDador_ReferenciaExterna;
    }


    /**
     * Gets the incluirEstadosPedido value for this ConsultarOrdenesPedidoRequest.
     * 
     * @return incluirEstadosPedido
     */
    public java.lang.String getIncluirEstadosPedido() {
        return incluirEstadosPedido;
    }


    /**
     * Sets the incluirEstadosPedido value for this ConsultarOrdenesPedidoRequest.
     * 
     * @param incluirEstadosPedido
     */
    public void setIncluirEstadosPedido(java.lang.String incluirEstadosPedido) {
        this.incluirEstadosPedido = incluirEstadosPedido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarOrdenesPedidoRequest)) return false;
        ConsultarOrdenesPedidoRequest other = (ConsultarOrdenesPedidoRequest) obj;
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
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.clienteDador_ReferenciaExterna==null && other.getClienteDador_ReferenciaExterna()==null) || 
             (this.clienteDador_ReferenciaExterna!=null &&
              this.clienteDador_ReferenciaExterna.equals(other.getClienteDador_ReferenciaExterna()))) &&
            ((this.incluirEstadosPedido==null && other.getIncluirEstadosPedido()==null) || 
             (this.incluirEstadosPedido!=null &&
              this.incluirEstadosPedido.equals(other.getIncluirEstadosPedido())));
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
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getClienteDador_ReferenciaExterna() != null) {
            _hashCode += getClienteDador_ReferenciaExterna().hashCode();
        }
        if (getIncluirEstadosPedido() != null) {
            _hashCode += getIncluirEstadosPedido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarOrdenesPedidoRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarOrdenesPedidoRequest"));
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
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clienteDador_ReferenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ClienteDador_ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incluirEstadosPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IncluirEstadosPedido"));
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
