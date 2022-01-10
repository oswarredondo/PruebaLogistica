package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class IdentificacionVehicular {
    private String configVehicular;
    private String placaVM;
    private String anioModeloVM;
    private Remolque[] remolques;

    @JsonProperty("ConfigVehicular")
    public String getConfigVehicular() { return configVehicular; }
    @JsonProperty("ConfigVehicular")
    public void setConfigVehicular(String value) { this.configVehicular = value; }

    @JsonProperty("PlacaVM")
    public String getPlacaVM() { return placaVM; }
    @JsonProperty("PlacaVM")
    public void setPlacaVM(String value) { this.placaVM = value; }

    @JsonProperty("AnioModeloVM")
    public String getAnioModeloVM() { return anioModeloVM; }
    @JsonProperty("AnioModeloVM")
    public void setAnioModeloVM(String value) { this.anioModeloVM = value; }

    @JsonProperty("Remolques")
    public Remolque[] getRemolques() { return remolques; }
    @JsonProperty("Remolques")
    public void setRemolques(Remolque[] value) { this.remolques = value; }
}
