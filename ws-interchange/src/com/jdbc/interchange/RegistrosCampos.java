/* $Id:  $
 *
 * Nombre del Proyecto: Captura de Confirmaciones
 * Nombre del Programa: ConfirmacionDAO.java
 * Responsable: Adrian Morales Ruaro
 * Descripcion: metodos genericos para accesar a la base de datos
 *
 * $Log: $
 */

package com.jdbc.interchange;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mensajeria.forms.CampoInfo;
import mensajeria.forms.RegistroInfo;

import com.debug.utils.ArrayUtilsStr;
import com.debug.utils.DebugLog;


/**
 * Implementa los metodos genericos con los que se procesa la informacion en
 * alguna tabla de la base de datos
 *
 * @author AMR,
 * @version $Id:  $
 */
public class RegistrosCampos{
	
	private String db=null;
	
	/** Creates a new instance of MensajeDAO */
    public RegistrosCampos(String db) {
    	this.db=db;
    }//fin de

    /*
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
        DebugLog.debug(this.getClass(), mensaje);
    }//fin de debug
    
    /**
     * Borra un registro de la DB, dado un identificador
     * @param o instancia del objeto procesado
     * @return la cantidad de registros afectado
     */
    public int delete(Object o) throws SQLException{
        return 0;
    }//fin de delete
    
    /**
     * Inserta un registro de confirmación en la base de datos
     * @param o instancia del objeto procesado
     * @return la cantidad de registros afectado
     */
    public int insert(RegistroInfo o)
    throws SQLException{
        
        return 0;
        
    }//fin de inserts
    
    /**
     * Obtiene los datos de la estadistica para una plaza o todas de acuerdo 
     * a la solicitud del usuario, muestra los datos envueltos en un arreglo 
     * con instancias de RegistroInfo, los datos son agrupados por Plaza,Servidor
     * y solo deben de perftenecer al cliente indicado
     * 
     */
    public ArrayList getEstadisticaCarga(RegistroInfo o,String display){
    	ArrayList arr_estadisticas = new ArrayList();
    	
    	PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cnx = null;
		Conexion conexion = new Conexion(this.db);
		String sql = "SELECT * FROM bitacora_resumen_agregadori WHERE IdPropietario=? AND Plaza=? AND DiaCarga=? ";
		
		if (display!=null){
			if (!display.trim().equals("all")){
				sql += " AND Servidor=? " ;
			}	
		}else{
			sql += " AND Servidor=? " ;
		}
		
		sql+= " ORDER BY Servidor,Plaza ";
		
		try {
			
			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sql);
			
			
			ps.setString(1, o.get_idpropietario());
			ps.setString(2, o.get_plaza());
			Calendar cal = Calendar.getInstance();
			java.sql.Date fecha = 
			       new java.sql.Date( cal.getTime().getTime() );
			
			ps.setDate(3,fecha);
			
			if (display!=null){
				if (!display.trim().equals("all")){
					ps.setString(4, o.get_servidor());
				}	
			}else{
				ps.setString(4, o.get_servidor());
			}

			rs = ps.executeQuery();
			RegistroInfo info = null;
			//TiposRegistros daoTipoRegistros =  new TiposRegistros();
			
			while (rs.next()) {
				 info = new RegistroInfo();
				 info.set_idpropietario(rs.getString("IdPropietario"));
				 info.set_plaza(rs.getString("Plaza"));
				 info.set_servidor(rs.getString("Servidor"));
				 info.setCantidad(rs.getInt("Cantidad"));
				 info.setDiaCarga(rs.getString("DiaCarga"));
				 
				 //Obtiene los datos del registro
				 //GeneralForm forma = daoTipoRegistros.getInfoRegistro(rs.getString("TipoRegistro"));
				 
				 //if (forma!=null){
				//	 info.set_idRegistro(rs.getString("TipoRegistro") + "-" + forma.getDescripcion());
				 //}else{
				//	 info.set_idRegistro(rs.getString("TipoRegistro") + "- INDEFINIDO" );
				 //}
				 
				 
				 
				 //Guarda el registro en la base de datos
				 arr_estadisticas.add(info);
   
			}// fin del while
		} catch (SQLException sq) {
			debug("Ocurrio un error getEstadisticaCarga-->" + sq.getMessage());
		} finally {
			// Cierra recursos
			conexion.closeRecursos(rs, ps, cnx);
		}
    	
    	return arr_estadisticas;
    	
    }//fin de getEstadisticaCarga
    
   
    /***
	 * Inserta el registro que se esta procesando, en esta tabla solamente se insertan los registgros que fueron 
	 * validados de forma correcta y que por alguna razon no se pudieron insertar en la base de datos indicada
     * @param registro
     * @param configuracion
     * @param estatus si la bandera de estatus=true quiere decir que la solicitud es de replicacion por  lo que 
     * los regisrtos se marcan como transmitidos=true para que no se envia replicacion nuevamente, si estatus=false
     * queiere decir que la transmision no viene de una replicacion
     * @param msgstatus
     * @param tipoerror
     */
    public void insertRegistroEstatus(String registro,String[] configuracion,boolean estatus,String msgstatus,String tipoerror ){
    	PreparedStatement ps = null;
		ResultSet rs = null;

		String sql_insert = " INSERT INTO bitacora_registros_procesados("+
	           " plazaenvia, servidor, cliente, archivo, transmitido, registro, "+
	           " fechaproceso, guia, msgstatus, tipoerror,tiporegistro)"+
	           " VALUES (?, ?, ?, ?, ?, ?,  current_timestamp, ?, ?, ?,?)";
		
   		
		Conexion conexion = new Conexion(this.db);
		Connection cnx = null;
		try {
			//Se toma la conexión a la base de datos utilerias 
			String[] arr_elementos = registro.split("\\|");
			
			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sql_insert);
			
			int index = 1;
			ps.setString(index++, ArrayUtilsStr.getValorArreglo(configuracion,0));
			ps.setString(index++, ArrayUtilsStr.getValorArreglo(configuracion,1));
			ps.setString(index++, ArrayUtilsStr.getValorArreglo(configuracion,2));
			ps.setString(index++, ArrayUtilsStr.getValorArreglo(configuracion,3));
			ps.setBoolean(index++, estatus);
			ps.setString(index++, registro);
			ps.setString(index++, ArrayUtilsStr.getValorArreglo(arr_elementos, 1));
			ps.setString(index++, msgstatus);
			ps.setString(index++, tipoerror);
			ps.setString(index++,  ArrayUtilsStr.getValorArreglo(arr_elementos,0));

			ps.executeUpdate(); 

		} catch (SQLException sq) {
			debug("Error al insertar insertRegistroEstatus-->" + sq.getMessage());
			// throw sq;
		}finally {
			// Cierra recursos
			conexion.closeRecursos(null, ps, cnx);
		}

		
    }
    
    /**
     * Incrementa la estadistica de agregado, primero trata de realizar el update
     * en caso de que no se pueda realizar se realiza un insert
     */
    public int insertEstadisticasCarga(RegistroInfo o)throws SQLException{
    	PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		// IdGuia ,NumCliente,IdAdicional,IdGarantia,IdFormato,IdServicio,
		// Comentario,FechaCreacion, Estado,Referencia,Login,Factura,Monto
		String sql_insert = "INSERT INTO bitacora_resumen_agregadori  VALUES(?,?,?,?,?,?)";
		String sql_update = "UPDATE  bitacora_resumen_agregadori  SET Cantidad=Cantidad+1  WHERE IdPropietario=? AND" +
				" Servidor=? AND  TipoRegistro=? AND Plaza=? AND DiaCarga=? ";
		Conexion conexion = new Conexion(this.db);
		Connection cnx = null;
		try {
			
			//Se toma la conexión a la base de datos utilerias 
			
			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sql_update);
			// envio.setIdEnvio(getConsecutivo());

			ps.setString(1, o.get_idpropietario());
			ps.setString(2, o.get_servidor());
			ps.setString(3, o.get_idRegistro());
			ps.setString(4, o.get_plaza());
			
			Calendar cal = Calendar.getInstance();
			java.sql.Date fecha = 
			       new java.sql.Date( cal.getTime().getTime() );
			
			ps.setDate(5,fecha);
			int  reg_cant = ps.executeUpdate();
			debug("reg_cant-->" + reg_cant);
			//Si no existe agrega un nuevo registro
			if ( reg_cant<= 0){
			    debug("ejecutando-->" + sql_insert);
			    debug("o.get_idpropietario()-->" + o.get_idpropietario());
			    debug("o.get_servidor()-->" + o.get_servidor());
			    debug("o.get_idRegistro()-->" + o.get_idRegistro());
			    debug("fecha-->" + fecha);
			    debug("o.get_plaza()-->" + o.get_plaza());  
			    
				ps = cnx.prepareStatement(sql_insert);
				ps.setString(1, o.get_idpropietario());
				ps.setString(2, o.get_servidor());
				ps.setString(3, o.get_idRegistro());
				ps.setDate(4,fecha);
				ps.setString(5, o.get_plaza());
				ps.setInt(6, 1);
				return ps.executeUpdate(); 
			}

		} catch (SQLException sq) {
			debug("Error al insertar datos envio-->" + sq.getMessage());
			// throw sq;
		}finally {
			// Cierra recursos
			conexion.closeRecursos(null, ps, cnx);
		}

		return 0;
    }
    
    /**
     *  Obtiene los datos de un registro de informacion y los datos del campos que esta asocido a el
     * @param identificador del registro
     * @throws SQLException
     * @return instancia  de RegistroInfo y los campos asociados a el o null en caso de no encontrar datos
     */
    public RegistroInfo getRegistroInfo(String idreg)
    throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb_reg = new StringBuffer();
        Connection cnx = null;
        Conexion conexion = new Conexion(this.db);
      // debug("Buscando getRegistroInfo->"+idreg);
        try{
            
            sb_reg.append("SELECT  IdRegistro,Descripcion,lower(Estructura),ClaseDespacha");
            sb_reg.append("  FROM InfoRegistros WHERE IdRegistro=? " );
			
			cnx = conexion.getConexion();
			
            ps = cnx.prepareStatement(sb_reg.toString());
            
            //debug("Buscando getRegistroInfo->"+idreg);
            
            ps.setString(1,idreg);
            
            //Obtiene los datos en el result set
            rs= ps.executeQuery();
            RegistroInfo registro = null;
            
            while (rs.next()){
                registro = new RegistroInfo();
                //debug("IdRegistro:" + rs.getString(1));
                //debug("Descripcion:" + rs.getString(2));
                //debug("Estructura:" + rs.getString(3));
                //debug("Clase:" + rs.getString(4));

                registro.set_idRegistro(rs.getString(1));
                registro.set_descripcion(rs.getString(2));
                registro.set_estructura(rs.getString(3));
                registro.setClaseUpdateInsert(rs.getString(4));
            }
            
            //Verifica si existe el registro
            if (registro!=null){
                String[] campos =  registro.get_estructura().split("\\|");
                CampoInfo campo = null;
                for (int i=1;i<campos.length;i++){
                  //  debug("Este es el registro a buscar:" + campos[i]);
                    campo = getCampoInfo(campos[i]);
                    
                    if (campo!=null){
                        registro.addCampo(campo);
                    }//fin del agregado del campo
                }//fin del for
            }//fin del if de campos
            
            return registro;
            
        } catch (SQLException sq) {
            debug("getRegistroInfo->Error al obtener los datos del registro "+ sq.getMessage());
            throw sq;
        } finally {
            //Libera los recursos
        	conexion.closeRecursos(rs, ps, cnx);
        }
        
        
    }//fin de getRegistroInfo
    
    public List<RegistroInfo> getTodoslosRegistrosDelTipo(String idreg)
	    throws SQLException{
	        
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        StringBuffer sb_reg = new StringBuffer();
	        Connection cnx = null;
	        Conexion conexion = new Conexion(this.db);
	        List<RegistroInfo> arr_registros = new ArrayList<RegistroInfo>();
	        List<RegistroInfo> arr_registros_final = new ArrayList<RegistroInfo>();
	        
	      // debug("Buscando getRegistroInfo->"+idreg);
	        try{
	            
	            sb_reg.append("SELECT  IdRegistro,Descripcion,lower(Estructura),ClaseDespacha");
	            sb_reg.append("  FROM InfoRegistros WHERE IdRegistro=? " );
				
				cnx = conexion.getConexion();
				
	            ps = cnx.prepareStatement(sb_reg.toString());
	            
	            //debug("Buscando getRegistroInfo->"+idreg);
	            
	            ps.setString(1,idreg);
	            
	            //Obtiene los datos en el result set
	            rs= ps.executeQuery();
	            RegistroInfo registro = null;
	            String[] campos =  null;
	            while (rs.next()){
	                registro = new RegistroInfo();
	               

	                registro.set_idRegistro(rs.getString(1));
	                registro.set_descripcion(rs.getString(2));
	                registro.set_estructura(rs.getString(3));
	                registro.setClaseUpdateInsert(rs.getString(4));
	                campos =  registro.get_estructura().split("\\|");
	                registro.setLargo(campos.length);
	                
	                arr_registros.add(registro) ;
	            }
	            
	            //Obtiene todos los campos para cada registro encontrado
	            for (RegistroInfo rec : arr_registros) {
	        	 if (rec!=null){
		               // String[] campos =  registro.get_estructura().split("\\|");
		        	campos =  rec.get_estructura().split("\\|");
		                CampoInfo campo = null;
		                for (int i=1;i<campos.length;i++){
		                  //  debug("Este es el registro a buscar:" + campos[i]);
		                    campo = getCampoInfo(campos[i]);
		                    
		                    if (campo!=null){
		                	rec.addCampo(campo);
		                    }//fin del agregado del campo
		                }//fin del for
		              
		                arr_registros_final.add(rec);
		         }//fin del if de campos
		    }
	           
	            
	            return arr_registros_final;
	            
	        } catch (SQLException sq) {
	            debug("getRegistroInfo->Error al obtener de los registros "
	            	+  idreg + ": "+ sq.getMessage());
	            throw sq;
	        } finally {
	            //Libera los recursos
	        	conexion.closeRecursos(rs, ps, cnx);
	        }
	        
	        
	    }//fin de getRegistroInfo
    
    /**
     *  Obtiene los datos campo
     * @param identificador del campo
     * @throws SQLException
     * @return instancia  de CampoInfo o null en caso de no encontrar datos
     */
    public CampoInfo getCampoInfo(String id)
    throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb_reg = new StringBuffer();
        Connection cnx = null;
        Conexion conexion = new Conexion(this.db);
        try{
            
            sb_reg.append("SELECT  lower(Nombre), Descripcion,Validacion,MensajeError");
            sb_reg.append("  FROM InfoCampos WHERE  lower(Nombre)=? " );
          
			cnx = conexion.getConexion();
            ps = cnx.prepareStatement(sb_reg.toString());
            
            //System.out.println("Campos:" + id);
            
            ps.setString(1,id);
            
            //Obtiene los datos en el result set
            rs= ps.executeQuery();
            CampoInfo campo = null;
            
            while (rs.next()){
                campo = new CampoInfo();
                campo.set_idCampo(rs.getString(1));
                campo.set_descripcion(rs.getString(2));
                campo.set_validacion(rs.getString(3));
                campo.set_mensaje_error(rs.getString(4));
            }
            return campo;
            
        } catch (SQLException sq) {
            System.out.println("getCampoInfo->Error al obtener los datos del registro "+ sq.getMessage());
            
            throw sq;
        } finally {
            //Libera los recursos
        	conexion.closeRecursos(rs, ps, cnx);
        }
        
        
    }//fin de getCampoInfo
    
    
}//fin de ConfirmacionDAO
