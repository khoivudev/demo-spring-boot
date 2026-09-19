package com.khoivu.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import com.khoivu.demo.common.Coach;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
public class DemoController {
  private Coach coach;

  private Coach anotherCoach;

  @Autowired 
  public DemoController(@Qualifier("trackCoach") Coach coach, @Qualifier("trackCoach") Coach anotherCoach) {
    System.out.println(">> DemoController: inside constructor");
    this.coach = coach;
    this.anotherCoach = anotherCoach;
  }


  @GetMapping("/dailyworkout")
  public String getDailyWorkout() {
      return coach.getDailyWorkout();
  }
  
  @GetMapping("/check")
  public String check() {
      return "Compare the two coach instances: " + (coach == anotherCoach);
  }
  
}
