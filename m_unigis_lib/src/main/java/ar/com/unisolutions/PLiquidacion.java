/**
 * PLiquidacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PLiquidacion  implements java.io.Serializable {
    private int idLiquidacion;

    private java.lang.String referenciaExterna;

    private java.lang.String referenciaAdicional;

    private java.lang.String estado;

    private java.lang.String tipo;

    private java.lang.String observaciones;

    private double importeTotal;

    private double importeNeto;

    private double importeBasico;

    private double importeComplemento;

    private double importeImpuestos;

    private double importeAjustes;

    private java.lang.String usuarioCreacion;

    private java.util.Calendar fecha;

    private java.util.Calendar fechaDesde;

    private java.util.Calendar fechaHasta;

    private java.util.Calendar fechaUltimoEstado;

    private ar.com.unisolutions.PEmpresa empresa;

    private ar.com.unisolutions.PSucursal sucursal;

    private ar.com.unisolutions.POperacion operacion;

    private ar.com.unisolutions.PTransporte transporte;

    private ar.com.unisolutions.PConductor conductor;

    private ar.com.unisolutions.PVehiculo vehiculo;

    private ar.com.unisolutions.PCliente cliente;

    private ar.com.unisolutions.PEmpresaCustodia empresaCustodia;

    private ar.com.unisolutions.PPeriodoLiquidacion periodo;

    private ar.com.unisolutions.PAjuste[] ajustes;

    private ar.com.unisolutions.PEstadia[] estadias;

    private ar.com.unisolutions.PServicio[] servicios;

    private ar.com.unisolutions.PGuiaLiquidacion[] guias;

    public PLiquidacion() {
    }

    public PLiquidacion(
           int idLiquidacion,
           java.lang.String referenciaExterna,
           java.lang.String referenciaAdicional,
           java.lang.String estado,
           java.lang.String tipo,
           java.lang.String observaciones,
           double importeTotal,
           double importeNeto,
           double importeBasico,
           double importeComplemento,
           double importeImpuestos,
           double importeAjustes,
           java.lang.String usuarioCreacion,
           java.util.Calendar fecha,
           java.util.Calendar fechaDesde,
           java.util.Calendar fechaHasta,
           java.util.Calendar fechaUltimoEstado,
           ar.com.unisolutions.PEmpresa empresa,
           ar.com.unisolutions.PSucursal sucursal,
           ar.com.unisolutions.POperacion operacion,
           ar.com.unisolutions.PTransporte transporte,
           ar.com.unisolutions.PConductor conductor,
           ar.com.unisolutions.PVehiculo vehiculo,
           ar.com.unisolutions.PCliente cliente,
           ar.com.unisolutions.PEmpresaCustodia empresaCustodia,
           ar.com.unisolutions.PPeriodoLiquidacion periodo,
           ar.com.unisolutions.PAjuste[] ajustes,
           ar.com.unisolutions.PEstadia[] estadias,
           ar.com.unisolutions.PServicio[] servicios,
           ar.com.unisolutions.PGuiaLiquidacion[] guias) {
           this.idLiquidacion = idLiquidacion;
           this.referenciaExterna = referenciaExterna;
           this.referenciaAdicional = referenciaAdicional;
           this.estado = estado;
           this.tipo = tipo;
           this.observaciones = observaciones;
           this.importeTotal = importeTotal;
           this.importeNeto = importeNeto;
           this.importeBasico = importeBasico;
           this.importeComplemento = importeComplemento;
           this.importeImpuestos = importeImpuestos;
           this.importeAjustes = importeAjustes;
           this.usuarioCreacion = usuarioCreacion;
           this.fecha = fecha;
           this.fechaDesde = fechaDesde;
           this.fechaHasta = fechaHasta;
           this.fechaUltimoEstado = fechaUltimoEstado;
           this.empresa = empresa;
           this.sucursal = sucursal;
           this.operacion = operacion;
           this.transporte = transporte;
           this.conductor = conductor;
           this.vehiculo = vehiculo;
           this.cliente = cliente;
           this.empresaCustodia = empresaCustodia;
           this.periodo = periodo;
           this.ajustes = ajustes;
           this.estadias = estadias;
           this.servicios = servicios;
           this.guias = guias;
    }


    /**
     * Gets the idLiquidacion value for this PLiquidacion.
     * 
     * @return idLiquidacion
     */
    public int getIdLiquidacion() {
        return idLiquidacion;
    }


    /**
     * Sets the idLiquidacion value for this PLiquidacion.
     * 
     * @param idLiquidacion
     */
    public void setIdLiquidacion(int idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }


    /**
     * Gets the referenciaExterna value for this PLiquidacion.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this PLiquidacion.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the referenciaAdicional value for this PLiquidacion.
     * 
     * @return referenciaAdicional
     */
    public java.lang.String getReferenciaAdicional() {
        return referenciaAdicional;
    }


    /**
     * Sets the referenciaAdicional value for this PLiquidacion.
     * 
     * @param referenciaAdicional
     */
    public void setReferenciaAdicional(java.lang.String referenciaAdicional) {
        this.referenciaAdicional = referenciaAdicional;
    }


    /**
     * Gets the estado value for this PLiquidacion.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PLiquidacion.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the tipo value for this PLiquidacion.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this PLiquidacion.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the observaciones value for this PLiquidacion.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PLiquidacion.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the importeTotal value for this PLiquidacion.
     * 
     * @return importeTotal
     */
    public double getImporteTotal() {
        return importeTotal;
    }


    /**
     * Sets the importeTotal value for this PLiquidacion.
     * 
     * @param importeTotal
     */
    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }


    /**
     * Gets the importeNeto value for this PLiquidacion.
     * 
     * @return importeNeto
     */
    public double getImporteNeto() {
        return importeNeto;
    }


    /**
     * Sets the importeNeto value for this PLiquidacion.
     * 
     * @param importeNeto
     */
    public void setImporteNeto(double importeNeto) {
        this.importeNeto = importeNeto;
    }


    /**
     * Gets the importeBasico value for this PLiquidacion.
     * 
     * @return importeBasico
     */
    public double getImporteBasico() {
        return importeBasico;
    }


    /**
     * Sets the importeBasico value for this PLiquidacion.
     * 
     * @param importeBasico
     */
    public void setImporteBasico(double importeBasico) {
        this.importeBasico = importeBasico;
    }


    /**
     * Gets the importeComplemento value for this PLiquidacion.
     * 
     * @return importeComplemento
     */
    public double getImporteComplemento() {
        return importeComplemento;
    }


    /**
     * Sets the importeComplemento value for this PLiquidacion.
     * 
     * @param importeComplemento
     */
    public void setImporteComplemento(double importeComplemento) {
        this.importeComplemento = importeComplemento;
    }


    /**
     * Gets the importeImpuestos value for this PLiquidacion.
     * 
     * @return importeImpuestos
     */
    public double getImporteImpuestos() {
        return importeImpuestos;
    }


    /**
     * Sets the importeImpuestos value for this PLiquidacion.
     * 
     * @param importeImpuestos
     */
    public void setImporteImpuestos(double importeImpuestos) {
        this.importeImpuestos = importeImpuestos;
    }


    /**
     * Gets the importeAjustes value for this PLiquidacion.
     * 
     * @return importeAjustes
     */
    public double getImporteAjustes() {
        return importeAjustes;
    }


    /**
     * Sets the importeAjustes value for this PLiquidacion.
     * 
     * @param importeAjustes
     */
    public void setImporteAjustes(double importeAjustes) {
        this.importeAjustes = importeAjustes;
    }


    /**
     * Gets the usuarioCreacion value for this PLiquidacion.
     * 
     * @return usuarioCreacion
     */
    public java.lang.String getUsuarioCreacion() {
        return usuarioCreacion;
    }


    /**
     * Sets the usuarioCreacion value for this PLiquidacion.
     * 
     * @param usuarioCreacion
     */
    public void setUsuarioCreacion(java.lang.String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }


    /**
     * Gets the fecha value for this PLiquidacion.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this PLiquidacion.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the fechaDesde value for this PLiquidacion.
     * 
     * @return fechaDesde
     */
    public java.util.Calendar getFechaDesde() {
        return fechaDesde;
    }


    /**
     * Sets the fechaDesde value for this PLiquidacion.
     * 
     * @param fechaDesde
     */
    public void setFechaDesde(java.util.Calendar fechaDesde) {
        this.fechaDesde = fechaDesde;
    }


    /**
     * Gets the fechaHasta value for this PLiquidacion.
     * 
     * @return fechaHasta
     */
    public java.util.Calendar getFechaHasta() {
        return fechaHasta;
    }


    /**
     * Sets the fechaHasta value for this PLiquidacion.
     * 
     * @param fechaHasta
     */
    public void setFechaHasta(java.util.Calendar fechaHasta) {
        this.fechaHasta = fechaHasta;
    }


    /**
     * Gets the fechaUltimoEstado value for this PLiquidacion.
     * 
     * @return fechaUltimoEstado
     */
    public java.util.Calendar getFechaUltimoEstado() {
        return fechaUltimoEstado;
    }


    /**
     * Sets the fechaUltimoEstado value for this PLiquidacion.
     * 
     * @param fechaUltimoEstado
     */
    public void setFechaUltimoEstado(java.util.Calendar fechaUltimoEstado) {
        this.fechaUltimoEstado = fechaUltimoEstado;
    }


    /**
     * Gets the empresa value for this PLiquidacion.
     * 
     * @return empresa
     */
    public ar.com.unisolutions.PEmpresa getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this PLiquidacion.
     * 
     * @param empresa
     */
    public void setEmpresa(ar.com.unisolutions.PEmpresa empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the sucursal value for this PLiquidacion.
     * 
     * @return sucursal
     */
    public ar.com.unisolutions.PSucursal getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this PLiquidacion.
     * 
     * @param sucursal
     */
    public void setSucursal(ar.com.unisolutions.PSucursal sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the operacion value for this PLiquidacion.
     * 
     * @return operacion
     */
    public ar.com.unisolutions.POperacion getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this PLiquidacion.
     * 
     * @param operacion
     */
    public void setOperacion(ar.com.unisolutions.POperacion operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the transporte value for this PLiquidacion.
     * 
     * @return transporte
     */
    public ar.com.unisolutions.PTransporte getTransporte() {
        return transporte;
    }


    /**
     * Sets the transporte value for this PLiquidacion.
     * 
     * @param transporte
     */
    public void setTransporte(ar.com.unisolutions.PTransporte transporte) {
        this.transporte = transporte;
    }


    /**
     * Gets the conductor value for this PLiquidacion.
     * 
     * @return conductor
     */
    public ar.com.unisolutions.PConductor getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this PLiquidacion.
     * 
     * @param conductor
     */
    public void setConductor(ar.com.unisolutions.PConductor conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the vehiculo value for this PLiquidacion.
     * 
     * @return vehiculo
     */
    public ar.com.unisolutions.PVehiculo getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this PLiquidacion.
     * 
     * @param vehiculo
     */
    public void setVehiculo(ar.com.unisolutions.PVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the cliente value for this PLiquidacion.
     * 
     * @return cliente
     */
    public ar.com.unisolutions.PCliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this PLiquidacion.
     * 
     * @param cliente
     */
    public void setCliente(ar.com.unisolutions.PCliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the empresaCustodia value for this PLiquidacion.
     * 
     * @return empresaCustodia
     */
    public ar.com.unisolutions.PEmpresaCustodia getEmpresaCustodia() {
        return empresaCustodia;
    }


    /**
     * Sets the empresaCustodia value for this PLiquidacion.
     * 
     * @param empresaCustodia
     */
    public void setEmpresaCustodia(ar.com.unisolutions.PEmpresaCustodia empresaCustodia) {
        this.empresaCustodia = empresaCustodia;
    }


    /**
     * Gets the periodo value for this PLiquidacion.
     * 
     * @return periodo
     */
    public ar.com.unisolutions.PPeriodoLiquidacion getPeriodo() {
        return periodo;
    }


    /**
     * Sets the periodo value for this PLiquidacion.
     * 
     * @param periodo
     */
    public void setPeriodo(ar.com.unisolutions.PPeriodoLiquidacion periodo) {
        this.periodo = periodo;
    }


    /**
     * Gets the ajustes value for this PLiquidacion.
     * 
     * @return ajustes
     */
    public ar.com.unisolutions.PAjuste[] getAjustes() {
        return ajustes;
    }


    /**
     * Sets the ajustes value for this PLiquidacion.
     * 
     * @param ajustes
     */
    public void setAjustes(ar.com.unisolutions.PAjuste[] ajustes) {
        this.ajustes = ajustes;
    }


    /**
     * Gets the estadias value for this PLiquidacion.
     * 
     * @return estadias
     */
    public ar.com.unisolutions.PEstadia[] getEstadias() {
        return estadias;
    }


    /**
     * Sets the estadias value for this PLiquidacion.
     * 
     * @param estadias
     */
    public void setEstadias(ar.com.unisolutions.PEstadia[] estadias) {
        this.estadias = estadias;
    }


    /**
     * Gets the servicios value for this PLiquidacion.
     * 
     * @return servicios
     */
    public ar.com.unisolutions.PServicio[] getServicios() {
        return servicios;
    }


    /**
     * Sets the servicios value for this PLiquidacion.
     * 
     * @param servicios
     */
    public void setServicios(ar.com.unisolutions.PServicio[] servicios) {
        this.servicios = servicios;
    }


    /**
     * Gets the guias value for this PLiquidacion.
     * 
     * @return guias
     */
    public ar.com.unisolutions.PGuiaLiquidacion[] getGuias() {
        return guias;
    }


    /**
     * Sets the guias value for this PLiquidacion.
     * 
     * @param guias
     */
    public void setGuias(ar.com.unisolutions.PGuiaLiquidacion[] guias) {
        this.guias = guias;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PLiquidacion)) return false;
        PLiquidacion other = (PLiquidacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idLiquidacion == other.getIdLiquidacion() &&
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.referenciaAdicional==null && other.getReferenciaAdicional()==null) || 
             (this.referenciaAdicional!=null &&
              this.referenciaAdicional.equals(other.getReferenciaAdicional()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            this.importeTotal == other.getImporteTotal() &&
            this.importeNeto == other.getImporteNeto() &&
            this.importeBasico == other.getImporteBasico() &&
            this.importeComplemento == other.getImporteComplemento() &&
            this.importeImpuestos == other.getImporteImpuestos() &&
            this.importeAjustes == other.getImporteAjustes() &&
            ((this.usuarioCreacion==null && other.getUsuarioCreacion()==null) || 
             (this.usuarioCreacion!=null &&
              this.usuarioCreacion.equals(other.getUsuarioCreacion()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.fechaDesde==null && other.getFechaDesde()==null) || 
             (this.fechaDesde!=null &&
              this.fechaDesde.equals(other.getFechaDesde()))) &&
            ((this.fechaHasta==null && other.getFechaHasta()==null) || 
             (this.fechaHasta!=null &&
              this.fechaHasta.equals(other.getFechaHasta()))) &&
            ((this.fechaUltimoEstado==null && other.getFechaUltimoEstado()==null) || 
             (this.fechaUltimoEstado!=null &&
              this.fechaUltimoEstado.equals(other.getFechaUltimoEstado()))) &&
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa()))) &&
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
            ((this.transporte==null && other.getTransporte()==null) || 
             (this.transporte!=null &&
              this.transporte.equals(other.getTransporte()))) &&
            ((this.conductor==null && other.getConductor()==null) || 
             (this.conductor!=null &&
              this.conductor.equals(other.getConductor()))) &&
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.empresaCustodia==null && other.getEmpresaCustodia()==null) || 
             (this.empresaCustodia!=null &&
              this.empresaCustodia.equals(other.getEmpresaCustodia()))) &&
            ((this.periodo==null && other.getPeriodo()==null) || 
             (this.periodo!=null &&
              this.periodo.equals(other.getPeriodo()))) &&
            ((this.ajustes==null && other.getAjustes()==null) || 
             (this.ajustes!=null &&
              java.util.Arrays.equals(this.ajustes, other.getAjustes()))) &&
            ((this.estadias==null && other.getEstadias()==null) || 
             (this.estadias!=null &&
              java.util.Arrays.equals(this.estadias, other.getEstadias()))) &&
            ((this.servicios==null && other.getServicios()==null) || 
             (this.servicios!=null &&
              java.util.Arrays.equals(this.servicios, other.getServicios()))) &&
            ((this.guias==null && other.getGuias()==null) || 
             (this.guias!=null &&
              java.util.Arrays.equals(this.guias, other.getGuias())));
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
        _hashCode += getIdLiquidacion();
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getReferenciaAdicional() != null) {
            _hashCode += getReferenciaAdicional().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        _hashCode += new Double(getImporteTotal()).hashCode();
        _hashCode += new Double(getImporteNeto()).hashCode();
        _hashCode += new Double(getImporteBasico()).hashCode();
        _hashCode += new Double(getImporteComplemento()).hashCode();
        _hashCode += new Double(getImporteImpuestos()).hashCode();
        _hashCode += new Double(getImporteAjustes()).hashCode();
        if (getUsuarioCreacion() != null) {
            _hashCode += getUsuarioCreacion().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFechaDesde() != null) {
            _hashCode += getFechaDesde().hashCode();
        }
        if (getFechaHasta() != null) {
            _hashCode += getFechaHasta().hashCode();
        }
        if (getFechaUltimoEstado() != null) {
            _hashCode += getFechaUltimoEstado().hashCode();
        }
        if (getEmpresa() != null) {
            _hashCode += getEmpresa().hashCode();
        }
        if (getSucursal() != null) {
            _hashCode += getSucursal().hashCode();
        }
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        if (getTransporte() != null) {
            _hashCode += getTransporte().hashCode();
        }
        if (getConductor() != null) {
            _hashCode += getConductor().hashCode();
        }
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getEmpresaCustodia() != null) {
            _hashCode += getEmpresaCustodia().hashCode();
        }
        if (getPeriodo() != null) {
            _hashCode += getPeriodo().hashCode();
        }
        if (getAjustes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAjustes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAjustes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEstadias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEstadias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEstadias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getServicios() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServicios());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServicios(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGuias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGuias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGuias(), i);
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
        new org.apache.axis.description.TypeDesc(PLiquidacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pLiquidacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idLiquidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdLiquidacion"));
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
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"));
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
        elemField.setFieldName("importeNeto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteNeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeBasico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteBasico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeComplemento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteComplemento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeImpuestos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteImpuestos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeAjustes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteAjustes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuarioCreacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UsuarioCreacion"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaUltimoEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaUltimoEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Empresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pSucursal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOperacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conductor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Vehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresaCustodia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EmpresaCustodia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEmpresaCustodia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Periodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPeriodoLiquidacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ajustes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ajustes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pAjuste"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pAjuste"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estadias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadia"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("servicios");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Servicios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicio"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Guias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
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
