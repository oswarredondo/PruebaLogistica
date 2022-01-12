/**
 * 
 */
package com.innovargia.ws.tracking.rest.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.utils.ArrayElementos;
import com.innovargia.ws.repo.interfase.bo.IDocumentoBO;
import com.innovargia.ws.repo.interfase.dao.IFirmaEvidenciaDao;
import com.innovargia.ws.repo.interfase.dao.IHistoriaDao;
import com.innovargia.ws.repo.interfase.dao.IServicioDatosDAO;
import com.innovargia.ws.tracking.rest.dto.ConsultarTrackingRequest;
import com.innovargia.ws.tracking.rest.dto.Envio;
import com.innovargia.ws.tracking.rest.dto.FirmaFoto;

@Service
public class DocumentoBO implements IDocumentoBO {
	@Autowired
	IServicioDatosDAO documentoDao;
	@Autowired
	IFirmaEvidenciaDao firmaEvidenciaDao;
	@Autowired
	IHistoriaDao historiaDao;

	private static final Logger logger = LoggerFactory.getLogger(DocumentoBO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.tracking.rest.bo.impl.IDocumentoBO#busquedaArrGuias(com
	 * .consulta.ws.tracking.dto.ConsultarTrackingRequest, java.lang.String)
	 */
	@Override
	public List<Envio> busquedaArrGuias(ConsultarTrackingRequest request, String tipoDocumento) throws Exception {

		String guias = ArrayElementos.formateaArregloCadenaComillas(request.getArr_guias());
		List<Envio> lista = documentoDao.busquedaArrGuias(request, guias, tipoDocumento);
		List<Envio> lista_final = new ArrayList<Envio>();
		HashMap<String, Envio> map = new HashMap<String, Envio>();

		for (Envio envio : lista) {
			map.put(envio.getIdguia(), envio);
		}
		Envio envio_my = null;
		try {
			for (String guia : request.getArr_guias()) {
				if (map.containsKey(guia)) {

					lista_final.add(map.get(guia));
				} else {
					envio_my = new Envio();
					envio_my.setEstatus("NO REGISTRADO");
					envio_my.setIdguia(guia);
					lista_final.add(envio_my);
				}
			}
		} catch (Exception e) {
			logger.debug("Error consulta:" + e.getMessage());
		}

		// Busca historia
		getHitoria(lista_final, request);
		// Busca Firma
		return getFirma(lista_final, request);
	}

	private List<Envio> getFirma(List<Envio> listaguias, ConsultarTrackingRequest request) throws Exception {
		List<Envio> guias = new ArrayList<Envio>();
		for (Envio envio : listaguias) {

			if (request.isBuscaFirma()) {
				//Solo si tiene entrega
				if (envio.getEntrega()!=null){
					FirmaFoto obj = firmaEvidenciaDao.getFirmaEntrega(envio.getIdguia());
					if (obj != null) {
							envio.getEntrega().setFirma(obj);
					}
				}
			}

			guias.add(envio);
		}

		return guias;
	}

	private List<Envio> getHitoria(List<Envio> listaguias, ConsultarTrackingRequest request) throws Exception {

		List<Envio> guias = new ArrayList<Envio>();
		for (Envio envio : listaguias) {
			if (request.isObtenerHistoria()) {
				
				if (!request.isMuestrarTodalaHistoria()) {
					envio.setMovimientos(historiaDao.getUltimoRegistroHistoria(envio.getIdguia()));
				} else {
					// Agrega el ultimo regisro de historia
					envio.setMovimientos(historiaDao.getHistoria(envio.getIdguia()));
				}
			}
			guias.add(envio);
		}
		return guias;

	}

}
