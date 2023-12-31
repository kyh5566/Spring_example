package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entipy.StudentEntity;
//@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
//	@PersistenceContext
//	private EntityManager em;
//	
//	public StudentEntity save(StudentEntity studentEntity) {
//		em.persist(studentEntity);
//		return studentEntity;
//	}
	// 기본 제공
	// JPA, Spring Data JPA
	// Optional<엔티티> findById().orElse();
	// void delete(엔티티) 
	//List<엔티티> findAll();
	
	// ex02/1 JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String email);
	public List<StudentEntity> findByNameStartingWith(String n);
	public List<StudentEntity> findByIdBetWeen(int startId, int endId);
	
	// ex02/2 JPQL(Entity 를 조회 하는것. DB에 접근하지않음.)
	//@Query(value="select st from StudentEntity st where st.dreamJob =:dreamJob") // JPQL(엔티티 조회)
	
	// nativeQuery = DB 에 접근 실제 쿼리문.
	@Query(value="select * from new_student where dreamJob =:dreamJob", nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
	 
}
