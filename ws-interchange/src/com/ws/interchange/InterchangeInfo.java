package com.ws.interchange;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jws.WebService;

import mensajeria.forms.RegistroInfo;
import mx.ws.interchange.RegistrosLogs;

import com.debug.utils.Constantes;
import com.debug.utils.DebugLog;
import com.debug.utils.Fechas;
import com.jdbc.interchange.InterfaceUpdateInser;
import com.jdbc.interchange.RegistrosCampos;
import com.jdbc.interchange.UsuariosDao;
import com.ws.interchange.client.ReplicaInformacionAWS;

@WebService(targetNamespace = "http://interchange.ws.com/", endpointInterface = "com.ws.interchange.InterchangeSEI", portName = "InterchangeInfoPort", serviceName = "InterchangeInfoService")
public class InterchangeInfo implements InterchangeSEI {
	private static HashMap map_Registros_Info = new HashMap();
	private String db = null;
	

	/**
	 * Limpia los datos existentes en de registros de intercambio para que
	 * vuelva a tomar los datos de la base de datos
	 */
	public void clearRegistroInfo() {
		map_Registros_Info.clear();
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug
	/**
	 * Ejecuta la clase a la que esta asociado el registro para poder procesar
	 * la información y realizar insert o update
	 * 
	 * @param classPath
	 *            paquetey nombre de la clase que se va a ejecutar e.i
	 *            mensajeria.ws.RegConfirmacion
	 * @param registro
	 *            que contiene la información a procesar e.i
	 *            1|8888010B0002613|MPL0CE5||200502191512|CEX01|MEX
	 */
	public boolean executeProcesa(String classPath, String registro,String[] configuracion,boolean isReplicacion) {
		Class clase;
		Object objeto;
		Method metodo;
		String resultado;
		Class[] clasesParam;
		Object[] param;
		
		boolean isCorrecto=false;
		try {
			// debug("classPath->" + classPath);
			// Cargamos la clase
			clase = Class.forName(classPath);

			// Instanciamos un objeto de la clase
			// try {
			objeto = clase.newInstance();

			// try {
			// Configura los datos
			clasesParam = new Class[2];

			clasesParam[0] = Class.forName("java.lang.String");
			clasesParam[1] = Class.forName("java.lang.String");
			metodo = clase.getMethod("procesa", clasesParam);
			param = new Object[2];
			param[0] = registro;
			param[1] = this.db;
			metodo.invoke(objeto, param);

			// Respalda el registro una vez que ha sido procesado
			//Se indica que no se ha transmitido la replica para indicar que el proceso
			//Automatico solo tomes los que no se han transmitido y con estatus 0
			estatusRegistroInsertado(registro, configuracion, isReplicacion,"SUCCESS","SUCCESS");
			isCorrecto=true;
			

		} catch (NoSuchMethodException e) {
			debug("Error al acceder al metodo. " + e);
			estatusRegistroInsertado(registro, configuracion, true,e.getMessage(), "NoSuchMethodException");
		} catch (SecurityException e) {
			debug("Error al acceder al metodo. " + e);
			estatusRegistroInsertado(registro, configuracion, true,e.getMessage(),"SecurityException");
		} catch (InvocationTargetException e) {
			debug("Error al ejecutar el metodo. " + e);
			estatusRegistroInsertado(registro, configuracion, true,e.getTargetException().getMessage(),"DATABASE");//"InvocationTargetException");
			// }
		} catch (InstantiationException e) {
			debug("Error al instanciar el objeto. " + e);
			// Respalda el registro una vez que ha sido procesado
			estatusRegistroInsertado(registro, configuracion, true,e.getMessage(),"InstantiationException");
		} catch (IllegalAccessException e) {
			debug("Error al instanciar el objeto. " + e);
			estatusRegistroInsertado(registro, configuracion, true,e.getMessage(),"IllegalAccessException");
			// }
		} catch (ClassNotFoundException e) {
			debug("No se ha encontrado la clase. " + e);
			estatusRegistroInsertado(registro, configuracion, true,e.getMessage(),"ClassNotFoundException");
		}

		return isCorrecto;
	}
 
	/***
	 * Respalda la informacion con el registro que se esta procesando, si el registro es 
	 * insertado correctamente se marca como procesado, en caso contrario lo 
	 * marca como no procesado
	 * @param registro
	 * @param configuracion
	 * @param estatus
	 */
	private void estatusRegistroInsertado(String registro,String[] configuracion, boolean estatus,String msgstatus,String tipoerror){
	    	msgstatus = msgstatus == null ? "":msgstatus;
	    	
	    	debug("msgstatus-->" + msgstatus);
	    	String[] arr_str = msgstatus.split("\\|");
	    	if (arr_str.length>1){
	            tipoerror = arr_str[0]; 
	            msgstatus =arr_str[1];
	            if (msgstatus.trim().length()>250){
	        	msgstatus= msgstatus.trim().substring(0,250);
	            }
	    	}
	    	debug("tipoerror-->" + tipoerror);
	    	debug("msgstatus-->" + msgstatus);  
	    	
		RegistrosCampos registrosDao = new RegistrosCampos(configuracion[4]);
		registrosDao.insertRegistroEstatus(registro, configuracion, estatus,msgstatus,tipoerror);
	}
	
	public boolean isCorrectServer(String servidorcliente) {
		// System.out.println("isCorrectServer");
		/*
		 * UsuarioDao dao =new UsuarioDao(); try { dao.getUsuario("PRUEBA",
		 * "MELIMAR1"); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
		// TODO Auto-generated method stub
		return true; // registros.isCorrectServer(servidorcliente);
	}

	public String[] procesaPlaza(String[] configuracion, String nomarchivo,
			String siglasplaza) {
		// TODO Auto-generated method stub
	    	String[] tablas = new String[1];
	    	tablas[0] = nomarchivo;
		return downloadInfo(configuracion, tablas);
	}

	/* (non-Javadoc)
	 * @see com.ws.interchange.InterchangeSEI#procesa(java.lang.String[], java.lang.String[])
	 */
	public String[] procesa(String[] arreglo, String[] configuracion) {
		// System.out.println("procesa");
		// TODO Auto-generated method stub
		// mensajeria.ws.Registros registros = new mensajeria.ws.Registros();
		// return registros.procesa(arreglo,configuracion);
	    	HashMap<String, String> map_registgros = new HashMap<String, String>();

		debug("SiglasPlaza-->" + configuracion[0]);
		debug("Servidor-->" + configuracion[1]);
		debug("Numero de Cliente-->" + configuracion[2]);
		debug("Nombre del archivo procesado-->" + configuracion[3]);
		debug("DB-->" + configuracion[4]);
		
		boolean isReplica = false;
		for (int i=0;i<configuracion.length;i++){
			if (configuracion[i].trim().toLowerCase().equals("replica")){
				isReplica=true;
			}
		}
		
		
		// Arreglo que contiene los errores generados
		ArrayList errores = new ArrayList();

		if (arreglo == null)
			return arreglo;

		String linea = "";

		// Contiene los campos del registro en turno
		String[] campos_registroinfo;
		String[] error_info = null;

		RegistroInfo registroInfo;
		InterfaceUpdateInser rf;
		

		// Itera sobre todos los registros del arreglo para agregarlos
		RegistroInfo info_registro_add = new RegistroInfo();
		// Indica la base de datos
		RegistrosCampos registrosDao = new RegistrosCampos(configuracion[4]);
		this.db = configuracion[4];
		String error;
		if (configuracion.length >= 4) {
			for (int i = 0; i < arreglo.length; i++) {
				linea = arreglo[i];

				//Verifica que no se haya procesado ya la linea
				if (map_registgros.containsKey(linea)){
				    continue;
				}
				
				if (linea == null)
					linea = "#";

				campos_registroinfo = linea.split("\\|",-1);
				// Arreglo para cambiar el orden de los datos
				for (int y = 0; y < campos_registroinfo.length; y++) {
					// debug("Campo " + y + " valor:" + campos_registroinfo[y]);
				}
				map_registgros.put(linea, linea);
				if (linea.trim().length() > 0) {

					// Verifica si el registro es de tipo 99 limpia los datos de
					// los campos y registros para tomar nuevos valores
					if (campos_registroinfo[0].equals("99")) {
						debug("Registro a procesar:" + linea);
						clearRegistroInfo();
					} else {// Fin del limpiado de datos
						// debug("Entre a procesar registgro:" + linea);
						// if ((!linea.trim().startsWith("#")) &&
						// (!linea.trim().startsWith("O"))) {
						// Solo lineas que no sean comentarios
						if (!campos_registroinfo[0].equals("0")
								&& !campos_registroinfo[0].equals("#")
								&& !campos_registroinfo[0].equals("#0")) {

							// Obtiene la informacion del registro cuyo
							// identificador se el indincado
							registroInfo = getRegistro(campos_registroinfo[0],campos_registroinfo.length);  

							if (registroInfo == null) {
								
								//RegistrosLogs.insertaError(error,this.db);
								

								
								error = formatoMsgError(linea, Fechas.Fecha(),
										campos_registroinfo[0] +
									" tipo registro no existe con largo " + campos_registroinfo.length,
										configuracion[3], configuracion[0]);
								
								registrosDao.insertRegistroEstatus(linea,
									configuracion, true,
									campos_registroinfo[0] +
									" tipo registro no existe con largo " + campos_registroinfo.length,
									"ESTRUCTURA_RI");


								errores.add(error);
		
								//putError(configuracion);
								
							} else {
								debug(registroInfo.get_idRegistro());
								debug(registroInfo.get_descripcion());
								debug(registroInfo.get_estructura());
								debug(registroInfo.getClaseUpdateInsert());

								// Verifica si los datos son correctos
								registroInfo.checkRegistro(linea);

								if (!registroInfo.is_isCorrecto()) {
	
									error = formatoMsgError(linea,
											Fechas.Fecha(),
											registroInfo.get_error(),
											configuracion[3], configuracion[0]);

									// Agrega el error al arreglo que se va a
									// devolver
									errores.add(error);

									// Agrega la linea de error al archivo de
									// log
									//RegistrosLogs.insertaError(error,this.db);
									registrosDao.insertRegistroEstatus(linea, configuracion, true,
										registroInfo.get_error(),
										"CAMPO");

									// Agrega en el log de la estadistica
									//putError(configuracion);
								} else {
									debug("Agregando registro DB->" + linea);
									// Cargamos la clase y se carga la informacion en la base 
									//de datos
									map_registgros.put(linea, linea);
									if (executeProcesa(
											registroInfo.getClaseUpdateInsert(),
											linea,configuracion,isReplica)){
										
									}

									
									// Guarda el registro en el archivo del dia
									//RegistrosLogs.respaldaRegistro(linea,this.db);
									
									//Inicia replicacion 
									

								}// fin de la verificacion del campo
							}// fin de registroInfo

							// Agrega el registro a la base de datos de
							// agregados
							// con
							// los datos
							// del cliente, servidor y registro procesado
							// SiglasPlaza->0, Servidor->1, Numero de
							// Cliente->2,Nombre
							// del archivo
							// procesado->3   
							if ((configuracion[0] != null)
									&& (configuracion[1] != null)
									&& (configuracion[2] != null)) {

								info_registro_add = new RegistroInfo();
								info_registro_add
										.set_idRegistro(campos_registroinfo[0]);
								info_registro_add.set_plaza(configuracion[0]);
								info_registro_add
										.set_servidor(configuracion[1]);
								info_registro_add
										.set_idpropietario(configuracion[2]);

								try {
									registrosDao
											.insertEstadisticasCarga(info_registro_add);
								} catch (SQLException e) {
									debug("Registros->procesa->No se logro actualizar la estadistica de agregado.");
								}

							}// Fin del agregado de la información

						}// fin frl if que procesa las lineas
					}// FIN DEL el de registro 99
				}// Fin de linea.trim().length>0

				// Crea el arreglo de los datos
				if (errores.size() > 0) {
					error_info = new String[errores.size()];

					for (int ii = 0; ii < errores.size(); ii++) {
						error_info[ii] = (String) errores.get(ii);
						// debug(error_info[ii]);
					}// fin del for de errores

				}
			}// fin del for de registros
		} else {
			error = formatoMsgError("NO SE INDICO BASE DE DATOS",
					Fechas.Fecha(),
					"",
					configuracion[3], configuracion[0]);

			// Agrega el error al arreglo que se va a
			// devolver
			errores.add(error);
		}

		//Trata de realizar la replica de la informacion si solo si el origen no es de una replica anterior
		return error_info;

	}

	public String[] registrosImpresion(String idFile, String login,
			String password) {
		// System.out.println("registrosImpresion");
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Da formato al mensaje de error devuelto
	 * @param registro
	 * @param fecha
	 * @param msg_error
	 * @param nomarchivo
	 * @param plaza
	 * @return
	 */
	private String formatoMsgError(String registro, String fecha, String msg_error, String nomarchivo,String plaza){
	
		return registro + '\t' + fecha + '\t' + nomarchivo + '\t' + plaza + '\t'  + msg_error;
	}
	
	/**
	 * Obtiene los datos del registro dado su identificador
	 * 
	 * @param idregistro
	 *            identificador del registro
	 * @return instancia de RegistroInfo con los datos de los campos asociados a
	 *         el o null en caso de no encontrar dato con identificador
	 *         indicado.
	 */
	private RegistroInfo getRegistro(String idregistro, int largo) {

	    	String llave = idregistro+largo;
	    
		if (idregistro == null)
			return null;

		// Busca en el hashMap el identificador del registro indicado
		if (map_Registros_Info.containsKey(llave)) {
			return (RegistroInfo) map_Registros_Info.get(llave);
		}

		
		RegistrosCampos regcam = new RegistrosCampos(this.db);
		RegistroInfo registro;
		 List<RegistroInfo> tipos_registro =null; 
		try {
		    	tipos_registro = regcam.getTodoslosRegistrosDelTipo(idregistro);
		    	
		    	if ((tipos_registro !=null) && (tipos_registro.size()>0)){
		    	    for (RegistroInfo registroInfo : tipos_registro) {
		    		// debug("registro->"+registro);
				if (registroInfo != null) {
				    
					map_Registros_Info.put(
						registroInfo.get_idRegistro()+registroInfo.getLargo(), 
						registroInfo);
				}
			    }
		    	}
			//Vuelve a intentar la  busqueda
		    	if (map_Registros_Info.containsKey(llave)) {
				return (RegistroInfo) map_Registros_Info.get(llave);
			}
		    	

		} catch (Exception e) {
			debug("getRegistro->Error al obtener los datos del registro "
					+ e.getMessage());
		}
		return null;

	}// fin de getRegistro
	
	/**
	 * Agrega el error a la cola de mensajes
	 * @param configuracion
	 */
	private void putError(String[] configuracion) {

		RegistroInfo info_registro_add = null;
		if ((configuracion[0] != null) && (configuracion[1] != null)
				&& (configuracion[2] != null)) {

			info_registro_add = new RegistroInfo();
			info_registro_add.set_idRegistro("00");
			info_registro_add.set_plaza(configuracion[0]);
			info_registro_add.set_servidor(configuracion[1]);
			info_registro_add.set_idpropietario(configuracion[2]);
			RegistrosCampos registrosDao = new RegistrosCampos(this.db);

			try {
				registrosDao.insertEstadisticasCarga(info_registro_add);
			} catch (SQLException e) {
				debug("Registros->procesa->No se logro actualizar la estadistica de agregado.");
			}

		}// Fin del agregado de la información
	}

	/* Recibe solicitu de informacion y devuelve la info en un arreglo
	 * @see com.ws.interchange.InterchangeSEI#downloadInfo(java.lang.String[], java.lang.String[])
	 */
	public String[] downloadInfo(String[] configuracion, String[] tablas) {
		// TODO Obtiene la entidad
		
		//Obtiene el nombre de la tabla 
		
		//Obtiene el parametro donde estan las tablas a descargar
		
		//Arma el nombre del archivo mas = tabla[] + configuracion[]
		//Verifica si existe el archivo 
		
		//Si existe lo abre y comienza a leer las lineas
		
		//Arma elarreglo de String
		
		//Devuelve arreglo de String
	    UsuariosDao usuarioDAO = new UsuariosDao(configuracion[1]);
	    
	    if (isTablaDownload(tablas,Constantes.TABLA_USERS)){
		return usuarioDAO.getUsuariosOperativos(configuracion[0]);
	    }
	    return null;
	}
	
	private boolean isTablaDownload( String[] tabla,String id){
	    for (String item : tabla) {
		if (id.equals(item)){
		    return true;
		}
	    }
	    return false;
	}
}
