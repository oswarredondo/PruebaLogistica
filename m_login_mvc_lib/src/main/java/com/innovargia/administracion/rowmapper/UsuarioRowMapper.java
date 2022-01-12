/**
 * 
 */
package com.innovargia.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class UsuarioRowMapper implements RowMapper<UsuarioDTO>{

	/**
	 * 
	 */
	public UsuarioRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UsuarioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuarioDTO obj = new UsuarioDTO();
		
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setNumCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));
		obj.setIdperfil(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idperfil", rs)));
		obj.setEstatus(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estatus", rs)));
		obj.setWallpaper(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("wallpaper", rs)));
		obj.setStretch(ResultSetUtils.getRSInt("wallpaperstretch", rs));
		obj.setIdagrupamiento(ResultSetUtils.getRSInt("idagrupamiento", rs)); 
		obj.setVisibilidad(ResultSetUtils.getRSInt("visibilidad", rs)); 
		
		
		obj.setLogin(ResultSetUtils.getRSString("Login", rs));
        
		obj.setPassword(ResultSetUtils.getRSString("Password", rs));
		obj.setIdUsuario(ResultSetUtils.getRSString("NumCliente", rs));
		obj.setDesEmpresa(ResultSetUtils.getRSString("Nombre", rs));
		obj.setLogo(ResultSetUtils.getRSString("Logo", rs));
		obj.setEstado(ResultSetUtils.getRSString("Estatus", rs));
		obj.setIdoficina(UtilsStringFechas.changeNULL(ResultSetUtils.getRSString("idoficina", rs)));
		obj.setNumempleado(UtilsStringFechas.changeNULL(ResultSetUtils.getRSString("numempleado", rs)));
		obj.setSiglasPlaza(UtilsStringFechas.changeNULL(ResultSetUtils.getRSString("siglasplaza", rs)));
		obj.setEmail(ResultSetUtils.getRSString("email", rs)); 
         
		obj.organizacion.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs));
		obj.entidad.setIdentidad(ResultSetUtils.getRSInt("identidad", rs)); 
		obj.perfil_Dto.setDescripcion_perfil(ResultSetUtils.getRSString("descripcion", rs));
		obj.perfil_Dto.setNivel(ResultSetUtils.getRSString("nivel", rs));
		obj.setFormatoetimedia(ResultSetUtils.getRSString("formatoetimedia", rs));
		obj.setFormatoetiperso(ResultSetUtils.getRSString("formatoetiperso", rs));;
		obj.setPlaza(UtilsStringFechas.changeNULL(ResultSetUtils.getRSString("plaza", rs))); 
		obj.setPuesto(UtilsStringFechas.changeNULL(ResultSetUtils.getRSString("puesto", rs))); 
		obj.setNivelPuesto(ResultSetUtils.getRSInt("nivelPuesto", rs)); 
		
		obj.setDescripcionpuesto(UtilsStringFechas.changeNULL(ResultSetUtils.getRSString("descripcionpuesto",rs)));
		
		
		obj.entidad.setEstatus(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("EstatusEntidad",rs)));
		obj.entidad.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("DescEntidad",rs)));
		
		obj.organizacion.setEstatus(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("EstatusOrganiza",rs)));
		obj.organizacion.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("DescOrganiza",rs)));
		obj.organizacion.setLogo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("LogoOrganiza",rs)));;
		obj.cuenta.setRazonSocial(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("razonsocial",rs)));;
		obj.cuenta.setActivo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("EstatusCuenta",rs)));
		
		obj.cuenta.setVertodasdirecciones(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("vertodasdirecciones",rs)));
		obj.cuenta.setCp(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cp",rs))); 
		    
      
         
		return obj;
	}

}
