package com.tracusa.logistica.model;

public class IdentificacionVehicular {

	String ConfigVehicular;
	String PlacaVM;
	String AnioModeloVM;
	Remolques Remolques;
	
	public IdentificacionVehicular() {
		super();
	}

	public String getConfigVehicular() {
		return ConfigVehicular;
	}

	public void setConfigVehicular(String configVehicular) {
		ConfigVehicular = configVehicular;
	}

	public String getPlacaVM() {
		return PlacaVM;
	}

	public void setPlacaVM(String placaVM) {
		PlacaVM = placaVM;
	}

	public String getAnioModeloVM() {
		return AnioModeloVM;
	}

	public void setAnioModeloVM(String anioModeloVM) {
		AnioModeloVM = anioModeloVM;
	}

	public Remolques getRemolques() {
		return Remolques;
	}

	public void setRemolques(Remolques remolques) {
		Remolques = remolques;
	}
	
}
