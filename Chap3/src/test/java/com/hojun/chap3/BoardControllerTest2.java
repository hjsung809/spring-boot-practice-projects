package com.hojun.chap3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hojun.chap3.service.BoardService;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BoardControllerTest2 {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private BoardService boardService;
	
	@Test
	public void testHello() throws Exception {
		mockMvc.perform(get("/hello").param("name", "둘리"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello 둘리!!"));
		
	}
	
	@Test
	public void testGetBoard() throws Exception {
		BoardVO tmp = new BoardVO();
		tmp.setTitle("테스트 제목");
		when(boardService.getBoard()).thenReturn(tmp);
		
		ResultActions ra =  mockMvc.perform(get("/getBoard"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andDo(print());
		
		
		String result = new String(ra.andReturn().getResponse().getContentAsByteArray());
		BoardVO board = objectMapper.readValue(result, BoardVO.class);
		assertEquals("테스트 제목", board.getTitle());
	}
}
