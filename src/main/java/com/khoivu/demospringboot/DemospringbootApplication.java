package com.khoivu.demospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

import com.khoivu.demospringboot.dao.StudentDAO;
import com.khoivu.demospringboot.entity.Student;

@SpringBootApplication
public class DemospringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemospringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//readAllStudents(studentDAO);
			//readStudentsByLastName(studentDAO, "Doe");
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("John", "Doe", "john.doe@example.com");
		System.out.println("Saving the student...");
		studentDAO.saveStudent(tempStudent);
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Johny", "Doe", "johny.doe@example.com");
		Student tempStudent2 = new Student("Jane", "Smith", "jane.smith@example.com");
		Student tempStudent3 = new Student("Bob", "Johnson", "bob.johnson@example.com");
		System.out.println("Saving the students...");
		studentDAO.saveStudent(tempStudent1);
		studentDAO.saveStudent(tempStudent2);
		studentDAO.saveStudent(tempStudent3);
		System.out.println("Saved students. Generated ids: " + tempStudent1.getId() + ", " + tempStudent2.getId() + ", " + tempStudent3.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		if (student != null) {
			System.out.println("Student found: " + student.getFirstName() + " " + student.getLastName() + ", Email: " + student.getEmail());
		} else {
			System.out.println("Student with ID 1 not found.");
		}
	}

	private void readAllStudents(StudentDAO studentDAO) {
		System.out.println("Retrieving all students...");
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println("Student: " + student.toString());
		}
	}

	private void readStudentsByLastName(StudentDAO studentDAO, String lastName) {
		System.out.println("Retrieving students with last name: " + lastName);
		List<Student> students = studentDAO.findByLastName(lastName);
		for (Student student : students) {
			System.out.println("Student: " + student.toString());
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		if (student != null) {
			System.out.println("Updating student with ID 1...");
			student.setFirstName("UpdatedFirstName");
			studentDAO.updateStudent(student);
			System.out.println("Student updated: " + student.toString());
		} else {
			System.out.println("Student with ID 1 not found.");
		}
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting student with ID 3" );
		studentDAO.deleteStudent(3);
		System.out.println("Student deleted.");
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		studentDAO.deleteAllStudents();
		System.out.println("All students deleted.");
	}
}