package com.innovargia.salesmanager.idao;

import java.util.List;

import com.administracion.dto.AgendaOR;

public interface IAgendaDAO {

	public abstract Number insert(AgendaOR catalogo) throws Exception;

	public abstract void update(AgendaOR catalogo) throws Exception;

	public abstract void updateEstatus(AgendaOR catalogo) throws Exception;

	public abstract void delete(AgendaOR catalogo) throws Exception;

	public abstract List<AgendaOR> getRegistros(AgendaOR catalogo)
			throws Exception;

	public abstract AgendaOR get(AgendaOR catalogo) throws Exception;
	public void updateDatosCierre(AgendaOR catalogo) throws Exception;
	public void updateAsignadoAtiende(AgendaOR catalogo) throws Exception;
	


}