package com.hojun.chap5.exception;

public class BoardNotFoundException extends BoardException{
	private static final long serialVersionUID = 1L;
	
	public BoardNotFoundException(String message) {
		super(message);
	}
}
