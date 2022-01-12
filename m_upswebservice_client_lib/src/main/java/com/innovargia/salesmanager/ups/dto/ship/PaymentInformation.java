package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentInformation {
	ShipmentCharge ShipmentCharge;

	/**
	 * @return the shipmentCharge
	 */
	public ShipmentCharge getShipmentCharge() {
		return ShipmentCharge;
	}

	/**
	 * @param shipmentCharge the shipmentCharge to set
	 */
	public void setShipmentCharge(ShipmentCharge shipmentCharge) {
		ShipmentCharge = shipmentCharge;
	}
}
