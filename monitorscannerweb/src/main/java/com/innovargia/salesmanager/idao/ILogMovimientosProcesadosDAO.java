package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO;
import com.servicio.dtos.ManifiestoDTO;

public interface ILogMovimientosProcesadosDAO {
    
    public void deleteManifiestoFX(LogMovimientoProcesadoDTO obj)
		throws Exception ;

    public List<LogHistoriaDTO> getGuiasPosiblesManifiestoFXC(String manifiesto)
	    throws Exception;

    public List<LogHistoriaDTO> getGuiasManifiesto(String manifiesto)
	    throws Exception;
    
    public List<LogHistoriaDTO> getGuiasRutaManifiesto(String manifiesto)
    	    throws Exception;

    public int insertManifiestoMovimientoFXC(ManifiestoDTO manifiesto_salida,
	    ManifiestoDTO manifiesto_salidafxc) throws Exception;

    public List<LogHistoriaDTO> getGuiasManifiestoFXC(String manifiesto)
	    throws Exception;

    public int insertManifiestoMovimiento(ManifiestoDTO manifiesto)
	    throws Exception;

    public List<LogHistoriaDTO> getGuiasMovimientoLocal(String ruta,
	    String depto, boolean verSoloLasNoManifiestadas, String plaza)
	    throws Exception;

    public abstract void update(LogMovimientoProcesadoDTO obj,
	    String exclude_guias) throws Exception;

    public abstract void updateMovLocal(LogMovimientoProcesadoDTO obj,
	    String exclude_guias) throws Exception;

    public abstract void delete(LogMovimientoProcesadoDTO obj) throws Exception;

    public void deleteManifiesto(LogMovimientoProcesadoDTO obj)
	    throws Exception;

    public List<LogHistoriaDTO> getGuiasViajeRutaEntradas(String viaje,
	    String ruta, String tipotranslado,
	    boolean verSoloLasNoManifiestadas, String plaza) throws Exception;

    public List<LogHistoriaDTO> getGuiasViajeRutaSalidas(String viaje,
	    String ruta, String tipotranslado,
	    boolean verSoloLasNoManifiestadas, String plaza) throws Exception;
    
	public List<LogMovimientoProcesadoDTO> getViajeCorrida(String viajecorrida) throws Exception;

	public List<LogMovimientoProcesadoDTO> getPlazaProcesaEntrada(String plaza, String tipotranslado) throws Exception; 
	public List<LogMovimientoProcesadoDTO> getPlazaProcesaSalidas(String plaza, String tipotranslado) throws Exception;	
	public List<LogMovimientoProcesadoDTO> getPlazaProcesaMovimientoLocal(String plaza, String tipotranslado) throws Exception;
	public List<LogMovimientoProcesadoDTO> getTotalesRutaRecolecciones(String plaza, String ruta) throws Exception ;
	public List<LogHistoriaDTO> getGuiasRecolecciones(String ruta,String depto,
		boolean verSoloLasNoManifiestadas,String plaza) throws Exception;
	
	public void updateRecoleccion(LogMovimientoProcesadoDTO obj, String exclude_guias, String plazas) throws Exception;	
	public List<LogMovimientoProcesadoDTO> getPlazaProcesaRecoleciones(String plaza, String tipotranslado) throws Exception;
	

    /***
     * Obtiene todos los registros de la bitacora
     * 
     * @param obj
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getRegistrosProcesados(
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
    public abstract List<LogMovimientoProcesadoDTO> getViajeSalidas(
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
	    String plaza, String tipotranslado) throws Exception;

    /***
     * 
     * @param viaje
     * @param tipotranslado
     *            L = Local, F=Foraneo
     * @return
     * @throws Exception
     */
    public abstract List<LogMovimientoProcesadoDTO> getTotalesViajeRutaEntradas(
	    String viaje, String tipotranslado, String plaza) throws Exception;

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

    public List<LogMovimientoProcesadoDTO> getTotalesRutaMovLocal(String plaza)
	    throws Exception;

    public abstract List<LogMovimientoProcesadoDTO> getTotalesRutaDeptoMovLocal(
	    String plaza, String ruta) throws Exception;

    public abstract LogHistoriaDTO get(LogHistoriaDTO obj) throws Exception;

    public abstract void updateEstatus(LogHistoriaDTO obj) throws Exception;

    public List<LogMovimientoProcesadoDTO> getTotalPorTipoRegistro(String plaza)
	    throws Exception;

    public List<LogMovimientoProcesadoDTO> getTotalesPorPlaza(String plaza)
	    throws Exception;

	public List<LogHistoriaDTO> getGuiasRecoleccionesMadre(String ruta, String depto, boolean verSoloLasNoManifiestadas,
			String plaza, String esMadre) throws Exception;

	public List<LogHistoriaDTO> getGuiasViajeRutaEntradasMadre(String viaje, String ruta, String tipotranslado,
			boolean verSoloLasNoManifiestadas, String plaza, String idMadre) throws Exception;

	public List<LogHistoriaDTO> getGuiasViajeRutaSalidasMadre(String viaje, String ruta, String tipotranslado,
			boolean verSoloLasNoManifiestadas, String plaza, String esMadre) throws Exception;

	public List<LogHistoriaDTO> getGuiasMovimientoLocalMadre(String ruta, String depto, boolean verSoloLasNoManifiestadas,
			String plaza, String esMadre) throws Exception;

}