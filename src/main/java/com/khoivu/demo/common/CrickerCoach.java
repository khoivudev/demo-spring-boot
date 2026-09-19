package com.khoivu.demo.common;

import org.springframework.stereotype.Component;

@Component 
public class CrickerCoach implements Coach {

  public CrickerCoach() {
    System.out.println(">> CrickerCoach: inside default constructor");
  }
  
  @Override
  public String getDailyWorkout() {
    return "Practice fast bowling for 15 minutes";
  }

}
