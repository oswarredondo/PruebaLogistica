package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabelSpecification {
	LabelImageFormat LabelImageFormat;
	String HTTPUserAgent;
	/**
	 * @return the labelImageFormat
	 */
	public LabelImageFormat getLabelImageFormat() {
		return LabelImageFormat;
	}
	/**
	 * @param labelImageFormat the labelImageFormat to set
	 */
	public void setLabelImageFormat(LabelImageFormat labelImageFormat) {
		LabelImageFormat = labelImageFormat;
	}
	/**
	 * @return the hTTPUserAgent
	 */
	public String getHTTPUserAgent() {
		return HTTPUserAgent;
	}
	/**
	 * @param hTTPUserAgent the hTTPUserAgent to set
	 */
	public void setHTTPUserAgent(String hTTPUserAgent) {
		HTTPUserAgent = hTTPUserAgent;
	}

}
