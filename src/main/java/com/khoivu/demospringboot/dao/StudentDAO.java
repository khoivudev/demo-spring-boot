package com.khoivu.demospringboot.dao;

import com.khoivu.demospringboot.entity.Student;
import java.util.List;

public interface StudentDAO {
  void saveStudent(Student student);
  Student findById(int id);
  List<Student> findAll();
  List<Student> findByLastName(String lastName);
  void updateStudent(Student student);
  void deleteStudent(int id);
  void deleteAllStudents();
}
