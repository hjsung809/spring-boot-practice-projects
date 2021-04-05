package com.hojun.chap5;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hojun.chap5.domain.Board;
import com.hojun.chap5.domain.Member;
import com.hojun.chap5.persistence.BoardRepository;
import com.hojun.chap5.persistence.MemberRepository;

@SpringBootTest
public class RelationalMappingTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
//	@Test
//	public void testManyToOneSelect() {
//		Board board = boardRepo.findById(5L).get();
//		System.out.println(board);
//	}
	
//	@Test
//	public void testTwoWayMapping() {
//		Member member = memberRepo.findById("member 1").get();
//		
//		System.out.println("==============");
//		System.out.println(member);
//		for(Board board : member.getBoardList()) {
//			System.out.println(board);
//		}
//	}
	
	@Test
	public void testCascadeDelete() {
		memberRepo.deleteById("member 2");
	}
	
//	@BeforeEach
//	public void testManyToOneInsert() {
//		Member member1 = new Member();
//		member1.setId("member 1");
//		member1.setPassword("member 111");
//		member1.setName("둘리");
//		member1.setRole("User");
////		memberRepo.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("member 2");
//		member2.setPassword("member 222");
//		member2.setName("도우");
//		member2.setRole("Admin");
////		memberRepo.save(member2);
//		
//		for(int i = 0; i <= 3; i++) {
//			Board board = new Board();
//			board.setMember(member1);
//			board.setTitle(member1.getName() + "가" + (i+1) + "번째 등록한 게시글");	
//			board.setContent(member1.getName() + "가"  + (i+1) +  "등록한 게시글 내용");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
////			boardRepo.save(board);
//		}
//		memberRepo.save(member1);
//		
//		for(int i = 0; i <= 3; i++) {
//			Board board = new Board();
//			board.setMember(member2);
//			board.setTitle(member2.getName() + "가" + (i+1) + "번째 등록한 게시글");	
//			board.setContent(member2.getName() + "가"  + (i+1) +  "등록한 게시글 내용");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
////			boardRepo.save(board);
//		}
//		memberRepo.save(member2);
//	}
}
