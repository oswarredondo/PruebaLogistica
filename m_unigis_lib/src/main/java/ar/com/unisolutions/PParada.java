/**
 * PParada.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PParada  implements java.io.Serializable {
    private int secuencia;

    private java.lang.String refDocumento;

    private java.lang.String refDocumentoAdicional;

    private java.lang.String refDocumentoPedido;

    private java.lang.String tipoParada;

    private java.lang.String descripcion;

    private java.lang.String direccion;

    private java.lang.String nroPuerta;

    private java.lang.String entreCalles;

    private java.lang.String barrio;

    private java.lang.String localidad;

    private java.lang.String partido;

    private java.lang.String provincia;

    private double latitud;

    private double longitud;

    private double volumen;

    private double peso;

    private double bulto;

    private int valor;

    private double pallets;

    private java.lang.String telefono;

    private java.lang.String telefono2;

    private java.lang.String telefono3;

    private java.lang.String email;

    private int tiempoEstadia;

    private java.lang.Integer inicioHorario1;

    private java.lang.Integer finHorario1;

    private java.lang.Integer inicioHorario2;

    private java.lang.Integer finHorario2;

    private java.lang.Double distancia;

    private java.lang.String observaciones;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.Boolean requiereControl;

    private java.lang.String valorControl;

    private java.util.Calendar inicioHorarioPlanificado;

    private java.util.Calendar finHorarioPlanificado;

    private ar.com.unisolutions.PCliente cliente;

    private java.lang.String pais;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private ar.com.unisolutions.PRecursos[] recursos;

    private ar.com.unisolutions.POrdenEntregaConsultarViaje orden;

    private ar.com.unisolutions.PEstadoParada[] estados;

    private ar.com.unisolutions.PIncidencia[] incidencias;

    private ar.com.unisolutions.PParadaItem[] items;

    private ar.com.unisolutions.PClienteDador clienteDador;

    private java.lang.String estado;

    private java.lang.String referenciaExternaEstado;

    private java.lang.String referenciaMotivo;

    private java.lang.Double valor_Declarado;

    private java.math.BigDecimal _Costo;

    private java.lang.Integer int_1;

    private java.lang.Integer int_2;

    private java.lang.Float float_1;

    private java.lang.Float float_2;

    private java.util.Calendar inicio_Visita;

    private java.util.Calendar fin_Visita;

    private java.util.Calendar inicio_VisitaReal;

    private java.util.Calendar fin_VisitaReal;

    private java.util.Calendar fecha_UltimaModificacion;

    private java.lang.Integer tiempoDetencionMinimo;

    private java.lang.Integer idParada;

    private java.lang.Long idOrden;

    private java.lang.Boolean sumarizarTotalesDesdeItems;

    public PParada() {
    }

    public PParada(
           int secuencia,
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           java.lang.String refDocumentoPedido,
           java.lang.String tipoParada,
           java.lang.String descripcion,
           java.lang.String direccion,
           java.lang.String nroPuerta,
           java.lang.String entreCalles,
           java.lang.String barrio,
           java.lang.String localidad,
           java.lang.String partido,
           java.lang.String provincia,
           double latitud,
           double longitud,
           double volumen,
           double peso,
           double bulto,
           int valor,
           double pallets,
           java.lang.String telefono,
           java.lang.String telefono2,
           java.lang.String telefono3,
           java.lang.String email,
           int tiempoEstadia,
           java.lang.Integer inicioHorario1,
           java.lang.Integer finHorario1,
           java.lang.Integer inicioHorario2,
           java.lang.Integer finHorario2,
           java.lang.Double distancia,
           java.lang.String observaciones,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.Boolean requiereControl,
           java.lang.String valorControl,
           java.util.Calendar inicioHorarioPlanificado,
           java.util.Calendar finHorarioPlanificado,
           ar.com.unisolutions.PCliente cliente,
           java.lang.String pais,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           ar.com.unisolutions.PRecursos[] recursos,
           ar.com.unisolutions.POrdenEntregaConsultarViaje orden,
           ar.com.unisolutions.PEstadoParada[] estados,
           ar.com.unisolutions.PIncidencia[] incidencias,
           ar.com.unisolutions.PParadaItem[] items,
           ar.com.unisolutions.PClienteDador clienteDador,
           java.lang.String estado,
           java.lang.String referenciaExternaEstado,
           java.lang.String referenciaMotivo,
           java.lang.Double valor_Declarado,
           java.math.BigDecimal _Costo,
           java.lang.Integer int_1,
           java.lang.Integer int_2,
           java.lang.Float float_1,
           java.lang.Float float_2,
           java.util.Calendar inicio_Visita,
           java.util.Calendar fin_Visita,
           java.util.Calendar inicio_VisitaReal,
           java.util.Calendar fin_VisitaReal,
           java.util.Calendar fecha_UltimaModificacion,
           java.lang.Integer tiempoDetencionMinimo,
           java.lang.Integer idParada,
           java.lang.Long idOrden,
           java.lang.Boolean sumarizarTotalesDesdeItems) {
           this.secuencia = secuencia;
           this.refDocumento = refDocumento;
           this.refDocumentoAdicional = refDocumentoAdicional;
           this.refDocumentoPedido = refDocumentoPedido;
           this.tipoParada = tipoParada;
           this.descripcion = descripcion;
           this.direccion = direccion;
           this.nroPuerta = nroPuerta;
           this.entreCalles = entreCalles;
           this.barrio = barrio;
           this.localidad = localidad;
           this.partido = partido;
           this.provincia = provincia;
           this.latitud = latitud;
           this.longitud = longitud;
           this.volumen = volumen;
           this.peso = peso;
           this.bulto = bulto;
           this.valor = valor;
           this.pallets = pallets;
           this.telefono = telefono;
           this.telefono2 = telefono2;
           this.telefono3 = telefono3;
           this.email = email;
           this.tiempoEstadia = tiempoEstadia;
           this.inicioHorario1 = inicioHorario1;
           this.finHorario1 = finHorario1;
           this.inicioHorario2 = inicioHorario2;
           this.finHorario2 = finHorario2;
           this.distancia = distancia;
           this.observaciones = observaciones;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.requiereControl = requiereControl;
           this.valorControl = valorControl;
           this.inicioHorarioPlanificado = inicioHorarioPlanificado;
           this.finHorarioPlanificado = finHorarioPlanificado;
           this.cliente = cliente;
           this.pais = pais;
           this.campoDinamico = campoDinamico;
           this.recursos = recursos;
           this.orden = orden;
           this.estados = estados;
           this.incidencias = incidencias;
           this.items = items;
           this.clienteDador = clienteDador;
           this.estado = estado;
           this.referenciaExternaEstado = referenciaExternaEstado;
           this.referenciaMotivo = referenciaMotivo;
           this.valor_Declarado = valor_Declarado;
           this._Costo = _Costo;
           this.int_1 = int_1;
           this.int_2 = int_2;
           this.float_1 = float_1;
           this.float_2 = float_2;
           this.inicio_Visita = inicio_Visita;
           this.fin_Visita = fin_Visita;
           this.inicio_VisitaReal = inicio_VisitaReal;
           this.fin_VisitaReal = fin_VisitaReal;
           this.fecha_UltimaModificacion = fecha_UltimaModificacion;
           this.tiempoDetencionMinimo = tiempoDetencionMinimo;
           this.idParada = idParada;
           this.idOrden = idOrden;
           this.sumarizarTotalesDesdeItems = sumarizarTotalesDesdeItems;
    }


    /**
     * Gets the secuencia value for this PParada.
     * 
     * @return secuencia
     */
    public int getSecuencia() {
        return secuencia;
    }


    /**
     * Sets the secuencia value for this PParada.
     * 
     * @param secuencia
     */
    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }


    /**
     * Gets the refDocumento value for this PParada.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this PParada.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the refDocumentoAdicional value for this PParada.
     * 
     * @return refDocumentoAdicional
     */
    public java.lang.String getRefDocumentoAdicional() {
        return refDocumentoAdicional;
    }


    /**
     * Sets the refDocumentoAdicional value for this PParada.
     * 
     * @param refDocumentoAdicional
     */
    public void setRefDocumentoAdicional(java.lang.String refDocumentoAdicional) {
        this.refDocumentoAdicional = refDocumentoAdicional;
    }


    /**
     * Gets the refDocumentoPedido value for this PParada.
     * 
     * @return refDocumentoPedido
     */
    public java.lang.String getRefDocumentoPedido() {
        return refDocumentoPedido;
    }


    /**
     * Sets the refDocumentoPedido value for this PParada.
     * 
     * @param refDocumentoPedido
     */
    public void setRefDocumentoPedido(java.lang.String refDocumentoPedido) {
        this.refDocumentoPedido = refDocumentoPedido;
    }


    /**
     * Gets the tipoParada value for this PParada.
     * 
     * @return tipoParada
     */
    public java.lang.String getTipoParada() {
        return tipoParada;
    }


    /**
     * Sets the tipoParada value for this PParada.
     * 
     * @param tipoParada
     */
    public void setTipoParada(java.lang.String tipoParada) {
        this.tipoParada = tipoParada;
    }


    /**
     * Gets the descripcion value for this PParada.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PParada.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the direccion value for this PParada.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this PParada.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the nroPuerta value for this PParada.
     * 
     * @return nroPuerta
     */
    public java.lang.String getNroPuerta() {
        return nroPuerta;
    }


    /**
     * Sets the nroPuerta value for this PParada.
     * 
     * @param nroPuerta
     */
    public void setNroPuerta(java.lang.String nroPuerta) {
        this.nroPuerta = nroPuerta;
    }


    /**
     * Gets the entreCalles value for this PParada.
     * 
     * @return entreCalles
     */
    public java.lang.String getEntreCalles() {
        return entreCalles;
    }


    /**
     * Sets the entreCalles value for this PParada.
     * 
     * @param entreCalles
     */
    public void setEntreCalles(java.lang.String entreCalles) {
        this.entreCalles = entreCalles;
    }


    /**
     * Gets the barrio value for this PParada.
     * 
     * @return barrio
     */
    public java.lang.String getBarrio() {
        return barrio;
    }


    /**
     * Sets the barrio value for this PParada.
     * 
     * @param barrio
     */
    public void setBarrio(java.lang.String barrio) {
        this.barrio = barrio;
    }


    /**
     * Gets the localidad value for this PParada.
     * 
     * @return localidad
     */
    public java.lang.String getLocalidad() {
        return localidad;
    }


    /**
     * Sets the localidad value for this PParada.
     * 
     * @param localidad
     */
    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }


    /**
     * Gets the partido value for this PParada.
     * 
     * @return partido
     */
    public java.lang.String getPartido() {
        return partido;
    }


    /**
     * Sets the partido value for this PParada.
     * 
     * @param partido
     */
    public void setPartido(java.lang.String partido) {
        this.partido = partido;
    }


    /**
     * Gets the provincia value for this PParada.
     * 
     * @return provincia
     */
    public java.lang.String getProvincia() {
        return provincia;
    }


    /**
     * Sets the provincia value for this PParada.
     * 
     * @param provincia
     */
    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }


    /**
     * Gets the latitud value for this PParada.
     * 
     * @return latitud
     */
    public double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this PParada.
     * 
     * @param latitud
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this PParada.
     * 
     * @return longitud
     */
    public double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this PParada.
     * 
     * @param longitud
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the volumen value for this PParada.
     * 
     * @return volumen
     */
    public double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this PParada.
     * 
     * @param volumen
     */
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this PParada.
     * 
     * @return peso
     */
    public double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this PParada.
     * 
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }


    /**
     * Gets the bulto value for this PParada.
     * 
     * @return bulto
     */
    public double getBulto() {
        return bulto;
    }


    /**
     * Sets the bulto value for this PParada.
     * 
     * @param bulto
     */
    public void setBulto(double bulto) {
        this.bulto = bulto;
    }


    /**
     * Gets the valor value for this PParada.
     * 
     * @return valor
     */
    public int getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this PParada.
     * 
     * @param valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }


    /**
     * Gets the pallets value for this PParada.
     * 
     * @return pallets
     */
    public double getPallets() {
        return pallets;
    }


    /**
     * Sets the pallets value for this PParada.
     * 
     * @param pallets
     */
    public void setPallets(double pallets) {
        this.pallets = pallets;
    }


    /**
     * Gets the telefono value for this PParada.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this PParada.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the telefono2 value for this PParada.
     * 
     * @return telefono2
     */
    public java.lang.String getTelefono2() {
        return telefono2;
    }


    /**
     * Sets the telefono2 value for this PParada.
     * 
     * @param telefono2
     */
    public void setTelefono2(java.lang.String telefono2) {
        this.telefono2 = telefono2;
    }


    /**
     * Gets the telefono3 value for this PParada.
     * 
     * @return telefono3
     */
    public java.lang.String getTelefono3() {
        return telefono3;
    }


    /**
     * Sets the telefono3 value for this PParada.
     * 
     * @param telefono3
     */
    public void setTelefono3(java.lang.String telefono3) {
        this.telefono3 = telefono3;
    }


    /**
     * Gets the email value for this PParada.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this PParada.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the tiempoEstadia value for this PParada.
     * 
     * @return tiempoEstadia
     */
    public int getTiempoEstadia() {
        return tiempoEstadia;
    }


    /**
     * Sets the tiempoEstadia value for this PParada.
     * 
     * @param tiempoEstadia
     */
    public void setTiempoEstadia(int tiempoEstadia) {
        this.tiempoEstadia = tiempoEstadia;
    }


    /**
     * Gets the inicioHorario1 value for this PParada.
     * 
     * @return inicioHorario1
     */
    public java.lang.Integer getInicioHorario1() {
        return inicioHorario1;
    }


    /**
     * Sets the inicioHorario1 value for this PParada.
     * 
     * @param inicioHorario1
     */
    public void setInicioHorario1(java.lang.Integer inicioHorario1) {
        this.inicioHorario1 = inicioHorario1;
    }


    /**
     * Gets the finHorario1 value for this PParada.
     * 
     * @return finHorario1
     */
    public java.lang.Integer getFinHorario1() {
        return finHorario1;
    }


    /**
     * Sets the finHorario1 value for this PParada.
     * 
     * @param finHorario1
     */
    public void setFinHorario1(java.lang.Integer finHorario1) {
        this.finHorario1 = finHorario1;
    }


    /**
     * Gets the inicioHorario2 value for this PParada.
     * 
     * @return inicioHorario2
     */
    public java.lang.Integer getInicioHorario2() {
        return inicioHorario2;
    }


    /**
     * Sets the inicioHorario2 value for this PParada.
     * 
     * @param inicioHorario2
     */
    public void setInicioHorario2(java.lang.Integer inicioHorario2) {
        this.inicioHorario2 = inicioHorario2;
    }


    /**
     * Gets the finHorario2 value for this PParada.
     * 
     * @return finHorario2
     */
    public java.lang.Integer getFinHorario2() {
        return finHorario2;
    }


    /**
     * Sets the finHorario2 value for this PParada.
     * 
     * @param finHorario2
     */
    public void setFinHorario2(java.lang.Integer finHorario2) {
        this.finHorario2 = finHorario2;
    }


    /**
     * Gets the distancia value for this PParada.
     * 
     * @return distancia
     */
    public java.lang.Double getDistancia() {
        return distancia;
    }


    /**
     * Sets the distancia value for this PParada.
     * 
     * @param distancia
     */
    public void setDistancia(java.lang.Double distancia) {
        this.distancia = distancia;
    }


    /**
     * Gets the observaciones value for this PParada.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PParada.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the varchar1 value for this PParada.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this PParada.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this PParada.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this PParada.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the requiereControl value for this PParada.
     * 
     * @return requiereControl
     */
    public java.lang.Boolean getRequiereControl() {
        return requiereControl;
    }


    /**
     * Sets the requiereControl value for this PParada.
     * 
     * @param requiereControl
     */
    public void setRequiereControl(java.lang.Boolean requiereControl) {
        this.requiereControl = requiereControl;
    }


    /**
     * Gets the valorControl value for this PParada.
     * 
     * @return valorControl
     */
    public java.lang.String getValorControl() {
        return valorControl;
    }


    /**
     * Sets the valorControl value for this PParada.
     * 
     * @param valorControl
     */
    public void setValorControl(java.lang.String valorControl) {
        this.valorControl = valorControl;
    }


    /**
     * Gets the inicioHorarioPlanificado value for this PParada.
     * 
     * @return inicioHorarioPlanificado
     */
    public java.util.Calendar getInicioHorarioPlanificado() {
        return inicioHorarioPlanificado;
    }


    /**
     * Sets the inicioHorarioPlanificado value for this PParada.
     * 
     * @param inicioHorarioPlanificado
     */
    public void setInicioHorarioPlanificado(java.util.Calendar inicioHorarioPlanificado) {
        this.inicioHorarioPlanificado = inicioHorarioPlanificado;
    }


    /**
     * Gets the finHorarioPlanificado value for this PParada.
     * 
     * @return finHorarioPlanificado
     */
    public java.util.Calendar getFinHorarioPlanificado() {
        return finHorarioPlanificado;
    }


    /**
     * Sets the finHorarioPlanificado value for this PParada.
     * 
     * @param finHorarioPlanificado
     */
    public void setFinHorarioPlanificado(java.util.Calendar finHorarioPlanificado) {
        this.finHorarioPlanificado = finHorarioPlanificado;
    }


    /**
     * Gets the cliente value for this PParada.
     * 
     * @return cliente
     */
    public ar.com.unisolutions.PCliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this PParada.
     * 
     * @param cliente
     */
    public void setCliente(ar.com.unisolutions.PCliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the pais value for this PParada.
     * 
     * @return pais
     */
    public java.lang.String getPais() {
        return pais;
    }


    /**
     * Sets the pais value for this PParada.
     * 
     * @param pais
     */
    public void setPais(java.lang.String pais) {
        this.pais = pais;
    }


    /**
     * Gets the campoDinamico value for this PParada.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this PParada.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the recursos value for this PParada.
     * 
     * @return recursos
     */
    public ar.com.unisolutions.PRecursos[] getRecursos() {
        return recursos;
    }


    /**
     * Sets the recursos value for this PParada.
     * 
     * @param recursos
     */
    public void setRecursos(ar.com.unisolutions.PRecursos[] recursos) {
        this.recursos = recursos;
    }


    /**
     * Gets the orden value for this PParada.
     * 
     * @return orden
     */
    public ar.com.unisolutions.POrdenEntregaConsultarViaje getOrden() {
        return orden;
    }


    /**
     * Sets the orden value for this PParada.
     * 
     * @param orden
     */
    public void setOrden(ar.com.unisolutions.POrdenEntregaConsultarViaje orden) {
        this.orden = orden;
    }


    /**
     * Gets the estados value for this PParada.
     * 
     * @return estados
     */
    public ar.com.unisolutions.PEstadoParada[] getEstados() {
        return estados;
    }


    /**
     * Sets the estados value for this PParada.
     * 
     * @param estados
     */
    public void setEstados(ar.com.unisolutions.PEstadoParada[] estados) {
        this.estados = estados;
    }


    /**
     * Gets the incidencias value for this PParada.
     * 
     * @return incidencias
     */
    public ar.com.unisolutions.PIncidencia[] getIncidencias() {
        return incidencias;
    }


    /**
     * Sets the incidencias value for this PParada.
     * 
     * @param incidencias
     */
    public void setIncidencias(ar.com.unisolutions.PIncidencia[] incidencias) {
        this.incidencias = incidencias;
    }


    /**
     * Gets the items value for this PParada.
     * 
     * @return items
     */
    public ar.com.unisolutions.PParadaItem[] getItems() {
        return items;
    }


    /**
     * Sets the items value for this PParada.
     * 
     * @param items
     */
    public void setItems(ar.com.unisolutions.PParadaItem[] items) {
        this.items = items;
    }


    /**
     * Gets the clienteDador value for this PParada.
     * 
     * @return clienteDador
     */
    public ar.com.unisolutions.PClienteDador getClienteDador() {
        return clienteDador;
    }


    /**
     * Sets the clienteDador value for this PParada.
     * 
     * @param clienteDador
     */
    public void setClienteDador(ar.com.unisolutions.PClienteDador clienteDador) {
        this.clienteDador = clienteDador;
    }


    /**
     * Gets the estado value for this PParada.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PParada.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the referenciaExternaEstado value for this PParada.
     * 
     * @return referenciaExternaEstado
     */
    public java.lang.String getReferenciaExternaEstado() {
        return referenciaExternaEstado;
    }


    /**
     * Sets the referenciaExternaEstado value for this PParada.
     * 
     * @param referenciaExternaEstado
     */
    public void setReferenciaExternaEstado(java.lang.String referenciaExternaEstado) {
        this.referenciaExternaEstado = referenciaExternaEstado;
    }


    /**
     * Gets the referenciaMotivo value for this PParada.
     * 
     * @return referenciaMotivo
     */
    public java.lang.String getReferenciaMotivo() {
        return referenciaMotivo;
    }


    /**
     * Sets the referenciaMotivo value for this PParada.
     * 
     * @param referenciaMotivo
     */
    public void setReferenciaMotivo(java.lang.String referenciaMotivo) {
        this.referenciaMotivo = referenciaMotivo;
    }


    /**
     * Gets the valor_Declarado value for this PParada.
     * 
     * @return valor_Declarado
     */
    public java.lang.Double getValor_Declarado() {
        return valor_Declarado;
    }


    /**
     * Sets the valor_Declarado value for this PParada.
     * 
     * @param valor_Declarado
     */
    public void setValor_Declarado(java.lang.Double valor_Declarado) {
        this.valor_Declarado = valor_Declarado;
    }


    /**
     * Gets the _Costo value for this PParada.
     * 
     * @return _Costo
     */
    public java.math.BigDecimal get_Costo() {
        return _Costo;
    }


    /**
     * Sets the _Costo value for this PParada.
     * 
     * @param _Costo
     */
    public void set_Costo(java.math.BigDecimal _Costo) {
        this._Costo = _Costo;
    }


    /**
     * Gets the int_1 value for this PParada.
     * 
     * @return int_1
     */
    public java.lang.Integer getInt_1() {
        return int_1;
    }


    /**
     * Sets the int_1 value for this PParada.
     * 
     * @param int_1
     */
    public void setInt_1(java.lang.Integer int_1) {
        this.int_1 = int_1;
    }


    /**
     * Gets the int_2 value for this PParada.
     * 
     * @return int_2
     */
    public java.lang.Integer getInt_2() {
        return int_2;
    }


    /**
     * Sets the int_2 value for this PParada.
     * 
     * @param int_2
     */
    public void setInt_2(java.lang.Integer int_2) {
        this.int_2 = int_2;
    }


    /**
     * Gets the float_1 value for this PParada.
     * 
     * @return float_1
     */
    public java.lang.Float getFloat_1() {
        return float_1;
    }


    /**
     * Sets the float_1 value for this PParada.
     * 
     * @param float_1
     */
    public void setFloat_1(java.lang.Float float_1) {
        this.float_1 = float_1;
    }


    /**
     * Gets the float_2 value for this PParada.
     * 
     * @return float_2
     */
    public java.lang.Float getFloat_2() {
        return float_2;
    }


    /**
     * Sets the float_2 value for this PParada.
     * 
     * @param float_2
     */
    public void setFloat_2(java.lang.Float float_2) {
        this.float_2 = float_2;
    }


    /**
     * Gets the inicio_Visita value for this PParada.
     * 
     * @return inicio_Visita
     */
    public java.util.Calendar getInicio_Visita() {
        return inicio_Visita;
    }


    /**
     * Sets the inicio_Visita value for this PParada.
     * 
     * @param inicio_Visita
     */
    public void setInicio_Visita(java.util.Calendar inicio_Visita) {
        this.inicio_Visita = inicio_Visita;
    }


    /**
     * Gets the fin_Visita value for this PParada.
     * 
     * @return fin_Visita
     */
    public java.util.Calendar getFin_Visita() {
        return fin_Visita;
    }


    /**
     * Sets the fin_Visita value for this PParada.
     * 
     * @param fin_Visita
     */
    public void setFin_Visita(java.util.Calendar fin_Visita) {
        this.fin_Visita = fin_Visita;
    }


    /**
     * Gets the inicio_VisitaReal value for this PParada.
     * 
     * @return inicio_VisitaReal
     */
    public java.util.Calendar getInicio_VisitaReal() {
        return inicio_VisitaReal;
    }


    /**
     * Sets the inicio_VisitaReal value for this PParada.
     * 
     * @param inicio_VisitaReal
     */
    public void setInicio_VisitaReal(java.util.Calendar inicio_VisitaReal) {
        this.inicio_VisitaReal = inicio_VisitaReal;
    }


    /**
     * Gets the fin_VisitaReal value for this PParada.
     * 
     * @return fin_VisitaReal
     */
    public java.util.Calendar getFin_VisitaReal() {
        return fin_VisitaReal;
    }


    /**
     * Sets the fin_VisitaReal value for this PParada.
     * 
     * @param fin_VisitaReal
     */
    public void setFin_VisitaReal(java.util.Calendar fin_VisitaReal) {
        this.fin_VisitaReal = fin_VisitaReal;
    }


    /**
     * Gets the fecha_UltimaModificacion value for this PParada.
     * 
     * @return fecha_UltimaModificacion
     */
    public java.util.Calendar getFecha_UltimaModificacion() {
        return fecha_UltimaModificacion;
    }


    /**
     * Sets the fecha_UltimaModificacion value for this PParada.
     * 
     * @param fecha_UltimaModificacion
     */
    public void setFecha_UltimaModificacion(java.util.Calendar fecha_UltimaModificacion) {
        this.fecha_UltimaModificacion = fecha_UltimaModificacion;
    }


    /**
     * Gets the tiempoDetencionMinimo value for this PParada.
     * 
     * @return tiempoDetencionMinimo
     */
    public java.lang.Integer getTiempoDetencionMinimo() {
        return tiempoDetencionMinimo;
    }


    /**
     * Sets the tiempoDetencionMinimo value for this PParada.
     * 
     * @param tiempoDetencionMinimo
     */
    public void setTiempoDetencionMinimo(java.lang.Integer tiempoDetencionMinimo) {
        this.tiempoDetencionMinimo = tiempoDetencionMinimo;
    }


    /**
     * Gets the idParada value for this PParada.
     * 
     * @return idParada
     */
    public java.lang.Integer getIdParada() {
        return idParada;
    }


    /**
     * Sets the idParada value for this PParada.
     * 
     * @param idParada
     */
    public void setIdParada(java.lang.Integer idParada) {
        this.idParada = idParada;
    }


    /**
     * Gets the idOrden value for this PParada.
     * 
     * @return idOrden
     */
    public java.lang.Long getIdOrden() {
        return idOrden;
    }


    /**
     * Sets the idOrden value for this PParada.
     * 
     * @param idOrden
     */
    public void setIdOrden(java.lang.Long idOrden) {
        this.idOrden = idOrden;
    }


    /**
     * Gets the sumarizarTotalesDesdeItems value for this PParada.
     * 
     * @return sumarizarTotalesDesdeItems
     */
    public java.lang.Boolean getSumarizarTotalesDesdeItems() {
        return sumarizarTotalesDesdeItems;
    }


    /**
     * Sets the sumarizarTotalesDesdeItems value for this PParada.
     * 
     * @param sumarizarTotalesDesdeItems
     */
    public void setSumarizarTotalesDesdeItems(java.lang.Boolean sumarizarTotalesDesdeItems) {
        this.sumarizarTotalesDesdeItems = sumarizarTotalesDesdeItems;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PParada)) return false;
        PParada other = (PParada) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.secuencia == other.getSecuencia() &&
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            ((this.refDocumentoAdicional==null && other.getRefDocumentoAdicional()==null) || 
             (this.refDocumentoAdicional!=null &&
              this.refDocumentoAdicional.equals(other.getRefDocumentoAdicional()))) &&
            ((this.refDocumentoPedido==null && other.getRefDocumentoPedido()==null) || 
             (this.refDocumentoPedido!=null &&
              this.refDocumentoPedido.equals(other.getRefDocumentoPedido()))) &&
            ((this.tipoParada==null && other.getTipoParada()==null) || 
             (this.tipoParada!=null &&
              this.tipoParada.equals(other.getTipoParada()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.nroPuerta==null && other.getNroPuerta()==null) || 
             (this.nroPuerta!=null &&
              this.nroPuerta.equals(other.getNroPuerta()))) &&
            ((this.entreCalles==null && other.getEntreCalles()==null) || 
             (this.entreCalles!=null &&
              this.entreCalles.equals(other.getEntreCalles()))) &&
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
            this.latitud == other.getLatitud() &&
            this.longitud == other.getLongitud() &&
            this.volumen == other.getVolumen() &&
            this.peso == other.getPeso() &&
            this.bulto == other.getBulto() &&
            this.valor == other.getValor() &&
            this.pallets == other.getPallets() &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.telefono2==null && other.getTelefono2()==null) || 
             (this.telefono2!=null &&
              this.telefono2.equals(other.getTelefono2()))) &&
            ((this.telefono3==null && other.getTelefono3()==null) || 
             (this.telefono3!=null &&
              this.telefono3.equals(other.getTelefono3()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            this.tiempoEstadia == other.getTiempoEstadia() &&
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
            ((this.distancia==null && other.getDistancia()==null) || 
             (this.distancia!=null &&
              this.distancia.equals(other.getDistancia()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            ((this.varchar1==null && other.getVarchar1()==null) || 
             (this.varchar1!=null &&
              this.varchar1.equals(other.getVarchar1()))) &&
            ((this.varchar2==null && other.getVarchar2()==null) || 
             (this.varchar2!=null &&
              this.varchar2.equals(other.getVarchar2()))) &&
            ((this.requiereControl==null && other.getRequiereControl()==null) || 
             (this.requiereControl!=null &&
              this.requiereControl.equals(other.getRequiereControl()))) &&
            ((this.valorControl==null && other.getValorControl()==null) || 
             (this.valorControl!=null &&
              this.valorControl.equals(other.getValorControl()))) &&
            ((this.inicioHorarioPlanificado==null && other.getInicioHorarioPlanificado()==null) || 
             (this.inicioHorarioPlanificado!=null &&
              this.inicioHorarioPlanificado.equals(other.getInicioHorarioPlanificado()))) &&
            ((this.finHorarioPlanificado==null && other.getFinHorarioPlanificado()==null) || 
             (this.finHorarioPlanificado!=null &&
              this.finHorarioPlanificado.equals(other.getFinHorarioPlanificado()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.pais==null && other.getPais()==null) || 
             (this.pais!=null &&
              this.pais.equals(other.getPais()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.recursos==null && other.getRecursos()==null) || 
             (this.recursos!=null &&
              java.util.Arrays.equals(this.recursos, other.getRecursos()))) &&
            ((this.orden==null && other.getOrden()==null) || 
             (this.orden!=null &&
              this.orden.equals(other.getOrden()))) &&
            ((this.estados==null && other.getEstados()==null) || 
             (this.estados!=null &&
              java.util.Arrays.equals(this.estados, other.getEstados()))) &&
            ((this.incidencias==null && other.getIncidencias()==null) || 
             (this.incidencias!=null &&
              java.util.Arrays.equals(this.incidencias, other.getIncidencias()))) &&
            ((this.items==null && other.getItems()==null) || 
             (this.items!=null &&
              java.util.Arrays.equals(this.items, other.getItems()))) &&
            ((this.clienteDador==null && other.getClienteDador()==null) || 
             (this.clienteDador!=null &&
              this.clienteDador.equals(other.getClienteDador()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.referenciaExternaEstado==null && other.getReferenciaExternaEstado()==null) || 
             (this.referenciaExternaEstado!=null &&
              this.referenciaExternaEstado.equals(other.getReferenciaExternaEstado()))) &&
            ((this.referenciaMotivo==null && other.getReferenciaMotivo()==null) || 
             (this.referenciaMotivo!=null &&
              this.referenciaMotivo.equals(other.getReferenciaMotivo()))) &&
            ((this.valor_Declarado==null && other.getValor_Declarado()==null) || 
             (this.valor_Declarado!=null &&
              this.valor_Declarado.equals(other.getValor_Declarado()))) &&
            ((this._Costo==null && other.get_Costo()==null) || 
             (this._Costo!=null &&
              this._Costo.equals(other.get_Costo()))) &&
            ((this.int_1==null && other.getInt_1()==null) || 
             (this.int_1!=null &&
              this.int_1.equals(other.getInt_1()))) &&
            ((this.int_2==null && other.getInt_2()==null) || 
             (this.int_2!=null &&
              this.int_2.equals(other.getInt_2()))) &&
            ((this.float_1==null && other.getFloat_1()==null) || 
             (this.float_1!=null &&
              this.float_1.equals(other.getFloat_1()))) &&
            ((this.float_2==null && other.getFloat_2()==null) || 
             (this.float_2!=null &&
              this.float_2.equals(other.getFloat_2()))) &&
            ((this.inicio_Visita==null && other.getInicio_Visita()==null) || 
             (this.inicio_Visita!=null &&
              this.inicio_Visita.equals(other.getInicio_Visita()))) &&
            ((this.fin_Visita==null && other.getFin_Visita()==null) || 
             (this.fin_Visita!=null &&
              this.fin_Visita.equals(other.getFin_Visita()))) &&
            ((this.inicio_VisitaReal==null && other.getInicio_VisitaReal()==null) || 
             (this.inicio_VisitaReal!=null &&
              this.inicio_VisitaReal.equals(other.getInicio_VisitaReal()))) &&
            ((this.fin_VisitaReal==null && other.getFin_VisitaReal()==null) || 
             (this.fin_VisitaReal!=null &&
              this.fin_VisitaReal.equals(other.getFin_VisitaReal()))) &&
            ((this.fecha_UltimaModificacion==null && other.getFecha_UltimaModificacion()==null) || 
             (this.fecha_UltimaModificacion!=null &&
              this.fecha_UltimaModificacion.equals(other.getFecha_UltimaModificacion()))) &&
            ((this.tiempoDetencionMinimo==null && other.getTiempoDetencionMinimo()==null) || 
             (this.tiempoDetencionMinimo!=null &&
              this.tiempoDetencionMinimo.equals(other.getTiempoDetencionMinimo()))) &&
            ((this.idParada==null && other.getIdParada()==null) || 
             (this.idParada!=null &&
              this.idParada.equals(other.getIdParada()))) &&
            ((this.idOrden==null && other.getIdOrden()==null) || 
             (this.idOrden!=null &&
              this.idOrden.equals(other.getIdOrden()))) &&
            ((this.sumarizarTotalesDesdeItems==null && other.getSumarizarTotalesDesdeItems()==null) || 
             (this.sumarizarTotalesDesdeItems!=null &&
              this.sumarizarTotalesDesdeItems.equals(other.getSumarizarTotalesDesdeItems())));
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
        _hashCode += getSecuencia();
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getRefDocumentoAdicional() != null) {
            _hashCode += getRefDocumentoAdicional().hashCode();
        }
        if (getRefDocumentoPedido() != null) {
            _hashCode += getRefDocumentoPedido().hashCode();
        }
        if (getTipoParada() != null) {
            _hashCode += getTipoParada().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getNroPuerta() != null) {
            _hashCode += getNroPuerta().hashCode();
        }
        if (getEntreCalles() != null) {
            _hashCode += getEntreCalles().hashCode();
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
        _hashCode += new Double(getLatitud()).hashCode();
        _hashCode += new Double(getLongitud()).hashCode();
        _hashCode += new Double(getVolumen()).hashCode();
        _hashCode += new Double(getPeso()).hashCode();
        _hashCode += new Double(getBulto()).hashCode();
        _hashCode += getValor();
        _hashCode += new Double(getPallets()).hashCode();
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getTelefono2() != null) {
            _hashCode += getTelefono2().hashCode();
        }
        if (getTelefono3() != null) {
            _hashCode += getTelefono3().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        _hashCode += getTiempoEstadia();
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
        if (getDistancia() != null) {
            _hashCode += getDistancia().hashCode();
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
        if (getRequiereControl() != null) {
            _hashCode += getRequiereControl().hashCode();
        }
        if (getValorControl() != null) {
            _hashCode += getValorControl().hashCode();
        }
        if (getInicioHorarioPlanificado() != null) {
            _hashCode += getInicioHorarioPlanificado().hashCode();
        }
        if (getFinHorarioPlanificado() != null) {
            _hashCode += getFinHorarioPlanificado().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getPais() != null) {
            _hashCode += getPais().hashCode();
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
        if (getOrden() != null) {
            _hashCode += getOrden().hashCode();
        }
        if (getEstados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEstados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEstados(), i);
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
        if (getClienteDador() != null) {
            _hashCode += getClienteDador().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getReferenciaExternaEstado() != null) {
            _hashCode += getReferenciaExternaEstado().hashCode();
        }
        if (getReferenciaMotivo() != null) {
            _hashCode += getReferenciaMotivo().hashCode();
        }
        if (getValor_Declarado() != null) {
            _hashCode += getValor_Declarado().hashCode();
        }
        if (get_Costo() != null) {
            _hashCode += get_Costo().hashCode();
        }
        if (getInt_1() != null) {
            _hashCode += getInt_1().hashCode();
        }
        if (getInt_2() != null) {
            _hashCode += getInt_2().hashCode();
        }
        if (getFloat_1() != null) {
            _hashCode += getFloat_1().hashCode();
        }
        if (getFloat_2() != null) {
            _hashCode += getFloat_2().hashCode();
        }
        if (getInicio_Visita() != null) {
            _hashCode += getInicio_Visita().hashCode();
        }
        if (getFin_Visita() != null) {
            _hashCode += getFin_Visita().hashCode();
        }
        if (getInicio_VisitaReal() != null) {
            _hashCode += getInicio_VisitaReal().hashCode();
        }
        if (getFin_VisitaReal() != null) {
            _hashCode += getFin_VisitaReal().hashCode();
        }
        if (getFecha_UltimaModificacion() != null) {
            _hashCode += getFecha_UltimaModificacion().hashCode();
        }
        if (getTiempoDetencionMinimo() != null) {
            _hashCode += getTiempoDetencionMinimo().hashCode();
        }
        if (getIdParada() != null) {
            _hashCode += getIdParada().hashCode();
        }
        if (getIdOrden() != null) {
            _hashCode += getIdOrden().hashCode();
        }
        if (getSumarizarTotalesDesdeItems() != null) {
            _hashCode += getSumarizarTotalesDesdeItems().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PParada.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParada"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secuencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Secuencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("tipoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoParada"));
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
        elemField.setFieldName("direccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Direccion"));
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
        elemField.setFieldName("entreCalles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntreCalles"));
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
        elemField.setFieldName("latitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Latitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Longitud"));
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
        elemField.setFieldName("bulto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Bulto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Valor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pallets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pallets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempoEstadia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoEstadia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("distancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Distancia"));
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
        elemField.setFieldName("requiereControl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RequiereControl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorControl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValorControl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
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
        elemField.setFieldName("orden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Orden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaConsultarViaje"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Estados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pEstadoParada"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incidencias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Incidencias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pIncidencia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pIncidencia"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("items");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Items"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pParadaItem"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clienteDador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ClienteDador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador"));
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
        elemField.setFieldName("referenciaExternaEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaMotivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaMotivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor_Declarado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Valor_Declarado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_Costo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "_Costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("int_1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Int_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("int_2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Int_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("float_1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Float_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("float_2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Float_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicio_Visita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Inicio_Visita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fin_Visita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fin_Visita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicio_VisitaReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Inicio_VisitaReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fin_VisitaReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fin_VisitaReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_UltimaModificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha_UltimaModificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempoDetencionMinimo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoDetencionMinimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("sumarizarTotalesDesdeItems");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "sumarizarTotalesDesdeItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
