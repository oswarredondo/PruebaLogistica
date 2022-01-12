/**
 * PEstadiaParadaVisita.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PEstadiaParadaVisita  implements java.io.Serializable {
    private java.util.Calendar inicioVisita;

    private java.util.Calendar finVisita;

    private int duracion;

    private double latitud;

    private double longitud;

    private int idParada;

    private int idViaje;

    private java.lang.String dominio;

    private java.lang.String viajeReferenciaExterna;

    public PEstadiaParadaVisita() {
    }

    public PEstadiaParadaVisita(
           java.util.Calendar inicioVisita,
           java.util.Calendar finVisita,
           int duracion,
           double latitud,
           double longitud,
           int idParada,
           int idViaje,
           java.lang.String dominio,
           java.lang.String viajeReferenciaExterna) {
           this.inicioVisita = inicioVisita;
           this.finVisita = finVisita;
           this.duracion = duracion;
           this.latitud = latitud;
           this.longitud = longitud;
           this.idParada = idParada;
           this.idViaje = idViaje;
           this.dominio = dominio;
           this.viajeReferenciaExterna = viajeReferenciaExterna;
    }


    /**
     * Gets the inicioVisita value for this PEstadiaParadaVisita.
     * 
     * @return inicioVisita
     */
    public java.util.Calendar getInicioVisita() {
        return inicioVisita;
    }


    /**
     * Sets the inicioVisita value for this PEstadiaParadaVisita.
     * 
     * @param inicioVisita
     */
    public void setInicioVisita(java.util.Calendar inicioVisita) {
        this.inicioVisita = inicioVisita;
    }


    /**
     * Gets the finVisita value for this PEstadiaParadaVisita.
     * 
     * @return finVisita
     */
    public java.util.Calendar getFinVisita() {
        return finVisita;
    }


    /**
     * Sets the finVisita value for this PEstadiaParadaVisita.
     * 
     * @param finVisita
     */
    public void setFinVisita(java.util.Calendar finVisita) {
        this.finVisita = finVisita;
    }


    /**
     * Gets the duracion value for this PEstadiaParadaVisita.
     * 
     * @return duracion
     */
    public int getDuracion() {
        return duracion;
    }


    /**
     * Sets the duracion value for this PEstadiaParadaVisita.
     * 
     * @param duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    /**
     * Gets the latitud value for this PEstadiaParadaVisita.
     * 
     * @return latitud
     */
    public double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this PEstadiaParadaVisita.
     * 
     * @param latitud
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this PEstadiaParadaVisita.
     * 
     * @return longitud
     */
    public double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this PEstadiaParadaVisita.
     * 
     * @param longitud
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the idParada value for this PEstadiaParadaVisita.
     * 
     * @return idParada
     */
    public int getIdParada() {
        return idParada;
    }


    /**
     * Sets the idParada value for this PEstadiaParadaVisita.
     * 
     * @param idParada
     */
    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }


    /**
     * Gets the idViaje value for this PEstadiaParadaVisita.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PEstadiaParadaVisita.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the dominio value for this PEstadiaParadaVisita.
     * 
     * @return dominio
     */
    public java.lang.String getDominio() {
        return dominio;
    }


    /**
     * Sets the dominio value for this PEstadiaParadaVisita.
     * 
     * @param dominio
     */
    public void setDominio(java.lang.String dominio) {
        this.dominio = dominio;
    }


    /**
     * Gets the viajeReferenciaExterna value for this PEstadiaParadaVisita.
     * 
     * @return viajeReferenciaExterna
     */
    public java.lang.String getViajeReferenciaExterna() {
        return viajeReferenciaExterna;
    }


    /**
     * Sets the viajeReferenciaExterna value for this PEstadiaParadaVisita.
     * 
     * @param viajeReferenciaExterna
     */
    public void setViajeReferenciaExterna(java.lang.String viajeReferenciaExterna) {
        this.viajeReferenciaExterna = viajeReferenciaExterna;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PEstadiaParadaVisita)) return false;
        PEstadiaParadaVisita other = (PEstadiaParadaVisita) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.inicioVisita==null && other.getInicioVisita()==null) || 
             (this.inicioVisita!=null &&
              this.inicioVisita.equals(other.getInicioVisita()))) &&
            ((this.finVisita==null && other.getFinVisita()==null) || 
             (this.finVisita!=null &&
              this.finVisita.equals(other.getFinVisita()))) &&
            this.duracion == other.getDuracion() &&
            this.latitud == other.getLatitud() &&
            this.longitud == other.getLongitud() &&
            this.idParada == other.getIdParada() &&
            this.idViaje == other.getIdViaje() &&
            ((this.dominio==null && other.getDominio()==null) || 
             (this.dominio!=null &&
              this.dominio.equals(other.getDominio()))) &&
            ((this.viajeReferenciaExterna==null && other.getViajeReferenciaExterna()==null) || 
             (this.viajeReferenciaExterna!=null &&
              this.viajeReferenciaExterna.equals(other.getViajeReferenciaExterna())));
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
        if (getInicioVisita() != null) {
            _hashCode += getInicioVisita().hashCode();
        }
        if (getFinVisita() != null) {
            _hashCode += getFinVisita().hashCode();
        }
        _hashCode += getDuracion();
        _hashCode += new Double(getLatitud()).hashCode();
        _hashCode += new Double(getLongitud()).hashCode();
        _hashCode += getIdParada();
        _hashCode += getIdViaje();
        if (getDominio() != null) {
            _hashCode += getDominio().hashCode();
        }
        if (getViajeReferenciaExterna() != null) {
            _hashCode += getViajeReferenciaExterna().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PEstadiaParadaVisita.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadiaParadaVisita"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioVisita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioVisita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finVisita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinVisita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Duracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Latitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Longitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dominio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viajeReferenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ViajeReferenciaExterna"));
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
