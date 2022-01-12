package com.innovargia.security;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

import com.innovargia.utils.FilterCharacter;

public class RequestWrapper extends HttpServletRequestWrapper {

	

	public RequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);

		if (values == null) {
			return null;
		}

		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = stripXSS(values[i]);
		}

		return encodedValues;
	}

	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);

		return stripXSS(value);
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		return stripXSS(value);
	}

	private String stripXSS(String value) {

		if (value != null) {
			// value = value.toLowerCase();
			// NOTE: It's highly recommended to use the ESAPI library and
			// uncomment the following line to
			// avoid encoded attacks.
			value = ESAPI.encoder().canonicalize(value);
			value  = FilterCharacter.filter(value);

		}
		return value;
	}
}
