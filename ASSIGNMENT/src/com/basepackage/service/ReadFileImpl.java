package com.basepackage.service;

import java.util.List;
//import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.basepackage.bean.Csv;
import com.basepackage.dao.InsertDatabaseImpl;

public class ReadFileImpl implements ReadFile{
	@Override
 	public void readCsv() 
	{
	
		 //read Csv 
		 List<Csv>  csvList = new ArrayList<>();
		 
		try {
			List<String> lines= Files.readAllLines(Paths.get("F:\\java_riya\\EmployeeInformation.csv"));
			for(String line :lines) {
				String[] result = line.split(",");
				csvList.add(new Csv(Integer.parseInt(result[0]),result[1], result[2],Integer.parseInt(result[3]),result[4],Double.parseDouble(result[5]),result[6]));
			System.out.println(result[0]+":"+result[1]+":"+result[2]+":"+result[3]+":"+result[4]+":"+result[5]+":"+result[6]);
				
				}
			System.out.println(csvList);
			InsertDatabaseImpl id=new 	InsertDatabaseImpl();
		//insert
				//id.insertValue(csvList);
		//fetch
				//id.fetchValue();
		//streams filter
			//id.streamFetch();
			
		//delete record
			id.deleteValue();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
 }
	}