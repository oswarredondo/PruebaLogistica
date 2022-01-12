package com.innovargia.salesmanager.ups.dto;

public class ServiceAccessToken {
	private String AccessLicenseNumber;

	public ServiceAccessToken(String accessKey){
		this.AccessLicenseNumber =accessKey; 
	}
	/**
	 * @return the accessLicenseNumber
	 */
	public String getAccessLicenseNumber() {
		return AccessLicenseNumber;
	}

	/**
	 * @param accessLicenseNumber the accessLicenseNumber to set
	 */
	public void setAccessLicenseNumber(String accessLicenseNumber) {
		AccessLicenseNumber = accessLicenseNumber;
	}
}
