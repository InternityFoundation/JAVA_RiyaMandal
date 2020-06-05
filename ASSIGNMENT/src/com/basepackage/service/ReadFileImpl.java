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
 	public void readCsv() {
	
		 //read Csv 
		 List<Csv>  csvList = new ArrayList<>();
		 
			try {
				List<String> lines= Files.readAllLines(Paths.get("F:\\java ecllipse\\Riya\\emp.csv"));
				for(String line :lines) {
					String[] result = line.split(",");
					csvList.add(new Csv(result[0],result[1], result[2],result[3]));
				//	System.out.println(result[0]+":"+result[1]+":"+result[2]+":"+result[3]);
					
					}
				System.out.println(csvList);
				InsertDatabaseImpl id=new 	InsertDatabaseImpl();
				id.insertValue(csvList);
				}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
 }