/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.documentos.dtos.CODFXC;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CODFXCRowMapper implements RowMapper<CODFXC>{
        
	/**
	 * 
	 */
	public CODFXCRowMapper() {
		// TODO Auto-generated constructor stub
	}
   
	@Override
	public CODFXC mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    CODFXC obj = new CODFXC();
	    obj.setIddocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumento", rs))); 
	    obj.setLogin_creo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login_creo", rs)));  
	    obj.setNumoficina_creo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numoficina_creo", rs)));  
	    obj.setValor_a_cobrar(ResultSetUtils.getRSFloat("valor_a_cobrar", rs)); 
	    obj.setLogin_entrega(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login_entrega", rs)));  
	    obj.setNumoficina_entrega(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numoficina_entrega", rs)));  
	    obj.setValor_cobrado(ResultSetUtils.getRSFloat("valor_cobrado", rs));  
	    obj.setTipocod(ResultSetUtils.getRSInt("valor_cobrado", rs)); 
	    obj.setLogin_devolucion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login_devolucion", rs)));  
	    obj.setNumoficina_devolucion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numoficina_devolucion", rs)));  
	    obj.setFechacreacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechacreacion", rs)));  
	    obj.setFecha_devolucion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fecha_devolucion", rs)));  
	    obj.setFecha_entrega(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fecha_entrega", rs)));  

	    return obj;
	}

}
