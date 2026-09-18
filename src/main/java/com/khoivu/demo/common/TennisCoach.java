package com.khoivu.demo.common;

import org.springframework.stereotype.Component;

@Component 
public class TennisCoach implements Coach {
  public TennisCoach() {
    System.out.println(">> TennisCoach: inside default constructor");
  }
  
  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley";
  }
}
