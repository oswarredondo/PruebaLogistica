package com.innovargia.administracion.bo.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.administracion.ibo.IUsuarioBO;
import com.innovargia.administracion.idao.IUsuarioDAO;
import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.CheckSumUtility;

@Service
public class UsuariosBO  implements IUsuarioBO {

	private static final Logger logger = LoggerFactory
			.getLogger(UsuariosBO.class);


	@Autowired
	IUsuarioDAO iUsuarioDAO;
	public UsuariosBO(){
		
	}
	
	@Override
	public List<UsuarioDTO> getRegistros(UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return iUsuarioDAO.getRegistros(usuario);
	}
	@Override
	public List<UsuarioCuentaDTO> getRegistrosCuentaCliente(BusquedaDTO busqueda) throws Exception {
		// TODO Auto-generated method stub
		return iUsuarioDAO.getRegistrosCuentaCliente(busqueda);
	}
	@Override
	public UsuarioCuentaDTO get(UsuarioCuentaDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UsuarioDTO getUsuarioLogin(UsuarioDTO usuario) throws Exception {
	    String pass = usuario.getPassword();
		usuario.setPassword(CheckSumUtility.encryptaPassWord(pass ));
		usuario.setPsha1(CheckSumUtility.encryptaPassWordSHA1( pass));
		return iUsuarioDAO.getUsuarioLogin(usuario);
	}
	
	@Override
	public UsuarioDTO checkSesoinUsuarioLogin(UsuarioDTO usuario) throws Exception {
		return iUsuarioDAO.getUsuarioLogin(usuario);
	}
	@Override
	public void updatePassword(UsuarioDTO user) throws Exception {
		
		user.setPassword(CheckSumUtility.encryptaPassWordSHA1(user.getPassword().trim().toUpperCase()));
		iUsuarioDAO.updatePassword(user);
	}

	@Override
	public void updateWallPaper(UsuarioDTO user) throws Exception {
		iUsuarioDAO.updateWallPaper(user);
	}
	
	@Override
	public List<AgrupamientoDTO>   getAgrupaciones(UsuarioDTO usuario) throws Exception{
		return iUsuarioDAO.getAgrupaciones(usuario) ;
	}
	@Override
	public void insertAgrupamiento(AgrupamientoDTO obj) throws Exception {
		iUsuarioDAO.insertAgrupamiento(obj);
		
	}
	@Override
	public void deleteAgrupamiento(AgrupamientoDTO obj) throws Exception {
		iUsuarioDAO.deleteAgrupamiento(obj);
		
	}
	@Override
	public List<UsuarioDTO> getUsuariosDeUnAgrupamiento(UsuarioDTO usuario)
			throws Exception {
		// TODO Auto-generated method stub
		return iUsuarioDAO.getUsuariosDeUnAgrupamiento(usuario);
	}

	@Override
	public void getEntidadOrganizacion(UsuarioDTO user) throws SQLException {
		iUsuarioDAO.getEntidadOrganizacion(user);
		
	}  

	@Override
	public List<UsuarioDTO> getUsuariosDeUnAgrupamientoYNivel(UsuarioDTO usuario)
			throws Exception {
		// TODO Auto-generated method stub
		return iUsuarioDAO.getUsuariosDeUnAgrupamientoYNivel(usuario);
	}

	@Override
	public UsuarioDTO getUsuarioDeCliente(UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return iUsuarioDAO.getUsuarioDeCliente(usuario);
	}

	@Override
	public String getRfc(UsuarioDTO user) throws Exception {
		
		return iUsuarioDAO.getRfc(user);
		
	}
	

}
