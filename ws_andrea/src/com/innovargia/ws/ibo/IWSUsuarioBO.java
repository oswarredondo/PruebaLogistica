/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovargia.ws.ibo;

import com.innovargia.salesmanager.dtos.UsuarioDTO;

/**
 *
 * @author aruaro
 */
public interface IWSUsuarioBO {

    UsuarioDTO getUsuarioLogin(UsuarioDTO usuario) throws Exception;
    
}
