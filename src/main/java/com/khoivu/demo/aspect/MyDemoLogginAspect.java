package com.khoivu.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {
  @Before("execution(public void com.khoivu.demo.dao.AccountDAO.addAccount())")
  public void beforeAddAccountAdvice() {
    System.out.println("\n ========>>>> Excecuting @Before advice on addAccount()");
  }
}
