/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class TareaDTO {
	
	  
	  int idtarea;
	  int idtareaorigina=-1; //es -1 cuando la tarea es la original que origina todas las subsecuentes
	  String idusuariogenero;
	  String idusuarioresponsable;
	  String fechasolicitud;
	  String solicitud;
	  String estatus;
	  String tipo;
	  String importancia;
	  String fechacambioestatus;
	  String solucion;

	  String ambito;
	  String fechaexpira;
	  String idambitotarea;
	  String idusuariomodifica;
	  String titulo;
	  
	  boolean enviarcorreo=false;
	  
	/**
	 * 
	 */
	public TareaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idtarea
	 */
	public int getIdtarea() {
		return idtarea;
	}

	/**
	 * @param idtarea the idtarea to set
	 */
	public void setIdtarea(int idtarea) {
		this.idtarea = idtarea;
	}
	public void setIdtarea(String idtarea) {
		try {
			this.idtarea = Integer.parseInt(idtarea);
		} catch (Exception e) {
			this.idtarea = -1;
		}
	}
	
	
	
	/**
	 * @return the idtareaorigina
	 */
	public int getIdtareaorigina() {
		return idtareaorigina;
	}

	/**
	 * @param idtareaorigina the idtareaorigina to set
	 */
	public void setIdtareaorigina(int idtareaorigina) {
		this.idtareaorigina = idtareaorigina;
	}
	
	/**
	 * @param idtareaorigina the idtareaorigina to set
	 */
	public void setIdtareaorigina(String idtareaorigina) {
		try{
			this.idtareaorigina=Integer.parseInt(idtareaorigina);
		}catch(Exception e){
			this.idtareaorigina=-1;
		}
		
	}

	/**
	 * @return the idusuariogenero
	 */
	public String getIdusuariogenero() {
		return idusuariogenero;
	}

	/**
	 * @param idusuariogenero the idusuariogenero to set
	 */
	public void setIdusuariogenero(String idusuariogenero) {
		this.idusuariogenero = idusuariogenero;
	}

	/**
	 * @return the idusuarioresponsable
	 */
	public String getIdusuarioresponsable() {
		return idusuarioresponsable;
	}

	/**
	 * @param idusuarioresponsable the idusuarioresponsable to set
	 */
	public void setIdusuarioresponsable(String idusuarioresponsable) {
		this.idusuarioresponsable = idusuarioresponsable;
	}

	/**
	 * @return the fechasolicitud
	 */
	public String getFechasolicitud() {
		return fechasolicitud;
	}

	/**
	 * @param fechasolicitud the fechasolicitud to set
	 */
	public void setFechasolicitud(String fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the importancia
	 */
	public String getImportancia() {
		return importancia;
	}

	/**
	 * @param importancia the importancia to set
	 */
	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	/**
	 * @return the fechacambioestatus
	 */
	public String getFechacambioestatus() {
		return fechacambioestatus;
	}

	/**
	 * @param fechacambioestatus the fechacambioestatus to set
	 */
	public void setFechacambioestatus(String fechacambioestatus) {
		this.fechacambioestatus = fechacambioestatus;
	}

	/**
	 * @return the solucion
	 */
	public String getSolucion() {
		return solucion;
	}

	/**
	 * @param solucion the solucion to set
	 */
	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	/**
	 * @return the ambito
	 */
	public String getAmbito() {
		return ambito;
	}

	/**
	 * @param ambito the ambito to set
	 */
	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	/**
	 * @return the fechaexpira
	 */
	public String getFechaexpira() {
		return fechaexpira;
	}

	/**
	 * @param fechaexpira the fechaexpira to set
	 */
	public void setFechaexpira(String fechaexpira) {
		this.fechaexpira = fechaexpira;
	}

	/**
	 * @return the idambitotarea
	 */
	public String getIdambitotarea() {
		return idambitotarea;
	}

	/**
	 * @param idambitotarea the idambitotarea to set
	 */
	public void setIdambitotarea(String idambitotarea) {
		this.idambitotarea = idambitotarea;
	}

	/**
	 * @return the enviarcorreo
	 */
	public boolean isEnviarcorreo() {
		return enviarcorreo;
	}

	/**
	 * @param enviarcorreo the enviarcorreo to set
	 */
	public void setEnviarcorreo(boolean enviarcorreo) {
		this.enviarcorreo = enviarcorreo;
	}
	/**
	 * @param enviarcorreo the enviarcorreo to set
	 */
	public void setEnviarcorreo(String enviarcorreo) {
		if (enviarcorreo==null){
			this.enviarcorreo = false;
		}else{
			if (("true".equals(enviarcorreo.trim().toLowerCase())) || 
					("on".equals(enviarcorreo.trim().toLowerCase())) || 	
					("yes".equals(enviarcorreo.trim().toLowerCase())) || 
					("1".equals(enviarcorreo.trim().toLowerCase())) || 
					("si".equals(enviarcorreo.trim().toLowerCase())) || 
					("verdad".equals(enviarcorreo.trim().toLowerCase())) 
					){
					this.enviarcorreo = true;
				}else{
					this.enviarcorreo = false;
				}
		}
		
		
		    
		
	}

	/**
	 * @return the idusuariomodifica
	 */
	public String getIdusuariomodifica() {
		return idusuariomodifica;
	}

	/**
	 * @param idusuariomodifica the idusuariomodifica to set
	 */
	public void setIdusuariomodifica(String idusuariomodifica) {
		this.idusuariomodifica = idusuariomodifica;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
