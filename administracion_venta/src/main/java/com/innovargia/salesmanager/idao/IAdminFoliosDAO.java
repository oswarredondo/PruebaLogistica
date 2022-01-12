package com.innovargia.salesmanager.idao;

import java.util.List;

import com.administracion.dto.Folios;

public interface IAdminFoliosDAO {

	void insert(Folios obj) throws Exception;

	void increment(Folios obj) throws Exception;

	void delete(Folios obj) throws Exception;

	List<Folios> getRegistros(Folios folio) throws Exception;

}