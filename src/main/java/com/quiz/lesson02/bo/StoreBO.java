package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service // spring bean
public class StoreBO {

	// input: x
	// output: List<Store>

	@Autowired
	private StoreMapper storeMapper;

	public List<Store> getStoreList() {
		return storeMapper.selectStoreList(); // 컨트롤러한테 전달
	}

}
