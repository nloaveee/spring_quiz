package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {

	// 1
	public List<RecruitEntity> findById(int id);

	public List<RecruitEntity> findBycompanyId(int id);

}
