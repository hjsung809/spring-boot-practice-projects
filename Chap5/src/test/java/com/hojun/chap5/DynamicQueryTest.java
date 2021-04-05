package com.hojun.chap5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.hojun.chap5.domain.Board;
import com.hojun.chap5.domain.QBoard;
import com.hojun.chap5.persistence.DynamicBoardRepository;
import com.querydsl.core.BooleanBuilder;

@SpringBootTest
class DynamicQueryTest {
	@Autowired
	private DynamicBoardRepository boardRepo;
	
	@BeforeEach
	public void setup() {
		for(int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle(i + " 번째 게시글");
			board.setContent("Is it working?" + (i + 1));
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
	}
	
	@Test
	void testDynamicQuery() {
		String searchCondition = "CONTENT";
		String searchKeyword = "10";
		
		BooleanBuilder builder = new BooleanBuilder();
		QBoard qboard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if(searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0, 5);
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}

}
