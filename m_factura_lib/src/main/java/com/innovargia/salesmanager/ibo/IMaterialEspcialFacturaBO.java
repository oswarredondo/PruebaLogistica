package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.administracion.dto.MaterialEspecialFactura;

public interface IMaterialEspcialFacturaBO {

	int insert(MaterialEspecialFactura obj) throws Exception;

	void update(MaterialEspecialFactura obj) throws Exception;

	void delete(MaterialEspecialFactura obj) throws Exception;

	void deleteAll(MaterialEspecialFactura obj) throws Exception;

	List<MaterialEspecialFactura> getRegistros(MaterialEspecialFactura obj) throws Exception;
	
	public List<MaterialEspecialFactura> getRegistrosNoIncluidos(MaterialEspecialFactura obj) throws Exception;

}