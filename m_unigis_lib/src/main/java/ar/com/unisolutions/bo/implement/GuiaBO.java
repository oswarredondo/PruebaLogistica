package ar.com.unisolutions.bo.implement;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.idao.IParamsSistemaDAO;

import ar.com.unisolutions.ConsultarOrdenesPedidoRequest;
import ar.com.unisolutions.PEstadoOrdenPedido;
import ar.com.unisolutions.POrdenPedido;
import ar.com.unisolutions.ServiceLocator;
import ar.com.unisolutions.ServiceSoap;
import ar.com.unisolutions.bo.IGuiaBO;
import ar.com.unisolutions.dto.Delivery;
import ar.com.unisolutions.dto.Guide;

@Service
public class GuiaBO implements IGuiaBO {

    @Autowired
    IParamsSistemaDAO iParamsSistemaDAO;

    @Override
    public int cambiarEstadoGuia(PEstadoOrdenPedido estadoOrdenPedido) throws Exception {

	try {

	    // UNIGIS CAMBIAR ESTADO

	    java.net.URL portAddress;

	    portAddress = new java.net.URL(iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS"));

	    String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");
	    
	    ServiceLocator locator = new ServiceLocator();

	    ServiceSoap proxy = locator.getServiceSoap(portAddress);

	    int result = proxy.modificarEstadoOrdenPedido(apiKey, estadoOrdenPedido);

	    return result;

	} catch (RemoteException e) {

	    throw new Exception("Error - Guide Status Modification[" + estadoOrdenPedido.getRefDocumento() + "].");

	}
    }

    @Override
    public ArrayList<Guide> ConsultarOrdenPedido(String guias) throws Exception {

	ArrayList<Guide> lstGuide = new ArrayList<>();

	try {
	    
	    java.net.URL portAddress;

	    portAddress = new java.net.URL(iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS"));

	    String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");
	    
	    ServiceLocator locator = new ServiceLocator();

	    ServiceSoap proxy = locator.getServiceSoap(portAddress);

	    ConsultarOrdenesPedidoRequest ordenesPedidoRequest = new ConsultarOrdenesPedidoRequest();
	    
	    ordenesPedidoRequest.setReferenciaExterna(guias);
	    ordenesPedidoRequest.setApiKey(apiKey);
	    
	    POrdenPedido[] pedidoResponse = proxy.consultarOrdenesPedido(ordenesPedidoRequest);	 

	    if (pedidoResponse.length > 0 ) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Guide guide = new Guide();

		if (pedidoResponse[0].getEstadoDetalle() != null) {

		    guide.setIdGuide(pedidoResponse[0].getRefDocumento());
		    guide.setReference(pedidoResponse[0].getRefDocumentoAdicional());
		    guide.setObservations(pedidoResponse[0].getObservaciones());
		    guide.setTypeMovement(pedidoResponse[0].getEstadoDetalle().getEstado());
		    guide.setDate(dateFormat.format(pedidoResponse[0].getEstadoDetalle().getEstadoFecha().getTime()));
		    guide.setDescription(pedidoResponse[0].getItems()[0].getDescripcion());

		    lstGuide.add(guide);

		}

	    }

	    return lstGuide;

	} catch (RemoteException e) {

	    throw new Exception("Error when consulting guides." );

	}
    }

    @Override
    public ArrayList<Guide> getShipmentTracking(String guias) throws Exception {
	
	ArrayList<Guide> lstGuide = new ArrayList<>();

	try {
	    
	    java.net.URL portAddress;

	    portAddress = new java.net.URL(iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS"));

	    String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");
	    
	    ServiceLocator locator = new ServiceLocator();

	    ServiceSoap proxy = locator.getServiceSoap(portAddress);
	    
	    String[] arrayGuias = guias.split(",");
	    
	    for(int i = 0; i <= arrayGuias.length - 1; i++) {
		
		 POrdenPedido pedidoResponse = proxy.consultarOrdenPedido(apiKey, arrayGuias[i]);
		 
		 if(pedidoResponse != null) {
		     
			 Guide guide = new Guide();
			 
			 guide.setIdGuide(pedidoResponse.getRefDocumento());
			 guide.setReference(pedidoResponse.getRefDocumentoAdicional());
			 guide.setObservations(pedidoResponse.getObservaciones());
			 
			 Delivery delivery = new Delivery();
			 
			 delivery.setId(pedidoResponse.getRefDocumento());
			 delivery.setEstimatedDate("");
			 delivery.setSuccess(pedidoResponse.getEstadoDetalle().getEstado().equals("ENTREGADO") ? true : false);
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);  
			 String strDate = dateFormat.format(pedidoResponse.getEstadoDetalle().getEstadoFecha().getTime());  
			 delivery.setDeliveryDate(pedidoResponse.getEstadoDetalle().getEstado().equals("ENTREGADO") ? strDate : "");
			 delivery.setRoute("");
			 delivery.setSignedBy("");
			 delivery.setLatitude(pedidoResponse.getLatitud());
			 delivery.setLongitude(pedidoResponse.getLongitud());
			 delivery.setSignatureDate("");
			 delivery.setSignature(false);
			 delivery.setImageSignature("");
			 
			 guide.setDelivery(delivery);
			 
			 ArrayList<ar.com.unisolutions.dto.Tracker> lsTrackers = new ArrayList<>();
			 
			 for(int j = pedidoResponse.getEstadosPedido().length - 1; j >= 0; j--) {
			     
			     ar.com.unisolutions.dto.Tracker tracker = new ar.com.unisolutions.dto.Tracker();
			     
			     tracker.setId(guide.getIdGuide());
			     
			     strDate = dateFormat.format(pedidoResponse.getEstadosPedido()[j].getFechaCreacion().getTime());  
			     
			     tracker.setDate(strDate);		     
			     tracker.setTypeMovement(pedidoResponse.getEstadosPedido()[j].getDescripcion());
			     tracker.setCode("");
			     tracker.setPlace("");
			     tracker.setPlace("MEX");
			     tracker.setDestination("");
			     tracker.setRemitter("");
			     
			     lsTrackers.add(tracker);
			     
			 }
			 
			 guide.setTracker(lsTrackers);
			
			 lstGuide.add(guide);
			 
		 }

	    }

	    return lstGuide;

	} catch (RemoteException e) {

	    throw new Exception("Error when consulting guides.");

	}
    }

}