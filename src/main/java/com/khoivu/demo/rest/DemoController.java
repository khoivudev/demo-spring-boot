package com.khoivu.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import com.khoivu.demo.common.Coach;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
public class DemoController {
  private Coach coach;


  @Autowired 
  public DemoController(@Qualifier("baseballCoach") Coach coach) {
    this.coach = coach;
  }

  @GetMapping("/dailyworkout")
  public String getDailyWorkout() {
      return coach.getDailyWorkout();
  }
  
}
