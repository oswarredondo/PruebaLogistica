package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.autodoc.dto.DesgloceCumplimientoDias;
import com.innovargia.autodoc.dto.DesgloceCumplimientoDiasTotal;
import com.innovargia.autodoc.dto.FiltrosReportesIndicadores;
import com.innovargia.autodoc.dto.MedicionCrossDock;
import com.innovargia.autodoc.dto.MedicionCumplimientoGarantias;
import com.innovargia.autodoc.dto.MedicionGarantiasPorCliente;
import com.innovargia.autodoc.dto.MedicionIntentosEntrega;
import com.innovargia.autodoc.dto.MedicionPendientesCO;


public interface IndicadoresBO {

    public List<MedicionGarantiasPorCliente> getMedicionGarantiaXCliente(FiltrosReportesIndicadores filtros)
		throws Exception;
    
    public List<MedicionCumplimientoGarantias> getMedicionCumplimientoGarantias(FiltrosReportesIndicadores filtros)
		throws Exception;
    
    public List<MedicionCumplimientoGarantias> getMedicionCumplimientoGarantiasXCO(FiltrosReportesIndicadores filtros)
		throws Exception;
    
    public List<MedicionGarantiasPorCliente> getTiempoEntregaPorCO(FiltrosReportesIndicadores filtros)
		throws Exception;
    
    public List<MedicionCrossDock> getMedicionCrossDock(FiltrosReportesIndicadores filtros)
		throws Exception;
    
    public List<MedicionCrossDock> getDemoraIngresoCOFinal(FiltrosReportesIndicadores filtros)
		throws Exception;
		
    public List<DesgloceCumplimientoDias> getDesgloceCumplimientoDias(FiltrosReportesIndicadores filtros)
	    throws Exception;
    
    public List<DesgloceCumplimientoDias> getDesgloceCumplimientoDiasPorcentaje(FiltrosReportesIndicadores filtros)
    	    throws Exception;
    
    public List<DesgloceCumplimientoDiasTotal> getDesgloceCumplimientoDiasTotal(FiltrosReportesIndicadores filtros)
    	    throws Exception;
    
    public List<DesgloceCumplimientoDiasTotal> getDesgloceCumplimientoDiasTotalNum(FiltrosReportesIndicadores filtros)
    	    throws Exception;
    
    public List<MedicionPendientesCO> getMedicionPendientesCO(FiltrosReportesIndicadores filtros)
    	    throws Exception;
    
    public List<MedicionIntentosEntrega> getMedicionIntentosEntrega(FiltrosReportesIndicadores filtros)
    	    throws Exception;
}
