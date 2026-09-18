package com.khoivu.demo.common;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;

@Component
@Lazy
public class TrackCoach implements Coach {
  public TrackCoach() {
    System.out.println(">> TrackCoach: inside default constructor");
  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5k";
  }
}
