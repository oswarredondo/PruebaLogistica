package com.innovargia.salesmanager.ups.dto.ship;

public class PackageResults {
	String TrackingNumber;
	ServiceOptionsCharges ServiceOptionsCharges;
	ShippingLabel ShippingLabel;
	/**
	 * @return the trackingNumber
	 */
	public String getTrackingNumber() {
		return TrackingNumber;
	}
	/**
	 * @param trackingNumber the trackingNumber to set
	 */
	public void setTrackingNumber(String trackingNumber) {
		TrackingNumber = trackingNumber;
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
	 * @return the shippingLabel
	 */
	public ShippingLabel getShippingLabel() {
		return ShippingLabel;
	}
	/**
	 * @param shippingLabel the shippingLabel to set
	 */
	public void setShippingLabel(ShippingLabel shippingLabel) {
		ShippingLabel = shippingLabel;
	}
}
