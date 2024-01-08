package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

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
	
	
	//jpa 로 update
	// input : int     output:   
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// select 후 update - save
		StudentEntity student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			student = student.toBuilder()
			.dreamJob(dreamJob)
			.build(); // 반드시 다시 저장한다
			
			// update
			student = studentRepository.save(student);
		}
		return student; // student or null
	}
	
	public void deleteStudentById(int id) {
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
	
	//input : id    output: Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
