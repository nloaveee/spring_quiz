package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@Controller
@RequestMapping("/lesson06")
public class Lesson06Controller {

	@Autowired
	private BookmarkBO bookmarkBO;

	// 즐겨 찾기 추가 화면
	// http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}

	// AJAX가 요청하는 요청
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String addBookmark(@ModelAttribute Bookmark bookmark) {

		bookmarkBO.addBookmark(bookmark);

		return "성공";
	}

	// 결과 화면 (즐겨 찾기 목록)
	// http://localhost:8080/lesson06/list-bookmark-view
	@GetMapping("/list-bookmark-view")
	public String listBookmarkView(@ModelAttribute Bookmark bookmark, Model model) {

		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();

		model.addAttribute("bookmarkList", bookmarkList);

		return "lesson06/listBookmark";
	}

}
