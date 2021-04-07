package com.hojun.boardweb.service;

import org.springframework.data.domain.Page;

import com.hojun.boardweb.domain.Board;
import com.hojun.boardweb.domain.Search;

public interface BoardService {
	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(Board board);
	Board getBoard(Board board);
	Page<Board> getBoardList(Search search);
}
