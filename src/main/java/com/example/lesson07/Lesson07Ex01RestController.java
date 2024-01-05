package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entipy.StudentEntity;

@RequestMapping("/lesson07")
@RestController
public class Lesson07Ex01RestController {
	@Autowired
	private StudentBO studentBO;
	
	// c: create
	@GetMapping("/ex01/1")
	public StudentEntity create() {
		String name = "김바다";
		String phoneNumber = "010-1234-1234";
		String email = "asd@naver.com";
		String dreamJob = "개발자";
		
		//방금 insert 된 pk값도 얻어낼수있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
}
