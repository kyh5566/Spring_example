package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01") 
@RestController // controller + responsebody
public class Lesson01Ex01RestController {
	
	// http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController를 사용해서 String을 리턴";
	}
	
	// http://localhost/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String,String> ex01_4() {
		Map<String,String> map = new HashMap<>();
		map.put("aaa", "ㅁㅁㅁ");
		map.put("bbb", "ㅠㅠㅠ");
		map.put("ccc", "ㅊㅊㅊ");
		return map;
	}
	
	// http://localhost/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); // 일반 자바 객체. new로 생성
		data.setId(10);
		data.setName("김용희");
		
		return data; // 일반 bean 객체도 JSON으로 변환된다.
	}
	
	// http://localhost/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(11);
		data.setName("바다");
		
		// 500 error , ok = 200ok 등...
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
