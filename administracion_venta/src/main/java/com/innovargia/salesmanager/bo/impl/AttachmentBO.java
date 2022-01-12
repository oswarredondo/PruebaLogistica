package com.innovargia.salesmanager.bo.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.ibo.IAttachmentBO;
import com.innovargia.salesmanager.idao.IAttachmentDAO;
import com.innovargia.salesmanager.idao.IParametrosSistemaDAO;
import com.innovargia.utils.ConstantesAdminSale;

@Service
public class AttachmentBO  implements IAttachmentBO {

	private static final Logger logger = LoggerFactory
			.getLogger(AttachmentBO.class);


	@Autowired
	IAttachmentDAO dao;
	@Autowired
	IParametrosSistemaDAO iParametrosSistemaDAO;
	public AttachmentBO(){
		
	}


	@Override
	public void insert(AttachmentDTO catalogo,InputStream inputstream) throws Exception {
	
		
		//Guarda el archivo 
		SistemaDTO sistema  = iParametrosSistemaDAO.getPathsSistema(ConstantesAdminSale.ID_APP,
				ConstantesAdminSale.NUM_CTE_APP);
		
		/*String path_attachment= 
				iParametrosSistemaDAO.getValorPropiedad(ConstantesAdminSale.PATHDOC_ATTACHMENT, ConstantesAdminSale.ID_APP) ;*/

		
		//if (path_attachment!=null){
		if (sistema!=null){
			try{
				dao.insert(catalogo); 
				
				//Crea nueva instancia de archivo
				if (inputstream!=null){
					String pathname=sistema.getPathDocsPDFs() + catalogo.getNombre_archivo();
					//String pathname=path_attachment + catalogo.getNombre_archivo();
					
					File file = new File(pathname);
					// Guarda el archivo en la ubicacion de las imagenes
					OutputStream outputStream = new FileOutputStream(file);
					IOUtils.copy(inputstream, outputStream);
					outputStream.close();	
				}
				
			}catch(Exception e){
				dao.delete(catalogo);
				throw new Exception(e.getMessage());
			}
			
		}else{
			//Borra el archivo en caso de que ya se haya dado alta
			dao.delete(catalogo); 
			throw new Exception("No existe configurado path de docuemtos dado de alta [path.documentos.attachment].");
		}

	}


	@Override
	public void update(AttachmentDTO catalogo) throws Exception {
	}


	@Override
	public void updateEstatus(AttachmentDTO catalogo) throws Exception {
		
	}


	@Override
	public void delete(AttachmentDTO catalogo) throws Exception {
		
		if (catalogo.getNombre_archivo()!=null){
			//Guarda el archivo 
			SistemaDTO sistema  = iParametrosSistemaDAO.getPathsSistema(ConstantesAdminSale.ID_APP,
					ConstantesAdminSale.NUM_CTE_APP);
			
			dao.delete(catalogo);
			
			//Borra el archivo de forma física del servidor
			String pathname=sistema.getPathDocsPDFs() + catalogo.getNombre_archivo();
			File archivo = new File(pathname);
			if (archivo.exists()){
				if (archivo.delete()){
					if (archivo.exists()){
						archivo.delete();
					}
				}
			}
		}
		
		
	}


	@Override
	public List<AttachmentDTO> getRegistros(BusquedaDTO catalogo)
			throws Exception {
		if (catalogo.getIdentificador_str().contains(",")){
			
			ArrayList<String> arr_identificador = new ArrayList<String>();
			ArrayList<String> arr_idtipodocumento = new ArrayList<String>();
			String[] str_ = catalogo.getIdentificador_str().split(",");

			for (int i = 0; i < str_.length; i++) {
				arr_identificador.add(str_[i]);
			}

			str_ = catalogo.getTipo_str().split(",");

			for (int i = 0; i < str_.length; i++) {
				arr_idtipodocumento.add(str_[i]);
			}
			return dao.getRegistros(arr_identificador, arr_idtipodocumento);

		}else{
			//Solo para un registro y tipo de documento
			return dao.getRegistros(catalogo);
		}
		
	}


	@Override
	public AttachmentDTO get(AttachmentDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public File getFile(String fileName) {
		
		try {
			SistemaDTO sistema  = iParametrosSistemaDAO.getPathsSistema(ConstantesAdminSale.ID_APP,
					ConstantesAdminSale.NUM_CTE_APP);

			File file = new File(sistema.getPathDocsPDFs() +  fileName);
			return file;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<AttachmentDTO> getRegistros(
			ArrayList<String> arr_identificador,
			ArrayList<String> arr_idtipodocumento) throws Exception {
		// TODO Auto-generated method stub
		return dao.getRegistros(arr_identificador, arr_idtipodocumento);
	}

}
