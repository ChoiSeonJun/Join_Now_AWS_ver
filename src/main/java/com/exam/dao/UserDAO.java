package com.exam.dao;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.UserInfoDTO;
import com.exam.securitymodel.User;



@Repository
public class UserDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	//id 중복체크
	public User idCheck(String username) {
		User user = session.selectOne("UserMapper.idCheck", username);
		return user;
	}
	
	// 유저 정보 select
	public UserInfoDTO selectAll(String username) {
		return session.selectOne("UserMapper.selectAll", username);
	}
	
	// 유저 정보 select by id
	public UserInfoDTO selectAllById(int id) {
		return session.selectOne("UserMapper.selectAllById", id);		
	}
	
	public int updateNickname(UserInfoDTO dto) {
		return session.update("UserMapper.updateNickname", dto);
	}

}
