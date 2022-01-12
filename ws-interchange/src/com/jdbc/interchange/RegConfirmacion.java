/**
 * 
 */
package com.jdbc.interchange;

import java.sql.SQLException;
import java.util.ArrayList;

import mensajeria.forms.EntregaForm;

import com.debug.utils.DebugLog;
import com.debug.utils.Fechas;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class RegConfirmacion implements InterfaceUpdateInser {
	private String db=null;
	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug

	/**
	 * 
	 */
	public RegConfirmacion(String db) {
		this.db=db;
	}
	public RegConfirmacion() {

	}

	/* (non-Javadoc)
	 * @see com.jdbc.interchange.InterfaceUpdateInser#insert(java.lang.Object)
	 */
	public void insert(Object o) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.jdbc.interchange.InterfaceUpdateInser#update(java.lang.Object)
	 */
	
	public void update(Object o) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.jdbc.interchange.InterfaceUpdateInser#delete(java.lang.Object)
	 */

	public void delete(Object o) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.jdbc.interchange.InterfaceUpdateInser#utils(java.lang.Object)
	 */
	
	public void utils(Object o) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.jdbc.interchange.InterfaceUpdateInser#procesa(java.lang.String)
	 */
	
	public void procesa(String registro,String db) throws SQLException {
		String[] campos = registro.split("\\|");
		EntregaForm entrega = new EntregaForm();

		// Arreglo para cambiar el orden de los datos
		OperacionDB confDao = new OperacionDB(db);
		//debug("BASE DE DATOS:" + db);

		// Arreglo para cambiar el orden de los datos
		for (int y = 0; y < campos.length; y++) {
			// debug("Campo " + y +" valor:"+campos[y] );
		}

		try {
			
			if ((campos[0].trim().equals("5")) || campos[0].trim().equals("05")) { // Confirmacion por guia

				//05|NumGuia|Ruta|Fecha|OriReg|Plaza|NomRecibe|Empleado
				//05|NumGuia|Ruta|Fecha|OriReg|Plaza|NomRecibe|firma|Empleado
				ArrayList<String> arr_envios = new ArrayList<String>();
				
				
				int index=1;
				entrega = new EntregaForm();
				entrega.setIdGuia(campos[index++]); // guia
				if (entrega.getIdGuia().trim().toUpperCase().startsWith(DebugLog.PREFIJO_DELIVERY)){
					String[] arr_delivery = entrega.getIdGuia().trim().toUpperCase().split(DebugLog.PREFIJO_DELIVERY_SEPARADOR); 
					if (arr_delivery.length>1){
						//Busca las guias atadas con el delivery
						arr_envios = confDao.getListaGuiasCasadas(arr_delivery[1]);
					}
				}
				//Si no se encontro ninguna guia de sacamiento solo se aplica el movimiento a la 
				//guia que esta contenida en el registro
				if (arr_envios.size()<=0){
					arr_envios.add(entrega.getIdGuia());
				}
				
				
				//Datos complementarios
				entrega.setIdRuta(campos[index++]); // ruta
				entrega.setIsRegistro(true);

				// Da formato a la Fecha en los movimientos de confirmaciones
				entrega.setFecha(Fechas.formateaFecha(campos[index++]));

				entrega.setCencap(campos[index++]);
				entrega.setDestino(campos[index++]);
				entrega.setQuienRecibe(campos[index++]);
				
				//Tiene firma y empleado
				if (campos.length>8){
					entrega.setIdFirma(campos[index++]);
					entrega.setNumEmpleado(campos[index++]);
				}else if (campos.length>7){
					//Solo tiene empleado
					entrega.setNumEmpleado(campos[index++]);
				}
				
				
				if (campos.length>9){
					entrega.setLatitud(campos[index++]);
					entrega.setLongitud(campos[index++]);
				}
				
				//Recorre la lista de todas las guias a afectar
				for (String idguia : arr_envios) {
					entrega.setIdGuia(idguia);
					// insrta el registro de confirmacion
					confDao.insertConfirmacion(entrega);
				}

				

				//TODO: 18-03-2012 REVISIOn POSTERIOR A LIBERACION DE
				//SKY4SOL 
				//envioDao.insert(envio);

			} else if ((campos[0].trim().equals("6")) || (campos[0].trim().equals("06") )) {
				// Confirmacion por guia de casamiento

				entrega = new EntregaForm();
				entrega.setIdGuia(campos[1]); // guia
				entrega.setIdRuta(campos[2]); // ruta
				entrega.setIsRegistro(true);
				// Da formato a la Fecha en los movimientos de confirmaciones
				entrega.setFecha(Fechas.formateaFecha(campos[3]));

				entrega.setOrigen(campos[4]);
				entrega.setSiglasPlaza(campos[5]);
				entrega.setQuienRecibe(campos[6]);
				if (campos.length>7){
					entrega.setIdFirma(campos[7]);
					entrega.setNumEmpleado(campos[8]);
				}
				

				// Ordena los campos para poder procesarlos e insertarlos
				// correctamente en la DB
				confDao.insertConfirmaCasamiento(entrega, false,campos[3]);

			} else if ((campos[0].trim().equals("7")) || (campos[0].trim().equals("07"))) {
				// Confirmacion por
				// Referencia

				entrega = new EntregaForm();

				entrega.setIdGuia(campos[1]);
				entrega.setIdRuta(campos[3]); // ruta
				entrega.setIsRegistro(true);
				// Da formato a la Fecha en los movimientos de confirmaciones
				entrega.setFecha(Fechas.formateaFecha(campos[4]));

				entrega.setOrigen(campos[5]);
				entrega.setSiglasPlaza(campos[6]);
				entrega.setQuienRecibe(campos[7]);

				// Ordena los campos para poder procesarlos e insertarlos
				// correctamente en la DB
				//confDao.insertConfirmaReferencia(entrega, campos[1], campos[2],campos[4]);

			}else if (campos[0].trim().equals("25")) {// Confirmacion por factura
				// 25|Factura|NumCliente|Ruta|Fecha|OriReg|Plaza|NomRecibe
				ArrayList<String>  arr = confDao.getDocumentosFactura(campos[1], campos[2]);
				if (arr.size()<=0){
					debug("Registro de confirmacion x factura  " + registro + ", no tiene informacion relacionada en la base de datos");
					return;
				}
				//Para cada docuento se agrega una confirmacion
				for (int i = 0; i < arr.size(); i++) {

					entrega = new EntregaForm();

					entrega.setIdGuia(arr.get(i));
					
					entrega.setIdRuta(campos[3]); // ruta
					entrega.setIsRegistro(true);
					// Da formato a la Fecha en los movimientos de confirmaciones
					entrega.setFecha(Fechas.formateaFecha(campos[4]));

					entrega.setOrigen(campos[5]);
					entrega.setSiglasPlaza(campos[6]);
					entrega.setQuienRecibe(campos[7]);
					if (campos.length>7){
						entrega.setNumEmpleado(campos[8]);
					}
					
					debug("Confirmando documento: " +entrega.getIdGuia() + ", de la factura:" +campos[1] + ", con numero de cliente:"+ campos[2]);
					
					confDao.insertConfirmacion(entrega);
				}


			}// fin del if principal

		} catch (Exception e) {
			debug("Excepcion " + e.getMessage());
			throw new SQLException(e.getMessage()); 
		}


	}

}
