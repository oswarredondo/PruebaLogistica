package org.rest_tracusa_logistica.struct;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

//import com.easypost.exception.EasyPostException;
//import com.easypost.net.EasyPostResource;

public class CustomsInfo {
    public String id;
    private String contentsType;
    private String contentsExplanation;
    private boolean customsCertify;
    private String customsSigner;
    private String nonDeliveryOption;
    private String restrictionType;
    private String restrictionComments;
    private List<CustomsItem> customsItems;

    public String getId() {
            return id;
    }
    public void setId(String id) {
            this.id = id;
    }

    public String getContentsType() {
            return contentsType;
    }
    public void setContentsType(String contentsType) {
            this.contentsType = contentsType;
    }

    public String getContentsExplanation() {
            return contentsExplanation;
    }
    public void setContentsExplanation(String contentsExplanation) {
            this.contentsExplanation = contentsExplanation;
    }

    public boolean getCustomsCertify() {
            return customsCertify;
    }
    public void setCustomsCertify(boolean customsCertify) {
            this.customsCertify = customsCertify;
    }

    public String getCustomsSigner() {
            return customsSigner;
    }
    public void setCustomsSigner(String customsSigner) {
            this.customsSigner = customsSigner;
    }

    public String getNonDeliveryOption() {
            return nonDeliveryOption;
    }
    public void setNonDeliveryOption(String nonDeliveryOption) {
            this.nonDeliveryOption = nonDeliveryOption;
    }

    public String getRestrictionType() {
            return restrictionType;
    }
    public void setRestrictionType(String restrictionType) {
            this.restrictionType = restrictionType;
    }

    public String getRestrictionComments() {
            return restrictionComments;
    }
    public void setRestrictionComments(String restrictionComments) {
            this.restrictionComments = restrictionComments;
    }

    public List<CustomsItem> getCustomsItems() {
            return customsItems;
    }
    public void setCustomsItems(List<CustomsItem> customsItems) {
            this.customsItems = customsItems;
    }
}
