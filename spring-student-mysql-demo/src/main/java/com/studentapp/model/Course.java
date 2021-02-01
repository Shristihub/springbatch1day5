package com.studentapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Course {
	private String courseName;
	@Id
//	@GeneratedValue(generator = "coursesq", strategy = GenerationType.AUTO)
	private Integer courseId;
	private double cost;
	
}
