/**
 * PViaje.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PViaje  implements java.io.Serializable {
    private int idViaje;

    private java.lang.String referencia;

    private java.lang.String estado;

    private java.lang.String tipo;

    private java.lang.String categoria;

    private double kmsPlanificados;

    private java.lang.Integer idDibujoZona;

    private java.lang.String descripcionZona;

    private java.util.Calendar fechaInicio;

    private java.util.Calendar fechaFin;

    private ar.com.unisolutions.POperacion operacion;

    private ar.com.unisolutions.PEmpresa empresa;

    private ar.com.unisolutions.PSucursal sucursal;

    private ar.com.unisolutions.PVehiculo vehiculo;

    private ar.com.unisolutions.PConductor conductor;

    private ar.com.unisolutions.PDeposito depositoSalida;

    private ar.com.unisolutions.PDeposito depositoLlegada;

    private ar.com.unisolutions.PTransporte transporte;

    private java.lang.String descripcion;

    private java.util.Calendar fechaCreacion;

    private java.lang.String tipoViaje;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String varchar3;

    private java.lang.String vehiculoSecundario;

    private java.lang.String vehiculoTerciario;

    private java.lang.String recorrido;

    private java.lang.String observaciones;

    private ar.com.unisolutions.PRecursos[] recursos;

    private java.math.BigDecimal preImporte;

    private java.math.BigDecimal preCosto;

    private java.math.BigDecimal importe;

    private java.lang.String varchar4;

    private java.lang.String varchar5;

    private java.lang.String varchar6;

    private java.lang.Float float1;

    private java.lang.Float float2;

    private ar.com.unisolutions.POrdenEntrega[] entregas;

    private ar.com.unisolutions.PVehiculo[] vehiculosAdicionales;

    private ar.com.unisolutions.PParada[] paradas;

    private java.lang.Integer idRuta;

    private java.util.Calendar fechaInicioCarga;

    private java.util.Calendar fechaFinCarga;

    private java.util.Calendar fechaHoraAtraque;

    private java.util.Calendar fechaHoraArribo;

    public PViaje() {
    }

    public PViaje(
           int idViaje,
           java.lang.String referencia,
           java.lang.String estado,
           java.lang.String tipo,
           java.lang.String categoria,
           double kmsPlanificados,
           java.lang.Integer idDibujoZona,
           java.lang.String descripcionZona,
           java.util.Calendar fechaInicio,
           java.util.Calendar fechaFin,
           ar.com.unisolutions.POperacion operacion,
           ar.com.unisolutions.PEmpresa empresa,
           ar.com.unisolutions.PSucursal sucursal,
           ar.com.unisolutions.PVehiculo vehiculo,
           ar.com.unisolutions.PConductor conductor,
           ar.com.unisolutions.PDeposito depositoSalida,
           ar.com.unisolutions.PDeposito depositoLlegada,
           ar.com.unisolutions.PTransporte transporte,
           java.lang.String descripcion,
           java.util.Calendar fechaCreacion,
           java.lang.String tipoViaje,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           java.lang.String vehiculoSecundario,
           java.lang.String vehiculoTerciario,
           java.lang.String recorrido,
           java.lang.String observaciones,
           ar.com.unisolutions.PRecursos[] recursos,
           java.math.BigDecimal preImporte,
           java.math.BigDecimal preCosto,
           java.math.BigDecimal importe,
           java.lang.String varchar4,
           java.lang.String varchar5,
           java.lang.String varchar6,
           java.lang.Float float1,
           java.lang.Float float2,
           ar.com.unisolutions.POrdenEntrega[] entregas,
           ar.com.unisolutions.PVehiculo[] vehiculosAdicionales,
           ar.com.unisolutions.PParada[] paradas,
           java.lang.Integer idRuta,
           java.util.Calendar fechaInicioCarga,
           java.util.Calendar fechaFinCarga,
           java.util.Calendar fechaHoraAtraque,
           java.util.Calendar fechaHoraArribo) {
           this.idViaje = idViaje;
           this.referencia = referencia;
           this.estado = estado;
           this.tipo = tipo;
           this.categoria = categoria;
           this.kmsPlanificados = kmsPlanificados;
           this.idDibujoZona = idDibujoZona;
           this.descripcionZona = descripcionZona;
           this.fechaInicio = fechaInicio;
           this.fechaFin = fechaFin;
           this.operacion = operacion;
           this.empresa = empresa;
           this.sucursal = sucursal;
           this.vehiculo = vehiculo;
           this.conductor = conductor;
           this.depositoSalida = depositoSalida;
           this.depositoLlegada = depositoLlegada;
           this.transporte = transporte;
           this.descripcion = descripcion;
           this.fechaCreacion = fechaCreacion;
           this.tipoViaje = tipoViaje;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.varchar3 = varchar3;
           this.vehiculoSecundario = vehiculoSecundario;
           this.vehiculoTerciario = vehiculoTerciario;
           this.recorrido = recorrido;
           this.observaciones = observaciones;
           this.recursos = recursos;
           this.preImporte = preImporte;
           this.preCosto = preCosto;
           this.importe = importe;
           this.varchar4 = varchar4;
           this.varchar5 = varchar5;
           this.varchar6 = varchar6;
           this.float1 = float1;
           this.float2 = float2;
           this.entregas = entregas;
           this.vehiculosAdicionales = vehiculosAdicionales;
           this.paradas = paradas;
           this.idRuta = idRuta;
           this.fechaInicioCarga = fechaInicioCarga;
           this.fechaFinCarga = fechaFinCarga;
           this.fechaHoraAtraque = fechaHoraAtraque;
           this.fechaHoraArribo = fechaHoraArribo;
    }


    /**
     * Gets the idViaje value for this PViaje.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PViaje.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the referencia value for this PViaje.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this PViaje.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the estado value for this PViaje.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PViaje.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the tipo value for this PViaje.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this PViaje.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the categoria value for this PViaje.
     * 
     * @return categoria
     */
    public java.lang.String getCategoria() {
        return categoria;
    }


    /**
     * Sets the categoria value for this PViaje.
     * 
     * @param categoria
     */
    public void setCategoria(java.lang.String categoria) {
        this.categoria = categoria;
    }


    /**
     * Gets the kmsPlanificados value for this PViaje.
     * 
     * @return kmsPlanificados
     */
    public double getKmsPlanificados() {
        return kmsPlanificados;
    }


    /**
     * Sets the kmsPlanificados value for this PViaje.
     * 
     * @param kmsPlanificados
     */
    public void setKmsPlanificados(double kmsPlanificados) {
        this.kmsPlanificados = kmsPlanificados;
    }


    /**
     * Gets the idDibujoZona value for this PViaje.
     * 
     * @return idDibujoZona
     */
    public java.lang.Integer getIdDibujoZona() {
        return idDibujoZona;
    }


    /**
     * Sets the idDibujoZona value for this PViaje.
     * 
     * @param idDibujoZona
     */
    public void setIdDibujoZona(java.lang.Integer idDibujoZona) {
        this.idDibujoZona = idDibujoZona;
    }


    /**
     * Gets the descripcionZona value for this PViaje.
     * 
     * @return descripcionZona
     */
    public java.lang.String getDescripcionZona() {
        return descripcionZona;
    }


    /**
     * Sets the descripcionZona value for this PViaje.
     * 
     * @param descripcionZona
     */
    public void setDescripcionZona(java.lang.String descripcionZona) {
        this.descripcionZona = descripcionZona;
    }


    /**
     * Gets the fechaInicio value for this PViaje.
     * 
     * @return fechaInicio
     */
    public java.util.Calendar getFechaInicio() {
        return fechaInicio;
    }


    /**
     * Sets the fechaInicio value for this PViaje.
     * 
     * @param fechaInicio
     */
    public void setFechaInicio(java.util.Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    /**
     * Gets the fechaFin value for this PViaje.
     * 
     * @return fechaFin
     */
    public java.util.Calendar getFechaFin() {
        return fechaFin;
    }


    /**
     * Sets the fechaFin value for this PViaje.
     * 
     * @param fechaFin
     */
    public void setFechaFin(java.util.Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }


    /**
     * Gets the operacion value for this PViaje.
     * 
     * @return operacion
     */
    public ar.com.unisolutions.POperacion getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this PViaje.
     * 
     * @param operacion
     */
    public void setOperacion(ar.com.unisolutions.POperacion operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the empresa value for this PViaje.
     * 
     * @return empresa
     */
    public ar.com.unisolutions.PEmpresa getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this PViaje.
     * 
     * @param empresa
     */
    public void setEmpresa(ar.com.unisolutions.PEmpresa empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the sucursal value for this PViaje.
     * 
     * @return sucursal
     */
    public ar.com.unisolutions.PSucursal getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this PViaje.
     * 
     * @param sucursal
     */
    public void setSucursal(ar.com.unisolutions.PSucursal sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the vehiculo value for this PViaje.
     * 
     * @return vehiculo
     */
    public ar.com.unisolutions.PVehiculo getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this PViaje.
     * 
     * @param vehiculo
     */
    public void setVehiculo(ar.com.unisolutions.PVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the conductor value for this PViaje.
     * 
     * @return conductor
     */
    public ar.com.unisolutions.PConductor getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this PViaje.
     * 
     * @param conductor
     */
    public void setConductor(ar.com.unisolutions.PConductor conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the depositoSalida value for this PViaje.
     * 
     * @return depositoSalida
     */
    public ar.com.unisolutions.PDeposito getDepositoSalida() {
        return depositoSalida;
    }


    /**
     * Sets the depositoSalida value for this PViaje.
     * 
     * @param depositoSalida
     */
    public void setDepositoSalida(ar.com.unisolutions.PDeposito depositoSalida) {
        this.depositoSalida = depositoSalida;
    }


    /**
     * Gets the depositoLlegada value for this PViaje.
     * 
     * @return depositoLlegada
     */
    public ar.com.unisolutions.PDeposito getDepositoLlegada() {
        return depositoLlegada;
    }


    /**
     * Sets the depositoLlegada value for this PViaje.
     * 
     * @param depositoLlegada
     */
    public void setDepositoLlegada(ar.com.unisolutions.PDeposito depositoLlegada) {
        this.depositoLlegada = depositoLlegada;
    }


    /**
     * Gets the transporte value for this PViaje.
     * 
     * @return transporte
     */
    public ar.com.unisolutions.PTransporte getTransporte() {
        return transporte;
    }


    /**
     * Sets the transporte value for this PViaje.
     * 
     * @param transporte
     */
    public void setTransporte(ar.com.unisolutions.PTransporte transporte) {
        this.transporte = transporte;
    }


    /**
     * Gets the descripcion value for this PViaje.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PViaje.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the fechaCreacion value for this PViaje.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this PViaje.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the tipoViaje value for this PViaje.
     * 
     * @return tipoViaje
     */
    public java.lang.String getTipoViaje() {
        return tipoViaje;
    }


    /**
     * Sets the tipoViaje value for this PViaje.
     * 
     * @param tipoViaje
     */
    public void setTipoViaje(java.lang.String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }


    /**
     * Gets the varchar1 value for this PViaje.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this PViaje.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this PViaje.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this PViaje.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the varchar3 value for this PViaje.
     * 
     * @return varchar3
     */
    public java.lang.String getVarchar3() {
        return varchar3;
    }


    /**
     * Sets the varchar3 value for this PViaje.
     * 
     * @param varchar3
     */
    public void setVarchar3(java.lang.String varchar3) {
        this.varchar3 = varchar3;
    }


    /**
     * Gets the vehiculoSecundario value for this PViaje.
     * 
     * @return vehiculoSecundario
     */
    public java.lang.String getVehiculoSecundario() {
        return vehiculoSecundario;
    }


    /**
     * Sets the vehiculoSecundario value for this PViaje.
     * 
     * @param vehiculoSecundario
     */
    public void setVehiculoSecundario(java.lang.String vehiculoSecundario) {
        this.vehiculoSecundario = vehiculoSecundario;
    }


    /**
     * Gets the vehiculoTerciario value for this PViaje.
     * 
     * @return vehiculoTerciario
     */
    public java.lang.String getVehiculoTerciario() {
        return vehiculoTerciario;
    }


    /**
     * Sets the vehiculoTerciario value for this PViaje.
     * 
     * @param vehiculoTerciario
     */
    public void setVehiculoTerciario(java.lang.String vehiculoTerciario) {
        this.vehiculoTerciario = vehiculoTerciario;
    }


    /**
     * Gets the recorrido value for this PViaje.
     * 
     * @return recorrido
     */
    public java.lang.String getRecorrido() {
        return recorrido;
    }


    /**
     * Sets the recorrido value for this PViaje.
     * 
     * @param recorrido
     */
    public void setRecorrido(java.lang.String recorrido) {
        this.recorrido = recorrido;
    }


    /**
     * Gets the observaciones value for this PViaje.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PViaje.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the recursos value for this PViaje.
     * 
     * @return recursos
     */
    public ar.com.unisolutions.PRecursos[] getRecursos() {
        return recursos;
    }


    /**
     * Sets the recursos value for this PViaje.
     * 
     * @param recursos
     */
    public void setRecursos(ar.com.unisolutions.PRecursos[] recursos) {
        this.recursos = recursos;
    }


    /**
     * Gets the preImporte value for this PViaje.
     * 
     * @return preImporte
     */
    public java.math.BigDecimal getPreImporte() {
        return preImporte;
    }


    /**
     * Sets the preImporte value for this PViaje.
     * 
     * @param preImporte
     */
    public void setPreImporte(java.math.BigDecimal preImporte) {
        this.preImporte = preImporte;
    }


    /**
     * Gets the preCosto value for this PViaje.
     * 
     * @return preCosto
     */
    public java.math.BigDecimal getPreCosto() {
        return preCosto;
    }


    /**
     * Sets the preCosto value for this PViaje.
     * 
     * @param preCosto
     */
    public void setPreCosto(java.math.BigDecimal preCosto) {
        this.preCosto = preCosto;
    }


    /**
     * Gets the importe value for this PViaje.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this PViaje.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the varchar4 value for this PViaje.
     * 
     * @return varchar4
     */
    public java.lang.String getVarchar4() {
        return varchar4;
    }


    /**
     * Sets the varchar4 value for this PViaje.
     * 
     * @param varchar4
     */
    public void setVarchar4(java.lang.String varchar4) {
        this.varchar4 = varchar4;
    }


    /**
     * Gets the varchar5 value for this PViaje.
     * 
     * @return varchar5
     */
    public java.lang.String getVarchar5() {
        return varchar5;
    }


    /**
     * Sets the varchar5 value for this PViaje.
     * 
     * @param varchar5
     */
    public void setVarchar5(java.lang.String varchar5) {
        this.varchar5 = varchar5;
    }


    /**
     * Gets the varchar6 value for this PViaje.
     * 
     * @return varchar6
     */
    public java.lang.String getVarchar6() {
        return varchar6;
    }


    /**
     * Sets the varchar6 value for this PViaje.
     * 
     * @param varchar6
     */
    public void setVarchar6(java.lang.String varchar6) {
        this.varchar6 = varchar6;
    }


    /**
     * Gets the float1 value for this PViaje.
     * 
     * @return float1
     */
    public java.lang.Float getFloat1() {
        return float1;
    }


    /**
     * Sets the float1 value for this PViaje.
     * 
     * @param float1
     */
    public void setFloat1(java.lang.Float float1) {
        this.float1 = float1;
    }


    /**
     * Gets the float2 value for this PViaje.
     * 
     * @return float2
     */
    public java.lang.Float getFloat2() {
        return float2;
    }


    /**
     * Sets the float2 value for this PViaje.
     * 
     * @param float2
     */
    public void setFloat2(java.lang.Float float2) {
        this.float2 = float2;
    }


    /**
     * Gets the entregas value for this PViaje.
     * 
     * @return entregas
     */
    public ar.com.unisolutions.POrdenEntrega[] getEntregas() {
        return entregas;
    }


    /**
     * Sets the entregas value for this PViaje.
     * 
     * @param entregas
     */
    public void setEntregas(ar.com.unisolutions.POrdenEntrega[] entregas) {
        this.entregas = entregas;
    }


    /**
     * Gets the vehiculosAdicionales value for this PViaje.
     * 
     * @return vehiculosAdicionales
     */
    public ar.com.unisolutions.PVehiculo[] getVehiculosAdicionales() {
        return vehiculosAdicionales;
    }


    /**
     * Sets the vehiculosAdicionales value for this PViaje.
     * 
     * @param vehiculosAdicionales
     */
    public void setVehiculosAdicionales(ar.com.unisolutions.PVehiculo[] vehiculosAdicionales) {
        this.vehiculosAdicionales = vehiculosAdicionales;
    }


    /**
     * Gets the paradas value for this PViaje.
     * 
     * @return paradas
     */
    public ar.com.unisolutions.PParada[] getParadas() {
        return paradas;
    }


    /**
     * Sets the paradas value for this PViaje.
     * 
     * @param paradas
     */
    public void setParadas(ar.com.unisolutions.PParada[] paradas) {
        this.paradas = paradas;
    }


    /**
     * Gets the idRuta value for this PViaje.
     * 
     * @return idRuta
     */
    public java.lang.Integer getIdRuta() {
        return idRuta;
    }


    /**
     * Sets the idRuta value for this PViaje.
     * 
     * @param idRuta
     */
    public void setIdRuta(java.lang.Integer idRuta) {
        this.idRuta = idRuta;
    }


    /**
     * Gets the fechaInicioCarga value for this PViaje.
     * 
     * @return fechaInicioCarga
     */
    public java.util.Calendar getFechaInicioCarga() {
        return fechaInicioCarga;
    }


    /**
     * Sets the fechaInicioCarga value for this PViaje.
     * 
     * @param fechaInicioCarga
     */
    public void setFechaInicioCarga(java.util.Calendar fechaInicioCarga) {
        this.fechaInicioCarga = fechaInicioCarga;
    }


    /**
     * Gets the fechaFinCarga value for this PViaje.
     * 
     * @return fechaFinCarga
     */
    public java.util.Calendar getFechaFinCarga() {
        return fechaFinCarga;
    }


    /**
     * Sets the fechaFinCarga value for this PViaje.
     * 
     * @param fechaFinCarga
     */
    public void setFechaFinCarga(java.util.Calendar fechaFinCarga) {
        this.fechaFinCarga = fechaFinCarga;
    }


    /**
     * Gets the fechaHoraAtraque value for this PViaje.
     * 
     * @return fechaHoraAtraque
     */
    public java.util.Calendar getFechaHoraAtraque() {
        return fechaHoraAtraque;
    }


    /**
     * Sets the fechaHoraAtraque value for this PViaje.
     * 
     * @param fechaHoraAtraque
     */
    public void setFechaHoraAtraque(java.util.Calendar fechaHoraAtraque) {
        this.fechaHoraAtraque = fechaHoraAtraque;
    }


    /**
     * Gets the fechaHoraArribo value for this PViaje.
     * 
     * @return fechaHoraArribo
     */
    public java.util.Calendar getFechaHoraArribo() {
        return fechaHoraArribo;
    }


    /**
     * Sets the fechaHoraArribo value for this PViaje.
     * 
     * @param fechaHoraArribo
     */
    public void setFechaHoraArribo(java.util.Calendar fechaHoraArribo) {
        this.fechaHoraArribo = fechaHoraArribo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PViaje)) return false;
        PViaje other = (PViaje) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idViaje == other.getIdViaje() &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.categoria==null && other.getCategoria()==null) || 
             (this.categoria!=null &&
              this.categoria.equals(other.getCategoria()))) &&
            this.kmsPlanificados == other.getKmsPlanificados() &&
            ((this.idDibujoZona==null && other.getIdDibujoZona()==null) || 
             (this.idDibujoZona!=null &&
              this.idDibujoZona.equals(other.getIdDibujoZona()))) &&
            ((this.descripcionZona==null && other.getDescripcionZona()==null) || 
             (this.descripcionZona!=null &&
              this.descripcionZona.equals(other.getDescripcionZona()))) &&
            ((this.fechaInicio==null && other.getFechaInicio()==null) || 
             (this.fechaInicio!=null &&
              this.fechaInicio.equals(other.getFechaInicio()))) &&
            ((this.fechaFin==null && other.getFechaFin()==null) || 
             (this.fechaFin!=null &&
              this.fechaFin.equals(other.getFechaFin()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa()))) &&
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo()))) &&
            ((this.conductor==null && other.getConductor()==null) || 
             (this.conductor!=null &&
              this.conductor.equals(other.getConductor()))) &&
            ((this.depositoSalida==null && other.getDepositoSalida()==null) || 
             (this.depositoSalida!=null &&
              this.depositoSalida.equals(other.getDepositoSalida()))) &&
            ((this.depositoLlegada==null && other.getDepositoLlegada()==null) || 
             (this.depositoLlegada!=null &&
              this.depositoLlegada.equals(other.getDepositoLlegada()))) &&
            ((this.transporte==null && other.getTransporte()==null) || 
             (this.transporte!=null &&
              this.transporte.equals(other.getTransporte()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.fechaCreacion==null && other.getFechaCreacion()==null) || 
             (this.fechaCreacion!=null &&
              this.fechaCreacion.equals(other.getFechaCreacion()))) &&
            ((this.tipoViaje==null && other.getTipoViaje()==null) || 
             (this.tipoViaje!=null &&
              this.tipoViaje.equals(other.getTipoViaje()))) &&
            ((this.varchar1==null && other.getVarchar1()==null) || 
             (this.varchar1!=null &&
              this.varchar1.equals(other.getVarchar1()))) &&
            ((this.varchar2==null && other.getVarchar2()==null) || 
             (this.varchar2!=null &&
              this.varchar2.equals(other.getVarchar2()))) &&
            ((this.varchar3==null && other.getVarchar3()==null) || 
             (this.varchar3!=null &&
              this.varchar3.equals(other.getVarchar3()))) &&
            ((this.vehiculoSecundario==null && other.getVehiculoSecundario()==null) || 
             (this.vehiculoSecundario!=null &&
              this.vehiculoSecundario.equals(other.getVehiculoSecundario()))) &&
            ((this.vehiculoTerciario==null && other.getVehiculoTerciario()==null) || 
             (this.vehiculoTerciario!=null &&
              this.vehiculoTerciario.equals(other.getVehiculoTerciario()))) &&
            ((this.recorrido==null && other.getRecorrido()==null) || 
             (this.recorrido!=null &&
              this.recorrido.equals(other.getRecorrido()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            ((this.recursos==null && other.getRecursos()==null) || 
             (this.recursos!=null &&
              java.util.Arrays.equals(this.recursos, other.getRecursos()))) &&
            ((this.preImporte==null && other.getPreImporte()==null) || 
             (this.preImporte!=null &&
              this.preImporte.equals(other.getPreImporte()))) &&
            ((this.preCosto==null && other.getPreCosto()==null) || 
             (this.preCosto!=null &&
              this.preCosto.equals(other.getPreCosto()))) &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.varchar4==null && other.getVarchar4()==null) || 
             (this.varchar4!=null &&
              this.varchar4.equals(other.getVarchar4()))) &&
            ((this.varchar5==null && other.getVarchar5()==null) || 
             (this.varchar5!=null &&
              this.varchar5.equals(other.getVarchar5()))) &&
            ((this.varchar6==null && other.getVarchar6()==null) || 
             (this.varchar6!=null &&
              this.varchar6.equals(other.getVarchar6()))) &&
            ((this.float1==null && other.getFloat1()==null) || 
             (this.float1!=null &&
              this.float1.equals(other.getFloat1()))) &&
            ((this.float2==null && other.getFloat2()==null) || 
             (this.float2!=null &&
              this.float2.equals(other.getFloat2()))) &&
            ((this.entregas==null && other.getEntregas()==null) || 
             (this.entregas!=null &&
              java.util.Arrays.equals(this.entregas, other.getEntregas()))) &&
            ((this.vehiculosAdicionales==null && other.getVehiculosAdicionales()==null) || 
             (this.vehiculosAdicionales!=null &&
              java.util.Arrays.equals(this.vehiculosAdicionales, other.getVehiculosAdicionales()))) &&
            ((this.paradas==null && other.getParadas()==null) || 
             (this.paradas!=null &&
              java.util.Arrays.equals(this.paradas, other.getParadas()))) &&
            ((this.idRuta==null && other.getIdRuta()==null) || 
             (this.idRuta!=null &&
              this.idRuta.equals(other.getIdRuta()))) &&
            ((this.fechaInicioCarga==null && other.getFechaInicioCarga()==null) || 
             (this.fechaInicioCarga!=null &&
              this.fechaInicioCarga.equals(other.getFechaInicioCarga()))) &&
            ((this.fechaFinCarga==null && other.getFechaFinCarga()==null) || 
             (this.fechaFinCarga!=null &&
              this.fechaFinCarga.equals(other.getFechaFinCarga()))) &&
            ((this.fechaHoraAtraque==null && other.getFechaHoraAtraque()==null) || 
             (this.fechaHoraAtraque!=null &&
              this.fechaHoraAtraque.equals(other.getFechaHoraAtraque()))) &&
            ((this.fechaHoraArribo==null && other.getFechaHoraArribo()==null) || 
             (this.fechaHoraArribo!=null &&
              this.fechaHoraArribo.equals(other.getFechaHoraArribo())));
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
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getCategoria() != null) {
            _hashCode += getCategoria().hashCode();
        }
        _hashCode += new Double(getKmsPlanificados()).hashCode();
        if (getIdDibujoZona() != null) {
            _hashCode += getIdDibujoZona().hashCode();
        }
        if (getDescripcionZona() != null) {
            _hashCode += getDescripcionZona().hashCode();
        }
        if (getFechaInicio() != null) {
            _hashCode += getFechaInicio().hashCode();
        }
        if (getFechaFin() != null) {
            _hashCode += getFechaFin().hashCode();
        }
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        if (getEmpresa() != null) {
            _hashCode += getEmpresa().hashCode();
        }
        if (getSucursal() != null) {
            _hashCode += getSucursal().hashCode();
        }
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        if (getConductor() != null) {
            _hashCode += getConductor().hashCode();
        }
        if (getDepositoSalida() != null) {
            _hashCode += getDepositoSalida().hashCode();
        }
        if (getDepositoLlegada() != null) {
            _hashCode += getDepositoLlegada().hashCode();
        }
        if (getTransporte() != null) {
            _hashCode += getTransporte().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
        }
        if (getTipoViaje() != null) {
            _hashCode += getTipoViaje().hashCode();
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
        if (getVehiculoSecundario() != null) {
            _hashCode += getVehiculoSecundario().hashCode();
        }
        if (getVehiculoTerciario() != null) {
            _hashCode += getVehiculoTerciario().hashCode();
        }
        if (getRecorrido() != null) {
            _hashCode += getRecorrido().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        if (getRecursos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRecursos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRecursos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPreImporte() != null) {
            _hashCode += getPreImporte().hashCode();
        }
        if (getPreCosto() != null) {
            _hashCode += getPreCosto().hashCode();
        }
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getVarchar4() != null) {
            _hashCode += getVarchar4().hashCode();
        }
        if (getVarchar5() != null) {
            _hashCode += getVarchar5().hashCode();
        }
        if (getVarchar6() != null) {
            _hashCode += getVarchar6().hashCode();
        }
        if (getFloat1() != null) {
            _hashCode += getFloat1().hashCode();
        }
        if (getFloat2() != null) {
            _hashCode += getFloat2().hashCode();
        }
        if (getEntregas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEntregas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEntregas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVehiculosAdicionales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVehiculosAdicionales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVehiculosAdicionales(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdRuta() != null) {
            _hashCode += getIdRuta().hashCode();
        }
        if (getFechaInicioCarga() != null) {
            _hashCode += getFechaInicioCarga().hashCode();
        }
        if (getFechaFinCarga() != null) {
            _hashCode += getFechaFinCarga().hashCode();
        }
        if (getFechaHoraAtraque() != null) {
            _hashCode += getFechaHoraAtraque().hashCode();
        }
        if (getFechaHoraArribo() != null) {
            _hashCode += getFechaHoraArribo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PViaje.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"));
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
        elemField.setFieldName("categoria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Categoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kmsPlanificados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "KmsPlanificados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDibujoZona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdDibujoZona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionZona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DescripcionZona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaFin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOperacion"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("vehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Vehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
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
        elemField.setFieldName("depositoSalida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DepositoSalida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositoLlegada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DepositoLlegada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"));
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
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCreacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCreacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoViaje"));
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
        elemField.setFieldName("vehiculoSecundario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculoSecundario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoTerciario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculoTerciario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recorrido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Recorrido"));
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
        elemField.setFieldName("recursos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Recursos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preImporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PreImporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preCosto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PreCosto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar4");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Varchar4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar5");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Varchar5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar6");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Varchar6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("float1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Float1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("float2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Float2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entregas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Entregas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculosAdicionales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculosAdicionales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Paradas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRuta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdRuta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicioCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaInicioCarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFinCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaFinCarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraAtraque");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHoraAtraque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraArribo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHoraArribo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
