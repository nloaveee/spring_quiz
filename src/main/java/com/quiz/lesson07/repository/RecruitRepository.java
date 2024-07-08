package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {

	// 1
	public List<RecruitEntity> findById(int id);

	// 2
	public List<RecruitEntity> findBycompanyId(int companyId);

	// 3
	public List<RecruitEntity> findByPositionAndType(String position, String type);

	// 4
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);

	// 5
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);

	// 6
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int startSalary, int endSalary);

	// 7 - Native query (DB에 직접 SQL)
	@Query(value = "select * from `recruit` where `deadline` > :deadline and `salary` >= :salary and `type` = :type order by `salary` desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAndsalaryAndType(@Param("deadline") String deadline,
			@Param("salary") int salary, @Param("type") String type);
}