package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RestController // spring bean
public class Lesson02Quiz01RestController {

	@Autowired
	private StoreBO storeBO;

	// http://localhost:8080/lesson02/quiz01
	@GetMapping("/lesson02/quiz01")
	public List<Store> quiz01() {
		return storeBO.getStoreList(); // JSON
	}
}
