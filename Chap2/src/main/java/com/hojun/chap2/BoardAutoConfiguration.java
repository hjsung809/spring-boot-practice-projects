package com.hojun.chap2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hojun.hojun_spring_boot_starter.JDBCConnectionManager;

//@Configuration
public class BoardAutoConfiguration {
	
//	@Bean
	public JDBCConnectionManager getJdbcConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("org.h2.Driver");
		manager.setUrl("jdbc:h2:tcp://localhost/~/test");
		manager.setUsername("hojun2");
		manager.setPassword("hojun2 password");
		return manager;
	}
}
