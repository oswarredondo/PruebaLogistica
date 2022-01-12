/**
 * ConsultarParadaResultadoItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarParadaResultadoItem  implements java.io.Serializable {
    private java.lang.String refDocumento;

    private java.lang.String refDocumentoAdicional;

    private java.lang.String descripcion;

    private double cantidad;

    private double volumen;

    private double peso;

    private double bulto;

    private double pallets;

    private double cantidadEntregada;

    private java.lang.String motivo;

    private java.lang.String estadoParadaItem;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String varchar3;

    private ar.com.unisolutions.PProducto[] productos;

    public ConsultarParadaResultadoItem() {
    }

    public ConsultarParadaResultadoItem(
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           java.lang.String descripcion,
           double cantidad,
           double volumen,
           double peso,
           double bulto,
           double pallets,
           double cantidadEntregada,
           java.lang.String motivo,
           java.lang.String estadoParadaItem,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           ar.com.unisolutions.PProducto[] productos) {
           this.refDocumento = refDocumento;
           this.refDocumentoAdicional = refDocumentoAdicional;
           this.descripcion = descripcion;
           this.cantidad = cantidad;
           this.volumen = volumen;
           this.peso = peso;
           this.bulto = bulto;
           this.pallets = pallets;
           this.cantidadEntregada = cantidadEntregada;
           this.motivo = motivo;
           this.estadoParadaItem = estadoParadaItem;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.varchar3 = varchar3;
           this.productos = productos;
    }


    /**
     * Gets the refDocumento value for this ConsultarParadaResultadoItem.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this ConsultarParadaResultadoItem.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the refDocumentoAdicional value for this ConsultarParadaResultadoItem.
     * 
     * @return refDocumentoAdicional
     */
    public java.lang.String getRefDocumentoAdicional() {
        return refDocumentoAdicional;
    }


    /**
     * Sets the refDocumentoAdicional value for this ConsultarParadaResultadoItem.
     * 
     * @param refDocumentoAdicional
     */
    public void setRefDocumentoAdicional(java.lang.String refDocumentoAdicional) {
        this.refDocumentoAdicional = refDocumentoAdicional;
    }


    /**
     * Gets the descripcion value for this ConsultarParadaResultadoItem.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ConsultarParadaResultadoItem.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the cantidad value for this ConsultarParadaResultadoItem.
     * 
     * @return cantidad
     */
    public double getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this ConsultarParadaResultadoItem.
     * 
     * @param cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the volumen value for this ConsultarParadaResultadoItem.
     * 
     * @return volumen
     */
    public double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this ConsultarParadaResultadoItem.
     * 
     * @param volumen
     */
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this ConsultarParadaResultadoItem.
     * 
     * @return peso
     */
    public double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this ConsultarParadaResultadoItem.
     * 
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }


    /**
     * Gets the bulto value for this ConsultarParadaResultadoItem.
     * 
     * @return bulto
     */
    public double getBulto() {
        return bulto;
    }


    /**
     * Sets the bulto value for this ConsultarParadaResultadoItem.
     * 
     * @param bulto
     */
    public void setBulto(double bulto) {
        this.bulto = bulto;
    }


    /**
     * Gets the pallets value for this ConsultarParadaResultadoItem.
     * 
     * @return pallets
     */
    public double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this ConsultarParadaResultadoItem.
     * 
     * @param pallets
     */
    public void setPallets(double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the cantidadEntregada value for this ConsultarParadaResultadoItem.
     * 
     * @return cantidadEntregada
     */
    public double getCantidadEntregada() {
        return cantidadEntregada;
    }


    /**
     * Sets the cantidadEntregada value for this ConsultarParadaResultadoItem.
     * 
     * @param cantidadEntregada
     */
    public void setCantidadEntregada(double cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }


    /**
     * Gets the motivo value for this ConsultarParadaResultadoItem.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this ConsultarParadaResultadoItem.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the estadoParadaItem value for this ConsultarParadaResultadoItem.
     * 
     * @return estadoParadaItem
     */
    public java.lang.String getEstadoParadaItem() {
        return estadoParadaItem;
    }


    /**
     * Sets the estadoParadaItem value for this ConsultarParadaResultadoItem.
     * 
     * @param estadoParadaItem
     */
    public void setEstadoParadaItem(java.lang.String estadoParadaItem) {
        this.estadoParadaItem = estadoParadaItem;
    }


    /**
     * Gets the varchar1 value for this ConsultarParadaResultadoItem.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this ConsultarParadaResultadoItem.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this ConsultarParadaResultadoItem.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this ConsultarParadaResultadoItem.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the varchar3 value for this ConsultarParadaResultadoItem.
     * 
     * @return varchar3
     */
    public java.lang.String getVarchar3() {
        return varchar3;
    }


    /**
     * Sets the varchar3 value for this ConsultarParadaResultadoItem.
     * 
     * @param varchar3
     */
    public void setVarchar3(java.lang.String varchar3) {
        this.varchar3 = varchar3;
    }


    /**
     * Gets the productos value for this ConsultarParadaResultadoItem.
     * 
     * @return productos
     */
    public ar.com.unisolutions.PProducto[] getProductos() {
        return productos;
    }


    /**
     * Sets the productos value for this ConsultarParadaResultadoItem.
     * 
     * @param productos
     */
    public void setProductos(ar.com.unisolutions.PProducto[] productos) {
        this.productos = productos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarParadaResultadoItem)) return false;
        ConsultarParadaResultadoItem other = (ConsultarParadaResultadoItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            ((this.refDocumentoAdicional==null && other.getRefDocumentoAdicional()==null) || 
             (this.refDocumentoAdicional!=null &&
              this.refDocumentoAdicional.equals(other.getRefDocumentoAdicional()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.cantidad == other.getCantidad() &&
            this.volumen == other.getVolumen() &&
            this.peso == other.getPeso() &&
            this.bulto == other.getBulto() &&
            this.pallets == other.getPallets() &&
            this.cantidadEntregada == other.getCantidadEntregada() &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo()))) &&
            ((this.estadoParadaItem==null && other.getEstadoParadaItem()==null) || 
             (this.estadoParadaItem!=null &&
              this.estadoParadaItem.equals(other.getEstadoParadaItem()))) &&
            ((this.varchar1==null && other.getVarchar1()==null) || 
             (this.varchar1!=null &&
              this.varchar1.equals(other.getVarchar1()))) &&
            ((this.varchar2==null && other.getVarchar2()==null) || 
             (this.varchar2!=null &&
              this.varchar2.equals(other.getVarchar2()))) &&
            ((this.varchar3==null && other.getVarchar3()==null) || 
             (this.varchar3!=null &&
              this.varchar3.equals(other.getVarchar3()))) &&
            ((this.productos==null && other.getProductos()==null) || 
             (this.productos!=null &&
              java.util.Arrays.equals(this.productos, other.getProductos())));
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
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getRefDocumentoAdicional() != null) {
            _hashCode += getRefDocumentoAdicional().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += new Double(getCantidad()).hashCode();
        _hashCode += new Double(getVolumen()).hashCode();
        _hashCode += new Double(getPeso()).hashCode();
        _hashCode += new Double(getBulto()).hashCode();
        _hashCode += new Double(getPallets()).hashCode();
        _hashCode += new Double(getCantidadEntregada()).hashCode();
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        if (getEstadoParadaItem() != null) {
            _hashCode += getEstadoParadaItem().hashCode();
        }
        if (getVarchar1() != null) {
            _hashCode += getVarchar1().hashCode();
        }
        if (getVarchar2() != null) {
            _hashCode += getVarchar2().hashCode();
        }
        if (getVarchar3() != null) {
            _hashCode += getVarchar3().hashCode();
        }
        if (getProductos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductos(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarParadaResultadoItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultadoItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDocumentoAdicional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumentoAdicional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volumen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Volumen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Peso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bulto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Bulto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pallets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pallets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadEntregada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CantidadEntregada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Motivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoParadaItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoParadaItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Varchar1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Varchar2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Varchar3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Productos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pProducto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pProducto"));
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
