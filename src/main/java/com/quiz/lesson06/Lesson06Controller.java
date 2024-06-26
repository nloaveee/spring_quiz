package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson06")
public class Lesson06Controller {

	// 즐겨 찾기 추가 화면
	// http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}

	// AJAX가 요청하는 요청
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String addBookmark() {

		return "성공";
	}

	// 결과 화면 (즐겨 찾기 목록)
	// http://localhost:8080/lesson06/list-bookmark-view
	@GetMapping("/list-bookmark-view")
	public String listBookmarkView() {
		return "lesson06/listBookmark";
	}

}
