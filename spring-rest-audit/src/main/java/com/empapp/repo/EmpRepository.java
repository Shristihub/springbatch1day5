package com.empapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empapp.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer>{

}
