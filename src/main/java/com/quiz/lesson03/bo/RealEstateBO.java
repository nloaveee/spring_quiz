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
	// output: List<RealEstate>
	public List<RealEstate> getERealEstateByAreaAndPrice(int area, int price) {
		return estateMapper.selectRealEstateByAreaAndPrice(area, price);
	}

	// quiz02_1
	// input: RealEstate
	// output: 성공한 행의 개수(int)
	public int addRealEstate(RealEstate realEstate) {
		return estateMapper.insertRealEstate(realEstate);
	}

	// quiz02_2
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price,
			Integer rentPrice) {
		return estateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}

	// quiz03_1
	// input: id, type, price
	// output: int
	public int updateRealEstateById(int id, String type, int price) {
		return estateMapper.updateRealEstateById(id, type, price);
	}

	// quiz04
	// input: id
	// output: x
	public void deleteEstateById(int id) {
		estateMapper.deleteEstateById(id);
	}
}
