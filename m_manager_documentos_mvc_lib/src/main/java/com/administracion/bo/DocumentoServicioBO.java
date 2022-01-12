package com.administracion.bo;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.ibo.IDocumentoServicioBO;
import com.administracion.idao.IDocumentoServicioDao;
import com.administracion.idao.IHistoriaDAO;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.Fechas;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Entrega;
import com.servicio.dtos.Movimiento;
import com.tracusa.ccp.FacturaCCP;

import ar.com.unisolutions.dao.IDocumentoUnigisDAO;

@Service
public class DocumentoServicioBO implements IDocumentoServicioBO {
	
	private static final Logger logger = LoggerFactory.getLogger(DocumentoServicioBO.class);

	@Autowired
	IDocumentoServicioDao documentoServicioDao;
	
	@Autowired
	IHistoriaDAO iHistoriaDAO;
	
	@Autowired
	IDocumentoUnigisDAO documentoUnigisDAO;
	
	/* (non-Javadoc)
	 * @see com.administracion.bo.IDocumentoServicioBO#consulta(com.servicio.dtos.DocumentoConsultaDTO, int, java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<DocumentoConsultaDTO> consulta(DocumentoDTO datos, int tipobusqueda,
			String fechaini, String fechafin,UsuarioDTO usuario) throws Exception{

		if (tipobusqueda==1 || tipobusqueda == 32){  //Por iddocumento
			return documentoServicioDao.getConsultaInfoDocumento(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario,tipobusqueda);
			
		}else if (tipobusqueda==2){//Por rango de fechas creacion
			return documentoServicioDao.busquedaXFechasCreacion(fechaini, fechafin, datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==3){//Por Razon Social Destino
			return documentoServicioDao.busquedaXRazonSocial(fechaini, fechafin, datos.getRazonSocialDestino(), datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==31){//Tel.  Destino
			return documentoServicioDao.busquedaTelDestino(fechaini, fechafin, datos.getTelefonoQuienSolicita(), datos.getIdTipoDocumento(),datos,usuario);
			
			
		}else if (tipobusqueda==4){//Por Referencia 
			return documentoServicioDao.busquedaXReferencia(fechaini, fechafin, datos.getReferencia(),datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==5){//Por delivery
			return documentoServicioDao.busquedaXDelivery(fechaini, fechafin, datos.getDelivery(), datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==6){//Por shipment
			return documentoServicioDao.busquedaXShipment(fechaini, fechafin, datos.getEmbarque(), datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==7){//Por factura
			return documentoServicioDao.busquedaXFactura(fechaini, fechafin, datos.getFactura(), datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==8){
			//Por numero de Rastreo que es el consecutivo de la guia, esta modalidad solo esta habilitrada para
			//usuarios firmados en el sistema
			return documentoServicioDao.getInfoDocumentoXRastreo(datos, datos.getIdTipoDocumento(),usuario); 
			
		}else if (tipobusqueda==9){
			//Por SoldParty 
			return documentoServicioDao.getInfoDocumentoXTransporte(datos, fechaini, fechafin,tipobusqueda,usuario); 
			
		}else if (tipobusqueda==10){
			//OrderNumberSAP
			return documentoServicioDao.getInfoDocumentoXTransporte(datos, fechaini, fechafin,tipobusqueda,usuario); 
			
		}else if (tipobusqueda==11){
			//Coss Dock
			return documentoServicioDao.getInfoDocumentoXTransporte(datos, fechaini, fechafin,tipobusqueda,usuario); 
			
		}else if (tipobusqueda==12){
			//Route Number
			return documentoServicioDao.getInfoDocumentoXTransporte(datos, fechaini, fechafin,tipobusqueda,usuario); 
			
		}else if (tipobusqueda==13){
			//Purcharse Order
			return documentoServicioDao.getInfoDocumentoXTransporte(datos, fechaini, fechafin,tipobusqueda,usuario); 
			
		}else if (tipobusqueda==14){
			//Busca la guia por el LIKE de documentos , en historia y confirmacion
			return documentoServicioDao.getInfoDocumentoLike(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario);
			
		}else if (tipobusqueda==15){//Por Contenido 
			return documentoServicioDao.busquedaXContenido(fechaini, fechafin, datos.getContenidoDeclarado(),datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==16){//Por GUIA INTERNACIONAL
			return documentoServicioDao.busquedaXGuiaInternacional(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario);
		}else if (tipobusqueda==17){//Por GUIA CASAMIENTO
			return documentoServicioDao.busquedaXGuiaCasamiento(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario);
		}else if (tipobusqueda==18){//Por CONSECUTIVO ASIGNADO 
		    	//Esta consulta puede arrojar varios resultados ya que no esta acotada a un solo cliente
			return documentoServicioDao.busquedaXGuiaConsecutivo(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario);
		}else if (tipobusqueda==19){//Por Guia Madre Multiple
		    	//Si la guia Madre es NUll debe devolver una lista vacia
		    	if ((datos.getIdDocumento()==null) || (datos.getIdDocumento().trim().isEmpty())){
		    	}else{
		    	    return documentoServicioDao.busquedaXGuiaMadreMultiple(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario); 
		    	}
			
		}

		
		


		return new ArrayList<DocumentoConsultaDTO>();
	}
	
	

	@Override
	public DocumentoDTO getInfoDocumento(String iddocumento, UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return documentoServicioDao.getInfoDocumento(iddocumento, usuario);
	}

	@Override
	public DocumentoDTO getInfoDocumentoJson(String iddocumento) {
		// TODO Auto-generated method stub
		return documentoServicioDao.getInfoDocumentoJson(iddocumento);
	}

	@Override
	public List<LogHistoriaDTO> getHistoriaDocumento(String iddocumento,
			UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return documentoServicioDao.getHistoriaDocumento(iddocumento, usuario);
	}
	
	@Override
	public void cancelaDocumento(String iddocumento, UsuarioDTO usuario)
			throws Exception {
		/*int cantidad = documentoServicioDao.cancelaDocumento(iddocumento, usuario);
		logger.debug("Cantidad de registros afectados para cancelación " + iddocumento +":" + cantidad);
		if (cantidad>0){
			logger.debug("Agregando historia de cancelacion folio " + Fechas.getFechaFormato("yyMMddhhmm") );
		    Movimiento movimiento = new Movimiento();
		    movimiento.setGuia(iddocumento);
		    movimiento.setTipoRegistro("CL");
		    movimiento.setClaveLogistica("CL");
		    movimiento.setEmpleado(usuario.getLogin());
		    movimiento.setRuta(Fechas.getFechaFormato("yyMMddhhmm"));
		    movimiento.setSiglasPlaza("");
		    
		    insertHistoriaDocumento(movimiento);
		}*/
		
		cancelaDocumento( iddocumento,  usuario, Fechas.getFechaFormato("yyMMddhhmm"));
		
	}
	@Override
	public void cancelaDocumento(String iddocumento, UsuarioDTO usuario, String folio)
			throws Exception {
		int cantidad = documentoServicioDao.cancelaDocumento(iddocumento,usuario);
		logger.debug("Cantidad de registros afectados para cancelación " + iddocumento +":" + cantidad);
		
		if (cantidad>0){
			logger.debug("Agregando historia de cancelacion folio " +folio );
		    Movimiento movimiento = new Movimiento();
		    movimiento.setGuia(iddocumento);
		    movimiento.setTipoRegistro("CL");
		    movimiento.setClaveLogistica("CL");
		    movimiento.setEmpleado(usuario.getLogin());
		    movimiento.setRuta(folio);
		    movimiento.setSiglasPlaza("");
		    
		    insertHistoriaDocumento(movimiento);
		}
		
		
	}


	@Override
	public void insertHistoriaDocumento(Movimiento movimiento)
		throws SQLException {
	    iHistoriaDAO.insertHistoriaDocumento(movimiento);
	    
	}



	@Override
	public void insertConfirmaEntregaEnvio(Entrega entrega)
		throws SQLException {
	    documentoServicioDao.insertConfirmaEntregaEnvio(entrega);
	    
	}



	@Override
	public DocumentoConsultaDTO getInfoGuia(String iddocumento) {
	    // TODO Auto-generated method stub
	    return documentoServicioDao.getInfoGuia(iddocumento);
	}



	@Override
	public List<ServicioDTO> getTipoServicioXTipoCobro(String tipocobro) throws Exception {
		// TODO Auto-generated method stub
		return documentoServicioDao.getTipoServicioXTipoCobro(tipocobro);
	}



	@Override
	public DocumentoConsultaDTO getInfoDocumentoMensajeria(String iddocumento) {
		// TODO Auto-generated method stub
		return documentoServicioDao.getInfoDocumentoMensajeria(iddocumento);
	}



	@Override
	public List<DocumentoDTO> getInfoDocumentoMadre(String iddocumento) {
		// TODO Auto-generated method stub
		return documentoServicioDao.getInfoDocumentoMadre(iddocumento);
	}

	
	@Override
	public List<DocumentoConsultaDTO> consultaEtiquetasUnigis(DocumentoDTO datos, int tipobusqueda, String fechaini,
			String fechafin, UsuarioDTO usuario) throws Exception {
		if (tipobusqueda==1 || tipobusqueda == 32){  //Por iddocumento
			String iddocumentos = datos.getIdDocumento().replaceAll(" ", ",");
			return documentoUnigisDAO.getConsultaInfoDocumento(iddocumentos,datos.getIdTipoDocumento(),usuario,tipobusqueda);	
		}else if (tipobusqueda==2){//Por rango de fechas creacion
			return documentoUnigisDAO.busquedaXFechasCreacion(fechaini, fechafin, datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==3){//Por Razon Social Destino
			return documentoUnigisDAO.busquedaXRazonSocial(fechaini, fechafin, datos.getRazonSocialDestino(), datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==31){//Tel.  Destino
			return documentoUnigisDAO.busquedaTelDestino(fechaini, fechafin, datos.getTelefonoQuienSolicita(), datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==4){//Por Referencia 
			return documentoUnigisDAO.busquedaXReferencia(fechaini, fechafin, datos.getReferencia(),datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==15){//Por Contenido 
			return documentoUnigisDAO.busquedaXContenido(fechaini, fechafin, datos.getContenidoDeclarado(),datos.getIdTipoDocumento(),datos,usuario);
		}else if (tipobusqueda==16){//Por GUIA INTERNACIONAL
			return documentoUnigisDAO.busquedaXGuiaInternacional(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario);
		}else if (tipobusqueda==17){//Por GUIA CASAMIENTO
			return documentoUnigisDAO.busquedaXGuiaCasamiento(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario);
		}else if (tipobusqueda==18){//Por CONSECUTIVO ASIGNADO 
		    	//Esta consulta puede arrojar varios resultados ya que no esta acotada a un solo cliente
			return documentoUnigisDAO.busquedaXGuiaConsecutivo(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario);
		}else if (tipobusqueda==19){//Por Guia Madre Multiple
		    	//Si la guia Madre es NUll debe devolver una lista vacia
		    	if ((datos.getIdDocumento()==null) || (datos.getIdDocumento().trim().isEmpty())){
		    	}else{
		    	    return documentoUnigisDAO.busquedaXGuiaMadreMultiple(datos.getIdDocumento(),datos.getIdTipoDocumento(),usuario); 
		    	}
			
		}

		return new ArrayList<DocumentoConsultaDTO>();
	}



	@Override
	public List<FacturaCCP> getFacturasCCP(String viaje) {
	  
	    return documentoServicioDao.getFacturasCCP(viaje);
	    
	}
	
}
