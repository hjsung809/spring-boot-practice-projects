package com.hojun.chap3;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception {
		String result = restTemplate.getForObject("/hello?name=둘리", String.class);
		assertEquals("Hello 둘리!!", result);
	}
	
	@Test
	public void testGetBoard() throws Exception {
		BoardVO result = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertEquals("테스트 제목", result.getTitle());
	}
	
	@Test
	public void testGetBoardList() throws Exception {
		List<BoardVO> result = restTemplate.getForObject("/getBoardList", List.class);
		assertEquals(10, result.size());
	}
}
