package com.administracion.ibo;

import java.util.List;

import com.administracion.dto.ITextObjeto;
import com.innovargia.documentos.dtos.Envio;

public interface ITemplateEtiquetaBO {

	public abstract int insertTemplate(ITextObjeto template) throws Exception;
	public abstract void insertTemplateClone(ITextObjeto template, String idtemplateclone) throws Exception;

	public abstract int insertTemplateDetalle(ITextObjeto template)
			throws Exception;

	public abstract void updateTemplate(ITextObjeto template) throws Exception;

	public abstract void updateTemplateDetalle(ITextObjeto template)
			throws Exception;

	public abstract void deleteTemplate(ITextObjeto template,
			ITextObjeto templatedetalle) throws Exception;

	public abstract void deleteTemplateDetalle(ITextObjeto template) throws Exception;

	public abstract List<ITextObjeto> getRegistrosTemplate(ITextObjeto template)
			throws Exception;

	public abstract List<ITextObjeto> getRegistrosLineas(ITextObjeto template)
			throws Exception;
	public List<ITextObjeto> getRegistrosTemplate(String idtemplate)throws Exception;
	
	//Guia Madre
	public abstract List<Envio> getDatosTablaContenido(List<Envio> arrDatosTabla) throws Exception;

}