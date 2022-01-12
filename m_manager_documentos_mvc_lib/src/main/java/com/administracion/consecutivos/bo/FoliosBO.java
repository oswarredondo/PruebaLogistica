package com.administracion.consecutivos.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.Folios;
import com.administracion.ibo.IFoliosBO;
import com.administracion.idao.IFoliosDAO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;


@Service
public class FoliosBO implements IFoliosBO {

	@Autowired
	IFoliosDAO iFoliosDAO;
	public FoliosBO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Folios> getFolios(String cliente, int identidad,
			int idorganizacion, String login) throws SQLException {
		// TODO Auto-generated method stub
		return iFoliosDAO.getFolios(cliente, identidad, idorganizacion, login);
	}

	@Override
	public List<Folios> getConvenios(String cliente, int identidad,
			int idorganizacion, String login, String tipo_formulario) throws SQLException {
		// TODO Auto-generated method stub
		return iFoliosDAO.getConvenios(cliente, identidad, idorganizacion, login, tipo_formulario);
	}

	@Override
	public int getFoliosPCUltimo(String servicio) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Folios> getFoliosAdmin(String cliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Folios> getFoliosPC(String cliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEnviosDisponibles(int entidad, int organizacion,
			String idServicio, String cliente, int peso, Connection cnx)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEnviosDisponiblesRetorno(int entidad, int organizacion,
			String idServicio, String cliente, int peso, Connection cnx)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnviosDisponibles(String idServicio, String cliente,
			int peso) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExisteRangoWeb(String idServicio, String cliente, int peso)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateEnviosDisponibles(Folios folios) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void initUtilizadas(Folios folios) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRangoFolios(Folios folios) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void incrementaFoliosWeb(Folios folios) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertFoliosWeb(Folios folios) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertLogFoliosWeb(Folios folios, String evento)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertFoliosPC(Folios folios) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getConsecutivo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMaxFechaFolios(String cliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Folios> getConveniosAutoDocPDV(UsuarioDTO usuario)
		throws SQLException {
	    List<Folios>  lista_tmp = iFoliosDAO.getConveniosAutoDocPDV(usuario);
	    /*List<Folios>  lista_final = new ArrayList<Folios>();
	    
	    
	    //Barre cada convenio y verifica si pertenece a la plaza de la oficina
	    //y si es super variable o variable
	    ConvenioContratoDTO convenio  = null;
	    for (Folios folios : lista_tmp) {
		
	    }*/
	    
	    return lista_tmp;
	}

	@Override
	public Folios getFoliosDisponibles(String idservicio, String numcliente, int peso_amparado, int identidad,
			int idorganizacion) throws SQLException {
		// TODO Auto-generated method stub
		 return iFoliosDAO.getFoliosDisponibles(idservicio, numcliente, peso_amparado, identidad, idorganizacion);
	}

}
