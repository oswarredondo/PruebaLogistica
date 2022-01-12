/**
 * PConceptoExterno.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PConceptoExterno  implements java.io.Serializable {
    private java.lang.String entidad;

    private java.lang.String referenciaEntidad;

    private java.lang.String entidadPadre;

    private java.lang.String referenciaEntidadPadre;

    private java.lang.String codigo;

    private double importeTotal;

    private java.lang.String valorChar;

    private double cantidad;

    private java.lang.String referenciaExternaTarifa;

    private java.lang.String referenciaAdicionalTarifa;

    private java.lang.String referenciaExternaClienteOperacion;

    private ar.com.unisolutions.PImputacion[] imputaciones;

    public PConceptoExterno() {
    }

    public PConceptoExterno(
           java.lang.String entidad,
           java.lang.String referenciaEntidad,
           java.lang.String entidadPadre,
           java.lang.String referenciaEntidadPadre,
           java.lang.String codigo,
           double importeTotal,
           java.lang.String valorChar,
           double cantidad,
           java.lang.String referenciaExternaTarifa,
           java.lang.String referenciaAdicionalTarifa,
           java.lang.String referenciaExternaClienteOperacion,
           ar.com.unisolutions.PImputacion[] imputaciones) {
           this.entidad = entidad;
           this.referenciaEntidad = referenciaEntidad;
           this.entidadPadre = entidadPadre;
           this.referenciaEntidadPadre = referenciaEntidadPadre;
           this.codigo = codigo;
           this.importeTotal = importeTotal;
           this.valorChar = valorChar;
           this.cantidad = cantidad;
           this.referenciaExternaTarifa = referenciaExternaTarifa;
           this.referenciaAdicionalTarifa = referenciaAdicionalTarifa;
           this.referenciaExternaClienteOperacion = referenciaExternaClienteOperacion;
           this.imputaciones = imputaciones;
    }


    /**
     * Gets the entidad value for this PConceptoExterno.
     * 
     * @return entidad
     */
    public java.lang.String getEntidad() {
        return entidad;
    }


    /**
     * Sets the entidad value for this PConceptoExterno.
     * 
     * @param entidad
     */
    public void setEntidad(java.lang.String entidad) {
        this.entidad = entidad;
    }


    /**
     * Gets the referenciaEntidad value for this PConceptoExterno.
     * 
     * @return referenciaEntidad
     */
    public java.lang.String getReferenciaEntidad() {
        return referenciaEntidad;
    }


    /**
     * Sets the referenciaEntidad value for this PConceptoExterno.
     * 
     * @param referenciaEntidad
     */
    public void setReferenciaEntidad(java.lang.String referenciaEntidad) {
        this.referenciaEntidad = referenciaEntidad;
    }


    /**
     * Gets the entidadPadre value for this PConceptoExterno.
     * 
     * @return entidadPadre
     */
    public java.lang.String getEntidadPadre() {
        return entidadPadre;
    }


    /**
     * Sets the entidadPadre value for this PConceptoExterno.
     * 
     * @param entidadPadre
     */
    public void setEntidadPadre(java.lang.String entidadPadre) {
        this.entidadPadre = entidadPadre;
    }


    /**
     * Gets the referenciaEntidadPadre value for this PConceptoExterno.
     * 
     * @return referenciaEntidadPadre
     */
    public java.lang.String getReferenciaEntidadPadre() {
        return referenciaEntidadPadre;
    }


    /**
     * Sets the referenciaEntidadPadre value for this PConceptoExterno.
     * 
     * @param referenciaEntidadPadre
     */
    public void setReferenciaEntidadPadre(java.lang.String referenciaEntidadPadre) {
        this.referenciaEntidadPadre = referenciaEntidadPadre;
    }


    /**
     * Gets the codigo value for this PConceptoExterno.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this PConceptoExterno.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the importeTotal value for this PConceptoExterno.
     * 
     * @return importeTotal
     */
    public double getImporteTotal() {
        return importeTotal;
    }


    /**
     * Sets the importeTotal value for this PConceptoExterno.
     * 
     * @param importeTotal
     */
    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }


    /**
     * Gets the valorChar value for this PConceptoExterno.
     * 
     * @return valorChar
     */
    public java.lang.String getValorChar() {
        return valorChar;
    }


    /**
     * Sets the valorChar value for this PConceptoExterno.
     * 
     * @param valorChar
     */
    public void setValorChar(java.lang.String valorChar) {
        this.valorChar = valorChar;
    }


    /**
     * Gets the cantidad value for this PConceptoExterno.
     * 
     * @return cantidad
     */
    public double getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this PConceptoExterno.
     * 
     * @param cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the referenciaExternaTarifa value for this PConceptoExterno.
     * 
     * @return referenciaExternaTarifa
     */
    public java.lang.String getReferenciaExternaTarifa() {
        return referenciaExternaTarifa;
    }


    /**
     * Sets the referenciaExternaTarifa value for this PConceptoExterno.
     * 
     * @param referenciaExternaTarifa
     */
    public void setReferenciaExternaTarifa(java.lang.String referenciaExternaTarifa) {
        this.referenciaExternaTarifa = referenciaExternaTarifa;
    }


    /**
     * Gets the referenciaAdicionalTarifa value for this PConceptoExterno.
     * 
     * @return referenciaAdicionalTarifa
     */
    public java.lang.String getReferenciaAdicionalTarifa() {
        return referenciaAdicionalTarifa;
    }


    /**
     * Sets the referenciaAdicionalTarifa value for this PConceptoExterno.
     * 
     * @param referenciaAdicionalTarifa
     */
    public void setReferenciaAdicionalTarifa(java.lang.String referenciaAdicionalTarifa) {
        this.referenciaAdicionalTarifa = referenciaAdicionalTarifa;
    }


    /**
     * Gets the referenciaExternaClienteOperacion value for this PConceptoExterno.
     * 
     * @return referenciaExternaClienteOperacion
     */
    public java.lang.String getReferenciaExternaClienteOperacion() {
        return referenciaExternaClienteOperacion;
    }


    /**
     * Sets the referenciaExternaClienteOperacion value for this PConceptoExterno.
     * 
     * @param referenciaExternaClienteOperacion
     */
    public void setReferenciaExternaClienteOperacion(java.lang.String referenciaExternaClienteOperacion) {
        this.referenciaExternaClienteOperacion = referenciaExternaClienteOperacion;
    }


    /**
     * Gets the imputaciones value for this PConceptoExterno.
     * 
     * @return imputaciones
     */
    public ar.com.unisolutions.PImputacion[] getImputaciones() {
        return imputaciones;
    }


    /**
     * Sets the imputaciones value for this PConceptoExterno.
     * 
     * @param imputaciones
     */
    public void setImputaciones(ar.com.unisolutions.PImputacion[] imputaciones) {
        this.imputaciones = imputaciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PConceptoExterno)) return false;
        PConceptoExterno other = (PConceptoExterno) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.entidad==null && other.getEntidad()==null) || 
             (this.entidad!=null &&
              this.entidad.equals(other.getEntidad()))) &&
            ((this.referenciaEntidad==null && other.getReferenciaEntidad()==null) || 
             (this.referenciaEntidad!=null &&
              this.referenciaEntidad.equals(other.getReferenciaEntidad()))) &&
            ((this.entidadPadre==null && other.getEntidadPadre()==null) || 
             (this.entidadPadre!=null &&
              this.entidadPadre.equals(other.getEntidadPadre()))) &&
            ((this.referenciaEntidadPadre==null && other.getReferenciaEntidadPadre()==null) || 
             (this.referenciaEntidadPadre!=null &&
              this.referenciaEntidadPadre.equals(other.getReferenciaEntidadPadre()))) &&
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            this.importeTotal == other.getImporteTotal() &&
            ((this.valorChar==null && other.getValorChar()==null) || 
             (this.valorChar!=null &&
              this.valorChar.equals(other.getValorChar()))) &&
            this.cantidad == other.getCantidad() &&
            ((this.referenciaExternaTarifa==null && other.getReferenciaExternaTarifa()==null) || 
             (this.referenciaExternaTarifa!=null &&
              this.referenciaExternaTarifa.equals(other.getReferenciaExternaTarifa()))) &&
            ((this.referenciaAdicionalTarifa==null && other.getReferenciaAdicionalTarifa()==null) || 
             (this.referenciaAdicionalTarifa!=null &&
              this.referenciaAdicionalTarifa.equals(other.getReferenciaAdicionalTarifa()))) &&
            ((this.referenciaExternaClienteOperacion==null && other.getReferenciaExternaClienteOperacion()==null) || 
             (this.referenciaExternaClienteOperacion!=null &&
              this.referenciaExternaClienteOperacion.equals(other.getReferenciaExternaClienteOperacion()))) &&
            ((this.imputaciones==null && other.getImputaciones()==null) || 
             (this.imputaciones!=null &&
              java.util.Arrays.equals(this.imputaciones, other.getImputaciones())));
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
        if (getEntidad() != null) {
            _hashCode += getEntidad().hashCode();
        }
        if (getReferenciaEntidad() != null) {
            _hashCode += getReferenciaEntidad().hashCode();
        }
        if (getEntidadPadre() != null) {
            _hashCode += getEntidadPadre().hashCode();
        }
        if (getReferenciaEntidadPadre() != null) {
            _hashCode += getReferenciaEntidadPadre().hashCode();
        }
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        _hashCode += new Double(getImporteTotal()).hashCode();
        if (getValorChar() != null) {
            _hashCode += getValorChar().hashCode();
        }
        _hashCode += new Double(getCantidad()).hashCode();
        if (getReferenciaExternaTarifa() != null) {
            _hashCode += getReferenciaExternaTarifa().hashCode();
        }
        if (getReferenciaAdicionalTarifa() != null) {
            _hashCode += getReferenciaAdicionalTarifa().hashCode();
        }
        if (getReferenciaExternaClienteOperacion() != null) {
            _hashCode += getReferenciaExternaClienteOperacion().hashCode();
        }
        if (getImputaciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImputaciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImputaciones(), i);
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
        new org.apache.axis.description.TypeDesc(PConceptoExterno.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoExterno"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Entidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaEntidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaEntidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entidadPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntidadPadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaEntidadPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaEntidadPadre"));
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
        elemField.setFieldName("importeTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorChar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValorChar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExternaTarifa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaTarifa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaAdicionalTarifa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaAdicionalTarifa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExternaClienteOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaClienteOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imputaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Imputaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pImputacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pImputacion"));
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
