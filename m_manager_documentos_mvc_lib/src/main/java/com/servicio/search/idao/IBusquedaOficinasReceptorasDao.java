package com.servicio.search.idao;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.servicio.dtos.OficinasDTO;

public interface IBusquedaOficinasReceptorasDao {

	public abstract List<OficinasDTO> getOficinasReceptoras(BusquedaDTO busqueda)
			throws SQLException;

	public abstract void insert(OficinasDTO objeto) throws Exception;
	
	public List<OficinasDTO> getOficinasReceptorasPDVCaja(BusquedaDTO busqueda)throws SQLException;
	
	public List<OficinasDTO> getOficinasReceptorasConOcurre(BusquedaDTO busqueda)throws SQLException ;
	
	public List<OficinasDTO> getOficinasReceptorasPDVs(BusquedaDTO busqueda)throws SQLException ;
	 public List<OficinasDTO> getPDVAsignadosAlUsuario(BusquedaDTO busqueda) throws SQLException ; 
	    public List<OficinasDTO> getUsuarioAsignadosAlPDV(BusquedaDTO busqueda)
		    throws SQLException ;
	    
	    public OficinasDTO getOficinaReceptora(BusquedaDTO busqueda)
		    throws SQLException;
	    


}