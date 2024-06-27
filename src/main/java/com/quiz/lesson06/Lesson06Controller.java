package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// 삭제는 a 태그를 사용하지 말고 button으로 사용
	// btn을 누르면 script에 id를 가져와서 삭제 하고 나서 페이지 새로고침
	// btn 이름은 class로 해야된다. (id x)
	// 삭제 api를 만든다음 번호를 파라미터로 받아와서 삭제 되는지 확인하고 ajax랑 연동

}
