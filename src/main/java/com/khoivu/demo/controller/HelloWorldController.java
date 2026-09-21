package com.khoivu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
 
  @GetMapping("/showForm")
  public String showForm() {
    return "helloworld-form";
  }


  @RequestMapping("/processForm")
  public String processForm() {
      return "helloworld";
  }
  
  @PostMapping("/processFormVersionTwo")
  public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {
    theName = theName.toUpperCase();
    String result = "Yo!" + theName;
    model.addAttribute("message", result);

    return "helloworld";
  }
}
