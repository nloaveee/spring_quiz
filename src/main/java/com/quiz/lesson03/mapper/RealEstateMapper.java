package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	public RealEstate selectRealEstateById(int id);

	public List<RealEstate> selectRealEstateByRentPrice(Integer rentPrice);

	public List<RealEstate> selectRealEstateByAreaAndPrice(int area, int price);
}
