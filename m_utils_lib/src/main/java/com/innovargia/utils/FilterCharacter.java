package com.innovargia.utils;

import java.util.regex.Pattern;

public class FilterCharacter {
	private static String VACIO = "";// "&#39;";
	public static String filter(String value) {
		
		if (value==null){
			value="";
		}
		// Avoid null characters
		value = value.replaceAll("", "");

		// Avoid anything between script tags
		Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
		value = scriptPattern.matcher(value).replaceAll("");

		scriptPattern = Pattern.compile("<a\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		scriptPattern = Pattern.compile("<A\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid anything in a src='...' type of expression
		scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Remove any lonesome </script> tag
		scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
		value = scriptPattern.matcher(value).replaceAll("");

		// Remove any lonesome <script ...> tag
		scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid eval(...) expressions
		scriptPattern = Pattern.compile("eval\\((.*?)\\)",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid expression(...) expressions
		scriptPattern = Pattern.compile("expression\\((.*?)\\)",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid javascript:... expressions
		scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid vbscript:... expressions
		scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid onload= expressions
		scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid anything between script tags
		scriptPattern = Pattern.compile("<SCRIPT>(.*?)</SCRIPT>", Pattern.CASE_INSENSITIVE);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid anything in a src='...' type of expression
		scriptPattern = Pattern.compile("SRC[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		scriptPattern = Pattern.compile("SRC[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Remove any lonesome </script> tag
		scriptPattern = Pattern.compile("</SCRIPT>", Pattern.CASE_INSENSITIVE);
		value = scriptPattern.matcher(value).replaceAll("");

		// Remove any lonesome <script ...> tag
		scriptPattern = Pattern.compile("<SCRIPT(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid eval(...) expressions
		scriptPattern = Pattern.compile("EVAL\\((.*?)\\)",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid expression(...) expressions
		scriptPattern = Pattern.compile("EXPRESSION\\((.*?)\\)",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid javascript:... expressions
		scriptPattern = Pattern.compile("JAVASCRIPT:", Pattern.CASE_INSENSITIVE);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid vbscript:... expressions
		scriptPattern = Pattern.compile("VBSCRIPT:", Pattern.CASE_INSENSITIVE);
		value = scriptPattern.matcher(value).replaceAll("");

		// Avoid onload= expressions
		scriptPattern = Pattern.compile("ONLOAD(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		value = scriptPattern.matcher(value).replaceAll("");

		// value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("<a", "a ").replaceAll("</a", " /a");
		value = value.replaceAll("<button", "button ").replaceAll("</button", " /button");

		value = value.replaceAll("<", "").replaceAll(">", "");
		value = value.replaceAll("\\(", "").replaceAll("\\)", "");
		value = value.replaceAll("'", "");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");

		value = value.replaceAll("'", VACIO);
		value = value.replaceAll("&lt;", VACIO);
		value = value.replaceAll("&#60;", VACIO);

		value = value.replaceAll("&gt;", VACIO);
		value = value.replaceAll("&#62;", VACIO);

		value = value.replaceAll("&quot;;", VACIO);
		value = value.replaceAll("&#34;", VACIO);

		value = value.replaceAll("&apos;", VACIO);
		value = value.replaceAll("&#39;", VACIO);
		value = value.replaceAll("&#38;", VACIO);

		value = value.replaceAll("&#40;", VACIO);
		value = value.replaceAll("&#41;", VACIO);

		value = value.replaceAll("%3c", VACIO);
		value = value.replaceAll("%3e", VACIO);
		value = value.replaceAll("%27", VACIO);
		value = value.replaceAll("%28", VACIO);
		value = value.replaceAll("%29", VACIO);
		value = value.replaceAll("\"", VACIO);
		value = value.replaceAll("&quot;", VACIO);
		value = value.replaceAll("&#34;", VACIO);
		value = value.replaceAll("%22", VACIO);
		

		return value;
	}

}
