/**
 * ConsultarViajePorFechas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajePorFechas  implements java.io.Serializable {
    private java.lang.String apiKey;

    private java.util.Calendar fechaJornadaDesde;

    private java.util.Calendar fechaJornadaHasta;

    private int pagina;

    private boolean cargarParadas;

    private boolean cargarItems;

    private boolean cargarIncidencias;

    private boolean cargarRecursos;

    private boolean cargarEstadoParada;

    private boolean cargarUltimaParadaVisitada;

    private boolean cargarTransporte;

    public ConsultarViajePorFechas() {
    }

    public ConsultarViajePorFechas(
           java.lang.String apiKey,
           java.util.Calendar fechaJornadaDesde,
           java.util.Calendar fechaJornadaHasta,
           int pagina,
           boolean cargarParadas,
           boolean cargarItems,
           boolean cargarIncidencias,
           boolean cargarRecursos,
           boolean cargarEstadoParada,
           boolean cargarUltimaParadaVisitada,
           boolean cargarTransporte) {
           this.apiKey = apiKey;
           this.fechaJornadaDesde = fechaJornadaDesde;
           this.fechaJornadaHasta = fechaJornadaHasta;
           this.pagina = pagina;
           this.cargarParadas = cargarParadas;
           this.cargarItems = cargarItems;
           this.cargarIncidencias = cargarIncidencias;
           this.cargarRecursos = cargarRecursos;
           this.cargarEstadoParada = cargarEstadoParada;
           this.cargarUltimaParadaVisitada = cargarUltimaParadaVisitada;
           this.cargarTransporte = cargarTransporte;
    }


    /**
     * Gets the apiKey value for this ConsultarViajePorFechas.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this ConsultarViajePorFechas.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the fechaJornadaDesde value for this ConsultarViajePorFechas.
     * 
     * @return fechaJornadaDesde
     */
    public java.util.Calendar getFechaJornadaDesde() {
        return fechaJornadaDesde;
    }


    /**
     * Sets the fechaJornadaDesde value for this ConsultarViajePorFechas.
     * 
     * @param fechaJornadaDesde
     */
    public void setFechaJornadaDesde(java.util.Calendar fechaJornadaDesde) {
        this.fechaJornadaDesde = fechaJornadaDesde;
    }


    /**
     * Gets the fechaJornadaHasta value for this ConsultarViajePorFechas.
     * 
     * @return fechaJornadaHasta
     */
    public java.util.Calendar getFechaJornadaHasta() {
        return fechaJornadaHasta;
    }


    /**
     * Sets the fechaJornadaHasta value for this ConsultarViajePorFechas.
     * 
     * @param fechaJornadaHasta
     */
    public void setFechaJornadaHasta(java.util.Calendar fechaJornadaHasta) {
        this.fechaJornadaHasta = fechaJornadaHasta;
    }


    /**
     * Gets the pagina value for this ConsultarViajePorFechas.
     * 
     * @return pagina
     */
    public int getPagina() {
        return pagina;
    }


    /**
     * Sets the pagina value for this ConsultarViajePorFechas.
     * 
     * @param pagina
     */
    public void setPagina(int pagina) {
        this.pagina = pagina;
    }


    /**
     * Gets the cargarParadas value for this ConsultarViajePorFechas.
     * 
     * @return cargarParadas
     */
    public boolean isCargarParadas() {
        return cargarParadas;
    }


    /**
     * Sets the cargarParadas value for this ConsultarViajePorFechas.
     * 
     * @param cargarParadas
     */
    public void setCargarParadas(boolean cargarParadas) {
        this.cargarParadas = cargarParadas;
    }


    /**
     * Gets the cargarItems value for this ConsultarViajePorFechas.
     * 
     * @return cargarItems
     */
    public boolean isCargarItems() {
        return cargarItems;
    }


    /**
     * Sets the cargarItems value for this ConsultarViajePorFechas.
     * 
     * @param cargarItems
     */
    public void setCargarItems(boolean cargarItems) {
        this.cargarItems = cargarItems;
    }


    /**
     * Gets the cargarIncidencias value for this ConsultarViajePorFechas.
     * 
     * @return cargarIncidencias
     */
    public boolean isCargarIncidencias() {
        return cargarIncidencias;
    }


    /**
     * Sets the cargarIncidencias value for this ConsultarViajePorFechas.
     * 
     * @param cargarIncidencias
     */
    public void setCargarIncidencias(boolean cargarIncidencias) {
        this.cargarIncidencias = cargarIncidencias;
    }


    /**
     * Gets the cargarRecursos value for this ConsultarViajePorFechas.
     * 
     * @return cargarRecursos
     */
    public boolean isCargarRecursos() {
        return cargarRecursos;
    }


    /**
     * Sets the cargarRecursos value for this ConsultarViajePorFechas.
     * 
     * @param cargarRecursos
     */
    public void setCargarRecursos(boolean cargarRecursos) {
        this.cargarRecursos = cargarRecursos;
    }


    /**
     * Gets the cargarEstadoParada value for this ConsultarViajePorFechas.
     * 
     * @return cargarEstadoParada
     */
    public boolean isCargarEstadoParada() {
        return cargarEstadoParada;
    }


    /**
     * Sets the cargarEstadoParada value for this ConsultarViajePorFechas.
     * 
     * @param cargarEstadoParada
     */
    public void setCargarEstadoParada(boolean cargarEstadoParada) {
        this.cargarEstadoParada = cargarEstadoParada;
    }


    /**
     * Gets the cargarUltimaParadaVisitada value for this ConsultarViajePorFechas.
     * 
     * @return cargarUltimaParadaVisitada
     */
    public boolean isCargarUltimaParadaVisitada() {
        return cargarUltimaParadaVisitada;
    }


    /**
     * Sets the cargarUltimaParadaVisitada value for this ConsultarViajePorFechas.
     * 
     * @param cargarUltimaParadaVisitada
     */
    public void setCargarUltimaParadaVisitada(boolean cargarUltimaParadaVisitada) {
        this.cargarUltimaParadaVisitada = cargarUltimaParadaVisitada;
    }


    /**
     * Gets the cargarTransporte value for this ConsultarViajePorFechas.
     * 
     * @return cargarTransporte
     */
    public boolean isCargarTransporte() {
        return cargarTransporte;
    }


    /**
     * Sets the cargarTransporte value for this ConsultarViajePorFechas.
     * 
     * @param cargarTransporte
     */
    public void setCargarTransporte(boolean cargarTransporte) {
        this.cargarTransporte = cargarTransporte;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajePorFechas)) return false;
        ConsultarViajePorFechas other = (ConsultarViajePorFechas) obj;
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
            ((this.fechaJornadaDesde==null && other.getFechaJornadaDesde()==null) || 
             (this.fechaJornadaDesde!=null &&
              this.fechaJornadaDesde.equals(other.getFechaJornadaDesde()))) &&
            ((this.fechaJornadaHasta==null && other.getFechaJornadaHasta()==null) || 
             (this.fechaJornadaHasta!=null &&
              this.fechaJornadaHasta.equals(other.getFechaJornadaHasta()))) &&
            this.pagina == other.getPagina() &&
            this.cargarParadas == other.isCargarParadas() &&
            this.cargarItems == other.isCargarItems() &&
            this.cargarIncidencias == other.isCargarIncidencias() &&
            this.cargarRecursos == other.isCargarRecursos() &&
            this.cargarEstadoParada == other.isCargarEstadoParada() &&
            this.cargarUltimaParadaVisitada == other.isCargarUltimaParadaVisitada() &&
            this.cargarTransporte == other.isCargarTransporte();
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
        if (getFechaJornadaDesde() != null) {
            _hashCode += getFechaJornadaDesde().hashCode();
        }
        if (getFechaJornadaHasta() != null) {
            _hashCode += getFechaJornadaHasta().hashCode();
        }
        _hashCode += getPagina();
        _hashCode += (isCargarParadas() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCargarItems() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCargarIncidencias() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCargarRecursos() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCargarEstadoParada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCargarUltimaParadaVisitada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCargarTransporte() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarViajePorFechas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">ConsultarViajePorFechas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaJornadaDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaJornadaDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaJornadaHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaJornadaHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagina");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pagina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargarParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargarItems");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargarIncidencias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarIncidencias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargarRecursos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarRecursos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargarEstadoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarEstadoParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargarUltimaParadaVisitada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarUltimaParadaVisitada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargarTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargarTransporte"));
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
