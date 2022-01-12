package com.innovargia.ws.tracking.rest.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class CheckSumUtility {

	public static String  SHA1 = "SHA1";
	public static String  MD5 = "MD5";
	

	/***
	 * Crea un identificador utilizando CRC32 para obtener un numero �nico de
	 * acuerdo a la sesi�n del usuario y la fecha en que esta realizando la
	 * acci�n, se envia la cadena y se le aplica el algoritmo de CRC32
	 * 
	 * @return consecutivo en cadena
	 * @param s
	 * @return
	 */
	public static String getCheckSumLineaCRC32 (String s) { 
		Checksum cs = new CRC32();
		byte[] str_bytes = s.getBytes();

		for (int bb = 0; bb < str_bytes.length; bb++) {
			cs.update(str_bytes[bb]);
		}

		return cs.getValue() + "";
	}

	public static long getChecksumValue(Checksum checksum, String fname) {
		try {
			BufferedInputStream is = new BufferedInputStream(
					new FileInputStream(fname));
			byte[] bytes = new byte[1024];
			int len = 0;

			while ((len = is.read(bytes)) >= 0) {
				checksum.update(bytes, 0, len);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return checksum.getValue();
	}

	/**
	 * 
	 * @param filename
	 * @param messageDigest: SHA1,MD5
	 * @return
	 * @throws Exception
	 */
	public static byte[] createChecksum(String filename,String messageDigest) throws Exception {
		InputStream fis = new FileInputStream(filename);

		byte[] buffer = new byte[1024];
		MessageDigest complete = MessageDigest.getInstance(messageDigest);
		int numRead;
		do {
			numRead = fis.read(buffer);
			if (numRead > 0) {
				complete.update(buffer, 0, numRead);
			}
		} while (numRead != -1);
		fis.close();
		return complete.digest();
	}
	

	/***
	 * Encripta el password
	 * @param linea
	 * @return
	 * @throws Exception
	 */
	 public static String encryptaPassWord(String linea) throws Exception{
		 String  chksum =  getCheckSumLineaCRC32(linea);
		 String password = linea+chksum;
		// System.out.println(password);
		 try {
			//  System.out.println("MD5:" + getChecksumString(password,MD5));
			//  System.out.println("SHA1:" + getChecksumString(password,SHA1));
			 return getChecksumString(getChecksumString(password,MD5),SHA1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
		 
	 }
	 
	/**
	 * Obtiene el checkSum para la linea indicada
	 * @param linea
	 * @param messageDigest SHA1,MD5
	 * @return
	 * @throws Exception
	 */
	public static String getChecksumString(String linea,String messageDigest) throws Exception {
		// Convierte la linea String a InputStream
		InputStream is = new ByteArrayInputStream(linea.getBytes());
	 
		byte[] buffer = new byte[1024];
		MessageDigest complete = MessageDigest.getInstance(messageDigest);
		int numRead;
		do {
			numRead = is.read(buffer);
			if (numRead > 0) {
				complete.update(buffer, 0, numRead);
			}
		} while (numRead != -1);
		is.close();
		byte[] b =complete.digest();
		return getChekSumResult(b);
	}
	/**
	 * Obtiene el checksum con el metodo SHA1 para un archivo 
	 * @param filename
	 * @param messageDigest SHA1,MD5
	 * @return
	 * @throws Exception
	 */
	public static String getChecksumFile(String filename,String messageDigest) throws Exception {
		byte[] b = createChecksum(filename,messageDigest);
		return getChekSumResult(b);
	}
	/**
	 * Devuelve la cadena correspondiente al checksum
	 * @param b
	 * @return
	 */
	private static String getChekSumResult( byte[] b ){
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}
	


	public static void main(String args[]) {
		try {
			System.out
					.println(getChecksumFile("c:/temp/isapi_redirect-1.2.30.dll","SHA1"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (args.length != 1) {
			System.err.println("Usage: java ComputeCRC32 <file>");
			System.exit(1);
		}
		long cs = getChecksumValue(new CRC32(), args[0]);
		System.out.println("crc32 " + args[0] + " : " + cs);

	
	}
	
	/////////// UTILITARIAS /////
	public int create(String filename, String method){
	     try {
	        byte[] chk = createChecksum(filename,method);
	        File f = new File(filename + ".chk");
	        OutputStream os = new FileOutputStream(f);
	        os.write(chk);
	        os.close();
	        return 1;
	     }
	     catch(Exception e) {
	        e.printStackTrace();
	        return 0;
	     }
	  }
}
