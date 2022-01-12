
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.CotizacionLineaDireccion;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.utils.ArrayElementos;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

public class LineaCotizacionDireccionDTORowMapper implements RowMapper<CotizacionLineaDireccion>{

	String formatofecha = "dd-MM-yyyy HH:mm:ss";
	public LineaCotizacionDireccionDTORowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CotizacionLineaDireccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    CotizacionLineaDireccion obj  =new CotizacionLineaDireccion();
		obj.setIdcotizacionlinea(ResultSetUtils.getRSInt("idcotizacionlinea", rs) );
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa", rs) );
 
		obj.setRazonsocial_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("razonsocial_rem",rs)));
		obj.setContacto_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("contacto_rem",rs)));
		obj.setCalle_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("calle_rem",rs)));
		obj.setColonia_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("colonia_rem",rs)));
		obj.setMunicipio_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("municipio_rem",rs)));
		obj.setCiudad_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("estado_rem",rs)));
		obj.setEstado_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("ciudad_rem",rs)));
		obj.setCp_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("cp_rem",rs)));
		obj.setTelefono_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("telefono_rem",rs)));
		obj.setCelular_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("celular_rem",rs)));
		obj.setRfc_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("rfc_rem",rs)));
		obj.setEmail_des(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email_rem",rs)));
		obj.setRazonsocial_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("razonsocial_des",rs)));
		obj.setContacto_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("contacto_des",rs)));
		obj.setCalle_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("calle_des",rs)));
		obj.setColonia_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("colonia_des",rs)));
		obj.setMunicipio_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("municipio_des",rs)));
		obj.setCiudad_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("estado_des",rs)));
		obj.setEstado_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("ciudad_des",rs)));
		obj.setCp_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("cp_des",rs)));
		obj.setTelefono_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("telefono_des",rs)));
		obj.setCelular_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("celular_des",rs)));
		obj.setRfc_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("rfc_des",rs)));
		obj.setEmail_des(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email_des",rs)));
		
		obj.setNuminterior_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("numinterior_des",rs))); 
		obj.setNumexterior_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("numexterior_des",rs)));  
		
		obj.setNuminterior_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("numinterior_rem",rs))); 
		obj.setNumexterior_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("numexterior_rem",rs)));  
		
		obj.setEs_ocurre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("es_ocurre",rs)));
		
		obj.setNacional(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nacional",rs))); 
		obj.setTramo(ResultSetUtils.getRSFloat("tramo",rs) ); 
		obj.setIdservicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idservicio",rs)));  
		
		obj.setCporigen(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cporigen",rs)));   
		obj.setCpdestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cpdestino",rs))); 
		obj.setServiciotarifa(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("serviciotarifa",rs)));  
		
		
		obj.setCobro_reexpedicion(ResultSetUtils.getRSFloat("cobro_reexpedicion",rs) ); 
		obj.setCobro_sobrepeso(ResultSetUtils.getRSFloat("cobro_sobrepeso",rs) ); 
		obj.setIddocumento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("iddocumento",rs))); 
		
		
		obj.setIdrangoinicial(ResultSetUtils.getRSInt("idrangoinicial",rs)); 
		obj.setIdrangoinicial(ResultSetUtils.getRSInt("idrangoinicial",rs)); 
		obj.setIdconvenio(ResultSetUtils.getRSInt("idconvenio",rs)); 
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa",rs)); 
		obj.setIdconveniodetalle(ResultSetUtils.getRSInt("idconveniodetalle",rs)); 
		obj.setNumoficina(ResultSetUtils.getRSString("numoficina",rs)); 
		obj.setNumcliente(ResultSetUtils.getRSString("numcliente",rs)); 
		

		
		 return obj;
	}

}
