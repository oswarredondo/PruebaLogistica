package com.tracusa.logistica.model;

public class CartaPorte {

	String version;
	String transpInternac;
	String entradaSalidaMerc;
	String viaEntradaSalida;
    String totalDistRec;
    Ubicaciones ubicaciones;
    Mercancia mercancia;
    FiguraTransporte figuraTransporte;
    
	public CartaPorte() {
		super();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTranspInternac() {
		return transpInternac;
	}

	public void setTranspInternac(String transpInternac) {
		this.transpInternac = transpInternac;
	}

	public String getEntradaSalidaMerc() {
		return entradaSalidaMerc;
	}

	public void setEntradaSalidaMerc(String entradaSalidaMerc) {
		this.entradaSalidaMerc = entradaSalidaMerc;
	}

	public String getViaEntradaSalida() {
		return viaEntradaSalida;
	}

	public void setViaEntradaSalida(String viaEntradaSalida) {
		this.viaEntradaSalida = viaEntradaSalida;
	}

	public String getTotalDistRec() {
		return totalDistRec;
	}

	public void setTotalDistRec(String totalDistRec) {
		this.totalDistRec = totalDistRec;
	}

	public Ubicaciones getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(Ubicaciones ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public Mercancia getMercancia() {
		return mercancia;
	}

	public void setMercancia(Mercancia mercancia) {
		this.mercancia = mercancia;
	}

	public FiguraTransporte getFiguraTransporte() {
		return figuraTransporte;
	}

	public void setFiguraTransporte(FiguraTransporte figuraTransporte) {
		this.figuraTransporte = figuraTransporte;
	}

}
