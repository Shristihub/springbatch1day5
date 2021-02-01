package com.studentapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Address;
import com.studentapp.model.Course;
import com.studentapp.model.Gadgets;
import com.studentapp.model.Student;
import com.studentapp.service.CourseService;
import com.studentapp.service.StudentService;

@SpringBootApplication

public class SpringStudentMysqlDemoApplication implements CommandLineRunner{
 
	 @Value("${greetings}")
	 String message;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringStudentMysqlDemoApplication.class, args);
	}

	
	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;
	@Override
	public void run(String... args) throws Exception {
		Address address= new Address(7,"Mangalore","Kar");
//		
		List<Gadgets> gadgetList =  Arrays.asList(
					new Gadgets(1015,"Theatre","X450"),new Gadgets(1016,"Xbox","P190"));
		Set<Gadgets> gadgets = new HashSet<>(gadgetList);
//		
//		Course course1 = new Course("AWS",101,9000);
//		Course course2 = new Course("AI",102,7000);
//////		Course course3 = new Course("node",92,3000);
//		Set<Course> courseList = new HashSet(Arrays.asList(course1,course2));
////		
		Course course1 = courseService.findById(102);
		Course course2 = courseService.findById(101);
		Set<Course> courseList = new HashSet(Arrays.asList(course1,course2));
//		
		Student student = new Student("Vishal",107,address,gadgets, courseList);
		studentService.addStudent(student);
		
		studentService.updateStudent(104, "Thai");
//		
//		studentService.getAllStudents().forEach(System.out::println);
//		studentService.getStudentByCity("Bangalore").forEach((nstudent)-> System.out.println(nstudent.getStudentName()));
//		studentService.getStudentByCourseName("Node").forEach((nstudent)-> {
//				System.out.print(nstudent.getStudentName()+" ");
//				System.out.print(nstudent.getAddress().getCity());
//				System.out.println(nstudent.getGadgets());
//				System.out.println(nstudent.getCourses());
//		});
//		
//		studentService.findByGadgetsCourses("Java","laptop").forEach((nstudent)-> {
//			System.out.print(nstudent.getStudentName()+" ");
//			System.out.print(nstudent.getAddress().getCity());
//			System.out.println(nstudent.getGadgets());
//			System.out.println(nstudent.getCourses());
//	});
////		
//		System.out.println(message);
//		
	}
	

}
