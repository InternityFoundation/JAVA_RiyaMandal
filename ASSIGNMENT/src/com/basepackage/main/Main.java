package com.basepackage.main;
import com.basepackage.service.*;

public class Main {
	public static void main(String[] args) {
			
		ReadFile readCsv = new ReadFileImpl();
         readCsv.readCsv();         
	}
}
