/**
 * 
 */
package com.innovargia.recolecciones.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.SolicitudRecoleccion;
import com.innovargia.utils.UtilsStrings;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class SolicitudRecoleccionRowMapper implements RowMapper<SolicitudRecoleccion>{

	/**
	 * 
	 */
	public SolicitudRecoleccionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SolicitudRecoleccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SolicitudRecoleccion solicitud = new SolicitudRecoleccion();
		solicitud.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs));
		solicitud.setIdsolicitud(ResultSetUtils.getRSString("idsolicitud", rs));
		solicitud.setIdrecoleccion(ResultSetUtils.getRSString("idrecoleccion", rs));
		solicitud.setManifiesto(ResultSetUtils.getRSString("manifiesto", rs));
		
		solicitud.setCuenta_estatus(ResultSetUtils.getRSString("cuenta_estatus", rs)); 
		solicitud.setNumempleado(ResultSetUtils.getRSString("numempleado", rs)); 
		solicitud.setQuiensolicita(ResultSetUtils.getRSString("quiensolicita", rs));
		solicitud.setCorreosolicita(ResultSetUtils.getRSString("correosolicita", rs));
		solicitud.setTelefonosolicita(ResultSetUtils.getRSString("telefonosolicita", rs)); 	
		solicitud.setCelularsolicita(ResultSetUtils.getRSString("celularsolicita", rs)); 
		solicitud.setNumoficina(ResultSetUtils.getRSString("numoficina", rs)); 

		solicitud.setNumcliente(ResultSetUtils.getRSString("numcliente", rs)); 		
		solicitud.setRazonsocialcliente(ResultSetUtils.getRSString("razonsocialcliente", rs)); 
		solicitud.setContrato(ResultSetUtils.getRSString("contrato", rs));
	
		solicitud.setIdtiporecol(ResultSetUtils.getRSString("idtiporecol", rs)); 	
		solicitud.setIdempaque(ResultSetUtils.getRSString("idempaque", rs)); 
		solicitud.setFechainicio(ResultSetUtils.getRSString("fechainicio", rs)); 
		solicitud.setFechafin(ResultSetUtils.getRSString("fechafin", rs));

		solicitud.setFecharecol(ResultSetUtils.getRSString("fecha", rs)); 
		solicitud.setRazonsocial(ResultSetUtils.getRSString("razonsocial", rs)); 
		solicitud.setPreguntarpor(ResultSetUtils.getRSString("preguntarpor", rs)); 
		solicitud.setDepartamento(ResultSetUtils.getRSString("departamento", rs)); 
		solicitud.setCalle(ResultSetUtils.getRSString("calle", rs));
		solicitud.setCp(ResultSetUtils.getRSString("cp", rs));
		solicitud.setColonia(ResultSetUtils.getRSString("colonia", rs)); 
		solicitud.setMunicipio(ResultSetUtils.getRSString("municipio", rs));
		solicitud.setEstado(ResultSetUtils.getRSString("estado", rs)); 
		solicitud.setTelefono(ResultSetUtils.getRSString("telefono", rs)); 
		solicitud.setCelular(ResultSetUtils.getRSString("celular", rs));
		solicitud.setEmail(ResultSetUtils.getRSString("email", rs)); 

		solicitud.setPesokg(ResultSetUtils.getRSString("pesokg", rs)); 			
		solicitud.setCantidadpzas(ResultSetUtils.getRSString("cantidadpzas", rs)); 		
		solicitud.setPesototal(ResultSetUtils.getRSString("pesotoal", rs)); 
		solicitud.setAncho(ResultSetUtils.getRSString("ancho", rs)); 
		solicitud.setAlto(ResultSetUtils.getRSString("alto", rs)); 
		solicitud.setLargo(ResultSetUtils.getRSString("largo", rs)); 
		solicitud.setVolumen(ResultSetUtils.getRSString("volumen", rs)); 
		solicitud.setObservacion(ResultSetUtils.getRSString("observacion", rs)); 	
		solicitud.setContenido(ResultSetUtils.getRSString("contenido", rs)); 	
		solicitud.setRutaasignada(ResultSetUtils.getRSString("rutaasignada", rs)); 
		solicitud.setPlaza(ResultSetUtils.getRSString("plaza", rs)); 
		
		solicitud.setEstatus(ResultSetUtils.getRSString("estatus", rs)); 
		solicitud.setIdusuariocreador(ResultSetUtils.getRSString("idusuartiocreador", rs)); 
		solicitud.setIdentidad(ResultSetUtils.getRSInt("identidad", rs));   
		solicitud.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs)); 
		solicitud.setFechacreacion(ResultSetUtils.getRSString("fechacreacion", rs));
		
		
		solicitud.setLatitud(UtilsStrings.nullChange(ResultSetUtils.getRSString("latitud", rs)));
		solicitud.setLongitud(UtilsStrings.nullChange(ResultSetUtils.getRSString("longitud", rs)));
		//Verifica si existen los siguientes campos es por que se realizo la consulta a la 
		//vista
		if (ResultSetUtils.getRSString("fecha_recol", rs)!=null){
			solicitud.setFecharecol(ResultSetUtils.getRSString("fecha_recol", rs)); 
			solicitud.setFechacancelacion(ResultSetUtils.getRSString("fechacancela", rs));
			solicitud.setQuiencancela(ResultSetUtils.getRSString("quiencancela", rs));
			solicitud.setMotivocancelacion(ResultSetUtils.getRSString("motivo", rs));
			solicitud.setObservacion(ResultSetUtils.getRSString("observadia", rs));
		}
		
		return solicitud;
	}

}
