/*
 * RegSobrePeso.java
 *
 * Created on 19 de marzo de 2006, 09:27 AM
 */

package com.jdbc.interchange;

import java.sql.SQLException;

import mensajeria.forms.Seguimiento;

import com.debug.utils.DebugLog;
import com.debug.utils.Fechas;

/**
 * 
 * @author Meche
 */
public class RegSobrePeso implements InterfaceUpdateInser {

	/** Creates a new instance of Recoleccion */
	public RegSobrePeso() {
	}

	public void delete(Object o) throws java.sql.SQLException {
	}// fin de delete

	public void insert(Object o) throws java.sql.SQLException {

	}// fin de insert

	public void update(Object o) throws java.sql.SQLException {
	}// fin de update

	public void utils(Object o) throws java.sql.SQLException {
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug

	public void procesa(String registro,String db) throws java.sql.SQLException {
		
		Seguimiento seguimiento = new Seguimiento();
		OperacionDB operaciondb = new OperacionDB(db);
		

		String[] campos = registro.split("\\|");
		
		// Arreglo para cambiar el orden de los datos
		for (int y = 0; y < campos.length; y++) {
			 //debug("Campo " + y +" valor:"+campos[y] );
		}
 

		// Obtiene los datos de peso vol y real
		int index =0;
	try{
		//08|NumGuia|Fecha|OriReg|Plaza|PesoKG|Largo|Ancho|Alto|Empleado
		if ((campos[0].trim().equals("8")) || (campos[0].trim().equals("08"))) {
			seguimiento.setTipoRegistro(campos[index++]);
			seguimiento.setIdEnvio(campos[index++]);
			seguimiento.setFechaEvento(Fechas.formateaFecha(campos[index++]));
			
			seguimiento.setOrigenRegistro(campos[index++]);
			seguimiento.setSiglas(campos[index++]);
			seguimiento.setPesoKG(campos[index++]);
			seguimiento.setLargo(campos[index++]);
			seguimiento.setAncho(campos[index++]);
			seguimiento.setAlto(campos[index++]);
			seguimiento.setNumEmpleado(campos[index++]);   

			// ///////////////////////////////03-12-2008
			// Inserta el registro de sobre peso
			operaciondb.insertSobrePeso(seguimiento);
		}

		//Registros de peso bascula
		//81|Numguia|fechalarga|lugarEscaneo|plaza|pesoKG|pesoVOL		
		//if (campos[0].trim().equals("81")){
		//	insertUpdatePesoBascula(campos);
		//}

		
	} catch (Exception e) {
		debug("Excepction RegECOPSCOP :" + e.getMessage());
	    throw new SQLException(e.getMessage());
	}
		
	}// fin de procesa

	
}// fin de RecoleccionDao
