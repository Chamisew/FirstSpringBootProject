package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner->{

			//createInstructor(appDAO);

		 	//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			//deleteInstructorDetail(appDAO);
			
			//createInstructorWithCourses(appDAO);
			
			findInstructorWithCourses(appDAO);
		};

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId=1;
		System.out.println("Finding instructorDetail id:"+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor:"+tempInstructor);
		System.out.println("the associated instructorDetail only:"+tempInstructor.getCourses());

		System.out.println("Done");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		//create the Instructor
		Instructor tempInstructor=new Instructor("Susan","Public","susan@luv2code.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.luv.com/youtube","Video game");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course tempCourse1=new Course("Air-Guitar-The Ultimate Guide");
		Course tempCourse2=new Course("The Pinball Masterclass");

		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		//
		//NOTE:this will ALSO save the courses
		//because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor:"+tempInstructor);
		System.out.println("The courses:"+tempInstructor.getCourses());

		appDAO.save(tempInstructor);

		System.out.println("Done");



	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId=3;
		System.out.println("Deleting instructorDetail id:"+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		//get the instructor detail object
		int theId=2;
		System.out.println("Finding instructorDetail id:"+theId);
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);

		//print the instructor Detail
		System.out.println("tempInstructorDetail:"+tempInstructorDetail);

		//print the associate instructor
		System.out.println("the associated instructor only:"+tempInstructorDetail.getInstructor());
		System.out.println("Done");



	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting instructor id:"+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");

	}

	public void findInstructor(AppDAO appDAO){

		int theId=1;
		System.out.println("Finding instructor id:"+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor:"+tempInstructor);
		System.out.println("the associated instructorDetail only:"+tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
/*
		//create the Instructor
		Instructor tempInstructor=new Instructor("Chad","Darby","darby@luv2code.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 code");
*/

		//create the Instructor
		Instructor tempInstructor=new Instructor("Madu","Patal","madhu@luv2code.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.luv2code.com/youtube","Dancing");



		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//
		//NOTE:this will ALSO saave details object
		//because of CascadeType.ALL
		//
		System.out.println("saving instructor"+tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");

	}

}
