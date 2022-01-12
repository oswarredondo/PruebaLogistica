package com.innovargia.autodoc.dto;

import org.springframework.security.core.GrantedAuthority;

public class PermissionRoleDTO implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	
	private String role;
    
    public PermissionRoleDTO(String role){
        this.role=role;
    }

    public String getAuthority() {
        return role;
    }
}
