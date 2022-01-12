/**
 * ConsultarParadaResultado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class ConsultarParadaResultado  implements java.io.Serializable {
    private int resultado;

    private boolean viajeFinalizado;

    private int idViaje;

    private java.lang.String viajeReferenciaExterna;

    private int secuencia;

    private java.lang.String estadoParada;

    private java.util.Calendar horarioParadaRealInicio;

    private java.util.Calendar horarioParadaRealFin;

    private java.lang.String refDocumento;

    private java.lang.String refDocumentoAdicional;

    private java.lang.String refCliente;

    private java.lang.String transporte;

    private java.lang.String dominio;

    private java.lang.String conductor;

    private java.lang.String URL;

    private java.lang.String referenciaMotivo;

    private java.lang.String observaciones;

    private java.lang.String descripcion;

    private java.lang.String direccion;

    private java.lang.String pais;

    private java.lang.String motivo;

    private java.util.Calendar inicioHorarioEstimado;

    private java.util.Calendar finHorarioEstimado;

    private java.util.Calendar inicioHorarioPlanificado;

    private java.util.Calendar finHorarioPlanificado;

    private ar.com.unisolutions.PCliente cliente;

    private ar.com.unisolutions.PClienteDador clienteDador;

    private ar.com.unisolutions.PFoto[] fotos;

    private ar.com.unisolutions.ConsultarParadaResultadoItem[] items;

    private ar.com.unisolutions.PRecursos[] recursos;

    private ar.com.unisolutions.CampoValor[] dinamicos;

    private java.lang.Double latitud;

    private java.lang.Double bultos;

    private java.lang.Double peso;

    private java.lang.Double valorDeclarado;

    private java.lang.Double longitud;

    public ConsultarParadaResultado() {
    }

    public ConsultarParadaResultado(
           int resultado,
           boolean viajeFinalizado,
           int idViaje,
           java.lang.String viajeReferenciaExterna,
           int secuencia,
           java.lang.String estadoParada,
           java.util.Calendar horarioParadaRealInicio,
           java.util.Calendar horarioParadaRealFin,
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           java.lang.String refCliente,
           java.lang.String transporte,
           java.lang.String dominio,
           java.lang.String conductor,
           java.lang.String URL,
           java.lang.String referenciaMotivo,
           java.lang.String observaciones,
           java.lang.String descripcion,
           java.lang.String direccion,
           java.lang.String pais,
           java.lang.String motivo,
           java.util.Calendar inicioHorarioEstimado,
           java.util.Calendar finHorarioEstimado,
           java.util.Calendar inicioHorarioPlanificado,
           java.util.Calendar finHorarioPlanificado,
           ar.com.unisolutions.PCliente cliente,
           ar.com.unisolutions.PClienteDador clienteDador,
           ar.com.unisolutions.PFoto[] fotos,
           ar.com.unisolutions.ConsultarParadaResultadoItem[] items,
           ar.com.unisolutions.PRecursos[] recursos,
           ar.com.unisolutions.CampoValor[] dinamicos,
           java.lang.Double latitud,
           java.lang.Double bultos,
           java.lang.Double peso,
           java.lang.Double valorDeclarado,
           java.lang.Double longitud) {
           this.resultado = resultado;
           this.viajeFinalizado = viajeFinalizado;
           this.idViaje = idViaje;
           this.viajeReferenciaExterna = viajeReferenciaExterna;
           this.secuencia = secuencia;
           this.estadoParada = estadoParada;
           this.horarioParadaRealInicio = horarioParadaRealInicio;
           this.horarioParadaRealFin = horarioParadaRealFin;
           this.refDocumento = refDocumento;
           this.refDocumentoAdicional = refDocumentoAdicional;
           this.refCliente = refCliente;
           this.transporte = transporte;
           this.dominio = dominio;
           this.conductor = conductor;
           this.URL = URL;
           this.referenciaMotivo = referenciaMotivo;
           this.observaciones = observaciones;
           this.descripcion = descripcion;
           this.direccion = direccion;
           this.pais = pais;
           this.motivo = motivo;
           this.inicioHorarioEstimado = inicioHorarioEstimado;
           this.finHorarioEstimado = finHorarioEstimado;
           this.inicioHorarioPlanificado = inicioHorarioPlanificado;
           this.finHorarioPlanificado = finHorarioPlanificado;
           this.cliente = cliente;
           this.clienteDador = clienteDador;
           this.fotos = fotos;
           this.items = items;
           this.recursos = recursos;
           this.dinamicos = dinamicos;
           this.latitud = latitud;
           this.bultos = bultos;
           this.peso = peso;
           this.valorDeclarado = valorDeclarado;
           this.longitud = longitud;
    }


    /**
     * Gets the resultado value for this ConsultarParadaResultado.
     * 
     * @return resultado
     */
    public int getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this ConsultarParadaResultado.
     * 
     * @param resultado
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the viajeFinalizado value for this ConsultarParadaResultado.
     * 
     * @return viajeFinalizado
     */
    public boolean isViajeFinalizado() {
        return viajeFinalizado;
    }


    /**
     * Sets the viajeFinalizado value for this ConsultarParadaResultado.
     * 
     * @param viajeFinalizado
     */
    public void setViajeFinalizado(boolean viajeFinalizado) {
        this.viajeFinalizado = viajeFinalizado;
    }


    /**
     * Gets the idViaje value for this ConsultarParadaResultado.
     * 
     * @return idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }


    /**
     * Sets the idViaje value for this ConsultarParadaResultado.
     * 
     * @param idViaje
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    /**
     * Gets the viajeReferenciaExterna value for this ConsultarParadaResultado.
     * 
     * @return viajeReferenciaExterna
     */
    public java.lang.String getViajeReferenciaExterna() {
        return viajeReferenciaExterna;
    }


    /**
     * Sets the viajeReferenciaExterna value for this ConsultarParadaResultado.
     * 
     * @param viajeReferenciaExterna
     */
    public void setViajeReferenciaExterna(java.lang.String viajeReferenciaExterna) {
        this.viajeReferenciaExterna = viajeReferenciaExterna;
    }


    /**
     * Gets the secuencia value for this ConsultarParadaResultado.
     * 
     * @return secuencia
     */
    public int getSecuencia() {
        return secuencia;
    }


    /**
     * Sets the secuencia value for this ConsultarParadaResultado.
     * 
     * @param secuencia
     */
    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }


    /**
     * Gets the estadoParada value for this ConsultarParadaResultado.
     * 
     * @return estadoParada
     */
    public java.lang.String getEstadoParada() {
        return estadoParada;
    }


    /**
     * Sets the estadoParada value for this ConsultarParadaResultado.
     * 
     * @param estadoParada
     */
    public void setEstadoParada(java.lang.String estadoParada) {
        this.estadoParada = estadoParada;
    }


    /**
     * Gets the horarioParadaRealInicio value for this ConsultarParadaResultado.
     * 
     * @return horarioParadaRealInicio
     */
    public java.util.Calendar getHorarioParadaRealInicio() {
        return horarioParadaRealInicio;
    }


    /**
     * Sets the horarioParadaRealInicio value for this ConsultarParadaResultado.
     * 
     * @param horarioParadaRealInicio
     */
    public void setHorarioParadaRealInicio(java.util.Calendar horarioParadaRealInicio) {
        this.horarioParadaRealInicio = horarioParadaRealInicio;
    }


    /**
     * Gets the horarioParadaRealFin value for this ConsultarParadaResultado.
     * 
     * @return horarioParadaRealFin
     */
    public java.util.Calendar getHorarioParadaRealFin() {
        return horarioParadaRealFin;
    }


    /**
     * Sets the horarioParadaRealFin value for this ConsultarParadaResultado.
     * 
     * @param horarioParadaRealFin
     */
    public void setHorarioParadaRealFin(java.util.Calendar horarioParadaRealFin) {
        this.horarioParadaRealFin = horarioParadaRealFin;
    }


    /**
     * Gets the refDocumento value for this ConsultarParadaResultado.
     * 
     * @return refDocumento
     */
    public java.lang.String getRefDocumento() {
        return refDocumento;
    }


    /**
     * Sets the refDocumento value for this ConsultarParadaResultado.
     * 
     * @param refDocumento
     */
    public void setRefDocumento(java.lang.String refDocumento) {
        this.refDocumento = refDocumento;
    }


    /**
     * Gets the refDocumentoAdicional value for this ConsultarParadaResultado.
     * 
     * @return refDocumentoAdicional
     */
    public java.lang.String getRefDocumentoAdicional() {
        return refDocumentoAdicional;
    }


    /**
     * Sets the refDocumentoAdicional value for this ConsultarParadaResultado.
     * 
     * @param refDocumentoAdicional
     */
    public void setRefDocumentoAdicional(java.lang.String refDocumentoAdicional) {
        this.refDocumentoAdicional = refDocumentoAdicional;
    }


    /**
     * Gets the refCliente value for this ConsultarParadaResultado.
     * 
     * @return refCliente
     */
    public java.lang.String getRefCliente() {
        return refCliente;
    }


    /**
     * Sets the refCliente value for this ConsultarParadaResultado.
     * 
     * @param refCliente
     */
    public void setRefCliente(java.lang.String refCliente) {
        this.refCliente = refCliente;
    }


    /**
     * Gets the transporte value for this ConsultarParadaResultado.
     * 
     * @return transporte
     */
    public java.lang.String getTransporte() {
        return transporte;
    }


    /**
     * Sets the transporte value for this ConsultarParadaResultado.
     * 
     * @param transporte
     */
    public void setTransporte(java.lang.String transporte) {
        this.transporte = transporte;
    }


    /**
     * Gets the dominio value for this ConsultarParadaResultado.
     * 
     * @return dominio
     */
    public java.lang.String getDominio() {
        return dominio;
    }


    /**
     * Sets the dominio value for this ConsultarParadaResultado.
     * 
     * @param dominio
     */
    public void setDominio(java.lang.String dominio) {
        this.dominio = dominio;
    }


    /**
     * Gets the conductor value for this ConsultarParadaResultado.
     * 
     * @return conductor
     */
    public java.lang.String getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this ConsultarParadaResultado.
     * 
     * @param conductor
     */
    public void setConductor(java.lang.String conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the URL value for this ConsultarParadaResultado.
     * 
     * @return URL
     */
    public java.lang.String getURL() {
        return URL;
    }


    /**
     * Sets the URL value for this ConsultarParadaResultado.
     * 
     * @param URL
     */
    public void setURL(java.lang.String URL) {
        this.URL = URL;
    }


    /**
     * Gets the referenciaMotivo value for this ConsultarParadaResultado.
     * 
     * @return referenciaMotivo
     */
    public java.lang.String getReferenciaMotivo() {
        return referenciaMotivo;
    }


    /**
     * Sets the referenciaMotivo value for this ConsultarParadaResultado.
     * 
     * @param referenciaMotivo
     */
    public void setReferenciaMotivo(java.lang.String referenciaMotivo) {
        this.referenciaMotivo = referenciaMotivo;
    }


    /**
     * Gets the observaciones value for this ConsultarParadaResultado.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this ConsultarParadaResultado.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the descripcion value for this ConsultarParadaResultado.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ConsultarParadaResultado.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the direccion value for this ConsultarParadaResultado.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this ConsultarParadaResultado.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the pais value for this ConsultarParadaResultado.
     * 
     * @return pais
     */
    public java.lang.String getPais() {
        return pais;
    }


    /**
     * Sets the pais value for this ConsultarParadaResultado.
     * 
     * @param pais
     */
    public void setPais(java.lang.String pais) {
        this.pais = pais;
    }


    /**
     * Gets the motivo value for this ConsultarParadaResultado.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this ConsultarParadaResultado.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the inicioHorarioEstimado value for this ConsultarParadaResultado.
     * 
     * @return inicioHorarioEstimado
     */
    public java.util.Calendar getInicioHorarioEstimado() {
        return inicioHorarioEstimado;
    }


    /**
     * Sets the inicioHorarioEstimado value for this ConsultarParadaResultado.
     * 
     * @param inicioHorarioEstimado
     */
    public void setInicioHorarioEstimado(java.util.Calendar inicioHorarioEstimado) {
        this.inicioHorarioEstimado = inicioHorarioEstimado;
    }


    /**
     * Gets the finHorarioEstimado value for this ConsultarParadaResultado.
     * 
     * @return finHorarioEstimado
     */
    public java.util.Calendar getFinHorarioEstimado() {
        return finHorarioEstimado;
    }


    /**
     * Sets the finHorarioEstimado value for this ConsultarParadaResultado.
     * 
     * @param finHorarioEstimado
     */
    public void setFinHorarioEstimado(java.util.Calendar finHorarioEstimado) {
        this.finHorarioEstimado = finHorarioEstimado;
    }


    /**
     * Gets the inicioHorarioPlanificado value for this ConsultarParadaResultado.
     * 
     * @return inicioHorarioPlanificado
     */
    public java.util.Calendar getInicioHorarioPlanificado() {
        return inicioHorarioPlanificado;
    }


    /**
     * Sets the inicioHorarioPlanificado value for this ConsultarParadaResultado.
     * 
     * @param inicioHorarioPlanificado
     */
    public void setInicioHorarioPlanificado(java.util.Calendar inicioHorarioPlanificado) {
        this.inicioHorarioPlanificado = inicioHorarioPlanificado;
    }


    /**
     * Gets the finHorarioPlanificado value for this ConsultarParadaResultado.
     * 
     * @return finHorarioPlanificado
     */
    public java.util.Calendar getFinHorarioPlanificado() {
        return finHorarioPlanificado;
    }


    /**
     * Sets the finHorarioPlanificado value for this ConsultarParadaResultado.
     * 
     * @param finHorarioPlanificado
     */
    public void setFinHorarioPlanificado(java.util.Calendar finHorarioPlanificado) {
        this.finHorarioPlanificado = finHorarioPlanificado;
    }


    /**
     * Gets the cliente value for this ConsultarParadaResultado.
     * 
     * @return cliente
     */
    public ar.com.unisolutions.PCliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this ConsultarParadaResultado.
     * 
     * @param cliente
     */
    public void setCliente(ar.com.unisolutions.PCliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the clienteDador value for this ConsultarParadaResultado.
     * 
     * @return clienteDador
     */
    public ar.com.unisolutions.PClienteDador getClienteDador() {
        return clienteDador;
    }


    /**
     * Sets the clienteDador value for this ConsultarParadaResultado.
     * 
     * @param clienteDador
     */
    public void setClienteDador(ar.com.unisolutions.PClienteDador clienteDador) {
        this.clienteDador = clienteDador;
    }


    /**
     * Gets the fotos value for this ConsultarParadaResultado.
     * 
     * @return fotos
     */
    public ar.com.unisolutions.PFoto[] getFotos() {
        return fotos;
    }


    /**
     * Sets the fotos value for this ConsultarParadaResultado.
     * 
     * @param fotos
     */
    public void setFotos(ar.com.unisolutions.PFoto[] fotos) {
        this.fotos = fotos;
    }


    /**
     * Gets the items value for this ConsultarParadaResultado.
     * 
     * @return items
     */
    public ar.com.unisolutions.ConsultarParadaResultadoItem[] getItems() {
        return items;
    }


    /**
     * Sets the items value for this ConsultarParadaResultado.
     * 
     * @param items
     */
    public void setItems(ar.com.unisolutions.ConsultarParadaResultadoItem[] items) {
        this.items = items;
    }


    /**
     * Gets the recursos value for this ConsultarParadaResultado.
     * 
     * @return recursos
     */
    public ar.com.unisolutions.PRecursos[] getRecursos() {
        return recursos;
    }


    /**
     * Sets the recursos value for this ConsultarParadaResultado.
     * 
     * @param recursos
     */
    public void setRecursos(ar.com.unisolutions.PRecursos[] recursos) {
        this.recursos = recursos;
    }


    /**
     * Gets the dinamicos value for this ConsultarParadaResultado.
     * 
     * @return dinamicos
     */
    public ar.com.unisolutions.CampoValor[] getDinamicos() {
        return dinamicos;
    }


    /**
     * Sets the dinamicos value for this ConsultarParadaResultado.
     * 
     * @param dinamicos
     */
    public void setDinamicos(ar.com.unisolutions.CampoValor[] dinamicos) {
        this.dinamicos = dinamicos;
    }


    /**
     * Gets the latitud value for this ConsultarParadaResultado.
     * 
     * @return latitud
     */
    public java.lang.Double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this ConsultarParadaResultado.
     * 
     * @param latitud
     */
    public void setLatitud(java.lang.Double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the bultos value for this ConsultarParadaResultado.
     * 
     * @return bultos
     */
    public java.lang.Double getBultos() {
        return bultos;
    }


    /**
     * Sets the bultos value for this ConsultarParadaResultado.
     * 
     * @param bultos
     */
    public void setBultos(java.lang.Double bultos) {
        this.bultos = bultos;
    }


    /**
     * Gets the peso value for this ConsultarParadaResultado.
     * 
     * @return peso
     */
    public java.lang.Double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this ConsultarParadaResultado.
     * 
     * @param peso
     */
    public void setPeso(java.lang.Double peso) {
        this.peso = peso;
    }


    /**
     * Gets the valorDeclarado value for this ConsultarParadaResultado.
     * 
     * @return valorDeclarado
     */
    public java.lang.Double getValorDeclarado() {
        return valorDeclarado;
    }


    /**
     * Sets the valorDeclarado value for this ConsultarParadaResultado.
     * 
     * @param valorDeclarado
     */
    public void setValorDeclarado(java.lang.Double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }


    /**
     * Gets the longitud value for this ConsultarParadaResultado.
     * 
     * @return longitud
     */
    public java.lang.Double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this ConsultarParadaResultado.
     * 
     * @param longitud
     */
    public void setLongitud(java.lang.Double longitud) {
        this.longitud = longitud;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarParadaResultado)) return false;
        ConsultarParadaResultado other = (ConsultarParadaResultado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.resultado == other.getResultado() &&
            this.viajeFinalizado == other.isViajeFinalizado() &&
            this.idViaje == other.getIdViaje() &&
            ((this.viajeReferenciaExterna==null && other.getViajeReferenciaExterna()==null) || 
             (this.viajeReferenciaExterna!=null &&
              this.viajeReferenciaExterna.equals(other.getViajeReferenciaExterna()))) &&
            this.secuencia == other.getSecuencia() &&
            ((this.estadoParada==null && other.getEstadoParada()==null) || 
             (this.estadoParada!=null &&
              this.estadoParada.equals(other.getEstadoParada()))) &&
            ((this.horarioParadaRealInicio==null && other.getHorarioParadaRealInicio()==null) || 
             (this.horarioParadaRealInicio!=null &&
              this.horarioParadaRealInicio.equals(other.getHorarioParadaRealInicio()))) &&
            ((this.horarioParadaRealFin==null && other.getHorarioParadaRealFin()==null) || 
             (this.horarioParadaRealFin!=null &&
              this.horarioParadaRealFin.equals(other.getHorarioParadaRealFin()))) &&
            ((this.refDocumento==null && other.getRefDocumento()==null) || 
             (this.refDocumento!=null &&
              this.refDocumento.equals(other.getRefDocumento()))) &&
            ((this.refDocumentoAdicional==null && other.getRefDocumentoAdicional()==null) || 
             (this.refDocumentoAdicional!=null &&
              this.refDocumentoAdicional.equals(other.getRefDocumentoAdicional()))) &&
            ((this.refCliente==null && other.getRefCliente()==null) || 
             (this.refCliente!=null &&
              this.refCliente.equals(other.getRefCliente()))) &&
            ((this.transporte==null && other.getTransporte()==null) || 
             (this.transporte!=null &&
              this.transporte.equals(other.getTransporte()))) &&
            ((this.dominio==null && other.getDominio()==null) || 
             (this.dominio!=null &&
              this.dominio.equals(other.getDominio()))) &&
            ((this.conductor==null && other.getConductor()==null) || 
             (this.conductor!=null &&
              this.conductor.equals(other.getConductor()))) &&
            ((this.URL==null && other.getURL()==null) || 
             (this.URL!=null &&
              this.URL.equals(other.getURL()))) &&
            ((this.referenciaMotivo==null && other.getReferenciaMotivo()==null) || 
             (this.referenciaMotivo!=null &&
              this.referenciaMotivo.equals(other.getReferenciaMotivo()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.pais==null && other.getPais()==null) || 
             (this.pais!=null &&
              this.pais.equals(other.getPais()))) &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo()))) &&
            ((this.inicioHorarioEstimado==null && other.getInicioHorarioEstimado()==null) || 
             (this.inicioHorarioEstimado!=null &&
              this.inicioHorarioEstimado.equals(other.getInicioHorarioEstimado()))) &&
            ((this.finHorarioEstimado==null && other.getFinHorarioEstimado()==null) || 
             (this.finHorarioEstimado!=null &&
              this.finHorarioEstimado.equals(other.getFinHorarioEstimado()))) &&
            ((this.inicioHorarioPlanificado==null && other.getInicioHorarioPlanificado()==null) || 
             (this.inicioHorarioPlanificado!=null &&
              this.inicioHorarioPlanificado.equals(other.getInicioHorarioPlanificado()))) &&
            ((this.finHorarioPlanificado==null && other.getFinHorarioPlanificado()==null) || 
             (this.finHorarioPlanificado!=null &&
              this.finHorarioPlanificado.equals(other.getFinHorarioPlanificado()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.clienteDador==null && other.getClienteDador()==null) || 
             (this.clienteDador!=null &&
              this.clienteDador.equals(other.getClienteDador()))) &&
            ((this.fotos==null && other.getFotos()==null) || 
             (this.fotos!=null &&
              java.util.Arrays.equals(this.fotos, other.getFotos()))) &&
            ((this.items==null && other.getItems()==null) || 
             (this.items!=null &&
              java.util.Arrays.equals(this.items, other.getItems()))) &&
            ((this.recursos==null && other.getRecursos()==null) || 
             (this.recursos!=null &&
              java.util.Arrays.equals(this.recursos, other.getRecursos()))) &&
            ((this.dinamicos==null && other.getDinamicos()==null) || 
             (this.dinamicos!=null &&
              java.util.Arrays.equals(this.dinamicos, other.getDinamicos()))) &&
            ((this.latitud==null && other.getLatitud()==null) || 
             (this.latitud!=null &&
              this.latitud.equals(other.getLatitud()))) &&
            ((this.bultos==null && other.getBultos()==null) || 
             (this.bultos!=null &&
              this.bultos.equals(other.getBultos()))) &&
            ((this.peso==null && other.getPeso()==null) || 
             (this.peso!=null &&
              this.peso.equals(other.getPeso()))) &&
            ((this.valorDeclarado==null && other.getValorDeclarado()==null) || 
             (this.valorDeclarado!=null &&
              this.valorDeclarado.equals(other.getValorDeclarado()))) &&
            ((this.longitud==null && other.getLongitud()==null) || 
             (this.longitud!=null &&
              this.longitud.equals(other.getLongitud())));
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
        _hashCode += getResultado();
        _hashCode += (isViajeFinalizado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getIdViaje();
        if (getViajeReferenciaExterna() != null) {
            _hashCode += getViajeReferenciaExterna().hashCode();
        }
        _hashCode += getSecuencia();
        if (getEstadoParada() != null) {
            _hashCode += getEstadoParada().hashCode();
        }
        if (getHorarioParadaRealInicio() != null) {
            _hashCode += getHorarioParadaRealInicio().hashCode();
        }
        if (getHorarioParadaRealFin() != null) {
            _hashCode += getHorarioParadaRealFin().hashCode();
        }
        if (getRefDocumento() != null) {
            _hashCode += getRefDocumento().hashCode();
        }
        if (getRefDocumentoAdicional() != null) {
            _hashCode += getRefDocumentoAdicional().hashCode();
        }
        if (getRefCliente() != null) {
            _hashCode += getRefCliente().hashCode();
        }
        if (getTransporte() != null) {
            _hashCode += getTransporte().hashCode();
        }
        if (getDominio() != null) {
            _hashCode += getDominio().hashCode();
        }
        if (getConductor() != null) {
            _hashCode += getConductor().hashCode();
        }
        if (getURL() != null) {
            _hashCode += getURL().hashCode();
        }
        if (getReferenciaMotivo() != null) {
            _hashCode += getReferenciaMotivo().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getPais() != null) {
            _hashCode += getPais().hashCode();
        }
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        if (getInicioHorarioEstimado() != null) {
            _hashCode += getInicioHorarioEstimado().hashCode();
        }
        if (getFinHorarioEstimado() != null) {
            _hashCode += getFinHorarioEstimado().hashCode();
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
        if (getClienteDador() != null) {
            _hashCode += getClienteDador().hashCode();
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
        if (getDinamicos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDinamicos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDinamicos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLatitud() != null) {
            _hashCode += getLatitud().hashCode();
        }
        if (getBultos() != null) {
            _hashCode += getBultos().hashCode();
        }
        if (getPeso() != null) {
            _hashCode += getPeso().hashCode();
        }
        if (getValorDeclarado() != null) {
            _hashCode += getValorDeclarado().hashCode();
        }
        if (getLongitud() != null) {
            _hashCode += getLongitud().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarParadaResultado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viajeFinalizado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ViajeFinalizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idViaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdViaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viajeReferenciaExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ViajeReferenciaExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secuencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Secuencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horarioParadaRealInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HorarioParadaRealInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horarioParadaRealFin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HorarioParadaRealFin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("refCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Transporte"));
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
        elemField.setFieldName("conductor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("URL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "URL"));
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
        elemField.setFieldName("observaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Observaciones"));
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
        elemField.setFieldName("pais");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Pais"));
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
        elemField.setFieldName("inicioHorarioEstimado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorarioEstimado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorarioEstimado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorarioEstimado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clienteDador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ClienteDador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pClienteDador"));
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
        elemField.setFieldName("items");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Items"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultadoItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConsultarParadaResultadoItem"));
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
        elemField.setFieldName("dinamicos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Dinamicos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Latitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bultos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Bultos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Peso"));
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
        elemField.setFieldName("longitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Longitud"));
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
