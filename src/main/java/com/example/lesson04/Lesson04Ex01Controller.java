package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller // jsp 를 내리는경우 @ReponseBody 사용안함
public class Lesson04Ex01Controller {	
	
	@Autowired
	private UserBO userBO;
	
	//회원가입 화면
	//http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // jsp view 의 경로
	}
	
	// 회원가입 insert => 입력성공 화면
	@PostMapping("/add-user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// db insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser";
	}
	
	//http://localhost/lesson04/ex01/latest-user-view
	// 최근 가입된 유저
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) { 
		//Model: view 화면에 data 를 넘겨주는 객체.
		// db select 최신가입자
		User user = userBO.getLatestUser();
		
		// Model 에 user 를 담는다. => jsp 에서 꺼내쓴다.
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입 된 유저정보");
		
		return "lesson04/latestUser"; // 결과하면 jsp
	}
	
}
