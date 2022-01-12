/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aruaro
 *
 */
public class CotizacionLineaDireccion implements Serializable{

    private static final long serialVersionUID = 1L;
   
    int idcotizacionlinea;
    int idtarifa;
    int idtipoventa;  //1=Contado, 2=Prepagado, 3=fxc  22=Contdo Convenio
    float tramo ;
    float kg_sobrepeso;
    String es_ocurre;
   
    String nacional;
    String cporigen;
    String cpdestino ;
    String uuid;
    String idcotizacionlinea_direccion ;
     String rfc_rem ;
    String razonsocial_rem ;
    String contacto_rem ;
    String numexterior_rem ;
    String numinterior_rem ;
    String calle_rem ;
    String  colonia_rem ;
    String  municipio_rem ;
    String estado_rem ;
    String ciudad_rem ;
    String cp_rem ;
    String telefono_rem ;
    String celular_rem ;
    String email_rem ;
    String pais_rem ;
    String rfc_des ;
    String razonsocial_des ;
    String contacto_des ;
    String calle_des ;
    String numexterior_des ;
    String numinterior_des ;
    String colonia_des ;
    String municipio_des ;
    String estado_des ;
    String ciudad_des ;
    String cp_des ;
    String telefono_des ;
    String celular_des ;
    String email_des ;
    String pais_des ;
    String tiporotulo;
    
    String idservicio;
    String  serviciotarifa;
    
    String  iddocumento ;
    float cobro_sobrepeso;
    float cobro_reexpedicion;
    
    List<CotizacionLineaAdicional> arr_adicionales= new ArrayList<CotizacionLineaAdicional>();
    List<CotizacionLineaVolumen> arr_volumen= new ArrayList<CotizacionLineaVolumen>();
    
    
    int idrangoinicial;
    int idrangofinal;
    String numoficina;
    String numcliente;
    int idcliente;
    int idconvenio;
    int idconveniodetalle;
    
    
    /**
     * @return the idcotizacionlinea_direccion
     */
    public String getIdcotizacionlinea_direccion() {
        return idcotizacionlinea_direccion;
    }
    /**
     * @return the idcotizacionlinea
     */
    public int getIdcotizacionlinea() {
        return idcotizacionlinea;
    }
    /**
     * @return the rfc_rem
     */
    public String getRfc_rem() {
        return rfc_rem;
    }
    /**
     * @return the razonsocial_rem
     */
    public String getRazonsocial_rem() {
        return razonsocial_rem;
    }
    /**
     * @return the contacto_rem
     */
    public String getContacto_rem() {
        return contacto_rem;
    }
    /**
     * @return the numexterior_rem
     */
    public String getNumexterior_rem() {
        return numexterior_rem;
    }
    /**
     * @return the numinterior_rem
     */
    public String getNuminterior_rem() {
        return numinterior_rem;
    }
    /**
     * @return the calle_rem
     */
    public String getCalle_rem() {
        return calle_rem;
    }
    /**
     * @return the colonia_rem
     */
    public String getColonia_rem() {
        return colonia_rem;
    }
    /**
     * @return the municipio_rem
     */
    public String getMunicipio_rem() {
        return municipio_rem;
    }
    /**
     * @return the estado_rem
     */
    public String getEstado_rem() {
        return estado_rem;
    }
    /**
     * @return the ciudad_rem
     */
    public String getCiudad_rem() {
        return ciudad_rem;
    }
    /**
     * @return the cp_rem
     */
    public String getCp_rem() {
        return cp_rem;
    }
    /**
     * @return the telefono_rem
     */
    public String getTelefono_rem() {
        return telefono_rem;
    }
    /**
     * @return the celular_rem
     */
    public String getCelular_rem() {
        return celular_rem;
    }
    /**
     * @return the email_rem
     */
    public String getEmail_rem() {
        return email_rem;
    }
    /**
     * @return the pais_rem
     */
    public String getPais_rem() {
        return pais_rem;
    }
    /**
     * @return the rfc_des
     */
    public String getRfc_des() {
        return rfc_des;
    }
    /**
     * @return the razonsocial_des
     */
    public String getRazonsocial_des() {
        return razonsocial_des;
    }
    /**
     * @return the contacto_des
     */
    public String getContacto_des() {
        return contacto_des;
    }
    /**
     * @return the calle_des
     */
    public String getCalle_des() {
        return calle_des;
    }
    /**
     * @return the numexterior_des
     */
    public String getNumexterior_des() {
        return numexterior_des;
    }
    /**
     * @return the numinterior_des
     */
    public String getNuminterior_des() {
        return numinterior_des;
    }
    /**
     * @return the colonia_des
     */
    public String getColonia_des() {
        return colonia_des;
    }
    /**
     * @return the municipio_des
     */
    public String getMunicipio_des() {
        return municipio_des;
    }
    /**
     * @return the estado_des
     */
    public String getEstado_des() {
        return estado_des;
    }
    /**
     * @return the ciudad_des
     */
    public String getCiudad_des() {
        return ciudad_des;
    }
    /**
     * @return the cp_des
     */
    public String getCp_des() {
        return cp_des;
    }
    /**
     * @return the telefono_des
     */
    public String getTelefono_des() {
        return telefono_des;
    }
    /**
     * @return the celular_des
     */
    public String getCelular_des() {
        return celular_des;
    }
    /**
     * @return the email_des
     */
    public String getEmail_des() {
        return email_des;
    }
    /**
     * @return the pais_des
     */
    public String getPais_des() {
        return pais_des;
    }
    /**
     * @return the tiporotulo
     */
    public String getTiporotulo() {
        return tiporotulo;
    }
    /**
     * @param idcotizacionlinea_direccion the idcotizacionlinea_direccion to set
     */
    public void setIdcotizacionlinea_direccion(String idcotizacionlinea_direccion) {
        this.idcotizacionlinea_direccion = idcotizacionlinea_direccion;
    }
    /**
     * @param idcotizacionlinea the idcotizacionlinea to set
     */
    public void setIdcotizacionlinea(int idcotizacionlinea) {
        this.idcotizacionlinea = idcotizacionlinea;
    }
    /**
     * @param rfc_rem the rfc_rem to set
     */
    public void setRfc_rem(String rfc_rem) {
        this.rfc_rem = rfc_rem;
    }
    /**
     * @param razonsocial_rem the razonsocial_rem to set
     */
    public void setRazonsocial_rem(String razonsocial_rem) {
        this.razonsocial_rem = razonsocial_rem;
    }
    /**
     * @param contacto_rem the contacto_rem to set
     */
    public void setContacto_rem(String contacto_rem) {
        this.contacto_rem = contacto_rem;
    }
    /**
     * @param numexterior_rem the numexterior_rem to set
     */
    public void setNumexterior_rem(String numexterior_rem) {
        this.numexterior_rem = numexterior_rem;
    }
    /**
     * @param numinterior_rem the numinterior_rem to set
     */
    public void setNuminterior_rem(String numinterior_rem) {
        this.numinterior_rem = numinterior_rem;
    }
    /**
     * @param calle_rem the calle_rem to set
     */
    public void setCalle_rem(String calle_rem) {
        this.calle_rem = calle_rem;
    }
    /**
     * @param colonia_rem the colonia_rem to set
     */
    public void setColonia_rem(String colonia_rem) {
        this.colonia_rem = colonia_rem;
    }
    /**
     * @param municipio_rem the municipio_rem to set
     */
    public void setMunicipio_rem(String municipio_rem) {
        this.municipio_rem = municipio_rem;
    }
    /**
     * @param estado_rem the estado_rem to set
     */
    public void setEstado_rem(String estado_rem) {
        this.estado_rem = estado_rem;
    }
    /**
     * @param ciudad_rem the ciudad_rem to set
     */
    public void setCiudad_rem(String ciudad_rem) {
        this.ciudad_rem = ciudad_rem;
    }
    /**
     * @param cp_rem the cp_rem to set
     */
    public void setCp_rem(String cp_rem) {
        this.cp_rem = cp_rem;
    }
    /**
     * @param telefono_rem the telefono_rem to set
     */
    public void setTelefono_rem(String telefono_rem) {
        this.telefono_rem = telefono_rem;
    }
    /**
     * @param celular_rem the celular_rem to set
     */
    public void setCelular_rem(String celular_rem) {
        this.celular_rem = celular_rem;
    }
    /**
     * @param email_rem the email_rem to set
     */
    public void setEmail_rem(String email_rem) {
        this.email_rem = email_rem;
    }
    /**
     * @param pais_rem the pais_rem to set
     */
    public void setPais_rem(String pais_rem) {
        this.pais_rem = pais_rem;
    }
    /**
     * @param rfc_des the rfc_des to set
     */
    public void setRfc_des(String rfc_des) {
        this.rfc_des = rfc_des;
    }
    /**
     * @param razonsocial_des the razonsocial_des to set
     */
    public void setRazonsocial_des(String razonsocial_des) {
        this.razonsocial_des = razonsocial_des;
    }
    /**
     * @param contacto_des the contacto_des to set
     */
    public void setContacto_des(String contacto_des) {
        this.contacto_des = contacto_des;
    }
    /**
     * @param calle_des the calle_des to set
     */
    public void setCalle_des(String calle_des) {
        this.calle_des = calle_des;
    }
    /**
     * @param numexterior_des the numexterior_des to set
     */
    public void setNumexterior_des(String numexterior_des) {
        this.numexterior_des = numexterior_des;
    }
    /**
     * @param numinterior_des the numinterior_des to set
     */
    public void setNuminterior_des(String numinterior_des) {
        this.numinterior_des = numinterior_des;
    }
    /**
     * @param colonia_des the colonia_des to set
     */
    public void setColonia_des(String colonia_des) {
        this.colonia_des = colonia_des;
    }
    /**
     * @param municipio_des the municipio_des to set
     */
    public void setMunicipio_des(String municipio_des) {
        this.municipio_des = municipio_des;
    }
    /**
     * @param estado_des the estado_des to set
     */
    public void setEstado_des(String estado_des) {
        this.estado_des = estado_des;
    }
    /**
     * @param ciudad_des the ciudad_des to set
     */
    public void setCiudad_des(String ciudad_des) {
        this.ciudad_des = ciudad_des;
    }
    /**
     * @param cp_des the cp_des to set
     */
    public void setCp_des(String cp_des) {
        this.cp_des = cp_des;
    }
    /**
     * @param telefono_des the telefono_des to set
     */
    public void setTelefono_des(String telefono_des) {
        this.telefono_des = telefono_des;
    }
    /**
     * @param celular_des the celular_des to set
     */
    public void setCelular_des(String celular_des) {
        this.celular_des = celular_des;
    }
    /**
     * @param email_des the email_des to set
     */
    public void setEmail_des(String email_des) {
        this.email_des = email_des;
    }
    /**
     * @param pais_des the pais_des to set
     */
    public void setPais_des(String pais_des) {
        this.pais_des = pais_des;
    }
    /**
     * @param tiporotulo the tiporotulo to set
     */
    public void setTiporotulo(String tiporotulo) {
        this.tiporotulo = tiporotulo;
    }
    /**
     * @return the idtarifa
     */
    public int getIdtarifa() {
        return idtarifa;
    }
    /**
     * @param idtarifa the idtarifa to set
     */
    public void setIdtarifa(int idtarifa) {
        this.idtarifa = idtarifa;
    }
    
    public void setIdtarifa(String idtarifa) {
		try{
			this.idtarifa = Integer.parseInt(idtarifa);
		}catch(Exception e){
			this.idtarifa =0;
		}
		
		
	}
    
    /**
     * @return the tramo
     */
    public float getTramo() { 
        return tramo;
    }
    /**
     * @param tramo the tramo to set
     */
    public void setTramo(float tramo) {
        this.tramo = tramo;
    }
    /**
     * @return the cporigen
     */
    public String getCporigen() {
        return cporigen;
    }
    /**
     * @param cporigen the cporigen to set
     */
    public void setCporigen(String cporigen) {
        this.cporigen = cporigen;
    }
    /**
     * @return the cpdestino
     */
    public String getCpdestino() {
        return cpdestino;
    }
    /**
     * @param cpdestino the cpdestino to set
     */
    public void setCpdestino(String cpdestino) {
        this.cpdestino = cpdestino;
    }
    /**
     * @return the arr_adicionales
     */
    public List<CotizacionLineaAdicional> getArr_adicionales() {
        return arr_adicionales;
    }
    
    public void addArr_adicionales(CotizacionLineaAdicional a) {
        arr_adicionales.add(a);
    }
    
    /**
     * @param arr_adicionales the arr_adicionales to set
     */
    public void setArr_adicionales(List<CotizacionLineaAdicional> arr_adicionales) {
        this.arr_adicionales = arr_adicionales;
    }
    /**
     * @return the arr_volumen
     */
    public List<CotizacionLineaVolumen> getArr_volumen() {
        return arr_volumen;
    }
    
    public void addArr_volumen(CotizacionLineaVolumen a) {
        arr_volumen.add(a);
    }
    
    /**
     * @param arr_volumen the arr_volumen to set
     */
    public void setArr_volumen(List<CotizacionLineaVolumen> arr_volumen) {
        this.arr_volumen = arr_volumen;
    }
    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }
    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    /**
     * @return the es_ocurre
     */
    public String getEs_ocurre() {
    	if ((es_ocurre == null) || (es_ocurre.trim().isEmpty())){
    		return "NO";
    	}
        return es_ocurre;
    }
    /**
     * @param es_ocurre the es_ocurre to set
     */
    public void setEs_ocurre(String es_ocurre) {
        this.es_ocurre = es_ocurre;
    }
    /**
     * @return the nacional
     */
    public String getNacional() {
        return nacional;
    }
    /**
     * @param nacional the nacional to set
     */
    public void setNacional(String nacional) {
        this.nacional = nacional;
    }
    /**
     * @return the idservicio
     */
    public String getIdservicio() {
        return idservicio;
    }
    /**
     * @param idservicio the idservicio to set
     */
    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }
    /**
     * @return the serviciotarifa
     */
    public String getServiciotarifa() {
        return serviciotarifa;
    }
    /**
     * @param serviciotarifa the serviciotarifa to set
     */
    public void setServiciotarifa(String serviciotarifa) {
        this.serviciotarifa = serviciotarifa;
    }
    /**
     * @return the iddocumento
     */
    public String getIddocumento() {
        return iddocumento;
    }
    /**
     * @return the cobro_sobrepeso
     */
    public float getCobro_sobrepeso() {
        return cobro_sobrepeso;
    }
    /**
     * @return the cobro_reexpedicion
     */
    public float getCobro_reexpedicion() {
        return cobro_reexpedicion;
    }
    /**
     * @param iddocumento the iddocumento to set
     */
    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }
    /**
     * @param cobro_sobrepeso the cobro_sobrepeso to set
     */
    public void setCobro_sobrepeso(float cobro_sobrepeso) {
        this.cobro_sobrepeso = cobro_sobrepeso;
    }
    /**
     * @param cobro_reexpedicion the cobro_reexpedicion to set
     */
    public void setCobro_reexpedicion(float cobro_reexpedicion) {
        this.cobro_reexpedicion = cobro_reexpedicion;
    }
	public int getIdtipoventa() {
		return idtipoventa;
	}
	public void setIdtipoventa(int idtipoventa) {
		this.idtipoventa = idtipoventa;
	}
	
	public void setIdtipoventa(String idtipoventa) {
		try{
			this.idtipoventa = Integer.parseInt(idtipoventa);
		}catch(Exception e){
			this.idtipoventa =0;
		}
	
	}
	public int getIdrangoinicial() {
		return idrangoinicial;
	}
	public void setIdrangoinicial(int idrangoinicial) {
		this.idrangoinicial = idrangoinicial;
	}
	
	public void setIdrangoinicial(String idrangoinicial) {
		try{
			this.idrangoinicial = Integer.parseInt(idrangoinicial);
		}catch(Exception e){
			this.idrangoinicial =0;
		}
		
		
	}
	
	public int getIdrangofinal() {
		return idrangofinal;
	}
	public void setIdrangofinal(int idrangofinal) {
		this.idrangofinal = idrangofinal;
	}
	
	public void setIdrangofinal(String idrangofinal) {
		try{
			this.idrangofinal = Integer.parseInt(idrangofinal);
		}catch(Exception e){
			this.idrangofinal =0;
		}
		
		
	}
	
	public String getNumoficina() {
		return numoficina;
	}
	public void setNumoficina(String numoficina) {
		this.numoficina = numoficina;
	}
	public String getNumcliente() {
		return numcliente;
	}
	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	public void setIdcliente(String idcliente) {
		try{
			this.idcliente = Integer.parseInt(idcliente);
		}catch(Exception e){
			this.idcliente =0;
		}
		
		
	}
	
	public int getIdconvenio() {
		return idconvenio;
	}
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}
	
	public void setIdconvenio(String idconvenio) {
		try{
			this.idconvenio = Integer.parseInt(idconvenio);
		}catch(Exception e){
			this.idconvenio =0;
		}
		
		
	}
	
	public int getIdconveniodetalle() {
		return idconveniodetalle;
	}
	public void setIdconveniodetalle(int idconveniodetalle) {
		this.idconveniodetalle = idconveniodetalle;
	}
	
	public void setIdconveniodetalle(String idconveniodetalle) {
		try{
			this.idconveniodetalle = Integer.parseInt(idconveniodetalle);
		}catch(Exception e){
			this.idconveniodetalle =0;
		}
		
		
	}
	public float getKg_sobrepeso() {
		return kg_sobrepeso;
	}
	public void setKg_sobrepeso(float kg_sobrepeso) {
		this.kg_sobrepeso = kg_sobrepeso;
	}
	
}
