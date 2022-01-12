/**
 * CrearViajeSolicitud.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearViajeSolicitud  implements java.io.Serializable {
    private int crearViajeNumero;

    private java.lang.String apiKey;

    private java.lang.String dominio;

    private java.util.Calendar fechaViaje;

    private java.util.Calendar fechaInicioPlan;

    private java.util.Calendar fechaFinPlan;

    private java.util.Calendar fechaInicioCarga;

    private java.util.Calendar fechaFinCarga;

    private java.util.Calendar fechaArribo;

    private java.lang.String referencia;

    private java.lang.String descripcion;

    private java.lang.String observaciones;

    private ar.com.unisolutions.Transporte transporte;

    private ar.com.unisolutions.PCliente cliente;

    private ar.com.unisolutions.PDeposito depositoSalida;

    private ar.com.unisolutions.PDeposito depositoLlegada;

    private ar.com.unisolutions.PConductor conductor;

    private java.lang.String login;

    private ar.com.unisolutions.PParada[] paradas;

    private java.lang.String prestador;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String varchar3;

    private java.lang.String varchar4;

    private java.lang.String varchar5;

    private java.lang.String varchar6;

    private java.lang.String empresa;

    private java.lang.String sucursal;

    private java.lang.String operacion;

    private java.lang.String tipoOperacion;

    private java.lang.String recorrido;

    private java.lang.String vehiculoSecundario;

    private java.lang.String categoria;

    private java.lang.Double kmsPlan;

    private java.lang.String tipoViaje;

    private java.lang.String tipoVehiculo;

    private java.lang.String tipoJornada;

    private java.lang.String tipoCarga;

    private java.lang.String descripcionZona;

    private ar.com.unisolutions.PRecursos[] recursos;

    private java.lang.Double preCosto;

    private java.lang.Double float1;

    private java.lang.Double float2;

    private java.lang.Double preImporte;

    public CrearViajeSolicitud() {
    }

    public CrearViajeSolicitud(
           int crearViajeNumero,
           java.lang.String apiKey,
           java.lang.String dominio,
           java.util.Calendar fechaViaje,
           java.util.Calendar fechaInicioPlan,
           java.util.Calendar fechaFinPlan,
           java.util.Calendar fechaInicioCarga,
           java.util.Calendar fechaFinCarga,
           java.util.Calendar fechaArribo,
           java.lang.String referencia,
           java.lang.String descripcion,
           java.lang.String observaciones,
           ar.com.unisolutions.Transporte transporte,
           ar.com.unisolutions.PCliente cliente,
           ar.com.unisolutions.PDeposito depositoSalida,
           ar.com.unisolutions.PDeposito depositoLlegada,
           ar.com.unisolutions.PConductor conductor,
           java.lang.String login,
           ar.com.unisolutions.PParada[] paradas,
           java.lang.String prestador,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           java.lang.String varchar4,
           java.lang.String varchar5,
           java.lang.String varchar6,
           java.lang.String empresa,
           java.lang.String sucursal,
           java.lang.String operacion,
           java.lang.String tipoOperacion,
           java.lang.String recorrido,
           java.lang.String vehiculoSecundario,
           java.lang.String categoria,
           java.lang.Double kmsPlan,
           java.lang.String tipoViaje,
           java.lang.String tipoVehiculo,
           java.lang.String tipoJornada,
           java.lang.String tipoCarga,
           java.lang.String descripcionZona,
           ar.com.unisolutions.PRecursos[] recursos,
           java.lang.Double preCosto,
           java.lang.Double float1,
           java.lang.Double float2,
           java.lang.Double preImporte) {
           this.crearViajeNumero = crearViajeNumero;
           this.apiKey = apiKey;
           this.dominio = dominio;
           this.fechaViaje = fechaViaje;
           this.fechaInicioPlan = fechaInicioPlan;
           this.fechaFinPlan = fechaFinPlan;
           this.fechaInicioCarga = fechaInicioCarga;
           this.fechaFinCarga = fechaFinCarga;
           this.fechaArribo = fechaArribo;
           this.referencia = referencia;
           this.descripcion = descripcion;
           this.observaciones = observaciones;
           this.transporte = transporte;
           this.cliente = cliente;
           this.depositoSalida = depositoSalida;
           this.depositoLlegada = depositoLlegada;
           this.conductor = conductor;
           this.login = login;
           this.paradas = paradas;
           this.prestador = prestador;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.varchar3 = varchar3;
           this.varchar4 = varchar4;
           this.varchar5 = varchar5;
           this.varchar6 = varchar6;
           this.empresa = empresa;
           this.sucursal = sucursal;
           this.operacion = operacion;
           this.tipoOperacion = tipoOperacion;
           this.recorrido = recorrido;
           this.vehiculoSecundario = vehiculoSecundario;
           this.categoria = categoria;
           this.kmsPlan = kmsPlan;
           this.tipoViaje = tipoViaje;
           this.tipoVehiculo = tipoVehiculo;
           this.tipoJornada = tipoJornada;
           this.tipoCarga = tipoCarga;
           this.descripcionZona = descripcionZona;
           this.recursos = recursos;
           this.preCosto = preCosto;
           this.float1 = float1;
           this.float2 = float2;
           this.preImporte = preImporte;
    }


    /**
     * Gets the crearViajeNumero value for this CrearViajeSolicitud.
     * 
     * @return crearViajeNumero
     */
    public int getCrearViajeNumero() {
        return crearViajeNumero;
    }


    /**
     * Sets the crearViajeNumero value for this CrearViajeSolicitud.
     * 
     * @param crearViajeNumero
     */
    public void setCrearViajeNumero(int crearViajeNumero) {
        this.crearViajeNumero = crearViajeNumero;
    }


    /**
     * Gets the apiKey value for this CrearViajeSolicitud.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this CrearViajeSolicitud.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the dominio value for this CrearViajeSolicitud.
     * 
     * @return dominio
     */
    public java.lang.String getDominio() {
        return dominio;
    }


    /**
     * Sets the dominio value for this CrearViajeSolicitud.
     * 
     * @param dominio
     */
    public void setDominio(java.lang.String dominio) {
        this.dominio = dominio;
    }


    /**
     * Gets the fechaViaje value for this CrearViajeSolicitud.
     * 
     * @return fechaViaje
     */
    public java.util.Calendar getFechaViaje() {
        return fechaViaje;
    }


    /**
     * Sets the fechaViaje value for this CrearViajeSolicitud.
     * 
     * @param fechaViaje
     */
    public void setFechaViaje(java.util.Calendar fechaViaje) {
        this.fechaViaje = fechaViaje;
    }


    /**
     * Gets the fechaInicioPlan value for this CrearViajeSolicitud.
     * 
     * @return fechaInicioPlan
     */
    public java.util.Calendar getFechaInicioPlan() {
        return fechaInicioPlan;
    }


    /**
     * Sets the fechaInicioPlan value for this CrearViajeSolicitud.
     * 
     * @param fechaInicioPlan
     */
    public void setFechaInicioPlan(java.util.Calendar fechaInicioPlan) {
        this.fechaInicioPlan = fechaInicioPlan;
    }


    /**
     * Gets the fechaFinPlan value for this CrearViajeSolicitud.
     * 
     * @return fechaFinPlan
     */
    public java.util.Calendar getFechaFinPlan() {
        return fechaFinPlan;
    }


    /**
     * Sets the fechaFinPlan value for this CrearViajeSolicitud.
     * 
     * @param fechaFinPlan
     */
    public void setFechaFinPlan(java.util.Calendar fechaFinPlan) {
        this.fechaFinPlan = fechaFinPlan;
    }


    /**
     * Gets the fechaInicioCarga value for this CrearViajeSolicitud.
     * 
     * @return fechaInicioCarga
     */
    public java.util.Calendar getFechaInicioCarga() {
        return fechaInicioCarga;
    }


    /**
     * Sets the fechaInicioCarga value for this CrearViajeSolicitud.
     * 
     * @param fechaInicioCarga
     */
    public void setFechaInicioCarga(java.util.Calendar fechaInicioCarga) {
        this.fechaInicioCarga = fechaInicioCarga;
    }


    /**
     * Gets the fechaFinCarga value for this CrearViajeSolicitud.
     * 
     * @return fechaFinCarga
     */
    public java.util.Calendar getFechaFinCarga() {
        return fechaFinCarga;
    }


    /**
     * Sets the fechaFinCarga value for this CrearViajeSolicitud.
     * 
     * @param fechaFinCarga
     */
    public void setFechaFinCarga(java.util.Calendar fechaFinCarga) {
        this.fechaFinCarga = fechaFinCarga;
    }


    /**
     * Gets the fechaArribo value for this CrearViajeSolicitud.
     * 
     * @return fechaArribo
     */
    public java.util.Calendar getFechaArribo() {
        return fechaArribo;
    }


    /**
     * Sets the fechaArribo value for this CrearViajeSolicitud.
     * 
     * @param fechaArribo
     */
    public void setFechaArribo(java.util.Calendar fechaArribo) {
        this.fechaArribo = fechaArribo;
    }


    /**
     * Gets the referencia value for this CrearViajeSolicitud.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this CrearViajeSolicitud.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the descripcion value for this CrearViajeSolicitud.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this CrearViajeSolicitud.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the observaciones value for this CrearViajeSolicitud.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this CrearViajeSolicitud.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the transporte value for this CrearViajeSolicitud.
     * 
     * @return transporte
     */
    public ar.com.unisolutions.Transporte getTransporte() {
        return transporte;
    }


    /**
     * Sets the transporte value for this CrearViajeSolicitud.
     * 
     * @param transporte
     */
    public void setTransporte(ar.com.unisolutions.Transporte transporte) {
        this.transporte = transporte;
    }


    /**
     * Gets the cliente value for this CrearViajeSolicitud.
     * 
     * @return cliente
     */
    public ar.com.unisolutions.PCliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this CrearViajeSolicitud.
     * 
     * @param cliente
     */
    public void setCliente(ar.com.unisolutions.PCliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the depositoSalida value for this CrearViajeSolicitud.
     * 
     * @return depositoSalida
     */
    public ar.com.unisolutions.PDeposito getDepositoSalida() {
        return depositoSalida;
    }


    /**
     * Sets the depositoSalida value for this CrearViajeSolicitud.
     * 
     * @param depositoSalida
     */
    public void setDepositoSalida(ar.com.unisolutions.PDeposito depositoSalida) {
        this.depositoSalida = depositoSalida;
    }


    /**
     * Gets the depositoLlegada value for this CrearViajeSolicitud.
     * 
     * @return depositoLlegada
     */
    public ar.com.unisolutions.PDeposito getDepositoLlegada() {
        return depositoLlegada;
    }


    /**
     * Sets the depositoLlegada value for this CrearViajeSolicitud.
     * 
     * @param depositoLlegada
     */
    public void setDepositoLlegada(ar.com.unisolutions.PDeposito depositoLlegada) {
        this.depositoLlegada = depositoLlegada;
    }


    /**
     * Gets the conductor value for this CrearViajeSolicitud.
     * 
     * @return conductor
     */
    public ar.com.unisolutions.PConductor getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this CrearViajeSolicitud.
     * 
     * @param conductor
     */
    public void setConductor(ar.com.unisolutions.PConductor conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the login value for this CrearViajeSolicitud.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this CrearViajeSolicitud.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the paradas value for this CrearViajeSolicitud.
     * 
     * @return paradas
     */
    public ar.com.unisolutions.PParada[] getParadas() {
        return paradas;
    }


    /**
     * Sets the paradas value for this CrearViajeSolicitud.
     * 
     * @param paradas
     */
    public void setParadas(ar.com.unisolutions.PParada[] paradas) {
        this.paradas = paradas;
    }


    /**
     * Gets the prestador value for this CrearViajeSolicitud.
     * 
     * @return prestador
     */
    public java.lang.String getPrestador() {
        return prestador;
    }


    /**
     * Sets the prestador value for this CrearViajeSolicitud.
     * 
     * @param prestador
     */
    public void setPrestador(java.lang.String prestador) {
        this.prestador = prestador;
    }


    /**
     * Gets the varchar1 value for this CrearViajeSolicitud.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this CrearViajeSolicitud.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this CrearViajeSolicitud.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this CrearViajeSolicitud.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the varchar3 value for this CrearViajeSolicitud.
     * 
     * @return varchar3
     */
    public java.lang.String getVarchar3() {
        return varchar3;
    }


    /**
     * Sets the varchar3 value for this CrearViajeSolicitud.
     * 
     * @param varchar3
     */
    public void setVarchar3(java.lang.String varchar3) {
        this.varchar3 = varchar3;
    }


    /**
     * Gets the varchar4 value for this CrearViajeSolicitud.
     * 
     * @return varchar4
     */
    public java.lang.String getVarchar4() {
        return varchar4;
    }


    /**
     * Sets the varchar4 value for this CrearViajeSolicitud.
     * 
     * @param varchar4
     */
    public void setVarchar4(java.lang.String varchar4) {
        this.varchar4 = varchar4;
    }


    /**
     * Gets the varchar5 value for this CrearViajeSolicitud.
     * 
     * @return varchar5
     */
    public java.lang.String getVarchar5() {
        return varchar5;
    }


    /**
     * Sets the varchar5 value for this CrearViajeSolicitud.
     * 
     * @param varchar5
     */
    public void setVarchar5(java.lang.String varchar5) {
        this.varchar5 = varchar5;
    }


    /**
     * Gets the varchar6 value for this CrearViajeSolicitud.
     * 
     * @return varchar6
     */
    public java.lang.String getVarchar6() {
        return varchar6;
    }


    /**
     * Sets the varchar6 value for this CrearViajeSolicitud.
     * 
     * @param varchar6
     */
    public void setVarchar6(java.lang.String varchar6) {
        this.varchar6 = varchar6;
    }


    /**
     * Gets the empresa value for this CrearViajeSolicitud.
     * 
     * @return empresa
     */
    public java.lang.String getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this CrearViajeSolicitud.
     * 
     * @param empresa
     */
    public void setEmpresa(java.lang.String empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the sucursal value for this CrearViajeSolicitud.
     * 
     * @return sucursal
     */
    public java.lang.String getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this CrearViajeSolicitud.
     * 
     * @param sucursal
     */
    public void setSucursal(java.lang.String sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the operacion value for this CrearViajeSolicitud.
     * 
     * @return operacion
     */
    public java.lang.String getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this CrearViajeSolicitud.
     * 
     * @param operacion
     */
    public void setOperacion(java.lang.String operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the tipoOperacion value for this CrearViajeSolicitud.
     * 
     * @return tipoOperacion
     */
    public java.lang.String getTipoOperacion() {
        return tipoOperacion;
    }


    /**
     * Sets the tipoOperacion value for this CrearViajeSolicitud.
     * 
     * @param tipoOperacion
     */
    public void setTipoOperacion(java.lang.String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }


    /**
     * Gets the recorrido value for this CrearViajeSolicitud.
     * 
     * @return recorrido
     */
    public java.lang.String getRecorrido() {
        return recorrido;
    }


    /**
     * Sets the recorrido value for this CrearViajeSolicitud.
     * 
     * @param recorrido
     */
    public void setRecorrido(java.lang.String recorrido) {
        this.recorrido = recorrido;
    }


    /**
     * Gets the vehiculoSecundario value for this CrearViajeSolicitud.
     * 
     * @return vehiculoSecundario
     */
    public java.lang.String getVehiculoSecundario() {
        return vehiculoSecundario;
    }


    /**
     * Sets the vehiculoSecundario value for this CrearViajeSolicitud.
     * 
     * @param vehiculoSecundario
     */
    public void setVehiculoSecundario(java.lang.String vehiculoSecundario) {
        this.vehiculoSecundario = vehiculoSecundario;
    }


    /**
     * Gets the categoria value for this CrearViajeSolicitud.
     * 
     * @return categoria
     */
    public java.lang.String getCategoria() {
        return categoria;
    }


    /**
     * Sets the categoria value for this CrearViajeSolicitud.
     * 
     * @param categoria
     */
    public void setCategoria(java.lang.String categoria) {
        this.categoria = categoria;
    }


    /**
     * Gets the kmsPlan value for this CrearViajeSolicitud.
     * 
     * @return kmsPlan
     */
    public java.lang.Double getKmsPlan() {
        return kmsPlan;
    }


    /**
     * Sets the kmsPlan value for this CrearViajeSolicitud.
     * 
     * @param kmsPlan
     */
    public void setKmsPlan(java.lang.Double kmsPlan) {
        this.kmsPlan = kmsPlan;
    }


    /**
     * Gets the tipoViaje value for this CrearViajeSolicitud.
     * 
     * @return tipoViaje
     */
    public java.lang.String getTipoViaje() {
        return tipoViaje;
    }


    /**
     * Sets the tipoViaje value for this CrearViajeSolicitud.
     * 
     * @param tipoViaje
     */
    public void setTipoViaje(java.lang.String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }


    /**
     * Gets the tipoVehiculo value for this CrearViajeSolicitud.
     * 
     * @return tipoVehiculo
     */
    public java.lang.String getTipoVehiculo() {
        return tipoVehiculo;
    }


    /**
     * Sets the tipoVehiculo value for this CrearViajeSolicitud.
     * 
     * @param tipoVehiculo
     */
    public void setTipoVehiculo(java.lang.String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }


    /**
     * Gets the tipoJornada value for this CrearViajeSolicitud.
     * 
     * @return tipoJornada
     */
    public java.lang.String getTipoJornada() {
        return tipoJornada;
    }


    /**
     * Sets the tipoJornada value for this CrearViajeSolicitud.
     * 
     * @param tipoJornada
     */
    public void setTipoJornada(java.lang.String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }


    /**
     * Gets the tipoCarga value for this CrearViajeSolicitud.
     * 
     * @return tipoCarga
     */
    public java.lang.String getTipoCarga() {
        return tipoCarga;
    }


    /**
     * Sets the tipoCarga value for this CrearViajeSolicitud.
     * 
     * @param tipoCarga
     */
    public void setTipoCarga(java.lang.String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }


    /**
     * Gets the descripcionZona value for this CrearViajeSolicitud.
     * 
     * @return descripcionZona
     */
    public java.lang.String getDescripcionZona() {
        return descripcionZona;
    }


    /**
     * Sets the descripcionZona value for this CrearViajeSolicitud.
     * 
     * @param descripcionZona
     */
    public void setDescripcionZona(java.lang.String descripcionZona) {
        this.descripcionZona = descripcionZona;
    }


    /**
     * Gets the recursos value for this CrearViajeSolicitud.
     * 
     * @return recursos
     */
    public ar.com.unisolutions.PRecursos[] getRecursos() {
        return recursos;
    }


    /**
     * Sets the recursos value for this CrearViajeSolicitud.
     * 
     * @param recursos
     */
    public void setRecursos(ar.com.unisolutions.PRecursos[] recursos) {
        this.recursos = recursos;
    }


    /**
     * Gets the preCosto value for this CrearViajeSolicitud.
     * 
     * @return preCosto
     */
    public java.lang.Double getPreCosto() {
        return preCosto;
    }


    /**
     * Sets the preCosto value for this CrearViajeSolicitud.
     * 
     * @param preCosto
     */
    public void setPreCosto(java.lang.Double preCosto) {
        this.preCosto = preCosto;
    }


    /**
     * Gets the float1 value for this CrearViajeSolicitud.
     * 
     * @return float1
     */
    public java.lang.Double getFloat1() {
        return float1;
    }


    /**
     * Sets the float1 value for this CrearViajeSolicitud.
     * 
     * @param float1
     */
    public void setFloat1(java.lang.Double float1) {
        this.float1 = float1;
    }


    /**
     * Gets the float2 value for this CrearViajeSolicitud.
     * 
     * @return float2
     */
    public java.lang.Double getFloat2() {
        return float2;
    }


    /**
     * Sets the float2 value for this CrearViajeSolicitud.
     * 
     * @param float2
     */
    public void setFloat2(java.lang.Double float2) {
        this.float2 = float2;
    }


    /**
     * Gets the preImporte value for this CrearViajeSolicitud.
     * 
     * @return preImporte
     */
    public java.lang.Double getPreImporte() {
        return preImporte;
    }


    /**
     * Sets the preImporte value for this CrearViajeSolicitud.
     * 
     * @param preImporte
     */
    public void setPreImporte(java.lang.Double preImporte) {
        this.preImporte = preImporte;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearViajeSolicitud)) return false;
        CrearViajeSolicitud other = (CrearViajeSolicitud) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.crearViajeNumero == other.getCrearViajeNumero() &&
            ((this.apiKey==null && other.getApiKey()==null) || 
             (this.apiKey!=null &&
              this.apiKey.equals(other.getApiKey()))) &&
            ((this.dominio==null && other.getDominio()==null) || 
             (this.dominio!=null &&
              this.dominio.equals(other.getDominio()))) &&
            ((this.fechaViaje==null && other.getFechaViaje()==null) || 
             (this.fechaViaje!=null &&
              this.fechaViaje.equals(other.getFechaViaje()))) &&
            ((this.fechaInicioPlan==null && other.getFechaInicioPlan()==null) || 
             (this.fechaInicioPlan!=null &&
              this.fechaInicioPlan.equals(other.getFechaInicioPlan()))) &&
            ((this.fechaFinPlan==null && other.getFechaFinPlan()==null) || 
             (this.fechaFinPlan!=null &&
              this.fechaFinPlan.equals(other.getFechaFinPlan()))) &&
            ((this.fechaInicioCarga==null && other.getFechaInicioCarga()==null) || 
             (this.fechaInicioCarga!=null &&
              this.fechaInicioCarga.equals(other.getFechaInicioCarga()))) &&
            ((this.fechaFinCarga==null && other.getFechaFinCarga()==null) || 
             (this.fechaFinCarga!=null &&
              this.fechaFinCarga.equals(other.getFechaFinCarga()))) &&
            ((this.fechaArribo==null && other.getFechaArribo()==null) || 
             (this.fechaArribo!=null &&
              this.fechaArribo.equals(other.getFechaArribo()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            ((this.transporte==null && other.getTransporte()==null) || 
             (this.transporte!=null &&
              this.transporte.equals(other.getTransporte()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.depositoSalida==null && other.getDepositoSalida()==null) || 
             (this.depositoSalida!=null &&
              this.depositoSalida.equals(other.getDepositoSalida()))) &&
            ((this.depositoLlegada==null && other.getDepositoLlegada()==null) || 
             (this.depositoLlegada!=null &&
              this.depositoLlegada.equals(other.getDepositoLlegada()))) &&
            ((this.conductor==null && other.getConductor()==null) || 
             (this.conductor!=null &&
              this.conductor.equals(other.getConductor()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.paradas==null && other.getParadas()==null) || 
             (this.paradas!=null &&
              java.util.Arrays.equals(this.paradas, other.getParadas()))) &&
            ((this.prestador==null && other.getPrestador()==null) || 
             (this.prestador!=null &&
              this.prestador.equals(other.getPrestador()))) &&
            ((this.varchar1==null && other.getVarchar1()==null) || 
             (this.varchar1!=null &&
              this.varchar1.equals(other.getVarchar1()))) &&
            ((this.varchar2==null && other.getVarchar2()==null) || 
             (this.varchar2!=null &&
              this.varchar2.equals(other.getVarchar2()))) &&
            ((this.varchar3==null && other.getVarchar3()==null) || 
             (this.varchar3!=null &&
              this.varchar3.equals(other.getVarchar3()))) &&
            ((this.varchar4==null && other.getVarchar4()==null) || 
             (this.varchar4!=null &&
              this.varchar4.equals(other.getVarchar4()))) &&
            ((this.varchar5==null && other.getVarchar5()==null) || 
             (this.varchar5!=null &&
              this.varchar5.equals(other.getVarchar5()))) &&
            ((this.varchar6==null && other.getVarchar6()==null) || 
             (this.varchar6!=null &&
              this.varchar6.equals(other.getVarchar6()))) &&
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa()))) &&
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
            ((this.tipoOperacion==null && other.getTipoOperacion()==null) || 
             (this.tipoOperacion!=null &&
              this.tipoOperacion.equals(other.getTipoOperacion()))) &&
            ((this.recorrido==null && other.getRecorrido()==null) || 
             (this.recorrido!=null &&
              this.recorrido.equals(other.getRecorrido()))) &&
            ((this.vehiculoSecundario==null && other.getVehiculoSecundario()==null) || 
             (this.vehiculoSecundario!=null &&
              this.vehiculoSecundario.equals(other.getVehiculoSecundario()))) &&
            ((this.categoria==null && other.getCategoria()==null) || 
             (this.categoria!=null &&
              this.categoria.equals(other.getCategoria()))) &&
            ((this.kmsPlan==null && other.getKmsPlan()==null) || 
             (this.kmsPlan!=null &&
              this.kmsPlan.equals(other.getKmsPlan()))) &&
            ((this.tipoViaje==null && other.getTipoViaje()==null) || 
             (this.tipoViaje!=null &&
              this.tipoViaje.equals(other.getTipoViaje()))) &&
            ((this.tipoVehiculo==null && other.getTipoVehiculo()==null) || 
             (this.tipoVehiculo!=null &&
              this.tipoVehiculo.equals(other.getTipoVehiculo()))) &&
            ((this.tipoJornada==null && other.getTipoJornada()==null) || 
             (this.tipoJornada!=null &&
              this.tipoJornada.equals(other.getTipoJornada()))) &&
            ((this.tipoCarga==null && other.getTipoCarga()==null) || 
             (this.tipoCarga!=null &&
              this.tipoCarga.equals(other.getTipoCarga()))) &&
            ((this.descripcionZona==null && other.getDescripcionZona()==null) || 
             (this.descripcionZona!=null &&
              this.descripcionZona.equals(other.getDescripcionZona()))) &&
            ((this.recursos==null && other.getRecursos()==null) || 
             (this.recursos!=null &&
              java.util.Arrays.equals(this.recursos, other.getRecursos()))) &&
            ((this.preCosto==null && other.getPreCosto()==null) || 
             (this.preCosto!=null &&
              this.preCosto.equals(other.getPreCosto()))) &&
            ((this.float1==null && other.getFloat1()==null) || 
             (this.float1!=null &&
              this.float1.equals(other.getFloat1()))) &&
            ((this.float2==null && other.getFloat2()==null) || 
             (this.float2!=null &&
              this.float2.equals(other.getFloat2()))) &&
            ((this.preImporte==null && other.getPreImporte()==null) || 
             (this.preImporte!=null &&
              this.preImporte.equals(other.getPreImporte())));
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
        _hashCode += getCrearViajeNumero();
        if (getApiKey() != null) {
            _hashCode += getApiKey().hashCode();
        }
        if (getDominio() != null) {
            _hashCode += getDominio().hashCode();
        }
        if (getFechaViaje() != null) {
            _hashCode += getFechaViaje().hashCode();
        }
        if (getFechaInicioPlan() != null) {
            _hashCode += getFechaInicioPlan().hashCode();
        }
        if (getFechaFinPlan() != null) {
            _hashCode += getFechaFinPlan().hashCode();
        }
        if (getFechaInicioCarga() != null) {
            _hashCode += getFechaInicioCarga().hashCode();
        }
        if (getFechaFinCarga() != null) {
            _hashCode += getFechaFinCarga().hashCode();
        }
        if (getFechaArribo() != null) {
            _hashCode += getFechaArribo().hashCode();
        }
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        if (getTransporte() != null) {
            _hashCode += getTransporte().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getDepositoSalida() != null) {
            _hashCode += getDepositoSalida().hashCode();
        }
        if (getDepositoLlegada() != null) {
            _hashCode += getDepositoLlegada().hashCode();
        }
        if (getConductor() != null) {
            _hashCode += getConductor().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
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
        if (getPrestador() != null) {
            _hashCode += getPrestador().hashCode();
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
        if (getVarchar4() != null) {
            _hashCode += getVarchar4().hashCode();
        }
        if (getVarchar5() != null) {
            _hashCode += getVarchar5().hashCode();
        }
        if (getVarchar6() != null) {
            _hashCode += getVarchar6().hashCode();
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
        if (getTipoOperacion() != null) {
            _hashCode += getTipoOperacion().hashCode();
        }
        if (getRecorrido() != null) {
            _hashCode += getRecorrido().hashCode();
        }
        if (getVehiculoSecundario() != null) {
            _hashCode += getVehiculoSecundario().hashCode();
        }
        if (getCategoria() != null) {
            _hashCode += getCategoria().hashCode();
        }
        if (getKmsPlan() != null) {
            _hashCode += getKmsPlan().hashCode();
        }
        if (getTipoViaje() != null) {
            _hashCode += getTipoViaje().hashCode();
        }
        if (getTipoVehiculo() != null) {
            _hashCode += getTipoVehiculo().hashCode();
        }
        if (getTipoJornada() != null) {
            _hashCode += getTipoJornada().hashCode();
        }
        if (getTipoCarga() != null) {
            _hashCode += getTipoCarga().hashCode();
        }
        if (getDescripcionZona() != null) {
            _hashCode += getDescripcionZona().hashCode();
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
        if (getPreCosto() != null) {
            _hashCode += getPreCosto().hashCode();
        }
        if (getFloat1() != null) {
            _hashCode += getFloat1().hashCode();
        }
        if (getFloat2() != null) {
            _hashCode += getFloat2().hashCode();
        }
        if (getPreImporte() != null) {
            _hashCode += getPreImporte().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearViajeSolicitud.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeSolicitud"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearViajeNumero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeNumero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ApiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dominio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dominio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicioPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaInicioPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFinPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaFinPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicioCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaInicioCarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFinCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaFinCarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaArribo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaArribo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
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
        elemField.setFieldName("transporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "transporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositoSalida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoSalida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositoLlegada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "depositoLlegada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conductor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "conductor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("prestador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "prestador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar4");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar5");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar6");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "varchar6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Empresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Sucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoOperacion"));
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
        elemField.setFieldName("vehiculoSecundario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculoSecundario"));
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
        elemField.setFieldName("kmsPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "KmsPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoVehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoVehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoJornada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoJornada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoCarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionZona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DescripcionZona"));
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
        elemField.setFieldName("preCosto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PreCosto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("float1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Float1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("float2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Float2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preImporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PreImporte"));
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
