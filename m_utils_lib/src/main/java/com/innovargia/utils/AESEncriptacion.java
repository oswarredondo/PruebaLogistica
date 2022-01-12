package com.innovargia.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;

//https://www.quickprogrammingtips.com/java/how-to-encrypt-and-decrypt-data-in-java-using-aes-algorithm.html
public class AESEncriptacion {
	
	private static final String _KEY = "N/wtRSEGcgMsRNU7nXf4dQ==";
	/**
	 * 1. Generate a plain text for encryption 2. Get a secret key (printed in
	 * hexadecimal form). In actual use this must by encrypted and kept safe.
	 * The same key is required for decryption. 3.
	 */
	public static void main(String[] args) throws Exception {

		try {
			String plainText = "ADMIN2018#a";
			System.out.println("Password:" + "M8ex2i1c8o$0" + ",ENCRIPTADO:" + encryptText("M8ex2i1c8o$0")) ;
			
			System.out.println("Original:" + "ADMIN2018#a" + ",ENCRIPTADO:" + encryptText("ADMIN2018#a")) ;
			System.out.println("Original:" + "ADMSALES2018#a" + ",ENCRIPTADO:" + encryptText("ADMSALES2018#a")) ;
			System.out.println("Original:" + "ENTADS2018#a" + ",ENCRIPTADO:" + encryptText("ENTADS2018#a")) ;
			/*System.out.println("Original:" + "ADMIN2018#a" + ",ENCRIPTADO:" + encryptText("ADMIN2018#a")) ;
			System.out.println("Original:" + "ADMIN2018#a" + ",ENCRIPTADO:" + encryptText("ADMIN2018#a")) ;
			System.out.println("Original:" + "ADMIN2018#a" + ",ENCRIPTADO:" + encryptText("ADMIN2018#a")) ;*/
			//Encript la cadena
			/*System.out.println("Original:" + plainText);
			String cad = encryptText(plainText);
			System.out.println("Encriptdada:" + cad);
			cad = decryptText(cad);
			System.out.println("Desencriptada:" + cad);*/

		} catch (Exception e) {
			System.out.println("Error al serializar el mensaje:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	

	/**
	 * gets the AES encryption key. In your actual programs, this should be
	 * safely stored.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static SecretKey getSecretEncryptionKey() throws Exception {
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		generator.init(128); // The AES key size in number of bits
		SecretKey secKey = generator.generateKey();
		return secKey;
	}

	/**
	 * Encrypts plainText in AES using the secret key
	 * 
	 * @param plainText
	 * @param secKey
	 * @return
	 * @throws Exception
	 */
	private static byte[] encryptText(String plainText, SecretKey secKey) throws Exception {
		// AES defaults to AES/ECB/PKCS5Padding in Java 7
		Cipher aesCipher = Cipher.getInstance("AES");
		aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
		byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
		return byteCipherText;
	}
	
	public static String encryptText(String plainText){
		
		byte[] encodedKey  = Base64.decodeBase64(_KEY);
		SecretKey originalKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		byte[] cipherText;
		try {
			cipherText = encryptText(plainText, originalKey);
			return   bytesToHex(cipherText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static String decryptText(String plainText){
		
		byte [] decoded = hexaToBytes(plainText) ;
		
		byte[] encodedKey  = Base64.decodeBase64(_KEY);
		SecretKey originalKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		
		String decryptedText=null;
		try {
			decryptedText = decryptText(decoded, originalKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return decryptedText;
		
	
		
	}
	
	

	/**
	 * Decrypts encrypted byte array using the key used for encryption.
	 * 
	 * @param byteCipherText
	 * @param secKey
	 * @return
	 * @throws Exception
	 */
	private static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {
		// AES defaults to AES/ECB/PKCS5Padding in Java 7
		Cipher aesCipher = Cipher.getInstance("AES");
		aesCipher.init(Cipher.DECRYPT_MODE, secKey);
		byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
		return new String(bytePlainText);
	}

	/**
	 * Convert a binary byte array into readable hex form
	 * 
	 * @param hash
	 * @return
	 */
	private static String bytesToHex(byte[] hash) {
		
		return DatatypeConverter.printHexBinary(hash);
	}
	
	private static byte[] hexaToBytes(String cadena){
		return DatatypeConverter.parseHexBinary(cadena);
	}
}
