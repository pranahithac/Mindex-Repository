package com.mindex.challenge.data;

public class EmployeeResponse {
	
	private String empId;
	private int employeesReports;
	public String getEmpId() {
		return empId;
	}
	public int getEmployeesReports() {
		return employeesReports;
	}
	public void setEmployeesReports(int employeesReports) {
		this.employeesReports = employeesReports;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public EmployeeResponse(String empId, int employeesReports) {
		super();
		this.empId = empId;
		this.employeesReports = employeesReports;
	}
	public EmployeeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
