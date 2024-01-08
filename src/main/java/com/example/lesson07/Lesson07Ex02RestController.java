package com.example.lesson07;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entipy.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {
	@Autowired
	// BO 생략
	private StudentRepository studentRespository;
	
	// 조회 방법들
	@GetMapping("/1")
	public List<StudentEntity> getStudentList() {
		// 1. 전체 조회(Jpa 기본 제공 메소드)
		// return studentRespository.findAll();
		
		// 2. id 기준 내림차순 전체 조회
		// return studentRespository.findAllByOrderByIdDesc();
		
		// 3. id 기준 내림차순 limit 조회
		// return studentRespository.findTop3ByOrderByIdDesc();
		
		// 4. 이름 '김바다' 조회
		// return studentRespository.findByName("김바다");
		
		// 5. in문으로 일치하는 값 모두 조회(이름)
		// return studentRespository.findByNameIn(Arrays.asList("김바다","유재석","조세호"));
		
		// 6. 여러 컬럼값과 일치하는 데이터 조회(이름, 장래희망)
		// return studentRespository.findByNameAndDreamJob("김바다", "개발자");
		
		// 7. email 컬럼에 naver 키워드가 포함된 데이터 조회(like문 - %naver%)
		// return studentRespository.findByEmailContains("naver");
		
		// 8. 이름이 김으로 시작하는 데이터 조회(like - 김%)
		// return studentRespository.findByNameStartingWith("김");
		
		// 9. id 가 1~5 인 데이터 조회(between)
		return studentRespository.findByIdBetWeen(1, 5);
	}
}
