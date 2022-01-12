/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.CotizacionLineaAdicional;
import com.administracion.dto.CotizacionLineaVolumen;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CotizacionLineaAdicionalesDTOMapper implements RowMapper<CotizacionLineaAdicional>{

	/**
	 * 
	 */
	public CotizacionLineaAdicionalesDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CotizacionLineaAdicional mapRow(ResultSet rs, int rowNum) throws SQLException {
		

	    CotizacionLineaAdicional obj  =new CotizacionLineaAdicional();
	    obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs)));
	    obj.setIdadicional(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idadicional",rs)) );
	    obj.setIdcotizacionlinea(ResultSetUtils.getRSInt("idcotizacionlinea", rs)  );
	    obj.setIdcotizacionlinea_adicional(ResultSetUtils.getRSInt("idcotizacionlinea_adicional", rs)  );
	    obj.setIdregistroadicional(ResultSetUtils.getRSInt("idregistroadicional", rs)  );
	    
	    obj.setTipo(ResultSetUtils.getRSInt("tipo", rs)  );
	    obj.setPrecio(ResultSetUtils.getRSFloat("precio", rs) );

	    obj.setIdcotizacionlinea(ResultSetUtils.getRSInt("idcotizacionlinea", rs) );    
	    

	  
		return obj;
	}

}
