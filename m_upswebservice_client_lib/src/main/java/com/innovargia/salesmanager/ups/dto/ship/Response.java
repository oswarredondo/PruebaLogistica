package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
	ResponseStatus ResponseStatus;
	TransactionReference TransactionReference;
	/**
	 * @return the responseStatus
	 */
	public ResponseStatus getResponseStatus() {
		return ResponseStatus;
	}
	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(ResponseStatus responseStatus) {
		ResponseStatus = responseStatus;
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
