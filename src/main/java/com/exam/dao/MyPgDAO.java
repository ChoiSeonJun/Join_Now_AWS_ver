package com.exam.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.MyPgDTO;


@Repository
public class MyPgDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<MyPgDTO> mypageList() {		
		return session.selectList("MyPageMapper.mypageList");
	}
	
	public MyPgDTO mypageInfo(int id) {		
		return session.selectOne("MyPageMapper.mypageInfo",id);
	}
	
	public int mypageInsert(MyPgDTO dto) {
		return session.insert("MyPageMapper.mypageInsert", dto);
	}
	
	
	public int mypageUpdate(MyPgDTO dto) {
		return session.update("MyPageMapper.mypageUpdate", dto);
	}
	
	
}
