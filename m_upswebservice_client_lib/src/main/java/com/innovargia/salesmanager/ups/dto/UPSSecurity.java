package com.innovargia.salesmanager.ups.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UPSSecurity {
	private UsernameToken UsernameToken;
	private ServiceAccessToken ServiceAccessToken;
	
	public UPSSecurity(UsernameToken usernameToken, ServiceAccessToken serviceAccessToken){
		this.UsernameToken =usernameToken;
		this.ServiceAccessToken = serviceAccessToken;
	}
	/**
	 * @return the usernameToken
	 */
	public UsernameToken getUsernameToken() {
		return UsernameToken;
	}
	/**
	 * @param usernameToken the usernameToken to set
	 */
	public void setUsernameToken(UsernameToken usernameToken) {
		UsernameToken = usernameToken;
	}
	/**
	 * @return the serviceAccessToken
	 */
	public ServiceAccessToken getServiceAccessToken() {
		return ServiceAccessToken;
	}
	/**
	 * @param serviceAccessToken the serviceAccessToken to set
	 */
	public void setServiceAccessToken(ServiceAccessToken serviceAccessToken) {
		ServiceAccessToken = serviceAccessToken;
	}
}
