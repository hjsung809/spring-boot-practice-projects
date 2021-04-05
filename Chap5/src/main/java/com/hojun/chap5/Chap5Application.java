package com.hojun.chap5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chap5Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Chap5Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
//		SpringApplication.run(Chap5Application.class, args);
	}

}
