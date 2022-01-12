/**
 * PRuta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PRuta  implements java.io.Serializable {
    private int idRuta;

    private ar.com.unisolutions.PVehiculo vehiculo;

    private ar.com.unisolutions.PVehiculo vehiculoSecundario;

    private ar.com.unisolutions.PDeposito depositoSalida;

    private ar.com.unisolutions.PDeposito despositoLlegada;

    private java.util.Calendar fechaHoraSalida;

    private java.util.Calendar fechaHoraLlegada;

    private java.util.Calendar fechaHoraCarga;

    private java.lang.String muelle;

    private java.lang.String conductor;

    private java.lang.String tipoVehiculo;

    private int ruta;

    private java.lang.String descripcion;

    private int cantidadOrdenes;

    private java.lang.String referenciaExterna;

    private int idViaje;

    private java.lang.String sucursal;

    private java.lang.String operacion;

    private java.lang.String estado;

    private java.lang.String estadoJornada;

    private long idJornada;

    private java.lang.Double bultos;

    private java.lang.Double peso;

    private java.lang.Double volumen;

    private java.lang.Double pallets;

    private java.lang.Double distancia;

    private java.lang.Double costo;

    private java.lang.Integer tiempo;

    private int numeroVuelta;

    private java.lang.String razonSocialTransporte;

    private java.lang.String CUIT_transporte;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.Integer int1;

    private java.lang.Integer int2;

    private java.lang.Float float1;

    private java.lang.Float float2;

    private int tiempoInactividad;

    private int inicioInactividad;

    private int finInactividad;

    private java.lang.Boolean copiarDescripcionOrdenes;

    private java.lang.Boolean pivotearPrimerVisita;

    private ar.com.unisolutions.PRecursos[] recursos;

    private ar.com.unisolutions.POrdenEntrega[] ordenes;

    private java.util.Calendar fechaHoraArribo;

    public PRuta() {
    }

    public PRuta(
           int idRuta,
           ar.com.unisolutions.PVehiculo vehiculo,
           ar.com.unisolutions.PVehiculo vehiculoSecundario,
           ar.com.unisolutions.PDeposito depositoSalida,
           ar.com.unisolutions.PDeposito despositoLlegada,
           java.util.Calendar fechaHoraSalida,
           java.util.Calendar fechaHoraLlegada,
           java.util.Calendar fechaHoraCarga,
           java.lang.String muelle,
           java.lang.String conductor,
           java.lang.String tipoVehiculo,
           int ruta,
           java.lang.String descripcion,
           int cantidadOrdenes,
           java.lang.String referenciaExterna,
           int idViaje,
           java.lang.String sucursal,
           java.lang.String operacion,
           java.lang.String estado,
           java.lang.String estadoJornada,
           long idJornada,
           java.lang.Double bultos,
           java.lang.Double peso,
           java.lang.Double volumen,
           java.lang.Double pallets,
           java.lang.Double distancia,
           java.lang.Double costo,
           java.lang.Integer tiempo,
           int numeroVuelta,
           java.lang.String razonSocialTransporte,
           java.lang.String CUIT_transporte,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.Integer int1,
           java.lang.Integer int2,
           java.lang.Float float1,
           java.lang.Float float2,
           int tiempoInactividad,
           int inicioInactividad,
           int finInactividad,
           java.lang.Boolean copiarDescripcionOrdenes,
           java.lang.Boolean pivotearPrimerVisita,
           ar.com.unisolutions.PRecursos[] recursos,
           ar.com.unisolutions.POrdenEntrega[] ordenes,
           java.util.Calendar fechaHoraArribo) {
           this.idRuta = idRuta;
           this.vehiculo = vehiculo;
           this.vehiculoSecundario = vehiculoSecundario;
           this.depositoSalida = depositoSalida;
           this.despositoLlegada = despositoLlegada;
           this.fechaHoraSalida = fechaHoraSalida;
           this.fechaHoraLlegada = fechaHoraLlegada;
           this.fechaHoraCarga = fechaHoraCarga;
           this.muelle = muelle;
           this.conductor = conductor;
           this.tipoVehiculo = tipoVehiculo;
           this.ruta = ruta;
           this.descripcion = descripcion;
           this.cantidadOrdenes = cantidadOrdenes;
           this.referenciaExterna = referenciaExterna;
           this.idViaje = idViaje;
           this.sucursal = sucursal;
           this.operacion = operacion;
           this.estado = estado;
           this.estadoJornada = estadoJornada;
           this.idJornada = idJornada;
           this.bultos = bultos;
           this.peso = peso;
           this.volumen = volumen;
           this.pallets = pallets;
           this.distancia = distancia;
           this.costo = costo;
           this.tiempo = tiempo;
           this.numeroVuelta = numeroVuelta;
           this.razonSocialTransporte = razonSocialTransporte;
           this.CUIT_transporte = CUIT_transporte;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.int1 = int1;
           this.int2 = int2;
           this.float1 = float1;
           this.float2 = float2;
           this.tiempoInactividad = tiempoInactividad;
           this.inicioInactividad = inicioInactividad;
           this.finInactividad = finInactividad;
           this.copiarDescripcionOrdenes = copiarDescripcionOrdenes;
           this.pivotearPrimerVisita = pivotearPrimerVisita;
           this.recursos = recursos;
           this.ordenes = ordenes;
           this.fechaHoraArribo = fechaHoraArribo;
    }


    /**
     * Gets the idRuta value for this PRuta.
     * 
     * @return idRuta
     */
    public int getIdRuta() {
        return idRuta;
    }


    /**
     * Sets the idRuta value for this PRuta.
     * 
     * @param idRuta
     */
    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }


    /**
     * Gets the vehiculo value for this PRuta.
     * 
     * @return vehiculo
     */
    public ar.com.unisolutions.PVehiculo getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this PRuta.
     * 
     * @param vehiculo
     */
    public void setVehiculo(ar.com.unisolutions.PVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the vehiculoSecundario value for this PRuta.
     * 
     * @return vehiculoSecundario
     */
    public ar.com.unisolutions.PVehiculo getVehiculoSecundario() {
        return vehiculoSecundario;
    }


    /**
     * Sets the vehiculoSecundario value for this PRuta.
     * 
     * @param vehiculoSecundario
     */
    public void setVehiculoSecundario(ar.com.unisolutions.PVehiculo vehiculoSecundario) {
        this.vehiculoSecundario = vehiculoSecundario;
    }


    /**
     * Gets the depositoSalida value for this PRuta.
     * 
     * @return depositoSalida
     */
    public ar.com.unisolutions.PDeposito getDepositoSalida() {
        return depositoSalida;
    }


    /**
     * Sets the depositoSalida value for this PRuta.
     * 
     * @param depositoSalida
     */
    public void setDepositoSalida(ar.com.unisolutions.PDeposito depositoSalida) {
        this.depositoSalida = depositoSalida;
    }


    /**
     * Gets the despositoLlegada value for this PRuta.
     * 
     * @return despositoLlegada
     */
    public ar.com.unisolutions.PDeposito getDespositoLlegada() {
        return despositoLlegada;
    }


    /**
     * Sets the despositoLlegada value for this PRuta.
     * 
     * @param despositoLlegada
     */
    public void setDespositoLlegada(ar.com.unisolutions.PDeposito despositoLlegada) {
        this.despositoLlegada = despositoLlegada;
    }


    /**
     * Gets the fechaHoraSalida value for this PRuta.
     * 
     * @return fechaHoraSalida
     */
    public java.util.Calendar getFechaHoraSalida() {
        return fechaHoraSalida;
    }


    /**
     * Sets the fechaHoraSalida value for this PRuta.
     * 
     * @param fechaHoraSalida
     */
    public void setFechaHoraSalida(java.util.Calendar fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }


    /**
     * Gets the fechaHoraLlegada value for this PRuta.
     * 
     * @return fechaHoraLlegada
     */
    public java.util.Calendar getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }


    /**
     * Sets the fechaHoraLlegada value for this PRuta.
     * 
     * @param fechaHoraLlegada
     */
    public void setFechaHoraLlegada(java.util.Calendar fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }


    /**
     * Gets the fechaHoraCarga value for this PRuta.
     * 
     * @return fechaHoraCarga
     */
    public java.util.Calendar getFechaHoraCarga() {
        return fechaHoraCarga;
    }


    /**
     * Sets the fechaHoraCarga value for this PRuta.
     * 
     * @param fechaHoraCarga
     */
    public void setFechaHoraCarga(java.util.Calendar fechaHoraCarga) {
        this.fechaHoraCarga = fechaHoraCarga;
    }


    /**
     * Gets the muelle value for this PRuta.
     * 
     * @return muelle
     */
    public java.lang.String getMuelle() {
        return muelle;
    }


    /**
     * Sets the muelle value for this PRuta.
     * 
     * @param muelle
     */
    public void setMuelle(java.lang.String muelle) {
        this.muelle = muelle;
    }


    /**
     * Gets the conductor value for this PRuta.
     * 
     * @return conductor
     */
    public java.lang.String getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this PRuta.
     * 
     * @param conductor
     */
    public void setConductor(java.lang.String conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the tipoVehiculo value for this PRuta.
     * 
     * @return tipoVehiculo
     */
    public java.lang.String getTipoVehiculo() {
        return tipoVehiculo;
    }


    /**
     * Sets the tipoVehiculo value for this PRuta.
     * 
     * @param tipoVehiculo
     */
    public void setTipoVehiculo(java.lang.String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }


    /**
     * Gets the ruta value for this PRuta.
     * 
     * @return ruta
     */
    public int getRuta() {
        return ruta;
    }


    /**
     * Sets the ruta value for this PRuta.
     * 
     * @param ruta
     */
    public void setRuta(int ruta) {
        this.ruta = ruta;
    }


    /**
     * Gets the descripcion value for this PRuta.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PRuta.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the cantidadOrdenes value for this PRuta.
     * 
     * @return cantidadOrdenes
     */
    public int getCantidadOrdenes() {
        return cantidadOrdenes;
    }


    /**
     * Sets the cantidadOrdenes value for this PRuta.
     * 
     * @param cantidadOrdenes
     */
    public void setCantidadOrdenes(int cantidadOrdenes) {
        this.cantidadOrdenes = cantidadOrdenes;
    }


    /**
     * Gets the referenciaExterna value for this PRuta.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this PRuta.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the idViaje value for this PRuta.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this PRuta.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the sucursal value for this PRuta.
     * 
     * @return sucursal
     */
    public java.lang.String getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this PRuta.
     * 
     * @param sucursal
     */
    public void setSucursal(java.lang.String sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the operacion value for this PRuta.
     * 
     * @return operacion
     */
    public java.lang.String getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this PRuta.
     * 
     * @param operacion
     */
    public void setOperacion(java.lang.String operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the estado value for this PRuta.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PRuta.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the estadoJornada value for this PRuta.
     * 
     * @return estadoJornada
     */
    public java.lang.String getEstadoJornada() {
        return estadoJornada;
    }


    /**
     * Sets the estadoJornada value for this PRuta.
     * 
     * @param estadoJornada
     */
    public void setEstadoJornada(java.lang.String estadoJornada) {
        this.estadoJornada = estadoJornada;
    }


    /**
     * Gets the idJornada value for this PRuta.
     * 
     * @return idJornada
     */
    public long getIdJornada() {
        return idJornada;
    }


    /**
     * Sets the idJornada value for this PRuta.
     * 
     * @param idJornada
     */
    public void setIdJornada(long idJornada) {
        this.idJornada = idJornada;
    }


    /**
     * Gets the bultos value for this PRuta.
     * 
     * @return bultos
     */
    public java.lang.Double getBultos() {
        return bultos;
    }


    /**
     * Sets the bultos value for this PRuta.
     * 
     * @param bultos
     */
    public void setBultos(java.lang.Double bultos) {
        this.bultos = bultos;
    }


    /**
     * Gets the peso value for this PRuta.
     * 
     * @return peso
     */
    public java.lang.Double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this PRuta.
     * 
     * @param peso
     */
    public void setPeso(java.lang.Double peso) {
        this.peso = peso;
    }


    /**
     * Gets the volumen value for this PRuta.
     * 
     * @return volumen
     */
    public java.lang.Double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this PRuta.
     * 
     * @param volumen
     */
    public void setVolumen(java.lang.Double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the pallets value for this PRuta.
     * 
     * @return pallets
     */
    public java.lang.Double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this PRuta.
     * 
     * @param pallets
     */
    public void setPallets(java.lang.Double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the distancia value for this PRuta.
     * 
     * @return distancia
     */
    public java.lang.Double getDistancia() {
        return distancia;
    }


    /**
     * Sets the distancia value for this PRuta.
     * 
     * @param distancia
     */
    public void setDistancia(java.lang.Double distancia) {
        this.distancia = distancia;
    }


    /**
     * Gets the costo value for this PRuta.
     * 
     * @return costo
     */
    public java.lang.Double getCosto() {
        return costo;
    }


    /**
     * Sets the costo value for this PRuta.
     * 
     * @param costo
     */
    public void setCosto(java.lang.Double costo) {
        this.costo = costo;
    }


    /**
     * Gets the tiempo value for this PRuta.
     * 
     * @return tiempo
     */
    public java.lang.Integer getTiempo() {
        return tiempo;
    }


    /**
     * Sets the tiempo value for this PRuta.
     * 
     * @param tiempo
     */
    public void setTiempo(java.lang.Integer tiempo) {
        this.tiempo = tiempo;
    }


    /**
     * Gets the numeroVuelta value for this PRuta.
     * 
     * @return numeroVuelta
     */
    public int getNumeroVuelta() {
        return numeroVuelta;
    }


    /**
     * Sets the numeroVuelta value for this PRuta.
     * 
     * @param numeroVuelta
     */
    public void setNumeroVuelta(int numeroVuelta) {
        this.numeroVuelta = numeroVuelta;
    }


    /**
     * Gets the razonSocialTransporte value for this PRuta.
     * 
     * @return razonSocialTransporte
     */
    public java.lang.String getRazonSocialTransporte() {
        return razonSocialTransporte;
    }


    /**
     * Sets the razonSocialTransporte value for this PRuta.
     * 
     * @param razonSocialTransporte
     */
    public void setRazonSocialTransporte(java.lang.String razonSocialTransporte) {
        this.razonSocialTransporte = razonSocialTransporte;
    }


    /**
     * Gets the CUIT_transporte value for this PRuta.
     * 
     * @return CUIT_transporte
     */
    public java.lang.String getCUIT_transporte() {
        return CUIT_transporte;
    }


    /**
     * Sets the CUIT_transporte value for this PRuta.
     * 
     * @param CUIT_transporte
     */
    public void setCUIT_transporte(java.lang.String CUIT_transporte) {
        this.CUIT_transporte = CUIT_transporte;
    }


    /**
     * Gets the varchar1 value for this PRuta.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this PRuta.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this PRuta.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this PRuta.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the int1 value for this PRuta.
     * 
     * @return int1
     */
    public java.lang.Integer getInt1() {
        return int1;
    }


    /**
     * Sets the int1 value for this PRuta.
     * 
     * @param int1
     */
    public void setInt1(java.lang.Integer int1) {
        this.int1 = int1;
    }


    /**
     * Gets the int2 value for this PRuta.
     * 
     * @return int2
     */
    public java.lang.Integer getInt2() {
        return int2;
    }


    /**
     * Sets the int2 value for this PRuta.
     * 
     * @param int2
     */
    public void setInt2(java.lang.Integer int2) {
        this.int2 = int2;
    }


    /**
     * Gets the float1 value for this PRuta.
     * 
     * @return float1
     */
    public java.lang.Float getFloat1() {
        return float1;
    }


    /**
     * Sets the float1 value for this PRuta.
     * 
     * @param float1
     */
    public void setFloat1(java.lang.Float float1) {
        this.float1 = float1;
    }


    /**
     * Gets the float2 value for this PRuta.
     * 
     * @return float2
     */
    public java.lang.Float getFloat2() {
        return float2;
    }


    /**
     * Sets the float2 value for this PRuta.
     * 
     * @param float2
     */
    public void setFloat2(java.lang.Float float2) {
        this.float2 = float2;
    }


    /**
     * Gets the tiempoInactividad value for this PRuta.
     * 
     * @return tiempoInactividad
     */
    public int getTiempoInactividad() {
        return tiempoInactividad;
    }


    /**
     * Sets the tiempoInactividad value for this PRuta.
     * 
     * @param tiempoInactividad
     */
    public void setTiempoInactividad(int tiempoInactividad) {
        this.tiempoInactividad = tiempoInactividad;
    }


    /**
     * Gets the inicioInactividad value for this PRuta.
     * 
     * @return inicioInactividad
     */
    public int getInicioInactividad() {
        return inicioInactividad;
    }


    /**
     * Sets the inicioInactividad value for this PRuta.
     * 
     * @param inicioInactividad
     */
    public void setInicioInactividad(int inicioInactividad) {
        this.inicioInactividad = inicioInactividad;
    }


    /**
     * Gets the finInactividad value for this PRuta.
     * 
     * @return finInactividad
     */
    public int getFinInactividad() {
        return finInactividad;
    }


    /**
     * Sets the finInactividad value for this PRuta.
     * 
     * @param finInactividad
     */
    public void setFinInactividad(int finInactividad) {
        this.finInactividad = finInactividad;
    }


    /**
     * Gets the copiarDescripcionOrdenes value for this PRuta.
     * 
     * @return copiarDescripcionOrdenes
     */
    public java.lang.Boolean getCopiarDescripcionOrdenes() {
        return copiarDescripcionOrdenes;
    }


    /**
     * Sets the copiarDescripcionOrdenes value for this PRuta.
     * 
     * @param copiarDescripcionOrdenes
     */
    public void setCopiarDescripcionOrdenes(java.lang.Boolean copiarDescripcionOrdenes) {
        this.copiarDescripcionOrdenes = copiarDescripcionOrdenes;
    }


    /**
     * Gets the pivotearPrimerVisita value for this PRuta.
     * 
     * @return pivotearPrimerVisita
     */
    public java.lang.Boolean getPivotearPrimerVisita() {
        return pivotearPrimerVisita;
    }


    /**
     * Sets the pivotearPrimerVisita value for this PRuta.
     * 
     * @param pivotearPrimerVisita
     */
    public void setPivotearPrimerVisita(java.lang.Boolean pivotearPrimerVisita) {
        this.pivotearPrimerVisita = pivotearPrimerVisita;
    }


    /**
     * Gets the recursos value for this PRuta.
     * 
     * @return recursos
     */
    public ar.com.unisolutions.PRecursos[] getRecursos() {
        return recursos;
    }


    /**
     * Sets the recursos value for this PRuta.
     * 
     * @param recursos
     */
    public void setRecursos(ar.com.unisolutions.PRecursos[] recursos) {
        this.recursos = recursos;
    }


    /**
     * Gets the ordenes value for this PRuta.
     * 
     * @return ordenes
     */
    public ar.com.unisolutions.POrdenEntrega[] getOrdenes() {
        return ordenes;
    }


    /**
     * Sets the ordenes value for this PRuta.
     * 
     * @param ordenes
     */
    public void setOrdenes(ar.com.unisolutions.POrdenEntrega[] ordenes) {
        this.ordenes = ordenes;
    }


    /**
     * Gets the fechaHoraArribo value for this PRuta.
     * 
     * @return fechaHoraArribo
     */
    public java.util.Calendar getFechaHoraArribo() {
        return fechaHoraArribo;
    }


    /**
     * Sets the fechaHoraArribo value for this PRuta.
     * 
     * @param fechaHoraArribo
     */
    public void setFechaHoraArribo(java.util.Calendar fechaHoraArribo) {
        this.fechaHoraArribo = fechaHoraArribo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PRuta)) return false;
        PRuta other = (PRuta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idRuta == other.getIdRuta() &&
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo()))) &&
            ((this.vehiculoSecundario==null && other.getVehiculoSecundario()==null) || 
             (this.vehiculoSecundario!=null &&
              this.vehiculoSecundario.equals(other.getVehiculoSecundario()))) &&
            ((this.depositoSalida==null && other.getDepositoSalida()==null) || 
             (this.depositoSalida!=null &&
              this.depositoSalida.equals(other.getDepositoSalida()))) &&
            ((this.despositoLlegada==null && other.getDespositoLlegada()==null) || 
             (this.despositoLlegada!=null &&
              this.despositoLlegada.equals(other.getDespositoLlegada()))) &&
            ((this.fechaHoraSalida==null && other.getFechaHoraSalida()==null) || 
             (this.fechaHoraSalida!=null &&
              this.fechaHoraSalida.equals(other.getFechaHoraSalida()))) &&
            ((this.fechaHoraLlegada==null && other.getFechaHoraLlegada()==null) || 
             (this.fechaHoraLlegada!=null &&
              this.fechaHoraLlegada.equals(other.getFechaHoraLlegada()))) &&
            ((this.fechaHoraCarga==null && other.getFechaHoraCarga()==null) || 
             (this.fechaHoraCarga!=null &&
              this.fechaHoraCarga.equals(other.getFechaHoraCarga()))) &&
            ((this.muelle==null && other.getMuelle()==null) || 
             (this.muelle!=null &&
              this.muelle.equals(other.getMuelle()))) &&
            ((this.conductor==null && other.getConductor()==null) || 
             (this.conductor!=null &&
              this.conductor.equals(other.getConductor()))) &&
            ((this.tipoVehiculo==null && other.getTipoVehiculo()==null) || 
             (this.tipoVehiculo!=null &&
              this.tipoVehiculo.equals(other.getTipoVehiculo()))) &&
            this.ruta == other.getRuta() &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.cantidadOrdenes == other.getCantidadOrdenes() &&
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            this.idViaje == other.getIdViaje() &&
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.estadoJornada==null && other.getEstadoJornada()==null) || 
             (this.estadoJornada!=null &&
              this.estadoJornada.equals(other.getEstadoJornada()))) &&
            this.idJornada == other.getIdJornada() &&
            ((this.bultos==null && other.getBultos()==null) || 
             (this.bultos!=null &&
              this.bultos.equals(other.getBultos()))) &&
            ((this.peso==null && other.getPeso()==null) || 
             (this.peso!=null &&
              this.peso.equals(other.getPeso()))) &&
            ((this.volumen==null && other.getVolumen()==null) || 
             (this.volumen!=null &&
              this.volumen.equals(other.getVolumen()))) &&
            ((this.pallets==null && other.getPallets()==null) || 
             (this.pallets!=null &&
              this.pallets.equals(other.getPallets()))) &&
            ((this.distancia==null && other.getDistancia()==null) || 
             (this.distancia!=null &&
              this.distancia.equals(other.getDistancia()))) &&
            ((this.costo==null && other.getCosto()==null) || 
             (this.costo!=null &&
              this.costo.equals(other.getCosto()))) &&
            ((this.tiempo==null && other.getTiempo()==null) || 
             (this.tiempo!=null &&
              this.tiempo.equals(other.getTiempo()))) &&
            this.numeroVuelta == other.getNumeroVuelta() &&
            ((this.razonSocialTransporte==null && other.getRazonSocialTransporte()==null) || 
             (this.razonSocialTransporte!=null &&
              this.razonSocialTransporte.equals(other.getRazonSocialTransporte()))) &&
            ((this.CUIT_transporte==null && other.getCUIT_transporte()==null) || 
             (this.CUIT_transporte!=null &&
              this.CUIT_transporte.equals(other.getCUIT_transporte()))) &&
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
            ((this.float1==null && other.getFloat1()==null) || 
             (this.float1!=null &&
              this.float1.equals(other.getFloat1()))) &&
            ((this.float2==null && other.getFloat2()==null) || 
             (this.float2!=null &&
              this.float2.equals(other.getFloat2()))) &&
            this.tiempoInactividad == other.getTiempoInactividad() &&
            this.inicioInactividad == other.getInicioInactividad() &&
            this.finInactividad == other.getFinInactividad() &&
            ((this.copiarDescripcionOrdenes==null && other.getCopiarDescripcionOrdenes()==null) || 
             (this.copiarDescripcionOrdenes!=null &&
              this.copiarDescripcionOrdenes.equals(other.getCopiarDescripcionOrdenes()))) &&
            ((this.pivotearPrimerVisita==null && other.getPivotearPrimerVisita()==null) || 
             (this.pivotearPrimerVisita!=null &&
              this.pivotearPrimerVisita.equals(other.getPivotearPrimerVisita()))) &&
            ((this.recursos==null && other.getRecursos()==null) || 
             (this.recursos!=null &&
              java.util.Arrays.equals(this.recursos, other.getRecursos()))) &&
            ((this.ordenes==null && other.getOrdenes()==null) || 
             (this.ordenes!=null &&
              java.util.Arrays.equals(this.ordenes, other.getOrdenes()))) &&
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
        _hashCode += getIdRuta();
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        if (getVehiculoSecundario() != null) {
            _hashCode += getVehiculoSecundario().hashCode();
        }
        if (getDepositoSalida() != null) {
            _hashCode += getDepositoSalida().hashCode();
        }
        if (getDespositoLlegada() != null) {
            _hashCode += getDespositoLlegada().hashCode();
        }
        if (getFechaHoraSalida() != null) {
            _hashCode += getFechaHoraSalida().hashCode();
        }
        if (getFechaHoraLlegada() != null) {
            _hashCode += getFechaHoraLlegada().hashCode();
        }
        if (getFechaHoraCarga() != null) {
            _hashCode += getFechaHoraCarga().hashCode();
        }
        if (getMuelle() != null) {
            _hashCode += getMuelle().hashCode();
        }
        if (getConductor() != null) {
            _hashCode += getConductor().hashCode();
        }
        if (getTipoVehiculo() != null) {
            _hashCode += getTipoVehiculo().hashCode();
        }
        _hashCode += getRuta();
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += getCantidadOrdenes();
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        _hashCode += getIdViaje();
        if (getSucursal() != null) {
            _hashCode += getSucursal().hashCode();
        }
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getEstadoJornada() != null) {
            _hashCode += getEstadoJornada().hashCode();
        }
        _hashCode += new Long(getIdJornada()).hashCode();
        if (getBultos() != null) {
            _hashCode += getBultos().hashCode();
        }
        if (getPeso() != null) {
            _hashCode += getPeso().hashCode();
        }
        if (getVolumen() != null) {
            _hashCode += getVolumen().hashCode();
        }
        if (getPallets() != null) {
            _hashCode += getPallets().hashCode();
        }
        if (getDistancia() != null) {
            _hashCode += getDistancia().hashCode();
        }
        if (getCosto() != null) {
            _hashCode += getCosto().hashCode();
        }
        if (getTiempo() != null) {
            _hashCode += getTiempo().hashCode();
        }
        _hashCode += getNumeroVuelta();
        if (getRazonSocialTransporte() != null) {
            _hashCode += getRazonSocialTransporte().hashCode();
        }
        if (getCUIT_transporte() != null) {
            _hashCode += getCUIT_transporte().hashCode();
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
        if (getFloat1() != null) {
            _hashCode += getFloat1().hashCode();
        }
        if (getFloat2() != null) {
            _hashCode += getFloat2().hashCode();
        }
        _hashCode += getTiempoInactividad();
        _hashCode += getInicioInactividad();
        _hashCode += getFinInactividad();
        if (getCopiarDescripcionOrdenes() != null) {
            _hashCode += getCopiarDescripcionOrdenes().hashCode();
        }
        if (getPivotearPrimerVisita() != null) {
            _hashCode += getPivotearPrimerVisita().hashCode();
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
        if (getOrdenes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrdenes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrdenes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFechaHoraArribo() != null) {
            _hashCode += getFechaHoraArribo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PRuta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRuta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRuta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdRuta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("despositoLlegada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DespositoLlegada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraSalida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHoraSalida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraLlegada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHoraLlegada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHoraCarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("muelle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Muelle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conductor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductor"));
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
        elemField.setFieldName("ruta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("cantidadOrdenes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CantidadOrdenes"));
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
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoJornada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoJornada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idJornada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdJornada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bultos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Bultos"));
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
        elemField.setFieldName("pallets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pallets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Distancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Tiempo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroVuelta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "NumeroVuelta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocialTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RazonSocialTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CUIT_transporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CUIT_transporte"));
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
        elemField.setFieldName("tiempoInactividad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoInactividad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioInactividad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioInactividad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finInactividad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinInactividad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("copiarDescripcionOrdenes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CopiarDescripcionOrdenes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pivotearPrimerVisita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PivotearPrimerVisita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
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
        elemField.setFieldName("ordenes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ordenes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
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
