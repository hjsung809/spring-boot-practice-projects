package com.example.demoapp;

import java.util.Date;

import lombok.Getter;

@Getter
public class TestVO {
	private int seq;
	private String title;
	private Date createDate = new Date();
}
