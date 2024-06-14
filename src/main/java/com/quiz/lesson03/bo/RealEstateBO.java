package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper estateMapper;

	// input: id
	// output: estate
	public RealEstate getEstateById(int id) {
		return estateMapper.selectRealEstateById(id);
	}

	// input: rentPrice
	// output: List<RealEstate>
	public List<RealEstate> getEstateByRentPrice(Integer rentPrice) {
		return estateMapper.selectRealEstateByRentPrice(rentPrice);
	}

	// input: area, price
	// output: estate
//	public List<RealEstate> getERealstateByAreaAndPrice(int area, int price) {
//
//	}
}
