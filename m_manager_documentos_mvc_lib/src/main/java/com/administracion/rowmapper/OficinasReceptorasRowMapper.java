/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.OficinasDTO;

/**
 * @author aruaro
 *
 */
public class OficinasReceptorasRowMapper implements RowMapper<OficinasDTO>{

	/**
	 * 
	 */
	public OficinasReceptorasRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public OficinasDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OficinasDTO obj  =new OficinasDTO(); 

		  
		 obj.setHorarios(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("horarios",rs)));   
		  obj.setEstatus(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estatus",rs))); 
		  obj.setLatitud(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("latitud",rs))); 
		  obj.setLongitud(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("longitud",rs))); 
		  obj.setSiglasplaza(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("siglasplaza",rs)));  
		  obj.setTipolocal(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipolocal",rs)));   
		  obj.setEncargado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("encargado",rs)));  
		  obj.setEntrecalles(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("entrecalles",rs)));  
		  obj.setIdoficina(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idoficina",rs)));  
		 obj.setNombre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nombre",rs))); 
			obj.setNumero(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numero",rs))); 
		obj.setCalle(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("calle",rs)));       
		obj.setColonia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("colonia",rs))); 
		obj.setMunicipio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("municipio",rs))); 
		obj.setEstado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estado",rs))); 
		obj.setCp(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cp",rs))); 
		obj.setTelefono(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("telefono",rs))); 
		obj.setEncargado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("encargado",rs))); 
		
		//Datos de la caja
		obj.setIdcaja(ResultSetUtils.getRSInt("idcaja",rs)); 
		obj.setDescripcion( UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs))); 
		obj.setFechaapertura(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechaapertura",rs))); 
		obj.setLogin(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("login",rs))); 
		obj.setFechacierre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechacierre",rs))); 
		obj.setLogincierre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("logincierre",rs))); 
		
		
		obj.setEsocurre(ResultSetUtils.getRSInt("esocurre",rs)); 
		obj.setTipooficina(ResultSetUtils.getRSInt("tipooficina",rs)); 
		obj.setIdregistro(ResultSetUtils.getRSInt("idregistro",rs)); 
		

		return obj;
	}

}
