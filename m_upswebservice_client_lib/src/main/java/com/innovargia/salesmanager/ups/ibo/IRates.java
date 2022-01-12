package com.innovargia.salesmanager.ups.ibo;

import java.util.List;

import com.administracion.dto.CotizacionTarifa;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;

public interface IRates {

    public abstract List<CotizacionTarifa> rates(CotizacionTarifa cotiza,
	    EtiquetaRotulacionDTO etiquetaDTO) throws Exception;

}