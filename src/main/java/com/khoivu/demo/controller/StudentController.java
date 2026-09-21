package com.khoivu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.khoivu.demo.model.Student;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class StudentController {

  @Value("${countries}")
  private List<String> countries;

  @Value("${languages}")
  private List<String> languages;

   @Value("${systems}")
  private List<String> systems;

  @GetMapping("/showStudentForm")
  public String showForm(Model model) {
    Student theStudent = new Student();
    model.addAttribute("student", theStudent);
    model.addAttribute("countries", countries);
    model.addAttribute("languages", languages);
    model.addAttribute("systems", systems);
    return "student-form";
  }


  @PostMapping("/processStudentForm")
  public String processForm(@ModelAttribute("student") Student theStudent) {
    System.out.printf("The Student:" + theStudent.getFirstName() + " " + theStudent.getLastName());
    return "student-confirmation";
  }
  
}
