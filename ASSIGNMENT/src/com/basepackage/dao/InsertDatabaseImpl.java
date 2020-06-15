package com.basepackage.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.BiPredicate;
//import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.basepackage.bean.Csv;
import com.basepackage.utility.DbConnection;



public class InsertDatabaseImpl implements InsertDatabase  {
	public void insertValue(List<Csv> csvList){ 
		try
		{
	        Connection con=new DbConnection().buildConnection();
	        String sql = "insert  into employeedetails(EmployeeId, EmployeeName,Job_Status,DeptId,DeptName,Salary,JobLocation) "+" values(?,?,?,?,?,?,?)";
	        PreparedStatement stmt = con.prepareStatement(sql);
			// data store		
			
			for(Csv element: csvList) {	
				//insert
				stmt.setInt(1, element.getEmployeeId());
				stmt.setString(2, element.getEmployeeName());
				stmt.setString(3, element.getJob_Status());
				stmt.setInt(4, element.getDeptId());
				stmt.setString(5, element.getDeptName());
				stmt.setDouble(6, element.getSalary());
				stmt.setString(7, element.getJobLocation());
				stmt.executeUpdate();				
			}
			System.out.println("data inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    } 
	public void fetchValue()
	{
		try
		{
			Connection con=new DbConnection().buildConnection();
	        String sql = "select * from employeedetails where EmployeeId=201011";
	        
	        PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			String EmployeeData="";
			while(rs.next())
			{
				EmployeeData=rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getInt(4)+":"+rs.getString(5)+":"+rs.getDouble(6)+":"+rs.getString(7);
				System.out.println(EmployeeData);
				
				
			}
			stmt.close();
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	public void streamFetch()
	{
		ArrayList<Csv> empList = new ArrayList<Csv>();
		try
		{
			Connection con=new DbConnection().buildConnection();
	        String sql = "select * from employeedetails";
	        
	        PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				empList.add(new Csv(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6),rs.getString(7)));
            }
			System.out.println(empList);
			//STREAM OPERATIONS
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("**********COUNT NO. OF EMPLOYEES SALARIES GREATER THAN 40000**********");
			Long empCount = empList.stream().filter(e -> e.getSalary() > 40000).count();
			System.out.println("NUMBER OF EMPLOYEES HAVING SALARY GREATER THAN 40,000:"+empCount);
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("********** INFORMATION ABOUT EMPLOYEES NAME STARTSWITH A **********");
			List<Csv> nameStartWwith=empList.stream().filter(f->f.getEmployeeName().startsWith("A")).collect(Collectors.toList());
			System.out.println(nameStartWwith);
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("********** INFORMATION ABOUT EMPLOYEES WHOES JOBLOCATION IS MUMBAI**********");
			List<Csv> JobLocation=empList.stream().filter(f->f.getJobLocation().equals("MUMBAI")).collect(Collectors.toList());
			System.out.println("list of employees whoes JobLocation is Mumbai:");
			System.out.println(JobLocation);
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("********** INFORMATION ABOUT EMPLOYEES WHOES SALARY IS IN DESCENDING ORDER(HIGHEST TO LOWEST)**********");
			List<Csv> sortedSalary= empList.stream().sorted((e1, e2) -> -e1.getSalary().compareTo(e2.getSalary())).collect(Collectors.toList());
			System.out.println(sortedSalary);
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("EMPLOYEE HAVING LOWEST SALARY");
			Csv min=empList.stream().min((e1, e2)->e1.getSalary().compareTo(e2.getSalary())).get();
			System.out.println("LOWEST SALARY="+min);
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("EMPLOYEE HAVING HIGHEST SALARY");
			Csv max=empList.stream().max((e1, e2)->e1.getSalary().compareTo(e2.getSalary())).get();
			System.out.println("HIGHEST SALARY="+max);
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			stmt.close(); 	
			}
			        		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	
	
	
	
	
	
	
	public void deleteValue()
	{
		try
		{
			Connection con=new DbConnection().buildConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("PLEASE ENTER THE DETAILS FOR DELETING RECORD:");
			System.out.println("ADMIN USERNAME:");
			String userName=sc.nextLine();
			
			System.out.println("ADMIN ID:");
			int adminId=sc.nextInt();
			
			
			BiPredicate<String,Integer> bp =(a,b)->(a.equals("ADMIN") && b==201030);
			boolean checkAdmin=bp.test(userName,adminId);
			System.out.println(checkAdmin);
			String sql = "delete  from employeedetails where EmployeeId=201015";
			
			if(checkAdmin)
			{
				PreparedStatement stmt = con.prepareStatement(sql);
				
				
				 int affectedRecords = stmt.executeUpdate();
		            System.out.println("Number of deleted records:- " + affectedRecords);
			}
			else
				System.out.println("NOT AN ADMIN");
			sc.close();
		}
				
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
} 