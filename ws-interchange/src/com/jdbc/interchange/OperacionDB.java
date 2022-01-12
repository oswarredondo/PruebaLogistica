/**
 * 
 */
package com.jdbc.interchange;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import mensajeria.forms.EntregaForm;
import mensajeria.forms.Seguimiento;

import com.debug.utils.DebugLog;
import com.debug.utils.FechasTimeStamp;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class OperacionDB {

	private String db=null;
	/**
	 * 
	 */
	public OperacionDB(String db) {
		this.db=db;
	}
	
	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug
	
	  /**
     * Inserta un registro de casamiento
     *
     *  @param seguimiento,  instancia de la clase de Seguimiento que contiene los datos agregar
     *  @throw SQLException
     */
    public boolean insertCasamiento(Seguimiento seguimiento) throws SQLException{
        
        // Define el objeto Conexion
    	Conexion conexion = new Conexion(this.db);
    	  Connection cnx = null;
       // String sql="INSERT INTO Casamiento VALUES(?,?,?,?,?,?,?)";
    	  String sql=null;
          // String sql="INSERT INTO Casamiento VALUES(?,?,?,?,?,?,?)";
       	  if ((seguimiento.getNumEmpleado()!=null) && (seguimiento.getNumEmpleado().trim().length()>0 )){
 
       		 sql =  "INSERT INTO casamiento("+
       		         "   idguia, idcasamiento, idcarrier, ceorigenregistro, plsiglasplaza, "+
       		         "   fechaevento, ruta, empleado)"+
       		    " VALUES (?, ?, ?, ?, ?,  ?, ?, ?)";
       		 
         		  
        	}else{
        		  sql =  "INSERT INTO casamiento("+
            		         "   idguia, idcasamiento, idcarrier, ceorigenregistro, plsiglasplaza, "+
            		         "   fechaevento, ruta)"+
            		    " VALUES (?, ?, ?, ?, ?,  ?, ?)";
        		
        	}
       
       	  
        //Define el PreparedStatement
        PreparedStatement ps=null;
        
        try{
        	cnx = conexion.getConexion();
            
            //verifica si se pudo realizar la conexion
            if ( cnx == null){
                return false;
            }
            //Ejecuta el query de insercion
            ps = cnx.prepareStatement(sql); 
            int index = 1;
            ps.setString(index++,seguimiento.getIdEnvio());
            ps.setString(index++,seguimiento.getIdCasamiento());
            ps.setString(index++,seguimiento.getIdCarrier());
            ps.setString(index++,seguimiento.getOrigenRegistro());
            ps.setString(index++,seguimiento.getSiglas());
            ps.setTimestamp(index++,FechasTimeStamp.convertFechaToTimeStamp(seguimiento.getFechaEvento()));
            ps.setString(index++,seguimiento.getRuta());
            
            if ((seguimiento.getNumEmpleado()!=null) && (seguimiento.getNumEmpleado().trim().length()>0 )){
          	  ps.setString(index++,seguimiento.getNumEmpleado());
            }
            
            //Verifica si se afecto registro de inserción
            ps.executeUpdate();
            
        }catch(SQLException sqle){
            debug("getInsertCasamiento-sqle - Error al insertar los datos en la db: " +
                    sqle.getMessage());
            throw new SQLException(sqle.getSQLState()+"|"+sqle.getMessage() );
            
        }catch(Exception e){
            debug("getInsertCasamiento-e - Error al insertar los datos en la db: " +
                    e.getMessage());
            throw new SQLException(e.getMessage());
            
        }finally{
            // Cierra recursos
        	conexion.closeRecursos(ps, cnx);
        }
        
        return true;
        
    }//fin de getInsertMovimiento
    
    /**
     * Inserta un registro de casamiento
     *
     *  @param seguimiento,  instancia de la clase de Seguimiento que contiene los datos agregar
     *  @throw SQLException
     */
    public boolean insertDevolucion(Seguimiento seguimiento) throws SQLException{
        
        // Define el objeto Conexion
    	Conexion conexion = new Conexion(this.db);
    	  Connection cnx = null;
    	  String sql=null;
       // String sql="INSERT INTO Casamiento VALUES(?,?,?,?,?,?,?)";
    	  if ((seguimiento.getNumEmpleado()!=null) && (seguimiento.getNumEmpleado().trim().length()>0 )){
    		  sql =  "INSERT INTO devolucion("+
    		         "   idguia, iddevolucion, ceorigenregistro, plsiglasplaza, fechaevento, "+
    		         "   ruta, empleado)"+
    		    " VALUES (?, ?, ?, ?, ?, ?, ?)";
      		  
     	}else{

     		  sql =  "INSERT INTO devolucion("+
     		         "   idguia, iddevolucion, ceorigenregistro, plsiglasplaza, fechaevento, "+
     		         "   ruta)"+
     		    " VALUES (?, ?, ?, ?, ?, ?)";
     	}
    	  
        //Define el PreparedStatement
        PreparedStatement ps=null;

        
        try{
        	cnx = conexion.getConexion();
            
            //verifica si se pudo realizar la conexion
            if ( cnx == null){
                return false;
            }
            //Ejecuta el query de insercion
            ps = cnx.prepareStatement(sql); 
            int index = 1;
            ps.setString(index++,seguimiento.getIdEnvio());
            ps.setString(index++,seguimiento.getIdCasamiento());
            ps.setString(index++,seguimiento.getOrigenRegistro());
            ps.setString(index++,seguimiento.getSiglas());
            ps.setTimestamp(index++,FechasTimeStamp.convertFechaToTimeStamp(seguimiento.getFechaEvento()));
            ps.setString(index++,seguimiento.getRuta());
            //ps.setString(index++,seguimiento.getNumEmpleado());
            
            if ((seguimiento.getNumEmpleado()!=null) && (seguimiento.getNumEmpleado().trim().length()>0 )){
            	  ps.setString(index++,seguimiento.getNumEmpleado());
              }
            
            //Verifica si se afecto registro de inserción
            ps.executeUpdate();
            
        }catch(SQLException sqle){
            debug("getInsertCasamiento-sqle - Error al insertar los datos en la db: " +
                    sqle.getMessage());
            throw new SQLException(sqle.getSQLState()+"|"+sqle.getMessage() );
            
        }catch(Exception e){
            debug("getInsertCasamiento-e - Error al insertar los datos en la db: " +
                    e.getMessage());
            throw new SQLException(e.getMessage());
            
        }finally{
            // Cierra recursos
        	conexion.closeRecursos(ps, cnx);
        }
        
        return true;
        
    }//fin de getInsertMovimiento

    /**
     * Inserta u registro de movimiento o seguimiento
     * @param envio instancia de la clase Seguimiento que contiene todos los datos del registro de movimineto
     * a procesar
     * @throws SQLException
     * @return
     */
    public boolean insertMovimientoEmbarcadoCOD(Seguimiento envio)
    throws SQLException{
        
        // Define el objeto Conexion
        Connection cnx = null;
    	
    	Conexion conexion = new Conexion(this.db);
    	String sql = "INSERT INTO movimientosmonto(" +
    			" idguia, tiregistro, exclave, plsiglasplaza, ceorigenregistro," +
    			" ruta, fechaevento, fechainsercion, numempleado, monto)" +
    			" VALUES (?, ?, ?, ?, ?, ?, ?, current_timestamp, ?, ?)";
    	
    
        debug("sql movimientos " + sql);
        PreparedStatement ps=null;
        
        try{
        	cnx = conexion.getConexion();
            
            //verifica si se pudo realizar la conexion
            if ( cnx == null){
                return false;
            }
            //Ejecuta el query de insercion
            ps = cnx.prepareStatement(sql);
            int index=1;
            ps.setString(index++,envio.getIdEnvio());
            ps.setString(index++,envio.getTipoRegistro());
            ps.setString(index++,envio.getClaveExce());
            ps.setString(index++,envio.getSiglas());
            ps.setString(index++,envio.getOrigenRegistro());
            ps.setString(index++,envio.getRuta());

            ps.setTimestamp(index++,FechasTimeStamp.convertFechaToTimeStamp(envio.getFechaEvento()));
       	  	ps.setString(index++,envio.getNumEmpleado());
       	  	ps.setFloat(index++, envio.getMonto());

          

            
            //Verifica si se afecto registro de inserción
            ps.executeUpdate();
            
        }catch(SQLException sqle){
            debug("Error al insertar el registro de Movimiento:" + 
                    sqle.getMessage() );
            throw new SQLException(sqle.getSQLState()+"|"+sqle.getMessage());
        }catch(Exception e){
            debug("Error al insertar el registro de Movimiento:" +
                    e.getMessage() );
            throw new SQLException(e.getMessage());
        } finally {
            // Cierra recursos
            conexion.closeRecursos(ps, cnx);
        }
        
        return true;
        
    }//fin de getInsertMovimiento
    

	/**
	 * Agrega un movimiento a la historia de una recoleccion
	 * @param idSolicitud
	 * 
	 */
	public void insertMovimientoRecoleccion(Seguimiento envio) throws SQLException {
		
		// Define el objeto Conexion
        Connection cnx = null;
    	
    	Conexion conexion = new Conexion(this.db);
    	String sql = null;
		sql = "INSERT INTO removimientosrecol(" +
					"  idsolicitud, tipomovimiento, fecha, claveexc, ruta, empleado, " +
					" quienrechaza, motivo)" +
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
         
        
        debug("sql movimientos " + sql);
        //Obtiene la fecha del sistema

        //Define el PreparedStatement
        PreparedStatement ps=null;
        
        try{
        	cnx = conexion.getConexion();
            
            //verifica si se pudo realizar la conexion
            if ( cnx == null){
                return ;
            }
            //Ejecuta el query de insercion
            ps = cnx.prepareStatement(sql);
            int index=1;
            ps.setString(index++,envio.getIdEnvio());
            ps.setString(index++,envio.getTipoRegistro());
			ps.setTimestamp(index++,FechasTimeStamp.convertFechaToTimeStamp(envio.getFechaEvento()));
            ps.setString(index++,envio.getClaveExce());
			ps.setString(index++,envio.getRuta());
			ps.setString(index++,envio.getNumEmpleado());	
			ps.setString(index++,envio.getQuienRechaza());	
            ps.setString(index++,envio.getMotivo()); 
             
            //Verifica si se afecto registro de inserción
            ps.executeUpdate();
            
        }catch(SQLException sqle){
            debug("Error al insertar el registro de Movimiento:" + 
                    sqle.getMessage() + "-" +  sqle.getSQLState()  );
            throw new SQLException(sqle.getSQLState()+"|"+sqle.getMessage());
        }catch(Exception e){
            debug("Error al insertar el registro de Movimiento:" +
                    e.getMessage() );
            
            throw new SQLException(e.getMessage());
            
        } finally {
            // Cierra recursos
            conexion.closeRecursos(ps, cnx);
        }
        
       
		
		
	}
	
    /**
     * Inserta u registro de movimiento o seguimiento
     * @param envio instancia de la clase Seguimiento que contiene todos los datos del registro de movimineto
     * a procesar
     * @throws SQLException
     * @return
     */
    public boolean insertMovimiento(Seguimiento envio)
    throws SQLException{
        
        // Define el objeto Conexion
        Connection cnx = null;
    	
    	Conexion conexion = new Conexion(this.db);
    	String sql = null;
    	
    	  
    	sql = "INSERT INTO movimientos(" +
		        "    fechainsercion, idguia, tiregistro, exclave, plsiglasplaza, ceorigenregistro," +
		        "    ruta, fechaevento, empleado, viaje, deptodestino,numeconomico,"
		        + "operador,cincho,latitud,longitud,ubicacion)" +
				" VALUES(current_timestamp, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
         
        
        //debug("sql movimientos " + sql);
        //Obtiene la fecha del sistema

        //Define el PreparedStatement
        PreparedStatement ps=null;
        
        try{
        	cnx = conexion.getConexion();
            
            //verifica si se pudo realizar la conexion
            if ( cnx == null){
                return false;
            }
            //Ejecuta el query de insercion
            ps = cnx.prepareStatement(sql);
            int index=1;
            ps.setString(index++,envio.getIdEnvio());
            ps.setString(index++,envio.getTipoRegistro());
            ps.setString(index++,envio.getClaveExce());
            ps.setString(index++,envio.getSiglas());
            ps.setString(index++,envio.getOrigenRegistro());
            ps.setString(index++,envio.getRuta());

            ps.setTimestamp(index++,FechasTimeStamp.convertFechaToTimeStamp(envio.getFechaEvento()));
            ps.setString(index++,envio.getNumEmpleado());
            ps.setString(index++,envio.getViaje());
            ps.setString(index++,envio.getDeptodestino());
            ps.setString(index++,envio.getNumeconomico());
            ps.setString(index++,envio.getOperador1());
            ps.setString(index++,envio.getCincho());
            ps.setString(index++,envio.getLatitud());
            ps.setString(index++,envio.getLongitud());

            ps.setString(index++,envio.getUbicacion());

            //Verifica si se afecto registro de inserción
            ps.executeUpdate();
            
        }catch(SQLException sqle){
            debug("Error al insertar el registro de Movimiento:" + 
                    sqle.getMessage() );
            throw new SQLException(sqle.getSQLState()+"|"+sqle.getMessage() );
        }catch(Exception e){
            debug("Error al insertar el registro de Movimiento:" +
                    e.getMessage() );
            throw new SQLException(e.getMessage());
            
        } finally {
            // Cierra recursos
            conexion.closeRecursos(ps, cnx);
        }
        
        return true;
        
    }//fin de getInsertMovimiento
	
    /***
     * Inserta registro de sobre peso
     * @param seguimiento
     * @throws SQLException 
     */
    public void insertSobrePeso(Seguimiento seguimiento )
    throws SQLException{
        
        // Define el objeto Conexion
        Connection cnx = null;
        
        //Define el PreparedStatement
        PreparedStatement ps=null;
        String _insert="INSERT INTO sobrepeso(idguia, pesokg, largo, ancho, alto, " +
        		" origreg, plaza, numempleado, fechaevento, fechainsercion) " +
        		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp)";
        Conexion conexion = null;
        try{
        	 conexion = new Conexion(this.db);
        	 cnx = conexion.getConexion();
        	 
        	  if ( cnx == null){
                  return ;
              }
            ps = cnx.prepareStatement(_insert);
            

            //Ejecuta el query de insercion
            int index = 1;
            ps.setString(index++,seguimiento.getIdEnvio());
            ps.setFloat(index++,seguimiento.getPesoKG());
            ps.setFloat(index++,seguimiento.getLargo());
            ps.setFloat(index++,seguimiento.getAncho());
            ps.setFloat(index++,seguimiento.getAlto());
            ps.setString(index++, seguimiento.getOrigenRegistro());
            ps.setString(index++, seguimiento.getSiglas());
            ps.setString(index++, seguimiento.getNumEmpleado());
            ps.setTimestamp(index++,FechasTimeStamp.convertFechaToTimeStamp(seguimiento.getFechaEvento()));

            ps.executeUpdate();
            
        }catch(SQLException sqle){
            debug("insertSobrePeso-sqle-Error al insertar los datos en la db: " +
                    sqle.getMessage() + "-" +  sqle.getErrorCode());
            throw new SQLException(sqle.getSQLState()+"|"+sqle.getMessage() );
            
        }catch(Exception e){
            debug("insertSobrePeso-e-Error al insertar los datos en la db: " +
        	    e.getMessage());
            throw new SQLException("0|"+e.getMessage());
            
        }finally{
            // Cierra recursos
        	  conexion.closeRecursos(ps, cnx);
        }
        
        
    }//fin insertSobrePeso
  
    /***
     * Inserta una historia en el kardex de Embarques
     * @param seguimiento
     * @return
     * @throws SQLException
     */
    public boolean insertMovimientoECOPSCOP(Seguimiento seguimiento) throws SQLException{
        if (seguimiento==null) return false;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cnx = null;
        String _insert = "INSERT INTO caecopscop (tipomov,numvehiculo,contenedor1,contenedor2," +
        		"operador1,operador2,cartaporte,manifiesto," +
        		"cveexcep,fechacreacion,origreg,plaza,numempleado,fechainsercion)" +
        		" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp)";
        Conexion conexion = new Conexion(this.db);
        try {
            
        	cnx = conexion.getConexion();
        	
        	  if ( cnx == null){
                  return false;
              }
        	  
            ps = cnx.prepareStatement(_insert);
            int index=1;
            //Documento,MOvimiento,Fecha,IdProducto, IdSerie,IdExcepcion,Placa,Cantidad
            ps.setString(index++, seguimiento.getTipoRegistro());
            ps.setString(index++, seguimiento.getVehiculo());
            ps.setString(index++, seguimiento.getContenedor1());
            ps.setString(index++, seguimiento.getContenedor2());  
            ps.setString(index++, seguimiento.getOperador1());
            ps.setString(index++, seguimiento.getOperador2());
            ps.setString(index++, seguimiento.getCartaporte());
            ps.setString(index++, seguimiento.getManifiesto());
            ps.setString(index++, seguimiento.getClaveExce());
            ps.setTimestamp(index++,FechasTimeStamp.convertFechaToTimeStamp(seguimiento.getFechaEvento()));
            ps.setString(index++, seguimiento.getOrigenRegistro());
            ps.setString(index++, seguimiento.getSiglas());
            ps.setString(index++, seguimiento.getNumEmpleado());
            
            ps.executeUpdate();
            
        } catch (SQLException sqle) {
            debug("No se puede agregar el registro insertMovimientoECOPSCOP-->"+sqle.getMessage());
            throw new SQLException(sqle.getSQLState()+"|"+sqle.getMessage()  );
        } finally {
            // Cierra recursos
            conexion.closeRecursos(ps, cnx);
        }
        return true;
        
    }//fin de insertMovimientoKardex
    
	 /**
     * Inserta una historia en el kardex de Embarques
     *
     */
    public int insertMovimientoEntradaSalida(Seguimiento seguimiento) throws SQLException{
        if (seguimiento==null) return 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cnx = null;
        String _insert = "INSERT INTO alCaDetalleEntradaSalida VALUES(?,?,?,?,?,?,?,?,?)";
        Conexion conexion = new Conexion(this.db);
        try {
            
        	cnx = conexion.getConexion();
            ps = cnx.prepareStatement(_insert);
            int index=1;
            //Documento,MOvimiento,Fecha,IdProducto, IdSerie,IdExcepcion,Placa,Cantidad
            ps.setString(index++, seguimiento.getDocumento_embarque());
            ps.setString(index++, seguimiento.getTipoRegistro());
            ps.setString(index++, seguimiento.getFechaEvento());
            ps.setString(index++,seguimiento.getIdProducto());
            ps.setString(index++, seguimiento.getSerie());
            ps.setString(index++, seguimiento.getClaveExce());
            ps.setString(index++, seguimiento.getPlaca());
            ps.setInt(index++, seguimiento.getCantidad());
            ps.setString(index++, seguimiento.getNumCliente());
            
            
            ps.executeUpdate();
            
        } catch (SQLException sqle) {
            debug("No se puede agregar el registro insertMovimientoEntradaSalida-->"+sqle.getMessage());
            throw new SQLException(sqle.getSQLState()+"|"+sqle.getMessage() );
        } finally {
            // Cierra recursos
            conexion.closeRecursos(ps, cnx);
        }
        return 0;
        
    }//fin de insertMovimientoKardex
	
	/**
	 * Inserta un registro de confirmación en la base de datos
	 * 
	 * @param o
	 *            instancia del objeto procesado
	 * @return la cantidad de registros afectado
	 */
	public int insertConfirmacion(EntregaForm o) throws SQLException {
		// Convierte el objeto a MensajeForm
		EntregaForm form = (EntregaForm) o;

		// Verifica que los datos sean correctos
		if ((form == null) || (form.getQuienRecibe() == null)
				|| (form.getQuienRecibe().trim().length() <= 0)) {
			return 0;
		}

		if (form.getQuienRecibe() == null) {
			return 0;
		}

		// Inserta el registro de confirmacion
		// IdGuia, plSiglasPlaza , ceOrigenRegistro, Ruta, coFecha,
		// coNombre,FechaInsercion
		PreparedStatement ps = null;
		Connection cnx = null;
		Conexion conexion = new Conexion(this.db);
		int afectados = 0;
		try {
			cnx = conexion.getConexion();

			//String qry = "INSERT INTO Confirma VALUES(?,?,?,?,?,?,current_timestamp,?)";
			String qry = "INSERT INTO confirma("+
		          "  idguia, plsiglasplaza, ceorigenregistro, ruta, cofecha, conombre, "+
		          "  fechaentregapod,fechainsercion,empleado,firma, latitud, longitud)"+
				  " VALUES (?, ?, ?, ?, ?, ?, ?,current_timestamp,?,?,?,?)";

			ps = cnx.prepareStatement(qry);  
			int index=1;
			ps.setString(index++, form.getIdGuia());

			ps.setString(index++, form.getDestino());
			ps.setString(index++, form.getCencap());
			ps.setString(index++, form.getIdRuta());

			/*if (form.isRegistro()) {

				ps.setString(index++, form.getFecha());// Informacion del SR2006
				 ps.setTimestamp(index++,FechasTimeStamp.convertFechaToTimeStamp(form.getFecha()));
			} else {**/

				 ps.setTimestamp(index++,FechasTimeStamp.convertFechaToTimeStamp(form.getFecha()));
			//}
			ps.setString(index++, form.getQuienRecibe());
			ps.setDate(index++, null);
			ps.setString(index++, form.getNumEmpleado());
			ps.setString(index++, form.getIdFirma());
		
			ps.setString(index++, form.getLatitud());
			ps.setString(index++, form.getLongitud());
			
			afectados = ps.executeUpdate();

		} catch (SQLException sqle) {
			debug("Excepcion en la confirmacion-->" + sqle.getMessage());
			  throw new SQLException( sqle.getSQLState()+"|"+sqle.getMessage() );

		} finally {
			// Libera los recursos
			conexion.closeRecursos(null, ps, cnx);
		}

		return afectados;

	}// fin de inserts
	
	/**
	 * Realiza la insercion de los registros con casamiento, la bandera de
	 * externa indica sobre que criterio se va a buscar la informacion
	 */
	public void insertConfirmaCasamiento(EntregaForm entregaForma,
			boolean externa, String fechaRI) throws SQLException {
		try {
			ArrayList listaGuias = new ArrayList();

			// Verifica si la confirmacion viene de una mensajeria externa
			if (externa) {

				listaGuias = getListaCasamientosMsgExterna(entregaForma
						.getIdGuia());

			} else {
				listaGuias = getListaCasamientos(entregaForma.getIdGuia());
			}

			EntregaForm entrega;
		
			// Barre todas las guias encontradas para el registro
			for (int i = 0; i < listaGuias.size(); i++) {
				// Obtiene los datos del envio en el cast viene ya implicito en
				// IdEnvio
				entrega = (EntregaForm) listaGuias.get(i);

				entrega.setIsRegistro(entregaForma.isRegistro()); 
				// Actualiza los datos de la confirmacion
				entrega.setCencap(entregaForma.getOrigen());
				entrega.setDestino(entregaForma.getSiglasPlaza());
				entrega.setIdRuta(entregaForma.getIdRuta());
				entrega.setQuienRecibe(entregaForma.getQuienRecibe());
				entrega.setFecha(entregaForma.getFecha());
				entrega.setNumEmpleado(entregaForma.getNumEmpleado());
				entrega.setIdFirma(entregaForma.getIdFirma());
				// inserta el registro en la DB
				insertConfirmacion(entrega);
				//envioDao.updateEstadoRegistro(entrega.getIdGuia(),
				//		Envio._entregado);

				if (fechaRI != null) {
					// Acrtualiza la fecha de creacion
					//envioDao.updateFechaCreacion(entrega.getIdGuia(),
					//		FechasTimeStamp.setTimestamp(fechaRI, 1));
				}
			}
		} catch (SQLException sq) {
			debug("Excepcion en la confirmacion casamiento-->"
					+ sq.getMessage());
			throw sq;
		} finally {

		}
	}// fin de insertConfirmaCasamiento
	
	/**
	 * Obtiene una lista de instancia s de Confirmaciones pendientes con
	 * respecto a una guia de casamiento que se encuentren dentro de la tabla de
	 * casamientos y cuyos primeros caracteres sean igual a la guia de
	 * casamiento indicada
	 * 
	 * @param casamiento
	 * @throws SQLException
	 * @return
	 */
	public java.util.ArrayList getListaCasamientosMsgExterna(String casamiento)
			throws SQLException {
		ArrayList lista = new ArrayList();

		if (casamiento == null) {
			return lista;
		} 

		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		Connection cnx = null;
		Hashtable ht = new Hashtable();
		Conexion conexion = new Conexion(this.db);
		try {
			// Si el identificador de la ruta es null obtiene todos los mensajes
			// para
			// ser despleados en pantalla
			sb.append("SELECT IdGuia,ceOrigenRegistro,plSiglasPlaza,Ruta");
			sb.append(" FROM  Casamiento WHERE IdCasamiento LIKE '"
					+ casamiento + "%'");
			sb.append(" ORDER BY  IdGuia");

			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sb.toString());

			// ps.setString(1,casamiento);

			// Obtiene los datos en el result set
			rs = ps.executeQuery();
			EntregaForm entregaVo;
			while (rs.next()) {
				lista.add(new EntregaForm(rs.getString(1), null, 0, 0));
			}// fin del while

		} catch (SQLException sq) {
			throw sq;
		} finally {
			// Libera los recursos
			conexion.closeRecursos(null, ps, cnx);
		}

		return lista;
	}// fin degetListaCasamientos

	/**
	 * Obtiene una lista de instancia s de Confirmaciones pendientes de una ruta
	 * indincada por el usuario estas se obtienen de la vista de viewSalidasSin
	 * Confirma especifico o todos cuando la ruta es null.
	 * 
	 * @param o
	 *            instancia del objeto procesado
	 * @return un arreglo con las instancias obtenidas
	 */
	public java.util.ArrayList getListaConfimaciones(Object o)
			throws SQLException {
		ArrayList lista = new ArrayList();

		EntregaForm forma = (EntregaForm) o;

		if (forma == null) {
			return lista;
		}

		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		Connection cnx = null;
		Hashtable ht = new Hashtable();
		Conexion conexion = new Conexion(this.db);

		// Si no se capturo fecha fin, se inicializa con la fecha del dia
		// seleccionado por el usuario
		if (forma.getFechafin() == null) {
			forma.setFechafin(forma.getFecha());
		}
		try {

			sb.append("SELECT IdGuia,CONVERT(VARCHAR(10), FechaEvento,103),");
			sb.append("datePart(hh,FechaEvento),datePart(mi,FechaEvento)");
			sb.append(" FROM  Movimientos WHERE Ruta =? AND ");
			sb.append(" FechaEvento>= ? AND FechaEvento<=? AND ");
			sb.append(" tiRegistro IN ( '2','15' ) ORDER BY  IdGuia  ");

			cnx = conexion.getConexion();

			ps = cnx.prepareStatement(sb.toString());

			ps.setString(1, forma.getIdRuta());
			ps.setString(2, forma.getFecha());
			ps.setString(3, forma.getFechafin());

			// Obtiene los datos en el result set
			rs = ps.executeQuery();
			EntregaForm entregaVo;
			//EnvioDao envioDao = new EnvioDao();
			while (rs.next()) {

				entregaVo = new EntregaForm(rs.getString(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4));
				// debug("entregaVo.getIdGuia():"+ entregaVo.getIdGuia());

				// TODO: verificar si se debe checar si la confirmacion esta en
				// la vista de devoluciones
				if (getConfirmacion(entregaVo.getIdGuia())) {
					// Verifica si el registro no esta ya dado de alta
					if (!ht.containsKey(entregaVo.getIdGuia())) {
						// Verifica que la guia no sea null
						if (entregaVo.getIdGuia() != null) {
							debug("agrego guia:" + entregaVo.getIdGuia());
							// Busca si la guia de cobex tiene una guia de
							// enlace
							if ((forma.getCabecera_incluye() == forma.CABECERA_AMBAS)
									|| (forma.getCabecera_incluye() == forma.CABECERA_GUIA_ENLACE)) {
								entregaVo
										.setIdGuiaEnlace(getIdCasamiento(entregaVo
												.getIdGuia()));
							}
							// Agrega la guia a la lista
							lista.add(entregaVo);
						}
					}// Fin de la verificacion de datos
					ht.put(entregaVo.getIdGuia(), entregaVo.getIdGuia());

				}// Fin de verificación de confirmacion

			}// fin del while

			// Si el identificador de la ruta es null obtiene todos los mensajes
			// para
			// ser despleados en pantalla
			StringBuffer sb1 = new StringBuffer();
			sb1.append("SELECT IdGuia,CONVERT(VARCHAR(10), FechaEvento,103),");
			sb1.append("datePart(hh,FechaEvento),datePart(mi,FechaEvento)");
			sb1
					.append(" FROM Movimientos WHERE Ruta =? AND CONVERT(VARCHAR(10), FechaEvento,101)>= ?  AND ");
			sb1.append(" CONVERT(VARCHAR(10), FechaEvento,101)<= ?  AND ");
			sb1.append(" tiRegistro IN ( '2','15' ) ORDER BY  IdGuia ");
			ps = cnx.prepareStatement(sb1.toString());

			ps.setString(1, forma.getIdRuta());
			ps.setString(2, forma.getFecha());
			ps.setString(3, forma.getFechafin());

			// debug(sb1.toString());
			// debug("forma.getIdRuta():"+forma.getIdRuta());
			// debug("forma.getFecha():"+forma.getFecha());
			// debug("forma.getFechafin():"+forma.getFechafin());

			// Obtiene los datos en el result set
			rs = ps.executeQuery();
			while (rs.next()) {

				entregaVo = new EntregaForm(rs.getString(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4));
				// debug("entregaVo.getIdGuia():"+ entregaVo.getIdGuia());
				// Verifica si la guia no se ha agregado a la lista
				if (!ht.containsKey(entregaVo.getIdGuia())) {
					// Si no se ha agregado vierifica si la guia no tiene
					// confirmacion
					if (getConfirmacion(entregaVo.getIdGuia())) {
						// Verifica si el registro no esta ya dado de alta
						// debug("agrego guia:"+ entregaVo.getIdGuia());
						// Verifica que la guia no sea null
						if (entregaVo.getIdGuia() != null) {

							// Busca si la guia de cobex tiene una guia de
							// enlace
							if ((forma.getCabecera_incluye() == forma.CABECERA_AMBAS)
									|| (forma.getCabecera_incluye() == forma.CABECERA_GUIA_ENLACE)) {
								entregaVo
										.setIdGuiaEnlace(getIdCasamiento(entregaVo
												.getIdGuia()));
							}
							// Agrega la guia a la lista
							lista.add(entregaVo);
						}
					}// Fin de la verificacion de datos en confirmaciones
					// Agrega la guia en la lista para no duplicarla
					ht.put(entregaVo.getIdGuia(), entregaVo.getIdGuia());

				}// Fin de la verficiacion de la guia en la lista del MAP

			}// fin del while

		} catch (SQLException sq) {
			throw sq;
		} finally {
			// Libera los recursos
			conexion.closeRecursos(null, ps, cnx);
		}

		return lista;
	}// fin de getListaRegistro
	
	
	/**
	 * Obtiene la guia de casamiento de un envio, en caso de no encontrar
	 * devuelve la guia original
	 * 
	 * @param idguia
	 *            guia original
	 * @throws SQLException
	 * @return si la encuentra la guia de enlace, en caso contrario devuelve la
	 *         guia original
	 */
	public String getIdCasamiento(String idguia) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		Connection cnx = null;
		String guia_enlace = ".";
		Conexion conexion = new Conexion(this.db);
		
		try {
			// Si el identificador de la ruta es null obtiene todos los mensajes
			// para ser despleados en pantalla
			sb.append("SELECT IdCasamiento FROM Casamiento WHERE IdGuia=? ");

			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sb.toString());

			ps.setString(1, idguia);

			// Obtiene los datos en el result set
			rs = ps.executeQuery();
			while (rs.next()) {
				guia_enlace = rs.getString(1);
			}

		} catch (SQLException sq) {
			throw sq;
		} finally {
			// Libera los recursos
			conexion.closeRecursos(rs, ps, cnx);
		}

		return guia_enlace;
	}// fin de getListaRegistro

	/**
	 * Obtiene los datos de la confirmacion
	 * 
	 * @param idGuia
	 * @throws SQLException
	 * @return
	 */
	public boolean getConfirmacion(String idGuia) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cnx = null;
		String sql = "SELECT * FROM Confirma WHERE IdGuia=?";
		Conexion conexion = new Conexion(this.db);

		try {
			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sql);
			ps.setString(1, idGuia);
			rs = ps.executeQuery();
	
			while (rs.next()) {

				return true;
			}// fin del while
		} catch (SQLException sq) {
			debug("Ocurrio un error getConfirmacion -->" + sq.getMessage());
			throw sq;
		} finally {
			// Cierra recursos
			conexion.closeRecursos(rs, ps, cnx);
		}
		return false;
	}// fin de getEnvio

	
	/**
	 * Obtiene una lista de instancia s de Confirmaciones pendientes con
	 * respecto a una guia de casamiento que se encuentren dentro de la vista de
	 * viewSalidasSinConfirma
	 * 
	 * @param casamiento
	 * @throws SQLException
	 * @return
	 */
	public java.util.ArrayList getListaCasamientos(String casamiento)
			throws SQLException {
		ArrayList lista = new ArrayList();

		if (casamiento == null) {
			return lista;
		}

		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		Connection cnx = null;
		Hashtable ht = new Hashtable();
		Conexion conexion = new Conexion(this.db);
		try {
			// Si el identificador de la ruta es null obtiene todos los mensajes
			// para
			// ser despleados en pantalla
			sb.append("SELECT IdGuia");
			sb.append(" FROM  Casamiento WHERE IdCasamiento=? ");
			sb.append(" ORDER BY  IdGuia");

			cnx = conexion.getConexion();

			ps = cnx.prepareStatement(sb.toString());
			ps.setString(1, casamiento);

			// Obtiene los datos en el result set
			rs = ps.executeQuery();
			EntregaForm entregaVo;
			while (rs.next()) {
				lista.add(new EntregaForm(rs.getString(1), null, 0, 0));
			}// fin del while

		} catch (SQLException sq) {
			throw sq;
		} finally {
			// Libera los recursos
			conexion.closeRecursos(rs, ps, cnx);
		}

		return lista;
	}// fin de
	
	
	/**
	 * Obtiene los numeros de documentos para poder agregar la confirmacion de acuerdo 
	 * al numero de cliente y el numero de factura indidcado
	 * 
	 * @param factura
	 * @param numcte        
	 * @throws SQLException
	 * @return arreglo 
	 */
	public ArrayList<String> getDocumentosFactura(String factura,String numcte) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		Connection cnx = null;
		
		 ArrayList<String> arr_documentos = new  ArrayList<String>(); 
		Conexion conexion = new Conexion(this.db);
		
		try {
			sb.append("select * from cadocumentos where factura=? AND numcliente=? ");

			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sb.toString());

			ps.setString(1, factura);
			ps.setString(2, numcte);

			// Obtiene los datos en el result set
			rs = ps.executeQuery();
			while (rs.next()) {
				arr_documentos.add(rs.getString("iddocumento"));
			}

		} catch (SQLException sq) {
			throw sq;
		} finally {
			// Libera los recursos
			conexion.closeRecursos(rs, ps, cnx);
		}

		return arr_documentos;
	}// fin de getDocumentosFactura
	
	
	/**
	 * Obtiene una lista de todas las guias casadas con una guia de casamiento
	 * en la tabla de Casamiento
	 * 
	 * @param casamiento
	 * @throws SQLException
	 * @return
	 */
	public java.util.ArrayList<String> getListaGuiasCasadas(String casamiento)
			throws SQLException {
		ArrayList<String> lista = new ArrayList<String>();

		if (casamiento == null) {
			return lista;
		} 

		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		Connection cnx = null;
	
		Conexion conexion = new Conexion(this.db);
		try {
			// Si el identificador de la ruta es null obtiene todos los mensajes
			// para
			// ser despleados en pantalla
			sb.append("SELECT IdGuia,ceOrigenRegistro,plSiglasPlaza,Ruta");
			sb.append(" FROM  Casamiento WHERE IdCasamiento = '"
					+ casamiento + "'");
			sb.append(" ORDER BY  IdGuia");

			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			EntregaForm entregaVo;
			while (rs.next()) {
				lista.add(rs.getString("IdGuia"));
			}// fin del while

		} catch (SQLException sq) {
			throw sq;
		} finally {
			// Libera los recursos
			conexion.closeRecursos(null, ps, cnx);
		}

		return lista;
	}// fin getListaGuiasCasadas

	
	

}
