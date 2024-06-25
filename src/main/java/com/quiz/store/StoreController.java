package com.quiz.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

	// http://localhost:8080/storeList
	@GetMapping("/storeList")
	public String storeList() {
		return "store/storeList";
	}
}
