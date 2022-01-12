package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {
	String RequestOption;
	TransactionReference TransactionReference;
	/**
	 * @return the requestOption
	 */
	public String getRequestOption() {
		return RequestOption;
	}
	/**
	 * @param requestOption the requestOption to set
	 */
	public void setRequestOption(String requestOption) {
		RequestOption = requestOption;
	}
	/**
	 * @return the transactionReference
	 */
	public TransactionReference getTransactionReference() {
		return TransactionReference;
	}
	/**
	 * @param transactionReference the transactionReference to set
	 */
	public void setTransactionReference(TransactionReference transactionReference) {
		TransactionReference = transactionReference;
	}
}
