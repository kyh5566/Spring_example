package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedgoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController
public class Lesson02Ex01RestController {
	
	@Autowired // DI : Spring Bean을 받아온다. new() 가 불가능하기때문.
	private UsedgoodsBO usedGoodsBO;
	
	//http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01 () {
		return usedGoodsBO.getUsedGoodsList(); // response => json
	}
}
