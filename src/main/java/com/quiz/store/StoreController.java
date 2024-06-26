package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@Controller
public class StoreController {

	@Autowired
	private StoreBO storeBO;

	// 가게 목록 리스트
	// http://localhost:8080/storeList
	@GetMapping("/storeList")
	public String storeList(@ModelAttribute Store store, Model model) {

		// db select
		List<Store> storeList = storeBO.getStoreList();

		// model에 담기
		model.addAttribute("storeList", storeList);
		return "store/storeList";
	}

	// 리뷰 페이지
	// http://localhost:8080/storeReview
	@GetMapping("/storeReview")
	public String review() {

		return "store/storeReview";
	}
}
