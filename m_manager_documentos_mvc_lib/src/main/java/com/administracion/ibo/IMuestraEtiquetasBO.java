package com.administracion.ibo;

import java.io.IOException;
import java.util.List;

import com.administracion.dto.ITextObjeto;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IMuestraEtiquetasBO {

	public abstract String generaPDFGuia(List<Envio> ar_envios,
			UsuarioDTO usuario, String tipoimpresion, String idSistema, String idtemplate) throws Exception;
	
	/**
	 * Genera las etiquetas y las avienta al stream y devuelve el nombre del
	 * archivo
	 * 
	 * @param idCarta
	 * @param response
	 * @param isCopia
	 * @throws IOException
	 */
	public abstract String muestrarPDFGuia(List<Envio> ar_envios,
			UsuarioDTO usuario, String tipoimpresion, String idSistema) throws Exception;
	
	public String muestrarPDFGuia(List<Envio> ar_envios,
			UsuarioDTO usuario,String tipoimpresion, String idSistema,
			ITextObjeto plantilla,List<ITextObjeto> lista_detalle )
			throws Exception ;

}