/**
 * POrdenEntregaConsultarViaje.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class POrdenEntregaConsultarViaje  extends ar.com.unisolutions.POrden  implements java.io.Serializable {
    private java.lang.String referenciaClienteDador;

    private java.lang.String razonSocialClienteDador;

    private java.lang.String nombreFantasiaClienteDador;

    private java.lang.String referenciaOrdenCliente;

    private java.lang.String razonSocialOrdenCliente;

    private java.lang.String descripcionDomicilioOrden;

    private java.lang.String direccionDomicilioOrden;

    private java.lang.String referenciaExternaOrden;

    public POrdenEntregaConsultarViaje() {
    }

    public POrdenEntregaConsultarViaje(
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
           java.lang.Integer unidades,
           java.lang.String referenciaClienteDador,
           java.lang.String razonSocialClienteDador,
           java.lang.String nombreFantasiaClienteDador,
           java.lang.String referenciaOrdenCliente,
           java.lang.String razonSocialOrdenCliente,
           java.lang.String descripcionDomicilioOrden,
           java.lang.String direccionDomicilioOrden,
           java.lang.String referenciaExternaOrden) {
        super(
            sucursal,
            operacion,
            refDocumento,
            refDocumentoAdicional,
            refDocumentoPedido,
            tipo,
            tipoOrden,
            tipoParada,
            categoriaOrden,
            refDocumentoRecoleccion,
            estado,
            fechaJornada,
            cliente,
            descripcion,
            direccion,
            calle,
            nroPuerta,
            entreCalle,
            barrio,
            localidad,
            partido,
            provincia,
            pais,
            inicioHorario1,
            finHorario1,
            inicioHorario2,
            finHorario2,
            tiempoEspera,
            crearDomicilio,
            orden,
            inicioHorarioPlanificado,
            finHorarioPlanificado,
            volumen,
            peso,
            bulto,
            pallets,
            distancia,
            latitud,
            longitud,
            observaciones,
            email,
            telefono,
            telefono2,
            telefono3,
            varchar1,
            varchar2,
            varchar3,
            varchar4,
            int1,
            int2,
            idRuta,
            preOrden,
            grupoConsolidacion,
            prioridadAbsoluta,
            grupoRutas,
            tiempoLatencia,
            tiempoEsperaPromedio,
            depositoSalida,
            depositoLlegada,
            campoDinamico,
            items,
            servicios,
            tipoJornada,
            jornadaDescripcion,
            codigoPostal,
            motivoEstadoParadaDescripcion,
            motivoEstadoParadaReferencia,
            fotos,
            paradaItems,
            remito,
            estadoOrden,
            idOrden,
            idJornada,
            pesoMaximo,
            volumenMaximo,
            bultosMaximo,
            costo,
            inicioVisita,
            finVisita,
            inicioHorarioEstimado,
            finHorarioEstimado,
            inicioHorarioReal,
            finHorarioReal,
            usarProductos,
            ultimaVisita,
            fecha,
            fechaOrden,
            datetime1,
            datetime2,
            fechaUltimoCambioEstado,
            unidades);
        this.referenciaClienteDador = referenciaClienteDador;
        this.razonSocialClienteDador = razonSocialClienteDador;
        this.nombreFantasiaClienteDador = nombreFantasiaClienteDador;
        this.referenciaOrdenCliente = referenciaOrdenCliente;
        this.razonSocialOrdenCliente = razonSocialOrdenCliente;
        this.descripcionDomicilioOrden = descripcionDomicilioOrden;
        this.direccionDomicilioOrden = direccionDomicilioOrden;
        this.referenciaExternaOrden = referenciaExternaOrden;
    }


    /**
     * Gets the referenciaClienteDador value for this POrdenEntregaConsultarViaje.
     * 
     * @return referenciaClienteDador
     */
    public java.lang.String getReferenciaClienteDador() {
        return referenciaClienteDador;
    }


    /**
     * Sets the referenciaClienteDador value for this POrdenEntregaConsultarViaje.
     * 
     * @param referenciaClienteDador
     */
    public void setReferenciaClienteDador(java.lang.String referenciaClienteDador) {
        this.referenciaClienteDador = referenciaClienteDador;
    }


    /**
     * Gets the razonSocialClienteDador value for this POrdenEntregaConsultarViaje.
     * 
     * @return razonSocialClienteDador
     */
    public java.lang.String getRazonSocialClienteDador() {
        return razonSocialClienteDador;
    }


    /**
     * Sets the razonSocialClienteDador value for this POrdenEntregaConsultarViaje.
     * 
     * @param razonSocialClienteDador
     */
    public void setRazonSocialClienteDador(java.lang.String razonSocialClienteDador) {
        this.razonSocialClienteDador = razonSocialClienteDador;
    }


    /**
     * Gets the nombreFantasiaClienteDador value for this POrdenEntregaConsultarViaje.
     * 
     * @return nombreFantasiaClienteDador
     */
    public java.lang.String getNombreFantasiaClienteDador() {
        return nombreFantasiaClienteDador;
    }


    /**
     * Sets the nombreFantasiaClienteDador value for this POrdenEntregaConsultarViaje.
     * 
     * @param nombreFantasiaClienteDador
     */
    public void setNombreFantasiaClienteDador(java.lang.String nombreFantasiaClienteDador) {
        this.nombreFantasiaClienteDador = nombreFantasiaClienteDador;
    }


    /**
     * Gets the referenciaOrdenCliente value for this POrdenEntregaConsultarViaje.
     * 
     * @return referenciaOrdenCliente
     */
    public java.lang.String getReferenciaOrdenCliente() {
        return referenciaOrdenCliente;
    }


    /**
     * Sets the referenciaOrdenCliente value for this POrdenEntregaConsultarViaje.
     * 
     * @param referenciaOrdenCliente
     */
    public void setReferenciaOrdenCliente(java.lang.String referenciaOrdenCliente) {
        this.referenciaOrdenCliente = referenciaOrdenCliente;
    }


    /**
     * Gets the razonSocialOrdenCliente value for this POrdenEntregaConsultarViaje.
     * 
     * @return razonSocialOrdenCliente
     */
    public java.lang.String getRazonSocialOrdenCliente() {
        return razonSocialOrdenCliente;
    }


    /**
     * Sets the razonSocialOrdenCliente value for this POrdenEntregaConsultarViaje.
     * 
     * @param razonSocialOrdenCliente
     */
    public void setRazonSocialOrdenCliente(java.lang.String razonSocialOrdenCliente) {
        this.razonSocialOrdenCliente = razonSocialOrdenCliente;
    }


    /**
     * Gets the descripcionDomicilioOrden value for this POrdenEntregaConsultarViaje.
     * 
     * @return descripcionDomicilioOrden
     */
    public java.lang.String getDescripcionDomicilioOrden() {
        return descripcionDomicilioOrden;
    }


    /**
     * Sets the descripcionDomicilioOrden value for this POrdenEntregaConsultarViaje.
     * 
     * @param descripcionDomicilioOrden
     */
    public void setDescripcionDomicilioOrden(java.lang.String descripcionDomicilioOrden) {
        this.descripcionDomicilioOrden = descripcionDomicilioOrden;
    }


    /**
     * Gets the direccionDomicilioOrden value for this POrdenEntregaConsultarViaje.
     * 
     * @return direccionDomicilioOrden
     */
    public java.lang.String getDireccionDomicilioOrden() {
        return direccionDomicilioOrden;
    }


    /**
     * Sets the direccionDomicilioOrden value for this POrdenEntregaConsultarViaje.
     * 
     * @param direccionDomicilioOrden
     */
    public void setDireccionDomicilioOrden(java.lang.String direccionDomicilioOrden) {
        this.direccionDomicilioOrden = direccionDomicilioOrden;
    }


    /**
     * Gets the referenciaExternaOrden value for this POrdenEntregaConsultarViaje.
     * 
     * @return referenciaExternaOrden
     */
    public java.lang.String getReferenciaExternaOrden() {
        return referenciaExternaOrden;
    }


    /**
     * Sets the referenciaExternaOrden value for this POrdenEntregaConsultarViaje.
     * 
     * @param referenciaExternaOrden
     */
    public void setReferenciaExternaOrden(java.lang.String referenciaExternaOrden) {
        this.referenciaExternaOrden = referenciaExternaOrden;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POrdenEntregaConsultarViaje)) return false;
        POrdenEntregaConsultarViaje other = (POrdenEntregaConsultarViaje) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.referenciaClienteDador==null && other.getReferenciaClienteDador()==null) || 
             (this.referenciaClienteDador!=null &&
              this.referenciaClienteDador.equals(other.getReferenciaClienteDador()))) &&
            ((this.razonSocialClienteDador==null && other.getRazonSocialClienteDador()==null) || 
             (this.razonSocialClienteDador!=null &&
              this.razonSocialClienteDador.equals(other.getRazonSocialClienteDador()))) &&
            ((this.nombreFantasiaClienteDador==null && other.getNombreFantasiaClienteDador()==null) || 
             (this.nombreFantasiaClienteDador!=null &&
              this.nombreFantasiaClienteDador.equals(other.getNombreFantasiaClienteDador()))) &&
            ((this.referenciaOrdenCliente==null && other.getReferenciaOrdenCliente()==null) || 
             (this.referenciaOrdenCliente!=null &&
              this.referenciaOrdenCliente.equals(other.getReferenciaOrdenCliente()))) &&
            ((this.razonSocialOrdenCliente==null && other.getRazonSocialOrdenCliente()==null) || 
             (this.razonSocialOrdenCliente!=null &&
              this.razonSocialOrdenCliente.equals(other.getRazonSocialOrdenCliente()))) &&
            ((this.descripcionDomicilioOrden==null && other.getDescripcionDomicilioOrden()==null) || 
             (this.descripcionDomicilioOrden!=null &&
              this.descripcionDomicilioOrden.equals(other.getDescripcionDomicilioOrden()))) &&
            ((this.direccionDomicilioOrden==null && other.getDireccionDomicilioOrden()==null) || 
             (this.direccionDomicilioOrden!=null &&
              this.direccionDomicilioOrden.equals(other.getDireccionDomicilioOrden()))) &&
            ((this.referenciaExternaOrden==null && other.getReferenciaExternaOrden()==null) || 
             (this.referenciaExternaOrden!=null &&
              this.referenciaExternaOrden.equals(other.getReferenciaExternaOrden())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getReferenciaClienteDador() != null) {
            _hashCode += getReferenciaClienteDador().hashCode();
        }
        if (getRazonSocialClienteDador() != null) {
            _hashCode += getRazonSocialClienteDador().hashCode();
        }
        if (getNombreFantasiaClienteDador() != null) {
            _hashCode += getNombreFantasiaClienteDador().hashCode();
        }
        if (getReferenciaOrdenCliente() != null) {
            _hashCode += getReferenciaOrdenCliente().hashCode();
        }
        if (getRazonSocialOrdenCliente() != null) {
            _hashCode += getRazonSocialOrdenCliente().hashCode();
        }
        if (getDescripcionDomicilioOrden() != null) {
            _hashCode += getDescripcionDomicilioOrden().hashCode();
        }
        if (getDireccionDomicilioOrden() != null) {
            _hashCode += getDireccionDomicilioOrden().hashCode();
        }
        if (getReferenciaExternaOrden() != null) {
            _hashCode += getReferenciaExternaOrden().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POrdenEntregaConsultarViaje.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntregaConsultarViaje"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaClienteDador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaClienteDador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocialClienteDador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RazonSocialClienteDador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreFantasiaClienteDador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "NombreFantasiaClienteDador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaOrdenCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaOrdenCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocialOrdenCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RazonSocialOrdenCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionDomicilioOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DescripcionDomicilioOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccionDomicilioOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DireccionDomicilioOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciaExternaOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ReferenciaExternaOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
