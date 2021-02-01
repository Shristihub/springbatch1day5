package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.dao.StudentRepository;
import com.studentapp.model.Student;

@Service
@Transactional
@Profile("dev")
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	@Override
	public void addStudent(Student student) {
		studentRepo.save(student);
	}

	@Override
	public List<Student> getStudentByCity(String city) {
		return studentRepo.findByAddressCity(city);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	public List<Student> getStudentByCourseName(String courseName){
		return studentRepo.findByCourses(courseName);
	}
	public List<Student> findByGadgetsCourses(String course, String gadgetname){
		return studentRepo.findByGadgetsCourses(course, gadgetname);
	}

	@Override
	public void updateStudent(Integer studentId, String name) {
		Student student = studentRepo.findById(studentId).get();
		student.setStudentName(name);
		studentRepo.save(student);
	}
	
	

}
