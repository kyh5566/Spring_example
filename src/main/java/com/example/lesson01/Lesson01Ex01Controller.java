package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 제일 먼저 읽혀진다.
@Controller // Spring bean(객체)으로 등록
public class Lesson01Ex01Controller {
	
	// String 을 브라우저에 출력
	//url http://localhost/lesson01/ex01/1
	
	@ResponseBody //리턴되는 값을 responsebody에 넣어 보낸다 => html
	@RequestMapping("/1")
	public String ex01_1() {
		return "<h2>예제1번</h2>문자열을 ResponseBody로 보내는 예제";
	}
	
	// map return -> jackson -> json 형식으로 출력
	// http://localhost/lesson01/ex01/2
		
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 10);
		map.put("포도", 20);
		map.put("코코넛", 30);
		map.put("바나나", 40);
		return map;	
	}
}
