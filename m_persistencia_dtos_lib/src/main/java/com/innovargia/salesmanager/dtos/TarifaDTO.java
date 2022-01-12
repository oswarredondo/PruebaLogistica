/**
 * 
 */
package com.innovargia.salesmanager.dtos;


/**
 * @author Adri�n
 *
 */
public class TarifaDTO {

    String idservicio  ;
	String idformapago;
	String nombre ;
	String descripcion;
	String fechainicial;
	String fechafinal;
	String zona;
	String descripciontarifa;
	String descripcionformapago;
	String descripcionservicio;

	
	int idtarifa ;
	int idtarifa_padre;
	int idtarifapeso  ;
	int idserviciotarifa ;
	int idserviciotarifazona;
	int idrangoenvios;
	float pesoamparado;
	float pesoinicial;
	float pesofinal;
	int estatus  ;
	int idrangoinicial;
	int idrangofinal;
	float kminicial;
	float kmfinal;
	float precio;
	float sobrepeso;
	float preciokgsp;
	float pesovolumetrico;
	int es_visible_pdv=0;
	float volumen;
	
	boolean es_default=false;
	
	/* CAMBIO CITA EVIDENCIA MANIOBRA */
	
	//Se agregan los campos para citas y evidencia y sus GET Y SET
	
	float preciocitas;
	float precioevidencia;
	
	/* FIN CAMBIO */
	
	/**
	 * @return the pesovolumetrico
	 */
	public float getPesovolumetrico() {
	   	return pesovolumetrico;
	}

	public void  setPesovolumetrico(String pesovolumetrico) {
	    try{
		this.pesovolumetrico = Float.parseFloat(pesovolumetrico);
	    }catch(Exception e){
		this.pesovolumetrico = 0;
	    }
		
	}



	/**
	 * @param pesovolumetrico the pesovolumetrico to set
	 */
	public void setPesovolumetrico(float pesovolumetrico) {
		this.pesovolumetrico = pesovolumetrico;
	}




	
	
	/**
	 * 
	 */
	public TarifaDTO() {
		// TODO Auto-generated constructor stub
	}
	



	public int getIdtarifa() {
		return idtarifa;
	}

	public void  setIdtarifa(String idtarifa) {
	    try{
		this.idtarifa = Integer.parseInt(idtarifa);
	    }catch(Exception e){
		this.idtarifa = 0;
	    }
		
	}

	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}



	public float getPesoamparado() {
		return pesoamparado;
	}

	public void  setPesoamparado(String pesoamparado) {
	    try{
		this.pesoamparado = Float.parseFloat(pesoamparado);
	    }catch(Exception e){
		this.pesoamparado = 0;
	    }
		
	}

	public void setPesoamparado(float pesoamparado) {
		this.pesoamparado = pesoamparado;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getIdserviciotarifa() {
		return idserviciotarifa;
	}


	public void  setIdserviciotarifa(String idserviciotarifa) {
	    try{
		this.idserviciotarifa = Integer.parseInt(idserviciotarifa);
	    }catch(Exception e){
		this.idserviciotarifa = 0;
	    }
		
	}
	
	public void setIdserviciotarifa(int idserviciotarifa) {
		this.idserviciotarifa = idserviciotarifa;
	}




	public int getEstatus() {
		return estatus;
	}




	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public void  setEstatus(String estatus) {
	    try{
		this.estatus = Integer.parseInt(estatus);
	    }catch(Exception e){
		this.estatus = 0;
	    }
		
	}


	public String getFechainicial() {
		return fechainicial;
	}




	public void setFechainicial(String fechainicial) {
		this.fechainicial = fechainicial;
	}




	public String getFechafinal() {
		return fechafinal;
	}




	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}




	/**
	 * @return the es_visible_pdv
	 */
	public int getEs_visible_pdv() {
	    return es_visible_pdv;
	}

   


	/**
	 * @param es_visible_pdv the es_visible_pdv to set
	 */
	public void setEs_visible_pdv(int es_visible_pdv) {
	    this.es_visible_pdv = es_visible_pdv;
	}
	public void setEs_visible_pdv(String es_visible_pdv) {
	    try{
		this.es_visible_pdv = Integer.parseInt(es_visible_pdv);
	    }catch(Exception e){
		this.es_visible_pdv =0;
	    }
	    
	}



	public int getIdrangoinicial() {
		return idrangoinicial;
	}




	public void setIdrangoinicial(int idrangoinicial) {
		this.idrangoinicial = idrangoinicial;
	}

	public void  setIdrangoinicial(String idrangoinicial) {
	    try{
		this.idrangoinicial = Integer.parseInt(idrangoinicial);
	    }catch(Exception e){
		this.idrangoinicial = 0;
	    }
		
	}


	public int getIdrangofinal() {
		return idrangofinal;
	}




	public void setIdrangofinal(int idrangofinal) {
		this.idrangofinal = idrangofinal;
	}

	public void  setIdrangofinal(String idrangofinal) {
	    try{
		this.idrangofinal = Integer.parseInt(idrangofinal);
	    }catch(Exception e){
		this.idrangofinal = 0;
	    }
		
	}


	public String getZona() {
		return zona;
	}




	public void setZona(String zona) {
		this.zona = zona;
	}




	public float getKminicial() {
		return kminicial;
	}




	public void setKminicial(float kminicial) {
		this.kminicial = kminicial;
	}

	public void  setKminicial(String kminicial) {
	    try{
		this.kminicial = Float.parseFloat(kminicial);
	    }catch(Exception e){
		this.kminicial = 0;
	    }
		
	}


	public float getKmfinal() {
		return kmfinal;
	}




	public void setKmfinal(float kmfinal) {
		this.kmfinal = kmfinal;
	}

	public void  setKmfinal(String kmfinal) {
	    try{
		this.kmfinal = Float.parseFloat(kmfinal);
	    }catch(Exception e){
		this.kmfinal = 0;
	    }
		
	}


	public float getPrecio() {
		return precio;
	}

	public void  getPrecio(String precio) {
	    try{
		this.precio = Float.parseFloat(precio);
	    }catch(Exception e){
		this.precio = 0;
	    }
		
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}




	public String getDescripciontarifa() {
		return descripciontarifa;
	}




	public void setDescripciontarifa(String descripciontarifa) {
		this.descripciontarifa = descripciontarifa;
	}




	public String getDescripcionservicio() {
		return descripcionservicio;
	}




	public void setDescripcionservicio(String descripcionservicio) {
		this.descripcionservicio = descripcionservicio;
	}




	/**
	 * @return the idformapago
	 */
	public String getIdformapago() {
		return idformapago;
	}




	/**
	 * @param idformapago the idformapago to set
	 */
	public void setIdformapago(String idformapago) {
		this.idformapago = idformapago;
	}




	/**
	 * @param idservicio the idservicio to set
	 */
	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
	}




	/**
	 * @return the descripcionformapago
	 */
	public String getDescripcionformapago() {
		return descripcionformapago;
	}




	/**
	 * @param descripcionformapago the descripcionformapago to set
	 */
	public void setDescripcionformapago(String descripcionformapago) {
		this.descripcionformapago = descripcionformapago;
	}




	/**
	 * @return the idservicio
	 */
	public String getIdservicio() {
		return idservicio;
	}




	/**
	 * @return the pesoinicial
	 */
	public float getPesoinicial() {
		return pesoinicial;
	}


	public void  getPesoinicial(String pesoinicial) {
	    try{
		this.pesoinicial = Float.parseFloat(pesoinicial);
	    }catch(Exception e){
		this.pesoinicial = 0;
	    }
		
	}

	/**
	 * @param pesoinicial the pesoinicial to set
	 */
	public void setPesoinicial(float pesoinicial) {
		this.pesoinicial = pesoinicial;
	}




	/**
	 * @return the pesofinal
	 */
	public float getPesofinal() {
		return pesofinal;
	}




	/**
	 * @param pesofinal the pesofinal to set
	 */
	public void setPesofinal(float pesofinal) {
		this.pesofinal = pesofinal;
	}


	public void  setPesofinal(String pesofinal) {
	    try{
		this.pesofinal = Float.parseFloat(pesofinal);
	    }catch(Exception e){
		this.pesofinal = 0;
	    }
		
	}

	/**
	 * @return the idserviciotarifazona
	 */
	public int getIdserviciotarifazona() {
		return idserviciotarifazona;
	}


	public void  setIdserviciotarifazona(String idserviciotarifazona) {
	    try{
		this.idserviciotarifazona = Integer.parseInt(idserviciotarifazona);
	    }catch(Exception e){
		this.idserviciotarifazona = 0;
	    }
		
	}

	/**
	 * @param idserviciotarifazona the idserviciotarifazona to set
	 */
	public void setIdserviciotarifazona(int idserviciotarifazona) {
		this.idserviciotarifazona = idserviciotarifazona;
	}




	public int getIdrangoenvios() {
		return idrangoenvios;
	}


	public void  setIdrangoenvios(String idrangoenvios) {
	    try{
		this.idrangoenvios = Integer.parseInt(idrangoenvios);
	    }catch(Exception e){
		this.idrangoenvios = 0;
	    }
		
	}

	public void setIdrangoenvios(int idrangoenvios) {
		this.idrangoenvios = idrangoenvios;
	}




	/**
	 * @return the idtarifapeso
	 */
	public int getIdtarifapeso() {
		return idtarifapeso;
	}




	/**
	 * @param idtarifapeso the idtarifapeso to set
	 */
	public void setIdtarifapeso(int idtarifapeso) {
		this.idtarifapeso = idtarifapeso;
	}

	public void  setIdtarifapeso(String idtarifapeso) {
	    try{
		this.idtarifapeso = Integer.parseInt(idtarifapeso);
	    }catch(Exception e){
		this.idtarifapeso = 0;
	    }
		
	}



	/**
	 * @return the sobrepeso
	 */
	public float getSobrepeso() {
		return sobrepeso;
	}




	/**
	 * @param sobrepeso the sobrepeso to set
	 */
	public void setSobrepeso(float sobrepeso) {
		this.sobrepeso = sobrepeso;
	}

	public void  setSobrepeso(String sobrepeso) {
	    try{
		this.sobrepeso = Float.parseFloat(sobrepeso);
	    }catch(Exception e){
		this.sobrepeso = 0;
	    }
		
	}


	public float getPreciokgsp() {
		return preciokgsp;
	}



	public void  setPreciokgsp(String preciokgsp) {
	    try{
		this.preciokgsp = Float.parseFloat(preciokgsp);
	    }catch(Exception e){
		this.preciokgsp = 0;
	    }
		
	}

	public void setPreciokgsp(float preciokgsp) {
		this.preciokgsp = preciokgsp;
	}

	/**
	 * @return the idtarifa_padre
	 */
	public int getIdtarifa_padre() {
	    return idtarifa_padre;
	}

	/**
	 * @param idtarifa_padre the idtarifa_padre to set
	 */
	public void setIdtarifa_padre(int idtarifa_padre) {
	    this.idtarifa_padre = idtarifa_padre;
	}

	/**
	 * @return the volumen
	 */
	public float getVolumen() {
	    return volumen;
	}

	/**
	 * @param volumen the volumen to set
	 */
	public void setVolumen(float volumen) {
	    this.volumen = volumen;
	}

	/**
	 * @return the es_default
	 */
	public boolean isEs_default() {
	    return es_default;
	}

	/**
	 * @param es_default the es_default to set
	 */
	public void setEs_default(boolean es_default) {
	    this.es_default = es_default;
	}
	
	/* CAMBIO CITA EVIDENCIA MANIOBRA */
	public float getPreciocitas() {
		return preciocitas;
	}

	public void setPreciocitas(float preciocitas) {
		this.preciocitas = preciocitas;
	}
	
	public float getPrecioevidencia() {
		return precioevidencia;
	}

	public void setPrecioevidencia(float precioevidencia) {
		this.precioevidencia = precioevidencia;
	}
	/* FIN CAMBIO */

}
