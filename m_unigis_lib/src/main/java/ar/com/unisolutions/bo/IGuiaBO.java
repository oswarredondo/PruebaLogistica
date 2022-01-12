package ar.com.unisolutions.bo;

import java.util.ArrayList;

import ar.com.unisolutions.PEstadoOrdenPedido;
import ar.com.unisolutions.dto.Guide;

public interface IGuiaBO {

	int cambiarEstadoGuia(PEstadoOrdenPedido estadoOrdenPedido) throws Exception;

	ArrayList<Guide> ConsultarOrdenPedido(String guias) throws Exception;
	
	ArrayList<Guide> getShipmentTracking(String guias) throws Exception;
}
