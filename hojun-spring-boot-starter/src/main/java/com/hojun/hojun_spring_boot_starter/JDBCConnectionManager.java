package com.hojun.hojun_spring_boot_starter;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Setter;

@Setter
public class JDBCConnectionManager {
	private String driverClass;
	private String url;
	private String username;
	private String password;
	
	public Connection getConnection() {
		try {
			Class.forName(driverClass);
			return DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "JDBCConnectionManager [dirverClass=" + driverClass + ", url=" + url + " , username=" + username
				+ ", password=" + password;
	}
}
