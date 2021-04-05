package com.hojun.hojun_spring_boot_starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix="board.jdbc")
@Data
public class JDBCConnectionManagerProperties {
	private String driverClass;
	private String url;
	private String username;
	private String password;
}
