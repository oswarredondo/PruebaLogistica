package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipmentResults {
	ShipmentCharges ShipmentCharges;
	BillingWeight BillingWeight;
	String ShipmentIdentificationNumber;
	com.innovargia.salesmanager.ups.dto.ship.PackageResults PackageResults;
	/**
	 * @return the shipmentCharges
	 */
	public ShipmentCharges getShipmentCharges() {
		return ShipmentCharges;
	}
	/**
	 * @param shipmentCharges the shipmentCharges to set
	 */
	public void setShipmentCharges(ShipmentCharges shipmentCharges) {
		ShipmentCharges = shipmentCharges;
	}
	/**
	 * @return the billingWeight
	 */
	public BillingWeight getBillingWeight() {
		return BillingWeight;
	}
	/**
	 * @param billingWeight the billingWeight to set
	 */
	public void setBillingWeight(BillingWeight billingWeight) {
		BillingWeight = billingWeight;
	}
	/**
	 * @return the shipmentIdentificationNumber
	 */
	public String getShipmentIdentificationNumber() {
		return ShipmentIdentificationNumber;
	}
	/**
	 * @param shipmentIdentificationNumber the shipmentIdentificationNumber to set
	 */
	public void setShipmentIdentificationNumber(String shipmentIdentificationNumber) {
		ShipmentIdentificationNumber = shipmentIdentificationNumber;
	}
	/**
	 * @return the packageResults
	 */
	public PackageResults getPackageResults() {
		return PackageResults;
	}
	/**
	 * @param packageResults the packageResults to set
	 */
	public void setPackageResults(PackageResults packageResults) {
		PackageResults = packageResults;
	}
}
