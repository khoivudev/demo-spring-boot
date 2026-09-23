package com.khoivu.demo.dao;

import com.khoivu.demo.entity.Instructor;

public interface AppDAO {
  void save(Instructor theInstructor);

  Instructor findInstructorById(int theId);

  void deleteInstructorById(int theId);
}
