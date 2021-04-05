package com.hojun.chap3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hojun.chap3.*")
public class Chap3Application {

	public static void main(String[] args) {
		SpringApplication.run(Chap3Application.class, args);
	}

}
