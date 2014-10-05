package edu.umd.enpm613.impl;
import java.sql.*;
public class DatabaseHelper {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/elms";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   Connection conn = null;
	   Statement stmt = null;
	
	public Connection makeConnection(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		       }
		       
		  
		    catch(SQLException se){
		      
		       se.printStackTrace();
		    }catch(Exception e){
		       //Handle errors for Class.forName
		       e.printStackTrace();

		}
		return conn;
	}

}
