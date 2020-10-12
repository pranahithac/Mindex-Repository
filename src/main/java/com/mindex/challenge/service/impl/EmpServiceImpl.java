package com.mindex.challenge.service.impl;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.EmployeeResponse;
import com.mindex.challenge.service.EmpService;
import com.mindex.challenge.service.EmployeeService;

@Component
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmployeeService empService;
	
	Employee emp =null;

	@Override
	public EmployeeResponse getNoOfEmployees(String empId) {
		Employee employee= empService.read(empId);
		EmployeeResponse empResponse=new EmployeeResponse();
		empResponse.setEmpId(empId);
		empResponse.setEmployeesReports(getNoOfReporting(employee));
		return empResponse;
		
	}
	
	public int getNoOfReporting(Employee employee) {
		int empCount =0;
		emp= employee.getLastName() != null
                ? employee
                : empService.read(employee.getEmployeeId());
		
		if(emp.getDirectReports() !=null) {

			for (Employee e:emp.getDirectReports()) {
				empCount++;
				empCount += getNoOfReporting(e);
			}
		}
		return empCount;
		
	}
}
