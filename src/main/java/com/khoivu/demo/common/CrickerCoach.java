package com.khoivu.demo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component 
public class CrickerCoach implements Coach {

  public CrickerCoach() {
    System.out.println(">> CrickerCoach: inside default constructor");
  }
  
  // define our init method
  @PostConstruct
  public void doMyStartupStuff() {
    System.out.println(">> CrickerCoach: inside of doMyStartupStuff" + getClass().getSimpleName());
  }

  @PreDestroy 
  public void doMyCleanupStuff() {
    System.out.println(">> CrickerCoach: inside of doMyCleanupStuff" + getClass().getSimpleName());
  }

  @Override
  public String getDailyWorkout() {
    return "Practice fast bowling for 15 minutes";
  }

}
