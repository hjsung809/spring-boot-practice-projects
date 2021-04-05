package com.hojun.chap3.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hojun.chap3.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	public BoardServiceImpl() {
		System.out.println("==> BoardServiceImpl 생성");
	}

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "Hello " + name + "!!";
	}

	@Override
	public BoardVO getBoard() {
		// TODO Auto-generated method stub
		BoardVO board= new BoardVO();
		board.setSeq(1);
		board.setCreateDate(new Date());
		board.setTitle("테스트 제목");
		return board;
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(int i = 1 ; i <= 10; i++) {
			BoardVO board= new BoardVO();
			board.setSeq(i);
			board.setCreateDate(new Date());
			board.setTitle("테스트 제목 " + i);
			boardList.add(board);
		}
		return boardList;
	}

}
