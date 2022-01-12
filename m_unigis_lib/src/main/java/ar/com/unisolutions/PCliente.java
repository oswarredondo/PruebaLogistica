/**
 * PCliente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PCliente  implements java.io.Serializable {
    private java.lang.String refCliente;

    private java.lang.String razonSocial;

    private java.lang.String telefono;

    private java.lang.String telefono2;

    private java.lang.String telefono3;

    private java.lang.String EMail;

    private java.lang.String direccion;

    private java.lang.String calle;

    private java.lang.String numeroPuerta;

    private java.lang.String entreCalle;

    private java.lang.String barrio;

    private java.lang.String localidad;

    private java.lang.String partido;

    private java.lang.String provincia;

    private java.lang.String pais;

    private java.lang.Double latitud;

    private java.lang.Double longitud;

    private java.lang.String refDomicilioExterno;

    private java.lang.String domicilioDescripcion;

    private java.lang.Integer inicioHorario1;

    private java.lang.Integer inicioHorario2;

    private java.lang.Integer finHorario1;

    private java.lang.Integer finHorario2;

    private java.lang.Integer tiempoEspera;

    private java.lang.String varchar1;

    private java.lang.String varchar2;

    private java.lang.String grupo;

    private java.lang.String numeroDocumento;

    private java.lang.String tipoDocumento;

    private java.lang.String domicilioCodigoPostal;

    private ar.com.unisolutions.PDomicilio domicilioFiscal;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private java.lang.String contacto;

    private java.lang.Integer int1;

    private java.lang.Integer int2;

    private java.lang.Double float1;

    private java.lang.Double float2;

    private java.lang.Boolean cargaExclusiva;

    private java.lang.Boolean ignorarOperacion;

    private java.lang.Boolean ignorarOperacionDomicilioOrden;

    private java.lang.Boolean crearDomicilioOrden;

    private java.lang.Boolean actualizarDomicilioOrden;

    private java.lang.Boolean validarDomicilioOrden;

    public PCliente() {
    }

    public PCliente(
           java.lang.String refCliente,
           java.lang.String razonSocial,
           java.lang.String telefono,
           java.lang.String telefono2,
           java.lang.String telefono3,
           java.lang.String EMail,
           java.lang.String direccion,
           java.lang.String calle,
           java.lang.String numeroPuerta,
           java.lang.String entreCalle,
           java.lang.String barrio,
           java.lang.String localidad,
           java.lang.String partido,
           java.lang.String provincia,
           java.lang.String pais,
           java.lang.Double latitud,
           java.lang.Double longitud,
           java.lang.String refDomicilioExterno,
           java.lang.String domicilioDescripcion,
           java.lang.Integer inicioHorario1,
           java.lang.Integer inicioHorario2,
           java.lang.Integer finHorario1,
           java.lang.Integer finHorario2,
           java.lang.Integer tiempoEspera,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String grupo,
           java.lang.String numeroDocumento,
           java.lang.String tipoDocumento,
           java.lang.String domicilioCodigoPostal,
           ar.com.unisolutions.PDomicilio domicilioFiscal,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           java.lang.String contacto,
           java.lang.Integer int1,
           java.lang.Integer int2,
           java.lang.Double float1,
           java.lang.Double float2,
           java.lang.Boolean cargaExclusiva,
           java.lang.Boolean ignorarOperacion,
           java.lang.Boolean ignorarOperacionDomicilioOrden,
           java.lang.Boolean crearDomicilioOrden,
           java.lang.Boolean actualizarDomicilioOrden,
           java.lang.Boolean validarDomicilioOrden) {
           this.refCliente = refCliente;
           this.razonSocial = razonSocial;
           this.telefono = telefono;
           this.telefono2 = telefono2;
           this.telefono3 = telefono3;
           this.EMail = EMail;
           this.direccion = direccion;
           this.calle = calle;
           this.numeroPuerta = numeroPuerta;
           this.entreCalle = entreCalle;
           this.barrio = barrio;
           this.localidad = localidad;
           this.partido = partido;
           this.provincia = provincia;
           this.pais = pais;
           this.latitud = latitud;
           this.longitud = longitud;
           this.refDomicilioExterno = refDomicilioExterno;
           this.domicilioDescripcion = domicilioDescripcion;
           this.inicioHorario1 = inicioHorario1;
           this.inicioHorario2 = inicioHorario2;
           this.finHorario1 = finHorario1;
           this.finHorario2 = finHorario2;
           this.tiempoEspera = tiempoEspera;
           this.varchar1 = varchar1;
           this.varchar2 = varchar2;
           this.grupo = grupo;
           this.numeroDocumento = numeroDocumento;
           this.tipoDocumento = tipoDocumento;
           this.domicilioCodigoPostal = domicilioCodigoPostal;
           this.domicilioFiscal = domicilioFiscal;
           this.campoDinamico = campoDinamico;
           this.contacto = contacto;
           this.int1 = int1;
           this.int2 = int2;
           this.float1 = float1;
           this.float2 = float2;
           this.cargaExclusiva = cargaExclusiva;
           this.ignorarOperacion = ignorarOperacion;
           this.ignorarOperacionDomicilioOrden = ignorarOperacionDomicilioOrden;
           this.crearDomicilioOrden = crearDomicilioOrden;
           this.actualizarDomicilioOrden = actualizarDomicilioOrden;
           this.validarDomicilioOrden = validarDomicilioOrden;
    }


    /**
     * Gets the refCliente value for this PCliente.
     * 
     * @return refCliente
     */
    public java.lang.String getRefCliente() {
        return refCliente;
    }


    /**
     * Sets the refCliente value for this PCliente.
     * 
     * @param refCliente
     */
    public void setRefCliente(java.lang.String refCliente) {
        this.refCliente = refCliente;
    }


    /**
     * Gets the razonSocial value for this PCliente.
     * 
     * @return razonSocial
     */
    public java.lang.String getRazonSocial() {
        return razonSocial;
    }


    /**
     * Sets the razonSocial value for this PCliente.
     * 
     * @param razonSocial
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = razonSocial;
    }


    /**
     * Gets the telefono value for this PCliente.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this PCliente.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the telefono2 value for this PCliente.
     * 
     * @return telefono2
     */
    public java.lang.String getTelefono2() {
        return telefono2;
    }


    /**
     * Sets the telefono2 value for this PCliente.
     * 
     * @param telefono2
     */
    public void setTelefono2(java.lang.String telefono2) {
        this.telefono2 = telefono2;
    }


    /**
     * Gets the telefono3 value for this PCliente.
     * 
     * @return telefono3
     */
    public java.lang.String getTelefono3() {
        return telefono3;
    }


    /**
     * Sets the telefono3 value for this PCliente.
     * 
     * @param telefono3
     */
    public void setTelefono3(java.lang.String telefono3) {
        this.telefono3 = telefono3;
    }


    /**
     * Gets the EMail value for this PCliente.
     * 
     * @return EMail
     */
    public java.lang.String getEMail() {
        return EMail;
    }


    /**
     * Sets the EMail value for this PCliente.
     * 
     * @param EMail
     */
    public void setEMail(java.lang.String EMail) {
        this.EMail = EMail;
    }


    /**
     * Gets the direccion value for this PCliente.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this PCliente.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the calle value for this PCliente.
     * 
     * @return calle
     */
    public java.lang.String getCalle() {
        return calle;
    }


    /**
     * Sets the calle value for this PCliente.
     * 
     * @param calle
     */
    public void setCalle(java.lang.String calle) {
        this.calle = calle;
    }


    /**
     * Gets the numeroPuerta value for this PCliente.
     * 
     * @return numeroPuerta
     */
    public java.lang.String getNumeroPuerta() {
        return numeroPuerta;
    }


    /**
     * Sets the numeroPuerta value for this PCliente.
     * 
     * @param numeroPuerta
     */
    public void setNumeroPuerta(java.lang.String numeroPuerta) {
        this.numeroPuerta = numeroPuerta;
    }


    /**
     * Gets the entreCalle value for this PCliente.
     * 
     * @return entreCalle
     */
    public java.lang.String getEntreCalle() {
        return entreCalle;
    }


    /**
     * Sets the entreCalle value for this PCliente.
     * 
     * @param entreCalle
     */
    public void setEntreCalle(java.lang.String entreCalle) {
        this.entreCalle = entreCalle;
    }


    /**
     * Gets the barrio value for this PCliente.
     * 
     * @return barrio
     */
    public java.lang.String getBarrio() {
        return barrio;
    }


    /**
     * Sets the barrio value for this PCliente.
     * 
     * @param barrio
     */
    public void setBarrio(java.lang.String barrio) {
        this.barrio = barrio;
    }


    /**
     * Gets the localidad value for this PCliente.
     * 
     * @return localidad
     */
    public java.lang.String getLocalidad() {
        return localidad;
    }


    /**
     * Sets the localidad value for this PCliente.
     * 
     * @param localidad
     */
    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }


    /**
     * Gets the partido value for this PCliente.
     * 
     * @return partido
     */
    public java.lang.String getPartido() {
        return partido;
    }


    /**
     * Sets the partido value for this PCliente.
     * 
     * @param partido
     */
    public void setPartido(java.lang.String partido) {
        this.partido = partido;
    }


    /**
     * Gets the provincia value for this PCliente.
     * 
     * @return provincia
     */
    public java.lang.String getProvincia() {
        return provincia;
    }


    /**
     * Sets the provincia value for this PCliente.
     * 
     * @param provincia
     */
    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }


    /**
     * Gets the pais value for this PCliente.
     * 
     * @return pais
     */
    public java.lang.String getPais() {
        return pais;
    }


    /**
     * Sets the pais value for this PCliente.
     * 
     * @param pais
     */
    public void setPais(java.lang.String pais) {
        this.pais = pais;
    }


    /**
     * Gets the latitud value for this PCliente.
     * 
     * @return latitud
     */
    public java.lang.Double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this PCliente.
     * 
     * @param latitud
     */
    public void setLatitud(java.lang.Double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this PCliente.
     * 
     * @return longitud
     */
    public java.lang.Double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this PCliente.
     * 
     * @param longitud
     */
    public void setLongitud(java.lang.Double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the refDomicilioExterno value for this PCliente.
     * 
     * @return refDomicilioExterno
     */
    public java.lang.String getRefDomicilioExterno() {
        return refDomicilioExterno;
    }


    /**
     * Sets the refDomicilioExterno value for this PCliente.
     * 
     * @param refDomicilioExterno
     */
    public void setRefDomicilioExterno(java.lang.String refDomicilioExterno) {
        this.refDomicilioExterno = refDomicilioExterno;
    }


    /**
     * Gets the domicilioDescripcion value for this PCliente.
     * 
     * @return domicilioDescripcion
     */
    public java.lang.String getDomicilioDescripcion() {
        return domicilioDescripcion;
    }


    /**
     * Sets the domicilioDescripcion value for this PCliente.
     * 
     * @param domicilioDescripcion
     */
    public void setDomicilioDescripcion(java.lang.String domicilioDescripcion) {
        this.domicilioDescripcion = domicilioDescripcion;
    }


    /**
     * Gets the inicioHorario1 value for this PCliente.
     * 
     * @return inicioHorario1
     */
    public java.lang.Integer getInicioHorario1() {
        return inicioHorario1;
    }


    /**
     * Sets the inicioHorario1 value for this PCliente.
     * 
     * @param inicioHorario1
     */
    public void setInicioHorario1(java.lang.Integer inicioHorario1) {
        this.inicioHorario1 = inicioHorario1;
    }


    /**
     * Gets the inicioHorario2 value for this PCliente.
     * 
     * @return inicioHorario2
     */
    public java.lang.Integer getInicioHorario2() {
        return inicioHorario2;
    }


    /**
     * Sets the inicioHorario2 value for this PCliente.
     * 
     * @param inicioHorario2
     */
    public void setInicioHorario2(java.lang.Integer inicioHorario2) {
        this.inicioHorario2 = inicioHorario2;
    }


    /**
     * Gets the finHorario1 value for this PCliente.
     * 
     * @return finHorario1
     */
    public java.lang.Integer getFinHorario1() {
        return finHorario1;
    }


    /**
     * Sets the finHorario1 value for this PCliente.
     * 
     * @param finHorario1
     */
    public void setFinHorario1(java.lang.Integer finHorario1) {
        this.finHorario1 = finHorario1;
    }


    /**
     * Gets the finHorario2 value for this PCliente.
     * 
     * @return finHorario2
     */
    public java.lang.Integer getFinHorario2() {
        return finHorario2;
    }


    /**
     * Sets the finHorario2 value for this PCliente.
     * 
     * @param finHorario2
     */
    public void setFinHorario2(java.lang.Integer finHorario2) {
        this.finHorario2 = finHorario2;
    }


    /**
     * Gets the tiempoEspera value for this PCliente.
     * 
     * @return tiempoEspera
     */
    public java.lang.Integer getTiempoEspera() {
        return tiempoEspera;
    }


    /**
     * Sets the tiempoEspera value for this PCliente.
     * 
     * @param tiempoEspera
     */
    public void setTiempoEspera(java.lang.Integer tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }


    /**
     * Gets the varchar1 value for this PCliente.
     * 
     * @return varchar1
     */
    public java.lang.String getVarchar1() {
        return varchar1;
    }


    /**
     * Sets the varchar1 value for this PCliente.
     * 
     * @param varchar1
     */
    public void setVarchar1(java.lang.String varchar1) {
        this.varchar1 = varchar1;
    }


    /**
     * Gets the varchar2 value for this PCliente.
     * 
     * @return varchar2
     */
    public java.lang.String getVarchar2() {
        return varchar2;
    }


    /**
     * Sets the varchar2 value for this PCliente.
     * 
     * @param varchar2
     */
    public void setVarchar2(java.lang.String varchar2) {
        this.varchar2 = varchar2;
    }


    /**
     * Gets the grupo value for this PCliente.
     * 
     * @return grupo
     */
    public java.lang.String getGrupo() {
        return grupo;
    }


    /**
     * Sets the grupo value for this PCliente.
     * 
     * @param grupo
     */
    public void setGrupo(java.lang.String grupo) {
        this.grupo = grupo;
    }


    /**
     * Gets the numeroDocumento value for this PCliente.
     * 
     * @return numeroDocumento
     */
    public java.lang.String getNumeroDocumento() {
        return numeroDocumento;
    }


    /**
     * Sets the numeroDocumento value for this PCliente.
     * 
     * @param numeroDocumento
     */
    public void setNumeroDocumento(java.lang.String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    /**
     * Gets the tipoDocumento value for this PCliente.
     * 
     * @return tipoDocumento
     */
    public java.lang.String getTipoDocumento() {
        return tipoDocumento;
    }


    /**
     * Sets the tipoDocumento value for this PCliente.
     * 
     * @param tipoDocumento
     */
    public void setTipoDocumento(java.lang.String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    /**
     * Gets the domicilioCodigoPostal value for this PCliente.
     * 
     * @return domicilioCodigoPostal
     */
    public java.lang.String getDomicilioCodigoPostal() {
        return domicilioCodigoPostal;
    }


    /**
     * Sets the domicilioCodigoPostal value for this PCliente.
     * 
     * @param domicilioCodigoPostal
     */
    public void setDomicilioCodigoPostal(java.lang.String domicilioCodigoPostal) {
        this.domicilioCodigoPostal = domicilioCodigoPostal;
    }


    /**
     * Gets the domicilioFiscal value for this PCliente.
     * 
     * @return domicilioFiscal
     */
    public ar.com.unisolutions.PDomicilio getDomicilioFiscal() {
        return domicilioFiscal;
    }


    /**
     * Sets the domicilioFiscal value for this PCliente.
     * 
     * @param domicilioFiscal
     */
    public void setDomicilioFiscal(ar.com.unisolutions.PDomicilio domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }


    /**
     * Gets the campoDinamico value for this PCliente.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this PCliente.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the contacto value for this PCliente.
     * 
     * @return contacto
     */
    public java.lang.String getContacto() {
        return contacto;
    }


    /**
     * Sets the contacto value for this PCliente.
     * 
     * @param contacto
     */
    public void setContacto(java.lang.String contacto) {
        this.contacto = contacto;
    }


    /**
     * Gets the int1 value for this PCliente.
     * 
     * @return int1
     */
    public java.lang.Integer getInt1() {
        return int1;
    }


    /**
     * Sets the int1 value for this PCliente.
     * 
     * @param int1
     */
    public void setInt1(java.lang.Integer int1) {
        this.int1 = int1;
    }


    /**
     * Gets the int2 value for this PCliente.
     * 
     * @return int2
     */
    public java.lang.Integer getInt2() {
        return int2;
    }


    /**
     * Sets the int2 value for this PCliente.
     * 
     * @param int2
     */
    public void setInt2(java.lang.Integer int2) {
        this.int2 = int2;
    }


    /**
     * Gets the float1 value for this PCliente.
     * 
     * @return float1
     */
    public java.lang.Double getFloat1() {
        return float1;
    }


    /**
     * Sets the float1 value for this PCliente.
     * 
     * @param float1
     */
    public void setFloat1(java.lang.Double float1) {
        this.float1 = float1;
    }


    /**
     * Gets the float2 value for this PCliente.
     * 
     * @return float2
     */
    public java.lang.Double getFloat2() {
        return float2;
    }


    /**
     * Sets the float2 value for this PCliente.
     * 
     * @param float2
     */
    public void setFloat2(java.lang.Double float2) {
        this.float2 = float2;
    }


    /**
     * Gets the cargaExclusiva value for this PCliente.
     * 
     * @return cargaExclusiva
     */
    public java.lang.Boolean getCargaExclusiva() {
        return cargaExclusiva;
    }


    /**
     * Sets the cargaExclusiva value for this PCliente.
     * 
     * @param cargaExclusiva
     */
    public void setCargaExclusiva(java.lang.Boolean cargaExclusiva) {
        this.cargaExclusiva = cargaExclusiva;
    }


    /**
     * Gets the ignorarOperacion value for this PCliente.
     * 
     * @return ignorarOperacion
     */
    public java.lang.Boolean getIgnorarOperacion() {
        return ignorarOperacion;
    }


    /**
     * Sets the ignorarOperacion value for this PCliente.
     * 
     * @param ignorarOperacion
     */
    public void setIgnorarOperacion(java.lang.Boolean ignorarOperacion) {
        this.ignorarOperacion = ignorarOperacion;
    }


    /**
     * Gets the ignorarOperacionDomicilioOrden value for this PCliente.
     * 
     * @return ignorarOperacionDomicilioOrden
     */
    public java.lang.Boolean getIgnorarOperacionDomicilioOrden() {
        return ignorarOperacionDomicilioOrden;
    }


    /**
     * Sets the ignorarOperacionDomicilioOrden value for this PCliente.
     * 
     * @param ignorarOperacionDomicilioOrden
     */
    public void setIgnorarOperacionDomicilioOrden(java.lang.Boolean ignorarOperacionDomicilioOrden) {
        this.ignorarOperacionDomicilioOrden = ignorarOperacionDomicilioOrden;
    }


    /**
     * Gets the crearDomicilioOrden value for this PCliente.
     * 
     * @return crearDomicilioOrden
     */
    public java.lang.Boolean getCrearDomicilioOrden() {
        return crearDomicilioOrden;
    }


    /**
     * Sets the crearDomicilioOrden value for this PCliente.
     * 
     * @param crearDomicilioOrden
     */
    public void setCrearDomicilioOrden(java.lang.Boolean crearDomicilioOrden) {
        this.crearDomicilioOrden = crearDomicilioOrden;
    }


    /**
     * Gets the actualizarDomicilioOrden value for this PCliente.
     * 
     * @return actualizarDomicilioOrden
     */
    public java.lang.Boolean getActualizarDomicilioOrden() {
        return actualizarDomicilioOrden;
    }


    /**
     * Sets the actualizarDomicilioOrden value for this PCliente.
     * 
     * @param actualizarDomicilioOrden
     */
    public void setActualizarDomicilioOrden(java.lang.Boolean actualizarDomicilioOrden) {
        this.actualizarDomicilioOrden = actualizarDomicilioOrden;
    }


    /**
     * Gets the validarDomicilioOrden value for this PCliente.
     * 
     * @return validarDomicilioOrden
     */
    public java.lang.Boolean getValidarDomicilioOrden() {
        return validarDomicilioOrden;
    }


    /**
     * Sets the validarDomicilioOrden value for this PCliente.
     * 
     * @param validarDomicilioOrden
     */
    public void setValidarDomicilioOrden(java.lang.Boolean validarDomicilioOrden) {
        this.validarDomicilioOrden = validarDomicilioOrden;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PCliente)) return false;
        PCliente other = (PCliente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.refCliente==null && other.getRefCliente()==null) || 
             (this.refCliente!=null &&
              this.refCliente.equals(other.getRefCliente()))) &&
            ((this.razonSocial==null && other.getRazonSocial()==null) || 
             (this.razonSocial!=null &&
              this.razonSocial.equals(other.getRazonSocial()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.telefono2==null && other.getTelefono2()==null) || 
             (this.telefono2!=null &&
              this.telefono2.equals(other.getTelefono2()))) &&
            ((this.telefono3==null && other.getTelefono3()==null) || 
             (this.telefono3!=null &&
              this.telefono3.equals(other.getTelefono3()))) &&
            ((this.EMail==null && other.getEMail()==null) || 
             (this.EMail!=null &&
              this.EMail.equals(other.getEMail()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.calle==null && other.getCalle()==null) || 
             (this.calle!=null &&
              this.calle.equals(other.getCalle()))) &&
            ((this.numeroPuerta==null && other.getNumeroPuerta()==null) || 
             (this.numeroPuerta!=null &&
              this.numeroPuerta.equals(other.getNumeroPuerta()))) &&
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
            ((this.latitud==null && other.getLatitud()==null) || 
             (this.latitud!=null &&
              this.latitud.equals(other.getLatitud()))) &&
            ((this.longitud==null && other.getLongitud()==null) || 
             (this.longitud!=null &&
              this.longitud.equals(other.getLongitud()))) &&
            ((this.refDomicilioExterno==null && other.getRefDomicilioExterno()==null) || 
             (this.refDomicilioExterno!=null &&
              this.refDomicilioExterno.equals(other.getRefDomicilioExterno()))) &&
            ((this.domicilioDescripcion==null && other.getDomicilioDescripcion()==null) || 
             (this.domicilioDescripcion!=null &&
              this.domicilioDescripcion.equals(other.getDomicilioDescripcion()))) &&
            ((this.inicioHorario1==null && other.getInicioHorario1()==null) || 
             (this.inicioHorario1!=null &&
              this.inicioHorario1.equals(other.getInicioHorario1()))) &&
            ((this.inicioHorario2==null && other.getInicioHorario2()==null) || 
             (this.inicioHorario2!=null &&
              this.inicioHorario2.equals(other.getInicioHorario2()))) &&
            ((this.finHorario1==null && other.getFinHorario1()==null) || 
             (this.finHorario1!=null &&
              this.finHorario1.equals(other.getFinHorario1()))) &&
            ((this.finHorario2==null && other.getFinHorario2()==null) || 
             (this.finHorario2!=null &&
              this.finHorario2.equals(other.getFinHorario2()))) &&
            ((this.tiempoEspera==null && other.getTiempoEspera()==null) || 
             (this.tiempoEspera!=null &&
              this.tiempoEspera.equals(other.getTiempoEspera()))) &&
            ((this.varchar1==null && other.getVarchar1()==null) || 
             (this.varchar1!=null &&
              this.varchar1.equals(other.getVarchar1()))) &&
            ((this.varchar2==null && other.getVarchar2()==null) || 
             (this.varchar2!=null &&
              this.varchar2.equals(other.getVarchar2()))) &&
            ((this.grupo==null && other.getGrupo()==null) || 
             (this.grupo!=null &&
              this.grupo.equals(other.getGrupo()))) &&
            ((this.numeroDocumento==null && other.getNumeroDocumento()==null) || 
             (this.numeroDocumento!=null &&
              this.numeroDocumento.equals(other.getNumeroDocumento()))) &&
            ((this.tipoDocumento==null && other.getTipoDocumento()==null) || 
             (this.tipoDocumento!=null &&
              this.tipoDocumento.equals(other.getTipoDocumento()))) &&
            ((this.domicilioCodigoPostal==null && other.getDomicilioCodigoPostal()==null) || 
             (this.domicilioCodigoPostal!=null &&
              this.domicilioCodigoPostal.equals(other.getDomicilioCodigoPostal()))) &&
            ((this.domicilioFiscal==null && other.getDomicilioFiscal()==null) || 
             (this.domicilioFiscal!=null &&
              this.domicilioFiscal.equals(other.getDomicilioFiscal()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.contacto==null && other.getContacto()==null) || 
             (this.contacto!=null &&
              this.contacto.equals(other.getContacto()))) &&
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
            ((this.cargaExclusiva==null && other.getCargaExclusiva()==null) || 
             (this.cargaExclusiva!=null &&
              this.cargaExclusiva.equals(other.getCargaExclusiva()))) &&
            ((this.ignorarOperacion==null && other.getIgnorarOperacion()==null) || 
             (this.ignorarOperacion!=null &&
              this.ignorarOperacion.equals(other.getIgnorarOperacion()))) &&
            ((this.ignorarOperacionDomicilioOrden==null && other.getIgnorarOperacionDomicilioOrden()==null) || 
             (this.ignorarOperacionDomicilioOrden!=null &&
              this.ignorarOperacionDomicilioOrden.equals(other.getIgnorarOperacionDomicilioOrden()))) &&
            ((this.crearDomicilioOrden==null && other.getCrearDomicilioOrden()==null) || 
             (this.crearDomicilioOrden!=null &&
              this.crearDomicilioOrden.equals(other.getCrearDomicilioOrden()))) &&
            ((this.actualizarDomicilioOrden==null && other.getActualizarDomicilioOrden()==null) || 
             (this.actualizarDomicilioOrden!=null &&
              this.actualizarDomicilioOrden.equals(other.getActualizarDomicilioOrden()))) &&
            ((this.validarDomicilioOrden==null && other.getValidarDomicilioOrden()==null) || 
             (this.validarDomicilioOrden!=null &&
              this.validarDomicilioOrden.equals(other.getValidarDomicilioOrden())));
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
        if (getRefCliente() != null) {
            _hashCode += getRefCliente().hashCode();
        }
        if (getRazonSocial() != null) {
            _hashCode += getRazonSocial().hashCode();
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
        if (getEMail() != null) {
            _hashCode += getEMail().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getCalle() != null) {
            _hashCode += getCalle().hashCode();
        }
        if (getNumeroPuerta() != null) {
            _hashCode += getNumeroPuerta().hashCode();
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
        if (getLatitud() != null) {
            _hashCode += getLatitud().hashCode();
        }
        if (getLongitud() != null) {
            _hashCode += getLongitud().hashCode();
        }
        if (getRefDomicilioExterno() != null) {
            _hashCode += getRefDomicilioExterno().hashCode();
        }
        if (getDomicilioDescripcion() != null) {
            _hashCode += getDomicilioDescripcion().hashCode();
        }
        if (getInicioHorario1() != null) {
            _hashCode += getInicioHorario1().hashCode();
        }
        if (getInicioHorario2() != null) {
            _hashCode += getInicioHorario2().hashCode();
        }
        if (getFinHorario1() != null) {
            _hashCode += getFinHorario1().hashCode();
        }
        if (getFinHorario2() != null) {
            _hashCode += getFinHorario2().hashCode();
        }
        if (getTiempoEspera() != null) {
            _hashCode += getTiempoEspera().hashCode();
        }
        if (getVarchar1() != null) {
            _hashCode += getVarchar1().hashCode();
        }
        if (getVarchar2() != null) {
            _hashCode += getVarchar2().hashCode();
        }
        if (getGrupo() != null) {
            _hashCode += getGrupo().hashCode();
        }
        if (getNumeroDocumento() != null) {
            _hashCode += getNumeroDocumento().hashCode();
        }
        if (getTipoDocumento() != null) {
            _hashCode += getTipoDocumento().hashCode();
        }
        if (getDomicilioCodigoPostal() != null) {
            _hashCode += getDomicilioCodigoPostal().hashCode();
        }
        if (getDomicilioFiscal() != null) {
            _hashCode += getDomicilioFiscal().hashCode();
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
        if (getContacto() != null) {
            _hashCode += getContacto().hashCode();
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
        if (getCargaExclusiva() != null) {
            _hashCode += getCargaExclusiva().hashCode();
        }
        if (getIgnorarOperacion() != null) {
            _hashCode += getIgnorarOperacion().hashCode();
        }
        if (getIgnorarOperacionDomicilioOrden() != null) {
            _hashCode += getIgnorarOperacionDomicilioOrden().hashCode();
        }
        if (getCrearDomicilioOrden() != null) {
            _hashCode += getCrearDomicilioOrden().hashCode();
        }
        if (getActualizarDomicilioOrden() != null) {
            _hashCode += getActualizarDomicilioOrden().hashCode();
        }
        if (getValidarDomicilioOrden() != null) {
            _hashCode += getValidarDomicilioOrden().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PCliente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RazonSocial"));
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
        elemField.setFieldName("EMail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EMail"));
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
        elemField.setFieldName("numeroPuerta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "NumeroPuerta"));
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
        elemField.setFieldName("refDomicilioExterno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDomicilioExterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioDescripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DomicilioDescripcion"));
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
        elemField.setFieldName("inicioHorario2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorario2"));
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
        elemField.setFieldName("grupo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Grupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "NumeroDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioCodigoPostal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DomicilioCodigoPostal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioFiscal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DomicilioFiscal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDomicilio"));
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
        elemField.setFieldName("contacto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Contacto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("int1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Int1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("int2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Int2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("cargaExclusiva");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CargaExclusiva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ignorarOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IgnorarOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ignorarOperacionDomicilioOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IgnorarOperacionDomicilioOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearDomicilioOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearDomicilioOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualizarDomicilioOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ActualizarDomicilioOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validarDomicilioOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValidarDomicilioOrden"));
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
