package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.exam.dao.UserDAO;
import com.exam.dto.UserInfoDTO;
import com.exam.securitymodel.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO dao;

	@Override
	public User idCheck(String username) {
		User user = dao.idCheck(username);
		return user;
	}

	@Override
	public UserInfoDTO selectAll(String username) {
		return dao.selectAll(username);
	}

	@Override
	public UserInfoDTO selectAllById(int id) {
		return dao.selectAllById(id);
	}

	@Override
	public int updateNickname(UserInfoDTO dto) {
		return dao.updateNickname(dto);
	}
}
