/**
 * Motivo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class Motivo  extends ar.com.unisolutions.AbstractEntitieCacheable  implements java.io.Serializable {
    private long idMotivo;

    private java.lang.String descripcion;

    private java.lang.String referenciaExterna;

    private int color;

    private java.lang.String categoria;

    private boolean eliminado;

    private java.util.Calendar fechaEliminacion;

    public Motivo() {
    }

    public Motivo(
           long idMotivo,
           java.lang.String descripcion,
           java.lang.String referenciaExterna,
           int color,
           java.lang.String categoria,
           boolean eliminado,
           java.util.Calendar fechaEliminacion) {
        this.idMotivo = idMotivo;
        this.descripcion = descripcion;
        this.referenciaExterna = referenciaExterna;
        this.color = color;
        this.categoria = categoria;
        this.eliminado = eliminado;
        this.fechaEliminacion = fechaEliminacion;
    }


    /**
     * Gets the idMotivo value for this Motivo.
     * 
     * @return idMotivo
     */
    public long getIdMotivo() {
        return idMotivo;
    }


    /**
     * Sets the idMotivo value for this Motivo.
     * 
     * @param idMotivo
     */
    public void setIdMotivo(long idMotivo) {
        this.idMotivo = idMotivo;
    }


    /**
     * Gets the descripcion value for this Motivo.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Motivo.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the referenciaExterna value for this Motivo.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this Motivo.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the color value for this Motivo.
     * 
     * @return color
     */
    public int getColor() {
        return color;
    }


    /**
     * Sets the color value for this Motivo.
     * 
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
    }


    /**
     * Gets the categoria value for this Motivo.
     * 
     * @return categoria
     */
    public java.lang.String getCategoria() {
        return categoria;
    }


    /**
     * Sets the categoria value for this Motivo.
     * 
     * @param categoria
     */
    public void setCategoria(java.lang.String categoria) {
        this.categoria = categoria;
    }


    /**
     * Gets the eliminado value for this Motivo.
     * 
     * @return eliminado
     */
    public boolean isEliminado() {
        return eliminado;
    }


    /**
     * Sets the eliminado value for this Motivo.
     * 
     * @param eliminado
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }


    /**
     * Gets the fechaEliminacion value for this Motivo.
     * 
     * @return fechaEliminacion
     */
    public java.util.Calendar getFechaEliminacion() {
        return fechaEliminacion;
    }


    /**
     * Sets the fechaEliminacion value for this Motivo.
     * 
     * @param fechaEliminacion
     */
    public void setFechaEliminacion(java.util.Calendar fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Motivo)) return false;
        Motivo other = (Motivo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.idMotivo == other.getIdMotivo() &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            this.color == other.getColor() &&
            ((this.categoria==null && other.getCategoria()==null) || 
             (this.categoria!=null &&
              this.categoria.equals(other.getCategoria()))) &&
            this.eliminado == other.isEliminado() &&
            ((this.fechaEliminacion==null && other.getFechaEliminacion()==null) || 
             (this.fechaEliminacion!=null &&
              this.fechaEliminacion.equals(other.getFechaEliminacion())));
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
        _hashCode += new Long(getIdMotivo()).hashCode();
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        _hashCode += getColor();
        if (getCategoria() != null) {
            _hashCode += getCategoria().hashCode();
        }
        _hashCode += (isEliminado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFechaEliminacion() != null) {
            _hashCode += getFechaEliminacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Motivo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Motivo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMotivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdMotivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("color");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Color"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Categoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eliminado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Eliminado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEliminacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaEliminacion"));
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
