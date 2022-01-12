package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackageWeight {
	UnitOfMeasurement UnitOfMeasurement;
	String Weight;
	/**
	 * @return the unitOfMeasurement
	 */
	public UnitOfMeasurement getUnitOfMeasurement() {
		return UnitOfMeasurement;
	}
	/**
	 * @param unitOfMeasurement the unitOfMeasurement to set
	 */
	public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
		UnitOfMeasurement = unitOfMeasurement;
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return Weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		Weight = weight;
	}
} 
