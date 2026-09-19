package com.khoivu.demospringboot.dao;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

import java.util.List;

import com.khoivu.demospringboot.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
  private EntityManager entityManager;

  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void saveStudent(Student student) {
    entityManager.persist(student);
  }

  @Override 
  public Student findById(int id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll() {
    String query = "SELECT s FROM Student s";
    return entityManager.createQuery(query, Student.class).getResultList();
  }

  @Override
  public List<Student> findByLastName(String lastName) {
    String query = "SELECT s FROM Student s WHERE s.lastName = :lastName";
    return entityManager.createQuery(query, Student.class)
                        .setParameter("lastName", lastName)
                        .getResultList();
  }

  @Override
  @Transactional
  public void updateStudent(Student student) {
    entityManager.merge(student);
  }

  @Override
  @Transactional
  public void deleteStudent(int id) {
    Student student = findById(id);
    if (student != null) {
      entityManager.remove(student);
    }
  }

  @Override
  @Transactional
  public void deleteAllStudents() {
    String query = "DELETE FROM Student";
    entityManager.createQuery(query).executeUpdate();
  }
}