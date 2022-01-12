package com.innovargia.salesmanager.ups.dto.ship;

public class ShippingLabel {
	LabelImageFormat ImageFormat;
	String GraphicImage;
	String HTMLImage;
	/**
	 * @return the imageFormat
	 */
	public LabelImageFormat getImageFormat() {
		return ImageFormat;
	}
	/**
	 * @param imageFormat the imageFormat to set
	 */
	public void setImageFormat(LabelImageFormat imageFormat) {
		ImageFormat = imageFormat;
	}
	/**
	 * @return the graphicImage
	 */
	public String getGraphicImage() {
		return GraphicImage;
	}
	/**
	 * @param graphicImage the graphicImage to set
	 */
	public void setGraphicImage(String graphicImage) {
		GraphicImage = graphicImage;
	}
	/**
	 * @return the hTMLImage
	 */
	public String getHTMLImage() {
		return HTMLImage;
	}
	/**
	 * @param hTMLImage the hTMLImage to set
	 */
	public void setHTMLImage(String hTMLImage) {
		HTMLImage = hTMLImage;
	}
}
