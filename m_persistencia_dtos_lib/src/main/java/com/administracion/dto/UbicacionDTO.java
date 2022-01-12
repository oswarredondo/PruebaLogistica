package com.administracion.dto;

import java.io.Serializable;

public class UbicacionDTO implements Serializable{

    String latitude;
    String longitude;
    String title;
    String content;
    String iconmarket;
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UbicacionDTO() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the iconmarket
     */
    public String getIconmarket() {
        return iconmarket;
    }

    /**
     * @param iconmarket the iconmarket to set
     */
    public void setIconmarket(String iconmarket) {
        this.iconmarket = iconmarket;
    }

}
