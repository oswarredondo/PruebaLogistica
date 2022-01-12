package com.innovargia.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;

public class PasswordValidator {

	private static PasswordValidator INSTANCE = new PasswordValidator();
	private static String pattern = null;
	public static boolean ForceSpecialChar=true;
	public static boolean ForceCapitalLetter=true;
	public static boolean ForceLowerLetter=true;
	public static boolean ForceNumber=true;
	public static int MinLength=7;
	public static int MaxLength=20;
	
	public static String MENSAJE_ERROR ="Password  no cumple con las politicas de seguridad(Debe tener"
			+ " al menos 7 caracteres y maximo 10, debe tener al menos una letra de "
			+ "la a-z, una letra de A-Z , un numero 0-9 y un caracter especial @#$%";
	
	/**
	 * No one can make a direct instance
	 */
	private PasswordValidator() {
	}

	/**
	 * Force the user to build a validator using this way only
	 */
	public static PasswordValidator buildValidator(boolean forceSpecialChar, 
			boolean forceCapitalLetter,boolean forceLowerLetter,
			boolean forceNumber, int minLength, int maxLength) {
		StringBuilder patternBuilder = new StringBuilder("((?=.*[a-z])");

		if (forceSpecialChar) {
			patternBuilder.append("(?=.*[@#$%])");
		}

		if (forceCapitalLetter) {
			patternBuilder.append("(?=.*[A-Z])");
		}
		
		if (forceLowerLetter) {
			patternBuilder.append("(?=.*[a-z])");
		}

		if (forceNumber) {
			patternBuilder.append("(?=.*d)");
		}

		patternBuilder.append(".{" + minLength + "," + maxLength + "})");
		pattern = patternBuilder.toString();

		return INSTANCE;
	}

	/**
	 * Here we will validate the password
	 */
	public  boolean validatePassword(final String password) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(password);
		return m.matches();
	}

	public  String cifrarBase64(String a) {
		Base64 base64 = new Base64();
		String encodedVersion = new String(base64.encode(a.getBytes()));
		return encodedVersion;
	}

	public  String descifrarBase64(String a) {
		byte[] decoded = Base64.decodeBase64(a);
		try {
			String b = new String(decoded, "UTF-8") ;
			return b;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
