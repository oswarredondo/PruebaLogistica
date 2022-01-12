/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO;
import com.innovargia.salesmanager.ibo.ILogMovimientosProcesadosBO;
import com.innovargia.salesmanager.idao.ILogMovimientosProcesadosDAO;
import com.innovargia.utils.UtilsStrings;
import com.servicio.dtos.ManifiestoDTO;

/**
 * @author aruaro
 * 
 */
@Service
public class LogMovimientosProcesadosBO implements ILogMovimientosProcesadosBO {

	private static final Logger logger = LoggerFactory.getLogger(LogMovimientosProcesadosBO.class);

	@Autowired
	ILogMovimientosProcesadosDAO iLogMovimientosProcesadosDAO;

	public LogMovimientosProcesadosBO() {
	}

	@Override
	public void update(LogMovimientoProcesadoDTO obj, String exclude_guias) throws Exception {
		String guias = UtilsStrings.formateaCadenaComillas(exclude_guias);
		String plazas = UtilsStrings.formateaCadenaComillas(obj.getPlazaenvia());
		if ("03".equals(obj.getTipomovimiento())) {
			iLogMovimientosProcesadosDAO.updateMovLocal(obj, guias);
		} else if ("21".equals(obj.getTipomovimiento())) {
			iLogMovimientosProcesadosDAO.updateRecoleccion(obj, exclude_guias, plazas);
		} else {
			iLogMovimientosProcesadosDAO.update(obj, guias);
		}

	}

	@Override
	public void updateMovLocal(LogMovimientoProcesadoDTO obj, String exclude_guias) throws Exception {

		String guias = UtilsStrings.formateaCadenaComillas(exclude_guias);

		iLogMovimientosProcesadosDAO.updateMovLocal(obj, guias);

	}

	@Override
	public void delete(LogMovimientoProcesadoDTO obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<LogMovimientoProcesadoDTO> getRegistros(LogMovimientoProcesadoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getRegistrosProcesados(obj);
	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesPlazaRegistro(String plaza) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getTotalesPlazaRegistro(plaza);
	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesTipoErroreProcesados(String plaza) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getTotalesTipoErroreProcesados(plaza);
	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesViajeSalidas(String plaza, String tipotranslado) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getViajeSalidas(plaza, tipotranslado);
	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesViajeRutaSalidas(String viaje, String tipotranslado, String plaza)
			throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getTotalesViajeRutaSalidas(viaje, tipotranslado, plaza);
	}

	@Override
	public List<LogMovimientoProcesadoDTO> getViajesEntradas(String tipotranslado, String plaza, String tiporegistro)
			throws Exception {

		// Verifica que tipo de datos necesita
		if (tiporegistro != null) {
			if ("01".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getViajesEntradas(plaza, tipotranslado);
			} else if ("02".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getViajeSalidas(plaza, tipotranslado);
			} else if ("03".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getTotalesRutaMovLocal(plaza);
			} else if ("21".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getTotalesRutaRecolecciones(plaza, "");
			} else if ("VC".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getViajeCorrida(tipotranslado);
			}

		}
		return new ArrayList<LogMovimientoProcesadoDTO>();

	}

	@Override
	public List<LogMovimientoProcesadoDTO> getPlazas(String tipotranslado, String plaza, String tiporegistro)
			throws Exception {

		// Verifica que tipo de datos necesita
		if (tiporegistro != null) {
			if ("01".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getPlazaProcesaEntrada(plaza, tipotranslado);
			} else if ("02".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getPlazaProcesaSalidas(plaza, tipotranslado);
			} else if ("03".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getPlazaProcesaMovimientoLocal(plaza, tipotranslado);
			} else if ("21".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getPlazaProcesaRecoleciones(plaza, tipotranslado);
			}
		}
		return new ArrayList<LogMovimientoProcesadoDTO>();

	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesViajeRutaEntradas(String viaje, String tipotranslado, String plaza,
			String tiporegistro) throws Exception {
		// Verifica que tipo de datos necesita
		if (tiporegistro != null) {
			if ("01".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getTotalesViajeRutaEntradas(viaje, tipotranslado, plaza);
			} else if ("02".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getTotalesViajeRutaSalidas(viaje, tipotranslado, plaza);
			} else if ("03".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getTotalesRutaDeptoMovLocal(plaza, viaje);
			} else if ("21".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getTotalesRutaRecolecciones(plaza, viaje);

			}

		}
		return new ArrayList<LogMovimientoProcesadoDTO>();

	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesViajeMovLocal() throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getTotalesViajeMovLocal();
	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesViajeRutaMovLocal(String plaza) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getTotalesRutaMovLocal(plaza);
	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesViajeRutaDeptoMovLocal(String plaza, String ruta)
			throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getTotalesRutaDeptoMovLocal(plaza, ruta);
	}

	@Override
	public LogHistoriaDTO get(LogHistoriaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEstatus(LogHistoriaDTO obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalPorTipoRegistro(String plaza) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getTotalPorTipoRegistro(plaza);
	}

	@Override
	public List<LogMovimientoProcesadoDTO> getTotalesPorPlaza(String plaza) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getTotalesPorPlaza(plaza);
	}

	@Override
	public List<LogHistoriaDTO> getGuiasViajeRutaEntradas(String viaje, String ruta, String tipotranslado,
			boolean verSoloLasNoManifiestadas, String plaza, String tiporegistro) throws Exception {
		
		if (tiporegistro != null) {
			if (("01".equals(tiporegistro)) || ("1".equals(tiporegistro))) {
				return iLogMovimientosProcesadosDAO.getGuiasViajeRutaEntradas(viaje, ruta, tipotranslado,
						verSoloLasNoManifiestadas, plaza);

			} else if (("02".equals(tiporegistro)) || ("2".equals(tiporegistro))) {
				return iLogMovimientosProcesadosDAO.getGuiasViajeRutaSalidas(viaje, ruta, tipotranslado,
						verSoloLasNoManifiestadas, plaza);

			} else if (("03".equals(tiporegistro)) || ("3".equals(tiporegistro))) {

				return iLogMovimientosProcesadosDAO.getGuiasMovimientoLocal(viaje, ruta, verSoloLasNoManifiestadas,
						plaza);
			} else if ("21".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getGuiasRecolecciones(viaje, ruta, verSoloLasNoManifiestadas,
						plaza);
			} else if ("FX".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getGuiasPosiblesManifiestoFXC(viaje);
			}

		}
		return new ArrayList<LogHistoriaDTO>();

	}
	
	@Override
	public List<LogHistoriaDTO> getGuiasViajeRutaEntradasMadre(String viaje, String ruta, String tipotranslado,
			boolean verSoloLasNoManifiestadas, String plaza, String tiporegistro, String idMadre) throws Exception {
		
		if (tiporegistro != null) {
			if (("01".equals(tiporegistro)) || ("1".equals(tiporegistro))) {
				return iLogMovimientosProcesadosDAO.getGuiasViajeRutaEntradasMadre(viaje, ruta, tipotranslado,
						verSoloLasNoManifiestadas, plaza, idMadre);

			} else if (("02".equals(tiporegistro)) || ("2".equals(tiporegistro))) {
				return iLogMovimientosProcesadosDAO.getGuiasViajeRutaSalidasMadre(viaje, ruta, tipotranslado,
						verSoloLasNoManifiestadas, plaza, idMadre);

			} else if (("03".equals(tiporegistro)) || ("3".equals(tiporegistro))) {

				return iLogMovimientosProcesadosDAO.getGuiasMovimientoLocalMadre(viaje, ruta, verSoloLasNoManifiestadas,
						plaza, idMadre);
			} else if ("21".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getGuiasRecoleccionesMadre(viaje, ruta, verSoloLasNoManifiestadas,
						plaza,idMadre);
			} else if ("FX".equals(tiporegistro)) {
				return iLogMovimientosProcesadosDAO.getGuiasPosiblesManifiestoFXC(viaje);
			}

		}
		return new ArrayList<LogHistoriaDTO>();

	}

	@Override
	public int insertManifiestoMovimiento(ManifiestoDTO manifiesto) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.insertManifiestoMovimiento(manifiesto);
	}

	@Override
	public List<LogHistoriaDTO> getGuiasManifiesto(String manifiesto) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getGuiasManifiesto(manifiesto);
	}

	@Override
	public void deleteManifiesto(LogMovimientoProcesadoDTO obj) throws Exception {
		iLogMovimientosProcesadosDAO.deleteManifiesto(obj);

	}

	@Override
	public void deleteManifiestoFX(LogMovimientoProcesadoDTO obj) throws Exception {
		iLogMovimientosProcesadosDAO.deleteManifiestoFX(obj);

	}

	@Override
	public int insertManifiestoMovimientoFXC(ManifiestoDTO manifiesto_salida, ManifiestoDTO manifiesto_salidafxc)
			throws Exception {
		return iLogMovimientosProcesadosDAO.insertManifiestoMovimientoFXC(manifiesto_salida, manifiesto_salidafxc);
	}

	@Override
	public List<LogHistoriaDTO> getGuiasManifiestoFXC(String manifiesto) throws Exception {
		return iLogMovimientosProcesadosDAO.getGuiasManifiestoFXC(manifiesto);
	}

	@Override
	public List<LogHistoriaDTO> getGuiasPosiblesManifiestoFXC(String manifiesto) throws Exception {
		// TODO Auto-generated method stub
		return iLogMovimientosProcesadosDAO.getGuiasPosiblesManifiestoFXC(manifiesto);
	}

	@Override
	public List<LogHistoriaDTO> getGuiasRutaManifiesto(String manifiesto) throws Exception {
		
		return iLogMovimientosProcesadosDAO.getGuiasRutaManifiesto(manifiesto);
	}

}
