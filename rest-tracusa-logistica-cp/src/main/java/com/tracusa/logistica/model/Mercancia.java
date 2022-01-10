package com.tracusa.logistica.model;

public class Mercancia {

	String BienesTransp;
	String ClaveSTCC;
	String Descripcion;
	String Cantidad;
	String ClaveUnidad;
	String Unidad;
	String Dimensiones;
	String MaterialPeligroso;
	String CveMaterialPeligroso;
	String Embalaje;
	String DescripEmbalaje;
	String PesoEnKg;
	String ValorMercancia;
	String Moneda;
	String FraccionArancelaria;
	String UUIDComercioExt;
	CantidadTransporta CantidadTransporta;
	DetalleMercancia DetalleMercancia;
	
	public Mercancia() {
		super();
	}

	public String getBienesTransp() {
		return BienesTransp;
	}

	public void setBienesTransp(String bienesTransp) {
		BienesTransp = bienesTransp;
	}

	public String getClaveSTCC() {
		return ClaveSTCC;
	}

	public void setClaveSTCC(String claveSTCC) {
		ClaveSTCC = claveSTCC;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public String getClaveUnidad() {
		return ClaveUnidad;
	}

	public void setClaveUnidad(String claveUnidad) {
		ClaveUnidad = claveUnidad;
	}

	public String getUnidad() {
		return Unidad;
	}

	public void setUnidad(String unidad) {
		Unidad = unidad;
	}

	public String getDimensiones() {
		return Dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		Dimensiones = dimensiones;
	}

	public String getMaterialPeligroso() {
		return MaterialPeligroso;
	}

	public void setMaterialPeligroso(String materialPeligroso) {
		MaterialPeligroso = materialPeligroso;
	}

	public String getCveMaterialPeligroso() {
		return CveMaterialPeligroso;
	}

	public void setCveMaterialPeligroso(String cveMaterialPeligroso) {
		CveMaterialPeligroso = cveMaterialPeligroso;
	}

	public String getEmbalaje() {
		return Embalaje;
	}

	public void setEmbalaje(String embalaje) {
		Embalaje = embalaje;
	}

	public String getDescripEmbalaje() {
		return DescripEmbalaje;
	}

	public void setDescripEmbalaje(String descripEmbalaje) {
		DescripEmbalaje = descripEmbalaje;
	}

	public String getPesoEnKg() {
		return PesoEnKg;
	}

	public void setPesoEnKg(String pesoEnKg) {
		PesoEnKg = pesoEnKg;
	}

	public String getValorMercancia() {
		return ValorMercancia;
	}

	public void setValorMercancia(String valorMercancia) {
		ValorMercancia = valorMercancia;
	}

	public String getMoneda() {
		return Moneda;
	}

	public void setMoneda(String moneda) {
		Moneda = moneda;
	}

	public String getFraccionArancelaria() {
		return FraccionArancelaria;
	}

	public void setFraccionArancelaria(String fraccionArancelaria) {
		FraccionArancelaria = fraccionArancelaria;
	}

	public String getUUIDComercioExt() {
		return UUIDComercioExt;
	}

	public void setUUIDComercioExt(String uUIDComercioExt) {
		UUIDComercioExt = uUIDComercioExt;
	}

	public CantidadTransporta getCantidadTransporta() {
		return CantidadTransporta;
	}

	public void setCantidadTransporta(CantidadTransporta cantidadTransporta) {
		CantidadTransporta = cantidadTransporta;
	}

	public DetalleMercancia getDetalleMercancia() {
		return DetalleMercancia;
	}

	public void setDetalleMercancia(DetalleMercancia detalleMercancia) {
		DetalleMercancia = detalleMercancia;
	}
}
