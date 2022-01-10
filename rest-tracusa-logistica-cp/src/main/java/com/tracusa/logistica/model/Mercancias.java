package com.tracusa.logistica.model;

public class Mercancias {

	String PesoBrutoTotal;
	String UnidadPeso;
	String PesoNetoTotal;
	String NumTotalMercancias;
	String CargoPorTasacion;
	Mercancia Mercancia;
	AutotransporteFederal AutotransporteFederal;	
	TransporteMaritimo TransporteMaritimo;
	TransporteAereo TransporteAereo;
	TransporteFerroviario TransporteFerroviario;
	
	public Mercancias() {
		super();
	}

	public String getPesoBrutoTotal() {
		return PesoBrutoTotal;
	}

	public void setPesoBrutoTotal(String pesoBrutoTotal) {
		PesoBrutoTotal = pesoBrutoTotal;
	}

	public String getUnidadPeso() {
		return UnidadPeso;
	}

	public void setUnidadPeso(String unidadPeso) {
		UnidadPeso = unidadPeso;
	}

	public String getPesoNetoTotal() {
		return PesoNetoTotal;
	}

	public void setPesoNetoTotal(String pesoNetoTotal) {
		PesoNetoTotal = pesoNetoTotal;
	}

	public String getNumTotalMercancias() {
		return NumTotalMercancias;
	}

	public void setNumTotalMercancias(String numTotalMercancias) {
		NumTotalMercancias = numTotalMercancias;
	}

	public String getCargoPorTasacion() {
		return CargoPorTasacion;
	}

	public void setCargoPorTasacion(String cargoPorTasacion) {
		CargoPorTasacion = cargoPorTasacion;
	}

	public Mercancia getMercancia() {
		return Mercancia;
	}

	public void setMercancia(Mercancia mercancia) {
		Mercancia = mercancia;
	}

	public AutotransporteFederal getAutotransporteFederal() {
		return AutotransporteFederal;
	}

	public void setAutotransporteFederal(AutotransporteFederal autotransporteFederal) {
		AutotransporteFederal = autotransporteFederal;
	}

	public TransporteMaritimo getTransporteMaritimo() {
		return TransporteMaritimo;
	}

	public void setTransporteMaritimo(TransporteMaritimo transporteMaritimo) {
		TransporteMaritimo = transporteMaritimo;
	}

	public TransporteAereo getTransporteAereo() {
		return TransporteAereo;
	}

	public void setTransporteAereo(TransporteAereo transporteAereo) {
		TransporteAereo = transporteAereo;
	}

	public TransporteFerroviario getTransporteFerroviario() {
		return TransporteFerroviario;
	}

	public void setTransporteFerroviario(TransporteFerroviario transporteFerroviario) {
		TransporteFerroviario = transporteFerroviario;
	}
	
}
