package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillShipper {
	String AccountNumber;

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return AccountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
}
