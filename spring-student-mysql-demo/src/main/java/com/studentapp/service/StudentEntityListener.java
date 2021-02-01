package com.studentapp.service;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.studentapp.model.Student;

public class StudentEntityListener {
	
	@PrePersist
	@PreUpdate
	@PreRemove
	public void beforeOperation(Object object) {
		Student emp = (Student)object;
		System.out.println("before "+emp);
	}
	@PostPersist
	@PostUpdate
	@PostRemove
	public void afterOperation(Object object) {
		Student emp = (Student)object;
		System.out.println("after "+emp);
	}

}
