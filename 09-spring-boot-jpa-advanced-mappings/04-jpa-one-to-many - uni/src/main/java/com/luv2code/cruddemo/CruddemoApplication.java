package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner->{


			//creteCourseAndReviews(appDAO);

			//retrieveCourseAndReviews(appDAO);

			deleteCourseAndReviews(appDAO);
		};

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId=10;
		System.out.println("Deleting Course id:"+theId);
		appDAO.deleteCourseById(theId);

		System.out.println("Done");

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		//get the course and reviews
		int theID=10;
		Course tempCourse=appDAO.findCourseAndReviewsByCourseId(theID);

		//print the course
		System.out.println(tempCourse);

		//print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done");

	}

	private void creteCourseAndReviews(AppDAO appDAO) {

		//create a course
		Course tempCourse=new Course("Pacman -How to score one milllion points");


		//add some reviews
		tempCourse.addReview(new Review("Greate course...loved it!"));
		tempCourse.addReview(new Review("cool couse...loved it!"));
		tempCourse.addReview(new Review("What a dump couse , you are an idiot!"));

		//save the course...and leverage the cascade all
		System.out.println("saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done");

	}

	private void deleteCourse(AppDAO appDAO) {

		int theId=10;
		System.out.println("Deleting Course id:"+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Finding the course:" + theId);

		Course tempCourse=appDAO.findCourseById(theId);
		System.out.println("Updating course id:" + theId);

		tempCourse.setTitle("Enjoy the simple things.");

		appDAO.update(tempCourse);

		System.out.println("Done");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id:" + theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println("Updating instructor id:" + theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);
		System.out.println("Done");


	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructorDetail id:" + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor:" + tempInstructor);
		System.out.println("the associated courses:" + tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId=1;
		System.out.println("Finding instructorDetail id:"+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor:"+tempInstructor);

		//find courses for instructor
		System.out.println("Finding courses for instructor id:"+theId);
		List<Course> courses=appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses:"+tempInstructor.getCourses());

		System.out.println("Done");


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
