/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovargia.ws.bo.impl;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.CheckSumUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innovargia.ws.ibo.IWSUsuarioBO;
import com.innovargia.ws.idao.IWSUsuarioDAO;

/**
 *
 * @author aruaro
 */
@Service
public class WSUsuarioBO implements IWSUsuarioBO {

    private static final Logger logger = LoggerFactory
            .getLogger(WSUsuarioBO.class);
    @Autowired
    IWSUsuarioDAO iUsuarioDAO;

    @Override
    public UsuarioDTO getUsuarioLogin(UsuarioDTO usuario) throws Exception {
        String pass = usuario.getPassword();
        usuario.setPassword(CheckSumUtility.encryptaPassWord(pass));
        usuario.setPsha1(CheckSumUtility.encryptaPassWordSHA1(pass));
        return iUsuarioDAO.getUsuarioLogin(usuario);
    }
    
    
}
