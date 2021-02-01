package com.empapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@EntityListeners(EmpAuditListener.class)
//JPA entity listener to capture saving and updating data

public class Employee extends Auditable<String>{

	String empName;
	@Id
	Integer empId;
	double salary;
	
	// Using entity lifecycle methods
//	@PrePersist
//	public void onPrePersist() {
//		audit("before","inserting");
//	}
//	@PostPersist
//	public void onPostPersist() {
//		audit("after","inserting");
//	}
//	@PreUpdate
//	public void onPreUpdate() {
//		audit("before","updating");
//	}
//	@PostUpdate
//	public void onPostUpdate() {
//		audit("after","updating");
//	}
//	@PreRemove
//	public void onPreRemove() {
//		audit("before","removing");
//	}
//	@PostRemove
//	public void onPostRemove() {
//		audit("after","removing");
//	}
//	
//	public void audit(String type, String operation) {
//		System.out.println(type+" "+operation);
//	}
	
}
