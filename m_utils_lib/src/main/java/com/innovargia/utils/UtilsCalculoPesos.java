package com.innovargia.utils;

public class UtilsCalculoPesos {
	/**
	 * Genera le peso volumetrico
	 * 
	 * @param alto
	 * @param largo
	 * @param ancho
	 * @return
	 */
	public static float pesoVolumetrico(float alto, float largo, float ancho) {
		float numerador = (alto * largo * ancho);
		if (numerador == 0) {
			return 0;
		}
		return (numerador / 6000);
	}

	
	public static float volumen(float alto, float largo, float ancho) {
		return alto * largo * ancho;
	}
	
	public static float pesoVolumetrico(float alto, float largo, float ancho, int demoninador) {
		float numerador = (alto * largo * ancho);
		if ((numerador == 0) || (demoninador == 0)) {
			return 0;
		}
		return (numerador / demoninador);
	}

	public static float porcentaje(int total, int cantidad) {
		return (cantidad * 100 / total);
	}

	public static float porcentaje(int total, float cantidad) {
		return (cantidad * 100 / total);
	}
}
