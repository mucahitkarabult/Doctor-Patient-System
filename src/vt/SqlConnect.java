package vt;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnect {
	Connection conn=null;
	public static Connection dbConnector(){
		
		try {

			String user="postgres";
			String pass="root";
			Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Evde_Saglik", user, pass);
			return conn;

			}
	   catch(Exception e)
			{
			return null;
			}
		}

}
