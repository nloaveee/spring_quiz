package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	public RealEstate selectRealEstateById(int id);

	public List<RealEstate> selectRealEstateByRentPrice(Integer rentPrice);

	// mapper 인터페이스가 xml로 파라미터를 전송 시 1개만 보낼 수 있다.
	// @Param 어노테이션을 사용하면 파라미터를 하나의 map으로 구성해준다. (mybatis에서 제공해주는 어노테이션)
	// param안에 들어가는 key의 이름이 중요하다. xml의 이름과 동일하게 해야된다.
	public List<RealEstate> selectRealEstateByAreaAndPrice(@Param("area") int area, @Param("price") int price);

	// quiz02_1
	public int insertRealEstate(RealEstate realEstate);

	// quiz02_2
	public int insertRealEstateAsField(@Param("realtorId") int realtorId, @Param("address") String address,
			@Param("area") int area, @Param("type") String type, @Param("price") int price,
			@Param("rentPrice") Integer rentPrice);

	// quiz03_1
	public int updateRealEstateById(@Param("id") int id, @Param("type") String type, @Param("price") int price);

	// quiz04
	public void deleteEstateById(int id);
}
