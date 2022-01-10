package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Any {
    private Cartaportecartaporte cartaportecartaporte;

    @JsonProperty("cartaportecartaporte")
    public Cartaportecartaporte getCartaportecartaporte() { return cartaportecartaporte; }
    @JsonProperty("cartaportecartaporte")
    public void setCartaportecartaporte(Cartaportecartaporte value) { this.cartaportecartaporte = value; }
}
