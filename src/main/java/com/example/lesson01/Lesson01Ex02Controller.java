package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// JSP 로 보내는 컨트롤러
@Controller // ResponseBody가 있으면 안된다.
public class Lesson01Ex02Controller {
	 // http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // Request Path 주소.
	public String ex02() {
		//return 되는 String 은 jsp 의 경로이다.
		//(@ResponseBody 없을때)
		return "lesson01/ex02"; // Response view 의 경로
		// prefix 로 인하여 /WEB-INF/jsp/ , .jsp 는 생략가능
		
	}
}
