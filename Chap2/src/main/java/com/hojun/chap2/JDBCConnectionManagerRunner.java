package com.hojun.chap2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.hojun.hojun_spring_boot_starter.JDBCConnectionManager;

@Service
public class JDBCConnectionManagerRunner implements ApplicationRunner{
	@Autowired
	private JDBCConnectionManager connectionManager;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("커넥션 매니저 : " + connectionManager);
	}
}
