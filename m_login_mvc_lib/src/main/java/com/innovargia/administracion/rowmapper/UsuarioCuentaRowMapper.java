/**
 * 
 */
package com.innovargia.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class UsuarioCuentaRowMapper implements RowMapper<UsuarioCuentaDTO>{

	/**
	 * 
	 */
	public UsuarioCuentaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UsuarioCuentaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuarioCuentaDTO obj = new UsuarioCuentaDTO();
		
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setNumcliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));
		obj.setIdperfil(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idperfil", rs)));
		obj.setEstatus(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estatus", rs)));
		obj.setWallpaper(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("wallpaper", rs)));
		obj.setWallpaperstretch(ResultSetUtils.getRSInt("wallpaperstretch", rs));
		
		obj.setIdagrupamiento(ResultSetUtils.getRSInt("idagrupamiento", rs));
		obj.setVisibilidad(ResultSetUtils.getRSInt("visibilidad", rs));
		
		obj.setLogin(ResultSetUtils.getRSString("Login", rs));
        
		obj.setPassword(ResultSetUtils.getRSString("password", rs));
		obj.setLogo(ResultSetUtils.getRSString("logo", rs));
		obj.setIdoficina(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idoficina", rs)));
		obj.setNumempleado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numempleado", rs)));

		obj.setEmail(ResultSetUtils.getRSString("email", rs));
		
		obj.setFormatoetimedia(ResultSetUtils.getRSString("formatoetimedia", rs));
		obj.setFormatoetiperso(ResultSetUtils.getRSString("formatoetiperso", rs));
		obj.setSiglasplaza(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("siglasplaza", rs))); 
		obj.setNivelpuesto(ResultSetUtils.getRSInt("nivelPuesto", rs)); 
		obj.setConsecutivo(ResultSetUtils.getRSInt("consecutivo", rs));  
         
		return obj;
	}

}
