/**
 * POrdenEntregaItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class POrdenEntregaItem  implements java.io.Serializable {
    private java.lang.Long idOrdenItem;

    private java.lang.String refDocumento;

    private java.lang.String descripcion;

    private java.lang.String refDocumentoAdicional;

    private ar.com.unisolutions.PProducto producto;

    private double cantidad;

    private java.lang.Double volumen;

    private java.lang.Double peso;

    private java.lang.Double bulto;

    private java.lang.Double pallets;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private ar.com.unisolutions.PEtiqueta[] etiquetas;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String LPN;

    private java.lang.Integer unidades;

    private java.lang.Integer int1;

    private java.lang.Integer int2;

    private java.lang.Integer referenciaCantidad;

    private java.lang.Double referenciaValor;

    private java.lang.Boolean procesarVolumetria;

    public POrdenEntregaItem() {
    }

    public POrdenEntregaItem(
           java.lang.Long idOrdenItem,
           java.lang.String refDocumento,
           java.lang.String descripcion,
           java.lang.String refDocumentoAdicional,
           ar.com.unisolutions.PProducto producto,
           double cantidad,
           java.lang.Double volumen,
           java.lang.Double peso,
           java.lang.Double bulto,
           java.lang.Double pallets,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           ar.com.unisolutions.PEtiqueta[] etiquetas,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String LPN,
           java.lang.Integer unidades,
           java.lang.Integer int1,
           java.lang.Integer int2,
           java.lang.Integer referenciaCantidad,
           java.lang.Double referenciaValor,
           java.lang.Boolean procesarVolumetria) {
           this.idOrdenItem = idOrdenItem;
           this.refDocumento = refDocumento;
           this.descripcion = descripcion;
           this.refDocumentoAdicional = refDocumentoAdicional;
           this.producto = producto;
           this.cantidad = cantidad;
           this.volumen = volumen;
           this.peso = peso;
           this.bulto = bulto;
           this.pallets = pallets;
           this.campoDinamico = campoDinamico;
           this.etiquetas = etiquetas;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.LPN = LPN;
           this.unidades = unidades;
           this.int1 = int1;
           this.int2 = int2;
           this.referenciaCantidad = referenciaCantidad;
           this.referenciaValor = referenciaValor;
           this.procesarVolumetria = procesarVolumetria;
    }


    /**
     * Gets the idOrdenItem value for this POrdenEntregaItem.
     * 
     * @return idOrdenItem
     */
    public java.lang.Long getIdOrdenItem() {
        return idOrdenItem;
    }


    /**
     * Sets the idOrdenItem value for this POrdenEntregaItem.
     * 
     * @param idOrdenItem
     */
    public void setIdOrdenItem(java.lang.Long idOrdenItem) {
        this.idOrdenItem = idOrdenItem;
    }


    /**
     * Gets the refDocumento value for this POrdenEntregaItem.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this POrdenEntregaItem.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the descripcion value for this POrdenEntregaItem.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this POrdenEntregaItem.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the refDocumentoAdicional value for this POrdenEntregaItem.
     * 
     * @return refDocumentoAdicional
     */
    public java.lang.String getRefDocumentoAdicional() {
        return refDocumentoAdicional;
    }


    /**
     * Sets the refDocumentoAdicional value for this POrdenEntregaItem.
     * 
     * @param refDocumentoAdicional
     */
    public void setRefDocumentoAdicional(java.lang.String refDocumentoAdicional) {
        this.refDocumentoAdicional = refDocumentoAdicional;
    }


    /**
     * Gets the producto value for this POrdenEntregaItem.
     * 
     * @return producto
     */
    public ar.com.unisolutions.PProducto getProducto() {
        return producto;
    }


    /**
     * Sets the producto value for this POrdenEntregaItem.
     * 
     * @param producto
     */
    public void setProducto(ar.com.unisolutions.PProducto producto) {
        this.producto = producto;
    }


    /**
     * Gets the cantidad value for this POrdenEntregaItem.
     * 
     * @return cantidad
     */
    public double getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this POrdenEntregaItem.
     * 
     * @param cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the volumen value for this POrdenEntregaItem.
     * 
     * @return volumen
     */
    public java.lang.Double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this POrdenEntregaItem.
     * 
     * @param volumen
     */
    public void setVolumen(java.lang.Double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this POrdenEntregaItem.
     * 
     * @return peso
     */
    public java.lang.Double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this POrdenEntregaItem.
     * 
     * @param peso
     */
    public void setPeso(java.lang.Double peso) {
        this.peso = peso;
    }


    /**
     * Gets the bulto value for this POrdenEntregaItem.
     * 
     * @return bulto
     */
    public java.lang.Double getBulto() {
        return bulto;
    }


    /**
     * Sets the bulto value for this POrdenEntregaItem.
     * 
     * @param bulto
     */
    public void setBulto(java.lang.Double bulto) {
        this.bulto = bulto;
    }


    /**
     * Gets the pallets value for this POrdenEntregaItem.
     * 
     * @return pallets
     */
    public java.lang.Double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this POrdenEntregaItem.
     * 
     * @param pallets
     */
    public void setPallets(java.lang.Double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the campoDinamico value for this POrdenEntregaItem.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this POrdenEntregaItem.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the etiquetas value for this POrdenEntregaItem.
     * 
     * @return etiquetas
     */
    public ar.com.unisolutions.PEtiqueta[] getEtiquetas() {
        return etiquetas;
    }


    /**
     * Sets the etiquetas value for this POrdenEntregaItem.
     * 
     * @param etiquetas
     */
    public void setEtiquetas(ar.com.unisolutions.PEtiqueta[] etiquetas) {
        this.etiquetas = etiquetas;
    }


    /**
     * Gets the varchar1 value for this POrdenEntregaItem.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this POrdenEntregaItem.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this POrdenEntregaItem.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this POrdenEntregaItem.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the LPN value for this POrdenEntregaItem.
     * 
     * @return LPN
     */
    public java.lang.String getLPN() {
        return LPN;
    }


    /**
     * Sets the LPN value for this POrdenEntregaItem.
     * 
     * @param LPN
     */
    public void setLPN(java.lang.String LPN) {
        this.LPN = LPN;
    }


    /**
     * Gets the unidades value for this POrdenEntregaItem.
     * 
     * @return unidades
     */
    public java.lang.Integer getUnidades() {
        return unidades;
    }


    /**
     * Sets the unidades value for this POrdenEntregaItem.
     * 
     * @param unidades
     */
    public void setUnidades(java.lang.Integer unidades) {
        this.unidades = unidades;
    }


    /**
     * Gets the int1 value for this POrdenEntregaItem.
     * 
     * @return int1
     */
    public java.lang.Integer getInt1() {
        return int1;
    }


    /**
     * Sets the int1 value for this POrdenEntregaItem.
     * 
     * @param int1
     */
    public void setInt1(java.lang.Integer int1) {
        this.int1 = int1;
    }


    /**
     * Gets the int2 value for this POrdenEntregaItem.
     * 
     * @return int2
     */
    public java.lang.Integer getInt2() {
        return int2;
    }


    /**
     * Sets the int2 value for this POrdenEntregaItem.
     * 
     * @param int2
     */
    public void setInt2(java.lang.Integer int2) {
        this.int2 = int2;
    }


    /**
     * Gets the referenciaCantidad value for this POrdenEntregaItem.
     * 
     * @return referenciaCantidad
     */
    public java.lang.Integer getReferenciaCantidad() {
        return referenciaCantidad;
    }


    /**
     * Sets the referenciaCantidad value for this POrdenEntregaItem.
     * 
     * @param referenciaCantidad
     */
    public void setReferenciaCantidad(java.lang.Integer referenciaCantidad) {
        this.referenciaCantidad = referenciaCantidad;
    }


    /**
     * Gets the referenciaValor value for this POrdenEntregaItem.
     * 
     * @return referenciaValor
     */
    public java.lang.Double getReferenciaValor() {
        return referenciaValor;
    }


    /**
     * Sets the referenciaValor value for this POrdenEntregaItem.
     * 
     * @param referenciaValor
     */
    public void setReferenciaValor(java.lang.Double referenciaValor) {
        this.referenciaValor = referenciaValor;
    }


    /**
     * Gets the procesarVolumetria value for this POrdenEntregaItem.
     * 
     * @return procesarVolumetria
     */
    public java.lang.Boolean getProcesarVolumetria() {
        return procesarVolumetria;
    }


    /**
     * Sets the procesarVolumetria value for this POrdenEntregaItem.
     * 
     * @param procesarVolumetria
     */
    public void setProcesarVolumetria(java.lang.Boolean procesarVolumetria) {
        this.procesarVolumetria = procesarVolumetria;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POrdenEntregaItem)) return false;
        POrdenEntregaItem other = (POrdenEntregaItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idOrdenItem==null && other.getIdOrdenItem()==null) || 
             (this.idOrdenItem!=null &&
              this.idOrdenItem.equals(other.getIdOrdenItem()))) &&
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.refDocumentoAdicional==null && other.getRefDocumentoAdicional()==null) || 
             (this.refDocumentoAdicional!=null &&
              this.refDocumentoAdicional.equals(other.getRefDocumentoAdicional()))) &&
            ((this.producto==null && other.getProducto()==null) || 
             (this.producto!=null &&
              this.producto.equals(other.getProducto()))) &&
            this.cantidad == other.getCantidad() &&
            ((this.volumen==null && other.getVolumen()==null) || 
             (this.volumen!=null &&
              this.volumen.equals(other.getVolumen()))) &&
            ((this.peso==null && other.getPeso()==null) || 
             (this.peso!=null &&
              this.peso.equals(other.getPeso()))) &&
            ((this.bulto==null && other.getBulto()==null) || 
             (this.bulto!=null &&
              this.bulto.equals(other.getBulto()))) &&
            ((this.pallets==null && other.getPallets()==null) || 
             (this.pallets!=null &&
              this.pallets.equals(other.getPallets()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.etiquetas==null && other.getEtiquetas()==null) || 
             (this.etiquetas!=null &&
              java.util.Arrays.equals(this.etiquetas, other.getEtiquetas()))) &&
            ((this.varchar1==null && other.getVarchar1()==null) || 
             (this.varchar1!=null &&
              this.varchar1.equals(other.getVarchar1()))) &&
            ((this.varchar2==null && other.getVarchar2()==null) || 
             (this.varchar2!=null &&
              this.varchar2.equals(other.getVarchar2()))) &&
            ((this.LPN==null && other.getLPN()==null) || 
             (this.LPN!=null &&
              this.LPN.equals(other.getLPN()))) &&
            ((this.unidades==null && other.getUnidades()==null) || 
             (this.unidades!=null &&
              this.unidades.equals(other.getUnidades()))) &&
            ((this.int1==null && other.getInt1()==null) || 
             (this.int1!=null &&
              this.int1.equals(other.getInt1()))) &&
            ((this.int2==null && other.getInt2()==null) || 
             (this.int2!=null &&
              this.int2.equals(other.getInt2()))) &&
            ((this.referenciaCantidad==null && other.getReferenciaCantidad()==null) || 
             (this.referenciaCantidad!=null &&
              this.referenciaCantidad.equals(other.getReferenciaCantidad()))) &&
            ((this.referenciaValor==null && other.getReferenciaValor()==null) || 
             (this.referenciaValor!=null &&
              this.referenciaValor.equals(other.getReferenciaValor()))) &&
            ((this.procesarVolumetria==null && other.getProcesarVolumetria()==null) || 
             (this.procesarVolumetria!=null &&
              this.procesarVolumetria.equals(other.getProcesarVolumetria())));
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
        if (getIdOrdenItem() != null) {
            _hashCode += getIdOrdenItem().hashCode();
        }
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getRefDocumentoAdicional() != null) {
            _hashCode += getRefDocumentoAdicional().hashCode();
        }
        if (getProducto() != null) {
            _hashCode += getProducto().hashCode();
        }
        _hashCode += new Double(getCantidad()).hashCode();
        if (getVolumen() != null) {
            _hashCode += getVolumen().hashCode();
        }
        if (getPeso() != null) {
            _hashCode += getPeso().hashCode();
        }
        if (getBulto() != null) {
            _hashCode += getBulto().hashCode();
        }
        if (getPallets() != null) {
            _hashCode += getPallets().hashCode();
        }
        if (getCampoDinamico() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCampoDinamico());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCampoDinamico(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEtiquetas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEtiquetas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEtiquetas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVarchar1() != null) {
            _hashCode += getVarchar1().hashCode();
        }
        if (getVarchar2() != null) {
            _hashCode += getVarchar2().hashCode();
        }
        if (getLPN() != null) {
            _hashCode += getLPN().hashCode();
        }
        if (getUnidades() != null) {
            _hashCode += getUnidades().hashCode();
        }
        if (getInt1() != null) {
            _hashCode += getInt1().hashCode();
        }
        if (getInt2() != null) {
            _hashCode += getInt2().hashCode();
        }
        if (getReferenciaCantidad() != null) {
            _hashCode += getReferenciaCantidad().hashCode();
        }
        if (getReferenciaValor() != null) {
            _hashCode += getReferenciaValor().hashCode();
        }
        if (getProcesarVolumetria() != null) {
            _hashCode += getProcesarVolumetria().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POrdenEntregaItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOrdenItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdOrdenItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumento"));
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
        elemField.setFieldName("refDocumentoAdicional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumentoAdicional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Producto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pProducto"));
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
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Peso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bulto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Bulto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pallets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pallets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoDinamico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoDinamico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Etiquetas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEtiqueta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEtiqueta"));
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
        elemField.setFieldName("LPN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LPN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Unidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("int1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Int1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("int2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Int2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaCantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaCantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaValor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaValor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procesarVolumetria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ProcesarVolumetria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
