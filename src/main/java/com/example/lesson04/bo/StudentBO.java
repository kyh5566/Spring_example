package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mappers.StudentMapper;

@Service
public class StudentBO {
	@Autowired
	private StudentMapper studentMapper;
	
	//input: 4개 파라미터    output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
}