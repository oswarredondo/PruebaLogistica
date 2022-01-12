/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.mail.EmailProperties;
import com.innovargia.mail.HTMLMail;
import com.innovargia.mail.SendEMail;
import com.innovargia.mail.TestGmail;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.ibo.ICotizacionPreConvenioBO;
import com.innovargia.salesmanager.ibo.ICuentasClientesBO;
import com.innovargia.salesmanager.ibo.IUsuarioBO;
import com.innovargia.salesmanager.idao.ICotizacionPreConvenioDAO;
import com.innovargia.salesmanager.idao.IParametrosSistemaDAO;
import com.innovargia.salesmanager.idao.IReportesDAOJDBC;
import com.innovargia.utils.CheckSumUtility;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.GeneradorPassword;
import com.innovargia.utils.UtilsStringFechas;

/**
 * @author aruaro
 * 
 */
@Service
public class CotizacionPreConvenioBO implements ICotizacionPreConvenioBO {

	private static final Logger logger = LoggerFactory
			.getLogger(CotizacionPreConvenioBO.class);

	@Autowired
	ICotizacionPreConvenioDAO dao;
	@Autowired
	IParametrosSistemaDAO iParametrosSistemaDAO;
	@Autowired
	IReportesDAOJDBC iReportesDAOJDBC;
	
	
	
	public CotizacionPreConvenioBO() {

	}

	@Override
	public int insert(ConvenioContratoDTO obj) throws Exception {
		Number idconvenio = dao.insert(obj);

		return idconvenio.intValue();

	}

	@Override
	public void update(ConvenioContratoDTO obj) throws Exception {
		dao.update(obj);

	}

	@Override
	public void delete(ConvenioContratoDTO obj) throws Exception {
		dao.delete(obj);

	}

	@Override
	public ConvenioContratoDTO get(ConvenioContratoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.get(obj);
	}

	@Override
	public void updateEstatus(ConvenioContratoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		dao.updateEstatus(obj);
	}
	


	@Override
	public List<ConvenioContratoDTO> getRegistros(BusquedaDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getRegistros(obj);
	}
	
	@Override
	public void sendMail(ConvenioContratoDTO documento,
			EmailProperties send_email )throws Exception {
		
	
	   	documento = get(documento);
		
		//crea el documento 
		byte[] pdf_documento_bytes = getPDFCotizacion(documento);
		//Obtiene el parametro donde va a depostar el archivo
		String path_archivo_pdf = 
				iParametrosSistemaDAO.getValorPropiedad(ConstantesAdminSale.DirPDFTXTFile, ConstantesAdminSale.ID_APP) ;

		String tipocontrato = 
			(documento.getTipo_contrato()==null || documento.getTipo_contrato().trim().length()<=0)?"docto" :documento.getTipo_contrato().trim();
		String nombre_path =path_archivo_pdf + tipocontrato + "_" +documento.getIdconvenio() +"_"+
					UtilsStringFechas.obtenerFechaActual("yyyyddMMhhmmss") + ".pdf";
					
		FileOutputStream stream = new FileOutputStream(nombre_path);
		try {
		    stream.write(pdf_documento_bytes);
		} finally {
		    stream.close();
		}
		//Complementa la informacion de las propiedades del correo
		EmailProperties email_propiedades = iParametrosSistemaDAO.getPropiedadesEmail(send_email, ConstantesAdminSale.ID_APP_MAIL);
		//Obtiene el correo de quien envia 
		send_email.setMail_from(iParametrosSistemaDAO.getValorPropiedad("mail.send.from", ConstantesAdminSale.ID_APP_MAIL));

		HTMLMail mail = new HTMLMail(email_propiedades);
		mail.addAttach(nombre_path);
		mail.send(true, email_propiedades.isWithDebug());
		
	

	}
	
	@Override
	public byte[] getPDFCotizacion(ConvenioContratoDTO obj) throws Exception{

		byte[] bytes = null;
		Connection cnx  = null;
	
		
		try{
			
			
			//Obtiene el parametro 
			String path_formatos_reporte_jasper = 
					iParametrosSistemaDAO.getValorPropiedad(ConstantesAdminSale.PATHIREPORTJASPER, ConstantesAdminSale.ID_APP) ;

			if (path_formatos_reporte_jasper==null){
				throw new Exception("No existe parametro "+ ConstantesAdminSale.PATHIREPORTJASPER + " configurado para la aplicacion.");
			}
			
			MetaDatoCatalogoDTO metaDocumento = iParametrosSistemaDAO.getDatosTipoDoc(obj.getEstadoactualdoc(), 1, 1);
			if ((metaDocumento== null) || (metaDocumento.getFormatoiReport()==null)){
				throw new Exception("No existe formato de reporte para el tipo de documento " + obj.getEstadoactualdoc());
			}
			//Obtiene el formato del jasper que se va a ejecutar
			String reportejasper = path_formatos_reporte_jasper +metaDocumento.getFormatoiReport();
			cnx  = iReportesDAOJDBC.getConexion();
			
			Map<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("idconvenio",obj.getIdconvenio());
			
			
			//Crea el reporte en la ubicacion indicada
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();			
			JasperPrint print = JasperFillManager.fillReport(reportejasper, parameters, cnx);
			 JRExporter exporter =
					 new net.sf.jasperreports.engine.export.JRPdfExporter();

			exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
			exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);			  
			exporter.exportReport();
			bytes =  byteArrayOutputStream.toByteArray();				 


		}catch(Exception e){
			logger.error("Error al generar el PDF del documento " + obj.getEstadoactualdoc());
			throw new Exception(e.getMessage());
			
		}finally{
			iReportesDAOJDBC.closeConecction(cnx);
		}
		
		return bytes;
	}
	

	
	@Override
	public void updateUsuarioCreador(ConvenioContratoDTO obj) throws Exception {
		dao.updateUsuarioCreador(obj);
		
	}

	@Override
	public void updateTipoCierre(ConvenioContratoDTO obj) throws Exception {
		dao.updateTipoCierre(obj);
		
	}
}
