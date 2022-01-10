package com.tracusa.logistica.model;

public class Carro {

	String TipoCarro;
	String MatriculaCarro;
	String GuiaCarro;
	String ToneladasNetasCarro;
	Contenedor Contenedor;
	
	public Carro() {
		super();
	}

	public String getTipoCarro() {
		return TipoCarro;
	}

	public void setTipoCarro(String tipoCarro) {
		TipoCarro = tipoCarro;
	}

	public String getMatriculaCarro() {
		return MatriculaCarro;
	}

	public void setMatriculaCarro(String matriculaCarro) {
		MatriculaCarro = matriculaCarro;
	}

	public String getGuiaCarro() {
		return GuiaCarro;
	}

	public void setGuiaCarro(String guiaCarro) {
		GuiaCarro = guiaCarro;
	}

	public String getToneladasNetasCarro() {
		return ToneladasNetasCarro;
	}

	public void setToneladasNetasCarro(String toneladasNetasCarro) {
		ToneladasNetasCarro = toneladasNetasCarro;
	}

	public Contenedor getContenedor() {
		return Contenedor;
	}

	public void setContenedor(Contenedor contenedor) {
		Contenedor = contenedor;
	}
}
