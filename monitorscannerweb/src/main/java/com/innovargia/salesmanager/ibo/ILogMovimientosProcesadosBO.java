package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO;
import com.servicio.dtos.ManifiestoDTO;

public interface ILogMovimientosProcesadosBO {
    
    public void deleteManifiestoFX(LogMovimientoProcesadoDTO obj)
		throws Exception;

    public List<LogHistoriaDTO> getGuiasManifiesto(String manifiesto)
	    throws Exception;
    
    public List<LogHistoriaDTO> getGuiasRutaManifiesto(String manifiesto)
    	    throws Exception;

    public int insertManifiestoMovimiento(ManifiestoDTO manifiesto)
	    throws Exception;

    public int insertManifiestoMovimientoFXC(ManifiestoDTO manifiesto_salida,
	    ManifiestoDTO manifiesto_salidafxc) throws Exception;

    public List<LogHistoriaDTO> getGuiasManifiestoFXC(String manifiesto)
	    throws Exception;

    public List<LogHistoriaDTO> getGuiasPosiblesManifiestoFXC(String manifiesto)
	    throws Exception;

    public abstract void update(LogMovimientoProcesadoDTO obj,
	    String exclude_guias) throws Exception;

    public abstract void updateMovLocal(LogMovimientoProcesadoDTO obj,
	    String exclude_guias) throws Exception;

    public List<LogHistoriaDTO> getGuiasViajeRutaEntradas(String viaje,
	    String ruta, String tipotranslado,
	    boolean verSoloLasNoManifiestadas, String plaza, String tiporegistro)
	    throws Exception;

    public abstract void delete(LogMovimientoProcesadoDTO obj) throws Exception;

    public abstract void deleteManifiesto(LogMovimientoProcesadoDTO obj)
	    throws Exception;
    public List<LogMovimientoProcesadoDTO> getPlazas(
		String tipotranslado,String plaza, String tiporegistro) throws Exception;    

    /***
     * Obtiene todos los registros de la bitacora
     * 
     * @param obj
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getRegistros(
	    LogMovimientoProcesadoDTO obj) throws Exception;

    /***
     * Obtiene el concentrado de registros por plaza
     * 
     * @param obj
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getTotalesPlazaRegistro(
	    String plaza) throws Exception;

    /***
     * Totales por error y movimiento
     * 
     * @param plaza
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getTotalesTipoErroreProcesados(
	    String plaza) throws Exception;

    /***
     * 
     * @param plaza
     * @param tipotranslado
     *            L = Local, F=Foraneo
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getTotalesViajeSalidas(
	    String plaza, String tipotranslado) throws Exception;

    /***
     * 
     * @param viaje
     * @param tipotranslado
     *            L = Local, F=Foraneo
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getTotalesViajeRutaSalidas(
	    String viaje, String tipotranslado, String plaza) throws Exception;

    /***
     * 
     * @param viaje
     * @param tipotranslado
     *            L = Local, F=Foraneo
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getViajesEntradas(
	    String tipotranslado, String plaza, String tiporegistro)
	    throws Exception;

    /***
     * 
     * @param viaje
     * @param tipotranslado
     *            L = Local, F=Foraneo
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getTotalesViajeRutaEntradas(
	    String viaje, String tipotranslado, String plaza,
	    String tiporegistro) throws Exception;

    /***
     * 
     * @param viaje
     * @param tipotranslado
     *            L = Local, F=Foraneo
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getTotalesViajeMovLocal()
	    throws Exception;

    public abstract List<LogMovimientoProcesadoDTO> getTotalesViajeRutaMovLocal(
	    String plaza) throws Exception;

    public abstract List<LogMovimientoProcesadoDTO> getTotalesViajeRutaDeptoMovLocal(
	    String plaza, String ruta) throws Exception;

    public abstract LogHistoriaDTO get(LogHistoriaDTO obj) throws Exception;

    public abstract void updateEstatus(LogHistoriaDTO obj) throws Exception;

    public List<LogMovimientoProcesadoDTO> getTotalPorTipoRegistro(String plaza)
	    throws Exception;

    public List<LogMovimientoProcesadoDTO> getTotalesPorPlaza(String plaza)
	    throws Exception;

	public List<LogHistoriaDTO> getGuiasViajeRutaEntradasMadre(String viaje, String ruta, String tipotranslado,
			boolean verSoloLasNoManifiestadas, String plaza, String tiporegistro, String idMadre) throws Exception;

}