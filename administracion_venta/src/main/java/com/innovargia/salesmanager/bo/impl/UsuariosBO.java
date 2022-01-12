package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IUsuarioBO;
import com.innovargia.salesmanager.idao.IUsuarioDAO;
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
	public void insert(UsuarioCuentaDTO usuario) throws Exception {
	    	//Verifica si existe usuarios con el mismo login
	    UsuarioDTO usuariodto = new UsuarioDTO();
	    usuariodto.setLogin(usuario.getLogin());
	    usuariodto.setSeleccionado(-1);
	    List<UsuarioDTO>  usuarios_login =  iUsuarioDAO.getUsuariosConLogin(usuariodto);
	    if (usuarios_login.size()>0){
		throw new Exception("El login " + usuario.getLogin() + " ya existe dado de alta, verifique");
	    }
	    
		iUsuarioDAO.insert(usuario);
		
	}
	@Override
	public void update(UsuarioCuentaDTO usuario) throws Exception {
	    UsuarioDTO usuariodto = new UsuarioDTO();
	    usuariodto.setLogin(usuario.getLogin());
	    usuariodto.setSeleccionado(usuario.getConsecutivo());
	    List<UsuarioDTO>  usuarios_login =  iUsuarioDAO.getUsuariosConLogin(usuariodto);
	    if (usuarios_login.size()>0){
		throw new Exception("El login " + usuario.getLogin() + " ya existe dado de alta, verifique");
	    }
	    
	    iUsuarioDAO.update(usuario);
		
	}
	@Override
	public void updateEstatus(UsuarioCuentaDTO usuario) throws Exception {
		iUsuarioDAO.updateEstatus(usuario);
	}
	@Override
	public void delete(UsuarioCuentaDTO usuario) throws Exception {
		iUsuarioDAO.delete(usuario);
		
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
		usuario.setPsha1(CheckSumUtility.encryptaPassWordSHA1(pass));
		 
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
	public void insertConvenioUsuario(UsuarioCuentaDTO usuario, int idconvenio)
		throws Exception {
	    iUsuarioDAO.insertConvenioUsuario(usuario, idconvenio);
	    
	}
	

}
