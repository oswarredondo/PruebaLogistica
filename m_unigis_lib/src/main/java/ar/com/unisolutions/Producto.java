/**
 * Producto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class Producto  extends ar.com.unisolutions.AbstractEntitieDynamicFields  implements java.io.Serializable {
    private java.lang.String referenciaExterna;

    private long idProducto;

    private java.lang.String descripcion;

    private int idEmpresa;

    private java.lang.String linea;

    private java.lang.String subLinea;

    private java.lang.String codigo;

    private double volumen;

    private double peso;

    private double ancho;

    private double alto;

    private double profundidad;

    private java.lang.String rotacionesPermitidas;

    private boolean apilable;

    private java.lang.Integer idCliente;

    private boolean eliminado;

    private java.util.Calendar fechaEliminacion;

    private double tiempoDescarga;

    private double costo;

    private java.lang.Integer idUnidadMedida;

    private boolean reUtilizable;

    private java.lang.Integer cantidadStockAdvertencia;

    private java.lang.Double ordenamiento;

    private java.lang.Double equivalenciaPallet;

    private java.lang.Integer stockDisponible;

    private java.lang.Integer productoStockTotal;

    private java.lang.Integer productoStockOnHand;

    private java.lang.Integer productoStockAllocated;

    private java.lang.Integer productoStockAvailable;

    public Producto() {
    }

    public Producto(
           ar.com.unisolutions.DynamicField[] dynamicFieldsList,
           java.lang.String referenciaExterna,
           long idProducto,
           java.lang.String descripcion,
           int idEmpresa,
           java.lang.String linea,
           java.lang.String subLinea,
           java.lang.String codigo,
           double volumen,
           double peso,
           double ancho,
           double alto,
           double profundidad,
           java.lang.String rotacionesPermitidas,
           boolean apilable,
           java.lang.Integer idCliente,
           boolean eliminado,
           java.util.Calendar fechaEliminacion,
           double tiempoDescarga,
           double costo,
           java.lang.Integer idUnidadMedida,
           boolean reUtilizable,
           java.lang.Integer cantidadStockAdvertencia,
           java.lang.Double ordenamiento,
           java.lang.Double equivalenciaPallet,
           java.lang.Integer stockDisponible,
           java.lang.Integer productoStockTotal,
           java.lang.Integer productoStockOnHand,
           java.lang.Integer productoStockAllocated,
           java.lang.Integer productoStockAvailable) {
        super(
            dynamicFieldsList);
        this.referenciaExterna = referenciaExterna;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.idEmpresa = idEmpresa;
        this.linea = linea;
        this.subLinea = subLinea;
        this.codigo = codigo;
        this.volumen = volumen;
        this.peso = peso;
        this.ancho = ancho;
        this.alto = alto;
        this.profundidad = profundidad;
        this.rotacionesPermitidas = rotacionesPermitidas;
        this.apilable = apilable;
        this.idCliente = idCliente;
        this.eliminado = eliminado;
        this.fechaEliminacion = fechaEliminacion;
        this.tiempoDescarga = tiempoDescarga;
        this.costo = costo;
        this.idUnidadMedida = idUnidadMedida;
        this.reUtilizable = reUtilizable;
        this.cantidadStockAdvertencia = cantidadStockAdvertencia;
        this.ordenamiento = ordenamiento;
        this.equivalenciaPallet = equivalenciaPallet;
        this.stockDisponible = stockDisponible;
        this.productoStockTotal = productoStockTotal;
        this.productoStockOnHand = productoStockOnHand;
        this.productoStockAllocated = productoStockAllocated;
        this.productoStockAvailable = productoStockAvailable;
    }


    /**
     * Gets the referenciaExterna value for this Producto.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this Producto.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the idProducto value for this Producto.
     * 
     * @return idProducto
     */
    public long getIdProducto() {
        return idProducto;
    }


    /**
     * Sets the idProducto value for this Producto.
     * 
     * @param idProducto
     */
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }


    /**
     * Gets the descripcion value for this Producto.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Producto.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the idEmpresa value for this Producto.
     * 
     * @return idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }


    /**
     * Sets the idEmpresa value for this Producto.
     * 
     * @param idEmpresa
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    /**
     * Gets the linea value for this Producto.
     * 
     * @return linea
     */
    public java.lang.String getLinea() {
        return linea;
    }


    /**
     * Sets the linea value for this Producto.
     * 
     * @param linea
     */
    public void setLinea(java.lang.String linea) {
        this.linea = linea;
    }


    /**
     * Gets the subLinea value for this Producto.
     * 
     * @return subLinea
     */
    public java.lang.String getSubLinea() {
        return subLinea;
    }


    /**
     * Sets the subLinea value for this Producto.
     * 
     * @param subLinea
     */
    public void setSubLinea(java.lang.String subLinea) {
        this.subLinea = subLinea;
    }


    /**
     * Gets the codigo value for this Producto.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this Producto.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the volumen value for this Producto.
     * 
     * @return volumen
     */
    public double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this Producto.
     * 
     * @param volumen
     */
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this Producto.
     * 
     * @return peso
     */
    public double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this Producto.
     * 
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }


    /**
     * Gets the ancho value for this Producto.
     * 
     * @return ancho
     */
    public double getAncho() {
        return ancho;
    }


    /**
     * Sets the ancho value for this Producto.
     * 
     * @param ancho
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }


    /**
     * Gets the alto value for this Producto.
     * 
     * @return alto
     */
    public double getAlto() {
        return alto;
    }


    /**
     * Sets the alto value for this Producto.
     * 
     * @param alto
     */
    public void setAlto(double alto) {
        this.alto = alto;
    }


    /**
     * Gets the profundidad value for this Producto.
     * 
     * @return profundidad
     */
    public double getProfundidad() {
        return profundidad;
    }


    /**
     * Sets the profundidad value for this Producto.
     * 
     * @param profundidad
     */
    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }


    /**
     * Gets the rotacionesPermitidas value for this Producto.
     * 
     * @return rotacionesPermitidas
     */
    public java.lang.String getRotacionesPermitidas() {
        return rotacionesPermitidas;
    }


    /**
     * Sets the rotacionesPermitidas value for this Producto.
     * 
     * @param rotacionesPermitidas
     */
    public void setRotacionesPermitidas(java.lang.String rotacionesPermitidas) {
        this.rotacionesPermitidas = rotacionesPermitidas;
    }


    /**
     * Gets the apilable value for this Producto.
     * 
     * @return apilable
     */
    public boolean isApilable() {
        return apilable;
    }


    /**
     * Sets the apilable value for this Producto.
     * 
     * @param apilable
     */
    public void setApilable(boolean apilable) {
        this.apilable = apilable;
    }


    /**
     * Gets the idCliente value for this Producto.
     * 
     * @return idCliente
     */
    public java.lang.Integer getIdCliente() {
        return idCliente;
    }


    /**
     * Sets the idCliente value for this Producto.
     * 
     * @param idCliente
     */
    public void setIdCliente(java.lang.Integer idCliente) {
        this.idCliente = idCliente;
    }


    /**
     * Gets the eliminado value for this Producto.
     * 
     * @return eliminado
     */
    public boolean isEliminado() {
        return eliminado;
    }


    /**
     * Sets the eliminado value for this Producto.
     * 
     * @param eliminado
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }


    /**
     * Gets the fechaEliminacion value for this Producto.
     * 
     * @return fechaEliminacion
     */
    public java.util.Calendar getFechaEliminacion() {
        return fechaEliminacion;
    }


    /**
     * Sets the fechaEliminacion value for this Producto.
     * 
     * @param fechaEliminacion
     */
    public void setFechaEliminacion(java.util.Calendar fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }


    /**
     * Gets the tiempoDescarga value for this Producto.
     * 
     * @return tiempoDescarga
     */
    public double getTiempoDescarga() {
        return tiempoDescarga;
    }


    /**
     * Sets the tiempoDescarga value for this Producto.
     * 
     * @param tiempoDescarga
     */
    public void setTiempoDescarga(double tiempoDescarga) {
        this.tiempoDescarga = tiempoDescarga;
    }


    /**
     * Gets the costo value for this Producto.
     * 
     * @return costo
     */
    public double getCosto() {
        return costo;
    }


    /**
     * Sets the costo value for this Producto.
     * 
     * @param costo
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }


    /**
     * Gets the idUnidadMedida value for this Producto.
     * 
     * @return idUnidadMedida
     */
    public java.lang.Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }


    /**
     * Sets the idUnidadMedida value for this Producto.
     * 
     * @param idUnidadMedida
     */
    public void setIdUnidadMedida(java.lang.Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }


    /**
     * Gets the reUtilizable value for this Producto.
     * 
     * @return reUtilizable
     */
    public boolean isReUtilizable() {
        return reUtilizable;
    }


    /**
     * Sets the reUtilizable value for this Producto.
     * 
     * @param reUtilizable
     */
    public void setReUtilizable(boolean reUtilizable) {
        this.reUtilizable = reUtilizable;
    }


    /**
     * Gets the cantidadStockAdvertencia value for this Producto.
     * 
     * @return cantidadStockAdvertencia
     */
    public java.lang.Integer getCantidadStockAdvertencia() {
        return cantidadStockAdvertencia;
    }


    /**
     * Sets the cantidadStockAdvertencia value for this Producto.
     * 
     * @param cantidadStockAdvertencia
     */
    public void setCantidadStockAdvertencia(java.lang.Integer cantidadStockAdvertencia) {
        this.cantidadStockAdvertencia = cantidadStockAdvertencia;
    }


    /**
     * Gets the ordenamiento value for this Producto.
     * 
     * @return ordenamiento
     */
    public java.lang.Double getOrdenamiento() {
        return ordenamiento;
    }


    /**
     * Sets the ordenamiento value for this Producto.
     * 
     * @param ordenamiento
     */
    public void setOrdenamiento(java.lang.Double ordenamiento) {
        this.ordenamiento = ordenamiento;
    }


    /**
     * Gets the equivalenciaPallet value for this Producto.
     * 
     * @return equivalenciaPallet
     */
    public java.lang.Double getEquivalenciaPallet() {
        return equivalenciaPallet;
    }


    /**
     * Sets the equivalenciaPallet value for this Producto.
     * 
     * @param equivalenciaPallet
     */
    public void setEquivalenciaPallet(java.lang.Double equivalenciaPallet) {
        this.equivalenciaPallet = equivalenciaPallet;
    }


    /**
     * Gets the stockDisponible value for this Producto.
     * 
     * @return stockDisponible
     */
    public java.lang.Integer getStockDisponible() {
        return stockDisponible;
    }


    /**
     * Sets the stockDisponible value for this Producto.
     * 
     * @param stockDisponible
     */
    public void setStockDisponible(java.lang.Integer stockDisponible) {
        this.stockDisponible = stockDisponible;
    }


    /**
     * Gets the productoStockTotal value for this Producto.
     * 
     * @return productoStockTotal
     */
    public java.lang.Integer getProductoStockTotal() {
        return productoStockTotal;
    }


    /**
     * Sets the productoStockTotal value for this Producto.
     * 
     * @param productoStockTotal
     */
    public void setProductoStockTotal(java.lang.Integer productoStockTotal) {
        this.productoStockTotal = productoStockTotal;
    }


    /**
     * Gets the productoStockOnHand value for this Producto.
     * 
     * @return productoStockOnHand
     */
    public java.lang.Integer getProductoStockOnHand() {
        return productoStockOnHand;
    }


    /**
     * Sets the productoStockOnHand value for this Producto.
     * 
     * @param productoStockOnHand
     */
    public void setProductoStockOnHand(java.lang.Integer productoStockOnHand) {
        this.productoStockOnHand = productoStockOnHand;
    }


    /**
     * Gets the productoStockAllocated value for this Producto.
     * 
     * @return productoStockAllocated
     */
    public java.lang.Integer getProductoStockAllocated() {
        return productoStockAllocated;
    }


    /**
     * Sets the productoStockAllocated value for this Producto.
     * 
     * @param productoStockAllocated
     */
    public void setProductoStockAllocated(java.lang.Integer productoStockAllocated) {
        this.productoStockAllocated = productoStockAllocated;
    }


    /**
     * Gets the productoStockAvailable value for this Producto.
     * 
     * @return productoStockAvailable
     */
    public java.lang.Integer getProductoStockAvailable() {
        return productoStockAvailable;
    }


    /**
     * Sets the productoStockAvailable value for this Producto.
     * 
     * @param productoStockAvailable
     */
    public void setProductoStockAvailable(java.lang.Integer productoStockAvailable) {
        this.productoStockAvailable = productoStockAvailable;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Producto)) return false;
        Producto other = (Producto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            this.idProducto == other.getIdProducto() &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.idEmpresa == other.getIdEmpresa() &&
            ((this.linea==null && other.getLinea()==null) || 
             (this.linea!=null &&
              this.linea.equals(other.getLinea()))) &&
            ((this.subLinea==null && other.getSubLinea()==null) || 
             (this.subLinea!=null &&
              this.subLinea.equals(other.getSubLinea()))) &&
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            this.volumen == other.getVolumen() &&
            this.peso == other.getPeso() &&
            this.ancho == other.getAncho() &&
            this.alto == other.getAlto() &&
            this.profundidad == other.getProfundidad() &&
            ((this.rotacionesPermitidas==null && other.getRotacionesPermitidas()==null) || 
             (this.rotacionesPermitidas!=null &&
              this.rotacionesPermitidas.equals(other.getRotacionesPermitidas()))) &&
            this.apilable == other.isApilable() &&
            ((this.idCliente==null && other.getIdCliente()==null) || 
             (this.idCliente!=null &&
              this.idCliente.equals(other.getIdCliente()))) &&
            this.eliminado == other.isEliminado() &&
            ((this.fechaEliminacion==null && other.getFechaEliminacion()==null) || 
             (this.fechaEliminacion!=null &&
              this.fechaEliminacion.equals(other.getFechaEliminacion()))) &&
            this.tiempoDescarga == other.getTiempoDescarga() &&
            this.costo == other.getCosto() &&
            ((this.idUnidadMedida==null && other.getIdUnidadMedida()==null) || 
             (this.idUnidadMedida!=null &&
              this.idUnidadMedida.equals(other.getIdUnidadMedida()))) &&
            this.reUtilizable == other.isReUtilizable() &&
            ((this.cantidadStockAdvertencia==null && other.getCantidadStockAdvertencia()==null) || 
             (this.cantidadStockAdvertencia!=null &&
              this.cantidadStockAdvertencia.equals(other.getCantidadStockAdvertencia()))) &&
            ((this.ordenamiento==null && other.getOrdenamiento()==null) || 
             (this.ordenamiento!=null &&
              this.ordenamiento.equals(other.getOrdenamiento()))) &&
            ((this.equivalenciaPallet==null && other.getEquivalenciaPallet()==null) || 
             (this.equivalenciaPallet!=null &&
              this.equivalenciaPallet.equals(other.getEquivalenciaPallet()))) &&
            ((this.stockDisponible==null && other.getStockDisponible()==null) || 
             (this.stockDisponible!=null &&
              this.stockDisponible.equals(other.getStockDisponible()))) &&
            ((this.productoStockTotal==null && other.getProductoStockTotal()==null) || 
             (this.productoStockTotal!=null &&
              this.productoStockTotal.equals(other.getProductoStockTotal()))) &&
            ((this.productoStockOnHand==null && other.getProductoStockOnHand()==null) || 
             (this.productoStockOnHand!=null &&
              this.productoStockOnHand.equals(other.getProductoStockOnHand()))) &&
            ((this.productoStockAllocated==null && other.getProductoStockAllocated()==null) || 
             (this.productoStockAllocated!=null &&
              this.productoStockAllocated.equals(other.getProductoStockAllocated()))) &&
            ((this.productoStockAvailable==null && other.getProductoStockAvailable()==null) || 
             (this.productoStockAvailable!=null &&
              this.productoStockAvailable.equals(other.getProductoStockAvailable())));
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
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        _hashCode += new Long(getIdProducto()).hashCode();
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += getIdEmpresa();
        if (getLinea() != null) {
            _hashCode += getLinea().hashCode();
        }
        if (getSubLinea() != null) {
            _hashCode += getSubLinea().hashCode();
        }
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        _hashCode += new Double(getVolumen()).hashCode();
        _hashCode += new Double(getPeso()).hashCode();
        _hashCode += new Double(getAncho()).hashCode();
        _hashCode += new Double(getAlto()).hashCode();
        _hashCode += new Double(getProfundidad()).hashCode();
        if (getRotacionesPermitidas() != null) {
            _hashCode += getRotacionesPermitidas().hashCode();
        }
        _hashCode += (isApilable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIdCliente() != null) {
            _hashCode += getIdCliente().hashCode();
        }
        _hashCode += (isEliminado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFechaEliminacion() != null) {
            _hashCode += getFechaEliminacion().hashCode();
        }
        _hashCode += new Double(getTiempoDescarga()).hashCode();
        _hashCode += new Double(getCosto()).hashCode();
        if (getIdUnidadMedida() != null) {
            _hashCode += getIdUnidadMedida().hashCode();
        }
        _hashCode += (isReUtilizable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCantidadStockAdvertencia() != null) {
            _hashCode += getCantidadStockAdvertencia().hashCode();
        }
        if (getOrdenamiento() != null) {
            _hashCode += getOrdenamiento().hashCode();
        }
        if (getEquivalenciaPallet() != null) {
            _hashCode += getEquivalenciaPallet().hashCode();
        }
        if (getStockDisponible() != null) {
            _hashCode += getStockDisponible().hashCode();
        }
        if (getProductoStockTotal() != null) {
            _hashCode += getProductoStockTotal().hashCode();
        }
        if (getProductoStockOnHand() != null) {
            _hashCode += getProductoStockOnHand().hashCode();
        }
        if (getProductoStockAllocated() != null) {
            _hashCode += getProductoStockAllocated().hashCode();
        }
        if (getProductoStockAvailable() != null) {
            _hashCode += getProductoStockAvailable().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Producto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Producto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProducto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdProducto"));
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
        elemField.setFieldName("idEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdEmpresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linea");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Linea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subLinea");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "SubLinea"));
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
        elemField.setFieldName("ancho");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ancho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Alto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profundidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Profundidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rotacionesPermitidas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RotacionesPermitidas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apilable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apilable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempoDescarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoDescarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUnidadMedida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdUnidadMedida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reUtilizable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReUtilizable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadStockAdvertencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CantidadStockAdvertencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordenamiento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ordenamiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("equivalenciaPallet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EquivalenciaPallet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stockDisponible");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "StockDisponible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productoStockTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ProductoStockTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productoStockOnHand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ProductoStockOnHand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productoStockAllocated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ProductoStockAllocated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productoStockAvailable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ProductoStockAvailable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
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
