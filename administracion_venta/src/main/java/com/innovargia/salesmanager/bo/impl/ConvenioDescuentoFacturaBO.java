package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertTabAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.ConvenioDescuentoFactura;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.IConvenioDescuentoFacturaBO;
import com.innovargia.salesmanager.idao.IAdicionalesDAO;
import com.innovargia.salesmanager.idao.IConvenioDescuentoFacturaDAO;

@Service
public class ConvenioDescuentoFacturaBO  implements IConvenioDescuentoFacturaBO {

	private static final Logger logger = LoggerFactory
			.getLogger(ConvenioDescuentoFacturaBO.class);


	@Autowired
	IConvenioDescuentoFacturaDAO iConvenioDescuentoFacturaDAO;
	public ConvenioDescuentoFacturaBO(){
		
	}
	@Override
	public void insert(ConvenioDescuentoFactura catalogo) throws Exception {
	    iConvenioDescuentoFacturaDAO.insert(catalogo);
	    
	}
	@Override
	public void update(ConvenioDescuentoFactura catalogo) throws Exception {
	    iConvenioDescuentoFacturaDAO.update(catalogo);
	    
	}
	@Override
	public void delete(ConvenioDescuentoFactura catalogo) throws Exception {
	    iConvenioDescuentoFacturaDAO.delete(catalogo);
	    
	}
	@Override
	public List<ConvenioDescuentoFactura> getRegistros(
		ConvenioDescuentoFactura catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    return iConvenioDescuentoFacturaDAO.getRegistros(catalogo);
	}
	@Override
	public ConvenioDescuentoFactura get(ConvenioDescuentoFactura catalogo)
		throws Exception {
	    // TODO Auto-generated method stub
	    return iConvenioDescuentoFacturaDAO.get(catalogo);
	}


	


}
