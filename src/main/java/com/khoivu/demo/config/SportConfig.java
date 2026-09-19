package com.khoivu.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.khoivu.demo.common.Coach;
import com.khoivu.demo.common.SwimCoach;

@Configuration 
public class SportConfig {
  @Bean("quatic")
  public Coach swimCoach() {
    return new SwimCoach();
  }
}
