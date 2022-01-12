package com.innovargia.salesmanager.ups.dto.ship;

public class ShipmentCharges {
	ServiceOptionsCharges TransportationCharges;
	ServiceOptionsCharges ServiceOptionsCharges;
	ServiceOptionsCharges TotalCharges;
	/**
	 * @return the transportationCharges
	 */
	public ServiceOptionsCharges getTransportationCharges() {
		return TransportationCharges;
	}
	/**
	 * @param transportationCharges the transportationCharges to set
	 */
	public void setTransportationCharges(ServiceOptionsCharges transportationCharges) {
		TransportationCharges = transportationCharges;
	}
	/**
	 * @return the serviceOptionsCharges
	 */
	public ServiceOptionsCharges getServiceOptionsCharges() {
		return ServiceOptionsCharges;
	}
	/**
	 * @param serviceOptionsCharges the serviceOptionsCharges to set
	 */
	public void setServiceOptionsCharges(ServiceOptionsCharges serviceOptionsCharges) {
		ServiceOptionsCharges = serviceOptionsCharges;
	}
	/**
	 * @return the totalCharges
	 */
	public ServiceOptionsCharges getTotalCharges() {
		return TotalCharges;
	}
	/**
	 * @param totalCharges the totalCharges to set
	 */
	public void setTotalCharges(ServiceOptionsCharges totalCharges) {
		TotalCharges = totalCharges;
	}
}
