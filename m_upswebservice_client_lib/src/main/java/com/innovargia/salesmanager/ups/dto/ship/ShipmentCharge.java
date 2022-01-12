package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipmentCharge {
	String Type;
	BillShipper BillShipper;
	/**
	 * @return the type
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}
	/**
	 * @return the billShipper
	 */
	public BillShipper getBillShipper() {
		return BillShipper;
	}
	/**
	 * @param billShipper the billShipper to set
	 */
	public void setBillShipper(BillShipper billShipper) {
		BillShipper = billShipper;
	}
}
