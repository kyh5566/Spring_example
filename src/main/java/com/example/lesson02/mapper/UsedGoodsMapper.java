package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;
@Mapper 
public interface UsedGoodsMapper {
	
	//input: X(BO로부터 받아오는것)   
	//output:(Service 에게 주는것) List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
	
}
