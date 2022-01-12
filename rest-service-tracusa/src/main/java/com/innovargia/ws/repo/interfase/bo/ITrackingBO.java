package com.innovargia.ws.repo.interfase.bo;

import com.innovargia.model.RequestTracking;
import com.innovargia.model.ResponseTracking;
import com.innovargia.model.ResponseTrackingSign;
import com.innovargia.ws.tracking.rest.utils.ExceptionTracking;

public interface ITrackingBO {

	ResponseTracking tracking(RequestTracking request) throws ExceptionTracking;

	ResponseTrackingSign sign(RequestTracking request) throws ExceptionTracking;

}