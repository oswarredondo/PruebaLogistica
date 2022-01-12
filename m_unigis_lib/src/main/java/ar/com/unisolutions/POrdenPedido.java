/**
 * POrdenPedido.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class POrdenPedido  implements java.io.Serializable {
    private java.lang.String refDocumento;

    private java.lang.String refDocumentoAdicional;

    private java.lang.String refDocumentoAdicional2;

    private java.util.Calendar fecha;

    private java.util.Calendar fechaEntrega;

    private java.util.Calendar fechaEntregaOriginal;

    private ar.com.unisolutions.PCliente cliente;

    private ar.com.unisolutions.PCliente cliente2;

    private java.lang.String telefono;

    private java.lang.String telefono2;

    private java.lang.String telefono3;

    private java.lang.String descripcion;

    private java.lang.String codigoSucursal;

    private java.lang.String tipoPedido;

    private java.lang.String estado;

    private java.lang.String estadoOrdenEntrega;

    private java.lang.String direccion;

    private java.lang.String calle;

    private java.lang.String nroPuerta;

    private java.lang.String entreCalle;

    private java.lang.String barrio;

    private java.lang.String localidad;

    private java.lang.String partido;

    private java.lang.String provincia;

    private java.lang.String pais;

    private java.lang.Integer inicioHorario1;

    private java.lang.Integer finHorario1;

    private java.lang.Integer inicioHorario2;

    private java.lang.Integer finHorario2;

    private java.lang.Integer tiempoEspera;

    private java.lang.Double volumen;

    private java.lang.Double peso;

    private java.lang.Double bulto;

    private java.lang.Double pallets;

    private java.lang.Double distancia;

    private java.lang.Double latitud;

    private java.lang.Double longitud;

    private java.lang.String observaciones;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String varchar3;

    private java.lang.String varchar4;

    private java.lang.String varchar5;

    private java.lang.String varchar6;

    private java.lang.String varchar7;

    private java.lang.String varchar8;

    private java.lang.String varchar9;

    private java.lang.String b2CPassword;

    private java.lang.Integer int1;

    private java.lang.Integer int2;

    private java.lang.String email;

    private java.lang.String tipo;

    private java.lang.String tipoCanal;

    private java.lang.String tipoVerificacion;

    private java.lang.String referenciaOrden;

    private ar.com.unisolutions.PCliente clienteDador;

    private java.lang.String categoria;

    private java.lang.String prioridad;

    private java.lang.Boolean cargaExclusiva;

    private java.lang.Boolean requiereTurno;

    private java.lang.Boolean ultimaVisita;

    private java.lang.Boolean requiereAbasto;

    private ar.com.unisolutions.PDeposito depositoSalida;

    private ar.com.unisolutions.PDeposito depositoLlegada;

    private java.lang.String codigoPostal;

    private java.lang.String codigoOperacion;

    private java.lang.String urlB2C;

    private ar.com.unisolutions.PUnidadContenedora contenedor;

    private ar.com.unisolutions.PEstadoOrdenPedido estadoDetalle;

    private ar.com.unisolutions.PPedidoTurno turnoPedido;

    private ar.com.unisolutions.PServicioAdicional[] serviciosAdicionales;

    private ar.com.unisolutions.POrdenPedidoItem[] items;

    private ar.com.unisolutions.POrdenPedidoTipoVehiculo[] tiposVehiculos;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private ar.com.unisolutions.PRecursos[] recursos;

    private ar.com.unisolutions.PDocumento[] documentos;

    private ar.com.unisolutions.PEstados[] estadosPedido;

    private java.lang.String descripcion2;

    private java.lang.String direccion2;

    private java.lang.String calle2;

    private java.lang.String nroPuerta2;

    private java.lang.String entreCalle2;

    private java.lang.String barrio2;

    private java.lang.String localidad2;

    private java.lang.String partido2;

    private java.lang.String provincia2;

    private java.lang.String pais2;

    private java.lang.Integer idPedido;

    private java.util.Calendar fechaRecoleccion;

    private java.lang.Boolean usarProductos;

    private java.lang.Boolean soloInsertarProductos;

    private java.lang.Boolean agruparItems;

    private java.lang.Integer grupoRutas;

    private java.lang.Integer inicioHorarioRecoleccion1;

    private java.lang.Integer inicioHorarioRecoleccion2;

    private java.lang.Integer finHorarioRecoleccion1;

    private java.lang.Integer finHorarioRecoleccion2;

    private java.util.Calendar datetime1;

    private java.util.Calendar datetime2;

    private java.util.Calendar datetime3;

    private java.lang.Double unidades;

    private java.lang.Double valorDeclarado;

    private java.lang.Double float1;

    private java.lang.Double float2;

    private java.lang.Double float3;

    private java.lang.Double float4;

    private java.util.Calendar vigenciaDesde;

    private java.util.Calendar vigenciaHasta;

    private java.lang.Double latitud2;

    private java.lang.Double longitud2;

    private java.lang.Integer tiempoEspera2;

    public POrdenPedido() {
    }

    public POrdenPedido(
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           java.lang.String refDocumentoAdicional2,
           java.util.Calendar fecha,
           java.util.Calendar fechaEntrega,
           java.util.Calendar fechaEntregaOriginal,
           ar.com.unisolutions.PCliente cliente,
           ar.com.unisolutions.PCliente cliente2,
           java.lang.String telefono,
           java.lang.String telefono2,
           java.lang.String telefono3,
           java.lang.String descripcion,
           java.lang.String codigoSucursal,
           java.lang.String tipoPedido,
           java.lang.String estado,
           java.lang.String estadoOrdenEntrega,
           java.lang.String direccion,
           java.lang.String calle,
           java.lang.String nroPuerta,
           java.lang.String entreCalle,
           java.lang.String barrio,
           java.lang.String localidad,
           java.lang.String partido,
           java.lang.String provincia,
           java.lang.String pais,
           java.lang.Integer inicioHorario1,
           java.lang.Integer finHorario1,
           java.lang.Integer inicioHorario2,
           java.lang.Integer finHorario2,
           java.lang.Integer tiempoEspera,
           java.lang.Double volumen,
           java.lang.Double peso,
           java.lang.Double bulto,
           java.lang.Double pallets,
           java.lang.Double distancia,
           java.lang.Double latitud,
           java.lang.Double longitud,
           java.lang.String observaciones,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           java.lang.String varchar4,
           java.lang.String varchar5,
           java.lang.String varchar6,
           java.lang.String varchar7,
           java.lang.String varchar8,
           java.lang.String varchar9,
           java.lang.String b2CPassword,
           java.lang.Integer int1,
           java.lang.Integer int2,
           java.lang.String email,
           java.lang.String tipo,
           java.lang.String tipoCanal,
           java.lang.String tipoVerificacion,
           java.lang.String referenciaOrden,
           ar.com.unisolutions.PCliente clienteDador,
           java.lang.String categoria,
           java.lang.String prioridad,
           java.lang.Boolean cargaExclusiva,
           java.lang.Boolean requiereTurno,
           java.lang.Boolean ultimaVisita,
           java.lang.Boolean requiereAbasto,
           ar.com.unisolutions.PDeposito depositoSalida,
           ar.com.unisolutions.PDeposito depositoLlegada,
           java.lang.String codigoPostal,
           java.lang.String codigoOperacion,
           java.lang.String urlB2C,
           ar.com.unisolutions.PUnidadContenedora contenedor,
           ar.com.unisolutions.PEstadoOrdenPedido estadoDetalle,
           ar.com.unisolutions.PPedidoTurno turnoPedido,
           ar.com.unisolutions.PServicioAdicional[] serviciosAdicionales,
           ar.com.unisolutions.POrdenPedidoItem[] items,
           ar.com.unisolutions.POrdenPedidoTipoVehiculo[] tiposVehiculos,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           ar.com.unisolutions.PRecursos[] recursos,
           ar.com.unisolutions.PDocumento[] documentos,
           ar.com.unisolutions.PEstados[] estadosPedido,
           java.lang.String descripcion2,
           java.lang.String direccion2,
           java.lang.String calle2,
           java.lang.String nroPuerta2,
           java.lang.String entreCalle2,
           java.lang.String barrio2,
           java.lang.String localidad2,
           java.lang.String partido2,
           java.lang.String provincia2,
           java.lang.String pais2,
           java.lang.Integer idPedido,
           java.util.Calendar fechaRecoleccion,
           java.lang.Boolean usarProductos,
           java.lang.Boolean soloInsertarProductos,
           java.lang.Boolean agruparItems,
           java.lang.Integer grupoRutas,
           java.lang.Integer inicioHorarioRecoleccion1,
           java.lang.Integer inicioHorarioRecoleccion2,
           java.lang.Integer finHorarioRecoleccion1,
           java.lang.Integer finHorarioRecoleccion2,
           java.util.Calendar datetime1,
           java.util.Calendar datetime2,
           java.util.Calendar datetime3,
           java.lang.Double unidades,
           java.lang.Double valorDeclarado,
           java.lang.Double float1,
           java.lang.Double float2,
           java.lang.Double float3,
           java.lang.Double float4,
           java.util.Calendar vigenciaDesde,
           java.util.Calendar vigenciaHasta,
           java.lang.Double latitud2,
           java.lang.Double longitud2,
           java.lang.Integer tiempoEspera2) {
           this.refDocumento = refDocumento;
           this.refDocumentoAdicional = refDocumentoAdicional;
           this.refDocumentoAdicional2 = refDocumentoAdicional2;
           this.fecha = fecha;
           this.fechaEntrega = fechaEntrega;
           this.fechaEntregaOriginal = fechaEntregaOriginal;
           this.cliente = cliente;
           this.cliente2 = cliente2;
           this.telefono = telefono;
           this.telefono2 = telefono2;
           this.telefono3 = telefono3;
           this.descripcion = descripcion;
           this.codigoSucursal = codigoSucursal;
           this.tipoPedido = tipoPedido;
           this.estado = estado;
           this.estadoOrdenEntrega = estadoOrdenEntrega;
           this.direccion = direccion;
           this.calle = calle;
           this.nroPuerta = nroPuerta;
           this.entreCalle = entreCalle;
           this.barrio = barrio;
           this.localidad = localidad;
           this.partido = partido;
           this.provincia = provincia;
           this.pais = pais;
           this.inicioHorario1 = inicioHorario1;
           this.finHorario1 = finHorario1;
           this.inicioHorario2 = inicioHorario2;
           this.finHorario2 = finHorario2;
           this.tiempoEspera = tiempoEspera;
           this.volumen = volumen;
           this.peso = peso;
           this.bulto = bulto;
           this.pallets = pallets;
           this.distancia = distancia;
           this.latitud = latitud;
           this.longitud = longitud;
           this.observaciones = observaciones;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.varchar3 = varchar3;
           this.varchar4 = varchar4;
           this.varchar5 = varchar5;
           this.varchar6 = varchar6;
           this.varchar7 = varchar7;
           this.varchar8 = varchar8;
           this.varchar9 = varchar9;
           this.b2CPassword = b2CPassword;
           this.int1 = int1;
           this.int2 = int2;
           this.email = email;
           this.tipo = tipo;
           this.tipoCanal = tipoCanal;
           this.tipoVerificacion = tipoVerificacion;
           this.referenciaOrden = referenciaOrden;
           this.clienteDador = clienteDador;
           this.categoria = categoria;
           this.prioridad = prioridad;
           this.cargaExclusiva = cargaExclusiva;
           this.requiereTurno = requiereTurno;
           this.ultimaVisita = ultimaVisita;
           this.requiereAbasto = requiereAbasto;
           this.depositoSalida = depositoSalida;
           this.depositoLlegada = depositoLlegada;
           this.codigoPostal = codigoPostal;
           this.codigoOperacion = codigoOperacion;
           this.urlB2C = urlB2C;
           this.contenedor = contenedor;
           this.estadoDetalle = estadoDetalle;
           this.turnoPedido = turnoPedido;
           this.serviciosAdicionales = serviciosAdicionales;
           this.items = items;
           this.tiposVehiculos = tiposVehiculos;
           this.campoDinamico = campoDinamico;
           this.recursos = recursos;
           this.documentos = documentos;
           this.estadosPedido = estadosPedido;
           this.descripcion2 = descripcion2;
           this.direccion2 = direccion2;
           this.calle2 = calle2;
           this.nroPuerta2 = nroPuerta2;
           this.entreCalle2 = entreCalle2;
           this.barrio2 = barrio2;
           this.localidad2 = localidad2;
           this.partido2 = partido2;
           this.provincia2 = provincia2;
           this.pais2 = pais2;
           this.idPedido = idPedido;
           this.fechaRecoleccion = fechaRecoleccion;
           this.usarProductos = usarProductos;
           this.soloInsertarProductos = soloInsertarProductos;
           this.agruparItems = agruparItems;
           this.grupoRutas = grupoRutas;
           this.inicioHorarioRecoleccion1 = inicioHorarioRecoleccion1;
           this.inicioHorarioRecoleccion2 = inicioHorarioRecoleccion2;
           this.finHorarioRecoleccion1 = finHorarioRecoleccion1;
           this.finHorarioRecoleccion2 = finHorarioRecoleccion2;
           this.datetime1 = datetime1;
           this.datetime2 = datetime2;
           this.datetime3 = datetime3;
           this.unidades = unidades;
           this.valorDeclarado = valorDeclarado;
           this.float1 = float1;
           this.float2 = float2;
           this.float3 = float3;
           this.float4 = float4;
           this.vigenciaDesde = vigenciaDesde;
           this.vigenciaHasta = vigenciaHasta;
           this.latitud2 = latitud2;
           this.longitud2 = longitud2;
           this.tiempoEspera2 = tiempoEspera2;
    }


    /**
     * Gets the refDocumento value for this POrdenPedido.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this POrdenPedido.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the refDocumentoAdicional value for this POrdenPedido.
     * 
     * @return refDocumentoAdicional
     */
    public java.lang.String getRefDocumentoAdicional() {
        return refDocumentoAdicional;
    }


    /**
     * Sets the refDocumentoAdicional value for this POrdenPedido.
     * 
     * @param refDocumentoAdicional
     */
    public void setRefDocumentoAdicional(java.lang.String refDocumentoAdicional) {
        this.refDocumentoAdicional = refDocumentoAdicional;
    }


    /**
     * Gets the refDocumentoAdicional2 value for this POrdenPedido.
     * 
     * @return refDocumentoAdicional2
     */
    public java.lang.String getRefDocumentoAdicional2() {
        return refDocumentoAdicional2;
    }


    /**
     * Sets the refDocumentoAdicional2 value for this POrdenPedido.
     * 
     * @param refDocumentoAdicional2
     */
    public void setRefDocumentoAdicional2(java.lang.String refDocumentoAdicional2) {
        this.refDocumentoAdicional2 = refDocumentoAdicional2;
    }


    /**
     * Gets the fecha value for this POrdenPedido.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this POrdenPedido.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the fechaEntrega value for this POrdenPedido.
     * 
     * @return fechaEntrega
     */
    public java.util.Calendar getFechaEntrega() {
        return fechaEntrega;
    }


    /**
     * Sets the fechaEntrega value for this POrdenPedido.
     * 
     * @param fechaEntrega
     */
    public void setFechaEntrega(java.util.Calendar fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }


    /**
     * Gets the fechaEntregaOriginal value for this POrdenPedido.
     * 
     * @return fechaEntregaOriginal
     */
    public java.util.Calendar getFechaEntregaOriginal() {
        return fechaEntregaOriginal;
    }


    /**
     * Sets the fechaEntregaOriginal value for this POrdenPedido.
     * 
     * @param fechaEntregaOriginal
     */
    public void setFechaEntregaOriginal(java.util.Calendar fechaEntregaOriginal) {
        this.fechaEntregaOriginal = fechaEntregaOriginal;
    }


    /**
     * Gets the cliente value for this POrdenPedido.
     * 
     * @return cliente
     */
    public ar.com.unisolutions.PCliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this POrdenPedido.
     * 
     * @param cliente
     */
    public void setCliente(ar.com.unisolutions.PCliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the cliente2 value for this POrdenPedido.
     * 
     * @return cliente2
     */
    public ar.com.unisolutions.PCliente getCliente2() {
        return cliente2;
    }


    /**
     * Sets the cliente2 value for this POrdenPedido.
     * 
     * @param cliente2
     */
    public void setCliente2(ar.com.unisolutions.PCliente cliente2) {
        this.cliente2 = cliente2;
    }


    /**
     * Gets the telefono value for this POrdenPedido.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this POrdenPedido.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the telefono2 value for this POrdenPedido.
     * 
     * @return telefono2
     */
    public java.lang.String getTelefono2() {
        return telefono2;
    }


    /**
     * Sets the telefono2 value for this POrdenPedido.
     * 
     * @param telefono2
     */
    public void setTelefono2(java.lang.String telefono2) {
        this.telefono2 = telefono2;
    }


    /**
     * Gets the telefono3 value for this POrdenPedido.
     * 
     * @return telefono3
     */
    public java.lang.String getTelefono3() {
        return telefono3;
    }


    /**
     * Sets the telefono3 value for this POrdenPedido.
     * 
     * @param telefono3
     */
    public void setTelefono3(java.lang.String telefono3) {
        this.telefono3 = telefono3;
    }


    /**
     * Gets the descripcion value for this POrdenPedido.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this POrdenPedido.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the codigoSucursal value for this POrdenPedido.
     * 
     * @return codigoSucursal
     */
    public java.lang.String getCodigoSucursal() {
        return codigoSucursal;
    }


    /**
     * Sets the codigoSucursal value for this POrdenPedido.
     * 
     * @param codigoSucursal
     */
    public void setCodigoSucursal(java.lang.String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }


    /**
     * Gets the tipoPedido value for this POrdenPedido.
     * 
     * @return tipoPedido
     */
    public java.lang.String getTipoPedido() {
        return tipoPedido;
    }


    /**
     * Sets the tipoPedido value for this POrdenPedido.
     * 
     * @param tipoPedido
     */
    public void setTipoPedido(java.lang.String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }


    /**
     * Gets the estado value for this POrdenPedido.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this POrdenPedido.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the estadoOrdenEntrega value for this POrdenPedido.
     * 
     * @return estadoOrdenEntrega
     */
    public java.lang.String getEstadoOrdenEntrega() {
        return estadoOrdenEntrega;
    }


    /**
     * Sets the estadoOrdenEntrega value for this POrdenPedido.
     * 
     * @param estadoOrdenEntrega
     */
    public void setEstadoOrdenEntrega(java.lang.String estadoOrdenEntrega) {
        this.estadoOrdenEntrega = estadoOrdenEntrega;
    }


    /**
     * Gets the direccion value for this POrdenPedido.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this POrdenPedido.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the calle value for this POrdenPedido.
     * 
     * @return calle
     */
    public java.lang.String getCalle() {
        return calle;
    }


    /**
     * Sets the calle value for this POrdenPedido.
     * 
     * @param calle
     */
    public void setCalle(java.lang.String calle) {
        this.calle = calle;
    }


    /**
     * Gets the nroPuerta value for this POrdenPedido.
     * 
     * @return nroPuerta
     */
    public java.lang.String getNroPuerta() {
        return nroPuerta;
    }


    /**
     * Sets the nroPuerta value for this POrdenPedido.
     * 
     * @param nroPuerta
     */
    public void setNroPuerta(java.lang.String nroPuerta) {
        this.nroPuerta = nroPuerta;
    }


    /**
     * Gets the entreCalle value for this POrdenPedido.
     * 
     * @return entreCalle
     */
    public java.lang.String getEntreCalle() {
        return entreCalle;
    }


    /**
     * Sets the entreCalle value for this POrdenPedido.
     * 
     * @param entreCalle
     */
    public void setEntreCalle(java.lang.String entreCalle) {
        this.entreCalle = entreCalle;
    }


    /**
     * Gets the barrio value for this POrdenPedido.
     * 
     * @return barrio
     */
    public java.lang.String getBarrio() {
        return barrio;
    }


    /**
     * Sets the barrio value for this POrdenPedido.
     * 
     * @param barrio
     */
    public void setBarrio(java.lang.String barrio) {
        this.barrio = barrio;
    }


    /**
     * Gets the localidad value for this POrdenPedido.
     * 
     * @return localidad
     */
    public java.lang.String getLocalidad() {
        return localidad;
    }


    /**
     * Sets the localidad value for this POrdenPedido.
     * 
     * @param localidad
     */
    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }


    /**
     * Gets the partido value for this POrdenPedido.
     * 
     * @return partido
     */
    public java.lang.String getPartido() {
        return partido;
    }


    /**
     * Sets the partido value for this POrdenPedido.
     * 
     * @param partido
     */
    public void setPartido(java.lang.String partido) {
        this.partido = partido;
    }


    /**
     * Gets the provincia value for this POrdenPedido.
     * 
     * @return provincia
     */
    public java.lang.String getProvincia() {
        return provincia;
    }


    /**
     * Sets the provincia value for this POrdenPedido.
     * 
     * @param provincia
     */
    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }


    /**
     * Gets the pais value for this POrdenPedido.
     * 
     * @return pais
     */
    public java.lang.String getPais() {
        return pais;
    }


    /**
     * Sets the pais value for this POrdenPedido.
     * 
     * @param pais
     */
    public void setPais(java.lang.String pais) {
        this.pais = pais;
    }


    /**
     * Gets the inicioHorario1 value for this POrdenPedido.
     * 
     * @return inicioHorario1
     */
    public java.lang.Integer getInicioHorario1() {
        return inicioHorario1;
    }


    /**
     * Sets the inicioHorario1 value for this POrdenPedido.
     * 
     * @param inicioHorario1
     */
    public void setInicioHorario1(java.lang.Integer inicioHorario1) {
        this.inicioHorario1 = inicioHorario1;
    }


    /**
     * Gets the finHorario1 value for this POrdenPedido.
     * 
     * @return finHorario1
     */
    public java.lang.Integer getFinHorario1() {
        return finHorario1;
    }


    /**
     * Sets the finHorario1 value for this POrdenPedido.
     * 
     * @param finHorario1
     */
    public void setFinHorario1(java.lang.Integer finHorario1) {
        this.finHorario1 = finHorario1;
    }


    /**
     * Gets the inicioHorario2 value for this POrdenPedido.
     * 
     * @return inicioHorario2
     */
    public java.lang.Integer getInicioHorario2() {
        return inicioHorario2;
    }


    /**
     * Sets the inicioHorario2 value for this POrdenPedido.
     * 
     * @param inicioHorario2
     */
    public void setInicioHorario2(java.lang.Integer inicioHorario2) {
        this.inicioHorario2 = inicioHorario2;
    }


    /**
     * Gets the finHorario2 value for this POrdenPedido.
     * 
     * @return finHorario2
     */
    public java.lang.Integer getFinHorario2() {
        return finHorario2;
    }


    /**
     * Sets the finHorario2 value for this POrdenPedido.
     * 
     * @param finHorario2
     */
    public void setFinHorario2(java.lang.Integer finHorario2) {
        this.finHorario2 = finHorario2;
    }


    /**
     * Gets the tiempoEspera value for this POrdenPedido.
     * 
     * @return tiempoEspera
     */
    public java.lang.Integer getTiempoEspera() {
        return tiempoEspera;
    }


    /**
     * Sets the tiempoEspera value for this POrdenPedido.
     * 
     * @param tiempoEspera
     */
    public void setTiempoEspera(java.lang.Integer tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }


    /**
     * Gets the volumen value for this POrdenPedido.
     * 
     * @return volumen
     */
    public java.lang.Double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this POrdenPedido.
     * 
     * @param volumen
     */
    public void setVolumen(java.lang.Double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this POrdenPedido.
     * 
     * @return peso
     */
    public java.lang.Double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this POrdenPedido.
     * 
     * @param peso
     */
    public void setPeso(java.lang.Double peso) {
        this.peso = peso;
    }


    /**
     * Gets the bulto value for this POrdenPedido.
     * 
     * @return bulto
     */
    public java.lang.Double getBulto() {
        return bulto;
    }


    /**
     * Sets the bulto value for this POrdenPedido.
     * 
     * @param bulto
     */
    public void setBulto(java.lang.Double bulto) {
        this.bulto = bulto;
    }


    /**
     * Gets the pallets value for this POrdenPedido.
     * 
     * @return pallets
     */
    public java.lang.Double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this POrdenPedido.
     * 
     * @param pallets
     */
    public void setPallets(java.lang.Double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the distancia value for this POrdenPedido.
     * 
     * @return distancia
     */
    public java.lang.Double getDistancia() {
        return distancia;
    }


    /**
     * Sets the distancia value for this POrdenPedido.
     * 
     * @param distancia
     */
    public void setDistancia(java.lang.Double distancia) {
        this.distancia = distancia;
    }


    /**
     * Gets the latitud value for this POrdenPedido.
     * 
     * @return latitud
     */
    public java.lang.Double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this POrdenPedido.
     * 
     * @param latitud
     */
    public void setLatitud(java.lang.Double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this POrdenPedido.
     * 
     * @return longitud
     */
    public java.lang.Double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this POrdenPedido.
     * 
     * @param longitud
     */
    public void setLongitud(java.lang.Double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the observaciones value for this POrdenPedido.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this POrdenPedido.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the varchar1 value for this POrdenPedido.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this POrdenPedido.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this POrdenPedido.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this POrdenPedido.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the varchar3 value for this POrdenPedido.
     * 
     * @return varchar3
     */
    public java.lang.String getVarchar3() {
        return varchar3;
    }


    /**
     * Sets the varchar3 value for this POrdenPedido.
     * 
     * @param varchar3
     */
    public void setVarchar3(java.lang.String varchar3) {
        this.varchar3 = varchar3;
    }


    /**
     * Gets the varchar4 value for this POrdenPedido.
     * 
     * @return varchar4
     */
    public java.lang.String getVarchar4() {
        return varchar4;
    }


    /**
     * Sets the varchar4 value for this POrdenPedido.
     * 
     * @param varchar4
     */
    public void setVarchar4(java.lang.String varchar4) {
        this.varchar4 = varchar4;
    }


    /**
     * Gets the varchar5 value for this POrdenPedido.
     * 
     * @return varchar5
     */
    public java.lang.String getVarchar5() {
        return varchar5;
    }


    /**
     * Sets the varchar5 value for this POrdenPedido.
     * 
     * @param varchar5
     */
    public void setVarchar5(java.lang.String varchar5) {
        this.varchar5 = varchar5;
    }


    /**
     * Gets the varchar6 value for this POrdenPedido.
     * 
     * @return varchar6
     */
    public java.lang.String getVarchar6() {
        return varchar6;
    }


    /**
     * Sets the varchar6 value for this POrdenPedido.
     * 
     * @param varchar6
     */
    public void setVarchar6(java.lang.String varchar6) {
        this.varchar6 = varchar6;
    }


    /**
     * Gets the varchar7 value for this POrdenPedido.
     * 
     * @return varchar7
     */
    public java.lang.String getVarchar7() {
        return varchar7;
    }


    /**
     * Sets the varchar7 value for this POrdenPedido.
     * 
     * @param varchar7
     */
    public void setVarchar7(java.lang.String varchar7) {
        this.varchar7 = varchar7;
    }


    /**
     * Gets the varchar8 value for this POrdenPedido.
     * 
     * @return varchar8
     */
    public java.lang.String getVarchar8() {
        return varchar8;
    }


    /**
     * Sets the varchar8 value for this POrdenPedido.
     * 
     * @param varchar8
     */
    public void setVarchar8(java.lang.String varchar8) {
        this.varchar8 = varchar8;
    }


    /**
     * Gets the varchar9 value for this POrdenPedido.
     * 
     * @return varchar9
     */
    public java.lang.String getVarchar9() {
        return varchar9;
    }


    /**
     * Sets the varchar9 value for this POrdenPedido.
     * 
     * @param varchar9
     */
    public void setVarchar9(java.lang.String varchar9) {
        this.varchar9 = varchar9;
    }


    /**
     * Gets the b2CPassword value for this POrdenPedido.
     * 
     * @return b2CPassword
     */
    public java.lang.String getB2CPassword() {
        return b2CPassword;
    }


    /**
     * Sets the b2CPassword value for this POrdenPedido.
     * 
     * @param b2CPassword
     */
    public void setB2CPassword(java.lang.String b2CPassword) {
        this.b2CPassword = b2CPassword;
    }


    /**
     * Gets the int1 value for this POrdenPedido.
     * 
     * @return int1
     */
    public java.lang.Integer getInt1() {
        return int1;
    }


    /**
     * Sets the int1 value for this POrdenPedido.
     * 
     * @param int1
     */
    public void setInt1(java.lang.Integer int1) {
        this.int1 = int1;
    }


    /**
     * Gets the int2 value for this POrdenPedido.
     * 
     * @return int2
     */
    public java.lang.Integer getInt2() {
        return int2;
    }


    /**
     * Sets the int2 value for this POrdenPedido.
     * 
     * @param int2
     */
    public void setInt2(java.lang.Integer int2) {
        this.int2 = int2;
    }


    /**
     * Gets the email value for this POrdenPedido.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this POrdenPedido.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the tipo value for this POrdenPedido.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this POrdenPedido.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the tipoCanal value for this POrdenPedido.
     * 
     * @return tipoCanal
     */
    public java.lang.String getTipoCanal() {
        return tipoCanal;
    }


    /**
     * Sets the tipoCanal value for this POrdenPedido.
     * 
     * @param tipoCanal
     */
    public void setTipoCanal(java.lang.String tipoCanal) {
        this.tipoCanal = tipoCanal;
    }


    /**
     * Gets the tipoVerificacion value for this POrdenPedido.
     * 
     * @return tipoVerificacion
     */
    public java.lang.String getTipoVerificacion() {
        return tipoVerificacion;
    }


    /**
     * Sets the tipoVerificacion value for this POrdenPedido.
     * 
     * @param tipoVerificacion
     */
    public void setTipoVerificacion(java.lang.String tipoVerificacion) {
        this.tipoVerificacion = tipoVerificacion;
    }


    /**
     * Gets the referenciaOrden value for this POrdenPedido.
     * 
     * @return referenciaOrden
     */
    public java.lang.String getReferenciaOrden() {
        return referenciaOrden;
    }


    /**
     * Sets the referenciaOrden value for this POrdenPedido.
     * 
     * @param referenciaOrden
     */
    public void setReferenciaOrden(java.lang.String referenciaOrden) {
        this.referenciaOrden = referenciaOrden;
    }


    /**
     * Gets the clienteDador value for this POrdenPedido.
     * 
     * @return clienteDador
     */
    public ar.com.unisolutions.PCliente getClienteDador() {
        return clienteDador;
    }


    /**
     * Sets the clienteDador value for this POrdenPedido.
     * 
     * @param clienteDador
     */
    public void setClienteDador(ar.com.unisolutions.PCliente clienteDador) {
        this.clienteDador = clienteDador;
    }


    /**
     * Gets the categoria value for this POrdenPedido.
     * 
     * @return categoria
     */
    public java.lang.String getCategoria() {
        return categoria;
    }


    /**
     * Sets the categoria value for this POrdenPedido.
     * 
     * @param categoria
     */
    public void setCategoria(java.lang.String categoria) {
        this.categoria = categoria;
    }


    /**
     * Gets the prioridad value for this POrdenPedido.
     * 
     * @return prioridad
     */
    public java.lang.String getPrioridad() {
        return prioridad;
    }


    /**
     * Sets the prioridad value for this POrdenPedido.
     * 
     * @param prioridad
     */
    public void setPrioridad(java.lang.String prioridad) {
        this.prioridad = prioridad;
    }


    /**
     * Gets the cargaExclusiva value for this POrdenPedido.
     * 
     * @return cargaExclusiva
     */
    public java.lang.Boolean getCargaExclusiva() {
        return cargaExclusiva;
    }


    /**
     * Sets the cargaExclusiva value for this POrdenPedido.
     * 
     * @param cargaExclusiva
     */
    public void setCargaExclusiva(java.lang.Boolean cargaExclusiva) {
        this.cargaExclusiva = cargaExclusiva;
    }


    /**
     * Gets the requiereTurno value for this POrdenPedido.
     * 
     * @return requiereTurno
     */
    public java.lang.Boolean getRequiereTurno() {
        return requiereTurno;
    }


    /**
     * Sets the requiereTurno value for this POrdenPedido.
     * 
     * @param requiereTurno
     */
    public void setRequiereTurno(java.lang.Boolean requiereTurno) {
        this.requiereTurno = requiereTurno;
    }


    /**
     * Gets the ultimaVisita value for this POrdenPedido.
     * 
     * @return ultimaVisita
     */
    public java.lang.Boolean getUltimaVisita() {
        return ultimaVisita;
    }


    /**
     * Sets the ultimaVisita value for this POrdenPedido.
     * 
     * @param ultimaVisita
     */
    public void setUltimaVisita(java.lang.Boolean ultimaVisita) {
        this.ultimaVisita = ultimaVisita;
    }


    /**
     * Gets the requiereAbasto value for this POrdenPedido.
     * 
     * @return requiereAbasto
     */
    public java.lang.Boolean getRequiereAbasto() {
        return requiereAbasto;
    }


    /**
     * Sets the requiereAbasto value for this POrdenPedido.
     * 
     * @param requiereAbasto
     */
    public void setRequiereAbasto(java.lang.Boolean requiereAbasto) {
        this.requiereAbasto = requiereAbasto;
    }


    /**
     * Gets the depositoSalida value for this POrdenPedido.
     * 
     * @return depositoSalida
     */
    public ar.com.unisolutions.PDeposito getDepositoSalida() {
        return depositoSalida;
    }


    /**
     * Sets the depositoSalida value for this POrdenPedido.
     * 
     * @param depositoSalida
     */
    public void setDepositoSalida(ar.com.unisolutions.PDeposito depositoSalida) {
        this.depositoSalida = depositoSalida;
    }


    /**
     * Gets the depositoLlegada value for this POrdenPedido.
     * 
     * @return depositoLlegada
     */
    public ar.com.unisolutions.PDeposito getDepositoLlegada() {
        return depositoLlegada;
    }


    /**
     * Sets the depositoLlegada value for this POrdenPedido.
     * 
     * @param depositoLlegada
     */
    public void setDepositoLlegada(ar.com.unisolutions.PDeposito depositoLlegada) {
        this.depositoLlegada = depositoLlegada;
    }


    /**
     * Gets the codigoPostal value for this POrdenPedido.
     * 
     * @return codigoPostal
     */
    public java.lang.String getCodigoPostal() {
        return codigoPostal;
    }


    /**
     * Sets the codigoPostal value for this POrdenPedido.
     * 
     * @param codigoPostal
     */
    public void setCodigoPostal(java.lang.String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    /**
     * Gets the codigoOperacion value for this POrdenPedido.
     * 
     * @return codigoOperacion
     */
    public java.lang.String getCodigoOperacion() {
        return codigoOperacion;
    }


    /**
     * Sets the codigoOperacion value for this POrdenPedido.
     * 
     * @param codigoOperacion
     */
    public void setCodigoOperacion(java.lang.String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }


    /**
     * Gets the urlB2C value for this POrdenPedido.
     * 
     * @return urlB2C
     */
    public java.lang.String getUrlB2C() {
        return urlB2C;
    }


    /**
     * Sets the urlB2C value for this POrdenPedido.
     * 
     * @param urlB2C
     */
    public void setUrlB2C(java.lang.String urlB2C) {
        this.urlB2C = urlB2C;
    }


    /**
     * Gets the contenedor value for this POrdenPedido.
     * 
     * @return contenedor
     */
    public ar.com.unisolutions.PUnidadContenedora getContenedor() {
        return contenedor;
    }


    /**
     * Sets the contenedor value for this POrdenPedido.
     * 
     * @param contenedor
     */
    public void setContenedor(ar.com.unisolutions.PUnidadContenedora contenedor) {
        this.contenedor = contenedor;
    }


    /**
     * Gets the estadoDetalle value for this POrdenPedido.
     * 
     * @return estadoDetalle
     */
    public ar.com.unisolutions.PEstadoOrdenPedido getEstadoDetalle() {
        return estadoDetalle;
    }


    /**
     * Sets the estadoDetalle value for this POrdenPedido.
     * 
     * @param estadoDetalle
     */
    public void setEstadoDetalle(ar.com.unisolutions.PEstadoOrdenPedido estadoDetalle) {
        this.estadoDetalle = estadoDetalle;
    }


    /**
     * Gets the turnoPedido value for this POrdenPedido.
     * 
     * @return turnoPedido
     */
    public ar.com.unisolutions.PPedidoTurno getTurnoPedido() {
        return turnoPedido;
    }


    /**
     * Sets the turnoPedido value for this POrdenPedido.
     * 
     * @param turnoPedido
     */
    public void setTurnoPedido(ar.com.unisolutions.PPedidoTurno turnoPedido) {
        this.turnoPedido = turnoPedido;
    }


    /**
     * Gets the serviciosAdicionales value for this POrdenPedido.
     * 
     * @return serviciosAdicionales
     */
    public ar.com.unisolutions.PServicioAdicional[] getServiciosAdicionales() {
        return serviciosAdicionales;
    }


    /**
     * Sets the serviciosAdicionales value for this POrdenPedido.
     * 
     * @param serviciosAdicionales
     */
    public void setServiciosAdicionales(ar.com.unisolutions.PServicioAdicional[] serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }


    /**
     * Gets the items value for this POrdenPedido.
     * 
     * @return items
     */
    public ar.com.unisolutions.POrdenPedidoItem[] getItems() {
        return items;
    }


    /**
     * Sets the items value for this POrdenPedido.
     * 
     * @param items
     */
    public void setItems(ar.com.unisolutions.POrdenPedidoItem[] items) {
        this.items = items;
    }


    /**
     * Gets the tiposVehiculos value for this POrdenPedido.
     * 
     * @return tiposVehiculos
     */
    public ar.com.unisolutions.POrdenPedidoTipoVehiculo[] getTiposVehiculos() {
        return tiposVehiculos;
    }


    /**
     * Sets the tiposVehiculos value for this POrdenPedido.
     * 
     * @param tiposVehiculos
     */
    public void setTiposVehiculos(ar.com.unisolutions.POrdenPedidoTipoVehiculo[] tiposVehiculos) {
        this.tiposVehiculos = tiposVehiculos;
    }


    /**
     * Gets the campoDinamico value for this POrdenPedido.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this POrdenPedido.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the recursos value for this POrdenPedido.
     * 
     * @return recursos
     */
    public ar.com.unisolutions.PRecursos[] getRecursos() {
        return recursos;
    }


    /**
     * Sets the recursos value for this POrdenPedido.
     * 
     * @param recursos
     */
    public void setRecursos(ar.com.unisolutions.PRecursos[] recursos) {
        this.recursos = recursos;
    }


    /**
     * Gets the documentos value for this POrdenPedido.
     * 
     * @return documentos
     */
    public ar.com.unisolutions.PDocumento[] getDocumentos() {
        return documentos;
    }


    /**
     * Sets the documentos value for this POrdenPedido.
     * 
     * @param documentos
     */
    public void setDocumentos(ar.com.unisolutions.PDocumento[] documentos) {
        this.documentos = documentos;
    }


    /**
     * Gets the estadosPedido value for this POrdenPedido.
     * 
     * @return estadosPedido
     */
    public ar.com.unisolutions.PEstados[] getEstadosPedido() {
        return estadosPedido;
    }


    /**
     * Sets the estadosPedido value for this POrdenPedido.
     * 
     * @param estadosPedido
     */
    public void setEstadosPedido(ar.com.unisolutions.PEstados[] estadosPedido) {
        this.estadosPedido = estadosPedido;
    }


    /**
     * Gets the descripcion2 value for this POrdenPedido.
     * 
     * @return descripcion2
     */
    public java.lang.String getDescripcion2() {
        return descripcion2;
    }


    /**
     * Sets the descripcion2 value for this POrdenPedido.
     * 
     * @param descripcion2
     */
    public void setDescripcion2(java.lang.String descripcion2) {
        this.descripcion2 = descripcion2;
    }


    /**
     * Gets the direccion2 value for this POrdenPedido.
     * 
     * @return direccion2
     */
    public java.lang.String getDireccion2() {
        return direccion2;
    }


    /**
     * Sets the direccion2 value for this POrdenPedido.
     * 
     * @param direccion2
     */
    public void setDireccion2(java.lang.String direccion2) {
        this.direccion2 = direccion2;
    }


    /**
     * Gets the calle2 value for this POrdenPedido.
     * 
     * @return calle2
     */
    public java.lang.String getCalle2() {
        return calle2;
    }


    /**
     * Sets the calle2 value for this POrdenPedido.
     * 
     * @param calle2
     */
    public void setCalle2(java.lang.String calle2) {
        this.calle2 = calle2;
    }


    /**
     * Gets the nroPuerta2 value for this POrdenPedido.
     * 
     * @return nroPuerta2
     */
    public java.lang.String getNroPuerta2() {
        return nroPuerta2;
    }


    /**
     * Sets the nroPuerta2 value for this POrdenPedido.
     * 
     * @param nroPuerta2
     */
    public void setNroPuerta2(java.lang.String nroPuerta2) {
        this.nroPuerta2 = nroPuerta2;
    }


    /**
     * Gets the entreCalle2 value for this POrdenPedido.
     * 
     * @return entreCalle2
     */
    public java.lang.String getEntreCalle2() {
        return entreCalle2;
    }


    /**
     * Sets the entreCalle2 value for this POrdenPedido.
     * 
     * @param entreCalle2
     */
    public void setEntreCalle2(java.lang.String entreCalle2) {
        this.entreCalle2 = entreCalle2;
    }


    /**
     * Gets the barrio2 value for this POrdenPedido.
     * 
     * @return barrio2
     */
    public java.lang.String getBarrio2() {
        return barrio2;
    }


    /**
     * Sets the barrio2 value for this POrdenPedido.
     * 
     * @param barrio2
     */
    public void setBarrio2(java.lang.String barrio2) {
        this.barrio2 = barrio2;
    }


    /**
     * Gets the localidad2 value for this POrdenPedido.
     * 
     * @return localidad2
     */
    public java.lang.String getLocalidad2() {
        return localidad2;
    }


    /**
     * Sets the localidad2 value for this POrdenPedido.
     * 
     * @param localidad2
     */
    public void setLocalidad2(java.lang.String localidad2) {
        this.localidad2 = localidad2;
    }


    /**
     * Gets the partido2 value for this POrdenPedido.
     * 
     * @return partido2
     */
    public java.lang.String getPartido2() {
        return partido2;
    }


    /**
     * Sets the partido2 value for this POrdenPedido.
     * 
     * @param partido2
     */
    public void setPartido2(java.lang.String partido2) {
        this.partido2 = partido2;
    }


    /**
     * Gets the provincia2 value for this POrdenPedido.
     * 
     * @return provincia2
     */
    public java.lang.String getProvincia2() {
        return provincia2;
    }


    /**
     * Sets the provincia2 value for this POrdenPedido.
     * 
     * @param provincia2
     */
    public void setProvincia2(java.lang.String provincia2) {
        this.provincia2 = provincia2;
    }


    /**
     * Gets the pais2 value for this POrdenPedido.
     * 
     * @return pais2
     */
    public java.lang.String getPais2() {
        return pais2;
    }


    /**
     * Sets the pais2 value for this POrdenPedido.
     * 
     * @param pais2
     */
    public void setPais2(java.lang.String pais2) {
        this.pais2 = pais2;
    }


    /**
     * Gets the idPedido value for this POrdenPedido.
     * 
     * @return idPedido
     */
    public java.lang.Integer getIdPedido() {
        return idPedido;
    }


    /**
     * Sets the idPedido value for this POrdenPedido.
     * 
     * @param idPedido
     */
    public void setIdPedido(java.lang.Integer idPedido) {
        this.idPedido = idPedido;
    }


    /**
     * Gets the fechaRecoleccion value for this POrdenPedido.
     * 
     * @return fechaRecoleccion
     */
    public java.util.Calendar getFechaRecoleccion() {
        return fechaRecoleccion;
    }


    /**
     * Sets the fechaRecoleccion value for this POrdenPedido.
     * 
     * @param fechaRecoleccion
     */
    public void setFechaRecoleccion(java.util.Calendar fechaRecoleccion) {
        this.fechaRecoleccion = fechaRecoleccion;
    }


    /**
     * Gets the usarProductos value for this POrdenPedido.
     * 
     * @return usarProductos
     */
    public java.lang.Boolean getUsarProductos() {
        return usarProductos;
    }


    /**
     * Sets the usarProductos value for this POrdenPedido.
     * 
     * @param usarProductos
     */
    public void setUsarProductos(java.lang.Boolean usarProductos) {
        this.usarProductos = usarProductos;
    }


    /**
     * Gets the soloInsertarProductos value for this POrdenPedido.
     * 
     * @return soloInsertarProductos
     */
    public java.lang.Boolean getSoloInsertarProductos() {
        return soloInsertarProductos;
    }


    /**
     * Sets the soloInsertarProductos value for this POrdenPedido.
     * 
     * @param soloInsertarProductos
     */
    public void setSoloInsertarProductos(java.lang.Boolean soloInsertarProductos) {
        this.soloInsertarProductos = soloInsertarProductos;
    }


    /**
     * Gets the agruparItems value for this POrdenPedido.
     * 
     * @return agruparItems
     */
    public java.lang.Boolean getAgruparItems() {
        return agruparItems;
    }


    /**
     * Sets the agruparItems value for this POrdenPedido.
     * 
     * @param agruparItems
     */
    public void setAgruparItems(java.lang.Boolean agruparItems) {
        this.agruparItems = agruparItems;
    }


    /**
     * Gets the grupoRutas value for this POrdenPedido.
     * 
     * @return grupoRutas
     */
    public java.lang.Integer getGrupoRutas() {
        return grupoRutas;
    }


    /**
     * Sets the grupoRutas value for this POrdenPedido.
     * 
     * @param grupoRutas
     */
    public void setGrupoRutas(java.lang.Integer grupoRutas) {
        this.grupoRutas = grupoRutas;
    }


    /**
     * Gets the inicioHorarioRecoleccion1 value for this POrdenPedido.
     * 
     * @return inicioHorarioRecoleccion1
     */
    public java.lang.Integer getInicioHorarioRecoleccion1() {
        return inicioHorarioRecoleccion1;
    }


    /**
     * Sets the inicioHorarioRecoleccion1 value for this POrdenPedido.
     * 
     * @param inicioHorarioRecoleccion1
     */
    public void setInicioHorarioRecoleccion1(java.lang.Integer inicioHorarioRecoleccion1) {
        this.inicioHorarioRecoleccion1 = inicioHorarioRecoleccion1;
    }


    /**
     * Gets the inicioHorarioRecoleccion2 value for this POrdenPedido.
     * 
     * @return inicioHorarioRecoleccion2
     */
    public java.lang.Integer getInicioHorarioRecoleccion2() {
        return inicioHorarioRecoleccion2;
    }


    /**
     * Sets the inicioHorarioRecoleccion2 value for this POrdenPedido.
     * 
     * @param inicioHorarioRecoleccion2
     */
    public void setInicioHorarioRecoleccion2(java.lang.Integer inicioHorarioRecoleccion2) {
        this.inicioHorarioRecoleccion2 = inicioHorarioRecoleccion2;
    }


    /**
     * Gets the finHorarioRecoleccion1 value for this POrdenPedido.
     * 
     * @return finHorarioRecoleccion1
     */
    public java.lang.Integer getFinHorarioRecoleccion1() {
        return finHorarioRecoleccion1;
    }


    /**
     * Sets the finHorarioRecoleccion1 value for this POrdenPedido.
     * 
     * @param finHorarioRecoleccion1
     */
    public void setFinHorarioRecoleccion1(java.lang.Integer finHorarioRecoleccion1) {
        this.finHorarioRecoleccion1 = finHorarioRecoleccion1;
    }


    /**
     * Gets the finHorarioRecoleccion2 value for this POrdenPedido.
     * 
     * @return finHorarioRecoleccion2
     */
    public java.lang.Integer getFinHorarioRecoleccion2() {
        return finHorarioRecoleccion2;
    }


    /**
     * Sets the finHorarioRecoleccion2 value for this POrdenPedido.
     * 
     * @param finHorarioRecoleccion2
     */
    public void setFinHorarioRecoleccion2(java.lang.Integer finHorarioRecoleccion2) {
        this.finHorarioRecoleccion2 = finHorarioRecoleccion2;
    }


    /**
     * Gets the datetime1 value for this POrdenPedido.
     * 
     * @return datetime1
     */
    public java.util.Calendar getDatetime1() {
        return datetime1;
    }


    /**
     * Sets the datetime1 value for this POrdenPedido.
     * 
     * @param datetime1
     */
    public void setDatetime1(java.util.Calendar datetime1) {
        this.datetime1 = datetime1;
    }


    /**
     * Gets the datetime2 value for this POrdenPedido.
     * 
     * @return datetime2
     */
    public java.util.Calendar getDatetime2() {
        return datetime2;
    }


    /**
     * Sets the datetime2 value for this POrdenPedido.
     * 
     * @param datetime2
     */
    public void setDatetime2(java.util.Calendar datetime2) {
        this.datetime2 = datetime2;
    }


    /**
     * Gets the datetime3 value for this POrdenPedido.
     * 
     * @return datetime3
     */
    public java.util.Calendar getDatetime3() {
        return datetime3;
    }


    /**
     * Sets the datetime3 value for this POrdenPedido.
     * 
     * @param datetime3
     */
    public void setDatetime3(java.util.Calendar datetime3) {
        this.datetime3 = datetime3;
    }


    /**
     * Gets the unidades value for this POrdenPedido.
     * 
     * @return unidades
     */
    public java.lang.Double getUnidades() {
        return unidades;
    }


    /**
     * Sets the unidades value for this POrdenPedido.
     * 
     * @param unidades
     */
    public void setUnidades(java.lang.Double unidades) {
        this.unidades = unidades;
    }


    /**
     * Gets the valorDeclarado value for this POrdenPedido.
     * 
     * @return valorDeclarado
     */
    public java.lang.Double getValorDeclarado() {
        return valorDeclarado;
    }


    /**
     * Sets the valorDeclarado value for this POrdenPedido.
     * 
     * @param valorDeclarado
     */
    public void setValorDeclarado(java.lang.Double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }


    /**
     * Gets the float1 value for this POrdenPedido.
     * 
     * @return float1
     */
    public java.lang.Double getFloat1() {
        return float1;
    }


    /**
     * Sets the float1 value for this POrdenPedido.
     * 
     * @param float1
     */
    public void setFloat1(java.lang.Double float1) {
        this.float1 = float1;
    }


    /**
     * Gets the float2 value for this POrdenPedido.
     * 
     * @return float2
     */
    public java.lang.Double getFloat2() {
        return float2;
    }


    /**
     * Sets the float2 value for this POrdenPedido.
     * 
     * @param float2
     */
    public void setFloat2(java.lang.Double float2) {
        this.float2 = float2;
    }


    /**
     * Gets the float3 value for this POrdenPedido.
     * 
     * @return float3
     */
    public java.lang.Double getFloat3() {
        return float3;
    }


    /**
     * Sets the float3 value for this POrdenPedido.
     * 
     * @param float3
     */
    public void setFloat3(java.lang.Double float3) {
        this.float3 = float3;
    }


    /**
     * Gets the float4 value for this POrdenPedido.
     * 
     * @return float4
     */
    public java.lang.Double getFloat4() {
        return float4;
    }


    /**
     * Sets the float4 value for this POrdenPedido.
     * 
     * @param float4
     */
    public void setFloat4(java.lang.Double float4) {
        this.float4 = float4;
    }


    /**
     * Gets the vigenciaDesde value for this POrdenPedido.
     * 
     * @return vigenciaDesde
     */
    public java.util.Calendar getVigenciaDesde() {
        return vigenciaDesde;
    }


    /**
     * Sets the vigenciaDesde value for this POrdenPedido.
     * 
     * @param vigenciaDesde
     */
    public void setVigenciaDesde(java.util.Calendar vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }


    /**
     * Gets the vigenciaHasta value for this POrdenPedido.
     * 
     * @return vigenciaHasta
     */
    public java.util.Calendar getVigenciaHasta() {
        return vigenciaHasta;
    }


    /**
     * Sets the vigenciaHasta value for this POrdenPedido.
     * 
     * @param vigenciaHasta
     */
    public void setVigenciaHasta(java.util.Calendar vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }


    /**
     * Gets the latitud2 value for this POrdenPedido.
     * 
     * @return latitud2
     */
    public java.lang.Double getLatitud2() {
        return latitud2;
    }


    /**
     * Sets the latitud2 value for this POrdenPedido.
     * 
     * @param latitud2
     */
    public void setLatitud2(java.lang.Double latitud2) {
        this.latitud2 = latitud2;
    }


    /**
     * Gets the longitud2 value for this POrdenPedido.
     * 
     * @return longitud2
     */
    public java.lang.Double getLongitud2() {
        return longitud2;
    }


    /**
     * Sets the longitud2 value for this POrdenPedido.
     * 
     * @param longitud2
     */
    public void setLongitud2(java.lang.Double longitud2) {
        this.longitud2 = longitud2;
    }


    /**
     * Gets the tiempoEspera2 value for this POrdenPedido.
     * 
     * @return tiempoEspera2
     */
    public java.lang.Integer getTiempoEspera2() {
        return tiempoEspera2;
    }


    /**
     * Sets the tiempoEspera2 value for this POrdenPedido.
     * 
     * @param tiempoEspera2
     */
    public void setTiempoEspera2(java.lang.Integer tiempoEspera2) {
        this.tiempoEspera2 = tiempoEspera2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POrdenPedido)) return false;
        POrdenPedido other = (POrdenPedido) obj;
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
            ((this.refDocumentoAdicional2==null && other.getRefDocumentoAdicional2()==null) || 
             (this.refDocumentoAdicional2!=null &&
              this.refDocumentoAdicional2.equals(other.getRefDocumentoAdicional2()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.fechaEntrega==null && other.getFechaEntrega()==null) || 
             (this.fechaEntrega!=null &&
              this.fechaEntrega.equals(other.getFechaEntrega()))) &&
            ((this.fechaEntregaOriginal==null && other.getFechaEntregaOriginal()==null) || 
             (this.fechaEntregaOriginal!=null &&
              this.fechaEntregaOriginal.equals(other.getFechaEntregaOriginal()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.cliente2==null && other.getCliente2()==null) || 
             (this.cliente2!=null &&
              this.cliente2.equals(other.getCliente2()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.telefono2==null && other.getTelefono2()==null) || 
             (this.telefono2!=null &&
              this.telefono2.equals(other.getTelefono2()))) &&
            ((this.telefono3==null && other.getTelefono3()==null) || 
             (this.telefono3!=null &&
              this.telefono3.equals(other.getTelefono3()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.codigoSucursal==null && other.getCodigoSucursal()==null) || 
             (this.codigoSucursal!=null &&
              this.codigoSucursal.equals(other.getCodigoSucursal()))) &&
            ((this.tipoPedido==null && other.getTipoPedido()==null) || 
             (this.tipoPedido!=null &&
              this.tipoPedido.equals(other.getTipoPedido()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.estadoOrdenEntrega==null && other.getEstadoOrdenEntrega()==null) || 
             (this.estadoOrdenEntrega!=null &&
              this.estadoOrdenEntrega.equals(other.getEstadoOrdenEntrega()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.calle==null && other.getCalle()==null) || 
             (this.calle!=null &&
              this.calle.equals(other.getCalle()))) &&
            ((this.nroPuerta==null && other.getNroPuerta()==null) || 
             (this.nroPuerta!=null &&
              this.nroPuerta.equals(other.getNroPuerta()))) &&
            ((this.entreCalle==null && other.getEntreCalle()==null) || 
             (this.entreCalle!=null &&
              this.entreCalle.equals(other.getEntreCalle()))) &&
            ((this.barrio==null && other.getBarrio()==null) || 
             (this.barrio!=null &&
              this.barrio.equals(other.getBarrio()))) &&
            ((this.localidad==null && other.getLocalidad()==null) || 
             (this.localidad!=null &&
              this.localidad.equals(other.getLocalidad()))) &&
            ((this.partido==null && other.getPartido()==null) || 
             (this.partido!=null &&
              this.partido.equals(other.getPartido()))) &&
            ((this.provincia==null && other.getProvincia()==null) || 
             (this.provincia!=null &&
              this.provincia.equals(other.getProvincia()))) &&
            ((this.pais==null && other.getPais()==null) || 
             (this.pais!=null &&
              this.pais.equals(other.getPais()))) &&
            ((this.inicioHorario1==null && other.getInicioHorario1()==null) || 
             (this.inicioHorario1!=null &&
              this.inicioHorario1.equals(other.getInicioHorario1()))) &&
            ((this.finHorario1==null && other.getFinHorario1()==null) || 
             (this.finHorario1!=null &&
              this.finHorario1.equals(other.getFinHorario1()))) &&
            ((this.inicioHorario2==null && other.getInicioHorario2()==null) || 
             (this.inicioHorario2!=null &&
              this.inicioHorario2.equals(other.getInicioHorario2()))) &&
            ((this.finHorario2==null && other.getFinHorario2()==null) || 
             (this.finHorario2!=null &&
              this.finHorario2.equals(other.getFinHorario2()))) &&
            ((this.tiempoEspera==null && other.getTiempoEspera()==null) || 
             (this.tiempoEspera!=null &&
              this.tiempoEspera.equals(other.getTiempoEspera()))) &&
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
            ((this.distancia==null && other.getDistancia()==null) || 
             (this.distancia!=null &&
              this.distancia.equals(other.getDistancia()))) &&
            ((this.latitud==null && other.getLatitud()==null) || 
             (this.latitud!=null &&
              this.latitud.equals(other.getLatitud()))) &&
            ((this.longitud==null && other.getLongitud()==null) || 
             (this.longitud!=null &&
              this.longitud.equals(other.getLongitud()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
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
            ((this.varchar7==null && other.getVarchar7()==null) || 
             (this.varchar7!=null &&
              this.varchar7.equals(other.getVarchar7()))) &&
            ((this.varchar8==null && other.getVarchar8()==null) || 
             (this.varchar8!=null &&
              this.varchar8.equals(other.getVarchar8()))) &&
            ((this.varchar9==null && other.getVarchar9()==null) || 
             (this.varchar9!=null &&
              this.varchar9.equals(other.getVarchar9()))) &&
            ((this.b2CPassword==null && other.getB2CPassword()==null) || 
             (this.b2CPassword!=null &&
              this.b2CPassword.equals(other.getB2CPassword()))) &&
            ((this.int1==null && other.getInt1()==null) || 
             (this.int1!=null &&
              this.int1.equals(other.getInt1()))) &&
            ((this.int2==null && other.getInt2()==null) || 
             (this.int2!=null &&
              this.int2.equals(other.getInt2()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.tipoCanal==null && other.getTipoCanal()==null) || 
             (this.tipoCanal!=null &&
              this.tipoCanal.equals(other.getTipoCanal()))) &&
            ((this.tipoVerificacion==null && other.getTipoVerificacion()==null) || 
             (this.tipoVerificacion!=null &&
              this.tipoVerificacion.equals(other.getTipoVerificacion()))) &&
            ((this.referenciaOrden==null && other.getReferenciaOrden()==null) || 
             (this.referenciaOrden!=null &&
              this.referenciaOrden.equals(other.getReferenciaOrden()))) &&
            ((this.clienteDador==null && other.getClienteDador()==null) || 
             (this.clienteDador!=null &&
              this.clienteDador.equals(other.getClienteDador()))) &&
            ((this.categoria==null && other.getCategoria()==null) || 
             (this.categoria!=null &&
              this.categoria.equals(other.getCategoria()))) &&
            ((this.prioridad==null && other.getPrioridad()==null) || 
             (this.prioridad!=null &&
              this.prioridad.equals(other.getPrioridad()))) &&
            ((this.cargaExclusiva==null && other.getCargaExclusiva()==null) || 
             (this.cargaExclusiva!=null &&
              this.cargaExclusiva.equals(other.getCargaExclusiva()))) &&
            ((this.requiereTurno==null && other.getRequiereTurno()==null) || 
             (this.requiereTurno!=null &&
              this.requiereTurno.equals(other.getRequiereTurno()))) &&
            ((this.ultimaVisita==null && other.getUltimaVisita()==null) || 
             (this.ultimaVisita!=null &&
              this.ultimaVisita.equals(other.getUltimaVisita()))) &&
            ((this.requiereAbasto==null && other.getRequiereAbasto()==null) || 
             (this.requiereAbasto!=null &&
              this.requiereAbasto.equals(other.getRequiereAbasto()))) &&
            ((this.depositoSalida==null && other.getDepositoSalida()==null) || 
             (this.depositoSalida!=null &&
              this.depositoSalida.equals(other.getDepositoSalida()))) &&
            ((this.depositoLlegada==null && other.getDepositoLlegada()==null) || 
             (this.depositoLlegada!=null &&
              this.depositoLlegada.equals(other.getDepositoLlegada()))) &&
            ((this.codigoPostal==null && other.getCodigoPostal()==null) || 
             (this.codigoPostal!=null &&
              this.codigoPostal.equals(other.getCodigoPostal()))) &&
            ((this.codigoOperacion==null && other.getCodigoOperacion()==null) || 
             (this.codigoOperacion!=null &&
              this.codigoOperacion.equals(other.getCodigoOperacion()))) &&
            ((this.urlB2C==null && other.getUrlB2C()==null) || 
             (this.urlB2C!=null &&
              this.urlB2C.equals(other.getUrlB2C()))) &&
            ((this.contenedor==null && other.getContenedor()==null) || 
             (this.contenedor!=null &&
              this.contenedor.equals(other.getContenedor()))) &&
            ((this.estadoDetalle==null && other.getEstadoDetalle()==null) || 
             (this.estadoDetalle!=null &&
              this.estadoDetalle.equals(other.getEstadoDetalle()))) &&
            ((this.turnoPedido==null && other.getTurnoPedido()==null) || 
             (this.turnoPedido!=null &&
              this.turnoPedido.equals(other.getTurnoPedido()))) &&
            ((this.serviciosAdicionales==null && other.getServiciosAdicionales()==null) || 
             (this.serviciosAdicionales!=null &&
              java.util.Arrays.equals(this.serviciosAdicionales, other.getServiciosAdicionales()))) &&
            ((this.items==null && other.getItems()==null) || 
             (this.items!=null &&
              java.util.Arrays.equals(this.items, other.getItems()))) &&
            ((this.tiposVehiculos==null && other.getTiposVehiculos()==null) || 
             (this.tiposVehiculos!=null &&
              java.util.Arrays.equals(this.tiposVehiculos, other.getTiposVehiculos()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.recursos==null && other.getRecursos()==null) || 
             (this.recursos!=null &&
              java.util.Arrays.equals(this.recursos, other.getRecursos()))) &&
            ((this.documentos==null && other.getDocumentos()==null) || 
             (this.documentos!=null &&
              java.util.Arrays.equals(this.documentos, other.getDocumentos()))) &&
            ((this.estadosPedido==null && other.getEstadosPedido()==null) || 
             (this.estadosPedido!=null &&
              java.util.Arrays.equals(this.estadosPedido, other.getEstadosPedido()))) &&
            ((this.descripcion2==null && other.getDescripcion2()==null) || 
             (this.descripcion2!=null &&
              this.descripcion2.equals(other.getDescripcion2()))) &&
            ((this.direccion2==null && other.getDireccion2()==null) || 
             (this.direccion2!=null &&
              this.direccion2.equals(other.getDireccion2()))) &&
            ((this.calle2==null && other.getCalle2()==null) || 
             (this.calle2!=null &&
              this.calle2.equals(other.getCalle2()))) &&
            ((this.nroPuerta2==null && other.getNroPuerta2()==null) || 
             (this.nroPuerta2!=null &&
              this.nroPuerta2.equals(other.getNroPuerta2()))) &&
            ((this.entreCalle2==null && other.getEntreCalle2()==null) || 
             (this.entreCalle2!=null &&
              this.entreCalle2.equals(other.getEntreCalle2()))) &&
            ((this.barrio2==null && other.getBarrio2()==null) || 
             (this.barrio2!=null &&
              this.barrio2.equals(other.getBarrio2()))) &&
            ((this.localidad2==null && other.getLocalidad2()==null) || 
             (this.localidad2!=null &&
              this.localidad2.equals(other.getLocalidad2()))) &&
            ((this.partido2==null && other.getPartido2()==null) || 
             (this.partido2!=null &&
              this.partido2.equals(other.getPartido2()))) &&
            ((this.provincia2==null && other.getProvincia2()==null) || 
             (this.provincia2!=null &&
              this.provincia2.equals(other.getProvincia2()))) &&
            ((this.pais2==null && other.getPais2()==null) || 
             (this.pais2!=null &&
              this.pais2.equals(other.getPais2()))) &&
            ((this.idPedido==null && other.getIdPedido()==null) || 
             (this.idPedido!=null &&
              this.idPedido.equals(other.getIdPedido()))) &&
            ((this.fechaRecoleccion==null && other.getFechaRecoleccion()==null) || 
             (this.fechaRecoleccion!=null &&
              this.fechaRecoleccion.equals(other.getFechaRecoleccion()))) &&
            ((this.usarProductos==null && other.getUsarProductos()==null) || 
             (this.usarProductos!=null &&
              this.usarProductos.equals(other.getUsarProductos()))) &&
            ((this.soloInsertarProductos==null && other.getSoloInsertarProductos()==null) || 
             (this.soloInsertarProductos!=null &&
              this.soloInsertarProductos.equals(other.getSoloInsertarProductos()))) &&
            ((this.agruparItems==null && other.getAgruparItems()==null) || 
             (this.agruparItems!=null &&
              this.agruparItems.equals(other.getAgruparItems()))) &&
            ((this.grupoRutas==null && other.getGrupoRutas()==null) || 
             (this.grupoRutas!=null &&
              this.grupoRutas.equals(other.getGrupoRutas()))) &&
            ((this.inicioHorarioRecoleccion1==null && other.getInicioHorarioRecoleccion1()==null) || 
             (this.inicioHorarioRecoleccion1!=null &&
              this.inicioHorarioRecoleccion1.equals(other.getInicioHorarioRecoleccion1()))) &&
            ((this.inicioHorarioRecoleccion2==null && other.getInicioHorarioRecoleccion2()==null) || 
             (this.inicioHorarioRecoleccion2!=null &&
              this.inicioHorarioRecoleccion2.equals(other.getInicioHorarioRecoleccion2()))) &&
            ((this.finHorarioRecoleccion1==null && other.getFinHorarioRecoleccion1()==null) || 
             (this.finHorarioRecoleccion1!=null &&
              this.finHorarioRecoleccion1.equals(other.getFinHorarioRecoleccion1()))) &&
            ((this.finHorarioRecoleccion2==null && other.getFinHorarioRecoleccion2()==null) || 
             (this.finHorarioRecoleccion2!=null &&
              this.finHorarioRecoleccion2.equals(other.getFinHorarioRecoleccion2()))) &&
            ((this.datetime1==null && other.getDatetime1()==null) || 
             (this.datetime1!=null &&
              this.datetime1.equals(other.getDatetime1()))) &&
            ((this.datetime2==null && other.getDatetime2()==null) || 
             (this.datetime2!=null &&
              this.datetime2.equals(other.getDatetime2()))) &&
            ((this.datetime3==null && other.getDatetime3()==null) || 
             (this.datetime3!=null &&
              this.datetime3.equals(other.getDatetime3()))) &&
            ((this.unidades==null && other.getUnidades()==null) || 
             (this.unidades!=null &&
              this.unidades.equals(other.getUnidades()))) &&
            ((this.valorDeclarado==null && other.getValorDeclarado()==null) || 
             (this.valorDeclarado!=null &&
              this.valorDeclarado.equals(other.getValorDeclarado()))) &&
            ((this.float1==null && other.getFloat1()==null) || 
             (this.float1!=null &&
              this.float1.equals(other.getFloat1()))) &&
            ((this.float2==null && other.getFloat2()==null) || 
             (this.float2!=null &&
              this.float2.equals(other.getFloat2()))) &&
            ((this.float3==null && other.getFloat3()==null) || 
             (this.float3!=null &&
              this.float3.equals(other.getFloat3()))) &&
            ((this.float4==null && other.getFloat4()==null) || 
             (this.float4!=null &&
              this.float4.equals(other.getFloat4()))) &&
            ((this.vigenciaDesde==null && other.getVigenciaDesde()==null) || 
             (this.vigenciaDesde!=null &&
              this.vigenciaDesde.equals(other.getVigenciaDesde()))) &&
            ((this.vigenciaHasta==null && other.getVigenciaHasta()==null) || 
             (this.vigenciaHasta!=null &&
              this.vigenciaHasta.equals(other.getVigenciaHasta()))) &&
            ((this.latitud2==null && other.getLatitud2()==null) || 
             (this.latitud2!=null &&
              this.latitud2.equals(other.getLatitud2()))) &&
            ((this.longitud2==null && other.getLongitud2()==null) || 
             (this.longitud2!=null &&
              this.longitud2.equals(other.getLongitud2()))) &&
            ((this.tiempoEspera2==null && other.getTiempoEspera2()==null) || 
             (this.tiempoEspera2!=null &&
              this.tiempoEspera2.equals(other.getTiempoEspera2())));
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
        if (getRefDocumentoAdicional2() != null) {
            _hashCode += getRefDocumentoAdicional2().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFechaEntrega() != null) {
            _hashCode += getFechaEntrega().hashCode();
        }
        if (getFechaEntregaOriginal() != null) {
            _hashCode += getFechaEntregaOriginal().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getCliente2() != null) {
            _hashCode += getCliente2().hashCode();
        }
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getTelefono2() != null) {
            _hashCode += getTelefono2().hashCode();
        }
        if (getTelefono3() != null) {
            _hashCode += getTelefono3().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getCodigoSucursal() != null) {
            _hashCode += getCodigoSucursal().hashCode();
        }
        if (getTipoPedido() != null) {
            _hashCode += getTipoPedido().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getEstadoOrdenEntrega() != null) {
            _hashCode += getEstadoOrdenEntrega().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getCalle() != null) {
            _hashCode += getCalle().hashCode();
        }
        if (getNroPuerta() != null) {
            _hashCode += getNroPuerta().hashCode();
        }
        if (getEntreCalle() != null) {
            _hashCode += getEntreCalle().hashCode();
        }
        if (getBarrio() != null) {
            _hashCode += getBarrio().hashCode();
        }
        if (getLocalidad() != null) {
            _hashCode += getLocalidad().hashCode();
        }
        if (getPartido() != null) {
            _hashCode += getPartido().hashCode();
        }
        if (getProvincia() != null) {
            _hashCode += getProvincia().hashCode();
        }
        if (getPais() != null) {
            _hashCode += getPais().hashCode();
        }
        if (getInicioHorario1() != null) {
            _hashCode += getInicioHorario1().hashCode();
        }
        if (getFinHorario1() != null) {
            _hashCode += getFinHorario1().hashCode();
        }
        if (getInicioHorario2() != null) {
            _hashCode += getInicioHorario2().hashCode();
        }
        if (getFinHorario2() != null) {
            _hashCode += getFinHorario2().hashCode();
        }
        if (getTiempoEspera() != null) {
            _hashCode += getTiempoEspera().hashCode();
        }
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
        if (getDistancia() != null) {
            _hashCode += getDistancia().hashCode();
        }
        if (getLatitud() != null) {
            _hashCode += getLatitud().hashCode();
        }
        if (getLongitud() != null) {
            _hashCode += getLongitud().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
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
        if (getVarchar7() != null) {
            _hashCode += getVarchar7().hashCode();
        }
        if (getVarchar8() != null) {
            _hashCode += getVarchar8().hashCode();
        }
        if (getVarchar9() != null) {
            _hashCode += getVarchar9().hashCode();
        }
        if (getB2CPassword() != null) {
            _hashCode += getB2CPassword().hashCode();
        }
        if (getInt1() != null) {
            _hashCode += getInt1().hashCode();
        }
        if (getInt2() != null) {
            _hashCode += getInt2().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getTipoCanal() != null) {
            _hashCode += getTipoCanal().hashCode();
        }
        if (getTipoVerificacion() != null) {
            _hashCode += getTipoVerificacion().hashCode();
        }
        if (getReferenciaOrden() != null) {
            _hashCode += getReferenciaOrden().hashCode();
        }
        if (getClienteDador() != null) {
            _hashCode += getClienteDador().hashCode();
        }
        if (getCategoria() != null) {
            _hashCode += getCategoria().hashCode();
        }
        if (getPrioridad() != null) {
            _hashCode += getPrioridad().hashCode();
        }
        if (getCargaExclusiva() != null) {
            _hashCode += getCargaExclusiva().hashCode();
        }
        if (getRequiereTurno() != null) {
            _hashCode += getRequiereTurno().hashCode();
        }
        if (getUltimaVisita() != null) {
            _hashCode += getUltimaVisita().hashCode();
        }
        if (getRequiereAbasto() != null) {
            _hashCode += getRequiereAbasto().hashCode();
        }
        if (getDepositoSalida() != null) {
            _hashCode += getDepositoSalida().hashCode();
        }
        if (getDepositoLlegada() != null) {
            _hashCode += getDepositoLlegada().hashCode();
        }
        if (getCodigoPostal() != null) {
            _hashCode += getCodigoPostal().hashCode();
        }
        if (getCodigoOperacion() != null) {
            _hashCode += getCodigoOperacion().hashCode();
        }
        if (getUrlB2C() != null) {
            _hashCode += getUrlB2C().hashCode();
        }
        if (getContenedor() != null) {
            _hashCode += getContenedor().hashCode();
        }
        if (getEstadoDetalle() != null) {
            _hashCode += getEstadoDetalle().hashCode();
        }
        if (getTurnoPedido() != null) {
            _hashCode += getTurnoPedido().hashCode();
        }
        if (getServiciosAdicionales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiciosAdicionales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiciosAdicionales(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTiposVehiculos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTiposVehiculos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTiposVehiculos(), i);
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
        if (getDocumentos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEstadosPedido() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEstadosPedido());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEstadosPedido(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDescripcion2() != null) {
            _hashCode += getDescripcion2().hashCode();
        }
        if (getDireccion2() != null) {
            _hashCode += getDireccion2().hashCode();
        }
        if (getCalle2() != null) {
            _hashCode += getCalle2().hashCode();
        }
        if (getNroPuerta2() != null) {
            _hashCode += getNroPuerta2().hashCode();
        }
        if (getEntreCalle2() != null) {
            _hashCode += getEntreCalle2().hashCode();
        }
        if (getBarrio2() != null) {
            _hashCode += getBarrio2().hashCode();
        }
        if (getLocalidad2() != null) {
            _hashCode += getLocalidad2().hashCode();
        }
        if (getPartido2() != null) {
            _hashCode += getPartido2().hashCode();
        }
        if (getProvincia2() != null) {
            _hashCode += getProvincia2().hashCode();
        }
        if (getPais2() != null) {
            _hashCode += getPais2().hashCode();
        }
        if (getIdPedido() != null) {
            _hashCode += getIdPedido().hashCode();
        }
        if (getFechaRecoleccion() != null) {
            _hashCode += getFechaRecoleccion().hashCode();
        }
        if (getUsarProductos() != null) {
            _hashCode += getUsarProductos().hashCode();
        }
        if (getSoloInsertarProductos() != null) {
            _hashCode += getSoloInsertarProductos().hashCode();
        }
        if (getAgruparItems() != null) {
            _hashCode += getAgruparItems().hashCode();
        }
        if (getGrupoRutas() != null) {
            _hashCode += getGrupoRutas().hashCode();
        }
        if (getInicioHorarioRecoleccion1() != null) {
            _hashCode += getInicioHorarioRecoleccion1().hashCode();
        }
        if (getInicioHorarioRecoleccion2() != null) {
            _hashCode += getInicioHorarioRecoleccion2().hashCode();
        }
        if (getFinHorarioRecoleccion1() != null) {
            _hashCode += getFinHorarioRecoleccion1().hashCode();
        }
        if (getFinHorarioRecoleccion2() != null) {
            _hashCode += getFinHorarioRecoleccion2().hashCode();
        }
        if (getDatetime1() != null) {
            _hashCode += getDatetime1().hashCode();
        }
        if (getDatetime2() != null) {
            _hashCode += getDatetime2().hashCode();
        }
        if (getDatetime3() != null) {
            _hashCode += getDatetime3().hashCode();
        }
        if (getUnidades() != null) {
            _hashCode += getUnidades().hashCode();
        }
        if (getValorDeclarado() != null) {
            _hashCode += getValorDeclarado().hashCode();
        }
        if (getFloat1() != null) {
            _hashCode += getFloat1().hashCode();
        }
        if (getFloat2() != null) {
            _hashCode += getFloat2().hashCode();
        }
        if (getFloat3() != null) {
            _hashCode += getFloat3().hashCode();
        }
        if (getFloat4() != null) {
            _hashCode += getFloat4().hashCode();
        }
        if (getVigenciaDesde() != null) {
            _hashCode += getVigenciaDesde().hashCode();
        }
        if (getVigenciaHasta() != null) {
            _hashCode += getVigenciaHasta().hashCode();
        }
        if (getLatitud2() != null) {
            _hashCode += getLatitud2().hashCode();
        }
        if (getLongitud2() != null) {
            _hashCode += getLongitud2().hashCode();
        }
        if (getTiempoEspera2() != null) {
            _hashCode += getTiempoEspera2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POrdenPedido.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedido"));
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
        elemField.setFieldName("refDocumentoAdicional2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumentoAdicional2"));
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
        elemField.setFieldName("fechaEntrega");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaEntrega"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEntregaOriginal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaEntregaOriginal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cliente2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Telefono2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Telefono3"));
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
        elemField.setFieldName("codigoSucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoSucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoPedido"));
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
        elemField.setFieldName("estadoOrdenEntrega");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoOrdenEntrega"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Direccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Calle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nroPuerta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "NroPuerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entreCalle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntreCalle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("barrio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Barrio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Localidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Partido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provincia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Provincia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pais");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioHorario1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorario1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorario1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorario1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioHorario2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorario2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorario2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorario2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempoEspera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoEspera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
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
        elemField.setFieldName("distancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Distancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Latitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Longitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"));
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
        elemField.setFieldName("varchar7");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Varchar7"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar8");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Varchar8"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varchar9");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Varchar9"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("b2CPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "B2CPassword"));
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
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Email"));
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
        elemField.setFieldName("tipoCanal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoCanal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoVerificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoVerificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clienteDador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ClienteDador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
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
        elemField.setFieldName("prioridad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Prioridad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargaExclusiva");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cargaExclusiva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requiereTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "requiereTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimaVisita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ultimaVisita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requiereAbasto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "requiereAbasto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("codigoPostal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoPostal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CodigoOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlB2C");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UrlB2C"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenedor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Contenedor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pUnidadContenedora"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoDetalle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoDetalle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoOrdenPedido"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("turnoPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TurnoPedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPedidoTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviciosAdicionales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "serviciosAdicionales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicioAdicional"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicioAdicional"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("items");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Items"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoItem"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiposVehiculos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiposVehiculos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoTipoVehiculo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenPedidoTipoVehiculo"));
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
        elemField.setFieldName("recursos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Recursos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRecursos"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Documentos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDocumento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDocumento"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadosPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadosPedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstados"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstados"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccion2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Direccion2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calle2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Calle2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nroPuerta2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "NroPuerta2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entreCalle2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntreCalle2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("barrio2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Barrio2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localidad2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Localidad2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partido2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Partido2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provincia2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Provincia2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pais2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pais2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdPedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaRecoleccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaRecoleccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usarProductos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "usarProductos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("soloInsertarProductos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "soloInsertarProductos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agruparItems");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "agruparItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grupoRutas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "GrupoRutas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioHorarioRecoleccion1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorarioRecoleccion1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioHorarioRecoleccion2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorarioRecoleccion2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorarioRecoleccion1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorarioRecoleccion1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorarioRecoleccion2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorarioRecoleccion2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datetime1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Datetime1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datetime2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Datetime2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datetime3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Datetime3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("valorDeclarado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValorDeclarado"));
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
        elemField.setFieldName("float3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Float3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("float4");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Float4"));
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
        elemField.setFieldName("latitud2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Latitud2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitud2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Longitud2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempoEspera2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoEspera2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
