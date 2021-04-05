package com.hojun.chap3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;



@Service
public class LoggingRunner implements ApplicationRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
;	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
//		logger.trace("TRACE 로그 메시");
//		logger.debug("DEBUG 로그 메시");
//		logger.info("INFO 로그 메시");
//		logger.warn("WARN 로그 메시");
//		logger.error("ERROR 로그 메시");
	}

}
