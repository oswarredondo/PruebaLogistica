/**
 * 
 */
package com.innovargia.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class LineaFacturaSAP implements Serializable{


	private static final long serialVersionUID = 1L;
	
	int row_number,idsapparametros ;
    String materialsap;
    int  cantidad;
    float importe;
    String unidad, cebe, tdformat1,
    tdline1, tdformat2,tdline2, 
    servicio_nombre, idservicio,numcliente, 
    razonsocial, zonaori,zonades, 
    estatus, marcafactura,p_proceso,p_tipo,p_spart,p_kunnr,p_zterm;
    String  pcorreo ="", pdocumento="G", pnumdocLog="";
    
    
	public int getRow_number() {
		return row_number;
	}
	public void setRow_number(int row_number) {
		this.row_number = row_number;
	}
	public String getMaterialsap() {
		return materialsap;
	}
	public void setMaterialsap(String materialsap) {
		this.materialsap = materialsap;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getCebe() {
		return cebe;
	}
	public void setCebe(String cebe) {
		this.cebe = cebe;
	}
	public String getTdformat1() {
		return tdformat1;
	}
	public void setTdformat1(String tdformat1) {
		this.tdformat1 = tdformat1;
	}
	public String getTdline1() {
		return tdline1;
	}
	public void setTdline1(String tdline1) {
		this.tdline1 = tdline1;
	}
	public String getTdformat2() {
		return tdformat2;
	}
	public void setTdformat2(String tdformat2) {
		this.tdformat2 = tdformat2;
	}
	public String getTdline2() {
		return tdline2;
	}
	public void setTdline2(String tdline2) {
		this.tdline2 = tdline2;
	}
	public String getServicio_nombre() {
		return servicio_nombre;
	}
	public void setServicio_nombre(String servicio_nombre) {
		this.servicio_nombre = servicio_nombre;
	}
	public String getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
	}
	public String getNumcliente() {
		return numcliente;
	}
	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getZonaori() {
		return zonaori;
	}
	public void setZonaori(String zonaori) {
		this.zonaori = zonaori;
	}
	public String getZonades() {
		return zonades;
	}
	public void setZonades(String zonades) {
		this.zonades = zonades;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getMarcafactura() {
		return marcafactura;
	}
	public void setMarcafactura(String marcafactura) {
		this.marcafactura = marcafactura;
	}
	public int getIdsapparametros() {
		return idsapparametros;
	}
	public void setIdsapparametros(int idsapparametros) {
		this.idsapparametros = idsapparametros;
	}
	public String getP_proceso() {
		return p_proceso;
	}
	public void setP_proceso(String p_proceso) {
		this.p_proceso = p_proceso;
	}
	public String getP_tipo() {
		return p_tipo;
	}
	public void setP_tipo(String p_tipo) {
		this.p_tipo = p_tipo;
	}
	public String getP_spart() {
		return p_spart;
	}
	public void setP_spart(String p_spart) {
		this.p_spart = p_spart;
	}
	public String getP_kunnr() {
		return p_kunnr;
	}
	public void setP_kunnr(String p_kunnr) {
		this.p_kunnr = p_kunnr;
	}
	public String getP_zterm() {
		return p_zterm;
	}
	public void setP_zterm(String p_zterm) {
		this.p_zterm = p_zterm;
	}
	public String getPcorreo() {
		return pcorreo;
	}
	public void setPcorreo(String pcorreo) {
		this.pcorreo = pcorreo;
	}
	public String getPdocumento() {
		return pdocumento;
	}
	public void setPdocumento(String pdocumento) {
		this.pdocumento = pdocumento;
	}
	public String getPnumdocLog() {
		return pnumdocLog;
	}
	public void setPnumdocLog(String pnumdocLog) {
		this.pnumdocLog = pnumdocLog;
	}

}
