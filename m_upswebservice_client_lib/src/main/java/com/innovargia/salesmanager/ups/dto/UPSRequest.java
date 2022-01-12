package com.innovargia.salesmanager.ups.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.innovargia.salesmanager.ups.dto.ship.ShipmentRequest;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UPSRequest {
	private UPSSecurity UPSSecurity;
	private ShipmentRequest ShipmentRequest;
	/**
	 * @return the uPSSecurity
	 */
	public UPSSecurity getUPSSecurity() {
		return UPSSecurity;
	}
	/**
	 * @param uPSSecurity the uPSSecurity to set
	 */
	public void setUPSSecurity(UPSSecurity uPSSecurity) {
		UPSSecurity = uPSSecurity;
	}
	/**
	 * @return the shipmentRequest
	 */
	public ShipmentRequest getShipmentRequest() {
		return ShipmentRequest;
	}
	/**
	 * @param shipmentRequest the shipmentRequest to set
	 */
	public void setShipmentRequest(ShipmentRequest shipmentRequest) {
		ShipmentRequest = shipmentRequest;
	}
	
}
