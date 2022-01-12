/**
 * PPedidoTurno.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PPedidoTurno  implements java.io.Serializable {
    private java.lang.Integer idEstadoPedidoTurno;

    private java.util.Calendar fechaTurnoConfirmada;

    private int inicioHorarioTurno;

    private int finHorarioTurno;

    private java.lang.String referenciaExterna;

    private java.lang.String descripcion;

    private java.lang.String comentario;

    private java.lang.String solicitante;

    private java.lang.String contacto;

    private java.util.Calendar fechaIngreso;

    private java.util.Calendar fechaSolicitudTurno;

    public PPedidoTurno() {
    }

    public PPedidoTurno(
           java.lang.Integer idEstadoPedidoTurno,
           java.util.Calendar fechaTurnoConfirmada,
           int inicioHorarioTurno,
           int finHorarioTurno,
           java.lang.String referenciaExterna,
           java.lang.String descripcion,
           java.lang.String comentario,
           java.lang.String solicitante,
           java.lang.String contacto,
           java.util.Calendar fechaIngreso,
           java.util.Calendar fechaSolicitudTurno) {
           this.idEstadoPedidoTurno = idEstadoPedidoTurno;
           this.fechaTurnoConfirmada = fechaTurnoConfirmada;
           this.inicioHorarioTurno = inicioHorarioTurno;
           this.finHorarioTurno = finHorarioTurno;
           this.referenciaExterna = referenciaExterna;
           this.descripcion = descripcion;
           this.comentario = comentario;
           this.solicitante = solicitante;
           this.contacto = contacto;
           this.fechaIngreso = fechaIngreso;
           this.fechaSolicitudTurno = fechaSolicitudTurno;
    }


    /**
     * Gets the idEstadoPedidoTurno value for this PPedidoTurno.
     * 
     * @return idEstadoPedidoTurno
     */
    public java.lang.Integer getIdEstadoPedidoTurno() {
        return idEstadoPedidoTurno;
    }


    /**
     * Sets the idEstadoPedidoTurno value for this PPedidoTurno.
     * 
     * @param idEstadoPedidoTurno
     */
    public void setIdEstadoPedidoTurno(java.lang.Integer idEstadoPedidoTurno) {
        this.idEstadoPedidoTurno = idEstadoPedidoTurno;
    }


    /**
     * Gets the fechaTurnoConfirmada value for this PPedidoTurno.
     * 
     * @return fechaTurnoConfirmada
     */
    public java.util.Calendar getFechaTurnoConfirmada() {
        return fechaTurnoConfirmada;
    }


    /**
     * Sets the fechaTurnoConfirmada value for this PPedidoTurno.
     * 
     * @param fechaTurnoConfirmada
     */
    public void setFechaTurnoConfirmada(java.util.Calendar fechaTurnoConfirmada) {
        this.fechaTurnoConfirmada = fechaTurnoConfirmada;
    }


    /**
     * Gets the inicioHorarioTurno value for this PPedidoTurno.
     * 
     * @return inicioHorarioTurno
     */
    public int getInicioHorarioTurno() {
        return inicioHorarioTurno;
    }


    /**
     * Sets the inicioHorarioTurno value for this PPedidoTurno.
     * 
     * @param inicioHorarioTurno
     */
    public void setInicioHorarioTurno(int inicioHorarioTurno) {
        this.inicioHorarioTurno = inicioHorarioTurno;
    }


    /**
     * Gets the finHorarioTurno value for this PPedidoTurno.
     * 
     * @return finHorarioTurno
     */
    public int getFinHorarioTurno() {
        return finHorarioTurno;
    }


    /**
     * Sets the finHorarioTurno value for this PPedidoTurno.
     * 
     * @param finHorarioTurno
     */
    public void setFinHorarioTurno(int finHorarioTurno) {
        this.finHorarioTurno = finHorarioTurno;
    }


    /**
     * Gets the referenciaExterna value for this PPedidoTurno.
     * 
     * @return referenciaExterna
     */
    public java.lang.String getReferenciaExterna() {
        return referenciaExterna;
    }


    /**
     * Sets the referenciaExterna value for this PPedidoTurno.
     * 
     * @param referenciaExterna
     */
    public void setReferenciaExterna(java.lang.String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }


    /**
     * Gets the descripcion value for this PPedidoTurno.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PPedidoTurno.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the comentario value for this PPedidoTurno.
     * 
     * @return comentario
     */
    public java.lang.String getComentario() {
        return comentario;
    }


    /**
     * Sets the comentario value for this PPedidoTurno.
     * 
     * @param comentario
     */
    public void setComentario(java.lang.String comentario) {
        this.comentario = comentario;
    }


    /**
     * Gets the solicitante value for this PPedidoTurno.
     * 
     * @return solicitante
     */
    public java.lang.String getSolicitante() {
        return solicitante;
    }


    /**
     * Sets the solicitante value for this PPedidoTurno.
     * 
     * @param solicitante
     */
    public void setSolicitante(java.lang.String solicitante) {
        this.solicitante = solicitante;
    }


    /**
     * Gets the contacto value for this PPedidoTurno.
     * 
     * @return contacto
     */
    public java.lang.String getContacto() {
        return contacto;
    }


    /**
     * Sets the contacto value for this PPedidoTurno.
     * 
     * @param contacto
     */
    public void setContacto(java.lang.String contacto) {
        this.contacto = contacto;
    }


    /**
     * Gets the fechaIngreso value for this PPedidoTurno.
     * 
     * @return fechaIngreso
     */
    public java.util.Calendar getFechaIngreso() {
        return fechaIngreso;
    }


    /**
     * Sets the fechaIngreso value for this PPedidoTurno.
     * 
     * @param fechaIngreso
     */
    public void setFechaIngreso(java.util.Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }


    /**
     * Gets the fechaSolicitudTurno value for this PPedidoTurno.
     * 
     * @return fechaSolicitudTurno
     */
    public java.util.Calendar getFechaSolicitudTurno() {
        return fechaSolicitudTurno;
    }


    /**
     * Sets the fechaSolicitudTurno value for this PPedidoTurno.
     * 
     * @param fechaSolicitudTurno
     */
    public void setFechaSolicitudTurno(java.util.Calendar fechaSolicitudTurno) {
        this.fechaSolicitudTurno = fechaSolicitudTurno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PPedidoTurno)) return false;
        PPedidoTurno other = (PPedidoTurno) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idEstadoPedidoTurno==null && other.getIdEstadoPedidoTurno()==null) || 
             (this.idEstadoPedidoTurno!=null &&
              this.idEstadoPedidoTurno.equals(other.getIdEstadoPedidoTurno()))) &&
            ((this.fechaTurnoConfirmada==null && other.getFechaTurnoConfirmada()==null) || 
             (this.fechaTurnoConfirmada!=null &&
              this.fechaTurnoConfirmada.equals(other.getFechaTurnoConfirmada()))) &&
            this.inicioHorarioTurno == other.getInicioHorarioTurno() &&
            this.finHorarioTurno == other.getFinHorarioTurno() &&
            ((this.referenciaExterna==null && other.getReferenciaExterna()==null) || 
             (this.referenciaExterna!=null &&
              this.referenciaExterna.equals(other.getReferenciaExterna()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.comentario==null && other.getComentario()==null) || 
             (this.comentario!=null &&
              this.comentario.equals(other.getComentario()))) &&
            ((this.solicitante==null && other.getSolicitante()==null) || 
             (this.solicitante!=null &&
              this.solicitante.equals(other.getSolicitante()))) &&
            ((this.contacto==null && other.getContacto()==null) || 
             (this.contacto!=null &&
              this.contacto.equals(other.getContacto()))) &&
            ((this.fechaIngreso==null && other.getFechaIngreso()==null) || 
             (this.fechaIngreso!=null &&
              this.fechaIngreso.equals(other.getFechaIngreso()))) &&
            ((this.fechaSolicitudTurno==null && other.getFechaSolicitudTurno()==null) || 
             (this.fechaSolicitudTurno!=null &&
              this.fechaSolicitudTurno.equals(other.getFechaSolicitudTurno())));
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
        if (getIdEstadoPedidoTurno() != null) {
            _hashCode += getIdEstadoPedidoTurno().hashCode();
        }
        if (getFechaTurnoConfirmada() != null) {
            _hashCode += getFechaTurnoConfirmada().hashCode();
        }
        _hashCode += getInicioHorarioTurno();
        _hashCode += getFinHorarioTurno();
        if (getReferenciaExterna() != null) {
            _hashCode += getReferenciaExterna().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getComentario() != null) {
            _hashCode += getComentario().hashCode();
        }
        if (getSolicitante() != null) {
            _hashCode += getSolicitante().hashCode();
        }
        if (getContacto() != null) {
            _hashCode += getContacto().hashCode();
        }
        if (getFechaIngreso() != null) {
            _hashCode += getFechaIngreso().hashCode();
        }
        if (getFechaSolicitudTurno() != null) {
            _hashCode += getFechaSolicitudTurno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PPedidoTurno.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pPedidoTurno"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEstadoPedidoTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdEstadoPedidoTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaTurnoConfirmada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaTurnoConfirmada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioHorarioTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorarioTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorarioTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorarioTurno"));
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
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comentario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Comentario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("solicitante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Solicitante"));
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
        elemField.setFieldName("fechaIngreso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaIngreso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaSolicitudTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaSolicitudTurno"));
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
