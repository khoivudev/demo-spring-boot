package com.khoivu.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.khoivu.demo.dao.AccountDAO;
import com.khoivu.demo.dao.MemberDAO;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MemberDAO thMemberDAO) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, thMemberDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MemberDAO thMemberDAO) {
		theAccountDAO.addAccount();
		thMemberDAO.addAccount();
	}
}
