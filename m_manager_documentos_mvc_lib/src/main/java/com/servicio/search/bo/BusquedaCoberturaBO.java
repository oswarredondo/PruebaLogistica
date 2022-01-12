package com.servicio.search.bo;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.ibo.ICoberturaBO;
import com.administracion.idao.ICPZonaDao;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.rotulacion.dtos.CoberturaEnrutamientoTranladoDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.servicio.dtos.Cobertura;
import com.servicio.search.idao.IBusquedaFrecuenciasDao;
import com.servicio.search.idao.IBusquedaPlazaDAO;
import com.servicio.search.idao.IBusquedaZonaDao;

@Service
public class BusquedaCoberturaBO implements ICoberturaBO {
	
	@Autowired
	IBusquedaZonaDao zonaDao;
	@Autowired
	ICPZonaDao icpZonaDao;
	@Autowired
	IBusquedaFrecuenciasDao frecuenciaDao;
	@Autowired
	IBusquedaPlazaDAO iPlazaDAO;


	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaCoberturaBO.class);

	public BusquedaCoberturaBO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CruceCoberturaDTO getCobertura(CruceCoberturaDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return getCoberturaConvenio(catalogo);
	}
	
	@Override
	public int getSeguro(CruceCoberturaDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return zonaDao.getSeguro(catalogo);
	}
	
    @Override
   	public List<CruceCoberturaDTO> getEnrutamientos(String siglasorigen, String siglasdestino, String garantiamax) throws Exception{
    	Frecuencias origenFrecuencia  = frecuenciaDao.getFrecuenciasEntregaCP(siglasorigen);
		Frecuencias destinoFrecuencia = frecuenciaDao.getFrecuenciasEntregaCP(siglasdestino);
		
    	return zonaDao.getEnrutamientos(origenFrecuencia.getIdterminal(), destinoFrecuencia.getIdterminal(),garantiamax) ;
	}
   	
	private CruceCoberturaDTO getCoberturaConvenio(CruceCoberturaDTO datos) throws Exception{
		
		
		Frecuencias origenFrecuencia = null;
		Frecuencias destinoFrecuencia = null;
		// CruceCoberturaDTO datos_terminal = new CruceCoberturaDTO();
		CruceCoberturaDTO cobertura = new CruceCoberturaDTO();

		List<CoberturaEnrutamientoTranladoDTO> lista_frec_cob = frecuenciaDao.getFrecuenciasOriDesCobertura(
				datos.getIdcoorigen(), datos.getIdcodestino(), datos.getGarantiamax(), null);
		if (lista_frec_cob.size() > 0) {
			origenFrecuencia = lista_frec_cob.get(0).getFrecuencia_origen();
			destinoFrecuencia = lista_frec_cob.get(0).getFrecuencia_destino();
			cobertura = lista_frec_cob.get(0).getCruce_obertura();
			logger.debug("PLaza origen:" + origenFrecuencia.getIdterminal() + ", Plaza Destino:"
					+ destinoFrecuencia.getIdterminal() + ",Garantia:" + datos.getGarantiamax());
			// Busca enrutamientos
			List<CruceCoberturaDTO> lista = zonaDao.getEnrutamientos(origenFrecuencia.getIdterminal(),
					destinoFrecuencia.getIdterminal(), datos.getGarantiamax());
			for (CruceCoberturaDTO cruceCoberturaDTO : lista) {
				logger.debug("Enrutamiento:" + cruceCoberturaDTO.getEnrutamiento());

			}

			if ((lista != null) && (lista.size() > 0)) {
				cobertura.setLista_transbordos(lista);
			}
		}

		return cobertura;
	}
	private CruceCoberturaDTO getCoberturaFolio(CruceCoberturaDTO catalogo) throws Exception{
		return null;
	}

	@Override
	public List<CruceCoberturaDTO> validarConvenioSeguro(String numCliente) throws SQLException {
		
		return zonaDao.validarConvenioSeguro(numCliente);
	}
}
