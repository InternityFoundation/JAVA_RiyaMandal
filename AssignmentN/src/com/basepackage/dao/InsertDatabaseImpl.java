package com.basepackage.dao;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import com.basepackage.bean.Csv;

public class InsertDatabaseImpl implements InsertDatabase {

	public void insertValue(List<Csv> csvList){
		// connection
			System.setProperty("Jdbc.drivers","com.mysql.jdbc.Driver");
			Properties properties = new Properties();
			properties.put("user", "root");
			properties.put("password", "root");
			String url = "jdbc:mysql://localhost:3306/internity";
			Connection con=null;
			try {
				 con = DriverManager.getConnection(url, properties);
			}
			catch(Exception e) {
				System.out.println("connection error");
			}
			System.out.println("connection established:" +con);
			@SuppressWarnings("unused")
			String sql = "insert data into employee(username, password,job_status,company" + "values(?,?,?,?,?)";
		// data store		
		
		for(Csv csv: csvList) {
			//insert
			csv.getUsername();
			csv.getPassword();
			csv.getJob_status();
			csv.getCompany();
		}
	}
		
}