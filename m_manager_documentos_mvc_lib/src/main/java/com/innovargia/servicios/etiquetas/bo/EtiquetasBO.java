/**
 * 
 */
package com.innovargia.servicios.etiquetas.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.DetalleVenta;
import com.administracion.dto.DocumentoPesoKMMaximo;
import com.administracion.dto.ITextObjeto;
import com.administracion.ibo.IAdminConsecutivosBO;
import com.administracion.ibo.ICoberturaBO;
import com.administracion.ibo.IEtiquetasBO;
import com.administracion.ibo.ITemplateEtiquetaBO;
import com.administracion.idao.IAdminConsecutivosHelperDAO;
import com.administracion.idao.IDocumentoServicioDao;
import com.administracion.idao.IFoliosDAO;
import com.administracion.idao.IParamsSistemaDAO;
import com.administracion.idao.IServiciosDao;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.ArrayElementos;
import com.innovargia.utils.Modulo11;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.search.ibo.IBusquedaZonasBO;

/**
 * @author Adrian Morales Ruaro
 *
 */
@Service
public class EtiquetasBO implements IEtiquetasBO {
	
	@Autowired
	IDocumentoServicioDao documentoServicioDao;
	//@Autowired
	//IServicioLogisticosBO servicioLogisticosBO ;
	@Autowired
	IFoliosDAO foliosDao;
	@Autowired
	IAdminConsecutivosBO iAdminConsecutivosBO;
	@Autowired
	IServiciosDao servicioDao ;
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;
	@Autowired
	IBusquedaZonasBO zonaBo;
	
	@Autowired
	ICoberturaBO iCoberturaBO;
	@Autowired
	IAdminConsecutivosHelperDAO iAdminConsecutivosHelperDAO;
	
	@Autowired
	ITemplateEtiquetaBO iTemplateEtiquetaBO;
	
	
	int tipomanejoimpresion = 1;  //1=CONVENIO 0=FOLIOS
	

	private static final Logger logger = LoggerFactory
			.getLogger(EtiquetasBO.class);
	
	/**
	 * 
	 */
	public EtiquetasBO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		logger.debug(mensaje);
	}// fin de debug
	
	
	@Override
	public void creaEtiquetas(List<EtiquetaRotulacionDTO> lista_registros,
			UsuarioDTO usuario, List<Envio> arr_envios,
			String uuid, int tipo ,String  manejo_por_folios_o_convenios)throws Exception{
		
		
		// Crea el identificador de la carta y actualiza folios
		String iddocumento = ((usuario.getFormatoetimedia()==null) || 
				(usuario.getFormatoetimedia().trim().length()<=0))? 
				ConstantesGenerales.FORMATO_ETIQUETA_DEFAUTL:
				ConstantesGenerales.FORMATO_ETIQUETA_DEFAUTL +usuario.getFormatoetimedia();
		logger.debug("Buscando consecutivo para tipo de documento:" + iddocumento);
		MetaDatoCatalogoDTO meta = iAdminConsecutivosBO.getMetaDatoCatalogoDTO(iddocumento,usuario.entidad.getIdentidad(),
				usuario.organizacion.getIdorganizacion() ) ;
		
		//Verifica si existe la tabla
		if (!iAdminConsecutivosBO.existeTablaConsecutivos(meta)){
			throw new Exception("TABLA DE CONTROL DE CONSECUTIVOS DOCUMENTO(" +iddocumento +") NO EXISTE. ");
		}

		EtiquetaRotulacionDTO etiqueta = null;
		if (lista_registros.size()>0){
			etiqueta = lista_registros.get(0);
		}

		//Cambia el iudentificador del servicio 
		String idservicio = etiqueta.getIdservicio();
		 if (manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_CONVENIO)){
			 etiqueta.setIdservicio(etiqueta.getServiciotarifa());
		 }
		
		 if (etiqueta.getIdservicio()==null){
		     etiqueta.setIdservicio(idservicio);
		     if (etiqueta.getIdservicio()==null){
			  etiqueta.setIdservicio("");
		     }
		     
		 }
		//Crea las etiquetas
		createDocumentoEtiqueta(lista_registros,arr_envios, 
				usuario,etiqueta.getPesobase(),etiqueta.getIdservicio(),
				manejo_por_folios_o_convenios);

	}

	@Override
	public void creaEtiquetas(List<EtiquetaRotulacionDTO> lista_registros,
			UsuarioDTO usuario, List<Envio> arr_envios,String uuid, int tipo)throws Exception{
		//String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
		//			ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS,ConstantesGenerales.ID_SKY4SOL);
		
		
		//if (manejo_por_folios_o_convenios==null){
		//		throw new Exception("NO EXISTE PARAMETRO manejo_por_folios_o_convenios ");
		//}
		
		
		// Crea el identificador de la carta y actualiza folios
		String iddocumento = ((usuario.getFormatoetimedia()==null) || 
				(usuario.getFormatoetimedia().trim().length()<=0))? 
				ConstantesGenerales.FORMATO_ETIQUETA_DEFAUTL:
				ConstantesGenerales.FORMATO_ETIQUETA_DEFAUTL +usuario.getFormatoetimedia();
		logger.debug("Buscando consecutivo para tipo de documento:" + iddocumento);
		MetaDatoCatalogoDTO meta = iAdminConsecutivosBO.getMetaDatoCatalogoDTO(iddocumento,usuario.entidad.getIdentidad(),
				usuario.organizacion.getIdorganizacion() ) ;
		
		//Verifica si existe la tabla
		if (!iAdminConsecutivosBO.existeTablaConsecutivos(meta)){
			throw new Exception("TABLA DE CONTROL DE CONSECUTIVOS DOCUMENTO(" +iddocumento +") NO EXISTE. ");
		}

		EtiquetaRotulacionDTO etiqueta = null;
		if (lista_registros.size()>0){
			etiqueta = lista_registros.get(0);
		}

		//Cambia el iudentificador del servicio 
		String idservicio = etiqueta.getIdservicio();
		// if (manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_CONVENIO)){
		 if (this.tipomanejoimpresion ==ConstantesGenerales.INT_MANEJO_CONVENIO){
			 etiqueta.setIdservicio(etiqueta.getServiciotarifa());
		 }
		
		 if (etiqueta.getIdservicio()==null){
		     etiqueta.setIdservicio(idservicio);
		     if (etiqueta.getIdservicio()==null){
			  etiqueta.setIdservicio("");
		     }
		     
		 }
		//Crea las etiquetas
		createDocumentoEtiqueta(lista_registros,arr_envios, 
				usuario,etiqueta.getPesobase(),etiqueta.getIdservicio());

	}
	
	public String armaGuiaEtiqueta(UsuarioDTO usuario,Envio envio,String consecutivo_ini,
			DocumentoDTO carta){
		
		//Arma la cadena con la estructura por defautl
		String guia = envio.armaIdEnvio(consecutivo_ini, 	carta, getLargoConsecutivo(usuario));
		String guia_tmp="";
		
		try{
			List<ITextObjeto> lista = iTemplateEtiquetaBO.getRegistrosTemplate(usuario.getFormatoetiperso());
			
			 boolean aplica_algorimo_dv = iParamsSistemaDAO.getValorPropiedadBoolean(
						ConstantesGenerales.APLICA_ALGORITMO_DV,ConstantesGenerales.ID_SKY4SOL);
			 
			 boolean dv_al_inicio = iParamsSistemaDAO.getValorPropiedadBoolean(
						ConstantesGenerales.ALGORITMO_DV_AL_INICIO,ConstantesGenerales.ID_SKY4SOL); 
			
			//Solo para estos campos "entidad@3,organizacion@3,servicio@3,peso@3,consecutivo@9"
			if (lista.size()>0){
				ITextObjeto template = lista.get(0);
				//Si se definio una estructura de guia en el template se aplica
				if ((template.getEstructuraguia()!=null) && (!template.getEstructuraguia().trim().isEmpty())){
					//Crea la estructura
					logger.debug("Estructura guia:" +template.getEstructuraguia() );
					String[] arr_estructuraguia = template.getEstructuraguia().trim().toLowerCase().split(",");
					if (arr_estructuraguia.length>0){
						String[] arr_elem = null;
						String campo ="";
						String campo_tmp="";
						int largo=0;
						guia_tmp="";
						
						for (String elem : arr_estructuraguia) {
							arr_elem = elem.split("@");
							campo = ArrayElementos.getString(arr_elem, 0);
							largo = ArrayElementos.getInt(arr_elem, 1);
							
							//Verifica el campo que desea agregar a la guia
							if ("entidad".equals(campo)){
								campo_tmp =carta.getEntidad().getIdentidad()+"" ; 
							}else if ("organizacion".equals(campo)){
								campo_tmp =carta.getOrganizacion().getIdorganizacion()+"" ; 
							}else if ("servicio".equals(campo)){
								campo_tmp =envio.getServicio();
							}else if ("peso".equals(campo)){
								campo_tmp =carta.datosCarta.getPesoAmparado()+"";
							}else if ("consecutivo".equals(campo)){
								campo_tmp =consecutivo_ini;
							}
							//Verifica si existe el campo 
							if ((campo_tmp!=null) && (!campo_tmp.trim().isEmpty())){
								guia_tmp = guia_tmp + UtilsStrings.completa(campo_tmp,
										'0', largo,  UtilsStrings.INICIO_CADENA);
							}
							
							
						}
						
						//Verifica si debe aplicar el algoritmo del digito verificador
						if (aplica_algorimo_dv){
							guia_tmp = Modulo11.agregaDigitoVerificador(guia_tmp,
									dv_al_inicio?Modulo11.INICIO_CADENA:Modulo11.FINAL_CADENA);
						}
					}
				}
				
			}
		}catch(Exception e){
			logger.debug("Error al crear armar la guia:" + e.getMessage());
		}
		
		
		if ((guia_tmp!=null) && (!guia_tmp.trim().isEmpty())){
			guia = guia_tmp;
		}
		
		return guia;
	}
	
	@Override
	public String creaDocumento(DocumentoDTO carta,Connection cnxTransaccion,
			UsuarioDTO usuario ) throws Exception {
		return creaDocumento( carta, cnxTransaccion,usuario,null );
	}
	
	@Override
	public String creaDocumento(DocumentoDTO carta,Connection cnxTransaccion,
			UsuarioDTO usuario,String manejo_por_folios_o_convenios ) throws Exception {
		
		

		try {

			//Valida que existan folios
		     if (this.tipomanejoimpresion ==ConstantesGenerales.INT_MANEJO_FOLIOS){
				// Actualiza los folios con el peso indicado el el registro del folio
					foliosDao.updateEnviosDisponibles(
							carta.entidad.getIdentidad(),
							carta.organizacion.getIdorganizacion(),
							carta.datosCarta.getServicio(),
								carta.getNumCliente(),
								carta.datosCarta.getPesoAmparaServicio(),cnxTransaccion);
			 }
		     
			String tipodocumento = ((usuario.getFormatoetimedia()==null) || 
					(usuario.getFormatoetimedia().trim().length()<=0))? 
					ConstantesGenerales.FORMATO_ETIQUETA_DEFAUTL:
					ConstantesGenerales.FORMATO_ETIQUETA_DEFAUTL +usuario.getFormatoetimedia();
			logger.debug("Buscando consecutivo para tipo de documento:" + tipodocumento);
			
			// Crea el identificador de la carta y actualiza folios
			String consecutivo_ini =  iAdminConsecutivosBO.getConsecutivoDocumento(
					//carta.getIdTipoDocumento(),
					tipodocumento,
					usuario.entidad.getIdentidad(),usuario.organizacion.getIdorganizacion());
			
			carta.datosCarta.setConsecutivo(consecutivo_ini);
			carta.setConsecutivo(consecutivo_ini);
			
			String mi_guia = armaGuiaEtiqueta( usuario, carta.datosCarta, consecutivo_ini,
					 carta);
			carta.datosCarta.setIdEnvio(mi_guia);
			
			// carta.datosCarta.setIdEnvio(carta.datosCarta.armaIdEnvio(consecutivo_ini, 	carta,
			//	 getLargoConsecutivo(usuario)));
			 
			 
			 carta.setIdDocumento(carta.datosCarta.getIdEnvio());
			 carta.setIdDocumentoPadre(carta.datosCarta.getIdEnvio());
			 
			// if (manejo_por_folios_o_convenios==null){
			//	 manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
			//				ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS,ConstantesGenerales.ID_SKY4SOL);
			 //}

			
			
			
			//if (carta.getIdDocumentoPadre()==null){
			//carta.setIdDocumentoPadre(carta.getIdDocumento());
			//}

			//Inserta el documento
			if ( carta.getIdDocumento() != null){
				//Inserta los datos del documento
				
				documentoServicioDao.insertDatosDocumentoEtiqueta(carta);
				
				//Inserta las direcciones si solo si no se ha agregado el padre
				//COn esto solo se obtienen se inserta una sola vez los datos y
				//en las consultas se busca por medio del padre
				//if (carta.getRemitente().getIdDocumentoPadre() == null){
					carta.getDestinatario().setIdTipoDocumento(carta.getIdTipoDocumento());
					carta.getRemitente().setIdTipoDocumento(carta.getIdTipoDocumento());
					
					carta.getDestinatario().setIdDocumentoPadre(carta.getIdDocumento());
					carta.getRemitente().setIdDocumentoPadre(carta.getIdDocumento());
					
					if (carta.getDestinatario().getNumCliente()==null){
						carta.getDestinatario().setNumCliente(carta.getNumCliente());
					}
					if (carta.getRemitente().getNumCliente()==null){
						carta.getRemitente().setNumCliente(carta.getNumCliente());
					}
					
					carta.remitente.setTipoDireccion(RemDes.TIPO_DIRECCION_ORIGEN_REM);
					carta.destinatario.setTipoDireccion(RemDes.TIPO_DIRECCION_DESTINATARIO);
					
	
					
					documentoServicioDao.insertDireccionDocumento(carta.getDestinatario(),
							carta.datosCarta.getIdEnvio(),carta.datosCarta.getNumCliente(), carta.datosCarta.getLogin(),cnxTransaccion);
					
					documentoServicioDao.insertDireccionDocumento(carta.getRemitente(),
							carta.datosCarta.getIdEnvio(),carta.datosCarta.getNumCliente(), carta.datosCarta.getLogin(),cnxTransaccion);

				//}
			}else{
				debug("IDENTIFICADOR INCORRECTO ...");
			}

		} catch (Exception e) {
			debug("Excepcion creaCartaPorte..."+ e.getMessage());
			carta.setIdDocumentoPadre(null);
			//Conexion.terminaConexionTransaccional(cnxTransaccion, false);
		}finally{
		
		}
		return carta.getIdDocumentoPadre();

	}
	
	@Override
	public void insertAdicionalesDocumento(List<EtiquetaRotulacionDTO> lista_registros)throws Exception{
		
	    for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista_registros) {
	    	
	    	/* CAMBIO CITA EVIDENCIA MANIOBRA */
	    	if (etiquetaRotulacionDTO.getIdenvio()!=null){
    		documentoServicioDao.insertAdicionalesDocumento(etiquetaRotulacionDTO);
    	}
	    	/* FIN CAMBIO */
	    	
//	    	if (etiquetaRotulacionDTO.getIddocumento()!=null){
//	    		documentoServicioDao.insertAdicionalesDocumento(etiquetaRotulacionDTO);
//	    	}
	    	
	    }
	    
	}
	
	@Override
	public void insertPesoKmAmpara(String iddocumento,String idservicio ,DetalleVenta detalleventa, int tipo)
			throws SQLException{
	    
	    	DocumentoPesoKMMaximo datos = new DocumentoPesoKMMaximo();
		datos.setIddocumento(iddocumento);
		datos.setIdconvenio(detalleventa.getIdconvenio());
		datos.setIdtarifa(detalleventa.getIdtarifa());
		datos.setIdrangotarifa(detalleventa.getIdrangotarifa());
		datos.setIdpesotarifa(detalleventa.getIdpesotarifa());
		datos.setIdzonatarifa(detalleventa.getIdzonatarifa());
		datos.setIdconveniodetalle(detalleventa.getIdconveniodetalle());
		datos.setPrecio(detalleventa.getPrecio_unitario());
		
		datos.setIdservicio(idservicio);
		datos.setMax_amparado_volumen(detalleventa.getVolumenamparado());
		datos.setMax_amparado_peso(detalleventa.getPesoamparado());
		
		datos.setSiglasplaza(detalleventa.getSiglasplaza());
		datos.setIdoficina(detalleventa.getIdoficina());
		datos.setLogin(detalleventa.getLogin());
		
		try{
		    	//Inserta en la tabla de documento_pesokm_max_amparados
			//Para futura recepcion
			if (tipo!= ConstantesGenerales.TIPO_ROTULACION_INTERNACIONAL){
			    datos.setTipo(getTipo(idservicio));
			}else{
				//precio y tipo internacional
				datos.setPrecio(detalleventa.getPrecio_unitario());
			    datos.setTipo(tipo);
			}
		    documentoServicioDao.insertPesoKmAmpara(datos);

		}catch(Exception e){
		    logger.error("No se pudo agregar peso y precio maximo:" +iddocumento);
		};
	  
	}
	
	@Override
	public ArrayList<Envio>  createDocumentoEtiqueta(
			List<EtiquetaRotulacionDTO> lista_registros,
			List<Envio> arr_envios, UsuarioDTO usuario,
			int pesoservicio, String servicio )
			throws Exception{
	
		return createDocumentoEtiqueta(lista_registros, arr_envios,  
				usuario, pesoservicio,  servicio,  null );
	}
	@Override
	public ArrayList<Envio>  createDocumentoEtiqueta(
			List<EtiquetaRotulacionDTO> lista_registros,
			List<Envio> arr_envios, UsuarioDTO usuario,
			int pesoservicio, String servicio, String manejo_por_folios_o_convenios )
			throws Exception{

		
		//ServiciosDao servicioDao = new ServiciosDao();
		ArrayList<Envio> arreglo_envios = new ArrayList<Envio>();

		try{
			
			String pathLogoEtiqueta =  iParamsSistemaDAO.getValorPropiedad(
					ConstantesGenerales.PATLOGOETIQUETAS,ConstantesGenerales.ID_SKY4SOL) + 
					usuario.getLogo();
			
			DocumentoDTO carta = null;
			//String jsonenvio = "";
			//String idDocumentoPadre = null;
			String idguiamadremultiple="";
			String es_multiple="NO";
			boolean es_primero =true;
			int linea_guia=1;
			String idcarta;
			for (EtiquetaRotulacionDTO etiqueta : lista_registros) {
				String adicionales = etiqueta.getAdicionales()==null?"":etiqueta.getAdicionales();
				String acu = adicionales.contains("ACU") ||  adicionales.contains("AC") ?"ACU":"";
				
				carta = new DocumentoDTO();
				
				/* CAMBIO UNIGIS */
				carta.setSistema(etiqueta.getSistema());
				carta.datosCarta.setTipo_empaque(etiqueta.getTipoempaque());
				
				carta.datosCarta.setAcuse(acu.equals("ACU")?true:false);
				carta.datosCarta.setAdicional(adicionales);
				carta.datosCarta.setPesoAmparaServicio(etiqueta.getPesobase());
				carta.datosCarta.setOficinacontrol(etiqueta.getOficinacontrol());
				carta.setOficinacontrol(etiqueta.getOficinacontrol());
				carta.setValor_asegurado(etiqueta.getValor_asegurado());
				carta.setIdguiainternacional(etiqueta.getIdguiainternacional());
				carta.datosCarta.setIdguiainternacional(etiqueta.getIdguiainternacional());
				
				carta.datosCarta.setLogin(usuario.getLogin());
				carta.datosCarta.setIdOficina(usuario.getIdoficina());
				carta.datosCarta.setUsuarioimprime(usuario.getNombre());
				
				/* DATOS SEGURO */
				carta.setCiaseguro(etiqueta.getCiaseguro());
				carta.setPrecio_seguro(etiqueta.getPrecio_seguro());
				carta.setValor_asegurado(etiqueta.getCantasegurada());
				carta.datosCarta.setTiene_seguro(etiqueta.getTiene_seguro());
				
				carta.datosCarta.setCantAsegurada(etiqueta.getValor_asegurado());
				carta.datosCarta.setMontoAsegurado(etiqueta.getValor_asegurado());
				carta.datosCarta.setS_monto(etiqueta.getValor_asegurado()+"");
				carta.datosCarta.setMonto(etiqueta.getValordeclarado()+"");
				carta.datosCarta.setRuta(etiqueta.getRuta());
				carta.setRuta(etiqueta.getRuta());
				
				
				if (etiqueta.getArr_transbordos().size()>0){
					CruceCoberturaDTO cob= null;
					for(int i=0;i<etiqueta.getArr_transbordos().size();i++){
						cob = etiqueta.getArr_transbordos().get(i);
						if ((cob.getEnrutamiento()!=null) && (cob.getEnrutamiento().trim().length()>0)){
							if (i==0){
								carta.datosCarta.setLineaenruta1(cob.getEnrutamiento());
							}
							if (i==1){
								carta.datosCarta.setLineaenruta2(cob.getEnrutamiento());
							}
							if (i==2){
								carta.datosCarta.setLineaenruta3(cob.getEnrutamiento());	
							}
							if (i==3){
								carta.datosCarta.setLineaenruta4(cob.getEnrutamiento());
							}
						}
					}
				}
				carta.entidad.setIdentidad(usuario.entidad.getIdentidad());
				carta.organizacion.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				carta.setIdconvenio(etiqueta.getIdconvenio());  
				carta.setIdtarifa(etiqueta.getIdtarifa());
				carta.setUuid(etiqueta.getUuid());
				carta.datosCarta.remitente = getRemitente(etiqueta, usuario);
				carta.remitente=carta.datosCarta.remitente;
				carta.setNumCliente(usuario.getNumCliente());
				carta.datosCarta.destinatario =getDestinatario(etiqueta, usuario);
				carta.destinatario=carta.datosCarta.destinatario;
				carta.domicionfiscal = getFacturacion(etiqueta, usuario);
			
				carta.getRecoleccion().setIdTipoDocumento(RemDes.TIPO_DIRECCION_ORIGEN_REM);
				carta.getDestinatario().setIdTipoDocumento(RemDes.TIPO_DIRECCION_DESTINATARIO);
				carta.datosCarta.setNumCliente(usuario.getNumCliente());
				carta.datosCarta.setServicio(servicio);	
				carta.setIdServicio(servicio);
				carta.datosCarta.setDes_servicio(etiqueta.getDescripcion_servicio());
				carta.datosCarta.setDes_garantia(etiqueta.getDescripciongarantia());

				//Datos de pesos
				carta.datosCarta.setAlto(etiqueta.getAlto());
				carta.datosCarta.setAncho(etiqueta.getAncho());
				carta.datosCarta.setLargo(etiqueta.getLargo());
				carta.setAlto(etiqueta.getAlto());
				carta.setAncho(etiqueta.getAncho());
				carta.setLargo(etiqueta.getLargo());

				carta.setPesoBruto(etiqueta.getPesomayor());  
				carta.datosCarta.setPeso((int)etiqueta.getPesomayor());
		
				carta.datosCarta.setLogo(pathLogoEtiqueta);
				carta.datosCarta.setPeso_volumetrico(etiqueta.getPesofisico());
				
				carta.datosCarta.setLogin(usuario.getLogin());
				carta.setLogin(usuario.getLogin());
				carta.datosCarta.setNumCliente(usuario.getNumCliente());
				carta.datosCarta.setNumClienteRem(usuario.getNumCliente());
				carta.datosCarta.setObserva1(etiqueta.getEnrutamiento());
				carta.setIdAdicional(acu);
				
				carta.setIdTipoDocumento("ETIQU");
				carta.setNumPiezas(1);
				
				carta.setReferencia(etiqueta.getReferencia());
				carta.setFactura(etiqueta.getFactura());
				carta.setObservaciones(etiqueta.getObservacion());
				carta.setContenidoDeclarado(etiqueta.getContenido());
				
				/* CAMBIO UNIGIS SAT*/
				carta.datosCarta.setIdproducto(etiqueta.getIdproducto());
				carta.datosCarta.setContenido(etiqueta.getContenido());
				carta.datosCarta.setReferencia(etiqueta.getReferencia());
				carta.datosCarta.setComentario(etiqueta.getObservacion());
				carta.datosCarta.setFactura(etiqueta.getFactura());
				
				/* GUIA MADRE */
				if(etiqueta.getEsmadre() != null){
					
					carta.setEsMadre(etiqueta.getEsmadre());
					carta.datosCarta.setEsMadre(etiqueta.getEsmadre());

				}
				
				/*FECHA CREACION PARA UNIGIS*/
				carta.setFechaCreacion(etiqueta.getFechacreacion());
				carta.datosCarta.setFechaCreacion(etiqueta.getFechacreacion());
				
				/* CAMBIO CITAS MANIOBRAS EVIDENCIAS V2 */
				carta.setCita(etiqueta.getTiene_cita().equals("SI") ? "S":"N");
				carta.datosCarta.setTiene_cita(etiqueta.getTiene_cita().equals("SI") ? "S":"N");
				carta.setFechaCita(etiqueta.getFecha_cita());
				carta.setHoraCita(etiqueta.getHora_cita());
				
				carta.setMaxEDD(etiqueta.getFechaEstimada());
				carta.datosCarta.setMaxEDD(etiqueta.getFechaEstimada());
				
				/*CAMBIO DOCUMENTO RETORNO*/
				carta.setMarcaRetornoDocumento(etiqueta.getTiene_retorno());
				
				//Crea el documento
				idcarta = creaDocumento(carta,null,usuario,manejo_por_folios_o_convenios);
				if (idcarta != null) {

					etiqueta.setIdenvio(carta.getIdDocumento());

					// Configura la etiqueta de multiples
					if ("SI".equals(etiqueta.getEs_multiple())) {
						if (es_primero) {
							es_primero = false;
							idguiamadremultiple = carta.getIdDocumento();
							es_multiple = "SI";
						}
						linea_guia = etiqueta.getLinea_consecutivo();
						carta.datosCarta.setCantidad_envios_remesa(lista_registros.size());
						carta.datosCarta.setMultiples(etiqueta.getLinea_consecutivo() + "/" + etiqueta.getNumpiezas());
					} else {
						linea_guia = 1;
						carta.datosCarta.setMultiples("1/1");
						idguiamadremultiple = carta.getIdDocumento();
						carta.datosCarta.setCantidad_envios_remesa(1);
					}

					// Verifica si es ocurre
					if (etiqueta.getEs_ocurre() != null && etiqueta.getEs_ocurre().trim().length() > 0) {
						if ("SI".equals(etiqueta.getEs_ocurre().trim().toUpperCase())) {
							carta.datosCarta.setOcurre(true);

						} else {
							etiqueta.setEs_ocurre("NO");
							carta.datosCarta.setOcurre(false);
						}
					}

					// Actualiza los campos restantes del registro
					etiqueta.setIdoficina(usuario.getIdoficina());
					carta.setIdguiamadremultiple(idguiamadremultiple);
					carta.datosCarta.setIdguiamadremultiple(idguiamadremultiple);

					documentoServicioDao.updateDoccumentoEtiqueta(etiqueta, carta.getIdDocumento());

					// Actualiza los datos de consecutivo
					documentoServicioDao.updateDoccumentoEtiquetaMultiple(carta.getIdDocumento(), idguiamadremultiple,
							es_multiple, linea_guia, lista_registros.size());

					// Inserta registros transbordos
					documentoServicioDao.insertDoccumentoTransbordos(etiqueta);

					// Configura los datos de enrutamiento
					carta.datosCarta.setSiglasDestino(etiqueta.getSiglasdestino());
					carta.datosCarta.setSiglasOrigen(etiqueta.getSiglasorigen());

					// El primer id pertenece al padre los subsecuentes son los
					// id de los envios
					// envio.setIdEnvio(idDocumentoPadre);
					carta.datosCarta.setArr_transbordos(etiqueta.getArr_transbordos());

					// Agrega el registro al arreglo
					arr_envios.add(carta.getDatosCarta());
					//if ("SI".equals(etiqueta.getTiene_retorno())) {
					if(false){

						DocumentoDTO carta_retorno = new DocumentoDTO();

						carta_retorno.setIdconvenio(etiqueta.getIdconvenio());
						carta_retorno.setIdtarifa(etiqueta.getIdtarifa());
						carta_retorno.setUuid(etiqueta.getUuid());
						carta_retorno.setLogin(usuario.getLogin());
						carta_retorno.datosCarta.remitente = carta.destinatario;
						carta_retorno.datosCarta.destinatario = carta.remitente;

						carta_retorno.datosCarta.remitente.setIdTipoDocumento(RemDes.TIPO_DIRECCION_ORIGEN_REM);
						carta_retorno.datosCarta.destinatario.setIdTipoDocumento(RemDes.TIPO_DIRECCION_DESTINATARIO);

						carta_retorno.remitente = carta.destinatario;
						carta_retorno.destinatario = carta.remitente;
						carta_retorno.setNumPiezas(1);

						// Configura la etiqueta de multiples
						if ("SI".equals(etiqueta.getEs_multiple())) {
							carta_retorno.datosCarta
									.setMultiples(etiqueta.getLinea_consecutivo() + "/" + etiqueta.getCantidad());
						} else {
							carta_retorno.datosCarta.setMultiples("1/1");
						}

						carta_retorno.getRemitente().setIdTipoDocumento(RemDes.TIPO_DIRECCION_ORIGEN_REM);
						carta_retorno.getDestinatario().setIdTipoDocumento(RemDes.TIPO_DIRECCION_DESTINATARIO);

						carta_retorno.datosCarta.setConsecutivo(carta.datosCarta.getConsecutivo());

						carta.datosCarta.setServicio(servicio);
						carta.datosCarta.setDes_servicio(etiqueta.getDescripcion_servicio());
						carta.datosCarta.setDes_garantia(etiqueta.getDescripciongarantia());
						carta.setContenidoDeclarado(etiqueta.getContenido());

						// Datos de pesos
						carta.datosCarta.setPeso((int) etiqueta.getPesomayor());

						carta.datosCarta.setLogo(pathLogoEtiqueta);
						carta.datosCarta.setPeso_volumetrico(etiqueta.getPesovolumetrico());
						carta.datosCarta.setContenido(etiqueta.getContenido());
						carta.datosCarta.setPeso((int) etiqueta.getPesobase());

						carta_retorno.datosCarta.setServicio("80"); // SIEMPRE
																	// ES EL
																	// SERVICIO
																	// DE
																	// RETORNO
						carta_retorno.datosCarta.setLogin(usuario.getIdUsuario());
						carta_retorno.datosCarta.setNumCliente(usuario.getNumCliente());
						carta_retorno.datosCarta.setNumClienteRem(usuario.getNumCliente());
						carta_retorno.setNumCliente(usuario.getNumCliente());
						carta_retorno.datosCarta.setObserva1("");
						carta_retorno.datosCarta.setDes_servicio("SERVICIO DE RETORNO");
						carta_retorno.datosCarta.setDes_garantia("SERVICIO DE RETORNO");
						carta_retorno.setLogin(usuario.getLogin());

						// Tipo documento
						carta_retorno.setIdTipoDocumento(carta.getIdTipoDocumento());

						CruceCoberturaDTO cobertura = new CruceCoberturaDTO();
						cobertura.setIdcoorigen(etiqueta.getCp_des());
						cobertura.setIdcodestino(etiqueta.getCp_rem());
						cobertura.setIdservicio(etiqueta.getIdservicio());

						CruceCoberturaDTO cobe = iCoberturaBO.getCobertura(cobertura);
						carta.datosCarta.setArr_transbordos(cobe.getLista_transbordos());

						// Verifica si la guia original es ACU
						carta.setIdAdicional(acu);

						// Agrega el registro en la tabla deenvios
						creaDocumentoRetorno(carta_retorno, null, usuario, carta.getIdDocumento());

						// Agrega el registro al arreglo
						arr_envios.add(carta_retorno.getDatosCarta());
					}

				}
				
			}
			
		} catch (Exception e) {
			debug("Excepcion createDocumentoEtiqueta..."+ e.getMessage());
			   e.printStackTrace();
			//Conexion.terminaConexionTransaccional(cnx, false);
			
		}finally{
			//Conexion.closeRecursos(cnx);
			//Conexion.terminaConexionTransaccional(cnx, true);
		}

		return arreglo_envios;
		
	}

	
	/* (non-Javadoc)
	 * @see com.innovargia.servicios.etiquetas.bo.IEtiquetasBO#creaDocumentoRetorno(com.servicio.dtos.CartaPorteDTO, java.sql.Connection, com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
	@Override
	public String creaDocumentoRetorno(DocumentoDTO carta,Connection cnxTransaccion,UsuarioDTO usuario,String iddoctooriginal ) throws Exception {
		
		
		debug("CREANDO DOCUMENTO DE RETORNO: guia->" + iddoctooriginal + ",retorno:"+carta.datosCarta.getIdEnvio());
		try {
			
			//Arma el registro con el mismo numero pero con diferente servicio
			carta.datosCarta.setIdEnvio(carta.datosCarta.armaIdEnvio(
				carta.datosCarta.getConsecutivo()+"", 	carta, 
				 getLargoConsecutivo(usuario)
				));
     		carta.setIdDocumento(carta.datosCarta.getIdEnvio());
			 
			// Actualiza los folios con el peso indicado el el registro del folio
     		 String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
						ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS,ConstantesGenerales.ID_SKY4SOL);
     		 
			 if (manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_FOLIOS)){
					foliosDao.updateEnviosDisponiblesRetorno(
							carta.entidad.getIdentidad(),
							carta.organizacion.getIdorganizacion(),
							carta.datosCarta.getServicio(),
								carta.getNumCliente(),
								carta.datosCarta.getPesoAmparaServicio(),cnxTransaccion);
			 }
		
			
			//Inserta el documento
			if ( carta.getIdDocumento() != null){
				carta.getDestinatario().setIdDocumentoPadre(carta.getIdDocumento());
				carta.getRemitente().setIdDocumentoPadre(carta.getIdDocumento());
				
				carta.setIdDocumentoPadre(carta.getIdDocumento());
				carta.datosCarta.setIdEnvio(carta.getIdDocumento());
			
				
				//Inserta los datos del documento
				documentoServicioDao.insertDatosDocumentoEtiqueta(carta);
				
				//Inserta las direcciones si solo si no se ha agregado el padre
				//COn esto solo se obtienen se inserta una sola vez los datos y
				//en las consultas se busca por medio del padre
				//if (carta.getRemitente().getIdDocumentoPadre() == null){
					
					
					carta.getDestinatario().setIdTipoDocumento(carta.getIdTipoDocumento());
					carta.getRemitente().setIdTipoDocumento(carta.getIdTipoDocumento());
					

					if (carta.getDestinatario().getNumCliente()==null){
						carta.getDestinatario().setNumCliente(carta.getNumCliente());
					}
					if (carta.getRemitente().getNumCliente()==null){
						carta.getRemitente().setNumCliente(carta.getNumCliente());
					}
					
					carta.remitente.setTipoDireccion(RemDes.TIPO_DIRECCION_ORIGEN_REM);
					carta.destinatario.setTipoDireccion(RemDes.TIPO_DIRECCION_DESTINATARIO);
	
					
					documentoServicioDao.insertDireccionDocumento(carta.getDestinatario(),
							carta.datosCarta.getIdEnvio(),carta.datosCarta.getNumCliente(), carta.datosCarta.getLogin(),cnxTransaccion);
					
					documentoServicioDao.insertDireccionDocumento(carta.getRemitente(),
							carta.datosCarta.getIdEnvio(),carta.datosCarta.getNumCliente(), carta.datosCarta.getLogin(),cnxTransaccion);

				//}
				//Agrega el registrode guias de retorno
				documentoServicioDao.insertGuiasRetorno(iddoctooriginal,carta.datosCarta.getIdEnvio(), cnxTransaccion);
				
				//Agrega el registro en la tabla de Retorno
			}else{
				debug("IDENTIFICADOR INCORRECTO ...");
			}

		} catch (Exception e) {
			debug("Excepcion creaCartaPorte..."+ e.getMessage());
			//Conexion.terminaConexionTransaccional(cnxTransaccion, false);
		}finally{
						
		}
		return carta.getIdDocumentoPadre();

	}
	
	
	@Override
	public RemDes getRemitente(EtiquetaRotulacionDTO etiqueta, UsuarioDTO usuario){
		RemDes datos = new RemDes();
		datos.setRazonSocial(etiqueta.getRazonsocial_rem());
		datos.setCorreoe(etiqueta.getEmail_rem());
		datos.setAtencion(etiqueta.getContacto_rem());
		datos.setRfc(etiqueta.getRfc_rem());
		datos.setCalle(etiqueta.getCalle_rem());// + " " + 
		//		(etiqueta.getNumexterior_rem()==null?"":etiqueta.getNumexterior_rem()) + " " +
		//		(etiqueta.getNuminterior_rem()==null?"":etiqueta.getNuminterior_rem())
		//);
		
		datos.setDireccion(etiqueta.getCalle_rem());// + " " + 
		//		(etiqueta.getNumexterior_rem()==null?"":etiqueta.getNumexterior_rem()) + " " +
		//		(etiqueta.getNuminterior_rem()==null?"":etiqueta.getNuminterior_rem())
		//);
		
		datos.setNuminterior(etiqueta.getNuminterior_rem());
		datos.setNumexterior(etiqueta.getNumexterior_rem());
		datos.setColonia(etiqueta.getColonia_rem());
		datos.setMunicipio(etiqueta.getMunicipio_rem());
		datos.setEstado(etiqueta.getEstado_rem());
		datos.setCp(etiqueta.getCp_rem());
		datos.setTelefono(etiqueta.getTelefono_rem());
		datos.setNumCliente(usuario.getNumCliente());
		datos.setTipoDireccion(RemDes.TIPO_DIRECCION_ORIGEN_REM); 
		datos.setPais(etiqueta.getPais_rem());
		datos.setCodigopais(etiqueta.getCodigopais_rem());
		datos.setReferencia(etiqueta.getReferencia_rem());
		
		datos.setCiudad(etiqueta.getCiudad_rem());
		
		/* UNIGIS CAMBIO IDREMDES */
		datos.setIdRmDes(etiqueta.getIdRmDes_rem());
		
		return datos;
	}
	

	
	@Override
	public RemDes getDestinatario(EtiquetaRotulacionDTO etiqueta, UsuarioDTO usuario){
		RemDes datos = new RemDes();
		datos.setRazonSocial(etiqueta.getRazonsocial_des());
		datos.setAtencion(etiqueta.getContacto_des());
		datos.setRfc(etiqueta.getRfc_des());
		datos.setCorreoe(etiqueta.getEmail_des());
		datos.setCalle(etiqueta.getCalle_des());// + " " + 
		//	(etiqueta.getNumexterior_des()==null?"":etiqueta.getNumexterior_des()) + " " +
		//	(etiqueta.getNuminterior_des()==null?"":etiqueta.getNuminterior_des())
		//);
		
		datos.setDireccion(etiqueta.getCalle_des());// + " " + 
		//		(etiqueta.getNumexterior_des()==null?"":etiqueta.getNumexterior_des()) + " " +
		//		(etiqueta.getNuminterior_des()==null?"":etiqueta.getNuminterior_des())
		//);
		datos.setNuminterior(etiqueta.getNuminterior_des());
		datos.setNumexterior(etiqueta.getNumexterior_des());
		datos.setColonia(etiqueta.getColonia_des());
		datos.setMunicipio(etiqueta.getMunicipio_des());
		datos.setEstado(etiqueta.getEstado_des());
		datos.setCp(etiqueta.getCp_des());
		datos.setTelefono(etiqueta.getTelefono_des());
		datos.setTelefono2(etiqueta.getTelefono_des2());
		datos.setNumCliente(usuario.getNumCliente());
		datos.setTipoDireccion(RemDes.TIPO_DIRECCION_DESTINATARIO);
		datos.setPais(etiqueta.getPais_des());
		
		datos.setCodigopais(etiqueta.getCodigopais_des());
		
		datos.setReferencia(etiqueta.getReferencia_des());
		
		datos.setCiudad(etiqueta.getCiudad_des());
		
		/* UNIGIS CAMBIO IDREMDES */
		datos.setIdRmDes(etiqueta.getIdRmDes_des());
		
		return datos;
	}
	

	
	@Override
	public RemDes getFacturacion(EtiquetaRotulacionDTO etiqueta, UsuarioDTO usuario){
		RemDes datos = new RemDes();
		datos.setRazonSocial(etiqueta.getRazonsocial_fac());
		datos.setAtencion(etiqueta.getContacto_fac());
		datos.setRfc(etiqueta.getRfc_fac());
		datos.setCorreoe(etiqueta.getEmail_fac());
		datos.setCalle(etiqueta.getCalle_fac() );//+ " " + 
		//		(etiqueta.getNumexterior_fac()==null?"":etiqueta.getNumexterior_fac()) + " " +
		//		(etiqueta.getNuminterior_fac()==null?"":etiqueta.getNuminterior_fac())
				//);
		
		datos.setDireccion(etiqueta.getCalle_fac()); //+ " " + 
		//		(etiqueta.getNumexterior_fac()==null?"":etiqueta.getNumexterior_fac()) + " " +
		//		(etiqueta.getNuminterior_fac()==null?"":etiqueta.getNuminterior_fac())
		//);
		datos.setNuminterior(etiqueta.getNumexterior_fac());
		datos.setNumexterior(etiqueta.getNumexterior_fac());
		datos.setColonia(etiqueta.getColonia_fac());
		datos.setMunicipio(etiqueta.getMunicipio_fac());
		datos.setEstado(etiqueta.getEstado_fac());
		datos.setCp(etiqueta.getCp_fac());
		datos.setTelefono(etiqueta.getTelefono_fac());
		datos.setNumCliente(usuario.getNumCliente());
		datos.setTipoDireccion(RemDes.TIPO_DIRECCION_FACTURACION);
		datos.setPais(etiqueta.getPais_fac());

		return datos;
	}
	
	@Override
	public ArrayList<Envio> mapeaCreateDocumento(
			EtiquetaRotulacionDTO etiqueta, Envio elemn_envio,
			ArrayList<Envio> arr_envios, UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
    private int getLargoConsecutivo(UsuarioDTO usuario) {
	int largo = 8;
	try {
	    if (ConstantesGenerales.MODULO_PDV.equals(usuario.getInterfaz())) {

		largo = iParamsSistemaDAO.getValorPropiedadInt(
			ConstantesGenerales.LARGO_CONSECUTIVO_PDV,
			ConstantesGenerales.ID_SKY4SOL);

	    } else if (ConstantesGenerales.MODULO_AUTODOCWEB.equals(usuario
		    .getInterfaz())) {
	    	
	    	largo = iParamsSistemaDAO.getValorPropiedadInt(
			ConstantesGenerales.LARGO_CONSECUTIVO_AUTODOC,
			ConstantesGenerales.ID_SKY4SOL);

	    }

	} catch (Exception e) {
	    logger.debug("No se encuentran definidos los parametros de largo[" + 
		    ConstantesGenerales.LARGO_CONSECUTIVO_PDV + "|" + ConstantesGenerales.LARGO_CONSECUTIVO_AUTODOC +"]:" +
		    e.getMessage());
	}
	return largo;

    }
    
   
    public int getTipo(String servicio) {
	/*String servicios_contado = "";
	String servicios_prepagado = "";
	String servicios_contrato = "";
	try {
	    servicios_contrato = iParamsSistemaDAO.getValorPropiedad(
		    ConstantesGenerales.SERVICIOS_CONTRATO_CONVENIO,
		    ConstantesGenerales.ID_SKY4SOL);
	    servicios_contrato  = servicios_contrato==null?"":servicios_contrato.trim().toUpperCase();
	    
	    servicios_prepagado = iParamsSistemaDAO.getValorPropiedad(
		    ConstantesGenerales.SERVICIOS_PREPAGADO,
		    ConstantesGenerales.ID_SKY4SOL);
	    servicios_prepagado  = servicios_prepagado==null?"":servicios_prepagado.trim().toUpperCase();
	    
	    servicios_contado = iParamsSistemaDAO.getValorPropiedad(
		    ConstantesGenerales.SERVICIOS_CONTADO,
		    ConstantesGenerales.ID_SKY4SOL);
	    servicios_contado  = servicios_contado==null?"":servicios_contado.trim().toUpperCase();
	    
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	logger.debug("servicios_contado:" + servicios_contado +
		",servicios_prepagado:" + servicios_prepagado + 
		",servicios_contrato:" + servicios_contrato );
	
	if (servicios_contrato.contains(servicio.toUpperCase())) {
	    return ConstantesGenerales.TIPO_ROTULACION_AUTODOC;
	}
	
	if (servicios_prepagado.contains(servicio.toUpperCase())) {
	    return ConstantesGenerales.TIPO_ROTULACION_PREPAGADO;
	}
	
	if (servicios_contado.contains(servicio.toUpperCase())) {
	    return ConstantesGenerales.TIPO_ROTULACION_CONTADO;
	}*/
	
	
	
	int tipocobro =0;
	try{
	    ServicioDTO servicioDTO =  documentoServicioDao.getTipoCobroServicio(servicio);
	    tipocobro = Integer.parseInt(servicioDTO.getTipocobro());
	}catch(Exception e){
	    logger.debug("Servicio "+servicio + " no existe � no tiene idtipocobro numerico � tipocobro es null o vacio.");
	    tipocobro =0;  
	}
	//No es de ningun tipo de Convenio ni prepago
	return tipocobro;
    }
    @Override
    public List<com.administracion.dto.AdicionalDTO> getAdicionalesDocumento(String iddocumento)
	    throws SQLException {
	// TODO Auto-generated method stub
	return documentoServicioDao.getAdicionalesDocumento(iddocumento);
    }
	@Override
	public void insertGuiasACU(String iddocumento, int idventa, String iduui) throws SQLException {
		documentoServicioDao.insertGuiasACU(iddocumento, idventa, iduui);
		
	}
	 @Override
	public int getTipomanejoimpresion() {
		return tipomanejoimpresion;
	}
	 @Override
	public void setTipomanejoimpresion(int tipomanejoimpresion) {
		this.tipomanejoimpresion = tipomanejoimpresion;
	}
	

}
