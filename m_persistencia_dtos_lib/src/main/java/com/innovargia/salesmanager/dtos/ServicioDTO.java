package com.innovargia.salesmanager.dtos;


public class ServicioDTO {

		
	    private String nombre;
	    private String fechaAlta;
	    private String folio;
	    private String  idservicio;
	    private String  descripcion;
	    private String  tipocobro;
	    private String  descripcion_tipocobro;
	    private String  generaretorno;
	    private String codigoid;
	    private int  identidad=0;
	    private int  idorganizacion=0;
	    private int  estatus;
	    private int  identificador;
	    private int jerarquia;
	    
		/**
		 * @return the jerarquia
		 */
		public int getJerarquia() {
			return jerarquia;
		}
		/**
		 * @param jerarquia the jerarquia to set
		 */
		public void setJerarquia(int jerarquia) {
			this.jerarquia = jerarquia;
		}
		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}
		/**
		 * @param nombre the nombre to set
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		/**
		 * @return the fechaAlta
		 */
		public String getFechaAlta() {
			return fechaAlta;
		}
		/**
		 * @param fechaAlta the fechaAlta to set
		 */
		public void setFechaAlta(String fechaAlta) {
			this.fechaAlta = fechaAlta;
		}
		/**
		 * @return the folio
		 */
		public String getFolio() {
			return folio;
		}
		/**
		 * @param folio the folio to set
		 */
		public void setFolio(String folio) {
			this.folio = folio;
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
		 * @return the descripcion
		 */
		public String getDescripcion() {
			return descripcion;
		}
		/**
		 * @param descripcion the descripcion to set
		 */
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		/**
		 * @return the tipocobro
		 */
		public String getTipocobro() {
			return tipocobro;
		}
		/**
		 * @param tipocobro the tipocobro to set
		 */
		public void setTipocobro(String tipocobro) {
			this.tipocobro = tipocobro;
		}
		/**
		 * @return the generaretorno
		 */
		public String getGeneraretorno() {
			return generaretorno;
		}
		/**
		 * @param generaretorno the generaretorno to set
		 */
		public void setGeneraretorno(String generaretorno) {
			this.generaretorno = generaretorno;
		}
		/**
		 * @return the identidad
		 */
		public int getIdentidad() {
			return identidad;
		}
		/**
		 * @param identidad the identidad to set
		 */
		public void setIdentidad(int identidad) {
			this.identidad = identidad;
		}
		
		/**
		 * @param identidad the identidad to set
		 */
		public void setIdentidad(String identidad) {
			try{
				this.identidad = Integer.parseInt(identidad);
			}catch(Exception e){
				this.identidad = -1;
			}
			
		}
		
		/**
		 * @return the idorganizacion
		 */
		public int getIdorganizacion() {
			return idorganizacion;
		}
		/**
		 * @param idorganizacion the idorganizacion to set
		 */
		public void setIdorganizacion(int idorganizacion) {
			this.idorganizacion = idorganizacion;
		}
		
		/**
		 * @param idorganizacion the identidad to set
		 */
		public void setIdorganizacion(String idorganizacion) {
			try{
				this.idorganizacion = Integer.parseInt(idorganizacion);
			}catch(Exception e){
				this.idorganizacion = -1;
			}
			
		}
		
		/**
		 * @return the estatus
		 */
		public int getEstatus() {
			return estatus;
		}
		/**
		 * @param estatus the estatus to set
		 */
		public void setEstatus(int estatus) {
			this.estatus = estatus;
		}
		/**
		 * @return the identificador
		 */
		public int getIdentificador() {
			return identificador;
		}
		/**
		 * @param identificador the identificador to set
		 */
		public void setIdentificador(int identificador) {
			this.identificador = identificador;
		}
		/**
		 * @return the codigoid
		 */
		public String getCodigoid() {
			return codigoid;
		}
		/**
		 * @param codigoid the codigoid to set
		 */
		public void setCodigoid(String codigoid) {
			this.codigoid = codigoid;
		}
		/**
		 * @return the descripcion_tipocobro
		 */
		public String getDescripcion_tipocobro() {
		    return descripcion_tipocobro;
		}
		/**
		 * @param descripcion_tipocobro the descripcion_tipocobro to set
		 */
		public void setDescripcion_tipocobro(String descripcion_tipocobro) {
		    this.descripcion_tipocobro = descripcion_tipocobro;
		}

}
