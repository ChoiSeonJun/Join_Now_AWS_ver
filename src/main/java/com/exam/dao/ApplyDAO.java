package com.exam.dao;


import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exam.dto.ApplyDTO;

@Repository
public class ApplyDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	
	public int applyAdd(ApplyDTO dto){
		return session.insert("ApplyMapper.applyAdd", dto);
	}
	
	public List<ApplyDTO> selectListApplyByIdAndPostNo(HashMap<String, Integer> map) {
		return session.selectList("ApplyMapper.selectListApplyByIdAndPostNo",map);
	}
	
	public ApplyDTO selectOne(int applyNo) {
		return session.selectOne("ApplyMapper.selectOne", applyNo);
	}
}
