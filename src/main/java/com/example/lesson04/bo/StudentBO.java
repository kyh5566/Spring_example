package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mappers.StudentMapper;
import com.example.lesson07.entipy.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA 로 insert
	public StudentEntity addStudent(
			String name, String phoneNumber,
			String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now())
				// @UpdateTimestamp 가 있으면 생략가능
				.build();
		
		return studentRepository.save(student);
	}
	
	
	
	// Mybatis 로 insert
	//input: 4개 파라미터    output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	//input : id    output: Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
