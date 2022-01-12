/**
 * POrden.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class POrden  implements java.io.Serializable {
    private java.lang.String sucursal;

    private java.lang.String operacion;

    private java.lang.String refDocumento;

    private java.lang.String refDocumentoAdicional;

    private java.lang.String refDocumentoPedido;

    private java.lang.String tipo;

    private java.lang.String tipoOrden;

    private java.lang.String tipoParada;

    private java.lang.String categoriaOrden;

    private java.lang.String refDocumentoRecoleccion;

    private java.lang.String estado;

    private java.util.Calendar fechaJornada;

    private ar.com.unisolutions.PCliente cliente;

    private java.lang.String descripcion;

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

    private java.lang.Boolean crearDomicilio;

    private java.lang.Integer orden;

    private java.util.Calendar inicioHorarioPlanificado;

    private java.util.Calendar finHorarioPlanificado;

    private java.lang.Double volumen;

    private java.lang.Double peso;

    private java.lang.Double bulto;

    private java.lang.Double pallets;

    private java.lang.Double distancia;

    private java.lang.Double latitud;

    private java.lang.Double longitud;

    private java.lang.String observaciones;

    private java.lang.String email;

    private java.lang.String telefono;

    private java.lang.String telefono2;

    private java.lang.String telefono3;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String varchar3;

    private java.lang.String varchar4;

    private java.lang.Integer int1;

    private java.lang.Integer int2;

    private java.lang.Integer idRuta;

    private java.lang.Integer preOrden;

    private java.lang.Integer grupoConsolidacion;

    private java.lang.Integer prioridadAbsoluta;

    private java.lang.Integer grupoRutas;

    private java.lang.Integer tiempoLatencia;

    private java.lang.Integer tiempoEsperaPromedio;

    private ar.com.unisolutions.PDeposito depositoSalida;

    private ar.com.unisolutions.PDeposito depositoLlegada;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private ar.com.unisolutions.POrdenEntregaItem[] items;

    private ar.com.unisolutions.PServicioAdicional[] servicios;

    private java.lang.String tipoJornada;

    private java.lang.String jornadaDescripcion;

    private java.lang.String codigoPostal;

    private java.lang.String motivoEstadoParadaDescripcion;

    private java.lang.String motivoEstadoParadaReferencia;

    private ar.com.unisolutions.PFoto[] fotos;

    private ar.com.unisolutions.ConsultarParadaResultadoItem[] paradaItems;

    private ar.com.unisolutions.PRemito remito;

    private ar.com.unisolutions.PEstadoOrdenEntrega estadoOrden;

    private java.lang.Long idOrden;

    private java.lang.Long idJornada;

    private java.lang.Double pesoMaximo;

    private java.lang.Double volumenMaximo;

    private java.lang.Double bultosMaximo;

    private java.math.BigDecimal costo;

    private java.lang.Integer inicioVisita;

    private java.lang.Integer finVisita;

    private java.util.Calendar inicioHorarioEstimado;

    private java.util.Calendar finHorarioEstimado;

    private java.util.Calendar inicioHorarioReal;

    private java.util.Calendar finHorarioReal;

    private java.lang.Boolean usarProductos;

    private java.lang.Boolean ultimaVisita;

    private java.util.Calendar fecha;

    private java.util.Calendar fechaOrden;

    private java.util.Calendar datetime1;

    private java.util.Calendar datetime2;

    private java.util.Calendar fechaUltimoCambioEstado;

    private java.lang.Integer unidades;

    public POrden() {
    }

    public POrden(
           java.lang.String sucursal,
           java.lang.String operacion,
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           java.lang.String refDocumentoPedido,
           java.lang.String tipo,
           java.lang.String tipoOrden,
           java.lang.String tipoParada,
           java.lang.String categoriaOrden,
           java.lang.String refDocumentoRecoleccion,
           java.lang.String estado,
           java.util.Calendar fechaJornada,
           ar.com.unisolutions.PCliente cliente,
           java.lang.String descripcion,
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
           java.lang.Boolean crearDomicilio,
           java.lang.Integer orden,
           java.util.Calendar inicioHorarioPlanificado,
           java.util.Calendar finHorarioPlanificado,
           java.lang.Double volumen,
           java.lang.Double peso,
           java.lang.Double bulto,
           java.lang.Double pallets,
           java.lang.Double distancia,
           java.lang.Double latitud,
           java.lang.Double longitud,
           java.lang.String observaciones,
           java.lang.String email,
           java.lang.String telefono,
           java.lang.String telefono2,
           java.lang.String telefono3,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           java.lang.String varchar4,
           java.lang.Integer int1,
           java.lang.Integer int2,
           java.lang.Integer idRuta,
           java.lang.Integer preOrden,
           java.lang.Integer grupoConsolidacion,
           java.lang.Integer prioridadAbsoluta,
           java.lang.Integer grupoRutas,
           java.lang.Integer tiempoLatencia,
           java.lang.Integer tiempoEsperaPromedio,
           ar.com.unisolutions.PDeposito depositoSalida,
           ar.com.unisolutions.PDeposito depositoLlegada,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           ar.com.unisolutions.POrdenEntregaItem[] items,
           ar.com.unisolutions.PServicioAdicional[] servicios,
           java.lang.String tipoJornada,
           java.lang.String jornadaDescripcion,
           java.lang.String codigoPostal,
           java.lang.String motivoEstadoParadaDescripcion,
           java.lang.String motivoEstadoParadaReferencia,
           ar.com.unisolutions.PFoto[] fotos,
           ar.com.unisolutions.ConsultarParadaResultadoItem[] paradaItems,
           ar.com.unisolutions.PRemito remito,
           ar.com.unisolutions.PEstadoOrdenEntrega estadoOrden,
           java.lang.Long idOrden,
           java.lang.Long idJornada,
           java.lang.Double pesoMaximo,
           java.lang.Double volumenMaximo,
           java.lang.Double bultosMaximo,
           java.math.BigDecimal costo,
           java.lang.Integer inicioVisita,
           java.lang.Integer finVisita,
           java.util.Calendar inicioHorarioEstimado,
           java.util.Calendar finHorarioEstimado,
           java.util.Calendar inicioHorarioReal,
           java.util.Calendar finHorarioReal,
           java.lang.Boolean usarProductos,
           java.lang.Boolean ultimaVisita,
           java.util.Calendar fecha,
           java.util.Calendar fechaOrden,
           java.util.Calendar datetime1,
           java.util.Calendar datetime2,
           java.util.Calendar fechaUltimoCambioEstado,
           java.lang.Integer unidades) {
           this.sucursal = sucursal;
           this.operacion = operacion;
           this.refDocumento = refDocumento;
           this.refDocumentoAdicional = refDocumentoAdicional;
           this.refDocumentoPedido = refDocumentoPedido;
           this.tipo = tipo;
           this.tipoOrden = tipoOrden;
           this.tipoParada = tipoParada;
           this.categoriaOrden = categoriaOrden;
           this.refDocumentoRecoleccion = refDocumentoRecoleccion;
           this.estado = estado;
           this.fechaJornada = fechaJornada;
           this.cliente = cliente;
           this.descripcion = descripcion;
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
           this.crearDomicilio = crearDomicilio;
           this.orden = orden;
           this.inicioHorarioPlanificado = inicioHorarioPlanificado;
           this.finHorarioPlanificado = finHorarioPlanificado;
           this.volumen = volumen;
           this.peso = peso;
           this.bulto = bulto;
           this.pallets = pallets;
           this.distancia = distancia;
           this.latitud = latitud;
           this.longitud = longitud;
           this.observaciones = observaciones;
           this.email = email;
           this.telefono = telefono;
           this.telefono2 = telefono2;
           this.telefono3 = telefono3;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.varchar3 = varchar3;
           this.varchar4 = varchar4;
           this.int1 = int1;
           this.int2 = int2;
           this.idRuta = idRuta;
           this.preOrden = preOrden;
           this.grupoConsolidacion = grupoConsolidacion;
           this.prioridadAbsoluta = prioridadAbsoluta;
           this.grupoRutas = grupoRutas;
           this.tiempoLatencia = tiempoLatencia;
           this.tiempoEsperaPromedio = tiempoEsperaPromedio;
           this.depositoSalida = depositoSalida;
           this.depositoLlegada = depositoLlegada;
           this.campoDinamico = campoDinamico;
           this.items = items;
           this.servicios = servicios;
           this.tipoJornada = tipoJornada;
           this.jornadaDescripcion = jornadaDescripcion;
           this.codigoPostal = codigoPostal;
           this.motivoEstadoParadaDescripcion = motivoEstadoParadaDescripcion;
           this.motivoEstadoParadaReferencia = motivoEstadoParadaReferencia;
           this.fotos = fotos;
           this.paradaItems = paradaItems;
           this.remito = remito;
           this.estadoOrden = estadoOrden;
           this.idOrden = idOrden;
           this.idJornada = idJornada;
           this.pesoMaximo = pesoMaximo;
           this.volumenMaximo = volumenMaximo;
           this.bultosMaximo = bultosMaximo;
           this.costo = costo;
           this.inicioVisita = inicioVisita;
           this.finVisita = finVisita;
           this.inicioHorarioEstimado = inicioHorarioEstimado;
           this.finHorarioEstimado = finHorarioEstimado;
           this.inicioHorarioReal = inicioHorarioReal;
           this.finHorarioReal = finHorarioReal;
           this.usarProductos = usarProductos;
           this.ultimaVisita = ultimaVisita;
           this.fecha = fecha;
           this.fechaOrden = fechaOrden;
           this.datetime1 = datetime1;
           this.datetime2 = datetime2;
           this.fechaUltimoCambioEstado = fechaUltimoCambioEstado;
           this.unidades = unidades;
    }


    /**
     * Gets the sucursal value for this POrden.
     * 
     * @return sucursal
     */
    public java.lang.String getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this POrden.
     * 
     * @param sucursal
     */
    public void setSucursal(java.lang.String sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the operacion value for this POrden.
     * 
     * @return operacion
     */
    public java.lang.String getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this POrden.
     * 
     * @param operacion
     */
    public void setOperacion(java.lang.String operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the refDocumento value for this POrden.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this POrden.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the refDocumentoAdicional value for this POrden.
     * 
     * @return refDocumentoAdicional
     */
    public java.lang.String getRefDocumentoAdicional() {
        return refDocumentoAdicional;
    }


    /**
     * Sets the refDocumentoAdicional value for this POrden.
     * 
     * @param refDocumentoAdicional
     */
    public void setRefDocumentoAdicional(java.lang.String refDocumentoAdicional) {
        this.refDocumentoAdicional = refDocumentoAdicional;
    }


    /**
     * Gets the refDocumentoPedido value for this POrden.
     * 
     * @return refDocumentoPedido
     */
    public java.lang.String getRefDocumentoPedido() {
        return refDocumentoPedido;
    }


    /**
     * Sets the refDocumentoPedido value for this POrden.
     * 
     * @param refDocumentoPedido
     */
    public void setRefDocumentoPedido(java.lang.String refDocumentoPedido) {
        this.refDocumentoPedido = refDocumentoPedido;
    }


    /**
     * Gets the tipo value for this POrden.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this POrden.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the tipoOrden value for this POrden.
     * 
     * @return tipoOrden
     */
    public java.lang.String getTipoOrden() {
        return tipoOrden;
    }


    /**
     * Sets the tipoOrden value for this POrden.
     * 
     * @param tipoOrden
     */
    public void setTipoOrden(java.lang.String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }


    /**
     * Gets the tipoParada value for this POrden.
     * 
     * @return tipoParada
     */
    public java.lang.String getTipoParada() {
        return tipoParada;
    }


    /**
     * Sets the tipoParada value for this POrden.
     * 
     * @param tipoParada
     */
    public void setTipoParada(java.lang.String tipoParada) {
        this.tipoParada = tipoParada;
    }


    /**
     * Gets the categoriaOrden value for this POrden.
     * 
     * @return categoriaOrden
     */
    public java.lang.String getCategoriaOrden() {
        return categoriaOrden;
    }


    /**
     * Sets the categoriaOrden value for this POrden.
     * 
     * @param categoriaOrden
     */
    public void setCategoriaOrden(java.lang.String categoriaOrden) {
        this.categoriaOrden = categoriaOrden;
    }


    /**
     * Gets the refDocumentoRecoleccion value for this POrden.
     * 
     * @return refDocumentoRecoleccion
     */
    public java.lang.String getRefDocumentoRecoleccion() {
        return refDocumentoRecoleccion;
    }


    /**
     * Sets the refDocumentoRecoleccion value for this POrden.
     * 
     * @param refDocumentoRecoleccion
     */
    public void setRefDocumentoRecoleccion(java.lang.String refDocumentoRecoleccion) {
        this.refDocumentoRecoleccion = refDocumentoRecoleccion;
    }


    /**
     * Gets the estado value for this POrden.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this POrden.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the fechaJornada value for this POrden.
     * 
     * @return fechaJornada
     */
    public java.util.Calendar getFechaJornada() {
        return fechaJornada;
    }


    /**
     * Sets the fechaJornada value for this POrden.
     * 
     * @param fechaJornada
     */
    public void setFechaJornada(java.util.Calendar fechaJornada) {
        this.fechaJornada = fechaJornada;
    }


    /**
     * Gets the cliente value for this POrden.
     * 
     * @return cliente
     */
    public ar.com.unisolutions.PCliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this POrden.
     * 
     * @param cliente
     */
    public void setCliente(ar.com.unisolutions.PCliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the descripcion value for this POrden.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this POrden.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the direccion value for this POrden.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this POrden.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the calle value for this POrden.
     * 
     * @return calle
     */
    public java.lang.String getCalle() {
        return calle;
    }


    /**
     * Sets the calle value for this POrden.
     * 
     * @param calle
     */
    public void setCalle(java.lang.String calle) {
        this.calle = calle;
    }


    /**
     * Gets the nroPuerta value for this POrden.
     * 
     * @return nroPuerta
     */
    public java.lang.String getNroPuerta() {
        return nroPuerta;
    }


    /**
     * Sets the nroPuerta value for this POrden.
     * 
     * @param nroPuerta
     */
    public void setNroPuerta(java.lang.String nroPuerta) {
        this.nroPuerta = nroPuerta;
    }


    /**
     * Gets the entreCalle value for this POrden.
     * 
     * @return entreCalle
     */
    public java.lang.String getEntreCalle() {
        return entreCalle;
    }


    /**
     * Sets the entreCalle value for this POrden.
     * 
     * @param entreCalle
     */
    public void setEntreCalle(java.lang.String entreCalle) {
        this.entreCalle = entreCalle;
    }


    /**
     * Gets the barrio value for this POrden.
     * 
     * @return barrio
     */
    public java.lang.String getBarrio() {
        return barrio;
    }


    /**
     * Sets the barrio value for this POrden.
     * 
     * @param barrio
     */
    public void setBarrio(java.lang.String barrio) {
        this.barrio = barrio;
    }


    /**
     * Gets the localidad value for this POrden.
     * 
     * @return localidad
     */
    public java.lang.String getLocalidad() {
        return localidad;
    }


    /**
     * Sets the localidad value for this POrden.
     * 
     * @param localidad
     */
    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }


    /**
     * Gets the partido value for this POrden.
     * 
     * @return partido
     */
    public java.lang.String getPartido() {
        return partido;
    }


    /**
     * Sets the partido value for this POrden.
     * 
     * @param partido
     */
    public void setPartido(java.lang.String partido) {
        this.partido = partido;
    }


    /**
     * Gets the provincia value for this POrden.
     * 
     * @return provincia
     */
    public java.lang.String getProvincia() {
        return provincia;
    }


    /**
     * Sets the provincia value for this POrden.
     * 
     * @param provincia
     */
    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }


    /**
     * Gets the pais value for this POrden.
     * 
     * @return pais
     */
    public java.lang.String getPais() {
        return pais;
    }


    /**
     * Sets the pais value for this POrden.
     * 
     * @param pais
     */
    public void setPais(java.lang.String pais) {
        this.pais = pais;
    }


    /**
     * Gets the inicioHorario1 value for this POrden.
     * 
     * @return inicioHorario1
     */
    public java.lang.Integer getInicioHorario1() {
        return inicioHorario1;
    }


    /**
     * Sets the inicioHorario1 value for this POrden.
     * 
     * @param inicioHorario1
     */
    public void setInicioHorario1(java.lang.Integer inicioHorario1) {
        this.inicioHorario1 = inicioHorario1;
    }


    /**
     * Gets the finHorario1 value for this POrden.
     * 
     * @return finHorario1
     */
    public java.lang.Integer getFinHorario1() {
        return finHorario1;
    }


    /**
     * Sets the finHorario1 value for this POrden.
     * 
     * @param finHorario1
     */
    public void setFinHorario1(java.lang.Integer finHorario1) {
        this.finHorario1 = finHorario1;
    }


    /**
     * Gets the inicioHorario2 value for this POrden.
     * 
     * @return inicioHorario2
     */
    public java.lang.Integer getInicioHorario2() {
        return inicioHorario2;
    }


    /**
     * Sets the inicioHorario2 value for this POrden.
     * 
     * @param inicioHorario2
     */
    public void setInicioHorario2(java.lang.Integer inicioHorario2) {
        this.inicioHorario2 = inicioHorario2;
    }


    /**
     * Gets the finHorario2 value for this POrden.
     * 
     * @return finHorario2
     */
    public java.lang.Integer getFinHorario2() {
        return finHorario2;
    }


    /**
     * Sets the finHorario2 value for this POrden.
     * 
     * @param finHorario2
     */
    public void setFinHorario2(java.lang.Integer finHorario2) {
        this.finHorario2 = finHorario2;
    }


    /**
     * Gets the tiempoEspera value for this POrden.
     * 
     * @return tiempoEspera
     */
    public java.lang.Integer getTiempoEspera() {
        return tiempoEspera;
    }


    /**
     * Sets the tiempoEspera value for this POrden.
     * 
     * @param tiempoEspera
     */
    public void setTiempoEspera(java.lang.Integer tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }


    /**
     * Gets the crearDomicilio value for this POrden.
     * 
     * @return crearDomicilio
     */
    public java.lang.Boolean getCrearDomicilio() {
        return crearDomicilio;
    }


    /**
     * Sets the crearDomicilio value for this POrden.
     * 
     * @param crearDomicilio
     */
    public void setCrearDomicilio(java.lang.Boolean crearDomicilio) {
        this.crearDomicilio = crearDomicilio;
    }


    /**
     * Gets the orden value for this POrden.
     * 
     * @return orden
     */
    public java.lang.Integer getOrden() {
        return orden;
    }


    /**
     * Sets the orden value for this POrden.
     * 
     * @param orden
     */
    public void setOrden(java.lang.Integer orden) {
        this.orden = orden;
    }


    /**
     * Gets the inicioHorarioPlanificado value for this POrden.
     * 
     * @return inicioHorarioPlanificado
     */
    public java.util.Calendar getInicioHorarioPlanificado() {
        return inicioHorarioPlanificado;
    }


    /**
     * Sets the inicioHorarioPlanificado value for this POrden.
     * 
     * @param inicioHorarioPlanificado
     */
    public void setInicioHorarioPlanificado(java.util.Calendar inicioHorarioPlanificado) {
        this.inicioHorarioPlanificado = inicioHorarioPlanificado;
    }


    /**
     * Gets the finHorarioPlanificado value for this POrden.
     * 
     * @return finHorarioPlanificado
     */
    public java.util.Calendar getFinHorarioPlanificado() {
        return finHorarioPlanificado;
    }


    /**
     * Sets the finHorarioPlanificado value for this POrden.
     * 
     * @param finHorarioPlanificado
     */
    public void setFinHorarioPlanificado(java.util.Calendar finHorarioPlanificado) {
        this.finHorarioPlanificado = finHorarioPlanificado;
    }


    /**
     * Gets the volumen value for this POrden.
     * 
     * @return volumen
     */
    public java.lang.Double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this POrden.
     * 
     * @param volumen
     */
    public void setVolumen(java.lang.Double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this POrden.
     * 
     * @return peso
     */
    public java.lang.Double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this POrden.
     * 
     * @param peso
     */
    public void setPeso(java.lang.Double peso) {
        this.peso = peso;
    }


    /**
     * Gets the bulto value for this POrden.
     * 
     * @return bulto
     */
    public java.lang.Double getBulto() {
        return bulto;
    }


    /**
     * Sets the bulto value for this POrden.
     * 
     * @param bulto
     */
    public void setBulto(java.lang.Double bulto) {
        this.bulto = bulto;
    }


    /**
     * Gets the pallets value for this POrden.
     * 
     * @return pallets
     */
    public java.lang.Double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this POrden.
     * 
     * @param pallets
     */
    public void setPallets(java.lang.Double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the distancia value for this POrden.
     * 
     * @return distancia
     */
    public java.lang.Double getDistancia() {
        return distancia;
    }


    /**
     * Sets the distancia value for this POrden.
     * 
     * @param distancia
     */
    public void setDistancia(java.lang.Double distancia) {
        this.distancia = distancia;
    }


    /**
     * Gets the latitud value for this POrden.
     * 
     * @return latitud
     */
    public java.lang.Double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this POrden.
     * 
     * @param latitud
     */
    public void setLatitud(java.lang.Double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this POrden.
     * 
     * @return longitud
     */
    public java.lang.Double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this POrden.
     * 
     * @param longitud
     */
    public void setLongitud(java.lang.Double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the observaciones value for this POrden.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this POrden.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the email value for this POrden.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this POrden.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the telefono value for this POrden.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this POrden.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the telefono2 value for this POrden.
     * 
     * @return telefono2
     */
    public java.lang.String getTelefono2() {
        return telefono2;
    }


    /**
     * Sets the telefono2 value for this POrden.
     * 
     * @param telefono2
     */
    public void setTelefono2(java.lang.String telefono2) {
        this.telefono2 = telefono2;
    }


    /**
     * Gets the telefono3 value for this POrden.
     * 
     * @return telefono3
     */
    public java.lang.String getTelefono3() {
        return telefono3;
    }


    /**
     * Sets the telefono3 value for this POrden.
     * 
     * @param telefono3
     */
    public void setTelefono3(java.lang.String telefono3) {
        this.telefono3 = telefono3;
    }


    /**
     * Gets the varchar1 value for this POrden.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this POrden.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this POrden.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this POrden.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the varchar3 value for this POrden.
     * 
     * @return varchar3
     */
    public java.lang.String getVarchar3() {
        return varchar3;
    }


    /**
     * Sets the varchar3 value for this POrden.
     * 
     * @param varchar3
     */
    public void setVarchar3(java.lang.String varchar3) {
        this.varchar3 = varchar3;
    }


    /**
     * Gets the varchar4 value for this POrden.
     * 
     * @return varchar4
     */
    public java.lang.String getVarchar4() {
        return varchar4;
    }


    /**
     * Sets the varchar4 value for this POrden.
     * 
     * @param varchar4
     */
    public void setVarchar4(java.lang.String varchar4) {
        this.varchar4 = varchar4;
    }


    /**
     * Gets the int1 value for this POrden.
     * 
     * @return int1
     */
    public java.lang.Integer getInt1() {
        return int1;
    }


    /**
     * Sets the int1 value for this POrden.
     * 
     * @param int1
     */
    public void setInt1(java.lang.Integer int1) {
        this.int1 = int1;
    }


    /**
     * Gets the int2 value for this POrden.
     * 
     * @return int2
     */
    public java.lang.Integer getInt2() {
        return int2;
    }


    /**
     * Sets the int2 value for this POrden.
     * 
     * @param int2
     */
    public void setInt2(java.lang.Integer int2) {
        this.int2 = int2;
    }


    /**
     * Gets the idRuta value for this POrden.
     * 
     * @return idRuta
     */
    public java.lang.Integer getIdRuta() {
        return idRuta;
    }


    /**
     * Sets the idRuta value for this POrden.
     * 
     * @param idRuta
     */
    public void setIdRuta(java.lang.Integer idRuta) {
        this.idRuta = idRuta;
    }


    /**
     * Gets the preOrden value for this POrden.
     * 
     * @return preOrden
     */
    public java.lang.Integer getPreOrden() {
        return preOrden;
    }


    /**
     * Sets the preOrden value for this POrden.
     * 
     * @param preOrden
     */
    public void setPreOrden(java.lang.Integer preOrden) {
        this.preOrden = preOrden;
    }


    /**
     * Gets the grupoConsolidacion value for this POrden.
     * 
     * @return grupoConsolidacion
     */
    public java.lang.Integer getGrupoConsolidacion() {
        return grupoConsolidacion;
    }


    /**
     * Sets the grupoConsolidacion value for this POrden.
     * 
     * @param grupoConsolidacion
     */
    public void setGrupoConsolidacion(java.lang.Integer grupoConsolidacion) {
        this.grupoConsolidacion = grupoConsolidacion;
    }


    /**
     * Gets the prioridadAbsoluta value for this POrden.
     * 
     * @return prioridadAbsoluta
     */
    public java.lang.Integer getPrioridadAbsoluta() {
        return prioridadAbsoluta;
    }


    /**
     * Sets the prioridadAbsoluta value for this POrden.
     * 
     * @param prioridadAbsoluta
     */
    public void setPrioridadAbsoluta(java.lang.Integer prioridadAbsoluta) {
        this.prioridadAbsoluta = prioridadAbsoluta;
    }


    /**
     * Gets the grupoRutas value for this POrden.
     * 
     * @return grupoRutas
     */
    public java.lang.Integer getGrupoRutas() {
        return grupoRutas;
    }


    /**
     * Sets the grupoRutas value for this POrden.
     * 
     * @param grupoRutas
     */
    public void setGrupoRutas(java.lang.Integer grupoRutas) {
        this.grupoRutas = grupoRutas;
    }


    /**
     * Gets the tiempoLatencia value for this POrden.
     * 
     * @return tiempoLatencia
     */
    public java.lang.Integer getTiempoLatencia() {
        return tiempoLatencia;
    }


    /**
     * Sets the tiempoLatencia value for this POrden.
     * 
     * @param tiempoLatencia
     */
    public void setTiempoLatencia(java.lang.Integer tiempoLatencia) {
        this.tiempoLatencia = tiempoLatencia;
    }


    /**
     * Gets the tiempoEsperaPromedio value for this POrden.
     * 
     * @return tiempoEsperaPromedio
     */
    public java.lang.Integer getTiempoEsperaPromedio() {
        return tiempoEsperaPromedio;
    }


    /**
     * Sets the tiempoEsperaPromedio value for this POrden.
     * 
     * @param tiempoEsperaPromedio
     */
    public void setTiempoEsperaPromedio(java.lang.Integer tiempoEsperaPromedio) {
        this.tiempoEsperaPromedio = tiempoEsperaPromedio;
    }


    /**
     * Gets the depositoSalida value for this POrden.
     * 
     * @return depositoSalida
     */
    public ar.com.unisolutions.PDeposito getDepositoSalida() {
        return depositoSalida;
    }


    /**
     * Sets the depositoSalida value for this POrden.
     * 
     * @param depositoSalida
     */
    public void setDepositoSalida(ar.com.unisolutions.PDeposito depositoSalida) {
        this.depositoSalida = depositoSalida;
    }


    /**
     * Gets the depositoLlegada value for this POrden.
     * 
     * @return depositoLlegada
     */
    public ar.com.unisolutions.PDeposito getDepositoLlegada() {
        return depositoLlegada;
    }


    /**
     * Sets the depositoLlegada value for this POrden.
     * 
     * @param depositoLlegada
     */
    public void setDepositoLlegada(ar.com.unisolutions.PDeposito depositoLlegada) {
        this.depositoLlegada = depositoLlegada;
    }


    /**
     * Gets the campoDinamico value for this POrden.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this POrden.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the items value for this POrden.
     * 
     * @return items
     */
    public ar.com.unisolutions.POrdenEntregaItem[] getItems() {
        return items;
    }


    /**
     * Sets the items value for this POrden.
     * 
     * @param items
     */
    public void setItems(ar.com.unisolutions.POrdenEntregaItem[] items) {
        this.items = items;
    }


    /**
     * Gets the servicios value for this POrden.
     * 
     * @return servicios
     */
    public ar.com.unisolutions.PServicioAdicional[] getServicios() {
        return servicios;
    }


    /**
     * Sets the servicios value for this POrden.
     * 
     * @param servicios
     */
    public void setServicios(ar.com.unisolutions.PServicioAdicional[] servicios) {
        this.servicios = servicios;
    }


    /**
     * Gets the tipoJornada value for this POrden.
     * 
     * @return tipoJornada
     */
    public java.lang.String getTipoJornada() {
        return tipoJornada;
    }


    /**
     * Sets the tipoJornada value for this POrden.
     * 
     * @param tipoJornada
     */
    public void setTipoJornada(java.lang.String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }


    /**
     * Gets the jornadaDescripcion value for this POrden.
     * 
     * @return jornadaDescripcion
     */
    public java.lang.String getJornadaDescripcion() {
        return jornadaDescripcion;
    }


    /**
     * Sets the jornadaDescripcion value for this POrden.
     * 
     * @param jornadaDescripcion
     */
    public void setJornadaDescripcion(java.lang.String jornadaDescripcion) {
        this.jornadaDescripcion = jornadaDescripcion;
    }


    /**
     * Gets the codigoPostal value for this POrden.
     * 
     * @return codigoPostal
     */
    public java.lang.String getCodigoPostal() {
        return codigoPostal;
    }


    /**
     * Sets the codigoPostal value for this POrden.
     * 
     * @param codigoPostal
     */
    public void setCodigoPostal(java.lang.String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    /**
     * Gets the motivoEstadoParadaDescripcion value for this POrden.
     * 
     * @return motivoEstadoParadaDescripcion
     */
    public java.lang.String getMotivoEstadoParadaDescripcion() {
        return motivoEstadoParadaDescripcion;
    }


    /**
     * Sets the motivoEstadoParadaDescripcion value for this POrden.
     * 
     * @param motivoEstadoParadaDescripcion
     */
    public void setMotivoEstadoParadaDescripcion(java.lang.String motivoEstadoParadaDescripcion) {
        this.motivoEstadoParadaDescripcion = motivoEstadoParadaDescripcion;
    }


    /**
     * Gets the motivoEstadoParadaReferencia value for this POrden.
     * 
     * @return motivoEstadoParadaReferencia
     */
    public java.lang.String getMotivoEstadoParadaReferencia() {
        return motivoEstadoParadaReferencia;
    }


    /**
     * Sets the motivoEstadoParadaReferencia value for this POrden.
     * 
     * @param motivoEstadoParadaReferencia
     */
    public void setMotivoEstadoParadaReferencia(java.lang.String motivoEstadoParadaReferencia) {
        this.motivoEstadoParadaReferencia = motivoEstadoParadaReferencia;
    }


    /**
     * Gets the fotos value for this POrden.
     * 
     * @return fotos
     */
    public ar.com.unisolutions.PFoto[] getFotos() {
        return fotos;
    }


    /**
     * Sets the fotos value for this POrden.
     * 
     * @param fotos
     */
    public void setFotos(ar.com.unisolutions.PFoto[] fotos) {
        this.fotos = fotos;
    }


    /**
     * Gets the paradaItems value for this POrden.
     * 
     * @return paradaItems
     */
    public ar.com.unisolutions.ConsultarParadaResultadoItem[] getParadaItems() {
        return paradaItems;
    }


    /**
     * Sets the paradaItems value for this POrden.
     * 
     * @param paradaItems
     */
    public void setParadaItems(ar.com.unisolutions.ConsultarParadaResultadoItem[] paradaItems) {
        this.paradaItems = paradaItems;
    }


    /**
     * Gets the remito value for this POrden.
     * 
     * @return remito
     */
    public ar.com.unisolutions.PRemito getRemito() {
        return remito;
    }


    /**
     * Sets the remito value for this POrden.
     * 
     * @param remito
     */
    public void setRemito(ar.com.unisolutions.PRemito remito) {
        this.remito = remito;
    }


    /**
     * Gets the estadoOrden value for this POrden.
     * 
     * @return estadoOrden
     */
    public ar.com.unisolutions.PEstadoOrdenEntrega getEstadoOrden() {
        return estadoOrden;
    }


    /**
     * Sets the estadoOrden value for this POrden.
     * 
     * @param estadoOrden
     */
    public void setEstadoOrden(ar.com.unisolutions.PEstadoOrdenEntrega estadoOrden) {
        this.estadoOrden = estadoOrden;
    }


    /**
     * Gets the idOrden value for this POrden.
     * 
     * @return idOrden
     */
    public java.lang.Long getIdOrden() {
        return idOrden;
    }


    /**
     * Sets the idOrden value for this POrden.
     * 
     * @param idOrden
     */
    public void setIdOrden(java.lang.Long idOrden) {
        this.idOrden = idOrden;
    }


    /**
     * Gets the idJornada value for this POrden.
     * 
     * @return idJornada
     */
    public java.lang.Long getIdJornada() {
        return idJornada;
    }


    /**
     * Sets the idJornada value for this POrden.
     * 
     * @param idJornada
     */
    public void setIdJornada(java.lang.Long idJornada) {
        this.idJornada = idJornada;
    }


    /**
     * Gets the pesoMaximo value for this POrden.
     * 
     * @return pesoMaximo
     */
    public java.lang.Double getPesoMaximo() {
        return pesoMaximo;
    }


    /**
     * Sets the pesoMaximo value for this POrden.
     * 
     * @param pesoMaximo
     */
    public void setPesoMaximo(java.lang.Double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }


    /**
     * Gets the volumenMaximo value for this POrden.
     * 
     * @return volumenMaximo
     */
    public java.lang.Double getVolumenMaximo() {
        return volumenMaximo;
    }


    /**
     * Sets the volumenMaximo value for this POrden.
     * 
     * @param volumenMaximo
     */
    public void setVolumenMaximo(java.lang.Double volumenMaximo) {
        this.volumenMaximo = volumenMaximo;
    }


    /**
     * Gets the bultosMaximo value for this POrden.
     * 
     * @return bultosMaximo
     */
    public java.lang.Double getBultosMaximo() {
        return bultosMaximo;
    }


    /**
     * Sets the bultosMaximo value for this POrden.
     * 
     * @param bultosMaximo
     */
    public void setBultosMaximo(java.lang.Double bultosMaximo) {
        this.bultosMaximo = bultosMaximo;
    }


    /**
     * Gets the costo value for this POrden.
     * 
     * @return costo
     */
    public java.math.BigDecimal getCosto() {
        return costo;
    }


    /**
     * Sets the costo value for this POrden.
     * 
     * @param costo
     */
    public void setCosto(java.math.BigDecimal costo) {
        this.costo = costo;
    }


    /**
     * Gets the inicioVisita value for this POrden.
     * 
     * @return inicioVisita
     */
    public java.lang.Integer getInicioVisita() {
        return inicioVisita;
    }


    /**
     * Sets the inicioVisita value for this POrden.
     * 
     * @param inicioVisita
     */
    public void setInicioVisita(java.lang.Integer inicioVisita) {
        this.inicioVisita = inicioVisita;
    }


    /**
     * Gets the finVisita value for this POrden.
     * 
     * @return finVisita
     */
    public java.lang.Integer getFinVisita() {
        return finVisita;
    }


    /**
     * Sets the finVisita value for this POrden.
     * 
     * @param finVisita
     */
    public void setFinVisita(java.lang.Integer finVisita) {
        this.finVisita = finVisita;
    }


    /**
     * Gets the inicioHorarioEstimado value for this POrden.
     * 
     * @return inicioHorarioEstimado
     */
    public java.util.Calendar getInicioHorarioEstimado() {
        return inicioHorarioEstimado;
    }


    /**
     * Sets the inicioHorarioEstimado value for this POrden.
     * 
     * @param inicioHorarioEstimado
     */
    public void setInicioHorarioEstimado(java.util.Calendar inicioHorarioEstimado) {
        this.inicioHorarioEstimado = inicioHorarioEstimado;
    }


    /**
     * Gets the finHorarioEstimado value for this POrden.
     * 
     * @return finHorarioEstimado
     */
    public java.util.Calendar getFinHorarioEstimado() {
        return finHorarioEstimado;
    }


    /**
     * Sets the finHorarioEstimado value for this POrden.
     * 
     * @param finHorarioEstimado
     */
    public void setFinHorarioEstimado(java.util.Calendar finHorarioEstimado) {
        this.finHorarioEstimado = finHorarioEstimado;
    }


    /**
     * Gets the inicioHorarioReal value for this POrden.
     * 
     * @return inicioHorarioReal
     */
    public java.util.Calendar getInicioHorarioReal() {
        return inicioHorarioReal;
    }


    /**
     * Sets the inicioHorarioReal value for this POrden.
     * 
     * @param inicioHorarioReal
     */
    public void setInicioHorarioReal(java.util.Calendar inicioHorarioReal) {
        this.inicioHorarioReal = inicioHorarioReal;
    }


    /**
     * Gets the finHorarioReal value for this POrden.
     * 
     * @return finHorarioReal
     */
    public java.util.Calendar getFinHorarioReal() {
        return finHorarioReal;
    }


    /**
     * Sets the finHorarioReal value for this POrden.
     * 
     * @param finHorarioReal
     */
    public void setFinHorarioReal(java.util.Calendar finHorarioReal) {
        this.finHorarioReal = finHorarioReal;
    }


    /**
     * Gets the usarProductos value for this POrden.
     * 
     * @return usarProductos
     */
    public java.lang.Boolean getUsarProductos() {
        return usarProductos;
    }


    /**
     * Sets the usarProductos value for this POrden.
     * 
     * @param usarProductos
     */
    public void setUsarProductos(java.lang.Boolean usarProductos) {
        this.usarProductos = usarProductos;
    }


    /**
     * Gets the ultimaVisita value for this POrden.
     * 
     * @return ultimaVisita
     */
    public java.lang.Boolean getUltimaVisita() {
        return ultimaVisita;
    }


    /**
     * Sets the ultimaVisita value for this POrden.
     * 
     * @param ultimaVisita
     */
    public void setUltimaVisita(java.lang.Boolean ultimaVisita) {
        this.ultimaVisita = ultimaVisita;
    }


    /**
     * Gets the fecha value for this POrden.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this POrden.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the fechaOrden value for this POrden.
     * 
     * @return fechaOrden
     */
    public java.util.Calendar getFechaOrden() {
        return fechaOrden;
    }


    /**
     * Sets the fechaOrden value for this POrden.
     * 
     * @param fechaOrden
     */
    public void setFechaOrden(java.util.Calendar fechaOrden) {
        this.fechaOrden = fechaOrden;
    }


    /**
     * Gets the datetime1 value for this POrden.
     * 
     * @return datetime1
     */
    public java.util.Calendar getDatetime1() {
        return datetime1;
    }


    /**
     * Sets the datetime1 value for this POrden.
     * 
     * @param datetime1
     */
    public void setDatetime1(java.util.Calendar datetime1) {
        this.datetime1 = datetime1;
    }


    /**
     * Gets the datetime2 value for this POrden.
     * 
     * @return datetime2
     */
    public java.util.Calendar getDatetime2() {
        return datetime2;
    }


    /**
     * Sets the datetime2 value for this POrden.
     * 
     * @param datetime2
     */
    public void setDatetime2(java.util.Calendar datetime2) {
        this.datetime2 = datetime2;
    }


    /**
     * Gets the fechaUltimoCambioEstado value for this POrden.
     * 
     * @return fechaUltimoCambioEstado
     */
    public java.util.Calendar getFechaUltimoCambioEstado() {
        return fechaUltimoCambioEstado;
    }


    /**
     * Sets the fechaUltimoCambioEstado value for this POrden.
     * 
     * @param fechaUltimoCambioEstado
     */
    public void setFechaUltimoCambioEstado(java.util.Calendar fechaUltimoCambioEstado) {
        this.fechaUltimoCambioEstado = fechaUltimoCambioEstado;
    }


    /**
     * Gets the unidades value for this POrden.
     * 
     * @return unidades
     */
    public java.lang.Integer getUnidades() {
        return unidades;
    }


    /**
     * Sets the unidades value for this POrden.
     * 
     * @param unidades
     */
    public void setUnidades(java.lang.Integer unidades) {
        this.unidades = unidades;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POrden)) return false;
        POrden other = (POrden) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            ((this.refDocumentoAdicional==null && other.getRefDocumentoAdicional()==null) || 
             (this.refDocumentoAdicional!=null &&
              this.refDocumentoAdicional.equals(other.getRefDocumentoAdicional()))) &&
            ((this.refDocumentoPedido==null && other.getRefDocumentoPedido()==null) || 
             (this.refDocumentoPedido!=null &&
              this.refDocumentoPedido.equals(other.getRefDocumentoPedido()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.tipoOrden==null && other.getTipoOrden()==null) || 
             (this.tipoOrden!=null &&
              this.tipoOrden.equals(other.getTipoOrden()))) &&
            ((this.tipoParada==null && other.getTipoParada()==null) || 
             (this.tipoParada!=null &&
              this.tipoParada.equals(other.getTipoParada()))) &&
            ((this.categoriaOrden==null && other.getCategoriaOrden()==null) || 
             (this.categoriaOrden!=null &&
              this.categoriaOrden.equals(other.getCategoriaOrden()))) &&
            ((this.refDocumentoRecoleccion==null && other.getRefDocumentoRecoleccion()==null) || 
             (this.refDocumentoRecoleccion!=null &&
              this.refDocumentoRecoleccion.equals(other.getRefDocumentoRecoleccion()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.fechaJornada==null && other.getFechaJornada()==null) || 
             (this.fechaJornada!=null &&
              this.fechaJornada.equals(other.getFechaJornada()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
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
            ((this.crearDomicilio==null && other.getCrearDomicilio()==null) || 
             (this.crearDomicilio!=null &&
              this.crearDomicilio.equals(other.getCrearDomicilio()))) &&
            ((this.orden==null && other.getOrden()==null) || 
             (this.orden!=null &&
              this.orden.equals(other.getOrden()))) &&
            ((this.inicioHorarioPlanificado==null && other.getInicioHorarioPlanificado()==null) || 
             (this.inicioHorarioPlanificado!=null &&
              this.inicioHorarioPlanificado.equals(other.getInicioHorarioPlanificado()))) &&
            ((this.finHorarioPlanificado==null && other.getFinHorarioPlanificado()==null) || 
             (this.finHorarioPlanificado!=null &&
              this.finHorarioPlanificado.equals(other.getFinHorarioPlanificado()))) &&
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
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.telefono2==null && other.getTelefono2()==null) || 
             (this.telefono2!=null &&
              this.telefono2.equals(other.getTelefono2()))) &&
            ((this.telefono3==null && other.getTelefono3()==null) || 
             (this.telefono3!=null &&
              this.telefono3.equals(other.getTelefono3()))) &&
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
            ((this.int1==null && other.getInt1()==null) || 
             (this.int1!=null &&
              this.int1.equals(other.getInt1()))) &&
            ((this.int2==null && other.getInt2()==null) || 
             (this.int2!=null &&
              this.int2.equals(other.getInt2()))) &&
            ((this.idRuta==null && other.getIdRuta()==null) || 
             (this.idRuta!=null &&
              this.idRuta.equals(other.getIdRuta()))) &&
            ((this.preOrden==null && other.getPreOrden()==null) || 
             (this.preOrden!=null &&
              this.preOrden.equals(other.getPreOrden()))) &&
            ((this.grupoConsolidacion==null && other.getGrupoConsolidacion()==null) || 
             (this.grupoConsolidacion!=null &&
              this.grupoConsolidacion.equals(other.getGrupoConsolidacion()))) &&
            ((this.prioridadAbsoluta==null && other.getPrioridadAbsoluta()==null) || 
             (this.prioridadAbsoluta!=null &&
              this.prioridadAbsoluta.equals(other.getPrioridadAbsoluta()))) &&
            ((this.grupoRutas==null && other.getGrupoRutas()==null) || 
             (this.grupoRutas!=null &&
              this.grupoRutas.equals(other.getGrupoRutas()))) &&
            ((this.tiempoLatencia==null && other.getTiempoLatencia()==null) || 
             (this.tiempoLatencia!=null &&
              this.tiempoLatencia.equals(other.getTiempoLatencia()))) &&
            ((this.tiempoEsperaPromedio==null && other.getTiempoEsperaPromedio()==null) || 
             (this.tiempoEsperaPromedio!=null &&
              this.tiempoEsperaPromedio.equals(other.getTiempoEsperaPromedio()))) &&
            ((this.depositoSalida==null && other.getDepositoSalida()==null) || 
             (this.depositoSalida!=null &&
              this.depositoSalida.equals(other.getDepositoSalida()))) &&
            ((this.depositoLlegada==null && other.getDepositoLlegada()==null) || 
             (this.depositoLlegada!=null &&
              this.depositoLlegada.equals(other.getDepositoLlegada()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.items==null && other.getItems()==null) || 
             (this.items!=null &&
              java.util.Arrays.equals(this.items, other.getItems()))) &&
            ((this.servicios==null && other.getServicios()==null) || 
             (this.servicios!=null &&
              java.util.Arrays.equals(this.servicios, other.getServicios()))) &&
            ((this.tipoJornada==null && other.getTipoJornada()==null) || 
             (this.tipoJornada!=null &&
              this.tipoJornada.equals(other.getTipoJornada()))) &&
            ((this.jornadaDescripcion==null && other.getJornadaDescripcion()==null) || 
             (this.jornadaDescripcion!=null &&
              this.jornadaDescripcion.equals(other.getJornadaDescripcion()))) &&
            ((this.codigoPostal==null && other.getCodigoPostal()==null) || 
             (this.codigoPostal!=null &&
              this.codigoPostal.equals(other.getCodigoPostal()))) &&
            ((this.motivoEstadoParadaDescripcion==null && other.getMotivoEstadoParadaDescripcion()==null) || 
             (this.motivoEstadoParadaDescripcion!=null &&
              this.motivoEstadoParadaDescripcion.equals(other.getMotivoEstadoParadaDescripcion()))) &&
            ((this.motivoEstadoParadaReferencia==null && other.getMotivoEstadoParadaReferencia()==null) || 
             (this.motivoEstadoParadaReferencia!=null &&
              this.motivoEstadoParadaReferencia.equals(other.getMotivoEstadoParadaReferencia()))) &&
            ((this.fotos==null && other.getFotos()==null) || 
             (this.fotos!=null &&
              java.util.Arrays.equals(this.fotos, other.getFotos()))) &&
            ((this.paradaItems==null && other.getParadaItems()==null) || 
             (this.paradaItems!=null &&
              java.util.Arrays.equals(this.paradaItems, other.getParadaItems()))) &&
            ((this.remito==null && other.getRemito()==null) || 
             (this.remito!=null &&
              this.remito.equals(other.getRemito()))) &&
            ((this.estadoOrden==null && other.getEstadoOrden()==null) || 
             (this.estadoOrden!=null &&
              this.estadoOrden.equals(other.getEstadoOrden()))) &&
            ((this.idOrden==null && other.getIdOrden()==null) || 
             (this.idOrden!=null &&
              this.idOrden.equals(other.getIdOrden()))) &&
            ((this.idJornada==null && other.getIdJornada()==null) || 
             (this.idJornada!=null &&
              this.idJornada.equals(other.getIdJornada()))) &&
            ((this.pesoMaximo==null && other.getPesoMaximo()==null) || 
             (this.pesoMaximo!=null &&
              this.pesoMaximo.equals(other.getPesoMaximo()))) &&
            ((this.volumenMaximo==null && other.getVolumenMaximo()==null) || 
             (this.volumenMaximo!=null &&
              this.volumenMaximo.equals(other.getVolumenMaximo()))) &&
            ((this.bultosMaximo==null && other.getBultosMaximo()==null) || 
             (this.bultosMaximo!=null &&
              this.bultosMaximo.equals(other.getBultosMaximo()))) &&
            ((this.costo==null && other.getCosto()==null) || 
             (this.costo!=null &&
              this.costo.equals(other.getCosto()))) &&
            ((this.inicioVisita==null && other.getInicioVisita()==null) || 
             (this.inicioVisita!=null &&
              this.inicioVisita.equals(other.getInicioVisita()))) &&
            ((this.finVisita==null && other.getFinVisita()==null) || 
             (this.finVisita!=null &&
              this.finVisita.equals(other.getFinVisita()))) &&
            ((this.inicioHorarioEstimado==null && other.getInicioHorarioEstimado()==null) || 
             (this.inicioHorarioEstimado!=null &&
              this.inicioHorarioEstimado.equals(other.getInicioHorarioEstimado()))) &&
            ((this.finHorarioEstimado==null && other.getFinHorarioEstimado()==null) || 
             (this.finHorarioEstimado!=null &&
              this.finHorarioEstimado.equals(other.getFinHorarioEstimado()))) &&
            ((this.inicioHorarioReal==null && other.getInicioHorarioReal()==null) || 
             (this.inicioHorarioReal!=null &&
              this.inicioHorarioReal.equals(other.getInicioHorarioReal()))) &&
            ((this.finHorarioReal==null && other.getFinHorarioReal()==null) || 
             (this.finHorarioReal!=null &&
              this.finHorarioReal.equals(other.getFinHorarioReal()))) &&
            ((this.usarProductos==null && other.getUsarProductos()==null) || 
             (this.usarProductos!=null &&
              this.usarProductos.equals(other.getUsarProductos()))) &&
            ((this.ultimaVisita==null && other.getUltimaVisita()==null) || 
             (this.ultimaVisita!=null &&
              this.ultimaVisita.equals(other.getUltimaVisita()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.fechaOrden==null && other.getFechaOrden()==null) || 
             (this.fechaOrden!=null &&
              this.fechaOrden.equals(other.getFechaOrden()))) &&
            ((this.datetime1==null && other.getDatetime1()==null) || 
             (this.datetime1!=null &&
              this.datetime1.equals(other.getDatetime1()))) &&
            ((this.datetime2==null && other.getDatetime2()==null) || 
             (this.datetime2!=null &&
              this.datetime2.equals(other.getDatetime2()))) &&
            ((this.fechaUltimoCambioEstado==null && other.getFechaUltimoCambioEstado()==null) || 
             (this.fechaUltimoCambioEstado!=null &&
              this.fechaUltimoCambioEstado.equals(other.getFechaUltimoCambioEstado()))) &&
            ((this.unidades==null && other.getUnidades()==null) || 
             (this.unidades!=null &&
              this.unidades.equals(other.getUnidades())));
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
        if (getSucursal() != null) {
            _hashCode += getSucursal().hashCode();
        }
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getRefDocumentoAdicional() != null) {
            _hashCode += getRefDocumentoAdicional().hashCode();
        }
        if (getRefDocumentoPedido() != null) {
            _hashCode += getRefDocumentoPedido().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getTipoOrden() != null) {
            _hashCode += getTipoOrden().hashCode();
        }
        if (getTipoParada() != null) {
            _hashCode += getTipoParada().hashCode();
        }
        if (getCategoriaOrden() != null) {
            _hashCode += getCategoriaOrden().hashCode();
        }
        if (getRefDocumentoRecoleccion() != null) {
            _hashCode += getRefDocumentoRecoleccion().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getFechaJornada() != null) {
            _hashCode += getFechaJornada().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
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
        if (getCrearDomicilio() != null) {
            _hashCode += getCrearDomicilio().hashCode();
        }
        if (getOrden() != null) {
            _hashCode += getOrden().hashCode();
        }
        if (getInicioHorarioPlanificado() != null) {
            _hashCode += getInicioHorarioPlanificado().hashCode();
        }
        if (getFinHorarioPlanificado() != null) {
            _hashCode += getFinHorarioPlanificado().hashCode();
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
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
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
        if (getInt1() != null) {
            _hashCode += getInt1().hashCode();
        }
        if (getInt2() != null) {
            _hashCode += getInt2().hashCode();
        }
        if (getIdRuta() != null) {
            _hashCode += getIdRuta().hashCode();
        }
        if (getPreOrden() != null) {
            _hashCode += getPreOrden().hashCode();
        }
        if (getGrupoConsolidacion() != null) {
            _hashCode += getGrupoConsolidacion().hashCode();
        }
        if (getPrioridadAbsoluta() != null) {
            _hashCode += getPrioridadAbsoluta().hashCode();
        }
        if (getGrupoRutas() != null) {
            _hashCode += getGrupoRutas().hashCode();
        }
        if (getTiempoLatencia() != null) {
            _hashCode += getTiempoLatencia().hashCode();
        }
        if (getTiempoEsperaPromedio() != null) {
            _hashCode += getTiempoEsperaPromedio().hashCode();
        }
        if (getDepositoSalida() != null) {
            _hashCode += getDepositoSalida().hashCode();
        }
        if (getDepositoLlegada() != null) {
            _hashCode += getDepositoLlegada().hashCode();
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
        if (getTipoJornada() != null) {
            _hashCode += getTipoJornada().hashCode();
        }
        if (getJornadaDescripcion() != null) {
            _hashCode += getJornadaDescripcion().hashCode();
        }
        if (getCodigoPostal() != null) {
            _hashCode += getCodigoPostal().hashCode();
        }
        if (getMotivoEstadoParadaDescripcion() != null) {
            _hashCode += getMotivoEstadoParadaDescripcion().hashCode();
        }
        if (getMotivoEstadoParadaReferencia() != null) {
            _hashCode += getMotivoEstadoParadaReferencia().hashCode();
        }
        if (getFotos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFotos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFotos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParadaItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParadaItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParadaItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRemito() != null) {
            _hashCode += getRemito().hashCode();
        }
        if (getEstadoOrden() != null) {
            _hashCode += getEstadoOrden().hashCode();
        }
        if (getIdOrden() != null) {
            _hashCode += getIdOrden().hashCode();
        }
        if (getIdJornada() != null) {
            _hashCode += getIdJornada().hashCode();
        }
        if (getPesoMaximo() != null) {
            _hashCode += getPesoMaximo().hashCode();
        }
        if (getVolumenMaximo() != null) {
            _hashCode += getVolumenMaximo().hashCode();
        }
        if (getBultosMaximo() != null) {
            _hashCode += getBultosMaximo().hashCode();
        }
        if (getCosto() != null) {
            _hashCode += getCosto().hashCode();
        }
        if (getInicioVisita() != null) {
            _hashCode += getInicioVisita().hashCode();
        }
        if (getFinVisita() != null) {
            _hashCode += getFinVisita().hashCode();
        }
        if (getInicioHorarioEstimado() != null) {
            _hashCode += getInicioHorarioEstimado().hashCode();
        }
        if (getFinHorarioEstimado() != null) {
            _hashCode += getFinHorarioEstimado().hashCode();
        }
        if (getInicioHorarioReal() != null) {
            _hashCode += getInicioHorarioReal().hashCode();
        }
        if (getFinHorarioReal() != null) {
            _hashCode += getFinHorarioReal().hashCode();
        }
        if (getUsarProductos() != null) {
            _hashCode += getUsarProductos().hashCode();
        }
        if (getUltimaVisita() != null) {
            _hashCode += getUltimaVisita().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFechaOrden() != null) {
            _hashCode += getFechaOrden().hashCode();
        }
        if (getDatetime1() != null) {
            _hashCode += getDatetime1().hashCode();
        }
        if (getDatetime2() != null) {
            _hashCode += getDatetime2().hashCode();
        }
        if (getFechaUltimoCambioEstado() != null) {
            _hashCode += getFechaUltimoCambioEstado().hashCode();
        }
        if (getUnidades() != null) {
            _hashCode += getUnidades().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POrden.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrden"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("refDocumentoPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumentoPedido"));
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
        elemField.setFieldName("tipoOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoriaOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CategoriaOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDocumentoRecoleccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDocumentoRecoleccion"));
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
        elemField.setFieldName("fechaJornada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaJornada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
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
        elemField.setFieldName("crearDomicilio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearDomicilio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Orden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioHorarioPlanificado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorarioPlanificado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorarioPlanificado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorarioPlanificado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("idRuta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdRuta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PreOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grupoConsolidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "GrupoConsolidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prioridadAbsoluta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PrioridadAbsoluta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grupoRutas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "GrupoRutas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempoLatencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoLatencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempoEsperaPromedio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoEsperaPromedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("campoDinamico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoDinamico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("items");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Items"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaItem"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("servicios");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Servicios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicioAdicional"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pServicioAdicional"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoJornada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoJornada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jornadaDescripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "JornadaDescripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("motivoEstadoParadaDescripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "MotivoEstadoParadaDescripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivoEstadoParadaReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "MotivoEstadoParadaReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fotos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fotos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pFoto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pFoto"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaItems");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ParadaItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultadoItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultadoItem"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Remito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pRemito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoOrdenEntrega"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idJornada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdJornada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoMaximo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PesoMaximo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volumenMaximo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "VolumenMaximo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bultosMaximo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "BultosMaximo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioVisita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioVisita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finVisita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinVisita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioHorarioEstimado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorarioEstimado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorarioEstimado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorarioEstimado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioHorarioReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorarioReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorarioReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorarioReal"));
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
        elemField.setFieldName("ultimaVisita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UltimaVisita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("fechaUltimoCambioEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaUltimoCambioEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Unidades"));
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
