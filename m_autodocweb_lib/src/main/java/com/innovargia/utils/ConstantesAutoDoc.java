/**
 * 
 */
package com.innovargia.utils;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author aruaro
 *
 */
public class ConstantesAutoDoc {


	public final static String  NUM_CTE_APP = "0000000000";
	public final static String  DOC_COTIZACION = "COTIZACION";
	public final static String  DOC_PRECONVENIO= "PRECONVENIO";
	public final static String  DOC_CONVENIO = "CONVENIO";

	
	
	public final static String  ID_MODULO= "2";

	//Tipos de Tareas
	public final static String TIPO_NOTIFICACION_SOLICITUD ="SOLICITUD"; 
	
	//0= Inactiva, 1 = Activa 2=Transformada a Convevio 3=Cerrada

	
	
	public final static String MSG_SESSION_FINISH ="No existe sesion de usuario activa, salga del sistema y vuelva a intentar";
	public final static String MSG_SESSIONCTE_FINISH ="Tipo de manejo de impresion (FOLIOS|CONVENIO) inválida, reincie la sesion de trabajo";


	/*public static UsuarioDTO getSession(HttpSession sesion){
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

	}*/
	
	public static UsuarioDTO getSession(HttpSession sesion){
		//Obtenemos la autenticacion actual
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		//Evaluamos que el usuario se haya autenticado
		if(authentication instanceof AnonymousAuthenticationToken)
			return null;
		else
			return (UsuarioDTO)authentication.getPrincipal();
	}
	
	public static CuentasDTO getSessionCte(HttpSession sesion){
		CuentasDTO obj =  new CuentasDTO();    
	        try{
	           HttpSession session = sesion;
	           obj = 
	               (CuentasDTO) session.getAttribute(ConstantesGenerales.USER_CTE_SESSION);

	            if (obj==null){
	                return null;
	            }
	        }catch(Exception e){
	            
	        }
	        
	        return obj;

	}


}
