package com.administracion.ibo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.DetalleVenta;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.DocumentoDTO;

public interface IEtiquetasBO {

	public void creaEtiquetas(List<EtiquetaRotulacionDTO> lista_registros,
			UsuarioDTO usuario, List<Envio> arr_envios,String uuid, int tipo)throws Exception;
	
	public ArrayList<Envio>  createDocumentoEtiqueta(
				List<EtiquetaRotulacionDTO> lista_registros,
				List<Envio> arr_envios, UsuarioDTO usuario,
				int pesoservicio, String servicio )
				throws Exception;
	public String creaDocumentoRetorno(DocumentoDTO carta,Connection cnxTransaccion,
			UsuarioDTO usuario,String iddoctooriginal ) throws Exception ;
	
	
	public ArrayList<Envio>  mapeaCreateDocumento(EtiquetaRotulacionDTO etiqueta,
			Envio elemn_envio,ArrayList<Envio> arr_envios, UsuarioDTO usuario) throws Exception;
	
	
	public String creaDocumento(DocumentoDTO carta,
			Connection cnxTransaccion,UsuarioDTO usuario ) throws Exception;
	
	public void insertAdicionalesDocumento(List<EtiquetaRotulacionDTO> lista_registros)throws Exception;
	
	public void insertPesoKmAmpara(String iddocumento,String idservicio ,DetalleVenta detalleventa, int tipo)
		throws SQLException;
	
	public RemDes getRemitente(EtiquetaRotulacionDTO etiqueta, UsuarioDTO usuario);
	public RemDes getDestinatario(EtiquetaRotulacionDTO etiqueta, UsuarioDTO usuario);
	public RemDes getFacturacion(EtiquetaRotulacionDTO etiqueta, UsuarioDTO usuario);
	
	public List<AdicionalDTO> getAdicionalesDocumento(String iddocumento)throws SQLException;
	
	public void insertGuiasACU(String iddocumento,int idventa, String iduui) throws SQLException;
	
	public void creaEtiquetas(List<EtiquetaRotulacionDTO> lista_registros,
			UsuarioDTO usuario, List<Envio> arr_envios,
			String uuid,  int tipo,String  manejo_por_folios_o_convenios)throws Exception;
	
	public String creaDocumento(DocumentoDTO carta,Connection cnxTransaccion,
			UsuarioDTO usuario,String manejo_por_folios_o_convenios ) throws Exception;
	
	public ArrayList<Envio>  createDocumentoEtiqueta(
			List<EtiquetaRotulacionDTO> lista_registros,
			List<Envio> arr_envios, UsuarioDTO usuario,
			int pesoservicio, String servicio, String manejo_por_folios_o_convenios )
			throws Exception;
	

	 public int getTipomanejoimpresion();
	 public void setTipomanejoimpresion(int tipomanejoimpresion) ;

}