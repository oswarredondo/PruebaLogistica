package com.innovargia.utils;

import java.util.ArrayList;

public class TestMainEncripta {

	public TestMainEncripta() {
		// TODO Auto-generated constructor stub
	}

	static ArrayList<String> lista_passwords =new ArrayList<String>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		lista_passwords.add( "DEVOL2014");//Devoluciones
		lista_passwords.add( "EKEKTRA201");//ELEKTRA2013
		lista_passwords.add( "SELECSA");//SELECSA
		String password = "";
		for (int i = 0; i < lista_passwords.size(); i++) {
			password = CheckSumUtility.encryptaPassWord(lista_passwords.get(i));
			System.out.println("Pass-->  " + lista_passwords.get(i) + ", Encriptada-->  " + password);
		}

	}

}
