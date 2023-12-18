package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mappers.ReviewMapper;

@Service
public class ReviewBO {
	@Autowired
	private ReviewMapper reviewMapper;
	//input : x      //output : Review 한개의 데이터만 컨트롤러에게 준다.
	public Review getReview (int id) {
		return reviewMapper.selectReview(id);
	}
}
