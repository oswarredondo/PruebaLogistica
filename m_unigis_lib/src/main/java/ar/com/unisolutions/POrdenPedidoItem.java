/**
 * POrdenPedidoItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class POrdenPedidoItem  implements java.io.Serializable {
    private java.lang.String refDocumento;

    private java.lang.String refDocumentoAdicional;

    private ar.com.unisolutions.PProducto producto;

    private int cantidad;

    private java.lang.Double volumen;

    private java.lang.Double peso;

    private java.lang.Double bulto;

    private java.lang.Double pallets;

    private java.lang.Double importeCosto;

    private java.util.Calendar fechaEntrega;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.Integer int1;

    private java.lang.Integer int2;

    private java.lang.String descripcion;

    private java.lang.String LPN;

    private java.lang.String estadoPedidoItem;

    private java.lang.String motivo;

    private java.lang.String unidadMedida;

    private ar.com.unisolutions.PEtiqueta[] etiquetas;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private ar.com.unisolutions.PCliente domicilioDestino;

    private java.lang.Long idPedidoItem;

    private java.lang.Double unidades;

    private java.lang.Integer referenciaCantidad;

    private java.lang.Double referenciaValor;

    private java.util.Calendar vigenciaDesde;

    private java.util.Calendar vigenciaHasta;

    private java.lang.Integer procesarVolumetria;

    private java.lang.Integer apilable;

    private java.lang.Double alto;

    private java.lang.Double ancho;

    private java.lang.Double profundidad;

    public POrdenPedidoItem() {
    }

    public POrdenPedidoItem(
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           ar.com.unisolutions.PProducto producto,
           int cantidad,
           java.lang.Double volumen,
           java.lang.Double peso,
           java.lang.Double bulto,
           java.lang.Double pallets,
           java.lang.Double importeCosto,
           java.util.Calendar fechaEntrega,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.Integer int1,
           java.lang.Integer int2,
           java.lang.String descripcion,
           java.lang.String LPN,
           java.lang.String estadoPedidoItem,
           java.lang.String motivo,
           java.lang.String unidadMedida,
           ar.com.unisolutions.PEtiqueta[] etiquetas,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           ar.com.unisolutions.PCliente domicilioDestino,
           java.lang.Long idPedidoItem,
           java.lang.Double unidades,
           java.lang.Integer referenciaCantidad,
           java.lang.Double referenciaValor,
           java.util.Calendar vigenciaDesde,
           java.util.Calendar vigenciaHasta,
           java.lang.Integer procesarVolumetria,
           java.lang.Integer apilable,
           java.lang.Double alto,
           java.lang.Double ancho,
           java.lang.Double profundidad) {
           this.refDocumento = refDocumento;
           this.refDocumentoAdicional = refDocumentoAdicional;
           this.producto = producto;
           this.cantidad = cantidad;
           this.volumen = volumen;
           this.peso = peso;
           this.bulto = bulto;
           this.pallets = pallets;
           this.importeCosto = importeCosto;
           this.fechaEntrega = fechaEntrega;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.int1 = int1;
           this.int2 = int2;
           this.descripcion = descripcion;
           this.LPN = LPN;
           this.estadoPedidoItem = estadoPedidoItem;
           this.motivo = motivo;
           this.unidadMedida = unidadMedida;
           this.etiquetas = etiquetas;
           this.campoDinamico = campoDinamico;
           this.domicilioDestino = domicilioDestino;
           this.idPedidoItem = idPedidoItem;
           this.unidades = unidades;
           this.referenciaCantidad = referenciaCantidad;
           this.referenciaValor = referenciaValor;
           this.vigenciaDesde = vigenciaDesde;
           this.vigenciaHasta = vigenciaHasta;
           this.procesarVolumetria = procesarVolumetria;
           this.apilable = apilable;
           this.alto = alto;
           this.ancho = ancho;
           this.profundidad = profundidad;
    }


    /**
     * Gets the refDocumento value for this POrdenPedidoItem.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this POrdenPedidoItem.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the refDocumentoAdicional value for this POrdenPedidoItem.
     * 
     * @return refDocumentoAdicional
     */
    public java.lang.String getRefDocumentoAdicional() {
        return refDocumentoAdicional;
    }


    /**
     * Sets the refDocumentoAdicional value for this POrdenPedidoItem.
     * 
     * @param refDocumentoAdicional
     */
    public void setRefDocumentoAdicional(java.lang.String refDocumentoAdicional) {
        this.refDocumentoAdicional = refDocumentoAdicional;
    }


    /**
     * Gets the producto value for this POrdenPedidoItem.
     * 
     * @return producto
     */
    public ar.com.unisolutions.PProducto getProducto() {
        return producto;
    }


    /**
     * Sets the producto value for this POrdenPedidoItem.
     * 
     * @param producto
     */
    public void setProducto(ar.com.unisolutions.PProducto producto) {
        this.producto = producto;
    }


    /**
     * Gets the cantidad value for this POrdenPedidoItem.
     * 
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this POrdenPedidoItem.
     * 
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the volumen value for this POrdenPedidoItem.
     * 
     * @return volumen
     */
    public java.lang.Double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this POrdenPedidoItem.
     * 
     * @param volumen
     */
    public void setVolumen(java.lang.Double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this POrdenPedidoItem.
     * 
     * @return peso
     */
    public java.lang.Double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this POrdenPedidoItem.
     * 
     * @param peso
     */
    public void setPeso(java.lang.Double peso) {
        this.peso = peso;
    }


    /**
     * Gets the bulto value for this POrdenPedidoItem.
     * 
     * @return bulto
     */
    public java.lang.Double getBulto() {
        return bulto;
    }


    /**
     * Sets the bulto value for this POrdenPedidoItem.
     * 
     * @param bulto
     */
    public void setBulto(java.lang.Double bulto) {
        this.bulto = bulto;
    }


    /**
     * Gets the pallets value for this POrdenPedidoItem.
     * 
     * @return pallets
     */
    public java.lang.Double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this POrdenPedidoItem.
     * 
     * @param pallets
     */
    public void setPallets(java.lang.Double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the importeCosto value for this POrdenPedidoItem.
     * 
     * @return importeCosto
     */
    public java.lang.Double getImporteCosto() {
        return importeCosto;
    }


    /**
     * Sets the importeCosto value for this POrdenPedidoItem.
     * 
     * @param importeCosto
     */
    public void setImporteCosto(java.lang.Double importeCosto) {
        this.importeCosto = importeCosto;
    }


    /**
     * Gets the fechaEntrega value for this POrdenPedidoItem.
     * 
     * @return fechaEntrega
     */
    public java.util.Calendar getFechaEntrega() {
        return fechaEntrega;
    }


    /**
     * Sets the fechaEntrega value for this POrdenPedidoItem.
     * 
     * @param fechaEntrega
     */
    public void setFechaEntrega(java.util.Calendar fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }


    /**
     * Gets the varchar1 value for this POrdenPedidoItem.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this POrdenPedidoItem.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this POrdenPedidoItem.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this POrdenPedidoItem.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the int1 value for this POrdenPedidoItem.
     * 
     * @return int1
     */
    public java.lang.Integer getInt1() {
        return int1;
    }


    /**
     * Sets the int1 value for this POrdenPedidoItem.
     * 
     * @param int1
     */
    public void setInt1(java.lang.Integer int1) {
        this.int1 = int1;
    }


    /**
     * Gets the int2 value for this POrdenPedidoItem.
     * 
     * @return int2
     */
    public java.lang.Integer getInt2() {
        return int2;
    }


    /**
     * Sets the int2 value for this POrdenPedidoItem.
     * 
     * @param int2
     */
    public void setInt2(java.lang.Integer int2) {
        this.int2 = int2;
    }


    /**
     * Gets the descripcion value for this POrdenPedidoItem.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this POrdenPedidoItem.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the LPN value for this POrdenPedidoItem.
     * 
     * @return LPN
     */
    public java.lang.String getLPN() {
        return LPN;
    }


    /**
     * Sets the LPN value for this POrdenPedidoItem.
     * 
     * @param LPN
     */
    public void setLPN(java.lang.String LPN) {
        this.LPN = LPN;
    }


    /**
     * Gets the estadoPedidoItem value for this POrdenPedidoItem.
     * 
     * @return estadoPedidoItem
     */
    public java.lang.String getEstadoPedidoItem() {
        return estadoPedidoItem;
    }


    /**
     * Sets the estadoPedidoItem value for this POrdenPedidoItem.
     * 
     * @param estadoPedidoItem
     */
    public void setEstadoPedidoItem(java.lang.String estadoPedidoItem) {
        this.estadoPedidoItem = estadoPedidoItem;
    }


    /**
     * Gets the motivo value for this POrdenPedidoItem.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this POrdenPedidoItem.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the unidadMedida value for this POrdenPedidoItem.
     * 
     * @return unidadMedida
     */
    public java.lang.String getUnidadMedida() {
        return unidadMedida;
    }


    /**
     * Sets the unidadMedida value for this POrdenPedidoItem.
     * 
     * @param unidadMedida
     */
    public void setUnidadMedida(java.lang.String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }


    /**
     * Gets the etiquetas value for this POrdenPedidoItem.
     * 
     * @return etiquetas
     */
    public ar.com.unisolutions.PEtiqueta[] getEtiquetas() {
        return etiquetas;
    }


    /**
     * Sets the etiquetas value for this POrdenPedidoItem.
     * 
     * @param etiquetas
     */
    public void setEtiquetas(ar.com.unisolutions.PEtiqueta[] etiquetas) {
        this.etiquetas = etiquetas;
    }


    /**
     * Gets the campoDinamico value for this POrdenPedidoItem.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this POrdenPedidoItem.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the domicilioDestino value for this POrdenPedidoItem.
     * 
     * @return domicilioDestino
     */
    public ar.com.unisolutions.PCliente getDomicilioDestino() {
        return domicilioDestino;
    }


    /**
     * Sets the domicilioDestino value for this POrdenPedidoItem.
     * 
     * @param domicilioDestino
     */
    public void setDomicilioDestino(ar.com.unisolutions.PCliente domicilioDestino) {
        this.domicilioDestino = domicilioDestino;
    }


    /**
     * Gets the idPedidoItem value for this POrdenPedidoItem.
     * 
     * @return idPedidoItem
     */
    public java.lang.Long getIdPedidoItem() {
        return idPedidoItem;
    }


    /**
     * Sets the idPedidoItem value for this POrdenPedidoItem.
     * 
     * @param idPedidoItem
     */
    public void setIdPedidoItem(java.lang.Long idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }


    /**
     * Gets the unidades value for this POrdenPedidoItem.
     * 
     * @return unidades
     */
    public java.lang.Double getUnidades() {
        return unidades;
    }


    /**
     * Sets the unidades value for this POrdenPedidoItem.
     * 
     * @param unidades
     */
    public void setUnidades(java.lang.Double unidades) {
        this.unidades = unidades;
    }


    /**
     * Gets the referenciaCantidad value for this POrdenPedidoItem.
     * 
     * @return referenciaCantidad
     */
    public java.lang.Integer getReferenciaCantidad() {
        return referenciaCantidad;
    }


    /**
     * Sets the referenciaCantidad value for this POrdenPedidoItem.
     * 
     * @param referenciaCantidad
     */
    public void setReferenciaCantidad(java.lang.Integer referenciaCantidad) {
        this.referenciaCantidad = referenciaCantidad;
    }


    /**
     * Gets the referenciaValor value for this POrdenPedidoItem.
     * 
     * @return referenciaValor
     */
    public java.lang.Double getReferenciaValor() {
        return referenciaValor;
    }


    /**
     * Sets the referenciaValor value for this POrdenPedidoItem.
     * 
     * @param referenciaValor
     */
    public void setReferenciaValor(java.lang.Double referenciaValor) {
        this.referenciaValor = referenciaValor;
    }


    /**
     * Gets the vigenciaDesde value for this POrdenPedidoItem.
     * 
     * @return vigenciaDesde
     */
    public java.util.Calendar getVigenciaDesde() {
        return vigenciaDesde;
    }


    /**
     * Sets the vigenciaDesde value for this POrdenPedidoItem.
     * 
     * @param vigenciaDesde
     */
    public void setVigenciaDesde(java.util.Calendar vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }


    /**
     * Gets the vigenciaHasta value for this POrdenPedidoItem.
     * 
     * @return vigenciaHasta
     */
    public java.util.Calendar getVigenciaHasta() {
        return vigenciaHasta;
    }


    /**
     * Sets the vigenciaHasta value for this POrdenPedidoItem.
     * 
     * @param vigenciaHasta
     */
    public void setVigenciaHasta(java.util.Calendar vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }


    /**
     * Gets the procesarVolumetria value for this POrdenPedidoItem.
     * 
     * @return procesarVolumetria
     */
    public java.lang.Integer getProcesarVolumetria() {
        return procesarVolumetria;
    }


    /**
     * Sets the procesarVolumetria value for this POrdenPedidoItem.
     * 
     * @param procesarVolumetria
     */
    public void setProcesarVolumetria(java.lang.Integer procesarVolumetria) {
        this.procesarVolumetria = procesarVolumetria;
    }


    /**
     * Gets the apilable value for this POrdenPedidoItem.
     * 
     * @return apilable
     */
    public java.lang.Integer getApilable() {
        return apilable;
    }


    /**
     * Sets the apilable value for this POrdenPedidoItem.
     * 
     * @param apilable
     */
    public void setApilable(java.lang.Integer apilable) {
        this.apilable = apilable;
    }


    /**
     * Gets the alto value for this POrdenPedidoItem.
     * 
     * @return alto
     */
    public java.lang.Double getAlto() {
        return alto;
    }


    /**
     * Sets the alto value for this POrdenPedidoItem.
     * 
     * @param alto
     */
    public void setAlto(java.lang.Double alto) {
        this.alto = alto;
    }


    /**
     * Gets the ancho value for this POrdenPedidoItem.
     * 
     * @return ancho
     */
    public java.lang.Double getAncho() {
        return ancho;
    }


    /**
     * Sets the ancho value for this POrdenPedidoItem.
     * 
     * @param ancho
     */
    public void setAncho(java.lang.Double ancho) {
        this.ancho = ancho;
    }


    /**
     * Gets the profundidad value for this POrdenPedidoItem.
     * 
     * @return profundidad
     */
    public java.lang.Double getProfundidad() {
        return profundidad;
    }


    /**
     * Sets the profundidad value for this POrdenPedidoItem.
     * 
     * @param profundidad
     */
    public void setProfundidad(java.lang.Double profundidad) {
        this.profundidad = profundidad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POrdenPedidoItem)) return false;
        POrdenPedidoItem other = (POrdenPedidoItem) obj;
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
            ((this.importeCosto==null && other.getImporteCosto()==null) || 
             (this.importeCosto!=null &&
              this.importeCosto.equals(other.getImporteCosto()))) &&
            ((this.fechaEntrega==null && other.getFechaEntrega()==null) || 
             (this.fechaEntrega!=null &&
              this.fechaEntrega.equals(other.getFechaEntrega()))) &&
            ((this.varchar1==null && other.getVarchar1()==null) || 
             (this.varchar1!=null &&
              this.varchar1.equals(other.getVarchar1()))) &&
            ((this.varchar2==null && other.getVarchar2()==null) || 
             (this.varchar2!=null &&
              this.varchar2.equals(other.getVarchar2()))) &&
            ((this.int1==null && other.getInt1()==null) || 
             (this.int1!=null &&
              this.int1.equals(other.getInt1()))) &&
            ((this.int2==null && other.getInt2()==null) || 
             (this.int2!=null &&
              this.int2.equals(other.getInt2()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.LPN==null && other.getLPN()==null) || 
             (this.LPN!=null &&
              this.LPN.equals(other.getLPN()))) &&
            ((this.estadoPedidoItem==null && other.getEstadoPedidoItem()==null) || 
             (this.estadoPedidoItem!=null &&
              this.estadoPedidoItem.equals(other.getEstadoPedidoItem()))) &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo()))) &&
            ((this.unidadMedida==null && other.getUnidadMedida()==null) || 
             (this.unidadMedida!=null &&
              this.unidadMedida.equals(other.getUnidadMedida()))) &&
            ((this.etiquetas==null && other.getEtiquetas()==null) || 
             (this.etiquetas!=null &&
              java.util.Arrays.equals(this.etiquetas, other.getEtiquetas()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.domicilioDestino==null && other.getDomicilioDestino()==null) || 
             (this.domicilioDestino!=null &&
              this.domicilioDestino.equals(other.getDomicilioDestino()))) &&
            ((this.idPedidoItem==null && other.getIdPedidoItem()==null) || 
             (this.idPedidoItem!=null &&
              this.idPedidoItem.equals(other.getIdPedidoItem()))) &&
            ((this.unidades==null && other.getUnidades()==null) || 
             (this.unidades!=null &&
              this.unidades.equals(other.getUnidades()))) &&
            ((this.referenciaCantidad==null && other.getReferenciaCantidad()==null) || 
             (this.referenciaCantidad!=null &&
              this.referenciaCantidad.equals(other.getReferenciaCantidad()))) &&
            ((this.referenciaValor==null && other.getReferenciaValor()==null) || 
             (this.referenciaValor!=null &&
              this.referenciaValor.equals(other.getReferenciaValor()))) &&
            ((this.vigenciaDesde==null && other.getVigenciaDesde()==null) || 
             (this.vigenciaDesde!=null &&
              this.vigenciaDesde.equals(other.getVigenciaDesde()))) &&
            ((this.vigenciaHasta==null && other.getVigenciaHasta()==null) || 
             (this.vigenciaHasta!=null &&
              this.vigenciaHasta.equals(other.getVigenciaHasta()))) &&
            ((this.procesarVolumetria==null && other.getProcesarVolumetria()==null) || 
             (this.procesarVolumetria!=null &&
              this.procesarVolumetria.equals(other.getProcesarVolumetria()))) &&
            ((this.apilable==null && other.getApilable()==null) || 
             (this.apilable!=null &&
              this.apilable.equals(other.getApilable()))) &&
            ((this.alto==null && other.getAlto()==null) || 
             (this.alto!=null &&
              this.alto.equals(other.getAlto()))) &&
            ((this.ancho==null && other.getAncho()==null) || 
             (this.ancho!=null &&
              this.ancho.equals(other.getAncho()))) &&
            ((this.profundidad==null && other.getProfundidad()==null) || 
             (this.profundidad!=null &&
              this.profundidad.equals(other.getProfundidad())));
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
        if (getProducto() != null) {
            _hashCode += getProducto().hashCode();
        }
        _hashCode += getCantidad();
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
        if (getImporteCosto() != null) {
            _hashCode += getImporteCosto().hashCode();
        }
        if (getFechaEntrega() != null) {
            _hashCode += getFechaEntrega().hashCode();
        }
        if (getVarchar1() != null) {
            _hashCode += getVarchar1().hashCode();
        }
        if (getVarchar2() != null) {
            _hashCode += getVarchar2().hashCode();
        }
        if (getInt1() != null) {
            _hashCode += getInt1().hashCode();
        }
        if (getInt2() != null) {
            _hashCode += getInt2().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getLPN() != null) {
            _hashCode += getLPN().hashCode();
        }
        if (getEstadoPedidoItem() != null) {
            _hashCode += getEstadoPedidoItem().hashCode();
        }
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        if (getUnidadMedida() != null) {
            _hashCode += getUnidadMedida().hashCode();
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
        if (getDomicilioDestino() != null) {
            _hashCode += getDomicilioDestino().hashCode();
        }
        if (getIdPedidoItem() != null) {
            _hashCode += getIdPedidoItem().hashCode();
        }
        if (getUnidades() != null) {
            _hashCode += getUnidades().hashCode();
        }
        if (getReferenciaCantidad() != null) {
            _hashCode += getReferenciaCantidad().hashCode();
        }
        if (getReferenciaValor() != null) {
            _hashCode += getReferenciaValor().hashCode();
        }
        if (getVigenciaDesde() != null) {
            _hashCode += getVigenciaDesde().hashCode();
        }
        if (getVigenciaHasta() != null) {
            _hashCode += getVigenciaHasta().hashCode();
        }
        if (getProcesarVolumetria() != null) {
            _hashCode += getProcesarVolumetria().hashCode();
        }
        if (getApilable() != null) {
            _hashCode += getApilable().hashCode();
        }
        if (getAlto() != null) {
            _hashCode += getAlto().hashCode();
        }
        if (getAncho() != null) {
            _hashCode += getAncho().hashCode();
        }
        if (getProfundidad() != null) {
            _hashCode += getProfundidad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POrdenPedidoItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoItem"));
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
        elemField.setFieldName("producto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Producto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pProducto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("importeCosto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteCosto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEntrega");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaEntrega"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
        elemField.setFieldName("int1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Int1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("int2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Int2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
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
        elemField.setFieldName("estadoPedidoItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoPedidoItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("unidadMedida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UnidadMedida"));
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
        elemField.setFieldName("domicilioDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DomicilioDestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPedidoItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdPedidoItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Unidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("vigenciaDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VigenciaDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vigenciaHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VigenciaHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procesarVolumetria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ProcesarVolumetria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apilable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apilable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Alto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ancho");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ancho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profundidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Profundidad"));
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
