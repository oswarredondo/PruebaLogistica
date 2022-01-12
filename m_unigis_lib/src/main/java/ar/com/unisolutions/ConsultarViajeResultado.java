/**
 * ConsultarViajeResultado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarViajeResultado  implements java.io.Serializable {
    private java.lang.String referenciaExterna;

    private java.lang.String descripcion;

    private java.lang.String resultado;

    private boolean viajeFinalizado;

    private java.lang.String estadoViaje;

    private java.lang.String estadoSeguimiento;

    private java.lang.String vehiculoEstadoSeguimiento;

    private int cantidadParadas;

    private int paradaVisitada;

    private java.util.Calendar fechaParadaVisitada;

    private java.lang.String refCliente;

    private java.lang.String refDocumento;

    private java.lang.String refDocumentoAdicional;

    private java.lang.Double kmsPlan;

    private java.lang.Double kmsRecorridos;

    private java.util.Calendar fechaInicioReal;

    private java.util.Calendar fechaFinReal;

    private java.util.Calendar fechaInicioPlan;

    private java.util.Calendar fechaFinPlan;

    private ar.com.unisolutions.PDeposito depositoSalida;

    private ar.com.unisolutions.PDeposito depositoLlegada;

    private ar.com.unisolutions.PVehiculo vehiculo;

    private ar.com.unisolutions.PVehiculo vehiculoSecundario;

    private ar.com.unisolutions.PVehiculo vehiculoTerciario;

    private java.lang.String categoriaViaje;

    private java.lang.String tipoViaje;

    private java.lang.String recorrido;

    private ar.com.unisolutions.POperacion operacion;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String varchar3;

    private java.lang.String varchar4;

    private java.lang.String varchar5;

    private java.lang.String varchar6;

    private java.lang.Double float1;

    private java.lang.Double float2;

    private java.lang.Double peso;

    private java.lang.Double volumen;

    private java.lang.Double bultos;

    private java.lang.Double pallets;

    private ar.com.unisolutions.PConductor conductor;

    private ar.com.unisolutions.PTransporte transporte;

    private ar.com.unisolutions.PRecurso[] recursosViaje;

    private ar.com.unisolutions.PParada[] paradas;

    private ar.com.unisolutions.PIncidencia[] incidencias;

    public ConsultarViajeResultado() {
    }

    public ConsultarViajeResultado(
           java.lang.String referenciaExterna,
           java.lang.String descripcion,
           java.lang.String resultado,
           boolean viajeFinalizado,
           java.lang.String estadoViaje,
           java.lang.String estadoSeguimiento,
           java.lang.String vehiculoEstadoSeguimiento,
           int cantidadParadas,
           int paradaVisitada,
           java.util.Calendar fechaParadaVisitada,
           java.lang.String refCliente,
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           java.lang.Double kmsPlan,
           java.lang.Double kmsRecorridos,
           java.util.Calendar fechaInicioReal,
           java.util.Calendar fechaFinReal,
           java.util.Calendar fechaInicioPlan,
           java.util.Calendar fechaFinPlan,
           ar.com.unisolutions.PDeposito depositoSalida,
           ar.com.unisolutions.PDeposito depositoLlegada,
           ar.com.unisolutions.PVehiculo vehiculo,
           ar.com.unisolutions.PVehiculo vehiculoSecundario,
           ar.com.unisolutions.PVehiculo vehiculoTerciario,
           java.lang.String categoriaViaje,
           java.lang.String tipoViaje,
           java.lang.String recorrido,
           ar.com.unisolutions.POperacion operacion,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           java.lang.String varchar4,
           java.lang.String varchar5,
           java.lang.String varchar6,
           java.lang.Double float1,
           java.lang.Double float2,
           java.lang.Double peso,
           java.lang.Double volumen,
           java.lang.Double bultos,
           java.lang.Double pallets,
           ar.com.unisolutions.PConductor conductor,
           ar.com.unisolutions.PTransporte transporte,
           ar.com.unisolutions.PRecurso[] recursosViaje,
           ar.com.unisolutions.PParada[] paradas,
           ar.com.unisolutions.PIncidencia[] incidencias) {
           this.referenciaExterna = referenciaExterna;
           this.descripcion = descripcion;
           this.resultado = resultado;
           this.viajeFinalizado = viajeFinalizado;
           this.estadoViaje = estadoViaje;
           this.estadoSeguimiento = estadoSeguimiento;
           this.vehiculoEstadoSeguimiento = vehiculoEstadoSeguimiento;
           this.cantidadParadas = cantidadParadas;
           this.paradaVisitada = paradaVisitada;
           this.fechaParadaVisitada = fechaParadaVisitada;
           this.refCliente = refCliente;
           this.refDocumento = refDocumento;
           this.refDocumentoAdicional = refDocumentoAdicional;
           this.kmsPlan = kmsPlan;
           this.kmsRecorridos = kmsRecorridos;
           this.fechaInicioReal = fechaInicioReal;
           this.fechaFinReal = fechaFinReal;
           this.fechaInicioPlan = fechaInicioPlan;
           this.fechaFinPlan = fechaFinPlan;
           this.depositoSalida = depositoSalida;
           this.depositoLlegada = depositoLlegada;
           this.vehiculo = vehiculo;
           this.vehiculoSecundario = vehiculoSecundario;
           this.vehiculoTerciario = vehiculoTerciario;
           this.categoriaViaje = categoriaViaje;
           this.tipoViaje = tipoViaje;
           this.recorrido = recorrido;
           this.operacion = operacion;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.varchar3 = varchar3;
           this.varchar4 = varchar4;
           this.varchar5 = varchar5;
           this.varchar6 = varchar6;
           this.float1 = float1;
           this.float2 = float2;
           this.peso = peso;
           this.volumen = volumen;
           this.bultos = bultos;
           this.pallets = pallets;
           this.conductor = conductor;
           this.transporte = transporte;
           this.recursosViaje = recursosViaje;
           this.paradas = paradas;
           this.incidencias = incidencias;
    }


    /**
     * Gets the referenciaExterna value for this ConsultarViajeResultado.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this ConsultarViajeResultado.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the descripcion value for this ConsultarViajeResultado.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ConsultarViajeResultado.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the resultado value for this ConsultarViajeResultado.
     * 
     * @return resultado
     */
    public java.lang.String getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this ConsultarViajeResultado.
     * 
     * @param resultado
     */
    public void setResultado(java.lang.String resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the viajeFinalizado value for this ConsultarViajeResultado.
     * 
     * @return viajeFinalizado
     */
    public boolean isViajeFinalizado() {
        return viajeFinalizado;
    }


    /**
     * Sets the viajeFinalizado value for this ConsultarViajeResultado.
     * 
     * @param viajeFinalizado
     */
    public void setViajeFinalizado(boolean viajeFinalizado) {
        this.viajeFinalizado = viajeFinalizado;
    }


    /**
     * Gets the estadoViaje value for this ConsultarViajeResultado.
     * 
     * @return estadoViaje
     */
    public java.lang.String getEstadoViaje() {
        return estadoViaje;
    }


    /**
     * Sets the estadoViaje value for this ConsultarViajeResultado.
     * 
     * @param estadoViaje
     */
    public void setEstadoViaje(java.lang.String estadoViaje) {
        this.estadoViaje = estadoViaje;
    }


    /**
     * Gets the estadoSeguimiento value for this ConsultarViajeResultado.
     * 
     * @return estadoSeguimiento
     */
    public java.lang.String getEstadoSeguimiento() {
        return estadoSeguimiento;
    }


    /**
     * Sets the estadoSeguimiento value for this ConsultarViajeResultado.
     * 
     * @param estadoSeguimiento
     */
    public void setEstadoSeguimiento(java.lang.String estadoSeguimiento) {
        this.estadoSeguimiento = estadoSeguimiento;
    }


    /**
     * Gets the vehiculoEstadoSeguimiento value for this ConsultarViajeResultado.
     * 
     * @return vehiculoEstadoSeguimiento
     */
    public java.lang.String getVehiculoEstadoSeguimiento() {
        return vehiculoEstadoSeguimiento;
    }


    /**
     * Sets the vehiculoEstadoSeguimiento value for this ConsultarViajeResultado.
     * 
     * @param vehiculoEstadoSeguimiento
     */
    public void setVehiculoEstadoSeguimiento(java.lang.String vehiculoEstadoSeguimiento) {
        this.vehiculoEstadoSeguimiento = vehiculoEstadoSeguimiento;
    }


    /**
     * Gets the cantidadParadas value for this ConsultarViajeResultado.
     * 
     * @return cantidadParadas
     */
    public int getCantidadParadas() {
        return cantidadParadas;
    }


    /**
     * Sets the cantidadParadas value for this ConsultarViajeResultado.
     * 
     * @param cantidadParadas
     */
    public void setCantidadParadas(int cantidadParadas) {
        this.cantidadParadas = cantidadParadas;
    }


    /**
     * Gets the paradaVisitada value for this ConsultarViajeResultado.
     * 
     * @return paradaVisitada
     */
    public int getParadaVisitada() {
        return paradaVisitada;
    }


    /**
     * Sets the paradaVisitada value for this ConsultarViajeResultado.
     * 
     * @param paradaVisitada
     */
    public void setParadaVisitada(int paradaVisitada) {
        this.paradaVisitada = paradaVisitada;
    }


    /**
     * Gets the fechaParadaVisitada value for this ConsultarViajeResultado.
     * 
     * @return fechaParadaVisitada
     */
    public java.util.Calendar getFechaParadaVisitada() {
        return fechaParadaVisitada;
    }


    /**
     * Sets the fechaParadaVisitada value for this ConsultarViajeResultado.
     * 
     * @param fechaParadaVisitada
     */
    public void setFechaParadaVisitada(java.util.Calendar fechaParadaVisitada) {
        this.fechaParadaVisitada = fechaParadaVisitada;
    }


    /**
     * Gets the refCliente value for this ConsultarViajeResultado.
     * 
     * @return refCliente
     */
    public java.lang.String getRefCliente() {
        return refCliente;
    }


    /**
     * Sets the refCliente value for this ConsultarViajeResultado.
     * 
     * @param refCliente
     */
    public void setRefCliente(java.lang.String refCliente) {
        this.refCliente = refCliente;
    }


    /**
     * Gets the refDocumento value for this ConsultarViajeResultado.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this ConsultarViajeResultado.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the refDocumentoAdicional value for this ConsultarViajeResultado.
     * 
     * @return refDocumentoAdicional
     */
    public java.lang.String getRefDocumentoAdicional() {
        return refDocumentoAdicional;
    }


    /**
     * Sets the refDocumentoAdicional value for this ConsultarViajeResultado.
     * 
     * @param refDocumentoAdicional
     */
    public void setRefDocumentoAdicional(java.lang.String refDocumentoAdicional) {
        this.refDocumentoAdicional = refDocumentoAdicional;
    }


    /**
     * Gets the kmsPlan value for this ConsultarViajeResultado.
     * 
     * @return kmsPlan
     */
    public java.lang.Double getKmsPlan() {
        return kmsPlan;
    }


    /**
     * Sets the kmsPlan value for this ConsultarViajeResultado.
     * 
     * @param kmsPlan
     */
    public void setKmsPlan(java.lang.Double kmsPlan) {
        this.kmsPlan = kmsPlan;
    }


    /**
     * Gets the kmsRecorridos value for this ConsultarViajeResultado.
     * 
     * @return kmsRecorridos
     */
    public java.lang.Double getKmsRecorridos() {
        return kmsRecorridos;
    }


    /**
     * Sets the kmsRecorridos value for this ConsultarViajeResultado.
     * 
     * @param kmsRecorridos
     */
    public void setKmsRecorridos(java.lang.Double kmsRecorridos) {
        this.kmsRecorridos = kmsRecorridos;
    }


    /**
     * Gets the fechaInicioReal value for this ConsultarViajeResultado.
     * 
     * @return fechaInicioReal
     */
    public java.util.Calendar getFechaInicioReal() {
        return fechaInicioReal;
    }


    /**
     * Sets the fechaInicioReal value for this ConsultarViajeResultado.
     * 
     * @param fechaInicioReal
     */
    public void setFechaInicioReal(java.util.Calendar fechaInicioReal) {
        this.fechaInicioReal = fechaInicioReal;
    }


    /**
     * Gets the fechaFinReal value for this ConsultarViajeResultado.
     * 
     * @return fechaFinReal
     */
    public java.util.Calendar getFechaFinReal() {
        return fechaFinReal;
    }


    /**
     * Sets the fechaFinReal value for this ConsultarViajeResultado.
     * 
     * @param fechaFinReal
     */
    public void setFechaFinReal(java.util.Calendar fechaFinReal) {
        this.fechaFinReal = fechaFinReal;
    }


    /**
     * Gets the fechaInicioPlan value for this ConsultarViajeResultado.
     * 
     * @return fechaInicioPlan
     */
    public java.util.Calendar getFechaInicioPlan() {
        return fechaInicioPlan;
    }


    /**
     * Sets the fechaInicioPlan value for this ConsultarViajeResultado.
     * 
     * @param fechaInicioPlan
     */
    public void setFechaInicioPlan(java.util.Calendar fechaInicioPlan) {
        this.fechaInicioPlan = fechaInicioPlan;
    }


    /**
     * Gets the fechaFinPlan value for this ConsultarViajeResultado.
     * 
     * @return fechaFinPlan
     */
    public java.util.Calendar getFechaFinPlan() {
        return fechaFinPlan;
    }


    /**
     * Sets the fechaFinPlan value for this ConsultarViajeResultado.
     * 
     * @param fechaFinPlan
     */
    public void setFechaFinPlan(java.util.Calendar fechaFinPlan) {
        this.fechaFinPlan = fechaFinPlan;
    }


    /**
     * Gets the depositoSalida value for this ConsultarViajeResultado.
     * 
     * @return depositoSalida
     */
    public ar.com.unisolutions.PDeposito getDepositoSalida() {
        return depositoSalida;
    }


    /**
     * Sets the depositoSalida value for this ConsultarViajeResultado.
     * 
     * @param depositoSalida
     */
    public void setDepositoSalida(ar.com.unisolutions.PDeposito depositoSalida) {
        this.depositoSalida = depositoSalida;
    }


    /**
     * Gets the depositoLlegada value for this ConsultarViajeResultado.
     * 
     * @return depositoLlegada
     */
    public ar.com.unisolutions.PDeposito getDepositoLlegada() {
        return depositoLlegada;
    }


    /**
     * Sets the depositoLlegada value for this ConsultarViajeResultado.
     * 
     * @param depositoLlegada
     */
    public void setDepositoLlegada(ar.com.unisolutions.PDeposito depositoLlegada) {
        this.depositoLlegada = depositoLlegada;
    }


    /**
     * Gets the vehiculo value for this ConsultarViajeResultado.
     * 
     * @return vehiculo
     */
    public ar.com.unisolutions.PVehiculo getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this ConsultarViajeResultado.
     * 
     * @param vehiculo
     */
    public void setVehiculo(ar.com.unisolutions.PVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the vehiculoSecundario value for this ConsultarViajeResultado.
     * 
     * @return vehiculoSecundario
     */
    public ar.com.unisolutions.PVehiculo getVehiculoSecundario() {
        return vehiculoSecundario;
    }


    /**
     * Sets the vehiculoSecundario value for this ConsultarViajeResultado.
     * 
     * @param vehiculoSecundario
     */
    public void setVehiculoSecundario(ar.com.unisolutions.PVehiculo vehiculoSecundario) {
        this.vehiculoSecundario = vehiculoSecundario;
    }


    /**
     * Gets the vehiculoTerciario value for this ConsultarViajeResultado.
     * 
     * @return vehiculoTerciario
     */
    public ar.com.unisolutions.PVehiculo getVehiculoTerciario() {
        return vehiculoTerciario;
    }


    /**
     * Sets the vehiculoTerciario value for this ConsultarViajeResultado.
     * 
     * @param vehiculoTerciario
     */
    public void setVehiculoTerciario(ar.com.unisolutions.PVehiculo vehiculoTerciario) {
        this.vehiculoTerciario = vehiculoTerciario;
    }


    /**
     * Gets the categoriaViaje value for this ConsultarViajeResultado.
     * 
     * @return categoriaViaje
     */
    public java.lang.String getCategoriaViaje() {
        return categoriaViaje;
    }


    /**
     * Sets the categoriaViaje value for this ConsultarViajeResultado.
     * 
     * @param categoriaViaje
     */
    public void setCategoriaViaje(java.lang.String categoriaViaje) {
        this.categoriaViaje = categoriaViaje;
    }


    /**
     * Gets the tipoViaje value for this ConsultarViajeResultado.
     * 
     * @return tipoViaje
     */
    public java.lang.String getTipoViaje() {
        return tipoViaje;
    }


    /**
     * Sets the tipoViaje value for this ConsultarViajeResultado.
     * 
     * @param tipoViaje
     */
    public void setTipoViaje(java.lang.String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }


    /**
     * Gets the recorrido value for this ConsultarViajeResultado.
     * 
     * @return recorrido
     */
    public java.lang.String getRecorrido() {
        return recorrido;
    }


    /**
     * Sets the recorrido value for this ConsultarViajeResultado.
     * 
     * @param recorrido
     */
    public void setRecorrido(java.lang.String recorrido) {
        this.recorrido = recorrido;
    }


    /**
     * Gets the operacion value for this ConsultarViajeResultado.
     * 
     * @return operacion
     */
    public ar.com.unisolutions.POperacion getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this ConsultarViajeResultado.
     * 
     * @param operacion
     */
    public void setOperacion(ar.com.unisolutions.POperacion operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the varchar1 value for this ConsultarViajeResultado.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this ConsultarViajeResultado.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this ConsultarViajeResultado.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this ConsultarViajeResultado.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the varchar3 value for this ConsultarViajeResultado.
     * 
     * @return varchar3
     */
    public java.lang.String getVarchar3() {
        return varchar3;
    }


    /**
     * Sets the varchar3 value for this ConsultarViajeResultado.
     * 
     * @param varchar3
     */
    public void setVarchar3(java.lang.String varchar3) {
        this.varchar3 = varchar3;
    }


    /**
     * Gets the varchar4 value for this ConsultarViajeResultado.
     * 
     * @return varchar4
     */
    public java.lang.String getVarchar4() {
        return varchar4;
    }


    /**
     * Sets the varchar4 value for this ConsultarViajeResultado.
     * 
     * @param varchar4
     */
    public void setVarchar4(java.lang.String varchar4) {
        this.varchar4 = varchar4;
    }


    /**
     * Gets the varchar5 value for this ConsultarViajeResultado.
     * 
     * @return varchar5
     */
    public java.lang.String getVarchar5() {
        return varchar5;
    }


    /**
     * Sets the varchar5 value for this ConsultarViajeResultado.
     * 
     * @param varchar5
     */
    public void setVarchar5(java.lang.String varchar5) {
        this.varchar5 = varchar5;
    }


    /**
     * Gets the varchar6 value for this ConsultarViajeResultado.
     * 
     * @return varchar6
     */
    public java.lang.String getVarchar6() {
        return varchar6;
    }


    /**
     * Sets the varchar6 value for this ConsultarViajeResultado.
     * 
     * @param varchar6
     */
    public void setVarchar6(java.lang.String varchar6) {
        this.varchar6 = varchar6;
    }


    /**
     * Gets the float1 value for this ConsultarViajeResultado.
     * 
     * @return float1
     */
    public java.lang.Double getFloat1() {
        return float1;
    }


    /**
     * Sets the float1 value for this ConsultarViajeResultado.
     * 
     * @param float1
     */
    public void setFloat1(java.lang.Double float1) {
        this.float1 = float1;
    }


    /**
     * Gets the float2 value for this ConsultarViajeResultado.
     * 
     * @return float2
     */
    public java.lang.Double getFloat2() {
        return float2;
    }


    /**
     * Sets the float2 value for this ConsultarViajeResultado.
     * 
     * @param float2
     */
    public void setFloat2(java.lang.Double float2) {
        this.float2 = float2;
    }


    /**
     * Gets the peso value for this ConsultarViajeResultado.
     * 
     * @return peso
     */
    public java.lang.Double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this ConsultarViajeResultado.
     * 
     * @param peso
     */
    public void setPeso(java.lang.Double peso) {
        this.peso = peso;
    }


    /**
     * Gets the volumen value for this ConsultarViajeResultado.
     * 
     * @return volumen
     */
    public java.lang.Double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this ConsultarViajeResultado.
     * 
     * @param volumen
     */
    public void setVolumen(java.lang.Double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the bultos value for this ConsultarViajeResultado.
     * 
     * @return bultos
     */
    public java.lang.Double getBultos() {
        return bultos;
    }


    /**
     * Sets the bultos value for this ConsultarViajeResultado.
     * 
     * @param bultos
     */
    public void setBultos(java.lang.Double bultos) {
        this.bultos = bultos;
    }


    /**
     * Gets the pallets value for this ConsultarViajeResultado.
     * 
     * @return pallets
     */
    public java.lang.Double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this ConsultarViajeResultado.
     * 
     * @param pallets
     */
    public void setPallets(java.lang.Double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the conductor value for this ConsultarViajeResultado.
     * 
     * @return conductor
     */
    public ar.com.unisolutions.PConductor getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this ConsultarViajeResultado.
     * 
     * @param conductor
     */
    public void setConductor(ar.com.unisolutions.PConductor conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the transporte value for this ConsultarViajeResultado.
     * 
     * @return transporte
     */
    public ar.com.unisolutions.PTransporte getTransporte() {
        return transporte;
    }


    /**
     * Sets the transporte value for this ConsultarViajeResultado.
     * 
     * @param transporte
     */
    public void setTransporte(ar.com.unisolutions.PTransporte transporte) {
        this.transporte = transporte;
    }


    /**
     * Gets the recursosViaje value for this ConsultarViajeResultado.
     * 
     * @return recursosViaje
     */
    public ar.com.unisolutions.PRecurso[] getRecursosViaje() {
        return recursosViaje;
    }


    /**
     * Sets the recursosViaje value for this ConsultarViajeResultado.
     * 
     * @param recursosViaje
     */
    public void setRecursosViaje(ar.com.unisolutions.PRecurso[] recursosViaje) {
        this.recursosViaje = recursosViaje;
    }


    /**
     * Gets the paradas value for this ConsultarViajeResultado.
     * 
     * @return paradas
     */
    public ar.com.unisolutions.PParada[] getParadas() {
        return paradas;
    }


    /**
     * Sets the paradas value for this ConsultarViajeResultado.
     * 
     * @param paradas
     */
    public void setParadas(ar.com.unisolutions.PParada[] paradas) {
        this.paradas = paradas;
    }


    /**
     * Gets the incidencias value for this ConsultarViajeResultado.
     * 
     * @return incidencias
     */
    public ar.com.unisolutions.PIncidencia[] getIncidencias() {
        return incidencias;
    }


    /**
     * Sets the incidencias value for this ConsultarViajeResultado.
     * 
     * @param incidencias
     */
    public void setIncidencias(ar.com.unisolutions.PIncidencia[] incidencias) {
        this.incidencias = incidencias;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarViajeResultado)) return false;
        ConsultarViajeResultado other = (ConsultarViajeResultado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            this.viajeFinalizado == other.isViajeFinalizado() &&
            ((this.estadoViaje==null && other.getEstadoViaje()==null) || 
             (this.estadoViaje!=null &&
              this.estadoViaje.equals(other.getEstadoViaje()))) &&
            ((this.estadoSeguimiento==null && other.getEstadoSeguimiento()==null) || 
             (this.estadoSeguimiento!=null &&
              this.estadoSeguimiento.equals(other.getEstadoSeguimiento()))) &&
            ((this.vehiculoEstadoSeguimiento==null && other.getVehiculoEstadoSeguimiento()==null) || 
             (this.vehiculoEstadoSeguimiento!=null &&
              this.vehiculoEstadoSeguimiento.equals(other.getVehiculoEstadoSeguimiento()))) &&
            this.cantidadParadas == other.getCantidadParadas() &&
            this.paradaVisitada == other.getParadaVisitada() &&
            ((this.fechaParadaVisitada==null && other.getFechaParadaVisitada()==null) || 
             (this.fechaParadaVisitada!=null &&
              this.fechaParadaVisitada.equals(other.getFechaParadaVisitada()))) &&
            ((this.refCliente==null && other.getRefCliente()==null) || 
             (this.refCliente!=null &&
              this.refCliente.equals(other.getRefCliente()))) &&
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            ((this.refDocumentoAdicional==null && other.getRefDocumentoAdicional()==null) || 
             (this.refDocumentoAdicional!=null &&
              this.refDocumentoAdicional.equals(other.getRefDocumentoAdicional()))) &&
            ((this.kmsPlan==null && other.getKmsPlan()==null) || 
             (this.kmsPlan!=null &&
              this.kmsPlan.equals(other.getKmsPlan()))) &&
            ((this.kmsRecorridos==null && other.getKmsRecorridos()==null) || 
             (this.kmsRecorridos!=null &&
              this.kmsRecorridos.equals(other.getKmsRecorridos()))) &&
            ((this.fechaInicioReal==null && other.getFechaInicioReal()==null) || 
             (this.fechaInicioReal!=null &&
              this.fechaInicioReal.equals(other.getFechaInicioReal()))) &&
            ((this.fechaFinReal==null && other.getFechaFinReal()==null) || 
             (this.fechaFinReal!=null &&
              this.fechaFinReal.equals(other.getFechaFinReal()))) &&
            ((this.fechaInicioPlan==null && other.getFechaInicioPlan()==null) || 
             (this.fechaInicioPlan!=null &&
              this.fechaInicioPlan.equals(other.getFechaInicioPlan()))) &&
            ((this.fechaFinPlan==null && other.getFechaFinPlan()==null) || 
             (this.fechaFinPlan!=null &&
              this.fechaFinPlan.equals(other.getFechaFinPlan()))) &&
            ((this.depositoSalida==null && other.getDepositoSalida()==null) || 
             (this.depositoSalida!=null &&
              this.depositoSalida.equals(other.getDepositoSalida()))) &&
            ((this.depositoLlegada==null && other.getDepositoLlegada()==null) || 
             (this.depositoLlegada!=null &&
              this.depositoLlegada.equals(other.getDepositoLlegada()))) &&
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo()))) &&
            ((this.vehiculoSecundario==null && other.getVehiculoSecundario()==null) || 
             (this.vehiculoSecundario!=null &&
              this.vehiculoSecundario.equals(other.getVehiculoSecundario()))) &&
            ((this.vehiculoTerciario==null && other.getVehiculoTerciario()==null) || 
             (this.vehiculoTerciario!=null &&
              this.vehiculoTerciario.equals(other.getVehiculoTerciario()))) &&
            ((this.categoriaViaje==null && other.getCategoriaViaje()==null) || 
             (this.categoriaViaje!=null &&
              this.categoriaViaje.equals(other.getCategoriaViaje()))) &&
            ((this.tipoViaje==null && other.getTipoViaje()==null) || 
             (this.tipoViaje!=null &&
              this.tipoViaje.equals(other.getTipoViaje()))) &&
            ((this.recorrido==null && other.getRecorrido()==null) || 
             (this.recorrido!=null &&
              this.recorrido.equals(other.getRecorrido()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
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
            ((this.float1==null && other.getFloat1()==null) || 
             (this.float1!=null &&
              this.float1.equals(other.getFloat1()))) &&
            ((this.float2==null && other.getFloat2()==null) || 
             (this.float2!=null &&
              this.float2.equals(other.getFloat2()))) &&
            ((this.peso==null && other.getPeso()==null) || 
             (this.peso!=null &&
              this.peso.equals(other.getPeso()))) &&
            ((this.volumen==null && other.getVolumen()==null) || 
             (this.volumen!=null &&
              this.volumen.equals(other.getVolumen()))) &&
            ((this.bultos==null && other.getBultos()==null) || 
             (this.bultos!=null &&
              this.bultos.equals(other.getBultos()))) &&
            ((this.pallets==null && other.getPallets()==null) || 
             (this.pallets!=null &&
              this.pallets.equals(other.getPallets()))) &&
            ((this.conductor==null && other.getConductor()==null) || 
             (this.conductor!=null &&
              this.conductor.equals(other.getConductor()))) &&
            ((this.transporte==null && other.getTransporte()==null) || 
             (this.transporte!=null &&
              this.transporte.equals(other.getTransporte()))) &&
            ((this.recursosViaje==null && other.getRecursosViaje()==null) || 
             (this.recursosViaje!=null &&
              java.util.Arrays.equals(this.recursosViaje, other.getRecursosViaje()))) &&
            ((this.paradas==null && other.getParadas()==null) || 
             (this.paradas!=null &&
              java.util.Arrays.equals(this.paradas, other.getParadas()))) &&
            ((this.incidencias==null && other.getIncidencias()==null) || 
             (this.incidencias!=null &&
              java.util.Arrays.equals(this.incidencias, other.getIncidencias())));
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
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        _hashCode += (isViajeFinalizado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEstadoViaje() != null) {
            _hashCode += getEstadoViaje().hashCode();
        }
        if (getEstadoSeguimiento() != null) {
            _hashCode += getEstadoSeguimiento().hashCode();
        }
        if (getVehiculoEstadoSeguimiento() != null) {
            _hashCode += getVehiculoEstadoSeguimiento().hashCode();
        }
        _hashCode += getCantidadParadas();
        _hashCode += getParadaVisitada();
        if (getFechaParadaVisitada() != null) {
            _hashCode += getFechaParadaVisitada().hashCode();
        }
        if (getRefCliente() != null) {
            _hashCode += getRefCliente().hashCode();
        }
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getRefDocumentoAdicional() != null) {
            _hashCode += getRefDocumentoAdicional().hashCode();
        }
        if (getKmsPlan() != null) {
            _hashCode += getKmsPlan().hashCode();
        }
        if (getKmsRecorridos() != null) {
            _hashCode += getKmsRecorridos().hashCode();
        }
        if (getFechaInicioReal() != null) {
            _hashCode += getFechaInicioReal().hashCode();
        }
        if (getFechaFinReal() != null) {
            _hashCode += getFechaFinReal().hashCode();
        }
        if (getFechaInicioPlan() != null) {
            _hashCode += getFechaInicioPlan().hashCode();
        }
        if (getFechaFinPlan() != null) {
            _hashCode += getFechaFinPlan().hashCode();
        }
        if (getDepositoSalida() != null) {
            _hashCode += getDepositoSalida().hashCode();
        }
        if (getDepositoLlegada() != null) {
            _hashCode += getDepositoLlegada().hashCode();
        }
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        if (getVehiculoSecundario() != null) {
            _hashCode += getVehiculoSecundario().hashCode();
        }
        if (getVehiculoTerciario() != null) {
            _hashCode += getVehiculoTerciario().hashCode();
        }
        if (getCategoriaViaje() != null) {
            _hashCode += getCategoriaViaje().hashCode();
        }
        if (getTipoViaje() != null) {
            _hashCode += getTipoViaje().hashCode();
        }
        if (getRecorrido() != null) {
            _hashCode += getRecorrido().hashCode();
        }
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
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
        if (getFloat1() != null) {
            _hashCode += getFloat1().hashCode();
        }
        if (getFloat2() != null) {
            _hashCode += getFloat2().hashCode();
        }
        if (getPeso() != null) {
            _hashCode += getPeso().hashCode();
        }
        if (getVolumen() != null) {
            _hashCode += getVolumen().hashCode();
        }
        if (getBultos() != null) {
            _hashCode += getBultos().hashCode();
        }
        if (getPallets() != null) {
            _hashCode += getPallets().hashCode();
        }
        if (getConductor() != null) {
            _hashCode += getConductor().hashCode();
        }
        if (getTransporte() != null) {
            _hashCode += getTransporte().hashCode();
        }
        if (getRecursosViaje() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRecursosViaje());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRecursosViaje(), i);
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
        if (getIncidencias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIncidencias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIncidencias(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarViajeResultado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarViajeResultado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExterna"));
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
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viajeFinalizado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ViajeFinalizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoSeguimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoSeguimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoEstadoSeguimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculoEstadoSeguimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CantidadParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaVisitada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ParadaVisitada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaParadaVisitada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaParadaVisitada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("kmsPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "KmsPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kmsRecorridos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "KmsRecorridos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicioReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaInicioReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFinReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaFinReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicioPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaInicioPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFinPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaFinPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
        elemField.setFieldName("vehiculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Vehiculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoSecundario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculoSecundario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoTerciario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VehiculoTerciario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pVehiculo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoriaViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CategoriaViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("recorrido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Recorrido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("float2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Float2"));
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
        elemField.setFieldName("volumen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Volumen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bultos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Bultos"));
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
        elemField.setFieldName("conductor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"));
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
        elemField.setFieldName("recursosViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RecursosViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecurso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecurso"));
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
        elemField.setFieldName("incidencias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Incidencias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pIncidencia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pIncidencia"));
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
