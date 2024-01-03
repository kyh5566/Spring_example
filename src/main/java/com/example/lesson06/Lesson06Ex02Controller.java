package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;
@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	@Autowired
	private UserBO userBO;
	
	@GetMapping("/add_name")
	public String ex02() {
		return "lesson06/addName";
	}
	
	@ResponseBody
	@GetMapping("/is_duplication")
	    // 데이터를 내려줄 때는 반드시 ResponseBody!!!    // 데이터를 내려줄 때는 반드시 ResponseBody!!!
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", userBO.existNewUserByName(name));
		return result;
	}
}
}
