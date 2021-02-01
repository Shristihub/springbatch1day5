package com.empapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.model.Employee;
import com.empapp.service.EmpService;

@RestController
public class EmpController {

	@Autowired 
	EmpService empService;  
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return empService.getAllEmployees();
	}
}
