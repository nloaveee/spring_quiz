package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@Controller
@RequestMapping("/lesson06")
public class Lesson06Controller {

	@Autowired
	private BookmarkBO bookmarkBO;

	// 즐겨 찾기 목록 화면 (결과)
	// http://localhost:8080/lesson06/list-bookmark-view
	@GetMapping("/list-bookmark-view")
	public String listBookmarkView(@ModelAttribute Bookmark bookmark, Model model) {

		// db select => List<Bookmark>
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();

		// model에 담기
		model.addAttribute("bookmarkList", bookmarkList);

		return "lesson06/listBookmark";
	}

	// 즐겨 찾기 추가 화면
	// http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}

	// AJAX가 하는 요청
	// 즐겨찾기 추가 로직
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(@ModelAttribute Bookmark bookmark) {

		// db insert
		bookmarkBO.addBookmark(bookmark);

		// 성공 JSON
		// {"code":200, "result": "성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");

		return result;
	}

	// AJAX 요청 - url 중복 확인
	@ResponseBody
	@PostMapping("is-duplication-url")
	public Map<String, Object> isDuplicationUrl(@RequestParam("url") String url) {

		// db select
		boolean isDuplication = bookmarkBO.isDuplicationUrl(url);

		// 응답 json
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);

		return result;
	}

	// http://localhost:8080/lesson06/delete-bookmark?id=3
	// AJAX 요청 - id로 삭제
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(@RequestParam("id") int id) {

		// db delete
		int rowCount = bookmarkBO.deleteBookmarkById(id);

		// 응답값 json
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
		}
		return result;
	}

}
