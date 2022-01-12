package org.rest_tracusa_logistica.struct;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

//import com.easypost.exception.EasyPostException;
//import com.easypost.net.EasyPostResource;

public class Parcel {
    private String id;
    private String predefinedPackage;
    private Float weight;
    private Float length;
    private Float width;
    private Float height;

    public String getId() {
            return id;
    }
    public void setId(String id) {
            this.id = id;
    }

    public String getPredefinedPackage() {
            return predefinedPackage;
    }
    public void setPredefinedPackage(String predefinedPackage) {
            this.predefinedPackage = predefinedPackage;
    }

    public Float getWeight() {
            return weight;
    }
    public void setWeight(Float weight) {
            this.weight = weight;
    }

    public Float getLength() {
            return length;
    }
    public void setLength(Float length) {
            this.length = length;
    }

    public Float getWidth() {
            return width;
    }
    public void setWidth(Float width) {
            this.width = width;
    }

    public Float getHeight() {
            return height;
    }
    public void setHeight(Float height) {
            this.height = height;
    }
}