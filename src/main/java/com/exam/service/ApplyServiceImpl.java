package com.exam.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ApplyDAO;
import com.exam.dto.ApplyDTO;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	ApplyDAO dao;
	
	@Override
	public int applyAdd(ApplyDTO dto) {
		return dao.applyAdd(dto);
	}

	@Override
	public List<ApplyDTO> selectListApplyByIdAndPostNo(HashMap<String, Integer> map) {
		return dao.selectListApplyByIdAndPostNo(map);
	}

	@Override
	public ApplyDTO selectOne(int applyNo) {
		return dao.selectOne(applyNo);
	}

}
