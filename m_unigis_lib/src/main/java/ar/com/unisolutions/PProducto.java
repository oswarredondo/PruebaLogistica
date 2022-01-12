/**
 * PProducto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PProducto  implements java.io.Serializable {
    private java.lang.String refProducto;

    private java.lang.String descripcion;

    private double volumen;

    private double peso;

    private double bultos;

    private double alto;

    private double ancho;

    private double profundidad;

    private int apilable;

    private java.lang.String rotacion;

    private java.lang.String codigo;

    private java.lang.String razonSocial;

    private java.lang.String rotacionesPermitidas;

    private java.lang.String linea;

    private java.lang.String subLinea;

    private java.lang.String unidadMedida;

    private ar.com.unisolutions.PClienteDador clienteDador;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private java.lang.Double tiempoDescarga;

    private java.lang.Double costo;

    private java.lang.Double ordenamiento;

    public PProducto() {
    }

    public PProducto(
           java.lang.String refProducto,
           java.lang.String descripcion,
           double volumen,
           double peso,
           double bultos,
           double alto,
           double ancho,
           double profundidad,
           int apilable,
           java.lang.String rotacion,
           java.lang.String codigo,
           java.lang.String razonSocial,
           java.lang.String rotacionesPermitidas,
           java.lang.String linea,
           java.lang.String subLinea,
           java.lang.String unidadMedida,
           ar.com.unisolutions.PClienteDador clienteDador,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           java.lang.Double tiempoDescarga,
           java.lang.Double costo,
           java.lang.Double ordenamiento) {
           this.refProducto = refProducto;
           this.descripcion = descripcion;
           this.volumen = volumen;
           this.peso = peso;
           this.bultos = bultos;
           this.alto = alto;
           this.ancho = ancho;
           this.profundidad = profundidad;
           this.apilable = apilable;
           this.rotacion = rotacion;
           this.codigo = codigo;
           this.razonSocial = razonSocial;
           this.rotacionesPermitidas = rotacionesPermitidas;
           this.linea = linea;
           this.subLinea = subLinea;
           this.unidadMedida = unidadMedida;
           this.clienteDador = clienteDador;
           this.campoDinamico = campoDinamico;
           this.tiempoDescarga = tiempoDescarga;
           this.costo = costo;
           this.ordenamiento = ordenamiento;
    }


    /**
     * Gets the refProducto value for this PProducto.
     * 
     * @return refProducto
     */
    public java.lang.String getRefProducto() {
        return refProducto;
    }


    /**
     * Sets the refProducto value for this PProducto.
     * 
     * @param refProducto
     */
    public void setRefProducto(java.lang.String refProducto) {
        this.refProducto = refProducto;
    }


    /**
     * Gets the descripcion value for this PProducto.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PProducto.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the volumen value for this PProducto.
     * 
     * @return volumen
     */
    public double getVolumen() {
        return volumen;
    }


    /**
     * Sets the volumen value for this PProducto.
     * 
     * @param volumen
     */
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }


    /**
     * Gets the peso value for this PProducto.
     * 
     * @return peso
     */
    public double getPeso() {
        return peso;
    }


    /**
     * Sets the peso value for this PProducto.
     * 
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }


    /**
     * Gets the bultos value for this PProducto.
     * 
     * @return bultos
     */
    public double getBultos() {
        return bultos;
    }


    /**
     * Sets the bultos value for this PProducto.
     * 
     * @param bultos
     */
    public void setBultos(double bultos) {
        this.bultos = bultos;
    }


    /**
     * Gets the alto value for this PProducto.
     * 
     * @return alto
     */
    public double getAlto() {
        return alto;
    }


    /**
     * Sets the alto value for this PProducto.
     * 
     * @param alto
     */
    public void setAlto(double alto) {
        this.alto = alto;
    }


    /**
     * Gets the ancho value for this PProducto.
     * 
     * @return ancho
     */
    public double getAncho() {
        return ancho;
    }


    /**
     * Sets the ancho value for this PProducto.
     * 
     * @param ancho
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }


    /**
     * Gets the profundidad value for this PProducto.
     * 
     * @return profundidad
     */
    public double getProfundidad() {
        return profundidad;
    }


    /**
     * Sets the profundidad value for this PProducto.
     * 
     * @param profundidad
     */
    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }


    /**
     * Gets the apilable value for this PProducto.
     * 
     * @return apilable
     */
    public int getApilable() {
        return apilable;
    }


    /**
     * Sets the apilable value for this PProducto.
     * 
     * @param apilable
     */
    public void setApilable(int apilable) {
        this.apilable = apilable;
    }


    /**
     * Gets the rotacion value for this PProducto.
     * 
     * @return rotacion
     */
    public java.lang.String getRotacion() {
        return rotacion;
    }


    /**
     * Sets the rotacion value for this PProducto.
     * 
     * @param rotacion
     */
    public void setRotacion(java.lang.String rotacion) {
        this.rotacion = rotacion;
    }


    /**
     * Gets the codigo value for this PProducto.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this PProducto.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the razonSocial value for this PProducto.
     * 
     * @return razonSocial
     */
    public java.lang.String getRazonSocial() {
        return razonSocial;
    }


    /**
     * Sets the razonSocial value for this PProducto.
     * 
     * @param razonSocial
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = razonSocial;
    }


    /**
     * Gets the rotacionesPermitidas value for this PProducto.
     * 
     * @return rotacionesPermitidas
     */
    public java.lang.String getRotacionesPermitidas() {
        return rotacionesPermitidas;
    }


    /**
     * Sets the rotacionesPermitidas value for this PProducto.
     * 
     * @param rotacionesPermitidas
     */
    public void setRotacionesPermitidas(java.lang.String rotacionesPermitidas) {
        this.rotacionesPermitidas = rotacionesPermitidas;
    }


    /**
     * Gets the linea value for this PProducto.
     * 
     * @return linea
     */
    public java.lang.String getLinea() {
        return linea;
    }


    /**
     * Sets the linea value for this PProducto.
     * 
     * @param linea
     */
    public void setLinea(java.lang.String linea) {
        this.linea = linea;
    }


    /**
     * Gets the subLinea value for this PProducto.
     * 
     * @return subLinea
     */
    public java.lang.String getSubLinea() {
        return subLinea;
    }


    /**
     * Sets the subLinea value for this PProducto.
     * 
     * @param subLinea
     */
    public void setSubLinea(java.lang.String subLinea) {
        this.subLinea = subLinea;
    }


    /**
     * Gets the unidadMedida value for this PProducto.
     * 
     * @return unidadMedida
     */
    public java.lang.String getUnidadMedida() {
        return unidadMedida;
    }


    /**
     * Sets the unidadMedida value for this PProducto.
     * 
     * @param unidadMedida
     */
    public void setUnidadMedida(java.lang.String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }


    /**
     * Gets the clienteDador value for this PProducto.
     * 
     * @return clienteDador
     */
    public ar.com.unisolutions.PClienteDador getClienteDador() {
        return clienteDador;
    }


    /**
     * Sets the clienteDador value for this PProducto.
     * 
     * @param clienteDador
     */
    public void setClienteDador(ar.com.unisolutions.PClienteDador clienteDador) {
        this.clienteDador = clienteDador;
    }


    /**
     * Gets the campoDinamico value for this PProducto.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this PProducto.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the tiempoDescarga value for this PProducto.
     * 
     * @return tiempoDescarga
     */
    public java.lang.Double getTiempoDescarga() {
        return tiempoDescarga;
    }


    /**
     * Sets the tiempoDescarga value for this PProducto.
     * 
     * @param tiempoDescarga
     */
    public void setTiempoDescarga(java.lang.Double tiempoDescarga) {
        this.tiempoDescarga = tiempoDescarga;
    }


    /**
     * Gets the costo value for this PProducto.
     * 
     * @return costo
     */
    public java.lang.Double getCosto() {
        return costo;
    }


    /**
     * Sets the costo value for this PProducto.
     * 
     * @param costo
     */
    public void setCosto(java.lang.Double costo) {
        this.costo = costo;
    }


    /**
     * Gets the ordenamiento value for this PProducto.
     * 
     * @return ordenamiento
     */
    public java.lang.Double getOrdenamiento() {
        return ordenamiento;
    }


    /**
     * Sets the ordenamiento value for this PProducto.
     * 
     * @param ordenamiento
     */
    public void setOrdenamiento(java.lang.Double ordenamiento) {
        this.ordenamiento = ordenamiento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PProducto)) return false;
        PProducto other = (PProducto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.refProducto==null && other.getRefProducto()==null) || 
             (this.refProducto!=null &&
              this.refProducto.equals(other.getRefProducto()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.volumen == other.getVolumen() &&
            this.peso == other.getPeso() &&
            this.bultos == other.getBultos() &&
            this.alto == other.getAlto() &&
            this.ancho == other.getAncho() &&
            this.profundidad == other.getProfundidad() &&
            this.apilable == other.getApilable() &&
            ((this.rotacion==null && other.getRotacion()==null) || 
             (this.rotacion!=null &&
              this.rotacion.equals(other.getRotacion()))) &&
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.razonSocial==null && other.getRazonSocial()==null) || 
             (this.razonSocial!=null &&
              this.razonSocial.equals(other.getRazonSocial()))) &&
            ((this.rotacionesPermitidas==null && other.getRotacionesPermitidas()==null) || 
             (this.rotacionesPermitidas!=null &&
              this.rotacionesPermitidas.equals(other.getRotacionesPermitidas()))) &&
            ((this.linea==null && other.getLinea()==null) || 
             (this.linea!=null &&
              this.linea.equals(other.getLinea()))) &&
            ((this.subLinea==null && other.getSubLinea()==null) || 
             (this.subLinea!=null &&
              this.subLinea.equals(other.getSubLinea()))) &&
            ((this.unidadMedida==null && other.getUnidadMedida()==null) || 
             (this.unidadMedida!=null &&
              this.unidadMedida.equals(other.getUnidadMedida()))) &&
            ((this.clienteDador==null && other.getClienteDador()==null) || 
             (this.clienteDador!=null &&
              this.clienteDador.equals(other.getClienteDador()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.tiempoDescarga==null && other.getTiempoDescarga()==null) || 
             (this.tiempoDescarga!=null &&
              this.tiempoDescarga.equals(other.getTiempoDescarga()))) &&
            ((this.costo==null && other.getCosto()==null) || 
             (this.costo!=null &&
              this.costo.equals(other.getCosto()))) &&
            ((this.ordenamiento==null && other.getOrdenamiento()==null) || 
             (this.ordenamiento!=null &&
              this.ordenamiento.equals(other.getOrdenamiento())));
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
        if (getRefProducto() != null) {
            _hashCode += getRefProducto().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += new Double(getVolumen()).hashCode();
        _hashCode += new Double(getPeso()).hashCode();
        _hashCode += new Double(getBultos()).hashCode();
        _hashCode += new Double(getAlto()).hashCode();
        _hashCode += new Double(getAncho()).hashCode();
        _hashCode += new Double(getProfundidad()).hashCode();
        _hashCode += getApilable();
        if (getRotacion() != null) {
            _hashCode += getRotacion().hashCode();
        }
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getRazonSocial() != null) {
            _hashCode += getRazonSocial().hashCode();
        }
        if (getRotacionesPermitidas() != null) {
            _hashCode += getRotacionesPermitidas().hashCode();
        }
        if (getLinea() != null) {
            _hashCode += getLinea().hashCode();
        }
        if (getSubLinea() != null) {
            _hashCode += getSubLinea().hashCode();
        }
        if (getUnidadMedida() != null) {
            _hashCode += getUnidadMedida().hashCode();
        }
        if (getClienteDador() != null) {
            _hashCode += getClienteDador().hashCode();
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
        if (getTiempoDescarga() != null) {
            _hashCode += getTiempoDescarga().hashCode();
        }
        if (getCosto() != null) {
            _hashCode += getCosto().hashCode();
        }
        if (getOrdenamiento() != null) {
            _hashCode += getOrdenamiento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PProducto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pProducto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refProducto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefProducto"));
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
        elemField.setFieldName("bultos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Bultos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Alto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ancho");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ancho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profundidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Profundidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apilable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Apilable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rotacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Rotacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Codigo"));
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
        elemField.setFieldName("rotacionesPermitidas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RotacionesPermitidas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linea");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Linea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subLinea");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "SubLinea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidadMedida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "UnidadMedida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("campoDinamico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoDinamico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CampoValor"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempoDescarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoDescarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordenamiento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ordenamiento"));
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
