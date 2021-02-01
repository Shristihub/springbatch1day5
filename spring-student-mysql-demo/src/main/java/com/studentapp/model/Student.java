package com.studentapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.studentapp.service.StudentEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(
		name="student.graph",
//		includeAllAttributes = false,
		attributeNodes ={
				@NamedAttributeNode("courses"),
				@NamedAttributeNode("address"),
				@NamedAttributeNode("gadgets")
		})
//@EntityListeners(StudentEntityListener.class)
public class Student extends Auditable<String>{
	private String studentName;
	@Id
	private Integer studentId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)//, fetch = FetchType.EAGER)
	@JoinColumn(name="student_id")
	private Set<Gadgets> gadgets;
	
	@JoinTable(name="student_course",
			joinColumns = @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id"))
	@ManyToMany(cascade = CascadeType.ALL)//, fetch = FetchType.EAGER)
	private Set<Course> courses;



//	@PrePersist
//	public void beforePersist() {
//		audit("before","inserting");
//	}
//	@PostPersist
//	public void afterPersist() {
//		audit("after","inserting");
//	}
//	
//	@PreUpdate
//	public void beforeUpdate() {
//		audit("before","updating");
//	}
//	@PostUpdate
//	public void afterUpdate() {
//		audit("after","updating");
//	}
//	public void audit(String type, String operation) {
//		System.out.println(type+" "+operation);
//	}
//	
//	


}








