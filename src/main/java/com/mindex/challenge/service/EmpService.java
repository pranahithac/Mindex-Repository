package com.mindex.challenge.service;

import org.springframework.stereotype.Service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.EmployeeResponse;

@Service
public interface EmpService {

	EmployeeResponse getNoOfEmployees(String empId);
	
}
