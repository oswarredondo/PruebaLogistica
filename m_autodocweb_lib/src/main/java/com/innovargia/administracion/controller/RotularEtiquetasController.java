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

import com.administracion.ibo.ICoberturaBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.salesmanager.json.CatalogoDTOJSON;
import com.innovargia.salesmanager.json.EtiquetaRotulacionDTOJSON;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author Adri�n
 * /rotular_etiquetas/getDatosCuentas 
 */
@RequestMapping("/rotular_etiquetas")
@Controller
public class RotularEtiquetasController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RotularEtiquetasController.class);
	
	@Autowired
	IRotulacionEtiquetasDatosBO bo;
	@Autowired
	ICoberturaBO iCoberturaBO;
	
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;
	
	/**
	 * 
	 */
	public RotularEtiquetasController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/getDatosCuentas", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosCuentas(
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO busqueda  = new BusquedaDTO();

		List<CuentasDTO> lista =null;
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				busqueda.setIdentidad(usuario.entidad.getIdentidad());
			}

			//Verifica si se necesita algun tipo de cliente en particular
			if (request.getParameter("tipocliente")!=null){
				try{
					busqueda.setTipo(Integer.parseInt(request.getParameter("tipocliente")));
				}catch(Exception e){
					logger.debug("Tipo de busqueda cliente invalido:" + request.getParameter("tipocliente"));
				}
			}
			lista = bo.getDatosClienteEntidad(busqueda);
			
			modelMap.put("success", true);
			modelMap.put("message", "OK");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	@RequestMapping(value="/getDatosCuentasPorTipoFormaPago", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosCuentasPorTipoFormaPago(
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO busqueda  = new BusquedaDTO();

		List<CuentasDTO> lista =null;
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				busqueda.setIdentidad(usuario.entidad.getIdentidad());
			}
			
			
			
			// Verifica si se necesita algun tipo de cliente en particular
			String tipocliente = request.getParameter("tipocliente") == null
					? ConstantesGenerales.TIPO_BUSQUEDA_CLIENTE_DISTINTO_A_CONSUMO + ""
					: request.getParameter("tipocliente");
			try {

				busqueda.setTipo(Integer.parseInt(tipocliente));

			} catch (Exception e) {
				logger.debug("Tipo de busqueda cliente invalido:" + request.getParameter("tipocliente"));
				busqueda.setTipo(ConstantesGenerales.TIPO_BUSQUEDA_CLIENTE_DISTINTO_A_CONSUMO);
			}

			
			lista = bo.getDatosClienteEntidad(busqueda);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
			
			modelMap.put("success", true);
			modelMap.put("message", "OK");
			
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}

	@RequestMapping(value="/depuraRotulacionTemporal", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
		Map<String, ? extends Object> depuraRotulacionTemporal(
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		EtiquetaRotulacionDTO etiquetaDTO = new EtiquetaRotulacionDTO();
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		bo.depuraRotulacionesTemporales();
		modelMap.put("success", true);
		modelMap.put("message", "Correcto");
		return modelMap;
	}
	
	/**
	 * Agrega un nuevo registro para Rotular
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/creaRegistro", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
		Map<String, ? extends Object> creaRegistro(
				@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				etiquetaDTO.setLogin(usuario.getLogin());
				etiquetaDTO.setIdentidad(usuario.entidad.getIdentidad());
				etiquetaDTO.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				etiquetaDTO.setNumcliente(usuario.getNumCliente()==null?"":usuario.getNumCliente());
			}
			
			List<EtiquetaRotulacionDTO> lista = bo.getRegistrosDatos(etiquetaDTO);  
			etiquetaDTO.setIdtipodocumento("ROTULACION");
			
			int idregistro = bo.insert(etiquetaDTO);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("idregistro", idregistro);
			
		} catch (Exception dae) {
			logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", true);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	
	
	/**
	 * Obtiene las lineas que se configuraron para rotular
	 */
	@RequestMapping(value="/getDatosRegistro", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosRegistro(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<EtiquetaRotulacionDTO> lista =null; 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new Exception( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			lista  = bo.getRegistrosDatos(etiqueta); 
			for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista) {
				bo.validaRegistro(etiquetaRotulacionDTO);
			}
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
				logger.debug("Error al obtener los datos:"+dae.getMessage());
	
		}
		return modelMap;
		
	}
	//bo.validaRegistro(etiquetaRotulacionDTO);
	
	
	/**
	 * Obtiene las lineas que se configuraron para rotular
	 */
	@RequestMapping(value="/validaCoberturaOrigenDestino", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> validaCoberturaOrigenDestino(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta,  
			HttpServletRequest request)throws Exception {


		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			validaEnrutaCobetura(etiqueta.getCp_rem(),etiqueta.getCp_des(),etiqueta.getIdservicio());
			 
		
			modelMap.put("success", true);
			modelMap.put("message", "Si existe cobertura entre Remitente y Destino Seleccionados.");
			
		} catch (Exception dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	@RequestMapping(value="/getDatosSetRegistradosUsuario", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosSetRegistradosUsuario(
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<EtiquetaRotulacionDTO> lista =null; 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			EtiquetaRotulacionDTO etiqueta = new EtiquetaRotulacionDTO();
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}else{
				 etiqueta.setLogin(usuario.getLogin());
			}
			
			 
			
			lista  = bo.getRegistrosSetsUsuario(etiqueta);  
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	@RequestMapping(value="/getDatosCOD", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosCOD(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<EtiquetaRotulacionDTO> lista =null;
		UtilsRequest.displayParametros(request);

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			lista  = bo.getRegistrosDatosCOD(etiqueta);
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	@RequestMapping(value="/getDatosVolumen", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosVolumen(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<EtiquetaRotulacionDTO> lista =null;
		UtilsRequest.displayParametros(request);
 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			lista  = bo.getRegistrosDatosVolumen(etiqueta);
			
			if (etiqueta.getIdconvenio() != 0){
			
				List<SistemaDTO> listaSeguro = iParamsSistemaDAO.getValorPropiedadFloat(etiqueta.getIdconvenio());
				
				float cantAsegurada = Float.parseFloat(listaSeguro.get(0).getIdpropertie());
				
				String ciaseguro = listaSeguro.get(0).getValor();
				
				for(int i = 0; i < lista.size(); i++){
					
					lista.get(i).setValor_asegurado(cantAsegurada);
					
					lista.get(i).setTiene_seguro(ciaseguro);
					
				}
			}
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	@RequestMapping(value="/getDatosObservacionContenido", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosObservacionContenido(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<EtiquetaRotulacionDTO> lista =null;
		UtilsRequest.displayParametros(request);

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			lista  = bo.getRegistrosDatosContenidoObserva(etiqueta);
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	@RequestMapping(value="/getDatosSeguro", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosSeguro(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<EtiquetaRotulacionDTO> lista =null;
		UtilsRequest.displayParametros(request);

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			lista  = bo.getRegistrosDatosSeguro(etiqueta);
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	
	@RequestMapping(value="/getAdicionales", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getAdicionales(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<EtiquetaRotulacionDTO> lista =null;
		UtilsRequest.displayParametros(request);
		try {
			lista  = bo.getRegistrosDatosAdicionales(etiqueta);
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}
	
	

	
	

	@RequestMapping(value="/insertVolumen", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> insertVolumen(
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "estatus" , required = false) String estatus,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
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
	

	@RequestMapping(value="/insertCOD", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> insertCOD(
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "estatus" , required = false) String estatus,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
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
	@RequestMapping(value="/insertSeguro", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> insertSeguro(
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "estatus" , required = false) String estatus,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
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
	
	@RequestMapping(value="/insertRotulacionSet", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> insertRotulacionSet(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			etiquetaDTO.setLogin(usuario.getLogin());
			bo.insertRotulacionSet(etiquetaDTO);
			
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
	
	@RequestMapping(value="/deleteRotulacionSet", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> deleteRotulacionSet(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			etiquetaDTO.setLogin(usuario.getLogin());
			bo.deleteRotulacionSet(etiquetaDTO);
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
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
	 * Actualiza un registro
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateRegistroDatos", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> updateRegistroDatos(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
			HttpServletRequest request)	throws Exception {
		
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				//modelMap.put("message", );
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			if (etiquetaDTO==null){
				modelMap.put("message", "Formateo de datos invalido, verifique.");
			}
			if ((etiquetaDTO.getUuid()==null) || (etiquetaDTO.getUuid().trim().length()>0)){
				modelMap.put("message", "Identificador unico de sesion invalido, verifique");
			}
			if (etiquetaDTO.getIdregistro()<=0){
				modelMap.put("message", "Identificador de registro invalido, verifique");
			}
			if (etiquetaDTO.getNumpiezas()<=0){
				modelMap.put("message", "Cantidad de etiquetas solicitadas invalido, verifique");
			}
			int idregistro = -1;
			String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
					ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS,ConstantesGenerales.ID_SKY4SOL);
			
			if (etiquetaDTO.getIdregistro()<=0){
				
				etiquetaDTO.setEmail_des(request.getParameter("correoe_des"));
				etiquetaDTO.setEmail_rem(request.getParameter("correoe_rem"));
				
				if(!etiquetaDTO.getFecha_cita().isEmpty()){
					
					etiquetaDTO.setFecha_cita(etiquetaDTO.getFecha_cita().substring(0, 10));
					
				}
				
				if (!etiquetaDTO.getHora_cita().isEmpty()){
					
					etiquetaDTO.setHora_cita(etiquetaDTO.getHora_cita().substring(11, 16));
					
				}

				
				etiquetaDTO.setIdtipodocumento("ROTULACION");
				etiquetaDTO.setTiporotucacion(manejo_por_folios_o_convenios);
				
				if (!manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_FOLIOS)){
					String[] convenio_tarifa = etiquetaDTO.getIdservicio().split("-");
					if (convenio_tarifa.length>1){
						etiquetaDTO.setIdconvenio(convenio_tarifa[0]);
						etiquetaDTO.setIdtarifa(convenio_tarifa[1]);
						etiquetaDTO.setIdconveniodetalle(convenio_tarifa[2]);
						etiquetaDTO.setIdservicio(convenio_tarifa[3]);
					}
				}
				
				
				etiquetaDTO.setLogin(usuario.getLogin());
				etiquetaDTO.setIdentidad(usuario.entidad.getIdentidad());
				etiquetaDTO.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				etiquetaDTO.setNumcliente(usuario.getNumCliente()==null?"":usuario.getNumCliente());
				idregistro = bo.insert(etiquetaDTO);
				etiquetaDTO.setIdregistro(idregistro);
			}
			//Actualiza los datos generales
			etiquetaDTO.setIdregistrodatos(etiquetaDTO.getIdregistro());  
			bo.update(etiquetaDTO);
			//Agrega los registros de volumne-contenido, seguro, observaciones
			for(int i=0;i<etiquetaDTO.getNumpiezas();i++){
				
				bo.insertLineaVolumenCOD(etiquetaDTO);
			}
			
			success = true;
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		} catch (Exception dae) {
			logger.debug("Error:"+ dae.getMessage());
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}
			modelMap.put("message", mensaje);
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
	@RequestMapping(value="/depuraUUID", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> depuraUUID(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();


		try {
			List<EtiquetaRotulacionDTO> lista =bo.getRegistrosSets(etiquetaDTO); 
			//Solo los borra cuando no pertenecen a un set de configuracion
			if ((lista!=null) && (lista.size()<=0)){
				bo.depuraUUID(etiquetaDTO);
				modelMap.put("success", true);
				modelMap.put("message", "Borrado");
			}
			
		} catch (DataAccessException dae) {
		
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
	@RequestMapping(value="/deleteRegistroDatos", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> deleteRegistroDatos(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();


		try {
			bo.depuraUUID(etiquetaDTO);
			modelMap.put("success", true);
			modelMap.put("message", "Borrado");
		} catch (DataAccessException dae) {
		
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	

		}
		return modelMap;
	}
	
	
	
	@RequestMapping(value="/getenrutamientos", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getenrutamientos(
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UtilsRequest.displayParametros(request);
		try {
			validaEnrutaCobetura(request.getParameter("cp_rem"),
					request.getParameter("cp_des"),
					request.getParameter("garantia") );   
			
			
			modelMap.put("success", true);
			modelMap.put("message", "ejecutado");
		} catch (Exception dae) {
		
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	

		}
		return modelMap;
	}
	
	@RequestMapping(value="/validarSeguro", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> validarSeguro(
			
		HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UtilsRequest.displayParametros(request);
		
		try {
			

			modelMap.put("success", validaSeguro(request.getParameter("idservicio")));
			
			modelMap.put("message", "ejecutado");
			
		} catch (Exception dae) {
		
				modelMap.put("success", false);
				
				modelMap.put("message", dae.getMessage());
	

		}
		
		return modelMap;
		
	}
	
	/***
	 * Inserta un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/insertJson",  method = { RequestMethod.GET, RequestMethod.POST }, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> insertJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<CatalogoDTO> listaregistros = new ArrayList<CatalogoDTO>();
		String mensaje = "";
		CatalogoDTOJSON dtoJSON = new CatalogoDTOJSON();


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
				//bo.insert(listaregistros.get(i));
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
	

	@RequestMapping(value = "/updateContenidoObservaJson",  method = { RequestMethod.GET, RequestMethod.POST },
			headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> updateContenidoObservaJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<EtiquetaRotulacionDTO> listaregistros = new ArrayList<EtiquetaRotulacionDTO>();
		String mensaje = "";
		EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();


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
				bo.updateVolumen(listaregistros.get(i));
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
	@RequestMapping(value = "/updateVolumenJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> updateVolumenJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<EtiquetaRotulacionDTO> listaregistros = new ArrayList<EtiquetaRotulacionDTO>();
		String mensaje = "";
		EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();


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
				bo.updateVolumen(listaregistros.get(i));
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
	
	/***
	 * INserta un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/deleteLineaJson",  method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> deleteLineaJson(@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<EtiquetaRotulacionDTO> listaregistros = new ArrayList<EtiquetaRotulacionDTO>();
		String mensaje = "";
//		EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();
//		String idregistrodatos = request.getParameter("idregistrodatos");

		try {
//			// Trata de machear la lista de registos
//			dtoJSON.runJSONParser(json);
//			if (dtoJSON.getData().size() == 0) {
//				// sustituye data por registro y vuelve hacer el parseo
//				json = json.replaceAll("proxiArray", "registro");
//				dtoJSON.runJSONParser(json);
//				listaregistros.add(dtoJSON.getRegistro());
//			} else {
//				listaregistros = dtoJSON.getData();
//			}
//
//			for (int i = 0; i < listaregistros.size(); i++) {
//				bo.deleteLinea(listaregistros.get(i));
				bo.deleteLinea(etiqueta);
//			}
//			mensaje = "Se borro el registro con exito";
//			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios seran deshechos, verifique.";
			}

		}

//		dtoJSON.clearData();

		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	/**
	 * Obtiene las lineas que se configuraron para rotular y las comparamos con los convenios activos del cliente
	 * para validar que se puedan crear las etiquetas
	 */
	@RequestMapping(value="/validarDatosRegistro", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> validarDatosRegistro(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<EtiquetaRotulacionDTO> lista =null; 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				throw new Exception( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			/* Obtenemos los datos del setter */
			lista  = bo.getRegistrosDatos(etiqueta); 
			
			/* Validams espacios en blanco y nulos */
			for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista) {
				bo.validaRegistro(etiquetaRotulacionDTO);
			}
			
			List<CruceCoberturaDTO> cobertura;
			
			/* Obtenemos los convenios activos del usuario para validarlos con sus setters guardados con anterioridad
			 * y saber si aun puede realizar etiquetas con ese convenio */
			cobertura = iCoberturaBO.validarConvenioSeguro(usuario.getNumCliente());
			
			boolean aux = true;
			
			/* Variable para almacena los setters invalidos */
			String registrosInvalidos = "";
			
			/* Se recorre la lista de los setters */
			for(int i = 0; i < lista.size(); i++){
				
				/* Se recorre la lista de los convenios activos del usuario 
				 * esto con el fin de recorrer cada dato del setter y comparar con los convenios
				 * y verificar que sean validos */
				for(int j = 0; j < cobertura.size(); j++){
					
					/* Si el convenio de setter se encuentra entre los convenios activos */
					if(lista.get(i).getIdconvenio() == cobertura.get(j).getConvenio()){
						
						/* Si el dato del setter guardado con anterioridad tiene seguro y el convenio ademas de estar activo tiene seguro */
						if("SI".equals(lista.get(i).getTiene_seguro()) && "1".equals(cobertura.get(j).getIdservicio())){
							
							/* Ponemos en true la bandera para mas adelante indicar que dicho dato es valido */
							aux = true;
							
							/* Sale y compara el siguiente dato del setter */
							break;
						
							/* Si el dato del setter guardado con anterioridad tiene seguro y el convenio ademas de estar activo no tiene un seguro activo */
						}else if("SI".equals(lista.get(i).getTiene_seguro()) && ("0".equals(cobertura.get(j).getIdservicio()) || "".equals(cobertura.get(j).getIdservicio()))){
							
							/* Ponemos en falso la bandera para mas adelante indicar que dicho dato es invalido */
							aux = false;
						
						/* En caso de que no tenga seguro */
						}else{
							
							/* Ponemos en true la bandera para mas adelante indicar que dicho dato es valido */
							aux = true;
							
							/* Sale y compara el siguiente dato del setter */
							break;
							
						}
					
					/* En caso de que el convenio del dato del setter no se encuentre en la lista de convenios activos */	
					}else{
						
						/* Ponemos en falso la bandera para mas adelante indicar que dicho dato es invalido */
						aux = false;
						
					}
					
				}
				
				/* En caso de que el dato sea invalido */
				if(aux == false){
					
					/* Agregamos el id a la lista de datos invalidos para indicarlo en la tabla */
					if(registrosInvalidos == ""){
						
						registrosInvalidos = String.valueOf(lista.get(i).getIdregistrodatos());
						
					}else{
						
						registrosInvalidos = registrosInvalidos + "," + String.valueOf(lista.get(i).getIdregistrodatos());
						
					}
					
					
				}
				
				/* Regresamos la variable  true para validar el siguiente dato */
				aux = true;
				
			}
			
			modelMap.put("success", true);
			modelMap.put("message", registrosInvalidos);
			
		} catch (Exception dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
				logger.debug("Error al obtener los datos:"+dae.getMessage());
	
		}
		return modelMap;
		
	}
	
	private boolean validaEnrutaCobetura(String cprem,String  cpdes,String idservicio)throws Exception{
		CruceCoberturaDTO cobertura = new CruceCoberturaDTO();
		cobertura.setIdcoorigen(cprem);
		cobertura.setIdcodestino(cpdes);
		idservicio = idservicio==null?"":idservicio;
		String[] arr_servicio = idservicio.split("-");
		if (arr_servicio.length>2){
			idservicio = arr_servicio[3];
		}
		logger.debug("Validando cobertura:" +cprem + "-" +cpdes +"-"+  idservicio);
		cobertura.setGarantiamax(idservicio);
		CruceCoberturaDTO cobe  = iCoberturaBO.getCobertura(cobertura); 
		if ((cobe==null) || (cobe.getLista_transbordos().size()<=0)){
			throw new Exception("No existe cobertura o frecuencia entre Remitente y Destino Seleccionados.");
		}
		
	
		return true;
	}
	
	private boolean validaSeguro(String idservicio)throws Exception{
		
		CruceCoberturaDTO cobertura = new CruceCoberturaDTO();
		
		boolean TF;
		
		idservicio = idservicio==null?"":idservicio;
		
		cobertura.setIdservicio(idservicio);

		logger.debug("Validando seguro: " + idservicio);
		
		int asegura = iCoberturaBO.getSeguro(cobertura);
		
		if (asegura == 1){
			
			TF = true;
			
		}else{
			
			TF = false;
			
		}
		
	
		return TF;
	}
}
