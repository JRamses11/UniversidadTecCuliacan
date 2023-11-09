package ProyectoU2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBaseDatos {
	  private static Statement statement= null;
	
      private ConexionBaseDatos() {
    	    String user = "sa";
	        String password = "cruzazul10"; // 

	        String url = "jdbc:sqlserver://localhost:1433;databaseName=Empresa;encrypt=true;trustServerCertificate=true";

	        try {
	            Connection connection = DriverManager.getConnection( url, user, password );    
	            statement=(connection.createStatement());
	            
	        } catch (Exception error) {
	            System.out.println(error.getMessage());
	            return;
	        }
      }

	public static Statement getStatement() {
	     if(statement==null) {
	    	new ConexionBaseDatos();
	     }
	     return statement;
	}

}
