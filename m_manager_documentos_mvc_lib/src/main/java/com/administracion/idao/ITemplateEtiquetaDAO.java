package com.administracion.idao;

import java.util.List;

import com.administracion.dto.ITextObjeto;
import com.innovargia.custom.exception.DBException;
import com.innovargia.documentos.dtos.Envio;

public interface ITemplateEtiquetaDAO {

	public abstract int insertTemplate(ITextObjeto template) throws DBException;

	public abstract int insertTemplateDetalle(ITextObjeto template)
			throws DBException;

	public abstract void updateTemplate(ITextObjeto template) throws DBException;

	public abstract void updateTemplateDetalle(ITextObjeto template)
			throws DBException;

	public abstract void deleteTemplate(ITextObjeto template,
			ITextObjeto templatedetalle) throws DBException;

	public abstract void deleteTemplateDetalle(ITextObjeto template) throws DBException;

	public abstract List<ITextObjeto> getRegistrosTemplate(ITextObjeto template)
			throws DBException;

	public abstract List<ITextObjeto> getRegistrosLineas(ITextObjeto template)
			throws DBException;
	public List<ITextObjeto> getRegistrosTemplate(String idtemplate)throws DBException;
	// Guia Madre
	public List<Envio> getDatosTablaContenido(List<Envio> arrDatosTabla) throws DBException;
}