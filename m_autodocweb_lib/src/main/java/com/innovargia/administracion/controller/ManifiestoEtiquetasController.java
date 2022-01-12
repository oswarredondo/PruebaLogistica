/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.ibo.IManifiestoLogisticaBO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsRequest;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.ManifiestoDTO;

/**
 * @author Adrian Morales Ruaro
 *
 */
@RequestMapping("/manifiestoetiquetas")
@Controller
public class ManifiestoEtiquetasController {
    
    private static final Logger logger = LoggerFactory
		.getLogger(ManifiestoEtiquetasController.class);

	@Autowired
	IManifiestoLogisticaBO manifiestosBO;

	public static String _TIPODOCUMENTO = "ORDENSERV";
	private int POSICION_FINAL_MANIF= 32000;
	
	/**
	 * 
	 */
	public ManifiestoEtiquetasController() {
		// TODO Auto-generated constructor stub
	}
	
	private void muestrarManifiestoPDF(ManifiestoDTO manifiesto,
			HttpServletResponse response, boolean isReimpresion,
			UsuarioDTO usuario) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Obtiene todos los parametros
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("P_MANIFIESTO", manifiesto.getManifiesto());
		logger.info("Manifiesto etiquetas P_MANIFIESTO:" + manifiesto.getManifiesto());

		// Cuandose trata de una re
		if (isReimpresion) {
			parameters.put("REIMPRESION", com.innovargia.utils.Fechas.Fecha());
		} else {
			parameters.put("REIMPRESION", "");
		}

		byte[] bytes = manifiestosBO.generarManifiestoPDF(manifiesto,
				parameters, usuario);

		// Incializamos el array
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ServletOutputStream out = response.getOutputStream();

		bos.write(bytes);

		response.setContentType("application/pdf");
		response.setContentLength(bos.size());
		out.write(bos.toByteArray());
		out.flush();
		bos.close();
		out.close();
		response.flushBuffer();

	}
	

	private void muestrarError(String error, HttpServletResponse response) throws IOException {

		if ((error==null) || (error.trim().length()<=0)){
			error ="No se puede mostrar el reporte solicitado, verifique con el administrador.";
		}
		byte[] bytes = error.getBytes();

		// Incializamos el array
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ServletOutputStream out = response.getOutputStream();

		bos.write(bytes);

		response.setContentType(MimeTypes.getMimeType("*.html"));
		response.setContentLength(bos.size());
		out.write(bos.toByteArray());
		out.flush();
		bos.close();
		out.close();
		response.flushBuffer();
		 

	}

	@RequestMapping(value="/consultaRegistrosParaManifiestoEntrega", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> consultaRegistrosParaManifiestoEntrega(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request
				.getSession(true));

		// Obtiene los registros para el manifiesto
		ManifiestoDTO manifiesto = new ManifiestoDTO();
		manifiesto.setManifiesto(request.getParameter("manifiesto"));
		manifiesto.setTipomanifiesto(request.getParameter("tipomanifiesto"));
		manifiesto.setTipoDocumento(request.getParameter("tipodocumento"));
		manifiesto.setSoloSinManifestar(request.getParameter("sinManifiestar"));
		List<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();

		try {

			if (manifiesto.getManifiesto() == null)
				return null;

			if (usuario == null) {
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			lista = manifiestosBO.consultaRegistrosParaManifiestoEntrega(
					manifiesto, usuario);

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}

		return modelMap;
	}

		
	@RequestMapping(value="/consultaRegistrosParaManifiesto", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> consultaRegistrosParaManifiesto(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request
				.getSession(true));

		List<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();

		// Obtiene los registros para el manifiesto
		ManifiestoDTO manifiesto = new ManifiestoDTO();
		manifiesto.setRuta(request.getParameter("ruta"));
		manifiesto.setTipoDocumento(_TIPODOCUMENTO);
		manifiesto.setFechaini(request.getParameter("fechaini"));
		manifiesto.setFechafin(request.getParameter("fechafin"));
		manifiesto.setPreAsigandoPendiente(request
				.getParameter("preAsigandoPendiente"));
		manifiesto.setSoloSinManifestar(request.getParameter("sinManifiestar"));

		try {

			if (usuario == null) {
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			}

			if ((manifiesto.getFechaini() == null)
					|| (manifiesto.getRuta() == null)) {
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			} else {
				lista = manifiestosBO.consultaRegistrosParaManifiesto(
						manifiesto, usuario);

				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("totalCount", lista.size());
				modelMap.put("proxiArray", lista);
			}

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}

		return modelMap;
	}

	@RequestMapping(value="/reimprimeManifiesto", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> reimprimeManifiesto(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request
				.getSession(true));


		try {

			if (usuario == null) {
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			}

			ManifiestoDTO manifiesto = new ManifiestoDTO();
			manifiesto.setManifiesto(request.getParameter("manifiesto"));
			if (request.getParameter("tipomanifiesto")==null){
				manifiesto.setTipoDocumento("MANIFIESTO");
			}else{
				manifiesto.setTipoDocumento(request.getParameter("tipomanifiesto"));
				
			}
			
			muestrarManifiestoPDF( manifiesto,  response,true,usuario);
		} catch (Exception dae) {
			muestrarError(dae.getMessage(),response);

		}

		return modelMap;
		
		
	}
	

	@RequestMapping(value="/applyAsignaAManifiesto", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> applyAsignaAManifiesto(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request
				.getSession(true));

		String str_manifiesto = null;
		try {

			if (usuario == null) {
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			}

			ManifiestoDTO  manifiesto = new ManifiestoDTO();
			manifiesto.setRuta(request.getParameter("ruta"));
			manifiesto.setLogin(request.getParameter("login"));
			manifiesto.setFechaini(request.getParameter("fechaini"));
			manifiesto.setFechafin(request.getParameter("fechafin"));
			manifiesto.setEnrutamientoTransportista(request.getParameter("enrutamiento"));
			manifiesto.setTipoDocumento("MANIFIESTO");
			
			str_manifiesto = manifiestosBO.updateManifiestoRegistros(manifiesto,usuario, request.getParameter("tipodocumento"));
			
			String unidad_reparto ="";
			String pos_manif="";
			//Actualiza los datos de cada guia solo en el caso de que se hayan dado de alta los datos de
			if (request.getParameter("guias")!=null){
				String[] arr_guias = request.getParameter("guias").trim().split("\\|",-1);
				String[] arr_documentos_marca= null; 
				//Recorre cada unos de los registros
				for (int i=0;i<arr_guias.length;i++){
					
					 arr_documentos_marca=arr_guias[i].trim().split(",",-1);
					 //Actualiza los datos de la guia
					 if (arr_documentos_marca.length>=3){
						 manifiesto = new ManifiestoDTO();
						 manifiesto.setManifiesto(str_manifiesto);   
						 //Checa documento   
						 if (arr_documentos_marca[0]!=null){
							 manifiesto.setIdDocumento(arr_documentos_marca[0]);
							 //Verifica unidad reparto 
							 if ((arr_documentos_marca[1]!=null) && (arr_documentos_marca[1].trim().length()>0)){
								try{
									 manifiesto.setPos_manif(Integer.parseInt(arr_documentos_marca[1]));
									 //Si la posicion es cero indica la posicion 32000 paa que se vaya al 
									 //final del manifiesto   
			    					//La posicion 32000 indica que no se ha personalizado por lo que va al ultimo del manifiesto
			    					//posicion_num = posicion_num==0?32000:posicion_num;
			    					//Solo para registros que hayan sufrido cambios
									 if (manifiesto.getPos_manif()==0){
										 manifiesto.setPos_manif(POSICION_FINAL_MANIF);
									 }
								}catch(Exception e){
									 manifiesto.setPos_manif(POSICION_FINAL_MANIF);
								}
								
							 }else{
								 manifiesto.setPos_manif(POSICION_FINAL_MANIF);
							 }
							 
							 if ((arr_documentos_marca[2]!=null) && (arr_documentos_marca[2].trim().length()>0)){
								 manifiesto.setUnidadreparto(arr_documentos_marca[2]);
							 }
							 //Actualiza datos complementarios
							 manifiestosBO.updatePosicionUnidadRepartoRegistros(manifiesto, usuario);
							 
							
						 }
					 }
					
				}
				
			}
			//Crea el manifiesto invocando a jaspert
			if (str_manifiesto!=null){
				manifiesto.setManifiesto(str_manifiesto);
				manifiesto.setTipoDocumento("MANIFIESTO");   
				muestrarManifiestoPDF( manifiesto,  response,false,usuario);

			}else{    
				throw new Exception("Error al actualizar manifiestos");
			}
			

			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		
			
		} catch (Exception dae) {
			muestrarError(dae.getMessage(),response);
	
		}

		return modelMap;
		
	}
	
	/**
	 * Asigna todos los envios seleccionados de etiquetas para ser manifestados
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="/applyAsignaAManifiestoEtiquetas", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> applyAsignaAManifiestoEtiquetas(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request
				.getSession(true));
	
		
		ManifiestoDTO  manifiesto = new ManifiestoDTO();
		manifiesto.setRuta(request.getParameter("ruta"));
		manifiesto.setLogin(request.getParameter("login"));
		manifiesto.setFechaini(request.getParameter("fechaini"));
		manifiesto.setFechafin(request.getParameter("fechafin"));
		manifiesto.setEnrutamientoTransportista(request.getParameter("enrutamiento"));
		manifiesto.setTipoDocumento("MANIFIESTO");
		  
		String str_manifiesto = null;
		try{
			

			//String unidad_reparto ="";
			//String pos_manif="";
			//Actualiza los datos de cada guia solo en el caso de que se hayan dado de alta los datos de
			if (request.getParameter("guias")!=null){
				String[] arr_guias = request.getParameter("guias").trim().split("\\|",-1);
				str_manifiesto = manifiestosBO.updateManifiestoRegistrosEtiquetas(manifiesto,usuario,request.getParameter("tipodocumento"),arr_guias);
			}
			
			//Crea el manifiesto invocando a jaspert
			if (str_manifiesto!=null){
				manifiesto.setManifiesto(str_manifiesto);
				manifiesto.setTipoDocumento("MANIFIESTO");   
				muestrarManifiestoPDF( manifiesto,  response,false,usuario);
    
			}else{    
				throw new Exception("Error al actualizar manifiestos");
				
			}
			
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		
			
		} catch (Exception dae) {
			muestrarError(dae.getMessage(),response);
	
		}

		return modelMap;
	}
	

	
	
	@RequestMapping(value="/applyAsignaAManifiestoEntregaTransportista", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> applyAsignaAManifiestoEntregaTransportista(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request
				.getSession(true));

		String documentos = request.getParameter("guias")==null?"":request.getParameter("guias");
		documentos = documentos==null?"":documentos.trim();
		
		String[] arr_documentos = documentos.split("\\|");
		
		ManifiestoDTO  manifiesto = null;
		String tipodocumento_registros = request.getParameter("tipodocumento");  //Tipo documento enviado de acuerdo a la tabla de caTipoDcoumento
		ArrayList<ManifiestoDTO> arr_manifiesto = new ArrayList<ManifiestoDTO>();
		for (int i = 0; i < arr_documentos.length; i++) {
			manifiesto = new ManifiestoDTO();
			manifiesto.setIdDocumento(arr_documentos[i]);
			manifiesto.setTipoDocumento(tipodocumento_registros);
			arr_manifiesto.add(manifiesto);
		}

		try{
			
			if (documentos.isEmpty()){
				throw new Exception("No fueron seleccionados documentos a manifestar o ya fueron"
						+ " manifestados previamente.");
			}
			       
			ManifiestoDTO  datos_manifiesto_consecutivo = new ManifiestoDTO();
			datos_manifiesto_consecutivo.setTipoDocumento("MANIFENTR");     
			
			String str_manifiesto = manifiestosBO.updateManifiestoRegistrosEtiquetas(datos_manifiesto_consecutivo,
					usuario,tipodocumento_registros ,arr_documentos );

			if (str_manifiesto!=null){
				datos_manifiesto_consecutivo.setManifiesto(str_manifiesto);
				muestrarManifiestoPDF( datos_manifiesto_consecutivo,  response,false,usuario);

			}else{
				throw new Exception("Error al actualizar manifiestos");
			
			}
			
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		
			
		} catch (Exception dae) {
			muestrarError(dae.getMessage(),response);
		}

		return modelMap;
	}
	

	
	/**
	 * Obtiene el detalle de la carga asiganda o pendiente de un usuario o
	 * usuarios para impresion de manifiesto de etiquetas
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="/consultaRegistrosEtiquetasCarga", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> consultaRegistrosEtiquetasCarga(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request
				.getSession(true));
	

	
			
		try {
			ManifiestoDTO manifiesto = new ManifiestoDTO();
			
			String login = ((request.getParameter("login")==null) || 
				("".equals(request.getParameter("login"))))?null:request.getParameter("login").trim().toUpperCase();
			
			//Si el nivel del usuario es Usuario entonces solo obtene 
			//la informacion del usuario de sesion
			String nivel = usuario.perfil_Dto.getNivel();
			if ("U".equals(nivel)){
				login = usuario.getLogin();
			}
			List<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();
			manifiesto.setLogin(login);
			manifiesto.setTipoDocumento("ETIQU");
			manifiesto.setFechaini(request.getParameter("fechaini"));
			manifiesto.setFechafin(request.getParameter("fechafin"));
			manifiesto.setSoloSinManifestar(request.getParameter("sinManifiestar"));   
			if (manifiesto.getFechaini()!=null){   
			    manifiesto.setFechaini(manifiesto.getFechaini()+ " 00:00:00");
			    manifiesto.setFechafin(manifiesto.getFechafin()+" 23:59:59");
			    lista = manifiestosBO.getDetalleManifiestoEtiquetas(manifiesto, usuario);
			}
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}

		return modelMap;
			
	}

}
