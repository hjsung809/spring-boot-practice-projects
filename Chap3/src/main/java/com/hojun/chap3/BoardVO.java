package com.hojun.chap3;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int seq;
	private String title;
	private Date createDate;
}
