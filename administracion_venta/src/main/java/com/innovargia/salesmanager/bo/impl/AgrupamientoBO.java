package com.innovargia.salesmanager.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.IAgrupamientoJerarquiaBO;
import com.innovargia.salesmanager.idao.IAdicionalesDAO;
import com.innovargia.salesmanager.idao.IAgrupamientoJerarquiaDAO;

@Service
public class AgrupamientoBO  implements IAgrupamientoJerarquiaBO {

	private static final Logger logger = LoggerFactory
			.getLogger(AgrupamientoBO.class);


	@Autowired
	IAgrupamientoJerarquiaDAO iAgrupamientoJerarquiaDAO;
	public AgrupamientoBO(){
		
	}


	@Override
	public void insert(AgrupamientoDTO catalogo) throws Exception {
		iAgrupamientoJerarquiaDAO.insert(catalogo);
		
	}


	@Override
	public void update(AgrupamientoDTO catalogo) throws Exception {
		iAgrupamientoJerarquiaDAO.update(catalogo);
		
	}


	@Override
	public void updateEstatus(AgrupamientoDTO catalogo) throws Exception {
		iAgrupamientoJerarquiaDAO.updateEstatus(catalogo);
		
	}


	@Override
	public void delete(AgrupamientoDTO catalogo) throws Exception {
		iAgrupamientoJerarquiaDAO.delete(catalogo);
		
	}


	@Override
	public List<AgrupamientoDTO> getRegistros(BusquedaDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iAgrupamientoJerarquiaDAO.getRegistros(catalogo);
	}


	@Override
	public AgrupamientoDTO get(AgrupamientoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return iAgrupamientoJerarquiaDAO.get(catalogo);
	}


	@Override
	public List<AgrupamientoDTO> getRegistrosXTipo(CatalogoDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return  iAgrupamientoJerarquiaDAO.getRegistrosXTipo(catalogo);
	}


	@Override
	public List<UsuarioCuentaDTO> getNivelSuperiorDelUsuario(UsuarioDTO usuario, int limit,boolean mostrarSoloUsuarioConNivelSuperior)
			throws Exception {
		//Verifica si solo se desean los usuarios con nivel immediato superior al del usuario indicado
		int nivelpuesto =-1;
		List<UsuarioCuentaDTO> lista = new ArrayList<UsuarioCuentaDTO>();
		if (mostrarSoloUsuarioConNivelSuperior){
			List<UsuarioCuentaDTO> lista_usuarios_nivel_inmediato_superior = iAgrupamientoJerarquiaDAO.getNivelSuperiorDelUsuario(usuario);
			if (lista_usuarios_nivel_inmediato_superior.size()>0){
				nivelpuesto = lista_usuarios_nivel_inmediato_superior.get(0).getNivelpuesto();
			}
			//No existe un nivel superior al indicado esto es cuando la lista esta vacia
			if (nivelpuesto==-1){
				return lista;
			}
			//Regresa solo los usuarios que tengan el nivel indicado
			return iAgrupamientoJerarquiaDAO.getNivelSuperiorIndicandoElNivel(usuario, 
					nivelpuesto);
		}

		//Obtiene todos los usuarios del agrupamiento	
		return iAgrupamientoJerarquiaDAO.getUsuariosDelMismoGrupo(usuario);
	}


	@Override
	public List<AgrupamientoDTO> getRegistrosAgrupamientosUsuario(String login)
			throws Exception {
		// TODO Auto-generated method stub
		return iAgrupamientoJerarquiaDAO.getRegistrosAgrupamientosUsuario(login);
	}


}
