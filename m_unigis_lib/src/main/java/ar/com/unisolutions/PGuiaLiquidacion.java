/**
 * PGuiaLiquidacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PGuiaLiquidacion  implements java.io.Serializable {
    private int idGuiaLiquidacion;

    private java.lang.String estado;

    private java.util.Calendar fecha;

    private java.util.Calendar fechaCreacion;

    private java.lang.String observaciones;

    private double importeNeto;

    private double importeTotal;

    private double importeConceptos;

    private ar.com.unisolutions.PEmpresa empresa;

    private ar.com.unisolutions.PSucursal sucursal;

    private ar.com.unisolutions.POperacion operacion;

    private ar.com.unisolutions.PTransporte transporte;

    private ar.com.unisolutions.PConductor conductor;

    private ar.com.unisolutions.PVehiculo vehiculo;

    private ar.com.unisolutions.PCliente cliente;

    private java.lang.String refExterna;

    private java.lang.String tipoGuia;

    private java.lang.String jurisdiccion;

    private java.lang.Integer idLiquidacion;

    private java.lang.String estadoLiquidacion;

    private ar.com.unisolutions.PPeriodoLiquidacion periodo;

    private ar.com.unisolutions.PViaje[] viajes;

    private ar.com.unisolutions.PConceptoExterno[] conceptos;

    private ar.com.unisolutions.PIncidencia[] incidencias;

    private ar.com.unisolutions.PImputacion[] imputaciones;

    private ar.com.unisolutions.PConceptoDinamico[] conceptosDinamicos;

    public PGuiaLiquidacion() {
    }

    public PGuiaLiquidacion(
           int idGuiaLiquidacion,
           java.lang.String estado,
           java.util.Calendar fecha,
           java.util.Calendar fechaCreacion,
           java.lang.String observaciones,
           double importeNeto,
           double importeTotal,
           double importeConceptos,
           ar.com.unisolutions.PEmpresa empresa,
           ar.com.unisolutions.PSucursal sucursal,
           ar.com.unisolutions.POperacion operacion,
           ar.com.unisolutions.PTransporte transporte,
           ar.com.unisolutions.PConductor conductor,
           ar.com.unisolutions.PVehiculo vehiculo,
           ar.com.unisolutions.PCliente cliente,
           java.lang.String refExterna,
           java.lang.String tipoGuia,
           java.lang.String jurisdiccion,
           java.lang.Integer idLiquidacion,
           java.lang.String estadoLiquidacion,
           ar.com.unisolutions.PPeriodoLiquidacion periodo,
           ar.com.unisolutions.PViaje[] viajes,
           ar.com.unisolutions.PConceptoExterno[] conceptos,
           ar.com.unisolutions.PIncidencia[] incidencias,
           ar.com.unisolutions.PImputacion[] imputaciones,
           ar.com.unisolutions.PConceptoDinamico[] conceptosDinamicos) {
           this.idGuiaLiquidacion = idGuiaLiquidacion;
           this.estado = estado;
           this.fecha = fecha;
           this.fechaCreacion = fechaCreacion;
           this.observaciones = observaciones;
           this.importeNeto = importeNeto;
           this.importeTotal = importeTotal;
           this.importeConceptos = importeConceptos;
           this.empresa = empresa;
           this.sucursal = sucursal;
           this.operacion = operacion;
           this.transporte = transporte;
           this.conductor = conductor;
           this.vehiculo = vehiculo;
           this.cliente = cliente;
           this.refExterna = refExterna;
           this.tipoGuia = tipoGuia;
           this.jurisdiccion = jurisdiccion;
           this.idLiquidacion = idLiquidacion;
           this.estadoLiquidacion = estadoLiquidacion;
           this.periodo = periodo;
           this.viajes = viajes;
           this.conceptos = conceptos;
           this.incidencias = incidencias;
           this.imputaciones = imputaciones;
           this.conceptosDinamicos = conceptosDinamicos;
    }


    /**
     * Gets the idGuiaLiquidacion value for this PGuiaLiquidacion.
     * 
     * @return idGuiaLiquidacion
     */
    public int getIdGuiaLiquidacion() {
        return idGuiaLiquidacion;
    }


    /**
     * Sets the idGuiaLiquidacion value for this PGuiaLiquidacion.
     * 
     * @param idGuiaLiquidacion
     */
    public void setIdGuiaLiquidacion(int idGuiaLiquidacion) {
        this.idGuiaLiquidacion = idGuiaLiquidacion;
    }


    /**
     * Gets the estado value for this PGuiaLiquidacion.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PGuiaLiquidacion.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the fecha value for this PGuiaLiquidacion.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this PGuiaLiquidacion.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the fechaCreacion value for this PGuiaLiquidacion.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this PGuiaLiquidacion.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the observaciones value for this PGuiaLiquidacion.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this PGuiaLiquidacion.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the importeNeto value for this PGuiaLiquidacion.
     * 
     * @return importeNeto
     */
    public double getImporteNeto() {
        return importeNeto;
    }


    /**
     * Sets the importeNeto value for this PGuiaLiquidacion.
     * 
     * @param importeNeto
     */
    public void setImporteNeto(double importeNeto) {
        this.importeNeto = importeNeto;
    }


    /**
     * Gets the importeTotal value for this PGuiaLiquidacion.
     * 
     * @return importeTotal
     */
    public double getImporteTotal() {
        return importeTotal;
    }


    /**
     * Sets the importeTotal value for this PGuiaLiquidacion.
     * 
     * @param importeTotal
     */
    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }


    /**
     * Gets the importeConceptos value for this PGuiaLiquidacion.
     * 
     * @return importeConceptos
     */
    public double getImporteConceptos() {
        return importeConceptos;
    }


    /**
     * Sets the importeConceptos value for this PGuiaLiquidacion.
     * 
     * @param importeConceptos
     */
    public void setImporteConceptos(double importeConceptos) {
        this.importeConceptos = importeConceptos;
    }


    /**
     * Gets the empresa value for this PGuiaLiquidacion.
     * 
     * @return empresa
     */
    public ar.com.unisolutions.PEmpresa getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this PGuiaLiquidacion.
     * 
     * @param empresa
     */
    public void setEmpresa(ar.com.unisolutions.PEmpresa empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the sucursal value for this PGuiaLiquidacion.
     * 
     * @return sucursal
     */
    public ar.com.unisolutions.PSucursal getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this PGuiaLiquidacion.
     * 
     * @param sucursal
     */
    public void setSucursal(ar.com.unisolutions.PSucursal sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the operacion value for this PGuiaLiquidacion.
     * 
     * @return operacion
     */
    public ar.com.unisolutions.POperacion getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this PGuiaLiquidacion.
     * 
     * @param operacion
     */
    public void setOperacion(ar.com.unisolutions.POperacion operacion) {
        this.operacion = operacion;
    }


    /**
     * Gets the transporte value for this PGuiaLiquidacion.
     * 
     * @return transporte
     */
    public ar.com.unisolutions.PTransporte getTransporte() {
        return transporte;
    }


    /**
     * Sets the transporte value for this PGuiaLiquidacion.
     * 
     * @param transporte
     */
    public void setTransporte(ar.com.unisolutions.PTransporte transporte) {
        this.transporte = transporte;
    }


    /**
     * Gets the conductor value for this PGuiaLiquidacion.
     * 
     * @return conductor
     */
    public ar.com.unisolutions.PConductor getConductor() {
        return conductor;
    }


    /**
     * Sets the conductor value for this PGuiaLiquidacion.
     * 
     * @param conductor
     */
    public void setConductor(ar.com.unisolutions.PConductor conductor) {
        this.conductor = conductor;
    }


    /**
     * Gets the vehiculo value for this PGuiaLiquidacion.
     * 
     * @return vehiculo
     */
    public ar.com.unisolutions.PVehiculo getVehiculo() {
        return vehiculo;
    }


    /**
     * Sets the vehiculo value for this PGuiaLiquidacion.
     * 
     * @param vehiculo
     */
    public void setVehiculo(ar.com.unisolutions.PVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * Gets the cliente value for this PGuiaLiquidacion.
     * 
     * @return cliente
     */
    public ar.com.unisolutions.PCliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this PGuiaLiquidacion.
     * 
     * @param cliente
     */
    public void setCliente(ar.com.unisolutions.PCliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the refExterna value for this PGuiaLiquidacion.
     * 
     * @return refExterna
     */
    public java.lang.String getRefExterna() {
        return refExterna;
    }


    /**
     * Sets the refExterna value for this PGuiaLiquidacion.
     * 
     * @param refExterna
     */
    public void setRefExterna(java.lang.String refExterna) {
        this.refExterna = refExterna;
    }


    /**
     * Gets the tipoGuia value for this PGuiaLiquidacion.
     * 
     * @return tipoGuia
     */
    public java.lang.String getTipoGuia() {
        return tipoGuia;
    }


    /**
     * Sets the tipoGuia value for this PGuiaLiquidacion.
     * 
     * @param tipoGuia
     */
    public void setTipoGuia(java.lang.String tipoGuia) {
        this.tipoGuia = tipoGuia;
    }


    /**
     * Gets the jurisdiccion value for this PGuiaLiquidacion.
     * 
     * @return jurisdiccion
     */
    public java.lang.String getJurisdiccion() {
        return jurisdiccion;
    }


    /**
     * Sets the jurisdiccion value for this PGuiaLiquidacion.
     * 
     * @param jurisdiccion
     */
    public void setJurisdiccion(java.lang.String jurisdiccion) {
        this.jurisdiccion = jurisdiccion;
    }


    /**
     * Gets the idLiquidacion value for this PGuiaLiquidacion.
     * 
     * @return idLiquidacion
     */
    public java.lang.Integer getIdLiquidacion() {
        return idLiquidacion;
    }


    /**
     * Sets the idLiquidacion value for this PGuiaLiquidacion.
     * 
     * @param idLiquidacion
     */
    public void setIdLiquidacion(java.lang.Integer idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }


    /**
     * Gets the estadoLiquidacion value for this PGuiaLiquidacion.
     * 
     * @return estadoLiquidacion
     */
    public java.lang.String getEstadoLiquidacion() {
        return estadoLiquidacion;
    }


    /**
     * Sets the estadoLiquidacion value for this PGuiaLiquidacion.
     * 
     * @param estadoLiquidacion
     */
    public void setEstadoLiquidacion(java.lang.String estadoLiquidacion) {
        this.estadoLiquidacion = estadoLiquidacion;
    }


    /**
     * Gets the periodo value for this PGuiaLiquidacion.
     * 
     * @return periodo
     */
    public ar.com.unisolutions.PPeriodoLiquidacion getPeriodo() {
        return periodo;
    }


    /**
     * Sets the periodo value for this PGuiaLiquidacion.
     * 
     * @param periodo
     */
    public void setPeriodo(ar.com.unisolutions.PPeriodoLiquidacion periodo) {
        this.periodo = periodo;
    }


    /**
     * Gets the viajes value for this PGuiaLiquidacion.
     * 
     * @return viajes
     */
    public ar.com.unisolutions.PViaje[] getViajes() {
        return viajes;
    }


    /**
     * Sets the viajes value for this PGuiaLiquidacion.
     * 
     * @param viajes
     */
    public void setViajes(ar.com.unisolutions.PViaje[] viajes) {
        this.viajes = viajes;
    }


    /**
     * Gets the conceptos value for this PGuiaLiquidacion.
     * 
     * @return conceptos
     */
    public ar.com.unisolutions.PConceptoExterno[] getConceptos() {
        return conceptos;
    }


    /**
     * Sets the conceptos value for this PGuiaLiquidacion.
     * 
     * @param conceptos
     */
    public void setConceptos(ar.com.unisolutions.PConceptoExterno[] conceptos) {
        this.conceptos = conceptos;
    }


    /**
     * Gets the incidencias value for this PGuiaLiquidacion.
     * 
     * @return incidencias
     */
    public ar.com.unisolutions.PIncidencia[] getIncidencias() {
        return incidencias;
    }


    /**
     * Sets the incidencias value for this PGuiaLiquidacion.
     * 
     * @param incidencias
     */
    public void setIncidencias(ar.com.unisolutions.PIncidencia[] incidencias) {
        this.incidencias = incidencias;
    }


    /**
     * Gets the imputaciones value for this PGuiaLiquidacion.
     * 
     * @return imputaciones
     */
    public ar.com.unisolutions.PImputacion[] getImputaciones() {
        return imputaciones;
    }


    /**
     * Sets the imputaciones value for this PGuiaLiquidacion.
     * 
     * @param imputaciones
     */
    public void setImputaciones(ar.com.unisolutions.PImputacion[] imputaciones) {
        this.imputaciones = imputaciones;
    }


    /**
     * Gets the conceptosDinamicos value for this PGuiaLiquidacion.
     * 
     * @return conceptosDinamicos
     */
    public ar.com.unisolutions.PConceptoDinamico[] getConceptosDinamicos() {
        return conceptosDinamicos;
    }


    /**
     * Sets the conceptosDinamicos value for this PGuiaLiquidacion.
     * 
     * @param conceptosDinamicos
     */
    public void setConceptosDinamicos(ar.com.unisolutions.PConceptoDinamico[] conceptosDinamicos) {
        this.conceptosDinamicos = conceptosDinamicos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PGuiaLiquidacion)) return false;
        PGuiaLiquidacion other = (PGuiaLiquidacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idGuiaLiquidacion == other.getIdGuiaLiquidacion() &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.fechaCreacion==null && other.getFechaCreacion()==null) || 
             (this.fechaCreacion!=null &&
              this.fechaCreacion.equals(other.getFechaCreacion()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            this.importeNeto == other.getImporteNeto() &&
            this.importeTotal == other.getImporteTotal() &&
            this.importeConceptos == other.getImporteConceptos() &&
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa()))) &&
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion()))) &&
            ((this.transporte==null && other.getTransporte()==null) || 
             (this.transporte!=null &&
              this.transporte.equals(other.getTransporte()))) &&
            ((this.conductor==null && other.getConductor()==null) || 
             (this.conductor!=null &&
              this.conductor.equals(other.getConductor()))) &&
            ((this.vehiculo==null && other.getVehiculo()==null) || 
             (this.vehiculo!=null &&
              this.vehiculo.equals(other.getVehiculo()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.refExterna==null && other.getRefExterna()==null) || 
             (this.refExterna!=null &&
              this.refExterna.equals(other.getRefExterna()))) &&
            ((this.tipoGuia==null && other.getTipoGuia()==null) || 
             (this.tipoGuia!=null &&
              this.tipoGuia.equals(other.getTipoGuia()))) &&
            ((this.jurisdiccion==null && other.getJurisdiccion()==null) || 
             (this.jurisdiccion!=null &&
              this.jurisdiccion.equals(other.getJurisdiccion()))) &&
            ((this.idLiquidacion==null && other.getIdLiquidacion()==null) || 
             (this.idLiquidacion!=null &&
              this.idLiquidacion.equals(other.getIdLiquidacion()))) &&
            ((this.estadoLiquidacion==null && other.getEstadoLiquidacion()==null) || 
             (this.estadoLiquidacion!=null &&
              this.estadoLiquidacion.equals(other.getEstadoLiquidacion()))) &&
            ((this.periodo==null && other.getPeriodo()==null) || 
             (this.periodo!=null &&
              this.periodo.equals(other.getPeriodo()))) &&
            ((this.viajes==null && other.getViajes()==null) || 
             (this.viajes!=null &&
              java.util.Arrays.equals(this.viajes, other.getViajes()))) &&
            ((this.conceptos==null && other.getConceptos()==null) || 
             (this.conceptos!=null &&
              java.util.Arrays.equals(this.conceptos, other.getConceptos()))) &&
            ((this.incidencias==null && other.getIncidencias()==null) || 
             (this.incidencias!=null &&
              java.util.Arrays.equals(this.incidencias, other.getIncidencias()))) &&
            ((this.imputaciones==null && other.getImputaciones()==null) || 
             (this.imputaciones!=null &&
              java.util.Arrays.equals(this.imputaciones, other.getImputaciones()))) &&
            ((this.conceptosDinamicos==null && other.getConceptosDinamicos()==null) || 
             (this.conceptosDinamicos!=null &&
              java.util.Arrays.equals(this.conceptosDinamicos, other.getConceptosDinamicos())));
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
        _hashCode += getIdGuiaLiquidacion();
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        _hashCode += new Double(getImporteNeto()).hashCode();
        _hashCode += new Double(getImporteTotal()).hashCode();
        _hashCode += new Double(getImporteConceptos()).hashCode();
        if (getEmpresa() != null) {
            _hashCode += getEmpresa().hashCode();
        }
        if (getSucursal() != null) {
            _hashCode += getSucursal().hashCode();
        }
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        if (getTransporte() != null) {
            _hashCode += getTransporte().hashCode();
        }
        if (getConductor() != null) {
            _hashCode += getConductor().hashCode();
        }
        if (getVehiculo() != null) {
            _hashCode += getVehiculo().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getRefExterna() != null) {
            _hashCode += getRefExterna().hashCode();
        }
        if (getTipoGuia() != null) {
            _hashCode += getTipoGuia().hashCode();
        }
        if (getJurisdiccion() != null) {
            _hashCode += getJurisdiccion().hashCode();
        }
        if (getIdLiquidacion() != null) {
            _hashCode += getIdLiquidacion().hashCode();
        }
        if (getEstadoLiquidacion() != null) {
            _hashCode += getEstadoLiquidacion().hashCode();
        }
        if (getPeriodo() != null) {
            _hashCode += getPeriodo().hashCode();
        }
        if (getViajes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getViajes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getViajes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConceptos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConceptos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConceptos(), i);
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
        if (getImputaciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImputaciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImputaciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConceptosDinamicos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConceptosDinamicos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConceptosDinamicos(), i);
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
        new org.apache.axis.description.TypeDesc(PGuiaLiquidacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pGuiaLiquidacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGuiaLiquidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdGuiaLiquidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCreacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaCreacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("importeNeto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteNeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeConceptos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ImporteConceptos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("operacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Operacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOperacion"));
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
        elemField.setFieldName("conductor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conductor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConductor"));
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
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refExterna");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefExterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoGuia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TipoGuia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jurisdiccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Jurisdiccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idLiquidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdLiquidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoLiquidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EstadoLiquidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Periodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPeriodoLiquidacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viajes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Viajes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pViaje"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conceptos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Conceptos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoExterno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoExterno"));
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
        elemField.setFieldName("imputaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Imputaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pImputacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pImputacion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conceptosDinamicos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ConceptosDinamicos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoDinamico"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pConceptoDinamico"));
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
