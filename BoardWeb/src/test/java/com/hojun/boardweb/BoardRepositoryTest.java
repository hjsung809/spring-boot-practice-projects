package com.hojun.boardweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hojun.boardweb.domain.Board;
import com.hojun.boardweb.domain.Member;
import com.hojun.boardweb.domain.Role;
import com.hojun.boardweb.persistence.BoardRepository;
import com.hojun.boardweb.persistence.MemberRepository;


@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	BoardRepository boardRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
//	@Test
//	public void testDataInsert() {
//		Member member1 = new Member();
//		member1.setId("member");
//		member1.setPassword(encoder.encode("member123"));
//		member1.setName("둘리");
//		member1.setRole(Role.ROLE_MEMBER);
//		member1.setEnabled(true);
//		memberRepo.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("admin");
//		member2.setPassword(encoder.encode("admin123"));
//		member2.setName("도우너");
//		member2.setRole(Role.ROLE_ADMIN);
//		member2.setEnabled(true);
//		memberRepo.save(member2);
//		
//		Member member = member1;
//		for(int i = 1; i <= 13; i++) {
//			Board board = new Board();
//			board.setMember(member);
//			board.setTitle(member.getName() + "가 등록한 게시글 " + i);
//			board.setContent(member.getName() + "가 등록한 게시글 내용 " + i);
//			boardRepo.save(board);
//		}
//		
//		member = member2;
//		for(int i = 1; i <= 3; i++) {
//			Board board = new Board();
//			board.setMember(member);
//			board.setTitle(member.getName() + "가 등록한 게시글 " + i);
//			board.setContent(member.getName() + "가 등록한 게시글 내용 " + i);
//			boardRepo.save(board);
//		}
//	}
//	
//	@Test
//	public void testGetBoard() {
//		Board board = boardRepo.findById(1L).get();
//
//		System.out.println("작성자 : " + board.getMember().getName());
//		System.out.println(board);
//
//	}
	
//	@Test
//	public void testGetBoardList() {
//		Member member = memberRepo.findById("member").get();
//		
//		System.out.println(member.getName() + "가 등록한 게시글 리스트 >>>>");
//		for(Board board : member.getBoardList()) {
//			System.out.println("--->" + board);
//		}
//	}
	
	@Test
	public void testGetBoardList() {
//		Member member = memberRepo.findById("member").get();
		Board board = boardRepo.findById(1L).get();
		Member member = board.getMember();
		
		System.out.println(member.getName() + "가 등록한 게시글 리스트 >>>>");
		for(Board board2 : member.getBoardList()) {
			System.out.println("--->" + board);
		}
	}
}
