package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Complemento {
    private Any[] any;

    @JsonProperty("Any")
    public Any[] getAny() { return any; }
    @JsonProperty("Any")
    public void setAny(Any[] value) { this.any = value; }
}
