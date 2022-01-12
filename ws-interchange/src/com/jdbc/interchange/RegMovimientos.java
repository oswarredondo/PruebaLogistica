/*
 * RegMovimientos.java
 *
 * Created on 19 de marzo de 2006, 09:27 AM
 */

package com.jdbc.interchange;

import java.sql.SQLException;
import java.util.ArrayList;

import mensajeria.forms.Seguimiento;

import com.debug.utils.ArrayUtilsStr;
import com.debug.utils.DebugLog;
import com.debug.utils.Fechas;

/**
 * Maneja registros como :
 * 21|NumGuia|Ruta|CveLog(Opcional)|Fecha|OriReg|Plaza|NumEmpleado
 * 01|NumGuia|Ruta|CveLog(Opcional)|Fecha|OriReg|Plaza|NumEmpleado
 * 02|NumGuia|Ruta|CveLog(Opcional)|Fecha|OriReg|Plaza|NumEmpleado
 * 03|NumGuia|Ruta|CveLog(Obligato)|Fecha|OriReg|Plaza|NumEmpleado
 * 04|NumGuia|Ruta|CveLog(Obligato)|Fecha|OriReg|Plaza|NumEmpleado
 * R1|NumRecol|Ruta|CveLog(Opcional)|Fecha|OriReg|Plaza|NumEmpleado
 * 
 * @author Meche
 */
public class RegMovimientos implements InterfaceUpdateInser {
    private String db = null;

    public RegMovimientos(String db) {
	this.db = db;
    }

    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje) {
	// DebugLog.debug(this.getClass(), mensaje);
    }// fin de debug

    /** Creates a new instance of Recoleccion */
    public RegMovimientos() {
    }

    public void delete(Object o) throws java.sql.SQLException {
    }// fin de delete

    public void insert(Object o) throws java.sql.SQLException {

    }// fin de insert

    public void update(Object o) throws java.sql.SQLException {
    }// fin de update

    public void utils(Object o) throws java.sql.SQLException {
    }

    public void procesa(String registro, String db)
	    throws java.sql.SQLException {

	try {
	    String[] campos = registro.split("\\|");
	    debug("TIPO REGISTRO:" + campos[0].trim());
	    
	    if (campos[0].trim().equals("01")) {
		     procesa01(registro, db);
		 }else  if (campos[0].trim().equals("02")) {
		     procesa02(registro, db);
		 }else  if (campos[0].trim().equals("03")) {
		     procesa03(registro, db);
		 }else  if (campos[0].trim().equals("04")) {
		     procesa04(registro, db);
		 }else  if (campos[0].trim().equals("21")) {
		     procesa21(registro, db);
		 }else{
		     procesaVarios(registro, db);
		 }

	    

	    

	} catch (Exception e) {
	    debug("Excepction Movimiento:" + e.getMessage());
	    throw new SQLException(e.getMessage()); 
	}
	try {
	    // Inserta el registro en la tabla de caEnvio
	    // Da formato a los datos para los campos signados
	    // IdGuia, NumCliente, IdAdicional, IdGarantia, IdFormato,
	    // IdServicio
	    // Comentario, FechaCreacion, Estado, Referencia, Contenido, Peso,
	    // Login
	    // Se obtiene el numero de cliente.
	    /*
	     * Envio envio = new Envio();
	     * 
	     * // Todos los envios que son agregados en la tabla de caEnvios //
	     * por el servidor deben tener el usuario ServerReg
	     * envio.setIdEnvio(seguimiento.getIdEnvio());
	     * envio.setIdUsuario((seguimiento.getIdEnvio().substring(0, 4)));
	     * envio.setNumClienteRem(seguimiento.getIdEnvio().substring(0, 4));
	     * envio.setAdicional("S"); envio.setGarantia("S");
	     * envio.setFormato("S"); envio.setServicio("S");
	     * envio.setContenido("S"); envio.setLogin("ServerReg");
	     * envio.setEstado(Envio._activo); // envioDao.insert(envio);
	     */

	    // Actualiza los datos del estado del envio
	    // envioDao.updateEstadoRegistro(envio.getIdEnvio(),Envio._con_historia);

	} catch (Exception e) {
	    debug("Excepction :" + e.getMessage());
	    throw new SQLException(e.getMessage()); 
	}

    }// fin de procesa

    public void procesaVarios(String registro, String db)
	    throws java.sql.SQLException {
	Seguimiento seguimiento = new Seguimiento();
	OperacionDB operaciondb = new OperacionDB(db);
	ArrayList<String> arr_envios = new ArrayList<String>();

	try {
	    String[] campos = registro.split("\\|");
	    debug("TIPO REGISTRO:" + campos[0].trim());
	    

	    int index = 0;
	    if (campos[0].trim().equals("15")) {

		// Embarcado COD
		// 15|NumGuia|Ruta|CveLog(Opcional)|Fecha|OriReg|Plaza|Monto|NumEmpleado
		seguimiento.setTipoRegistro(campos[index++]);

		seguimiento.setIdEnvio(campos[index++]); // Guia
		seguimiento.setRuta(campos[index++]);// Ruta
		seguimiento.setClaveExce(campos[index++]);// CveLog
		seguimiento.setFechaEvento(Fechas
			.formateaFecha(campos[index++]));// Fecha
		seguimiento.setOrigenRegistro(campos[index++]);// OriReg
		seguimiento.setSiglas(campos[index++]);// Plaza
		seguimiento.setMonto(campos[index++]);
		seguimiento.setNumEmpleado(campos[index++]);// Empleado

		debug("Agregando registro 15 a BASE DE DATOS");
		operaciondb.insertMovimientoEmbarcadoCOD(seguimiento);

		debug("Agregando registro 15 a BASE DE DATOS");
		operaciondb.insertMovimiento(seguimiento);

	    } else if (campos[0].trim().equals("R1")) {

		seguimiento = new Seguimiento();
		seguimiento.setTipoRegistro(campos[index++]);

		seguimiento.setIdEnvio(campos[index++]); // Num Recoleccion
		seguimiento.setRuta(campos[index++]);// Ruta
		seguimiento.setClaveExce(campos[index++]);// CveLog
		seguimiento.setFechaEvento(Fechas
			.formateaFecha(campos[index++]));// Fecha
		seguimiento.setOrigenRegistro(campos[index++]);// OriReg
		seguimiento.setSiglas(campos[index++]);// Plaza
		seguimiento.setNumEmpleado(campos[index++]);// Empleado

		operaciondb.insertMovimientoRecoleccion(seguimiento);

	    } else {
		
		
		
		seguimiento.setTipoRegistro(campos[index++]);

		seguimiento.setIdEnvio(campos[index++]); // Guia
		if (seguimiento.getIdEnvio().trim().toUpperCase()
			.startsWith(DebugLog.PREFIJO_DELIVERY)) {
		    String[] arr_delivery = seguimiento.getIdEnvio().trim()
			    .toUpperCase()
			    .split(DebugLog.PREFIJO_DELIVERY_SEPARADOR);
		    if (arr_delivery.length > 1) {
			// Busca las guias atadas con el delivery
			arr_envios = operaciondb
				.getListaGuiasCasadas(arr_delivery[1]);
		    }
		}
		// Si no se encontro ninguna guia de sacamiento solo se aplica
		// el movimiento a la
		// guia que esta contenida en el registro
		if (arr_envios.size() <= 0) {
		    arr_envios.add(seguimiento.getIdEnvio());
		}

		seguimiento.setRuta(campos[index++]);// Ruta
		seguimiento.setClaveExce(campos[index++]);// CveLog
		seguimiento.setFechaEvento(Fechas
			.formateaFecha(campos[index++]));// Fecha
		seguimiento.setOrigenRegistro(campos[index++]);// OriReg
		seguimiento.setSiglas(campos[index++]);// Plaza

		// Solo cuando exista el numero de cliente
		//if (campos.length > 7) {
		    seguimiento.setNumEmpleado(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);// Empleado
		//}
		// Solo cuando exista latitud y longitud
		//if (campos.length > 8) {
		    seguimiento.setLongitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		    seguimiento.setLatitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);

		//}

		// Recorre la lista de todas las guias a afectar
		for (String idguia : arr_envios) {
		    seguimiento.setIdEnvio(idguia);
		    // insrta el registro de confirmacion
		    operaciondb.insertMovimiento(seguimiento);
		}
	    }

	} catch (Exception e) {
	    debug("Excepction Movimiento:" + e.getMessage());
	    throw new SQLException(e.getMessage()); 
	}
	

    }
    private void procesa02(String registro, String db)
	    throws java.sql.SQLException {
	//"02|numGuia|ruta|cveLog|fecha|oriReg|plaza|empleado|longitud|latitud|viaje|economico"
	Seguimiento seguimiento = new Seguimiento();
	OperacionDB operaciondb = new OperacionDB(db);
	ArrayList<String> arr_envios = new ArrayList<String>();

	try {
	    String[] campos = registro.split("\\|");
	    debug("TIPO REGISTRO:" + campos[0].trim());

	    int index = 0;
	    seguimiento.setTipoRegistro(campos[index++]);
	    seguimiento.setIdEnvio(campos[index++]); // Guia
	    if (seguimiento.getIdEnvio().trim().toUpperCase()
		    .startsWith(DebugLog.PREFIJO_DELIVERY)) {
		String[] arr_delivery = seguimiento.getIdEnvio().trim()
			.toUpperCase()
			.split(DebugLog.PREFIJO_DELIVERY_SEPARADOR);
		if (arr_delivery.length > 1) {
		    // Busca las guias atadas con el delivery
		    arr_envios = operaciondb
			    .getListaGuiasCasadas(arr_delivery[1]);
		}
	    }
	    // Si no se encontro ninguna guia de sacamiento solo se aplica el
	    // movimiento a la
	    // guia que esta contenida en el registro
	    if (arr_envios.size() <= 0) {
		arr_envios.add(seguimiento.getIdEnvio());
	    }

	    seguimiento.setRuta(campos[index++]);// Ruta
	    seguimiento.setClaveExce(campos[index++]);// CveLog
	    seguimiento.setFechaEvento(Fechas.formateaFecha(campos[index++]));// Fecha
	    seguimiento.setOrigenRegistro(campos[index++]);// OriReg
	    seguimiento.setSiglas(campos[index++]);// Plaza

	    // Solo cuando exista el numero de cliente
	    //if (campos.length > 7) {
		seguimiento.setNumEmpleado(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);// Empleado
		//}
	    // Solo cuando exista latitud y longitud
	    //if (campos.length >= 10) {
		seguimiento.setLongitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setLatitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);

		//}
	  
	    //if (campos.length > 11) {
		seguimiento.setViaje(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setNumeconomico(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setUbicacion(ArrayUtilsStr.getValorArreglo(campos, index++));
	    //}
	    
	    // Recorre la lista de todas las guias a afectar
	    for (String idguia : arr_envios) {
		seguimiento.setIdEnvio(idguia);
		// insrta el registro de confirmacion
		operaciondb.insertMovimiento(seguimiento);
	    }

	} catch (Exception e) {
	    debug("Excepction Movimiento:" + e.getMessage());
	    throw new SQLException(e.getMessage()); 
	}

    }
    
    private void procesa03(String registro, String db)
	    throws java.sql.SQLException {
	// "03|numGuia|ruta|cveLog|fecha|oriReg|plaza|empleado|longitud|latitud|deptodestino"
	Seguimiento seguimiento = new Seguimiento();
	OperacionDB operaciondb = new OperacionDB(db);
	ArrayList<String> arr_envios = new ArrayList<String>();

	try {
	    String[] campos = registro.split("\\|");
	    debug("TIPO REGISTRO:" + campos[0].trim());

	    int index =0;
	    seguimiento.setTipoRegistro(campos[index++]);
	    seguimiento.setIdEnvio(campos[index++]); // Guia
	    if (seguimiento.getIdEnvio().trim().toUpperCase()
		    .startsWith(DebugLog.PREFIJO_DELIVERY)) {
		String[] arr_delivery = seguimiento.getIdEnvio().trim()
			.toUpperCase()
			.split(DebugLog.PREFIJO_DELIVERY_SEPARADOR);
		if (arr_delivery.length > 1) {
		    // Busca las guias atadas con el delivery
		    arr_envios = operaciondb
			    .getListaGuiasCasadas(arr_delivery[1]);
		}
	    }
	    // Si no se encontro ninguna guia de sacamiento solo se aplica el
	    // movimiento a la
	    // guia que esta contenida en el registro
	    if (arr_envios.size() <= 0) {
		arr_envios.add(seguimiento.getIdEnvio());
	    }

	    seguimiento.setRuta(campos[index++]);// Ruta
	    seguimiento.setClaveExce(campos[index++]);// CveLog
	    seguimiento.setFechaEvento(Fechas.formateaFecha(campos[index++]));// Fecha
	    seguimiento.setOrigenRegistro(campos[index++]);// OriReg
	    seguimiento.setSiglas(campos[index++]);// Plaza

	    // Solo cuando exista el numero de cliente
	   // if (campos.length > 7) {
		seguimiento.setNumEmpleado(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);// Empleado
	   // }
	    // Solo cuando exista latitud y longitud
	  //  if (campos.length >=10) {
		seguimiento.setLongitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setLatitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);

	    //}
	    //if (campos.length >=11) {
		seguimiento.setViaje(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setUbicacion(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
	    //}
	    
	    // Recorre la lista de todas las guias a afectar
	    for (String idguia : arr_envios) {
		seguimiento.setIdEnvio(idguia);
		// insrta el registro de confirmacion
		operaciondb.insertMovimiento(seguimiento);
	    }

	} catch (Exception e) {
	    debug("Excepction Movimiento:" + e.getMessage());
	    throw new SQLException(e.getMessage()); 
	}

    }

    private void procesa04(String registro, String db)
	    throws java.sql.SQLException {
	// "04|numGuia|ruta|cveLog|fecha|oriReg|plaza|empleado|longitud|latitud"
	Seguimiento seguimiento = new Seguimiento();
	OperacionDB operaciondb = new OperacionDB(db);
	ArrayList<String> arr_envios = new ArrayList<String>();

	try {
	    String[] campos = registro.split("\\|");
	    debug("TIPO REGISTRO:" + campos[0].trim());

	    int index = 0;
	    seguimiento.setTipoRegistro(campos[index++]);
	    seguimiento.setIdEnvio(campos[index++]); // Guia
	    if (seguimiento.getIdEnvio().trim().toUpperCase()
		    .startsWith(DebugLog.PREFIJO_DELIVERY)) {
		String[] arr_delivery = seguimiento.getIdEnvio().trim()
			.toUpperCase()
			.split(DebugLog.PREFIJO_DELIVERY_SEPARADOR);
		if (arr_delivery.length > 1) {
		    // Busca las guias atadas con el delivery
		    arr_envios = operaciondb
			    .getListaGuiasCasadas(arr_delivery[1]);
		}
	    }
	    // Si no se encontro ninguna guia de sacamiento solo se aplica el
	    // movimiento a la
	    // guia que esta contenida en el registro
	    if (arr_envios.size() <= 0) {
		arr_envios.add(seguimiento.getIdEnvio());
	    }

	    seguimiento.setRuta(campos[index++]);// Ruta
	    seguimiento.setClaveExce(campos[index++]);// CveLog
	    seguimiento.setFechaEvento(Fechas.formateaFecha(campos[index++]));// Fecha
	    seguimiento.setOrigenRegistro(campos[index++]);// OriReg
	    seguimiento.setSiglas(campos[index++]);// Plaza

	    // Solo cuando exista el numero de cliente
	    //if (campos.length > 7) {
		seguimiento.setNumEmpleado(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);// Empleado
	    //}
	    // Solo cuando exista latitud y longitud
	    //if (campos.length > 8) {
		seguimiento.setLongitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setLatitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);

	    //}

	    // Recorre la lista de todas las guias a afectar
	    for (String idguia : arr_envios) {
		seguimiento.setIdEnvio(idguia);
		// insrta el registro de confirmacion
		operaciondb.insertMovimiento(seguimiento);
	    }

	} catch (Exception e) {
	    debug("Excepction Movimiento:" + e.getMessage());
	    throw new SQLException(e.getMessage()); 
	}

    }

    private void procesa01(String registro, String db)
	    throws java.sql.SQLException {
	Seguimiento seguimiento = new Seguimiento();
	OperacionDB operaciondb = new OperacionDB(db);
	ArrayList<String> arr_envios = new ArrayList<String>();

	try {
	    String[] campos = registro.split("\\|");
	    debug("TIPO REGISTRO:" + campos[0].trim());

	    int index = 0;
	    seguimiento.setTipoRegistro(campos[index++]);
	    seguimiento.setIdEnvio(campos[index++]); // Guia
	    if (seguimiento.getIdEnvio().trim().toUpperCase()
		    .startsWith(DebugLog.PREFIJO_DELIVERY)) {
		String[] arr_delivery = seguimiento.getIdEnvio().trim()
			.toUpperCase()
			.split(DebugLog.PREFIJO_DELIVERY_SEPARADOR);
		if (arr_delivery.length > 1) {
		    // Busca las guias atadas con el delivery
		    arr_envios = operaciondb
			    .getListaGuiasCasadas(arr_delivery[1]);
		}
	    }
	    // Si no se encontro ninguna guia de sacamiento solo se aplica el
	    // movimiento a la
	    // guia que esta contenida en el registro
	    if (arr_envios.size() <= 0) {
		arr_envios.add(seguimiento.getIdEnvio());
	    }

	    //01|numGuia|ruta|cveLog|fecha|oriReg|plaza|empleado|longitud|latitud|viaje|economico|operador|cincho
	    seguimiento.setRuta(campos[index++]);// Ruta
	    seguimiento.setClaveExce(campos[index++]);// CveLog
	    seguimiento.setFechaEvento(Fechas.formateaFecha(campos[index++]));// Fecha
	    seguimiento.setOrigenRegistro(campos[index++]);// OriReg
	    seguimiento.setSiglas(campos[index++]);// Plaza

	    // Solo cuando exista el numero de cliente
	   // if (campos.length > 7) {
		seguimiento.setNumEmpleado(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);// Empleado
	   // }
	    // Solo cuando exista latitud y longitud
	   // if (campos.length > 8) {
		seguimiento.setLongitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setLatitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);

	   // }

	//    if (campos.length >13) {
		seguimiento.setViaje(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setNumeconomico(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setOperador1(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setCincho(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setUbicacion(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);

	  //  }
	    // Recorre la lista de todas las guias a afectar
	    for (String idguia : arr_envios) {
		seguimiento.setIdEnvio(idguia);
		// insrta el registro de confirmacion
		operaciondb.insertMovimiento(seguimiento);
	    }

	} catch (Exception e) {
	    debug("Excepction Movimiento:" + e.getMessage());
	    throw new SQLException(e.getMessage()); 
	}
    }

    private void procesa21(String registro, String db)
	    throws java.sql.SQLException {
	Seguimiento seguimiento = new Seguimiento();
	OperacionDB operaciondb = new OperacionDB(db);
	ArrayList<String> arr_envios = new ArrayList<String>();

	try {
	    String[] campos = registro.split("\\|");
	    debug("TIPO REGISTRO:" + campos[0].trim());

	    int index = 0;
	    seguimiento.setTipoRegistro(campos[index++]);
	    seguimiento.setIdEnvio(campos[index++]); // Guia
	    if (seguimiento.getIdEnvio().trim().toUpperCase()
		    .startsWith(DebugLog.PREFIJO_DELIVERY)) {
		String[] arr_delivery = seguimiento.getIdEnvio().trim()
			.toUpperCase()
			.split(DebugLog.PREFIJO_DELIVERY_SEPARADOR);
		if (arr_delivery.length > 1) {
		    // Busca las guias atadas con el delivery
		    arr_envios = operaciondb
			    .getListaGuiasCasadas(arr_delivery[1]);
		}
	    }
	    // Si no se encontro ninguna guia de sacamiento solo se aplica el
	    // movimiento a la
	    // guia que esta contenida en el registro
	    if (arr_envios.size() <= 0) {
		arr_envios.add(seguimiento.getIdEnvio());
	    }

	    seguimiento.setRuta(campos[index++]);// Ruta
	    seguimiento.setClaveExce(campos[index++]);// CveLog
	    seguimiento.setFechaEvento(Fechas.formateaFecha(campos[index++]));// Fecha
	    seguimiento.setOrigenRegistro(campos[index++]);// OriReg
	    seguimiento.setSiglas(campos[index++]);// Plaza

	    // Solo cuando exista el numero de cliente
	   // if (campos.length > 7) {
		seguimiento.setNumEmpleado(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);// Empleado
	    //}
	    // Solo cuando exista latitud y longitud
	    //if (campos.length > 8) {
		seguimiento.setLongitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);
		seguimiento.setLatitud(ArrayUtilsStr.getValorArreglo(campos, index++));//campos[index++]);

	    //}

	    // Recorre la lista de todas las guias a afectar
	    for (String idguia : arr_envios) {
		seguimiento.setIdEnvio(idguia);
		// insrta el registro de confirmacion
		operaciondb.insertMovimiento(seguimiento);
	    }

	} catch (Exception e) {
	    debug("Excepction Movimiento:" + e.getMessage());
	    throw new SQLException(e.getMessage()); 
	}
    }

}// fin de RecoleccionDao
