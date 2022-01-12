package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.ConvenioDescuentoFactura;

public interface IConvenioDescuentoFacturaDAO {

	public abstract void insert(ConvenioDescuentoFactura catalogo) throws Exception;

	public abstract void update(ConvenioDescuentoFactura catalogo) throws Exception;


	public abstract void delete(ConvenioDescuentoFactura catalogo) throws Exception;

	public abstract List<ConvenioDescuentoFactura> getRegistros(ConvenioDescuentoFactura catalogo)
			throws Exception;

	public abstract ConvenioDescuentoFactura get(ConvenioDescuentoFactura catalogo) throws Exception;
	
	public void insertRegistrosDescuentoXFacturacion(int de_idcotizacion, int a_idcotizacion) throws Exception;


}