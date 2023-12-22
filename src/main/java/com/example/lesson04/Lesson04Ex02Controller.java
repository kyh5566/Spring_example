package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	@Autowired
	private StudentBO studentBO;
	
	
	// 학생 추가 화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 방금가입 된 학생 화면 & insert
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student, Model model // 태그의 name 속성 파라미터와 이름이 같은 필드에 맵핑
			) {
		
		// DB insert
		studentBO.addStudent(student);
		
		// DB select (방금 가입된)
		int id = student.getId();
		
		// selectStudentById
		Student latestStudent = studentBO.getStudentById(id);
		
		// select 한것을 model 에 담는다
		model.addAttribute("student", latestStudent);
		
		// view (테이블)
		return "lesson04/afterAddStudent";
	}
}
