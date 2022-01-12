package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipData {
	String Name;
	String AttentionName;
	String TaxIdentificationNumber;
	Phone Phone;
	String ShipperNumber;
	String FaxNumber;
	Address Address;
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the attentionName
	 */
	public String getAttentionName() {
		return AttentionName;
	}
	/**
	 * @param attentionName the attentionName to set
	 */
	public void setAttentionName(String attentionName) {
		AttentionName = attentionName;
	}
	/**
	 * @return the taxIdentificationNumber
	 */
	public String getTaxIdentificationNumber() {
		return TaxIdentificationNumber;
	}
	/**
	 * @param taxIdentificationNumber the taxIdentificationNumber to set
	 */
	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		TaxIdentificationNumber = taxIdentificationNumber;
	}
	/**
	 * @return the phone
	 */
	public Phone getPhone() {
		return Phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Phone phone) {
		Phone = phone;
	}
	/**
	 * @return the shipperNumber
	 */
	public String getShipperNumber() {
		return ShipperNumber;
	}
	/**
	 * @param shipperNumber the shipperNumber to set
	 */
	public void setShipperNumber(String shipperNumber) {
		ShipperNumber = shipperNumber;
	}
	/**
	 * @return the faxNumber
	 */
	public String getFaxNumber() {
		return FaxNumber;
	}
	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {
		FaxNumber = faxNumber;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		Address = address;
	}
}
