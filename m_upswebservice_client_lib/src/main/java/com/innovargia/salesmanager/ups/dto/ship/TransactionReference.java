package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionReference {
	String CustomerContext;

	/**
	 * @return the customerContext
	 */
	public String getCustomerContext() {
		return CustomerContext;
	}

	/**
	 * @param customerContext the customerContext to set
	 */
	public void setCustomerContext(String customerContext) {
		CustomerContext = customerContext;
	}
}
