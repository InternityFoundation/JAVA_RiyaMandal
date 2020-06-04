package com.basepackage.main;

import java.io.FileInputStream; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.util.Properties; 


public class TestConnection {
	public static void main(String[] args) throws Exception { 
        FileInputStream fis=new FileInputStream("lib/jdbc.properties"); 
        Properties p=new Properties (); 
        p.load (fis); 
        String dname= (String) p.get ("JDBCdriver"); 
      //  System.out.println(dname);
        String url= (String) p.get ("JDBCurl"); 
        String username= (String) p.get ("JDBCusername"); 
        String password= (String) p.get ("JDBCpassword"); 
        Class.forName(dname); 
        Connection con = DriverManager.getConnection( 
                url, username, password); 
        Statement stmt = con.createStatement(); 
        ResultSet rs = stmt.executeQuery("select * from InternInformation"); 
        while (rs.next()) { 
            System.out.println(rs.getInt(1) + " " + rs.getString(2)); 
        } 
        rs.close(); 
        stmt.close(); 
        con.close(); 
    } 
} 
