package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.autodoc.dto.DesgloceCumplimientoDias;
import com.innovargia.autodoc.dto.DesgloceCumplimientoDiasTotal;
import com.innovargia.autodoc.dto.FiltrosReportesIndicadores;
import com.innovargia.autodoc.dto.MedicionCrossDock;
import com.innovargia.autodoc.dto.MedicionCumplimientoGarantias;
import com.innovargia.autodoc.dto.MedicionGarantiasPorCliente;
import com.innovargia.autodoc.dto.MedicionIntentosEntrega;
import com.innovargia.autodoc.dto.MedicionPendientesCO;
import com.innovargia.salesmanager.ibo.IndicadoresBO;
import com.innovargia.salesmanager.idao.IndicadoresDAO;

@Service
public class IndicadoresIBO implements IndicadoresBO {

	@Autowired
	IndicadoresDAO IndicadoresDAO;

	@Override
	public List<MedicionGarantiasPorCliente> getMedicionGarantiaXCliente(FiltrosReportesIndicadores filtros)
			throws Exception {

		return IndicadoresDAO.getMedicionGarantiaXCliente(filtros);
	}

	@Override
	public List<MedicionCumplimientoGarantias> getMedicionCumplimientoGarantias(FiltrosReportesIndicadores filtros)
			throws Exception {

		return IndicadoresDAO.getMedicionCumplimientoGarantias(filtros);
	}

	@Override
	public List<MedicionCumplimientoGarantias> getMedicionCumplimientoGarantiasXCO(FiltrosReportesIndicadores filtros)
			throws Exception {

		return IndicadoresDAO.getMedicionCumplimientoGarantiasXCO(filtros);

	}

	@Override
	public List<MedicionGarantiasPorCliente> getTiempoEntregaPorCO(FiltrosReportesIndicadores filtros)
			throws Exception {

		return IndicadoresDAO.getTiempoEntregaPorCO(filtros);
	}

	@Override
	public List<MedicionCrossDock> getMedicionCrossDock(FiltrosReportesIndicadores filtros) throws Exception {

		return IndicadoresDAO.getMedicionCrossDock(filtros);
	}

	@Override
	public List<MedicionCrossDock> getDemoraIngresoCOFinal(FiltrosReportesIndicadores filtros) throws Exception {

		return IndicadoresDAO.getDemoraIngresoCOFinal(filtros);
	}

	@Override
	public List<DesgloceCumplimientoDias> getDesgloceCumplimientoDias(FiltrosReportesIndicadores filtros)
			throws Exception {

		return IndicadoresDAO.getDesgloceCumplimientoDias(filtros);

	}

	@Override
	public List<DesgloceCumplimientoDias> getDesgloceCumplimientoDiasPorcentaje(FiltrosReportesIndicadores filtros)
			throws Exception {

		return IndicadoresDAO.getDesgloceCumplimientoDiasPrcentaje(filtros);

	}

	@Override
	public List<DesgloceCumplimientoDiasTotal> getDesgloceCumplimientoDiasTotal(FiltrosReportesIndicadores filtros)
			throws Exception {

		return IndicadoresDAO.getDesgloceCumplimientoDiasTotal(filtros);

	}

	@Override
	public List<DesgloceCumplimientoDiasTotal> getDesgloceCumplimientoDiasTotalNum(FiltrosReportesIndicadores filtros)
			throws Exception {

		return IndicadoresDAO.getDesgloceCumplimientoDiasTotalNum(filtros);

	}

	@Override
	public List<MedicionPendientesCO> getMedicionPendientesCO(FiltrosReportesIndicadores filtros) throws Exception {

		return IndicadoresDAO.getMedicionPendientesCO(filtros);

	}

	@Override
	public List<MedicionIntentosEntrega> getMedicionIntentosEntrega(FiltrosReportesIndicadores filtros)
			throws Exception {
	    
		return IndicadoresDAO.getMedicionIntentosEntrega(filtros);

	}

}
