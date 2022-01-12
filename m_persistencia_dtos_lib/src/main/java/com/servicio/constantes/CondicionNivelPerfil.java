package com.servicio.constantes;

import com.innovargia.salesmanager.dtos.UsuarioDTO;

/**
 * 
 */

/**
 * @author aruaro
 *
 */
public class CondicionNivelPerfil {

	/**
	 * De acuerdo al nivelde un usuario regresa la condicion a aplicar 
	 * ahora que si no quieres que vean todo de la organizacion entonces bajariamos hasta el nivel de Cuenta
	 *	-Cualquier usuario cuyo perfil sea del nivel de cuenta entonces solo podra consultar solo la 
	 *	informacion donde 
	 *	identidad=usuario.entidad y idorganizacion=usuario.organizacion y cuenta=usuario.cuenta
	 *  - Si el usuario tiene un perfil cuyo nivel es de organizacion entonces solo podra consultar 
	 *  	informacion donde identidad=usuario.entidad y organizacion = usuario.organizacion
	 *  - Si el usuario tiene un perfil cuyo nivel es entidad entonces solo podra consultar informacion 
	 *  	donde identidad=usuario.entidad
	 *  -Si no esta definido el usuario o el perfil regresa null
	 *  -Si el nivel es distinto de C (cuenta) y E (entidad) y O (organizacion) entonces regresa null
	 * @param user
	 * @return
	 */
	public static String condicionNivelUsuario(UsuarioDTO user){
		String condicion = " identidad = " + user.entidad.getIdentidad() ;
		
		if ((user== null) || (user.perfil_Dto == null) || (user.perfil_Dto.getNivel() == null) ){
			// logger.debug("Usuario o Perfil de usuario es NULL" );
			return null;
		}
		String nivelperfil = user.perfil_Dto.getNivel().trim().toUpperCase();
		if (nivelperfil.equals("O")){//Nivel Organizacion
			
			condicion = " identidad = " + user.entidad.getIdentidad() + 
						" AND idorganizacion = " + user.organizacion.getIdorganizacion();
			
		}else if(nivelperfil.equals("C") ){//Nivel cuenta 
			
			condicion = " identidad = " + user.entidad.getIdentidad() + " AND idorganizacion = " +
					user.organizacion.getIdorganizacion() + " AND numcliente='" + user.getNumCliente() +"'";
			
		}else if(nivelperfil.equals("U")){// usuario	
			
			condicion = " identidad = " + user.entidad.getIdentidad() + " AND idorganizacion = " +
					user.organizacion.getIdorganizacion() + " AND numcliente='" + user.getNumCliente() +"' AND"
							+ " login = '" + user.getLogin() +"'";
			
		}else if(!nivelperfil.equals("C") && !nivelperfil.equals("E") && 
				 !nivelperfil.equals("O") && !nivelperfil.equals("U")){
			condicion=null;  
			 //logger.debug("NIVEL " + nivelperfil + " DE PERFIL DE USUARIO INVALIDO:" );
		}
		return condicion; 
		
	}
	
	/**
	 * Valida solo el nivel de jearquia de Entidad y Organizacion, esto debido a que en 
	 * algunos procesos es necesario indicar siempre la cuenta y el usuario debe terner  
	 * un perfil con nivel de entidad o organizacion
	 * @param user
	 * @return
	 */
	public static String condicionNivelUsuarioSoloEntidayOrganizacion(UsuarioDTO user){
		String condicion = " identidad = " + user.entidad.getIdentidad() ;
		
		if ((user== null) || (user.perfil_Dto == null) || (user.perfil_Dto.getNivel() == null) ){
			 //logger.debug("Usuario o Perfil de usuario es NULL" );
			return null;
		}
		String nivelperfil = user.perfil_Dto.getNivel().trim().toUpperCase();
		if (nivelperfil.equals("O")){//Nivel Organizacion
			condicion = " identidad = " + user.entidad.getIdentidad() + 
						" AND idorganizacion = " + user.organizacion.getIdorganizacion();
		
		}else if(!nivelperfil.equals("E") && !nivelperfil.equals("O")){
			condicion=null;  
			 //logger.debug("NIVEL " + nivelperfil + " DE PERFIL DE USUARIO INVALIDO:" );
		}
		return condicion; 
		
	}

}
