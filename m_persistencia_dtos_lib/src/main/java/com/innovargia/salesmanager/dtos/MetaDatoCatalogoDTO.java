/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class MetaDatoCatalogoDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String select;
	private String update;
	private String delete;
	private String insert;
	private int id;
	private String nombre;
	private String claseDispatch;
	private String tabla;
	private String formatoiReport;
	private String idTipoDocumento;
	private int largoConsecutivo;
	
	/**
	 * 
	 */
	public MetaDatoCatalogoDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClaseDispatch() {
		return claseDispatch;
	}

	public void setClaseDispatch(String claseDispatch) {
		this.claseDispatch = claseDispatch;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getFormatoiReport() {
		return formatoiReport;
	}

	public void setFormatoiReport(String formatoiReport) {
		this.formatoiReport = formatoiReport;
	}

	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public int getLargoConsecutivo() {
		return largoConsecutivo;
	}

	public void setLargoConsecutivo(int largoConsecutivo) {
		this.largoConsecutivo = largoConsecutivo;
	}

}
