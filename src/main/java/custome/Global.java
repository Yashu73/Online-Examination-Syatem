package custome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Global {
	
	StringBuilder sb = new StringBuilder();
	Connection conn = null;
	ResultSet rs=null;
	
 	public static String getConnString()
	{
		return "jdbc:oracle:thin:@localhost:1521/XE";
	}
	public String getConnUsrName()
	{
		return "SOES";
	}
	public String getConnPswd()
	{
		return "SOES";
	}
	
	public static Connection createConnection()
	 {
	     Connection con = null;
	     String url = getConnString();
	     String username = "SOES"; //oracle username
	     String password = "SOES"; //oracle password
	     System.out.println("In DBConnection.java class ");
	      
	     try
	     {
	         try
	         {
	           // Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
	        	 Class.forName("oracle.jdbc.driver.OracleDriver");
	         } 
	         catch (ClassNotFoundException e)
	         {
	            e.printStackTrace();
	         }       
	         con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	         System.out.println("Printing connection object "+con);
	     } 
	     catch (Exception e) 
	     {
	    	 System.out.println("Error in Connection Establishing......");
	        e.printStackTrace();
	     }
	     return con; 
	 }


	public String GetSingleValue(String Query, String ColsNM) {
		try {
			String  Retval="null";
			sb.delete(0, sb.length());
			conn = createConnection();
			Statement stm = conn.createStatement();
			System.out.print("Global Single Method "+Query);
			rs=stm.executeQuery(Query);
			while(rs.next())
			{
				Retval=(rs.getString(ColsNM));								
			}
			conn.close();
			System.out.print("question DAL Inserted");
			return Retval;
		} catch (Exception e) {
			System.out.print(e);
			System.out.print("error getting " + sb);
			e.printStackTrace();
			return "null";
		}
	}
	
	
	
	
}
