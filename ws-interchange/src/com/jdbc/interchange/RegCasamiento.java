/**
 * 
 */
package com.jdbc.interchange;

import mensajeria.forms.Seguimiento;

import java.sql.SQLException;

import mensajeria.forms.EntregaForm;

import com.debug.utils.DebugLog;
import com.debug.utils.Fechas;

/**
 * @author Adrian Morales Ruaro
 * 
 */
public class RegCasamiento implements InterfaceUpdateInser {
	private String db = null;

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug

	/**
	 * 
	 */
	public RegCasamiento(String db) {
		this.db = db;
	}

	public RegCasamiento() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jdbc.interchange.InterfaceUpdateInser#insert(java.lang.Object)
	 */
	public void insert(Object o) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jdbc.interchange.InterfaceUpdateInser#update(java.lang.Object)
	 */

	public void update(Object o) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jdbc.interchange.InterfaceUpdateInser#delete(java.lang.Object)
	 */

	public void delete(Object o) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jdbc.interchange.InterfaceUpdateInser#utils(java.lang.Object)
	 */

	public void utils(Object o) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jdbc.interchange.InterfaceUpdateInser#procesa(java.lang.String)
	 */

	public void procesa(String registro, String db) throws SQLException {
		String[] campos = registro.split("\\|");
		Seguimiento seguimiento = new Seguimiento();

		// Arreglo para cambiar el orden de los datos
		OperacionDB confDao = new OperacionDB(db);
		// debug("BASE DE DATOS:" + db);

		// Arreglo para cambiar el orden de los datos
		for (int y = 0; y < campos.length; y++) {
			// debug("Campo " + y +" valor:"+campos[y] );
		}

		try {
			//09|NumGuia|Ruta|guiacasamiento|Fecha|OriReg|Plaza|Empleado
			int index=0;
			//Inserta el registo en casamiento
			seguimiento.setTipoRegistro(campos[index++]);
			seguimiento.setIdEnvio(campos[index++]);
			seguimiento.setRuta(campos[index++]);
			seguimiento.setIdCasamiento(campos[index++]);
			seguimiento.setFechaEvento(Fechas.formateaFecha(campos[index++]));
			seguimiento.setOrigenRegistro(campos[index++]);
			seguimiento.setSiglas(campos[index++]);
			seguimiento.setIdCarrier(null);

			if (campos.length>7){
				seguimiento.setNumEmpleado(campos[index++]);//Empleado
			}
			
			confDao.insertCasamiento(seguimiento);

			// Se agrega la clave de excepcion para agregar un registro de
			// movimiento
			seguimiento.setClaveExce("Z00");
			//seguimiento.setRuta("");
			confDao.insertMovimiento(seguimiento);

		} catch (Exception e) {
			debug("Excepcion " + e.getMessage());
			throw new SQLException(e.getMessage()); 
		}

	}

}
