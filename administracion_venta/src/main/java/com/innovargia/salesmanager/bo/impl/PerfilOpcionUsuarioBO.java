package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.PerfilOpcionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IPerfilOpcionUsuarioBO;
import com.innovargia.salesmanager.idao.IPerfilOpcionUsuarioDAO;

@Service
public class PerfilOpcionUsuarioBO implements IPerfilOpcionUsuarioBO {
	private static final Logger logger = LoggerFactory
			.getLogger(PerfilOpcionUsuarioBO.class);

	@Autowired
	IPerfilOpcionUsuarioDAO iPerfilOpcionUsuarioDAO;
	public PerfilOpcionUsuarioBO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PerfilOpcionDTO> getPerfiles(UsuarioDTO usuario,
			boolean onlyActive) throws Exception {
		// TODO Auto-generated method stub
		return iPerfilOpcionUsuarioDAO.getPerfiles(usuario, onlyActive);
	}

	@Override
	public List<PerfilOpcionDTO> getOpcionesPerfil(String idperfil,
			UsuarioDTO usuario, boolean isSeleccionados, String idsistema)
			throws Exception {
		// TODO Auto-generated method stub
		return iPerfilOpcionUsuarioDAO.getOpcionesPerfil(idperfil, usuario, isSeleccionados, idsistema);
	}

	@Override
	public List<PerfilOpcionDTO> getPerfilesXNivel(String listaniveles,
			UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return iPerfilOpcionUsuarioDAO.getPerfilesXNivel(listaniveles, usuario);
	}

	@Override
	public PerfilOpcionDTO getOpcionesPerfilAcceso(UsuarioDTO usuario,
			String idmodulo) throws Exception {
		// TODO Auto-generated method stub
		return iPerfilOpcionUsuarioDAO.getOpcionesPerfilAcceso(usuario, idmodulo);
	}

	@Override
	public PerfilOpcionDTO getOpcionesPerfilAccesoWin(UsuarioDTO usuario,
			String idmodulo) throws Exception {
		// TODO Auto-generated method stub
		return iPerfilOpcionUsuarioDAO.getOpcionesPerfilAccesoWin(usuario, idmodulo);
	}

	@Override
	public PerfilOpcionDTO isOpcionPerfilAcceso(UsuarioDTO usuario,
			String idopcion) throws Exception {
		// TODO Auto-generated method stub
		return iPerfilOpcionUsuarioDAO.isOpcionPerfilAcceso(usuario, idopcion);
	}

	@Override
	public void add(PerfilOpcionDTO perfil) throws Exception {
		// TODO Auto-generated method stub
		iPerfilOpcionUsuarioDAO.add(perfil);
	}

	@Override
	public void delete(PerfilOpcionDTO perfil) throws Exception {
		// TODO Auto-generated method stub
		iPerfilOpcionUsuarioDAO.delete(perfil);
	}

	@Override
	public void updatePerfil(PerfilOpcionDTO perfil) throws Exception {
		// TODO Auto-generated method stub
		iPerfilOpcionUsuarioDAO.updatePerfil(perfil);
		
	}

	@Override
	public void updateEstado(PerfilOpcionDTO perfil) throws Exception {
		// TODO Auto-generated method stub
		iPerfilOpcionUsuarioDAO.updateEstado(perfil);
	}

	@Override
	public void deleteOpcionPerfil(PerfilOpcionDTO perfil) throws Exception {
		// TODO Auto-generated method stub
		iPerfilOpcionUsuarioDAO.deleteOpcionPerfil(perfil);
	}

	@Override
	public void addOpcionPerfil(PerfilOpcionDTO perfil) throws Exception {
		// TODO Auto-generated method stub
		iPerfilOpcionUsuarioDAO.addOpcionPerfil(perfil);
	}

}
