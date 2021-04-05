package com.hojun.chap3.service;

import java.util.List;

import com.hojun.chap3.BoardVO;

public interface BoardService {
	String hello(String name);
	BoardVO getBoard();
	List<BoardVO> getBoardList();
}
