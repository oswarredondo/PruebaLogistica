/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.ITextObjeto;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ITextObjetoMapper implements RowMapper<ITextObjeto>{

	/**
	 * 
	 */
	public ITextObjetoMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ITextObjeto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ITextObjeto obj  =new ITextObjeto();
		obj.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs) );  
		obj.setIdentidad(ResultSetUtils.getRSInt("identidad", rs) );  
		obj.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs) );  
		obj.setRotation(ResultSetUtils.getRSInt("rotation", rs) );  
		obj.setFontsize(ResultSetUtils.getRSInt("fontsize", rs) );  
		obj.setBaseline(ResultSetUtils.getRSInt("baseline", rs) );  
		obj.setAncho(ResultSetUtils.getRSFloat("ancho", rs) );  
		obj.setAlto(ResultSetUtils.getRSFloat("alto", rs) );  
		obj.setBloque(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("bloque",rs))); 
		
		
		
		obj.setX(ResultSetUtils.getRSFloat("x", rs) );  
		obj.setY(ResultSetUtils.getRSFloat("y", rs) );  
		obj.setWidth(ResultSetUtils.getRSFloat("width", rs) );  
		obj.setHeigth(ResultSetUtils.getRSFloat("heigth", rs) );  
		obj.setBorder(ResultSetUtils.getRSFloat("border", rs) );  
		
		obj.setFont(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("font",rs)));
		obj.setType(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("type",rs)));
		obj.setEtiqueta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("etiqueta",rs)));
		obj.setIdtemplate(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idtemplate",rs)));
		obj.setLineaplnatilla(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("lineaplnatilla",rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs)));
		
		obj.setCampo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("campo",rs)));
	
		obj.setAcuseSoloLeyenda(ResultSetUtils.getRSInt("acusesololeyenda", rs) );  
		obj.setEstructuraguia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estructuraguia",rs)));
		
		
		return obj;
	}

}
