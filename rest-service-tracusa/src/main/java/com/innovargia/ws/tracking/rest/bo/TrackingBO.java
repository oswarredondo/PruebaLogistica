package com.innovargia.ws.tracking.rest.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.administracion.ibo.IAdminPasswordBO;
import com.innovargia.administracion.ibo.IUsuarioBO;
import com.innovargia.model.Confirmacion;
import com.innovargia.model.Firma;
import com.innovargia.model.Historia;
import com.innovargia.model.RequestTracking;
import com.innovargia.model.ResponseTracking;
import com.innovargia.model.ResponseTrackingSign;
import com.innovargia.utils.UtilsStrings;
import com.innovargia.ws.repo.interfase.bo.IDocumentoBO;
import com.innovargia.ws.repo.interfase.bo.ITrackingBO;
import com.innovargia.ws.tracking.rest.dto.ConsultarTrackingRequest;
import com.innovargia.ws.tracking.rest.dto.Envio;
import com.innovargia.ws.tracking.rest.dto.Movimiento;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.ws.tracking.rest.utils.Constantes;
import com.innovargia.ws.tracking.rest.utils.ExceptionTracking;

@Service
public class TrackingBO implements ITrackingBO {
	private static final Logger logger = LoggerFactory.getLogger(TrackingBO.class);

	@Autowired
	IDocumentoBO documentoBO;

	@Autowired
	IUsuarioBO iusuarioBO;
	
	@Autowired
	IAdminPasswordBO iAdminPasswordBO;

	/* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.bo.ITrackingBO#tracking(com.innovargia.model.RequestTracking)
	 */
	@Override
	public ResponseTracking tracking(RequestTracking request) throws ExceptionTracking {
		// Valida los datos del usuario
		try {

			UsuarioDTO usuario = isValidUser(request);
			// Realiza la busqueda
			if (usuario != null) {
				// Busca datos de la guia
				ConsultarTrackingRequest consulta = new ConsultarTrackingRequest();
				String[] arr_guias = new String[1];
				arr_guias[0] = request.getNumeroguia();
				consulta.setArr_guias(arr_guias);
				consulta.setBuscaFirma(true);
				consulta.setMuestrarTodalaHistoria(true);
				consulta.setObtenerHistoria(true);
				consulta.setCliente(request.getNumcliente());
				
				List<Envio> lista = documentoBO.busquedaArrGuias(consulta, "ETIQU");
				ResponseTracking response = mapeaResponse(lista, consulta);
				ObjectMapper mapper = new ObjectMapper();
				String jsonInString;
				try {
					jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
					logger.debug(jsonInString);
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return response;

			} else {
				throw new ExceptionTracking(Constantes.ACCESOINVALIDO_MSG, Constantes.CODIGO_ACCESOINVALIDO);
			}

		} catch (ExceptionTracking e) {
			throw new ExceptionTracking(e.getMessage(), e.getCodigo());
		} catch (Exception e) {
			throw new ExceptionTracking(e.getMessage(), Constantes.CODIGO_ERROR_SISTEMA);
		}

	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.bo.ITrackingBO#sign(com.innovargia.model.RequestTracking)
	 */
	@Override
	public ResponseTrackingSign sign(RequestTracking request) throws ExceptionTracking {
		// Valida los datos del usuario
		try {

			UsuarioDTO usuario = isValidUser(request);
			// Realiza la busqueda
			if (usuario != null) {
				// Busca datos de la guia
				ConsultarTrackingRequest consulta = new ConsultarTrackingRequest();
				String[] arr_guias = new String[1];
				arr_guias[0] = request.getNumeroguia();
				consulta.setArr_guias(arr_guias);
				consulta.setBuscaFirma(true);
				consulta.setMuestrarTodalaHistoria(false);
				consulta.setObtenerHistoria(false);
				consulta.setCliente(request.getNumcliente());

				List<Envio> lista = documentoBO.busquedaArrGuias(consulta, "ETIQU");
				ResponseTrackingSign response = mapeaResponseSign(lista, consulta);
				return response;

			} else {
				throw new ExceptionTracking(Constantes.ACCESOINVALIDO_MSG, Constantes.CODIGO_ACCESOINVALIDO);
			}

		} catch (ExceptionTracking e) {
			throw new ExceptionTracking(e.getMessage(), e.getCodigo());
		} catch (Exception e) {
			throw new ExceptionTracking(e.getMessage(), Constantes.CODIGO_ERROR_SISTEMA);
		}

	}

	private UsuarioDTO isValidUser(RequestTracking request) throws Exception {
		
		UsuarioDTO usuario = new UsuarioDTO();
	 	usuario.setLogin(UtilsStrings.nullChangeToUpperCase(request.getUsuario()));
	 	usuario.setPassword(request.getContrasena());
		boolean existeUsuario = iAdminPasswordBO.existeLoginPass(usuario.getLogin(), 
				usuario.getPassword());
		
		if (!existeUsuario) {
			throw new ExceptionTracking(Constantes.CODIGO_ACCESOINVALIDO,
					Constantes.ACCESOINVALIDO_MSG);
		}

		com.innovargia.salesmanager.dtos.UsuarioDTO user = iusuarioBO.getUsuarioLogin(usuario); 
		request.setNumcliente(request.getNumcliente() == null ? "" : request.getNumcliente());
		if (!request.getNumcliente().equals(user.getNumCliente())) {
			throw new ExceptionTracking(Constantes.CODIGO_ACCESOINVALIDO, Constantes.ACCESOINVALIDO_MSG);
		}
		return usuario;
	}

	private ResponseTracking mapeaResponse(List<Envio> lista, ConsultarTrackingRequest consulta) {

		ResponseTracking response = new ResponseTracking();

		Confirmacion confimacion;
		List<Historia> arr_historia = new ArrayList<Historia>();
		Historia historia = null;

		for (Envio envio : lista) {
			response.setNumeroguia(envio.getIdguia());
			// Confirmacion
			if (envio.getEntrega() != null) {
				confimacion = new Confirmacion();
				confimacion.setQuienrecibe(envio.getEntrega().getQuienRecibe());
				confimacion.setFecha(envio.getEntrega().getFecha());
				confimacion.setLatitud(envio.getEntrega().getLatitud());
				confimacion.setLongitud(envio.getEntrega().getLongitud());

				// Solo indica si la guia tiene firma
				if (envio.getEntrega().getFirma() != null && envio.getEntrega().getFirma().getImaBase64()!=null
						&& !envio.getEntrega().getFirma().getImaBase64().isEmpty()) {
					confimacion.setTienefirma(true);
				} else {
					confimacion.setTienefirma(false);
				}
				response.setConfimacion(confimacion);
			}
			// Historia
			if (envio.getMovimientos() != null && envio.getMovimientos().size() > 0) {

				for (Movimiento movimiento : envio.getMovimientos()) {
					historia = new Historia();
					historia.setFecha(movimiento.getFecha());
					historia.setTipomovimiento(movimiento.getTipoMovimiento());
					historia.setPlaza(movimiento.getPlaza());
					historia.setClave(movimiento.getIdclavelog());
					historia.setDescripcioncve(movimiento.getCveLog());
					arr_historia.add(historia);
				}
				response.setHistoria(arr_historia);
			}

		}
		// Verifica si existe info de la guia solicitada
		if (response.getConfimacion() == null && response.getHistoria().size() <= 0) {
			response.setCodigo(Constantes.CODIGO_NO_EXISTE_GUIA);
			response.setMensaje(Constantes.MSG_NO_EXISTE_INFO);
		} else {
			response.setCodigo(Constantes.CODIGO_EXITO);
			response.setMensaje(Constantes.MSG_EXITO);
		}

		return response;

	}

	private ResponseTrackingSign mapeaResponseSign(List<Envio> lista, ConsultarTrackingRequest consulta) {

		ResponseTrackingSign response = new ResponseTrackingSign();

		Firma confimacion;

		for (Envio envio : lista) {
			response.setNumeroguia(envio.getIdguia());
			// Confirmacion
			if (envio.getEntrega() != null) {
				confimacion = new Firma();
				confimacion.setQuienrecibe(envio.getEntrega().getQuienRecibe());
				confimacion.setFecha(envio.getEntrega().getFecha());
				confimacion.setLatitud(envio.getEntrega().getLatitud());
				confimacion.setLongitud(envio.getEntrega().getLongitud());
				if (envio.getEntrega().getFirma() != null && envio.getEntrega().getFirma().getImaBase64()!=null
						&& !envio.getEntrega().getFirma().getImaBase64().isEmpty()) {
					confimacion.setBase64firma(envio.getEntrega().getFirma().getImaBase64());
					confimacion.setExtension(".png");
					confimacion.setTienefirma(true);
				}
				
				response.setConfimacion(confimacion);
			}
			

		}
		// Verifica si existe info de la guia solicitada
		if (response.getConfimacion()==null) {
			response.setCodigo(Constantes.CODIGO_NO_EXISTE_GUIA);
			response.setMensaje(Constantes.MSG_NO_EXISTE_INFO);
		} else {
			response.setCodigo(Constantes.CODIGO_EXITO);
			response.setMensaje(Constantes.MSG_EXITO);
		}

		return response;

	}

}
