package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;

	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {

		return "lesson04/addSeller";
	}

	// 물건 추가 => DB 저장 => 결과 화면
	@GetMapping("/add-seller")
	public String addSeller(@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {

		// DB 저장 - insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);

		// 결과 화면
		return "lesson04/afterAddSeller";
	}

	// 최근 가입자 뿌리기
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model) {

		// DB SELECT (최신 가입자 1명)
		Seller seller = sellerBO.getLatestSeller();

		model.addAttribute("result", seller);

		return "lesson04/sellerInfo";

	}

}
