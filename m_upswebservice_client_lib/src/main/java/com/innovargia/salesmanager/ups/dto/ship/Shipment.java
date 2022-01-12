package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shipment {
	String Description;
	ShipData Shipper;
	ShipData   ShipTo;
	ShipData   ShipFrom;
	PaymentInformation PaymentInformation;
	Service Service;
	Package Package;
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @return the shipper
	 */
	public ShipData getShipper() {
		return Shipper;
	}
	/**
	 * @param shipper the shipper to set
	 */
	public void setShipper(ShipData shipper) {
		Shipper = shipper;
	}
	/**
	 * @return the shipTo
	 */
	public ShipData getShipTo() {
		return ShipTo;
	}
	/**
	 * @param shipTo the shipTo to set
	 */
	public void setShipTo(ShipData shipTo) {
		ShipTo = shipTo;
	}
	/**
	 * @return the shipFrom
	 */
	public ShipData getShipFrom() {
		return ShipFrom;
	}
	/**
	 * @param shipFrom the shipFrom to set
	 */
	public void setShipFrom(ShipData shipFrom) {
		ShipFrom = shipFrom;
	}
	/**
	 * @return the paymentInformation
	 */
	public PaymentInformation getPaymentInformation() {
		return PaymentInformation;
	}
	/**
	 * @param paymentInformation the paymentInformation to set
	 */
	public void setPaymentInformation(PaymentInformation paymentInformation) {
		PaymentInformation = paymentInformation;
	}
	/**
	 * @return the service
	 */
	public Service getService() {
		return Service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		Service = service;
	}
	/**
	 * @return the package
	 */
	public Package getPackage() {
		return Package;
	}
	/**
	 * @param package1 the package to set
	 */
	public void setPackage(Package package1) {
		Package = package1;
	}
}
