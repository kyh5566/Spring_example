package com.example.lesson03.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	public Review selectReview(int id);
	
	//input : review    output: 성공한 행의 개수(int)
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	// input: id, review  output: int 성공한 행 개수
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
}
	