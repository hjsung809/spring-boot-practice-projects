package com.hojun.boardweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hojun.boardweb.domain.Board;
import com.hojun.boardweb.domain.Member;
import com.hojun.boardweb.domain.Search;
import com.hojun.boardweb.security.SecurityUser;
import com.hojun.boardweb.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
//	@ModelAttribute("member")
//	public Member setMember() {
//		// 먼저동작함
//		return new Member();
//	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Search search) {
		if(search.getSearchCondition() == null) {
			search.setSearchCondition("TITLE");
		}
		
		if(search.getSearchKeyword() == null) {
			search.setSearchKeyword("");
		}
		
		Page<Board> boardList = boardService.getBoardList(search);
		model.addAttribute("boardList", boardList);
		return "board/getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		return "board/insertBoard";
	}
	
	// @AuthenticationPrincipal 을 사용하여 인증 정보를 가진 객체 얻기.
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @AuthenticationPrincipal SecurityUser principal) {
//		if(member.getId() == null) {
//			return "redirect:login"; 
//		}
		board.setMember(principal.getMember());
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
//	
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) { // @ModelAttribute("member") Member member,
//		if(member.getId() == null) {
//			return "redirect:login"; 
//		}
		model.addAttribute("board", boardService.getBoard(board));
		return "board/getBoard";
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Board board) {	
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
}
