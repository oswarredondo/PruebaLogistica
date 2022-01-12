/**
 * PArchivosParada.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PArchivosParada  implements java.io.Serializable {
    private int idViaje;

    private int idParada;

    private java.lang.String referenciaViaje;

    private java.lang.String refDocumento;

    private java.lang.String estadoActual;

    private java.lang.String depositoSalida;

    private java.lang.String depositoLlegada;

    private java.lang.String refDepositoSalida;

    private java.lang.String refDepositoLlegada;

    private ar.com.unisolutions.PArchivos[] archivosParada;

    private ar.com.unisolutions.PEstados[] estados;

    public PArchivosParada() {
    }

    public PArchivosParada(
           int idViaje,
           int idParada,
           java.lang.String referenciaViaje,
           java.lang.String refDocumento,
           java.lang.String estadoActual,
           java.lang.String depositoSalida,
           java.lang.String depositoLlegada,
           java.lang.String refDepositoSalida,
           java.lang.String refDepositoLlegada,
           ar.com.unisolutions.PArchivos[] archivosParada,
           ar.com.unisolutions.PEstados[] estados) {
           this.idViaje = idViaje;
           this.idParada = idParada;
           this.referenciaViaje = referenciaViaje;
           this.refDocumento = refDocumento;
           this.estadoActual = estadoActual;
           this.depositoSalida = depositoSalida;
           this.depositoLlegada = depositoLlegada;
           this.refDepositoSalida = refDepositoSalida;
           this.refDepositoLlegada = refDepositoLlegada;
           this.archivosParada = archivosParada;
           this.estados = estados;
    }


    /**
     * Gets the idViaje value for this PArchivosParada.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PArchivosParada.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the idParada value for this PArchivosParada.
     * 
     * @return idParada
     */
    public int getIdParada() {
        return idParada;
    }


    /**
     * Sets the idParada value for this PArchivosParada.
     * 
     * @param idParada
     */
    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }


    /**
     * Gets the referenciaViaje value for this PArchivosParada.
     * 
     * @return referenciaViaje
     */
    public java.lang.String getReferenciaViaje() {
        return referenciaViaje;
    }


    /**
     * Sets the referenciaViaje value for this PArchivosParada.
     * 
     * @param referenciaViaje
     */
    public void setReferenciaViaje(java.lang.String referenciaViaje) {
        this.referenciaViaje = referenciaViaje;
    }


    /**
     * Gets the refDocumento value for this PArchivosParada.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this PArchivosParada.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the estadoActual value for this PArchivosParada.
     * 
     * @return estadoActual
     */
    public java.lang.String getEstadoActual() {
        return estadoActual;
    }


    /**
     * Sets the estadoActual value for this PArchivosParada.
     * 
     * @param estadoActual
     */
    public void setEstadoActual(java.lang.String estadoActual) {
        this.estadoActual = estadoActual;
    }


    /**
     * Gets the depositoSalida value for this PArchivosParada.
     * 
     * @return depositoSalida
     */
    public java.lang.String getDepositoSalida() {
        return depositoSalida;
    }


    /**
     * Sets the depositoSalida value for this PArchivosParada.
     * 
     * @param depositoSalida
     */
    public void setDepositoSalida(java.lang.String depositoSalida) {
        this.depositoSalida = depositoSalida;
    }


    /**
     * Gets the depositoLlegada value for this PArchivosParada.
     * 
     * @return depositoLlegada
     */
    public java.lang.String getDepositoLlegada() {
        return depositoLlegada;
    }


    /**
     * Sets the depositoLlegada value for this PArchivosParada.
     * 
     * @param depositoLlegada
     */
    public void setDepositoLlegada(java.lang.String depositoLlegada) {
        this.depositoLlegada = depositoLlegada;
    }


    /**
     * Gets the refDepositoSalida value for this PArchivosParada.
     * 
     * @return refDepositoSalida
     */
    public java.lang.String getRefDepositoSalida() {
        return refDepositoSalida;
    }


    /**
     * Sets the refDepositoSalida value for this PArchivosParada.
     * 
     * @param refDepositoSalida
     */
    public void setRefDepositoSalida(java.lang.String refDepositoSalida) {
        this.refDepositoSalida = refDepositoSalida;
    }


    /**
     * Gets the refDepositoLlegada value for this PArchivosParada.
     * 
     * @return refDepositoLlegada
     */
    public java.lang.String getRefDepositoLlegada() {
        return refDepositoLlegada;
    }


    /**
     * Sets the refDepositoLlegada value for this PArchivosParada.
     * 
     * @param refDepositoLlegada
     */
    public void setRefDepositoLlegada(java.lang.String refDepositoLlegada) {
        this.refDepositoLlegada = refDepositoLlegada;
    }


    /**
     * Gets the archivosParada value for this PArchivosParada.
     * 
     * @return archivosParada
     */
    public ar.com.unisolutions.PArchivos[] getArchivosParada() {
        return archivosParada;
    }


    /**
     * Sets the archivosParada value for this PArchivosParada.
     * 
     * @param archivosParada
     */
    public void setArchivosParada(ar.com.unisolutions.PArchivos[] archivosParada) {
        this.archivosParada = archivosParada;
    }


    /**
     * Gets the estados value for this PArchivosParada.
     * 
     * @return estados
     */
    public ar.com.unisolutions.PEstados[] getEstados() {
        return estados;
    }


    /**
     * Sets the estados value for this PArchivosParada.
     * 
     * @param estados
     */
    public void setEstados(ar.com.unisolutions.PEstados[] estados) {
        this.estados = estados;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PArchivosParada)) return false;
        PArchivosParada other = (PArchivosParada) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idViaje == other.getIdViaje() &&
            this.idParada == other.getIdParada() &&
            ((this.referenciaViaje==null && other.getReferenciaViaje()==null) || 
             (this.referenciaViaje!=null &&
              this.referenciaViaje.equals(other.getReferenciaViaje()))) &&
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            ((this.estadoActual==null && other.getEstadoActual()==null) || 
             (this.estadoActual!=null &&
              this.estadoActual.equals(other.getEstadoActual()))) &&
            ((this.depositoSalida==null && other.getDepositoSalida()==null) || 
             (this.depositoSalida!=null &&
              this.depositoSalida.equals(other.getDepositoSalida()))) &&
            ((this.depositoLlegada==null && other.getDepositoLlegada()==null) || 
             (this.depositoLlegada!=null &&
              this.depositoLlegada.equals(other.getDepositoLlegada()))) &&
            ((this.refDepositoSalida==null && other.getRefDepositoSalida()==null) || 
             (this.refDepositoSalida!=null &&
              this.refDepositoSalida.equals(other.getRefDepositoSalida()))) &&
            ((this.refDepositoLlegada==null && other.getRefDepositoLlegada()==null) || 
             (this.refDepositoLlegada!=null &&
              this.refDepositoLlegada.equals(other.getRefDepositoLlegada()))) &&
            ((this.archivosParada==null && other.getArchivosParada()==null) || 
             (this.archivosParada!=null &&
              java.util.Arrays.equals(this.archivosParada, other.getArchivosParada()))) &&
            ((this.estados==null && other.getEstados()==null) || 
             (this.estados!=null &&
              java.util.Arrays.equals(this.estados, other.getEstados())));
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
        _hashCode += getIdViaje();
        _hashCode += getIdParada();
        if (getReferenciaViaje() != null) {
            _hashCode += getReferenciaViaje().hashCode();
        }
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getEstadoActual() != null) {
            _hashCode += getEstadoActual().hashCode();
        }
        if (getDepositoSalida() != null) {
            _hashCode += getDepositoSalida().hashCode();
        }
        if (getDepositoLlegada() != null) {
            _hashCode += getDepositoLlegada().hashCode();
        }
        if (getRefDepositoSalida() != null) {
            _hashCode += getRefDepositoSalida().hashCode();
        }
        if (getRefDepositoLlegada() != null) {
            _hashCode += getRefDepositoLlegada().hashCode();
        }
        if (getArchivosParada() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArchivosParada());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArchivosParada(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEstados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEstados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEstados(), i);
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
        new org.apache.axis.description.TypeDesc(PArchivosParada.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivosParada"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoActual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoActual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositoSalida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DepositoSalida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositoLlegada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DepositoLlegada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDepositoSalida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDepositoSalida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDepositoLlegada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDepositoLlegada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archivosParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ArchivosParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pArchivos"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstados"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstados"));
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
