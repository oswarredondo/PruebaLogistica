/**
 * 
 */
package com.administracion.jasperreport;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.administracion.idao.IConexionDAOJDBC;
import com.administracion.idao.IParamsSistemaDAO;
import com.administracion.jasperreport.utils.ConstantesIReport;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;
import com.ireport.web.dto.CheckBox;
import com.ireport.web.dto.DateBox;
import com.ireport.web.dto.IntegerBox;
import com.ireport.web.dto.NumberBox;
import com.ireport.web.dto.ParameterDTO;
import com.ireport.web.dto.StringBox;
import com.ireport.web.dto.TimeBox;
import com.servicio.constantes.ConstantesGenerales;



/**
 * @author aruaro
 *
 */
@Service
public class PrintReport implements IPrintReport {
	private static final Logger logger = LoggerFactory
			.getLogger(PrintReport.class);
	
	
	@Autowired
	IParamsSistemaDAO iParamsSistemaIReportDAO;
	@Autowired
	IConexionDAOJDBC iReportesDAOJDBC;

	
	/**
	 * 
	 */
	public PrintReport() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public byte[] genera(String tipo,Map<String,Object> parameters,String reportejasper  ) throws Exception{ 
		Connection cnx  = null;
		
		try {
			String pathJaspertReport = iParamsSistemaIReportDAO.getValorPropiedad(
					ConstantesGenerales.PATHIREPORTJASPER,
					ConstantesGenerales.ID_SKY4SOL);
			
			reportejasper =pathJaspertReport + reportejasper ;
			
			cnx  = iReportesDAOJDBC.getConexion();
			return genera(tipo,parameters,reportejasper, cnx);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("El reporte no puede ser procesado, verifique con el administrador.");
		}finally{
			iReportesDAOJDBC.closeConecction(cnx);
		}
		
	}
	/* (non-Javadoc)
	 * @see com.administracion.jasperreport.IPrintReport#genera(java.lang.String, java.util.Map, java.lang.String, java.sql.Connection)
	 */
	@Override
	public byte[] genera(String tipo,Map<String,Object> parameters,String reportejasper,Connection cnx  ) throws Exception{
		
		try{
			Set<String> keys = parameters.keySet();  //get all keys
			for(String key: keys){
				logger.debug("Parametro:" + key  + ", Valor:" + parameters.get(key));
			}
			logger.debug("Generando reporte con tipo:" +tipo + ",reportejasper:" + reportejasper + ", cnx:" + cnx );
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			JasperPrint print = JasperFillManager.fillReport(reportejasper,
					parameters, cnx);
			JRExporter exporter = null;
			logger.debug("Convirtiedo a :" +tipo );
			//Configura el tipo
			if (tipo.equals(ConstantesIReport.TIPO_PDF)){
				exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			}else if (tipo.equals(ConstantesIReport.TIPO_EXCEL)){
				exporter = new net.sf.jasperreports.engine.export.JRXlsExporter();
			}else if (tipo.equals(ConstantesIReport.TIPO_CSV)){
				exporter = new net.sf.jasperreports.engine.export.JRCsvExporter(); 
			}else if (tipo.equals(ConstantesIReport.TIPO_HTML)){
				exporter = new net.sf.jasperreports.engine.export.JRHtmlExporter();
			}
			
			//Crea el archivo		
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
					byteArrayOutputStream);
			exporter.exportReport();
			byte[] bytes = byteArrayOutputStream.toByteArray();	
			logger.debug("bytes a :" +bytes );
			return bytes;
		}catch(Exception e ){
			logger.debug("Error genera:" +e.getMessage() );
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	@Override
	public List<Object> getCamposForma(String pathFile, UsuarioDTO usuario) throws Exception{
	

		logger.debug("Obteniendo parametros de jasper:" + pathFile );
		List<ParameterDTO> list_parametros =  getParametros(pathFile);
		logger.debug("Configurando " +  list_parametros.size()  +"parametros" );
		List<Object> lista_objetos = getParametrosExtJS(list_parametros);
		
		return lista_objetos;
		
	}
	@Override
	public List<Object> getCamposForma(String pathFile) throws Exception{
		

		/*logger.debug("Obteniendo parametros de jasper:" + pathFile );
		List<ParameterDTO> list_parametros =  getParametros(pathFile);
		logger.debug("Configurando " +  list_parametros.size()  +"parametros" );
		List<Object> lista_objetos = getParametrosExtJS(list_parametros);*/
		
		return getCamposForma(pathFile, null);
		
	}
	
	@Override
	public  List<ParameterDTO> getParametros(String pathFile) throws Exception{
		//Agrega la extenci�n
		//if (!pathFile.contains(".jasper")){
		//	pathFile = pathFile +".jasper";
		//}
		String pathJaspertReport = iParamsSistemaIReportDAO.getValorPropiedad(
				ConstantesGenerales.PATHIREPORTJASPER,
				ConstantesGenerales.ID_SKY4SOL);
		
		pathFile =pathJaspertReport + pathFile ;
		
		JasperReport jasperReport = null;
		List<ParameterDTO> list_parametros = new ArrayList<ParameterDTO>();
		try {
			jasperReport = getJasperReport(pathFile);
			if (jasperReport != null) {

				//jw.convertRequestParameters(jasperReport, null, null);
				JRParameter[] params = jasperReport.getParameters();
				ParameterDTO parameterDTO = null;
				for (JRParameter p : params) {
					// Solo obtiene los parametros que no son del sistema y que
					// son de
					// entrada
					if (!p.isSystemDefined() && p.isForPrompting()) {

						parameterDTO = getTypeParams(p.getName(), "",
								p.getValueClass());
						list_parametros.add(parameterDTO);
					}
				}

			} else {

			}
		} catch (Exception e) {
			logger.debug("Error al abrir reporte " +  e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_parametros;
	}
	
	private  List<Object> getParametrosExtJS(List<ParameterDTO> lista_parametros){

		/*List<Object> lista_objetos = new ArrayList<Object>();
		try {
			for (ParameterDTO p : lista_parametros) {
				lista_objetos.add( getTypeParamsExtJS(p) ) ;
			}

		} catch (Exception e) {
			logger.debug("getParametrosExtJS" +  e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return getParametrosExtJS(lista_parametros,null);
				

	}
	
	private  List<Object> getParametrosExtJS(List<ParameterDTO> lista_parametros, UsuarioDTO usuario){

		List<Object> lista_objetos = new ArrayList<Object>();
		try {
			for (ParameterDTO p : lista_parametros) {
				lista_objetos.add( getTypeParamsExtJS(p, usuario) ) ;
			}

		} catch (Exception e) {
			logger.debug("getParametrosExtJS" +  e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista_objetos;

	}

	
	/**
	 * Returns a JasperReport by its file name. If the report's jasper file is found then it is loaded and returned.
	 * Otherwise, we look for an jrxml file and compile it to the jasper file first.
	 * 
	 * @param reportName
	 *            the name of the JasperReport to return.
	 * @return the corresponding JasperReport ready to be filled.
	 * @throws JRException
	 *             if something went wrong.
	 * @throws FileNotFoundException 
	 */
	private  JasperReport getJasperReport(String reportName) throws JRException, FileNotFoundException {
		
		//Agrega la extenci�n
		String jasperFilename="";
		//if (!reportName.contains(".jasper")){
		//	jasperFilename=reportName +".jasper";
		//}else{
			jasperFilename=reportName;
		//}
				
		
		
		File file=new File(jasperFilename);
		if(file.exists()) {
			logger.debug("loading jasper file from "+file.getPath());
			JasperReport jasperReport=(JasperReport)JRLoader.loadObject(file); 
			return jasperReport;
		}
		reportName = jasperFilename.replace(".jasper", ".jrxml");
		InputStream is = new FileInputStream(reportName);

		logger.debug("loading jrxml file from "+reportName+" and compiling it to "+file.getPath());
		JasperDesign design=JRXmlLoader.load(is);
		JasperReport jasperReport=JasperCompileManager.compileReport(design);
		JRSaver.saveObject(jasperReport,file);
		return jasperReport;
	}
	
	/**
	 * Obtiene el tipo de objeto de acuerdo al parametro del reporte, si no tiene un tipo de clase
	 * definida, se manda excecpion y null el objeto
	 * @param name
	 * @param parameterValue
	 * @param clazz
	 * @return
	 */
	private Object convert(String name, String parameterValue ,Class clazz ){
		if( clazz.equals( java.lang.Boolean.class ) ) {
           return new Boolean(parameterValue);
        } else if( clazz.equals( java.lang.Byte.class ) ) {
        	 return null;
          
        } else if( clazz.equals( java.lang.Double.class ) ) {
        	 return new Double(parameterValue);
           
        } else if( clazz.equals( java.lang.Float.class ) ) {
        	 return new Float(parameterValue);
           
        } else if( clazz.equals( java.lang.Integer.class ) ) {
        	 return new Integer(parameterValue);
           
        } else if( clazz.equals( java.lang.Long.class ) ) {
        	 return new Long(parameterValue);
          
        } else if( clazz.equals( java.lang.Short.class ) ) {
        	 return new Short(parameterValue);
           
        } else if( clazz.equals( java.math.BigDecimal.class ) ) {
        	 return new BigDecimal(parameterValue);
           
        } else if( clazz.equals( java.lang.String.class ) ) {
        	return UtilsStrings.formateaCadenaComillas(parameterValue.toString());
        } else if( clazz.equals( java.util.Date.class ) ) {
        	
        	//CONVERTIR FECHA FORMATO
        	 return FechasDateTimeStamp.valueOfDate(parameterValue, FechasDateTimeStamp.FORMATO_yyyy_MM_dd)  ;
        } else if( clazz.equals( java.sql.Timestamp.class ) ) {
        	
        	return  FechasDateTimeStamp.valueOfTimeStamp(parameterValue);//new java.sql.Timestamp();//(java.sql.Timestamp) parameterValue ;
       
        } else if( clazz.equals( java.sql.Time.class ) ) {
        	
        	if (parameterValue==null) parameterValue ="00:00:00";
        	if (parameterValue.trim().length()==5) parameterValue +=":00";
            return FechasDateTimeStamp.valueOfTime(parameterValue); //new java.sql.Time((long)parameterValue) ;
                 
        } else {
        	logger.debug("Tipo de dato desconocido");
        }
		return null;
	}
	
	/**
	 * Obtiene el tipo de objeto de acuerdo al parametro del reporte, si no tiene un tipo de clase
	 * definida, se manda excecpion y null el objeto
	 * @param name
	 * @param parameterValue
	 * @param clazz
	 * @return
	 */
	private ParameterDTO getTypeParams(String name, String parameterValue ,Class clazz ){

		ParameterDTO parameter = new ParameterDTO();
		parameter.setName(name);
		parameter.setValue(parameterValue);
		
		if( clazz.equals( java.lang.Boolean.class ) ) {
			parameter.setXtype("boolean");
        } else if( clazz.equals( java.lang.Byte.class ) ) {
        	parameter.setXtype("byte");
          
        } else if( clazz.equals( java.lang.Double.class ) ) {
        	parameter.setXtype("double");
        	
           
        } else if( clazz.equals( java.lang.Float.class ) ) {
        	parameter.setXtype("float");
           
        } else if( clazz.equals( java.lang.Integer.class ) ) {
        	parameter.setXtype("integer");
           
        } else if( clazz.equals( java.lang.Long.class ) ) {
        	parameter.setXtype("long");
          
        } else if( clazz.equals( java.lang.Short.class ) ) {
        	parameter.setXtype("short");
           
        } else if( clazz.equals( java.math.BigDecimal.class ) ) {
        	parameter.setXtype("bigdecinal");
           
        } else if( clazz.equals( java.lang.String.class ) ) {
        	parameter.setXtype("string");
        } else if( clazz.equals( java.util.Date.class ) ) {
        	parameter.setXtype("date");
        } else if( clazz.equals( java.sql.Timestamp.class ) ) {
        	parameter.setXtype("timestamp");
            
        } else if( clazz.equals( java.sql.Time.class ) ) {
        	parameter.setXtype("time");
            
        } else {
            try {
				throw new JRException( "Tipo de parametro no soportado : " + name
				        + " class " + clazz.getName() );
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return parameter;
	}
	
	/**
	 * Obtiene el tipo de objeto de acuerdo al parametro del reporte, si no tiene un tipo de clase
	 * definida, se manda excecpion y null el objeto
	 * @param name
	 * @param parameterValue
	 * @param clazz
	 * @return
	 */
	private Object getTypeParamsExtJS(ParameterDTO parametro, UsuarioDTO usuario ){
	
		if ("boolean".equals(parametro.getXtype())){
			CheckBox obj = new CheckBox();
			obj.setName(parametro.getName());
			obj.setId(parametro.getName()+"boolean_id");
			obj.setFieldLabel(parametro.getName());
			return obj;
		}else if ("byte".equals(parametro.getXtype())){
			NumberBox obj = new NumberBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"byte_id");
			return obj;
		}else if ("double".equals(parametro.getXtype())){
			NumberBox obj = new NumberBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"double_id");
			return obj;
		}else if ("float".equals(parametro.getXtype())){
			NumberBox obj = new NumberBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"float_id");
			return obj;
		}else if ("integer".equals(parametro.getXtype())){
			IntegerBox obj = new IntegerBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"integer_id");
			return obj;
		}else if ("long".equals(parametro.getXtype())){
			NumberBox obj = new NumberBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"long_id");
			return obj;
		}else if ("short".equals(parametro.getXtype())){
			IntegerBox obj = new IntegerBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"short_id");
			return obj;
		}else if ("bigdecinal".equals(parametro.getXtype())){
			NumberBox obj = new NumberBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"bigdecinal_id");
			return obj;
		}else if ("string".equals(parametro.getXtype())){
			
			StringBox obj = new StringBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"string_id");
			//Verifica si los datos de usuario estan definidos
			if (usuario!=null){
				//Valida si se trata de un dato generico 
				//P_LOGIN, P_CLIENTE,P_PLAZA,P_OFICINA
				if ( ("P_LOGIN".equals(parametro.getName())) || 
					 ("P_CLIENTE".equals(parametro.getName())) ||
					 ("P_PLAZA".equals(parametro.getName())) ||
					 ("P_OFICINA".equals(parametro.getName())) ){
					
					obj.setReadOnly("true");
					
					//Ajusta el valor
					if  ("P_LOGIN".equals(parametro.getName())){
						obj.setValue(usuario.getLogin());
					}else if  ("P_CLIENTE".equals(parametro.getName())){
						obj.setValue(usuario.getNumCliente());
					}else if  ("P_PLAZA".equals(parametro.getName())){
						obj.setValue(usuario.getSiglasPlaza());
					}else if  ("P_OFICINA".equals(parametro.getName())){
						obj.setValue(usuario.getIdoficina());
					}
				}
			}
			return obj;
			
		}else if ("date".equals(parametro.getXtype())){
			DateBox obj = new DateBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"string_id");
			return obj;
		}else if ("timestamp".equals(parametro.getXtype())){
			DateBox obj = new DateBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"string_id");
			return obj;
		}else if ("time".equals(parametro.getXtype())){
			TimeBox obj = new TimeBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"string_id");
			return obj;
		}else{
			StringBox obj = new StringBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"string_id");
			
			//Verifica si los datos de usuario estan definidos
			if (usuario!=null){
				//Valida si se trata de un dato generico 
				//P_LOGIN, P_CLIENTE,P_PLAZA,P_OFICINA
				if ( ("P_LOGIN".equals(parametro.getName())) || 
					 ("P_CLIENTE".equals(parametro.getName())) ||
					 ("P_PLAZA".equals(parametro.getName())) ||
					 ("P_OFICINA".equals(parametro.getName())) ){
					
					obj.setReadOnly("true");
					
					//Ajusta el valor
					if  ("P_LOGIN".equals(parametro.getName())){
						obj.setValue(usuario.getLogin());
					}else if  ("P_CLIENTE".equals(parametro.getName())){
						obj.setValue(usuario.getNumCliente());
					}else if  ("P_PLAZA".equals(parametro.getName())){
						obj.setValue(usuario.getSiglasPlaza());
					}else if  ("P_OFICINA".equals(parametro.getName())){
						obj.setValue(usuario.getIdoficina());
					}
				}
			}
			
			return obj;
		}

	}
	@Override
	public Object getObjectParams(ParameterDTO parametro, String value ){
		
		if ("boolean".equals(parametro.getXtype())){
			Boolean obj = new Boolean(value);
			return obj;
		}else if ("byte".equals(parametro.getXtype())){
			NumberBox obj = new NumberBox();
			obj.setName(parametro.getName());
			obj.setFieldLabel(parametro.getName());
			obj.setId(parametro.getName()+"byte_id");
			return obj;
		}else if ("double".equals(parametro.getXtype())){
			Double obj = new Double(value);
			return obj;
		}else if ("float".equals(parametro.getXtype())){
			Float obj = new Float(value);
			return obj;
		}else if ("integer".equals(parametro.getXtype())){
			Integer obj = new Integer(value);
			return obj;
		}else if ("long".equals(parametro.getXtype())){
			Long obj = new Long(value);
			return obj;
		}else if ("short".equals(parametro.getXtype())){
			Integer obj = new Integer(value);
			return obj;
		}else if ("bigdecinal".equals(parametro.getXtype())){
			BigDecimal obj = new BigDecimal(value);
			return obj;
		}else if ("string".equals(parametro.getXtype())){
			//verifica si la cadena tiene comas y las sustituye
			return value; //UtilsStrings.formateaCadenaComillas(value);
			
		}else if ("date".equals(parametro.getXtype())){
			java.util.Date date = FechasDateTimeStamp.stringToDate(value, "yyyy-MM-dd");
			return date;
		}else if ("timestamp".equals(parametro.getXtype())){
			java.util.Date date = FechasDateTimeStamp.stringToDate(value, "yyyy-MM-dd");
			return date;
		}else if ("time".equals(parametro.getXtype())){
			java.util.Date date = FechasDateTimeStamp.stringToDate(value, "yyyy-MM-dd");
			return date;
		}else{
			return UtilsStrings.formateaCadenaComillas(value);
			
		}

	}
	
	@Override
	public String getObjectParamsString(ParameterDTO parametro, String value ){
		
		if ("boolean".equals(parametro.getXtype())){
			Boolean obj = new Boolean(value);
			return obj.booleanValue()+"";
		}else if ("byte".equals(parametro.getXtype())){
			return value;
		}else if ("double".equals(parametro.getXtype())){
			Double obj = new Double(value);
			return obj.doubleValue()+"";
		}else if ("float".equals(parametro.getXtype())){
			Float obj = new Float(value);
			return obj.floatValue()+"";
		}else if ("integer".equals(parametro.getXtype())){
			Integer obj = new Integer(value);
			return obj.intValue()+"";
		}else if ("long".equals(parametro.getXtype())){
			Long obj = new Long(value);
			return obj.longValue()+"";
		}else if ("short".equals(parametro.getXtype())){
			Integer obj = new Integer(value);
			return obj.intValue()+"";
		}else if ("bigdecinal".equals(parametro.getXtype())){
			BigDecimal obj = new BigDecimal(value);
			return obj.byteValue()+"";
		}else if ("string".equals(parametro.getXtype())){
			//verifica si la cadena tiene comas y las sustituye
			return value; //UtilsStrings.formateaCadenaComillas(value);
			
		}else if ("date".equals(parametro.getXtype())){
			java.util.Date date = FechasDateTimeStamp.stringToDate(value, "yyyy-MM-dd");
			return  FechasDateTimeStamp.formatoFecha(date, "yyyy-MM-dd hh:mm:ss");
		}else if ("timestamp".equals(parametro.getXtype())){
			java.util.Date date = FechasDateTimeStamp.stringToDate(value, "yyyy-MM-dd");
			return  FechasDateTimeStamp.formatoFecha(date, "yyyy-MM-dd hh:mm:ss");
		}else if ("time".equals(parametro.getXtype())){
			java.util.Date date = FechasDateTimeStamp.stringToDate(value, "yyyy-MM-dd");
			return  FechasDateTimeStamp.formatoFecha(date, "hh:mm:ss");
		}else{
			return UtilsStrings.formateaCadenaComillas(value);
			
		}

	}
	
	/*private String formateaCadena(String value){
		if (!value.contains("','")){
			//Primero a comas paa evitar que se pongan incompletos
			value = value.replaceAll("','", ",");
			//Formate correctamente la separaci�n con comillas
			String tmp_value =value.replace(",", "','");
			tmp_value = "'" + tmp_value + "'";
			return tmp_value;
		}else{
			if (!"'".equals(value.charAt(0)+"")){
				value = "'"+value;
			}
			if (!"'".equals(value.charAt(value.length()-1)+"")){
				value = value+ "'";
			}
			return value;
		}
	}*/
	
}
