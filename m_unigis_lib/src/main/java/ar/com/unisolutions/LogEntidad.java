/**
 * LogEntidad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class LogEntidad  extends ar.com.unisolutions.AbstractEntitie  implements java.io.Serializable {
    private int idLogEntidad;

    private long idObjeto;

    private java.lang.String entidad;

    private java.util.Calendar fechaHora;

    private java.lang.String login;

    private java.lang.String campo;

    private java.lang.String valorAnterior;

    private java.lang.String valorNuevo;

    private java.lang.Long transactionId;

    private java.lang.String IP;

    public LogEntidad() {
    }

    public LogEntidad(
           int idLogEntidad,
           long idObjeto,
           java.lang.String entidad,
           java.util.Calendar fechaHora,
           java.lang.String login,
           java.lang.String campo,
           java.lang.String valorAnterior,
           java.lang.String valorNuevo,
           java.lang.Long transactionId,
           java.lang.String IP) {
        this.idLogEntidad = idLogEntidad;
        this.idObjeto = idObjeto;
        this.entidad = entidad;
        this.fechaHora = fechaHora;
        this.login = login;
        this.campo = campo;
        this.valorAnterior = valorAnterior;
        this.valorNuevo = valorNuevo;
        this.transactionId = transactionId;
        this.IP = IP;
    }


    /**
     * Gets the idLogEntidad value for this LogEntidad.
     * 
     * @return idLogEntidad
     */
    public int getIdLogEntidad() {
        return idLogEntidad;
    }


    /**
     * Sets the idLogEntidad value for this LogEntidad.
     * 
     * @param idLogEntidad
     */
    public void setIdLogEntidad(int idLogEntidad) {
        this.idLogEntidad = idLogEntidad;
    }


    /**
     * Gets the idObjeto value for this LogEntidad.
     * 
     * @return idObjeto
     */
    public long getIdObjeto() {
        return idObjeto;
    }


    /**
     * Sets the idObjeto value for this LogEntidad.
     * 
     * @param idObjeto
     */
    public void setIdObjeto(long idObjeto) {
        this.idObjeto = idObjeto;
    }


    /**
     * Gets the entidad value for this LogEntidad.
     * 
     * @return entidad
     */
    public java.lang.String getEntidad() {
        return entidad;
    }


    /**
     * Sets the entidad value for this LogEntidad.
     * 
     * @param entidad
     */
    public void setEntidad(java.lang.String entidad) {
        this.entidad = entidad;
    }


    /**
     * Gets the fechaHora value for this LogEntidad.
     * 
     * @return fechaHora
     */
    public java.util.Calendar getFechaHora() {
        return fechaHora;
    }


    /**
     * Sets the fechaHora value for this LogEntidad.
     * 
     * @param fechaHora
     */
    public void setFechaHora(java.util.Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }


    /**
     * Gets the login value for this LogEntidad.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this LogEntidad.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the campo value for this LogEntidad.
     * 
     * @return campo
     */
    public java.lang.String getCampo() {
        return campo;
    }


    /**
     * Sets the campo value for this LogEntidad.
     * 
     * @param campo
     */
    public void setCampo(java.lang.String campo) {
        this.campo = campo;
    }


    /**
     * Gets the valorAnterior value for this LogEntidad.
     * 
     * @return valorAnterior
     */
    public java.lang.String getValorAnterior() {
        return valorAnterior;
    }


    /**
     * Sets the valorAnterior value for this LogEntidad.
     * 
     * @param valorAnterior
     */
    public void setValorAnterior(java.lang.String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }


    /**
     * Gets the valorNuevo value for this LogEntidad.
     * 
     * @return valorNuevo
     */
    public java.lang.String getValorNuevo() {
        return valorNuevo;
    }


    /**
     * Sets the valorNuevo value for this LogEntidad.
     * 
     * @param valorNuevo
     */
    public void setValorNuevo(java.lang.String valorNuevo) {
        this.valorNuevo = valorNuevo;
    }


    /**
     * Gets the transactionId value for this LogEntidad.
     * 
     * @return transactionId
     */
    public java.lang.Long getTransactionId() {
        return transactionId;
    }


    /**
     * Sets the transactionId value for this LogEntidad.
     * 
     * @param transactionId
     */
    public void setTransactionId(java.lang.Long transactionId) {
        this.transactionId = transactionId;
    }


    /**
     * Gets the IP value for this LogEntidad.
     * 
     * @return IP
     */
    public java.lang.String getIP() {
        return IP;
    }


    /**
     * Sets the IP value for this LogEntidad.
     * 
     * @param IP
     */
    public void setIP(java.lang.String IP) {
        this.IP = IP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LogEntidad)) return false;
        LogEntidad other = (LogEntidad) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.idLogEntidad == other.getIdLogEntidad() &&
            this.idObjeto == other.getIdObjeto() &&
            ((this.entidad==null && other.getEntidad()==null) || 
             (this.entidad!=null &&
              this.entidad.equals(other.getEntidad()))) &&
            ((this.fechaHora==null && other.getFechaHora()==null) || 
             (this.fechaHora!=null &&
              this.fechaHora.equals(other.getFechaHora()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.campo==null && other.getCampo()==null) || 
             (this.campo!=null &&
              this.campo.equals(other.getCampo()))) &&
            ((this.valorAnterior==null && other.getValorAnterior()==null) || 
             (this.valorAnterior!=null &&
              this.valorAnterior.equals(other.getValorAnterior()))) &&
            ((this.valorNuevo==null && other.getValorNuevo()==null) || 
             (this.valorNuevo!=null &&
              this.valorNuevo.equals(other.getValorNuevo()))) &&
            ((this.transactionId==null && other.getTransactionId()==null) || 
             (this.transactionId!=null &&
              this.transactionId.equals(other.getTransactionId()))) &&
            ((this.IP==null && other.getIP()==null) || 
             (this.IP!=null &&
              this.IP.equals(other.getIP())));
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
        _hashCode += getIdLogEntidad();
        _hashCode += new Long(getIdObjeto()).hashCode();
        if (getEntidad() != null) {
            _hashCode += getEntidad().hashCode();
        }
        if (getFechaHora() != null) {
            _hashCode += getFechaHora().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getCampo() != null) {
            _hashCode += getCampo().hashCode();
        }
        if (getValorAnterior() != null) {
            _hashCode += getValorAnterior().hashCode();
        }
        if (getValorNuevo() != null) {
            _hashCode += getValorNuevo().hashCode();
        }
        if (getTransactionId() != null) {
            _hashCode += getTransactionId().hashCode();
        }
        if (getIP() != null) {
            _hashCode += getIP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LogEntidad.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "LogEntidad"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idLogEntidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdLogEntidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idObjeto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IdObjeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Entidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHora");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FechaHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Campo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorAnterior");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValorAnterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorNuevo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ValorNuevo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TransactionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "IP"));
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
