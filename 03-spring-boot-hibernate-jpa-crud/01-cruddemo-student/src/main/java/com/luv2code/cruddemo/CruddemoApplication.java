package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{
			createMultipleStudents(studentDAO);
		};

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating 3 student objects...");
		Student tempStudent1=new Student("Doe","paul@gmail.com","Paul");
		Student tempStudent2=new Student("Public","mary@gmail.com","Mary");
		Student tempStudent3=new Student("Applebum","Apple@gmail.com","Bonita");


		//save the student object
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}


	private void createStudent(StudentDAO studentDAO){

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("Doe","paul@gmail.com","Paul");


		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println(("Saved student id:"+tempStudent.getId()));
	}
}
