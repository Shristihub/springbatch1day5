package com.empapp.service;

import java.util.List;

import com.empapp.model.Employee;

public interface EmpService {
	void addEmployee(Employee employee);
	Employee getById(Integer id);
	void deleteEmployee(Integer id);
	void updateEmployee(Integer id,double salary);
	List<Employee> getAllEmployees();

}
