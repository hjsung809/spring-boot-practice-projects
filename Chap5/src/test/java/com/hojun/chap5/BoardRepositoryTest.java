package com.hojun.chap5;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.hojun.chap5.domain.Board;
import com.hojun.chap5.persistence.BoardRepository;

@SpringBootTest
//@Transactional
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepository;
	
	@BeforeEach
	public void setup() {
		for(int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle(i + " 번째 게시글");
//			board.setWriter("Tester " + i);
			board.setContent("Is it working?");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepository.save(board);
		}
	}
	
	
//	@Test
//	public void testFindByTitle() {
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//		Page<Board> pageInfo = boardRepository.findByTitleContaining("17", paging);
//		
//		
//		System.out.println("PAGE SIZE : " + pageInfo.getSize());
//		System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
//		System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
//		System.out.println("NEXT : " + pageInfo.nextPageable());
//		
//		List<Board> boardList = pageInfo.getContent();
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--------->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest1() {
//		List<Board> boardList = boardRepository.queryAnnotationTest1("10");
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--------->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest2() {
//		List<Object[]> boardList = boardRepository.queryAnnotationTest2("10");
//		System.out.println("검색 결과");
//		for(Object[] row : boardList) {
//			System.out.println("--------->" + Arrays.toString(row));
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest3() {
//		List<Object[]> boardList = boardRepository.queryAnnotationTest3("10");
//		System.out.println("검색 결과");
//		for(Object[] row : boardList) {
//			System.out.println("--------->" + Arrays.toString(row));
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest4() {
//		Pageable paging = PageRequest.of(0, 3, Sort.Direction.ASC, "seq");
//		
//		List<Board> boardList = boardRepository.queryAnnotationTest4(paging);
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--------->" + board);
//		}
//	}
	
}
