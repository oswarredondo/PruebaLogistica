package com.innovargia.utils;

import java.util.ArrayList;
import java.util.List;

import com.innovargia.model.DetalleEnvio;
import com.innovargia.model.Direccion;
import com.innovargia.model.GuiaEmbarque;
import com.innovargia.model.Paquete;

public class TestFile {

	public static void main(String[] args) {
		GuiaEmbarque guia = new GuiaEmbarque();
		
		guia.setLogin("ENTADS");
		guia.setPassword("ENTADS");
		guia.setIdservicio("D01");
		guia.setReferencia("ESTA ES LA REFERENCIA");
		guia.setObservaciones("Observaciones");
		
		Direccion remitente= new Direccion();
		remitente.setCalle("CALLE REM");
		remitente.setCiudad("CIUDAD REM");
		remitente.setClaveCliente("");
		remitente.setCodigoPostal("09230");
		remitente.setColonia("COL REM");
		remitente.setContacto("AMR");
		remitente.setConvenio("");
		remitente.setEntreCalles("NINGUNA");
		remitente.setEstado("CDMX");
		remitente.setEstado("MEXICO");
		remitente.setNumexterior("11");
		remitente.setNuminterior("22");
		remitente.setPais("MEX");
		remitente.setRazonsocial("RASOC MEX");
		remitente.setReferencia("ESTA ES LA REFERENCIA");
		remitente.setTelefono("TELEFONO");
		
		guia.setRemitente(remitente);
		
		Direccion destinatario = new Direccion();
		destinatario.setCalle("CALLE DES");
		destinatario.setCiudad("CIUDAD DES");
		destinatario.setClaveCliente("");
		destinatario.setCodigoPostal("09230");
		destinatario.setColonia("COL DES");
		destinatario.setContacto("AMR  DES");
		destinatario.setConvenio("");
		destinatario.setEntreCalles("NINGUNA  DES");
		destinatario.setEstado("CDMX");
		destinatario.setEstado("MEXICO  DES");
		destinatario.setNumexterior("11");
		destinatario.setNuminterior("22");
		destinatario.setPais("MEX");
		destinatario.setRazonsocial("RASOC DES"  );
		destinatario.setReferencia("ESTA ES LA REFERENCIA  DES");
		destinatario.setTelefono("TELEFONO DES");
		guia.setDestinatario(destinatario);
		
		
		DetalleEnvio detalleEnvio = new DetalleEnvio();
		guia.setDetalleEnvio(detalleEnvio);
		
	
		List<Paquete>  paquetes = new ArrayList<Paquete>();
		Paquete paqute = new Paquete();
		paqute.setCantidad(2);
		paqute.setDescripcionMercancia("Zapatos");
		paqute.setPeso(4.50f);
		paqute.setTipoMercancia("ALGO");
		paqute.setValor(8909.9f);
		paqute.setVolumen(23.5f);
		paqute.setAsegurarlo(true);
		paqute.setEsmultiple(true);
		paquetes.add(paqute);
		guia.setPaquete(paqute);
		
		System.out.println(UtilsJson.getJson(guia)); 


	}

}
