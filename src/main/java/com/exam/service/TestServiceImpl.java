package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.TestDAO;
import com.exam.dto.TestDTO;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestDAO dao;

	@Override
	public List<TestDTO> testSelect() {
		return dao.testSelect();
	}

}
