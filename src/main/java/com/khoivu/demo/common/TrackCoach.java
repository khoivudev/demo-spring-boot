package com.khoivu.demo.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach {
  public TrackCoach() {
    System.out.println(">> TrackCoach: inside default constructor");
  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5k";
  }
}
