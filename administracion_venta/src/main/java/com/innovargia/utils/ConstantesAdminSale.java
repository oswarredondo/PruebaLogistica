/**
 * 
 */
package com.innovargia.utils;

import javax.servlet.http.HttpSession;

import com.innovargia.salesmanager.dtos.UsuarioDTO;

/**
 * @author aruaro
 *
 */
public class ConstantesAdminSale {

	public final static String  USER_SESSION = "ADMINSALESESSIONUSER";
	public final static String  ID_APP = "ADMINSALES";
	public final static String  ID_APP_MAIL = "ADMSALESE_EMAIL";
	public final static String  ID_SKY4SOL = "SKY4SOL";
	public final static String  NUM_CTE_APP = "0000000000";
	public final static String  DOC_COTIZACION = "COTIZACION";
	public final static String  DOC_PRECONVENIO= "PRECONVENIO";
	public final static String  DOC_CONVENIO = "CONVENIO";
	
	
	public final static String  MOV_INSERT = "AGREGAR";
	public final static String  MOV_SENDMAIL = "CORREO";
	public final static String  MOV_ACTIVAR = "ACTIVAR";
	public final static String  MOV_CERRADO = "CERRADO";
	public final static String  MOV_DESACTIVAR = "DESACTIVAR";
	public final static String  MOV_AUTORIZAR = "AUTORIZAR";

	public final static String  MOV_DOCUMENTACION= "EN DOCUMENTACION";
	public final static String  MOV_ = "AUTORIZAR";
	public final static String  MOV_CANCELADO = "CANCELADO";
	public final static String  MOV_OTRO = "OTRO";
	public final static String  MOV_TRANSFORMA = "TRANSFORMA";
	public final static String  MOV_UPDATE = "ACTUALIZAR";
	public final static String  MOV_DELETE= "BORRAR";
	
	public final static String  ID_MODULO= "A";
	
	public final static String PATHIREPORTJASPER = "PathiReportJasper";
	public final static String PATHDOC_ATTACHMENT = "path.documentos.attachment";
	
	public final static String DirPDFTXTFile = "DirPDFTXTFile";

	public final static String WALLPAPER_PARAMETRO = "wallpaper.sistema.default";
	
	public final static String WALLPAPER_DEFAULT = "desktop.jpg";
	
	
	public final static String  ESTADO_ACTIVO= "A";
	public final static String  ESTADO_CADUCO= "C";
	public final static String  ESTADO_TEMPORAL= "T";
	
	public final static String  ESTADO_HISTORIA= "H";
	
	//Tipos de Tareas
	public final static String TIPO_NOTIFICACION_SOLICITUD ="SOLICITUD"; 
	
	//0= Inactiva, 1 = Activa 2=Transformada a Convevio 3=Cerrada

	
	
	public final static String MSG_SESSION_FINISH ="No existe sesi�n de usuario activa, "
		+ "salga del sistema y vuelva a intentar";
	public final static String MSG_OPERACION_UPDATE_RESTRINGIDA = "Operaci�n de actualizaci�n "
		+ "de datos restringida para el perfil de usuario.";


	public static UsuarioDTO getSession(HttpSession sesion){
		UsuarioDTO usuario =  new UsuarioDTO();    
	        try{
	           HttpSession session = sesion;
	           usuario = 
	               (UsuarioDTO) session.getAttribute(USER_SESSION);

	            if (usuario==null){
	                return null;
	            }
	        }catch(Exception e){
	            
	        }
	        
	        return usuario;

	}

}
