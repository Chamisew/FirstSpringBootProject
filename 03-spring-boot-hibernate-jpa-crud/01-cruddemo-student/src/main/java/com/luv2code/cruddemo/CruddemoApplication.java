package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{

			createMultipleStudents(studentDAO);
			//deleteAllStudent(studentDAO);

		};

	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("Deleted row count:"+numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting student id:" +studentId);
		studentDAO.delete(studentId);


	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id:primary key
		int studentId=1;
		System.out.println("Getting student with id:"+studentId);
		Student myStudent =studentDAO.findById(studentId);



		//change first name of "John"
		System.out.println("Updating Student...");
		myStudent.setFirstName("John");


		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Update student:"+myStudent);

	}



	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudent=studentDAO.findByLastName("Doe");

		//display list of students
		for(Student tempStudent:theStudent){
			System.out.println(tempStudent);
		}


	}





	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents=studentDAO.findAll();

		//display list of students
		for (Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}


	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("Doe","daffy@gmail.com","Daffy");


		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);


		//display id of the saved student
		int theId= tempStudent.getId();
		System.out.println("Saved student .generated id:"+theId);


		//retrieve student based on the id:primary key
		System.out.println("Retrieving student with id:"+theId);
		Student myStudent=studentDAO.findById(theId);


		//display student
		System.out.println("Found the student:"+myStudent);


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
