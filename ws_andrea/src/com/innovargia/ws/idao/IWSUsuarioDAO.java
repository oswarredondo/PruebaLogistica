/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovargia.ws.idao;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import java.util.List;

/**
 *
 * @author aruaro
 */
public interface IWSUsuarioDAO {

    UsuarioDTO getUsuarioLogin(UsuarioDTO usuario) throws Exception;

    List<UsuarioDTO> getUsuariosConLogin(UsuarioDTO usuario) throws Exception;
    
}
