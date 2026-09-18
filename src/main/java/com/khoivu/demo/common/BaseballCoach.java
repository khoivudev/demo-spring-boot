package com.khoivu.demo.common;

import org.springframework.stereotype.Component;

@Component 
public class BaseballCoach implements Coach {
  public BaseballCoach() {
    System.out.println(">> BaseballCoach: inside default constructor");
  }
  
  @Override
  public String getDailyWorkout() {
    return "Spend 30 minutes on batting practice";
  }

}
