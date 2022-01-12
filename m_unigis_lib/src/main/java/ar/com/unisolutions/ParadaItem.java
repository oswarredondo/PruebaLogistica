/**
 * ParadaItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ParadaItem  extends ar.com.unisolutions.AbstractEntitie  implements java.io.Serializable {
    private double cantidad;

    private int idParadaItem;

    private java.lang.String referenciaExterna;

    private java.lang.String referenciaAdicional;

    private int idParada;

    private long idProducto;

    private java.lang.String descripcion;

    private double valorCorte;

    private double volumen;

    private double peso;

    private double bultos;

    private double pallets;

    private double ancho;

    private double alto;

    private double profundidad;

    private java.lang.String tipoRotacionPermitida;

    private int apilablePermitido;

    private double cargoX;

    private double cargoY;

    private double cargoZ;

    private int cargoRotacion;

    private int cargoEstado;

    private int flagProceso;

    private java.lang.Integer unidades;

    private java.lang.String LPN;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String varchar3;

    private java.lang.String productoLinea;

    private java.lang.String productoSubLinea;

    private java.lang.Long idOrdenItem;

    private double cantidadReal;

    private ar.com.unisolutions.Producto producto;

    private java.lang.String[] etiquetas;

    private ar.com.unisolutions.Motivo motivo;

    public ParadaItem() {
    }

    public ParadaItem(
           double cantidad,
           int idParadaItem,
           java.lang.String referenciaExterna,
           java.lang.String referenciaAdicional,
           int idParada,
           long idProducto,
           java.lang.String descripcion,
           double valorCorte,
           double volumen,
           double peso,
           double bultos,
           double pallets,
           double ancho,
           double alto,
           double profundidad,
           java.lang.String tipoRotacionPermitida,
           int apilablePermitido,
           double cargoX,
           double cargoY,
           double cargoZ,
           int cargoRotacion,
           int cargoEstado,
           int flagProceso,
           java.lang.Integer unidades,
           java.lang.String LPN,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           java.lang.String productoLinea,
           java.lang.String productoSubLinea,
           java.lang.Long idOrdenItem,
           double cantidadReal,
           ar.com.unisolutions.Producto producto,
           java.lang.String[] etiquetas,
           ar.com.unisolutions.Motivo motivo) {
        this.cantidad = cantidad;
        this.idParadaItem = idParadaItem;
        this.referenciaExterna = referenciaExterna;
        this.referenciaAdicional = referenciaAdicional;
        this.idParada = idParada;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.valorCorte = valorCorte;
        this.volumen = volumen;
        this.peso = peso;
        this.bultos = bultos;
        this.pallets = pallets;
        this.ancho = ancho;
        this.alto = alto;
        this.profundidad = profundidad;
        this.tipoRotacionPermitida = tipoRotacionPermitida;
        this.apilablePermitido = apilablePermitido;
        this.cargoX = cargoX;
        this.cargoY = cargoY;
        this.cargoZ = cargoZ;
        this.cargoRotacion = cargoRotacion;
        this.cargoEstado = cargoEstado;
        this.flagProceso = flagProceso;
        this.unidades = unidades;
        this.LPN = LPN;
        this.varchar1 = varchar1;
        this.varchar2 = varchar2;
        this.varchar3 = varchar3;
        this.productoLinea = productoLinea;
        this.productoSubLinea = productoSubLinea;
        this.idOrdenItem = idOrdenItem;
        this.cantidadReal = cantidadReal;
        this.producto = producto;
        this.etiquetas = etiquetas;
        this.motivo = motivo;
    }


    /**
     * Gets the cantidad value for this ParadaItem.
     * 
     * @return cantidad
     */
    public double getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this ParadaItem.
     * 
     * @param cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the idParadaItem value for this ParadaItem.
     * 
     * @return idParadaItem
     */
    public int getIdParadaItem() {
        return idParadaItem;
    }


    /**
     * Sets the idParadaItem value for this ParadaItem.
     * 
     * @param idParadaItem
     */
    public void setIdParadaItem(int idParadaItem) {
        this.idParadaItem = idParadaItem;
    }


    /**
     * Gets the referenciaExterna value for this ParadaItem.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this ParadaItem.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the referenciaAdicional value for this ParadaItem.
     * 
     * @return referenciaAdicional
     */
    public java.lang.String getReferenciaAdicional() {
        return referenciaAdicional;
    }


    /**
     * Sets the referenciaAdicional value for this ParadaItem.
     * 
     * @param referenciaAdicional
     */
    public void setReferenciaAdicional(java.lang.String referenciaAdicional) {
        this.referenciaAdicional = referenciaAdicional;
    }


    /**
     * Gets the idParada value for this ParadaItem.
     * 
     * @return idParada
     */
    public int getIdParada() {
        return idParada;
    }


    /**
     * Sets the idParada value for this ParadaItem.
     * 
     * @param idParada
     */
    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }


    /**
     * Gets the idProducto value for this ParadaItem.
     * 
     * @return idProducto
     */
    public long getIdProducto() {
        return idProducto;
    }


    /**
     * Sets the idProducto value for this ParadaItem.
     * 
     * @param idProducto
     */
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }


    /**
     * Gets the descripcion value for this ParadaItem.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ParadaItem.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the valorCorte value for this ParadaItem.
     * 
     * @return valorCorte
     */
    public double getValorCorte() {
        return valorCorte;
    }


    /**
     * Sets the valorCorte value for this ParadaItem.
     * 
     * @param valorCorte
     */
    public void setValorCorte(double valorCorte) {
        this.valorCorte = valorCorte;
    }


    /**
     * Gets the volumen value for this ParadaItem.
     * 
     * @return volumen
     */
    public double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this ParadaItem.
     * 
     * @param volumen
     */
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this ParadaItem.
     * 
     * @return peso
     */
    public double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this ParadaItem.
     * 
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }


    /**
     * Gets the bultos value for this ParadaItem.
     * 
     * @return bultos
     */
    public double getBultos() {
        return bultos;
    }


    /**
     * Sets the bultos value for this ParadaItem.
     * 
     * @param bultos
     */
    public void setBultos(double bultos) {
        this.bultos = bultos;
    }


    /**
     * Gets the pallets value for this ParadaItem.
     * 
     * @return pallets
     */
    public double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this ParadaItem.
     * 
     * @param pallets
     */
    public void setPallets(double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the ancho value for this ParadaItem.
     * 
     * @return ancho
     */
    public double getAncho() {
        return ancho;
    }


    /**
     * Sets the ancho value for this ParadaItem.
     * 
     * @param ancho
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }


    /**
     * Gets the alto value for this ParadaItem.
     * 
     * @return alto
     */
    public double getAlto() {
        return alto;
    }


    /**
     * Sets the alto value for this ParadaItem.
     * 
     * @param alto
     */
    public void setAlto(double alto) {
        this.alto = alto;
    }


    /**
     * Gets the profundidad value for this ParadaItem.
     * 
     * @return profundidad
     */
    public double getProfundidad() {
        return profundidad;
    }


    /**
     * Sets the profundidad value for this ParadaItem.
     * 
     * @param profundidad
     */
    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }


    /**
     * Gets the tipoRotacionPermitida value for this ParadaItem.
     * 
     * @return tipoRotacionPermitida
     */
    public java.lang.String getTipoRotacionPermitida() {
        return tipoRotacionPermitida;
    }


    /**
     * Sets the tipoRotacionPermitida value for this ParadaItem.
     * 
     * @param tipoRotacionPermitida
     */
    public void setTipoRotacionPermitida(java.lang.String tipoRotacionPermitida) {
        this.tipoRotacionPermitida = tipoRotacionPermitida;
    }


    /**
     * Gets the apilablePermitido value for this ParadaItem.
     * 
     * @return apilablePermitido
     */
    public int getApilablePermitido() {
        return apilablePermitido;
    }


    /**
     * Sets the apilablePermitido value for this ParadaItem.
     * 
     * @param apilablePermitido
     */
    public void setApilablePermitido(int apilablePermitido) {
        this.apilablePermitido = apilablePermitido;
    }


    /**
     * Gets the cargoX value for this ParadaItem.
     * 
     * @return cargoX
     */
    public double getCargoX() {
        return cargoX;
    }


    /**
     * Sets the cargoX value for this ParadaItem.
     * 
     * @param cargoX
     */
    public void setCargoX(double cargoX) {
        this.cargoX = cargoX;
    }


    /**
     * Gets the cargoY value for this ParadaItem.
     * 
     * @return cargoY
     */
    public double getCargoY() {
        return cargoY;
    }


    /**
     * Sets the cargoY value for this ParadaItem.
     * 
     * @param cargoY
     */
    public void setCargoY(double cargoY) {
        this.cargoY = cargoY;
    }


    /**
     * Gets the cargoZ value for this ParadaItem.
     * 
     * @return cargoZ
     */
    public double getCargoZ() {
        return cargoZ;
    }


    /**
     * Sets the cargoZ value for this ParadaItem.
     * 
     * @param cargoZ
     */
    public void setCargoZ(double cargoZ) {
        this.cargoZ = cargoZ;
    }


    /**
     * Gets the cargoRotacion value for this ParadaItem.
     * 
     * @return cargoRotacion
     */
    public int getCargoRotacion() {
        return cargoRotacion;
    }


    /**
     * Sets the cargoRotacion value for this ParadaItem.
     * 
     * @param cargoRotacion
     */
    public void setCargoRotacion(int cargoRotacion) {
        this.cargoRotacion = cargoRotacion;
    }


    /**
     * Gets the cargoEstado value for this ParadaItem.
     * 
     * @return cargoEstado
     */
    public int getCargoEstado() {
        return cargoEstado;
    }


    /**
     * Sets the cargoEstado value for this ParadaItem.
     * 
     * @param cargoEstado
     */
    public void setCargoEstado(int cargoEstado) {
        this.cargoEstado = cargoEstado;
    }


    /**
     * Gets the flagProceso value for this ParadaItem.
     * 
     * @return flagProceso
     */
    public int getFlagProceso() {
        return flagProceso;
    }


    /**
     * Sets the flagProceso value for this ParadaItem.
     * 
     * @param flagProceso
     */
    public void setFlagProceso(int flagProceso) {
        this.flagProceso = flagProceso;
    }


    /**
     * Gets the unidades value for this ParadaItem.
     * 
     * @return unidades
     */
    public java.lang.Integer getUnidades() {
        return unidades;
    }


    /**
     * Sets the unidades value for this ParadaItem.
     * 
     * @param unidades
     */
    public void setUnidades(java.lang.Integer unidades) {
        this.unidades = unidades;
    }


    /**
     * Gets the LPN value for this ParadaItem.
     * 
     * @return LPN
     */
    public java.lang.String getLPN() {
        return LPN;
    }


    /**
     * Sets the LPN value for this ParadaItem.
     * 
     * @param LPN
     */
    public void setLPN(java.lang.String LPN) {
        this.LPN = LPN;
    }


    /**
     * Gets the varchar1 value for this ParadaItem.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this ParadaItem.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this ParadaItem.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this ParadaItem.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the varchar3 value for this ParadaItem.
     * 
     * @return varchar3
     */
    public java.lang.String getVarchar3() {
        return varchar3;
    }


    /**
     * Sets the varchar3 value for this ParadaItem.
     * 
     * @param varchar3
     */
    public void setVarchar3(java.lang.String varchar3) {
        this.varchar3 = varchar3;
    }


    /**
     * Gets the productoLinea value for this ParadaItem.
     * 
     * @return productoLinea
     */
    public java.lang.String getProductoLinea() {
        return productoLinea;
    }


    /**
     * Sets the productoLinea value for this ParadaItem.
     * 
     * @param productoLinea
     */
    public void setProductoLinea(java.lang.String productoLinea) {
        this.productoLinea = productoLinea;
    }


    /**
     * Gets the productoSubLinea value for this ParadaItem.
     * 
     * @return productoSubLinea
     */
    public java.lang.String getProductoSubLinea() {
        return productoSubLinea;
    }


    /**
     * Sets the productoSubLinea value for this ParadaItem.
     * 
     * @param productoSubLinea
     */
    public void setProductoSubLinea(java.lang.String productoSubLinea) {
        this.productoSubLinea = productoSubLinea;
    }


    /**
     * Gets the idOrdenItem value for this ParadaItem.
     * 
     * @return idOrdenItem
     */
    public java.lang.Long getIdOrdenItem() {
        return idOrdenItem;
    }


    /**
     * Sets the idOrdenItem value for this ParadaItem.
     * 
     * @param idOrdenItem
     */
    public void setIdOrdenItem(java.lang.Long idOrdenItem) {
        this.idOrdenItem = idOrdenItem;
    }


    /**
     * Gets the cantidadReal value for this ParadaItem.
     * 
     * @return cantidadReal
     */
    public double getCantidadReal() {
        return cantidadReal;
    }


    /**
     * Sets the cantidadReal value for this ParadaItem.
     * 
     * @param cantidadReal
     */
    public void setCantidadReal(double cantidadReal) {
        this.cantidadReal = cantidadReal;
    }


    /**
     * Gets the producto value for this ParadaItem.
     * 
     * @return producto
     */
    public ar.com.unisolutions.Producto getProducto() {
        return producto;
    }


    /**
     * Sets the producto value for this ParadaItem.
     * 
     * @param producto
     */
    public void setProducto(ar.com.unisolutions.Producto producto) {
        this.producto = producto;
    }


    /**
     * Gets the etiquetas value for this ParadaItem.
     * 
     * @return etiquetas
     */
    public java.lang.String[] getEtiquetas() {
        return etiquetas;
    }


    /**
     * Sets the etiquetas value for this ParadaItem.
     * 
     * @param etiquetas
     */
    public void setEtiquetas(java.lang.String[] etiquetas) {
        this.etiquetas = etiquetas;
    }


    /**
     * Gets the motivo value for this ParadaItem.
     * 
     * @return motivo
     */
    public ar.com.unisolutions.Motivo getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this ParadaItem.
     * 
     * @param motivo
     */
    public void setMotivo(ar.com.unisolutions.Motivo motivo) {
        this.motivo = motivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParadaItem)) return false;
        ParadaItem other = (ParadaItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.cantidad == other.getCantidad() &&
            this.idParadaItem == other.getIdParadaItem() &&
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.referenciaAdicional==null && other.getReferenciaAdicional()==null) || 
             (this.referenciaAdicional!=null &&
              this.referenciaAdicional.equals(other.getReferenciaAdicional()))) &&
            this.idParada == other.getIdParada() &&
            this.idProducto == other.getIdProducto() &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.valorCorte == other.getValorCorte() &&
            this.volumen == other.getVolumen() &&
            this.peso == other.getPeso() &&
            this.bultos == other.getBultos() &&
            this.pallets == other.getPallets() &&
            this.ancho == other.getAncho() &&
            this.alto == other.getAlto() &&
            this.profundidad == other.getProfundidad() &&
            ((this.tipoRotacionPermitida==null && other.getTipoRotacionPermitida()==null) || 
             (this.tipoRotacionPermitida!=null &&
              this.tipoRotacionPermitida.equals(other.getTipoRotacionPermitida()))) &&
            this.apilablePermitido == other.getApilablePermitido() &&
            this.cargoX == other.getCargoX() &&
            this.cargoY == other.getCargoY() &&
            this.cargoZ == other.getCargoZ() &&
            this.cargoRotacion == other.getCargoRotacion() &&
            this.cargoEstado == other.getCargoEstado() &&
            this.flagProceso == other.getFlagProceso() &&
            ((this.unidades==null && other.getUnidades()==null) || 
             (this.unidades!=null &&
              this.unidades.equals(other.getUnidades()))) &&
            ((this.LPN==null && other.getLPN()==null) || 
             (this.LPN!=null &&
              this.LPN.equals(other.getLPN()))) &&
            ((this.varchar1==null && other.getVarchar1()==null) || 
             (this.varchar1!=null &&
              this.varchar1.equals(other.getVarchar1()))) &&
            ((this.varchar2==null && other.getVarchar2()==null) || 
             (this.varchar2!=null &&
              this.varchar2.equals(other.getVarchar2()))) &&
            ((this.varchar3==null && other.getVarchar3()==null) || 
             (this.varchar3!=null &&
              this.varchar3.equals(other.getVarchar3()))) &&
            ((this.productoLinea==null && other.getProductoLinea()==null) || 
             (this.productoLinea!=null &&
              this.productoLinea.equals(other.getProductoLinea()))) &&
            ((this.productoSubLinea==null && other.getProductoSubLinea()==null) || 
             (this.productoSubLinea!=null &&
              this.productoSubLinea.equals(other.getProductoSubLinea()))) &&
            ((this.idOrdenItem==null && other.getIdOrdenItem()==null) || 
             (this.idOrdenItem!=null &&
              this.idOrdenItem.equals(other.getIdOrdenItem()))) &&
            this.cantidadReal == other.getCantidadReal() &&
            ((this.producto==null && other.getProducto()==null) || 
             (this.producto!=null &&
              this.producto.equals(other.getProducto()))) &&
            ((this.etiquetas==null && other.getEtiquetas()==null) || 
             (this.etiquetas!=null &&
              java.util.Arrays.equals(this.etiquetas, other.getEtiquetas()))) &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo())));
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
        _hashCode += new Double(getCantidad()).hashCode();
        _hashCode += getIdParadaItem();
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getReferenciaAdicional() != null) {
            _hashCode += getReferenciaAdicional().hashCode();
        }
        _hashCode += getIdParada();
        _hashCode += new Long(getIdProducto()).hashCode();
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += new Double(getValorCorte()).hashCode();
        _hashCode += new Double(getVolumen()).hashCode();
        _hashCode += new Double(getPeso()).hashCode();
        _hashCode += new Double(getBultos()).hashCode();
        _hashCode += new Double(getPallets()).hashCode();
        _hashCode += new Double(getAncho()).hashCode();
        _hashCode += new Double(getAlto()).hashCode();
        _hashCode += new Double(getProfundidad()).hashCode();
        if (getTipoRotacionPermitida() != null) {
            _hashCode += getTipoRotacionPermitida().hashCode();
        }
        _hashCode += getApilablePermitido();
        _hashCode += new Double(getCargoX()).hashCode();
        _hashCode += new Double(getCargoY()).hashCode();
        _hashCode += new Double(getCargoZ()).hashCode();
        _hashCode += getCargoRotacion();
        _hashCode += getCargoEstado();
        _hashCode += getFlagProceso();
        if (getUnidades() != null) {
            _hashCode += getUnidades().hashCode();
        }
        if (getLPN() != null) {
            _hashCode += getLPN().hashCode();
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
        if (getProductoLinea() != null) {
            _hashCode += getProductoLinea().hashCode();
        }
        if (getProductoSubLinea() != null) {
            _hashCode += getProductoSubLinea().hashCode();
        }
        if (getIdOrdenItem() != null) {
            _hashCode += getIdOrdenItem().hashCode();
        }
        _hashCode += new Double(getCantidadReal()).hashCode();
        if (getProducto() != null) {
            _hashCode += getProducto().hashCode();
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
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParadaItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ParadaItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParadaItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParadaItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("referenciaAdicional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaAdicional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("valorCorte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValorCorte"));
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
        elemField.setFieldName("bultos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Bultos"));
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
        elemField.setFieldName("tipoRotacionPermitida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoRotacionPermitida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apilablePermitido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApilablePermitido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargoX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargoX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargoY");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargoY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargoZ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargoZ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargoRotacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargoRotacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargoEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargoEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagProceso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FlagProceso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Unidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LPN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LPN"));
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
        elemField.setFieldName("productoLinea");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ProductoLinea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productoSubLinea");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ProductoSubLinea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOrdenItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdOrdenItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CantidadReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Producto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Producto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Etiquetas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Motivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Motivo"));
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
