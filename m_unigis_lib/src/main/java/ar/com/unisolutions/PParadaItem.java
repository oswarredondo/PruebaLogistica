/**
 * PParadaItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PParadaItem  implements java.io.Serializable {
    private java.lang.String refDocumento;

    private java.lang.String refDocumentoAdicional;

    private java.lang.String descripcion;

    private double cantidad;

    private java.lang.Double volumen;

    private java.lang.Double peso;

    private java.lang.Double bulto;

    private java.lang.Double pallets;

    private java.lang.String motivoEntrega;

    private ar.com.unisolutions.PProducto producto;

    private java.lang.String tipoRotacionPermitida;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String varchar3;

    private ar.com.unisolutions.PEtiqueta[] etiquetas;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private java.lang.String estado;

    private java.lang.String referenciaExternaEstado;

    private java.lang.Float valor_Corte;

    private java.lang.Integer apilable_Permitido;

    private java.lang.Double cantidadEntregada;

    public PParadaItem() {
    }

    public PParadaItem(
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           java.lang.String descripcion,
           double cantidad,
           java.lang.Double volumen,
           java.lang.Double peso,
           java.lang.Double bulto,
           java.lang.Double pallets,
           java.lang.String motivoEntrega,
           ar.com.unisolutions.PProducto producto,
           java.lang.String tipoRotacionPermitida,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           ar.com.unisolutions.PEtiqueta[] etiquetas,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           java.lang.String estado,
           java.lang.String referenciaExternaEstado,
           java.lang.Float valor_Corte,
           java.lang.Integer apilable_Permitido,
           java.lang.Double cantidadEntregada) {
           this.refDocumento = refDocumento;
           this.refDocumentoAdicional = refDocumentoAdicional;
           this.descripcion = descripcion;
           this.cantidad = cantidad;
           this.volumen = volumen;
           this.peso = peso;
           this.bulto = bulto;
           this.pallets = pallets;
           this.motivoEntrega = motivoEntrega;
           this.producto = producto;
           this.tipoRotacionPermitida = tipoRotacionPermitida;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.varchar3 = varchar3;
           this.etiquetas = etiquetas;
           this.campoDinamico = campoDinamico;
           this.estado = estado;
           this.referenciaExternaEstado = referenciaExternaEstado;
           this.valor_Corte = valor_Corte;
           this.apilable_Permitido = apilable_Permitido;
           this.cantidadEntregada = cantidadEntregada;
    }


    /**
     * Gets the refDocumento value for this PParadaItem.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this PParadaItem.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the refDocumentoAdicional value for this PParadaItem.
     * 
     * @return refDocumentoAdicional
     */
    public java.lang.String getRefDocumentoAdicional() {
        return refDocumentoAdicional;
    }


    /**
     * Sets the refDocumentoAdicional value for this PParadaItem.
     * 
     * @param refDocumentoAdicional
     */
    public void setRefDocumentoAdicional(java.lang.String refDocumentoAdicional) {
        this.refDocumentoAdicional = refDocumentoAdicional;
    }


    /**
     * Gets the descripcion value for this PParadaItem.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PParadaItem.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the cantidad value for this PParadaItem.
     * 
     * @return cantidad
     */
    public double getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this PParadaItem.
     * 
     * @param cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the volumen value for this PParadaItem.
     * 
     * @return volumen
     */
    public java.lang.Double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this PParadaItem.
     * 
     * @param volumen
     */
    public void setVolumen(java.lang.Double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this PParadaItem.
     * 
     * @return peso
     */
    public java.lang.Double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this PParadaItem.
     * 
     * @param peso
     */
    public void setPeso(java.lang.Double peso) {
        this.peso = peso;
    }


    /**
     * Gets the bulto value for this PParadaItem.
     * 
     * @return bulto
     */
    public java.lang.Double getBulto() {
        return bulto;
    }


    /**
     * Sets the bulto value for this PParadaItem.
     * 
     * @param bulto
     */
    public void setBulto(java.lang.Double bulto) {
        this.bulto = bulto;
    }


    /**
     * Gets the pallets value for this PParadaItem.
     * 
     * @return pallets
     */
    public java.lang.Double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this PParadaItem.
     * 
     * @param pallets
     */
    public void setPallets(java.lang.Double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the motivoEntrega value for this PParadaItem.
     * 
     * @return motivoEntrega
     */
    public java.lang.String getMotivoEntrega() {
        return motivoEntrega;
    }


    /**
     * Sets the motivoEntrega value for this PParadaItem.
     * 
     * @param motivoEntrega
     */
    public void setMotivoEntrega(java.lang.String motivoEntrega) {
        this.motivoEntrega = motivoEntrega;
    }


    /**
     * Gets the producto value for this PParadaItem.
     * 
     * @return producto
     */
    public ar.com.unisolutions.PProducto getProducto() {
        return producto;
    }


    /**
     * Sets the producto value for this PParadaItem.
     * 
     * @param producto
     */
    public void setProducto(ar.com.unisolutions.PProducto producto) {
        this.producto = producto;
    }


    /**
     * Gets the tipoRotacionPermitida value for this PParadaItem.
     * 
     * @return tipoRotacionPermitida
     */
    public java.lang.String getTipoRotacionPermitida() {
        return tipoRotacionPermitida;
    }


    /**
     * Sets the tipoRotacionPermitida value for this PParadaItem.
     * 
     * @param tipoRotacionPermitida
     */
    public void setTipoRotacionPermitida(java.lang.String tipoRotacionPermitida) {
        this.tipoRotacionPermitida = tipoRotacionPermitida;
    }


    /**
     * Gets the varchar1 value for this PParadaItem.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this PParadaItem.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this PParadaItem.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this PParadaItem.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the varchar3 value for this PParadaItem.
     * 
     * @return varchar3
     */
    public java.lang.String getVarchar3() {
        return varchar3;
    }


    /**
     * Sets the varchar3 value for this PParadaItem.
     * 
     * @param varchar3
     */
    public void setVarchar3(java.lang.String varchar3) {
        this.varchar3 = varchar3;
    }


    /**
     * Gets the etiquetas value for this PParadaItem.
     * 
     * @return etiquetas
     */
    public ar.com.unisolutions.PEtiqueta[] getEtiquetas() {
        return etiquetas;
    }


    /**
     * Sets the etiquetas value for this PParadaItem.
     * 
     * @param etiquetas
     */
    public void setEtiquetas(ar.com.unisolutions.PEtiqueta[] etiquetas) {
        this.etiquetas = etiquetas;
    }


    /**
     * Gets the campoDinamico value for this PParadaItem.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this PParadaItem.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the estado value for this PParadaItem.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PParadaItem.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the referenciaExternaEstado value for this PParadaItem.
     * 
     * @return referenciaExternaEstado
     */
    public java.lang.String getReferenciaExternaEstado() {
        return referenciaExternaEstado;
    }


    /**
     * Sets the referenciaExternaEstado value for this PParadaItem.
     * 
     * @param referenciaExternaEstado
     */
    public void setReferenciaExternaEstado(java.lang.String referenciaExternaEstado) {
        this.referenciaExternaEstado = referenciaExternaEstado;
    }


    /**
     * Gets the valor_Corte value for this PParadaItem.
     * 
     * @return valor_Corte
     */
    public java.lang.Float getValor_Corte() {
        return valor_Corte;
    }


    /**
     * Sets the valor_Corte value for this PParadaItem.
     * 
     * @param valor_Corte
     */
    public void setValor_Corte(java.lang.Float valor_Corte) {
        this.valor_Corte = valor_Corte;
    }


    /**
     * Gets the apilable_Permitido value for this PParadaItem.
     * 
     * @return apilable_Permitido
     */
    public java.lang.Integer getApilable_Permitido() {
        return apilable_Permitido;
    }


    /**
     * Sets the apilable_Permitido value for this PParadaItem.
     * 
     * @param apilable_Permitido
     */
    public void setApilable_Permitido(java.lang.Integer apilable_Permitido) {
        this.apilable_Permitido = apilable_Permitido;
    }


    /**
     * Gets the cantidadEntregada value for this PParadaItem.
     * 
     * @return cantidadEntregada
     */
    public java.lang.Double getCantidadEntregada() {
        return cantidadEntregada;
    }


    /**
     * Sets the cantidadEntregada value for this PParadaItem.
     * 
     * @param cantidadEntregada
     */
    public void setCantidadEntregada(java.lang.Double cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PParadaItem)) return false;
        PParadaItem other = (PParadaItem) obj;
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
            ((this.motivoEntrega==null && other.getMotivoEntrega()==null) || 
             (this.motivoEntrega!=null &&
              this.motivoEntrega.equals(other.getMotivoEntrega()))) &&
            ((this.producto==null && other.getProducto()==null) || 
             (this.producto!=null &&
              this.producto.equals(other.getProducto()))) &&
            ((this.tipoRotacionPermitida==null && other.getTipoRotacionPermitida()==null) || 
             (this.tipoRotacionPermitida!=null &&
              this.tipoRotacionPermitida.equals(other.getTipoRotacionPermitida()))) &&
            ((this.varchar1==null && other.getVarchar1()==null) || 
             (this.varchar1!=null &&
              this.varchar1.equals(other.getVarchar1()))) &&
            ((this.varchar2==null && other.getVarchar2()==null) || 
             (this.varchar2!=null &&
              this.varchar2.equals(other.getVarchar2()))) &&
            ((this.varchar3==null && other.getVarchar3()==null) || 
             (this.varchar3!=null &&
              this.varchar3.equals(other.getVarchar3()))) &&
            ((this.etiquetas==null && other.getEtiquetas()==null) || 
             (this.etiquetas!=null &&
              java.util.Arrays.equals(this.etiquetas, other.getEtiquetas()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.referenciaExternaEstado==null && other.getReferenciaExternaEstado()==null) || 
             (this.referenciaExternaEstado!=null &&
              this.referenciaExternaEstado.equals(other.getReferenciaExternaEstado()))) &&
            ((this.valor_Corte==null && other.getValor_Corte()==null) || 
             (this.valor_Corte!=null &&
              this.valor_Corte.equals(other.getValor_Corte()))) &&
            ((this.apilable_Permitido==null && other.getApilable_Permitido()==null) || 
             (this.apilable_Permitido!=null &&
              this.apilable_Permitido.equals(other.getApilable_Permitido()))) &&
            ((this.cantidadEntregada==null && other.getCantidadEntregada()==null) || 
             (this.cantidadEntregada!=null &&
              this.cantidadEntregada.equals(other.getCantidadEntregada())));
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
        if (getMotivoEntrega() != null) {
            _hashCode += getMotivoEntrega().hashCode();
        }
        if (getProducto() != null) {
            _hashCode += getProducto().hashCode();
        }
        if (getTipoRotacionPermitida() != null) {
            _hashCode += getTipoRotacionPermitida().hashCode();
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
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getReferenciaExternaEstado() != null) {
            _hashCode += getReferenciaExternaEstado().hashCode();
        }
        if (getValor_Corte() != null) {
            _hashCode += getValor_Corte().hashCode();
        }
        if (getApilable_Permitido() != null) {
            _hashCode += getApilable_Permitido().hashCode();
        }
        if (getCantidadEntregada() != null) {
            _hashCode += getCantidadEntregada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PParadaItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem"));
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
        elemField.setFieldName("motivoEntrega");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "MotivoEntrega"));
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
        elemField.setFieldName("tipoRotacionPermitida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoRotacionPermitida"));
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
        elemField.setFieldName("etiquetas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Etiquetas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEtiqueta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEtiqueta"));
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
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExternaEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor_Corte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Valor_Corte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apilable_Permitido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apilable_Permitido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadEntregada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CantidadEntregada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
