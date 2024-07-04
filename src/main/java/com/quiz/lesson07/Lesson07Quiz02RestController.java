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
	// http://localhost:8080/lesson07/quiz02/2?companyId=1
	// Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회
	@GetMapping("/2")
	public List<RecruitEntity> select2(@RequestParam("companyId") int companyId) {

		return recruitRepository.findBycompanyId(companyId);
	}

	// 3. 복합 조건 조회 (/lesson07/quiz02/3)
	// 웹 back-end 개발자이고 정규직인 공고 조회
	@GetMapping("/3")
	public List<RecruitEntity> select3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}

	// 4. 복합 조건 조회(/lesson07/quiz02/4)
	// 정규직 이거나 연봉이 9000이상인 공고 조회
	@GetMapping("/4")
	public List<RecruitEntity> select4() {
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}

	// 5. 정렬 제한 조건 (/lesson07/quiz02/5)
	// 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
	@GetMapping("/5")
	public List<RecruitEntity> select5() {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}

	// 6. 범위 조회 (/lesson07/quiz02/6)
	// 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고 조회
	@GetMapping("/6")
	public List<RecruitEntity> select6() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}

}
