package com.firstdevelop.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.firstdevelop.boot.entity.UserEntity;

@Mapper
public interface UserMapper {

	List<UserEntity> selectAll();
	
	UserEntity login(@Param("username") String username, @Param("password") String password);
}
