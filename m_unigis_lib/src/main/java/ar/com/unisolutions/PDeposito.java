/**
 * PDeposito.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class PDeposito  implements java.io.Serializable {
    private java.lang.String refDepositoExterno;

    private java.lang.String descripcion;

    private java.lang.String direccion;

    private java.lang.String nroPuerta;

    private java.lang.String ciudad;

    private java.lang.String municipio;

    private java.lang.String colonia;

    private int inicioHorario;

    private int finHorario;

    private int tiempoEspera;

    private double latitud;

    private double longitud;

    private java.lang.String calle;

    private java.lang.String entreCalle;

    private java.lang.String barrio;

    private java.lang.String localidad;

    private java.lang.String partido;

    private java.lang.String provincia;

    private java.lang.String pais;

    private java.lang.Double x;

    private java.lang.Double y;

    private ar.com.unisolutions.CampoValor[] campoDinamico;

    private java.lang.Double distanciaMaxima;

    private java.lang.Boolean eliminado;

    public PDeposito() {
    }

    public PDeposito(
           java.lang.String refDepositoExterno,
           java.lang.String descripcion,
           java.lang.String direccion,
           java.lang.String nroPuerta,
           java.lang.String ciudad,
           java.lang.String municipio,
           java.lang.String colonia,
           int inicioHorario,
           int finHorario,
           int tiempoEspera,
           double latitud,
           double longitud,
           java.lang.String calle,
           java.lang.String entreCalle,
           java.lang.String barrio,
           java.lang.String localidad,
           java.lang.String partido,
           java.lang.String provincia,
           java.lang.String pais,
           java.lang.Double x,
           java.lang.Double y,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           java.lang.Double distanciaMaxima,
           java.lang.Boolean eliminado) {
           this.refDepositoExterno = refDepositoExterno;
           this.descripcion = descripcion;
           this.direccion = direccion;
           this.nroPuerta = nroPuerta;
           this.ciudad = ciudad;
           this.municipio = municipio;
           this.colonia = colonia;
           this.inicioHorario = inicioHorario;
           this.finHorario = finHorario;
           this.tiempoEspera = tiempoEspera;
           this.latitud = latitud;
           this.longitud = longitud;
           this.calle = calle;
           this.entreCalle = entreCalle;
           this.barrio = barrio;
           this.localidad = localidad;
           this.partido = partido;
           this.provincia = provincia;
           this.pais = pais;
           this.x = x;
           this.y = y;
           this.campoDinamico = campoDinamico;
           this.distanciaMaxima = distanciaMaxima;
           this.eliminado = eliminado;
    }


    /**
     * Gets the refDepositoExterno value for this PDeposito.
     * 
     * @return refDepositoExterno
     */
    public java.lang.String getRefDepositoExterno() {
        return refDepositoExterno;
    }


    /**
     * Sets the refDepositoExterno value for this PDeposito.
     * 
     * @param refDepositoExterno
     */
    public void setRefDepositoExterno(java.lang.String refDepositoExterno) {
        this.refDepositoExterno = refDepositoExterno;
    }


    /**
     * Gets the descripcion value for this PDeposito.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PDeposito.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the direccion value for this PDeposito.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this PDeposito.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the nroPuerta value for this PDeposito.
     * 
     * @return nroPuerta
     */
    public java.lang.String getNroPuerta() {
        return nroPuerta;
    }


    /**
     * Sets the nroPuerta value for this PDeposito.
     * 
     * @param nroPuerta
     */
    public void setNroPuerta(java.lang.String nroPuerta) {
        this.nroPuerta = nroPuerta;
    }


    /**
     * Gets the ciudad value for this PDeposito.
     * 
     * @return ciudad
     */
    public java.lang.String getCiudad() {
        return ciudad;
    }


    /**
     * Sets the ciudad value for this PDeposito.
     * 
     * @param ciudad
     */
    public void setCiudad(java.lang.String ciudad) {
        this.ciudad = ciudad;
    }


    /**
     * Gets the municipio value for this PDeposito.
     * 
     * @return municipio
     */
    public java.lang.String getMunicipio() {
        return municipio;
    }


    /**
     * Sets the municipio value for this PDeposito.
     * 
     * @param municipio
     */
    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }


    /**
     * Gets the colonia value for this PDeposito.
     * 
     * @return colonia
     */
    public java.lang.String getColonia() {
        return colonia;
    }


    /**
     * Sets the colonia value for this PDeposito.
     * 
     * @param colonia
     */
    public void setColonia(java.lang.String colonia) {
        this.colonia = colonia;
    }


    /**
     * Gets the inicioHorario value for this PDeposito.
     * 
     * @return inicioHorario
     */
    public int getInicioHorario() {
        return inicioHorario;
    }


    /**
     * Sets the inicioHorario value for this PDeposito.
     * 
     * @param inicioHorario
     */
    public void setInicioHorario(int inicioHorario) {
        this.inicioHorario = inicioHorario;
    }


    /**
     * Gets the finHorario value for this PDeposito.
     * 
     * @return finHorario
     */
    public int getFinHorario() {
        return finHorario;
    }


    /**
     * Sets the finHorario value for this PDeposito.
     * 
     * @param finHorario
     */
    public void setFinHorario(int finHorario) {
        this.finHorario = finHorario;
    }


    /**
     * Gets the tiempoEspera value for this PDeposito.
     * 
     * @return tiempoEspera
     */
    public int getTiempoEspera() {
        return tiempoEspera;
    }


    /**
     * Sets the tiempoEspera value for this PDeposito.
     * 
     * @param tiempoEspera
     */
    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }


    /**
     * Gets the latitud value for this PDeposito.
     * 
     * @return latitud
     */
    public double getLatitud() {
        return latitud;
    }


    /**
     * Sets the latitud value for this PDeposito.
     * 
     * @param latitud
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }


    /**
     * Gets the longitud value for this PDeposito.
     * 
     * @return longitud
     */
    public double getLongitud() {
        return longitud;
    }


    /**
     * Sets the longitud value for this PDeposito.
     * 
     * @param longitud
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    /**
     * Gets the calle value for this PDeposito.
     * 
     * @return calle
     */
    public java.lang.String getCalle() {
        return calle;
    }


    /**
     * Sets the calle value for this PDeposito.
     * 
     * @param calle
     */
    public void setCalle(java.lang.String calle) {
        this.calle = calle;
    }


    /**
     * Gets the entreCalle value for this PDeposito.
     * 
     * @return entreCalle
     */
    public java.lang.String getEntreCalle() {
        return entreCalle;
    }


    /**
     * Sets the entreCalle value for this PDeposito.
     * 
     * @param entreCalle
     */
    public void setEntreCalle(java.lang.String entreCalle) {
        this.entreCalle = entreCalle;
    }


    /**
     * Gets the barrio value for this PDeposito.
     * 
     * @return barrio
     */
    public java.lang.String getBarrio() {
        return barrio;
    }


    /**
     * Sets the barrio value for this PDeposito.
     * 
     * @param barrio
     */
    public void setBarrio(java.lang.String barrio) {
        this.barrio = barrio;
    }


    /**
     * Gets the localidad value for this PDeposito.
     * 
     * @return localidad
     */
    public java.lang.String getLocalidad() {
        return localidad;
    }


    /**
     * Sets the localidad value for this PDeposito.
     * 
     * @param localidad
     */
    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }


    /**
     * Gets the partido value for this PDeposito.
     * 
     * @return partido
     */
    public java.lang.String getPartido() {
        return partido;
    }


    /**
     * Sets the partido value for this PDeposito.
     * 
     * @param partido
     */
    public void setPartido(java.lang.String partido) {
        this.partido = partido;
    }


    /**
     * Gets the provincia value for this PDeposito.
     * 
     * @return provincia
     */
    public java.lang.String getProvincia() {
        return provincia;
    }


    /**
     * Sets the provincia value for this PDeposito.
     * 
     * @param provincia
     */
    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }


    /**
     * Gets the pais value for this PDeposito.
     * 
     * @return pais
     */
    public java.lang.String getPais() {
        return pais;
    }


    /**
     * Sets the pais value for this PDeposito.
     * 
     * @param pais
     */
    public void setPais(java.lang.String pais) {
        this.pais = pais;
    }


    /**
     * Gets the x value for this PDeposito.
     * 
     * @return x
     */
    public java.lang.Double getX() {
        return x;
    }


    /**
     * Sets the x value for this PDeposito.
     * 
     * @param x
     */
    public void setX(java.lang.Double x) {
        this.x = x;
    }


    /**
     * Gets the y value for this PDeposito.
     * 
     * @return y
     */
    public java.lang.Double getY() {
        return y;
    }


    /**
     * Sets the y value for this PDeposito.
     * 
     * @param y
     */
    public void setY(java.lang.Double y) {
        this.y = y;
    }


    /**
     * Gets the campoDinamico value for this PDeposito.
     * 
     * @return campoDinamico
     */
    public ar.com.unisolutions.CampoValor[] getCampoDinamico() {
        return campoDinamico;
    }


    /**
     * Sets the campoDinamico value for this PDeposito.
     * 
     * @param campoDinamico
     */
    public void setCampoDinamico(ar.com.unisolutions.CampoValor[] campoDinamico) {
        this.campoDinamico = campoDinamico;
    }


    /**
     * Gets the distanciaMaxima value for this PDeposito.
     * 
     * @return distanciaMaxima
     */
    public java.lang.Double getDistanciaMaxima() {
        return distanciaMaxima;
    }


    /**
     * Sets the distanciaMaxima value for this PDeposito.
     * 
     * @param distanciaMaxima
     */
    public void setDistanciaMaxima(java.lang.Double distanciaMaxima) {
        this.distanciaMaxima = distanciaMaxima;
    }


    /**
     * Gets the eliminado value for this PDeposito.
     * 
     * @return eliminado
     */
    public java.lang.Boolean getEliminado() {
        return eliminado;
    }


    /**
     * Sets the eliminado value for this PDeposito.
     * 
     * @param eliminado
     */
    public void setEliminado(java.lang.Boolean eliminado) {
        this.eliminado = eliminado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PDeposito)) return false;
        PDeposito other = (PDeposito) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.refDepositoExterno==null && other.getRefDepositoExterno()==null) || 
             (this.refDepositoExterno!=null &&
              this.refDepositoExterno.equals(other.getRefDepositoExterno()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.nroPuerta==null && other.getNroPuerta()==null) || 
             (this.nroPuerta!=null &&
              this.nroPuerta.equals(other.getNroPuerta()))) &&
            ((this.ciudad==null && other.getCiudad()==null) || 
             (this.ciudad!=null &&
              this.ciudad.equals(other.getCiudad()))) &&
            ((this.municipio==null && other.getMunicipio()==null) || 
             (this.municipio!=null &&
              this.municipio.equals(other.getMunicipio()))) &&
            ((this.colonia==null && other.getColonia()==null) || 
             (this.colonia!=null &&
              this.colonia.equals(other.getColonia()))) &&
            this.inicioHorario == other.getInicioHorario() &&
            this.finHorario == other.getFinHorario() &&
            this.tiempoEspera == other.getTiempoEspera() &&
            this.latitud == other.getLatitud() &&
            this.longitud == other.getLongitud() &&
            ((this.calle==null && other.getCalle()==null) || 
             (this.calle!=null &&
              this.calle.equals(other.getCalle()))) &&
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
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this.y==null && other.getY()==null) || 
             (this.y!=null &&
              this.y.equals(other.getY()))) &&
            ((this.campoDinamico==null && other.getCampoDinamico()==null) || 
             (this.campoDinamico!=null &&
              java.util.Arrays.equals(this.campoDinamico, other.getCampoDinamico()))) &&
            ((this.distanciaMaxima==null && other.getDistanciaMaxima()==null) || 
             (this.distanciaMaxima!=null &&
              this.distanciaMaxima.equals(other.getDistanciaMaxima()))) &&
            ((this.eliminado==null && other.getEliminado()==null) || 
             (this.eliminado!=null &&
              this.eliminado.equals(other.getEliminado())));
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
        if (getRefDepositoExterno() != null) {
            _hashCode += getRefDepositoExterno().hashCode();
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
        if (getCiudad() != null) {
            _hashCode += getCiudad().hashCode();
        }
        if (getMunicipio() != null) {
            _hashCode += getMunicipio().hashCode();
        }
        if (getColonia() != null) {
            _hashCode += getColonia().hashCode();
        }
        _hashCode += getInicioHorario();
        _hashCode += getFinHorario();
        _hashCode += getTiempoEspera();
        _hashCode += new Double(getLatitud()).hashCode();
        _hashCode += new Double(getLongitud()).hashCode();
        if (getCalle() != null) {
            _hashCode += getCalle().hashCode();
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
        if (getX() != null) {
            _hashCode += getX().hashCode();
        }
        if (getY() != null) {
            _hashCode += getY().hashCode();
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
        if (getDistanciaMaxima() != null) {
            _hashCode += getDistanciaMaxima().hashCode();
        }
        if (getEliminado() != null) {
            _hashCode += getEliminado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PDeposito.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pDeposito"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refDepositoExterno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "RefDepositoExterno"));
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
        elemField.setFieldName("ciudad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Ciudad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("municipio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Municipio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("colonia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Colonia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioHorario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "InicioHorario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finHorario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "FinHorario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tiempoEspera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "TiempoEspera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("calle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Calle"));
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
        elemField.setFieldName("x");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "X"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Y"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
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
        elemField.setFieldName("distanciaMaxima");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "DistanciaMaxima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eliminado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Eliminado"));
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
