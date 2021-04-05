package com.hojun.chap3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(properties = 
{ 		
		"author.name=Gurum",
		"author.name=45",
		"author.nation=Korea"
}
)
class PropertiesTest {
	@Autowired
	Environment enviroment;

	@Test
	void test() {
		System.out.println(enviroment.getProperty("author.name"));
		System.out.println(enviroment.getProperty("author.age"));
		System.out.println(enviroment.getProperty("author.nation"));
	}

}
