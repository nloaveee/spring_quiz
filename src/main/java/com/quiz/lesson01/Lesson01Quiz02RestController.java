package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController // @Controller + @ResponseBody
public class Lesson01Quiz02RestController {

	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {

		List<Map<String, Object>> listMap = new ArrayList<>();

		Map<String, Object> map1 = new HashMap<>();
		map1.put("rate", 15);
		map1.put("director", "봉준호");
		map1.put("time", 131);
		map1.put("title", "기생충");
		listMap.add(map1);

		Map<String, Object> map2 = new HashMap<>();
		map2.put("rate", 0);
		map2.put("director", "로베르토 베니니");
		map2.put("time", 116);
		map2.put("title", "인생은 아름다워");
		listMap.add(map2);

		Map<String, Object> map3 = new HashMap<>();
		map3.put("rate", 12);
		map3.put("director", "크리스토퍼 놀란");
		map3.put("time", 147);
		map3.put("title", "인셉션");
		listMap.add(map3);

		Map<String, Object> map4 = new HashMap<>();
		map4.put("rate", 19);
		map4.put("director", "윤종빈");
		map4.put("time", 133);
		map4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		listMap.add(map4);

		// stack에 계속 map을 만들지 말고 map을 재활용해서 heap영역에서 new를 해서 사용 가능
		map1 = new HashMap<>();
		map1.put("rate", 15);
		map1.put("director", "프란시스 로렌스");
		map1.put("time", 137);
		map1.put("title", "헝거게임");
		listMap.add(map1);

		return listMap;
	}

	// http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		// @ResponseBody + return String => httpMessageConverter => HTML
		// @RestController => return 객체(Map, List, 객체) => httpMessageConverter => JSON

		List<Board> listClass = new ArrayList<>();

		Board board1 = new Board();
		board1.setTitle("안녕하세요 가입인사 드립니다.");
		board1.setUser("marobiana");
		board1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		listClass.add(board1);

		Board board2 = new Board();
		board2.setTitle("헐 대박");
		board2.setUser("bada");
		board2.setContent("오늘 목요일이었어...금요일인줄");
		listClass.add(board2);

		Board board3 = new Board();
		board3.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		board3.setUser("dulumary");
		board3.setContent("...");
		listClass.add(board3);

		return listClass;
	}

	// http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_3() {
		Board board = new Board();
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");

		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
