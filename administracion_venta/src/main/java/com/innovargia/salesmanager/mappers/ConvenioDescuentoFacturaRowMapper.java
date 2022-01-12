/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.ConvenioDescuentoFactura;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ConvenioDescuentoFacturaRowMapper implements RowMapper<ConvenioDescuentoFactura>{

	/**
	 * 
	 */
	public ConvenioDescuentoFacturaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ConvenioDescuentoFactura mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    ConvenioDescuentoFactura obj = new ConvenioDescuentoFactura();
	    obj.setIdconvenio( ResultSetUtils.getRSInt("idconvenio", rs) );
	    obj.setIdconveniodescfact( ResultSetUtils.getRSInt("idconveniodescfact", rs)  );
	    obj.setRangofinal( ResultSetUtils.getRSInt("rangofinal", rs) );
	    obj.setRangoinicial( ResultSetUtils.getRSInt("rangoinicial", rs)  );
	    obj.setDescuento( ResultSetUtils.getRSInt("descuento", rs)   );
	    obj.setFechaevento(ResultSetUtils.getRSString("fechaevento", rs) );
	    obj.setLogin(ResultSetUtils.getRSString("login", rs)  );
			
		return obj;
	}

}
