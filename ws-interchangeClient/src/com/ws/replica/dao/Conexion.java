/**
 * 
 */
package com.ws.replica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.administracion.utils.Log4jUtil;
import com.debug.utils.DebugLog;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class Conexion {

	private String db=null;
	
	/** Conexion a la base de datos. */
    private  Connection cnx = null;
    /**DataSource buscado*/
    private  String JDBC_DATASOURCE = null;
    /**Contexto para encontrar un recurso declarado */
    private  String COMP_ENV = "java:comp/env";
    
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private static void debug(String mensaje){
        //logger.info("Conexion-->" + mensaje);
    	DebugLog.debug("Conexion ", mensaje);
    }//fin de debug
    
	/**
	 * 
	 */
	public Conexion(String db) {
		JDBC_DATASOURCE = "jdbc/" + db;
		//debug("JDBC_DATASOURCE: " + JDBC_DATASOURCE);
	}
	
	
	
	 /**
     * Obtiene una conexion para una operacion transaccional
	 * @return
	 * @throws SQLException
	 */
	public  Connection getInciaConexionTransaccional()
			throws SQLException {
		Connection conn = null;
		try {
			Context init = new InitialContext();
            //debug("1");
            
            Context ctx = (Context) init.lookup(COMP_ENV);
            DataSource ds = (javax.sql.DataSource) ctx.lookup(JDBC_DATASOURCE);
			//InitialContext ini = new InitialContext();
			//DataSource ds = (DataSource) ini.lookup(jndi);
			conn = ds.getConnection();
			BeginTransaction(conn);
		} catch (Exception e) {
			//e.printStackTrace();
			//throw new SQLException(e.getMessage());
			 debug("SQLException-terminaConexionTransaccional:" + e.getMessage());
		}
		return conn;
	}
	
	/**
	 * Termina la conexion transaccional inciada
	 * @param conn
	 * @param exito
	 * @throws SQLException
	 */
	public  void terminaConexionTransaccional(Connection conn, boolean exito)
			 {
		try {
			if (conn != null && !conn.isClosed()) {
				if (exito == true) {
					CommitTransaction(conn);
				} else {
					RollBackTransaction(conn);
				}
				EndTransaction(conn);
				conn.close();
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			 debug("SQLException-terminaConexionTransaccional:" + e.getMessage());
		}
	}
    
    /**
     * Busca el recurso de datasource por medio del JNDI que debe estar declarado
     * en Tomcar jdbc/Mensajeria
     * @throws Exception en caso de no lograr establecer la conexion
     */
    public  Connection getConexion() throws SQLException {
        
        try {
            Context init = new InitialContext();
            Context ctx = (Context) init.lookup(COMP_ENV);
            DataSource ds = (javax.sql.DataSource) ctx.lookup(JDBC_DATASOURCE);
            if (ds != null){
                cnx =  ds.getConnection(); // Obtiene conexion a bd
            }
            
        } catch(Exception e) {
        	debug("Error al realizar la conexion " + e.toString());
            // si hay error cierra cnx
            if (cnx != null) {
                try { cnx.close(); } catch (SQLException sqle) {}
            }

        }
        
        return cnx;
    }
    
    /**
	 * @param conn
	 * @throws SQLException
	 */
	public  void BeginTransaction(Connection conn) throws SQLException {
		try {
			if (conn.getAutoCommit())
				conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param conn
	 * @throws SQLException
	 */
	public  void EndTransaction(Connection conn) throws SQLException {
		try {
			if (!conn.getAutoCommit())
				conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param conn
	 * @throws SQLException
	 */
	public  void CommitTransaction(Connection conn) throws SQLException {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param conn
	 * @throws SQLException
	 */
	public static void RollBackTransaction(Connection conn) throws SQLException {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param conn
	 * @param exito
	 * @throws SQLException
	 */
	public  void closeTransactionConnection(Connection conn, boolean exito)
			{
		try {
			if (conn != null && !conn.isClosed()) {
				if (exito == true) {
					CommitTransaction(conn);
				} else {
					RollBackTransaction(conn);
				}
				EndTransaction(conn);
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 /**
     * Liebera recursos de conexion utrilizados por el sistema
     * @param rs ResultSet
     * @param ps PreparedStatement
     * @param cnx Connection
     */
    public  void closeRecursos(ResultSet rs, PreparedStatement ps,
    Connection cnx) {
        // Cierra resultset
        if (rs != null) {
            try { rs.close(); } catch (SQLException e) { ; }
        }
        
        // Cierra statement
        if (ps != null) {
            try { ps.close(); } catch (SQLException e) { ; }
        }
        
        // Cierra conexion
        if (cnx != null) {
            try { cnx.close(); } catch (SQLException e) { ; }
        }
        
    }
    
    /**
     * Liebera recursos de conexion utrilizados por el sistema
     * @param ps PreparedStatement
     * @param cnx Connection
     */
    public  void closeRecursos(PreparedStatement ps,
    Connection cnx) {
        // Cierra statement
        if (ps != null) {
            try { ps.close(); } catch (SQLException e) { ; }
        }
        // Cierra conexion
        if (cnx != null) {
            try { cnx.close(); } catch (SQLException e) { ; }
        }
    }
    
    /**
     * Liebera recursos de conexion utrilizados por el sistema
     * @param cnx Connection
     */
    public  void closeRecursos(Connection cnx) {
        
        // Cierra conexion
        if (cnx != null) {
            try { cnx.close(); } catch (SQLException e) { ; }
        }
    }

}
