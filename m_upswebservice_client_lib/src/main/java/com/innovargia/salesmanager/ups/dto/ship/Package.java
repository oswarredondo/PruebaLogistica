package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Package {
	String Description;
	Packaging Packaging;
	Dimensions Dimensions;
	PackageWeight PackageWeight;
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
	 * @return the packaging
	 */
	public Packaging getPackaging() {
		return Packaging;
	}
	/**
	 * @param packaging the packaging to set
	 */
	public void setPackaging(Packaging packaging) {
		Packaging = packaging;
	}
	/**
	 * @return the dimensions
	 */
	public Dimensions getDimensions() {
		return Dimensions;
	}
	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(Dimensions dimensions) {
		Dimensions = dimensions;
	}
	/**
	 * @return the packageWeight
	 */
	public PackageWeight getPackageWeight() {
		return PackageWeight;
	}
	/**
	 * @param packageWeight the packageWeight to set
	 */
	public void setPackageWeight(PackageWeight packageWeight) {
		PackageWeight = packageWeight;
	}
}
