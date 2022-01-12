/**
 * 
 */
package com.innovargia.utils;

import javax.servlet.http.HttpSession;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author aruaro
 *
 */
public class ConstantesAdminSale {


	public final static String  NUM_CTE_APP = "0000000000";
	public final static String  DOC_COTIZACION = "COTIZACION";
	public final static String  DOC_PRECONVENIO= "PRECONVENIO";
	public final static String  DOC_CONVENIO = "CONVENIO";
	
	public final static String  ESTADO_ACTIVO= "A";
	public final static String  ESTADO_CADUCO= "C";
	public final static String  ESTADO_TEMPORAL= "T";
	
	public final static String  ESTADO_HISTORIA= "H";
	
	
	
	public final static String  ID_MODULO= "2";

	//Tipos de Tareas
	public final static String TIPO_NOTIFICACION_SOLICITUD ="SOLICITUD"; 
	
	//0= Inactiva, 1 = Activa 2=Transformada a Convevio 3=Cerrada

	
	
	public final static String MSG_SESSION_FINISH ="No existe sesi�n de usuario activa, salga del sistema y vuelva a intentar";


	public static UsuarioDTO getSession(HttpSession sesion){
		UsuarioDTO usuario =  new UsuarioDTO();    
	        try{
	           HttpSession session = sesion;
	           usuario = 
	               (UsuarioDTO) session.getAttribute(ConstantesGenerales.USER_SESSION);

	            if (usuario==null){
	                return null;
	            }
	        }catch(Exception e){
	            
	        }
	        
	        return usuario;

	}

}
