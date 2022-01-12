/*
 * RegMovimientos.java
 *
 * Created on 19 de marzo de 2006, 09:27 AM
 */

package com.jdbc.interchange;

import java.sql.SQLException;

import mensajeria.forms.Seguimiento;

import com.debug.utils.DebugLog;
import com.debug.utils.Fechas;

/**
 * Maneja registros como :
 * 31|NumVehiculo|NumCon1(Opcional)|NumCon2(Opcional)|NumOpe1(Opcional)|NumOpe2(Opcional)|NumCartaP(Opcional)| NumManifiesto(Opcional)|CveLog(Opcional)|Fecha|OriReg|Plaza|NumEmpleado
 * 32|NumVehiculo|NumCon1(Opcional)|NumCon2(Opcional)|NumOpe1(Opcional)|NumOpe2(Opcional)|NumCartaP(Opcional)| NumManifiesto(Opcional)|CveLog(Opcional)|Fecha|OriReg|Plaza|NumEmpleado
 * 
 * @author Meche
 */
public class RegECOPSCOP implements InterfaceUpdateInser {
	private String db = null;

	public RegECOPSCOP(String db) {
		this.db = db;
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug

	/** Creates a new instance of Recoleccion */
	public RegECOPSCOP() {
	}

	public void delete(Object o) throws java.sql.SQLException {
	}// fin de delete

	public void insert(Object o) throws java.sql.SQLException {

	}// fin de insert

	public void update(Object o) throws java.sql.SQLException {
	}// fin de update

	public void utils(Object o) throws java.sql.SQLException {
	}

	public void procesa(String registro,String db) throws java.sql.SQLException {

		Seguimiento seguimiento = new Seguimiento();
		OperacionDB operaciondb = new OperacionDB(db);
		//debug("BASE DE DATOS:" + db);
		try {
			String[] campos = registro.split("\\|");

			// Estructura del archivo
			
			int index=0;
			//31|manifiesto|vehiculo|CveLog|contenedor1|contenedor2|operador1|operador2|cartaporte|Fecha|OriReg|Plaza|Empleado

			seguimiento.setTipoRegistro(campos[index++]);
			seguimiento.setManifiesto(campos[index++]);
			seguimiento.setVehiculo(campos[index++]);
			seguimiento.setClaveExce(campos[index++]);//CveLog
			seguimiento.setContenedor1(campos[index++]);
			seguimiento.setContenedor2(campos[index++]);
			seguimiento.setOperador1(campos[index++]);
			seguimiento.setOperador2(campos[index++]);
			seguimiento.setCartaporte(campos[index++]);
			seguimiento.setFechaEvento(Fechas.formateaFecha(campos[index++]));//Fecha
			seguimiento.setOrigenRegistro(campos[index++]);//OriReg
			seguimiento.setSiglas(campos[index++]);//Plaza
			seguimiento.setNumEmpleado(campos[index++]);

			
			operaciondb.insertMovimientoECOPSCOP(seguimiento);

		} catch (Exception e) {
			debug("Excepction RegECOPSCOP :" + e.getMessage());
			throw new SQLException(e.getMessage()); 
		}
	

	}// fin de procesa

}// fin de RecoleccionDao
