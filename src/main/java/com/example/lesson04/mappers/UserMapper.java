package com.example.lesson04.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.User;

@Mapper
public interface UserMapper { // int or void
	public int insertUser(
			@Param("name") String name,
			@Param("yyyymmdd")String yyyymmdd,
			@Param("email")String email,
			@Param("introduce")String introduce);
	
	public User selectLatestUser();
	
	public boolean existNewUserByName(@Param("name")String name);
}
