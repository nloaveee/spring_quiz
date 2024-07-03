package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;

	// input: 파라미터 4개
	// output: CompanyEntity
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {

		CompanyEntity company = CompanyEntity.builder().name(name).business(business).scale(scale).headcount(headcount)
				.build();

		return companyRepository.save(company);
	}

	// update
	// input: id, scale, headcount
	// output: CompanyEntity or null
	public CompanyEntity updateCompanyById(int id, String scale, int headcount) {

		// 기존 데이터 조회 => id로 select 해오기
		CompanyEntity company = companyRepository.findById(id).orElse(null);

		if (company != null) {

			// toBuilder는 기존 필드는 유지하고 update 하고 싶은 필드만 작성
			// update한 결과를 다시 저장 (save)
			company = companyRepository.save(company.toBuilder().scale(scale).headcount(headcount).build());
		}

		return company;

	}

	// delete
	// input: id
	// output: x
	public void deleteCompanyById(int id) {
		// 기존 데이터 조회
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);

		// CompanyEntity 이름 => c
		companyOptional.ifPresent(c -> companyRepository.delete(c));

	}

}
