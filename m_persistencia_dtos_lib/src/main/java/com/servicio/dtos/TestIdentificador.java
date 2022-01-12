/**
 * 
 */
package com.servicio.dtos;

/**
 * @author Adrian Morales Ruaro
 * 
 */
public class TestIdentificador implements java.io.Serializable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentoDTO dto = new DocumentoDTO();
		String id = null;
		for (int i = 0; i < 20; i++) {
			id = dto.creaIdentificador();
			System.out.println("ID: " + id);
		}
	}
}
