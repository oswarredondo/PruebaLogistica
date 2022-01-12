package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.ibo.IParametrosSistemaBO;
import com.innovargia.salesmanager.idao.IParametrosSistemaDAO;

@Service
public class ParametrosSistemaBO implements IParametrosSistemaBO {

	private static final Logger logger = LoggerFactory
			.getLogger(ParametrosSistemaBO.class);


	@Autowired
	IParametrosSistemaDAO iParametrosSistemaDAO;
	@Override
	public String getValorPropiedad(String idparametro, String idsistema)
			throws Exception {
		try{
			return iParametrosSistemaDAO.getValorPropiedad(idparametro, idsistema);
		}catch(Exception e){
			logger.error("Error:" + e.getMessage());
		}
	
		return null;
	}
	@Override
	public SistemaDTO getPathsSistema(String idSistema, String numCliente)
			throws Exception {
		
		try{
			return iParametrosSistemaDAO.getPathsSistema(idSistema, numCliente);
		}catch(Exception e){
			logger.error("Error:" + e.getMessage());
		}
		
		return null;
		
	}
	@Override
	public void insert(SistemaDTO catalogo) throws Exception {
		iParametrosSistemaDAO.insert(catalogo);
		
	}
	@Override
	public void update(SistemaDTO catalogo) throws Exception {
		iParametrosSistemaDAO.update(catalogo);
		
	}
	@Override
	public void delete(SistemaDTO catalogo) throws Exception {
		iParametrosSistemaDAO.delete(catalogo);
		
	}
	@Override
	public List<SistemaDTO> getRegistros(String sistema)
			throws Exception {
		// TODO Auto-generated method stub
		return iParametrosSistemaDAO.getRegistros(sistema);
	}


}
