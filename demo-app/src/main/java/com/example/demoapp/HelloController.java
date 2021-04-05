package com.example.demoapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	public HelloController() {
		System.out.println("==> HelloController 생성");
	}
	
	@RequestMapping("/hello")
	public String hello(String name) {
		return "Hello " + name + "!!";
	}

}
