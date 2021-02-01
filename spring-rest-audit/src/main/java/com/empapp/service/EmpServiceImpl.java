package com.empapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.empapp.model.Employee;
import com.empapp.repo.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepository empRepository;
	
	public void addEmployee(Employee employee) {
		empRepository.save(employee);
		
	}

	public Employee getById(Integer empId) {
		return empRepository.findById(empId).get();
	}

	public void deleteEmployee(Integer id) {
		empRepository.deleteById(id);

	}

	public void updateEmployee(Integer id,double salary) {
		Optional<Employee> optEmp = empRepository.findById(id);
		if(optEmp.isPresent()) {
			Employee emp = optEmp.get();
		    emp.setSalary(salary);
		    empRepository.save(emp);
		}
			
	}

	@Override
	@Cacheable(cacheNames = "employees")
	public List<Employee> getAllEmployees() {
		try {
			Thread.sleep(2000*5);
		}catch(InterruptedException e) {
			
		}
		return empRepository.findAll();
	}

}
