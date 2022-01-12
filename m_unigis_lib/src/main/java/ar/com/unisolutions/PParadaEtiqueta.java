/**
 * PParadaEtiqueta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PParadaEtiqueta  implements java.io.Serializable {
    private int id;

    private java.lang.String parada__ReferenciaExterna;

    private java.lang.String viaje__ReferenciaExterna;

    private int idViaje;

    private java.lang.String estadoViaje;

    private java.lang.Double kmsRecorridos;

    private java.lang.Integer idRuta;

    private long idJornada;

    private int bultos;

    private java.lang.String etiqueta;

    private java.lang.String usuario;

    private java.util.Calendar fecha;

    public PParadaEtiqueta() {
    }

    public PParadaEtiqueta(
           int id,
           java.lang.String parada__ReferenciaExterna,
           java.lang.String viaje__ReferenciaExterna,
           int idViaje,
           java.lang.String estadoViaje,
           java.lang.Double kmsRecorridos,
           java.lang.Integer idRuta,
           long idJornada,
           int bultos,
           java.lang.String etiqueta,
           java.lang.String usuario,
           java.util.Calendar fecha) {
           this.id = id;
           this.parada__ReferenciaExterna = parada__ReferenciaExterna;
           this.viaje__ReferenciaExterna = viaje__ReferenciaExterna;
           this.idViaje = idViaje;
           this.estadoViaje = estadoViaje;
           this.kmsRecorridos = kmsRecorridos;
           this.idRuta = idRuta;
           this.idJornada = idJornada;
           this.bultos = bultos;
           this.etiqueta = etiqueta;
           this.usuario = usuario;
           this.fecha = fecha;
    }


    /**
     * Gets the id value for this PParadaEtiqueta.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this PParadaEtiqueta.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the parada__ReferenciaExterna value for this PParadaEtiqueta.
     * 
     * @return parada__ReferenciaExterna
     */
    public java.lang.String getParada__ReferenciaExterna() {
        return parada__ReferenciaExterna;
    }


    /**
     * Sets the parada__ReferenciaExterna value for this PParadaEtiqueta.
     * 
     * @param parada__ReferenciaExterna
     */
    public void setParada__ReferenciaExterna(java.lang.String parada__ReferenciaExterna) {
        this.parada__ReferenciaExterna = parada__ReferenciaExterna;
    }


    /**
     * Gets the viaje__ReferenciaExterna value for this PParadaEtiqueta.
     * 
     * @return viaje__ReferenciaExterna
     */
    public java.lang.String getViaje__ReferenciaExterna() {
        return viaje__ReferenciaExterna;
    }


    /**
     * Sets the viaje__ReferenciaExterna value for this PParadaEtiqueta.
     * 
     * @param viaje__ReferenciaExterna
     */
    public void setViaje__ReferenciaExterna(java.lang.String viaje__ReferenciaExterna) {
        this.viaje__ReferenciaExterna = viaje__ReferenciaExterna;
    }


    /**
     * Gets the idViaje value for this PParadaEtiqueta.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PParadaEtiqueta.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the estadoViaje value for this PParadaEtiqueta.
     * 
     * @return estadoViaje
     */
    public java.lang.String getEstadoViaje() {
        return estadoViaje;
    }


    /**
     * Sets the estadoViaje value for this PParadaEtiqueta.
     * 
     * @param estadoViaje
     */
    public void setEstadoViaje(java.lang.String estadoViaje) {
        this.estadoViaje = estadoViaje;
    }


    /**
     * Gets the kmsRecorridos value for this PParadaEtiqueta.
     * 
     * @return kmsRecorridos
     */
    public java.lang.Double getKmsRecorridos() {
        return kmsRecorridos;
    }


    /**
     * Sets the kmsRecorridos value for this PParadaEtiqueta.
     * 
     * @param kmsRecorridos
     */
    public void setKmsRecorridos(java.lang.Double kmsRecorridos) {
        this.kmsRecorridos = kmsRecorridos;
    }


    /**
     * Gets the idRuta value for this PParadaEtiqueta.
     * 
     * @return idRuta
     */
    public java.lang.Integer getIdRuta() {
        return idRuta;
    }


    /**
     * Sets the idRuta value for this PParadaEtiqueta.
     * 
     * @param idRuta
     */
    public void setIdRuta(java.lang.Integer idRuta) {
        this.idRuta = idRuta;
    }


    /**
     * Gets the idJornada value for this PParadaEtiqueta.
     * 
     * @return idJornada
     */
    public long getIdJornada() {
        return idJornada;
    }


    /**
     * Sets the idJornada value for this PParadaEtiqueta.
     * 
     * @param idJornada
     */
    public void setIdJornada(long idJornada) {
        this.idJornada = idJornada;
    }


    /**
     * Gets the bultos value for this PParadaEtiqueta.
     * 
     * @return bultos
     */
    public int getBultos() {
        return bultos;
    }


    /**
     * Sets the bultos value for this PParadaEtiqueta.
     * 
     * @param bultos
     */
    public void setBultos(int bultos) {
        this.bultos = bultos;
    }


    /**
     * Gets the etiqueta value for this PParadaEtiqueta.
     * 
     * @return etiqueta
     */
    public java.lang.String getEtiqueta() {
        return etiqueta;
    }


    /**
     * Sets the etiqueta value for this PParadaEtiqueta.
     * 
     * @param etiqueta
     */
    public void setEtiqueta(java.lang.String etiqueta) {
        this.etiqueta = etiqueta;
    }


    /**
     * Gets the usuario value for this PParadaEtiqueta.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this PParadaEtiqueta.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the fecha value for this PParadaEtiqueta.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this PParadaEtiqueta.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PParadaEtiqueta)) return false;
        PParadaEtiqueta other = (PParadaEtiqueta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.parada__ReferenciaExterna==null && other.getParada__ReferenciaExterna()==null) || 
             (this.parada__ReferenciaExterna!=null &&
              this.parada__ReferenciaExterna.equals(other.getParada__ReferenciaExterna()))) &&
            ((this.viaje__ReferenciaExterna==null && other.getViaje__ReferenciaExterna()==null) || 
             (this.viaje__ReferenciaExterna!=null &&
              this.viaje__ReferenciaExterna.equals(other.getViaje__ReferenciaExterna()))) &&
            this.idViaje == other.getIdViaje() &&
            ((this.estadoViaje==null && other.getEstadoViaje()==null) || 
             (this.estadoViaje!=null &&
              this.estadoViaje.equals(other.getEstadoViaje()))) &&
            ((this.kmsRecorridos==null && other.getKmsRecorridos()==null) || 
             (this.kmsRecorridos!=null &&
              this.kmsRecorridos.equals(other.getKmsRecorridos()))) &&
            ((this.idRuta==null && other.getIdRuta()==null) || 
             (this.idRuta!=null &&
              this.idRuta.equals(other.getIdRuta()))) &&
            this.idJornada == other.getIdJornada() &&
            this.bultos == other.getBultos() &&
            ((this.etiqueta==null && other.getEtiqueta()==null) || 
             (this.etiqueta!=null &&
              this.etiqueta.equals(other.getEtiqueta()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
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
        _hashCode += getId();
        if (getParada__ReferenciaExterna() != null) {
            _hashCode += getParada__ReferenciaExterna().hashCode();
        }
        if (getViaje__ReferenciaExterna() != null) {
            _hashCode += getViaje__ReferenciaExterna().hashCode();
        }
        _hashCode += getIdViaje();
        if (getEstadoViaje() != null) {
            _hashCode += getEstadoViaje().hashCode();
        }
        if (getKmsRecorridos() != null) {
            _hashCode += getKmsRecorridos().hashCode();
        }
        if (getIdRuta() != null) {
            _hashCode += getIdRuta().hashCode();
        }
        _hashCode += new Long(getIdJornada()).hashCode();
        _hashCode += getBultos();
        if (getEtiqueta() != null) {
            _hashCode += getEtiqueta().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PParadaEtiqueta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaEtiqueta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parada__ReferenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Parada__ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viaje__ReferenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Viaje__ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("kmsRecorridos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "KmsRecorridos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRuta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdRuta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idJornada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdJornada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bultos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Bultos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiqueta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Etiqueta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Usuario"));
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
