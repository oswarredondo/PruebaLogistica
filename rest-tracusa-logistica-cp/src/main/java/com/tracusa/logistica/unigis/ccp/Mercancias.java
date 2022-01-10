package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Mercancias {
    private Mercancia[] mercancia;
    private AutotransporteFederal autotransporteFederal;
    private long numTotalMercancias;
    private long totalValorMercancias;

    @JsonProperty("Mercancia")
    public Mercancia[] getMercancia() { return mercancia; }
    @JsonProperty("Mercancia")
    public void setMercancia(Mercancia[] value) { this.mercancia = value; }

    @JsonProperty("AutotransporteFederal")
    public AutotransporteFederal getAutotransporteFederal() { return autotransporteFederal; }
    @JsonProperty("AutotransporteFederal")
    public void setAutotransporteFederal(AutotransporteFederal value) { this.autotransporteFederal = value; }

    @JsonProperty("NumTotalMercancias")
    public long getNumTotalMercancias() { return numTotalMercancias; }
    @JsonProperty("NumTotalMercancias")
    public void setNumTotalMercancias(long value) { this.numTotalMercancias = value; }

    @JsonProperty("TotalValorMercancias")
    public long getTotalValorMercancias() { return totalValorMercancias; }
    @JsonProperty("TotalValorMercancias")
    public void setTotalValorMercancias(long value) { this.totalValorMercancias = value; }
}
