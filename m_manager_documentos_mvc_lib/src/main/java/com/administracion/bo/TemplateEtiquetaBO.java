package com.administracion.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.ITextObjeto;
import com.administracion.ibo.ITemplateEtiquetaBO;
import com.administracion.idao.ITemplateEtiquetaDAO;
import com.innovargia.documentos.dtos.Envio;

@Service
public class TemplateEtiquetaBO  implements ITemplateEtiquetaBO {

	private static final Logger logger = LoggerFactory
			.getLogger(TemplateEtiquetaBO.class);


	@Autowired
	ITemplateEtiquetaDAO iTemplateEtiquetaDAO;


	@Override
	public int insertTemplate(ITextObjeto template) throws Exception {
		// TODO Auto-generated method stub
		return iTemplateEtiquetaDAO.insertTemplate(template);
	}


	@Override
	public int insertTemplateDetalle(ITextObjeto template) throws Exception {
		// TODO Auto-generated method stub
		return iTemplateEtiquetaDAO.insertTemplateDetalle(template);
	}


	@Override
	public void updateTemplate(ITextObjeto template) throws Exception {
		// TODO Auto-generated method stub
		iTemplateEtiquetaDAO.updateTemplate(template);
	}


	@Override
	public void updateTemplateDetalle(ITextObjeto template) throws Exception {
		// TODO Auto-generated method stub
		iTemplateEtiquetaDAO.updateTemplateDetalle(template);
	}


	@Override
	public void deleteTemplate(ITextObjeto template, ITextObjeto templatedetalle)
			throws Exception {
		iTemplateEtiquetaDAO.deleteTemplate(templatedetalle,templatedetalle);
		
	}


	@Override
	public void deleteTemplateDetalle(ITextObjeto template) throws Exception {
		// TODO Auto-generated method stub
		iTemplateEtiquetaDAO.deleteTemplateDetalle(template);
	}


	@Override
	public List<ITextObjeto> getRegistrosTemplate(ITextObjeto template)
			throws Exception {
		// TODO Auto-generated method stub
		return iTemplateEtiquetaDAO.getRegistrosTemplate(template);
	}


	@Override
	public List<ITextObjeto> getRegistrosLineas(ITextObjeto template)
			throws Exception {
		// TODO Auto-generated method stub
		return iTemplateEtiquetaDAO.getRegistrosLineas(template);
	}


	@Override
	public List<ITextObjeto> getRegistrosTemplate(String idtemplate)
			throws Exception {
		// TODO Auto-generated method stub
		return iTemplateEtiquetaDAO.getRegistrosTemplate(idtemplate);
	}

	@Override
	public List<Envio> getDatosTablaContenido(List<Envio>  arrDatosTabla)
			throws Exception {
		// TODO Auto-generated method stub
		return iTemplateEtiquetaDAO.getDatosTablaContenido(arrDatosTabla);
	}

	@Override
	public void insertTemplateClone(ITextObjeto template,String idtemplateclone) throws Exception {
		

		List<ITextObjeto> listatemplate  =getRegistrosTemplate(template);
		ITextObjeto template_new = listatemplate.get(0);
		template_new.setIdtemplate(idtemplateclone);
		insertTemplate(template_new);
		
		List<ITextObjeto> lineas = getRegistrosLineas(template);
		for (ITextObjeto iTextObjeto : lineas) {
			iTextObjeto.setIdtemplate(idtemplateclone);
			insertTemplateDetalle(iTextObjeto);
		}

	}


}
