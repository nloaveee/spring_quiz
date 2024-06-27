package com.quiz.store.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.store.domain.NewReview;
import com.quiz.store.mapper.NewReviewMapper;

@Service
public class NewReviewBO {

	@Autowired
	private NewReviewMapper newReviewMapper;

	public List<NewReview> getReview(int storeId) {
		return newReviewMapper.selectReview(storeId);
	}
}
