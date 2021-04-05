package com.hojun.chap3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hojun.chap3.BoardVO;
import com.hojun.chap3.service.BoardService;
import com.hojun.chap3.service.BoardServiceImpl;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	public BoardController() {
		System.out.println("==> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World")String name) {
		return "Hello " + name + "!!";
	}
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		return boardService.getBoard();
	}
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		return boardService.getBoardList();
	}

}
