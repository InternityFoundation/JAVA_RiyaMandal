package com.basepackage.dao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.basepackage.bean.Csv;
import com.basepackage.utility.DbConnection;



public class InsertDatabaseImpl implements InsertDatabase  {
	public void insertValue(List<Csv> csvList){ 
		try
		{
			Connection con=new DbConnection().buildConnection();
			String sql = "insert  into riyaco(username, password,job_status,company) "+" values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
		// data store		
		
		for(Csv element: csvList) {
			//insert
			stmt.setString(1, element.getUsername());
			stmt.setString(2, element.getPassword());
			stmt.setString(3, element.getJob_status());
			stmt.setString(4, element.getCompany());
			stmt.executeUpdate();
		
		}
		System.out.println("DATA INSERTED");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    } 
} 

