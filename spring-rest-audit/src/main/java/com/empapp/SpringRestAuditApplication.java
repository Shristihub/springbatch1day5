package com.empapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.empapp.model.Employee;
import com.empapp.service.EmpService;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
public class SpringRestAuditApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringRestAuditApplication.class, args);
	}
  
	@Autowired 
	EmpService empService;   
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("Mridhu",23,20000);
		empService.addEmployee(employee);
		empService.updateEmployee(21,2000);
//		empService.deleteEmployee(11);
		empService.getAllEmployees().forEach(System.out::println);
		
		
		
		
	}

}
