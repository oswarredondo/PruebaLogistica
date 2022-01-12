package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
	String AddressLine;
	String City;
	String StateProvinceCode;
	String PostalCode;
	String CountryCode;
	/**
	 * @return the addressLine
	 */
	public String getAddressLine() {
		return AddressLine;
	}
	/**
	 * @param addressLine the addressLine to set
	 */
	public void setAddressLine(String addressLine) {
		AddressLine = addressLine;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * @return the stateProvinceCode
	 */
	public String getStateProvinceCode() {
		return StateProvinceCode;
	}
	/**
	 * @param stateProvinceCode the stateProvinceCode to set
	 */
	public void setStateProvinceCode(String stateProvinceCode) {
		StateProvinceCode = stateProvinceCode;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return PostalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return CountryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
}
