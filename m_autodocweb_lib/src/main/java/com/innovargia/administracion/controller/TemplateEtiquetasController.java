/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.ITextObjeto;
import com.administracion.ibo.IEtiquetasBO;
import com.administracion.ibo.IMuestraEtiquetasBO;
import com.administracion.ibo.ITemplateEtiquetaBO;
import com.innovargia.custom.exception.DBException;
import com.innovargia.custom.exception.UsuarioException;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.salesmanager.json.ITextObjectDTOJSON;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.Files;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsRequest;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author Adri�n
 * /template_etiquetas/deleteRegistroTemplate 
 */
@RequestMapping("/template_etiquetas")
@Controller
public class TemplateEtiquetasController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(TemplateEtiquetasController.class);
	
	@Autowired
	IRotulacionEtiquetasDatosBO iRotulacionEtiquetasDatosBO;
	@Autowired
	IEtiquetasBO iEtiquetasBO;
	@Autowired
	IMuestraEtiquetasBO iMuestraEtiquetasBO;
	@Autowired
	ITemplateEtiquetaBO iTemplateEtiquetaBO;
	
	
	@RequestMapping(value="/getDatosTemplate", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosTemplate(
			@ModelAttribute("template") ITextObjeto template,  
			HttpServletRequest request)throws Exception {

		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<ITextObjeto> lista =null; 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			if (template.getIdregistro()<=0){
				lista  =iTemplateEtiquetaBO.getRegistrosTemplate("");
			}else{
				lista  =iTemplateEtiquetaBO.getRegistrosTemplate(template);
			}
			
			
		
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
		} catch (UsuarioException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		} catch (DBException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", "No se logro crear el detalle del template, verifique con el administrador.");
		}	
		
		return modelMap;
		
	}
	
	@RequestMapping(value="/getDatosTemplateDetalle", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosTemplateDetalle(
			@ModelAttribute("template") ITextObjeto template,  
			HttpServletRequest request)throws Exception {

	
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<ITextObjeto> lista =null; 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			List<ITextObjeto> lista_templates = iTemplateEtiquetaBO.getRegistrosTemplate(template);
			ITextObjeto mytemplate=null;
			if (!lista_templates.isEmpty()){
				mytemplate= lista_templates.get(0);
			}
			if (mytemplate==null){
				throw new DBException("No existe el template indicado, verifique.");
			}
			lista  =iTemplateEtiquetaBO.getRegistrosLineas(mytemplate);
			
		
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DBException dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		} catch (UsuarioException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", "No se logro crear el detalle del template, verifique con el administrador.");
		}	
		return modelMap;
		
	}
	
	
	@RequestMapping(value="/clonarTemplate", method = {  RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
		Map<String, ? extends Object> clonarTemplate(
				@ModelAttribute("template") ITextObjeto template,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		
		try {
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			//IdTemplate Clone
			String idtemplateclone = request.getParameter("idtemplateclone");
			if ((idtemplateclone==null) || (idtemplateclone.trim().length()<=0)){
				throw new Exception( "Identificador de Template invalido.");
			}
			
			iTemplateEtiquetaBO.insertTemplateClone(template,idtemplateclone);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			
		
		} catch (DBException dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		} catch (UsuarioException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", "No se logro crear el detalle del template, verifique con el administrador.");
		}	
	
		return modelMap;
		
	}
	
	@RequestMapping(value="/creaRegistroTemplate",
			method = {  RequestMethod.POST })
	public @ResponseBody
		Map<String, ? extends Object> creaRegistroTemplate(
				@ModelAttribute("template") ITextObjeto template,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			iTemplateEtiquetaBO.insertTemplate(template);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			
	
		
		} catch (DBException dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		} catch (UsuarioException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", "No se logro crear el detalle del template, verifique con el administrador.");
		}	
	
		return modelMap;
		
	}
	
	@RequestMapping(value="/creaRegistroTemplateDetalle",
			method = {  RequestMethod.POST })
	public @ResponseBody
		Map<String, ? extends Object> creaRegistroTemplateDetalle(
				@ModelAttribute("template") ITextObjeto template,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			iTemplateEtiquetaBO.insertTemplateDetalle(template);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		
		} catch (DBException dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		} catch (UsuarioException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
	
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", "No se logro crear el detalle del template, verifique con el administrador.");
		}
		return modelMap;
		
	}
	
	
	@RequestMapping(value="/updateRegistroTemplate",method = {  RequestMethod.POST })
	public @ResponseBody
		Map<String, ? extends Object> updateRegistroTemplate(
				@ModelAttribute("template") ITextObjeto template,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			iTemplateEtiquetaBO.updateTemplate(template);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			
		
		} catch (DBException dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		} catch (UsuarioException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", "No se logro crear el detalle del template, verifique con el administrador.");
		}	
			return modelMap;
		
	}
	
	
	
	@RequestMapping(value="/updateRegistroTemplateDetalle",
			method = {  RequestMethod.POST })
	public @ResponseBody
		Map<String, ? extends Object> updateRegistroTemplateDetalle(
				@ModelAttribute("template") ITextObjeto template,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			iTemplateEtiquetaBO.updateTemplateDetalle(template);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			
		} catch (DBException dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		} catch (UsuarioException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", "No se logro crear el detalle del template, verifique con el administrador.");
		}	
		return modelMap;
		
	}
	
	@RequestMapping(value="/deleteRegistroTemplate",method = {  RequestMethod.POST })
	public @ResponseBody
		Map<String, ? extends Object> deleteRegistroTemplate(
				@ModelAttribute("template") ITextObjeto template,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			iTemplateEtiquetaBO.deleteTemplate(template, template);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			
		} catch (DBException dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		} catch (UsuarioException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", "No se logro crear el detalle del template, verifique con el administrador.");
		}	
		return modelMap;
		
	}
	
	@RequestMapping(value="/deleteRegistroTemplateDetalle",method = {  RequestMethod.POST })
	public @ResponseBody
		Map<String, ? extends Object> deleteRegistroTemplateDetalle(
				@ModelAttribute("template") ITextObjeto template,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			iTemplateEtiquetaBO.deleteTemplateDetalle(template);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			
		} catch (DBException dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		} catch (UsuarioException dae) {
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", "No se logro crear el detalle del template, verifique con el administrador.");
		}	
		return modelMap;
		
	}
	
	@RequestMapping(value = "/viewPDFArchivo",method = { RequestMethod.GET, RequestMethod.POST })
	public void viewPDFArchivo(HttpServletRequest request,
			@ModelAttribute("template") ITextObjeto template,  
			HttpServletResponse response) {

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		
		byte[] bytes=null;
		String archivo="";
		String error= "<p>No se pudo crear archivo PDF del documento.<p>";
		try {
		
			List<ITextObjeto> lista  =iTemplateEtiquetaBO.getRegistrosTemplate(template);
			if (lista.isEmpty()){
				throw new Exception("No existen informacion del template ["+template.getIdregistro()+"] solicitado, verifique.");
			}
			List<ITextObjeto> lista_detalle  =iTemplateEtiquetaBO.getRegistrosLineas(lista.get(0));
			
		
			
			if (usuario==null){
				throw new UsuarioException( ConstantesAutoDoc.MSG_SESSION_FINISH);
				
			} else if ((lista_detalle==null) || (lista_detalle.size()<=0)){
				error ="NO EXISTE DETALLE CONFIGURADO PARA EL TEMPLATE.";
					
			}else{
				
				template = lista.get(0);
				
				if (template==null){
					throw new Exception("No existen informacion del template solicitado, verifique.");
				}
				RemDes remitente = new RemDes();
				remitente.setNumCliente("00001");
				remitente.setRazonSocial("RAZONSOCIAL_REM");
				remitente.setAtencion("ATENCION_CONTACTO_REM");
				remitente.setDireccion("CALLE_REM NUM_INT NUM_EXT");
				remitente.setCalle("CALLE_REM NUM_INT NUM_EXT");
				remitente.setColonia("COLONIA_REM");
				remitente.setNuminterior("NUM_INT_REM");
				remitente.setNumexterior("NUM_EXT_REM");
				remitente.setCiudad("CIUDAD_REM");
				remitente.setMunicipio("MUNICIPIO_REM");
				remitente.setCp("88888");    
				remitente.setTelefono("TELEFONO_REM");
				remitente.setCorreoe("CORREO_REM@EMAIL.COM");
				remitente.setRfc("RFC0000000REM");
				remitente.setPais("MEXICO");
				
				RemDes destinatario = new RemDes();
				destinatario.setNumCliente("00001");
				destinatario.setRazonSocial("RAZONSOCIAL_DES");
				destinatario.setAtencion("ATENCION_CONTACTO_DES");
				destinatario.setDireccion("CALLE_DES NUM_INT NUM_EXT");
				destinatario.setCalle("CALLE_DES NUM_INT NUM_EXT");
				destinatario.setColonia("COLONIA_DES");
				destinatario.setNuminterior("NUM_INT_DES");
				destinatario.setNumexterior("NUM_EXT_DES");
				destinatario.setCiudad("CIUDAD_DES");
				destinatario.setMunicipio("MUNICIPIO_DES");
				destinatario.setCp("55555");
				destinatario.setTelefono("TELEFONO_DES");
				destinatario.setCorreoe("CORREO_DES@EMAIL.COM");
				destinatario.setRfc("RFC0000000DES");
				
				destinatario.setPais("MEXICO");
				
				
				
				Envio envio_tmp = new Envio();
				envio_tmp.remitente = remitente;
				envio_tmp.destinatario= destinatario;
				
				envio_tmp.setLineaenruta1("CEL-HMO-R");
				envio_tmp.setLineaenruta2("CEL-APT-C-75");   
				envio_tmp.setLineaenruta3("APT-HMO-R");
				envio_tmp.setLineaenruta4("CEL-HMO-R");
				
				envio_tmp.setLogin("INNOVAGIA");
				envio_tmp.setIdOficina("P2345");
				envio_tmp.setUsuarioimprime("INNOVARGIA USER");
				
				List<CruceCoberturaDTO> arr_transbordos = new ArrayList<CruceCoberturaDTO>();
				CruceCoberturaDTO cobetura = null;
				for (int i=1;i<6;i++){
				    cobetura = new CruceCoberturaDTO();
				    cobetura.setTerminal_ori("ORI"+i);
				    cobetura.setTerminal_des("DES"+i);
				    cobetura.setPrecio(i+20);
				    arr_transbordos.add(cobetura);
				}
				
				envio_tmp.setArr_transbordos(arr_transbordos);
				envio_tmp.setLogo("/opt/recursos/images_logos/logoInferior.gif");
				
				envio_tmp.setFuerzaventas("FUERZA DE VENTAS");
				envio_tmp.setOficinacontrol("MEX-OFCTRL");
				envio_tmp.setDescripcionfolioconvenio("VARIABLE");
				envio_tmp.setAdicional("FXC-TRL-CSR");
				
				
				envio_tmp.setIdEnvio("0010000107000000171");
				envio_tmp.setAcuse(true);
				envio_tmp.setMultiples("1/N");
				envio_tmp.setAlto(10);
				envio_tmp.setAncho(11);
				envio_tmp.setLargo(13);
				envio_tmp.setCantidad(1);
				envio_tmp.setDes_garantia("DESCRIPCION GARANTIA");
				envio_tmp.setDes_servicio("DESCRIPCION SERVICIO");
				envio_tmp.setConsecutivo(000001);
				envio_tmp.setSiglasPlaza("SPLAZA");
				envio_tmp.setSiglasDestino("SDES");
				envio_tmp.setSiglasOrigen("SORI");
				envio_tmp.setRuta("RUTAENTREGA");
				
				envio_tmp.setContenido("CONTENIDO");
				envio_tmp.setPeso(99);
				envio_tmp.setComentario("OBSERVACION/COMENTARIO");
				envio_tmp.setReferencia("REFERENCIA");
				envio_tmp.setMonto(9999.99);
				envio_tmp.setS_monto("9998.99");
				envio_tmp.setEnrutadoPor("ENRUTAMIENTO");
				envio_tmp.setIdguiamadremultiple("12345678909876543212");
				envio_tmp.setOcurre(true);
				List<Envio> arr_envios = new ArrayList<Envio>();
				arr_envios.add(envio_tmp);

				//Genera y obtiene el nombre del archivo
				List<ITextObjeto> lista_detalle_tem  =iTemplateEtiquetaBO.getRegistrosLineas(template);
				if (lista_detalle_tem==null || lista_detalle_tem.size()<=0 ){
					throw new Exception("No existen lineas de detalle para la plantilla indicada:" + template.getIdtemplate());
				}
				archivo = iMuestraEtiquetasBO.generaPDFGuia(arr_envios, usuario,
						ConstantesGenerales._TIPOIMPRESION, ConstantesGenerales.ID_SKY4SOL,template.getIdtemplate());
				
				//archivo =iMuestraEtiquetasBO.muestrarPDFGuia(arr_envios, usuario,
				//		ConstantesGenerales._TIPOIMPRESION, ConstantesGenerales.ID_SKY4SOL,lista.get(0),lista_detalle);
				
				try{
					File f = new File(archivo);
					bytes = Files.getBytesFromFile(f);
				}catch(Exception e){
					logger.debug("Error al crear el PDF de las etiquetas:" + e.getMessage() );
					error= "<p>No se pudo crear archivo PDF del documento.<p>";
				}
				
			}

		

		} catch (Exception e) {
			logger.error("Error:", e);
			error =  e.getMessage() ;//"Error: " + HttpServletResponse.SC_INTERNAL_SERVER_ERROR + ", [" + e.getMessage() +"]";
		}
		
		//Arroja los datos al stream
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ServletOutputStream out;
		try {
			out = response.getOutputStream();
			//Verifica el tipo de documento a desplegar
			if (bytes!=null){
				response.setContentType(MimeTypes.getMimeType("*.pdf"));
			}else{
				response.setContentType(MimeTypes.getMimeType("*.html"));
				bytes = error.getBytes();
			}
			
			bos.write(bytes);
			
			response.setContentLength(bos.size());
			out.write(bos.toByteArray());
			out.flush();
			bos.close();
			out.close();
			response.flushBuffer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/***
	 * Actualiza un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/updateJson", method = RequestMethod.POST,
			consumes="application/json")
	public @ResponseBody
	Map<String, ? extends Object> updateJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ITextObjeto> listaregistros = new ArrayList<ITextObjeto>();
		String mensaje = "";
		ITextObjectDTOJSON dtoJSON = new ITextObjectDTOJSON();
	
		try {
			// Trata de machear la lista de registos
			dtoJSON.runJSONParser(json);
			if (dtoJSON.getData().size() == 0) {
				// sustituye data por registro y vuelve hacer el parseo
				json = json.replaceAll("proxiArray", "registro");
				dtoJSON.runJSONParser(json);
				listaregistros.add(dtoJSON.getRegistro());
			} else {
				listaregistros = dtoJSON.getData();
			}

			for (int i = 0; i < listaregistros.size(); i++) {
				iTemplateEtiquetaBO.updateTemplateDetalle(listaregistros.get(i));
				
			}
			mensaje = "Se Actualizo el registro con exito";
			result.put("success", true);
		} catch (DBException dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			mensaje= "Error al crear o modidificar la informacion, verifique con el administrador";
		} catch (UsuarioException dae) {
			mensaje= dae.getMessage();
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			mensaje= "No se logro crear el detalle del template, verifique con el administrador.";
		}	
	
		
		dtoJSON.clearData();

		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
}
