package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;

	// 입력 화면
	// http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}

	// 방금 추가된 데이터 화면
	// DB insert => select => 결과 화면
	// http://localhost:8080/lesson04/quiz02/add-realtor
	@PostMapping("/add-realtor")
	public String addRealtor(@ModelAttribute Realtor realtor, Model model) {

		// DB INSERT
		realtorBO.addRealtor(realtor);

		// id를 가지고 DB SELECT
		int id = realtor.getId();
		Realtor latestRealtor = realtorBO.getRealtorById(id);

		// MODEL에 담기
		model.addAttribute("realtor", latestRealtor);

		// 화면 이동
		return "lesson04/afterAddRealtor";
	}

}