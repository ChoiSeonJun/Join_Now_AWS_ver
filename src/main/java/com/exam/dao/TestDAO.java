package com.exam.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.TestDTO;

@Repository
public class TestDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<TestDTO> testSelect(){
		return session.selectList("TestMapper.testSelect");
	}
}
