package com.innovargia.salesmanager.idao;

import java.util.List;

import com.administracion.dto.DetalleVenta;
import com.administracion.dto.VentaDTO;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IRotulacionEtiquetasDatosDAO {

	public abstract int insert(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public int insertLineaVolumenCOD(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public int insertLineaAdicional(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public int insertRotulacionSet(EtiquetaRotulacionDTO etiqueta) throws Exception;

	public abstract void update(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public void updateCOD(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public void updateVolumen(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public void updateSeguro(EtiquetaRotulacionDTO etiqueta) throws Exception ;
	public abstract void updateRegistroDatos(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public void updateRotulacionSet(EtiquetaRotulacionDTO etiqueta) throws Exception;

	public abstract void delete(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public void deleteRotulacionSet(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public abstract void deleteLinea(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public void deleteLineaVolumenSeguroCOD(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public void deleteLineaAdicional(EtiquetaRotulacionDTO etiqueta) throws Exception;

		

	public List<EtiquetaRotulacionDTO> getRegistrosDatos(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public List<EtiquetaRotulacionDTO> getRegistrosDatosVolumen(EtiquetaRotulacionDTO etiqueta)	throws Exception;
	public List<EtiquetaRotulacionDTO> getRegistrosDatosAdicionales(EtiquetaRotulacionDTO etiqueta)	throws Exception;
	public List<EtiquetaRotulacionDTO> getRegistrosDatosContenidoObserva(EtiquetaRotulacionDTO etiqueta)throws Exception;
	
	public List<EtiquetaRotulacionDTO> getRegistrosDatosSeguro(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public List<EtiquetaRotulacionDTO> getRegistrosDatosCOD(EtiquetaRotulacionDTO etiqueta)throws Exception;
	public void depuraUUID(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public List<EtiquetaRotulacionDTO> getRegistrosSets(EtiquetaRotulacionDTO etiqueta)	throws Exception;
	public List<EtiquetaRotulacionDTO> getRegistrosSetsUsuario(EtiquetaRotulacionDTO etiqueta)throws Exception ;
	
	
	public void depuraRotulacionesTemporales() throws Exception;
	
	public int insertRegistroImportado(EtiquetaRotulacionDTO etiqueta) throws Exception;
	
	public void updateRotulacionIdRegistroSet(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public List<EtiquetaRotulacionDTO> getRegistrosDatosEtiquetas(EtiquetaRotulacionDTO etiqueta)throws Exception ;
	
	public void deleteJSonEtiquetasGeneradas() throws Exception;
	public int insertRotulacionEtiquetasGeneradas(EtiquetaRotulacionDTO etiqueta) throws Exception;
	public List<EtiquetaRotulacionDTO> getRegistrosDatosEtiquetasJsonGeneradas(UsuarioDTO usuario, String uuid)throws Exception ;
	
	public List<EtiquetaRotulacionDTO> 
	getReimpresionRegistrosDatosEtiquetasJsonGeneradas(UsuarioDTO usuario, String fechaini, String fechafin) throws Exception;
	
	public List<EtiquetaRotulacionDTO> getReimpresionRegistrosDatosEtiquetasJsonGeneradas(String[] idregistro)  throws Exception;
	
	public void deleteRegistrosUUID(EtiquetaRotulacionDTO etiqueta) throws Exception ;
	
	
	 public int insertVentaAutoDoc(VentaDTO venta) throws Exception ;
	 public int insertDetalle(DetalleVenta detalleventa) throws Exception;
	 public void updateIdVentaJsonGeneradas(int idregistro, int idventa) throws Exception ;   
	 
	 public void insertVentaAutoDocDetalleRecepcionManifiesto(VentaDTO venta, UsuarioDTO usuario,
		 String manifiesto)  throws Exception;
	 
	 public int insertRotulacionEtiquetasRecepcion(
		    EtiquetaRotulacionDTO etiqueta, String nacional, String manifieto)
		    throws Exception ;
	 
		public List<EtiquetaRotulacionDTO> getReimpresionRegistrosDatosEtiquetasJsonGeneradas(
				String uuid) throws Exception ;
		
		public List<ConvenioContratoDetalleDTO> getDetalleConvenioRotulacion(int idconveniodetalle)
				throws Exception;
		
		public List<CuentasDTO> getDatosClienteEntidad(BusquedaDTO obj) throws Exception;
	    
		/* CAMBIO CITA EVIDENCIA MANIOBRA 
		public List<TarifaDTO>  getRegistrosTarifasRangosEnvios(BusquedaDTO busqueda) throws Exception;
		public List<TarifaDTO>  getRegistrosTarifaPeso(BusquedaDTO busqueda) throws Exception;*/
		public EtiquetaRotulacionDTO getRegistrosTarifaserviciozona(int idconvenio,int identidad,int idorganizacion,String numCliente,String login,float kms) throws Exception;
		/* FIN CAMBIO */
		
		public void UpdateDocumentoUnigis(String iddocumento, int unigis_status);
		
		public void insertLog(String numCliente,String login, String iddocumento,int evento,String data,int tipodoc);
		
		public void updateLogReenvio(String iddocumento);
		
		public String getDeposito(String codigo);
		
		public String getDirection(Envio etiquetaRotulacionDTO);
}