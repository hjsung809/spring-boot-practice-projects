package com.hojun.boardweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hojun.boardweb.domain.Board;
import com.hojun.boardweb.domain.QBoard;
import com.hojun.boardweb.domain.Search;
import com.hojun.boardweb.persistence.BoardRepository;
import com.querydsl.core.BooleanBuilder;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardRepository boardRepo;
	
	
	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		boardRepo.save(board);
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}

	@Override
	public void deleteBoard(Board board) {
		// TODO Auto-generated method stub
		boardRepo.deleteById(board.getSeq());
		
	}

	@Override
	public Board getBoard(Board board) {
		// TODO Auto-generated method stub
		return boardRepo.findById(board.getSeq()).get();
	}

	@Override
	public Page<Board> getBoardList(Search search) {
		// TODO Auto-generated method stub
		System.out.println(search);
		
		BooleanBuilder builder = new BooleanBuilder();
		QBoard qboard = QBoard.board;
		
		if(search.getSearchCondition().equals("TITLE")) {
			builder.and(qboard.title.like("%" + search.getSearchKeyword() + "%"));
		} else if (search.getSearchCondition().equals("CONTENT")) {
			builder.and(qboard.content.like("%" + search.getSearchKeyword() + "%"));
		}
		
		Pageable pagealbe = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		return boardRepo.findAll(builder, pagealbe);
	}

}
