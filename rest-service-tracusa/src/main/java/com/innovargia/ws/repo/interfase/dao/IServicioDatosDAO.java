package com.innovargia.ws.repo.interfase.dao;

import java.util.List;

import com.innovargia.ws.tracking.rest.dto.ConsultarTrackingRequest;
import com.innovargia.ws.tracking.rest.dto.Envio;
import com.innovargia.ws.tracking.rest.dto.UsuarioDTO;

public interface IServicioDatosDAO {

	/**
	 * Obtiene la informacion de documento, comparamdo la referencia indicada
	 * 
	 * @param fechaini
	 * @param fechafin
	 * @param referencia
	 * @param tipoDocumento
	 *            si tipo de documento es NULL busca todos los documentos sin
	 *            importar el tipo
	 * @return
	 */
	List<com.innovargia.ws.tracking.rest.dto.Envio> busquedaXReferencia(ConsultarTrackingRequest request,
			String tipoDocumento);

	List<Envio> busquedaArrGuias(ConsultarTrackingRequest request, String guias, String tipoDocumento);

	List<Envio> busquedaFechaCreacionPorCliente(ConsultarTrackingRequest request, String tipoDocumento);

	List<Envio> obtieneDatosDeCasamiento(ConsultarTrackingRequest request, String tipoDocumento);

	List<Envio> buscaArrGuiasMultiples(ConsultarTrackingRequest request, String idguiamadremultiple);
	String obtieneGuiaMadreMultiple(ConsultarTrackingRequest request, String idguiamadremultiple);
	public UsuarioDTO getUsuario(UsuarioDTO usuario) throws Exception ;

}