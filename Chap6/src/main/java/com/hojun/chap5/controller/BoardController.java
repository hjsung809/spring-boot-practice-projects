package com.hojun.chap5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hojun.chap5.domain.Board;
import com.hojun.chap5.domain.Member;
import com.hojun.chap5.service.BoardService;

@SessionAttributes("member")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("member")
	public Member setMember() {
		// 먼저동작함
		return new Member();
	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member, // 세션에 있는  member를 member에 바인딩함.
			Model model, Board board) {
		
		if(member.getId() == null) {
			return "redirect:login"; 
		}
		
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		if(member.getId() == null) {
			return "redirect:login"; 
		}
		
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login"; 
		}
		
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
		if(member.getId() == null) {
			return "redirect:login"; 
		}
		
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login"; 
		}
		
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login"; 
		}
		
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello 타임리프!");
	}
}
