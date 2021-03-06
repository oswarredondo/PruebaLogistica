package com.administracion.bo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.ibo.IAttachmentNotaBO;
import com.administracion.ibo.IParamsSistemaBO;
import com.administracion.idao.IAgendaNotaDAO;
import com.administracion.idao.IAttachmentNotaDAO;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.servicio.constantes.ConstantesGenerales;

@Service
public class AttachmentNotaBO  implements IAttachmentNotaBO {

	private static final Logger logger = LoggerFactory
			.getLogger(AttachmentNotaBO.class);


	@Autowired
	IAttachmentNotaDAO dao;
	@Autowired
	IParamsSistemaBO iParamsSistemaBO;
	
	@Autowired
	IAgendaNotaDAO iAgendaNotaDAO;
	
	public AttachmentNotaBO(){
		
	}


	@Override
	public void insert(AttachmentDTO catalogo,InputStream inputstream) throws Exception {
	
		
		//Guarda el archivo 
		SistemaDTO sistema  = iParamsSistemaBO.getPathsSistema(ConstantesGenerales.ID_APP,
				ConstantesGenerales.NUM_CTE_APP);
		
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
			SistemaDTO sistema  = iParamsSistemaBO.getPathsSistema(ConstantesGenerales.ID_APP,
					ConstantesGenerales.NUM_CTE_APP);
			
			dao.delete(catalogo);
			
			//Borra el archivo de forma f???sica del servidor
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
			SistemaDTO sistema  = iParamsSistemaBO.getPathsSistema(ConstantesGenerales.ID_APP,
					ConstantesGenerales.NUM_CTE_APP);

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


    @Override
    public void insertNotaAgenda(AttachmentDTO catalogo, InputStream inputstream)
	    throws Exception {
	// Guarda el archivo
	SistemaDTO sistema = iParamsSistemaBO.getPathsSistema(
		ConstantesGenerales.ID_APP, ConstantesGenerales.NUM_CTE_APP);

	if (sistema != null) {
	    try {
		iAgendaNotaDAO.insert(catalogo);

		// Crea nueva instancia de archivo
		if (inputstream != null) {
		    String pathname = sistema.getPathDocsPDFs()
			    + catalogo.getNombre_archivo();


		    File file = new File(pathname);
		   
		    // Guarda el archivo en la ubicacion de las imagenes
		    OutputStream outputStream = new FileOutputStream(file);
		    IOUtils.copy(inputstream, outputStream);
		    outputStream.close();
		}

	    } catch (Exception e) {
		dao.delete(catalogo);
		throw new Exception(e.getMessage());
	    }

	} else {
	    // Borra el archivo en caso de que ya se haya dado alta
	    dao.delete(catalogo);
	    throw new Exception(
		    "No existe configurado path de docuemtos dado de alta [path.documentos.attachment].");
	}

    }

	@Override
	public void updateNotaAgenda(AttachmentDTO catalogo) throws Exception {
	    iAgendaNotaDAO.update(catalogo);
	    
	}


	@Override
	public void updateEstatusAgenda(AttachmentDTO catalogo)
		throws Exception {
	    iAgendaNotaDAO.updateEstatus(catalogo);
	    
	}


	@Override
	public void deleteAgenda(AttachmentDTO catalogo) throws Exception {
	 
	    
	    if (catalogo.getNombre_archivo()!=null){
		//Guarda el archivo 
		SistemaDTO sistema  = iParamsSistemaBO.getPathsSistema(ConstantesGenerales.ID_APP,
				ConstantesGenerales.NUM_CTE_APP);
		
		   iAgendaNotaDAO.delete(catalogo);
		
		//Borra el archivo de forma f???sica del servidor
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
	public List<AttachmentDTO> getRegistrosNotasAgenda(BusquedaDTO catalogo)
		throws Exception {
	    // TODO Auto-generated method stub
	    return iAgendaNotaDAO.getRegistros(catalogo);
	}


    @Override
    public File getFileNotasAgenda(String fileName) {
	try {
	    SistemaDTO sistema = iParamsSistemaBO
		    .getPathsSistema(ConstantesGenerales.ID_APP,
			    ConstantesGenerales.NUM_CTE_APP);

	    File file = new File(sistema.getPathDocsPDFs() + fileName);
	    return file;

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return null;
    }


	@Override
	public AttachmentDTO getRegistro(int idregistro) throws Exception {
		// TODO Auto-generated method stub
		return dao.getRegistro(idregistro);
	}
	
	@Override
	public AttachmentDTO getRegistroBase64(int idregistro) throws Exception {
		// TODO Auto-generated method stub
		return dao.getRegistroBase64(idregistro);
	}

}
