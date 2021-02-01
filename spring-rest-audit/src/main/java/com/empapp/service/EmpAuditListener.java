package com.empapp.service;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.empapp.model.Employee;

public class EmpAuditListener {

	@PreRemove
	@PrePersist
	@PreUpdate
	public void beforeMethodCall(Object object) {
		System.out.println("called before "+object);
	}
	@PostRemove
	@PostPersist
	@PostUpdate
	public void afterMethodCall(Object object) {
		Employee emp = (Employee)object;
		System.out.println("called after "+emp.getEmpName());
	}
}
