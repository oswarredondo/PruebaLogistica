/**
 * 
 */
package com.innovargia.administracion.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.ibo.IFoliosBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.json.BusquedaDTOJSON;
import com.innovargia.salesmanager.json.DireccionDTOJSON;
import com.innovargia.salesmanager.json.EtiquetaRotulacionDTOJSON;
import com.innovargia.salesmanager.json.RemDesDTOJSON;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.OficinasDTO;
import com.servicio.search.ibo.IBusquedaOficinasBO;
import com.servicio.search.ibo.ICarteraDireccionesRemDesBO;

/** 
 * @author Adri�n
 * /rotular_etiquetas/carteraremdes/delete
 */
@RequestMapping("/rotular_etiquetas/carteraremdes")
@Controller
public class CarteraClienteRemDesController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CarteraClienteRemDesController.class);
	
	private List<RemDes> listaRemDesConstanteDTO = new ArrayList<RemDes>();
	
	@Autowired
	ICarteraDireccionesRemDesBO bo;
	@Autowired
	IBusquedaOficinasBO iOficinasReceptorasBO;
	
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;
	
	@Autowired
	IFoliosBO iFoliosBO;
	
	/**
	 * 
	 */
	public CarteraClienteRemDesController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(value="/insert", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
		Map<String, ? extends Object> insert(
				@ModelAttribute("remitente") RemDes remitente,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		
		String tipo = request.getParameter("tipo");
		
		/*Si el tipo de de insercion es masiva*/
		if(tipo.equals("masivo")){
			
			try {
				
				if (usuario==null){
					modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
				}else{
					
					 /*Se recorre la lista mientras asigna valores a un objeto REMDES*/
					for(RemDes remitenteMasivo : listaRemDesConstanteDTO){
						
						/*Se asigna identidad y organizacion del usuario en curso a el objeto REMDES */
						remitenteMasivo.setIdentidad(usuario.entidad.getIdentidad());
						
						remitenteMasivo.setIdorganizacion(usuario.organizacion.getIdorganizacion());
						
						/*Metodo de isercion*/
						bo.insert(remitenteMasivo, usuario);
						
						
					}
					
				}
				
				/*Se limpia la lista constante*/
				listaRemDesConstanteDTO.clear();
				
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");

				
			} catch (Exception dae) {
				logger.debug("creaRegistro:" + dae.getMessage());
				modelMap.put("success", true);
				modelMap.put("message", dae.getMessage());
			}
			
		}else if(tipo.equals("individual")){
			
			try {
				
				if (usuario==null){
					modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
				}else{
//					remitente.setNumCliente(usuario.getNumCliente());
					remitente.setIdentidad(usuario.entidad.getIdentidad());
					remitente.setIdorganizacion(usuario.organizacion.getIdorganizacion());
					if(remitente.getNumCliente().equals("")) {
						remitente.setNumCliente(usuario.getLogin());
					}
					//remitente.setTipoDireccion("REM");  
					bo.insert(remitente, usuario);
				}

				
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");

				
			} catch (Exception dae) {
				logger.debug("creaRegistro:" + dae.getMessage());
				modelMap.put("success", true);
				modelMap.put("message", dae.getMessage());
			}
			
		}
		

		return modelMap;
		
	}
	
	@RequestMapping(value="/update", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
		Map<String, ? extends Object> update(
				@ModelAttribute("remitente") RemDes remitente,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				remitente.setNumCliente(usuario.getNumCliente());
				remitente.setIdentidad(usuario.entidad.getIdentidad());
				remitente.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				//remitente.setTipoDireccion("REM");  
				bo.update(remitente);
			}

			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	@RequestMapping(value="/insertaRemitente", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
		Map<String, ? extends Object> insertaRemitente(
				@ModelAttribute("remitente") EtiquetaRotulacionDTO etiquetaDTO,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				RemDes remitente = new RemDes();
				remitente.setRfc(etiquetaDTO.getRfc_rem());
				remitente.setRazonSocial(etiquetaDTO.getRazonsocial_rem());
				remitente.setAtencion(etiquetaDTO.getContacto_rem());
				remitente.setCalle(etiquetaDTO.getCalle_rem());
				remitente.setDireccion(etiquetaDTO.getCalle_rem());
				remitente.setColonia(etiquetaDTO.getColonia_rem());
				remitente.setMunicipio(etiquetaDTO.getMunicipio_rem());
				remitente.setEstado(etiquetaDTO.getEstado_rem());
				remitente.setCp(etiquetaDTO.getCp_rem());
				remitente.setCiudad(etiquetaDTO.getCiudad_rem());
				remitente.setTelefono(etiquetaDTO.getTelefono_rem());
				remitente.setNumcelular(etiquetaDTO.getCelular_rem());
				remitente.setNuminterior(etiquetaDTO.getNuminterior_rem());
				remitente.setNumexterior(etiquetaDTO.getNumexterior_rem()); 
				remitente.setCorreoe(etiquetaDTO.getEmail_rem());
				remitente.setNumCliente(usuario.getNumCliente());
				remitente.setIdentidad(usuario.entidad.getIdentidad());
				remitente.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				remitente.setTipoDireccion("REM");  
				bo.insert(remitente, usuario);
			}
			
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	
	@RequestMapping(value="/insertaDestinatario", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
		Map<String, ? extends Object> insertaDestinatario(
				@ModelAttribute("destinatario") EtiquetaRotulacionDTO etiquetaDTO,  
				HttpServletRequest request)	throws Exception {	
		
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				RemDes destintario = new RemDes();
				destintario.setRfc(etiquetaDTO.getRfc_des());
				destintario.setRazonSocial(etiquetaDTO.getRazonsocial_des());
				destintario.setAtencion(etiquetaDTO.getContacto_des());
				destintario.setCalle(etiquetaDTO.getCalle_des());
				destintario.setDireccion(etiquetaDTO.getCalle_des());
				destintario.setColonia(etiquetaDTO.getColonia_des());
				destintario.setMunicipio(etiquetaDTO.getMunicipio_des());
				destintario.setEstado(etiquetaDTO.getEstado_des());
				destintario.setCp(etiquetaDTO.getCp_des());
				destintario.setCiudad(etiquetaDTO.getCiudad_des());
				destintario.setTelefono(etiquetaDTO.getTelefono_des());
				destintario.setNumcelular(etiquetaDTO.getCelular_des());
				destintario.setNuminterior(etiquetaDTO.getNuminterior_des());
				destintario.setNumexterior(etiquetaDTO.getNumexterior_des()); 
				destintario.setCorreoe(etiquetaDTO.getEmail_des());
				destintario.setNumCliente(usuario.getNumCliente());
				destintario.setIdentidad(usuario.entidad.getIdentidad());
				destintario.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				destintario.setTipoDireccion("DES");
				
				bo.insert(destintario, usuario);
			}
			
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}

	@RequestMapping(value="/getDirecciones", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDirecciones(
			@ModelAttribute("busqueda") BusquedaDTO busqueda,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
			

		List<RemDes> lista =null; 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				busqueda.setIdentidad(usuario.entidad.getIdentidad());
				busqueda.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				if(busqueda.getNumcliente() == null){
					busqueda.setNumcliente(usuario.getLogin());
				}
				lista  = bo.getDirecconesRemDes(busqueda, usuario); 
				modelMap.put("totalCount", lista.size());
				modelMap.put("proxiArray", lista);
			}
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	
	/*Metodo utilizado al momento de agregar una guia*/
	@RequestMapping(value="/getDireccionIndividual", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> getDireccionIndicidual(
			@ModelAttribute("busqueda") BusquedaDTO busqueda,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
			

		List<RemDes> lista =null; 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		
		/*Recibimos si es REM o DES de la variable*/
		String REMDES = request.getParameter("REMDES");
		
		try {
			
			/*Ponemos el patron % por defecto para buscar todos*/
			busqueda.setPatron_busqueda("%");
			
			busqueda.setTipo_str(REMDES);
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				busqueda.setIdentidad(usuario.entidad.getIdentidad());
				busqueda.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				if(busqueda.getNumcliente() == null){
					busqueda.setNumcliente(usuario.getLogin());
				}
				
				lista  = bo.getDirecconesRemDes(busqueda, usuario);
				
			}
			
			if(lista.size() == 1){
				
				String datos = lista.get(0).getRazonSocial()+ "~" + lista.get(0).getNuminterior()+
							   "~" + lista.get(0).getAtencion() + "~" + lista.get(0).getNumexterior()+
							   "~" + lista.get(0).getCp() + "~" + lista.get(0).getColonia()+
							   "~" + lista.get(0).getMunicipio() + "~" + lista.get(0).getEstado()+
							   "~" + lista.get(0).getTelefono() + "~" + lista.get(0).getNumcelular()+
							   "~" + lista.get(0).getCorreoe() + "~" + lista.get(0).getCiudad()+
							   "~" + lista.get(0).getCalle()+ "~" + lista.get(0).getRfc();
 				
				modelMap.put("success", true);
				modelMap.put("message", datos);
				
			}else{
				
				modelMap.put("success", false);
				modelMap.put("message", "");
				
				}
//			modelMap.put("success", true);
//			modelMap.put("message", mensaje);
			
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	
	@RequestMapping(value="/getOficinasReceptoras", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getOficinasReceptoras(
			@ModelAttribute("busqueda") BusquedaDTO busqueda,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
			

		List<OficinasDTO> lista =null; 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				busqueda.setIdentidad(usuario.entidad.getIdentidad());
				busqueda.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				busqueda.setNumcliente(usuario.getNumCliente());
				lista  = iOficinasReceptorasBO.getOficinasReceptoras(busqueda); 
				modelMap.put("totalCount", lista.size());
				modelMap.put("proxiArray", lista);
			}
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	
	/***
	 * INserta un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/deleteJson", method = {RequestMethod.GET, RequestMethod.POST}, 
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> deleteJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<RemDes> listaregistros = new ArrayList<RemDes>();
		String mensaje = "";
		RemDesDTOJSON dtoJSON = new RemDesDTOJSON();


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
				bo.delete(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}

		}

		dtoJSON.clearData();

		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	@RequestMapping(value="/delete", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
		Map<String, ? extends Object> delete(
				@ModelAttribute("destinatario") EtiquetaRotulacionDTO etiquetaDTO,  
				HttpServletRequest request)	throws Exception {	
		
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				RemDes remdes = new RemDes();
				remdes.setIdregistro(etiquetaDTO.getIdregistro()+"");
				bo.delete(remdes);
			}
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	
	@RequestMapping(value = "/uploadRowsJsonFile", method = RequestMethod.POST, headers = {
			"content-type=application/json" })
	public @ResponseBody Map<String, ? extends Object> uploadRowsJsonFile(@RequestBody String json,
			HttpServletRequest request) {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		// logger.debug("json:" + json);
		UtilsRequest.displayParametros(request);
		String mensaje = "";
		try {
			
			/*Se creo la clase RemDesDTOJSON para mapear los datos del archivo*/
			RemDesDTOJSON dtoJSON = new RemDesDTOJSON();
			List<RemDes> listaregistros = new ArrayList<RemDes>();
			json = json.replaceAll("datos", "proxiArray");
			json = json.replaceAll("usuario", "numCliente");

			int lineas_max_archivo = iParamsSistemaDAO.getValorPropiedadInt(
					ConstantesGenerales.LINEAS_PERMITIDAS_EXCEL_ROTULACION, ConstantesGenerales.ID_SKY4SOL);
			
			/*Se mapean los datos*/
			dtoJSON.runJSONParser(json);

			if (dtoJSON.getData().size() >= 0) {

				listaregistros = dtoJSON.getData();

			} else {

				throw new Exception("No existe informacion que exportar.");

			}

			if (listaregistros.size() > lineas_max_archivo) {

				// Solo se toman los primeros lineas_max_archivo registros
				List<RemDes> listaregistros_tmp = new ArrayList<RemDes>();

				for (RemDes etiquetaRotulacionDTO : listaregistros) {

					if (listaregistros_tmp.size() >= lineas_max_archivo) {

						break;

					}

					listaregistros_tmp.add(etiquetaRotulacionDTO);

				}

				listaregistros.clear();

				for (RemDes etiquetaRotulacionDTO : listaregistros_tmp) {

					listaregistros.add(etiquetaRotulacionDTO);

				}

				listaregistros_tmp.clear();

				mensaje = ":Archivo contiene m�s l�neas de las permitidas, se tom�n solo las primeras "
						+ lineas_max_archivo;

			}

			UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

			// Agrega el registro
			int identidad = usuario.entidad.getIdentidad();
			int idorganizacion = usuario.organizacion.getIdorganizacion();
			
			/*Si la lista contiene datos*/
			if (listaRemDesConstanteDTO.size() != 0) {
				
				/*Se limpia la lista para agregar los nuevos registros*/
				listaRemDesConstanteDTO.clear();

			}
			
			/*Se recorre la lista de registros y se asigna a un objeto REMDES*/
			for (RemDes busquedaDTO : listaregistros) {
				
				/*Se le asigna la identidad del usuario en curso al objeto REMDES*/
				busquedaDTO.setIdentidad(identidad);
				
				/*Se le asigna la organizacion del usuario en curso al objeto REMDES*/
				busquedaDTO.setIdorganizacion(idorganizacion);
				
				/*Se agregan los objetos a la lista constante para posteriormente hacer uso de ella al visualizar los datos*/
				listaRemDesConstanteDTO.add(busquedaDTO);

			}

			modelMap.put("success", true);
			modelMap.put("message", "Correcto" + mensaje);

		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", ExcepcionMessage.getMessageExcepcion(e.getMessage()));

		}

		return modelMap;
	}
	
	@RequestMapping(value = "/getDireccionesImport", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> getDireccionesImport(
			@ModelAttribute("busqueda") BusquedaDTO busqueda, HttpServletRequest request) throws Exception {

		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<RemDes> lista = null;
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {

			if (usuario == null) {
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			} else {
				
				/* Igualemos la lista a la lista estatica que tiene los datos de el archivo excel */
				lista = listaRemDesConstanteDTO;

				modelMap.put("totalCount", lista.size());
				modelMap.put("proxiArray", lista);
			}

			modelMap.put("success", true);
			modelMap.put("message", mensaje);

		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;

	}
}
