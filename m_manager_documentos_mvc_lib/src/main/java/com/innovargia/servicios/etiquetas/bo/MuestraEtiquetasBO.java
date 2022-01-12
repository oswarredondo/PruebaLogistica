/**
 * 
 */
package com.innovargia.servicios.etiquetas.bo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.ITextObjeto;
import com.administracion.ibo.IAdminConsecutivosBO;
import com.administracion.ibo.IMuestraEtiquetasBO;
import com.administracion.ibo.ITemplateEtiquetaBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.Files;
import com.itext.etiquetas.LabelIETWEB;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class MuestraEtiquetasBO implements IMuestraEtiquetasBO {
	
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;
	@Autowired
	IAdminConsecutivosBO iAdminConsecutivosBO;
	@Autowired
	ITemplateEtiquetaBO iTemplateEtiquetaBO;
	
	private static final Logger logger = LoggerFactory
			.getLogger(EtiquetasBO.class);
	

	/**
	 * 
	 */
	public MuestraEtiquetasBO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String generaPDFGuia(List<Envio> ar_envios, UsuarioDTO usuario,
			String tipoimpresion, String idSistema, String idtemplate) throws Exception {
		
		String verificaMadre = ar_envios.get(0).getesMadre();
		
		if(verificaMadre == null){
			
			verificaMadre = "n";
			
		}
		
		String reimpresion = ar_envios.get(0).getReimpresion();
		
		ITextObjeto template = new ITextObjeto();
//		template.setIdtemplate(idtemplate);
		List<ITextObjeto> lista_detalle_tem = null;
		List<ITextObjeto> arr_template = null;
		
		/* VALIDAMOS QUE SEA ENVIO DE GUIA MADRE */
		if(!verificaMadre.equals("n") && reimpresion == null){
		//if(!verificaMadre.equals("n")){

				
				/* IGUALAMOS  */
				ar_envios =  iTemplateEtiquetaBO.getDatosTablaContenido(ar_envios);
			
				template.setIdtemplate("TRACUSA MADRE");
				lista_detalle_tem = iTemplateEtiquetaBO.getRegistrosLineas(template);
				arr_template = iTemplateEtiquetaBO.getRegistrosTemplate(idtemplate);


			}else{
				
				template.setIdtemplate(idtemplate);
				lista_detalle_tem = iTemplateEtiquetaBO.getRegistrosLineas(template);
				arr_template = iTemplateEtiquetaBO.getRegistrosTemplate(idtemplate);
				
			}
		
//		template.setIdtemplate(idtemplate);
//		lista_detalle_tem  =iTemplateEtiquetaBO.getRegistrosLineas(template);
//		arr_template  =iTemplateEtiquetaBO.getRegistrosTemplate(idtemplate);
		
		if (lista_detalle_tem.size()>0){
			//Toma la plantilla de la base de datos
			return muestrarPDFGuia(ar_envios, usuario,
					ConstantesGenerales._TIPOIMPRESION, ConstantesGenerales.ID_SKY4SOL,arr_template.get(0),lista_detalle_tem);
		}else{
			//Obtiene los datos del archivo
			return muestrarPDFGuia(ar_envios, usuario,
					ConstantesGenerales._TIPOIMPRESION, ConstantesGenerales.ID_SKY4SOL);
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.servicios.etiquetas.bo.IMuestraEtiquetasBO#muestrarPDFGuia(java.util.ArrayList, com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String muestrarPDFGuia(List<Envio> ar_envios,
			UsuarioDTO usuario,
			String tipoimpresion, String idSistema)
			throws Exception {
		
		byte[] bytes = null;

		String pathJaspertReport = iParamsSistemaDAO.getValorPropiedad(
				ConstantesGenerales.PATHIREPORTJASPER,
				ConstantesGenerales.ID_SKY4SOL);

		String pathLogoEtiqueta = iParamsSistemaDAO.getValorPropiedad(
				ConstantesGenerales.PATLOGOETIQUETAS,
				ConstantesGenerales.ID_SKY4SOL)
				+ usuario.getLogo();

		String dirPDFTXTFile = iParamsSistemaDAO.getValorPropiedad(
				ConstantesGenerales.DirPDFTXTFile,
				ConstantesGenerales.ID_SKY4SOL);

		String identificador = salvaDatosArchivo(dirPDFTXTFile, ar_envios,
				usuario.getNumCliente());

		String pathFilePDF = dirPDFTXTFile + identificador + "-"
				+ usuario.getNumCliente() + ".gui";
		String pathpdf = dirPDFTXTFile + identificador + "-"
				+ usuario.getNumCliente() + ".pdf";

		String iddocumento = usuario.getFormatoetiperso() == null ? ConstantesGenerales.FORMATO_ETIQUETA_DEFAUTL
				: ConstantesGenerales.FORMATO_ETIQUETA_DEFAUTL
						+ usuario.getFormatoetiperso();

		// Verifica el tipo de impresion
		if ("PDF4".equals(tipoimpresion)) {
			pathFilePDF = saveDataFilePDF(pathFilePDF, 4);

			File f = new File(pathFilePDF);
			// InputStream in = new FileInputStream(pathFilePDF);
			bytes = Files.getBytesFromFile(f);

			// Devuelve el identificador del archivo
			pathpdf = f.getName();

		} else if ("PDF2".equals(tipoimpresion)
				|| "PERSO".equals(tipoimpresion)) {
			
			
			MetaDatoCatalogoDTO metaDocumento = iAdminConsecutivosBO
					.getMetaDatoCatalogoDTO(iddocumento,
							usuario.entidad.getIdentidad(),
							usuario.organizacion.getIdorganizacion());

			String platilla = metaDocumento.getFormatoiReport();

			// Verifrica si la etiqueta tiene las dimensiones
			String[] arr_platilla_dimensiones = platilla.split("@");
			platilla = arr_platilla_dimensiones[0];

			String ptahfileplantilla = pathJaspertReport + platilla;

			LabelIETWEB ietweb = new LabelIETWEB();
			ietweb.setMapPlantilla(ptahfileplantilla);

			// Indica el tipo de docto a crear de acuerdo a la plantilla
			if (arr_platilla_dimensiones.length <= 1) {
				pathFilePDF = ietweb.createPDFGenerico(ar_envios, pathFilePDF,
						2);
			} else {
				// Verifica que que las dimensiones sean correctas
				// en caso contrario manda el tama�o de media hoja
				String[] arr_dimensiones = arr_platilla_dimensiones[1]
						.split(",");

				if (arr_dimensiones.length > 1) {
					pathFilePDF = ietweb.createPDFGenerico(pathFilePDF,
							Float.parseFloat(arr_dimensiones[0]),
							Float.parseFloat(arr_dimensiones[1]));
				} else {
					pathFilePDF = ietweb.createPDFGenerico(ar_envios,
							pathFilePDF, 2);
				}
			}

			/*File f = new File(pathFilePDF);
			// InputStream in = new FileInputStream(pathFilePDF);
			bytes = Files.getBytesFromFile(f);

			// Devuelve el identificador del archivo
			pathpdf = f.getName();*/

		}

		return pathFilePDF;

	}
	
	@Override
	public String muestrarPDFGuia(List<Envio> ar_envios,
			UsuarioDTO usuario,String tipoimpresion, String idSistema,
			ITextObjeto plantilla,List<ITextObjeto> lista_detalle )
			throws Exception {
		

		String dirPDFTXTFile = iParamsSistemaDAO.getValorPropiedad(
				ConstantesGenerales.DirPDFTXTFile,
				ConstantesGenerales.ID_SKY4SOL);

		String identificador = salvaDatosArchivo(dirPDFTXTFile, ar_envios,
				usuario.getNumCliente());

		//Arma ruta
		/*String pathFilePDF = dirPDFTXTFile + identificador + "-"
				+ usuario.getNumCliente() + ".gui";*/
		String pathFilePDF = dirPDFTXTFile + ar_envios.get(0).getIdEnvio() + "-" + usuario.getNumCliente() + ".gui";

		LabelIETWEB ietweb = new LabelIETWEB();
		ietweb.setMapPlantilla(lista_detalle);
		ietweb.setAcuseSoloLeyenda(plantilla.esAcuseSoloLeyenda());

		//Note: las dimensones se colocan alreves primero el alto y despues el ancho 
		//y de esta forma ya crea las dimensiones de la pagina de forma correcta
		pathFilePDF = ietweb.createPDFGenerico(ar_envios,pathFilePDF,
					plantilla.getAlto(),plantilla.getAncho());

		return pathFilePDF;

	}
	
	
	
     /* Salva los datos de un arreglo en un archivo. los registros
     * del arreglo contien instancias de Envio
     */
    private  String salvaDatosArchivo(String dirPDFTXTFile,List<Envio> lista,String numcliente){
    	
        //Crea el identificador de la guia con
        //AAAAMMDDMMSSmm
        Calendar fecha = Calendar.getInstance();
        //Da formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMDDhhmmSSS");
        String identificador = formato.format(fecha.getTime());
        
        if ((lista==null) || (lista.size()<=0)){
            return "NO_EXISTEN_ENVIOS_"+identificador;
        }
        //Crea una llave
        


        //String nombre_archivo =  dirPDFTXTFile+identificador + "-"+ numcliente +".gui";
        String nombre_archivo =  dirPDFTXTFile + lista.get(0).getIdEnvio() + "-" + numcliente +".gui";
        logger.debug(identificador);
        
        try{
            
            //Crea el objeto para escribir en el archivo
            PrintWriter pw =   new PrintWriter( new BufferedWriter(
            new FileWriter(nombre_archivo)));
            Envio envio;
            String str_envio="";
            for (int i=0;i<lista.size();i++){
                envio = (Envio)lista.get(i);
                if (envio!=null){
                    //Pone el encabezado
                    //GUIA1|RUTA|SERVICIO|EMPRESA_RE|ATENCION_RE|DIRECCION_RE|
                    //COLONIA_RE|MUNICIPIO_RE|ESTADO_RE|CP_RE|TELEFONO_RE|EMPRESA_DE|
                    //ATENCION_DE|DIRECCION_DE|COLONIA_DE|MUNICIPIO_DE|ESTADO_DE|CP_DE|
                    //TELEFONO_DE|CONTENIDO|PESO|COMENTARIO|MULTIPLES|CANTIDAD|REFERENCIA|MONTO|FACTURA
                	str_envio = envio.getInfoEnvio(envio);
                	
                    pw.write(str_envio);
                }//fin del envio null
            }//fin del for
            //se cierra el archivo
            pw.close();
            
            
            File fileGuia = new File(nombre_archivo);
            logger.debug(fileGuia.getAbsolutePath());
            logger.debug(fileGuia.getName());
            
            long sizeFileGuia = fileGuia.length();
            logger.debug(""+sizeFileGuia);
            
        }catch(IOException ioe){
        	logger.debug("Se genero un error en " +
            " salvaDatosArchivo() " + ioe.getMessage() +
            " " + ioe.getCause());
        }//fin de try
        
        return identificador;
    }//fin de salvaDatosArchivo
    
    
    /**
	 * Genera el archivo PDF con los datos de las etiquetas
	 */
	private String saveDataFilePDF(String pathFileText, int tantos) {
		try {
			LabelIETWEB ietweb = new LabelIETWEB();
			String path = ietweb.createPDF(pathFileText, tantos);
			return path;

		} catch (Exception e) {
			logger.debug("No se guardo la info en el archivo:"
					+ e.getMessage());
		}
		return null;
	}




	
	

}
