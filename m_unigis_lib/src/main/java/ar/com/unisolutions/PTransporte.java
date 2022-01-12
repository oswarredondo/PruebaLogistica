/**
 * PTransporte.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PTransporte  implements java.io.Serializable {
    private java.lang.String referencia;

    private java.lang.String referenciaAdicional;

    private java.lang.String descripcion;

    private java.lang.String cuit;

    private java.lang.String direccion;

    private java.lang.String telefono1;

    private java.lang.String telefono2;

    private java.lang.Boolean habilitadoAdministrativo;

    private java.lang.Boolean habilitadoOperativo;

    private ar.com.unisolutions.PConductorTransporte[] conductores;

    private java.lang.String razonSocial;

    private java.lang.String nombreFantasia;

    private java.lang.String email;

    private java.lang.String tipoTransporte;

    private java.lang.String localidad;

    private java.lang.String refernciaExternaEstadoTransporte;

    private java.lang.String contacto;

    private java.lang.String codigoPostal;

    private java.lang.String descripcionEstado;

    private java.lang.String descripcionGrupoTendering;

    private java.lang.Integer idEstado;

    private java.lang.Integer horarioDesdeTendering;

    private java.lang.Integer horarioHastaTendering;

    private java.lang.Integer prioridadTendering;

    private java.lang.Integer horarioPublicacionDesdeTendering;

    private java.lang.Integer horarioPublicacionHastaTendering;

    private java.lang.Double calificacion;

    private java.lang.Double latitud;

    private java.lang.Double longitud;

    private java.lang.Boolean habilitadoTendering;

    public PTransporte() {
    }

    public PTransporte(
           java.lang.String referencia,
           java.lang.String referenciaAdicional,
           java.lang.String descripcion,
           java.lang.String cuit,
           java.lang.String direccion,
           java.lang.String telefono1,
           java.lang.String telefono2,
           java.lang.Boolean habilitadoAdministrativo,
           java.lang.Boolean habilitadoOperativo,
           ar.com.unisolutions.PConductorTransporte[] conductores,
           java.lang.String razonSocial,
           java.lang.String nombreFantasia,
           java.lang.String email,
           java.lang.String tipoTransporte,
           java.lang.String localidad,
           java.lang.String refernciaExternaEstadoTransporte,
           java.lang.String contacto,
           java.lang.String codigoPostal,
           java.lang.String descripcionEstado,
           java.lang.String descripcionGrupoTendering,
           java.lang.Integer idEstado,
           java.lang.Integer horarioDesdeTendering,
           java.lang.Integer horarioHastaTendering,
           java.lang.Integer prioridadTendering,
           java.lang.Integer horarioPublicacionDesdeTendering,
           java.lang.Integer horarioPublicacionHastaTendering,
           java.lang.Double calificacion,
           java.lang.Double latitud,
           java.lang.Double longitud,
           java.lang.Boolean habilitadoTendering) {
           this.referencia = referencia;
           this.referenciaAdicional = referenciaAdicional;
           this.descripcion = descripcion;
           this.cuit = cuit;
           this.direccion = direccion;
           this.telefono1 = telefono1;
           this.telefono2 = telefono2;
           this.habilitadoAdministrativo = habilitadoAdministrativo;
           this.habilitadoOperativo = habilitadoOperativo;
           this.conductores = conductores;
           this.razonSocial = razonSocial;
           this.nombreFantasia = nombreFantasia;
           this.email = email;
           this.tipoTransporte = tipoTransporte;
           this.localidad = localidad;
           this.refernciaExternaEstadoTransporte = refernciaExternaEstadoTransporte;
           this.contacto = contacto;
           this.codigoPostal = codigoPostal;
           this.descripcionEstado = descripcionEstado;
           this.descripcionGrupoTendering = descripcionGrupoTendering;
           this.idEstado = idEstado;
           this.horarioDesdeTendering = horarioDesdeTendering;
           this.horarioHastaTendering = horarioHastaTendering;
           this.prioridadTendering = prioridadTendering;
           this.horarioPublicacionDesdeTendering = horarioPublicacionDesdeTendering;
           this.horarioPublicacionHastaTendering = horarioPublicacionHastaTendering;
           this.calificacion = calificacion;
           this.latitud = latitud;
           this.longitud = longitud;
           this.habilitadoTendering = habilitadoTendering;
    }


    /**
     * Gets the referencia value for this PTransporte.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this PTransporte.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the referenciaAdicional value for this PTransporte.
     * 
     * @return referenciaAdicional
     */
    public java.lang.String getReferenciaAdicional() {
        return referenciaAdicional;
    }


    /**
     * Sets the referenciaAdicional value for this PTransporte.
     * 
     * @param referenciaAdicional
     */
    public void setReferenciaAdicional(java.lang.String referenciaAdicional) {
        this.referenciaAdicional = referenciaAdicional;
    }


    /**
     * Gets the descripcion value for this PTransporte.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PTransporte.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the cuit value for this PTransporte.
     * 
     * @return cuit
     */
    public java.lang.String getCuit() {
        return cuit;
    }


    /**
     * Sets the cuit value for this PTransporte.
     * 
     * @param cuit
     */
    public void setCuit(java.lang.String cuit) {
        this.cuit = cuit;
    }


    /**
     * Gets the direccion value for this PTransporte.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this PTransporte.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the telefono1 value for this PTransporte.
     * 
     * @return telefono1
     */
    public java.lang.String getTelefono1() {
        return telefono1;
    }


    /**
     * Sets the telefono1 value for this PTransporte.
     * 
     * @param telefono1
     */
    public void setTelefono1(java.lang.String telefono1) {
        this.telefono1 = telefono1;
    }


    /**
     * Gets the telefono2 value for this PTransporte.
     * 
     * @return telefono2
     */
    public java.lang.String getTelefono2() {
        return telefono2;
    }


    /**
     * Sets the telefono2 value for this PTransporte.
     * 
     * @param telefono2
     */
    public void setTelefono2(java.lang.String telefono2) {
        this.telefono2 = telefono2;
    }


    /**
     * Gets the habilitadoAdministrativo value for this PTransporte.
     * 
     * @return habilitadoAdministrativo
     */
    public java.lang.Boolean getHabilitadoAdministrativo() {
        return habilitadoAdministrativo;
    }


    /**
     * Sets the habilitadoAdministrativo value for this PTransporte.
     * 
     * @param habilitadoAdministrativo
     */
    public void setHabilitadoAdministrativo(java.lang.Boolean habilitadoAdministrativo) {
        this.habilitadoAdministrativo = habilitadoAdministrativo;
    }


    /**
     * Gets the habilitadoOperativo value for this PTransporte.
     * 
     * @return habilitadoOperativo
     */
    public java.lang.Boolean getHabilitadoOperativo() {
        return habilitadoOperativo;
    }


    /**
     * Sets the habilitadoOperativo value for this PTransporte.
     * 
     * @param habilitadoOperativo
     */
    public void setHabilitadoOperativo(java.lang.Boolean habilitadoOperativo) {
        this.habilitadoOperativo = habilitadoOperativo;
    }


    /**
     * Gets the conductores value for this PTransporte.
     * 
     * @return conductores
     */
    public ar.com.unisolutions.PConductorTransporte[] getConductores() {
        return conductores;
    }


    /**
     * Sets the conductores value for this PTransporte.
     * 
     * @param conductores
     */
    public void setConductores(ar.com.unisolutions.PConductorTransporte[] conductores) {
        this.conductores = conductores;
    }


    /**
     * Gets the razonSocial value for this PTransporte.
     * 
     * @return razonSocial
     */
    public java.lang.String getRazonSocial() {
        return razonSocial;
    }


    /**
     * Sets the razonSocial value for this PTransporte.
     * 
     * @param razonSocial
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = razonSocial;
    }


    /**
     * Gets the nombreFantasia value for this PTransporte.
     * 
     * @return nombreFantasia
     */
    public java.lang.String getNombreFantasia() {
        return nombreFantasia;
    }


    /**
     * Sets the nombreFantasia value for this PTransporte.
     * 
     * @param nombreFantasia
     */
    public void setNombreFantasia(java.lang.String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }


    /**
     * Gets the email value for this PTransporte.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this PTransporte.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the tipoTransporte value for this PTransporte.
     * 
     * @return tipoTransporte
     */
    public java.lang.String getTipoTransporte() {
        return tipoTransporte;
    }


    /**
     * Sets the tipoTransporte value for this PTransporte.
     * 
     * @param tipoTransporte
     */
    public void setTipoTransporte(java.lang.String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }


    /**
     * Gets the localidad value for this PTransporte.
     * 
     * @return localidad
     */
    public java.lang.String getLocalidad() {
        return localidad;
    }


    /**
     * Sets the localidad value for this PTransporte.
     * 
     * @param localidad
     */
    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }


    /**
     * Gets the refernciaExternaEstadoTransporte value for this PTransporte.
     * 
     * @return refernciaExternaEstadoTransporte
     */
    public java.lang.String getRefernciaExternaEstadoTransporte() {
        return refernciaExternaEstadoTransporte;
    }


    /**
     * Sets the refernciaExternaEstadoTransporte value for this PTransporte.
     * 
     * @param refernciaExternaEstadoTransporte
     */
    public void setRefernciaExternaEstadoTransporte(java.lang.String refernciaExternaEstadoTransporte) {
        this.refernciaExternaEstadoTransporte = refernciaExternaEstadoTransporte;
    }


    /**
     * Gets the contacto value for this PTransporte.
     * 
     * @return contacto
     */
    public java.lang.String getContacto() {
        return contacto;
    }


    /**
     * Sets the contacto value for this PTransporte.
     * 
     * @param contacto
     */
    public void setContacto(java.lang.String contacto) {
        this.contacto = contacto;
    }


    /**
     * Gets the codigoPostal value for this PTransporte.
     * 
     * @return codigoPostal
     */
    public java.lang.String getCodigoPostal() {
        return codigoPostal;
    }


    /**
     * Sets the codigoPostal value for this PTransporte.
     * 
     * @param codigoPostal
     */
    public void setCodigoPostal(java.lang.String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    /**
     * Gets the descripcionEstado value for this PTransporte.
     * 
     * @return descripcionEstado
     */
    public java.lang.String getDescripcionEstado() {
        return descripcionEstado;
    }


    /**
     * Sets the descripcionEstado value for this PTransporte.
     * 
     * @param descripcionEstado
     */
    public void setDescripcionEstado(java.lang.String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }


    /**
     * Gets the descripcionGrupoTendering value for this PTransporte.
     * 
     * @return descripcionGrupoTendering
     */
    public java.lang.String getDescripcionGrupoTendering() {
        return descripcionGrupoTendering;
    }


    /**
     * Sets the descripcionGrupoTendering value for this PTransporte.
     * 
     * @param descripcionGrupoTendering
     */
    public void setDescripcionGrupoTendering(java.lang.String descripcionGrupoTendering) {
        this.descripcionGrupoTendering = descripcionGrupoTendering;
    }


    /**
     * Gets the idEstado value for this PTransporte.
     * 
     * @return idEstado
     */
    public java.lang.Integer getIdEstado() {
        return idEstado;
    }


    /**
     * Sets the idEstado value for this PTransporte.
     * 
     * @param idEstado
     */
    public void setIdEstado(java.lang.Integer idEstado) {
        this.idEstado = idEstado;
    }


    /**
     * Gets the horarioDesdeTendering value for this PTransporte.
     * 
     * @return horarioDesdeTendering
     */
    public java.lang.Integer getHorarioDesdeTendering() {
        return horarioDesdeTendering;
    }


    /**
     * Sets the horarioDesdeTendering value for this PTransporte.
     * 
     * @param horarioDesdeTendering
     */
    public void setHorarioDesdeTendering(java.lang.Integer horarioDesdeTendering) {
        this.horarioDesdeTendering = horarioDesdeTendering;
    }


    /**
     * Gets the horarioHastaTendering value for this PTransporte.
     * 
     * @return horarioHastaTendering
     */
    public java.lang.Integer getHorarioHastaTendering() {
        return horarioHastaTendering;
    }


    /**
     * Sets the horarioHastaTendering value for this PTransporte.
     * 
     * @param horarioHastaTendering
     */
    public void setHorarioHastaTendering(java.lang.Integer horarioHastaTendering) {
        this.horarioHastaTendering = horarioHastaTendering;
    }


    /**
     * Gets the prioridadTendering value for this PTransporte.
     * 
     * @return prioridadTendering
     */
    public java.lang.Integer getPrioridadTendering() {
        return prioridadTendering;
    }


    /**
     * Sets the prioridadTendering value for this PTransporte.
     * 
     * @param prioridadTendering
     */
    public void setPrioridadTendering(java.lang.Integer prioridadTendering) {
        this.prioridadTendering = prioridadTendering;
    }


    /**
     * Gets the horarioPublicacionDesdeTendering value for this PTransporte.
     * 
     * @return horarioPublicacionDesdeTendering
     */
    public java.lang.Integer getHorarioPublicacionDesdeTendering() {
        return horarioPublicacionDesdeTendering;
    }


    /**
     * Sets the horarioPublicacionDesdeTendering value for this PTransporte.
     * 
     * @param horarioPublicacionDesdeTendering
     */
    public void setHorarioPublicacionDesdeTendering(java.lang.Integer horarioPublicacionDesdeTendering) {
        this.horarioPublicacionDesdeTendering = horarioPublicacionDesdeTendering;
    }


    /**
     * Gets the horarioPublicacionHastaTendering value for this PTransporte.
     * 
     * @return horarioPublicacionHastaTendering
     */
    public java.lang.Integer getHorarioPublicacionHastaTendering() {
        return horarioPublicacionHastaTendering;
    }


    /**
     * Sets the horarioPublicacionHastaTendering value for this PTransporte.
     * 
     * @param horarioPublicacionHastaTendering
     */
    public void setHorarioPublicacionHastaTendering(java.lang.Integer horarioPublicacionHastaTendering) {
        this.horarioPublicacionHastaTendering = horarioPublicacionHastaTendering;
    }


    /**
     * Gets the calificacion value for this PTransporte.
     * 
     * @return calificacion
     */
    public java.lang.Double getCalificacion() {
        return calificacion;
    }


    /**
     * Sets the calificacion value for this PTransporte.
     * 
     * @param calificacion
     */
    public void setCalificacion(java.lang.Double calificacion) {
        this.calificacion = calificacion;
    }


    /**
     * Gets the latitud value for this PTransporte.
     * 
     * @return latitud
     */
    public java.lang.Double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this PTransporte.
     * 
     * @param latitud
     */
    public void setLatitud(java.lang.Double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this PTransporte.
     * 
     * @return longitud
     */
    public java.lang.Double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this PTransporte.
     * 
     * @param longitud
     */
    public void setLongitud(java.lang.Double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the habilitadoTendering value for this PTransporte.
     * 
     * @return habilitadoTendering
     */
    public java.lang.Boolean getHabilitadoTendering() {
        return habilitadoTendering;
    }


    /**
     * Sets the habilitadoTendering value for this PTransporte.
     * 
     * @param habilitadoTendering
     */
    public void setHabilitadoTendering(java.lang.Boolean habilitadoTendering) {
        this.habilitadoTendering = habilitadoTendering;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTransporte)) return false;
        PTransporte other = (PTransporte) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            ((this.referenciaAdicional==null && other.getReferenciaAdicional()==null) || 
             (this.referenciaAdicional!=null &&
              this.referenciaAdicional.equals(other.getReferenciaAdicional()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.cuit==null && other.getCuit()==null) || 
             (this.cuit!=null &&
              this.cuit.equals(other.getCuit()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.telefono1==null && other.getTelefono1()==null) || 
             (this.telefono1!=null &&
              this.telefono1.equals(other.getTelefono1()))) &&
            ((this.telefono2==null && other.getTelefono2()==null) || 
             (this.telefono2!=null &&
              this.telefono2.equals(other.getTelefono2()))) &&
            ((this.habilitadoAdministrativo==null && other.getHabilitadoAdministrativo()==null) || 
             (this.habilitadoAdministrativo!=null &&
              this.habilitadoAdministrativo.equals(other.getHabilitadoAdministrativo()))) &&
            ((this.habilitadoOperativo==null && other.getHabilitadoOperativo()==null) || 
             (this.habilitadoOperativo!=null &&
              this.habilitadoOperativo.equals(other.getHabilitadoOperativo()))) &&
            ((this.conductores==null && other.getConductores()==null) || 
             (this.conductores!=null &&
              java.util.Arrays.equals(this.conductores, other.getConductores()))) &&
            ((this.razonSocial==null && other.getRazonSocial()==null) || 
             (this.razonSocial!=null &&
              this.razonSocial.equals(other.getRazonSocial()))) &&
            ((this.nombreFantasia==null && other.getNombreFantasia()==null) || 
             (this.nombreFantasia!=null &&
              this.nombreFantasia.equals(other.getNombreFantasia()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.tipoTransporte==null && other.getTipoTransporte()==null) || 
             (this.tipoTransporte!=null &&
              this.tipoTransporte.equals(other.getTipoTransporte()))) &&
            ((this.localidad==null && other.getLocalidad()==null) || 
             (this.localidad!=null &&
              this.localidad.equals(other.getLocalidad()))) &&
            ((this.refernciaExternaEstadoTransporte==null && other.getRefernciaExternaEstadoTransporte()==null) || 
             (this.refernciaExternaEstadoTransporte!=null &&
              this.refernciaExternaEstadoTransporte.equals(other.getRefernciaExternaEstadoTransporte()))) &&
            ((this.contacto==null && other.getContacto()==null) || 
             (this.contacto!=null &&
              this.contacto.equals(other.getContacto()))) &&
            ((this.codigoPostal==null && other.getCodigoPostal()==null) || 
             (this.codigoPostal!=null &&
              this.codigoPostal.equals(other.getCodigoPostal()))) &&
            ((this.descripcionEstado==null && other.getDescripcionEstado()==null) || 
             (this.descripcionEstado!=null &&
              this.descripcionEstado.equals(other.getDescripcionEstado()))) &&
            ((this.descripcionGrupoTendering==null && other.getDescripcionGrupoTendering()==null) || 
             (this.descripcionGrupoTendering!=null &&
              this.descripcionGrupoTendering.equals(other.getDescripcionGrupoTendering()))) &&
            ((this.idEstado==null && other.getIdEstado()==null) || 
             (this.idEstado!=null &&
              this.idEstado.equals(other.getIdEstado()))) &&
            ((this.horarioDesdeTendering==null && other.getHorarioDesdeTendering()==null) || 
             (this.horarioDesdeTendering!=null &&
              this.horarioDesdeTendering.equals(other.getHorarioDesdeTendering()))) &&
            ((this.horarioHastaTendering==null && other.getHorarioHastaTendering()==null) || 
             (this.horarioHastaTendering!=null &&
              this.horarioHastaTendering.equals(other.getHorarioHastaTendering()))) &&
            ((this.prioridadTendering==null && other.getPrioridadTendering()==null) || 
             (this.prioridadTendering!=null &&
              this.prioridadTendering.equals(other.getPrioridadTendering()))) &&
            ((this.horarioPublicacionDesdeTendering==null && other.getHorarioPublicacionDesdeTendering()==null) || 
             (this.horarioPublicacionDesdeTendering!=null &&
              this.horarioPublicacionDesdeTendering.equals(other.getHorarioPublicacionDesdeTendering()))) &&
            ((this.horarioPublicacionHastaTendering==null && other.getHorarioPublicacionHastaTendering()==null) || 
             (this.horarioPublicacionHastaTendering!=null &&
              this.horarioPublicacionHastaTendering.equals(other.getHorarioPublicacionHastaTendering()))) &&
            ((this.calificacion==null && other.getCalificacion()==null) || 
             (this.calificacion!=null &&
              this.calificacion.equals(other.getCalificacion()))) &&
            ((this.latitud==null && other.getLatitud()==null) || 
             (this.latitud!=null &&
              this.latitud.equals(other.getLatitud()))) &&
            ((this.longitud==null && other.getLongitud()==null) || 
             (this.longitud!=null &&
              this.longitud.equals(other.getLongitud()))) &&
            ((this.habilitadoTendering==null && other.getHabilitadoTendering()==null) || 
             (this.habilitadoTendering!=null &&
              this.habilitadoTendering.equals(other.getHabilitadoTendering())));
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
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        if (getReferenciaAdicional() != null) {
            _hashCode += getReferenciaAdicional().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getCuit() != null) {
            _hashCode += getCuit().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getTelefono1() != null) {
            _hashCode += getTelefono1().hashCode();
        }
        if (getTelefono2() != null) {
            _hashCode += getTelefono2().hashCode();
        }
        if (getHabilitadoAdministrativo() != null) {
            _hashCode += getHabilitadoAdministrativo().hashCode();
        }
        if (getHabilitadoOperativo() != null) {
            _hashCode += getHabilitadoOperativo().hashCode();
        }
        if (getConductores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConductores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConductores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRazonSocial() != null) {
            _hashCode += getRazonSocial().hashCode();
        }
        if (getNombreFantasia() != null) {
            _hashCode += getNombreFantasia().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getTipoTransporte() != null) {
            _hashCode += getTipoTransporte().hashCode();
        }
        if (getLocalidad() != null) {
            _hashCode += getLocalidad().hashCode();
        }
        if (getRefernciaExternaEstadoTransporte() != null) {
            _hashCode += getRefernciaExternaEstadoTransporte().hashCode();
        }
        if (getContacto() != null) {
            _hashCode += getContacto().hashCode();
        }
        if (getCodigoPostal() != null) {
            _hashCode += getCodigoPostal().hashCode();
        }
        if (getDescripcionEstado() != null) {
            _hashCode += getDescripcionEstado().hashCode();
        }
        if (getDescripcionGrupoTendering() != null) {
            _hashCode += getDescripcionGrupoTendering().hashCode();
        }
        if (getIdEstado() != null) {
            _hashCode += getIdEstado().hashCode();
        }
        if (getHorarioDesdeTendering() != null) {
            _hashCode += getHorarioDesdeTendering().hashCode();
        }
        if (getHorarioHastaTendering() != null) {
            _hashCode += getHorarioHastaTendering().hashCode();
        }
        if (getPrioridadTendering() != null) {
            _hashCode += getPrioridadTendering().hashCode();
        }
        if (getHorarioPublicacionDesdeTendering() != null) {
            _hashCode += getHorarioPublicacionDesdeTendering().hashCode();
        }
        if (getHorarioPublicacionHastaTendering() != null) {
            _hashCode += getHorarioPublicacionHastaTendering().hashCode();
        }
        if (getCalificacion() != null) {
            _hashCode += getCalificacion().hashCode();
        }
        if (getLatitud() != null) {
            _hashCode += getLatitud().hashCode();
        }
        if (getLongitud() != null) {
            _hashCode += getLongitud().hashCode();
        }
        if (getHabilitadoTendering() != null) {
            _hashCode += getHabilitadoTendering().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTransporte.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pTransporte"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Referencia"));
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
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cuit"));
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
        elemField.setFieldName("telefono1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Telefono1"));
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
        elemField.setFieldName("habilitadoAdministrativo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HabilitadoAdministrativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("habilitadoOperativo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HabilitadoOperativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conductores");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductorTransporte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductorTransporte"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RazonSocial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreFantasia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "NombreFantasia"));
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
        elemField.setFieldName("tipoTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoTransporte"));
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
        elemField.setFieldName("refernciaExternaEstadoTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefernciaExternaEstadoTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contacto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Contacto"));
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
        elemField.setFieldName("descripcionEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DescripcionEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionGrupoTendering");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DescripcionGrupoTendering"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horarioDesdeTendering");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HorarioDesdeTendering"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horarioHastaTendering");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HorarioHastaTendering"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prioridadTendering");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "PrioridadTendering"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horarioPublicacionDesdeTendering");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HorarioPublicacionDesdeTendering"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horarioPublicacionHastaTendering");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HorarioPublicacionHastaTendering"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Calificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Latitud"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("habilitadoTendering");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HabilitadoTendering"));
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
