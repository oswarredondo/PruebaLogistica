package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.administracion.dto.Folios;

public interface IAdminFoliosBO {

	void insert(Folios obj) throws Exception;

	void increment(Folios obj) throws Exception;

	void delete(Folios obj) throws Exception;

	List<Folios> getRegistros(Folios folio) throws Exception;

}