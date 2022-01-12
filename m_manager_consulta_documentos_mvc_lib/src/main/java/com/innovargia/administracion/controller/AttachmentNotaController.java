/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.administracion.ibo.IAttachmentNotaBO;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.Files;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.constantes.ConstantesAdminSale;

/**
 * @author Adri�n 
 * 
 */
@RequestMapping("/attachmentnota")
@Controller
public class AttachmentNotaController {

	private static final Logger logger = LoggerFactory
			.getLogger(AttachmentNotaController.class);

	@Autowired
	IAttachmentNotaBO iAttachmentBO;

	/***
	 * Agrega un registro
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> insert(
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "estatus", required = false) String estatus,
			HttpServletRequest request) throws Exception {

		boolean success = false;
		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {
			success = true;
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}

		}
		return modelMap;
	}
	
	

	/**
	 * Obtiene los datos de un catalogo, solo los registros que estan activos
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getDatos",method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatos(HttpServletRequest request)throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO objeto = new BusquedaDTO();
		objeto.setEstatus(-1);
		List<AttachmentDTO> lista =null;   
		try { 
			displayParametros(request);
			if ( (request.getParameter("identificador")!=null) && (request.getParameter("idtipodocumento")!=null ) ){
				objeto.setIdentificador_str(request.getParameter("identificador"));
				objeto.setTipo_str(request.getParameter("idtipodocumento"));
			}
			lista  = iAttachmentBO.getRegistros(objeto);  
			for (AttachmentDTO attachmentDTO : lista) {
				attachmentDTO.setNombre_archivo("");
			}
			
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			logger.info("Error en la consulta de Notas:" + dae.getMessage());
				modelMap.put("success", false);
				modelMap.put("message", "Error en la consulta de Notas");


		}
		return modelMap;
		
	}
	@RequestMapping(value="/getDatosNotaAgenda",method=RequestMethod.GET)
	public @ResponseBody
	Map<String, ? extends Object> getDatosNotaAgenda(HttpServletRequest request)throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO objeto = new BusquedaDTO();
		objeto.setEstatus(-1);
		List<AttachmentDTO> lista =null;   
		try { 
			displayParametros(request); 
			if ( (request.getParameter("identificador")!=null) && (request.getParameter("idtipodocumento")!=null ) ){
				objeto.setIdentificador_str(request.getParameter("identificador"));
				objeto.setTipo_str(request.getParameter("idtipodocumento"));
			}
			
			objeto.setTipo(1);
			lista  = iAttachmentBO.getRegistrosNotasAgenda(objeto);  
			for (AttachmentDTO attachmentDTO : lista) {
				attachmentDTO.setNombre_archivo("");
			}
			
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			logger.info("Error en la getDatosNotaAgenda:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
			

		}
		return modelMap;
		
	}
	/**
	 * Borra un registro
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		AttachmentDTO att= new AttachmentDTO() ;
		try {
			if (ids!=null){
				String[] arr_idsclientes = ids.trim().split("\\|");
				for (String id : arr_idsclientes) {
					try{
						att.setNombre_archivo(id);//MimeTypes.getNameFileWithoutExt(id));
						iAttachmentBO.delete(att);
					}catch(Exception e){
						logger.error("Identificador de cliente invalido:" + id);
					}
					
				}
			}
			modelMap.put("success", true);
			modelMap.put("message", "Registros seleccionados fueron desactivados");
		} catch (Exception dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
		}
		return modelMap;
	}
	
	

	/**
	 * Maneja la subida del archivo de texto para ser procesado
	 * 
	 * @param name
	 *            El nombre del archivo
	 * @param file
	 *            El archivo en cuesti�n
	 * @return El resultado de la operaci�n
	 */
	@RequestMapping(value = "/upload", method = { RequestMethod.GET, RequestMethod.POST },
			headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> upload(
	//public ModelAndView upload(
			@RequestParam(value = "file_upload", required = false) MultipartFile archivo_procesar,
			@RequestParam(value = "extenciones_validas", required = false) String extenciones_validas,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "idtipodocumento", required = false) String idtipodocumento,
			@RequestParam(value = "identificador", required = false) String identificador,
			HttpServletRequest request) {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		String mensaje = "";
		String file_name = "";
		AttachmentDTO attachment = new AttachmentDTO();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		if (usuario == null) {
			mensaje = ConstantesAdminSale.MSG_SESSION_FINISH;
		} else {
			// Evaluar que el archivo no venga vac�o
			
				try {
					InputStream inputstream=null;
					if (archivo_procesar!=null){
						
						if (!archivo_procesar.isEmpty()) {
							//mensaje = "Archivo vacio";
							// Leemos el archivo y lo transformamos en l�neas
							inputstream = archivo_procesar.getInputStream();
							// Quita todos los espacios intermedios y los sustituye por
							// guion y convierte la cadena a minisculas
							String extencion = MimeTypes.getExtencion( archivo_procesar.getOriginalFilename().trim());
							file_name = UUIDUniqueCreator.generateUUID()+ "." + extencion;
							/*file_name = archivo_procesar.getName().trim()
									.replaceAll(" ", "_").toLowerCase();*/   
							
						
						}else{
							file_name = UUIDUniqueCreator.generateUUID();
						}
					}
					
					attachment.setNombre_archivo(file_name);  
					attachment.setIdentificador(identificador);
					attachment.setDescripcion(descripcion);
					attachment.setIdtipodocumento(idtipodocumento);
					attachment.setLogin(usuario.getLogin());

					// Guarda el archivo en la base de datos y de forma fisica
					// en el server
					iAttachmentBO.insert(attachment, inputstream);

					mensaje = "Se salvo la informacion";
					modelMap.put("success", true);

				} catch (Exception e) {
					modelMap.put("success", false);
					mensaje = "Ocurri� un error inesperado:" + e.getMessage();
				}
			}
		

		modelMap.put("message", mensaje);
		return modelMap;
		/*String json = "";
		Gson gson = new Gson();
		json = gson.toJson(result);
		return new ModelAndView("json", "json", json);*/
	}

	/**
	 * Download the selected file to the client.
	 * 
	 * @param request  
	 * @param response
	 * @param fileName
	 *            The name of the file to open, including path info if not in
	 *            the root log directory.
	 */
	@RequestMapping(value = "/downloadFile",method={RequestMethod.GET, RequestMethod.POST})
	public void downloadFile(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "idregistro", required = false) int idregistro) {
		try {

			String fileName = null;
			AttachmentDTO registro = iAttachmentBO.getRegistro(idregistro);

			if (registro != null) {
				fileName = registro.getNombre_archivo();
			} else {
				throw new Exception("No existe reistro del documento o ya fue depurado");
			}
			
			
			File file = iAttachmentBO.getFile(fileName);
			byte[] content = new byte[(int) file.length()];
			String mimetype = MimeTypes.getMimeType(fileName);

			// response.setContentType("application/octet-stream");
			response.setContentType(mimetype);
			if (mimetype.equals("application/octet-stream")) {
				response.setHeader("Content-Disposition",
						"attachment;filename=" + fileName);
			} else {
				response.setHeader("Content-Disposition", "outline;filename=\""
						+ fileName + "\"");
			}
			response.setHeader("Cache-Control", "cache, must-revalidate");
			response.setHeader("Pragma", "public");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setContentLength(content.length);
			FileInputStream in = new FileInputStream(file);
			FileCopyUtils.copy(in, response.getOutputStream());

		} catch (Exception e) {
			logger.debug("Error al descargar el archivo:" + e.getMessage());
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
		}
	}



	/**
	 * Muestra el archivo solo para tipos de pdf, png, gif, jpg, texto, cvs
	 * 
	 * @param fileName
	 *            FileName includes path information if file is not in the root
	 *            log directory.
	 * @return file found
	 */
	@RequestMapping(value = "/viewArchivo",method={RequestMethod.GET, RequestMethod.POST})
	public void viewArchivo(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "idregistro", required = false) int idregistro) {
		byte[] bytes =null;
		try {
			String fileName = null;
			AttachmentDTO registro = iAttachmentBO.getRegistroBase64(idregistro);

			if (registro != null) {
				fileName = registro.getNombre_archivo();
			} else {
				throw new Exception("No existe reistro del documento o ya fue depurado");
			}
			String mimetype = MimeTypes.getMimeType(fileName);
			File file = null;
			if (registro.getBase64()!=null){
				//Intenta realizar el archivo para bytes
				try{
					Base64 b = new Base64();
					bytes = b.decode(registro.getBase64());
				}catch(Exception e){
					//Si no logra hacerlo lo va a tratar por medio del archivo
					logger.debug("No se logro convertir la cadena base 64 al achivo: " + fileName +
							", se intenta buscando el archivo físico");
				}
				
			}
			String error= "<p>No se pudo vusalizar archivo " + fileName +" para el documeto seleccionado.<p>";
			if (bytes==null){
				//Intenta busqueda por archivo fisico
				file = iAttachmentBO.getFile(fileName);
				
				try{
					bytes= Files.getBytesFromFile(file);

				}catch(Exception e){
					logger.error("Error al visualizar el archivo:" + e.getMessage());
					error= "El recurso solicitado no puede ser desplegado o ya no existe como historial.";
					
				}
			}
			
			

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ServletOutputStream out = response.getOutputStream();

			//Verifica el tipo de documento a desplegar
			if (bytes!=null){
				response.setContentType(mimetype);// "application/pdf");
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
			logger.error("Error:", e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	

	private void displayParametros(HttpServletRequest request) {

		Enumeration enumera = request.getParameterNames();

		while (enumera.hasMoreElements()) {
		    String attribute = (String) enumera.nextElement();
		    logger.info("" + attribute + "=" + request.getParameter(attribute));
		}

	    }


}
