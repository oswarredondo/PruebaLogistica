package org.rest_tracusa_logistica.struct;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

//import com.easypost.exception.EasyPostException;
//import com.easypost.net.EasyPostResource;

public class CustomsItem {
    public String id;
    private String description;
    private String hsTariffNumber;
    private String originCountry;
    private int quantity;
    private Float value;
    private Float weight;

    public String getId() {
            return id;
    }
    public void setId(String id) {
            this.id = id;
    }

    public String getDescription() {
            return description;
    }
    public void setDescription(String description) {
            this.description = description;
    }

    public String getHsTariffNumber() {
            return hsTariffNumber;
    }
    public void setHsTariffNumber(String hsTariffNumber) {
            this.hsTariffNumber = hsTariffNumber;
    }

    public String getOriginCountry() {
            return originCountry;
    }
    public void setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
    }

    public int getQuantity() {
            return quantity;
    }
    public void setQuantity(int quantity) {
            this.quantity = quantity;
    }

    public Float getValue() {
            return value;
    }
    public void setValue(Float value) {
            this.value = value;
    }

    public Float getWeight() {
            return weight;
    }
    public void setWeight(Float weight) {
            this.weight = weight;
    }
}
