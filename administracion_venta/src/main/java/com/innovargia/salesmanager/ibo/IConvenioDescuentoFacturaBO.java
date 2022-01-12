package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.ConvenioDescuentoFactura;

public interface IConvenioDescuentoFacturaBO {

	public abstract void insert(ConvenioDescuentoFactura catalogo) throws Exception;

	public abstract void update(ConvenioDescuentoFactura catalogo) throws Exception;


	public abstract void delete(ConvenioDescuentoFactura catalogo) throws Exception;

	public abstract List<ConvenioDescuentoFactura> getRegistros(ConvenioDescuentoFactura catalogo)
			throws Exception;

	public abstract ConvenioDescuentoFactura get(ConvenioDescuentoFactura catalogo) throws Exception;


}