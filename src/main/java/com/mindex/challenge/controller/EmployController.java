package com.mindex.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.EmployeeResponse;
import com.mindex.challenge.service.EmpService;

@RestController
public class EmployController {
	
	@Autowired 
	private EmpService empService;

	@GetMapping("/get/employee/{employeeId}")
    public EmployeeResponse read(@PathVariable String employeeId) {
        

		return empService.getNoOfEmployees(employeeId);
    }
}
