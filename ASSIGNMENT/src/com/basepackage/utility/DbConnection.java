package com.basepackage.utility;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream; 

public class DbConnection {
	public Connection buildConnection()
	{
		Connection con=null;
		try{
			FileInputStream fis=new FileInputStream("lib/jdbc.properties"); 
			Properties p=new Properties (); 
			p.load (fis); 
			String dname= (String) p.get ("JDBCdriver"); 
			//  System.out.println(dname);
			String url= (String) p.get ("JDBCurl"); 
			String username= (String) p.get ("JDBCusername"); 
			String password= (String) p.get ("JDBCpassword"); 
			Class.forName(dname); 
			con = DriverManager.getConnection(url, username, password); 
			System.out.println("connection built");
	}
	catch(Exception e) {
		System.out.println("error");
	}
	return con;

	}
}