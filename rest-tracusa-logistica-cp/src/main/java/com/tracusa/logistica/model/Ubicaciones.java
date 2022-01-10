package com.tracusa.logistica.model;

public class Ubicaciones {

	Ubicacion Ubicacion;
	Mercancias Mercancias;
	FiguraTransporte FiguraTransporte;
	
	public Ubicaciones() {
		super();
	}

	public Ubicacion getUbicacion() {
		return Ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		Ubicacion = ubicacion;
	}

	public Mercancias getMercancias() {
		return Mercancias;
	}

	public void setMercancias(Mercancias mercancias) {
		Mercancias = mercancias;
	}

	public FiguraTransporte getFiguraTransporte() {
		return FiguraTransporte;
	}

	public void setFiguraTransporte(FiguraTransporte figuraTransporte) {
		FiguraTransporte = figuraTransporte;
	}
}
