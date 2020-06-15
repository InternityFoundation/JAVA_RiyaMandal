package com.basepackage.bean;

public class Csv {
	
	private  int EmployeeId;
	private  String EmployeeName;
	private String Job_Status;
	private  int DeptId;
	private  String DeptName;
	private  double Salary;
	private  String JobLocation;
	
	public  Csv(int EmployeeId, String EmployeeName, String Job_Status,int DeptId, String DeptName,double Salary, String JobLocation) 
	{
		this.EmployeeId = EmployeeId;
		this.EmployeeName = EmployeeName;
		this.Job_Status = Job_Status;
		this.DeptId = DeptId;
		this.DeptName = DeptName;
		this.Salary = Salary;
		this.JobLocation = JobLocation;
	}
	//setter method
	public void setEmployeeId(int EmployeeId) {
		this.EmployeeId = EmployeeId;
	}
	
	public void setEmployeeName(String EmployeeName) {
		this.EmployeeName = EmployeeName;
	}
	
	public void setJob_Status(String Job_Status) {
		this.Job_Status = Job_Status;
	}
	
	public void setDeptId(int DeptId) {
		this.DeptId = DeptId;
	}
	
	public void setDeptName(String DeptName) {
		this.DeptName = DeptName;
	}
	
	public void setSalary(double Salary) {
		this.Salary = Salary;
	}
	
	public void setJobLocation(String JobLocation) {
		this.JobLocation = JobLocation;
	}
	
	//getter method
	public int getEmployeeId() {
		return EmployeeId;
	}
	
	public String getEmployeeName() {
		return EmployeeName;
	}
	
	public String getJob_Status() {
		return Job_Status;
	}
	
	public int getDeptId() {
		return DeptId;
	}
	
	public String getDeptName() {
		return DeptName;
	}
	
	public Double getSalary() {
		return Salary;
	}
	
	public String getJobLocation() {
		return JobLocation;
	}
		@Override
	public String toString()
	{
		return "Csv[EmployeeId="+ EmployeeId +",EmployeeName="+ EmployeeName + ", Job_Status="+ Job_Status + ",DeptId="+DeptId +",DeptName="+ DeptName + ", Salary="+ Salary + ",JobLocation="+JobLocation +"]";
				 
	}
}