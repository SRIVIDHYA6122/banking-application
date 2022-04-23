
package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection 
{
	//Database Connection information
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/bankingapp";
	private static String un="root";
	private static String pass="root";
	private static Connection conn=null;

	static public Connection getConnection() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, un, pass);
			if(conn==null) 
			{
				System.out.println("Error in connection");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}               
		return conn;            
	}


}
