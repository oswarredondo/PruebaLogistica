/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRParameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.idao.IConexionDAOJDBC;
import com.administracion.ireport.web.ibo.IIReportBO;
import com.administracion.jasperreport.IPrintReport;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsRequest;
import com.ireport.web.dto.IReportDTO;
import com.ireport.web.dto.ParameterDTO;

/**
 * @author Adri�n
 *
 */
@RequestMapping("/ireportweb/")
@Controller
public class IReporteController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(IReporteController.class);
	
	@Autowired
	IIReportBO iiReportBO;
	@Autowired
	IPrintReport iPrintReport;
	
	@Autowired
	IConexionDAOJDBC iReportesDAOJDBC;
	
	/**
	 * 
	 */
	public IReporteController() {
		// TODO Auto-generated constructor stub
	}
	

	@RequestMapping("/getDatosReportes")
	public @ResponseBody
	Map<String, ? extends Object> getDatosReportes(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
			HttpServletRequest request)throws Exception {
		
		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<IReportDTO> lista =null;
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			lista = iiReportBO.getReportesMonitorScanner(usuario);//getReportes(usuario);
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	@RequestMapping("/getDatosForm")
	public @ResponseBody
	Map<String, ? extends Object> getDatosForm(
			@ModelAttribute("reporte") IReportDTO reporte,  
			HttpServletRequest request)throws Exception {
		
	
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<Object> lista =null;
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		
		try {
			
			IReportDTO reporte_tmp = iiReportBO.getReporte(reporte.getIdregistro());
			if (reporte_tmp==null){
				throw new Exception("NO EXISWTS REPORTE SELECCIONADO");
			}
			lista = iPrintReport.getCamposForma(reporte_tmp.getNombre());

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
	

	@RequestMapping("/showReport")
	public @ResponseBody
	Map<String, ? extends Object> showReport(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request
				.getSession(true));
	
		//String jasperfile = request.getParameter("nombrefile");
		int idreporte = Integer.parseInt(request.getParameter("idregistro"));
		String exportType = request.getParameter("exportType");
		byte[] bytes =null;
		String error="";
		try{
			IReportDTO reporte_tmp = iiReportBO.getReporte(idreporte);
			
			List<ParameterDTO> lista = iPrintReport.getParametros(reporte_tmp.getNombre());
			Map<String, Object> map_parametros = new HashMap<String, Object>();
			
			String valor ="";
			for (ParameterDTO p : lista) {
				
				if(p.getName().equals("P_RUTAS")){
					
					valor = (request.getParameter(p.getName()) == null || request.getParameter(p.getName()) == "") ? "AND movimientos.ruta = movimientos.ruta"
							: "AND movimientos.ruta = '"+request.getParameter(p.getName()).trim()+"'";
							
				}else{
					
					valor = request.getParameter(p.getName()) == null ? ""
							: request.getParameter(p.getName()).trim();
				
				}
				
				map_parametros.put(p.getName(), iPrintReport.getObjectParams(p,valor));

			}

			map_parametros.put("USER_ENTIDAD",new Integer(usuario.entidad.getIdentidad()+""));
			map_parametros.put("USER_ORGANIZACION",new Integer(usuario.organizacion.getIdorganizacion()+""));
			map_parametros.put("USER_CUENTA",usuario.getNumCliente());
			map_parametros.put("USER_LOGIN",usuario.getLogin());
			map_parametros.put("USER_PLAZA",usuario.getSiglasPlaza()==null?"":usuario.getSiglasPlaza() );
			map_parametros.put("USER_OFICINA",usuario.getIdoficina()==null?"":usuario.getIdoficina());
			
			//Genera el reporte
			bytes = iPrintReport.genera(exportType, map_parametros, reporte_tmp.getNombre());

			// Incializamos el array
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ServletOutputStream out = response.getOutputStream();

			bos.write(bytes);

			//Verifica el tipo de documento a desplegar
			
			if (bytes!=null){
					
				if(exportType.equals("xls")){

					response.setContentType("application/vnd.ms-excel");
					response.addHeader("Content-Disposition", " attachment; filename=report.xls");
					response.addHeader("Set-Cookie"," fileDownload=true;  path=/");
				
				}
					
					
			}
			
				
			response.setContentLength(bos.size());
			out.write(bos.toByteArray());
			out.flush();
			bos.close();
			out.close();
			response.flushBuffer();
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());
			error = dae.getMessage() ;
			
			if ((error==null) || (error.trim().length()<=0)){
				error="No se puedo visualizar el reporte seleccionado, verifique con el administrador";
			}
	
		}
		

//		//Arroja los datos al stream
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		ServletOutputStream out;
//		try {
//			out = response.getOutputStream();
//			//Verifica el tipo de documento a desplegar
//			if (bytes!=null){
//				response.setContentType("application/"+ exportType);
//			}else{
//				response.setContentType(MimeTypes.getMimeType("*.html"));
//				bytes = error.getBytes();
//			}
//			
//			bos.write(bytes);
//			
//			response.setContentLength(bos.size());
//			out.write(bos.toByteArray());
//			out.flush();
//			bos.close();
//			out.close();
//			response.flushBuffer();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return modelMap;
	}
	
	
	
	
}
