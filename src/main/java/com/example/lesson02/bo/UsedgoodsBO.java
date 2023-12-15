package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean 으로 등록 controller 아님 주의.
public class UsedgoodsBO {
	
	@Autowired // Dependency Injection (DI): 의존성 주입
	private UsedGoodsMapper usedGoodsMapper; // Spring Bean 을 가져오는 어노테이션
	
	// input : X (Controller 에게 받아옴)
	// output :(Repository에게 받은것을) List<UsedGoods> 형태로 (Controller 에게 전달)
	public List<UsedGoods> getUsedGoodsList () {
		return usedGoodsMapper.selectUsedGoodsList();
	}
}
