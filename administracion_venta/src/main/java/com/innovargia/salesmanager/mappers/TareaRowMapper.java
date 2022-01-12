/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.TareaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class TareaRowMapper implements RowMapper<TareaDTO>{

	/**
	 * 
	 */
	public TareaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TareaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TareaDTO obj = new TareaDTO();
		
		obj.setEstatus( UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estatus", rs)) );
		
		if (ResultSetUtils.getRSString("fechacambioestatus", rs)!=null){
			obj.setFechacambioestatus(UtilsStringFechas.formatoStrFecha(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechacambioestatus", rs)), "yyyy-MM-dd hh:mm:ss", "dd-MM-yyyy") ); 
		}else{
			obj.setFechacambioestatus("");
		}
			
		if (ResultSetUtils.getRSString("fechasolicitud", rs)!=null){
			obj.setFechasolicitud(UtilsStringFechas.formatoStrFecha(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechasolicitud", rs)), "yyyy-MM-dd hh:mm:ss", "dd-MM-yyyy") );
		
		}else{
			obj.setFechasolicitud("");
		}
		if (ResultSetUtils.getRSString("fechaexpira", rs)!=null){
			obj.setFechaexpira(UtilsStringFechas.formatoStrFecha(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechaexpira", rs)), "yyyy-MM-dd hh:mm:ss", "dd-MM-yyyy"));		
		}else{
			obj.setFechaexpira("");
		}

		
		obj.setIdtarea(ResultSetUtils.getRSInt("idtarea", rs) );
		obj.setIdtareaorigina(ResultSetUtils.getRSInt("idtareaorigina", rs) );
		obj.setIdusuariogenero(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idusuariogenero", rs))  ); 
		obj.setIdusuarioresponsable(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idusuarioresponsable", rs))  );
		obj.setImportancia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("importancia", rs))  );
		obj.setSolicitud(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("solicitud", rs))  );
		obj.setSolucion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("solucion", rs))  );
		
		obj.setTipo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipo", rs)) );
		obj.setAmbito(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ambito", rs)) );

		obj.setIdambitotarea(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idambitotarea", rs)) );
		
		obj.setTitulo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("titulo", rs)) );
		
		obj.setIdtarea(ResultSetUtils.getRSInt("idtarea", rs) );
		
		
		

		return obj;
	}

}
