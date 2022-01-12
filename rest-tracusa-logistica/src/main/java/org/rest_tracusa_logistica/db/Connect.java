package org.rest_tracusa_logistica.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	
	private static Connection conn;
	private static Statement stm;
	private static ResultSet rs;
	
	public static void conectar(){
		try {
			//conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sigemTRS","postgres","tracusabjo");
			//conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tracusabd","postgres","post2012");
			stm  = conn.createStatement(); 
			System.out.println("Conexión iniciada...");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Conexión fallida... " + e.getMessage());
		}
	}
	
	public String initDbConnection()  { 

       //String url1 = "jdbc:postgresql://192.168.110.21:5432/tracusabd"; //QAS
       String url1 = "jdbc:postgresql://172.35.40.66:5432/tracusabd"; //PRD

        org.postgresql.Driver driver1 = new org.postgresql.Driver();
        try {
            Class.forName(driver1.getClass().getName());
            //conn = DriverManager.getConnection(url1, "postgres", "tracusabjo");
            conn = DriverManager.getConnection(url1, "postgres", "post2012");
            stm  = conn.createStatement();
        }
        catch (java.lang.ClassNotFoundException e) {
            return "failure";
        }
        catch (SQLException ex) {
            return "failure";
        }
        return "success";
    }
	
	public static void cerrarConexion() throws SQLException {
		if(conn!=null) {
			conn.close();
			System.out.println("Conexi�n finalizada...");
		}
	}
	
	public static ResultSet select(String consulta) {
		try {
			System.out.println("Ejecutando...");
			rs = stm.executeQuery(consulta);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se pudo ejecutar la consulta");
		}
		return rs;
	}
	
	public static void imprimirRegistros(ResultSet rsSelect) {
		try {
			while (rsSelect.next()) {
				String	 dato = "";
				int columnas = rsSelect.getMetaData().getColumnCount();
				for(int i=1; i <= columnas; i++) {
					dato = dato + " " + ((rsSelect.getObject(i) == null) ? "" : rsSelect.getObject(i).toString());
				}
				System.out.println(dato);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se pueden imprimir los registros...");
		}
	}
	
	public static void insert(String consulta) {
		try {
			System.out.println("Ejecutando...");
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se pudo ejecutar la consulta");
		}
	}
	
	public static void update(String consulta) {
		try {
			System.out.println("Ejecutando...");
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se pudo ejecutar la consulta");
		}
	}
}
