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
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.studentapp.model.Address;
import com.studentapp.model.Course;
import com.studentapp.model.Gadgets;
import com.studentapp.model.Student;
import com.studentapp.service.CourseService;
import com.studentapp.service.StudentService;

@SpringBootApplication
@EnableJpaAuditing
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
		Address address= new Address(10,"Bangalore","Kar");
//		
		List<Gadgets> gadgetList =  Arrays.asList(
					new Gadgets(1024,"mobile","X450"),new Gadgets(1025,"Xbox","P190"));
		Set<Gadgets> gadgets = new HashSet<>(gadgetList);
//		
		Course course1 = new Course("SASS",103,9000);
		Course course2 = new Course("Bootstrap",104,7000);
//////		Course course3 = new Course("node",92,3000);
		Set<Course> courseList = new HashSet(Arrays.asList(course1,course2));
////		
//		Course course1 = courseService.findById(102);
//		Course course2 = courseService.findById(101);
//		Set<Course> courseList = new HashSet(Arrays.asList(course1,course2));
//		
		Student student = new Student("Revathy",110,address,gadgets, courseList);
		studentService.addStudent(student);
		
		studentService.updateStudent(105, "Samuel");
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
