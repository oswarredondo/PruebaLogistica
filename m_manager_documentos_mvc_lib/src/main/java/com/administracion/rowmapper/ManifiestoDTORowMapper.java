/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AdicionalDTO;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.ManifiestoDTO;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class ManifiestoDTORowMapper implements RowMapper<ManifiestoDTO>{

	/**
	 * 
	 */
	public ManifiestoDTORowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ManifiestoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ManifiestoDTO obj_manifiesto  =new ManifiestoDTO();
		
		obj_manifiesto = new ManifiestoDTO();
    	obj_manifiesto.setRuta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ruta",rs)));
    	obj_manifiesto.setCantidad_asig(ResultSetUtils.getRSInt("cantidad_asig",rs));
    	obj_manifiesto.setEmpaque_asig("");
    	obj_manifiesto.setPesofisico_asig(ResultSetUtils.getRSFloat("pesofisico_asig",rs));
    	obj_manifiesto.setPesovolumetrico_asig(ResultSetUtils.getRSFloat("pesovolumetrico_asig",rs));
    	obj_manifiesto.setVolumen_asig(ResultSetUtils.getRSFloat("volumen_asig",rs));
    	
    	obj_manifiesto.setCantidad_pend(ResultSetUtils.getRSInt("cantidad_pend",rs));
    	obj_manifiesto.setEmpaque_pend("");
    	obj_manifiesto.setPesofisico_pend(ResultSetUtils.getRSFloat("pesofisico_pend",rs));
    	obj_manifiesto.setPesovolumetrico_pend(ResultSetUtils.getRSFloat("pesovolumetrico_pend",rs));
    	obj_manifiesto.setVolumen_pend(ResultSetUtils.getRSFloat("volumen_pend",rs));

   
		
		return obj_manifiesto;
	}

}
