package com.khoivu.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.khoivu.demo.dao.AppDAO;
import com.khoivu.demo.entity.Course;
import com.khoivu.demo.entity.Instructor;
import com.khoivu.demo.entity.InstructorDetail;
import com.khoivu.demo.entity.Review;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			// findInstructorWithCoursesJoinFetch(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// deleteCourse(appDAO);
			// createCourseAndReviews(appDAO);
			// retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Char", "Darby", "darby@example.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http:example.com/youtube", "Dog");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving Instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor detail id: " + theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 5;
		System.out.println("Deleting instructord detail id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Susan", "Public", "sussan@example.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http:example.susan.com/youtube", "Video Games");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("Pinball - The Ultimate Guide");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving Instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated course: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("The associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated course: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Updating instructor id:" + theId);
		tempInstructor.setLastName("TESTER");
		appDAO.update(tempInstructor);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding course id: " + theId);
		Course course = appDAO.findCourseById(theId);
		System.out.println("Updating course id:" + theId);
		course.setTitle("Electric Guitar - The Ultimate Guide");
		appDAO.update(course);
		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting course id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tmpCourse = new Course("Pacman");
		tmpCourse.addReview(new Review("Great"));
		tmpCourse.addReview(new Review("Cool"));
		tmpCourse.addReview(new Review("Love it"));
		appDAO.save(tmpCourse);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 2;
		Course tmpCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tmpCourse);
		System.out.println(tmpCourse.getReviews());
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting course id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
	}
}
