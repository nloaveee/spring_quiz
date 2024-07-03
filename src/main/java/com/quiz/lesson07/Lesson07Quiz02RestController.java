package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;

	// 1. id 로 조회(/lesson07/quiz02/1)
	// http://localhost:8080/lesson07/quiz02/1
	// id = 8인 공고를 조회
	@GetMapping("/1")
	public List<RecruitEntity> select1() {
		return recruitRepository.findById(8);
	}

	// 2. parameter 조건 조회 (/lesson07/quiz02/2)
	// Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회
	@GetMapping("/2")
	public List<RecruitEntity> select2(@RequestParam("companyId") int companyId) {

		return recruitRepository.findBycompanyId(1);
	}

}
