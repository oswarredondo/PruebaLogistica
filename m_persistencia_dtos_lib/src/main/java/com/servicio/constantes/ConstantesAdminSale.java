/**
 * 
 */
package com.servicio.constantes;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import net.sf.jasperreports.engine.export.draw.PrintDrawVisitor;

import com.administracion.dto.VentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.OficinasDTO;

/**
 * @author aruaro
 *
 */
public class ConstantesAdminSale {


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
	public final static String  MOV_CANCELADO = "CANCELADO";
	public final static String  MOV_OTRO = "OTRO";
	public final static String  MOV_TRANSFORMA = "TRANSFORMA";
	public final static String  MOV_UPDATE = "ACTUALIZAR";
	public final static String  MOV_DELETE= "BORRAR";
	
	public final static int  CONSULTA_INTERNET= -1000;

	
	public final static String  ID_MODULO= "2";
	

	
	

	
	//Tipos de Tareas
	public final static String TIPO_NOTIFICACION_SOLICITUD ="SOLICITUD"; 
	
	//0= Inactiva, 1 = Activa 2=Transformada a Convevio 3=Cerrada

	
	
	public final static String MSG_SESSION_FINISH ="No existe sesion de usuario activa, salga del sistema y vuelva a intentar";


	
	    public static OficinasDTO getSessionPDV(HttpSession sesion){
		OficinasDTO pdv =  new OficinasDTO();    
	        try{
	           HttpSession session = sesion;
	           pdv = 
	               (OficinasDTO) session.getAttribute(ConstantesGenerales.PDV_SESSION);

	            if (pdv==null){
	                return null;
	            }
	        }catch(Exception e){
	            
	        }
	        
	        return pdv;

	}
	    public static UsuarioDTO getSession(HttpSession sesion){
		UsuarioDTO usuario =  new UsuarioDTO();    
	        try{
	           HttpSession session = sesion;
	           usuario = 
	               (UsuarioDTO) session.getAttribute(ConstantesGenerales.USER_SESSION);

	            if (usuario==null){
	            	try{
	            		 usuario = (UsuarioDTO) getSessionAuth(sesion);
	            	}catch(Exception e){
	            		e.printStackTrace();
	            		usuario = null;
	            	}
	            	
	                return usuario;
	            }
	        }catch(Exception e){
	            
	        }
	        
	        return usuario;

	}
	    
	    public static UsuarioDTO getSessionAuth(HttpSession sesion){
			//Obtenemos la autenticacion actual
			Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
			//Evaluamos que el usuario se haya autenticado
			if(authentication instanceof AnonymousAuthenticationToken)
				return null;
			else
				return (UsuarioDTO)authentication.getPrincipal();
		}
		
	private static HashMap<String, String> hash_tipoEmpaque = new HashMap<String, String>();
	private static HashMap<String, String> hash_tipoMedidaPeso= new HashMap<String, String>();
	private static HashMap<String, String> hash_tipoMedidaDimension= new HashMap<String, String>();
	static{
	    hash_tipoEmpaque.put("00", "Unknown");
	    hash_tipoEmpaque.put("01", "UPS Letter Envelope");
	    hash_tipoEmpaque.put("21", "UPS Express Box");
	    hash_tipoEmpaque.put("03", "UPS Tube");
	    hash_tipoEmpaque.put("25", "UPS Worldwide 10KG Box");
	    hash_tipoEmpaque.put("24", "UPS Worldwide 25KG Box");

	        
	    hash_tipoMedidaPeso.put("LBS", "POUNDS");
	    hash_tipoMedidaPeso.put("KGS", "KILOGRAMS");
	    
	    hash_tipoMedidaDimension.put("IN", "INCHES");
	    hash_tipoMedidaDimension.put("CM", "CENTIMETERS");

	}
	public static String getTipoEmpaqueUPS(String id){
	    return hash_tipoEmpaque.get(id);

	}
	
	public static String getMedidaPeso(String id){
	    return hash_tipoMedidaPeso.get(id);

	}
	
	public static String getMedidaDimension(String id){
	    return hash_tipoMedidaDimension.get(id);

	}

}
