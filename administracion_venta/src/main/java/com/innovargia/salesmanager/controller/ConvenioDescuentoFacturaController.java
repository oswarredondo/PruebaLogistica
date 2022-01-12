/**
 * 
 */
package com.innovargia.salesmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.ConvenioDescuentoFactura;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.IConvenioDescuentoFacturaBO;
import com.innovargia.salesmanager.json.CatalogoDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adrián
 *
 * /convenio/descuentofactura/delete
 */
@RequestMapping("/convenio/descuentofactura")
@Controller
public class ConvenioDescuentoFacturaController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ConvenioDescuentoFacturaController.class);
	
	@Autowired
	IConvenioDescuentoFacturaBO iConvenioDescuentoFacturaBO;
	
	/**
	 * 
	 */
	public ConvenioDescuentoFacturaController() {
		// TODO Auto-generated constructor stub
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
	@RequestMapping("/getDatos")
	public @ResponseBody
	Map<String, ? extends Object> getDatos(HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ConvenioDescuentoFactura objeto = new ConvenioDescuentoFactura();

		List<ConvenioDescuentoFactura> lista =null;
		try {
		    	
		    	try{
		    	    objeto.setIdconvenio( Integer.parseInt(request.getParameter("idconvenio")) );
		    	    lista  = iConvenioDescuentoFacturaBO.getRegistros(objeto);  
		    	}catch(Exception e){
		    	    lista= new ArrayList<ConvenioDescuentoFactura>();
		    	}
		    	
		    	
			
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
		
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	
	@RequestMapping("/insert")
	public @ResponseBody
	Map<String, ? extends Object> insert(
			@RequestParam(value = "idconvenio", required = true) int idconvenio,
			@RequestParam(value = "rangoinicial", required = true) int rangoinicial,
			@RequestParam(value = "rangofinal" , required = false) int rangofinal,
			@RequestParam(value = "descuento" , required = false) int descuento,
			HttpServletRequest request)	throws Exception {

		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
		    if (usuario != null){
			ConvenioDescuentoFactura objeto = new ConvenioDescuentoFactura();
		    	objeto.setIdconvenio(idconvenio);
		    	objeto.setRangoinicial(rangoinicial);
		    	objeto.setRangofinal(rangofinal);
		    	objeto.setDescuento(descuento);
		    	objeto.setLogin(usuario.getLogin());
		    	iConvenioDescuentoFacturaBO.insert(objeto);
		    	modelMap.put("message", "Registro agregado");
		    }else{
			modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
		    }
		    
		    	
			modelMap.put("success", true);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}
			modelMap.put("message",mensaje);
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
	@RequestMapping("/update")
	public @ResponseBody
	Map<String, ? extends Object> update(
		@RequestParam(value = "idconveniodescfact", required = true) int idconveniodescfact,
		@RequestParam(value = "idconvenio", required = true) int idconvenio,
		@RequestParam(value = "rangoinicial", required = true) int rangoinicial,
		@RequestParam(value = "rangofinal" , required = false) int rangofinal,
		@RequestParam(value = "descuento" , required = false) int descuento,
			HttpServletRequest request)	throws Exception {

		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));


		try {
		    if (usuario != null){
			ConvenioDescuentoFactura objeto = new ConvenioDescuentoFactura();
			objeto.setIdconveniodescfact(idconveniodescfact);
		    	objeto.setIdconvenio(idconvenio);
		    	objeto.setRangoinicial(rangoinicial);
		    	objeto.setRangofinal(rangofinal);
		    	objeto.setDescuento(descuento);
		    	objeto.setLogin(usuario.getLogin());
		    	iConvenioDescuentoFacturaBO.update(objeto);
		    	modelMap.put("message", "Se actualizo registro");
		    }else{
			modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
		    }
			
		    	
			modelMap.put("success", true);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}
			
			modelMap.put("message",mensaje);

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
	@RequestMapping("/delete")
	public @ResponseBody
	Map<String, ? extends Object> delete(
		@RequestParam(value = "idconveniodescfact", required = true) int idconveniodescfact,
			HttpServletRequest request)	throws Exception {


		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
		    if (usuario!=null){
			ConvenioDescuentoFactura objeto = new ConvenioDescuentoFactura();
			objeto.setIdconveniodescfact(idconveniodescfact);
			iConvenioDescuentoFacturaBO.delete(objeto);
			
			modelMap.put("message", "Se elimino registro");
		    }else{
					modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
		    }
		    modelMap.put("success", true);
				
		} catch (DataAccessException dae) {
		    modelMap.put("success", false);
			if (dae.contains(DuplicateKeyException.class)) {
				
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
	}
	
	
	
}
