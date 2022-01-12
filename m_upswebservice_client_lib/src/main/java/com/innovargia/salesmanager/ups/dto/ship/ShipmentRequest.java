package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipmentRequest {
	Shipment Shipment;
	Request Request;
	LabelSpecification LabelSpecification;
	/**
	 * @return the shipment
	 */
	public Shipment getShipment() {
		return Shipment;
	}
	/**
	 * @param shipment the shipment to set
	 */
	public void setShipment(Shipment shipment) {
		Shipment = shipment;
	}
	/**
	 * @return the request
	 */
	public Request getRequest() {
		return Request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(Request request) {
		Request = request;
	}
	/**
	 * @return the labelSpecification
	 */
	public LabelSpecification getLabelSpecification() {
		return LabelSpecification;
	}
	/**
	 * @param labelSpecification the labelSpecification to set
	 */
	public void setLabelSpecification(LabelSpecification labelSpecification) {
		LabelSpecification = labelSpecification;
	}
}
